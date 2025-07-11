(function () {
    var app = angular.module('dsfapp');

    app.controller("sysDutyListCtrl", function ($scope, $http, $alert, $modal, AuthUser, $loading, $timeout) {

        $scope.Context = {
            title: '系统功能管理',
        };
        //分页设置
        $scope.selectdata = {querySysName: '', queryDutyName: '', syslist: [], pageindex: 1, pagesize: 10, ptotal: 0};

        //当前用户获取
        //test url要加上?uid=1121131017
        $scope.user = AuthUser.getUser();
        //选择的系统名称
        $scope.selectSys = {};
        //可供选择的系统名称数组
        $scope.sysNameAndID = [];
        //对应系统的功能点对象数组
        $scope.sysDutyData = {};
        //节点列表
        $scope.PSysDuty = [];

        //系统树数据源
        $scope.tree_option = {
            xAxis: [{id: 0, name: '系统'}, {id: 1, name: '模块'}, {id: 2, name: '应用'}, {id: 3, name: '功能点'}],
            data: [],
            canEdit: true,
            canChecked: false,
            btnclick: function (titem, type) {

                if ((type == 1 || type == 4) && titem.xid == 0) {
                    $alert({content: '系统级别添加请在系统管理模块维护', type: 'info', placement: 'top', show: true, duration: 3});
                } else if (type == 3) {
                    $scope.removeSysDuty(titem);
                } else {
                    $scope.modalSysDuty({data: titem, type: type});
                }

            }
        };

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
            myModal.$scope.SysDutyParams.readonly = false;
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

        //函数类
        $scope.showTree = function ($event, system) {
            $scope.selectSys = system;
            angular.element($event.target).parents('tr').first().after(angular.element('tr[data-id="tr_tree"]'));
            $scope.getSysDutybysystemid(system);
        }

        $scope.initTree = function () {
            if ($scope.selectdata.syslist.length > 0) {
                angular.element('[name="dutylist"] tbody tr').first().after(angular.element('tr[data-id="tr_tree"]'));
                $scope.selectSys = $scope.selectdata.syslist[0];
                $scope.getSysDutybysystemid($scope.selectSys);
            }

        }

        $scope.freshTree = function () {
            $scope.getSysDutybysystemid($scope.selectSys);
        }

        //监视页数变化
        $scope.$watch("selectdata.pageindex", function (newVal, oldVal) {
            if ($scope.selectdata.ptotal > 0) {
                angular.element('[name="dutylist"] tr').first().after(angular.element('tr[data-id="tr_tree"]'));
                $scope.loadData();
            }
        });

        //打印当前选中页索引
        $scope.loadData = function () {

            $http({
                url: "../../api/SysManage/GetSysList", method: 'GET', params: {
                    sysName: $scope.selectdata.querySysName,
                    ProMan: "",
                    PageSize: $scope.selectdata.pagesize,
                    PageIndex: $scope.selectdata.pageindex
                }
            }).then(function (res) {
                if (!res.data.DataList) {
                    $scope.selectdata.syslist = [];
                } else {
                    $scope.selectdata.syslist = res.data.DataList;
                    $scope.selectdata.ptotal = res.data.DataCount;
                    $timeout($scope.initTree, 50);

                }
            }, function (res) {
                console.log(res);
            });
        };

        $scope.loadData();

        $scope.getSysDutybysystemid = function (system) {
            $http({
                method: 'get',
                url: '../../api/SysDuty/GetSysDutybysysid',
                params: {
                    SystemID: system.SystemID
                }
            }).then(function (result) {
                $scope.bindSysDutyTree([system], result.data.items);
            });
        }

        //获取可供选择的系统名称
        $scope.getSys = function () {
            $loading.show();
            if ($scope.sysNameAndID == '') {
                $http({
                    method: 'get',
                    url: '../../api/SysDuty/GetSysName'
                }).then(function (result) {
                    if (result.data == '') {
                        $alert({content: '查询系统名称失败', type: 'info', placement: 'top', show: true, duration: 3});
                    } else {
                        $scope.sysNameAndID = angular.fromJson(result.data);
                        $scope.getSysDuty();
                    }
                    $loading.hide();
                });
            }
        };
        //$scope.getSys();
        $scope.hidden = function () {
            myModal.hide();
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

            $scope.tree_option.data = treedata;

            //$scope.$apply();
        }

        //查询选择系统的所有功能点信息
        $scope.getSysDuty = function () {
            $http({
                method: 'get',
                url: '../../api/SysDuty/GetSysDuty',
                params: {
                    sysName: $scope.querySysName == null ? "" : $scope.querySysName,
                    SysDutyName: "",//$scope.queryDutyName == null ? "" : $scope.queryDutyName,
                    DutyLv: 0
                }
            }).then(function (result) {
                $scope.sysDutyData = result.data;

                $scope.bindSysDutyTree($scope.sysDutyData.extdata, $scope.sysDutyData.items);

                //$scope.sysDutyList = result.data.items;
                //先显示父级节点
                //$scope.PSysDuty = [];
                //$scope.getPDuty($scope.PSysDuty, null);
                //显示分页列表
                //$scope.updatePDutyList();
            }).catch(function (result) {
                console.log(result.data);
            });
        };


        //使用递归将所有节点的内容填好
        $scope.getPDuty = function (dataList, SysDutyID) {
            angular.forEach($scope.sysDutyList, function (data) {
                if (data.PDutyID == SysDutyID) {
                    var childList = [];
                    $scope.getPDuty(childList, data.SysDutyID);
                    //不显示子节点的系统名称
                    if (SysDutyID != null) {
                        data.SystemName = "   ";
                    }
                    dataList.push({
                        myDuty: data,
                        childDuty: childList,
                        changeShow: false,
                        changeClass: 'glyphicon-chevron-right'
                    });
                }
            });

        };

        //根据父节点来显示对应的子节点
        $scope.getSysDutyByPDutyID = function (item) {
            //改变样式
            item.changeClass = item.changeClass == 'glyphicon-chevron-down' ? 'glyphicon-chevron-right' : 'glyphicon-chevron-down';
            //改变child的显示
            angular.forEach(item.childDuty, function (data) {
                data.changeShow = data.changeShow == true ? false : true;
            });
        };

        //页面数据更新
        $scope.updatePDutyList = function () {
            $scope.PSysDutySelect = [];
            $scope.selectdata.ptotal = $scope.PSysDuty.length;
            var firstLength = ($scope.selectdata.pageindex - 1) * $scope.selectdata.pagesize < $scope.selectdata.ptotal ?
                (($scope.selectdata.pageindex - 1) * $scope.selectdata.pagesize) : 0;
            var lastLength = ($scope.selectdata.pageindex * $scope.selectdata.pagesize) < $scope.selectdata.ptotal ?
                ($scope.selectdata.pageindex * $scope.selectdata.pagesize) : $scope.selectdata.ptotal;
            for (var i = firstLength; i < lastLength; i++) {
                $scope.PSysDutySelect.push($scope.PSysDuty[i]);
            }
        };


    });
})();