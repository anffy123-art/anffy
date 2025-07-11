(function ($app) {
    'use strict';
    $app.module('dsfapp').controller('formMarkTaskCtrl', function ($scope, $filter, $timeout, $state, $alert, AuthUser, flowaudit, $http) {
        $scope.show = false;
        $timeout(function () {
            $scope.show = true;
        }, 1000);
        $scope.disabledtoto = false;
        $scope.markList = [];
        $scope.markList.score = 100;

        //改变进度条相应位置
        $scope.changeSlider = function (valueMark) {
            //if (valueMark==0) {
            //    $scope.markList.score = 70;
            //} else {
            //    if (valueMark >= 70 && valueMark <= 79) {
            //        $scope.markList.score = valueMark;
            //    } else if (valueMark >= 80 && valueMark <= 89) {
            //        $scope.markList.score = valueMark;
            //    } else if (valueMark >= 90 && valueMark <= 99) {
            //        $scope.markList.score = valueMark;
            //    } else if (valueMark == 100) {
            //        $scope.markList.score = valueMark;
            //    }
            //}
            $scope.markList.score = valueMark;
            $scope.toTop();
        }

        //根据fid加载对应的当前用户的需要打分的记录
        $scope.getMark = function () {
            $http({
                url: '../../api/Mark/getMark',
                method: 'get',
                params: {
                    fid: $scope.flowdata.params.fid,
                    CreateID: AuthUser.getUser().DGUserID
                },
            }).then(function (res) {
                $scope.markList = res.data.items;
                //循环遍历整个items改变进度条
                angular.forEach(res.data.items, function (val, key) {
                    $scope.changeSlider(val.score);
                });
                //$scope.changeSlider(res.data.items[0].score);
            }, function (res) {
                // $scope.showalert("服务器错误");
            });
        }
        $scope.getMark();

        //向下广播
        $scope.$on("tomarkTask", function (event, tar) {
            $scope.params = tar;
            if (angular.isUndefined($scope.scoreList)) {
                $scope.getMark();
            }
        });

        //向上广播
        $scope.toTop = function () {
            $scope.$emit("tomarkTaskManage", {markList: $scope.markList});
        }
    }).directive('sliderRangeFilter', [function () {
        return {
            restrict: 'A',
            template: '<div id="searchBySliderFilter" class="filter-slider"><input ng-model="value3.value"  type="text" id="mySlider1" slider options="options" /></div><div>Current value is: {{value3.value}}</div>',
            link: function ($scope, element, attrs) {
            }

        };
    }]);

})(angular);