(function ($app) {
    'use strict';
    $app.module('dsfapp').controller('taskDevPlanCtrl', function ($scope, AuthUser, $state, $http, $modal, $alert, flowaudit) {


        $scope.params = {};
        $scope.copyfinddata = {};
        //参数设置  
        $scope.finddata = {
            DemandApplyID: $scope.DemandApplyID,
            pageindex: 1,
            pagesize: 10,
            total: 0,
            DWPid: ''
        };
        $scope.readonly = $state.params.st == 2;

        //监视页面的变化
        $scope.$watch("finddata.pageindex", function (newVal, oldVal) {
            if ($scope.finddata.total > 0) {
                $scope.loadItems($scope.params.fid);
            }
        });

        //判断是否可以提交开发计划
        $scope.isSubmit = function () {
            $http({
                url: "../../api/DemandFlow/CheckPlanFilled",
                method: 'get',
                contentType: 'application/json',
                params: {DemandApplyID: $scope.DemandApplyID}
            }).then(function (rq) {
                if (rq.data.success) {
                    alert("可以提交");
                } else {
                    alert("开发表单未完善");
                }
            });
        }
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
            if (e.TaskNote.length >= 30) {
                DModal.$scope.title = e.TaskName + "描述:";
                DModal.$scope.TaskNote = e.TaskNote;
                DModal.$promise.then(DModal.show);
            }

        };
        //新增或修改弹窗
        var workPlanCtrl = function ($scope, $http) {
            //流程id
            $scope.fid = $scope.params.fid;
            //需求id
            $scope.id = '';
            $scope.roleParams = $scope.fid + "+高级开发工程师" + "+初级开发工程师";
            //同步开发计划名称
            $scope.synchronized = function () {
                if ($scope.modal.SysDutyID != null) {
                    $scope.modal.TaskName = $scope.modal.SysDutyID.SysDutyName + "开发任务";
                }
            }
            //文本框文字输入限制控制,包括空格的限制,只截取前500字
            $scope.textLength = 500;
            $scope.changeText = function (length) {
                $scope.textLength = 500 - length;
                if ($scope.textLength < 0) {
                    $scope.textLength = 0;
                    $("#Note").val($scope.content.Note.slice(0, 501));
                }
            }

            //提交开发数据
            $scope.saveTaskPlan = function (e) {
                if (this.workPlanForm.$valid) {
                    $scope.modal.SysDutyID = $scope.modal.SysDutyID.SysDutyID;
                    $http({
                        url: "../../api/DemandFlow/saveDevWorkPlan",
                        method: 'POST',
                        contentType: 'application/json',
                        data: $scope.modal
                    }).then(function (rq) {
                        $scope.hidemodal();
                        $scope.loadItems($scope.params.fid);
                        $alert({
                            title: '计划',
                            content: rq.data.msg,
                            placement: 'top',
                            type: 'info',
                            show: true,
                            duration: 3
                        });
                    });
                }

            }
            //关闭弹窗
            $scope.hidemodal = function () {
                myModal.$promise.then(myModal.hide);
            }
        }
        workPlanCtrl.$inject = ['$scope', '$http', '$alert'];

        //模态框的设置
        var myModal = $modal({
            animation: "am-fade-and-slide-top",
            scope: $scope,
            controller: workPlanCtrl,
            templateUrl: '../js/template/modal_workplan.html',
            show: false,
            backdrop: false
        });
        //查找对应功能点
        $scope.filter = function (e, d) {
            for (var i = 0; i < e.length; i++) {
                if (e[i].SysDutyID == d.SysDutyID && e[i].SysDutyName == d.SysDutyName)
                    return e[i];
            }
        }
        //展示修改弹框
        $scope.showmodal = function (e) {
            if (e != null) {
                $http({
                    url: "../../api/DemandFlow/getSysDutyNameData",
                    method: 'GET',
                    contentType: 'application/json',
                    params: {DemandApplyID: $scope.DemandApplyID}
                }).then(function (rq) {
                    $scope.SysDutyName = rq.data.SysDutyNameData;
                });
                $scope.finddata.DWPid = e.DevWorkPlanID;
                angular.copy($scope.finddata, $scope.copyfinddata);
                angular.extend($scope.copyfinddata, {userid: $scope.task.TaskerID});
                $http({
                    url: "../../api/DemandFlow/getDevWorkPlanList",
                    method: 'GET',
                    contentType: 'application/json',
                    params: $scope.copyfinddata
                }).then(function (rq) {
                    $scope.finddata.DWPid = '';
                    $scope.modal = rq.data.items[0];
                    $scope.modal.SysDutyID = $scope.filter($scope.SysDutyName, $scope.modal);
                    $scope.title = "修改";
                });

            }
            myModal.$promise.then(myModal.show);
        }
        //获取开发计划
        $scope.loadItems = function (fid) {
            $http({
                url: "../../api/DemandFlow/getDemandApplyID", method: 'get', params: {
                    id: "",
                    fid: fid,
                    userid: '',
                }
            }).then(function (rq) {
                $scope.DemandApplyID = rq.data.items;
                $scope.finddata.DemandApplyID = $scope.DemandApplyID;
                angular.copy($scope.finddata, $scope.copyfinddata);
                angular.extend($scope.copyfinddata, {userid: $scope.task.TaskerID});
                $http({
                    url: "../../api/DemandFlow/getDevWorkPlanList",
                    method: 'GET',
                    params: $scope.copyfinddata
                }).then(function (rq) {
                    $scope.items = rq.data.items;
                    $scope.finddata.total = rq.data.total;
                    $loading.hide();
                    //$scope.DemandApplyID = rq.data.items[0].DemandApplyID;
                });
            });

        }


        //接收广播信息
        $scope.$on("toTaskDevPlan", function (event, tar) {
            $scope.params = tar;
            if (angular.isUndefined($scope.items)) {
                $scope.loadItems($scope.params.fid);
            }

        });
    });

})(angular);