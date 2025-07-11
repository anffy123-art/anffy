(function ($app) {
    'use strict';
    $app.module('dsfapp').controller('stepDevSysDesignCtrl', function ($scope, $state, $alert, AuthUser, flowaudit, $ocLazyLoad, $loading) {
        $scope.stepdata = {
            flowStagePanels: [],
            activePanelids: [0, 1, 2],
            params: $state.params,
            FlowStage: 3
        };
        //angular.extend($scope.stepdata.params, { FlowStep: 3 })

        //定义加载模块
        $scope.loadingflow = function () {
            $loading.show();
            $ocLazyLoad.load(['dsflow/formQuantityOfWork.js']).then(function (loaddata) {
                angular.copy(
                    [{
                        title: '工作量', src: 'dsflow/formQuantityOfWork.html', onloadfunc: function () {

                            $scope.$broadcast('toQuantityOfWork', $scope.stepdata.params);
                        }
                    }], $scope.stepdata.flowStagePanels);
            });
        };


        //接收广播事件
        $scope.$on("todevSysDesign", function (event, tar) {
            $scope.stepdata.params = tar;
            $scope.stepdata.params.FlowStage = 3;
            $scope.loadingflow();

        });
        //执行incluld的onload事件
        $scope.loadPanel = function (func) {
            if (angular.isFunction(func)) {
                func();
            }
        }

        $scope.applyclick = function (i) {
            if (i == 0) {
                $scope.$broadcast("toQuantityOfWork", $scope.stepdata.params);
            }
        }


    });
})(angular);