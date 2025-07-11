(function ($app) {
    'use strict';
    $app.module('dsfapp').controller('formSysMarkCtrl', function ($scope, $http, $modal, $alert, $rootScope, $loading) {
        //分页参数设置  
        $scope.finddata = {
            pageindex: 1,
            pagesize: 5,
            ptotal: 0
        };
        //监测页面变化
        $scope.$watch("finddata.pageindex", function (newVal, oldVal) {
            if ($scope.finddata.ptotal > 0) {
                $scope.getSysMark($scope.flowdata.params.fid);
            }
        });

        //判断是否可以自动计算分数
        $scope.isCkeckCount = function (id) {
            $http({
                url: '../../api/SubmitValidate/checkCountSysMark',
                method: 'get',
                params: {
                    fid: id
                }
            }).then(function (res) {
                if (res.data) {
                    $scope.isShow = res.data;
                    $scope.getSysMark($scope.flowdata.params.fid);
                } else {
                    $scope.isShow = res.data;
                }
            }, function (res) {
                //$scope.showalert("服务器错误");
            })
        };

        //系统自动计算各个角色的总的分数
        $scope.getSysMark = function (id) {
            $http({
                url: '../../api/Mark/getSysMark',
                method: 'get',
                params: {
                    fid: id,
                    pageIndex: $scope.finddata.pageindex,
                    pageSize: $scope.finddata.pagesize
                },
            }).then(function (res) {
                $scope.SysScoreList = res.data.items;
                $scope.finddata.ptotal = res.data.total;
                //$scope.showalert("获取列表成功");
            }, function (res) {
                $scope.showalert("服务器错误");
            });
        };

        //弹模态框展示需求内部评分明细
        var editModalController = function ($scope, $http) {
            $scope.paramsDemand = myModal.params;
            $scope.content = myModal.params.content;
            //加载单个人员的需求内部打分明细记录
            $scope.loadDemandList = function () {
                $http.get("../../api/Mark/getDemandList", {
                    params: {
                        'userid': $scope.paramsDemand.userid,
                        'fid': $scope.paramsDemand.fid,
                        'roleid': $scope.paramsDemand.roleid
                    }
                }).then(function (result) {
                    console.log(result);
                    $scope.content = result.data.items;
                }, function () {
                    $alert({title: '提示：', content: "服务器错误", placement: 'top', type: 'info', show: true, duration: 3});
                });
            }
            $scope.loadDemandList();
        }
        editModalController.$inject = ['$scope', '$http'];

        //弹模态框展示需求验收评分明细
        var editModalController1 = function ($scope, $http) {
            $scope.paramsAccept = myModal1.params;
            $scope.content1 = myModal1.params.content;

            //加载单个人员的需求验收评分记录(都是一致的打分结果)
            $scope.loadAcceptList = function () {
                $http.get("../../api/Mark/getAcceptList", {params: {'fid': $scope.paramsAccept.fid}}).then(function (result) {
                    console.log(result);
                    $scope.content1 = result.data.items;
                }, function () {
                    $alert({title: '提示：', content: "服务器错误", placement: 'top', type: 'info', show: true, duration: 3});
                });
            }
            $scope.loadAcceptList();
        }
        editModalController1.$inject = ['$scope', '$http'];
        var myModal = $modal({
            scope: $scope,
            templateUrl: 'task/editDemandModal.html',
            controller: editModalController,
            show: false,
            animation: 'am-fade-and-slide-top'
        });
        var myModal1 = $modal({
            scope: $scope,
            templateUrl: 'task/editAcceptModal.html',
            controller: editModalController1,
            show: false,
            animation: 'am-fade-and-slide-top'
        });
        //打开需求内部评分模态框
        $scope.editDemandmodal = function (userid, roleid) {
            myModal.params = {};
            angular.extend(myModal.params, {
                title: "需求内部评分明细",
                content: {},
                userid: userid,
                roleid: roleid,
                fid: $scope.flowdata.params.fid
            });
            myModal.$promise.then(myModal.show);
        }
        //打开需求验收评分模态框
        $scope.editAcceptmodal = function () {
            myModal1.params = {};
            angular.extend(myModal1.params, {
                title: "需求验收评分明细",
                content: {},
                fid: $scope.flowdata.params.fid
            });
            myModal1.$promise.then(myModal1.show);
        }
        //广播
        $scope.$on("toSysMark", function (event, tar) {
            if (angular.isUndefined($scope.item)) {
                $scope.isCkeckCount(tar.fid);
            }

        });
    });
})(angular);