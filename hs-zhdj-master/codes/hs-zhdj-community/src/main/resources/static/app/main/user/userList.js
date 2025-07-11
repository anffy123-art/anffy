(function ($app) {
    $app.module('gtPartyApp').controller('userListCtrl', function ($scope, $http, $modal, $ocLazyLoad, $alert, $loading, $state, $desData, AuthUser, $bsRouterState, $excel) {

        //列表页面
        $scope.title = "用户管理";
        $scope.isShow = false;
        $scope.moreTxt = "更多";

        //定义数据集合
        $scope.treeList = []; //组织架构
        $scope.dataList = []; //列表数据
        $scope.userList = []; //用户数据
        $scope.roleIdUserList = [];
        $scope.ryztList = [];//人员状态
        //初始化查询参数
        $scope.selectparams = {
            isunfold: false,//组织结构树展开收缩
            'pageindex': 1,
            'pagesize': 10,
            'username': '',
            'selectdzzdm': '',
            selectdzzmc: '',
            xm: '',
            rybm: '',
            ryzt: null,
            dzzdm: '',
            userNo:''
        };
        $scope.resetparams = {};
        $scope.pageInfo = {ptotal: 0};
        angular.extend($scope.resetparams, $scope.selectparams);

        //监视页数变化
        $scope.$watch("selectparams.pageindex", function (newVal, oldVal) {
            if ($scope.pageInfo.ptotal > 0) {
                $scope.loadData();
            }
        });

        $scope.$watch("selectparams.selectdzzdm", function (newVal, oldVal) {
            if (newVal != '' && newVal != null) {
                $scope.selectparams.dzzdm = $scope.selectparams.selectdzzdm;
                $scope.loadData();
            }
        });

        //查询
        $scope.search = function () {
            $scope.loadData();
        };

        $scope.reset = function () {
            $scope.selectparams = {};
            angular.extend($scope.selectparams, $scope.resetparams);
            $scope.pageInfo = {ptotal: 0};
            $scope.getList();
        };

        //取数方法
        $scope.loadData = function () {
            $loading.show();

            //获取用户基本信息
            $http({
                method: 'get',
                url: '../../api/partyUser/getAllUserList',
                params: $scope.selectparams
            }).then(function (result) {
                $scope.roleIdUserList = [];
                $scope.datalist = result.data.item.list;
                $scope.pageInfo.ptotal = result.data.item.total;
                $loading.hide();
            });
        };

        $scope.enableUser = function (id, enable) {
            $http({
                method: "post",
                url: "../../api/user/enableUser",
                data: {
                    id: id,
                    enable: enable
                }
            }).then(function (result) {
                if (result.data.success) {
                    $scope.showMsg('成功', result.data.msg);
                    //重新刷新列表
                    $scope.loadData();
                } else {
                    $scope.showMsg('失败', result.data.msg);
                }

            }, function (resp) {
                $scope.showMsg('错误', '服务器错误');
            })
        };

        $scope.excelConfig = {
            filetype: 1,
            columns: {
                '姓名': 'userName',
                '学号/工号': 'userCode',
                '所属党支部名称': 'partyName',
                '性别': 'sex',
                '出生日期': 'birthDate',
                '联系电话': 'contactMobile'
            },
            errorcolumns: {
                'userName': '姓名',
                'userCode': '学号/工号',
                'partyName': '所属党支部名称',
                'sex': '性别',
                'birthDate': '出生日期',
                'contactMobile': '联系电话',
                'errorInfo': '错误信息'
            },
            readonly: false,
            templateUrl: '/doc/template/群众信息导入模版.xlsx'
        };
        $scope.import = function () {
            $excel.addFile($scope.excelConfig).then(function (items) {
                $loading.show();
                $http({
                    method: "post",
                    url: "../../api/user/importUser",
                    data: {
                        userList: JSON.stringify(items)
                    }
                }).then(function (result) {
                    $loading.hide();
                    if (result.data.success) {
                        $scope.loadData();
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

        var editPasswordCtrl = function ($scope, $http) {
            $scope.params = passwordModal.params;
            $scope.uservm = passwordModal.uservm;
            $scope.userinfovm = passwordModal.userinfovm;
            $scope.pwd = {
                pwd_default: '',
                pwd_confirm: ''
            };

            $scope.submitUser = function (isflag) {
                if (isflag) {
                    if ($scope.pwd.pwd_default != $scope.pwd.pwd_confirm) {
                        $scope.showMsg('失败', "两次输入的密码不一致！");
                        return;
                    }

                    //$scope.uservm.userpwd = $scope.pwd.pwd_default;

                    var data = $desData.GetToken($scope.uservm.userid + '|' + $scope.pwd.pwd_default);

                    $loading.show();
                    $http({
                        method: "post",
                        url: "../../api/user/updatePassword",
                        data: data
                    }).then(function (result) {
                        $loading.hide();
                        if (result.data.success) {
                            $scope.showMsg('成功', result.data.msg);
                            //重新刷新列表
                            $scope.loadData();
                            $scope.$hide();
                        } else {
                            $scope.showMsg('失败', result.data.msg);
                        }

                    }), function (resp) {
                        $scope.showMsg('错误', '服务器错误');
                    }
                }
            }
        };
        editPasswordCtrl.$inject = ['$scope', '$http'];
        //定义模态框
        var passwordModal = $modal({
            resolve: {
                load: ['$ocLazyLoad', function ($ocLazyLoad) {
                    //return [$ocLazyLoad.load('../main/user/edituser.css')];
                }]
            },
            scope: $scope,
            controller: editPasswordCtrl,
            templateUrl: '../main/user/editPassword.html',
            show: false,
            animation: 'am-fade-and-slide-top'
        });
        $scope.editPassword = function (id) {

            passwordModal.params = {};
            $http.get("../../api/user/getUserByID", {params: {'id': id}}).then(function (result) {
                passwordModal.uservm = result.data.extdata.userModel;
                passwordModal.userinfovm = result.data.item;
                passwordModal.$promise.then(passwordModal.show);
            }, function () {
                $scope.showMsg('错误', '服务器错误');
            });

        };
        $scope.assetRole = function (id, selectvalues, selecttexts) {
            $scope.userids = new Array(id);
            $scope.selectRolelist.selectedValueData = selectvalues;
            $scope.selectRolelist.selectedLabeData = selecttexts;

        };

        var deleteUserInfoCtrl = function ($scope, $http) {
            $scope.mobile = "";
            $scope.save = function (isflag) {
                if (isflag) {
                    $loading.show();
                    $http({
                        method: "post",
                        url: "../../api/user/deleteUserInfo",
                        data: {mobile: $scope.mobile}
                    }).then(function (result) {
                        $loading.hide();
                        if (result.data.success) {
                            $scope.$hide();
                            $scope.showMsg('成功', result.data.msg);
                            $scope.loadData();
                        } else {
                            $scope.showMsg('失败', result.data.msg);
                        }

                    }, function (resp) {
                        $scope.showMsg('错误', '服务器错误');
                    })
                }
            }
        };
        deleteUserInfoCtrl.$inject = ['$scope', '$http'];
        //定义模态框
        var deleteUserInfoModal = $modal({
            resolve: {
                load: ['$ocLazyLoad', function ($ocLazyLoad) {

                }]
            },
            scope: $scope,
            controller: deleteUserInfoCtrl,
            templateUrl: '../main/user/deleteUserInfo.html',
            show: false,
            animation: 'am-fade-and-slide-top'
        });
        $scope.deleteUserInfo = function () {
            deleteUserInfoModal.$promise.then(deleteUserInfoModal.show);
        };

        $scope.selectRolelist = {
            url: '../../api/userrole/GetRoleList',
            title: '角色选择',
            isMulti: true,
            selectData: {rolename: '角色名称'},
            columns: {rolename: '角色名称', description: '角色描述', groupby: '分组', orderby: '排序'},
            selectLabelKey: 'rolename',
            selectValuekey: 'roleid',
            selectedValueData: '',
            selectedLabeData: '',
            selectedJData: [],
            selectParams: {
                rolename: '',
                appid: '',
                userId: AuthUser.getUser().Id,
            },
            onSelect: function (selectvalues) {
                $http({
                    url: "../../api/user/SaveUserRoleList",
                    method: 'GET',
                    params: {
                        roleId: selectvalues,
                        isRemoveRole: true,
                        userIds: $scope.userids.join(",")
                    }
                }).then(function (res) {

                    $scope.loadData();
                    $scope.showalert(res.data.msg);
                }, function (res) {
                    $scope.showalert("添加人员失败");
                });
            }
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

        //人员状态
        $scope.getRyztList = function () {
            $http({
                method: 'get',
                url: '../../api/partyDic/getRyztList',
                params: {}
            }).then(function (result) {
                $scope.ryztList = result.data;
            }, function (resp) {
            });
        };

        //初始化数据
        $scope.getRyztList();
    });

})
(angular);