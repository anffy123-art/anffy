(function ($app) {
    $app.module('gtPartyApp').controller('partyOutlayEditCtrl', function ($scope, $http, $modal, $ocLazyLoad, $alert, $loading, $state, $partySelect, $stateParams, $bsRouterState, $partySelect) {
        $stateParams = $bsRouterState.$params($scope);

        $scope.maxDate = moment(new Date()).format("YYYY-MM-DD");

        $scope.op = $stateParams.op;
        //定义数据集合
        $scope.dataModel = {
            id: $stateParams.id == undefined ? "" : $stateParams.id,
            partycode: $stateParams.dzzdm
        };

        $scope.reqFileModel = {
            selectdata: {FileRefID: '', pageindex: 1, pagesize: 10, ptotal: 0},//查询参数：FileRefID为文件关联ID
            filetype: 11,//文件类型
            items: [],//列表数据地址
            readonly: $scope.op==0,//是否只能查看
            title: '附件材料',
            addFileButton: '上传'
        };

        $scope.loadData = function () {
            $http.get("../../api/publicity/getPartyOutlayById", {
                params: {
                    'id': $scope.dataModel.id,
                    'dzzdm': $scope.dataModel.partycode
                }
            }).then(function (result) {
                $scope.dataModel = result.data.item;

                $scope.reqFileModel.selectdata.FileRefID = $scope.dataModel.partyoutlayid;
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
                    url: "../../api/publicity/savePartyOutlay",
                    data: $scope.dataModel
                }).then(function (result) {
                    $loading.hide();
                    $scope.showMsg('成功', result.data.msg);
                    //重新刷新列表
                    $scope.pagechange();

                    $scope.$emit("tabReloadData", {name: 'partyOutlayListCtrl', data: 1});

                }, function (resp) {
                    $loading.hide();
                    $scope.showMsg('错误', '服务器错误,' + resp.data.message);
                })
            }
        };
        $scope.paytypeList=[];
        $scope.getPaytypeList = function () {
            $http({
                method: 'get',
                url: '../../api/dictionary/getDictionaryListByDicTypeKey',
                params: {dicTypeKey: 'partyoutlayPaytype'}
            }).then(function (result) {
                $scope.paytypeList = result.data;
            }, function (resp) {

            });
        };
        $scope.getPaytypeName = function () {
            var items = $scope.paytypeList.filter(function (item) {
                return item.dickey == $scope.dataModel.paytype;
            })
            return items.length > 0 ? items[0].dicvalue : "";
        }
        $scope.getPaytypeList();
        //加载数据
        $scope.loadData();

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