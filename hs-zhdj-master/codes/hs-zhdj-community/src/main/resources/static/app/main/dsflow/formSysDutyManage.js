(function ($app) {
    'use strict';
    $app.module('dsfapp').controller('formSysDutyManageCtrl', function ($scope, $http, $modal, $alert, AuthUser, $state) {

        //test url要加上?uid=1121131017
        $scope.user = AuthUser.getUser();
        //保存所有的功能点
        $scope.allSysDuty = [];
        $scope.allselectSysDuty = [];
        //$scope.PSysDuty = [];
        //显示的子功能点列表
        $scope.sysDutyItems = [];
        $scope.params = {};

        //分页设置
        $scope.selectdata = {pageindex: 1, pagesize: 10, ptotal: 0};

        //页面数据更新
        $scope.updatePDutyList = function () {
            $scope.sysDutyItemsList = [];
            $scope.selectdata.ptotal = $scope.sysDutyItems.length;
            var firstLength = ($scope.selectdata.pageindex - 1) * $scope.selectdata.pagesize;
            var lastLength = ($scope.selectdata.pageindex * $scope.selectdata.pagesize) < $scope.selectdata.ptotal ?
                ($scope.selectdata.pageindex * $scope.selectdata.pagesize) : $scope.selectdata.ptotal;
            for (var i = firstLength; i < lastLength; i++) {
                $scope.sysDutyItemsList.push($scope.sysDutyItems[i]);
            }
        };
        //监视页数变化
        $scope.$watch("selectdata.pageindex", function (newVal, oldVal) {
            $scope.updatePDutyList();
        });


        //顶层模块
        $scope.Top = [];
        $scope.findTop = function (sysDuty) {
            if (sysDuty.PDutyID == null) {
                $scope.Top = {
                    DutyName: sysDuty.SysDutyName,
                    DutyID: sysDuty.SysDutyID
                };
            } else {
                angular.forEach($scope.allSysDuty, function (value) {
                    if (value.SysDutyID == sysDuty.PDutyID) {
                        $scope.findTop(value);
                    }
                });
            }
        };


        $scope.loadSysDuty = function () {
            $http({
                url: "../../api/SysDuty/GetDemandDuty",
                method: "Get",
                params: {
                    DemandApplyID: $scope.demandApply.DemandApplyID,
                }
            }).then(function (result) {
                $scope.allDemandDuty = result.data;
                //再获取属于该系统所有的功能点
                $http({
                    url: "../../api/SysDuty/GetSysDuty",
                    method: "Get",
                    params: {
                        sysName: $scope.demandApplyExtra.SystemName,
                        SysDutyName: "",
                        DutyLv: 0
                    }
                }).then(function (rq) {
                    $scope.allSysDuty = rq.data.items;
                    $scope.sysDutyItems = [];
                    angular.forEach($scope.allDemandDuty, function (value) {
                        $scope.findTop(value);
                        $scope.sysDutyItems.push({
                            item: value,
                            Top: $scope.Top
                        });
                    });
                    // $scope.flowdata.flowFileModel.sysDuty = $scope.sysDutyItems;
                    //更新最终显示的数据
                    $scope.updatePDutyList();
                });

            });
        };


        //获取需求申请单的数据
        $scope.loadDemandApplyItem = function (id) {
            $http({
                url: "../../api/DemandFlow/getDemandApply",
                method: 'GET',
                params: {id: '', fid: id, userid: ''}
            }).then(function (rq) {
                $scope.demandApply = rq.data.items;
                $scope.demandApplyExtra = rq.data.extdata;
                $scope.loadSysDuty();
            });
        };
        //接收广播
        $scope.$on("toSysDutyManage", function (event, tar) {
            $scope.params = tar;
            if (angular.isUndefined($scope.demandApply)) {
                $scope.loadDemandApplyItem(tar.fid);
            }
        });


        //将已有的功能点选择到需求功能点上
        var selectDutyModal = $modal({
            scope: $scope, resolve: {
                load: ['$ocLazyLoad', function ($ocLazyLoad) {
                    $ocLazyLoad.load('../js/template/modal_userselect.css');
                    return true;
                }]
            },
            controller: selectDutyCtrl,
            templateUrl: 'dsflow/selectDuty.html',
            show: false
        });

        $scope.selectSysDuty = function () {
            selectDutyModal.$scope.title = "新增需求功能点";
            //selectDutyModal.isShow = true;
            //selectDutyModal.data = {
            //    DemandApplyID: "",
            //    SysDutyID: "",
            //    FlowStage: "",
            //    UserID:"",
            //};
            //selectDutyModal.allSysDuty = $scope.allSysDuty;
            selectDutyModal.$promise.then(selectDutyModal.show);
        };

        //查看或者编辑需求功能点
        $scope.showOrEditSysDuty = function (it) {
            selectDutyModal.title = "编辑需求功能点";
            selectDutyModal.isShow = true;
            selectDutyModal.data = it.item;
            selectDutyModal.$promise.then(selectDutyModal.show);
        };

        function selectDutyCtrl($scope, $http, $alert, $filter) {

            $scope.selectDutyData = {
                tree_option: {
                    xAxis: [{id: 0, name: '系统'}, {id: 1, name: '模块'}, {id: 2, name: '应用'}, {id: 3, name: '功能点'}],
                    data: [],
                    canEdit: !$scope.params.readonly_sysDuty,
                    canChecked: !$scope.params.readonly_sysDuty,
                    btnclick: function (titem, type) {

                        if ((type == 1 || type == 4) && titem.xid == 0) {
                            $alert({
                                content: '系统级别添加请在系统管理模块维护',
                                type: 'info',
                                placement: 'top',
                                show: true,
                                duration: 3
                            });
                        } else if (type == 3) {
                            $scope.removeSysDuty(titem);
                        } else {
                            $scope.modalSysDuty({data: titem, type: type});
                        }

                    }
                }
            };

            $scope.getSysDutybysystemid = function (system) {
                $http({
                    method: 'get',
                    url: '../../api/SysDuty/GetSysDutybysysid',
                    params: {
                        SystemID: system.SystemID
                    }
                }).then(function (result) {
                    $scope.selectDutyData.tree_option.data = $scope.bindSysDutyTree([system], result.data.items);
                });
            }

            //把数据集加入tree
            $scope.bindSysDutyTree = function (syslist, dutylist) {
                //$scope.tree_option.data.splice(0, $scope.tree_option.data.length);
                var treedata = [];
                angular.forEach(syslist, function (val) {
                    this.push({id: val.SystemID, xid: 0, name: val.SystemName});
                }, treedata);

                angular.forEach(dutylist, function (val) {
                    this.push({
                        id: val.SysDutyID, xid: val.DutyLv, name: val.SysDutyName,
                        pid: val.DutyLv == 1 ? val.SystemID : val.PDutyID
                    });
                }, treedata);

                return treedata;
            }

            $scope.freshTree = function () {
                $scope.getSysDutybysystemid({
                    SystemID: $scope.demandApply.SystemID,
                    SystemName: $scope.demandApplyExtra.SystemName
                });
            }

            $scope.freshTree();

            //弹出的模态框预先加载
            var myModal = $modal({
                scope: $scope,
                resolve: {
                    load: ['$ocLazyLoad', function ($ocLazyLoad) {

                        return $ocLazyLoad.load('setting/sysDuty/addSysDuty.js');
                    }]
                },
                templateUrl: 'setting/sysDuty/addSysDuty.html',
                controller: 'addSysDutyCtrl',
                size: 'sm',
                show: false
            });

            //添加一个同级节点
            $scope.modalSysDuty = function (Params) {

                myModal.$scope.SysDutyParams = Params;
                myModal.$promise.then(myModal.show);
            };

            //对当前功能点进行删除操作（弹出模态框确认删除）
            $scope.removeSysDuty = function (sysDuty) {
                if (sysDuty.children && sysDuty.children.length != 0) {
                    $alert({content: '必须删除所有子节点后才能删除此模块', type: 'info', placement: 'top', show: true, duration: 3});
                } else if (sysDuty.xid == 0) {
                    $alert({content: '系统不能在这里删除', type: 'info', placement: 'top', show: true, duration: 3});
                } else {
                    if (!confirm("确认删除功能点：" + sysDuty.name + "?")) {
                        return;
                    }
                    $http({
                        method: 'get',
                        url: '../../api/SysDuty/DeleteSysDuty',
                        params: {sysDutyID: sysDuty.id}
                    }).then(function (res) {
                        $scope.freshTree();
                        $alert({content: res.data, type: 'info', placement: 'top', show: true, duration: 3});
                        //$scope.getSysDuty();
                    }, function (res) {
                        $alert({content: res.data, type: 'info', placement: 'top', show: true, duration: 3});
                    });
                }
            };


            $scope.chooseOne = {
                SysDutyName: "      ",
                SysDutyID: "",
                selectedID: "",
                SysDutyNote: "",
                hasName: true
            };
            $scope.chooseTwo = {
                Name: ""
            }

            //默认显示功能点负责人只有一个高程的情况下
            $scope.showProjectMan = function () {
                $http.get("../../api/MemManage/FindMemsdataByrolename",
                    {
                        params:
                            {
                                'aid': $scope.flowdata.params.fid + '+' + '高级开发工程师' + '+',
                                'findkey': "",
                                'pageIndex': $scope.selectdata.pageindex,
                                'pageSize': $scope.selectdata.pagesize
                            }
                    }).then(function (result) {
                    console.log(result);
                    if (result.data.items.length == 1) {
                        $scope.chooseTwo.Name = result.data.items[0].label;
                        $scope.chooseTwo.selectedID = result.data.items[0].val;
                    } else {
                        $scope.chooseTwo.Name = "";
                    }
                }, function () {
                    $alert({title: '提示：', content: "服务器错误", placement: 'top', type: 'info', show: true, duration: 3});
                });
            };
            $scope.showProjectMan();

            //点击保存的时候添加功能点
            $scope.save = function () {

                var selectdutys = $filter('filter')($scope.selectDutyData.tree_option.data, function (val) {
                    return val.chk;
                });


                if (selectdutys.length == 0) {
                    $alert({content: "你还没有选择功能点!", type: 'warning', placement: 'top', show: true, duration: 3});
                } else {

                    var arrsysDutys = [];

                    angular.forEach(selectdutys, function (val) {
                        arrsysDutys.push(val.id);
                    }, arrsysDutys);

                    $scope.tempDemandDuty = {
                        SysDutyIDs: arrsysDutys.join(','),
                        DemandApplyID: $scope.demandApply.DemandApplyID,
                        FlowStage: $scope.demandApply.FlowStage,
                        UserID: $scope.chooseTwo.selectedID
                    };

                    $http({
                        url: "../../api/DemandFlow/SaveDemandDuty",
                        method: "get",
                        params: $scope.tempDemandDuty
                    }).then(function (result) {


                        if (result.data == "false") {
                            $alert({
                                content: "功能点：" + $scope.chooseOne.SysDutyName + "已经存在到该需求中",
                                type: 'warning',
                                placement: 'top',
                                show: true,
                                duration: 3
                            });
                        } else if (result.data == "success") {
                            $alert({
                                content: "功能点：" + $scope.chooseOne.SysDutyName + "添加成功",
                                type: 'success',
                                placement: 'top',
                                show: true,
                                duration: 3
                            });
                        } else {
                            $alert({
                                content: "功能点：" + $scope.chooseOne.SysDutyName + "更新成功",
                                type: 'success',
                                placement: 'top',
                                show: true,
                                duration: 3
                            });
                        }
                        //更新显示数据
                        $scope.loadSysDuty();
                        $scope.$parent.$hide();
                    });
                }


            };

        };


        //删除功能点列表的删除
        $scope.deleteSysDuty = function (it) {
            if (!confirm("确认删除功能点：" + it.item.SysDutyName + "?")) {
                return;
            }
            $http({
                method: 'get',
                url: '../../api/SysDuty/DeleteDemandDuty',
                params: {
                    DemandApplyID: $scope.demandApply.DemandApplyID,
                    sysDutyID: it.item.SysDutyID
                }
            }).then(function (result) {
                if (result.data == "success") {
                    $alert({
                        content: "删除功能点" + it.item.SysDutyName + "成功",
                        type: 'success',
                        placement: 'top',
                        show: true,
                        duration: 3
                    });
                } else {
                    $alert({content: "删除失败", type: 'warning', placement: 'top', show: true, duration: 3});
                }
                $scope.loadSysDuty();
            });
        }
        selectDutyModal.$inject = ['$scope', '$http', '$alert', '$filter'];


    });
})(angular);