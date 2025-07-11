(function ($app) {
    'use strict';
    $app.module('dsfapp').controller('stepDevTestCtrl', function ($scope, $state, $alert, AuthUser, flowaudit, $loading, $ocLazyLoad) {
        $scope.stepdata = {
            flowStagePanels: [],
            activePanelids: [0, 1],
            params: $state.params
        };

        $scope.$on("toDevTest", function (event, tar) {
            $scope.stepdata.params = tar;
            var stepparams = {
                showBtnExec: !tar.readonly && tar.FlowStage == 5 && tar.ft == 2,//是否显示执行测试计划按钮
                readonly_InternalTest: true,//内部测试是否只读tar.readonly || (tar.ft != 2 && tar.FlowStage == 5)
                readonly_FuncTest: tar.readonly || (tar.ft != 3 && tar.FlowStage == 5) || tar.FlowStage > 5,//功能测试是否只读
                showAllForm: (tar.ft > 2 && tar.FlowStage == 5) || tar.FlowStage != 5//是否显示内部测试和功能测试
            }
            angular.extend($scope.stepdata.params, stepparams);
            if ($scope.stepdata.flowStagePanels <= 0) {
                $scope.loadingflow();
            }


        });

        //定义加载模块
        $scope.loadingflow = function () {
            $loading.show();
            $ocLazyLoad.load(['dsflow/formDevTestProblem.js']).then(function (loaddata) {
                angular.copy([
                    {
                        title: '内部测试计划', src: 'dsflow/formDevTestProblem.html', onloadfunc: function () {
                            $scope.$broadcast("toDevTestProblem", $scope.stepdata.params);
                        }
                    }], $scope.stepdata.flowStagePanels);
            });
        };

        //执行incluld的onload事件
        $scope.loadPanel = function (func) {
            if (angular.isFunction(func)) {
                func();
            }
        }
    });
})(angular);