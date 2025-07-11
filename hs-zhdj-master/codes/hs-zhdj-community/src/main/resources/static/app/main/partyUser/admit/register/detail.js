var detailCtrl = function ($scope, $http, $alert, $loading) {
    $scope.detailParams = detailModal.params;
    $scope.dataModel = {};
    $scope.imgConfig = {
        filerefid: $scope.dataModel.applyFileReId,
        filetypeid: 1,
        readonly: true,
        ismulti: true,
        height: 180,
        width: 180,
        imgList: []
    };

    $scope.getData = function () {
        $http
        ({
            method: 'get', url: "../../api/partyUserAdmit/getPartyUserByCode",
            params: {
                'userCode': $scope.detailParams.userCode
            }
        }).then(function (result) {
            $scope.dataModel = result.data.item;
            $scope.imgConfig.filerefid = $scope.dataModel.applyFileReId
        }, function (resp) {
            $scope.showMsg('错误', '服务器错误：' + resp.data);
        });
    };
    $scope.getData();
};

//定义模态框
var detailModal;