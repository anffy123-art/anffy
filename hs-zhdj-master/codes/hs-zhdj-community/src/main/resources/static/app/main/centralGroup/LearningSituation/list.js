(function ($app) {
    $app.module('gtPartyApp').controller('LearningSituationListCtrl', function ($scope, $http, $modal, $ocLazyLoad, $alert, $loading, $state, $stateParams, AuthUser,$bsRouterState) {

        $stateParams=$bsRouterState.$params($scope);

        $state.params = $bsRouterState.$params($scope);

        //定义数据集合
        $scope.dataList = []; //列表数据
        $scope.isShow = false;
        $scope.moreTxt = "更多";


        $scope.selectparams = {
            isunfold: false,//组织结构树展开收缩
            shykType: $stateParams.type,
            'pageindex': 1,
            'pagesize': 10,
            defaultselected: $state.params.dzzdm,
            dzzdm: '',
            dzzmc:'',
            userName:  $state.params.xm == undefined ? '' : $state.params.xm,
            dwId: '',
            studySTime: $state.params.beginTime == undefined ? '' : $state.params.beginTime,
            studyETime: $state.params.endTime == undefined ? '' : $state.params.endTime,
            onlyshow_dw: $stateParams.type,
            zzfbType : null,
        };
        $scope.resetparams = {
            isunfold: false,//组织结构树展开收缩
            shykType: $stateParams.type,
            'pageindex': 1,
            'pagesize': 10,
            dzzdm: '',
            dzzmc:'',
            userName: '',
            dwId: '',
            studySTime: '',
            studyETime: '',
            onlyshow_dw: $stateParams.type,
            zzfbType : null,
        };
        $scope.pageInfo = {ptotal: 0};
        //监视页数变化
        $scope.$watch("selectparams.pageindex", function (newVal, oldVal) {
            if ($scope.pageInfo.ptotal > 0) {
                $scope.loadData();
            }
        });
        $scope.$watch("selectparams.dzzdm", function (newVal, oldVal) {
            if (newVal != '' && newVal != null) {
                if ($scope.selectparams.defaultselected != "" && $scope.selectparams.defaultselected != null &&
                    $scope.selectparams.defaultselected != $scope.selectparams.dzzdm)
                    return;

                $scope.selectparams.defaultselected = "";
                //$scope.selectparams.parentcode = $scope.selectparams.dzzdm;
                $scope.loadData();
            }
        });
        $scope.$watch("selectparams.zzfbType", function (newVal, oldVal) {
            if (newVal != oldVal) {
                $scope.loadData();
            }
        });

        $scope.$on('tabChildReloadData',function (event,data) {
            if(data.name=='LearningSituationListCtrl'){
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
                method: 'get', url: '../../api/zxzxx/xxqk/list', params: $scope.selectparams
            }).then(function (result) {
                $scope.dataList = result.data.item.list;
                $scope.pageInfo.ptotal = result.data.item.total;
            });
        };

        //导出
        $scope.exportData = function () {
            var params = "?1=1";
            for (var p in $scope.selectparams) {
                if ($scope.selectparams[p] !== '' && $scope.selectparams[p] !== null)
                    params += ("&" + p + "=" + encodeURI($scope.selectparams[p]));
            }
            window.open('../../api/zxzxx/xxqk/exportList' + params);
        };
        //查看方案
        $scope.detailsData = function (id) {
            $bsRouterState.go('home.LearningSituationDetails', {
                id: id
            });
        };
        //删除
        $scope.deleteData = function (id) {
            if (confirm("是否确定删除？")) {
                $http({
                    url: "../../api/zxzxx/xxjh/delete",
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

        $scope.isShowClick = function(){
            $scope.isShow=!$scope.isShow;
            if($scope.moreTxt == "更多")
            {
                $scope.moreTxt = "收起";
            }
            else if($scope.moreTxt == "收起")
            {
                $scope.moreTxt = "更多";
            }
        };
        $scope.setisunfold = function () {
            $scope.selectparams.isunfold = !$scope.selectparams.isunfold;
            $scope.$emit('menudatas.toggle', !$scope.selectparams.isunfold);
        };
        //$scope.loadData();
        $scope.reset  = function () {
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
            $scope.selectparams.dwId = $scope.resetparams.dwId;
            $scope.selectparams.studySTime = $scope.resetparams.studySTime;
            $scope.selectparams.studyETime = $scope.resetparams.studyETime;
            // $scope.selectparams.jldzzrq_end = $scope.resetparams.jldzzrq_end;
            // $scope.selectparams.isContainParent = $scope.resetparams.isContainParent;
            // $scope.selectparams.zzfbType = $scope.resetparams.zzfbType;
            //$scope.selectparams.selectdzzmc = $scope.selectparams.dzzmc = $scope.selectparams.zzlb = $scope.selectparams.jczzfl = '';
        }
    });
})(angular);