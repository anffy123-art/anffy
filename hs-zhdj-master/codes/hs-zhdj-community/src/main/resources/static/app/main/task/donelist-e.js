(function ($saga_done) {
    'use strict';
    $saga_done.module('zcapp').controller('donelistECtrl', function ($scope, $http, AuthUser, $loading, $alert) {
        $scope.title = "已办页面";

        //查询以及分页参数设置  
        $scope.finddata = {pageindex: 1, pagesize: 10, total: 0, userlid: AuthUser.getUser().Id, dateb: '', datee: ''};

        //查询按钮
        $scope.selectpage = function () {
            $scope.finddata.pageindex = 1;
            $scope.finddata.total = 0;
            $scope.getDoneList();
        }


        //监视页面的变化
        $scope.$watch("finddata.pageindex", function (newVal, oldVal) {
            if ($scope.finddata.total > 0) {
                $scope.getDoneList();
            }
        });

        //工作流获取数据
        $scope.getDoneList = function () {
            $loading.show();
            //判断是否为null;
            $scope.finddata.dateb = $scope.finddata.dateb || '';
            $scope.finddata.datee = $scope.finddata.datee || '';
            $http({url: "../../api/flow/doneflowlist", method: 'GET', params: $scope.finddata}).then(function (rq) {
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
        $scope.getDoneList();


    });

})(angular);