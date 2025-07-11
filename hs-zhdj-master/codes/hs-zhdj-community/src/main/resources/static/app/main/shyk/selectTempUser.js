(function ($app) {
    $app.module('gtPartyApp').controller('shykSelectTempUserCtrl',function ($scope,$http,$modal,$alert,$filter) {

        $scope.tempUserList=[];
        $scope.tempUserUrl='../../api/shyk/getTempUsers';

        $scope.findData={
            name:'',
            partycode:$scope.$parent.$parent.dataModel.partycode
        };


        $scope.selectTempUser=function () {
            $scope.loadData();
        };

        $scope.loadData=function(){

            $http
            ({
                method: 'get',
                url: $scope.tempUserUrl,
                params: $scope.findData
            }).then(function (req) {
                if(req.data.success){
                    $scope.tempUserList=req.data.item;

                    $app.forEach($scope.tempUserList,function (val) {
                        val.checked=false;
                    });

                }
            });

        };

        $scope.loadData();

        $scope.deleteTempUser=function (id) {
            if(confirm('是否删除？')){
                $http
                ({
                    method: 'get',
                    url: "../../api/shyk/delTempUser",
                    params:{id:id}
                }).then(function (req){
                    $scope.loadData();
                });
            }
        };

        $scope.selectedData=function () {
            var selectedUsers=$filter('filter')($scope.tempUserList,function (val) {
                return val.checked;
            });
            if(selectedUsers.length==0){
                $alert({
                    title: '提示',
                    content: '请选择临时加入人员',
                    container:'[name="m_selectTempUser"]',
                    placement: 'top',
                    type: 'info',
                    show: true,
                    duration: 3
                });

                return;
            }

            var users=$scope.$parent.$parent.userList;

            $app.forEach(selectedUsers,function (val) {
                if($filter('filter')(users,{ RYBM:val.userid}).length==0){
                    users.push({RYBM:val.userid,XM:val.userName,
                        SZDZBDM:val.SZDZBDM,
                        DZZMC:val.partyName,
                        XBMC:val.XBMC,
                        DZZMC:val.DZZMC
                    });
                }
            });

            $scope.$hide();

        };

        var sendMsgController=function ($scope1){
            $scope1.findData1={
                mobile:'',
                partyid:$scope.findData.partycode,
                applierid:$scope.$parent.$parent.dataModel.createuserid
            };
            $scope1.sendMsgUrl='../../api/shyk/sendTempUserMsg';

            $scope1.sendMsg=function(isVaild){
                if(isVaild){
                    $http
                    ({
                        method: 'post',
                        url: $scope1.sendMsgUrl,
                        data: $scope1.findData1
                    }).then(function (req){
                        if(req.data.success){
                            $scope1.$hide();
                            $scope.loadData();
                        }
                        else {
                            $alert({
                                title: '提示',
                                content: req.data.msg,
                                container:'[name="sendTempUser"]',
                                placement: 'top',
                                type: 'info',
                                show: true,
                                duration: 3
                            });
                        }
                    });
                }

            };

        };

        sendMsgController.$inject = ['$scope'];

        var sendMsgModal=new $modal({
            scope: $scope,
            controller: sendMsgController,
            templateUrl: 'shyk/sendApplyUser.html',
            show: false,
            animation: 'am-fade-and-slide-top'
        });

        $scope.addTempUser=function () {
            sendMsgModal.$promise.then(sendMsgModal.show);
        };

        
    });
})(angular);