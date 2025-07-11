var successCtrl = function ($scope, $state, $http, $alert, $loading) {
    $scope.confirmMsg = function () {
        $scope.$hide();
        $state.go("localLogin");
    };
};

//定义模态框
var successModal;