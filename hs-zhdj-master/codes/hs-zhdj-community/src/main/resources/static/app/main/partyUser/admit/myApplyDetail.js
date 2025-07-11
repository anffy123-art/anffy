(function ($app) {
    $app.module('gtPartyApp').controller('myApplyInfoCtrl', function ($scope, $http, $modal, $ocLazyLoad, $alert, $loading, $state, $partySelect, $stateParams, $bsRouterState, AuthUser, $timeout, $filter) {
        $stateParams = $bsRouterState.$params($scope);

        $scope.dataModel = {};
        $scope.applyProgressList = [];
        $scope.imgConfig = {
            filerefid: $scope.dataModel.applyFileReId,
            filetypeid: 1,
            readonly: true,
            ismulti: true,
            height: 180,
            width: 180,
            imgList: []
        };

        $scope.getData = function () {
            $http
            ({
                method: 'get', url: "../../api/partyUserAdmit/getPartyUserByCode",
                params: {
                    'userCode': AuthUser.getUser().Id
                }
            }).then(function (result) {
                $scope.dataModel = result.data.item;
                $scope.imgConfig.filerefid = $scope.dataModel.applyFileReId
            }, function (resp) {
                $scope.showMsg('错误', '服务器错误：' + resp.data);
            });
        };

        $scope.getApplyProgressList = function () {
            $http
            ({
                method: 'get', url: "../../api/partyUserAdmit/getApplyProgressList",
                params: {
                    'userCode': AuthUser.getUser().Id
                }
            }).then(function (result) {
                $scope.applyProgressList = result.data.item;
            }, function (resp) {
                $scope.showMsg('错误', '服务器错误：' + resp.data);
            });
        };

        $scope.getData();
        $scope.getApplyProgressList();
    });
})(angular);
