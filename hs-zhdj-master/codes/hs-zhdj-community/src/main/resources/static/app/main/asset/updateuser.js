(function ($app) {
    $app.module('gtPartyApp').controller('assetUpdateuserCtrl', function ($scope, $http, $modal, $ocLazyLoad, $alert, $loading, $state, $bsRouterState, AuthUser, $timeout, $partySelect) {
        $stateParams = $bsRouterState.$params($scope);

        //定义数据集合
        $scope.dataModel = {
            assetid: $stateParams.assetid == undefined ? "" : $stateParams.assetid
        };
        $scope.assetModel = {};

        $scope.getData = function () {
            $http.get("../../api/asset/getTakeCareUserById", {
                params: {
                    'id': $scope.dataModel.id,
                    'assetId': $scope.dataModel.assetid
                }
            }).then(function (result) {
                $scope.dataModel = result.data.item;
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
                        url: "../../api/asset/updateTakeCareUser",
                        data: $scope.dataModel
                    }).then(function (result) {
                        $loading.hide();
                        if (result.data.success) {
                            $scope.showMsg('成功', result.data.msg);
                            $scope.$emit("tabReloadData", {name: 'assetListCtrl', data: 1});
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
                dzzdm: $scope.assetModel.takecarepartycode || AuthUser.getUser().DataDzzdm
            }
        };
        $scope.$watch('selectTakecareuser.selectedValueData', function (newVal) {
            if (newVal != '' && newVal != undefined) {
                $scope.dataModel.newuserid = $scope.selectTakecareuser.selectedValueData;
                $scope.dataModel.newusername = $scope.selectTakecareuser.selectedLabeData;
            }
        });

        $scope.loadAsset = function () {
            $scope.$broadcast("toParams", {id: $scope.dataModel.assetid || '', op: 1});
        };

        $scope.$on("toParentParams", function (event, tar) {
            $scope.assetModel = tar.assetModel;
            $scope.selectTakecareuser.selectParams.dzzdm = $scope.assetModel.takecarepartycode;
        });

        $scope.pagechange = function () {
            $bsRouterState.$closeTab($scope);
        };
    });
})(angular);