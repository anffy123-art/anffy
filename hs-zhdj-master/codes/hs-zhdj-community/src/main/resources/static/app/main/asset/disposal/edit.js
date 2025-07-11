(function ($app) {
    $app.module('gtPartyApp').controller('assetDisposalEditCtrl', function ($scope, $http, $modal, $ocLazyLoad, $alert, $loading, $state, $bsRouterState, AuthUser, $timeout, $partySelect) {
        $stateParams = $bsRouterState.$params($scope);

        //定义数据集合
        $scope.dataModel = {
            id: $stateParams.id == undefined ? "" : $stateParams.id
        };
        $scope.assetModel = {};
        $scope.disposalTypeList = [];
        $scope.isAdd = !$stateParams.id;

        $scope.getData = function () {
            $http.get("../../api/asset/getDisposalById", {
                params: {
                    'id': $scope.dataModel.id
                }
            }).then(function (result) {
                $scope.dataModel = result.data.item;
                if (!$scope.dataModel.userid) {
                    $scope.dataModel.userid = AuthUser.getUser().Id;
                    $scope.dataModel.username = AuthUser.getUser().Name;
                }

                $scope.selectAsset.selectedValueData = $scope.dataModel.assetid;

            }, function () {
                $scope.showMsg('错误', '服务器错误');
            });
        };

        $scope.submitData = function (isflag) {
            if (!isflag) {
                $scope.showMsg('提示', '请填写相关信息');
                return false;
            }
            if (isflag) {
                if (confirm("确认提交？")) {
                    $loading.show();
                    $http({
                        method: "post",
                        url: "../../api/asset/saveDisposal",
                        data: $scope.dataModel
                    }).then(function (result) {
                        $loading.hide();
                        if (result.data.success) {
                            $scope.showMsg('成功', result.data.msg);
                            $scope.$emit("tabReloadData", {name: 'assetDisposalListCtrl', data: 1});
                            $scope.pagechange();
                        } else {
                            $scope.showMsg('失败', result.data.msg);
                        }

                    }, function (resp) {
                        $loading.hide();
                        $scope.showMsg('错误', '服务器错误');
                    })
                }
            }
        };

        //选择资产
        $scope.selectAsset = {
            url: '../../api/asset/getAssetList',
            title: '选择资产',
            isMulti: false,
            selectData: {name: '名称'},
            columns: {NO: '资产编号', NAME: '资产名称', "MODEL": "型号"},
            selectLabelKey: 'NAME',
            selectValuekey: 'ASSETID',
            selectedValueData: '',
            selectedLabeData: '',
            selectedJData: [],
            selectParams: {
                dzzdm: AuthUser.getUser().DataDzzdm,
                state: 1
            }
        };
        $scope.$watch('selectAsset.selectedValueData', function (newVal) {
            if (newVal != '' && newVal != undefined) {
                $http.get("../../api/asset/getAssetById", {
                    params: {
                        'id': newVal
                    }
                }).then(function (result) {
                    $scope.assetModel = result.data.item
                    $scope.dataModel.assetid = $scope.assetModel.assetid;
                }, function () {
                    $scope.showMsg('错误', '服务器错误');
                });
            }
        });

        //选择维修申请人
        $scope.selectUser = {
            url: '../../api/partyUser/getPartyUserList',
            title: '人员选择',
            isMulti: false,
            selectData: {xm: '姓名', szdzb: '所在组织架构'},
            columns: {XM: '姓名', XBMC: '性别', JG: '籍贯', DZZMC: '所在组织架构'},
            selectLabelKey: 'XM',
            selectValuekey: 'RYBM',
            selectedValueData: '',
            selectedLabeData: '',
            selectedJData: [],
            selectParams: {
                dzzdm: AuthUser.getUser().DataDzzdm
            }
        };
        $scope.$watch('selectUser.selectedValueData', function (newVal) {
            if (newVal != '' && newVal != undefined) {
                $scope.dataModel.userid = $scope.selectUser.selectedValueData;
                $scope.dataModel.username = $scope.selectUser.selectedLabeData;
            }
        });

        $scope.getDisposalTypeList = function () {
            $http({
                method: 'get',
                url: '../../api/dictionary/getDictionaryListByDicTypeKey',
                params: {
                    dicTypeKey: 'DisposalType'
                }
            }).then(function (result) {
                $scope.disposalTypeList = result.data;
            }, function (resp) {

            });
        };

        $scope.pagechange = function () {
            $bsRouterState.$closeTab($scope);
        };


        $scope.getData();
        $scope.getDisposalTypeList();

    });
})(angular);