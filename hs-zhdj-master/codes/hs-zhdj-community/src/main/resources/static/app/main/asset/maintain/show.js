(function ($app) {
    $app.module('gtPartyApp').controller('assetMaintainShowCtrl', function ($scope, $http, $modal, $ocLazyLoad, $alert, $loading, $state, $bsRouterState, AuthUser, $timeout, $partySelect) {
        $stateParams = $bsRouterState.$params($scope);

        //定义数据集合
        $scope.dataModel = {
            id: $stateParams.id,
            assetid: $stateParams.assetid
        };
        $scope.assetModel = {};

        $scope.getData = function () {
            $http.get("../../api/asset/getMaintainById", {
                params: {
                    'id': $scope.dataModel.id
                }
            }).then(function (result) {
                $scope.dataModel = result.data.item;
            }, function () {
                $scope.showMsg('错误', '服务器错误');
            });
        };

        $scope.loadAsset = function () {
            $scope.$broadcast("toParams", {id: $scope.dataModel.assetid || '', op: 1});
        };

        $scope.$on("toParentParams", function (event, tar) {
            $scope.assetModel = tar.assetModel;
        });

        $scope.pagechange = function () {
            $bsRouterState.$closeTab($scope);
        };

        $scope.getData();

    });
})(angular);