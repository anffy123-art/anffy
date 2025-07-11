(function () {
    'use strict';
    angular.module('gtPartyApp').controller("homeCtrl", function ($scope, $state, $http, AuthUser, $modal, $interval, $q, $filter, $loading, $bsfiles, $alert, $bsRouterState,$timeout,$rootScope,$desData) {

        var gsModal = {};//客服弹出框
        $scope.userOnlineIsOut=false;
        $scope.sysName=window.sysCompanyName;
        $scope.userOnlineActivityFun=function(){
            //判断是否已经退出登陆
            if($scope.userOnlineIsOut){
                return;
            }
            $http.post("../../api/home/setOnlineUser", {
                uid: AuthUser.getUser().Id
            }).then(function (res) {
                if(res.data.success){
                    $timeout($scope.userOnlineActivityFun,60*1000);
                } else {
                    $scope.loginOutCookie();
                }

            });
        };
        $scope.User = {name: ''};
        $scope.panels = [];
        $scope.gsMsgInfo = {
            qdata: {userId: '', st: 1},
            msgCountInfo: []
        };
        $scope.roleName = '';

        $scope.roleList = [];
        //站点ID
        $scope.menudatas = {
            appkey: "appId",
            defrolekey: "DefaultRoleId",
            getMenuUrl: '../../api/user/getmenubyuid',
            toggle: true
        };

        /*$scope.$on("menudatas.toggle", function (event, data) {
            $scope.menudatas.toggle = data;
            $rootScope.menuToggle = $scope.menudatas.toggle;
        });*/

        $scope.toggleClick = function () {
            //$scope.menudatas.toggle = !$scope.menudatas.toggle;
            $rootScope.menuToggle = !$rootScope.menuToggle;
        };

        $scope.$watch('roleList.selectedId', function (newVal, oldVal) {
            if (newVal != undefined && newVal != '') {
                //修改选择角色
                $scope.User.curRoleId = newVal;
                AuthUser.setUser($scope.User);
                $bsRouterState.tabs.length=0;
                $scope.getMenuList(newVal);
                $scope.getUserDataScope();
            }
        });

        $scope.getMenuList = function (roleId) {
            // $scope.pictureurl = "../../api/home/showImg/" + $scope.User.Id;
            //$scope.menuList.length=0;
            $scope.menuList = [];
            $scope.panels.length = 0;


            $http({
                method: 'post', url: $scope.menudatas.getMenuUrl, data: {
                    uid: $scope.User.id,
                    appkey: $scope.menudatas.appkey,
                    defrolekey: $scope.menudatas.defrolekey,
                    roleId: roleId,
                    dwId:$scope.User.dwId
                }
            }).then(function (result) {
                if (result.data.success) {
                    $scope.menuList = result.data.item;
                    //$state.get('home');若路由不存在，返回null
                    //$state.is('home');若路由不存在，返回undifined;
                    if ($scope.menuList.length > 0) {

                        $scope.buildMenuTree();
                        $scope.initActive($scope.panels);

                    }
                } else {
                    $alert({
                        title: '错误：',
                        content: result.data.msg,
                        placement: 'centre',
                        type: 'info',
                        show: true,
                        duration: 3
                    });
                }

            });
        };

        //查询数据权限范围
        $scope.getUserDataScope = function () {
            $http.get("../../api/user/getUserDataScope", {
                params: {
                    userId: AuthUser.getUser().Id,
                    roleId: AuthUser.getUser().curRoleId
                }
            }).then(function (res) {
                $scope.User.dataScope = res.data.dataScope;
                $scope.User.dataDzzdm = res.data.dataDzzdm;
                AuthUser.setUser($scope.User);

                $bsRouterState.$showTab($bsRouterState.defaults.initTabName,{});
                //tabs.

            });
        };

        //begin菜单树方法
        {
            //构建菜单树
            $scope.buildMenuTree = function () {
                angular.forEach($scope.menuList, function (menu) {
                    //如果为父节点
                    if (menu.PARENTMENUID == null || menu.PARENTMENUID == "") {
                        //截取路由
                        var realstate = $scope.sliceStateName(menu.MENUNO);
                        //路由是否存在,若存在则为原路由，若不存在，为空
                        var isExisted = angular.isDefined($state.is(realstate)) ? menu.MENUNO : '';
                        var pmenu = {
                            id: menu.MENUID,
                            title: menu.MENUNAME,
                            icon: menu.MENUPIC,
                            name: isExisted,
                            url: menu.MENUNO,
                            isblank: menu.ISBLANK,
                            cNodes: [], //子节点
                            childShow: 0, //子节点是否显示，0不显示，1显示
                            parentid: 'maincode',//父级id
                            parentIds: 'maincode' //父级id集合
                        };
                        //遍历插入子节点
                        pmenu.cNodes = $scope.getChildMenus(pmenu);
                        $scope.panels.push(pmenu);
                    }
                })
            };
            //递归获取子菜单
            $scope.getChildMenus = function (parent) {
                var cNodes = [];
                angular.forEach($scope.menuList, function (cli) {
                    //截取路由
                    var realstate = $scope.sliceStateName(cli.MENUNO);
                    //路由是否存在,若存在则为原路由，若不存在，为空
                    var isExisted = angular.isDefined($state.is(realstate)) ? cli.MENUNO : '';
                    if (cli.PARENTMENUID == parent.id) {
                        var climenu = {
                            id: cli.MENUID,
                            title: cli.MENUNAME,
                            name: isExisted,
                            icon: cli.MenuPic,
                            url: cli.MENUNO,
                            isblank: cli.ISBLANK,
                            cNodes: [],
                            childShow: 0,
                            parentid: cli.PARENTMENUID,
                            parentIds: parent.parentIds + '.' + cli.PARENTMENUID
                        };

                        climenu.cNodes = $scope.getChildMenus(climenu);
                        cNodes.push(climenu);
                    }
                });
                return cNodes;
            };
            //点击菜单事件
            $scope.menutoggle = function (node) {
                var childShow = node.cNodes.length > 0 ? (node.childShow > 0 ? 0 : 1) : 1;
                var codes = node.parentIds.split('.');
                codes.push(node.id);
                $scope.resetActive($scope.panels, codes);
                node.childShow = childShow;
            };
            //重置菜单选中项
            $scope.resetActive = function (list, codes) {
                angular.forEach(list, function (node, index) {
                    var index = $.inArray(node.id, codes);
                    node.childShow = index >= 0 ? 1 : 0;
                    if (node.cNodes != null && node.cNodes.length > 0) {
                        $scope.resetActive(node.cNodes, codes);
                    }
                });
            };
            //刷新页面时默认打开菜单
            $scope.initActive = function (menuList) {
                //当前路由name
                var statename = $state.current.name;
                angular.forEach(menuList, function (value, index) {
                    var p_realState = $scope.sliceStateName(value.name);
                    if (p_realState == statename) {
                        $scope.menutoggle(value);
                    }
                    $scope.initActive(value.cNodes);
                });
            };

            //用于截取路由name,
            //如:home.roleList({appid:"CBFAF886-D757-46B5-A856-763AEEF6D3D3"})---返回home.roleList
            $scope.sliceStateName = function (statename) {
                var index = statename.indexOf('(');
                if (index >= 0) {
                    return statename.slice(0, index);
                }
                return statename;
            };
        }
        //end

        $scope.loadUserRole = function (userid) {
            $http.get("../../api/userrole/GetRolesById", {
                params: {
                    appid: '',
                    rolename: '',
                    userId: userid
                }
            }).then(
                function (req) {
                    if (req.data.success) {

                        //$scope.roleList = $filter('orderBy')(req.data.item, '-orderby');
                        $scope.roleList = req.data.item;
                        $scope.roleName = $scope.roleList[0].rolename;
                        var roleId=AuthUser.getUser().curRoleId;
                        //$scope.roleList.selectedId =roleId==null||roleId=='null'?$scope.roleList[0].roleid:roleId;
                        $scope.roleList.selectedId =roleId?$scope.roleList[0].roleid:roleId;
                        //$scope.getMenuList($scope.roleList.selectedId);
                    }
                }
            );

        };

        $scope.loadCurUser = function () {

            $http.get("../../api/user/curloginuser", {params: {appkey: $scope.menudatas.appkey}}).then(function (res) {
                if (res.data.success) {
                    if (res.data.item) {
                        //angular.extend(res.data.item, {dataDzzdm: res.data.extdata.dataDzzdm});
                        angular.extend(res.data.item, {gddwdm: res.data.extdata.gddwdm});
                        angular.extend(res.data.item, {userType: res.data.extdata.userType});
                        //angular.extend(res.data.item, {dataScope: res.data.extdata.dataScope});
                        angular.extend(res.data.item, {dwId: res.data.extdata.dwId});
                        angular.extend(res.data.item, {dwName: res.data.extdata.dwName});
                        angular.extend(res.data.item, {oaUserId: res.data.extdata.oaUserId});
                        angular.extend(res.data.item, {oaIdCard: res.data.extdata.oaIdCard});
                        angular.extend(res.data.item, {generalPartyCode: res.data.extdata.generalPartyCode});

                        $scope.loadUserRole(res.data.item.id);
                        $bsRouterState.loadTabMenu();
                        $scope.pictureurl = "../../api/home/showDbImg/" + res.data.item.id;
                        AuthUser.clearExtData();
                        //AuthUser.setlogin();
                        $scope.User = res.data.item;
                        $scope.User.isServerMan = res.data.extdata != null ? res.data.extdata.isServerMan : false;
                        //开始心跳查询是否超时
                        $scope.userOnlineActivityFun();
                        //$scope.getMenuList();

                        //$scope.initGsModal();
                    }
                } else {
                    AuthUser.clearUser();
                    $state.go("localLogin");
                }

            });


        };

        $scope.loginOutCookie=function(){

            $scope.userOnlineIsOut=true;
            $http.get("../../api/home/logout",{
                params:{
                        uid:AuthUser.getUser().Id
                    }
            }).then(function (req) {
                if (req.data.success) {
                    $bsRouterState.tabs.length = 0;
                    //window.open("../public/index.html", "_self");
                }
                /*
                else {
                    $alert({
                        title: '提示',
                        content: '退出成功，清理缓存失败：' + req.data.msg,
                        placement: 'top',
                        type: 'info',
                        show: true,
                        duration: 3
                    });
                }*/
                $rootScope.menuToggle=true;
                AuthUser.clearUser();
                $state.go("localLogin");

            }, function (err) {

                $alert({
                    title: '错误：',
                    content: '退出失败，请重试：' + angular.toJson(err),
                    placement: 'top',
                    type: 'info',
                    show: true,
                    duration: 3
                });
                $state.go("localLogin");
            });
        };

        $scope.logout = function () {

            if (confirm('是否退出登录？')) {
                $scope.loginOutCookie();
            }
        };

        var editPasswordCtrl = function ($scope, $http) {
            $scope.params = passwordModal.params;
            $scope.uservm = passwordModal.uservm;
            $scope.userinfovm = passwordModal.userinfovm;
            $scope.pwd = {
                pwd_default: '',
                pwd_confirm: ''
            };

            $scope.submitUser = function (isflag) {
                if (isflag) {
                    if ($scope.pwd.pwd_default != $scope.pwd.pwd_confirm) {
                        $scope.showMsg('失败', "两次输入的密码不一致！");
                        return;
                    }

                    //$scope.uservm.userpwd = $scope.pwd.pwd_default;

                    var data = $desData.GetToken($scope.uservm.userid + '|' + $scope.pwd.pwd_default);

                    $loading.show();
                    $http({
                        method: "post",
                        url: "../../api/user/updatePassword",
                        data: data
                    }).then(function (result) {
                        $loading.hide();
                        if (result.data.success) {
                            $scope.showMsg('成功', result.data.msg);
                            $scope.$hide();
                        } else {
                            $scope.showMsg('失败', result.data.msg);
                        }

                    }), function (resp) {
                        $scope.showMsg('错误', '服务器错误');
                    }
                }
            }
        };
        editPasswordCtrl.$inject = ['$scope', '$http'];
        //定义模态框
        var passwordModal = $modal({
            resolve: {
                load: ['$ocLazyLoad', function ($ocLazyLoad) {
                    //return [$ocLazyLoad.load('../main/user/edituser.css')];
                }]
            },
            scope: $scope,
            controller: editPasswordCtrl,
            templateUrl: '../main/user/editPassword.html',
            show: false,
            animation: 'am-fade-and-slide-top'
        });
        $scope.updatePwd = function () {

            passwordModal.params = {};
            $http.get("../../api/user/getUserByID", {params: {'id': AuthUser.getUser().Id}}).then(function (result) {
                passwordModal.uservm = result.data.extdata.userModel;
                passwordModal.userinfovm = result.data.item;
                passwordModal.$promise.then(passwordModal.show);
            }, function () {
                $scope.showMsg('错误', '服务器错误');
            });

        };

        $scope.showMsg = function (title, content) {
            $alert({
                title: title + '：',
                content: content,
                placement: 'top',
                type: 'info',
                show: true,
                duration: 3
            });

        };

        $scope.loadCurUser();

        //Set Waves
        Waves.attach('.menu .list a', ['waves-block']);
        Waves.init();
    }).directive('activateInput', ['$timeout', function ($timeout) {

        var activateFun = function ($element) {
            $element.find('.form-control').focus(function () {
                $(this).parent().addClass('focused');
            });

            //On focusout event
            $element.find('.form-control').focusout(function () {
                var $this = $(this);
                if ($this.parents('.form-group').hasClass('form-float')) {
                    if ($this.val() == '') {
                        $this.parents('.form-line').removeClass('focused');
                    }
                } else {
                    $this.parents('.form-line').removeClass('focused');
                }
            });

            //On label click
            $('body').on('click', '.form-float .form-line .form-label', function () {
                //$(this).parent().find('input').focus();
            });

            //Not blank form
            $element.find('.form-control').each(function () {
                if ($(this).val() !== '') {
                    //$(this).parents('.form-line').addClass('focused');
                }
            });
        };

        var directiveObject = {
            restrict: 'AC',
            link: function (scope, element, attr, controller) {
                $timeout(function () {
                    activateFun(element);
                }, 50);
            }

        };
        return directiveObject;
    }]).factory("$partySelect", ['$http', '$q', '$modal', function ($http, $q, $modal) {
        var reslut = {
            myModal: {}
        };

        reslut.showModal = function () {
            var deferred = $q.defer();
            if (reslut.myModal) {
                reslut.myModal.$promise.then(reslut.myModal.show);
            }
            return deferred.promise;
        };
        //config:{Scope:{当前的$scope},selectedKey:'',selectedText:'',selectedData:[],isMulti:true,isshowxz:0,parentcode:'',parentname:'',szdzzdm:'',szdzzmc:''}
        reslut.initServer = function (config) {
            config.scope.$partyData = {$parent: reslut, $config: config};
            //添加更新事件
            config.scope.$watch("$partyData.$config.selectedKey", function (newVal, oldVal) {

            });


            reslut.myModal = $modal({
                resolve: {
                    load: ['$ocLazyLoad', function ($ocLazyLoad) {
                        $ocLazyLoad.load(['common/partymodal.css']);
                        return $ocLazyLoad.load(['common/partymodal.js']);
                    }]
                },
                scope: config.scope,
                controller: 'partyModalCtrl',
                templateUrl: 'common/partymodal.html',
                show: false,
                animation: 'am-fade-and-slide-top'
            });
        };


        return reslut;
    }]).directive('activateSelect', ['$timeout', function ($timeout) {

        // var activateFun = function (scope, $element) {
        //     var _this = $element;
        //
        //     /* if ($.fn.selectpicker) {
        //          $('select:not(.ms)').selectpicker();
        //      }*/
        //
        //
        //     $.each($element.find("select"), function (i, node) {
        //
        //         scope.$watch(function () {
        //             return node.childNodes.length;
        //         }, function (newVal, oldVal) {
        //             $(node).selectpicker('refresh');
        //         });
        //     });
        // };

        var directiveObject = {
            restrict: 'AC',
            link: function (scope, element, attr, controller) {
                // activateFun(scope, element);
                // //activateFun(scope,element);
                // //activateFun(scope,element);
                // element.find('.btn-reset').on('click',function () {
                //     $timeout(function () {
                //         activateFun(scope,element);
                //     },200);
                //
                // });
                // $timeout(function () {
                //     activateFun(scope, element);
                // }, 200);
            }

        };
        return directiveObject;
    }]).filter('ceil', function() { return function(input) { return Math.ceil(input); }; }); ;

})();
