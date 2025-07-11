(function ($app) {
    $app.module('gtPartyApp').controller('programmeDetailsCtrl', function ($scope, $http, $modal, $ocLazyLoad, $alert, $loading, $state, $partySelect, $stateParams, AuthUser, $filter,$bsRouterState) {

        $stateParams=$bsRouterState.$params($scope);

        $scope.changevm={};
        $scope.sendDepartmentName = AuthUser.getUser().DPFullName;
        $scope.receiveDWs=[];
        $scope.reqFileModel = {
            selectdata: { FileRefID: '', pageindex: 1, pagesize: 10, ptotal: 0,filetypecode:'LearningMaterialType' },//查询参数：FileRefID为文件关联ID
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
                $scope.changevm = result.data.item.zzZxzxxFaModel;
                $scope.receiveDWs = result.data.item.upstepUsers;
                var vipUsersmodel = {
                    spokesmanId:[],
                    spokesmanName:[]
                };
                for(var i=0;i<result.data.item.vipUsersmodel.length;i++){
                    if(result.data.item.vipUsersmodel[i].vip==1){
                        vipUsersmodel.spokesmanId.push(result.data.item.vipUsersmodel[i].spokesmanId);
                        vipUsersmodel.spokesmanName.push(result.data.item.vipUsersmodel[i].spokesmanName);
                    }
                }
                $scope.vipUserIds = vipUsersmodel.spokesmanId.join(",");
                $scope.vipUserNames = vipUsersmodel.spokesmanName.join(",");
                var supplementUsers = {
                    spokesmanId:[],
                    spokesmanName:[]
                };
                for(var i=0;i<result.data.item.vipUsersmodel.length;i++){
                    if(result.data.item.vipUsersmodel[i].vip==2){
                        supplementUsers.spokesmanId.push(result.data.item.vipUsersmodel[i].spokesmanId);
                        supplementUsers.spokesmanName.push(result.data.item.vipUsersmodel[i].spokesmanName);
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


        $scope.parentUrl = "home.programme";//父级地址
        $scope.pagechange = function () {
            if($bsRouterState.$getRouteType()=='tab'){
                $bsRouterState.$closeTab($scope);
            } else {
                $bsRouterState.go($scope.parentUrl);
            }
        };

    });
})(angular);