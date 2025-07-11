(function () {
    angular.module('dsfapp').controller("syslistController", function ($scope, $http, $rootScope, $alert, $modal, $ocLazyLoad, AuthUser, $loading) {
        $scope.title = "系统管理";
        $scope.sysName = "";
        $scope.ProMan = "";
        $scope.pageSize = 10;
        $scope.pageIndex = 1;//选择页
        $scope.syslists = [];
        //当前用户获取
        //test url要加上?uid=1121131017
        $scope.user = AuthUser.getUser();

        //打印当前选中页索引
        $scope.selectPage = function (page) {
            //设置当前页码
            $scope.pageIndex = page;
            $http({
                url: "../../api/SysManage/GetSysList", method: 'GET', params: {
                    sysName: $scope.sysName,
                    ProMan: $scope.ProMan,
                    PageSize: $scope.pageSize,
                    PageIndex: page
                }
            }).then(function (res) {
                if (!res.data.DataList) {
                    $scope.syslists = [];
                } else {
                    $scope.syslists = res.data.DataList;
                    $scope.totalCount = res.data.DataCount;
                }
            }, function (res) {
                console.log(res);
            });
            //$.ajax({
            //    url: "../../api/SysManage/GetSysList",
            //    data:{
            //        sysName: $scope.sysName,
            //        ProMan: $scope.ProMan,
            //        PageSize: $scope.pageSize,
            //        PageIndex: page
            //    },
            //    type: 'get',
            //    contentType: 'application/json',
            //    success: function (res) {
            //        $scope.$apply(function () {
            //            if (!res.DataList) {
            //                $scope.syslists = [];
            //            } else {
            //                $scope.syslists = res.DataList;
            //                $scope.totalCount = res.DataCount;
            //            }


            //        })

            //    },
            //    error: function (res) {
            //        console.log(res);
            //    }
            //});

            //$scope.isActivePage(page);
            console.log("选择的页：" + page);
        };

        //加载页面时查询所有
        $scope.selectPage(1);

        //删除一条系统信息记录
        $scope.deleteSys = function (SystemID) {
            if (!confirm("确认删除?")) {
                return;
            }
            $http({
                url: "../../api/SysManage/deleteSys", method: 'GET', params: {sysId: SystemID}
            }).then(function (res) {
                $scope.selectPage(1);
                if (res.data.success) {
                    $scope.showalert("删除成功");
                } else {
                    $scope.showalert("删除失败，请确认该系统下无功能点。");
                }

            }, function (res) {
                console.log(res);
            });
            //$.ajax({
            //    url: "../../api/SysManage/deleteSys",
            //    data: { sysId: SystemID },
            //    type: 'get',
            //    contentType: 'application/json',
            //    success: function (res) {
            //        console.log(res);
            //        $scope.selectPage(1);
            //        $scope.showalert("删除成功");
            //    },
            //    error: function (res) {
            //        console.log(res);
            //    }
            //});

        };

        //给弹窗界面进行赋值操作
        var MyEditModalController = function ($scope, $http) {

            $scope.title = "填写系统信息";
            $scope.sys = myModal.data;

            $scope.saveSys = function () {
                $scope.newSys = {
                    SystemID: $scope.sys.SystemID,
                    SystemName: $scope.sys.SystemName,
                    SystemDescribe: $scope.sys.SystemDescribe,
                    Note: $scope.sys.Note,
                    BuildYear: $scope.sys.BuildYear,
                    BuildDev: $scope.sys.BuildDev,
                    TechFrame: $scope.sys.TechFrame,
                    DBType: $scope.sys.DBType,
                    DemandPD: $scope.sys.DemandPD,
                    DemandMan: $scope.sys.DemandMan,
                    Builder: $scope.sys.Builder,
                    PM: $scope.sys.PM,
                    CreatorID: $scope.sys.CreatorID,
                    LastDoneTime: $scope.sys.LastDoneTime
                };
                $.ajax({
                    url: "../../api/SysManage/SaveSysList",
                    data: JSON.stringify($scope.newSys),
                    type: 'post',
                    contentType: 'application/json',
                    success: function (res) {
                        console.log(res);
                        myModal.$promise.then(myModal.hide);
                        $scope.selectPage(1);
                        $scope.showalert("保存成功");
                    },
                    error: function (res) {
                        console.log(res);
                    }
                });
            };
        };
        MyEditModalController.$inject = ['$scope', '$http'];

        var myModal = $modal({
            scope: $scope,
            title: '修改系统细节',
            templateUrl: 'setting/editSysModal.html',
            controller: MyEditModalController,
            show: false,
            animation: 'am-fade-and-slide-top'
        });
        $scope.editModal = function (id) {
            $.ajax({
                url: "../../api/SysManage/findSys",
                data: {sysId: id},
                type: 'get',
                contentType: 'application/json',
                success: function (res) {
                    console.log(res);
                    if (res == null) {
                        myModal.data = $scope.sys;
                    } else {
                        myModal.data = res;

                    }
                    myModal.$promise.then(myModal.show);
                },
                error: function (res) {
                    console.log(res);
                }
            });


        };
        $scope.addModal = function () {
            $scope.sys = {
                SystemName: "",
                SystemDescribe: "",
                Note: "",
                BuildYear: "",
                BuildDev: "",
                TechFrame: "",
                DBType: "",
                DemandPD: "",
                DemandMan: "",
                Builder: "",
                PM: "",
                CreatorID: $scope.user.DGUserID
            };

            $scope.editModal("");
        };
        $scope.showalert = function (data) {
            $alert({title: '提示：', content: data, placement: 'top', type: 'info', show: true, duration: 3});
        };

    });
})();
