(function ($app) {
    'use strict';
    $app.module('dsfapp').controller('devTestPlanTaskCtrl', function ($scope, $state, $alert, AuthUser, flowaudit, $http, $ocLazyLoad, $loading) {
        $scope.flowdata = {
            flowStagePanels: [],
            activePanelids: [0, 1],
            params: $state.params,
            readonly: $state.params.st == 2
        };
        angular.extend($scope.flowdata.params, {pictureUrl: '../../../DemandDevSelf/Content/images/TestPlan.jpg'});
        $scope.urls = {
            putNextUrl: '../../api/Flow/putNextSteps',
            saveDevTestPlanUrl: '../../api/DevTest/saveDevTestPlan',
            getNextFlowInfoUrl: '../../api/Flow/getFlowNextInfo',
        };

        //定义加载模块
        $scope.loadingflow = function () {
            $loading.show();
            $http({
                url: "../../api/DevelopmentTask/FindTaskByfid",
                method: 'GET',
                params: {fid: $scope.flowdata.params.fid}
            }).then(function (rq) {
                $scope.mainUrl = rq.data.CurUrl;
            });
            $ocLazyLoad.load(['task/form_taskinfo.js', 'task/form_devTestPlan.js', 'dsflow/appendDemandFlowStep.js']).then(function (loaddata) {
                $scope.flowdata.flowStagePanels = [
                    {
                        title: '测试计划任务', src: 'task/form_taskinfo.html', onloadfunc: function () {
                            $scope.$broadcast("todevelopmentTask", angular.extend($scope.flowdata.params, {readonly: $scope.flowdata.readonly}));
                        }
                    },
                    {title: '测试计划', src: 'task/form_devTestPlan.html'}, {
                        title: '任务流程环节',
                        src: 'dsflow/appendDemandFlowStep.html'
                    }];
            });
        };
        //执行incluld的onload事件
        $scope.loadPanel = function (func) {
            if (angular.isFunction(func)) {
                func();
            }
        }

        $scope.toMainFlow = function () {
            // open("#!/" + $scope.tasker.CurUrl);
            window.location.href = "#!/" + $scope.mainUrl;
        };

        //取消页面回退
        $scope.pagechange = function () {
            $state.go('home.todolist');
        };

        //接收testPlanList
        $scope.$on('testPlanList', function (event, data) {
            //data里有{stopwatch(注销watch的方法),testPlanList(测试计划集合)}
            $scope.testPlanList = data.testPlanList;
            //注销watch
            //$scope.stopwatch = data.stopwatch;
        });

        //判断是否所有测试计划都分配了负责人
        $scope.isAllAssign = function (list) {
            var count = 0;
            angular.forEach(list, function (item) {
                if (item.TestUserID != null && angular.isDefined(item.TestUserID)) {
                    count++;
                }
            })
            if (count == list.length) {
                return true;
            } else {
                return false;
            }
        };

        //遍历集合获得userid字符串
        $scope.getUsers = function (list) {
            var newlist = [];
            angular.forEach(list, function (item) {
                if ($.inArray($scope.idtrim(item.TestUserID), newlist) == -1) {
                    newlist.push($scope.idtrim(item.TestUserID));
                }
            });
            return newlist.join(',');
        }
        //进入下一步
        $scope.tonextstep = function () {
            var nextStepOption = {
                ActionID: $scope.actionid,
                Comment: '测试计划任务分配',
                ProcessID: $state.params.pid,
                Users: $scope.getUsers($scope.testPlanList),
                Workby: AuthUser.getUser().DGUserID
            }
            console.log(nextStepOption);//测试
            $http({
                method: 'GET', url: $scope.urls.putNextUrl,
                params: nextStepOption
            }).then(function (rq) {
                $alert({
                    title: '消息',
                    content: rq.data.msg,
                    placement: 'center',
                    type: 'success',
                    show: true,
                    duration: 3
                });
                if (rq.data.success) {
                    $scope.pagechange();
                }

            });
        }
        //保存负责人
        $scope.saveDevTestPlan = function (aftersuccessfun) {
            $http.post($scope.urls.saveDevTestPlanUrl, {
                'list': $scope.testPlanList,
                'opr': 'updateUser',
                'param': ''
            }).then(function (rq) {
                if (rq.data.success) {
                    //进入下个流程
                    if (angular.isFunction(aftersuccessfun)) {
                        aftersuccessfun();
                    } else {
                        $alert({
                            title: '错误',
                            content: '没有成功回调方法',
                            placement: 'center',
                            type: 'success',
                            show: true,
                            duration: 3
                        });
                    }
                }
            });
        }


        //加载下一步骤信息
        $scope.loadflow = function () {
            $http({
                method: 'GET',
                url: $scope.urls.getNextFlowInfoUrl,
                params: {ProcessID: $state.params.pid, afuns: ''}
            }).then(function (rq) {
                if (rq.data.success) {
                    $scope.actionid = rq.data.data.nextactions[0].actionid;
                } else {
                    $alert({
                        title: '消息',
                        content: rq.data.msg,
                        placement: 'centre',
                        type: 'info',
                        show: true,
                        duration: 3
                    });
                }
            });
        };
        $scope.loadflow();
        $scope.loadingflow();

        //保存实际工作量
        $scope.isShow = false;
        $scope.change = function () {
            $scope.task = this.task;
            if (angular.isNumber(this.task.RealQuantity) && this.task.RealQuantity > 0) {
                $scope.isShow = false;
            } else {
                $scope.isShow = true;
            }

        };
        $scope.upflow = function () {
            if (($scope.isShow == false && angular.isDefined($scope.task))) {
                //将实际工作量保存到任务基础表
                $http({url: "../../api/Task/saveRealQuantity", method: 'Post', data: $scope.task}).then(function (rq) {
                    if ($scope.isAllAssign($scope.testPlanList)) {
                        $scope.saveDevTestPlan($scope.tonextstep);
                    } else {
                        $alert({
                            title: '消息',
                            content: '每项计划都必须分配一个负责人',
                            placement: 'center',
                            type: 'success',
                            show: true,
                            duration: 3
                        });
                    }
                });
            } else {
                $scope.isShow = true;
            }
        }

        //去除两头空格
        $scope.idtrim = function (userid) {
            return userid.replace(/^\s+|\s+$/g, "");
        }
    });
})(angular);