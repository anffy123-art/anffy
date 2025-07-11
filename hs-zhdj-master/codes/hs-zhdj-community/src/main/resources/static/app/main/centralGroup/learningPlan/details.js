(function ($app) {
    $app.module('gtPartyApp').controller('learningPlanDetailsCtrl', function ($scope, $http, $modal, $ocLazyLoad, $alert, $loading, $state, $partySelect, $stateParams, AuthUser, $filter,$bsRouterState) {

        $stateParams=$bsRouterState.$params($scope);

        $scope.changevm={};
        $scope.receiveDWs=[];
        $scope.reqFileModel = {
            selectdata: { FileRefID: '', pageindex: 1, pagesize: 10, ptotal: 0 },//查询参数：FileRefID为文件关联ID
            filetype:3,//文件类型
            items: [],//列表数据地址
            readonly:false,//是否只能查看
            title:'学习资料',
            addFileButton:'上传'
        };
        $scope.typeMod = $stateParams.d;
        if($scope.typeMod=='d'){
            $scope.reqFileModel.type = 'details';
        }

        //加载数据
        $scope.loadData = function () {
            if($stateParams.id==undefined){
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
                $scope.genUUID();
                $scope.changevm.type = 'add';
                $scope.reqFileModel.selectdata.FileRefID = $scope.changevm.id;
            }else{
                
                $http.get("../../api/zxzxx/xxjh/get", {
                    params: {
                        'id': $stateParams.id
                    }
                }).then(function (result) {
                    $scope.reqFileModel.selectdata.FileRefID = $stateParams.id;
                    $scope.changevm = result.data.item;
                    $scope.changevm.type = 'update';
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
        //isflag：表单验证结果
        $scope.submitData = function (isflag, state) {
            if (isflag) {
                $scope.changevm.state = state;
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
                }), function (resp) {
                    $scope.showMsg('错误', '服务器错误');
                }
            }
        };

        //生成ID
        $scope.genUUID = function() {
            var d = new Date().getTime();
            var uuid = 'xxxxxxxx-xxxx-4xxx-yxxx-xxxxxxxxxxxx'.replace(/[xy]/g, function(c) {
                var r = (d + Math.random()*16)%16 | 0;
                d = Math.floor(d/16);
                return (c=='x' ? r : (r&0x7|0x8)).toString(16);
            });
            $scope.changevm.id = uuid;
        }

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