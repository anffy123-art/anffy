(function ($app) {
    'use strict';
    $app.module('dsfapp').controller('demandAuditCtrl', function ($scope, $state, $alert, AuthUser, flowaudit, $ocLazyLoad, $loading) {
        $scope.flowdata = {
            flowStagePanels: []
            , activePanelids: [0, 1, 2], params: $state.params
            , flowFileModel: {
                selectdata: {FileRefID: $state.params.fid, pageindex: 1, pagesize: 10, ptotal: 0},
                filetype: 2,
                items: [],
                readonly: $state.params.st == 2//判断当前页面是否为已办
            },
            readonly: $state.params.st == 2
        };
        //执行incluld的onload事件
        $scope.loadPanel = function (func) {
            if (angular.isFunction(func)) {
                func();
            }
        }


        $scope.loadApply = function () {

            $scope.$broadcast("d_applyinit", angular.extend($scope.flowdata.params, {
                readonly: $scope.flowdata.readonly,
                pictureUrl: '../../../DemandDevSelf/Content/images/flow.jpg'
            }));
        };

        //定义加载模块
        $scope.loadingflow = function () {
            $loading.show();
            $ocLazyLoad.load(['dsflow/appendDemandFlowStep.js', 'dsflow/stepDemandApply.js']).then(function (data) {
                angular.copy([{
                    title: '需求提出', src: 'dsflow/stepDemandApply.html', onloadfunc: function () {
                        $scope.loadApply();
                    }
                }, {title: '附件', src: 'dsflow/appendDemandfiles.html'},
                    {title: '流程环节', src: 'dsflow/appendDemandFlowStep.html'}], $scope.flowdata.flowStagePanels);

            });
        }

        $scope.applyclick = function (i) {
            if (i == 0) {
                //把这个步骤是否可操作传下去
                $scope.loadApply();
            }
            //else if (i == 3) {
            //    $scope.$broadcast("toSysDutyManage", $scope.flowdata.params);
            //}
            //else if (i == 4) {
            //    $scope.$broadcast("toDevPlan", $scope.flowdata.params);
            //}
            //else if (i == 5) {
            //    $scope.$broadcast("toQuantityOfWork", $scope.flowdata.params);
            //} else if (i == 6) {
            //    $scope.$broadcast("toMembershipManage", $scope.flowdata.params);
            //}
            //else if (i == 7) {
            //    $scope.$broadcast("d_probleminit", $scope.flowdata.params);
            //}
        }

        $scope.pagechange = function () {
            $state.go('home.todolist');
        };

        $scope.upflow = function () {
            flowaudit.showaudit({
                appid: '',
                pid: $scope.flowdata.params.pid,
                fid: $scope.flowdata.params.fid,
                uid: AuthUser.getUser().DGUserID,
                onsuccess: $scope.pagechange
            });
        }

        $scope.loadingflow();

    });
})(angular);