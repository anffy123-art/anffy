(function ($app) {
    'use strict';
    //var app = .module('dsfapp', [['dsflow/saveQuantityOfWorkModal.js']]);
    $app.module('dsfapp').controller('formQuantityOfWorkCtrl', function ($scope, $http, $modal, $alert, $rootScope, $loading) {
        //$scope.item = null;
        $scope.QuantityOfWorklist = [];
        //人员选择
        $scope.selectedID = '';
        $scope.selectedName = '';
        $scope.selectedDataUsers = [];
        $scope.selectedGuids = '';
        $scope.params = {};//参数实体
        $scope.paramsQuabtity = {};
        //分页参数设置  
        $scope.finddata = {
            pageindex: 1,
            pagesize: 10,
            ptotal: 0
        };
        //监测页面变化
        $scope.$watch("finddata.pageindex", function (newVal, oldVal) {
            if ($scope.finddata.ptotal > 0) {
                $scope.getQuantityOfWorkList($scope.flowdata.params.fid);
            }
        });

        //获取工作流工作量列表
        $scope.getQuantityOfWorkList = function (id) {
            if ($scope.params.mainfid != undefined) {
                id = $scope.params.mainfid;
            }
            $http({
                url: "../../api/QuantityOfWork/getQuantityOfWorklist",
                method: 'GET',
                params: {
                    fid: id,
                    FlowStage: $scope.params.FlowStage,
                    pageIndex: $scope.finddata.pageindex,
                    pageSize: $scope.finddata.pagesize
                }
            })
                .then(function (rq) {
                    //console.log(rq.data.msg);
                    $scope.QuantityOfWorkLists = rq.data.items;
                    $scope.totalQuantity = rq.data.extdata;
                    $scope.finddata.ptotal = rq.data.total;
                }, function (rq) {
                    alert("获取失败");
                });
            $loading.hide();
        }
        //$scope.getQuantityOfWorkList($scope.flowdata.params.fid);

        //弹窗的更改
        var MyEditModalController = function ($scope, $http) {
            $scope.paramsQuabtity = myModal.params;
            $scope.content = myModal.params.content;


            //获取工作量类型信息
            $scope.getDicValue = function () {
                $http({
                    method: "GET",
                    url: "../../api/Comm/GetDictionaryListByDicType",
                    params: {
                        DicTypeKey: "QuantityOfWork_WorkType"
                    }
                }).then(function (result) {
                    $scope.DicValueList = result.data;
                    if ($scope.paramsQuabtity.title == "工作量编辑") {
                        $scope.loadQuantityOfWork();
                    } else {
                        if ($scope.content.FlowStage <= 2) {
                            $scope.content.WorkType = 1;
                        } else if (2 < $scope.content.FlowStage <= 3) {
                            $scope.content.WorkType = 2;
                        }
                    }
                }, function (resp) {
                    alert("获取工作量类型信息失败");
                });
            }
            $scope.getDicValue();

            //获取单个工作量明细
            $scope.loadQuantityOfWork = function () {
                $http.get("../../api/QuantityOfWork/getQuantityOfWork", {
                    params: {
                        'Qid': $scope.paramsQuabtity.QuantityOfWorkID,
                        'Did': $scope.paramsQuabtity.DemandApplyID
                    }
                }).then(function (result) {
                    console.log(result);
                    $scope.content = result.data.items;
                    $scope.content.Name = result.data.extdata.Name;
                    $scope.content.roleName = result.data.extdata.roleName;
                    //$scope.content.selectedID = result.data.items.UserID;
                }, function () {
                    $alert({title: '提示：', content: "服务器错误", placement: 'top', type: 'info', show: true, duration: 3});
                });
            };
            $scope.change = function () {
                //监测人员变化更改对应的角色
                $scope.$watch("content.Name", function (newVal, oldVal) {
                        if (newVal != oldVal) {
                            if ($scope.params.mainfid != undefined) {
                                $scope.flowdata.params.fid = $scope.params.mainfid;
                            }
                            $http.get("../../api/MemManage/FindMemeberRolesdata",
                                {
                                    params:
                                        {
                                            'aid': $scope.flowdata.params.fid + '+' + $scope.content.UserID,
                                            'findkey': "",
                                            'pageIndex': $scope.finddata.pageindex,
                                            'pageSize': $scope.finddata.pagesize
                                        }
                                }).then(function (result) {
                                console.log(result);
                                if (result.data.items.length == 1) {
                                    $scope.content.roleName = result.data.items[0].label;
                                    $scope.content.QWorkRoleID = result.data.items[0].val;
                                } else {
                                    $scope.content.roleName = "";
                                }
                            }, function () {
                                $alert({
                                    title: '提示：',
                                    content: "服务器错误",
                                    placement: 'top',
                                    type: 'info',
                                    show: true,
                                    duration: 3
                                });
                            });
                        }
                        ;
                    }
                );
            }

            //保存工作量
            $scope.saveQuantityOfWork = function (flag) {
                if (flag) {
                    $http({
                        url: "../../api/QuantityOfWork/SaveQuantityOfWork",
                        method: 'post',
                        data: {
                            "QuantityOfWork": $scope.content,
                            "fid": $scope.params.fid,
                            //"selectedID": $scope.content.selectedID,
                            //"RoleID":$scope.content.RoleID
                        }
                    }).then(function (res) {
                        //console.log(res);
                        if (res.data.success) {
                            $scope.$hide();
                            $scope.getQuantityOfWorkList($scope.params.fid);
                            $scope.showalert(res.data.msg);
                        } else {
                            $scope.$hide();
                            $scope.getQuantityOfWorkList($scope.params.fid);
                            $scope.showalert(res.data.msg);
                        }
                    }, function (res) {
                        $scope.showalert("添加工作量失败");
                    });
                }
            };
        }
        MyEditModalController.$inject = ['$scope', '$http'];

        //新增或者编辑工作量 模拟框
        var myModal = $modal({
            scope: $scope,
            templateUrl: 'dsflow/editQuantityOfWorkModal.html',
            controller: MyEditModalController,
            show: false,
            animation: 'am-fade-and-slide-top'
        });
        //打开新增角色模拟框
        $scope.savemodal = function () {
            myModal.content = {};
            // myModal.content.FlowStage = $scope.params.FlowStage;
            myModal.params = {
                title: "工作量新增",
                content: {
                    QuantityOfWorkID: "",
                    DemandApplyID: "",
                    UserID: "",
                    RoleId: "",
                    WorkType: "",
                    FlowStage: $scope.params.FlowStage
                },
                fid: $scope.params.fid
            }
            myModal.$promise.then(myModal.show);
        }

        //打开工作量编辑模拟框
        $scope.editmodal = function (Qid, Did) {
            myModal.params = {};
            angular.extend(myModal.params, {
                title: "工作量编辑",
                content: {Name: ""},
                QuantityOfWorkID: Qid,
                DemandApplyID: Did,
                fid: $scope.params.fid
            });
            myModal.$promise.then(myModal.show);
        }

        $scope.showalert = function (data) {
            $alert({title: '提示：', content: data, placement: 'center', type: 'info', show: true, duration: 2});
        };

        //删除单个工作量
        $scope.deletetQuantityOfWork = function (QuantityOfWorkID) {
            if (!confirm("确认删除?")) {
                return;
            }
            $.ajax({
                url: "../../api/QuantityOfWork/deleteQuantityOfWork",
                data: {QuantityOfWorkID: QuantityOfWorkID},
                type: 'get',
                contentType: 'application/json',
                success: function (res) {
                    console.log(res);
                    $scope.getQuantityOfWorkList($scope.params.fid);
                    $scope.showalert("删除成功");
                },
                error: function (res) {
                    console.log(res);
                }
            });

        };

        //广播
        $scope.$on("toQuantityOfWork", function (event, tar) {
            $scope.params = tar;
            if (angular.isUndefined($scope.item)) {
                $scope.getQuantityOfWorkList(tar.fid);
            }

        });
    });
})(angular);