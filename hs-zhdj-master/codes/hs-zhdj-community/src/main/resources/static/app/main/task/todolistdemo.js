(function () {
    angular.module('dsfapp').controller("tododemoCtrl", function ($scope, $http, $rootScope, $alert, $modal) {
        $scope.data = {dateb: "", datee: ""};
        $scope.title = "测试数据";

        $scope.loaddata = function () {
            //$http.get("/api/Vision/getJsondata").then(function (rq) {
            //    $scope.data = rq.data;
            //    $scope.items = rq.data.xxx;
            //});
        }

        $scope.updata = function () {
            /*
            $http.post("/api/Vision/setJsondata", $scope.data).then(function (rq) {
                $alert({title: '消息', content: rq.data.msg, placement: 'top', type: 'info', show: true});
            });*/
        };

        $scope.showalert = function () {
            $alert({title: '消息', content: '提示成功', placement: 'top', type: 'info', show: true});
        };

        $scope.modal = {
            "title": "弹出窗",
            "content": "Hello Modal!"
        };
        $scope.modal1 = {
            "title": "弹页面",
            "content": "Hello Modal!"
        };

        function MyModalController($scope, $http) {
            $scope.title = '弹页面';
            $scope.content = myModal.data;
            $scope.aid = myModal.aid;

            //$scope.content = 'Hello Modal<br />This is a multiline message from a controller!';
        }

        MyModalController.$inject = ['$scope', '$http'];
        //var myModal = $modal({ scope: $scope, title: '弹页面', content: 'Hello Modal', templateUrl: 'tast/todomodal.html', show: false });
        var myModal = $modal({
            resolve: {
                load: ['$ocLazyLoad', function ($ocLazyLoad) {

                    return $ocLazyLoad.load('setting/sysDuty/saveSysDuty.js');
                }]
            },
            scope: $scope,
            content: 'Hello Modal',
            controller: MyModalController,
            templateUrl: 'tast/todomodal.html',
            show: false
        });


        $scope.showModal = function (e) {
            myModal.aid = "200";
            myModal.data = e;
            myModal.$promise.then(myModal.show);
        };
        $scope.hideModal = function () {
            myModal.$promise.then(myModal.hide);
        };


        $scope.tooltip = {
            "title": "Hello Tooltip<br />This is a multiline message!",
            "checked": false
        };

        $scope.aside = {
            "title": "Title",
            "content": "Hello Aside<br />This is a multiline message!"
        };

        $scope.loaddata();

    });
})();