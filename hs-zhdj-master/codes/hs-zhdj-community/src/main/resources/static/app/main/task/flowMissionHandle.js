(function ($app) {
    'use strict';
    $app.module('dsfapp').controller('flowMissionHandlerCtrl', function ($rootScope, $loading, $scope, $location, $state, $stateParams, $alert, AuthUser, flowaudit, $http, $ocLazyLoad) {
        $scope.flowdata = {
            flowStagePanels: []
            , activePanelids: [0, 1, 2, 3, 4, 5], params: $state.params
            , flowFileModel: {
                selectdata: {FileRefID: $state.params.fid, pageindex: 1, pagesize: 10, ptotal: 0},
                filetype: 2,
                items: [],
                fileList: [],
                folderlist: []

            },
            readonly: $state.params.st == 2,    //标志位：true为只读 ，false 为可编辑
            mianfid: '',//主流程id
            FlowStage: '',
            DemandApplyID: '',
            paramsWork: {}
        };
        if ($state.params.mh == 2 && $scope.flowdata.readonly == false) {
            $scope.flowdata.readonly = true;
            $scope.flowdata.readonly_submit = false;
        } else {
            $scope.flowdata.readonly_submit = $scope.flowdata.readonly;
        }
        //if ($stateParams.preParams != null) {
        //    $scope.flowdata.paramsWork.FlowStep = $stateParams.preParams.FlowStep;
        //    $scope.flowdata.paramsWork.fid = $scope.flowdata.mianfid;
        //}


        $scope.dutyIds = ['4CD8A1BA-BA48-4515-A712-A83B00C363B0', '809E6ABE-5D35-4273-9F60-A8390140021C']
        $scope.getTaskType = function () {
            $http({
                url: "../../api/Comm/GetDictionaryListByDicType",
                method: 'GET',
                params: {DicTypeKey: "MissionStart_TaskType"}
            }).then(function (rq) {
                $scope.TaskTypes = rq.data;
            });
        };

        $scope.loadItem = function (id) {
            $loading.hide();
            $ocLazyLoad.load(['task/form_taskhandle.js', 'dsflow/formSysDutyManage.js', 'dsflow/formQuantityOfWork.js', 'task/taskDevPlan.js', 'dsflow/formDevTestProblem.js', 'task/form_TaskReport.js', 'dsflow/appendDemandFlowStep.js']).then(function (loaddata) {
                $http({
                    url: "../../api/Task/FindTaskByfid",
                    method: 'GET',
                    params: {id: "", fid: id}
                }).then(function (rq) {
                    $scope.task = rq.data.item;
                    $scope.task.TaskerName = rq.data.TaskerName;
                    $scope.task.CurUrl = rq.data.CurUrl;
                    $scope.task.TypeValue = Tfilter($scope.TaskTypes, $scope.task.TaskType, 'DicKey').DicValue;
                    $scope.flowdata.flowStagePanels.push({title: '任务处理', src: 'task/form_taskhandle.html'});
                    //console.log(rq.data.msg);
                    angular.extend($scope.flowdata.params, {pictureUrl: '../../../DemandDevSelf/Content/images/comm.jpg'});
                    if ($scope.task.DelegateDuty) {
                        $scope.flowdata.flowStagePanels.push({
                            title: '功能点', src: 'dsflow/formSysDutyManage.html', onloadfunc: function () {

                                $scope.$broadcast('toSysDutyManage', $scope.flowdata.paramsWork);
                            }
                        });
                        angular.forEach($scope.dutyIds, function (value) {
                            $http({
                                url: "../../api/Task/FindFilebyID",
                                method: 'GET',
                                params: {fileid: value}
                            }).then(function (rq) {
                                $scope.flowdata.flowFileModel.fileList.push(rq.data.items);

                            })
                        })

                    }
                    if ($scope.task.DelegateQuantityOfWork) {
                        $scope.flowdata.flowStagePanels.push({
                            title: '工作量', src: 'dsflow/formQuantityOfWork.html', onloadfunc: function () {
                                //用来加载一开始就展示的页面
                                $scope.$broadcast("toQuantityOfWork", $scope.flowdata.paramsWork);
                            }
                        });
                    }
                    if ($scope.task.DelegateWorkPlan) {
                        angular.extend($scope.flowdata.params, {pictureUrl: '../../../DemandDevSelf/Content/images/Development.jpg'});
                        $scope.flowdata.flowStagePanels.push({
                            title: '开发计划', src: 'task/taskDevPlan.html', onloadfunc: function () {
                                $scope.$broadcast("toTaskDevPlan", $scope.flowdata.paramsWork);
                            }
                        });
                    }
                    if ($scope.task.DelegateDevTestData) {
                        $scope.flowdata.flowStagePanels.push({title: '测试问题', src: 'dsflow/formDevTestProblem.html'});
                    }
                    if ($scope.task.DelegateAddFile) {
                        $scope.flowdata.flowStagePanels.push({title: '附件', src: 'dsflow/appendDemandfiles.html'});
                        angular.forEach($scope.dutyIds, function (value) {
                            $http({
                                url: "../../api/Task/FindFilebyID",
                                method: 'GET',
                                params: {fileid: value}
                            }).then(function (rq) {
                                $scope.flowdata.flowFileModel.folderlist.push(rq.data.items);

                            })
                        })
                    }
                    //$scope.flowdata.flowStagePanels.push({
                    //    title: '报告', src: 'task/form_TaskReport.html', onloadfunc: function () {
                    //        //用来加载一开始就展示的页面
                    //        $scope.$broadcast("toTaskReport", $scope.flowdata.params);
                    //    }
                    //});
                    $scope.flowdata.flowStagePanels.push({
                        title: '流程环节', src: 'dsflow/appendDemandFlowStep.html', onloadfunc: function () {

                            // $scope.$broadcast('toSysDutyManage', $scope.flowdata.params);
                        }
                    });
                    $loading.hide();
                });
            });
        };
        $scope.getMainFid = function (id) {
            $loading.show();
            $http({
                url: "../../api/DemandFlow/getDemandApplyID",
                method: 'GET',
                params: {id: "", fid: id, userid: ''}
            }).then(function (rq) {
                $scope.flowdata.DemandApplyID = rq.data.items;
                $scope.flowdata.mianfid = rq.data.extdata.FlowID;
                $scope.flowdata.FlowStage = rq.data.extdata.FlowStage;

                angular.extend($scope.flowdata.params, {
                    readonly: $scope.flowdata.readonly,
                    mainfid: $scope.flowdata.mianfid
                });
                //工作量
                angular.copy($scope.flowdata.params, $scope.flowdata.paramsWork);
                $scope.flowdata.paramsWork.fid = $scope.flowdata.mianfid;
                $scope.flowdata.paramsWork.FlowStage = $scope.flowdata.FlowStage;
                $scope.flowdata.paramsWork.readonly_Quantity = $scope.flowdata.readonly;
                //定义文件实例
                $scope.flowdata.flowFileModel = {
                    selectdata: {FileRefID: $scope.flowdata.paramsWork.fid, pageindex: 1, pagesize: 10, ptotal: 0},
                    filetype: 2,
                    items: [],
                    readonly: $scope.flowdata.readonly//判断当前页面是否为已办
                };

                $scope.loadItem($state.params.fid);
            });
        }
        $scope.toMainFlow = function () {
            //open("#!/"+$scope.task.CurUrl);
            window.location.href = "#!/" + $scope.task.CurUrl;
        };
        //执行incluld的onload事件
        $scope.loadPanel = function (func) {
            if (angular.isFunction(func)) {
                func();
            }
        }

        var Tfilter = function (e, d, f) {
            var len = $scope.TaskTypes.length;
            for (var j = 0; j < len; j++) {
                // var e={};
                if (e[j][f] == d) {
                    return e[j]
                }
            }
        }

        if ($state.params.fid != null) {

        }

        $scope.applyclick = function (i) {
            if (i == "任务处理") {
                $scope.$broadcast("toTaskManage", $scope.flowdata.params);
            } else if (i == "功能点") {
                $scope.$broadcast("toSysDutyManage", $scope.flowdata.params);
            } else if (i == "工作量") {
                $scope.$broadcast("toQuantityOfWork", $scope.flowdata.paramsWork);
            } else if (i == "开发计划") {
                $scope.$broadcast("toTaskDevPlan", $scope.flowdata.paramsWork);
            }
            //else if (i == "报告") {
            // $scope.$broadcast("toTaskReport", $scope.flowdata.params);
            //}

        }

        $scope.pagechange = function () {
            $http({url: "../../api/Task/saveRealQuantity", method: 'Post', data: $scope.task}).then(function (rq) {
            });
            window.history.back()
            //if ($stateParams.preParams!=null) {
            //    $state.go($stateParams.preParams.name, {
            //        fid: $stateParams.preParams.fid, pid: $stateParams.preParams.pid, st: $stateParams.preParams.st,
            //        df: $stateParams.preParams.df, sd: $stateParams.preParams.sd, ds: $stateParams.preParams.ds,
            //        me2: $stateParams.preParams.me2, qu2: $stateParams.preParams.qu2, du2: $stateParams.preParams.du2,
            //        qu3: $stateParams.preParams.qu3,
            //        qu4: $stateParams.preParams.qu4, dp4: $stateParams.preParams.dp4, fr: $stateParams.preParams.fr
            //    });
            //} else {
            //    $state.go('home.todolist');
            //}
        };

        $scope.isShow = false;
        $scope.change = function () {
            if (angular.isNumber($scope.task.RealQuantity) && $scope.task.RealQuantity > 0) {
                $scope.isShow = false;
            } else {
                $scope.isShow = true;
            }

        };
        $scope.upflow = function () {
            if (angular.isNumber($scope.task.RealQuantity) && $scope.task.RealQuantity > 0) {
                if ($scope.task.DelegateWorkPlan) {
                    $http({
                        url: "../../api/SubmitValidate/TaskPlanValidate",
                        method: 'get',
                        params: {DemandApplyID: $scope.flowdata.DemandApplyID, userid: $scope.task.TaskerID}
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
                                title: '消息',
                                content: rq.data.msg,
                                placement: 'center',
                                type: 'info',
                                show: true,
                                duration: 3
                            });
                        }
                    });
                } else {
                    flowaudit.showaudit({
                        appid: '',
                        pid: $scope.flowdata.params.pid,
                        fid: $scope.flowdata.params.fid,
                        uid: AuthUser.getUser().DGUserID,
                        onsuccess: $scope.pagechange
                    });
                }
            } else {
                $scope.isShow = true;
            }
        };

        $scope.getTaskType();
        $scope.getMainFid($state.params.fid);
    });
})(angular);


