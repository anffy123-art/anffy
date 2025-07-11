(function ($ang, win) {
    $app.module('fgpwapp').controller('forgotPasswordCtrl', function ($scope, $http, $modal, $ocLazyLoad, $alert, $loading, $state) {
        $scope.title = "找回密码";

        //初始化查询参数
        $scope.loginuser = {
            'uid': null,
            'email': null,
        };

        $scope.send = function () {

        }
    });
})(angular, this);