(function ($app) {
    'use strict';
    $app.module('dsfapp').controller('flowStepCtrl', function ($scope, $loading, $ocLazyLoad, $state, $alert, AuthUser, flowaudit, $http) {
        $scope.flowdata = {
            flowStagePanels: []
            , activePanelids: [0, 1, 2],
            params: $state.params,
            readonly: $state.params.st == 2,
        };
        $scope.url = $state.params.pictureUrl;
        $scope.showFlow = function () {
            window.open($scope.url, '_blank');
        }
    });
})(angular);