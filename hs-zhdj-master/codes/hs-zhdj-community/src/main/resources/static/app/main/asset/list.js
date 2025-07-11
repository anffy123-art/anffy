(function ($app) {
    $app.module('gtPartyApp').controller('assetListCtrl', function ($scope, $http, $modal, $ocLazyLoad, $alert, $loading, $state, $bsRouterState, AuthUser, $timeout, $excel) {
        $state.params = $bsRouterState.$params($scope);
        $scope.isShow = false;
        $scope.moreTxt = "更多";
        $scope.loginUserId = AuthUser.getUser().Id;

        //定义数据集合
        $scope.dataList = []; //列表数据
        $scope.assetStateList = [];
        //组织树参数
        $scope.treeparams = {
            isunfold: false,//组织结构树展开收缩
            selectdzzdm: "",
            selectdzzmc: "",
            defaultselected: $state.params.dzzdm
        };
        //查询条件
        $scope.selectparams = {
            pageindex: 1,
            pagesize: 10,
            dzzdm: '',
            no: '',
            name: '',
            userName: '',
            state: null
        };
        $scope.resetparams = {};
        $scope.pageInfo = {ptotal: 0};
        angular.extend($scope.resetparams, $scope.selectparams);

        //加载列表数据
        $scope.getList = function () {
            $http
            ({
                method: 'get', url: '../../api/asset/getAssetList', params: $scope.selectparams
            }).then(function (result) {
                $scope.dataList = result.data.item.list;
                $scope.pageInfo.ptotal = result.data.item.total;
            }, function (res) {
                $scope.showMsg('错误', '服务器错误');
            });
        };

        $scope.search = function () {
            $scope.getList();
        };
        $scope.reset = function () {
            $scope.selectparams = [];
            angular.extend($scope.selectparams, $scope.resetparams);
            $scope.pageInfo = {ptotal: 0};
            $scope.getList();
        };
        $scope.add = function () {
            $bsRouterState.$closeTabName("home.assetAdd");
            $timeout(function () {
                $bsRouterState.go('home.assetAdd', {
                    id: ""
                });
            }, 100);
        };
        $scope.edit = function (id) {
            $bsRouterState.$closeTabName("home.assetEdit");
            $timeout(function () {
                $bsRouterState.go('home.assetEdit', {
                    id: id
                });
            }, 100);
        };
        $scope.show = function (id) {
            $bsRouterState.$closeTabName("home.assetShow");
            $timeout(function () {
                $bsRouterState.go('home.assetShow', {assetid: id});
            }, 100);
        };
        $scope.updateUser = function (id) {
            $bsRouterState.$closeTabName("home.assetUpdateuser");
            $timeout(function () {
                $bsRouterState.go('home.assetUpdateuser', {assetid: id});
            }, 100);
        };
        $scope.delete = function (id) {
            if (confirm("是否确定删除？")) {
                $http({
                    url: "../../api/asset/deleteAsset",
                    method: 'GET',
                    params: {id: id}
                }).then(function (result) {
                    $scope.showMsg("消息", result.data.msg);
                    if (result.data.success) {
                        $scope.getList();
                    }
                });
            }
        };
        $scope.export = function () {
            var params = "?1=1";
            for (var p in $scope.selectparams) {
                if ($scope.selectparams[p] !== '' && $scope.selectparams[p] !== null)
                    params += ("&" + p + "=" + encodeURI($scope.selectparams[p]));
            }
            window.open('../../api/asset/export' + params);
        };
        $scope.import = function () {
            $scope.excelConfig = {
                filetype: 1,
                columns: {
                    '资产编号': 'no',
                    '名称': 'name',
                    '型号': 'model',
                    '数量': 'count',
                    '计量单位': 'unittype',
                    '固资原值': 'originalvalue',
                    '税额': 'tax',
                    '价税合计': 'pricetaxtotal',
                    '使用部门': 'usepartyname',
                    '购置人': 'purchaseuserid',
                    '建卡时间': 'buildtimeStr',
                    '预计使用年限': 'expectedusefullife',
                    '固资状况': 'assetcondition',
                    '保管单位': 'takecarepartyname',
                    '保管人': 'takecareusername',
                    '保管开始时间': 'startdateStr',
                    '保管结束时间': 'enddateStr',
                    '备注': 'remark',

                },
                errorcolumns: {
                    'no': '资产编号',
                    'name': '名称',
                    'model': '型号',
                    'errorInfo': '错误信息'
                },
                readonly: false,
                templateUrl: '/doc/template/党内资产明细导入模板.xls'
            };
            $excel.addFile($scope.excelConfig).then(function (items) {
                $loading.show();
                $http({
                    method: "post",
                    url: "../../api/asset/import",
                    data: {
                        dataList: JSON.stringify(items)
                    }
                }).then(function (result) {
                    $loading.hide();
                    if (result.data.success) {
                        $scope.showMsg("导入成功");
                        $scope.getList();
                    } else {
                        if (result.data.item.length > 0) {
                            $scope.showMsg('错误', '导入失败，存在错误数据，请修改后重新导入！', 20);
                            $excel.showErrorInfo(result.data.item);
                        } else {
                            $scope.showMsg(result.data.msg);
                        }
                    }

                }, function (resp) {
                    $loading.hide();
                    $scope.showMsg('错误', '服务器错误');
                })
            });
        };

        //获取字典数据
        $scope.getAssetStateList = function () {
            $http({
                method: 'get',
                url: '../../api/dictionary/getDictionaryListByDicTypeKey',
                params: {
                    dicTypeKey: 'AssetState'
                }
            }).then(function (result) {
                $scope.assetStateList = result.data;
            }, function (resp) {

            });
        };

        $scope.$watch("selectparams.pageindex", function (newVal, oldVal) {
            if ($scope.pageInfo.ptotal > 0) {
                $scope.getList();
            }
        });
        $scope.$watch("treeparams.selectdzzdm", function (newVal, oldVal) {
            if (newVal != "") {
                if ($scope.treeparams.defaultselected != "" && $scope.treeparams.defaultselected != null &&
                    $scope.treeparams.defaultselected != $scope.treeparams.selectdzzdm)
                    return;

                $scope.selectparams.dzzdm = $scope.treeparams.selectdzzdm;

                $scope.getList();
            }
        });

        $scope.$on('tabChildReloadData', function (event, data) {
            if (data.name == 'assetListCtrl') {
                $scope.getList();
            }
        });

        $scope.isShowClick = function () {
            $scope.isShow = !$scope.isShow;
            if ($scope.moreTxt == "更多") {
                $scope.moreTxt = "收起";
            } else if ($scope.moreTxt == "收起") {
                $scope.moreTxt = "更多";
            }
        };
        $scope.setisunfold = function () {
            $scope.treeparams.isunfold = !$scope.treeparams.isunfold;
            $scope.$emit('menudatas.toggle', !$scope.treeparams.isunfold);
        };

        $scope.getAssetStateList();

    });
})(angular);