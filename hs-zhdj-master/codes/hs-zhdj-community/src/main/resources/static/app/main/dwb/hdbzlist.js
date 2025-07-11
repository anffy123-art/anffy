(function ($ang) {
    'use strict';
    $ang.module('gtPartyApp').controller('hdbzlistCtrl', function ($scope, $http, $alert, $modal, AuthUser, $state, $loading, $window, $timeout) {
        $scope.selectdata = {
            uid: AuthUser.getUser().DGUserID,
            nd: null,
            pageindex: 1,
            pagesize: 10,
        };
        $scope.pageInfo = {ptotal: 0};
        $scope.ndList = [];
        $scope.items = [];

        $scope.loadData = function () {
            $loading.show();
            $http({
                url: "../../api/jfys/HdbzList",
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
        $scope.DelItem = function (id) {
            if (confirm('是否删除核定标准？')) {
                $loading.show();
                $http({
                    method: 'get',
                    url: '../../api/jfys/DelHdbz',
                    params: {
                        hdbzid: id
                    }
                }).then(function (result) {
                    $scope.search();
                    $loading.hide();
                }, function (resp) {
                    $loading.hide();
                });
            }
        };
        var editCtrl = function ($scope, $http, AuthUser) {

            $scope.modalData = $scope.$parent.$parent.modalData;
            $scope.modalData.nd = $scope.modalData.nd.toString();
            $scope.getNdList = $scope.$parent.$parent.getNdList;
            $scope.submitForm = function (isflag) {
                if (isflag) {
                    // $loading.show();
                    $http({
                        method: "post",
                        url: "../../api/jfys/SaveHdbz",
                        data: $scope.modalData
                    }).then(function (result) {
                        $loading.hide();
                        $scope.showMsg('成功', result.data.msg);
                        if(result.data.success) {
                            //重新刷新列表
                            $scope.loadData();
                            $scope.$hide();
                        }

                    }), function (resp) {
                        $scope.showMsg('错误', '服务器错误');
                    }
                }
            }
        };
        editCtrl.$inject = ['$scope', '$http'];
        var cdModal = $modal({
            scope: $scope,
            title: '核定标准信息',
            templateUrl: 'dwb/hdbzedit.html',
            controller: editCtrl,
            show: false,
            animation: 'am-fade-and-slide-top'
        });
        $scope.modalData = {};
        $scope.EditModal = function (it) {
            $scope.modalData = it;
            cdModal.$promise.then(cdModal.show);
        };
        $scope.AddModal = function () {
            $scope.modalData = {cjr: AuthUser.getUser().Id, nd: new Date().getFullYear};
            cdModal.$promise.then(cdModal.show);
        };
        $scope.getNdList();
        $scope.loadData();
    })
})(angular);