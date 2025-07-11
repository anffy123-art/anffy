(function ($saga_todo) {
    'use strict';
    $saga_todo.module('zcapp').controller('todolistECtrl', function ($scope, $http, AuthUser, $loading, $alert) {
        $scope.title = "待办页面";

        //查询条件以及分页参数 
        $scope.finddata = {
            pageindex: 1,
            pagesize: 10,
            total: 0,
            userlid: AuthUser.getUser().Id,
            todoTitle: '',
            createUserName: ''
        };

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
        /*
        $scope.testpay=function(){
            $payService.payShow({
                amt: 0.01,
                payRelID: 'xxxxxxxx20190105002',
                //companyID: '3333b44c-1f52-4cf1-a481-94c9743516f3',
                companyID:'05d83e2a-5814-4cca-93e2-da5306ec904f',
                creatorID: $scope.User.Id,
                commodityName: '测试银联'
            }).then(function (val) {
                alert("已经返回："+val);
            });
        };

        $scope.backpay=function(){
            $payService.backShow( 'xxxxxxxx20190105002').then(function (val) {
                alert("退款返回："+val);
            });
        };

        */

        //工作流获取数据
        $scope.getTodoList = function () {
            $loading.show();
            $http({url: "../../api/flow/todoflowlist", method: 'GET', params: $scope.finddata}).then(function (rq) {
                $scope.items = rq.data.item;
                angular.forEach($scope.items, function (val, index) {
                    $scope.items[index].toDoUrl = 'ent/' + $scope.items[index].toDoUrl;
                });
                $scope.finddata.total = rq.data.total;
                $loading.hide();
            }, function (rq) {
                $alert({
                    content: "服务器错误！错误代码：" + rq.status,
                    placement: 'center',
                    type: 'info',
                    show: true,
                    duration: 3
                });
                $loading.hide();
            });
        }
        $scope.getTodoList();


    });
    //angular.module('dsfapp').filter('titleAndPerson', function () {
    //    //0过滤
    //    return function (e, todoTitle, pushPerson) {
    //        return (todoTitle == null ? true : (e.ToDoTitle.indexOf(todoTitle) > 0)) && (pushPerson == null ? true : (e.UserName.indexOf(pushPerson) > 0));
    //    };
    //})


})(angular);