(function ($app) {
    $app.module('gtPartyApp').controller('userLeaderEditCtrl', function ($scope, $http, $modal, $ocLazyLoad, $alert, $loading, $state, $partySelect, $stateParams, $bsRouterState, AuthUser) {
        $stateParams = $bsRouterState.$params($scope);

        $scope.maxDate = moment(new Date()).format("YYYY-MM-DD");
        $scope.op = $stateParams.op;
        $scope.isAdd = false;
        //定义数据集合
        $scope.dataModel = {
            id: $stateParams.id == undefined ? "" : $stateParams.id,
            partycode: $stateParams.dzzdm
        };
        $scope.userList = [];

        $scope.leaderTypeList = [];

        $scope.reqFileModel = {
            selectdata: {FileRefID: '', pageindex: 1, pagesize: 10, ptotal: 0},//查询参数：FileRefID为文件关联ID
            filetype: 3,//文件类型
            items: [],//列表数据地址
            readonly: $scope.op == 0,//是否只能查看
            title: '附件列表',
            addFileButton: '上传'
        };
        $scope.selectLeaderlist = {
            url: '../../api/partyUser/getPartyUserList',
            title: '人员选择',
            isMulti: false,
            selectData: {xm: '姓名', szdzb: '所在组织架构'},
            columns: {XM: '姓名', XBMC: '性别', JG: '籍贯', DZZMC: '所在组织架构'},
            selectLabelKey: 'XM',
            selectValuekey: 'RYJBXXBS',
            selectedValueData: '',
            selectedLabeData: '',
            selectedJData: [],
            selectParams: {
                /*ryzt: '2,3',*/
                dzzdm: AuthUser.getUser().dwId,
                sfsldry: 1
            }
        };
        $scope.$watch('selectLeaderlist.selectedValueData', function (newVal) {
            if (newVal != '' && newVal != undefined) {
                $http({
                    method: 'get',
                    url: '../../api/partyUser/getPartyUserList',
                    params: {
                        userIds: newVal,
                        pageindex: 1,
                        pagesize: 1000
                    }
                }).then(function (result) {
                    $loading.hide();
                    $scope.dataModel.username = result.data.item.list[0].XM;
                    $scope.dataModel.usercode = result.data.item.list[0].RYBM;
                }, function (resp) {
                    $loading.hide();
                    $scope.showMsg('错误', '服务器错误,' + resp.data.message);
                });
            }
        });

        //选择党支部begin
        $scope.partyTreeConfig = {
            scope: $scope,
            selectedKey: '',
            selectedText: '',
            selectedData: [],
            isMulti: false,
            isshowxz: 0
        };
        $partySelect.initServer($scope.partyTreeConfig);
        $scope.selectParty = function () {
            $partySelect.showModal();
        };
        $scope.$watch("partyTreeConfig.selectedKey", function (newVal, oldVal) {
            if (newVal) {
                $scope.dataModel.partycode = $scope.partyTreeConfig.selectedKey;
                $scope.dataModel.partyname = $scope.partyTreeConfig.selectedText;

                $scope.selectLeaderlist.selectParams.dzzdm = $scope.partyTreeConfig.selectedKey;

                $scope.dataModel.username = "";
                $scope.dataModel.usercode = "";
            }
        }, true);
        //end

        //选择成员
        $scope.selectUserlist = {
            url: '../../api/partyUser/getPartyUserList',
            title: '人员选择',
            isMulti: true,
            selectData: {xm: '姓名', szdzb: '所在组织架构'},
            columns: {XM: '姓名', XBMC: '性别', JG: '籍贯', DZZMC: '所在组织架构'},
            selectLabelKey: 'XM',
            selectValuekey: 'RYJBXXBS',
            selectedValueData: '',
            selectedLabeData: '',
            selectedJData: [],
            selectParams: {
                dzzdm: AuthUser.getUser().dwId,
                removeUsers: '',
                ryzt: '2,3' //预备党员，正式党员
            }
        };
        $scope.$watch('selectUserlist.selectedValueData', function (newVal) {
            if (newVal != '' && newVal != undefined) {
                $http({
                    method: 'get',
                    url: '../../api/partyUser/getPartyUserList',
                    params: {
                        userIds: newVal,
                        pageindex: 1,
                        pagesize: 10000
                    }
                }).then(function (result) {
                    $loading.hide();
                    result.data.item.list.forEach(item => {
                        $scope.userList.push({
                            usercode: item.RYBM,
                            username: item.XM,
                            DZZMC: item.DZZMC,
                            isLeader: item.SFSLDRY
                        });
                    });
                    $scope.selectUserlist.selectedValueData = "";
                    $scope.selectUserlist.selectedLabeData = "";
                }, function (resp) {
                    $loading.hide();
                    $scope.showMsg('错误', '服务器错误');
                });
            }
        });
        $scope.$watch('userList', function (newVal) {
            $scope.setRemoveUser();
        }, true);
        $scope.setRemoveUser = function () {
            $scope.selectUserlist.selectParams.removeUsers = "";
            angular.forEach($scope.userList, function (val, index) {
                $scope.selectUserlist.selectParams.removeUsers += val.RYJBXXBS + ','
            });
        };

        $scope.loadData = function () {
            $http.get("../../api/publicity/getUserLeaderById", {
                params: {
                    'id': $scope.dataModel.id,
                    'dzzdm': $scope.dataModel.partycode
                }
            }).then(function (result) {
                $scope.dataModel = result.data.item;
                $scope.isAdd = ($scope.dataModel.usercode == null || $scope.dataModel.usercode == '');
                $scope.reqFileModel.selectdata.FileRefID = result.data.item.userleaderid;
                $scope.getUserList();
            }, function () {
                $scope.showMsg('错误', '服务器错误');
            });
        };
        //保存
        $scope.submitData = function (isflag) {
            if (!isflag) {
                $scope.showMsg('提示', '请填写相关信息');
                return false;
            }

            if ($scope.dataModel.leadertype != 3) {
                $scope.userList = [];
            }

            if ($scope.userList.length == 0 && $scope.dataModel.leadertype == 3) {
                $scope.showMsg('提示', '请添加谈心谈话人员');
                return false;
            }

            if (isflag) {
                var leaderCount = $scope.userList.filter(it => it.isLeader).length;
                var msg = "确认提交？";
                if ($scope.isAdd && leaderCount > 0 && $scope.dataModel.leadertype == 3) {
                    msg = "谈心谈话人员中有" + leaderCount + "人是落实人，确认提交？";
                }
                if (confirm(msg)) {
                    $loading.show();
                    $http({
                        method: "post",
                        url: "../../api/publicity/saveUserLeader",
                        data: {
                            dataModel: $scope.dataModel,
                            userList: JSON.stringify($scope.userList)
                        }
                    }).then(function (result) {
                        $loading.hide();
                        $scope.showMsg('成功', result.data.msg);
                        //重新刷新列表
                        $scope.pagechange();

                        $scope.$emit("tabReloadData", {name: 'userLeaderListCtrl', data: 1});

                    }, function (resp) {
                        $loading.hide();
                        $scope.showMsg('错误', '服务器错误');
                    })
                }
            }
        };

        $scope.getLeaderTypeList = function () {
            $http({
                method: 'get',
                url: '../../api/dictionary/getDictionaryListByDicTypeKey',
                params: {
                    dicTypeKey: 'leaderType'
                }
            }).then(function (result) {
                $scope.leaderTypeList = result.data;
            }, function (resp) {

            });
        };

        $scope.getUserList = function () {
            $http({
                method: 'get',
                url: '../../api/publicity/getUserleaderDetailList',
                params: {
                    leaderId: $scope.dataModel.userleaderid
                }
            }).then(function (result) {
                $scope.userList = result.data.item;
            }, function (resp) {

            });
        };

        $scope.deleteUser = function (index) {
            $scope.userList.splice(index, 1);
        };
        $scope.addUser = function () {
            $scope.userList.push({
                usercode: '',
                username: '',
                DZZMC: '',
                isLeader: 0
            });
        };

        $scope.invalidFee = function (index, form1, name) {
            name = name + "_" + index;
            eval('var i=form1.' + name + '.$invalid');
            return i;
        };

        //加载数据
        $scope.loadData();
        $scope.getLeaderTypeList();

        $scope.pagechange = function () {
            var inTab = $bsRouterState.$getRouteType() == 'tab';
            if (inTab) {
                $bsRouterState.$closeTab($scope);
            } else {
                window.history.back();
            }
        };

        $scope.showMsg = function (title, content) {
            $alert({
                title: title + '：',
                content: content,
                placement: 'top',
                type: 'info',
                show: true,
                duration: 3
            });

        };

    });
})(angular);