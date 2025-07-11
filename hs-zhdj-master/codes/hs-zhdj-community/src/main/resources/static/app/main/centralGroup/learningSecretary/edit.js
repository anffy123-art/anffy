(function ($app) {
    $app.module('gtPartyApp').controller('learningSecretaryEditCtrl', function ($scope, $http, $modal, $ocLazyLoad, $alert, $loading, $state, $partySelect, $stateParams, AuthUser, $filter,$bsRouterState) {

        $stateParams=$bsRouterState.$params($scope);
        $scope.changevm={};
        $scope.receiveDWs=[];

        //加载数据
        $scope.loadData = function () {
            if($stateParams.id == undefined){
                $scope.changevm.id = '';
            }else{
                $scope.changevm.id = $stateParams.id;
            }
            $scope.changevm.dzzdm = $stateParams.dzzdm;
            $scope.dwName = $stateParams.dwName;
            $scope.changevm.rydm = $stateParams.rydm;
            $scope.changevm.oldrydm = $stateParams.rydm;
            $scope.rydmName =$stateParams.msName;
        };
        //保存
        //isflag：表单验证结果，shykStatus：下一环节状态
        $scope.submitData = function (isflag, shykStatus, isnotify) {
            if (isflag) {
                var mydata = {
                    xxms:$scope.changevm
                }
                $loading.show();
                $http({
                    method: "post",
                    url: "../../api/zxzxx/xxms/save ",
                    data: mydata
                }).then(function (result) {
                    $loading.hide();
                    $scope.showMsg('成功', result.data.msg);
                    $scope.pagechange();

                    $scope.$emit("tabReloadData",{name:'learningSecretaryListCtrl',data:1});
                }), function (resp) {
                    $scope.showMsg('错误', '服务器错误');
                }
            }
        };

        $scope.loadData();

        $scope.qingkongrenyuan = function(){
            $scope.changevm.rydm = '';
            $scope.rydmName = '';
        };

        //选择人员
        $scope.paramsMod = {
            'pageindex':1,
            'pagesize':10,
            dzzdm : $stateParams.dzzdm,
            //userName : userChangeModal.selectUserList.userName,
            pageInfo : {ptotal: 0}
        }
        var userChangeCtrl = function ($scope, $http) {
            $scope.params = userChangeModal.params;
            $scope.selectUserList = userChangeModal.selectUserList;
            $scope.receivePcomm = userChangeModal.receivePcomm;
        }
        userChangeCtrl.$inject = ['$scope', '$http'];
            //定义模态框
        var userChangeModal = $modal({
            resolve: {
                load: ['$ocLazyLoad', function ($ocLazyLoad) {
                }]
            },
            scope: $scope,
            controller: userChangeCtrl,
            templateUrl: '../main/centralGroup/learningSecretary/userList.html',
            show: false,
            animation: 'am-fade-and-slide-top'
        });

        $scope.xuanzeUser = function(){
            $scope.user("选择人员");
        }
        $scope.user = function (title) {
            userChangeModal.selectUserList = {
                userName:''
            };
            userChangeModal.params = {
                title: title
            };
            userChangeModal.receivePcomm = {};
            userChangeModal.$promise.then(userChangeModal.show);
            $scope.ajaxSelectUser();
        };

        $scope.ajaxSelectUser = function(){
            $http.get("../../api/zxzxx/xxms/selectUser", {
                params: $scope.paramsMod
            }).then(function (result) {
                var resultDataItemList = result.data.item.list;
                for(var i=0;i<resultDataItemList.length;i++){
                    if($scope.changevm.rydm!=undefined){
                        if($scope.changevm.rydm == resultDataItemList[i].rydm){
                            resultDataItemList[i].checked = true;
                            userChangeModal.receivePcomm = resultDataItemList[i];
                        }else{
                            resultDataItemList[i].checked = false;
                        }
                    }else{
                        resultDataItemList[i].checked = false;
                    }
                }
                $scope.receivePcommListUser = resultDataItemList;
                $scope.paramsMod.pageInfo.ptotal = result.data.item.total;
            }, function () {
                $scope.showMsg('错误', '服务器错误');
            });
        };

        //监视页数变化
        $scope.$watch("paramsMod.pageindex", function (newVal, oldVal) {
            //alert($scope.paramsMod.pageindex)
            if ($scope.paramsMod.pageInfo.ptotal > 0) {
                $scope.ajaxSelectUser();
            }
        });

        $scope.selectUserListSelect = function(){
            $scope.paramsMod.userName = userChangeModal.selectUserList.userName
            $scope.ajaxSelectUser(); 
            //console.log('111');
        }

        $scope.chkchildrenUser = function (item) {
            userChangeModal.receivePcomm = item;
            for(var i=0;i<$scope.receivePcommListUser.length;i++){
                if(userChangeModal.receivePcomm.rydm == $scope.receivePcommListUser[i].rydm){
                    $scope.receivePcommListUser[i].checked = true;
                }else{
                    $scope.receivePcommListUser[i].checked = false;
                }
            }
        };

        $scope.quedingxuyaoUser = function(){
            $scope.changevm.rydm = userChangeModal.receivePcomm.rydm;
            $scope.rydmName = userChangeModal.receivePcomm.msName;
            userChangeModal.$promise.then(userChangeModal.hide);
        }


        $scope.parentUrl = "home.learningSecretary";//父级地址
        $scope.pagechange = function () {
            if($bsRouterState.$getRouteType()=='tab'){
                $bsRouterState.$closeTab($scope);
            } else {
                $bsRouterState.go($scope.parentUrl);
            }
        };

    });
})(angular);