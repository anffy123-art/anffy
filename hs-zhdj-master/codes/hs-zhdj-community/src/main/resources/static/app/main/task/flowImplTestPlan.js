(function ($app) {
    'use strict';
    $app.module('dsfapp').controller('implTestPlanCtrl', function ($scope, $state, $alert, AuthUser, flowaudit, $http, $ocLazyLoad, $loading) {
        $scope.flowdata = {
            flowStagePanels: [],
            activePanelids: [0, 1, 2],
            params: $state.params,
            readonly: true,//该流程是否为可读
            readonly2: $state.params.st == 2,
            isAllPlan: $state.params.ft != 1,//是否查看所有测试计划
        };
        angular.extend($scope.flowdata.params, {pictureUrl: '../../../DemandDevSelf/Content/images/TestPlan.jpg'});
        //定义加载模块
        $scope.loadingflow = function () {
            $http({
                url: "../../api/DevelopmentTask/FindTaskByfid",
                method: 'GET',
                params: {fid: $scope.flowdata.params.fid}
            }).then(function (rq) {
                $scope.mainUrl = rq.data.CurUrl;
            });
            $ocLazyLoad.load(['task/form_taskinfo.js', 'task/formUploadTestFile.js', 'dsflow/appendDemandFlowStep.js']).then(function (loaddata) {
                $loading.show();
                $scope.flowdata.flowStagePanels = [
                    {
                        title: '测试计划任务', src: 'task/form_taskinfo.html', onloadfunc: function () {
                            $scope.$broadcast("todevelopmentTask", angular.extend($scope.flowdata.params, {readonly: $scope.flowdata.readonly}));
                        }
                    },
                    {
                        title: '上传测试计划文件', src: 'task/formUploadTestFile.html', onloadfunc: function () {
                            $scope.$broadcast("toUploadTestFile", angular.extend($scope.flowdata.params, {
                                readonly: $scope.flowdata.readonly2,
                                isAllPlan: $scope.flowdata.isAllPlan
                            }));
                        }
                    }, {title: '任务流程环节', src: 'dsflow/appendDemandFlowStep.html'}];
            });
        };

        //执行incluld的onload事件
        $scope.loadPanel = function (func) {
            if (angular.isFunction(func)) {
                func();
            }
        }
        $scope.toMainFlow = function () {
            // open("#!/" + $scope.tasker.CurUrl);
            window.location.href = "#!/" + $scope.mainUrl;
        };

        $scope.pagechange = function () {
            window.history.back();
            //$state.go('home.todolist');
        };

        $scope.upflow = function () {
            //显示流程处理环节框的参数
            var option = {
                pid: $scope.flowdata.params.pid,
                fid: $scope.flowdata.params.fid,
                uid: AuthUser.getUser().DGUserID,
                onsuccess: $scope.pagechange
            };
            flowaudit.showaudit(option);
        }

        $scope.loadingflow();
    });
})(angular);