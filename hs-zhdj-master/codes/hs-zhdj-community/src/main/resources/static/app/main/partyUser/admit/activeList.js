(function ($app) {
    $app.module('gtPartyApp').controller('admitActiveCtrl', function ($scope, $http, $modal, $ocLazyLoad, $alert, $loading, $state, $bsRouterState, AuthUser, $timeout, $excel, $filter) {
        $state.params = $bsRouterState.$params($scope);
        $scope.loginUserId = AuthUser.getUser().Id;
        $scope.userStatus = 5;//积极分子
        $scope.upUserStatus = 1;//入党申请人
        $scope.pageId = "admitActiveList";

        //定义数据集合
        $scope.dataList = []; //列表数据
        $scope.xbList = [{BM: '1', HZMC: '男'}, {BM: '2', HZMC: '女'}];
        $scope.boolList = [{dickey: 1, dicvalue: '是'}, {dickey: 0, dicvalue: '否'}];
        $scope.xlList = [];
        $scope.isShow = false;
        $scope.moreTxt = "更多";
        //组织树参数
        $scope.treeparams = {
            isunfold: false,//组织结构树展开收缩
            selectdzzdm: "",
            selectdzzmc: "",
            defaultselected: $state.params.dzzdm
        };
        //查询条件
        $scope.selectparams = {
            pageindex: 1,
            pagesize: 10,
            dzzdm: '',
            userName: '',
            activeStartDate: null,
            activeEndDate: null,
            userStatus: $scope.userStatus,
            applyApproveStatus: 2,
            userCode: '',
            gradeName: '',
            className: '',
            sexId: null,
            isStudent: null,
            educationalId: null,
            isArchive: 0,
            userNo:''
        };
        $scope.pageInfo = {ptotal: 0};
        //定义模态框
        partyAdmitUser_editCtrl.$inject = ['$scope', '$http', '$alert', '$loading', '$partySelect'];
        partyAdmitUser_editModal = $modal({
            resolve: {
                load: ['$ocLazyLoad', function ($ocLazyLoad) {
                }]
            },
            scope: $scope,
            controller: partyAdmitUser_editCtrl,
            templateUrl: '../main/partyUser/admit/edit.html',
            show: false,
            animation: 'am-fade-and-slide-top'
        });

        partyAdmitUser_detailCtrl.$inject = ['$scope', '$http', '$alert', '$loading'];
        partyAdmitUser_detailModal = $modal({
            resolve: {
                load: ['$ocLazyLoad', function ($ocLazyLoad) {
                }]
            },
            scope: $scope,
            controller: partyAdmitUser_detailCtrl,
            templateUrl: '../main/partyUser/admit/detail.html',
            show: false,
            animation: 'am-fade-and-slide-top'
        });

        archiveEditCtrl.$inject = ['$scope', '$http', '$alert', '$loading'];
        archiveEditModal = $modal({
            resolve: {
                load: ['$ocLazyLoad', function ($ocLazyLoad) {
                }]
            },
            scope: $scope,
            controller: archiveEditCtrl,
            templateUrl: '../main/partyUser/admit/archiveEdit.html',
            show: false,
            animation: 'am-fade-and-slide-top'
        });

        //加载列表数据
        $scope.getList = function () {
            $http
            ({
                method: 'get', url: '../../api/partyUserAdmit/getList', params: $scope.selectparams
            }).then(function (result) {
                $scope.dataList = result.data.item.list;
                $scope.pageInfo.ptotal = result.data.item.total;
            }, function (res) {
                $scope.showMsg('错误', '服务器错误');
            });
        };

        $scope.search = function () {
            $scope.getList();
        };
        $scope.edit = function (userCode) {
            partyAdmitUser_editModal.params = {
                userCode: userCode,
                title: userCode ? "修改积极分子信息" : "新增积极分子信息",
                userStatus: $scope.userStatus,
                upUserStatus: $scope.upUserStatus
            };
            partyAdmitUser_editModal.parentLoad = $scope.getList;
            partyAdmitUser_editModal.$promise.then(partyAdmitUser_editModal.show);
        };

        $scope.excelConfig = {
            filetype: 1,
            columns: {
                '姓名': 'userName',
                '学号/工号': 'userCode',
                '所属党支部': 'partyName',
                '确定积极分子时间': 'activeDate',
                '培养联系人1': 'trainUser1',
                '培养联系人2': 'trainUser2',
                '联系电话': 'contactMobile'
            },
            errorcolumns: {
                'userName': '姓名',
                'userCode': '学号/工号',
                'partyName': '所属党支部',
                'activeDate': '确定积极分子时间',
                'trainUser1': '培养联系人1',
                'trainUser2': '培养联系人2',
                'contactMobile': '联系电话',
                'errorInfo': '错误信息'
            },
            readonly: false,
            templateUrl: '/doc/template/积极分子导入模板.xlsx'
        };

        $scope.import = function () {
            $excel.addFile($scope.excelConfig).then(function (items) {
                $loading.show();
                $http({
                    method: "post",
                    url: "../../api/partyUserAdmit/updateUserProgress",
                    data: {
                        userList: JSON.stringify(items),
                        userStatus: $scope.userStatus
                    }
                }).then(function (result) {
                    $loading.hide();
                    if (result.data.success) {
                        $scope.getList();
                        $scope.showMsg('成功', result.data.msg, 3);
                    } else {
                        if (result.data.item.length > 0) {
                            $scope.showMsg('错误', '导入失败，存在错误数据，请修改后重新导入！', 20);
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

        $scope.exportTemp = function () {
            var params = "?1=1&dzzdm=" + $scope.selectparams.dzzdm + "&userStatus=" + $scope.upUserStatus;
            window.open('../../api/partyUserAdmit/exportPartyUserAdmitTemp' + params);
        };

        $scope.export = function () {
            var params = "?1=1&getType=" + $scope.userStatus;
            for (var p in $scope.selectparams) {
                if ($scope.selectparams[p] !== '' && $scope.selectparams[p] !== null)
                    params += ("&" + p + "=" + encodeURI($scope.selectparams[p]));
            }
            window.open('../../api/partyUserAdmit/exportPartyUserAdmit' + params);
        };

        $scope.detail = function (userCode) {
            partyAdmitUser_detailModal.params = {
                userCode: userCode,
                title: "查看发展党员信息"
            };
            partyAdmitUser_detailModal.$promise.then(partyAdmitUser_detailModal.show);
        };

        $scope.archive = function () {
            /*var ids = $.map($filter('filter')($scope.dataList, {rowChecked: true}), function (x) {
                return x.userCode;
            });

            if (ids.length <= 0) {
                $scope.showMsg('提示', "请选择归档的数据");
                return false;
            }

            if (confirm("归档后人员将进入档案库，请确认！")) {
                $loading.show();
                $http({
                    method: "post",
                    url: "../../api/partyUserAdmit/archive",
                    data: {
                        userCodes: JSON.stringify(ids)
                    }
                }).then(function (result) {
                    $loading.hide();
                    if (result.data.success) {
                        $scope.showMsg('成功', "操作成功");
                        $scope.getList();
                    } else {
                        $scope.showMsg('失败', result.data.msg);
                    }
                }, function (resp) {
                    $loading.hide();
                    $scope.showMsg('错误', '服务器错误：' + resp.data);
                });
            }*/

            var ids = $.map($filter('filter')($scope.dataList, {rowChecked: true}), function (x) {
                return x.userCode;
            });

            if (ids.length <= 0) {
                $scope.showMsg('提示', "请选择需要归档的数据");
                return false;
            }

            archiveEditModal.params = {
                ids: ids,
                title: "归档"
            };
            archiveEditModal.parentLoad = $scope.getList;
            archiveEditModal.$promise.then(archiveEditModal.show);
        };

        $scope.$watch("selectparams.pageindex", function (newVal, oldVal) {
            if ($scope.pageInfo.ptotal > 0) {
                $scope.getList();
            }
        });
        $scope.$watch("treeparams.selectdzzdm", function (newVal, oldVal) {
            if (newVal != "") {
                if ($scope.treeparams.defaultselected != "" && $scope.treeparams.defaultselected != null &&
                    $scope.treeparams.defaultselected != $scope.treeparams.selectdzzdm)
                    return;

                $scope.selectparams.dzzdm = $scope.treeparams.selectdzzdm;

                $scope.getList();
            }
        });
        $scope.setisunfold = function () {
            $scope.treeparams.isunfold = !$scope.treeparams.isunfold;
            $scope.$emit('menudatas.toggle', !$scope.treeparams.isunfold);
        };

        $scope.isShowClick = function () {
            $scope.isShow = !$scope.isShow;
            if ($scope.moreTxt == "更多") {
                $scope.moreTxt = "收起";
            } else if ($scope.moreTxt == "收起") {
                $scope.moreTxt = "更多";
            }
        };
        $scope.getEducationList = function () {
            $http({
                method: 'get',
                url: '../../api/partyDic/getEducationList'
            }).then(function (result) {
                $scope.xlList = result.data;
            }, function (resp) {

            });
        };

        $scope.getEducationList();

    });
})(angular);