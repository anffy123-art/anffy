(function ($ang) {
    'use strict';
    $ang.module('zcapp').controller("gsManCtrl", function ($scope, $http, $alert, $modal, AuthUser, $loading) {
        $scope.guestServerTypeList = [];
        $scope.selectdata = {
            username: '',
            guestServerType: null,
            total: 0,
            pageindex: 1,
            pagesize: 10
        };
        $scope.items = [];

        $scope.findSData = function () {
            $loading.show();
            $http.get('../../api/gsmsg/getgsmanlist', {params: $scope.selectdata}).then(function (req) {
                $loading.hide();
                if (req.data.success) {
                    $scope.items = req.data.item.list;
                    $scope.selectdata.ptotal = req.data.item.size;
                }
            }, function (reason) {
                $loading.hide();
            });
        };

        $scope.search = function () {
            $scope.selectdata.pageindex = 1;
            $scope.findSData();
        };

        //监视页面的变化
        $scope.$watch("selectdata.pageindex", function (newVal, oldVal) {
            if ($scope.selectdata.total > 0) {
                $scope.findSData();
            }
        });

        $scope.getGuestServerType = function () {
            $http({
                method: 'get',
                url: '../../api/dictionary/getDictionaryListByDicTypeKey',
                params: {
                    dicTypeKey: 'yy_guestServerType'
                }
            }).then(function (result) {
                $scope.guestServerTypeList = result.data;
            }, function (resp) {

            });
        };

        var gsManSaveModalCtrl = function ($scope) {
            $scope.item = {};
            $scope.extdata = {};


            $scope.loadData = function () {
                $http.get('../../api/gsmsg/getgsman', {params: {id: $scope.$parent.$parent.editId}}).then(
                    function (req) {
                        if (req.data.success) {
                            $scope.item = req.data.item;
                            $scope.extdata = req.data.extdata;
                        }
                    }
                );
            };
            $scope.save = function () {

                if (this.gsmanForm.$valid) {
                    $http.post('../../api/gsmsg/savegsman', $scope.item).then(function (req) {

                        $alert({
                            title: '提示',
                            content: req.data.msg,
                            placement: 'top',
                            type: 'info',
                            show: true,
                            duration: 3
                        });
                        if (req.data.success) {
                            $scope.$parent.$parent.findSData()
                            $scope.$hide();
                        }

                    });
                }


            };

            $scope.loadData();
        };

        gsManSaveModalCtrl.$inject = ['$scope'];

        //新增或编辑字典 模态框
        var myModal = $modal({
            scope: $scope,
            controller: gsManSaveModalCtrl,
            templateUrl: 'setting/gsManModal.html',
            show: false,
            animation: 'am-fade-and-slide-top'
        });

        $scope.editPage = function (id) {
            $scope.editId = id;
            myModal.$promise.then(myModal.show);
        };

        $scope.deleteit = function (id) {
            if (confirm('是否删除客服设置？')) {
                $http.get('../../api/gsmsg/delgsmanbyid', {params: {id: id}}).then(function (req) {
                    $alert({
                        title: '提示',
                        content: req.data.msg,
                        placement: 'top',
                        type: 'info',
                        show: true,
                        duration: 3
                    });
                    if (req.data.success) {
                        $scope.findSData();
                    }
                });
            }
        };

        $scope.getGuestServerType();
        $scope.findSData();

    });
})(angular);
