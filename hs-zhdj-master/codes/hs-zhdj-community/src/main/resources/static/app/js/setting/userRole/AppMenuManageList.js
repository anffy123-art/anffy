(function ($ang_userRole) {
    'use strict';
    $ang_userRole.module('gtPartyApp', []).controller("AppMenuManageListController", function ($scope, $http, $rootScope, $alert) {
        $scope.modularLists = [];
        $scope.modularname = "";

        $scope.roleInfo = $rootScope.role;

        //分页参数设置
        $scope.finddata = {
            pageindex: 1,
            pagesize: 5,
            ptotal: 0
        };

        //监测页面变化
        $scope.$watch("finddata.pageindex", function (newVal, oldVal) {
            if ($scope.finddata.ptotal > 0) {
                $scope.getModularList();
            }
        })

        //查询按钮
        $scope.selectpage = function () {
            $scope.finddata.pageindex = 1;
            $scope.finddata.ptotal = 0;
            $scope.getModularList();
        }

        $scope.changeIsUse = function (modular) {

            if (modular.ISUSE == 1) {
                $http({
                    url: "../../api/modular/deleteModularRole",
                    method: 'GET',
                    params: {
                        MODULARID: modular.MID,
                        ROLEID: $scope.roleInfo.roleId,
                    }
                }).then(function (result) {
                    $scope.showMsg("消息", result.data.msg);
                    if (result.data.success) {
                        $scope.getModularList();
                    }
                });
            } else {
                $http({
                    method: "post",
                    url: "../../api/modular/saveModularRole",
                    data: {
                        rmid : modular.RMID,
                        modularid: modular.MID,
                        roleid: $scope.roleInfo.roleId,
                        iscommonuse: modular.ISCOMMONUSE,
                        orderby: modular.ORDERBY,
                    }
                }).then(function (result) {
                    $scope.showMsg('提示', result.data.msg);
                    //重新刷新列表
                    $scope.getModularList();
                }, function (resp) {
                    $scope.showMsg('错误', '服务器错误');
                })
            }
        }

        $scope.changeIsCommonuse = function (modular){

            if (modular.ISCOMMONUSE == 1) {
                modular.ISCOMMONUSE = 0;
            }else {
                modular.ISCOMMONUSE = 1;
            }

            $http({
                method: "post",
                url: "../../api/modular/saveModularRole",
                data: {
                    rmid : modular.RMID,
                    modularid: modular.MID,
                    roleid: $scope.roleInfo.roleId,
                    iscommonuse: modular.ISCOMMONUSE,
                    orderby: modular.ORDERBY,
                }
            }).then(function (result) {
                $scope.showMsg('提示', result.data.msg);
                //重新刷新列表
                $scope.getModularList();
            }, function (resp) {
                $scope.showMsg('错误', '服务器错误');
            })

        }

        //通过mid以及名字去实现模糊查询
        $scope.getModularList = function () {
            $http({
                url: "../../api/modular/selectModularList",
                method: 'GET',
                params: {
                    roleId: $rootScope.role.roleId,
                    modularname: $scope.modularname,
                    pageindex: $scope.finddata.pageindex,
                    pagesize: $scope.finddata.pagesize
                }
            }).then(function (rq) {
                $scope.modularLists = rq.data.item.list;
                $scope.finddata.ptotal = rq.data.item.total;
            }, function (rq) {
                alert("获取失败");
            });
        }
        $scope.getModularList();

        $scope.showalert = function (data) {
            $alert({title: '提示：', content: data, placement: 'top', type: 'info', show: true, duration: 3});
        };
    });
})(angular);
