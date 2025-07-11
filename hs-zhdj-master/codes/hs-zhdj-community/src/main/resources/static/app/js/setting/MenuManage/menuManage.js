(function () {
    var app = angular.module('devself.common');

    app.controller("MenuManageCtrl", function ($scope, $http, $alert, $modal, AuthUser, $state, $loading,$bsRouterState) {

        $scope.title = '菜单管理';

        $state.params=$bsRouterState.$params($scope);

        //分页设置
        $scope.selectdata = {pageindex: 1, pagesize: 10, ptotal: 0};
        $scope.hasPermission = {
            show: true
        };
        //当前用户获取
        //test url要加上?uid=1121131017
        $scope.user = AuthUser.getUser();
        //选择的菜单名称
        $scope.MenuName = '';
        //选择的菜单编号
        $scope.MenuNo = '';
        //所有的菜单记录
        $scope.menuLists = [];
        $scope.curMenuID = "";

        //加载所有的父菜单记录
        $scope.getMenuList = function () {
            $loading.show();
            $http.get("../../api/menumanage/alltopparentmenus", {
                params: {
                    'menuname': $scope.MenuName,
                    'menuno': $scope.MenuNo,
                    appid: $state.params.appid
                }
            }).then(function (value) {
                $scope.menuLists = value.data.item;
                $scope.updatePDutyList();
                $loading.hide();

            }, function (reason) {
                $loading.hide();
                console.log(reason);
            });

        };

        //查询对应菜单数据
        $scope.searchMenu = function () {
            $scope.getMenuList();
            /*
            $http.get("../../api/menumanage/getmenulists", { params: { 'MenuName': $scope.MenuName, 'MenuNo': $scope.MenuNo, 'appid': $state.params.appid } }).then(function (result) {
                $scope.menuLists = result.data.item;
                $scope.updatePDutyList();

            }, function () {
                console.log("无匹配条件数据");
            });*/
        };
        //加载子菜单
        $scope.loadChildMenu = function (item) {
            $scope.searchParam = "";//查询条件清空
            if (!item.isExpand)//如果该节点未展开
            {
                item.isExpand = true;
                $scope.getMenuByParentID(item);
            } else {
                item.isExpand = false;
            }
        };
        //根据当前项的menuID找到其所有的子菜单
        $scope.getMenuByParentID = function (item) {
            $http.get("../../api/menumanage/childmenubyparentid", {
                params: {
                    'parentid': item.menuid,
                    'appid': $state.params.appid
                }
            }).then(function (result) {
                item.childMenus = result.data.item;

            }, function () {
                console.log("无匹配项");
            });
        };

        $scope.getMenuList();

        //页面数据更新
        $scope.updatePDutyList = function () {
            $scope.tempMenu = [];
            $scope.selectdata.ptotal = $scope.menuLists.length;
            var firstLength = ($scope.selectdata.pageindex - 1) * $scope.selectdata.pagesize;
            var lastLength = ($scope.selectdata.pageindex * $scope.selectdata.pagesize) < $scope.selectdata.ptotal ?
                ($scope.selectdata.pageindex * $scope.selectdata.pagesize) : $scope.selectdata.ptotal;
            for (var i = firstLength; i < lastLength; i++) {
                $scope.tempMenu.push($scope.menuLists[i]);
            }
        };
        //监视页数变化
        $scope.$watch("selectdata.pageindex", function (newVal, oldVal) {
            $scope.updatePDutyList();
        });

        //删除选中菜单项
        $scope.delete = function (item) {
            $http.get("../../api/menumanage/childmenubyparentid", {
                params: {
                    'parentid': item.menuid,
                    'appid': $state.params.appid
                }
            }).then(function (result) {
                if (result.data.item.length > 0) {
                    $alert({content: '有子菜单项不能删除！', type: 'info', placement: 'top', show: true, duration: 3});
                } else {
                    if (!confirm("确认删除?")) {
                        return;
                    }
                    $http.get("../../api/menumanage/deletemenubyid", {params: {'menuid': item.menuid}}).then(function (result) {
                        $scope.getMenuList();
                        $scope.showalert(result.data.msg);

                    }, function () {
                        console.log("无匹配项");
                    });
                }

            }, function () {
                console.log("无匹配项");
            });


        };

        var MyModalController = function ($scope, $http) {

            $scope.edit = {
                menuParentName: "",
                menuParentId: ""
            };
            $scope.title = "菜单信息";
            $scope.menu = $scope.data;
            $scope.edit.menuParentId = $scope.menu.parentmenuid;
            $scope.selectParent = function () {
                if ($scope.hasPermission.show) {
                    myselectModal.$promise.then(myselectModal.show);
                }

            };

            //获取原父级菜单
            $scope.getParentName = function () {
                if ($scope.menu.parentmenuid == null || $scope.menu.parentmenuid == "") {
                    $scope.edit.menuParentName = "顶层菜单";

                } else {
                    $http.get("../../api/menumanage/findmenubymenuid", {params: {'menuid': $scope.menu.parentmenuid}}).then(function (result) {
                        $scope.edit.menuParentName = result.data.item.menuname;

                    }, function () {
                        console.log("无匹配项");
                    });


                }
            };
            $scope.getParentName();

            //加载所有的父菜单记录
            var selecModalController = function ($scope, $http) {

                //加载所有的父菜单记录
                $scope.getMenus = function () {
                    $.ajax({
                        url: "../../api/menumanage/alltopparentmenus",
                        data: {appid: $state.params.appid, menuname: '', menuno: ''},
                        type: 'get',
                        contentType: 'application/json',
                        success: function (res) {
                            $scope.$apply(function () {
                                $scope.selectMenus = res.item;
                            })
                        },
                        error: function (res) {
                            console.log(res);
                        }
                    });
                };
                //加载子菜单
                $scope.loadChild = function (item) {

                    if (!item.isExpand)//如果该节点未展开
                    {
                        item.isExpand = true;
                        $scope.getMenuByPID(item);
                    } else {
                        item.isExpand = false;
                    }
                };
                //根据当前项的menuID找到其所有的子菜单
                $scope.getMenuByPID = function (item) {
                    $http.get("../../api/menumanage/childmenubyparentid", {
                        params: {
                            'parentid': item.menuid,
                            'appid': $state.params.appid
                        }
                    }).then(function (result) {
                        item.childs = result.data.item;

                    }, function () {
                        console.log("无匹配项");
                    });
                };
                $scope.getMenus();

                $scope.changeChoose = function (item) {
                    if ($scope.curMenuID != item.menuid) {
                        $scope.curMenuID = item.menuid;
                        if (item.isleaf == false) {
                            $scope.FinalmenuParentName = item.menuname;
                            $scope.FinalmenuParentId = item.menuid;
                        } else {
                            $scope.FinalmenuParentName = "";
                            $scope.FinalmenuParentId = null;
                            $alert({
                                title: '提示：',
                                content: "不能选择叶节点作为父级菜单",
                                placement: 'top',
                                type: 'info',
                                show: true,
                                duration: 3,
                                container: "#selectParentMenu"
                            });

                        }

                    }

                };

                $scope.choose = function () {
                    if ($scope.FinalmenuParentId != null) {
                        $scope.edit.menuParentName = $scope.FinalmenuParentName;
                        $scope.edit.menuParentId = $scope.FinalmenuParentId;
                        myselectModal.$promise.then(myselectModal.hide);
                    } else {
                        $alert({
                            title: '提示：',
                            content: "未选择有效的父级菜单",
                            placement: 'top',
                            type: 'info',
                            show: true,
                            duration: 3,
                            container: "#selectParentMenu"
                        });

                    }

                };


            };
            selecModalController.$inject = ['$scope', '$http'];
            var myselectModal = $modal({
                scope: $scope,
                title: '选择父菜单',
                resolve: {
                    load: ['$ocLazyLoad', function ($ocLazyLoad) {
                        $ocLazyLoad.load('../js/template/modal_userselect.css');
                        $ocLazyLoad.load('../js/setting/MenuManage/selectMenu.css');
                        return true;
                    }]
                },
                templateUrl: '../js/setting/MenuManage/selectParentMenu.html',
                controller: selecModalController,
                show: false,
                animation: 'am-fade-and-slide-top'
            });
            //保存菜单项
            $scope.saveMenu = function () {
                $scope.menu.parentmenuid = $scope.edit.menuParentId;
                $scope.sameLevel = [];
                $scope.sameLevelName = [];
                $scope.hassame = false;

                if ($scope.menu.parentmenuid == "" || $scope.menu.parentmenuidFindMenuByMenuId == null) {
                    $http.get("../../api/menumanage/childmenubyparentid", {
                        params: {
                            'parentid': "",
                            'appid': $state.params.appid
                        }
                    }).then(function (result) {
                        $scope.sameLevel = result.data.items;
                        angular.forEach($scope.sameLevel, function (data) {
                            if (($scope.menu.menuname == data.menuname || $scope.menu.menuno == data.menuno) && $scope.menu.menuid != data.menuid) {
                                $scope.hassame = true;
                            }
                        });

                        if ($scope.hassame) {
                            $scope.showalert("同级已存在与此同名的菜单，不可新增！");
                        } else {
                            $.ajax({
                                url: "../../api/menumanage/savemenu",
                                data: JSON.stringify($scope.menu),
                                type: 'post',
                                contentType: 'application/json',
                                success: function (res) {
                                    $scope.$apply(function () {
                                        $scope.getMenuList();
                                        myModal.$promise.then(myModal.hide);
                                        $scope.showalert(res.msg);
                                    })
                                },
                                error: function (res) {
                                    console.log(res);
                                }
                            });
                        }

                    }, function () {
                        console.log("无匹配项");
                    });

                } else {

                    $http.get("../../api/menumanage/childmenubyparentid", {
                        params: {
                            'parentid': $scope.menu.parentmenuid,
                            'appid': $state.params.appid
                        }
                    }).then(function (result) {
                        $scope.sameLevel = result.data.items;
                        angular.forEach($scope.sameLevel, function (data) {
                            if (($scope.menu.menuname == data.menuname || $scope.menu.menuno == data.menuno) && $scope.menu.menuid != data.menuid) {
                                $scope.hassame = true;
                            }
                        });

                        if ($scope.hassame) {
                            $scope.showalert("同级已存在与此同名的菜单，不可新增！");
                        } else {
                            $.ajax({
                                url: "../../api/menumanage/savemenu",
                                data: JSON.stringify($scope.menu),
                                type: 'post',
                                contentType: 'application/json',
                                success: function (res) {
                                    $scope.$apply(function () {
                                        $scope.getMenuList();
                                        myModal.$promise.then(myModal.hide);
                                        $scope.showalert(res.msg);
                                    })
                                },
                                error: function (res) {
                                    console.log(res);
                                }
                            });
                        }

                    }, function () {
                        console.log("无匹配项");
                    });
                }


            };


        };
        MyModalController.$inject = ['$scope', '$http'];

        var myModal = $modal({
            scope: $scope,
            title: '菜单信息',
            templateUrl: '../js/setting/MenuManage/editMenu.html',
            controller: MyModalController,
            show: false,
            animation: 'am-fade-and-slide-top'
        });

        $scope.editModal = function (menu) {
            if (menu.menuid != null) {
                $scope.hasPermission.show = true;
                $http.get("../../api/menumanage/findmenubymenuid", {params: {'menuid': menu.menuid}}).then(function (result) {

                    $scope.data = result.data.item;
                    myModal.$promise.then(myModal.show);
                }, function () {
                    console.log("无匹配项");
                });
            } else {
                $scope.data = menu;
            }


        };
        //新增菜单项
        $scope.addMenu = function () {
            $scope.hasPermission.show = true;
            $scope.newMenu = {
                menuid: null,
                applicationid: $state.params.appid,
                parentmenuid: "",
                menusystem: "",
                menuorder: "",
                menuno: "",
                menuname: "",
                menuprogram: "",
                menupic: "",
                menudesc: "",
                isvisible: 1,
                isleaf: 1
            };
            $scope.editModal($scope.newMenu);
            myModal.$promise.then(myModal.show);
        };


        //提示函数
        $scope.showalert = function (data) {
            $alert({title: '提示：', content: data, placement: 'top', type: 'info', show: true, duration: 3});
        };

        $scope.reset = function () {
            //选择的菜单名称
            $scope.MenuName = '';
            //选择的菜单编号
            $scope.MenuNo = '';
        }
    });
})();