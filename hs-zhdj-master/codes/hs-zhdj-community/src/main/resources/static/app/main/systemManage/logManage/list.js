(function ($app) {
    $app.module('gtPartyApp').controller('logListCtrl', function ($scope, $http, $modal, $ocLazyLoad, $alert, $loading, $state, $stateParams, AuthUser, $bsRouterState) {
        $state.params = $bsRouterState.$params($scope);

        //定义数据集合
        $scope.loginUserId = AuthUser.getUser().Id;
        $scope.dataList = []; //列表数据

        $scope.selectparams = {
            pageindex: 1,
            pagesize: 10,
            beginTime: '',
            endTime: '',
            userName: ''
        };
        $scope.resetparams = {
            pageindex: 1,
            pagesize: 10,
            beginTime: '',
            endTime: '',
            userName: ''
        };
        $scope.pageInfo = {ptotal: 0};
        //监视页数变化
        $scope.$watch("selectparams.pageindex", function (newVal, oldVal) {
            if ($scope.pageInfo.ptotal > 0) {
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
                method: 'get', url: '../../api/log/getLogList', params: $scope.selectparams
            }).then(function (result) {
                $scope.dataList = result.data.item.list;
                $scope.pageInfo.ptotal = result.data.item.total;
            });
        };

        var showModalCtrl = function ($scope, $http) {
            $scope.title='日志明细';
            $scope.dataModel=myModal.selectItem;

        };

        showModalCtrl.$inject = ['$scope', '$http'];

        //新增或编辑字典 模态框
        var myModal = $modal({
            scope: $scope,
            controller: showModalCtrl,
            templateUrl: 'systemManage/logManage/showmodal.html',
            show: false,
            animation: 'am-fade-and-slide-top'
        });

        $scope.showItem=function(it){
            myModal.selectItem=it;
            myModal.$promise.then(myModal.show);
        };

        $scope.loadData();
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
            $scope.selectparams.beginTime = $scope.resetparams.beginTime;
            $scope.selectparams.endTime = $scope.resetparams.endTime;
            //$scope.selectparams.selectdzzmc = $scope.selectparams.dzzmc = $scope.selectparams.zzlb = $scope.selectparams.jczzfl = '';
        }
    });
})(angular);
