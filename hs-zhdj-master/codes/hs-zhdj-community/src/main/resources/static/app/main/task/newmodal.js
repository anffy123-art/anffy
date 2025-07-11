(function () {
    angular.module('dsfapp').controller("newmodelCtrl", function ($scope, $rootScope) {

        $scope.zz = "测试数据1";
        $scope.ze = $rootScope.aid;
        $scope.zc = $scope.$parent.aid;
    });
})();