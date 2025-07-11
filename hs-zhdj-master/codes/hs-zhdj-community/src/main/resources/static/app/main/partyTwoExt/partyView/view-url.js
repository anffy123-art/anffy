(function ($app) {
    $app.module('gtPartyApp').controller('partyViewUrlCtrl', function ($scope,$state,$bsRouterState,$sce,$http,$filter) {
        //var a=1;
        //$state.params = $bsRouterState.$params($scope);
        /*
        $scope.data={
            hostUrl:window.fineHostUrl,
            viewlet:$scope.panedata.data.viewlet
        };*/

        $scope.settings=[];

        $scope.fUrl=$sce.trustAsResourceUrl('./partyTwoExt/partyView/view-init.html');

        $scope.loginFine=function(){
            var urlSetting=$filter('filter')($scope.settings,{dickey:1});
            var userInfo=$filter('filter')($scope.settings,{dickey:2})[0].dicvalue.split(',');

            //那边弄个不认证的。
            $scope.fUrl=$sce.trustAsResourceUrl(urlSetting[0].dicvalue+'/webroot/decision/view/report?viewlet='
                +$scope.panedata.data.viewlet+'.cpt&op=view');
            /* 认证的部分
            $.ajax({
                url: urlSetting[0].dicvalue+'/webroot/decision/login/cross/domain',
                data: {'fine_username': userInfo[0], 'fine_password': userInfo[1], 'validity': -1},
                dataType: 'jsonp',
                callback: 'callback',
                success: function (data) {
                    if(data.status=='success'){
                        $scope.$apply(function () {
                            $scope.fUrl=$sce.trustAsResourceUrl(urlSetting[0].dicvalue+'/webroot/decision/view/report?viewlet='
                                +$scope.panedata.data.viewlet+'.cpt&op=view');
                        });
                    } else {
                        $scope.showMsg('错误', '登陆报表系统sso失败：'+data.status);
                    }

                },
                error: function () {
                    $scope.showMsg('错误', '登陆报表系统错误！404');
                }
            });
            */

            /*
            $http.jsonp($sce.trustAsResourceUrl(),{params: {'fine_username': userInfo[0], 'fine_password': userInfo[1], 'validity': -1,callback:'JSON_CALLBACK'}})
                .then(function (result) {
                    $scope.fUrl=$sce.trustAsResourceUrl(urlSetting[0].dicvalue+'/webroot/decision/view/report?viewlet='
                        +$scope.panedata.data.viewlet+'.cpt&op=view');

                }, function (resp) {
                    $scope.showMsg('错误', '登陆报表系统失败！');
                });

            $http({
                method: 'JSONP',
                url:urlSetting[0].dicvalue+'/webroot/decision/login/cross/domain',
                params: {'fine_username': userInfo[0], 'fine_password': userInfo[1], 'validity': -1,callback:'JSON_CALLBACK'}
            }).then();
            */
        };

        $scope.loadData=function(){
            $http({
                method: 'get',
                url: '../../api/dictionary/getDictionaryListByDicTypeKey',
                params: {dicTypeKey: 'fineReport'}
            }).then(function (result) {
                $scope.settings = result.data;
                $scope.loginFine();
            }, function (resp) {

            });
        };

        $scope.loadData();


        //$scope.loadParentFlows();
    });
})(angular);
