(function ($app) {
    'use strict';
    $app.module('dsfapp').controller('flowDevelopmentTaskManageCtrl', function ($scope, $stateParams, $loading, $ocLazyLoad, $state, $alert, AuthUser, flowaudit, $http) {
        $scope.flowdata = {
            flowStagePanels: []
            , activePanelids: [0, 1, 2],
            params: $state.params,
            readonly: $state.params.st == 2
        };
        if ($state.params.tm == 2) {
            $scope.flowdata.readonly = true;
            $scope.flowdata.readonly_submit = false;
        } else {
            $scope.flowdata.readonly_submit = $scope.flowdata.readonly;
        }

        angular.extend($scope.flowdata.params, {
            readonly: $scope.flowdata.readonly,
            pictureUrl: '../../../DemandDevSelf/Content/images/Development.jpg'
        })

        //定义加载模块
        $scope.loadingflow = function () {
            $loading.show();

            $http({
                url: "../../api/Task/FindTaskByfid",
                method: 'GET',
                params: {id: "", fid: $scope.flowdata.params.fid}
            }).then(function (rq) {
                $scope.tasker = rq.data.item;
                $scope.tasker.CurUrl = rq.data.CurUrl;
            });

            $ocLazyLoad.load(['task/form_taskinfo.js', 'task/form_developemntSys.js', 'task/form_TaskReport.js', 'dsflow/stepDevImplement.js', 'dsflow/appendStartTask.js', 'dsflow/stepDevTest.js', 'dsflow/appendDemandFlowStep.js']).then(function (loaddata) {
                angular.copy(
                    [{
                        title: '开发任务', src: 'task/form_taskinfo.html', onloadfunc: function () {
                            $scope.$broadcast("todevelopmentTask", $scope.flowdata.params);
                        }
                    }, {
                        title: '开发计划', src: 'task/form_developemntSys.html', onloadfunc: function () {
                            $scope.$broadcast("todevelopmentSys", $scope.flowdata.params);
                        }
                    },
                        {
                            title: '报告', src: 'task/form_TaskReport.html', onloadfunc: function () {
                                $scope.$broadcast("toTaskReport", $scope.flowdata.params);
                            }
                        },
                        {title: '任务流程环节', src: 'dsflow/appendDemandFlowStep.html'}], $scope.flowdata.flowStagePanels);
            });
        };

        $scope.loadingflow();


        $scope.applyclick = function (i) {
            if (i == 0) {
                $scope.$broadcast("todevelopmentTask", $scope.flowdata.params);
            } else if (i == 1) {
                $scope.$broadcast("todevelopmentSys", $scope.flowdata.params);
            } else if (i == 2) {
                $scope.$broadcast("toTaskReport", $scope.flowdata.params);
            }

        }
        //执行incluld的onload事件
        $scope.loadPanel = function (func) {
            if (angular.isFunction(func)) {
                func();
            }
        }
        $scope.pagechange = function () {
            //将实际工作量保存到任务基础表
            $http({url: "../../api/Task/saveRealQuantity", method: 'Post', data: $scope.tasker}).then(function (rq) {
            });
            window.history.back()
            //if ($stateParams.preParams != null) {
            //    $state.go($stateParams.preParams.name, { fid: $stateParams.preParams.fid, pid: $stateParams.preParams.pid, st: $stateParams.preParams.st });
            //} else {
            //    $state.go('home.todolist');
            //}
        };
        $scope.toMainFlow = function () {
            // open("#!/" + $scope.tasker.CurUrl);
            window.location.href = "#!/" + $scope.tasker.CurUrl;
        };
        $scope.isShow = false;
        $scope.change = function () {
            $scope.tasker.RealQuantity = this.task.RealQuantity;
            if (angular.isNumber($scope.tasker.RealQuantity) && $scope.tasker.RealQuantity > 0) {
                $scope.isShow = false;
            } else {
                $scope.isShow = true;
            }

        };
        $scope.upflow = function () {
            if (angular.isNumber($scope.tasker.RealQuantity) && $scope.tasker.RealQuantity > 0) {

                flowaudit.showaudit({
                    appid: '',
                    pid: $scope.flowdata.params.pid,
                    fid: $scope.flowdata.params.fid,
                    uid: AuthUser.getUser().DGUserID,
                    onsuccess: $scope.pagechange
                });
            } else {
                $scope.isShow = true;
            }
        }
    });
})(angular);