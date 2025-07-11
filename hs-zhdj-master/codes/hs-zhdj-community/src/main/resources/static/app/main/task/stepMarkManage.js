(function ($app) {
    'use strict';
    $app.module('dsfapp').controller('MarkManageCtrl', function ($scope, $state, $alert, AuthUser, flowaudit, $http, $ocLazyLoad, $loading) {
        $scope.stepdata = {
            flowStagePanels: [],
            activePanelids: [],
            params: $state.params,
            FlowStep: 6,
            params_markScale: {}        //需求评分权限参数
        };

        angular.extend($scope.stepdata.params, {
            readonly: $scope.stepdata.readonly,
            FlowStep: $scope.stepdata.FlowStep
        });
        angular.copy($scope.stepdata.params, $scope.stepdata.params_markScale);
        $scope.stepdata.params_markScale.readonly = true;

        //定义加载模块
        $scope.loadingflow = function () {
            $loading.show();
            $ocLazyLoad.load(['task/stepMarkScale.js', 'task/formMark.js', 'task/formSysMark.js']).then(function (loaddata) {
                angular.copy([
                    {
                        title: '需求评分', src: 'task/stepMarkScale.html', onloadfunc: function () {
                            $scope.$broadcast("tomarkScale", $scope.stepdata.params_markScale);
                        }
                    },
                    {
                        title: '评分结果', src: 'task/formMark.html', onloadfunc: function () {
                            $scope.$broadcast("toMark", $scope.stepdata.params);
                        }
                    },
                    {
                        title: '系统计算分数', src: 'task/formSysMark.html', onloadfunc: function () {
                            $scope.$broadcast("toSysMark", $scope.stepdata.params);
                        }
                    },
                ], $scope.stepdata.flowStagePanels);
            });
        };
        $scope.loadingflow();

        //执行incluld的onload事件
        $scope.loadPanel = function (func) {
            if (angular.isFunction(func)) {
                func();
            }
        }

        $scope.applyclick = function (i) {
            if (i == 0) {
                $scope.$broadcast("tomarkScale", $scope.stepdata.params_markScale);
            } else if (i == 1) {
                $scope.$broadcast("toMark", $scope.stepdata.params);
            } else if (i == 2) {
                $scope.$broadcast("toSysMark", $scope.stepdata.params);
            }
        }

        $scope.pagechange = function () {
            $state.go('home.todolist');
        };
        //执行incluld的onload事件
        $scope.loadPanel = function (func) {
            if (angular.isFunction(func)) {
                func();
            }
        }

        $scope.upflow = function () {
            flowaudit.showaudit({
                appid: '',
                pid: $scope.flowdata.params.pid,
                fid: $scope.flowdata.params.fid,
                uid: AuthUser.getUser().DGUserID,
                onsuccess: $scope.pagechange
            });
        }
        //广播
        $scope.$on("toMarkManage", function (event, tar) {
            $scope.stepdata.params = tar;
            $scope.stepdata.params.FlowStep = 6;
        });
    });
})(angular);