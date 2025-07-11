(function ($app) {
    $app.module('gtPartyApp').controller('userThoughtTotalEditCtrl', function ($scope, $http, $modal, $ocLazyLoad, $alert, $loading, $state, $partySelect, $stateParams, $bsRouterState, $partySelect) {
        $stateParams = $bsRouterState.$params($scope);

        $scope.maxDate = moment(new Date()).format("YYYY-MM-DD");

        $scope.op = $stateParams.op;
        //定义数据集合
        $scope.dataModel = {
            id: $stateParams.id == undefined ? "" : $stateParams.id,
            partycode: $stateParams.dzzdm
        };
        $scope.viewdata = {yearMonth: ''};

        $scope.loadData = function () {
            $http.get("../../api/publicity/getUserthoughtTotalById", {
                params: {
                    'id': $scope.dataModel.id,
                    'dzzdm': $scope.dataModel.partycode
                }
            }).then(function (result) {
                $scope.dataModel = result.data.item;
                if ($scope.dataModel.month != null) {
                    $scope.viewdata.yearMonth = moment($scope.dataModel.month, 'YYYYMM');
                }
            }, function () {
                $scope.showMsg('错误', '服务器错误');
            });
        };
        //保存
        $scope.submitData = function (isflag) {
            if (isflag) {
                if ($scope.dataModel.totalcontent == "" || $scope.dataModel.totalcontent == null || $scope.dataModel.totalcontent == "<br />") {
                    $scope.showMsg('错误', '统计表不能为空');
                    return false;
                }
                $loading.show();
                $http({
                    method: "post",
                    url: "../../api/publicity/savetUserthoughtTotal",
                    data: $scope.dataModel
                }).then(function (result) {
                    $loading.hide();
                    $scope.showMsg('成功', result.data.msg);
                    //重新刷新列表
                    $scope.pagechange();

                    $scope.$emit("tabReloadData",{name:'userThoughtTotalListCtrl',data:1});

                }, function (resp) {
                    $loading.hide();
                    $scope.showMsg('错误', '服务器错误,' + resp.data.message);
                })
            }
        };

        $scope.dateChange = function () {
            $scope.dataModel.month = moment($scope.viewdata.yearMonth).format('YYYYMM');
        };


        //加载数据
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