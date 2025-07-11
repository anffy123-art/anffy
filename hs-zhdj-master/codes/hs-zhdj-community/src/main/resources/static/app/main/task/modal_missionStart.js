(function ($saga_mission) {
    'use strict';
    $saga_mission.module('dsfapp').controller('missionStartCtrl', function ($scope, $http, $q, $state, $loading, $alert, AuthUser, flowaudit) {
        $scope.title = "任务发起";
        $scope.flag = $scope.$parent.flag;
        $scope.fid = $state.params.fid;
        $scope.id = '';
        $scope.activePanelids = [0, 1];
        $scope.TaskTypes = [];
        $scope.FlowStage = $scope.$parent.FlowStage;


        $scope.init = function () {
            //获取任务类型的数据
            $http({
                url: "../../api/Comm/GetDictionaryListByDicType",
                method: 'GET',
                params: {DicTypeKey: "MissionStart_TaskType"}
            }).then(function (rq) {
                $scope.TaskTypes = rq.data;
                //flag:1.修改 0.新增
                if ($scope.flag != 0) {
                    $scope.model = $scope.$parent.model;
                    $scope.model.TypeValue = Tfilter($scope.TaskTypes, $scope.model.TaskType, 'DicKey').DicValue;

                } else {
                    //新增
                    $http({
                        url: "../../api/Task/FindTaskByfid",
                        method: 'GET',
                        params: {id: "", fid: ""}
                    }).then(function (rq) {
                        $scope.model = rq.data.item;
                        $scope.model.TaskType = 1;
                        $scope.model.TaskerName = rq.data.TaskerName;
                        $scope.model.RefID = $scope.DemandApplyID;
                        $scope.model.FlowStage = $scope.FlowStage;
                        $scope.model.DelegateAddFile = true;
                        $scope.model.TypeValue = Tfilter($scope.TaskTypes, $scope.model.TaskType, 'DicKey').DicValue;
                        $scope.appid = rq.data.appid;
                    });
                }
            });
        }
        //文本框文字输入限制控制,包括空格的限制,只截取前500字
        $scope.textLength = 500;
        $scope.changeText = function (length) {
            if (length == undefined) {
                length = 0;
            }
            $scope.textLength = 500 - length;
            if ($scope.textLength <= 0) {
                $scope.textLength = 0;
                $("#Note").val($scope.content.Note.slice(0, 501));
            }
        }
        //查询函数
        var Tfilter = function (e, d, f) {
            var len = $scope.TaskTypes.length;
            for (var j = 0; j < len; j++) {
                // var e={};
                if (e[j][f] == d) {
                    return e[j]
                }
            }
        }
        $scope.DemandTitle = "普通任务";

        $scope.save = function (isUpflow, Form) {
            Form.$submitted = true;
            if (this.missionForm.$valid) {
                $http({url: "../../api/Task/saveTask", method: 'POST', data: $scope.model}).then(function (rq) {
                    if (rq.data.success) {
                        $scope.model.CreatorID = AuthUser.getUser().DGUserID;
                        $scope.model.TaskbaseID = rq.data.extdata;
                        if (isUpflow) {
                            if (confirm('你确定要发起任务吗？')) {
                                $scope.Upflow($scope.model.TaskbaseID);
                            }
                        } else {
                            $alert({
                                title: '消息',
                                content: rq.data.msg,
                                placement: 'top',
                                type: 'success',
                                show: true,
                                duration: 3
                            });
                        }
                    } else {
                        $alert({
                            title: '消息',
                            content: rq.data.msg,
                            placement: 'top',
                            type: 'error',
                            show: true,
                            duration: 3
                        });
                    }
                    //if (!isUpflow)
                    //{
                    //    $scope.$parent.pagechange();
                    //}


                });
            }

        };
        $scope.Upflow = function (e) {
            $http({
                url: "../../api/Task/sendCommTask",
                method: 'GET',
                params: {TaskbaseID: e, CreateID: AuthUser.getUser().DGUserID}
            }).then(function (rq) {
                $alert({title: '消息', content: rq.data.msg, placement: 'top', type: 'success', show: true, duration: 3});
                $scope.$parent.pagechange();
            });
        };
        $scope.init();
    });
})(angular);