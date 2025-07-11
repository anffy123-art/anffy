(function ($ang) {
    'use strict';
    $ang.module('gtPartyApp').controller('zgygEditCtrl', function ($scope, $filter, $http, $alert, $modal, AuthUser, $state, $loading,$stateParams, $window, $timeout,$bsRouterState) {

        $stateParams=$bsRouterState.$params($scope);

        $scope.dataModel = {
            createuserid: AuthUser.getUser().Id,
            createusername: AuthUser.getUser().Name,
            status: 0,
            zgtgid: $stateParams.businessid != null ? $stateParams.businessid : $stateParams.zgtgid
        };
        $scope.reqFileModel = {
            selectdata: {FileRefID: $scope.dataModel.zgtgid, pageindex: 1, pagesize: 10, ptotal: 0},//查询参数：FileRefID为文件关联ID
            filetype: 1,//文件类型
            items: [],//列表数据地址
            readonly:$stateParams.businessid != null,//是否只能查看
            title: '附件列表',
            addFileButton: '上传'
        };
        $scope.yg_dataList = [{title: null, begindate: null, enddate: null}];
        $scope.receiveDWs = [];

        //监视所属类型变化
        $scope.$watch("dataModel.typevalue", function (newVal, oldVal) {
            //如果为具体约稿，只能保留一条记录
            if (newVal == 2) {
                $scope.yg_dataList = [$scope.yg_dataList[0]];
            }
        });
        $scope.loadData = function () {
            $loading.show();

            $http({
                url: "../../api/Zgyg/getFormModel",
                method: 'post',
                data: $scope.dataModel
            }).then(function (rq) {
                $scope.dataModel = rq.data.item;
                //$scope.dataModel.typevalue = $scope.dataModel.typevalue + '';
                $scope.reqFileModel.selectdata.FileRefID = $scope.dataModel.zgtgid;
                $loading.hide();
            });
            if ($scope.dataModel.zgtgid != null) {
                $scope.getJsdwList();
                $scope.getYgqkList();
            }
        }
        //获取类型
        $scope.getTypeList = function () {
            $http({
                method: 'get',
                url: '../../api/dictionary/GetDictionaryList',
                params: {dicTypeKey: 'ZgtgType'}
            }).then(function (result) {
                $scope.ndList = result.data.item.list;
            }, function (resp) {
            });
        };
        //获取约稿情况
        $scope.getYgqkList = function () {
            $http.get("../../api/Zgyg/getYgqkList", {
                params: {zgtgid: $scope.dataModel.zgtgid}
            }).then(function (result) {
                $scope.yg_dataList = result.data.item.list;
            }, function () {
                $scope.showMsg('错误', '服务器错误');
            });
        }
        //获取接收单位
        $scope.getJsdwList = function () {
            $http.get("../../api/Zgyg/getJsdwList", {
                params: {zgtgid: $scope.dataModel.zgtgid}
            }).then(function (result) {
                $scope.receiveDWs = result.data.item.list;
            }, function () {
                $scope.showMsg('错误', '服务器错误');
            });
        }
        $scope.selectAllDw = function () {
            $http.get("../../api/dzzgly/chooseDw", {
                params: {}
            }).then(function (result) {
                $scope.receiveDWs = result.data.item.list;
            }, function () {
                $scope.showMsg('错误', '服务器错误');
            });
        }
        //表单提交
        $scope.submitData = function (isvalid, issubmit) {
            if (isvalid == false) return false;
            $scope.dataModel.status = issubmit ? 1 : 0;//1提交：0保存
            if ($scope.yg_dataList.length == 0) {
                $scope.showMsg('错误', '约稿情况为空！');
                return;
            }
            if ($scope.receiveDWs.length == 0) {
                $scope.showMsg('错误', '接收单位为空！');
                return;
            }
            $http({
                method: "post",
                url: "../../api/Zgyg/save",
                data: {item: $scope.dataModel, ygdatalist: $scope.yg_dataList, dwlist: $scope.receiveDWs}
            }).then(function (result) {
                $scope.showMsg('成功', result.data.msg);
                //$bsRouterState.go('home.zgyg', {});
                $scope.pagechange();
            }), function (resp) {
                $scope.showMsg('错误', '服务器错误');
            }
        }
        var selectCtrl = function ($scope, $http) {
            $scope.receivePcomm = [];
            $scope.checkitem = function (item) {
                $scope.receivePcomm.push(item);
            };

            $scope.confirmSelect = function () {
                $scope.$parent.$parent.receiveDWs = $scope.$parent.$parent.receiveDWs.concat($scope.receivePcomm);
                selectModal.$promise.then(selectModal.hide);
            }

            $scope.cancelSelect = function () {
                selectModal.$promise.then(selectModal.hide);
            };
        }
        selectCtrl.$inject = ['$scope', '$http'];
        //定义模态框
        var selectModal = $modal({
            scope: $scope,
            controller: selectCtrl,
            templateUrl: '../main/dwb/zgyg/selectDw.html',
            show: false,
            animation: 'am-fade-and-slide-top'
        });
        $scope.selectDw = function () {
            $scope.receivePcommList = [];
            $http.get("../../api/dzzgly/chooseDw", {
                params: {}
            }).then(function (result) {
                //只保留未选择的
                var list = result.data.item.list;
                var dwids = [];
                for (var i = 0; i < $scope.receiveDWs.length; i++) {
                    dwids.push($scope.receiveDWs[i].dzzdm);
                }
                angular.forEach(list, f => {
                    if (dwids.indexOf(f.dzzdm) < 0)
                        $scope.receivePcommList.push(f);
                })
                selectModal.$promise.then(selectModal.show);
            }, function () {
                $scope.showMsg('错误', '服务器错误');
            });
        }

        $scope.addYg = function () {
            $scope.yg_dataList.push({title: null, begindate: null, enddate: null});
        };
        $scope.deleteReceiveDWs = function (i) {
            $scope.receiveDWs.splice(i, 1);
        };
        $scope.deleteYg = function (i) {
            $scope.yg_dataList.splice(i, 1);
        };
        $scope.return = function () {
            $scope.pagechange();
        }
        //必填验证
        $scope.invalidValue = function (index, form1, name) {
            name = name + "_" + index;
            return form1[name].$invalid;
        };
        $scope.getTypeList();
        $scope.loadData();

        $scope.parentUrl = "home.zgyg";//父级地址
        $scope.pagechange = function () {
            if($bsRouterState.$getRouteType()=='tab'){
                $bsRouterState.$closeTab($scope);
            } else {
                $bsRouterState.go($scope.parentUrl);
            }
        };

    })
})(angular);