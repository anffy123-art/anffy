(function ($app) {
    $app.module('gtPartyApp').controller('zzsreditCtrl', function ($scope, $http, $modal, $ocLazyLoad, $alert, $loading, $state, $partySelect, $stateParams, $bsRouterState, $partySelect) {
        $stateParams = $bsRouterState.$params($scope);

        $scope.maxDate = moment(new Date()).format("YYYY-MM-DD");

        $scope.isDetail =($stateParams.isDetail == "true"||$stateParams.isDetail==true);
        //定义数据集合
        $scope.dataModel = {
            id: $stateParams.id == undefined ? "" : $stateParams.id,
            dzzdm: $stateParams.dzzdm,
            dzzmc: $stateParams.dzzmc
        };
        $scope.positionLevelList = [];

        //图片部分begin

        $scope.showFileId = "";
        $scope.img = {rotate: 0};

        $scope.img_ReqFileModel = {
            selectdata: {FileRefID: '', pageindex: 1, pagesize: 1000, ptotal: 0},
            filetype: 2,
            items: [],
            readonly: $scope.isDetail,
            typeparams: {
                types: ['jpg', 'bmp', 'png', 'gif', 'jpe', 'jpeg'],
                errormsg: '图片格式必须为*.jpg,*.gif,*.png,*.bmp,*.jpe,*.jpeg等格式'
            },
            templateUrl:'common/imgTemplate.html',
            img:{
                rotate: 0,
                showFileId:''
            },
            downFun:function (id) {
                this.img.showFileId=id;
            }
        };

        //图片附件 end


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
            $http.get("../../api/partyTowExt/getZzsr", {
                params: {
                    'id': $scope.dataModel.id,
                    'dzzdm': $scope.dataModel.dzzdm,
                    'dzzmc': $stateParams.dzzmc
                }
            }).then(function (result) {
                $scope.dataModel = result.data.item;
                $scope.img_ReqFileModel.selectdata.FileRefID=$scope.dataModel.id;
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
                    url: "../../api/partyTowExt/saveZzsr",
                    data: $scope.dataModel
                }).then(function (result) {
                    $loading.hide();
                    $scope.showMsg('提示', result.data.msg);
                    $scope.$emit("tabReloadData",{name:'zzsrCtrl',data:1});
                    //重新刷新列表
                    $scope.pagechange();
                    $scope.$hide();

                }, function (resp) {
                    $scope.showMsg('错误', '服务器错误');
                })
            }
        };


        $scope.getPositionLevelList = function () {
            $http({
                method: 'get',
                url: '../../api/dictionary/getDictionaryListByDicTypeKey',
                params: {
                    dicTypeKey: 'ZzsrType'
                }
            }).then(function (result) {
                $scope.positionLevelList = result.data;
            }, function (resp) {

            });
        };
        $scope.getPositionLevelName = function () {
            var items = $scope.positionLevelList.filter(function (item) {
                return item.dickey == $scope.dataModel.subjecttype;
            })
            return items.length > 0 ? items[0].dicvalue : "";
        }
        //加载数据
        $scope.loadData();
        $scope.getPositionLevelList();

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
