(function ($app) {
    $app.module('gtPartyApp').controller('learningPlanReceiveListCtrl', function ($scope, $http, $modal, $ocLazyLoad, $alert, $loading, $state, $stateParams, AuthUser, $bsRouterState) {
        //定义数据集合
        $scope.dataList = []; //列表数据
        $scope.isShow = false;
        $scope.moreTxt = "更多";


        $scope.selectparams = {
            isunfold: false,//组织结构树展开收缩
            shykType: $stateParams.type,
            'pageindex': 1,
            'pagesize': 10,
            id: '',
            name: '',
            endTimeStart: '',
            endTimeEnd: '',
            /*userId:AuthUser.getUser().Id,
            roleId:AuthUser.getUser().curRoleId*/
            dzzdm: AuthUser.getUser().DataDzzdm.length < AuthUser.getUser().generalPartyCode.length ? AuthUser.getUser().DataDzzdm : AuthUser.getUser().generalPartyCode
        };
        $scope.resetparams = {
            isunfold: false,//组织结构树展开收缩
            shykType: $stateParams.type,
            'pageindex': 1,
            'pagesize': 10,
            id: '',
            name: '',
            endTimeStart: '',
            endTimeEnd: ''
        };
        $scope.pageInfo = {ptotal: 0};
        //监视页数变化
        $scope.$watch("selectparams.pageindex", function (newVal, oldVal) {
            if ($scope.pageInfo.ptotal > 0) {
                $scope.loadData();
            }
        });

        $scope.$on('tabChildReloadData', function (event, data) {
            if (data.name == 'learningPlanReceiveListCtrl') {
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
                method: 'get', url: '../../api/zxzxx/xxjh/list4zd', params: $scope.selectparams
            }).then(function (result) {
                $scope.dataList = result.data.item.list;
                $scope.pageInfo.ptotal = result.data.item.total;
            });
        };

        //接收
        $scope.receiveData = function (id) {
            if (confirm("是否确定接收？")) {
                $http.get("../../api/zxzxx/xxjh/markReceived", {
                    params: {
                        'id': id,
                        'userId': AuthUser.getUser().Id,
                        'roleId': AuthUser.getUser().curRoleId
                    }
                }).then(function (result) {
                    $scope.showMsg("消息", result.data.msg);
                    if (result.data.success) {
                        $scope.loadData();
                    }
                }, function () {
                    $scope.showMsg('错误', '服务器错误');
                });
            }
        };

        //查看
        $scope.detailsData = function (id) {
            /*$state.go('home.learningPlanReceiveDetails', {
                id: id
            });*/

            $bsRouterState.go('home.learningPlanReceiveDetails', {
                id: id
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

        $scope.loadData();
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
            $scope.selectparams.name = $scope.resetparams.name;
            //$scope.selectparams.dzzdm = $scope.resetparams.dzzdm;
            $scope.selectparams.endTimeStart = $scope.resetparams.endTimeStart;
            $scope.selectparams.endTimeEnd = $scope.resetparams.endTimeEnd;
            // $scope.selectparams.jldzzrq_begin = $scope.resetparams.jldzzrq_begin;
            // $scope.selectparams.jldzzrq_end = $scope.resetparams.jldzzrq_end;
            // $scope.selectparams.isContainParent = $scope.resetparams.isContainParent;
            // $scope.selectparams.zzfbType = $scope.resetparams.zzfbType;
            //$scope.selectparams.selectdzzmc = $scope.selectparams.dzzmc = $scope.selectparams.zzlb = $scope.selectparams.jczzfl = '';
        }
    });
})(angular);