(function ($app) {
    $app.module('gtPartyApp').controller('fundsIncomeCtrl', function ($scope, $http, $modal, $ocLazyLoad, $alert, $loading, $state, $bsRouterState, AuthUser, $timeout) {
        $state.params = $bsRouterState.$params($scope);
        $scope.isShow = false;
        $scope.moreTxt = "更多";


        //定义数据集合
        $scope.loginUserId = AuthUser.getUser().Id;
        $scope.dataList = []; //列表数据
        //当前年度季度
        var year = new Date().getFullYear();
        $scope.selectparams = {
            isunfold: false,//组织结构树展开收缩
            'pageindex': 1,
            'pagesize': 10,
            isshowxz: 0,
            onlyshowdw: 1,
            selectdzzdm: "",
            selectdzzmc: "",
            defaultselected: $state.params.dzzdm,
            parentcode: AuthUser.getUser().ParentDpCode,
            parentname: AuthUser.getUser().ParentDpName,
            szdzzdm: AuthUser.getUser().DPCode,
            szdzzmc: AuthUser.getUser().DPName,
            zzfbType: null,
            partyCode: '',//党组织代码
            userid: AuthUser.getUser().Id,
            userName: '',
            year: $state.params.year == undefined ? new Date().getFullYear() : $state.params.year
        };
        $scope.resetparams = {
            isunfold: false,//组织结构树展开收缩
            'pageindex': 1,
            'pagesize': 10,
            isshowxz: 0,
            selectdzzdm: "",
            selectdzzmc: "",
            defaultselected: $state.params.dzzdm,
            parentcode: AuthUser.getUser().ParentDpCode,
            parentname: AuthUser.getUser().ParentDpName,
            szdzzdm: AuthUser.getUser().DPCode,
            szdzzmc: AuthUser.getUser().DPName,
            zzfbType: null,
            partyCode: '',//党组织代码
            userid: AuthUser.getUser().Id,
            userName: '',
            year: $state.params.year == undefined ? new Date().getFullYear() : $state.params.year
        };
        $scope.yearList = [];
        $scope.pageInfo = {ptotal: 0};
        //监视页数变化
        $scope.$watch("selectparams.pageindex", function (newVal, oldVal) {
            if ($scope.pageInfo.ptotal > 0) {
                $scope.loadData();
            }
        });

        $scope.$watch("selectparams.selectdzzdm", function (newVal, oldVal) {
            if (newVal != "") {
                if ($scope.selectparams.defaultselected != "" && $scope.selectparams.defaultselected != null &&
                    $scope.selectparams.defaultselected != $scope.selectparams.selectdzzdm)
                    return;
                $scope.selectparams.defaultselected = "";

                $scope.selectparams.dzzdm = $scope.selectparams.selectdzzdm;
                $scope.loadData();
            }
        });

        $scope.$watch("selectparams.zzfbType", function (newVal, oldVal) {
            if (newVal != oldVal) {
                $scope.loadData();
            }
        });

        $scope.$on('tabChildReloadData', function (event, data) {
            if (data.name == 'fundsIncomeCtrl') {
                $scope.loadData();
            }
        });


        //查询
        $scope.search = function () {
            $scope.loadData();
        };

        //加载列表数据
        $scope.loadData = function () {
            $loading.show();
            $http
            ({
                method: 'get', url: '../../api/publicity/getFundsIncomeSummary', params: $scope.selectparams
            }).then(function (result) {
                $loading.hide();
                $scope.dataList = result.data.item.list;
                $scope.pageInfo.ptotal = result.data.item.total;
            }, function (resp) {
                $loading.hide();
                $scope.showMsg('错误', '服务器错误');
            });
        };

        //录入
        $scope.editData = function (PARTYCODE, DZZMC) {
            $bsRouterState.$closeTabName("home.fundsIncomeEdit");
            $timeout(function () {
                $bsRouterState.go('home.fundsIncomeEdit', {
                    year: $scope.selectparams.year,
                    dzzdm: PARTYCODE,
                    dzzmc: DZZMC
                });
            }, 100);
        };

        $scope.exportData = function () {
            if ($scope.selectparams.dzzdm != "") {
                var params = "?1=1";
                for (var p in $scope.selectparams) {
                    if ($scope.selectparams[p] !== '' && $scope.selectparams[p] !== null)
                        params += ("&" + p + "=" + encodeURI($scope.selectparams[p]));
                }
                window.open('../../api/publicity/exportFundsIncomeSummary' + params);
            }
        };

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
            $scope.selectparams.isunfold = !$scope.selectparams.isunfold;
            $scope.$emit('menudatas.toggle', !$scope.selectparams.isunfold);
        };
        $scope.reset = function () {
            $scope.selectparams.userName = $scope.resetparams.userName;
            $scope.selectparams.year = $scope.resetparams.year;
            $scope.selectparams.jczzfl = $scope.resetparams.jczzfl;
        }

    });
})(angular);