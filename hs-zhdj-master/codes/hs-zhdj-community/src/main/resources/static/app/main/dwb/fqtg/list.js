(function ($ang) {
    'use strict';
    $ang.module('gtPartyApp').controller('fqtgListCtrl', function ($scope, $http, $alert, $modal, AuthUser, $state, $loading, $window, $timeout,$bsRouterState) {
        $scope.selectdata = {
            createUserId: AuthUser.getUser().DGUserID,
            title: null,
            topicValue: null,
            author: null,
            pageindex: 1,
            pagesize: 10,
        };
        $scope.resetdata = {
            createUserId: AuthUser.getUser().DGUserID,
            title: null,
            topicValue: null,
            author: null,
            pageindex: 1,
            pagesize: 10,
        };
        $scope.pageInfo = {ptotal: 0};
        $scope.ndList = [];
        $scope.items = [];
        $scope.isShow = false;
        $scope.moreTxt = "更多";



        $scope.loadData = function () {
            $loading.show();
            $http({
                url: "../../api/Fqtg/gettgList",
                method: 'GET',
                params: $scope.selectdata
            }).then(function (rq) {
                $scope.items = rq.data.item.list;
                $scope.pageInfo.ptotal = rq.data.item.total;
                $loading.hide();
            });
        };
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
        //获取栏目
        $scope.getTopicList = function () {
            $http({
                method: 'get',
                url: '../../api/dictionary/GetDictionaryList',
                params: {dicTypeKey: 'topic'}
            }).then(function (result) {
                $scope.ndList = result.data.item.list;
            }, function (resp) {
            });
        };

        $scope.viewItem = function (fqtgid) {
            $bsRouterState.go('home.fqtgedit', {fqtgid:fqtgid});
        };

        $scope.isShowClick = function(){
            $scope.isShow=!$scope.isShow;
            if($scope.moreTxt == "更多")
            {
                $scope.moreTxt = "收起";
            }
            else if($scope.moreTxt == "收起")
            {
                $scope.moreTxt = "更多";
            }
        };
        $scope.getTopicList();
        $scope.loadData();
        $scope.reset  = function () {
            $scope.selectdata.title = $scope.resetdata.title;
            $scope.selectdata.author = $scope.resetdata.author;
            $scope.selectdata.topicValue = $scope.resetdata.topicValue;
            $scope.selectdata.closeenddate = $scope.resetdata.closeenddate;
            //$scope.selectparams.selectdzzmc = $scope.selectparams.dzzmc = $scope.selectparams.zzlb = $scope.selectparams.jczzfl = '';
        }
    })
})(angular);