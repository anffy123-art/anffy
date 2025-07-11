(function ($app) {
    'use strict';
    $app.module('dsfapp').controller('formMembershipManageCtrl', function ($scope, $state, $alert, $modal, AuthUser, flowaudit, $http, $loading) {
        $scope.showCheckBox = false;
        $scope.pageSize = 10;
        $scope.pageIndex = 1;//选择页
        $scope.params = {};

        //加载对应工作流的需求对应的项目团队信息
        $scope.loadItem = function (id) {
            $loading.show();
            $http({
                url: "../../api/MemManage/FindMemsById",
                method: 'GET',
                params: {id: "", fid: id, findkey: "", PageSize: $scope.pageSize, PageIndex: $scope.pageIndex}
            }).then(function (rq) {
                $scope.items = rq.data.DataList;
                $scope.totalCount = rq.data.DataCount;
                $scope.iteminfo = rq.data.msg;
                $scope.DemandApplyID = rq.data.DemandApplyID;
                $loading.hide();
                //console.log($scope.iteminfo);

            });
        };
        //$scope.loadItem($state.params.fid);
        //接收广播
        $scope.$on("toMembershipManage", function (event, tar) {
            $scope.params = tar;
            if (angular.isUndefined($scope.items)) {
                $scope.loadItem(tar.fid);
            }

        });
        //分页操作
        $scope.pagechange = function (pageIndex) {
            $scope.pageIndex = pageIndex;
            $scope.loadItem($state.params.fid);

        }
        //显示checkbox和删除，取消按钮
        $scope.deleteMember = function () {
            $scope.showCheckBox = true;
        };
        //点击删除按钮确认删除操作
        $scope.confirmDelete = function () {
            $scope.deleteCount = 0;
            $scope.deleteItem = [];//存储即将删除的团队成员的membershipID

            //循环确定选择删除的项
            angular.forEach($scope.items, function (value, key) {
                if (value.check) {
                    $scope.deleteCount++;
                    $scope.deleteItem.push(value.MemebershipID);
                }
            });
            //被选记录才能删除
            if ($scope.deleteCount > 0 && $scope.showCheckBox) {
                if (!confirm("确认删除这" + $scope.deleteCount + "条团队成员记录？")) {
                    return;
                }
                $.ajax({
                    url: "../../api/MemManage/deleteMems",
                    data: {membershipIDs: $scope.deleteItem},
                    type: 'get',
                    contentType: 'application/json',
                    success: function (res) {
                        $scope.pageIndex = 1;
                        $scope.loadItem($state.params.fid);
                        $scope.showalert(res.info);
                        $scope.showCheckBox = false;
                    },
                    error: function (res) {
                        console.log(res);
                    }
                });

            } else if ($scope.deleteCount == 0 && $scope.showCheckBox) {
                $scope.showalert("还未选择删除项！");
            }


        };
        //取消删除操作，将删除和取消按钮隐藏
        $scope.cancelDelete = function () {
            $scope.showCheckBox = false;
        }
        //添加成员操作弹框
        var MyModalController = function ($scope, $http) {
            //获取团队成员角色字典信息
            $scope.getDicValue = function () {
                $http({
                    method: "GET",
                    url: "../../api/Comm/GetDictionaryListByDicType",
                    params: {
                        DicTypeKey: "Member_RoleType"
                    }
                }).then(function (result) {
                    $scope.DicValueList = result.data;
                }, function (resp) {
                    alert("获取团队成员角色字典信息失败");
                });
            }
            $scope.getDicValue();

            $scope.loadItem($state.params.fid);
            $scope.member = {
                MemebershipID: "",
                FlowStage: "",
                JoinTime: "",
                DemandApplyID: $scope.DemandApplyID,
            };

            $scope.title = "团队成员信息";
            $scope.saveMem = function () {
                $http({
                    url: "../../api/MemManage/saveMems",
                    method: 'post',
                    data: {
                        "member": $scope.member,
                        "Roledic": $scope.member.Roledic
                    }
                }).then(function (res) {
                    myModal.$promise.then(myModal.hide);
                    $scope.pageIndex = 1;
                    $scope.loadItem($state.params.fid);
                    $scope.showalert(res.data.info);
                    $scope.showCheckBox = false;
                }, function (res) {
                    console.log(res);
                });
            };

        };

        MyModalController.$inject = ['$scope', '$http'];

        var myModal = $modal({
            scope: $scope,
            title: '团队成员信息',
            templateUrl: 'dsflow/editMemberModal.html',
            controller: MyModalController,
            show: false,
            animation: 'am-fade-and-slide-top'
        });


        $scope.addMember = function () {
            if (!$scope.showCheckBox)
                myModal.$promise.then(myModal.show);
            else
                $scope.showalert("请先取消删除操作！");
        }
        var DetailModalController = function ($scope, $http) {
            //模态框参数设置  
            $scope.finddata = {
                pageindex: 1,
                pagesize: 10,
                ptotal: 0,
                UserID: $scope.params.UserID,
                DemandApplyID: $scope.params.DemandApplyID,
                QWorkRoleID: $scope.params.RoleID
            };

            //监测页面变化
            $scope.$watch("finddata.pageindex", function (newVal, oldVal) {
                if ($scope.finddata.ptotal > 0) {
                    $scope.getQuantityOfWorkList();
                }
            })
            $scope.getQuantityByUserID = function () {
                $http({
                    url: "../../api/QuantityOfWork/getQuantityByUserID",
                    method: 'GET',
                    params: $scope.finddata
                }).then(function (rq) {
                    $scope.QuantityOfWorkLists = rq.data.items;
                    $scope.finddata.ptotal = rq.data.total;
                });

            }
            $scope.getQuantityByUserID();

        };

        DetailModalController.$inject = ['$scope', '$http'];

        var detailModal = $modal({
            scope: $scope,
            title: '工作量详情',
            templateUrl: '../js/template/modal_workValue.html',
            controller: DetailModalController,
            show: false,
            animation: 'am-fade-and-slide-top'
        });

        $scope.showDetail = function (e) {
            if (e.WorkValue > 0) {
                detailModal.$scope.params = e;
                detailModal.$promise.then(detailModal.show);
            }

        };
        //$scope.CalculateQuantity = function () {
        //    $http({ url: "../../api/MemManage/CalculateQuantity", method: 'GET', params: { fid: $state.params.fid } }).then(function (rq) {
        //    });
        //};
        $scope.showalert = function (data) {
            $alert({title: '提示：', content: data, placement: 'top', type: 'info', show: true, duration: 3});
        };
    });
})(angular);