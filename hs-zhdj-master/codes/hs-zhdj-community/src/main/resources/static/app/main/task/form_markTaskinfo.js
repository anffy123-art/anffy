(function ($app) {
    "use strict";
    $app.module('dsfapp').controller('MarkTaskCtrl', function ($scope, $state, $alert, AuthUser, flowaudit, $http, $window) {
        $scope.loadItem = function (id) {
            $http({
                url: "../../api/DevelopmentTask/FindMarkTaskByfid",
                method: 'GET',
                params: {
                    fid: id,
                    userid: AuthUser.getUser().DGUserID,
                }
            }).then(function (rq) {
                $scope.task = rq.data.item;
                $scope.taskName = rq.data.TaskName;
                $scope.taskType = rq.data.Tasktype;
                //console.log(rq.data.msg);
            });
        };
        //$scope.loadItem($state.params.fid);

        //接收广播
        $scope.$on("toMarkTask", function (event, tar) {
            if (angular.isUndefined($scope.item)) {
                $scope.loadItem(tar.fid);
            }
        });
    });
})(angular);