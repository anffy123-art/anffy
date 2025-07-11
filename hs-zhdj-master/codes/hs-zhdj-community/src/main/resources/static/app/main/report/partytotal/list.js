(function ($app) {
    $app.module('gtPartyApp').controller('partyTotalListCtrl', function ($scope, $http, $modal, $ocLazyLoad, $alert, $loading, $state, $bsRouterState, AuthUser, $timeout) {
        $state.params = $bsRouterState.$params($scope);
        $scope.isShow = false;
        $scope.moreTxt = "更多";


        //定义数据集合
        $scope.loginUserId = AuthUser.getUser().Id;
        $scope.dataList = []; //列表数据
        $scope.yearList = [];

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
            year: new Date().getFullYear()
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

        //加载列表数据
        $scope.loadData = function () {
            $http
            ({
                method: 'get', url: '../../api/partyTotal/getPartyTotalList', params: $scope.selectparams
            }).then(function (result) {
                $scope.dataList = result.data.item.list;
                $scope.pageInfo.ptotal = result.data.item.total;
            });
        };

        $scope.getYearsList();


        //报表链接
        {
            $scope.showParty = function (dzzdm, zzlb, sfhj) {
                $bsRouterState.$closeTabName("home.partyList");
                $timeout(function () {
                    $bsRouterState.go('home.partyList', {
                        dzzdm: dzzdm,
                        zzlb: zzlb,
                        jmrq_begintime: sfhj == 1 ? ($scope.selectparams.year + '-01-01') : '',
                        jmrq_endtime: sfhj == 1 ? ($scope.selectparams.year + '-12-31') : ''
                    })
                    ;
                }, 100);
            };

            $scope.showPartyUser = function (dzzdm, sfzg) {
                $bsRouterState.$closeTabName("home.partyUserList");
                $timeout(function () {
                    $bsRouterState.go('home.partyUserList', {
                        dzzdm: dzzdm,
                        sfzg: sfzg
                    });
                }, 100);
            };


            $scope.showCgjq = function (dzzdm, cgjqType) {
                $bsRouterState.$closeTabName("home.cgjqScoreList");
                $timeout(function () {
                    $bsRouterState.go('home.cgjqScoreList', {
                        dzzdm: dzzdm,
                        gqtype: 1,
                        cgjqType: cgjqType,
                        year: $scope.selectparams.year
                    });
                }, 100);
            };


            $scope.showDnpp = function (dzzdm, creatType) {
                $bsRouterState.$closeTabName("home.brandMgList");
                $timeout(function () {
                    $bsRouterState.go('home.brandMgList', {
                        dzzdm: dzzdm,
                        creatType: creatType,
                        beginTime: $scope.selectparams.year + '-01-01',
                        endTime: $scope.selectparams.year + '-12-31'
                    });
                }, 100);
            };


            $scope.showActivityRoom = function (dzzdm) {
                $bsRouterState.$closeTabName("home.djPartyActivityRoomList");
                $timeout(function () {
                    $bsRouterState.go('home.djPartyActivityRoomList', {
                        dzzdm: dzzdm
                    });
                }, 100);
            };

            $scope.showPosition = function (dzzdm) {
                $bsRouterState.$closeTabName("home.publicityPositionList");
                $timeout(function () {
                    $bsRouterState.go('home.publicityPositionList', {
                        dzzdm: dzzdm
                    });
                }, 100);
            };

            $scope.showWxgroup = function (dzzdm) {
                $bsRouterState.$closeTabName("home.wxGroupMgList");
                $timeout(function () {
                    $bsRouterState.go('home.wxGroupMgList', {
                        dzzdm: dzzdm
                    });
                }, 100);
            };

        }

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