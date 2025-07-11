(function ($app) {
    $app.module('gtPartyApp').controller('assetAllocateEditCtrl', function ($scope, $http, $modal, $ocLazyLoad, $alert, $loading, $state, $bsRouterState, AuthUser, $timeout, $partySelect) {
        $stateParams = $bsRouterState.$params($scope);

        //定义数据集合
        $scope.dataModel = {
            id: $stateParams.id == undefined ? "" : $stateParams.id
        };
        $scope.assetModel = {};

        $scope.getData = function () {
            $http.get("../../api/asset/getAllocateById", {
                params: {
                    'id': $scope.dataModel.id
                }
            }).then(function (result) {
                $scope.dataModel = result.data.item;
                $scope.dataModel.allocateuserid = AuthUser.getUser().Id;
                $scope.dataModel.allocateusername = AuthUser.getUser().Name;
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
                        url: "../../api/asset/saveAllocate",
                        data: $scope.dataModel
                    }).then(function (result) {
                        $loading.hide();
                        if (result.data.success) {
                            $scope.showMsg('成功', result.data.msg);
                            $scope.$emit("tabReloadData", {name: 'assetAllocateListCtrl', data: 1});
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
                dzzdm: AuthUser.getUser().DataDzzdm
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

        //选择调拨人
        $scope.selectAllocateuser = {
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
        $scope.$watch('selectAllocateuser.selectedValueData', function (newVal) {
            if (newVal != '' && newVal != undefined) {
                $scope.dataModel.allocateuserid = $scope.selectAllocateuser.selectedValueData;
                $scope.dataModel.allocateusername = $scope.selectAllocateuser.selectedLabeData;
            }
        });

        //选择保管人
        $scope.selectTakecareuser = {
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
                dzzdm: $scope.assetModel.takecarepartycode || (AuthUser.getUser().DataDzzdm.length <= 12 ? AuthUser.getUser().DataDzzdm : AuthUser.getUser().dwId)
            }
        };
        $scope.$watch('selectTakecareuser.selectedValueData', function (newVal) {
            if (newVal != '' && newVal != undefined) {
                $scope.dataModel.newuserid = $scope.selectTakecareuser.selectedValueData;
                $scope.dataModel.newusername = $scope.selectTakecareuser.selectedLabeData;
            }
        });

        //选择党支部
        $scope.partyConfig = {
            scope: $scope,
            selectedKey: '',
            selectedText: '',
            selectedData: [],
            isMulti: false,
            isshowxz: 1,
            dzzdm: AuthUser.getUser().DataDzzdm.length <= 12 ? AuthUser.getUser().DataDzzdm : AuthUser.getUser().dwId
        };
        $partySelect.initServer($scope.partyConfig);
        $scope.$watch("partyConfig.selectedKey", function (newVal, oldVal) {
            if (newVal) {
                $scope.dataModel.newpartycode = $scope.partyConfig.selectedKey;
                $scope.dataModel.newpartyname = $scope.partyConfig.selectedText;

                $scope.selectTakecareuser.selectParams.dzzdm = $scope.dataModel.newpartycode;
                $scope.dataModel.newuserid = "";
                $scope.dataModel.newusername = "";
            }
        }, true);
        $scope.selectTakecareParty = function () {
            $partySelect.showModal();
        };

        $scope.pagechange = function () {
            $bsRouterState.$closeTab($scope);
        };


        $scope.getData();

    });
})(angular);