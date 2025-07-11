(function ($app) {
    $app.module('gtPartyApp').controller('programmeListCtrl', function ($scope, $http, $modal, $ocLazyLoad, $alert, $loading, $state, $stateParams, AuthUser,$bsRouterState) {

        $stateParams=$bsRouterState.$params($scope);
        //定义数据集合
        $scope.dataList = []; //列表数据
        $scope.isShow = false;
        $scope.moreTxt = "更多";


        $scope.selectparams = {
            isunfold: false,//组织结构树展开收缩
            'pageindex': 1,
            'pagesize': 10,
            dzzdm:  '',
            dzzmc: '',
            caseName:'',
            planName:'',
            step:null,
            studyModalityCode:$stateParams.scode== undefined?null:$stateParams.scode,
            endTimeStart: $stateParams.bt==null?'':$stateParams.bt,
            endTimeEnd: '',
            onlyshow_dw: $stateParams.type,
            zzfbType : null,
            defaultselected: $stateParams.dzzdm,
            roleid:AuthUser.getUser().curRoleId,
            userId:AuthUser.getUser().Id
        };
        $scope.resetparams = {
            isunfold: false,//组织结构树展开收缩
            'pageindex': 1,
            'pagesize': 10,
            dzzdm:  '',
            dzzmc: '',
            caseName:'',
            planName:'',
            step:null,
            studyModalityCode:null,
            endTimeStart: '',
            endTimeEnd: '',
            onlyshow_dw: $stateParams.type,
            zzfbType : null,
            defaultselected: $stateParams.dzzdm
        };
        $scope.pageInfo = {ptotal: 0};
        //监视页数变化
        $scope.$watch("selectparams.pageindex", function () {
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

                $scope.loadData();
            }
        });

        $scope.$watch("selectparams.zzfbType", function (newVal, oldVal) {
            if (newVal != oldVal) {
                $scope.loadData();
            }
        });

        $scope.$on('tabChildReloadData',function (event,data) {
            if(data.name=='programmeListCtrl'){
                $scope.loadData();
            }
        });
       /* $scope.dzzdmSetByRoleId = function () {
            $http
            ({
                method: 'get', url: '../../api/zxzxx/xxfa/isRoleIdSetdzzdm', params: {
                    curRoleId:$scope.selectparams.roleid,
                    userId:AuthUser.getUser().Id
                }
            }).then(function (result) {
                $scope.selectparams.userdzzdm =result.data.msg
                console.log($scope.selectparams.userdzzdm)
            });
        };
        $scope.dzzdmSetByRoleId();*/
        //查询
        $scope.search = function () {
            $scope.loadData();
        };
        //加载列表数据
        $scope.loadData = function () {
            $http
            ({
                method: 'get', url: '../../api/zxzxx/xxfa/list', params: $scope.selectparams
            }).then(function (result) {
                $scope.dataList = result.data.item.list;
                $scope.pageInfo.ptotal = result.data.item.total;
            });
        };




        //加载查询下拉数据
        $scope.selectparamsMenu = function(){
            $http({
                url: "../../api/dictionary/GetDictionaryList",
                method: 'GET',
                params: {
                    dicTypeKey: 'zxzxxfabz'
                }
            }).then(function (result) {
                $scope.stepList = result.data.item.list;
            });
            $http({
                url: "../../api/dictionary/GetDictionaryList",
                method: 'GET',
                params: {
                    dicTypeKey: 'zxzxxxxfaxxxs'
                }
            }).then(function (result) {
                $scope.studyModalityList = result.data.item.list;
            });
        };

        //新增
        $scope.addData = function () {
            $bsRouterState.go('home.programmeAdd', {
                id: "",
                dzzdm:$scope.selectparams.dzzdm,
                dzzmc:$scope.selectparams.dzzmc
            });
        };
        //修改
        $scope.editData = function (id) {
            $bsRouterState.go('home.programmeEdit', {
                id: id
            });
        };
        //查看
        $scope.detailsData = function (id) {
            $bsRouterState.go('home.programmeDetails', {
                id: id
            });
        };
        //删除
        $scope.deleteData = function (id) {
            if (confirm("是否确定删除？")) {
                $http({
                    url: "../../api/zxzxx/xxfa/deleteById",
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
        $scope.selectparamsMenu();

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
            $scope.selectparams.caseName = $scope.resetparams.caseName;
            //$scope.selectparams.dzzdm = $scope.resetparams.dzzdm;
            $scope.selectparams.planName = $scope.resetparams.planName;
            $scope.selectparams.step = $scope.resetparams.step;
            $scope.selectparams.studyModalityCode = $scope.resetparams.studyModalityCode;
            $scope.selectparams.endTimeStart = $scope.resetparams.endTimeStart;
            $scope.selectparams.endTimeEnd = $scope.resetparams.endTimeEnd;
            // $scope.selectparams.zzfbType = $scope.resetparams.zzfbType;
            //$scope.selectparams.selectdzzmc = $scope.selectparams.dzzmc = $scope.selectparams.zzlb = $scope.selectparams.jczzfl = '';
        }
    });
})(angular);
