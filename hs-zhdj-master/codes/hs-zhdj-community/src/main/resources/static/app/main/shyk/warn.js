var warnCtrl = function ($scope, $http, $alert, $loading) {
    $scope.warnParams = warnModal.params;
    $scope.totalList = warnModal.params.totalList;
    $scope.partyName = warnModal.params.partyName;
};

//定义模态框
var warnModal;