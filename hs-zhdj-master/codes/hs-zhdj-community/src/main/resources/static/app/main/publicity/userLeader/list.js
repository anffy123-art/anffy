(function ($app) {
    $app.module('gtPartyApp').controller('userLeaderListCtrl', function ($scope, $http, $modal, $ocLazyLoad, $alert, $loading, $state, $bsRouterState, AuthUser, $timeout, $excel) {
        $state.params = $bsRouterState.$params($scope);
        $scope.isShow = false;
        $scope.moreTxt = "更多";
        $scope.dataScope = parseInt(AuthUser.getUser().dataScope);//角色数据范围


        //定义数据集合
        $scope.loginUserId = AuthUser.getUser().Id;
        $scope.dataList = []; //列表数据
        $scope.leaderTypeList = [];

        $scope.selectparams = {
            onlyshow_dw: 1,
            isunfold: false,//组织结构树展开收缩
            'pageindex': 1,
            'pagesize': 10,
            isshowxz: 0,
            selectdzzdm: AuthUser.getUser().DataDzzdm.length <= 12 ? AuthUser.getUser().DataDzzdm : AuthUser.getUser().dwId,
            selectdzzmc: "",
            defaultselected: $state.params.dzzdm,
            parentcode: AuthUser.getUser().ParentDpCode,
            parentname: AuthUser.getUser().ParentDpName,
            szdzzdm: AuthUser.getUser().DPCode,
            szdzzmc: AuthUser.getUser().DPName,
            zzfbType: null,
            partyCode: '',//党组织代码
            userid: AuthUser.getUser().Id,
            userName: $state.params.xm,
            leaderType: $state.params.leaderType,
            beginTime: $state.params.beginTime == undefined ? null : $state.params.beginTime,
            endTime: $state.params.endTime == undefined ? null : $state.params.endTime,
            rybm: $state.params.rybm
        };
        $scope.resetparams = {
            onlyshow_dw: 1,
            isunfold: false,//组织结构树展开收缩
            'pageindex': 1,
            'pagesize': 10,
            isshowxz: 0,
            selectdzzdm: AuthUser.getUser().DataDzzdm.length <= 12 ? AuthUser.getUser().DataDzzdm : AuthUser.getUser().dwId,
            selectdzzmc: "",
            defaultselected: $state.params.dzzdm,
            parentcode: AuthUser.getUser().ParentDpCode,
            parentname: AuthUser.getUser().ParentDpName,
            szdzzdm: AuthUser.getUser().DPCode,
            szdzzmc: AuthUser.getUser().DPName,
            zzfbType: null,
            partyCode: '',//党组织代码
            userid: AuthUser.getUser().Id,
            userName: $state.params.xm,
            leaderType: $state.params.leaderType,
            beginTime: '',
            endTime: '',
            rybm: $state.params.rybm
        };
        $scope.pageInfo = {ptotal: 0};
        //监视页数变化
        $scope.$watch("selectparams.pageindex", function (newVal, oldVal) {
            if ($scope.pageInfo.ptotal > 0) {
                $scope.loadData();
            }
        });

        $scope.$watch("selectparams.selectdzzdm", function (newVal, oldVal) {
            if (newVal != "") {

                if ($scope.selectparams.defaultselected != "" && $scope.selectparams.defaultselected != null &&
                    $scope.selectparams.defaultselected != $scope.selectparams.selectdzzdm)
                    return;

                $scope.selectparams.partyCode = $scope.selectparams.selectdzzdm;
                if ($scope.selectparams.selectdzzdm != AuthUser.getUser().DPCode) {
                    $scope.selectparams.userid = "";
                } else {
                    $scope.selectparams.userid = AuthUser.getUser().Id;
                }
                $scope.loadData();
            }
        });

        $scope.$watch("selectparams.zzfbType", function (newVal, oldVal) {
            if (newVal != oldVal) {
                $scope.loadData();
            }
        });

        $scope.$on('tabChildReloadData', function (event, data) {
            if (data.name == 'userLeaderListCtrl') {
                $scope.loadData();
            }
        });


        //查询
        $scope.search = function () {
            $scope.loadData();
        };

        //加载列表数据
        $scope.loadData = function () {
            $scope.selectparams.rybm = "";
            $http
            ({
                method: 'get', url: '../../api/publicity/getUserLeaderList', params: $scope.selectparams
            }).then(function (result) {
                $scope.dataList = result.data.item.list;
                $scope.pageInfo.ptotal = result.data.item.total;
            });
        };

        //新增
        $scope.addData = function () {
            $bsRouterState.$closeTabName("home.userLeaderAdd");
            $timeout(function () {
                $bsRouterState.go('home.userLeaderAdd', {
                    id: "",
                    dzzdm: $scope.selectparams.partyCode.length < 12 ? AuthUser.getUser().dwId : $scope.selectparams.partyCode//$scope.selectparams.partyCode
                });
            }, 100);
        };
        //修改
        $scope.editData = function (id) {
            $bsRouterState.$closeTabName("home.userLeaderEdit");
            $timeout(function () {
                $bsRouterState.go('home.userLeaderEdit', {
                    id: id,
                    dzzdm: $scope.selectparams.partyCode
                });
            }, 100);
        };

        //查看
        $scope.showData = function (id) {
            $bsRouterState.$closeTabName("home.userLeaderShow");
            $timeout(function () {
                $bsRouterState.go('home.userLeaderShow', {id: id, op: 0});
            }, 100);
        };

        //删除
        $scope.deleteData = function (id) {
            if (confirm("是否确定删除？")) {
                $http({
                    url: "../../api/publicity/deleteUserLeaderById",
                    method: 'GET',
                    params: {id: id}
                }).then(function (result) {
                    $scope.showMsg("消息", result.data.msg);
                    if (result.data.success) {
                        $scope.loadData();
                    }
                });
            }
        };

        $scope.exportData = function () {
            if ($scope.selectparams.dzzdm != "" && $scope.selectparams.dzzdm != AuthUser.getUser().gddwdm) {
                var params = "?1=1";
                for (var p in $scope.selectparams) {
                    if ($scope.selectparams[p] !== '' && $scope.selectparams[p] !== null)
                        params += ("&" + p + "=" + encodeURI($scope.selectparams[p]));
                }
                window.open('../../api/publicity/exportUserLeader' + params);
            }
        };

        $scope.excelConfig = {
            filetype: 1,
            columns: {
                '姓名': 'userName',
                '所属支部': 'partyName',
                '类别': 'leadertype',
                '时间': 'leadertime',
                '地点': 'address',
                '内容': 'content'

            },
            errorcolumns: {
                'userName': '姓名',
                'partyName': '所属支部',
                'leadertype': '类别',
                'leadertime': '时间',
                'errorInfo': '错误信息'
            },
            readonly: false,
            templateUrl: '/doc/template/5+3领导导入模版.xlsx'
        };
        $scope.import = function () {
            $excel.addFile($scope.excelConfig).then(function (items) {
                $loading.show();
                $http({
                    method: "post",
                    url: "../../api/publicity/importUserLeader",
                    data: {
                        userList: JSON.stringify(items),
                        dzzdm: $scope.selectparams.partyCode
                    }
                }).then(function (result) {
                    $loading.hide();
                    if (result.data.success) {
                        $scope.showMsg("导入成功");
                        $scope.loadData();
                    } else {
                        if (result.data.item.length > 0) {
                            $scope.showMsg('错误', '导入失败，存在错误数据，请修改后重新导入！', 10);
                            $excel.showErrorInfo(result.data.item);
                        } else {
                            $scope.showMsg(result.data.msg);
                        }
                    }

                }, function (resp) {
                    $loading.hide();
                    $scope.showMsg('错误', '服务器错误');
                })
            });
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

        $scope.getLeaderTypeList();

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
        $scope.isShowClick = function () {
            $scope.isShow = !$scope.isShow;
            if ($scope.moreTxt == "更多") {
                $scope.moreTxt = "收起";
            } else if ($scope.moreTxt == "收起") {
                $scope.moreTxt = "更多";
            }
        };
        $scope.setisunfold = function () {
            $scope.selectparams.isunfold = !$scope.selectparams.isunfold;
            $scope.$emit('menudatas.toggle', !$scope.selectparams.isunfold);
        };
        $scope.reset = function () {
            // var $form = $scope.myform;
            // var $names = $form.$$controls;
            // angular.forEach($names, function (val) {
            //     val
            // });
            // $scope.myform.$setPristine();
            // $scope.myform.$setUntouched();
            //$scope.selectparams.selectdzzdm = $scope.resetparams.selectdzzdm;
            //$scope.selectparams.selectdzzmc = $scope.resetparams.selectdzzmc;
            //$scope.selectparams.defaultselected = $scope.resetparams.defaultselected;
            //$scope.selectparams.parentname = $scope.resetparams.parentname;
            //$scope.selectparams.szdzzdm = $scope.resetparams.szdzzdm;
            //$scope.selectparams.szdzzmc = $scope.resetparams.szdzzmc;
            $scope.selectparams.userName = $scope.resetparams.userName;
            //$scope.selectparams.dzzdm = $scope.resetparams.dzzdm;
            $scope.selectparams.leaderType = $scope.resetparams.leaderType;
            $scope.selectparams.beginTime = $scope.resetparams.beginTime;
            $scope.selectparams.endTime = $scope.resetparams.endTime;
            // $scope.selectparams.jldzzrq_end = $scope.resetparams.jldzzrq_end;
            // $scope.selectparams.isContainParent = $scope.resetparams.isContainParent;
            // $scope.selectparams.zzfbType = $scope.resetparams.zzfbType;
            //$scope.selectparams.selectdzzmc = $scope.selectparams.dzzmc = $scope.selectparams.zzlb = $scope.selectparams.jczzfl = '';
        }
    });
})(angular);