(function ($app) {
    $app.module('gtPartyApp').controller('adPartyGroupListCtrl', function ($scope, $http, $modal, $ocLazyLoad, $alert, $loading, $state, AuthUser, $bsRouterState, $timeout) {
        $state.params = $bsRouterState.$params($scope);

        $scope.dataList = [];

        $scope.getDataList = function () {
            $loading.show();
            $http.get("../../api/adPartyGroup/getTree").then(function (res) {
                $scope.dataList = res.data.item;
                $loading.hide();
            }, function (res) {
                $loading.hide();
                $scope.showMsg('错误', '服务器错误' + res);
            });
        };

        $scope.loadChildList = function (item) {
            if (!item.isExpand) {
                item.isExpand = true;
                /*$scope.getGroupByParentID(item);*/
            } else {
                item.isExpand = false;
            }
        };

        $scope.getGroupByParentID = function (item) {
            $http.get("../../api/adPartyGroup/getList", {
                params: {
                    'parentId': item.ID
                }
            }).then(function (result) {
                item.childList = result.data.item;

            }, function () {
            });
        };

        var editCtrl = function ($scope, $http) {
            $scope.params = editModal.params;

        };
        editCtrl.$inject = ['$scope', '$http'];
        //定义模态框
        var editModal = $modal({
            resolve: {
                load: ['$ocLazyLoad', function ($ocLazyLoad) {
                }]
            },
            scope: $scope,
            controller: editCtrl,
            templateUrl: '../main/systemManage/adPartyGroup/edit.html',
            show: false,
            animation: 'am-fade-and-slide-top'
        });

        $scope.add = function () {
            $scope.editItem("", "新增机构信息");
        };

        $scope.edit = function (id) {
            $scope.editItem(id, "修改机构信息")
        };

        var editCtrl = function ($scope, $http) {
            $scope.params = editModal.params;
            $scope.dataModel = editModal.data;
            $scope.parentConfig = {
                url: '../../api/adPartyGroup/getTree',
                ismulti: false,
                readonly: $scope.params.op == 1
            };

            $scope.save = function (isflag) {
                if (isflag) {
                    $loading.show();
                    $http({
                        method: "post",
                        url: "../../api/adPartyGroup/save",
                        data: $scope.dataModel
                    }).then(function (result) {
                        $loading.hide();
                        if (result.data.success) {
                            $scope.showMsg('成功', result.data.msg);
                            $scope.getDataList();
                            $scope.$hide();
                        }
                        else{
                            $scope.showMsg('失败', result.data.msg);
                        }

                    }, function (resp) {
                        $loading.hide();
                        $scope.showMsg('错误', '服务器错误：' + resp.data);
                    });
                }
            };


        };
        editCtrl.$inject = ['$scope', '$http'];
        //定义模态框
        var editModal = $modal({
            resolve: {
                load: ['$ocLazyLoad', function ($ocLazyLoad) {
                }]
            },
            scope: $scope,
            controller: editCtrl,
            templateUrl: '../main/systemManage/adPartyGroup/edit.html',
            show: false,
            animation: 'am-fade-and-slide-top'
        });
        $scope.editItem = function (id, title) {
            editModal.params = {
                title: title,
                op: id == "" ? 0 : 1
            };
            $loading.show();
            $http.get("../../api/adPartyGroup/get", {
                params: {
                    'id': id
                }
            }).then(function (result) {
                $loading.hide();
                editModal.data = result.data.item;
                editModal.$promise.then(editModal.show);
            }, function (resp) {
                $loading.hide();
                $scope.showMsg('错误', '服务器错误：' + resp.data);
            });
        };

        $scope.delete = function (id) {
            if (confirm("是否确定删除？")) {
                $http({
                    url: "../../api/adPartyGroup/delete",
                    method: 'GET',
                    params: {id: id}
                }).then(function (result) {
                    $scope.showMsg("消息", result.data.msg);
                    if (result.data.success) {
                        $scope.getDataList();
                    }
                });
            }
        };


        $scope.getDataList();

    });
})(angular);