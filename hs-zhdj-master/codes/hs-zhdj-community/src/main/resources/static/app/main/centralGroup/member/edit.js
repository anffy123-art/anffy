(function ($app) {
    $app.module('gtPartyApp').controller('memberEditCtrl', function ($scope, $http, $modal, $ocLazyLoad, $alert, $loading, $state, $partySelect, $stateParams, AuthUser, $filter,$stateParams) {

        $stateParams=$bsRouterState.$params($scope);

        $scope.changevm={};
        $scope.xm = '';
        $scope.receiveDWs=[];
        //加载数据
        $scope.loadData = function () {
            $scope.changevm.dwId = $stateParams.dzzdm;
            $scope.changevm.dwName = $stateParams.dzzmc;
        };
        //保存
        //isflag：表单验证结果，shykStatus：下一环节状态
        $scope.submitData = function (isflag, shykStatus, isnotify) {
            console.log($scope.changevm.servingDate)
            if ($scope.changevm.servingDate == "" || $scope.changevm.servingDate == null) {
                $scope.showMsg('错误', '请填写任职时间');
                return false;
            }
            if (isflag) {
                var mydata = {
                    zcy:{
                        userId: $scope.changevm.userId,
                        dwId: $scope.changevm.dwId,
                        servingDate: $scope.changevm.servingDate
                    }
                }
                $loading.show();
                $http({
                    method: "post",
                    url: "../../api/zxzxx/zxz/edit",
                    data: mydata
                }).then(function (result) {
                    $loading.hide();
                    $scope.showMsg('成功', result.data.msg);
                    $scope.pagechange();

                    $scope.$emit("tabReloadData",{name:'memberListCtrl',data:1});
                }), function (resp) {
                    $scope.showMsg('错误', '服务器错误');
                }
            }
        };

        $scope.loadData();

        var editUserChangeCtrl = function ($scope, $http) {
            $scope.params = userChangeModal.params;
            $scope.receivePcomm = userChangeModal.receivePcomm;
            $scope.xm = userChangeModal.xm;
        }
        editUserChangeCtrl.$inject = ['$scope', '$http'];
            //定义模态框
        var userChangeModal = $modal({
            resolve: {
                load: ['$ocLazyLoad', function ($ocLazyLoad) {
                }]
            },
            scope: $scope,
            controller: editUserChangeCtrl,
            templateUrl: '../main/centralGroup/member/userList.html',
            show: false,
            animation: 'am-fade-and-slide-top'
        });

        $scope.selectUser = function(){
            $scope.edit("选择人员");
        }

        $scope.edit = function (title) {
            userChangeModal.params = {
                title: title
            };
            userChangeModal.receivePcomm = {};
            userChangeModal.xm = '';
            //$scope.SelectUserList();
        };

        $scope.SelectUserList = function (){
            $loading.show();
            $http.get("../../api/partyUser/getPartyUserList", {
                params: {
                    pageindex:1,
                    pagesize:1000,
                    dzzdm:$scope.changevm.dwId,
                    xm:$scope.xm,
                }
            }).then(function (result) {
                $loading.hide();
                var resultDataItemList = result.data.item.list;
                //console.log($scope.changevm.userId)
                for(var i=0;i<resultDataItemList.length;i++){
                    if($scope.changevm.userId!=undefined){
                        if($scope.changevm.userId == resultDataItemList[i].RYBM){
                            resultDataItemList[i].checked = true;
                            userChangeModal.receivePcomm = resultDataItemList[i];
                        }else{
                            resultDataItemList[i].checked = false;
                        }
                    }else{
                        resultDataItemList[i].checked = false;
                    }
                }
                $scope.receivePcommList = resultDataItemList;
                userChangeModal.$promise.then(userChangeModal.show);
            }, function () {
                $scope.showMsg('错误', '服务器错误');
            });
        }

        $scope.selectUserListSelect = function(){
            $scope.xm = userChangeModal.xm;
            $scope.SelectUserList();
        };

        $scope.chkchildren = function (item) {
            userChangeModal.receivePcomm = item;
        };

        $scope.quedingxuyao = function(){
            $scope.changevm.userId = userChangeModal.receivePcomm.RYBM;
            $scope.changevm.userName = userChangeModal.receivePcomm.XM;
            userChangeModal.$promise.then(userChangeModal.hide);
        }

        $scope.quxiaoguanbi = function(){
            userChangeModal.$promise.then(userChangeModal.hide);
        };

        $scope.parentUrl = "home.member";//父级地址
        $scope.pagechange = function () {
            if($bsRouterState.$getRouteType()=='tab'){
                $bsRouterState.$closeTab($scope);
            } else {
                $bsRouterState.go($scope.parentUrl);
            }
        };

    });
})(angular);