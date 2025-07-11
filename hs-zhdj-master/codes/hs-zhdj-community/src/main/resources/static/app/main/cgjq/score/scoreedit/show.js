(function ($app) {
    $app.module('gtPartyApp').controller('cgjqScoreShowCtrl', function ($scope, $http, $modal, $ocLazyLoad, $alert, $loading, $state, $partySelect, $stateParams, AuthUser,
                                                                        $filter,$bsRouterState) {

        $stateParams = $bsRouterState.$params($scope);

        //定义数据集合
        $scope.loginUserId = AuthUser.getUser().Id;
        $scope.dataModel = {
            postareascoreid: $stateParams.id == undefined ? "" : $stateParams.id,
            cgjqtype: $stateParams.cgjqType
        };
        $scope.scoreDataList = [];
        $scope.userList = [];

        //获取数据
        $scope.loadData = function () {
            $http.get("../../api/cgjq/getPostareaScoreById", {
                params: {
                    'id': $scope.dataModel.postareascoreid,
                    cgjqType: $scope.dataModel.cgjqtype
                }
            }).then(function (result) {
                if (!result.data.success) {
                    $scope.showMsg('错误', result.data.extdata.message);
                    return false;
                }

                $scope.dataModel = result.data.item;

                $scope.getPostareaScoreList();
                $scope.getUserList();
            }, function () {
                $scope.showMsg('错误', '服务器错误');
            });

        };

        //获取岗区评分数据
        $scope.getPostareaScoreList = function () {
            $http
            ({
                method: 'get', url: '../../api/cgjq/getPostareaScoreProjectList', params: {
                    postAreaScoreId: $scope.dataModel.postareascoreid
                }
            }).then(function (result) {
                $scope.scoreDataList = result.data;
            });
        };

        $scope.getUserList = function () {
            $http
            ({
                method: 'get',
                url: '../../api/cgjq/getPostareaScoreUserList',
                params: {pageindex: 1, pagesize: 10000, postAreaScoreId: $scope.dataModel.postareascoreid}
            }).then(function (result) {
                $scope.userList = result.data.item.list;
            });
        };

        //初始化数据
        $scope.loadData();

        $scope.pagechange = function () {
            //window.history.go(-1);
            var inTab = $bsRouterState.$getRouteType() == 'tab';
            if (inTab) {
                $bsRouterState.$closeTab($scope);
            } else {
                $bsRouterState.go("home.cgjqScoreSort",{},{reload:false});
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