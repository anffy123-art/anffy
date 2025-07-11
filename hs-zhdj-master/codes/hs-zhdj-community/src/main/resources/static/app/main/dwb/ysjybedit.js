(function ($ang) {
    'use strict';
    $ang.module('gtPartyApp').controller('ysjybeditCtrl', function ($scope, $http, $alert, $modal, AuthUser, $state, $loading, $window, $timeout,$stateParams,$bsRouterState) {

        $stateParams=$bsRouterState.$params($scope);

        $scope.formmodel = {
            cjr: AuthUser.getUser().Id,
            nd: $stateParams.nd,
            ptotal: 0,
        };
        $scope.hdbzmodel = {
            v1: '',
            v2: '',
            v3: '',
            v4: '',
            hdbz: ''
        };
        $scope.items = [];

        $scope.loadData = function () {
            $loading.show();

            $http({
                url: "../../api/jfys/YsjybmxList",
                method: 'GET',
                params: $scope.formmodel
            }).then(function (rq) {
                $scope.items = rq.data.item;
                $scope.formmodel.ptotal = rq.data.total;
                $loading.hide();
            });
        }
        //获取年度
        $scope.getNdList = function () {
            $http({
                method: 'get',
                url: '../../api/dictionary/getDictionaryListByDicTypeKey',
                params: {dicTypeKey: 'years'}
            }).then(function (result) {
                $scope.ndList = result.data;
            }, function (resp) {
            });
        };
        //查询
        $scope.search = function () {
            if ($scope.formmodel.nd == null) {
                $scope.showMsg('错误', '请选择年度！');
                $scope.items = [];
                return;
            }
            $http({
                url: "../../api/jfys/getHdbz",
                method: 'GET',
                params: {nd: $scope.formmodel.nd}
            }).then(function (rq) {
                if (rq.data.success == false) {
                    $scope.showMsg('错误', rq.data.msg);
                    return;
                }
                $scope.hdbzmodel = rq.data.item;
                $scope.loadData();
            });
        };
        //生成
        $scope.create = function (isflag) {
            if ($scope.items.length == 0) {
                $scope.showMsg('错误', '预算表为空，不允许生成！');
                return;
            }
            $http({
                method: "post",
                url: "../../api/jfys/saveYsjybmx",
                data: {item: $scope.formmodel, detailslist: $scope.items}
            }).then(function (result) {
                $scope.showMsg('成功', result.data.msg);
                $scope.$emit("tabReloadData", {name: 'ysjyblistCtrl', data: 1});
                $scope.pagechange();
            }, function (resp) {
                $scope.showMsg('错误', '服务器错误');
            });
        }
        //导出
        $scope.export = function () {
            var params = "?1=1";
            for (var p in $scope.formmodel) {
                if ($scope.formmodel[p] != '' && $scope.formmodel[p] != null)
                    params += ("&" + p + "=" + encodeURI($scope.formmodel[p]));
            }
            window.open('../../api/jfys/exportJfysb' + params);
        };
        if ($scope.formmodel.nd != null)
            $scope.search();
        $scope.getNdList();

        $scope.pagechange = function () {
            var inTab = $bsRouterState.$getRouteType() == 'tab';
            if (inTab) {
                $bsRouterState.$closeTab($scope);
            } else {
                $bsRouterState.go('home.ysjyb', {});
            }
        };

    })
    $ang.module('gtPartyApp').filter('sum', function () {
        return function (data, column) {
            var sum = 0;
            angular.forEach(data, function (c, i) {
                sum = sum + (parseFloat(c[column]));
            });
            return sum;
        }
    });

})(angular);