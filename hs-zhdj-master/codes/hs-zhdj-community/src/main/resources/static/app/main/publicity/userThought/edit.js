(function ($app) {
    $app.module('gtPartyApp').controller('userThoughtEditCtrl', function ($scope, $http, $modal, $ocLazyLoad, $alert, $loading, $state, $partySelect, $stateParams, $bsRouterState) {
        $stateParams = $bsRouterState.$params($scope);

        $scope.maxDate = moment(new Date()).format("YYYY-MM-DD");

        $scope.op = $stateParams.op;
        //定义数据集合
        $scope.dataModel = {
            id: $stateParams.id == undefined ? "" : $stateParams.id,
            partycode: $stateParams.dzzdm
        };
        $scope.thoughtTypeList = [];
        $scope.questionTypeList = [];
        $scope.handleTypeList = [];
        $scope.destroyTypeList = [];
        $scope.handleLevelList = [];

        //选择党支部begin
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
                $scope.dataModel.partycode = $scope.partyTreeConfig.selectedKey;
                $scope.dataModel.partyname = $scope.partyTreeConfig.selectedText;
            }
        }, true);
        //end

        $scope.loadData = function () {
            $http.get("../../api/publicity/getUserthoughtById", {
                params: {
                    'id': $scope.dataModel.id,
                    'dzzdm': $scope.dataModel.partycode
                }
            }).then(function (result) {
                $scope.dataModel = result.data.item;
            }, function () {
                $scope.showMsg('错误', '服务器错误');
            });
        };
        //保存
        $scope.submitData = function (isflag) {
            if (!isflag) {
                $scope.showMsg('提示', '请填写相关信息');
                return false;
            }

            if (isflag) {
                $loading.show();
                $http({
                    method: "post",
                    url: "../../api/publicity/saveUserthought",
                    data: $scope.dataModel
                }).then(function (result) {
                    $loading.hide();
                    $scope.showMsg('成功', result.data.msg);
                    //重新刷新列表
                    $scope.pagechange();

                    $scope.$emit("tabReloadData",{name:'userThoughtListCtrl',data:1});

                }, function (resp) {
                    $loading.hide();
                    $scope.showMsg('错误', '服务器错误,' + resp.data.message);
                })
            }
        };

        $scope.getThoughtTypeList = function () {
            $http({
                method: 'get',
                url: '../../api/dictionary/getDictionaryListByDicTypeKey',
                params: {
                    dicTypeKey: 'thoughtType'
                }
            }).then(function (result) {
                $scope.thoughtTypeList = result.data;
            }, function (resp) {

            });
        };
        $scope.getQuestionTypeList = function () {
            $http({
                method: 'get',
                url: '../../api/dictionary/getDictionaryListByDicTypeKey',
                params: {
                    dicTypeKey: 'questionType'
                }
            }).then(function (result) {
                $scope.questionTypeList = result.data;
            }, function (resp) {

            });
        };
        $scope.getHandleTypeList = function () {
            $http({
                method: 'get',
                url: '../../api/dictionary/getDictionaryListByDicTypeKey',
                params: {
                    dicTypeKey: 'handleType'
                }
            }).then(function (result) {
                $scope.handleTypeList = result.data;
            }, function (resp) {

            });
        }
        $scope.getDestroyTypeList = function () {
            $http({
                method: 'get',
                url: '../../api/dictionary/getDictionaryListByDicTypeKey',
                params: {
                    dicTypeKey: 'destroyType'
                }
            }).then(function (result) {
                $scope.destroyTypeList = result.data;
            }, function (resp) {

            });
        };
        $scope.getHandleLevelList = function () {
            $http({
                method: 'get',
                url: '../../api/dictionary/getDictionaryListByDicTypeKey',
                params: {
                    dicTypeKey: 'handleLevel'
                }
            }).then(function (result) {
                $scope.handleLevelList = result.data;
            }, function (resp) {

            });
        };

        //加载数据
        $scope.loadData();
        $scope.getThoughtTypeList();
        $scope.getQuestionTypeList();
        $scope.getHandleTypeList();
        $scope.getDestroyTypeList();
        $scope.getHandleLevelList();;

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