(function ($ang_userRole) {
    'use strict';
    $ang_userRole.module('devself.common', []).controller("UserManageListController", function ($scope, $http, $rootScope, $alert, $modal, $ocLazyLoad) {
        $scope.RoleUserLists = [];
        $scope.Name = "";
        //人员选择
        $rootScope.selectedID = '';
        $rootScope.selectedName = '';
        $rootScope.selectedDataUsers = [];
        $rootScope.selectedGuids = '';


        //分页参数设置  
        $scope.finddata = {
            pageindex: 1,
            pagesize: 5,
            ptotal: 0
        };

        //监测页面变化
        $scope.$watch("finddata.pageindex", function (newVal, oldVal) {
            if ($scope.finddata.ptotal > 0) {
                $scope.getUserRoleList();
            }
        })

        //查询按钮
        $scope.selectpage = function () {
            $scope.finddata.pageindex = 1;
            $scope.finddata.ptotal = 0;
            $scope.getUserRoleList();
        }

        //通过roleId以及名字去实现模糊查询
        $scope.getUserRoleList = function () {
            $http({
                url: "../../api/userrole/GetRoleUserList",
                method: 'GET',
                params: {
                    roleId: $rootScope.role.roleId,
                    //roleName: $rootScope.role.roleName,
                    name: $scope.Name,
                    pageIndex: $scope.finddata.pageindex,
                    pageSize: $scope.finddata.pagesize
                }
            })
                .then(function (rq) {
                    //console.log(rq);
                    $scope.RoleUserLists = rq.data.item.list;
                    $scope.finddata.ptotal = rq.data.item.total;
                }, function (rq) {
                    alert("获取失败");
                });
        }
        $scope.getUserRoleList();

        //根据UserId删除一条角色对应的人员信息记录
        $scope.deleteUserRole = function (UserId, RoleId) {
            if (!confirm("确认删除?")) {
                return;
            }
            $http({
                url: "../../api/user/deleteUserRole",
                method: 'GET',
                params: {
                    userId: UserId,
                    roleId: RoleId
                }
            }).then(function (res) {

                $scope.showalert(res.data.msg);
                $scope.getUserRoleList();
            }, function () {
                $alert({title: '错误：', content: '服务器错误', placement: 'top', type: 'info', show: true, duration: 2});
            });
        };

        //给弹窗界面进行赋值操作
        var MyEditModalController = function ($scope, $http) {

            $scope.title = "新增人员信息";
            $scope.userRole = myModal.data;
            $scope.saveUserRole = function (isflag) {
                if (isflag) {
                    $http({
                    url: "../../api/user/SaveUserRoleList",
                    method: 'GET',
                    params: {
                        roleId: $scope.userRole.roleId,
                        //name: $scope.userRole.name
                        userIds: $scope.userRole.selectedGuids
                    }
                }).then(function (res) {
                    //console.log(res);
                    if (res.data.success) {
                        myModal.$promise.then(myModal.hide);

                    } else {
                        myModal.$promise.then(myModal.hide);
                    }
                    $scope.getUserRoleList();
                    $scope.showalert(res.data.msg);
                }, function (res) {
                    $scope.showalert("添加人员失败");
                });
            }
            };
        };
        MyEditModalController.$inject = ['$scope', '$http'];

        var myModal = $modal({
            scope: $scope,
            title: '修改人员',
            templateUrl: '../js/setting/userRole/editUserRoleModal.html',
            controller: MyEditModalController,
            show: false,
            animation: 'am-fade-and-slide-top'
        });
        $scope.editModal = function (e) {
            myModal.data = e;

            myModal.$promise.then(myModal.show);
        };
        $scope.addModal = function () {
            $scope.userRole = {
                RoleName: $rootScope.role.roleName,
                roleId: $rootScope.role.roleId,
                selectedGuids: $rootScope.selectedGuids
                //name: "",
            };

            $scope.editModal($scope.userRole);
        };
        $scope.showalert = function (data) {
            $alert({title: '提示：', content: data, placement: 'top', type: 'info', show: true, duration: 3});
        };
    });
})(angular);
