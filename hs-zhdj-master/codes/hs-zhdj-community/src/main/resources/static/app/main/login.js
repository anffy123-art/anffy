(function ($ang, win) {
    'use strict';
    $ang.module('gtPartyApp').controller("loginCtrl", ['$scope', '$state', '$http', '$loading', '$alert', '$desData', '$modal', 'AuthUser', function ($scope, $state, $http, $loading, $alert, $desData, $modal, AuthUser) {
        $scope.loginuser = {uid: '', pwd: ''};

        $scope.sysName = window.sysCompanyName;

        $scope.reset = function () {
            $scope.loginuser.uid = '';
            $scope.loginuser.pwd = '';
        };
        $scope.errorMsg = '';

        //站点ID
        $scope.menudatas = {
            appkey: "appId",
            defrolekey: "DefaultRoleId",
            getMenuUrl: '../../api/user/getmenubyuid',
            toggle: true
        };

        $scope.loadCurUser = function () {

            $http.get("../../api/user/curloginuser", {params: {appkey: $scope.menudatas.appkey}}).then(function (res) {
                if (res.data.success) {
                    if (res.data.item) {

                        angular.extend(res.data.item, {dataDzzdm: res.data.extdata.dataDzzdm});
                        angular.extend(res.data.item, {gddwdm: res.data.extdata.gddwdm});
                        angular.extend(res.data.item, {userType: res.data.extdata.userType});
                        angular.extend(res.data.item, {dataScope: res.data.extdata.dataScope});
                        angular.extend(res.data.item, {dwId: res.data.extdata.dwId});
                        angular.extend(res.data.item, {dwName: res.data.extdata.dwName});
                        angular.extend(res.data.item, {oaUserId: res.data.extdata.oaUserId});
                        angular.extend(res.data.item, {oaIdCard: res.data.extdata.oaIdCard});
                        angular.extend(res.data.item, {generalPartyCode: res.data.extdata.generalPartyCode});

                        AuthUser.setUser(res.data.item);

                        AuthUser.clearExtData();
                        $state.go('homeTabs');
                    }
                }

            });


        };

        $scope.chechUserAgent = function () {
            if (win.navigator.userAgent.toLocaleLowerCase().indexOf('chrome') < 0) {
                $alert({
                    title: '消息',
                    content: '非谷歌浏览器浏览本网站可能出现排版错误，请点击右上方下载浏览器，以体验最好浏览效果！',
                    placement: 'bottom',
                    type: 'info',
                    show: true,
                    duration: 5
                });
            }
        };

        $scope.chechUserAgent();

        $scope.loadCurUser();


        $scope.login = function () {

            var tk = $scope.loginuser.uid + '|' + $scope.loginuser.pwd;
            $loading.show();
            AuthUser.clearUser();
            $http.post('../../api/home/login', $desData.GetToken(tk)).then(function (req) {
                $loading.hide();
                if (req.data.success) {
                    $state.go("homeTabs");
                } else {

                    $scope.errorMsg = req.data.msg;
                }
            }, function (reason) {
                $loading.hide();
            });

        };

        $scope.getLastActiveDate = function (uid) {
            //var uid = encodeURI(encodeURI(uid));
            $http({
                method: "post",
                url: "../../api/home/getLastActivityDate",
                params: {
                    uid: uid
                }
            }).then(function (req) {
                if (req.data.success) {
                    $state.go("home.todolist");
                } else {
                    $scope.changePassword();
                }
            }, function (reason) {
                $loading.hide();
            });
        }

        var forgotPasswordCtrl = function ($scope, $http) {
            // $scope.params = parkModal.params;
            // $scope.parkvm = parkModal.parkvm;
            $scope.sendPassword = function (isflag) {
                if (isflag) {
                    $loading.show();
                    $http({
                        method: "post",
                        url: "../../api/home/sendPassword",
                        data: $scope.loginuser
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
        forgotPasswordCtrl.$inject = ['$scope', '$http'];

        var parkModal = $modal({
            resolve: {
                load: ['$ocLazyLoad', function ($ocLazyLoad) {
                    //return [$ocLazyLoad.load('../main/css/theme1.css')];
                }]
            },
            scope: $scope,
            controller: forgotPasswordCtrl,
            templateUrl: '../main/forgotPassword.html',
            show: false,
            animation: 'am-fade-and-slide-top'
        });

        $scope.forgotPassword = function () {
            $scope.forgot("找回密码");
        };
        $scope.forgot = function (title) {
            parkModal.params = {
                title: title,
                reqFileModelOfService: {
                    loginuser: {FileRefID: '', pageindex: 1, pagesize: 10, ptotal: 0},
                    filetype: 1,
                    items: [],
                    readonly: false
                }
            };
            $loading.show();
            $http.get("../../api/home/forgotPassword").then(function (result) {
                $loading.hide();
                parkModal.parkvm = null;
                // parkModal.params.reqFileModelOfService.selectdata.FileRefID = result.data.item.servicefileid;
                parkModal.$promise.then(parkModal.show);
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
        $loading.hide();

        var updatepassword = function ($scope, $http) {
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
                        return;
                    }

                    $scope.uservm.userpwd = $scope.pwd.pwd_default;

                    $loading.show();
                    $http({
                        method: "post",
                        url: "../../api/user/updatePassword",
                        data: {
                            userModel: $scope.uservm
                        }
                    }).then(function (result) {
                        $loading.hide();
                        if (result.data.success) {
                            $scope.showMsg('成功', result.data.msg);
                            $scope.$hide();
                            $state.go("home.todolist");
                        } else {
                            $scope.showMsg('失败', result.data.msg);
                        }

                    }), function (resp) {
                        $scope.showMsg('错误', '服务器错误');
                    }
                }
            }
        };

        var passwordModal = $modal({
            resolve: {
                load: ['$ocLazyLoad', function ($ocLazyLoad) {
                    //return [$ocLazyLoad.load('../main/user/edituser.css')];
                }]
            },
            scope: $scope,
            controller: updatepassword,
            templateUrl: '../main/firstEditPassword.html',
            show: false,
            animation: 'am-fade-and-slide-top'
        });

        $scope.changePassword = function () {
            var username = $scope.loginuser.uid;
            passwordModal.params = {};
            $http.get("../../api/user/getUserByUserName", {params: {'username': username}}).then(function (result) {
                passwordModal.uservm = result.data.extdata.userModel;
                passwordModal.userinfovm = result.data.item;
                passwordModal.$promise.then(passwordModal.show);
            }, function () {
                $scope.showMsg('错误', '服务器错误');
            });
        };
        $loading.hide();
    }]).controller("loginECtrl", ['$scope', '$state', '$http', '$loading', '$alert', '$desData', 'AuthUser', function ($scope, $state, $http, $loading, $alert, $desData, AuthUser) {
        $scope.loginuser = {uid: '', pwd: ''};
        $scope.sysName = window.sysCompanyName;

        $scope.reset = function () {
            $scope.loginuser.uid = '';
            $scope.loginuser.pwd = '';
        };

        $scope.login = function () {

            var tk = $scope.loginuser.uid + '|' + $scope.loginuser.pwd;
            $loading.show();
            AuthUser.clearUser();
            $http.post('../../api/home/locallogin', $desData.GetToken(tk)).then(function (req) {
                $loading.hide();
                if (req.data.success) {
                    $state.go("homeTabs");
                } else {
                    $scope.errorMsg = req.data.msg;
                }
            }, function (reason) {
                $loading.hide();
            });

        };

        $scope.apply = function () {
            $state.go("register");
        };

        $loading.hide();
    }]);
})(angular, this);
