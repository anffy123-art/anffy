(function ($ang) {
    'use strict';
    $ang.module('gtPartyApp').controller('zgygListCtrl', function ($scope, $http, $alert, $modal, AuthUser, $state, $loading, $window, $timeout,$bsRouterState) {
        $scope.selectdata = {
            uid: AuthUser.getUser().DGUserID,
            title: null,
            closebegindate: null,
            closeenddate: null,
            typevalue: null,
            'pageindex': 1,
            'pagesize': 10,
        };
        $scope.resetdata = {
            uid: AuthUser.getUser().DGUserID,
            title: null,
            closebegindate: null,
            closeenddate: null,
            typevalue: null,
            'pageindex': 1,
            'pagesize': 10,
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
        $scope.delItem = function (id) {
            if (confirm('请确认是否删除，删除将无法恢复!')) {
                $loading.show();
                $http({
                    method: 'get',
                    url: '../../api/Zgyg/deleteZgtg',
                    params: {
                        zgtgid: id
                    }
                }).then(function (result) {
                    $scope.search();
                    $loading.hide();
                }, function (resp) {
                    $loading.hide();
                });
            }
        };
        $scope.editModal = function (zgtgid) {
            $bsRouterState.go('home.zgygedit', {zgtgid:zgtgid});
        };
        $scope.viewItem = function (zgtgid) {
            $bsRouterState.go('home.zgygview', {businessid:zgtgid});
        };
        $scope.quxiaoguanbi = function(){
            cdModal.$promise.then(cdModal.hide);
        };
        var editCtrl = function ($scope, $http, AuthUser) {
            $scope.receivePcommList =  cdModal.receivePcommList ;
            $scope.title=cdModal.title;
            $scope.close = function () {
                cdModal.$promise.then(cdModal.hide);
            };
        };
        editCtrl.$inject = ['$scope', '$http'];
        var cdModal = $modal({
            scope: $scope,
            title: '接收单位信息',
            templateUrl: '../main/dwb/zgyg/showDw.html',
            controller: editCtrl,
            show: false,
            animation: 'am-fade-and-slide-top'
        });
        $scope.showDw=function(zgtgid,status,title){
            $http.get("../../api/Zgyg/getJsdwList", {
                params: {zgtgid: zgtgid,status:status}
            }).then(function (result) {
                cdModal.receivePcommList = result.data.item.list;
                cdModal.title=title;
                cdModal.$promise.then(cdModal.show);
            }, function () {
                $scope.showMsg('错误', '服务器错误');
            });
        };
        $scope.getNdList();
        $scope.loadData();

        $scope.parentUrl = "home.zgyg";//父级地址
        $scope.pagechange = function () {
            if($bsRouterState.$getRouteType()=='tab'){
                $bsRouterState.$closeTab($scope);
            } else {
                $bsRouterState.go($scope.parentUrl);
            }
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
        $scope.reset  = function () {
            $scope.selectdata.title = $scope.resetdata.title;
            $scope.selectdata.typevalue = $scope.resetdata.typevalue;
            $scope.selectdata.closebegindate = $scope.resetdata.closebegindate;
            $scope.selectdata.closeenddate = $scope.resetdata.closeenddate;
            //$scope.selectparams.selectdzzmc = $scope.selectparams.dzzmc = $scope.selectparams.zzlb = $scope.selectparams.jczzfl = '';
        }
    })
})(angular);