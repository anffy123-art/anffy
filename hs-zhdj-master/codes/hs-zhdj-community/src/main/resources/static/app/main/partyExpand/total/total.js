(function ($app) {
    $app.module('gtPartyApp').controller('peJoinUserTotalCtrl', function ($scope, $http, $modal, $ocLazyLoad, $alert, $loading, $state, $stateParams, AuthUser, $bsRouterState, $timeout) {
        $state.params = $bsRouterState.$params($scope);

        //定义数据集合
        $scope.loginUserId = AuthUser.getUser().Id;
        $scope.dataList = []; //列表数据

        $scope.selectparams = {
            isunfold: false,//组织结构树展开收缩
            selectdzzdm: '',
            selectdzzmc: '',
            defaultselected: '',
            pageindex: 1,
            pagesize: 10,
            dzzdm: '',//党组织代码
            zzfbType: null
        };
        $scope.pageInfo = {ptotal: 0, mergetotal: 0};

        //监视页数变化
        $scope.$watch("selectparams.pageindex", function (newVal, oldVal) {
            if ($scope.pageInfo.ptotal > 0) {
                $scope.loadData();
            }
        });

        $scope.$watch("selectparams.selectdzzdm", function (newVal, oldVal) {
            if (newVal != "") {
                $scope.selectparams.dzzdm = $scope.selectparams.selectdzzdm;
                $scope.loadData();
            }
        });

        $scope.$watch("selectparams.zzfbType", function (newVal, oldVal) {
            if (newVal != oldVal) {
                /*$scope.selectparams.dzzdm = "";
                $scope.dataList.length = 0;*/
                $scope.loadData();
            }
        });

        //查询
        $scope.search = function () {
            $scope.loadData();
        };

        //加载列表数据
        $scope.loadData = function () {
            /*if ($scope.selectparams.dzzdm != "") {
                if ($scope.selectparams.dzzdm.length == 12) {
                    $loading.show();
                }*/
            $loading.show();
            $http
            ({
                method: 'get', url: '../../api/partyExpand/getJoinUserTotalList', params: $scope.selectparams
            }).then(function (result) {
                $loading.hide();
                $scope.dataList = result.data.item.list;
                $scope.pageInfo.ptotal = result.data.item.total;

            }, function (resp) {
                $loading.hide();
                $scope.showMsg('错误', '服务器错误');
            });
            //}
        };

        $scope.exportData = function () {
            if ($scope.selectparams.dzzdm != "" && $scope.selectparams.dzzdm != AuthUser.getUser().gddwdm) {
                var params = "?1=1";
                for (var p in $scope.selectparams) {
                    if ($scope.selectparams[p] !== '' && $scope.selectparams[p] !== null)
                        params += ("&" + p + "=" + encodeURI($scope.selectparams[p]));
                }
                window.open('../../api/partyExpand/exportJoinUserTotal' + params);
            }
        };

        $scope.showData = function (dzzdm) {
            $bsRouterState.$closeTabName("home.pe_UserList");
            $timeout(function () {
                $bsRouterState.go('home.pe_UserList', {
                    dzzdm: dzzdm
                });
            }, 100);
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
        $scope.setisunfold = function () {
            $scope.selectparams.isunfold = !$scope.selectparams.isunfold;
            $scope.$emit('menudatas.toggle', !$scope.selectparams.isunfold);
        };

    });
})(angular);