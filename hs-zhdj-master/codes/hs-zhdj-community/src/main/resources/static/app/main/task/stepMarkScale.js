(function ($app) {
    'use strict';
    $app.module('dsfapp').controller('formMarkScaleCtrl', function ($scope, $filter, $timeout, $state, $alert, AuthUser, flowaudit, $http) {
        $scope.show = false;
        $timeout(function () {
            $scope.show = true;
        }, 1000);
        $scope.scoreList = [];
        $scope.scoreList.valueMark = 100;
        $scope.scoreList.Note = "功能完全符合需求描述，上线后没有任何故障";

        $scope.changeNote = function (valueMark) {
            if (valueMark == undefined) {
                $scope.scoreList.valueMark = 100;
                $scope.scoreList.Note = "功能完全符合需求描述，上线后没有任何故障";
            } else {
                if (valueMark >= 70 && valueMark <= 79) {
                    $scope.scoreList.valueMark = valueMark;
                    $scope.scoreList.Note = "部分功能不符合需求，或上线后问题较多";
                } else if (valueMark >= 80 && valueMark <= 89) {
                    $scope.scoreList.valueMark = valueMark;
                    $scope.scoreList.Note = "功能基本符合需求描述，上线后有小故障但能及时解决";
                } else if (valueMark >= 90 && valueMark <= 99) {
                    $scope.scoreList.valueMark = valueMark;
                    $scope.scoreList.Note = "功能符合需求描述，上线后没有明显故障";
                } else if (valueMark == 100) {
                    $scope.scoreList.valueMark = valueMark;
                    $scope.scoreList.Note = "功能完全符合需求描述，上线后没有任何故障";
                }
            }
            $scope.toTop();
        }

        //根据工作流id以及打分类型固定是0（需求人打分）加载需求人评分结果
        $scope.getDemandAppilerScore = function () {
            $http({
                url: '../../api/Mark/getdemandappilerMark',
                method: 'get',
                params: {
                    fid: $scope.flowdata.params.fid
                },
            }).then(function (res) {
                $scope.scoreList = res.data.items;
                $scope.changeNote(res.data.items.Score);
                //$scope.showalert("获取列表成功");
            }, function (res) {
                // $scope.showalert("服务器错误");
            });
        }
        //$scope.getDemandAppilerScore();
        //消息提示
        $scope.showalert = function (data) {
            $alert({title: '提示：', content: data, placement: 'center center-d', type: 'info', show: true, duration: 2});
        };

        //向下广播
        $scope.$on("tomarkScale", function (event, tar) {
            $scope.params = tar;
            $scope.getDemandAppilerScore();
            //if (angular.isUndefined($scope.scoreList)) {
            //    $scope.getDemandAppilerScore();
            //}

        });

        //向上广播
        $scope.toTop = function () {
            $scope.$emit("toDevRequirementTest", {
                valueMark: $scope.scoreList.valueMark,
                Note: $scope.scoreList.Note
            });
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