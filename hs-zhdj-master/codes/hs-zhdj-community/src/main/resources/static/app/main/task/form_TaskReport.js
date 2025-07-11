(function ($app) {
    'use strict';
    $app.module('dsfapp').controller('TaskReportCtrl', function ($scope, $http, $modal, $rootScope, $alert, AuthUser) {
        $scope.TaskReportLists = [];

        //分页参数设置  
        $scope.finddata = {
            pageindex: 1,
            pagesize: 5,
            ptotal: 0
        };
        //监测页面变化
        $scope.$watch("finddata.pageindex", function (newVal, oldVal) {
            if ($scope.finddata.ptotal > 0) {
                $scope.getTaskReportLists($scope.flowdata.params.fid);
            }
        })

        //根据工作流fid找到对应的任务报告相应的数据
        $scope.getTaskReportLists = function (id) {
            $http({
                url: "../../api/DevelopmentTask/getTaskReportlist",
                method: 'GET',
                params: {
                    fid: id,
                    pageIndex: $scope.finddata.pageindex,
                    pageSize: $scope.finddata.pagesize
                }
            })
                .then(function (rq) {
                    //console.log(rq.data.msg);
                    $scope.TaskReportLists = rq.data.items;
                    $scope.finddata.ptotal = rq.data.total;
                }, function (rq) {
                    alert("获取失败");
                });
        }
        $scope.getTaskReportLists($scope.flowdata.params.fid);

        //弹窗的更改
        var MyEditModalController = function ($scope, $http) {
            $scope.params = myModal.params;
            $scope.content = myModal.params.content;

            //进度条控制
            $scope.myFunc = function (progress) {
                $scope.content.text = true;
                $scope.content.progress = progress;
                if (progress > 100) {
                    $scope.content.progress = 100;
                }
                if (progress < 0) {
                    $scope.content.progress = 0;
                }
            }

            //文本框文字输入限制控制,包括空格的限制,只截取前200字
            $scope.textLength = 200;
            $scope.changeText = function (length) {
                if (length == undefined) {
                    length = 0;
                }
                $scope.textLength = 200 - length;
                if ($scope.textLength < 0) {
                    $scope.textLength = 0;
                    $("#Note").val($scope.content.Note.slice(0, 201));
                }
            }
            //$scope.changeText();
            //获取单个开发任务报告明细
            $scope.loadTaskbase = function () {
                $http.get("../../api/DevelopmentTask/getTaskReport", {params: {'TRid': $scope.params.TaskReportID}}).then(function (result) {
                    //console.log(result);
                    $scope.content = result.data.items;
                    $scope.content.ReportDate = result.data.extdata;
                    $scope.myFunc(result.data.items.Progress);
                    $scope.changeText(result.data.items.Note.length);
                }, function () {
                    $alert({title: '提示：', content: "服务器错误", placement: 'top', type: 'info', show: true, duration: 3});
                });
            }

            //在新增的时候获取同一个任务下的最大的报告的进度
            $scope.getOneMaxProcess = function () {
                $http.get("../../api/DevelopmentTask/getOneMaxProcess",
                    {
                        params: {
                            "fid": $scope.flowdata.params.fid,
                            "uid": AuthUser.getUser().DGUserID
                        }
                    }).then(function (result) {
                    $scope.content.Progress = result.data.items;
                    $scope.myFunc(result.data.items);
                }, function () {
                    $alert({title: '提示：', content: "服务器错误", placement: 'top', type: 'info', show: true, duration: 3});
                });
            };

            //判断是否需要加载关于任务报告明细的数据
            $scope.isLoad = function () {
                if ($scope.params.title == "任务报告编辑") {
                    $scope.loadTaskbase();
                } else {
                    $scope.getOneMaxProcess();
                }
            }
            $scope.isLoad();
            //保存工作报告
            $scope.saveTaskReport = function (flag) {
                if (flag) {
                    $http({
                        url: "../../api/DevelopmentTask/SaveTaskReport",
                        method: 'post',
                        data: {
                            "TaskReport": $scope.content,
                            "ReportDate": $scope.content.ReportDate,
                            "fid": $scope.flowdata.params.fid,
                        }
                    }).then(function (res) {
                        //console.log(res);
                        if (res.data == "保存成功") {
                            $scope.$hide();
                            $scope.getTaskReportLists($scope.flowdata.params.fid);
                            $scope.showalert("保存成功");
                        } else {
                            $scope.$hide();
                            $scope.getTaskReportLists($scope.flowdata.params.fid);
                            $scope.showalert("添加任务报告失败");
                        }
                    }, function (res) {
                        $scope.showalert("服务器错误");
                    });
                }
            };
        }
        MyEditModalController.$inject = ['$scope', '$http'];

        //新增或者编辑工作报告 模拟框
        var myModal = $modal({
            scope: $scope, resolve: {
                load: ['$ocLazyLoad', function ($ocLazyLoad) {
                    $ocLazyLoad.load('../devselfflow/task/form_TaskReport.css');
                    return true;
                }]
            },
            templateUrl: 'task/editTaskReport.html',
            controller: MyEditModalController,
            show: false,
            animation: 'am-fade-and-slide-top'
        });
        //打开新增任务报告模拟框
        $scope.savemodal = function () {
            myModal.content = {};
            myModal.params = {
                title: "任务报告新增",
                content: {
                    TaskReportID: "",
                    TaskbaseID: "",
                    Progress: "",
                    Note: "",
                    ReportDate: ""
                }
            }
            myModal.$promise.then(myModal.show);
        }

        //打开任务报告编辑模拟框
        $scope.editmodal = function (TRid) {
            myModal.params = {
                title: "任务报告编辑",
                content: {},
                TaskReportID: TRid,
            }
            myModal.$promise.then(myModal.show);
        }

        $scope.showalert = function (data) {
            $alert({title: '提示：', content: data, placement: 'top', type: 'info', show: true, duration: 2});
        };

        //删除单个任务报告
        $scope.deletetTaskReport = function (TaskReportID) {
            if (!confirm("确认删除?")) {
                return;
            }
            $.ajax({
                url: "../../api/DevelopmentTask/deleteTaskReport",
                data: {TaskReportID: TaskReportID},
                type: 'get',
                contentType: 'application/json',
                success: function (res) {
                    //console.log(res);
                    $scope.getTaskReportLists($scope.flowdata.params.fid);
                    $scope.showalert("删除成功");
                },
                error: function (res) {
                    console.log(res);
                }
            });

        };

        //广播
        $scope.$on("toTaskReport", function (event, tar) {
            $scope.params = tar;
            if (angular.isUndefined($scope.item)) {
                $scope.getTaskReportLists($scope.params.fid);
            }

        });
    });
})(angular);