(function ($ang_role) {
    'use strict';
    $ang_role.module('devself.common', []).controller("roleListController", function ($scope, $state, $http, $rootScope, $alert, $modal, AuthUser, $ocLazyLoad, $filter, $loading, $bsRouterState) {
        $scope.title = "人员角色权限";
        $scope.roleLists = []; //角色信息
        $scope.roleLists_dir = new Array(); //包含数据范围的角色信息
        $scope.roleName = "";
        $scope.roleConfigList = [];

        $state.params = $bsRouterState.$params($scope);

        //分页参数设置  
        $scope.finddata = {
            pageindex: 1,
            pagesize: 10,
            ptotal: 0,
            lx: ''
        };
        $scope.selectPage = function (page) {
            if ($scope.finddata.ptotal > 0) {
                $scope.getRoleList($state.params.appid);
            }
        }

        //查询按钮
        $scope.selectpage = function () {
            $scope.finddata.pageindex = 1;
            $scope.finddata.ptotal = 0;
            $scope.getRoleList($state.params.appid);
        }

        $scope.getRoleConfigList = function () {
            $http({
                method: 'get',
                url: '../../api/dictionary/getDictionaryListByDicTypeKey',
                params: {
                    dicTypeKey: 'roleConfig'
                }
            }).then(function (result) {
                $scope.roleConfigList = result.data;
            }, function (resp) {

            });
        };
        $scope.getRoleConfigList();

        $scope.getRoleList = function (id) {
            $loading.show();
            $scope.roleLists_dir = new Array();
            $http({
                url: "../../api/userrole/GetRoleList",
                method: 'GET',
                params: {
                    appid: id,
                    rolename: $scope.roleName,
                    pageindex: $scope.finddata.pageindex,
                    pagesize: $scope.finddata.pagesize,
                    userId: AuthUser.getUser().Id
                }
            })
                .then(function (rq) {
                    $scope.roleLists = rq.data.item.list;
                    for (var i = 0; i < $scope.roleLists.length; i++) {
                        //判断是否含有dictionaryId
                        if ($scope.roleLists[i].dictionaryid == null || $scope.roleLists[i].dictionaryid == "") {
                            // $scope.roleLists_dir.push($scope.roleLists[i]);
                        } else {
                            $scope.getDictionaryByID(i, $scope.roleLists[i].dictionaryid);
                        }
                    }
                    $scope.finddata.ptotal = rq.data.item.total;
                    $loading.hide();
                }, function (rq) {
                    alert("获取失败");
                    $loading.hide();
                });
        }

        $scope.getDictionaryByID = function (index, id) {
            $http({
                url: "../../api/dictionary/getDictionaryByID",
                method: 'GET',
                params: {
                    id: id
                }
            }).then(function (res) {
                //合并role和dictionary信息
                $scope.roleLists[index] = Object.assign(res.data.item, $scope.roleLists[index]);
            }, function (res) {
                console.log(res);
            });
        }

        $scope.getRoleList($state.params.appid);


        //删除一条角色信息记录
        $scope.deleteRole = function (RoleId) {
            if (!confirm("确认删除?")) {
                return;
            }

            $http({
                url: "../../api/userrole/deleteRole",
                method: 'GET',
                params: {
                    roleId: RoleId
                }
            }).then(function (res) {
                $scope.showalert(res.data.msg);
                $scope.getRoleList($state.params.appid);
            }, function (res) {
                console.log(res);
            });

        };
        //提示信息
        $scope.showalert = function (data) {
            $alert({title: '提示：', content: data, placement: 'top', type: 'info', show: true, duration: 3});
        };
        //弹窗的更改
        var MyEditModalController = function ($scope, $http) {
            $scope.params = myModal.params;
            $scope.loadRoleMenu = function () {
                $http.get("../../api/userrole/getRoleMenu", {params: {'id': $scope.params.roleId}}).then(function (result) {
                    $scope.content = result.data.item;
                    $scope.content2 = result.data.extdata.array;
                    //循环遍历所有的Menulist与返回结果的content的值进行比对，然后设置MenuList的isChecked=true
                    angular.forEach($scope.content2, function (val, key) {
                        var data = $filter('filter')($scope.menuLists, function (value) {
                            return value.menuid == val
                        });

                        if (data.length > 0) {
                            data[0].isChecked = true;
                        }

                    });
                    $scope.PmenuLists = [];
                    $scope.getPmenuLists($scope.PmenuLists, null);

                }, function () {
                    alert("服务器错误");
                });
            }


            //加载所有的菜单记录
            $scope.getMenuList = function () {
                $http({
                    method: 'get',
                    url: "../../api/userrole/getMenuList",
                    params: {
                        appid: $state.params.appid,
                    }
                }).then(function (res) {
                    $scope.menuLists = res.data.item;
                    if ($scope.params.title == "角色编辑") {
                        $scope.loadRoleMenu();
                    }
                    //先显示父级节点
                    $scope.PmenuLists = [];
                    $scope.getPmenuLists($scope.PmenuLists, null);
                }, function (res) {
                    alert("获取失败");
                });
            };
            $scope.getMenuList();

            //使用递归将所有节点的内容填好
            $scope.getPmenuLists = function (dataList, MenuId) {
                angular.forEach($scope.menuLists, function (data) {
                    if (data.parentmenuid == MenuId) {
                        var childList = [];
                        $scope.getPmenuLists(childList, data.menuid);

                        dataList.push({
                            myMenu: data,
                            isChecked: data.isChecked,
                            childMenu: childList,
                            changeShow: false,
                            changeClass: 'glyphicon-chevron-right'
                        });
                    }
                });

            };

            //根据父节点来显示对应的子节点
            $scope.getMenuByPMenuID = function (item) {
                //改变样式
                item.changeClass = item.changeClass == 'glyphicon-chevron-down' ? 'glyphicon-chevron-right' : 'glyphicon-chevron-down';
                //改变child的显示
                angular.forEach(item.childMenu, function (data) {
                    data.changeShow = data.changeShow == true ? false : true;
                });
            };

            //父节点的过滤
            $scope.menufilter = function (value) {
                return !value.parentmenuid;
            }
            //checkbox的判断
            $scope.chkchildren = function (item) {
                //angular.forEach($scope.menuLists, function (val) {
                //    if (val.MenuId == item.myMenu.MenuId) {
                //        val.isChecked = item.isChecked;
                //    }
                //});
                if (angular.isDefined(item.childMenu)) {
                    angular.forEach(item.childMenu, function (val, key) {
                        val.isChecked = item.isChecked;
                        $scope.chkchildren(val);
                    });
                }
                $scope.chkparent(item);
            };
            $scope.chkparent = function (item) {
                $scope.tempMenu = "";
                $scope.getPmenu = function (dataList, menuId) {
                    var flag = true;
                    angular.forEach(dataList, function (val) {
                        if (flag) {
                            if (menuId == val.myMenu.menuid) {
                                //找到父级
                                $scope.tempMenu = val;
                                //选择一个全部勾选父节点
                                if (item.isChecked) {
                                    val.isChecked = item.isChecked;
                                } else {
                                    $scope.Amt = 0;
                                    var flag2 = true;
                                    angular.forEach(val.childMenu, function (val_child) {
                                        if (flag2) {
                                            if (val_child.isChecked == item.isChecked) {
                                                $scope.Amt = $scope.Amt + 1;
                                            }
                                            flag = false;
                                        }
                                    })
                                    if (val.childMenu.length == $scope.Amt) {
                                        val.isChecked = item.isChecked;
                                    }
                                }
                                flag = false;
                            }
                            $scope.getPmenu(val.childMenu, menuId);
                        }
                    });
                }
                if (item.myMenu.parentmenuid != null) {
                    $scope.getPmenu($scope.PmenuLists, item.myMenu.parentmenuid);
                    var grandChk = $scope.tempMenu;
                    $scope.chkparent(grandChk);
                }
            };


            //保存
            $scope.saveRole = function (isflag) {
                if (isflag) {
                    //遍历所有的isChecked的属性，用,去拼接;
                    var menuIdArr = [];
                    $scope.GetPmenuChecked = function (dataList) {
                        angular.forEach(dataList, function (data) {
                            if (data.isChecked) {
                                this.push(data.myMenu.menuid);
                            }
                            $scope.GetPmenuChecked(data.childMenu);
                        }, menuIdArr);
                    }
                    $scope.GetPmenuChecked($scope.PmenuLists);
                    //angular.forEach($scope.menuLists, function (data) {
                    //    if (data.isChecked) {
                    //        this.push(data.MenuId);
                    //    }
                    //}, menuIdArr);

                    if (menuIdArr.length <= 0) {

                        $scope.showalert("请分配菜单权限");
                        return false;
                    }

                    $http({
                        method: "post",
                        url: "../../api/userrole/SaveRoleList",
                        data: {
                            "applicationId": $state.params.appid,
                            "roleId": $scope.content.roleid || '',
                            "roleName": $scope.content.rolename,
                            "description": $scope.content.description,
                            "groupby": $scope.content.groupby,
                            "orderby": $scope.content.orderby,
                            "dictionaryid": $scope.content.dictionaryid,
                            "menuIds": menuIdArr.join(','),
                        }
                    }).then(function (result) {
                        //alert(result.data);
                        $scope.$hide();
                        $scope.getRoleList($state.params.appid);
                        $scope.showalert(result.data.msg);

                    }), function (resp) {
                        alert("服务器错误");
                    }
                }
            }
        }
        MyEditModalController.$inject = ['$scope', '$http'];

        //APP权限管理弹出模块
        var myModal3 = $modal({
            resolve: {
                load: ['$ocLazyLoad', function ($ocLazyLoad) {
                    $rootScope.aid = "101";
                    return $ocLazyLoad.load('../js/setting/userRole/AppMenuManageList.js');
                }]
            },
            scope: $scope,
            title: 'APP角色权限分配',
            controller: 'AppMenuManageListController',
            templateUrl: '../js/setting/userRole/AppMenuManageList.html',
            show: false,
            animation: 'am-fade-and-slide-top'
        });
        $scope.showModal3 = function (e) {
            $rootScope.role = {
                roleName: e.rolename,
                roleId: e.roleid
            }
            myModal3.$promise.then(myModal3.show);
        };
        $scope.hideModal3 = function () {
            myModal3.$promise.then(myModal3.hide);
        }

        //新增或者编辑角色 模拟框
        var myModal = $modal({
            scope: $scope,
            resolve: {
                load: ['$ocLazyLoad', function ($ocLazyLoad) {
                    $ocLazyLoad.load('../js/template/modal_userselect.css');
                    return true;
                }]
            },
            templateUrl: '../js/setting/userRole/editRoleModal.html',
            controller: MyEditModalController,
            show: false,
            animation: 'am-fade-and-slide-top'
        });
        //打开新增角色模拟框
        $scope.savemodal = function () {
            myModal.content = {};
            myModal.params = {
                title: "角色新增",
                content: {},
                content2: {}
            }
            myModal.$promise.then(myModal.show);
        }

        //打开角色编辑模拟框
        $scope.editmodal = function (id) {
            myModal.params = {
                title: "角色编辑",
                content: {},
                content2: {},
                roleId: id
            }
            myModal.$promise.then(myModal.show);

        }

        //添加人员管理弹出模块
        var myModal2 = $modal({
            resolve: {
                load: ['$ocLazyLoad', function ($ocLazyLoad) {
                    $rootScope.aid = "100";
                    return $ocLazyLoad.load('../js/setting/userRole/UserManageList.js');
                }]
            },
            scope: $scope,
            title: '人员列表',
            controller: 'UserManageListController',
            templateUrl: '../js/setting/userRole/UserManageList.html',
            show: false,
            animation: 'am-fade-and-slide-top'
        });
        $scope.showModal2 = function (e) {
            $rootScope.role = {
                roleName: e.rolename,
                roleId: e.roleid
            }
            myModal2.$promise.then(myModal2.show);
        };
        $scope.hideModal2 = function () {
            myModal2.$promise.then(myModal2.hide);
        }

    });
})(angular);
