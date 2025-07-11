(function ($app) {
    $app.module('gtPartyApp').controller('assetShowCtrl', function ($scope, $http, $modal, $ocLazyLoad, $alert, $loading, $state, $bsRouterState, AuthUser, $timeout) {
        $stateParams = $bsRouterState.$params($scope);

        $scope.op = $stateParams.op;

        //定义数据集合
        $scope.dataModel = {
            assetid: $stateParams.assetid == undefined ? "" : $stateParams.assetid
        };
        $scope.assetLogList = [];

        $scope.getData = function () {
            $http.get("../../api/asset/getAssetById", {
                params: {
                    'id': $scope.dataModel.assetid
                }
            }).then(function (result) {
                $scope.dataModel = result.data.item;
                $scope.$emit('toParentParams', {
                    assetModel: $scope.dataModel
                });

                $scope.getList();
            }, function () {
                $scope.showMsg('错误', '服务器错误');
            });
        };
        //加载列表数据
        $scope.getList = function () {
            $http
            ({
                method: 'get', url: '../../api/asset/getAssetLogList', params: {id:$scope.dataModel.assetid}
            }).then(function (result) {
                $scope.assetLogList = result.data.item;
            }, function (res) {
                $scope.showMsg('错误', '服务器错误');
            });
        };
        //加载数据
        $scope.getData();

        $scope.pagechange = function () {
            $bsRouterState.$closeTab($scope);
        };


    });
})(angular);