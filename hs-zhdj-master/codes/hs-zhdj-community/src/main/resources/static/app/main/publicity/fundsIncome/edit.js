(function ($app) {
    $app.module('gtPartyApp').controller('fundsIncomedtiCtrl', function ($scope, $http, $modal, $ocLazyLoad, $alert, $loading, $state, $partySelect, $stateParams, $bsRouterState) {
        $stateParams = $bsRouterState.$params($scope);
        $scope.isDetail = ($stateParams.isDetail == "true" || $stateParams.isDetail == true);

        $scope.userModel = {};
        $scope.dataModel = {partyCode: $stateParams.dzzdm, year: $stateParams.year};
        $scope.dzzmc = $stateParams.dzzmc;

        $scope.loadData = function () {
            $http.get("../../api/publicity/getFundsIncome", {
                params: {
                    'dzzdm': $scope.dataModel.partyCode,
                    'year': $scope.dataModel.year
                }
            }).then(function (result) {
                $scope.dataModel = result.data.item;
            }, function () {
                $scope.showMsg('错误', '服务器错误');
            });
        };


        //保存
        $scope.submitData = function (isflag) {

            if (isflag) {
                if (confirm("确认提交？")) {
                    $loading.show();
                    $http({
                        method: "post",
                        url: "../../api/publicity/saveFundsIncome",
                        data: $scope.dataModel
                    }).then(function (result) {
                        $loading.hide();
                        if (result.data.success) {
                            $scope.showMsg('成功', result.data.msg);
                            $scope.$emit("tabReloadData", {name: 'fundsIncomeCtrl', data: 1});
                            //重新刷新列表
                            $scope.pagechange();

                        } else {
                            $scope.showMsg('失败', result.data.msg);
                        }

                    }, function (resp) {
                        $scope.showMsg('错误', '服务器错误');
                    });
                }
            }
        };
        $scope.loadData();

        $scope.pagechange = function () {
            var inTab = $bsRouterState.$getRouteType() == 'tab';
            if (inTab) {
                $bsRouterState.$closeTab($scope);
            } else {
                window.history.back();
            }
        };

        $scope.showMsg = function (title, content) {
            $alert({
                title: title + '：',
                content: content,
                placement: 'top',
                type: 'info',
                show: true,
                duration: 3
            });
        };
    });
})(angular);