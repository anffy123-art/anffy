(function ($saga_demandlist) {
    'use strict';
    $saga_demandlist.module('zcapp').controller('demandlistCtrl', function ($scope, $http, $state, $alert, AuthUser, $loading) {
        $scope.selectdata = {
            ApplyNo: '',
            DemandTitle: '',
            uid: AuthUser.getUser().DGUserID,
            pageindex: 1,
            pagesize: 10,
            ptotal: 0,
            StateOfFlow: null
        };
        $scope.copy_selectdata = {};
        angular.copy($scope.selectdata, $scope.copy_selectdata);
        $scope.items = [];
        $scope.confirmed = false;

        $scope.loadData = function () {
            $loading.show();
            $scope.copy_selectdata.pageindex = $scope.selectdata.pageindex;
            if (angular.isUndefined($scope.selectdata.StateOfFlow) || $scope.selectdata.StateOfFlow == null) {
                $scope.copy_selectdata.StateOfFlow = "";
            }

            $http({
                url: "../../api/DemandFlow/getDemandApplylist",
                method: 'GET',
                params: $scope.copy_selectdata
            }).then(function (rq) {
                $scope.items = rq.data.items;
                $scope.selectdata.ptotal = rq.data.total;
                $loading.hide();
            });
        }
        //获取流程状态字典
        $scope.getStateOfFlow = function () {
            $http({
                url: "../../api/Comm/GetDictionaryListByDicType",
                method: 'GET',
                params: {DicTypeKey: "DemandApply_StateOfFlow"}
            }).then(function (rq) {
                $scope.UrgentStatuslist = rq.data;
            });
        }
        $scope.selectpage = function () {

            angular.copy($scope.selectdata, $scope.copy_selectdata);
            $scope.selectdata.pageindex = 1;
            $scope.selectdata.ptotal = 0;
            $scope.loadData();
        }

        //监视页数变化
        $scope.$watch("selectdata.pageindex", function (newVal, oldVal) {
            if ($scope.selectdata.ptotal > 0) {
                $scope.loadData();
            }
        });

        $scope.goModalEdit = function (item, flag) {
            /*
            if (item.FlowStep < 1 || item.CurUrl==null) {
                $state.go("home.demandup", { id: item.DemandApplyID });
            } else {
                window.location.href = "#!/" + item.CurUrl;
            }*/
            $state.go('home.dmup', {id: ''});

        }

        $scope.deleteit = function (id) {
            if (confirm("是否确定删除？")) {
                $http({
                    url: "../../api/DemandFlow/delDemandApply",
                    method: 'GET',
                    params: {id: id}
                }).then(function (rq) {
                    $alert({
                        title: '消息',
                        content: rq.data.msg,
                        placement: 'top',
                        type: 'info',
                        show: true,
                        duration: 3
                    });
                    if (rq.data.success) {
                        $scope.loadData();
                    }
                });
            }
        }
        //$scope.getStateOfFlow();
        //$scope.selectpage();
    });
})(angular);