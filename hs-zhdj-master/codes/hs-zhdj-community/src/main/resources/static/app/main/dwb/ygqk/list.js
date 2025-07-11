(function ($ang) {
    'use strict';
    $ang.module('gtPartyApp').controller('ygqkListCtrl', function ($scope, $http, $alert, $modal, AuthUser, $state, $loading, $window, $timeout,$bsRouterState) {
        $scope.selectdata = {
            leader: AuthUser.getUser().DGUserID,
            title: null,
            closebegindate: null,
            closeenddate: null,
            typevalue: null,
            pageindex: 1,
            pagesize: 10,
        };
        $scope.resetdata = {
            leader: AuthUser.getUser().DGUserID,
            title: null,
            closebegindate: null,
            closeenddate: null,
            typevalue: null,
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
                url: "../../api/Zgyg/getZgtgList",
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
        //获取类型
        $scope.getNdList = function () {
            $http({
                method: 'get',
                url: '../../api/dictionary/GetDictionaryList',
                params: {dicTypeKey: 'ZgtgType'}
            }).then(function (result) {
                $scope.ndList = result.data.item.list;
            }, function (resp) {
            });
        };

        $scope.editModal = function (zgtgid) {
            $bsRouterState.go('home.zgygedit', {zgtgid:zgtgid});
        };
        $scope.viewItem = function (zgtgid) {
            $bsRouterState.go('home.ygqkreply', {businessid:zgtgid});
        };
        $scope.reply=function(zgtgid){
            $http.get("../../api/Zgyg/getYgqkList", {
                params: {zgtgid: zgtgid}
            }).then(function (result) {
                var ygqk= result.data.item.list[0];
                $bsRouterState.go('home.fqtgedit', {ygqkid:ygqk["ygqkid"],ygmc:ygqk["title"]});
            }, function () {
                $scope.showMsg('错误', '服务器错误');
            });
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
        $scope.getNdList();
        $scope.loadData();

        $scope.reset  = function () {
            $scope.selectdata.title = $scope.resetdata.title;
            $scope.selectdata.typevalue = $scope.resetdata.typevalue;
            $scope.selectdata.closebegindate = $scope.resetdata.closebegindate;
            $scope.selectdata.closeenddate = $scope.resetdata.closeenddate;
            //$scope.selectparams.selectdzzmc = $scope.selectparams.dzzmc = $scope.selectparams.zzlb = $scope.selectparams.jczzfl = '';
        }

    })
})(angular);
