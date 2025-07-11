(function ($app) {
    $app.module('gtPartyApp').controller('systemUseTotalListCtrl', function ($scope, $http, $modal, $ocLazyLoad, $alert, $loading, $state, $bsRouterState, AuthUser, $timeout) {
        $state.params = $bsRouterState.$params($scope);
        $scope.isShow = false;
        $scope.moreTxt = "更多";


        //定义数据集合
        $scope.loginUserId = AuthUser.getUser().Id;
        $scope.dataList = []; //列表数据

        //组织树参数
        $scope.treeparams = {
            isunfold: false,//组织结构树展开收缩
            selectdzzdm: "",
            selectdzzmc: "",
            defaultselected: $state.params.dzzdm,
            showdxz: 0
        };

        //查询参数
        $scope.selectparams = {
            pageindex: 1,
            pagesize: 10,
            dzzdm: '',//党组织代码
            fundYear: new Date(),
            duesYearMonth: new Date(),
            meetingYearMonth: new Date(),
            partydayYearMonth: new Date(),
            positionYearMonth: new Date()
        };
        $scope.resetparams = {};
        angular.extend($scope.resetparams, $scope.selectparams);


        //监视页数变化
        $scope.pageInfo = {ptotal: 0};
        $scope.$watch("selectparams.pageindex", function (newVal, oldVal) {
            if ($scope.pageInfo.ptotal > 0) {
                $scope.loadData();
            }
        });

        $scope.$watch("treeparams.selectdzzdm", function (newVal, oldVal) {
            if (newVal != "") {

                if ($scope.treeparams.defaultselected != "" && $scope.treeparams.defaultselected != null &&
                    $scope.treeparams.defaultselected != $scope.treeparams.selectdzzdm)
                    return;

                $scope.selectparams.dzzdm = $scope.treeparams.selectdzzdm;
                $scope.resetparams.dzzdm = $scope.treeparams.selectdzzdm;

                $scope.loadData();
            }
        });


        //查询
        $scope.search = function () {
            $scope.loadData();
        };

        //加载列表数据
        $scope.loadData = function () {
            if (!$scope.selectparams.fundYear || !$scope.selectparams.duesYearMonth || !$scope.selectparams.meetingYearMonth || !$scope.selectparams.partydayYearMonth || !$scope.selectparams.positionYearMonth) {
                $scope.showMsg('错误', '请填写查询年月');
                return false;
            }
            $http
            ({
                method: 'get', url: '../../api/partyTotal/getSystemUseTotalList', params: $scope.getSelectparams()
            }).then(function (result) {
                $scope.dataList = result.data.item.list;
                $scope.pageInfo.ptotal = result.data.item.total;
            }, function (res) {
                $scope.showMsg('错误', '服务器错误:' + res.data.message);
            });
        };

        //导出
        $scope.export = function () {
            if (!$scope.selectparams.fundYear || !$scope.selectparams.duesYearMonth || !$scope.selectparams.meetingYearMonth || !$scope.selectparams.partydayYearMonth || !$scope.selectparams.positionYearMonth) {
                $scope.showMsg('错误', '请填写查询年月');
                return false;
            }
            if (AuthUser.getUser().Id) {
                var selectParams = $scope.getSelectparams();
                var params = "?1=1";
                for (var p in selectParams) {
                    if (selectParams[p] != '' && selectParams[p] != null)
                        params += ("&" + p + "=" + encodeURI(selectParams[p]));
                }
                window.open('../../api/partyTotal/exportSystemUseTotalList' + params);
            }
        };

        $scope.getSelectparams = function () {
            var params = {
                pageindex: $scope.selectparams.pageindex,
                pagesize: $scope.selectparams.pagesize,
                dzzdm: $scope.selectparams.dzzdm,//党组织代码
                fundYear: moment($scope.selectparams.fundYear).format('YYYY'),
                duesYearMonth: moment($scope.selectparams.duesYearMonth).format('YYYYMM'),
                meetingYearMonth: moment($scope.selectparams.meetingYearMonth).format('YYYYMM01'),
                partydayYearMonth: moment($scope.selectparams.partydayYearMonth).format('YYYYMM01'),
                positionYearMonth: moment($scope.selectparams.positionYearMonth).format('YYYYMM01')
            };

            return params;
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