(function ($app) {
    "use strict";
    $app.module('dsfapp').controller('taskHandle', function ($scope, $state, $alert, AuthUser, flowaudit, $http, $window) {
        //加载对应工作流的需求对应的任务信息
        $scope.proman = "";
        $scope.DoneTime = "";
        $scope.fileList = $scope.flowdata.flowFileModel.fileList;//功能点模板等文件
        $scope.folderlist = $scope.flowdata.flowFileModel.folderlist;//其它附件等

        $scope.user = AuthUser.getUser();
        if ($scope.user != null) {
            $scope.proman = $scope.user.Name;
        }
        //接收广播
        $scope.$on("toTaskManage", function (event, tar) {

        });
        $scope.downfile = function (url) {
            $window.open(url);
        }
    });
})(angular);