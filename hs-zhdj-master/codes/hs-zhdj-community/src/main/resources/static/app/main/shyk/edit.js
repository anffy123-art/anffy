(function ($app) {
    $app.module('gtPartyApp').controller('shykEditCtrl', function ($scope, $http, $modal, $ocLazyLoad, $alert, $loading, $state, $partySelect, $stateParams, AuthUser,
                                                                   $filter, $bsRouterState) {

        $stateParams = $bsRouterState.$params($scope);

        $scope.maxDate = moment(new Date()).format("YYYY-MM-DD 23:59:59");
        $scope.pageId = "shykEdit";
        $scope.loginUserId = AuthUser.getUser().Id;
        $scope.democracyReviewType = 7;//民主评议党员
        $scope.selectUserUrl = '../../api/partyUser/getPartyUserList';//获取成员接口地址

        //定义数据集合
        $scope.dataModel = {
            meetingid: $stateParams.id == undefined ? "" : $stateParams.id,
            shyktype: $stateParams.shykType,
            //partycode: $stateParams.shykType == 3 ? "" : $stateParams.dzzdm, //shykType=3 党小组会
            partycode: $stateParams.dzzdm,
            partyname: ''
        };
        $scope.shyklxList = [];//三会一课类型字典
        $scope.topicList = [];//议题
        $scope.userList = [];//会议成员
        $scope.historyAddressList = [];
        $scope.democracyReviewList = [];
        $scope.meetingTypeList = [];
        $scope.boolList = [];
        $scope.democracyReviewResultTypeList = [];
        $scope.imgConfig1 = {
            filerefid: $scope.dataModel.meetingid,
            filetypeid: 1,
            readonly: false,
            ismulti: true,
            height: 150,
            width: 180,
            imgList: []
        };
        $scope.imgConfig2 = {
            filerefid: $scope.dataModel.meetingid,
            filetypeid: 2,
            readonly: false,
            ismulti: true,
            height: 150,
            width: 180,
            imgList: []
        };

        //选择会议成员
        $scope.selectUserlist = {
            url: $scope.selectUserUrl,
            title: '人员选择',
            isMulti: true,
            selectData: {xm: '姓名', szdzb: '所在组织架构'},
            columns: {XM: '姓名', XBMC: '性别', JG: '籍贯', DZZMC: '所在组织架构'},
            selectLabelKey: 'XM',
            selectValuekey: 'RYBM',
            selectedValueData: '',
            selectedLabeData: '',
            selectedJData: [],
            selectParams: {
                dzzdm: $scope.dataModel.partycode,
                removeUsers: '',
                ryzt: '2,3' //预备党员，正式党员
            },
            onSelect: function (value, selecteds) {
                if (selecteds && selecteds.length > 0) {
                    selecteds.forEach(val => {
                        if ($scope.userList.filter(it => it.RYBM == val.RYBM).length == 0) {
                            $scope.userList.push({
                                RYBM: val.RYBM,
                                XM: val.XM,
                                SZDZBDM: val.SZDZBDM,
                                DZZMC: val.DZZMC,
                                SIGNINSTATUS: 2,
                                USERREMARK: null
                            });
                        }
                    });

                    $scope.selectUserlist.selectedJData = [];
                    $scope.selectUserlist.selectedLabeData = '';
                    $scope.selectUserlist.selectedValueData = '';
                }
            }
        };

        //选择民主评议成员
        $scope.selectDemocracyReviewUserlist = {
            url: $scope.selectUserUrl,
            title: '人员选择',
            isMulti: true,
            selectData: {xm: '姓名', szdzb: '所在组织架构'},
            columns: {XM: '姓名', XBMC: '性别', JG: '籍贯', DZZMC: '所在组织架构'},
            selectLabelKey: 'XM',
            selectValuekey: 'RYBM',
            selectedValueData: '',
            selectedLabeData: '',
            selectedJData: [],
            selectParams: {
                dzzdm: $scope.dataModel.partycode,
                removeUsers: '',
                ryzt: '2,3' //预备党员，正式党员
            },
            onSelect: function (value, selecteds) {
                if (selecteds && selecteds.length > 0) {
                    selecteds.forEach(val => {
                        if ($scope.democracyReviewList.filter(it => it.usercode == val.RYBM).length == 0) {
                            $scope.democracyReviewList.push({
                                usercode: val.RYBM,
                                userName: val.XM,
                                partyCode: val.SZDZBDM,
                                partyName: val.DZZMC
                            });
                        }
                    });

                    $scope.selectDemocracyReviewUserlist.selectedJData = [];
                    $scope.selectDemocracyReviewUserlist.selectedLabeData = '';
                    $scope.selectDemocracyReviewUserlist.selectedValueData = '';
                }
            }
        };

        //选择党支部
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
                $scope.selectUserlist.selectParams.dzzdm = $scope.dataModel.partycode;

                $scope.defaultUser();
            }
        }, true);

        //保存,isflag：表单验证结果
        $scope.submitData = function (isflag) {
            if (!isflag) {
                $scope.showMsg('提示', '请填写相关信息');
                return false;
            }

            const ulist = $.map($scope.userList, function (item) {
                return {
                    rybm: item.RYBM,
                    xm: item.XM,
                    szdzbdm: item.SZDZBDM,
                    dzzmc: item.DZZMC,
                    signinstatus: item.SIGNINSTATUS,
                    userremark: item.USERREMARK
                }
            });

            const typeList = $.map($scope.getShykType(), function (item) {
                return {
                    shyktype: item.dickey
                }
            });

            //数据验证
            if (ulist.length <= 0) {
                $scope.showMsg('错误', '请选择参加会议成员');
                return false;
            }

            //保存
            if (confirm("确定提交？")) {
                $loading.show();
                $http({
                    method: "post",
                    url: "../../api/shyk/saveMeeting",
                    data: {
                        dataModel: $scope.dataModel,
                        typeList: JSON.stringify(typeList),
                        userList: JSON.stringify(ulist),
                        democracyReviewList: $scope.isEditDemocracyReview() ? JSON.stringify($scope.democracyReviewList) : []
                    }
                }).then(function (result) {
                    $loading.hide();
                    if (result.data.success) {
                        $scope.showMsg('成功', '提交成功');
                        //重新刷新列表
                        $scope.pagechange();

                        $scope.$emit("tabReloadData", {name: 'shykListCtrl', data: 1});
                    } else {
                        $scope.showMsg('失败', result.data.msg);
                    }
                }, function (resp) {
                    $loading.hide();
                    $scope.showMsg('错误', '服务器错误,' + resp.data.message);
                });
            }
        };

        $scope.getShykType = function () {
            return $scope.shyklxList.filter(e => e.selected);
        };

        $scope.isEditDemocracyReview = function () {
            return $scope.getShykType().filter(e => e.dickey === $scope.democracyReviewType).length > 0;
        };

        //人员操作
        $scope.deleteUser = function (index) {
            $scope.userList.splice(index, 1);
        };

        //默认加载参会成员
        $scope.defaultUser = function () {
            $scope.userList = [];
            $http({
                method: 'get',
                url: $scope.selectUserUrl,
                params: {
                    dzzdm: $scope.dataModel.partycode,
                    pageindex: 1,
                    pagesize: 10000,
                    //szdzbdm: $scope.dataModel.shyktype == 2 ? $scope.dataModel.partycode : '',
                    ryzt: '2,3' //预备党员，正式党员
                }
            }).then(function (result) {
                $scope.userList = result.data.item.list;
                $scope.userList.forEach(item => {
                    item.SIGNINSTATUS = 2;
                });
            }, function (resp) {
                $scope.showMsg('错误', '服务器错误');
            });
        };

        $scope.editNoSigninModal = {};
        $scope.resetRemark = function (item) {
            $scope.editNoSigninModal = {item: item, remark: ""};
            $scope.editNoSigninModal.item = item;
        };
        $scope.signin = function (item, state, userremark) {
            item.SIGNINSTATUS = state;
            item.USERREMARK = userremark;
            $('#editNoSignin').modal('hide');
        };

        $scope.deleteDemocracyReview = function (index) {
            $scope.democracyReviewList.splice(index, 1);
        };

        //获取数据
        $scope.loadData = function () {
            $http.get("../../api/shyk/getMeetingById", {
                params: {
                    'id': $scope.dataModel.meetingid,
                    'dzzdm': $scope.dataModel.partycode,
                    'shyktype': $scope.dataModel.shyktype
                }
            }).then(function (result) {
                if (!result.data.success) {
                    $scope.showMsg('错误', result.data.extdata.message);
                    return false;
                }

                $scope.dataModel = result.data.item;
                $scope.selectUserlist.selectParams.dzzdm = $scope.dataModel.partycode;
                $scope.imgConfig1.filerefid = $scope.dataModel.meetingid;
                $scope.imgConfig2.filerefid = $scope.dataModel.meetingid;

                $scope.getUserList();
                $scope.getMeetingDemocracyReviewList();
                $scope.getMeetingTypeList();
                $scope.getHistoryAddressList();
                $scope.boolList = [{dickey: true, dicvalue: '是'}, {dickey: false, dicvalue: '否'}];

            }, function () {
                $scope.showMsg('错误', '服务器错误');
            });
        };
        $scope.getUserList = function () {
            if ($scope.dataModel.partycode != "" && $scope.dataModel.partycode != null) {
                $http
                ({
                    method: 'get',
                    url: '../../api/shyk/getMeetingUserList',
                    params: {pageindex: 1, pagesize: 10000, meetingId: $scope.dataModel.meetingid}
                }).then(function (result) {
                    $scope.userList = result.data.item.list;

                    if ($scope.userList.length === 0) {
                        $scope.defaultUser();
                    }
                });
            }
        };
        $scope.getHistoryAddressList = function () {
            $http({
                method: 'get',
                url: '../../api/shyk/getHistoryAddressList',
                params: {
                    userId: $scope.loginUserId
                }
            }).then(function (result) {
                $scope.historyAddressList = result.data;

                if ($scope.historyAddressList.length > 0 && $scope.dataModel.meetingaddress == "" || $scope.dataModel.meetingaddress == null) {
                    $scope.dataModel.meetingaddress = $scope.historyAddressList[0].MEETINGADDRESS;
                }
            }, function (resp) {

            });
        };
        $scope.getMeetingDemocracyReviewList = function () {
            $http({
                method: 'get',
                url: '../../api/shyk/getMeetingDemocracyReviewList',
                params: {
                    meetingId: $scope.dataModel.meetingid
                }
            }).then(function (result) {
                $scope.democracyReviewList = result.data.item;
            }, function (resp) {
            });
        };
        $scope.getMeetingTypeList = function () {
            $http({
                method: 'get',
                url: '../../api/shyk/getMeetingTypeList',
                params: {
                    meetingId: $scope.dataModel.meetingid
                }
            }).then(function (result) {
                $scope.meetingTypeList = result.data.item;

                $scope.getShyklxList();
            }, function (resp) {
            });
        };
        $scope.getShyklxList = function () {
            $http({
                method: 'get',
                url: '../../api/dictionary/getDictionaryListByDicTypeKey',
                params: {
                    dicTypeKey: 'shykType'
                }
            }).then(function (result) {
                $scope.shyklxList = result.data;

                $scope.shyklxList.forEach(e => {
                    e.selected = $scope.meetingTypeList.filter(mt => mt.shyktype === e.dickey).length > 0;
                });
            }, function (resp) {
            });
        };
        $scope.getDemocracyReviewResultTypeList = function () {
            $http({
                method: 'get',
                url: '../../api/dictionary/getDictionaryListByDicTypeKey',
                params: {dicTypeKey: 'DemocracyReviewResultType'}
            }).then(function (result) {
                $scope.democracyReviewResultTypeList = result.data;
            });
        };

        $scope.pagechange = function () {
            var inTab = $bsRouterState.$getRouteType() == 'tab';
            if (inTab) {
                $bsRouterState.$closeTab($scope);
            } else {
                window.history.back();
            }
        };

        //列表数据必填
        $scope.invalidFee = function (index, form1, name) {
            try {
                name = name + "_" + index;
                eval('var i=form1.' + name + '.$invalid');
                return i;
            } catch (e) {
                return false;
            }
        };

        //初始化数据
        $scope.loadData();
        $scope.getDemocracyReviewResultTypeList();

    });
})(angular);