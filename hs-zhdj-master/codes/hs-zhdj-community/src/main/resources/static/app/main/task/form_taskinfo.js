(function ($app) {
    "use strict";
    $app.module('dsfapp').controller('developmentTaskCtrl', function ($scope, $state, $alert, AuthUser, flowaudit, $http, $window) {
        $scope.loadItem = function (id) {
            $http({
                url: "../../api/DevelopmentTask/FindTaskByfid",
                method: 'GET',
                params: {fid: id}
            }).then(function (rq) {
                $scope.task = rq.data.item;
                $scope.taskName = rq.data.TaskName;
                $scope.taskType = rq.data.Tasktype;
                //console.log(rq.data.msg);
            });
        };
        //$scope.loadItem($state.params.fid);

        //接收广播
        $scope.$on("todevelopmentTask", function (event, tar) {
            if (angular.isUndefined($scope.item)) {
                $scope.loadItem(tar.fid);
            }
        });
    });
})(angular);