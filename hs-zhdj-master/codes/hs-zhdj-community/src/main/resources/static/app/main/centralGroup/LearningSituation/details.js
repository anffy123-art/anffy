(function ($app) {
    $app.module('gtPartyApp').controller('LearningSituationDetailsCtrl', function ($scope, $http, $modal, $ocLazyLoad, $alert, $loading, $state, $partySelect, $stateParams, AuthUser, $filter,$bsRouterState) {

        $stateParams=$bsRouterState.$params($scope);

        $scope.changevm={};
        $scope.sendDepartmentName = AuthUser.getUser().DPFullName;
        $scope.receiveDWs=[];
        $scope.reqFileModel = {
            selectdata: { FileRefID: '', pageindex: 1, pagesize: 10, ptotal: 0 },//查询参数：FileRefID为文件关联ID
            filetype:3,//文件类型
            items: [],//列表数据地址
            readonly:false,//是否只能查看
            title:'学习成果',
            addFileButton:'上传',
            type:'details'
        };

        //加载数据
        $scope.loadData = function () {
            $http.get("../../api/zxzxx/xxfa/get", {
                params: {
                    'id': $stateParams.id
                }
            }).then(function (result) {
                $scope.changevm = result.data.item.zzZxzxxFa;
                $scope.receiveDWs = result.data.item.upstepUsers;
                var vipUsers = {
                    spokesmanId:[],
                    spokesmanName:[]
                };
                for(var i=0;i<result.data.item.vipUsers.length;i++){
                    if(result.data.item.vipUsers[i].vip==1){
                        vipUsers.spokesmanId.push(result.data.item.vipUsers[i].spokesmanId);
                        vipUsers.spokesmanName.push(result.data.item.vipUsers[i].spokesmanName);
                    }
                }
                $scope.vipUserIds = vipUsers.spokesmanId.join(",");
                $scope.vipUserNames = vipUsers.spokesmanName.join(",");
                var supplementUsers = {
                    spokesmanId:[],
                    spokesmanName:[]
                };
                for(var i=0;i<result.data.item.vipUsers.length;i++){
                    if(result.data.item.vipUsers[i].vip==2){
                        supplementUsers.spokesmanId.push(result.data.item.vipUsers[i].spokesmanId);
                        supplementUsers.spokesmanName.push(result.data.item.vipUsers[i].spokesmanName);
                    }
                }
                $scope.supplementUserIds = supplementUsers.spokesmanId.join(",");
                $scope.supplementUserNames = supplementUsers.spokesmanName.join(",");
                $scope.reqFileModel.selectdata.FileRefID = $stateParams.id;
            }, function () {
                $scope.showMsg('错误', '服务器错误');
            });
        };

        $scope.loadData();


        $scope.parentUrl = "home.LearningSituation";//父级地址
        $scope.pagechange = function () {
            if($bsRouterState.$getRouteType()=='tab'){
                $bsRouterState.$closeTab($scope);
            } else {
                $bsRouterState.go($scope.parentUrl);
            }
        };

    });
})(angular);