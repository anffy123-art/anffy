(function ($app) {
    $app.module('gtPartyApp').controller('assetMaintainListCtrl', function ($scope, $http, $modal, $ocLazyLoad, $alert, $loading, $state, $bsRouterState, AuthUser, $timeout, $excel) {
        $state.params = $bsRouterState.$params($scope);
        $scope.isShow = false;
        $scope.moreTxt = "更多";
        $scope.loginUserId = AuthUser.getUser().Id;

        //定义数据集合
        $scope.dataList = []; //列表数据
        //组织树参数
        $scope.treeparams = {
            isunfold: false,//组织结构树展开收缩
            selectdzzdm: "",
            selectdzzmc: "",
            defaultselected: $state.params.dzzdm
        };
        //查询条件
        $scope.selectparams = {
            pageIndex: 1,
            pageSize: 10,
            dzzdm: '',
            no: '',
            name: '',
            beginDate: '',
            endDate: ''
        };
        $scope.resetparams = {};
        $scope.pageInfo = {ptotal: 0};
        angular.extend($scope.resetparams, $scope.selectparams);

        //加载列表数据
        $scope.getList = function () {
            $http
            ({
                method: 'get', url: '../../api/asset/getMaintainList', params: $scope.selectparams
            }).then(function (result) {
                $scope.dataList = result.data.item.list;
                $scope.pageInfo.ptotal = result.data.item.total;
            }, function (res) {
                $scope.showMsg('错误', '服务器错误');
            });
        };

        $scope.search = function () {
            $scope.getList();
        };
        $scope.reset = function () {
            $scope.selectparams = [];
            angular.extend($scope.selectparams, $scope.resetparams);
            $scope.pageInfo = {ptotal: 0};
            $scope.getList();
        };
        $scope.add = function () {
            $bsRouterState.$closeTabName("home.assetMaintainAdd");
            $timeout(function () {
                $bsRouterState.go('home.assetMaintainAdd', {
                    id: ""
                });
            }, 100);
        };
        $scope.edit = function (id) {
            $bsRouterState.$closeTabName("home.assetMaintainEdit");
            $timeout(function () {
                $bsRouterState.go('home.assetMaintainEdit', {
                    id: id
                });
            }, 100);
        };
        $scope.show = function (id,assetid) {
            $bsRouterState.$closeTabName("home.assetMaintainShow");
            $timeout(function () {
                $bsRouterState.go('home.assetMaintainShow', {id: id,assetid:assetid});
            }, 100);
        };
        $scope.delete = function (id) {
            if (confirm("是否确定删除？")) {
                $http({
                    url: "../../api/asset/deteleMaintain",
                    method: 'GET',
                    params: {id: id}
                }).then(function (result) {
                    $scope.showMsg("消息", result.data.msg);
                    if (result.data.success) {
                        $scope.getList();
                    }
                });
            }
        };

        $scope.$watch("selectparams.pageIndex", function (newVal, oldVal) {
            if ($scope.pageInfo.ptotal > 0) {
                $scope.getList();
            }
        });
        $scope.$watch("treeparams.selectdzzdm", function (newVal, oldVal) {
            if (newVal != "") {
                if ($scope.treeparams.defaultselected != "" && $scope.treeparams.defaultselected != null &&
                    $scope.treeparams.defaultselected != $scope.treeparams.selectdzzdm)
                    return;

                $scope.selectparams.dzzdm = $scope.treeparams.selectdzzdm;

                $scope.getList();
            }
        });

        $scope.$on('tabChildReloadData', function (event, data) {
            if (data.name == 'assetMaintainListCtrl') {
                $scope.getList();
            }
        });

        $scope.isShowClick = function () {
            $scope.isShow = !$scope.isShow;
            if ($scope.moreTxt == "更多") {
                $scope.moreTxt = "收起";
            } else if ($scope.moreTxt == "收起") {
                $scope.moreTxt = "更多";
            }
        };
        $scope.setisunfold = function () {
            $scope.treeparams.isunfold = !$scope.treeparams.isunfold;
            $scope.$emit('menudatas.toggle', !$scope.treeparams.isunfold);
        };

    });
})(angular);