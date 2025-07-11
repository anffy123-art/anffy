(function ($app) {
    'use strict';
    $app.module('dsfapp').controller('flowDevelopOndoingCtrl', function ($scope, $state, $http, $location, $alert, AuthUser, flowaudit, $ocLazyLoad, $loading) {
        $scope.flowdata = {
            flowStagePanels: [],
            activePanelids: [3, 5, 6],
            params: $state.params,
            readonly: $state.params.st == 2,
            FlowStage: 4,
            params_demandSurvey: {},//需求调研权限参数
            params_SysDesign: {},//需求调研权限参数
            params_DevImpl: {},    //开发实施权限参数
            urlparams: {
                me2: $state.params.st == 2 ? true : $state.params.me2 == Ascii(17, 8) ? false : true,//项目团队参数
                qu2: $state.params.st == 2 ? true : $state.params.qu2 == Ascii(18, 8) ? false : true,//工作量参数
                du2: $state.params.st == 2 ? true : $state.params.du2 == Ascii(19, 8) ? false : true,//功能点参数
                qu3: $state.params.st == 2 ? true : $state.params.qu3 == Ascii(18, 8) ? false : true,//工作量参数
                qu4: $state.params.st == 2 ? true : $state.params.qu4 == Ascii(18, 8) ? false : true,//工作量参数
                dp4: $state.params.st == 2 ? true : $state.params.dp4 == Ascii(20, 8) ? false : true,//工作量参数
                re: $state.params.st == 2 ? true : $state.params.re == 1 ? true : false,//是否为评审阶段
            }

        };

        // 十进制转二进制
        function Ascii(num, Bits) {
            var resArry = num.toString(2).split("");
            if (Bits) {
                for (var r = resArry.length; r < Bits; r++) {
                    resArry.unshift(0)
                }
            }
            //console.log(resArry.join().replace(/,/g, ''));
            return resArry.join().replace(/,/g, '')
        }

        //定义文件实例
        $scope.flowdata.flowFileModel = {
            selectdata: {FileRefID: $state.params.fid, pageindex: 1, pagesize: 10, ptotal: 0},
            filetype: 2,
            items: [],
            readonly: $scope.flowdata.readonly//判断当前页面是否为已办
        };

        angular.extend($scope.flowdata.params, {
            readonly: $scope.flowdata.readonly,
            FlowStage: $scope.flowdata.FlowStage,
            readonly_Quantity: $scope.flowdata.urlparams.qu4,
            readonly_Task: $scope.flowdata.urlparams.re,
            pictureUrl: '../../../DemandDevSelf/Content/images/flow.jpg'
        });

        angular.copy($scope.flowdata.params, $scope.flowdata.params_demandSurvey);
        angular.extend($scope.flowdata.params_demandSurvey, {
            readonly: true,
            FlowStage: $scope.flowdata.FlowStage,
            readonly_Mem: $scope.flowdata.urlparams.me2,
            readonly_Quantity: $scope.flowdata.urlparams.qu2,
            readonly_sysDuty: $scope.flowdata.urlparams.du2
        });

        // $scope.flowdata.params_demandSurvey.readonly = true;

        angular.copy($scope.flowdata.params, $scope.flowdata.params_SysDesign);
        angular.extend($scope.flowdata.params_SysDesign, {
            readonly: true,
            FlowStage: $scope.flowdata.FlowStage,
            readonly_Quantity: $scope.flowdata.urlparams.qu3
        });

        //$scope.flowdata.params_SysDesign.readonly = true;
        angular.copy($scope.flowdata.params, $scope.flowdata.params_DevImpl);


        //定义加载模块
        $scope.loadingflow = function () {
            $loading.show();
            $ocLazyLoad.load(['dsflow/stepDemandApply.js', 'dsflow/stepdemandSurvey.js', 'dsflow/stepDevSysDesign.js', 'dsflow/stepDevImplement.js', 'dsflow/appendStartTask.js', 'dsflow/appendDemandFlowStep.js']).then(function (loaddata) {
                angular.copy([
                    {
                        title: '需求提出', src: 'dsflow/stepDemandApply.html'
                    },
                    {
                        title: '需求调研', src: 'dsflow/stepdemandSurvey.html', onloadfunc: function () {
                            //$scope.$broadcast("todemandSurvey", $scope.flowdata.params);
                        }
                    },
                    {title: '系统设计', src: 'dsflow/stepDevSysDesign.html'},
                    {
                        title: '开发实施', src: 'dsflow/stepDevImplement.html', onloadfunc: function () {
                            $scope.$broadcast("toDevImplement", $scope.flowdata.params);
                        }
                    },
                    {title: '任务', src: 'dsflow/appendStartTask.html'},
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


        $scope.applyclick = function (i) {
            if (i == 0) {
                $scope.$broadcast("d_applyinit", $scope.flowdata.params_demandSurvey);
            } else if (i == 1) {
                //$scope.flowdata.params.readonly = true;
                $scope.$broadcast("todemandSurvey", $scope.flowdata.params_demandSurvey);
            } else if (i == 2) {
                //$scope.flowdata.params.readonly = true;
                $scope.$broadcast("todevSysDesign", $scope.flowdata.params_SysDesign);
            } else if (i == 3) {
                $scope.$broadcast("toDevImplement", $scope.flowdata.params);
            } else if (i == 4) {
                $scope.$broadcast("toStartTask", $scope.flowdata.params);
            }
        }

        $scope.pagechange = function () {
            //$state.go('home.todolist');
            window.history.back();
        };


        $scope.upflow = function () {
            $http({
                url: "../../api/SubmitValidate/StepValidate", method: 'get', contentType: 'application/json',
                params: {
                    fid: $scope.flowdata.params.fid, FlowStage: $scope.flowdata.FlowStage, ft: $scope.flowdata.params.df
                }
            }).then(function (rq) {
                if (rq.data.success) {
                    $http({
                        url: "../../api/Task/WheatherSendTestPlan",
                        method: 'get',
                        contentType: 'application/json',
                        params: {fid: $scope.flowdata.params.fid, CreateID: AuthUser.getUser().DGUserID}
                    }).then(function (rq) {
                        if (rq.data.success) {
                            flowaudit.showaudit({
                                appid: '',
                                pid: $scope.flowdata.params.pid,
                                fid: $scope.flowdata.params.fid,
                                uid: AuthUser.getUser().DGUserID,
                                onsuccess: $scope.pagechange
                            });
                        }
                    });
                } else {
                    $alert({
                        title: '消息',
                        content: rq.data.msg,
                        placement: 'center',
                        type: 'info',
                        show: true,
                        duration: 3
                    });
                }


            });

        }

        $scope.loadingflow();
    });
})(angular);