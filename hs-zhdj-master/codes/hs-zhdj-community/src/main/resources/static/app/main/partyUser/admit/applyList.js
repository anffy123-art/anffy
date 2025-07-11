(function ($app) {
    $app.module('gtPartyApp').controller('admitApplyCtrl', function ($scope, $http, $modal, $ocLazyLoad, $alert, $loading, $state, $bsRouterState, AuthUser, $timeout, $excel, $partySelect, $filter) {
        $state.params = $bsRouterState.$params($scope);
        $scope.loginUserId = AuthUser.getUser().Id;
        $scope.pageId = "admitApplyList";
        $scope.userStatus = 1;

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
            applyStartDate: null,
            applyEndDate: null,
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
                title: userCode ? "修改入党申请人信息" : "新增入党申请人信息",
                userStatus: $scope.userStatus
            };
            partyAdmitUser_editModal.parentLoad = $scope.getList;
            partyAdmitUser_editModal.$promise.then(partyAdmitUser_editModal.show);
        };

        $scope.delete = function (rybm) {
            if (confirm("是否确定删除？")) {
                $http({
                    url: "../../api/partyUser/deletePartyById_ZN",
                    method: 'GET',
                    params: {rybm: rybm}
                }).then(function (result) {
                    $scope.showMsg("消息", result.data.msg);
                    if (result.data.success) {
                        $scope.getList();
                    }
                });
            }
        };

        $scope.excelConfig = {
            filetype: 1,
            columns: {
                '姓名': 'userName',
                '学号/工号': 'userCode',
                '所属党支部名称': 'partyName',
                '性别': 'sex',
                '民族': 'national',
                '出生日期': 'birthDate',
                '籍贯(省市县)': 'nativePlace',
                '身份证号': 'idCard',
                '年级': 'gradeName',
                '班级': 'className',
                '最高学历': 'education',
                '最高学历入学日期': 'enrollmentDate',
                '最高学历毕业日期': 'graduateDate',
                '申请入党时间': 'applyDate',
                '联系电话': 'contactMobile',
                '是否学生身份': 'isStudent'
            },
            errorcolumns: {
                'userName': '姓名',
                'userCode': '学号/工号',
                'partyName': '所属党支部名称',
                'isStudent': '是否学生身份',
                'sex': '性别',
                'national': '民族',
                'birthDate': '出生日期',
                'nativePlace': '籍贯(省市县)',
                'idCard': '身份证号',
                'gradeName': '年级',
                'className': '班级',
                'education': '最高学历',
                'enrollmentDate': '最高学历入学日期',
                'graduateDate': '最高学历毕业日期',
                'applyDate': '申请入党时间',
                'contactMobile': '联系电话',
                'errorInfo': '错误信息'
            },
            readonly: false,
            templateUrl: '/doc/template/入党申请人导入模版.xlsx',
            typeparams: {types: ['xls', 'xlsx'], errormsg: '请选择excel格式文件'}
        };

        $scope.import = function () {
            $excel.addFile($scope.excelConfig).then(function (items) {
                $loading.show();
                $http({
                    method: "post",
                    url: "../../api/partyUserAdmit/importApplyUser",
                    data: {
                        userList: JSON.stringify(items)
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

        $scope.export = function () {
            var params = "?1=1&getType=" + 1;
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