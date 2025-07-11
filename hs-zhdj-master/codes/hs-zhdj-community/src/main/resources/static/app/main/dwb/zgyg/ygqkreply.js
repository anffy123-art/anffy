(function ($ang) {
    'use strict';
    $ang.module('gtPartyApp').controller('ygqkreplyCtrl', function ($scope, $filter, $http, $alert, $modal, AuthUser, $state, $loading, $window, $timeout,$bsRouterState) {
        $scope.dataModel = {
            createuserid: AuthUser.getUser().Id,
            createusername: AuthUser.getUser().Name,
            status: 0,
            zgtgid: $state.params.businessid != null ? $state.params.businessid : $state.params.zgtgid
        };
        $scope.reqFileModel = {
            selectdata: {FileRefID: $scope.dataModel.zgtgid, pageindex: 1, pagesize: 10, ptotal: 0},//查询参数：FileRefID为文件关联ID
            filetype: 1,//文件类型
            items: [],//列表数据地址
            readonly: $state.params.businessid != null,//是否只能查看
            title: '附件列表',
            addFileButton: '上传'
        };
        $scope.yg_dataList = [{title: null, begindate: null, enddate: null}];
        $scope.receiveDWs = [];
        $scope.showreply = false;

        $scope.loadData = function () {
            $loading.show();

            $http({
                url: "../../api/Zgyg/getFormModel",
                method: 'post',
                data: $scope.dataModel
            }).then(function (rq) {
                $scope.dataModel = rq.data.item;
                $scope.dataModel.typevalue = $scope.dataModel.typevalue + '';
                $scope.reqFileModel.selectdata.FileRefID = $scope.dataModel.zgtgid;
                $scope.receive();
                $loading.hide();
            });
            if ($scope.dataModel.zgtgid != null) {
                $scope.getJsdwList();
                $scope.getYgqkList();
            }
        }

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

        //接收约稿处理
        $scope.receive = function () {
            if ($scope.dataModel.typename == '年度计划') {
                $http({
                    method: 'get',
                    url: '../../api/Zgyg/receiveZgyg',
                    params: {businessId: $scope.dataModel.zgtgid, userId: AuthUser.getUser().Id, messageType: '6'}
                }).then(function (result) {
                }, function (resp) {
                });
            } else {
                $http({
                    method: 'get',
                    url: '../../api/Zgyg/getJswd',
                    params: {businessId: $scope.dataModel.zgtgid, userId: AuthUser.getUser().Id}
                }).then(function (result) {
                    $scope.showreply = (result.data.item.statusName == "待回复");
                }, function (resp) {
                });
            }
        }
        $scope.addYg = function () {
            $scope.yg_dataList.push({title: null, begindate: null, enddate: null});
        };

        $scope.reply=function(){
            var ygqk=$scope.yg_dataList[0];
            $bsRouterState.go('home.fqtgedit', {ygqkid:ygqk["ygqkid"],ygmc:ygqk["title"]});
        }

        $scope.loadData();

        $scope.parentUrl = "home.ygqk";//父级地址
        $scope.pagechange = function () {
            if($bsRouterState.$getRouteType()=='tab'){
                $bsRouterState.$closeTab($scope);
            } else {
                $bsRouterState.go($scope.parentUrl);
            }
        };

    })
})(angular);