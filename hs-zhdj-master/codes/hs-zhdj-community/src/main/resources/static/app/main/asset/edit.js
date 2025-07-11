(function ($app) {
    $app.module('gtPartyApp').controller('assetEditCtrl', function ($scope, $http, $modal, $ocLazyLoad, $alert, $loading, $state, $bsRouterState, AuthUser, $timeout, $partySelect) {
        $stateParams = $bsRouterState.$params($scope);
        $scope.maxDate = moment(new Date()).format("YYYY-MM-DD");

        //定义数据集合
        $scope.dataModel = {
            id: $stateParams.id == undefined ? "" : $stateParams.id
        };

        $scope.getData = function () {
            $http.get("../../api/asset/getAssetById", {
                params: {
                    'id': $scope.dataModel.id
                }
            }).then(function (result) {
                $scope.dataModel = result.data.item;
                $scope.selectTakecareuser.selectParams.dzzdm = $scope.dataModel.takecarepartycode;
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
                        url: "../../api/asset/saveAsset",
                        data: $scope.dataModel
                    }).then(function (result) {
                        $loading.hide();
                        if (result.data.success) {
                            $scope.showMsg('成功', result.data.msg);
                            $scope.$emit("tabReloadData", {name: 'assetListCtrl', data: 1});
                            $scope.pagechange();
                        }
                        else{
                            $scope.showMsg('失败', result.data.msg);
                        }

                    }, function (resp) {
                        $loading.hide();
                        $scope.showMsg('错误', '服务器错误');
                    })
                }
            }
        };

        //选择人员
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
                dzzdm: $scope.dataModel.takecarepartycode || AuthUser.getUser().DataDzzdm
            }
        };
        $scope.$watch('selectTakecareuser.selectedValueData', function (newVal) {
            if (newVal != '' && newVal != undefined) {
                $scope.dataModel.takecareuserid = $scope.selectTakecareuser.selectedValueData;
                $scope.dataModel.takecareusername = $scope.selectTakecareuser.selectedLabeData;
            }
        });

        //选择党支部
        $scope.partyConfig = {
            scope: $scope,
            selectedKey: '',
            selectedText: '',
            selectedData: [],
            isMulti: false,
            isshowxz: 1
        };
        $partySelect.initServer($scope.partyConfig);

        $scope.$watch("partyConfig.selectedKey", function (newVal, oldVal) {
            if (newVal) {
                if ($scope.partyType == 1) {
                    $scope.dataModel.usepartycode = $scope.partyConfig.selectedKey;
                    $scope.dataModel.usepartyname = $scope.partyConfig.selectedText;
                } else {
                    $scope.dataModel.takecarepartycode = $scope.partyConfig.selectedKey;
                    $scope.dataModel.takecarepartyname = $scope.partyConfig.selectedText;

                    $scope.selectTakecareuser.selectParams.dzzdm = $scope.dataModel.takecarepartycode;
                    $scope.dataModel.takecareuserid = "";
                    $scope.dataModel.takecareusername = "";
                }

                $scope.partyConfig.selectedText = "";
                $scope.partyConfig.selectedKey = "";
            }
        }, true);

        $scope.selectUseParty = function () {
            $scope.partyType = 1;
            $partySelect.showModal();
        };
        $scope.selectTakecareParty = function () {
            $scope.partyType = 2;
            $partySelect.showModal();
        };
        //end

        //加载数据
        $scope.getData();

        $scope.pagechange = function () {
            $bsRouterState.$closeTab($scope);
        };
    });
})(angular);