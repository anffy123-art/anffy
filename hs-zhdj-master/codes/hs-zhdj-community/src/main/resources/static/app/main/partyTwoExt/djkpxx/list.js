(function ($app) {
    $app.module('gtPartyApp').controller('djkpxxCtrl', function ($scope, $http, $modal, $ocLazyLoad, $timeout, $alert, $loading, $state, AuthUser, $stateParams, $bsRouterState) {
        $state.params = $bsRouterState.$params($scope);
        /*1、 所属单位党组织工作考核 显示党委层级即可。
         2、党支部工作考核：显示党支部工作考核TAB，并过滤（党委、党工委）类型组织。评定等级改为：先进  一般  薄弱*/
        $scope.type = $state.params.type; //单位党组织工作考核=1， 党支部工作考核=2
        $scope.isShow = false;
        $scope.moreTxt = "更多";
        //定义数据集合
        $scope.dataList = []; //列表数据
        $scope.isDetail = true;
        //当前年度季度
        var year = new Date().getFullYear();
        //初始化查询参数
        $scope.selectparams = {
            isunfold: false,//组织结构树展开收缩
            'pageindex': 1,
            'pagesize': 10,
            'selectdzzdm': '',
            selectdzzmc: '',
            defaultselected: $state.params.dzzdm,
            parentcode: AuthUser.getUser().ParentDpCode,
            parentname: AuthUser.getUser().ParentDpName,
            szdzzdm: AuthUser.getUser().DPCode,
            szdzzmc: AuthUser.getUser().DPName,
            dzzdm: '',
            ldjtjc: '',
            dzzmc: '',
            xm: '',
            zwmc: null,
            rzfs: null,
            userid: AuthUser.getUser().Id,
            onlyshow_dw: $state.params.type == 1 ? 1 : 0,
            zzfbType: null,
            judgeLevel: $state.params.judgeLevel == undefined ? null : $state.params.judgeLevel,
            showdw: $scope.type == '1' ? 1 : 2,
            year: $state.params.year == undefined ? year : $state.params.year
        };
        $scope.resetparams = {
            isunfold: false,//组织结构树展开收缩
            'pageindex': 1,
            'pagesize': 10,
            'selectdzzdm': '',
            selectdzzmc: '',
            parentcode: AuthUser.getUser().ParentDpCode,
            parentname: AuthUser.getUser().ParentDpName,
            szdzzdm: AuthUser.getUser().DPCode,
            szdzzmc: AuthUser.getUser().DPName,
            dzzdm: '',
            ldjtjc: '',
            dzzmc: '',
            xm: '',
            zwmc: null,
            rzfs: null,
            userid: AuthUser.getUser().Id,
            onlyshow_dw: $state.params.type == 1 ? 1 : 0,
            zzfbType: null
        };
        $scope.pageInfo = {ptotal: 0};
        //监视页数变化
        $scope.$watch("selectparams.pageindex", function (newVal, oldVal) {
            if ($scope.pageInfo.ptotal > 0) {
                $scope.loadData();
            }
        });
        //监视党组织选中变化
        $scope.$watch("selectparams.selectdzzdm", function (newVal, oldVal) {
            if (newVal != '' && newVal != null) {
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
            if (data.name == 'djkpxxCtrl') {
                $scope.loadData();
            }
        });
        //查询
        $scope.search = function () {
            $scope.loadData();
        };

        //加载列表数据
        $scope.loadData = function () {

            $http
            ({
                method: 'get', url: '../../api/partyTowExt/getDjkpxxList', params: $scope.selectparams
            }).then(function (result) {
                $scope.dataList = result.data.item.list;
                $scope.pageInfo.ptotal = result.data.item.total;
            });
        };
        $scope.getJudgeLevelList = function () {
            $http({
                method: 'get',
                url: '../../api/dictionary/getDictionaryListByDicTypeKey',
                params: {
                    dicTypeKey: 'judgeLevel'
                }
            }).then(function (result) {
                $scope.judgeLevelList = result.data.filter(function (item) {
                    return item.dicnote == $scope.type.toString();
                });
            }, function (resp) {

            });
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

        //新增编辑
        $scope.add = function () {
            $scope.isDetail = true;
            if ($scope.selectparams.dzzdm == "" || $scope.selectparams.dzzdm == AuthUser.getUser().gddwdm) {
                $scope.showMsg('错误', '请选择组织');
                return false;
            }
            if ($state.params.type == 2) {
                //逻辑判断
                $http.get("../../api/party/getByDzzdm", {
                    params: {
                        'dzzdm': $scope.selectparams.dzzdm
                    }
                }).then(function (result) {
                    if (result.data.item.zzlb == '100' || result.data.item.zzlb == '200') {
                        $scope.showMsg('错误', '请选择党支部或党小组');
                        return false;
                    }
                    $scope.editRedit("", "新增党建考评信息");
                }, function () {
                    $scope.showMsg('错误', '服务器错误');
                });
                return false;
            }
            $scope.editRedit("", "新增党建考评信息");
        };
        $scope.batchAdd = function () {
            $timeout(function () {
                $bsRouterState.go('home.djkpBatch', {
                    dzzdm: $scope.selectparams.dzzdm,
                    dzzmc: $scope.selectparams.selectdzzmc,
                    type: $scope.type,
                    year:$scope.selectparams.year
                });
            }, 100);
        };
        $scope.edit = function (id) {
            $scope.isDetail = true;
            $scope.editRedit(id, "编辑党建考评信息")
        };
        $scope.detail = function (id) {
            $scope.isDetail = false;
            $bsRouterState.$closeTabName("home.djkpxxview");
            $timeout(function () {
                $bsRouterState.go('home.djkpxxview', {
                    id: id,
                    dzzdm: $scope.selectparams.dzzdm,
                    dzzmc: $scope.selectparams.selectdzzmc,
                    isDetail: $scope.isDetail,
                    type: $scope.type,
                });
            }, 100);
        };
        $scope.editRedit = function (id, title) {
            $bsRouterState.$closeTabName("home.djkpxxedit");
            $timeout(function () {
                $bsRouterState.go('home.djkpxxedit', {
                    id: id,
                    dzzdm: $scope.selectparams.dzzdm,
                    dzzmc: $scope.selectparams.selectdzzmc,
                    isDetail: $scope.isDetail,
                    type: $scope.type,
                });
            }, 100);
        };

        $scope.delete = function (id) {
            if (confirm("是否确定删除？")) {
                $http({
                    url: "../../api/partyTowExt/delDjkpxx",
                    method: 'GET',
                    params: {id: id}
                }).then(function (result) {
                    $scope.showMsg("消息", result.data.msg);
                    if (result.data.success) {
                        $scope.loadData();
                    }
                });
            }
        };

        $scope.export = function () {
            if ($scope.selectparams.dzzdm != "") {
                var params = "?1=1";
                for (var p in $scope.selectparams) {
                    if ($scope.selectparams[p] !== '' && $scope.selectparams[p] !== null)
                        params += ("&" + p + "=" + encodeURI($scope.selectparams[p]));
                }
                window.open('../../api/partyTowExt/exportDjkpxx' + params);
            }
        };
        //数据初始化
        $scope.getYearList();
        $scope.getJudgeLevelList();

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
        $scope.isUnfoldfun = function () {
            $scope.selectparams.isunfold = !$scope.selectparams.isunfold;
            $scope.$emit('menudatas.toggle', $scope.selectparams.isunfold);
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
            $scope.selectparams.year = $scope.resetparams.year;
            //$scope.selectparams.dzzdm = $scope.resetparams.dzzdm;
            $scope.selectparams.judgeLevel = $scope.resetparams.judgeLevel;
            // $scope.selectparams.jczzfl = $scope.resetparams.jczzfl;
            // $scope.selectparams.jldzzrq_begin = $scope.resetparams.jldzzrq_begin;
            // $scope.selectparams.jldzzrq_end = $scope.resetparams.jldzzrq_end;
            // $scope.selectparams.isContainParent = $scope.resetparams.isContainParent;
            // $scope.selectparams.zzfbType = $scope.resetparams.zzfbType;
            //$scope.selectparams.selectdzzmc = $scope.selectparams.dzzmc = $scope.selectparams.zzlb = $scope.selectparams.jczzfl = '';
        }

    });
})(angular);