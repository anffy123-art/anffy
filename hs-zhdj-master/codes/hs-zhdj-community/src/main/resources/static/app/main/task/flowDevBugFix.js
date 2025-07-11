(function ($app) {
    'use strict';
    $app.module('dsfapp').controller('bugfixCtrl', function ($scope, $state, $alert, AuthUser, flowaudit, $http, $ocLazyLoad, $loading) {
        $scope.flowdata = {
            flowStagePanels: [],
            activePanelids: [0, 1, 2],
            params: $state.params,
            flowFileModel: {
                selectdata: {FileRefID: $state.params.fid, pageindex: 1, pagesize: 10, ptotal: 0},
                filetype: 2,
                items: [],
                fileList: [],
                folderlist: []
            },
            readonly: $state.params.st == 2 || $state.params.ft != 2
        };
        angular.extend($scope.flowdata.params, {
            readonly: $scope.flowdata.readonly,
            pictureUrl: '../../../DemandDevSelf/Content/images/BugFix.jpg'
        });
        //定义加载模块
        $scope.loadingflow = function () {
            $loading.show();
            $ocLazyLoad.load(['task/form_taskhandle.js', 'task/form_TaskReport.js', 'task/form_buginfo.js', 'dsflow/appendDemandFlowStep.js']).then(function (loaddata) {
                angular.copy([{
                    title: '修复任务', src: 'task/form_taskhandle.html', onloadfunc: function () {
                        $http({
                            url: "../../api/DevelopmentTask/FindTaskByfid",
                            method: 'GET',
                            params: {fid: $scope.flowdata.params.fid}
                        }).then(function (rq) {
                            $scope.task = rq.data.item;
                            $scope.task.TaskerName = rq.data.TaskName;
                            $scope.task.TypeValue = rq.data.Tasktype;
                        })
                    }
                },
                    {title: '问题详情', src: 'task/form_buginfo.html'},
                    {
                        title: '修复报告', src: 'task/form_TaskReport.html', onloadfunc: function () {
                            $scope.$broadcast("toTaskReport", $scope.flowdata.params);
                        }
                    },
                    {title: '流程环节', src: 'dsflow/appendDemandFlowStep.html'}], $scope.flowdata.flowStagePanels);
            });
        };

        //执行incluld的onload事件
        $scope.loadPanel = function (func) {
            if (angular.isFunction(func)) {
                func();
            }
        }
        $scope.pagechange = function () {
            window.history.back();
            //$state.go('home.todolist');
        };

        $scope.$on('bugitem', function (event, data) {
            $scope.bugitem = data;
        });
        $scope.isShow = false;
        $scope.change = function () {
            if ((angular.isNumber(this.task.RealQuantity) && this.task.RealQuantity > 0)) {
                $scope.isShow = false;
                return true;
            } else {
                $scope.isShow = true && !$scope.flowdata.readonly;
                return false;
            }
        };
        $scope.upflow = function () {
            //显示流程处理环节框的参数
            var option = {
                pid: $scope.flowdata.params.pid,
                fid: $scope.flowdata.params.fid,
                uid: AuthUser.getUser().DGUserID,
                onsuccess: $scope.pagechange
            };
            if ($scope.change()) {
                //将实际工作量保存到任务基础表
                $http({url: "../../api/Task/saveRealQuantity", method: 'Post', data: $scope.task}).then(function (rq) {
                    flowaudit.showaudit(option);
                });
            } else if ($scope.flowdata.params.ft != 2) {
                flowaudit.showaudit(option);
            }
        }

        $scope.loadingflow();
    });
})(angular);