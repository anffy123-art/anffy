var partyAdmitUser_detailCtrl = function ($scope, $http, $alert, $loading) {
    $scope.detailParams = partyAdmitUser_detailModal.params;
    $scope.dataModel = {};

    $scope.getData = function () {
        $http
        ({
            method: 'get', url: "../../api/partyUserAdmit/getPartyUserByCode",
            params: {
                'userCode': $scope.detailParams.userCode
            }
        }).then(function (result) {
            $scope.dataModel = result.data.item;
        }, function (resp) {
            $scope.showMsg('错误', '服务器错误：' + resp.data);
        });
    };
    $scope.getData();
};

//定义模态框
var partyAdmitUser_detailModal;