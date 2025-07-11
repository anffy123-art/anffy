(function ($app) {
    "use strict";
    $app.module('dsfapp').controller('devTestPlanCtrl', function ($scope, $state, $alert, AuthUser, flowaudit, $http, $window, $loading) {
        $scope.formdata = {
            params: $state.params,
            readonly: $state.params.st == 2
        }

        $loading.hide();
        $scope.loadItem = function () {
            $http({
                url: "../../api/DevTest/getDevTestPlanListByFid",
                method: 'GET',
                params: {fid: $state.params.fid, uid: ''}
            }).then(function (rq) {
                $scope.items = rq.data
                $loading.hide();
            }, function (ex) {
                $loading.hide();
            });
        };
        $scope.loadItem();
        //监视测试任务负责人变化
        var listwatch = $scope.$watch('items', function (newVal, oldVal) {
            var emitObject = {
                stopwatch: listwatch,
                testPlanList: newVal
            };
            $scope.$emit('testPlanList', emitObject);
        }, true)
    });
})(angular);