(function ($app) {
    $app.module('gtPartyApp').controller('djResultmgListCtrl', function ($scope, $http, $modal, $ocLazyLoad, $alert, $loading, $state, $bsRouterState, AuthUser, $timeout) {
        $state.params = $bsRouterState.$params($scope);

        //定义数据集合
        $scope.loginUserId = AuthUser.getUser().Id;
        $scope.dataList = []; //列表数据
        $scope.isShow = false;
        $scope.moreTxt = "更多";


        $scope.pflowList = [];
        $scope.flowList = [];

        $scope.selectparams = {
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
            partyCode: '',//党组织代码
            name: '',
            beginTime:$state.params.bt==null?'':$state.params.bt,
            endTime:$state.params.et==null?'':$state.params.et,
            userid: AuthUser.getUser().Id,
            zzfbType: null
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
            partyCode: '',//党组织代码
            name: '',
            beginTime:'',
            endTime:'',
            userid: AuthUser.getUser().Id,
            zzfbType: null
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

                if ($scope.selectparams.defaultselected != "" && $scope.selectparams.defaultselected != null &&
                    $scope.selectparams.defaultselected != $scope.selectparams.selectdzzdm)
                    return;
                $scope.selectparams.defaultselected = "";

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

        $scope.$on('tabChildReloadData',function (event,data) {
            if(data.name=='ResultmgListCtrl'){
                $scope.loadData();
            }
        });

        //查询
        $scope.search = function () {
            $scope.loadData();
        };
        //导出
        $scope.exportData = function () {
            if ($scope.selectparams.dzzdm != "" && $scope.selectparams.dzzdm != AuthUser.getUser().gddwdm) {
                var params = "?1=1";
                for (var p in $scope.selectparams) {
                    if ($scope.selectparams[p] !== '' && $scope.selectparams[p] !== null)
                        params += ("&" + p + "=" + encodeURI($scope.selectparams[p]));
                }
                window.open('../../api/partyTowExt/exportResultmg' + params);
            }
        };

        //加载列表数据
        $scope.loadData = function () {
            $http
            ({
                method: 'get', url: '../../api/partyTowExt/getResultmgList', params: $scope.selectparams
            }).then(function (result) {
                $scope.dataList = result.data.item.list;
                $scope.pageInfo.ptotal = result.data.item.total;
            });
        };

        //新增
        $scope.addData = function () {
            $bsRouterState.$closeTabName("home.djResultmgEdit");
            $timeout(function () {
                $bsRouterState.go('home.djResultmgEdit', {
                    id: "",
                    pc: $scope.selectparams.partyCode,
                    st:1
                });
            }, 100);
        };
        //修改
        $scope.editData = function (id) {

            $timeout(function () {
                $bsRouterState.go('home.djResultmgEdit', {
                    id: id,
                    st:1
                });
            }, 100);
        };

        //查看
        $scope.showData = function (id) {
            $bsRouterState.$closeTabName("home.djResultmgEdit");
            $timeout(function () {
                $bsRouterState.go('home.djResultmgEdit', {id: id,st:2});
            }, 100);
        };
        /*
        $scope.editProcess = function (id) {
            $bsRouterState.$closeTabName("home.peJoinUserProcess");
            $timeout(function () {
                $bsRouterState.go('home.peJoinUserProcess', {
                    id: id
                });
            }, 100);
        };*/

        //删除
        $scope.deleteData = function (id) {
            if (confirm("是否确定删除？")) {
                $http({
                    url: "../../api/partyTowExt/resultmgDel",
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
        /*
        $scope.loadParentFlows = function () {
            $http
            ({
                method: 'get', url: '../../api/pe/wordTemplate/getPFlowDicList'
            }).then(function (result) {
                $scope.pflowList = result.data.item;
            });
        };

        $scope.loaFlows = function () {

            $scope.flowList.length = 0;

            $http
            ({
                method: 'get', url: '../../api/pe/wordTemplate/getFlowDicList',
                params: {pid: $scope.selectparams.pflowid}
            }).then(function (result) {
                if (result.data.item) {
                    $scope.flowList = result.data.item;
                }

            });
        };
        */
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
            $scope.selectparams.name = $scope.resetparams.name;
            //$scope.selectparams.dzzdm = $scope.resetparams.dzzdm;
            $scope.selectparams.beginTime = $scope.resetparams.beginTime;
            $scope.selectparams.endTime = $scope.resetparams.endTime;
            // $scope.selectparams.jldzzrq_begin = $scope.resetparams.jldzzrq_begin;
            // $scope.selectparams.jldzzrq_end = $scope.resetparams.jldzzrq_end;
            // $scope.selectparams.isContainParent = $scope.resetparams.isContainParent;
            // $scope.selectparams.zzfbType = $scope.resetparams.zzfbType;
            //$scope.selectparams.selectdzzmc = $scope.selectparams.dzzmc = $scope.selectparams.zzlb = $scope.selectparams.jczzfl = '';
        }
        //$scope.loadParentFlows();
    });
})(angular);
