(function ($app) {
    'use strict';
    $app.module('dsfapp').controller('devTestDataCtrl', function ($scope, $state, $alert, AuthUser, flowaudit, $ocLazyLoad, $http) {
        $scope.flowdata = {
            flowStagePanels: [],
            activePanelids: [4, 7],
            params: $state.params,
            readonly: $state.params.st == 2,
            FlowStage: 5,//系统测试阶段
            params_demandSurvey: {},//需求调研权限参数
            params_SysDesign: {},//需求调研权限参数
            params_DevImpl: {},
            params_DevTest: {},//系统测试权限参数
        };

        angular.extend($scope.flowdata.params, {
            readonly: $scope.flowdata.readonly,
            FlowStage: $scope.flowdata.FlowStage,
            readonly_Mem: true,
            readonly_Quantity: true,
            readonly_sysDuty: true,
            pictureUrl: '../../../DemandDevSelf/Content/images/flow.jpg'
        });

        angular.copy($scope.flowdata.params, $scope.flowdata.params_demandSurvey);
        $scope.flowdata.params_demandSurvey.readonly = true;
        angular.copy($scope.flowdata.params, $scope.flowdata.params_SysDesign);
        $scope.flowdata.params_SysDesign.readonly = true;
        angular.copy($scope.flowdata.params, $scope.flowdata.params_DevImpl);
        $scope.flowdata.params_DevImpl.readonly = true;
        //定义加载模块
        $scope.loadingflow = function () {
            $ocLazyLoad.load(['dsflow/stepDemandApply.js', 'dsflow/stepdemandSurvey.js', 'dsflow/stepDevSysDesign.js', 'dsflow/stepDevImplement.js', 'dsflow/appendStartTask.js', 'dsflow/stepDevTest.js', 'dsflow/appendDemandFlowStep.js']).then(function (loaddata) {
                angular.copy([{
                    title: '需求提出', src: 'dsflow/stepDemandApply.html'
                },
                    {
                        title: '需求调研', src: 'dsflow/stepdemandSurvey.html'
                    },
                    {title: '系统设计', src: 'dsflow/stepDevSysDesign.html'},
                    {
                        title: '开发实施', src: 'dsflow/stepDevImplement.html', onloadfunc: function () {
                            $scope.$broadcast("toDevImplement", $scope.flowdata.params_DevImpl);
                        }
                    },
                    {
                        title: '系统测试', src: 'dsflow/stepDevTest.html', onloadfunc: function () {
                            $scope.$broadcast("toDevTest", $scope.flowdata.params);
                        }
                    },
                    {title: '通知消息', src: 'dsflow/appendStartTask.html'},
                    {title: '附件', src: 'dsflow/appendDemandfiles.html'},
                    {title: '流程环节', src: 'dsflow/appendDemandFlowStep.html'}], $scope.flowdata.flowStagePanels);
            });
        };
        //执行incluld的onload事件
        $scope.loadPanel = function (func) {
            if (angular.isFunction(func)) {
                func();
            }
        }
        //定义文件实例
        $scope.flowdata.flowFileModel = {
            selectdata: {FileRefID: $state.params.fid, pageindex: 1, pagesize: 10, ptotal: 0},
            filetype: 2,
            items: [],
            readonly: $scope.flowdata.readonly//判断当前页面是否为已办
        };

        $scope.applyclick = function (i) {
            if (i == 0) {
                //需求提出
                $scope.$broadcast("d_applyinit", $scope.flowdata.params_demandSurvey);
            } else if (i == 1) {
                //需求调研
                $scope.$broadcast("todemandSurvey", $scope.flowdata.params_demandSurvey);
            } else if (i == 2) {
                //系统设计
                $scope.$broadcast("todevSysDesign", $scope.flowdata.params_SysDesign);
            } else if (i == 3) {
                //开发实施
                $scope.$broadcast("toDevImplement", $scope.flowdata.params_DevImpl);
            } else if (i == 5) {
                $scope.$broadcast("toStartTask", $scope.flowdata.params);
            }
        }
        $scope.vali = [];
        $scope.FunctTestValidate = function () {
            $http({
                url: "../../api/SubmitValidate/FunctTestFinishedValidate", method: 'get',
                params: {
                    fid: $scope.flowdata.params.fid, FlowStage: $scope.flowdata.FlowStage, ft: $scope.flowdata.params.ft
                }
            }).then(function (rq) {
                if (rq.data.success) {
                    flowaudit.showaudit({
                        appid: '',
                        pid: $scope.flowdata.params.pid,
                        fid: $scope.flowdata.params.fid,
                        uid: AuthUser.getUser().DGUserID,
                        onsuccess: $scope.pagechange
                    });
                } else {
                    $alert({
                        title: "错误：",
                        content: rq.data.msg,
                        placement: 'center',
                        type: 'info',
                        show: true,
                        duration: 3
                    });
                }
            }, function (ex) {
                $alert({title: "错误：", content: '服务器错误', placement: 'center', type: 'info', show: true, duration: 3});
            });
        }

        $scope.pagechange = function () {
            window.history.back();
            //$state.go('home.todolist');
        };

        $scope.upflow = function () {
            $scope.FunctTestValidate();
        }

        $scope.loadingflow();
    });
})(angular);