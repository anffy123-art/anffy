(function ($app) {
    $app.module('gtPartyApp').controller('userThoughtTotalListCtrl', function ($scope, $http, $modal, $ocLazyLoad, $alert, $loading, $state, $bsRouterState, AuthUser, $timeout) {
        $state.params = $bsRouterState.$params($scope);
        $scope.isShow = false;
        $scope.moreTxt = "更多";
        //定义数据集合
        $scope.loginUserId = AuthUser.getUser().Id;
        $scope.dataList = []; //列表数据

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
            zzfbType:null,
            partyCode: '',//党组织代码
            userid: AuthUser.getUser().Id,
            month: '',
            writeUser: ''
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
            if(data.name=='userThoughtTotalListCtrl'){
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
                method: 'get', url: '../../api/publicity/getUserThoughtTotalList', params: $scope.selectparams
            }).then(function (result) {
                $scope.dataList = result.data.item.list;
                $scope.pageInfo.ptotal = result.data.item.total;
            });
        };

        //新增
        $scope.addData = function () {
            $bsRouterState.$closeTabName("home.userThoughtTotalAdd");
            $timeout(function () {
                $bsRouterState.go('home.userThoughtTotalAdd', {
                    id: "",
                    dzzdm: $scope.selectparams.partyCode
                });
            }, 100);
        };
        //修改
        $scope.editData = function (id) {
            $bsRouterState.$closeTabName("home.userThoughtTotalEdit");
            $timeout(function () {
                $bsRouterState.go('home.userThoughtTotalEdit', {
                    id: id,
                    dzzdm: $scope.selectparams.partyCode
                });
            }, 100);
        };

        //查看
        $scope.showData = function (id) {
            $bsRouterState.$closeTabName("home.userThoughtTotalShow");
            $timeout(function () {
                $bsRouterState.go('home.userThoughtTotalShow', {id: id, op: 0});
            }, 100);
        };

        //删除
        $scope.deleteData = function (id) {
            if (confirm("是否确定删除？")) {
                $http({
                    url: "../../api/publicity/deletetUserthoughtTotalById",
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

        $scope.exportData = function () {
            if ($scope.selectparams.dzzdm != "" && $scope.selectparams.dzzdm != AuthUser.getUser().gddwdm) {
                var params = "?1=1";
                for (var p in $scope.selectparams) {
                    if ($scope.selectparams[p] !== '' && $scope.selectparams[p] !== null)
                        params += ("&" + p + "=" + encodeURI($scope.selectparams[p]));
                }
                window.open('../../api/publicity/exportUserthoughtTotal' + params);
            }
        };


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
        }

    });
})(angular);