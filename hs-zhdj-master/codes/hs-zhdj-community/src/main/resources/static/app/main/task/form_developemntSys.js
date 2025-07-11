(function ($app) {
    "use strict";
    $app.module('dsfapp').controller('developmentSys', function ($scope, $rootScope, $loading, $state, $modal, $alert, AuthUser, flowaudit, $http, $window) {
        //分页参数设置  
        $scope.finddata = {
            pageindex: 1,
            pagesize: 5,
            ptotal: 0
        };
        //监测页面变化
        $scope.$watch("finddata.pageindex", function (newVal, oldVal) {
            if ($scope.finddata.ptotal > 0) {
                $scope.loadSys($scope.flowdata.params.fid);
            }
        })


        //根据fid加载对应的功能点相关信息
        $scope.loadSys = function (id) {
            $http({
                url: "../../api/DevelopmentTask/getSyslist",
                method: 'GET',
                params: {
                    fid: id,
                    pageIndex: $scope.finddata.pageindex,
                    pageSize: $scope.finddata.pagesize
                }
            })
                .then(function (rq) {
                    $scope.Syslist = rq.data.items;
                    //$scope.totalList = rq.data.total;
                    $scope.finddata.ptotal = rq.data.total;
                }, function (rq) {
                    alert("获取失败");
                });
            $loading.hide();
        }
        $scope.loadSys($scope.flowdata.params.fid);

        //查看功能点相应信息的弹窗，不允许编辑
        var MyEditModalController = function ($scope, $http) {
            $scope.params = myModal.params;
            $scope.content = myModal.params.content;

            //获取单个开发任务报告明细
            $scope.loadTaskSys = function () {
                $http.get("../../api/DevelopmentTask/getTaskSys", {params: {'SysDutyID': $scope.params.SysDutyID}}).then(function (result) {
                    //console.log(result);
                    $scope.content = result.data.items[0];
                }, function () {
                    $alert({title: '提示：', content: "服务器错误", placement: 'top', type: 'info', show: true, duration: 3});
                });
            }
            $scope.loadTaskSys();
        }
        MyEditModalController.$inject = ['$scope', '$http'];

        //查看功能点模拟框
        var myModal = $modal({
            scope: $scope,
            templateUrl: 'task/showTaskSys.html',
            controller: MyEditModalController,
            show: false,
            animation: 'am-fade-and-slide-top'
        });

        //打开查看功能点模拟框
        $scope.editmodal = function (sysDutyID) {
            myModal.params = {
                title: "开发任务功能点查看",
                content: {},
                SysDutyID: sysDutyID,
            }
            myModal.$promise.then(myModal.show);
        }

        $scope.showalert = function (data) {
            $alert({title: '提示：', content: data, placement: 'top', type: 'info', show: true, duration: 2});
        };

        //接收广播
        $scope.$on("todevelopmentSys", function (event, tar) {
            if (angular.isUndefined($scope.Syslist)) {
                $scope.loadSys(tar.fid);
            }
        });
    });
})(angular);