(function ($ang) {
    'use strict';
    $ang.module('zcapp').controller('wxApiTestCtrl', function ($scope, $payService, AuthUser) {
        $scope.payData = {
            amt: 0.01,
            payRelID: 'xxxxxxxx20190105002',
            companyID: '05d83e2a-5814-4cca-93e2-da5306ec904f',
            creatorID: AuthUser.getUser().Id,
            commodityName: '测试银联'
        };

        //$scope.b_payRelID='xxxxxxxx20190105002';

        $scope.testpay = function () {
            $payService.payShow($scope.payData).then(function (val) {
                alert("已经返回：" + val);
            });
        };

        $scope.backpay = function () {
            $payService.backShow($scope.payData.payRelID).then(function (val) {
                alert("退款返回：" + val);
            });
        };

    });
})(angular);