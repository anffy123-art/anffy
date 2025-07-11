(function ($app) {
    'use strict';
    $app.module('dsfapp').controller('demandsurveyCtrl', function ($scope, $state, $alert, AuthUser, $q, $ocLazyLoad) {
        //var pagedeferred = $q.defer();
        $scope.pagedata = {
            Panels: [],
            params: {},
            params_Mem: {}
        };

        //执行incluld的onload事件
        $scope.loadPanel = function (func) {
            if (angular.isFunction(func)) {
                func();
            }
        }
        //模块调用事件
        $scope.$on("todemandSurvey", function (event, tar) {
            $scope.pagedata.params = tar;
            //angular.copy($scope.pagedata.params, $scope.pagedata.params_Mem)
            //if ($scope.pagedata.params.FlowStage == 3 && $scope.pagedata.params.readonly==true) {
            //    $scope.pagedata.params_Mem.readonly = false;
            //}
            $scope.pagedata.params.FlowStage = 2;
            $scope.pagedata.params_Mem.FlowStage = 2;
            if ($scope.pagedata.Panels.length > 0) {
                return;
            }
            ;

            $ocLazyLoad.load(['dsflow/formMembershipManage.js', 'dsflow/formSysDutyManage.js', 'dsflow/formQuantityOfWork.js']).then(function () {

                //加载显示列表
                angular.copy([{
                    title: '项目团队', src: 'dsflow/formMembershipManage.html', onloadfunc: function () {
                        $scope.$broadcast('toMembershipManage', $scope.pagedata.params);
                    }
                }, {
                    title: '工作量', src: 'dsflow/formQuantityOfWork.html', onloadfunc: function () {

                        $scope.$broadcast('toQuantityOfWork', $scope.pagedata.params);
                    }
                }, {
                    title: '功能点管理', src: 'dsflow/formSysDutyManage.html', onloadfunc: function () {

                        $scope.$broadcast('toSysDutyManage', $scope.pagedata.params);
                    }
                }], $scope.pagedata.Panels);

            });


        });

    });
})(angular);