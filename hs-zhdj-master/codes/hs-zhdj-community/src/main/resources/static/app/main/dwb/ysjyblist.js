(function ($ang) {
    'use strict';
    $ang.module('gtPartyApp').controller('ysjyblistCtrl', function ($scope, $http, $alert, $modal, AuthUser, $state, $loading, $window, $timeout,$bsRouterState) {
        $scope.selectdata = {
            'pageindex': 1,
            'pagesize': 10,
            uid: AuthUser.getUser().DGUserID,
            nd: null,
            ptotal: 0,
        };
        $scope.pageInfo = {ptotal: 0};
        $scope.ndList = [];
        $scope.items = [];

        $scope.loadData = function () {
            $loading.show();
            $http({
                url: "../../api/jfys/YsjybList",
                method: 'GET',
                params: $scope.selectdata
            }).then(function (rq) {
                $scope.items = rq.data.item.list;
                $scope.pageInfo.ptotal = rq.data.item.total;
                $loading.hide();
            });
        }
        //监视页数变化
        $scope.$watch("selectdata.pageindex", function (newVal, oldVal) {
            if ($scope.pageInfo.ptotal > 0) {
                $scope.loadData();
            }
        });
        //查询
        $scope.search = function () {
            $scope.loadData();
        };
        //获取年度
        $scope.getNdList = function () {
            $http({
                method: 'get',
                url: '../../api/dictionary/GetDictionaryList',
                params: {dicTypeKey: 'years'}
            }).then(function (result) {
                $scope.ndList = result.data.item.list;
            }, function (resp) {
            });
        };
        $scope.delItem = function (id) {
            if (confirm('是否删除党组织工作经费预算建议表？')) {
                $loading.show();
                $http({
                    method: 'get',
                    url: '../../api/jfys/DelJfysb',
                    params: {
                        jfysbid: id
                    }
                }).then(function (result) {
                    $scope.search();
                    $loading.hide();
                }, function (resp) {
                    $loading.hide();
                });
            }
        };
        $scope.editModal = function (nd) {
            $bsRouterState.go('home.ysjybedit', {nd:nd});
        };

        $scope.$on('tabChildReloadData', function (event, data) {
            if (data.name == 'ysjyblistCtrl') {
                $scope.loadData();
            }
        });
        $scope.getNdList();
        $scope.loadData();
    })
})(angular);