(function ($app) {
    'use strict';
    $app.module('dsfapp').controller('DevPlanReportCtrl', function ($scope, $http, $modal, $rootScope, $alert) {
        $scope.TaskReportLists = [];

        //分页参数设置  
        $scope.finddata = {
            pageindex: 1,
            pagesize: 5,
            ptotal: 0
        };
        //监测页面变化
        $scope.$watch("finddata.pageindex", function (newVal, oldVal) {
            if ($scope.finddata.ptotal > 0) {
                $scope.getTaskReportLists($scope.flowdata.params.fid);
            }
        })

        //根据工作流fid找到对应的任务报告相应的数据
        $scope.getTaskReportLists = function (id) {
            $http({
                url: "../../api/DevelopmentTask/getImpLog",
                method: 'GET',
                params: {
                    fid: id,
                    pageIndex: $scope.finddata.pageindex,
                    pageSize: $scope.finddata.pagesize
                }
            })
                .then(function (rq) {
                    //console.log(rq.data.msg);
                    $scope.TaskReportLists = rq.data.items;
                    $scope.finddata.ptotal = rq.data.total;
                }, function (rq) {
                    alert("获取失败");
                });
        }
        $scope.getOneImpLog = function ($event, id) {
            $http({
                url: "../../api/DevelopmentTask/getOneImpLog",
                method: 'GET',
                params: {
                    TaskbaseID: id
                }
            })
                .then(function (rq) {
                    $scope.DevPlanReportLists = rq.data.items;
                    if ($($event.target).parents('tr').next('tr').css('display') == 'table-row') {
                        $($event.target).parents('tr').next('tr').css('display', 'none');
                    } else {
                        $(".secondTr").css('display', 'none');
                        $($event.target).parents('tr').next('tr').css('display', 'table-row');
                    }
                }, function (rq) {
                    alert("获取失败");
                });
        }
        //$scope.getTaskReportLists($scope.flowdata.params.fid);

        //广播
        $scope.$on("toDevPlanReport", function (event, tar) {
            $scope.params = tar;
            if (angular.isUndefined($scope.item)) {
                $scope.getTaskReportLists($scope.params.fid);
            }

        });
    });
})(angular);