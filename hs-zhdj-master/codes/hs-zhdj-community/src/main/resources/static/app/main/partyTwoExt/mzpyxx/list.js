(function ($app) {
    $app.module('gtPartyApp').controller('mzpyxxCtrl', function ($scope, $http, $modal, $ocLazyLoad, $timeout, $alert, $loading, $state, AuthUser, $stateParams, $bsRouterState) {
        $state.params = $bsRouterState.$params($scope);
        $scope.isShow = false;
        $scope.moreTxt = "更多";


        //定义数据集合
        $scope.dataList = []; //列表数据
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
            username: '',
            zwmc: null,
            rzfs: null,
            userid: AuthUser.getUser().Id,
            onlyshow_dw: $stateParams.type == 1 ? 1 : 0,
            zzfbType: null,
            pyjg: null,
            beginTime: $state.params.beginTime == undefined ? '' : $state.params.beginTime,
            endTime: $state.params.endTime == undefined ? '' : $state.params.endTime,
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
            username: '',
            zwmc: null,
            rzfs: null,
            userid: AuthUser.getUser().Id,
            onlyshow_dw: $stateParams.type == 1 ? 1 : 0,
            zzfbType: null,
            pyjg: null
        };
        $scope.pageInfo = {ptotal: 0};
        //定义模态框
        editCtrl.$inject = ['$scope', '$http', '$alert', '$loading', '$partySelect'];
        editModal = $modal({
            resolve: {
                load: ['$ocLazyLoad', function ($ocLazyLoad) {
                }]
            },
            scope: $scope,
            controller: editCtrl,
            templateUrl: '../main/partyTwoExt/mzpyxx/edit.html',
            show: false,
            animation: 'am-fade-and-slide-top'
        });
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

        //查询
        $scope.search = function () {
            $scope.loadData();
        };

        //加载列表数据
        $scope.loadData = function () {
            $http
            ({
                method: 'get', url: '../../api/partyTowExt/getMzpyxxList', params: $scope.selectparams
            }).then(function (result) {
                $scope.dataList = result.data.item.list;
                $scope.pageInfo.ptotal = result.data.item.total;
            });
        };
        $scope.getPyjgList = function () {
            $http({
                method: 'get',
                url: '../../api/partyTowExt/getMzpyjgList',
                params: {}
            }).then(function (result) {
                $scope.pyjgList = result.data.item;
            }, function (resp) {

            });
        };

        $scope.edit = function (id) {
            editModal.params = {
                id: id,
                title: id ? "修改民主评议信息" : "新增民主评议信息",
                dataDzzdm: AuthUser.getUser().DataDzzdm
            };
            editModal.parentLoad = $scope.loadData;
            editModal.$promise.then(editModal.show);
        };
        $scope.delete = function (id) {
            if (confirm("是否确定删除？")) {
                $loading.show();
                $http({
                    url: "../../api/partyTowExt/deleteMzpy",
                    method: 'GET',
                    params: {id: id}
                }).then(function (result) {
                    $loading.hide();
                    $scope.showMsg("消息", result.data.msg);
                    if (result.data.success) {
                        $scope.loadData();
                    }
                }, function (res) {
                    $loading.hide();
                    $scope.showMsg("错误", res);
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
                window.open('../../api/partyTowExt/exportMzpyxx' + params);
            }
        };
        //数据初始化
        $scope.getPyjgList();

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
        $scope.reset = function () {
            $scope.selectparams.defaultselected = $scope.resetparams.defaultselected;
            $scope.selectparams.username = $scope.resetparams.username;
            $scope.selectparams.pyjg = $scope.resetparams.pyjg;
            $scope.selectparams.beginTime = $scope.resetparams.beginTime;
            $scope.selectparams.endTime = $scope.resetparams.endTime;
            $scope.loadData();
        }
    });
})(angular);
