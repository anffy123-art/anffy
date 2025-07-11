(function ($app) {
    'use strict';
    $app.module('dsfapp').controller('formUploadTestFileCtrl', function ($scope, $http, $state, AuthUser, $modal, $alert, $loading, $bsfiles) {
        //分页参数设置  
        $scope.finddata = {
            pageindex: 1,
            pagesize: 5,
            ptotal: 0
        };
        //接收广播
        $scope.$on("toUploadTestFile", function (event, tar) {
            $scope.params = tar;
            $scope.fileOption = {
                selectdata: {FileRefID: tar.fid, pageindex: 1, pagesize: 10, ptotal: 0},
                filetype: 3,
                items: [],
                readonly: tar.isAllPlan || tar.readonly
            };
            //判断是否显示所有测试计划
            $scope.uid = tar.isAllPlan ? '' : AuthUser.getUser().DGUserID;
            if (angular.isUndefined($scope.items)) {
                $scope.loadItem();
            }
        });
        //监测页面变化
        $scope.$watch("finddata.pageindex", function (newVal, oldVal) {
            if (angular.isUndefined($scope.items)) {
                $scope.loadItem();
            }
        });

        $scope.loadItem = function () {
            $http({
                url: "../../api/DevTest/getDevTestPlanListByFid",
                method: 'GET',
                params: {fid: $scope.params.fid, uid: $scope.uid}
            }).then(function (rq) {
                $scope.items = rq.data
                $loading.hide();
            }, function (ex) {
                $loading.hide();
            });
        };

        var testfileCtrl = function ($scope, $http) {
            $scope.title = '测试文件列表';
            $scope.param = fModal.param;
            $scope.fileOption = {
                selectdata: {FileRefID: $scope.param.DevTestPlanID, pageindex: 1, pagesize: 10, ptotal: 0},
                filetype: 3,
                items: [],
                readonly: $scope.param.isAllPlan || $scope.param.readonly
            };
        };

        testfileCtrl.$inject = ['$scope', '$http'];
        var fModal = $modal({
            controller: testfileCtrl,
            templateUrl: 'testfilelist.html', show: false,
            placement: 'center', animation: 'am-fade-and-slide-top'
        });
        $scope.showFileList = function (item) {
            fModal.param = angular.extend($scope.params, {DevTestPlanID: item.DevTestPlanID});
            fModal.$promise.then(fModal.show);
        }

    }).filter('isPlanState', function () {
        //0过滤
        return function (item) {
            switch (item) {
                case 0:
                    return "未测试";
                case 1:
                    return "测试中";
                case 2:
                    return "已测试";
                default:
                    return "未测试";
            }
        };
    });
})(angular);