(function () {
    'use strict';
    angular.module('gtPartyApp').controller("registerCtrl", function ($scope, $state, $http, $loading, $alert, $desData, $modal, $uuid) {
        $scope.dataModel = {
            applyFileReId: $uuid.getUUID()
        };
        $scope.pswModel = {
            password: '',
            confirmPassword: ''
        };
        $scope.treeConfig = {
            url: '../../api/party/getTree',
            ismulti: false,
            readonly: false
        };
        $scope.imgConfig = {
            filerefid: $scope.dataModel.applyFileReId,
            filetypeid: 1,
            readonly: false,
            ismulti: true,
            height: 180,
            width: 180,
            imgList: []
        };
        $scope.xbList = [{BM: '1', HZMC: '男'}, {BM: '2', HZMC: '女'}];
        $scope.boolList = [{dickey: true, dicvalue: '是'}, {dickey: false, dicvalue: '否'}];
        //定义模态框
        successCtrl.$inject = ['$scope', '$state', '$http', '$alert', '$loading'];
        successModal = $modal({
            resolve: {
                load: ['$ocLazyLoad', function ($ocLazyLoad) {
                }]
            },
            scope: $scope,
            controller: successCtrl,
            templateUrl: '../main/partyUser/admit/register/success.html',
            show: false,
            animation: 'am-fade-and-slide-top'
        });

        $scope.register = function (isflag) {
            if (!isflag) {
                $scope.showMsg('提示', "信息不全无法提交");
                return false;
            }
            if ($scope.imgConfig.imgList.length == 0) {
                $scope.showMsg('提示', "请上传入党申请书照片");
                return false;
            }

            var pwdDes = $desData.GetToken($scope.pswModel.password + '|' + $scope.pswModel.confirmPassword);

            if (isflag && confirm("确认提交申请？")) {
                $loading.show();
                $http({
                    method: "post",
                    url: "../../api/partyUserAdmit/register",
                    data: {
                        userData: $scope.dataModel,
                        desData: pwdDes
                    }
                }).then(function (result) {
                    $loading.hide();
                    if (result.data.success) {
                        successModal.$promise.then(successModal.show);
                    } else {
                        $scope.showMsg('失败', result.data.msg);
                    }

                }, function (resp) {
                    $scope.showMsg('错误', '服务器错误：' + resp.data);
                });
            }
        };

        $scope.back = function () {
            $state.go("localLogin");
        };

        //民族
        $scope.getMZList = function () {
            $http({
                method: 'get',
                url: '../../api/partyDic/getNationList'
            }).then(function (result) {
                $scope.mzList = result.data;
            }, function (resp) {

            });
        };
        $scope.getEducationList = function () {
            $http({
                method: 'get',
                url: '../../api/partyDic/getEducationList'
            }).then(function (result) {
                $scope.xlList = result.data;
            }, function (resp) {

            });
        };

        $scope.showMsg = function (title, content) {
            $alert({
                title: title + '：',
                content: content,
                placement: 'top',
                type: 'info',
                show: true,
                duration: 10
            });
        };

        $scope.getMZList();
        $scope.getEducationList();
    });
})(angular, this);
