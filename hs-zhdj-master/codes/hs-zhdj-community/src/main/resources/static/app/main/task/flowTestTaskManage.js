(function ($app) {
    'use strict';
    $app.module('dsfapp').controller('testTaskManageCtrl', function ($scope, $state, $alert, AuthUser, flowaudit, $http, $ocLazyLoad) {
        $scope.flowdata = {
            flowStagePanels: [],
            activePanelids: [0, 1, 5],
            params: $state.params,
            readonly: $state.params.st == 2 || $state.params.ft != 2
        };
        angular.extend($scope.flowdata.params, {pictureUrl: '../../../DemandDevSelf/Content/images/ExecTestPlan.jpg'});
        var flowparams = {
            showBtnExec: false,//是否显示执行测试计划按钮
            readonly_InternalTest: $scope.flowdata.readonly || $scope.flowdata.params.ft != 2,//内部测试是否只读
            readonly_FuncTest: true,//功能测试是否只读
            showAllForm: false//是否显示内部测试和功能测试
        }
        //定义加载模块
        $scope.loadingflow = function () {
            $ocLazyLoad.load(['task/form_taskhandle.js', 'dsflow/formDevTestProblem.js', 'dsflow/appendDemandFlowStep.js']).then(function (loaddata) {
                $scope.flowdata.flowStagePanels = [
                    {
                        title: '测试任务', src: 'task/form_taskhandle.html', onloadfunc: function () {
                            $http({
                                url: "../../api/DevelopmentTask/FindTaskByfid",
                                method: 'GET',
                                params: {fid: $scope.flowdata.params.fid}
                            }).then(function (rq) {
                                $scope.task = rq.data.item;
                                $scope.task.TaskerName = rq.data.TaskName;
                                $scope.task.TypeValue = rq.data.Tasktype;
                                $scope.task.CurUrl = rq.data.CurUrl;
                            })
                        }
                    },
                    {
                        title: '测试问题', src: 'dsflow/formDevTestProblem.html', onloadfunc: function () {
                            $scope.$broadcast("toDevTestProblem", angular.extend($scope.flowdata.params, flowparams));
                        }
                    },
                    {title: '任务流程环节', src: 'dsflow/appendDemandFlowStep.html'}];
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
            //if (i == 0) {
            //    $scope.$broadcast("todevelopmentTask", $scope.flowdata.params);
            //} else if (i == 1) {
            //    $scope.$broadcast("toTaskReport", $scope.flowdata.params);
            //} else if (i == 2) {
            //    $scope.$broadcast("toSysDutyManage", $scope.flowdata.params);
            //}

        }
        //返回主流程
        $scope.toMainFlow = function () {
            // open("#!/" + $scope.tasker.CurUrl);
            window.location.href = "#!/" + $scope.task.CurUrl;
        };

        $scope.pagechange = function () {
            window.history.back();
            //$state.go('home.todolist');
        };
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
        $scope.vali = [];
        $scope.ExecTestTaskValidate = function () {
            $http({
                url: "../../api/SubmitValidate/ExecTestTaskValidate", method: 'get',
                params: {
                    fid: $scope.flowdata.params.fid, ft: $scope.flowdata.params.ft
                }
            }).then(function (rq) {
                if (rq.data.success) {
                    $scope.saveQuantity();
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
        $scope.saveQuantity = function () {
            $http({url: "../../api/Task/saveRealQuantity", method: 'Post', data: $scope.task}).then(function (rq) {
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

            });
        }
        $scope.upflow = function () {
            if ($scope.change()) {
                //提交验证是否所有BUG处理完成;
                $scope.ExecTestTaskValidate();
            } else if ($scope.flowdata.params.ft != 2) {
                flowaudit.showaudit(option);
            }
        }

        $scope.loadingflow();
    });
})(angular);