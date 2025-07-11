(function ($app) {
    $app.module('gtPartyApp').controller('userLeaderTotalListCtrl', function ($scope, $http, $modal, $ocLazyLoad, $alert, $loading, $state, $bsRouterState, AuthUser, $timeout) {
        $state.params = $bsRouterState.$params($scope);
        $scope.isShow = false;
        $scope.moreTxt = "更多";

        $scope.yearList = [];

        //定义数据集合
        $scope.loginUserId = AuthUser.getUser().Id;
        $scope.dataList = []; //列表数据
        $scope.selectparams = {
            onlyshow_dw: 1,
            isunfold: false,//组织结构树展开收缩
            'pageindex': 1,
            'pagesize': 15,
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
        $scope.resetparams = {
            onlyshow_dw: 1,
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
            userName: ''
        };
        $scope.pageInfo = {ptotal: 0};
        //监视页数变化
        $scope.$watch("selectparams.pageindex", function (newVal, oldVal) {
            if ($scope.pageInfo.ptotal > 0) {
                $scope.loadData();
            }
        });

        $scope.$watch("selectparams.selectdzzdm", function (newVal, oldVal) {
            if (newVal != "") {
                $scope.selectparams.partyCode = $scope.selectparams.selectdzzdm;
                if ($scope.selectparams.selectdzzdm != AuthUser.getUser().DPCode) {
                    $scope.selectparams.userid = "";
                } else {
                    $scope.selectparams.userid = AuthUser.getUser().Id;
                }
                $scope.loadData();
            }
        });

        $scope.$watch("selectparams.zzfbType", function (newVal, oldVal) {
            if (newVal != oldVal) {
                $scope.loadData();
            }
        });

        $scope.$on('tabChildReloadData', function (event, data) {
            if (data.name == 'userLeaderTotalListCtrl') {
                $scope.loadData();
            }
        });


        //查询
        $scope.search = function () {
            $scope.loadData();
        };

        //加载列表数据
        $scope.loadData = function () {
            $scope.selectparams.beginTime = $scope.selectparams.year + "-01-01";
            $scope.selectparams.endTime = $scope.selectparams.year + "-12-31";
            $http
            ({
                method: 'get', url: '../../api/publicity/getUserLeaderTotalList', params: $scope.selectparams
            }).then(function (result) {
                $scope.dataList = result.data.item.list;
                $scope.pageInfo.ptotal = result.data.item.total;
            });
        };

        //查看
        $scope.showData = function (xm, rybm, type) {
            $bsRouterState.$closeTabName("home.userLeaderList");
            $timeout(function () {
                $bsRouterState.go('home.userLeaderList', {
                    leaderType: type, xm: xm, rybm: rybm,
                    beginTime: $scope.selectparams.beginTime, endTime: $scope.selectparams.endTime
                });
            }, 100);
        };

        $scope.getYearList = function () {
            $http({
                method: 'get',
                url: '../../api/dictionary/getDictionaryListByDicTypeKey',
                params: {
                    dicTypeKey: 'years'
                }
            }).then(function (result) {
                $scope.yearList = result.data;
            }, function (resp) {

            });
        };

        $scope.getYearList();

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
            // var $form = $scope.myform;
            // var $names = $form.$$controls;
            // angular.forEach($names, function (val) {
            //     val
            // });
            // $scope.myform.$setPristine();
            // $scope.myform.$setUntouched();
            //$scope.selectparams.selectdzzdm = $scope.resetparams.selectdzzdm;
            //$scope.selectparams.selectdzzmc = $scope.resetparams.selectdzzmc;
            //$scope.selectparams.defaultselected = $scope.resetparams.defaultselected;
            //$scope.selectparams.parentname = $scope.resetparams.parentname;
            //$scope.selectparams.szdzzdm = $scope.resetparams.szdzzdm;
            //$scope.selectparams.szdzzmc = $scope.resetparams.szdzzmc;
            $scope.selectparams.userName = $scope.resetparams.userName;
            //$scope.selectparams.dzzdm = $scope.resetparams.dzzdm;
            // $scope.selectparams.zzlb = $scope.resetparams.zzlb;
            // $scope.selectparams.jczzfl = $scope.resetparams.jczzfl;
            // $scope.selectparams.jldzzrq_begin = $scope.resetparams.jldzzrq_begin;
            // $scope.selectparams.jldzzrq_end = $scope.resetparams.jldzzrq_end;
            // $scope.selectparams.isContainParent = $scope.resetparams.isContainParent;
            // $scope.selectparams.zzfbType = $scope.resetparams.zzfbType;
            //$scope.selectparams.selectdzzmc = $scope.selectparams.dzzmc = $scope.selectparams.zzlb = $scope.selectparams.jczzfl = '';
        }

    });
})(angular);