(function ($app) {
    $app.module('gtPartyApp').controller('dyfzztqkCtrl', function ($scope, $http, $modal, $ocLazyLoad, $alert, $loading, $state, $filter, $stateParams, AuthUser, $bsRouterState, $timeout) {
        $state.params = $bsRouterState.$params($scope);
        $scope.nd = parseInt($filter("date")(new Date(), "yyyy"));
        $scope.title = "发展党员总体情况";
        $scope.dyfzqk_dataList = [];
        $scope.loadDYFZQK = function () {
            $http
            ({
                method: 'get',
                url: '../../api/bigdata/getDsjDYFZQKList',
                params: {nd: $scope.nd}
            }).then(function (result) {
                $scope.dyfzqk_dataList = result.data;
            });
        };

        $scope.loadDYFZQKTotalList = function () {
            $http
            ({
                method: 'get',
                url: '../../api/bigdata/getDYFZQKTotalList',
                params: {nd: $scope.nd-1}
            }).then(function (result) {
                $scope.parseOption(result.data.item);
            });
        };
        $scope.pieOption = {};
        $scope.parseOption = function (data) {
            var series = new Array();
            var colors =['#FF9801','#E91E63','#01BCD4']
            angular.forEach(data, function (item, index) {
                var values = [item.JHFZDYSL, item.GR, item.SCGZDYX, item.GTLY, item.XJMFRW, item.GZSQT, item.GQTY];
                series.push({type: 'bar', name: item.ND, itemStyle: {color: colors[index],normal: {
                            color: colors[index],
                            label: {
                                show: true, //开启显示
                                position: 'top', //在上方显示
                            }
                        }}, data: values});
            })
            $scope.pieOption = {
                legend: {
                    data: [
                        {
                            name: ($scope.nd-3).toString()
                        },
                        {
                            name: ($scope.nd - 2).toString()
                        },
                        {
                            name: ($scope.nd - 1).toString()
                        }
                    ],
                    formatter: '{name}年'
                },
                tooltip: {},
                xAxis: {
                    type: 'category',
                    data: ['发展党员总数', '工人', '生产、工作第一线', '高铁领域', '先进模范人物', '高知识群体', '共青团员'],
                    axisLabel: {
                        formatter:function (d) {
                            return d.substr(0,6)+"\n"+d.substr(6)
                        },
                    }
                },
              /*  dataZoom : [{//实现缩放功能
                    show : true,
                    realtime : true,
                    start : 0,
                    end : 70
                }],*/
                yAxis: [{
                    type: 'value',
                    name: '人数',
                    axisLabel: {
                        formatter: '{value}'
                    }
                }],
                grid: { // 控制图的大小，调整下面这些值就可以，
                    x: 40,
                    x2: 100,
                    y2: 150,// y2可以控制 X轴跟Zoom控件之间的间隔，避免以为倾斜后造成 label重叠到zoom上
                },
                series: series
            };
        }

        $scope.loadDYFZQK();
        $scope.loadDYFZQKTotalList()

    });
})(angular);