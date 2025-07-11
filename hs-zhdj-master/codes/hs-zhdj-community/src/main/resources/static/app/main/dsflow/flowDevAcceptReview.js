(function ($app) {
    'use strict';
    $app.module('dsfapp').controller('flowDevAcceptReviewCtrl', function ($scope, $state, $alert, AuthUser, flowaudit, $ocLazyLoad, $loading) {
        $scope.flowdata = {
            flowStagePanels: [],
            activePanelids: [7, 8],
            params: $state.params,
            readonly: $state.params.st == 2,
            FlowStage: 6,//需求验收阶段
            params_demandSurvey: {},    //需求调研权限参数
            params_SysDesign: {},       //系统设计权限参数
            params_DevImpl: {},         //开发实施权限参数
            params_DevTest: {},         //系统测试权限参数
            params_DevAccept: {}         //系统验收权限参数
        };

        angular.extend($scope.flowdata.params, {
            readonly: $scope.flowdata.readonly,
            FlowStage: $scope.flowdata.FlowStage,
            readonly_Quantity: true,
            readonly_Mem: true,
            readonly_sysDuty: true,
            pictureUrl: '../../../DemandDevSelf/Content/images/flow.jpg'
        });

        angular.copy($scope.flowdata.params, $scope.flowdata.params_demandSurvey);
        $scope.flowdata.params_demandSurvey.readonly = true;
        angular.copy($scope.flowdata.params, $scope.flowdata.params_SysDesign);
        $scope.flowdata.params_SysDesign.readonly = true;
        angular.copy($scope.flowdata.params, $scope.flowdata.params_DevImpl);
        $scope.flowdata.params_DevImpl.readonly = true;
        angular.copy($scope.flowdata.params, $scope.flowdata.params_DevTest);
        $scope.flowdata.params_DevTest.readonly = true;
        angular.copy($scope.flowdata.params, $scope.flowdata.params_DevAccept);
        $scope.flowdata.params_DevAccept.readonly = true;

        //定义加载模块
        $scope.loadingflow = function () {
            $loading.show();
            $ocLazyLoad.load(['dsflow/stepDemandApply.js', 'dsflow/stepdemandSurvey.js', 'dsflow/stepDevSysDesign.js', 'dsflow/stepDevImplement.js', 'dsflow/stepDevTest.js', 'dsflow/appendStartTask.js', 'task/stepMarkManage.js', 'dsflow/appendDemandFlowStep.js']).then(function (loaddata) {
                angular.copy([
                    {title: '需求提出', src: 'dsflow/stepDemandApply.html'},
                    {
                        title: '需求调研', src: 'dsflow/stepdemandSurvey.html', onloadfunc: function () {
                            $scope.$broadcast("todemandSurvey", $scope.flowdata.params_demandSurvey);
                        }
                    },
                    {title: '系统设计', src: 'dsflow/stepDevSysDesign.html'},
                    {title: '开发实施', src: 'dsflow/stepDevImplement.html'},
                    {title: '系统测试', src: 'dsflow/stepDevTest.html'},
                    {
                        title: '需求验收', src: 'task/stepMarkManage.html', onloadfunc: function () {
                            $scope.$broadcast("toMarkManage", $scope.flowdata.params_DevAccept);
                        }
                    },
                    {title: '通知', src: 'dsflow/appendStartTask.html'},
                    {title: '附件', src: 'dsflow/appendDemandfiles.html'},
                    {title: '流程环节', src: 'dsflow/appendDemandFlowStep.html'}], $scope.flowdata.flowStagePanels);
            });
        };

        //定义文件实例
        $scope.flowdata.flowFileModel = {
            selectdata: {FileRefID: $state.params.fid, pageindex: 1, pagesize: 10, ptotal: 0},
            filetype: 2,
            items: [],
            readonly: $scope.flowdata.readonly//判断当前页面是否为已办
        };

        //执行incluld的onload事件
        $scope.loadPanel = function (func) {
            if (angular.isFunction(func)) {
                func();
            }
        }

        //执行incluld的onload事件
        $scope.loadPanel = function (func) {
            if (angular.isFunction(func)) {
                func();
            }
        }

        $scope.applyclick = function (i) {
            if (i == 0) {
                $scope.$broadcast("d_applyinit", $scope.flowdata.params_demandSurvey);
            } else if (i == 1) {
                $scope.$broadcast("todemandSurvey", $scope.flowdata.params_demandSurvey);
            } else if (i == 2) {
                $scope.$broadcast("todevSysDesign", $scope.flowdata.params_SysDesign);
            } else if (i == 3) {
                $scope.$broadcast("toDevImplement", $scope.flowdata.params_DevImpl);
            } else if (i == 4) {
                $scope.$broadcast("toDevTest", $scope.flowdata.params_DevTest);
            } else if (i == 5) {
                $scope.$broadcast("toMarkManage", $scope.flowdata.params_DevAccept);
            } else if (i == 6) {
                $scope.$broadcast("toStartTask", $scope.flowdata.params);
            }
        }

        $scope.pagechange = function () {
            //$state.go('home.todolist');
            window.history.back();
        };

        $scope.upflow = function () {
            flowaudit.showaudit({
                appid: '',
                pid: $scope.flowdata.params.pid,
                fid: $scope.flowdata.params.fid,
                uid: AuthUser.getUser().DGUserID,
                onsuccess: $scope.pagechange
            });
        }

        $scope.loadingflow();
    });
})(angular);