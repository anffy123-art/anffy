(function ($app) {
    $app.module('gtPartyApp').controller('cgjqScoreListCtrl', function ($scope, $http, $modal, $ocLazyLoad, $alert, $loading, $state, $stateParams, AuthUser, $bsRouterState) {
        $state.params = $bsRouterState.$params($scope);

        //定义数据集合
        $scope.pageList = [
            {id: 1, title: '责任岗', url: '../main/cgjq/score/scoreedit/post.html'},
            {id: 2, title: '责任区', url: '../main/cgjq/score/scoreedit/area.html'}];
        $scope.activeTab = $state.params.cgjqType == undefined ? 1 : $state.params.cgjqType;
        $scope.loginUserId = AuthUser.getUser().Id;

        $scope.boolList = [{dickey: 1, dicvalue: '是'}, {dickey: 0, dicvalue: '否'}];

        $scope.selectparams = {
            isunfold: false,//组织结构树展开收缩
            selectdzzdm: '',
            selectdzzmc: '',
            zzfbType: null,
            defaultselected: $state.params.dzzdm,
        };
        //责任岗
        $scope.post_dataList = []; //列表数据
        $scope.post_selectparams = {
            pageindex: 1,
            pagesize: 10,
            cgjqType: 1,
            partyCode: '',//党组织代码
            userId: AuthUser.getUser().Id,
            name: '',
            year: $state.params.year == undefined ? null : $state.params.year,
            quarter: null,
            zzfbType: null,
            gqtype: $state.params.gqtype == undefined ? null : $state.params.gqtype
        };
        $scope.post_resetparams = {
            pageindex: 1,
            pagesize: 10,
            cgjqType: 1,
            partyCode: '',//党组织代码
            userId: AuthUser.getUser().Id,
            name: '',
            year: null,
            quarter: null,
            zzfbType: null
        };
        $scope.post_pageInfo = {ptotal: 0};
        //责任区
        $scope.area_dataList = []; //列表数据
        $scope.area_selectparams = {
            pageindex: 1,
            pagesize: 10,
            cgjqType: 2,
            partyCode: '',//党组织代码
            userId: AuthUser.getUser().Id,
            name: '',
            year: $state.params.year == undefined ? null : $state.params.year,
            quarter: null,
            zzfbType: null,
            gqtype: $state.params.gqtype == undefined ? null : $state.params.gqtype
        };
        $scope.area_resetparams = {
            pageindex: 1,
            pagesize: 10,
            cgjqType: 2,
            partyCode: '',//党组织代码
            userId: AuthUser.getUser().Id,
            name: '',
            year: null,
            quarter: null,
            zzfbType: null
        };
        $scope.area_pageInfo = {ptotal: 0};
        $scope.isShow = false;
        $scope.moreTxt = "更多";


        $scope.yearList = [];
        $scope.quarterList = [];


        //选择tab页
        $scope.selectTab = function (setTab) {
            $scope.activeTab = setTab;
            $scope.loadData($scope.activeTab);
        };
        //判断选中项
        $scope.isSelected = function (checkedTab) {
            return $scope.activeTab === checkedTab;

        };
        //监视页数变化
        $scope.$watch("post_selectparams.pageindex", function (newVal, oldVal) {
            if ($scope.post_pageInfo.ptotal > 0) {
                $scope.loadData(1);
            }
        });
        $scope.$watch("area_selectparams.pageindex", function (newVal, oldVal) {
            if ($scope.post_pageInfo.ptotal > 0) {
                $scope.loadData(2);
            }
        });
        $scope.$watch("selectparams.selectdzzdm", function (newVal, oldVal) {
            if (newVal != "") {
                if ($scope.selectparams.defaultselected != "" && $scope.selectparams.defaultselected != null &&
                    $scope.selectparams.defaultselected != $scope.selectparams.selectdzzdm)
                    return;

                $scope.post_selectparams.partyCode = $scope.selectparams.selectdzzdm;
                $scope.area_selectparams.partyCode = $scope.selectparams.selectdzzdm;
                $scope.loadData(1);
                $scope.loadData(2);
            }
        });

        $scope.$watch("selectparams.zzfbType", function (newVal, oldVal) {
            if (newVal != oldVal) {
                $scope.post_selectparams.zzfbType = $scope.selectparams.zzfbType;
                $scope.area_selectparams.zzfbType = $scope.selectparams.zzfbType;
                $scope.loadData(1);
                $scope.loadData(2);
            }
        });

        $scope.$on('tabChildReloadData', function (event, data) {
            if (data.name == 'cgjqScoreListCtrl') {
                $scope.loadData(1);
                $scope.loadData(2);
            }
        });

        //查询
        $scope.search = function (cgjqType) {
            $scope.loadData(cgjqType);
        };

        //加载列表数据
        $scope.loadData = function (cgjqType) {
            $scope.selectparams.defaultselected = "";
            var params = [];
            if (cgjqType == 1) {
                params = $scope.post_selectparams;
            } else {
                params = $scope.area_selectparams;
            }
            $http
            ({
                method: 'get', url: '../../api/cgjq/getPostareaScoreList', params: params
            }).then(function (result) {
                if (cgjqType == 1) {
                    $scope.post_dataList = result.data.item.list;
                    $scope.post_pageInfo.ptotal = result.data.item.total;
                } else {
                    $scope.area_dataList = result.data.item.list;
                    $scope.area_pageInfo.ptotal = result.data.item.total;
                }

            });
        };

        //新增
        $scope.addData = function (cgjqType) {
            $bsRouterState.go('home.cgjqScoreEdit', {
                id: "",
                cgjqType: cgjqType,
                dzzdm: $scope.selectparams.selectdzzdm,
                isDetail: 1
            });
        };
        //修改
        $scope.editData = function (id, cgjqType) {
            $bsRouterState.go('home.cgjqScoreEdit', {
                id: id,
                cgjqType: cgjqType,
                dzzdm: $scope.selectparams.selectdzzdm,
                isDetail: 1
            });
        };
        //查看
        $scope.detailData = function (id, cgjqType) {
            $bsRouterState.go('home.cgjqScoreEdit', {
                id: id,
                cgjqType: cgjqType,
                dzzdm: $scope.selectparams.selectdzzdm,
                isDetail: 0
            });
        };
        //删除
        $scope.deleteData = function (id, cgjqType) {
            if (confirm("是否确定删除？")) {
                $http({
                    url: "../../api/cgjq/deletePostareaScoreById",
                    method: 'GET',
                    params: {id: id}
                }).then(function (result) {
                    $scope.showMsg("消息", result.data.msg);
                    if (result.data.success) {
                        $scope.loadData(cgjqType);
                    }
                });
            }
        };
        //导出
        $scope.export = function (cgjqType) {
            if (AuthUser.getUser().Id) {
                var params = "?1=1";
                var exportparams = [];
                if (cgjqType == 1) {
                    exportparams = $scope.post_selectparams;
                } else {
                    exportparams = $scope.area_selectparams;
                }
                for (var p in exportparams) {
                    if (exportparams[p] != '' && exportparams[p] != null)
                        params += ("&" + p + "=" + encodeURI(exportparams[p]));
                }
                window.open('../../api/cgjq/exportPostareaScore' + params);
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
        $scope.setisunfold = function () {
            $scope.selectparams.isunfold = !$scope.selectparams.isunfold;
            $scope.$emit('menudatas.toggle', !$scope.selectparams.isunfold);
        };
        $scope.getYearsList();
        $scope.getQuartersList();

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
            $scope.area_selectparams.name = $scope.area_resetparams.name;
            $scope.area_selectparams.headUserName = $scope.area_resetparams.headUserName;
            $scope.area_selectparams.year = $scope.area_resetparams.year;
            $scope.area_selectparams.quarter = $scope.area_resetparams.quarter;
            $scope.post_selectparams.name = $scope.post_resetparams.name;
            $scope.post_selectparams.headUserName = $scope.post_resetparams.headUserName;
            $scope.post_selectparams.year = $scope.post_resetparams.year;
            $scope.post_selectparams.quarter = $scope.post_resetparams.quarter;
            //$scope.selectparams.selectdzzmc = $scope.selectparams.dzzmc = $scope.selectparams.zzlb = $scope.selectparams.jczzfl = '';
        }

    });
})(angular);
