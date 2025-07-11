(function ($app) {
    $app.module('gtPartyApp').controller('learningPlanEditCtrl', function ($scope, $http, $modal, $ocLazyLoad, $alert, $loading, $state, $partySelect, $stateParams, AuthUser, $filter,$bsRouterState) {

        $stateParams=$bsRouterState.$params($scope);

        $scope.changevm={};
        $scope.receiveDWs=[];

        //加载数据
        $scope.loadData = function () {
            if($stateParams.id==undefined||stateParams.id==''){
                $http.get("../../api/zxzxx/xxjh/get/bureau", {
                    params: {}
                }).then(function (result) {
                    $scope.changevm.sendDepartmentId = result.data.item.dzzdm;
                    $scope.changevm.sendDepartmentName = result.data.item.dzzmc;
                }, function () {
                    $scope.showMsg('错误', '服务器错误');
                });
                $http.get("../../api/dictionary/GetDictionaryList", {
                    params: {
                        'dicTypeKey': 'zxzxxjhlx'
                    }
                }).then(function (result) {
                    $scope.roleConfigList = result.data.item.list;
                    $scope.changevmTypeCode = $scope.roleConfigList[0];
                }, function () {
                    $scope.showMsg('错误', '服务器错误');
                });
            }else{
                $http.get("../../api/zxzxx/xxjh/get", {
                    params: {
                        'id': $stateParams.id
                    }
                }).then(function (result) {
                    $scope.changevm = result.data.item;
                    $http.get("../../api/dictionary/GetDictionaryList", {
                        params: {
                            'dicTypeKey': 'zxzxxjhlx'
                        }
                    }).then(function (result) {
                        $scope.roleConfigList = result.data.item.list;
                        $scope.changevmTypeCode = $scope.roleConfigList[$scope.changevm.typeCode-1];
                    }, function () {
                        $scope.showMsg('错误', '服务器错误');
                    });
                }, function () {
                    $scope.showMsg('错误', '服务器错误');
                });
                $http.get("../../api/zxzxx/xxjh/list/receive/dw", {
                    params: {
                        'id': $stateParams.id
                    }
                }).then(function (result) {
                    $scope.receiveDWs = result.data.item;
                }, function () {
                    $scope.showMsg('错误', '服务器错误');
                });
            }
        };
        //保存
        //isflag：表单验证结果，shykStatus：下一环节状态
        $scope.submitData = function (isflag, shykStatus, isnotify) {
            if (isflag) {
                $scope.changevm.typeCode = $scope.changevmTypeCode.val;
                var receiveDWs = [];
                for(var i=0;i<$scope.receiveDWs.length;i++){
                    receiveDWs.push({});
                    receiveDWs[i].dwId = $scope.receiveDWs[i].dwId;
                    receiveDWs[i].receiveUserId = $scope.receiveDWs[i].secretaryIds;
                }
                var mydata = {
                    xxjh: $scope.changevm,
                    receiveDWs: receiveDWs
                }
                $loading.show();
                $http({
                    method: "post",
                    url: "../../api/zxzxx/xxjh/edit",
                    data: mydata
                }).then(function (result) {
                    $loading.hide();
                    $scope.showMsg('成功', result.data.msg);
                    $scope.pagechange();

                    $scope.$emit("tabReloadData",{name:'LearningSituationListCtrl',data:1});
                }), function (resp) {
                    $scope.showMsg('错误', '服务器错误');
                }
            }
        };

        $scope.loadData();

        var editUserChangeCtrl = function ($scope, $http) {
            $scope.params = userChangeModal.params;
            $scope.receivePcomm = userChangeModal.receivePcomm;
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
            templateUrl: '../main/centralGroup/learningPlan/partyCommittee.html',
            show: false,
            animation: 'am-fade-and-slide-top'
        });

        $scope.selectPartyCommittee = function(){
            $scope.edit("选择党委");
        }

        $scope.selectPartyCommitteeFull = function(){
            $http.get("../../api/zxzxx/xxjh/list/choose/dw", {
                params: {
                    
                }
            }).then(function (result) {
                $scope.receiveDWs = result.data.item.list;                
            }, function () {
                $scope.showMsg('错误', '服务器错误');
            });
        }

        $scope.edit = function (title) {
            userChangeModal.params = {
                title: title
            };
            userChangeModal.receivePcomm = [];
            $loading.show();
            $http.get("../../api/zxzxx/xxjh/list/choose/dw", {
                params: {
                    
                }
            }).then(function (result) {
                $loading.hide();
                var resultDataItemList = result.data.item.list;
                var resultDataItemListArr = [];
                var receiveDWs = $scope.receiveDWs;
                var receiveDWsId = [];
                for(var i=0;i<receiveDWs.length;i++){
                    receiveDWsId.push(receiveDWs[i].dwId);
                }
                receiveDWsId = receiveDWsId.join(",");
                for(var i=0;i<resultDataItemList.length;i++){
                    if(receiveDWsId.indexOf(resultDataItemList[i].dwId)<0){
                        resultDataItemListArr.push(resultDataItemList[i]);
                    }else{
                        userChangeModal.receivePcomm.push(resultDataItemList[i])
                    }
                }
                $scope.receivePcommList = resultDataItemListArr;
                userChangeModal.$promise.then(userChangeModal.show);
            }, function () {
                $scope.showMsg('错误', '服务器错误');
            });
        };

        $scope.chkchildren = function (item) {
            userChangeModal.receivePcomm.push(item);
        };

        $scope.quedingxuyao = function(){
            $scope.receiveDWs = userChangeModal.receivePcomm;
            userChangeModal.$promise.then(userChangeModal.hide);
        }

        $scope.quxiaoguanbi = function(){
            userChangeModal.$promise.then(userChangeModal.hide);
        };

        $scope.deleteReceiveDWs = function(i){
            $scope.receiveDWs.splice(i,1);
        };


        $scope.parentUrl = "home.learningPlan";//父级地址
        $scope.pagechange = function () {
            if($bsRouterState.$getRouteType()=='tab'){
                $bsRouterState.$closeTab($scope);
            } else {
                $bsRouterState.go($scope.parentUrl);
            }
        };

    });
})(angular);