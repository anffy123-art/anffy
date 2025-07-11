(function () {
    'use strict';
    angular.module('zcapp').controller("homeECtrl", function ($scope, $state, $http, AuthUser, $modal, $interval, $q, $filter) {

        var gsModal = {};//客服弹出框
        $scope.User = {};
        $scope.Company = {};
        $scope.panels = [];
        $scope.gsMsgInfo = {
            qdata: {userId: '', st: 0},
            msgCountInfo: []
        };
        //站点ID
        $scope.menudatas = {
            appkey: "epAppId",
            defrolekey: "DefaultRoleId",
            getMenuUrl: '../../api/user/getmenubyuid',
            toggle: true
        };

        $scope.notifyCount = 0;//通知数
        $scope.msgCount = 0;//消息数

        $scope.$watch("Company.selectedCompany", function (newVal) {
            if (newVal) {
                angular.extend($scope.Company, newVal);
                AuthUser.setExtData($scope.Company);
            }
        });

        $scope.getMenuList = function () {
            $http({
                method: 'post', url: $scope.menudatas.getMenuUrl, data: {
                    uid: $scope.User.Id,
                    appkey: $scope.menudatas.appkey,
                    defrolekey: $scope.menudatas.defrolekey
                }
            }).then(function (result) {
                if (result.data.success) {
                    $scope.menuList = result.data.item;
                    //$state.get('home');若路由不存在，返回null
                    //$state.is('home');若路由不存在，返回undifined;
                    if ($scope.menuList.length > 0) {
                        angular.forEach($scope.menuList, function (menu) {
                            //如果为父节点
                            if (menu.ParentMenuId == null || menu.ParentMenuId == "") {
                                var pmenu = {title: menu.MenuName, cNodes: [], icon: menu.MenuPic};
                                //遍历插入子节点
                                angular.forEach($scope.menuList, function (cli) {
                                    //截取路由
                                    var realstate = $scope.sliceStateName(cli.MenuNo);
                                    //路由是否存在,若存在则为原路由，若不存在，为空
                                    var isExisted = angular.isDefined($state.is(realstate)) ? cli.MenuNo : '';
                                    if (cli.ParentMenuId == menu.MenuId) pmenu.cNodes.push({
                                        title: cli.MenuName,
                                        name: isExisted,
                                        icon: cli.MenuPic
                                    });
                                });
                                $scope.panels.push(pmenu);
                            }
                        })
                    }
                    $scope.initActive();
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


        //用于截取路由name,
        //如:home.roleList({appid:"CBFAF886-D757-46B5-A856-763AEEF6D3D3"})---返回home.roleList
        $scope.sliceStateName = function (statename) {
            var index = statename.indexOf('(');
            if (index >= 0) {
                return statename.slice(0, index);
            }
            return statename;
        };


        //刷新页面时默认打开一级菜单
        $scope.initActive = function () {
            //当前路由name
            var statename = $state.current.name;
            angular.forEach($scope.panels, function (value, index) {
                angular.forEach(value.cNodes, function (item) {
                    //去掉参数的路由，如home.roleList({appid:"CBFAF886-D757-46B5-A856-763AEEF6D3D3"})，去参数路由：home.roleList
                    var realState = $scope.sliceStateName(item.name);
                    if (realState == statename) {
                        $scope.panels.activePanel = index;
                    }
                })
            });
        };

        $scope.loadCurUser = function () {

            $http.get("../../api/user/curloginuser", {params: {appkey: $scope.menudatas.appkey}}).then(function (res) {
                if (res.data.success) {
                    if (res.data.item) {
                        AuthUser.setUser(res.data.item);
                        AuthUser.setExtData(res.data.extdata);
                        //AuthUser.setlogin();
                        $scope.User = AuthUser.getUser();
                        $scope.Company = AuthUser.getExtData();
                        if ($scope.Company.companys != undefined && $scope.Company.companys.length > 0) {
                            $scope.Company.selectedCompany = $scope.Company.companys[0];
                            //$scope.getNotifyCount();
                        }
                        $scope.getMenuList();
                        if (res.data.extdata) {
                            $scope.initGsModal();
                        }

                        $interval(function () {
                            $scope.getNotifyCount();
                        }, 10000);

                    } else {
                        if ($state.params.uid) {
                            //本地登陆
                            $http.get("../../api/dsUser/GetCurUser?UserId=" + $state.params.uid).then(function (res) {
                                AuthUser.setUser(res.data);
                                $scope.User = AuthUser.getUser();
                            });
                        }
                    }

                } else {
                    //location.href = res.data.extdata + encodeURI(location.href);
                    AuthUser.clearUser();
                    $state.go("loginE");
                }

            });


        };

        $scope.logout = function () {
            AuthUser.clearUser();

            $state.go("loginE");

        };

        //客户端
        $scope.initGsModal = function () {
            gsModal = $modal({
                resolve: {
                    load: ['$ocLazyLoad', function ($ocLazyLoad) {
                        return $ocLazyLoad.load(['motion/gsimguest.css', 'motion/gsimguest.js']);
                    }]
                },
                scope: $scope,
                controller: 'gsMsgGuestCtrl',
                templateUrl: 'motion/gsimguest.html',
                show: false,
                animation: 'am-fade-and-slide-top',
                onBeforeHide: function () {
                    $scope.gsMsgInfo.deferfun = null;
                }
            });
            //客服信息类
            $scope.gsMsgInfo.deferfun = null;
            $scope.gsMsgInfo.qdata.userId = $scope.User.Id;

            //客户定时服务开始
            $scope.gsMsgInfo.timeService = $interval(function () {
                $http.get('../../api/gsmsg/guestunreadmsgs', {params: $scope.gsMsgInfo.qdata}).then(function (value) {
                    if (value.data.success) {
                        $scope.msgCount = $filter('filter')(value.data.item, {receiverID: $scope.User.Id}).length;
                        $scope.gsMsgInfo.qdata.userId = $scope.User.Id;
                        $scope.gsMsgInfo.deferData = value.data.item;
                        if ($scope.gsMsgInfo.deferfun) {
                            $scope.gsMsgInfo.deferfun(value.data.item);

                        }
                        ;
                    }
                }, function (reason) {

                });
            }, 10000);
        };

        $scope.showServerGuest = function () {
            gsModal.$promise.then(gsModal.show);
        };
        /*
        $scope.testPay = function () {
            //payRelID:'xxxxx1',
            $payService.payShow({
                amt: 0.01,
                payRelID: 'xxxxx2',
                companyID: '8c7d150b-9be7-4a06-a7cb-552a4ddc0ce9',
                creatorID: $scope.User.Id,
                commodityName: '测试微信'
            });
        }*/

        //获取通知数
        $scope.getNotifyCount = function () {
            if ($scope.Company.selectedCompany != null) {
                $http({
                    method: 'get',
                    url: '../../api/message/getMyMessageCount',
                    params: {companyId: $scope.Company.selectedCompany.companyID}
                }).then(function (result) {
                    $scope.notifyCount = result.data;
                }, function (resp) {

                });
            }
        };

        //获取未读消息数
        $scope.getMsgCount = function () {
            var loginUser = $scope.User;
            if (loginUser != null && loginUser.Id != null) {
                $http({
                    method: 'get',
                    url: '../../api/gsmsg/getMyUnreadMsgCount',
                    params: {userId: loginUser.Id}
                }).then(function (result) {
                    $scope.msgCount = result.data;
                }, function (resp) {

                });
            }
        };

        $scope.showNotify = function () {
            $state.go('homeE.myMessageList');
        };

        $scope.$on('$destroy', function (event) {
            if ($scope.gsMsgInfo.timeService) {
                $interval.cancel($scope.gsMsgInfo.timeService);
            }
        });
        /*
        if (AuthUser.islogin()) {
            $scope.User = AuthUser.getUser();
            $scope.getMenuList();
            $scope.initGsModal();
        } else {
            $scope.loadCurUser();
        }*/
        $scope.loadCurUser();


    }).factory("$industrySelect", ['$http', '$q', '$modal', function ($http, $q, $modal) {
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
        //config:{Scope:{当前的$scope},selectedKey:'',selectedText:'',selectedData:[],isMulti:true}
        reslut.initServer = function (config) {
            config.scope.$industryData = {$parent: reslut, $config: config};
            //添加更新事件
            config.scope.$watch("$industryData.$config.selectedKey", function (newVal, oldVal) {

            });


            reslut.myModal = $modal({
                resolve: {
                    load: ['$ocLazyLoad', function ($ocLazyLoad) {
                        $ocLazyLoad.load(['company/common/industrymodal.css']);
                        return $ocLazyLoad.load(['company/common/industrymodal.js']);
                    }]
                },
                scope: config.scope,
                controller: 'industryModalCtrl',
                templateUrl: 'company/common/industrymodal.html',
                show: false,
                animation: 'am-fade-and-slide-top'
            });
        };


        return reslut;
    }]);

})();