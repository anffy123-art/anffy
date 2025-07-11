(function ($ang) {
    'use strict';
    var app = $ang.module('devself.common');
    app.controller("payAsideCtrl", ['$scope', '$rootScope', '$window', '$http', '$modal', '$alert', function ($scope, $rootScope, $window, $http, $modal, $alert) {

        $scope.data = {
            amt: 0,
            selectedPayType: '1',
            changePayType: true,
            hasInit: false,
            msg: '生成支持订号中……',
            pageData: {pageindex: 1, pagesize: 5, ptotal: 0},
            item: {},
            extData: {},
            activeTab: 'pay',
            pageList: [],
            paydefer$: $rootScope.paydefer$
        };


        $scope.wxNativeData = {};

        $scope.$watch("data.activeTab", function (newVal) {
            if (newVal == 'history') {
                $scope.loadHistoryList();
            }
        });

        $scope.loadHistoryList = function () {

            if (!$scope.data.item.payRelID) {
                return;
            }

            $scope.data.pageData.payRelID = $scope.data.item.payRelID;
            $http.get("../../wxapi/pay/getPayHistoryList", {params: $scope.data.pageData}).then(function (req) {
                if (req.data.success) {
                    $scope.data.pageList = req.data.item.list;
                    $scope.data.pageData.ptotal = req.data.item.size;
                }
            });

        };

        $scope.$watch("data.pageData.pageindex", function (newVal) {
            $scope.loadHistoryList();
        });

        $scope.selectPay = function (it) {
            $scope.data.item = it;
            $scope.data.activeTab = 'pay';
            $scope.data.extData.payType = it.payType;
            $scope.checkPayType();
        }


        $scope.initPay = function () {
            $http.post("../../wxapi/pay/initPay", $rootScope.payModel).then(function (res) {
                if (res.data.success) {
                    $scope.data.item = res.data.item;
                    $scope.data.extData = res.data.extdata;
                    $scope.data.hasInit = true;
                    $scope.checkPayType();
                    $scope.data.msg = '订单已创建！'
                } else {
                    $scope.data.hasInit = false;
                    $scope.data.msg = '订单通信失败！';
                }

            }, function (err) {
                $scope.data.hasInit = false;
                $scope.data.msg = '订单通信失败！';
            })
        };

        $scope.checkPayType = function () {
            $scope.data.changePayType = $scope.data.item.payState == 0;
            if ($scope.data.item.payState == 1) {
                $scope.data.selectedPayType = $scope.data.extData.payType.toString();
            }

        };

        $scope.startPay = function () {

            if ($scope.data.selectedPayType == 1) {
                //微信接口
                $scope.paybyWXPay();
            } else {
                $scope.paybyUnionPay();
            }

            setTimeout($scope.MonitorPayState, 5 * 1000);

        };

        $scope.resetPay = function () {
            $http.post("../../wxapi/pay/resetPay", $scope.data.item).then(function (req) {
                if (req.data.success) {
                    $scope.data.item = req.data.item;

                    $scope.data.hasInit = true;
                    $scope.data.extData = {};
                    $scope.checkPayType();
                }
            });
        }

        var nativeModal = $modal({
            scope: $scope,
            templateUrl: '../js/setting/payment/wx-modal.html',
            controller: 'wxNativeCtrl',
            show: false,
            animation: 'am-fade-and-slide-top'
        });

        $scope.paybyUnionPay = function () {
            $scope.data.item.payState = 1;
            $scope.data.extData.payType = 2;
            $scope.checkPayType();
            $window.open("../../wxapi/pay/frontconsume?id=" + $scope.data.item.payOrderID);
        }

        $scope.paybyWXPay = function () {
            /*
            $scope.wxNativeData.imgsrc='../js/setting/payment/wx.png';
            nativeModal.$promise.then(nativeModal.show);
            return;*/
            $http.get('../../wxapi/pay/startWebWxPay', {params: {id: $scope.data.item.payOrderID}}).then(function (req) {
                if (req.data.success) {
                    if (req.data.item.state) {
                        $scope.wxNativeData.imgdata = req.data.item.orderReq.codeUrl;
                        $scope.wxNativeData.payOrderID = $scope.data.item.payOrderID;
                        $scope.data.item.payState = 1;
                        $scope.data.extData.payType = 1;
                        $scope.checkPayType();
                        nativeModal.$promise.then(nativeModal.show);
                        $scope.data.hasInit = true;
                        $scope.data.msg = '';
                    } else {
                        $scope.data.hasInit = false;
                        $scope.data.msg = req.data.item.msg;
                    }
                }
            });
        }

        $scope.MonitorPayState = function () {
            $http.get('../../wxapi/pay/checkpayorderstatus', {params: {payOrderID: $scope.data.item.payOrderID}}).then(function (req) {
                if (req.data.success) {
                    if (req.data.item == 3) {
                        $alert({
                            title: '提示：',
                            content: '支付成功',
                            placement: 'top',
                            type: 'info',
                            show: true,
                            duration: 3
                        });

                        if ($scope.data.extData.payType == 1) {
                            nativeModal.hide();
                        }
                        $scope.$hide();
                        $scope.data.paydefer$.resolve(true);
                        //$scope.$hide();
                    } else if (req.data.item == 4) {
                        $alert({
                            title: '提示：',
                            content: '支付失败',
                            placement: 'top',
                            type: 'info',
                            show: true,
                            duration: 3
                        });
                        nativeModal.hide();
                        $scope.data.paydefer$.resolve(false);
                        if ($scope.data.extData.payType == 1) {
                            nativeModal.hide();
                        }
                        $scope.$hide();

                    } else {
                        $scope.data.paydefer$.notify("继续处理中！");
                        setTimeout($scope.MonitorPayState, 5 * 1000);
                        //$alert({ title: '提示：',content:'未知状态', placement: 'top', type: 'info', show: true, duration: 3 });
                    }
                }
            }, function (err) {

            });
        };

        if ($rootScope.payModel) {
            $scope.data.amt = $rootScope.payModel.amt | 0;
            $scope.initPay();
        }


    }]).controller('wxNativeCtrl', ['$scope', '$timeout', '$http', '$alert', '$interval', '$http', function ($scope, $timeout, $http, $alert, $interval) {
        $scope.wxNativeData = $scope.$parent.$parent.wxNativeData;
        var defer = $scope.$parent.$parent.paydefer$;

        $scope.asyncPayResultTimer = $interval(function () {
            $scope.getPayResult();
        }, 2000);
        ///在切换控制器的时候，清除定时器，减少内存损耗
        $scope.$on(
            "$destroy",
            function () {
                $interval.cancel($scope.asyncPayResultTimer);
            }
        );

        $scope.colseModal = function () {
            $interval.cancel($scope.asyncPayResultTimer);
            $scope.$hide();
        };

        $scope.getPayResult = function () {
            if (!$scope.wxNativeData.outTradeNo)
                return;

            $http.get('../../wxapi/pay/order/query', {
                params: {"outTradeNo": $scope.wxNativeData.outTradeNo}
            }).then(function (res) {
                if (res.data && res.data.returnCode == "SUCCESS" && res.data.tradeState == "SUCCESS") {
                    $alert({
                        title: '成功',
                        content: '支付成功',
                        placement: 'top',
                        type: 'info',
                        show: true,
                        duration: 3
                    });
                    $scope.colseModal();
                    defer.resolve(true);
                } else {
                }
            }, function (res) {
            });

            return defer.promise;
        };

        //$timeout($scope.checkPayResult,60*1000);
    }]).controller('backAsideCtrl', ['$scope', '$http', '$rootScope', '$alert', function ($scope, $http, $rootScope, $alert) {

        $scope.data = {
            $defer: $rootScope.backpaydefer$,
            pageData: {
                payRelID: $rootScope.payModel.payRelID,
                pageindex: 1,
                pagesize: 5,
                ptotal: 0
            },
            pageList: [],
            activeTab: 'back',
            logData: {
                payRelID: $rootScope.payModel.payRelID,
                pageindex: 1,
                pagesize: 5,
                ptotal: 0
            },
            logList: []
        };

        $scope.loadItems = function () {
            $http.get("../../wxapi/pay/getPayHistoryList", {params: $scope.data.pageData}).then(function (req) {
                if (req.data.success) {
                    $scope.data.pageList = req.data.item.list;
                    $scope.data.pageData.ptotal = req.data.item.size;
                }
            });
        };

        $scope.loadLog = function () {
            $http.get("../../wxapi/pay/refundloglist", {params: $scope.data.logData}).then(function (req) {
                if (req.data.success) {
                    $scope.data.logList = req.data.item.list;
                    $scope.data.logData.ptotal = req.data.item.size;
                }
            });
        };

        $scope.$watch("data.pageData.pageindex", function (newVal) {
            $scope.loadItems();
        });
        $scope.$watch("data.logData.pageindex", function (newVal) {
            $scope.loadLog();
        });

        $scope.$watch("data.activeTab", function (newVal) {
            if (newVal == 'log') {
                $scope.loadLog();
            }
        });

        $scope.backPay = function (it) {
            if (confirm('是否确定退款？')) {
                $http.get('../../wxapi/pay/backpay', {params: {payOrderID: it.payOrderID}}).then(function (req) {
                    if (req.data.success) {
                        $scope.data.$defer.resolve(true);
                        $scope.$hide();
                        $alert({
                            title: '提示：',
                            content: '退款成功！',
                            placement: 'top',
                            type: 'info',
                            show: true,
                            duration: 3
                        });
                    } else {
                        $scope.data.$defer.notify('退款错误！');
                        $alert({
                            title: '提示：',
                            content: req.data.msg,
                            placement: 'top',
                            type: 'info',
                            show: true,
                            duration: 3
                        });
                    }
                }, function (err) {
                    $scope.data.$defer.notify('退款错误！');
                });
            }
        }

        $scope.loadItems();
    }]);
})(angular);