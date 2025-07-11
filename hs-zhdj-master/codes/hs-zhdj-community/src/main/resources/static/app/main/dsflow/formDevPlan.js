(function ($app) {
    'use strict';
    $app.module('dsfapp').controller('formDevPlanCtrl', function ($scope, $location, AuthUser, $state, $http, $modal, $alert, flowaudit, $loading) {

        $scope.formdata = {
            finddata: {
                DemandApplyID: $scope.DemandApplyID,
                pageindex: 1,
                pagesize: 10,
                total: 0,
                DWPid: ''
            },
            ft: $state.params.df,
            params: {},
            copyfinddata: {}
        }

        //监视页面的变化
        $scope.$watch("formdata.finddata.pageindex", function (newVal, oldVal) {
            if ($scope.formdata.finddata.total > 0) {
                $scope.loadItems($scope.formdata.params.fid);
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
                    alert("开发表单未完善或者未派送");
                }
            });
        }
        //var DetailCtrl = function ($scope, $http) {

        //}
        ////模态框的设置
        //var DModal = $modal({ animation: "am-fade-and-slide-top", scope: $scope, controller: DetailCtrl, templateUrl: '../js/template/modal_taskDetail.html', show: false });
        //$scope.showDetail = function (e) {
        //    if (e.TaskNote.length >= 30)
        //    {
        //        DModal.$scope.title = e.TaskName + "描述:";
        //        DModal.$scope.TaskNote = e.TaskNote;
        //        DModal.$promise.then(DModal.show);
        //    }

        //};
        //新增或修改弹窗
        var workPlanCtrl = function ($scope, $http) {
            //流程id
            $scope.fid = $scope.formdata.params.fid;
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
                if (length == undefined) {
                    length = 0;
                }
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
                        $scope.loadItems($scope.formdata.params.fid);
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
                $scope.formdata.finddata.DWPid = e.DevWorkPlanID;
                angular.copy($scope.formdata.finddata, $scope.formdata.copyfinddata);
                angular.extend($scope.formdata.copyfinddata, {userid: ""});
                $http({
                    url: "../../api/DemandFlow/getDevWorkPlanList",
                    method: 'GET',
                    contentType: 'application/json',
                    params: $scope.formdata.copyfinddata
                }).then(function (rq) {
                    $scope.formdata.finddata.DWPid = '';
                    $scope.modal = rq.data.items[0];
                    $scope.modal.SysDutyID = $scope.filter($scope.SysDutyName, $scope.modal);
                    myModal.$scope.title = "修改";
                });

            }
            myModal.$promise.then(myModal.show);
        }

        //输入开发计划预计完成时间弹窗
        var Ft1_inputTimeCtrl = function () {
            $scope.title = "发起开发计划实施:";
            $scope.sendTask = function (e, d) {
                if (this.Dateform.$valid) {
                    $http({
                        url: "../../api/Task/sendDevtask",
                        method: 'get',
                        params: {
                            DemandApplyID: $scope.DemandApplyID,
                            CreateID: AuthUser.getUser().DGUserID,
                            ExpectFinishDate: e,
                            ExpectQuantity: d,
                            FlowStage: $scope.formdata.params.FlowStage
                        }
                    }).then(function (rq) {
                        $alert({
                            title: '消息',
                            content: rq.data.msg,
                            placement: 'top',
                            type: 'info',
                            show: true,
                            duration: 3
                        });
                        Ft1_inputTimeModal.$promise.then(Ft1_inputTimeModal.hide);
                    });
                }


            };

        }

        var Ft1_inputTimeModal = $modal({
            animation: "am-fade-and-slide-top",
            scope: $scope,
            controller: Ft1_inputTimeCtrl,
            templateUrl: '../js/template/modal_inputExpectFinishDate.html',
            show: false,
            backdrop: false
        });

        //派发开发计划任务给高层
        $scope.sendToSenior = function (e) {
            Ft1_inputTimeModal.$scope.flag = e;
            Ft1_inputTimeModal.$scope.DemandApplyID = $scope.DemandApplyID;
            $http({
                url: "../../api/Task/WhetherCouldSendToSenior",
                method: 'get',
                params: {DemandApplyID: $scope.DemandApplyID}
            }).then(function (rq) {
                if (rq.data.success) {
                    Ft1_inputTimeModal.$scope.Quantity_flag = true;

                    Ft1_inputTimeModal.$promise.then(Ft1_inputTimeModal.show);
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
        };

        //输入开发实施预计完成时间弹窗
        var Ft2_inputTimeCtrl = function () {
            $scope.title = "发起开发实施任务:";
            $scope.sendTask = function (e, d) {
                //$scope.ExpectQuantity = parseInt("1");
                if (this.Dateform.$valid) {
                    $http({
                        url: "../../api/DemandFlow/sendTask",
                        method: 'get',
                        params: {
                            DemandApplyID: $scope.DemandApplyID,
                            ExpectFinishDate: e,
                            ExpectQuantity: d,
                            FlowStage: $scope.formdata.params.FlowStage,
                            CreateID: AuthUser.getUser().DGUserID
                        }
                    }).then(function (rq) {
                        if (rq.data.failCount == 0) {
                            $alert({
                                title: '消息',
                                content: '全部发起成功！',
                                placement: 'top',
                                type: 'info',
                                show: true,
                                duration: 3
                            });
                        } else {
                            alert("发起成功：" + rq.data.successCount + "条<br/> 发起失败：" + rq.data.failCount + "条<br/>");
                        }
                        Ft2_inputTimeModal.$promise.then(Ft2_inputTimeModal.hide);
                        $scope.loadItems($scope.formdata.params.fid);
                    });
                }


            };

        }

        var Ft2_inputTimeModal = $modal({
            animation: "am-fade-and-slide-top",
            scope: $scope,
            controller: Ft2_inputTimeCtrl,
            templateUrl: '../js/template/modal_inputExpectFinishDate.html',
            show: false,
            backdrop: false
        });


        //一键派发开发任务--初级工程师
        $scope.sendToJunior = function () {
            //判断是否有可以派发的任务 
            $http({
                url: "../../api/DemandFlow/WhetherCouldSend",
                method: 'get',
                params: {DemandApplyID: $scope.DemandApplyID, CreateID: AuthUser.getUser().DGUserID}
            }).then(function (rq) {
                if (rq.data.items.length > 0) {
                    Ft2_inputTimeModal.$scope.Quantity_flag = true;
                    Ft2_inputTimeModal.$promise.then(Ft2_inputTimeModal.show);
                } else {
                    $alert({
                        title: '消息',
                        content: '无可以发起的开发实施任务',
                        placement: 'center',
                        type: 'info',
                        show: true,
                        duration: 3
                    });
                }
            });

        }
        //开发计划任务查看
        //preParams:页面参数
        $scope.check = function (e) {
            // FindTaskbyPlanID
            $http({
                url: "../../api/Task/FindTaskbyPlanID",
                method: 'get',
                params: {DevWorkPlanID: e.DevWorkPlanID}
            }).then(function (rq) {
                if (rq.data.success) {
                    var data = rq.data.items;
                    $state.go("home.developmentTaskManage", {
                        fid: data.FlowID,
                        pid: data.FlowPid,
                        st: 2,
                        preParams: angular.extend($scope.formdata.params, {name: $state.current.name})
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
        //获取开发计划
        $scope.loadItems = function (fid) {
            $loading.show();
            $http({
                url: "../../api/DemandFlow/getDemandApplyID", method: 'get', params: {
                    id: "",
                    fid: fid,
                    userid: '',
                }
            }).then(function (rq) {
                $scope.DemandApplyID = rq.data.items;
                $scope.formdata.finddata.DemandApplyID = $scope.DemandApplyID;
                angular.copy($scope.formdata.finddata, $scope.formdata.copyfinddata);
                angular.extend($scope.formdata.copyfinddata, {userid: ""});
                $http({
                    url: "../../api/DemandFlow/getDevWorkPlanList",
                    method: 'GET',
                    params: $scope.formdata.copyfinddata
                }).then(function (rq) {
                    $scope.items = rq.data.items;
                    $scope.formdata.finddata.total = rq.data.total;
                    $loading.hide();
                    //$scope.DemandApplyID = rq.data.items[0].DemandApplyID;
                });
            });

        }


        //接收广播信息
        $scope.$on("toDevPlan", function (event, tar) {
            $scope.formdata.params = tar;
            $scope.title = $scope.formdata.params.df < 3 ? "制定开发计划" : "开发计划实施";
            if (angular.isUndefined($scope.items)) {
                $scope.loadItems($scope.formdata.params.fid);
            }

        });
    });

})(angular);