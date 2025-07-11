(function ($app) {
    'use strict';
    $app.module('dsfapp').controller('formMarkCtrl', function ($scope, $http, $modal, $alert, AuthUser) {
        //分页参数设置  
        $scope.finddata = {
            pageindex: 1,
            pagesize: 5,
            ptotal: 0
        };
        //监测页面变化
        $scope.$watch("finddata.pageindex", function (newVal, oldVal) {
            if ($scope.finddata.ptotal > 0) {
                $scope.getMemMark($scope.flowdata.params.fid);
            }
        })

        //根据fid找到团队成员并根据规则保存相应的打分记录
        //同时保存相关信息到任务基础表之中
        $scope.saveMemScore = function (id) {
            $http({
                url: "../../api/Mark/saveMemScore",
                method: 'get',
                params: {
                    fid: id
                }
            }).then(function (res) {
                console.log(res);
            }, function (res) {
                $scope.showalert("服务器错误");
            });
        }

        //判断是否可以评分
        $scope.isCheck = function (id) {
            $http({
                url: "../../api/Mark/isSendScoreTask",
                method: 'get',
                params: {
                    fid: id
                }
            }).then(function (res) {
                if (res.data) {
                    $scope.isshow = res.data;
                } else {
                    $scope.isshow = false;
                    $scope.getMemMark($scope.flowdata.params.fid);
                }
            }, function (res) {
                $scope.showalert("服务器错误");
            })
        }

        //根据fid显示相应的团队成员的打分记录
        $scope.getMemMark = function (id) {
            $http({
                url: '../../api/Mark/getMemMark',
                method: 'get',
                params: {
                    fid: id,
                    pageIndex: $scope.finddata.pageindex,
                    pageSize: $scope.finddata.pagesize
                },
            }).then(function (res) {
                $scope.MemScoreList = res.data.items;
                $scope.finddata.ptotal = res.data.total;
                //$scope.showalert("获取列表成功");
            }, function (res) {
                // $scope.showalert("服务器错误");
            });
        }

        //消息提示
        $scope.showalert = function (data) {
            $alert({title: '提示：', content: data, placement: 'center', type: 'info', show: true, duration: 2});
        };

        //输入评分任务完成时间弹窗的设置
        var inputTimeCtrl = function ($scope, $http) {
            $scope.sendTask = function (e, ExpectQuantity) {
                if (e) {
                    $http({
                        url: "../../api/Mark/sendScoreTask",
                        method: 'get',
                        params: {
                            fid: $scope.flowdata.params.fid,
                            CreateID: AuthUser.getUser().DGUserID,
                            ExpectFinishDate: e,
                            ExpectQuantity: ExpectQuantity
                        }
                    }).then(function (rq) {
                        //$scope.showalert(rq.data.msg);
                        $scope.getMemMark($scope.flowdata.params.fid);
                        inputTimeModal.$promise.then(inputTimeModal.hide);
                    });
                }
            };
        }
        inputTimeCtrl.$inject = ['$scope', '$http'];
        var inputTimeModal = $modal({
            animation: "am-fade-and-slide-top",
            scope: $scope,
            controller: inputTimeCtrl,
            templateUrl: '../js/template/modal_inputExpectFinishDate.html', show: false, backdrop: false
        });
        $scope.saveScoreTask = function () {
            $scope.title = "输入评分任务完成截止时间:";
            $scope.ExpectQuantity = 0;
            inputTimeModal.$promise.then(inputTimeModal.show);
        }

        //接收广播
        $scope.$on("toMark", function (event, tar) {
            if (angular.isUndefined($scope.item)) {
                $scope.saveMemScore(tar.fid);
                $scope.isCheck(tar.fid);
            }

        });
    });
})(angular);