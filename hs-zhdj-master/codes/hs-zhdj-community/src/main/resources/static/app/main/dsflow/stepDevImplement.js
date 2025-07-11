(function ($app) {
    'use strict';
    $app.module('dsfapp').controller('formDevImplementCtrl', function ($scope, $location, $state, $alert, AuthUser, flowaudit, $ocLazyLoad, $loading) {
        $scope.stepdata = {
            flowStagePanels: [],
            activePanelids: [],
            params: {}
        };


        //定义加载模块
        $scope.loadingflow = function () {

            if ($scope.stepdata.flowStagePanels.length > 0) {
                return;
            }

            $ocLazyLoad.load(['dsflow/formDevPlan.js', 'dsflow/formDevPlanReport.js', 'dsflow/formQuantityOfWork.js']).then(function (loaddata) {
                angular.copy([
                    {
                        title: '开发计划', src: 'dsflow/formDevPlan.html', onloadfunc: function () {
                            $scope.$broadcast("toDevPlan", $scope.stepdata.params);
                        }
                    },
                    {
                        title: '实施日志', src: 'dsflow/formDevPlanReport.html', onloadfunc: function () {
                            $scope.$broadcast("toDevPlanReport", $scope.stepdata.params);
                        }
                    },
                    {
                        title: '工作量', src: 'dsflow/formQuantityOfWork.html', onloadfunc: function () {

                            $scope.$broadcast('toQuantityOfWork', $scope.stepdata.params);
                        }
                    }
                ], $scope.stepdata.flowStagePanels);
            });
        };

        //执行incluld的onload事件
        $scope.loadPanel = function (func) {
            if (angular.isFunction(func)) {
                func();
            }
        }
        //
        $scope.$on("toDevImplement", function (event, tar) {
            $scope.stepdata.params = tar;
            $scope.stepdata.params.FlowStage = 4;
            $scope.loadingflow();
        });


    });
})(angular);