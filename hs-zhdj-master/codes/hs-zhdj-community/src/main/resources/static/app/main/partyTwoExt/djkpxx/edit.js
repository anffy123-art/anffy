(function ($app) {
    $app.module('gtPartyApp').controller('djkpxxeditCtrl', function ($scope, $http, $modal, $ocLazyLoad, $alert, $loading, $state, $partySelect, $stateParams, $bsRouterState, $partySelect) {
        $stateParams = $bsRouterState.$params($scope);
        $scope.type = $stateParams.type;
        $scope.isDetail =($stateParams.isDetail == "true"||$stateParams.isDetail==true);
        //定义数据集合
        $scope.dataModel = {
            id: $stateParams.id == undefined ? "" : $stateParams.id,
            dzzdm: $stateParams.dzzdm,
            dzzmc: $stateParams.dzzmc
        };
        $scope.yearList = [];
        $scope.judgeLevelList=[];

        $scope.reqFileModel = {
            selectdata: {FileRefID: '', pageindex: 1, pagesize: 10, ptotal: 0},//查询参数：FileRefID为文件关联ID
            filetype: 3,//文件类型
            items: [],//列表数据地址
            readonly:    !$scope.isDetail,//是否只能查看
            title: '附件（考评附件等）',
            addFileButton: '上传'
        };
        //选择党支部
        $scope.partyTreeConfig = {
            scope: $scope,
            selectedKey: '',
            selectedText: '',
            selectedData: [],
            isMulti: false,
            isshowxz: 0
        };
        $partySelect.initServer($scope.partyTreeConfig);
        $scope.selectParty = function () {
            $partySelect.showModal();
        };
        $scope.$watch("partyTreeConfig.selectedKey", function (newVal, oldVal) {
            if (newVal) {
                $scope.dataModel.dzzdm = $scope.partyTreeConfig.selectedKey;
                $scope.dataModel.dzzmc = $scope.partyTreeConfig.selectedText;
            }
        }, true);


        $scope.loadData = function () {
            $http.get("../../api/partyTowExt/getDjkpxx", {
                params: {
                    'id': $scope.dataModel.id,
                    'dzzdm': $scope.dataModel.dzzdm,
                    'dzzmc': $stateParams.dzzmc
                }
            }).then(function (result) {
                $scope.dataModel = result.data.item;
                $scope.reqFileModel.selectdata.FileRefID=$scope.dataModel.id;
            }, function () {
                $scope.showMsg('错误', '服务器错误');
            });
        };
        //保存
        $scope.submitData = function (isflag) {
            if (isflag) {
                $loading.show();
                $http({
                    method: "post",
                    url: "../../api/partyTowExt/saveDjkpxx",
                    data: $scope.dataModel
                }).then(function (result) {
                    $loading.hide();
                    $scope.showMsg('提示', result.data.msg);

                    if(result.data.success) {
                        $scope.$emit("tabReloadData", {name: 'djkpxxCtrl', data: 1});
                        //重新刷新列表
                        $scope.pagechange();
                        $scope.$hide();
                    }
                }, function (resp) {
                    $scope.showMsg('错误', '服务器错误');
                })
            }
        };


        $scope.getYearList = function () {
            $http({
                method: 'get',
                url: '../../api/dictionary/getDictionaryListByDicTypeKey',
                params: {
                    dicTypeKey: 'years'
                }
            }).then(function (result) {
                $scope.yearList = result.data;
            }, function (resp) {

            });
        };
        $scope.getJudgeLevelList = function () {
            $http({
                method: 'get',
                url: '../../api/dictionary/getDictionaryListByDicTypeKey',
                params: {
                    dicTypeKey: 'judgeLevel'
                }
            }).then(function (result) {
                $scope.judgeLevelList = result.data.filter(function (item) {
                    return item.dicnote==$scope.type.toString();
                });
            }, function (resp) {

            });
        };
        $scope.getJudgeLevelName = function () {
            var items = $scope.judgeLevelList.filter(function (item) {
                return item.dickey == $scope.dataModel.judgelevel;
            })
            return items.length > 0 ? items[0].dicvalue : "";
        }
        //加载数据
        $scope.loadData();
        $scope.getYearList();
        $scope.getJudgeLevelList();

        $scope.pagechange = function () {
            var inTab = $bsRouterState.$getRouteType() == 'tab';
            if (inTab) {
                $bsRouterState.$closeTab($scope);
            } else {
                window.history.back();
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

    });
})(angular);