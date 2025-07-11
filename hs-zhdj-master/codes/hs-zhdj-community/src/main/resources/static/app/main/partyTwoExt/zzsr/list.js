(function ($app) {
    $app.module('gtPartyApp').controller('zzsrCtrl', function ($scope, $http, $modal, $ocLazyLoad, $timeout,$alert, $loading, $state, AuthUser, $stateParams,$bsRouterState) {
        $state.params = $bsRouterState.$params($scope);
        $scope.isShow = false;
        $scope.moreTxt = "更多";


        //定义数据集合
        $scope.dataList = []; //列表数据
        $scope.isDetail = true;
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
            onlyshow_dw: $stateParams.type == 1 ? 1 : 0,
            zzfbType: null,
            beginTime: $state.params.beginTime == undefined ? '' : $state.params.beginTime,
            endTime: $state.params.endTime == undefined ? '' : $state.params.endTime
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
            onlyshow_dw: $stateParams.type == 1 ? 1 : 0,
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
        $scope.$on('tabChildReloadData',function (event,data) {
            if(data.name=='zzsrCtrl'){
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
                method: 'get', url: '../../api/partyTowExt/getZzsrList', params: $scope.selectparams
            }).then(function (result) {
                $scope.dataList = result.data.item.list;
                $scope.pageInfo.ptotal = result.data.item.total;
            });
        };
        $scope.getPositionLevelList = function () {
            $http({
                method: 'get',
                url: '../../api/dictionary/getDictionaryListByDicTypeKey',
                params: {
                    dicTypeKey: 'ZzsrType'
                }
            }).then(function (result) {
                $scope.positionLevelList = result.data;
            }, function (resp) {

            });
        };

        //新增编辑
        $scope.add = function () {
            $scope.isDetail = true;
            if ($scope.selectparams.dzzdm == "" || $scope.selectparams.dzzdm == AuthUser.getUser().gddwdm){
                $scope.showMsg('错误', '请选择组织');
                return false;
            } else {
                $scope.editRedit("", "新增政治生日信息");
            }
        };
        $scope.edit = function (id) {
            $scope.isDetail = true;
            $scope.editRedit(id, "编辑政治生日信息")
        };
        $scope.detail = function (id){
            $scope.isDetail = false;
            $bsRouterState.$closeTabName("home.zzsrview");
            $timeout(function () {
                $bsRouterState.go('home.zzsrview', {
                    id: id,
                    dzzdm: $scope.selectparams.dzzdm,
                    dzzmc:$scope.selectparams.selectdzzmc,
                    isDetail:$scope.isDetail
                });
            }, 100);

        };
        $scope.editRedit = function (id, title) {
            $bsRouterState.$closeTabName("home.zzsredit");
            $timeout(function () {
                $bsRouterState.go('home.zzsredit', {
                    id: id,
                    dzzdm: $scope.selectparams.dzzdm,
                    dzzmc:$scope.selectparams.selectdzzmc,
                    isDetail:$scope.isDetail
                });
            }, 100);

        };

        $scope.delete = function (id) {
            if (confirm("是否确定删除？")) {
                $http({
                    url: "../../api/partyTowExt/delZzsr",
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
                window.open('../../api/partyTowExt/exportZzsr' + params);
            }
        };
        //数据初始化
        $scope.getPositionLevelList();

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
            $scope.selectparams.title = $scope.resetparams.title;
            //$scope.selectparams.dzzdm = $scope.resetparams.dzzdm;
            $scope.selectparams.location = $scope.resetparams.location;
            $scope.selectparams.subjectType = $scope.resetparams.subjectType;
            $scope.selectparams.beginTime = $scope.resetparams.beginTime;
            $scope.selectparams.endTime = $scope.resetparams.endTime;
            // $scope.selectparams.isContainParent = $scope.resetparams.isContainParent;
            // $scope.selectparams.zzfbType = $scope.resetparams.zzfbType;
            //$scope.selectparams.selectdzzmc = $scope.selectparams.dzzmc = $scope.selectparams.zzlb = $scope.selectparams.jczzfl = '';
        }
    });
})(angular);
