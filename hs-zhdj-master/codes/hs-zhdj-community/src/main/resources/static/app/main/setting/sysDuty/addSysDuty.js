(function () {
    var app = angular.module('dsfapp');

    app.controller("addSysDutyCtrl", function ($scope, $alert, $http, AuthUser) {

        $scope.hasPermission = {
            hide: '取消',
            editTitle: true,
            showSave: true
        }
        var GuidEmpty = "00000000-0000-0000-0000-000000000000";
        $scope.item = {};
        $scope.itemadddata = {};


        $scope.loadpage = function () {
            $scope.hasPermission.showSave = !$scope.$parent.SysDutyParams.readonly;
            var urlparams = {
                SysDutyID: $scope.$parent.SysDutyParams.data.id,
                PDutyID: $scope.$parent.SysDutyParams.data.pid || '',
                DutyLv: $scope.$parent.SysDutyParams.data.xid,
                tp: $scope.$parent.SysDutyParams.type
            };

            /*
            if ($scope.$parent.SysDutyParam.type == 1) {
                urlparams.DutyLv = $scope.$parent.SysDutyParam.data.xid;
                urlparams.PDutyID = $scope.$parent.SysDutyParam.data.pid;
            }

            if ($scope.$parent.SysDutyParam.type==2) {
                urlparams.DutyLv = $scope.$parent.SysDutyParam.data.xid+1;
                urlparams.PDutyID = $scope.$parent.SysDutyParam.data.id;
            }

            if ($scope.$parent.SysDutyParam.type == 4) {
                urlparams.SysDutyID = $scope.$parent.SysDutyParam.data.id;
            }*/

            $http({
                method: 'get',
                url: '../../api/SysDuty/getsysDemandDuty',
                params: urlparams
            }).then(function (res) {
                //$alert({ content: res.data, type: 'info', placement: 'top', show: true, duration: 3 });
                //$scope.getSysDuty();
                $scope.item = res.data.items;
                $scope.itemadddata = res.data.extdata;
                if ($scope.item.SysDutyID == GuidEmpty) {
                    $scope.item.CreatorID = AuthUser.getUser().DGUserID;
                    $scope.itemadddata.CreatorName = AuthUser.getUser().Name;
                }
            });

        }


        $scope.Dlevel = [
            {DutyLv: "", LvName: '-------请先选择系统层级-------'},
            {DutyLv: 1, LvName: '模块'},
            {DutyLv: 2, LvName: '菜单'},
            {DutyLv: 3, LvName: '功能点'}
        ];


        $scope.loadpage();

        $scope.hidden = function () {
            $scope.$parent.$hide();
        }

        $scope.save = function () {
            if (this.formSysDuty.$valid) {
                $http({
                    method: 'post',
                    url: '../../api/SysDuty/SavesysDemandDuty',
                    data: JSON.stringify($scope.item),
                    contentType: 'application/json'
                }).then(function (res) {

                    $alert({content: res.data.msg, type: 'info', placement: 'top', show: true, duration: 3});
                    if (angular.isFunction($scope.$parent.$parent.freshTree)) {
                        $scope.$parent.$parent.freshTree();
                    }
                    $scope.$parent.$hide();
                });
            }
        };
    });
})();