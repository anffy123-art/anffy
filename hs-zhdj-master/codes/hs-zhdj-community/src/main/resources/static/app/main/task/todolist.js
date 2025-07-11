(function ($saga_todo) {
    'use strict';
    $saga_todo.module('gtPartyApp').controller('todolistCtrl', function ($scope, $http, AuthUser, $loading, $alert) {
        $scope.title = "待办页面";

        //查询条件以及分页参数 
        $scope.finddata = {pageindex: 1, pagesize: 10, total: 0, userlid: '', todoTitle: '', createUserName: ''};

        //选择页数
        $scope.selectpage = function () {
            $scope.finddata.pageindex = 1;
            $scope.finddata.total = 0;
            $scope.getTodoList();
        }

        //监视页面的变化
        $scope.$watch("finddata.pageindex", function (newVal, oldVal) {
            if ($scope.finddata.total > 0) {
                $scope.getTodoList();
            }
        });

        //工作流获取数据
        $scope.getTodoList = function () {
            $loading.show();
            $http({url: "../../api/flow/todoflowlist", method: 'GET', params: $scope.finddata}).then(function (rq) {
                $scope.items = rq.data.item;
                $scope.finddata.total = rq.data.extdata.total;
                $loading.hide();
            }, function (rq) {
                $loading.hide();
                $alert({
                    content: "服务器错误！错误代码：" + rq.status,
                    placement: 'center',
                    type: 'info',
                    show: true,
                    duration: 3
                });
            });
        };
        /*
        $scope.backpay=function(){

        }

        $scope.testpay=function(){

        };*/
        AuthUser.dofunAfterLogin().then(function (user) {
            $scope.finddata.userlid = user.Id;
            $scope.getTodoList();
        });


    });


})(angular);