var archiveEditCtrl = function ($scope, $http, $alert, $loading, $partySelect) {
    $scope.parentLoad = archiveEditModal.parentLoad;
    $scope.exportParams = archiveEditModal.params;
    $scope.ids = $scope.exportParams.ids;
    $scope.archiveDate = null;

    $scope.save = function (isflag) {
        if (isflag && confirm("归档后人员将进入档案库，请确认！")) {
            $loading.show();
            $http({
                method: "post",
                url: "../../api/partyUserAdmit/archive",
                data: {
                    userCodes: JSON.stringify($scope.ids),
                    archiveDate: $scope.archiveDate
                }
            }).then(function (result) {
                $loading.hide();
                if (result.data.success) {
                    $scope.showMsg('成功', "操作成功");
                    //重新刷新列表
                    $scope.parentLoad();
                    $scope.$hide();
                }
                else {
                    $scope.showMsg('失败', result.data.msg);
                }
            }, function (resp) {
                $loading.hide();
                $scope.showMsg('错误', '服务器错误：' + resp.data);
            });
        }
    };

};

//定义模态框
var archiveEditModal;