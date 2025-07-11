(function ($app) {
    $app.module('gtPartyApp').controller('dyxxglCtrl', function ($scope, $http, $modal, $ocLazyLoad, $alert, $loading, $state, $stateParams, AuthUser, $bsRouterState, $timeout) {
        $state.params = $bsRouterState.$params($scope);

        $scope.selectparams = {
            'pageindex': 1,
            'pagesize': 5,
             dzzdm: AuthUser.getUser().DataDzzdm,
             userid: AuthUser.getUser().Id,
        };
        $scope.pageSrc = '../main/partyExpand/summary/shykqk.html';
        $scope.apiSrc='../../api/partyTowExt/getDnpxxxList';
        $scope.selectmenu="shykqk";
        $scope.loadPage = function (src) {
            $scope.selectmenu=src;
            switch (src) {
                case "ztdrqk":
                    $scope.pageSrc = '../main/partyExpand/summary/' + src+".html";
                    $scope.apiSrc='../../api/partyTowExt/getZtdrxxList';
                    $scope.loadData();
                    break;
                case "dnpxqk":
                    $scope.pageSrc = '../main/partyExpand/summary/' + src+".html";
                    $scope.apiSrc='../../api/partyTowExt/getDnpxxxList';
                    $scope.loadData();
                    break;
            }
        }
        //加载列表数据
        $scope.loadData = function () {
            $loading.show()
            $http
            ({
                method: 'get', url:$scope.apiSrc, params: $scope.selectparams
            }).then(function (result) {
                $scope.dataList = result.data.item.list;
                $loading.hide()
            },function () {
                $loading.hide();
            });
        };

        $scope.toRight=function() {
            var redmenu=$('.redmenu');
            var left=redmenu.scrollLeft();
            redmenu.scrollLeft(left+200);
        };
        $scope.toLeft=function() {
            var redmenu=$('.redmenu');
            var left=redmenu.scrollLeft();
            redmenu.scrollLeft(left-200);
        };
    });
})(angular);