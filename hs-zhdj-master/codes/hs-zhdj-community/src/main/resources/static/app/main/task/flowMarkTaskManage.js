(function ($app) {
    'use strict';
    $app.module('dsfapp').controller('flowMarkTaskManageCtrl', function ($scope, $loading, $ocLazyLoad, $state, $alert, AuthUser, flowaudit, $http) {
        $scope.flowdata = {
            flowStagePanels: []
            , activePanelids: [0, 1, 2],
            params: $state.params,
            readonly: $state.params.st == 2,
        };

        angular.extend($scope.flowdata.params, {
            readonly: $scope.flowdata.readonly,
            pictureUrl: '../../../DemandDevSelf/Content/images/Score.jpg'
        });

        //定义加载模块
        $scope.loadingflow = function () {
            $http({
                url: "../../api/Task/FindTaskByfid",
                method: 'GET',
                params: {
                    id: "",
                    fid: $scope.flowdata.params.fid
                }
            }).then(function (rq) {
                $scope.tasker = rq.data.item;
                $scope.tasker.CurUrl = rq.data.CurUrl;
            });

            //$loading.show();
            $ocLazyLoad.load(['task/form_Marktaskinfo.js', 'task/form_markTask.js', 'dsflow/appendDemandFlowStep.js']).then(function (loaddata) {
                angular.copy(
                    [{
                        title: '评分任务', src: 'task/form_Marktaskinfo.html', onloadfunc: function () {
                            $scope.$broadcast("toMarkTask", $scope.flowdata.params);
                        }
                    }, {
                        title: '评分', src: 'task/form_markTask.html', onloadfunc: function () {
                            $scope.$broadcast("tomarkTask", $scope.flowdata.params);
                        }
                    },
                        {
                            title: '流程环节', src: 'dsflow/appendDemandFlowStep.html'
                        }], $scope.flowdata.flowStagePanels);
            });
        };

        $scope.loadingflow();


        $scope.applyclick = function (i) {
            if (i == 0) {
                $scope.$broadcast("toMarkTask", $scope.flowdata.params);
            } else if (i == 1) {
                $scope.$broadcast("tomarkTask", $scope.flowdata.params);
            }

        }
        //执行incluld的onload事件
        $scope.loadPanel = function (func) {
            if (angular.isFunction(func)) {
                func();
            }
        }

        //返回主流程
        $scope.toMainFlow = function () {
            // open("#!/" + $scope.tasker.CurUrl);
            window.location.href = "#!/" + $scope.tasker.CurUrl;
        };

        //一次性保存所有的打分分数
        $scope.saveScore = function () {
            $scope.demandScores = [];
            //循环遍历这个markList将demandScoredId与score放至一个新的list上面
            angular.forEach($scope.markList, function (val, key) {
                $scope.demandScores.push({
                    'DemandScoreID': val.DemandScoreID,
                    'Score': val.score
                });
            });
            $http({
                method: "post",
                url: "../../api/Mark/saveScore",
                data:
                $scope.demandScores

            }).then(function (result) {
                //$scope.upflow();
            }), function (resp) {
                alert("服务器错误");
            }
        }

        $scope.upflow = function () {
            $scope.saveScore();
            flowaudit.showaudit({
                appid: '',
                pid: $scope.flowdata.params.pid,
                fid: $scope.flowdata.params.fid,
                uid: AuthUser.getUser().DGUserID,
                onsuccess: $scope.pagechange
            });
        }
        //取消按钮返回待办
        $scope.pagechange = function () {
            //$state.go('home.todolist');
            window.history.back();
        };

        $scope.$on("tomarkTaskManage", function (event, tar) {
            $scope.markList = tar.markList;
        });
    });
})(angular);