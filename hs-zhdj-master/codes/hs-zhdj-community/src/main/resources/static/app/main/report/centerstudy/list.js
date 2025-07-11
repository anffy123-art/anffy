(function ($app) {
    $app.module('gtPartyApp').controller('centerstudyTotalCtrl', function ($scope, $http, $modal, $ocLazyLoad, $alert, $loading, $state, $bsRouterState, AuthUser, $timeout) {
        $state.params = $bsRouterState.$params($scope);
        $scope.isShow = false;
        $scope.moreTxt = "更多";


        //定义数据集合
        $scope.loginUserId = AuthUser.getUser().Id;
        $scope.dataList = []; //列表数据
        $scope.detailList = []; //列表数据
        $scope.userList = []; //列表数据
        $scope.yearList = [];

        //组织树参数
        $scope.treeparams = {
            isunfold: false,//组织结构树展开收缩
            selectdzzdm: "",
            selectdzzmc: "",
            defaultselected: $state.params.dzzdm,
            showdxz: 0,
            onlyshowdw: 1,
            dzzdm:""
        };

        //查询参数
        $scope.selectparams = {
            pageindex: 1,
            pagesize: 1,
            dzzdm: '',//党组织代码
            year: new Date().getFullYear(),
            ssdzzdm: ''
        };
        $scope.resetparams = {};
        angular.extend($scope.resetparams, $scope.selectparams);

        $scope.$watch("treeparams.selectdzzdm", function (newVal, oldVal) {
            if (newVal != "") {

                if ($scope.treeparams.defaultselected != "" && $scope.treeparams.defaultselected != null &&
                    $scope.treeparams.defaultselected != $scope.treeparams.selectdzzdm)
                    return;

                $scope.selectparams.dzzdm = $scope.treeparams.selectdzzdm;
                $scope.resetparams.dzzdm = $scope.treeparams.selectdzzdm;
                $scope.selectparams.ssdzzdm = $scope.treeparams.selectdzzdm;
                $scope.resetparams.ssdzzdm = $scope.treeparams.selectdzzdm;

                $scope.loadData();
            }
        });

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

        //查询
        $scope.search = function () {
            $scope.loadData();
        };
        $scope.selectDzzdmByUserId = function () {
            $http({
                method: 'get', url: '../../api/zxzxx/xxfa/getdzzdzByUserId',
                params:{
                    Id :AuthUser.getUser().Id
                }
            }).then(function (result) {
                $scope.treeparams.dzzdm = result.data.msg;
             /*   console.log(result.data.msg);*/
            })
        };
        $scope.selectDzzdmByUserId();

        //加载列表数据
        $scope.loadData = function () {
            $http
            ({
                method: 'get', url: '../../api/partyTotal/getZxzxxFaTotalList', params: $scope.selectparams
            }).then(function (result) {
                $scope.dataList = result.data.item.list;
            });

            $http
            ({
                method: 'get', url: '../../api/partyTotal/getZxzxxCqlDetailList', params: $scope.selectparams
            }).then(function (result) {
                $scope.detailList = result.data.item;
            });

            $http
            ({
                method: 'get', url: '../../api/partyTotal/getZxzxxUserStudyList', params: {
                    pageindex: 1,
                    pagesize: 300,
                    dzzdm: $scope.selectparams.dzzdm,//党组织代码
                    year:  $scope.selectparams.year,
                    ssdzzdm: $scope.selectparams.ssdzzdm
                }
            }).then(function (result) {
                $scope.userList = result.data.item.list;
            });
        };

        $scope.getYearsList();

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

        $scope.isShowClick = function () {
            $scope.isShow = !$scope.isShow;
            if ($scope.moreTxt == "更多") {
                $scope.moreTxt = "收起";
            } else if ($scope.moreTxt == "收起") {
                $scope.moreTxt = "更多";
            }
        };
        $scope.setisunfold = function () {
            $scope.treeparams.isunfold = !$scope.treeparams.isunfold;
            $scope.$emit('menudatas.toggle', !$scope.treeparams.isunfold);
        };
        $scope.resetSearch = function () {
            $scope.selectparams = {};

            angular.extend($scope.selectparams, $scope.resetparams);
            $scope.loadData();
        }

    });
})(angular);