(function ($app) {
    $app.module('gtPartyApp').controller('djResultmgEditCtrl', function ($scope, $http, $modal, $ocLazyLoad, $alert, $loading, $stateParams,$bsRouterState,AuthUser,$partySelect) {
        $stateParams = $bsRouterState.$params($scope);

        $scope.maxDate = moment(new Date()).format("YYYY-MM-DD");

        //定义数据集合
        $scope.dataModel = {
            djResultmgid: $stateParams.id == undefined ? "" : $stateParams.id,

        };

        $scope.st=$stateParams.st;

        $scope.reqFileModel = {
            selectdata: {FileRefID: '', pageindex: 1, pagesize: 10, ptotal: 0},//查询参数：FileRefID为文件关联ID
            filetype: 2,//文件类型
            items: [],//列表数据地址
            readonly: $scope.st!=1,//是否只能查看
            title: '附件（成果照片、内容等）',
            addFileButton: '上传'
        };

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

            $http.get("../../api/partyTowExt/getResultmgData", {
                params: {
                    'id': $scope.dataModel.djResultmgid||'',
                    'pcode':$stateParams.pc
                }
            }).then(function (result) {
                $scope.dataModel = result.data.item;
                $scope.reqFileModel.selectdata.FileRefID=result.data.item.djResultmgid;
            }, function () {
                $scope.showMsg('错误', '服务器错误');
            });
        };
        //保存
        $scope.submitData = function (isflag) {
            if (isflag) {
                $loading.show();

                $scope.dataModel.updateuserid=AuthUser.getUser().Id;
                $scope.dataModel.updateusername=AuthUser.getUser().Name;

                $http({
                    method: "post",
                    url: "../../api/partyTowExt/ResultmgSave",
                    data: $scope.dataModel
                }).then(function (result) {
                    $loading.hide();
                    $scope.showMsg('成功', result.data.msg);
                    $scope.$emit("tabReloadData",{name:'ResultmgListCtrl',data:1});
                    //重新刷新列表
                    $scope.pagechange();
                    $scope.$hide();

                }, function (resp) {
                    $scope.showMsg('错误', '服务器错误');
                })
            }
        };



        //选择党支部
        /*
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
        };*/


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
