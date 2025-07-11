var editCtrl = function ($scope, $http, $alert, $loading) {
    $scope.parentLoad = editModal.parentLoad;
    $scope.editParams = editModal.params;
    $scope.dataModel = {id: $scope.editParams.id};
    $scope.selectUserlist = {
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
            ryzt: '2,3',
            dataDzzdm: $scope.editParams.dataDzzdm
        },
        onSelect: function (val, item) {
            if (item) {
                $scope.dataModel.rybm = item.RYBM;
                $scope.dataModel.userName = item.XM;
                $scope.dataModel.partyName = item.DZZMC;
                $scope.dataModel.szdzbdm = item.SZDZBDM;
            }
        }
    };

    $scope.save = function (isflag) {
        if (isflag) {
            $loading.show();
            $http({
                method: "post",
                url: "../../api/partyTowExt/saveMzpy",
                data: $scope.dataModel
            }).then(function (result) {
                $loading.hide();
                if (result.data.success) {
                    $scope.showMsg('成功', "操作成功");
                    //重新刷新列表
                    $scope.parentLoad();
                    $scope.$hide();
                } else {
                    $scope.showMsg('失败', result.data.msg);
                }
            }, function (resp) {
                $loading.hide();
                $scope.showMsg('错误', '服务器错误：' + resp.data);
            });
        }
    };
    $scope.getData = function () {
        $http
        ({
            method: 'get', url: "../../api/partyTowExt/getMzpyById",
            params: {
                'id': $scope.dataModel.id
            }
        }).then(function (result) {
            $scope.dataModel = result.data.item;
        }, function (resp) {
            $scope.showMsg('错误', '服务器错误：' + resp.data);
        });
    };

    $scope.getData($scope.editParams.userCode);

};

//定义模态框
var editModal;