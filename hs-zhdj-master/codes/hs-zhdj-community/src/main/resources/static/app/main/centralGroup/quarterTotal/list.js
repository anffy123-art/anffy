(function ($app) {
    $app.module('gtPartyApp').controller('learningQuarterTotalCtrl', function ($scope, $http, $modal, $ocLazyLoad, $alert, $loading, $state, $bsRouterState, AuthUser, $timeout, $excel) {
        $state.params = $bsRouterState.$params($scope);
        $scope.isShow = false;
        $scope.moreTxt = "更多";
        $scope.loginUserId = AuthUser.getUser().Id;

        //定义数据集合
        $scope.dataList = []; //列表数据
        $scope.assetStateList = [];
        //组织树参数
        $scope.treeparams = {
            isunfold: false,//组织结构树展开收缩
            selectdzzdm: "",
            selectdzzmc: "",
            defaultselected: $state.params.dzzdm,
            onlyshow_dw:1
        };
        //查询条件
        $scope.selectparams = {
            pageindex: 1,
            pagesize: 10,
            dzzdm: '',
            year:  new Date().getFullYear(),
            quarter: parseInt(new Date().getMonth() / 3) + 1
        };

        $scope.pageInfo = {ptotal: 0};

        //加载列表数据
        $scope.getList = function () {
            $http
            ({
                method: 'get', url: '../../api/zxzxx/xxqk/getLearningQuarterTotalList', params: $scope.selectparams
            }).then(function (result) {
                $scope.dataList = result.data.item.list;
                $scope.pageInfo.ptotal = result.data.item.total;
            }, function (res) {
                $scope.showMsg('错误', '服务器错误');
            });
        };

        $scope.search = function () {
            $scope.getList();
        };

        $scope.export = function () {
            var params = "?1=1";
            for (var p in $scope.selectparams) {
                if ($scope.selectparams[p] !== '' && $scope.selectparams[p] !== null)
                    params += ("&" + p + "=" + encodeURI($scope.selectparams[p]));
            }
            window.open('../../api/zxzxx/xxqk/excelLearningQuarterTotalList' + params);
        };


        //获取字典数据
        $scope.getYearsList = function () {
            $http({
                method: 'get',
                url: '../../api/dictionary/getDictionaryListByDicTypeKey',
                params: {dicTypeKey: 'years'}
            }).then(function (result) {
                $scope.yearList = result.data;
            }, function (resp) {

            });
        };
        $scope.getQuartersList = function () {
            $http({
                method: 'get',
                url: '../../api/dictionary/getQuartersList',
                params: {}
            }).then(function (result) {
                $scope.quarterList = result.data;
            }, function (resp) {

            });
        };

        $scope.$watch("selectparams.pageindex", function (newVal, oldVal) {
            if ($scope.pageInfo.ptotal > 0) {
                $scope.getList();
            }
        });
        $scope.$watch("treeparams.selectdzzdm", function (newVal, oldVal) {
            if (newVal != "") {
                if ($scope.treeparams.defaultselected != "" && $scope.treeparams.defaultselected != null &&
                    $scope.treeparams.defaultselected != $scope.treeparams.selectdzzdm)
                    return;

                $scope.selectparams.dzzdm = $scope.treeparams.selectdzzdm;

                $scope.getList();
            }
        });

        $scope.setisunfold = function () {
            $scope.treeparams.isunfold = !$scope.treeparams.isunfold;
            $scope.$emit('menudatas.toggle', !$scope.treeparams.isunfold);
        };

        $scope.getYearsList();
        $scope.getQuartersList();

    });
})(angular);