(function ($app) {
    'use strict';
    $app.module('dsfapp').controller('formStartTaskCtrl', function ($scope, $state, $http, $modal, $alert, $window) {
        //分页参数
        $scope.page = {
            id: '',
            fid: '',
            userid: '',
            pageIndex: 1,
            pageSize: 10,
            totalCount: 0,
            TaskbaseID: ''
        }
        //接收广播信息
        $scope.$on("toStartTask", function (event, tar) {
            $scope.params = tar;
            $scope.page.fid = $scope.params.fid
            $scope.loadItem();
            //if (angular.isUndefined($scope.items)) {
            //    $scope.loadItem();
            //}

        });
        //监视页数变化
        $scope.$watch("page.pageIndex", function (newVal, oldVal) {
            if ($scope.page.totalCount > 0) {
                $scope.loadItem();
            }
        });
        var DetailCtrl = function ($scope, $http) {

        }
        //模态框的设置
        var DModal = $modal({
            animation: "am-fade-and-slide-top",
            scope: $scope,
            controller: DetailCtrl,
            templateUrl: '../js/template/modal_taskDetail.html',
            show: false
        });
        $scope.showDetail = function (e) {
            if (e.TaskNote != null && e.TaskNote.length >= 50) {
                DModal.$scope.title = "任务描述:";
                DModal.$scope.TaskNote = e.TaskNote;
                DModal.$promise.then(DModal.show);
            }

        };
        //加载列表
        $scope.loadItem = function () {
            $http({url: "../../api/Task/getTask", method: 'GET', params: $scope.page}).then(function (rq) {
                $scope.items = rq.data.items;
                $scope.page.totalCount = rq.data.total;
                $scope.DemandApplyID = rq.data.extdata;//获取需求ID
            });
        };
        //修改任务
        $scope.editTask = function (e) {
            //获取某条数据
            $http({
                url: "../../api/Task/FindTaskByfid",
                method: 'GET',
                params: {id: e.TaskbaseID, fid: ""}
            }).then(function (rq) {
                $scope.model = rq.data.item;
                $scope.model.TaskerName = rq.data.TaskerName;
                $scope.model.FlowStage = $scope.$parent.flowdata.FlowStage;
                //flag:1.修改 0.新增 2.查看
                myTModal.$scope.flag = 1;
                myTModal.$promise.then(myTModal.show);
            });

        };
        //删除任务
        $scope.deleteTask = function (e) {

            if (confirm("您确认要删除此通知?")) {
                $http({url: "../../api/Task/deleteTask", method: 'GET', params: {TaskbaseID: e}}).then(function (rq) {
                    if (rq.data.success) {
                        $alert({
                            title: '通知',
                            content: rq.data.msg,
                            placement: 'top',
                            type: 'info',
                            show: true,
                            duration: 3
                        });
                    } else {
                        $alert({
                            title: '通知',
                            content: rq.data.msg,
                            placement: 'top',
                            type: 'error',
                            show: true,
                            duration: 3
                        });
                    }
                    $scope.loadItem();
                });
            }
        };
        //任务发起弹窗
        var missionStartCtrl_Parent = function ($scope, $http) {
            //$scope.fid = myTModal.fid;

            $scope.pagechange = function () {
                $scope.page.pageIndex = 1;
                $scope.page.totalCount = 0;
                myTModal.$promise.then(myTModal.hide);
                $scope.$parent.loadItem();
            }
        }
        missionStartCtrl_Parent.$inject = ['$scope', '$http'];

        var myTModal = $modal({
            resolve: {
                load: ['$ocLazyLoad', function ($ocLazyLoad) {
                    return $ocLazyLoad.load('task/modal_missionStart.js');
                }]
            },
            scope: $scope,
            animation: "am-fade-and-slide-top",
            controller: missionStartCtrl_Parent,
            templateUrl: 'task/modal_missionStart.html',
            show: false,
            backdrop: false,
            keyboard: false
        });

        //任务发起
        $scope.ToMission = function () {
            myTModal.$scope.flag = 0;
            myTModal.$scope.DemandApplyID = $scope.DemandApplyID;
            myTModal.$scope.FlowStage = $scope.$parent.flowdata.FlowStage
            myTModal.$promise.then(myTModal.show);
        }

        //任务查看
        //preParams:页面参数
        $scope.check = function (e) {
            //var preParams;
            // angular.copy(angular.extend($scope.params, { name: $state.current.name }), preParams);
            //if (e.TypeNumber == 1 || e.TypeNumber == 2) {
            //    $state.go("home.missionhandler", { fid: e.FlowID, pid: e.FlowPid, st: 2, preParams: angular.extend($scope.params, { name: $state.current.name }) });
            //} else {
            //    $state.go("home.developmentTaskManage", { fid: e.FlowID, pid: e.FlowPid, st: 2, preParams: angular.extend($scope.params, { name: $state.current.name }) });
            //}

            switch (e.TypeNumber) {
                case 1:
                    $state.go("home.missionhandler", {
                        fid: e.FlowID,
                        pid: e.FlowPid,
                        st: 2,
                        preParams: angular.extend($scope.params, {name: $state.current.name})
                    });
                    break;
                case 2:
                    $state.go("home.missionhandler", {
                        fid: e.FlowID,
                        pid: e.FlowPid,
                        st: 2,
                        preParams: angular.extend($scope.params, {name: $state.current.name})
                    });
                    break;
                case 3:
                    $state.go("home.ImplTestPlan", {
                        fid: e.FlowID,
                        pid: e.FlowPid,
                        st: 2,
                        ft: 3,
                        preParams: angular.extend($scope.params, {name: $state.current.name})
                    });
                    break;
                case 4:
                    $state.go("home.developmentTaskManage", {
                        fid: e.FlowID,
                        pid: e.FlowPid,
                        st: 2,
                        preParams: angular.extend($scope.params, {name: $state.current.name})
                    });
                    break;
                case 7:
                    $state.go("home.testTaskManage", {
                        fid: e.FlowID,
                        pid: e.FlowPid,
                        st: 2,
                        ft: 3,
                        preParams: angular.extend($scope.params, {name: $state.current.name})
                    });
                    break;
                default:
                    $state.go("home.missionhandler", {
                        fid: e.FlowID,
                        pid: e.FlowPid,
                        st: 2,
                        preParams: angular.extend($scope.params, {name: $state.current.name})
                    });
            }
        }
    });
})(angular);