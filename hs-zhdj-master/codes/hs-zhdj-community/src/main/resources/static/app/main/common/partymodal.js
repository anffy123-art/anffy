(function ($ang) {
    'use strict';
    $ang.module('gtPartyApp').controller("partyModalCtrl", function ($scope, $http, $filter, $alert) {
        $scope.treeList = [];
        $scope.selectdzzdm = $scope.$partyData.$config.dzzdm || "";
        $scope.selectdzzmc = "";
        $scope.isshowxz = $scope.$partyData.$config.isshowxz;

        $scope.choose = function () {
            if ($scope.selectdzzdm.length < 12) {
                $alert({
                    title: '错误：',
                    content: "请选择党组织",
                    placement: 'top',
                    type: 'info',
                    show: true,
                    duration: 3
                });
                return false;
            }
            $scope.$parent.$parent.$partyData.$config.selectedData.length = 0;
            $scope.$parent.$parent.$partyData.$config.selectedText = $scope.selectdzzmc;
            $scope.$parent.$parent.$partyData.$config.selectedKey = $scope.selectdzzdm;

            $scope.$hide();
        };

    });
})(angular);