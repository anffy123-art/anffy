(function ($app) {
    $app.module('gtPartyApp').controller('learningSecretaryListCtrl', function ($scope, $http, $modal, $ocLazyLoad, $alert, $loading, $state, $stateParams, AuthUser,$bsRouterState) {

        $stateParams=$bsRouterState.$params($scope);
        //定义数据集合
        $scope.dataList = []; //列表数据
        $scope.selectparams = {
            isunfold: false,//组织结构树展开收缩
            'pageindex': 1,
            'pagesize': 10,
             userId :  AuthUser.getUser().Id,
            roleId:AuthUser.getUser().curRoleId
        };
        $scope.pageInfo = {ptotal: 0};
        //监视页数变化
        $scope.$watch("selectparams.pageindex", function (newVal, oldVal) {
            if ($scope.pageInfo.ptotal > 0) {
                $scope.loadData();
            }
        });

        $scope.$on('tabChildReloadData',function (event,data) {
            if(data.name=='learningSecretaryListCtrl'){
                $scope.loadData();
            }
        });

        //查询
        $scope.search = function () {
            $scope.loadData();
        };
        //加载列表数据
        $scope.loadData = function () {
            $http
            ({
                method: 'get', url: '../../api/zxzxx/xxms/list', params: $scope.selectparams
            }).then(function (result) {
                $scope.dataList = result.data.item.list;
                $scope.pageInfo.ptotal = result.data.item.total;
            });
        };

        //修改
        $scope.editData = function (id,dzzdm,dwName,rydm,msName) {
            $bsRouterState.go('home.learningSecretaryAdd', {
                id:id,
                dzzdm: dzzdm,
                dwName: dwName,
                rydm: rydm,
                msName: msName
            });
        };

        $scope.loadData();
    });
})(angular);