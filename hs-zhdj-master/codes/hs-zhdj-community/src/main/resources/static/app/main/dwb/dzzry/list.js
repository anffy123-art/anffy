(function ($app) {
    $app.module('gtPartyApp').controller('dzzglyListCtrl', function ($scope, $http, $modal, $ocLazyLoad, $alert, $loading, $state, $stateParams, AuthUser,$bsRouterState) {
        //定义数据集合
        $scope.dataList = []; //列表数据
        $scope.selectparams = {dwName: null}
        //查询
        $scope.search = function () {
            $scope.loadData();
        };
        $scope.$on('tabChildReloadData', function (event, data) {
            if (data.name == 'dzzglyListCtrl') {
                $scope.loadData();
            }
        });
        //加载列表数据
        $scope.loadData = function () {
            $http
            ({
                method: 'get', url: '../../api/dzzgly/list', params: $scope.selectparams
            }).then(function (result) {
                $scope.dataList = result.data.item.list;
            });
        };

        //修改
        $scope.editData = function (dzzdm, dwName, leader, leaderName) {
            $bsRouterState.go('home.dzzglyedit', {
                dzzdm: dzzdm,
                dwName: dwName,
                leader: leader,
                leaderName: leaderName
            });
        };

        $scope.loadData();
    });
})(angular);
