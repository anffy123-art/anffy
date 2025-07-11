(function ($app) {
    $app.module('gtPartyApp').controller('partyGroupListCtrl', function ($scope, $http, $modal, $ocLazyLoad, $alert, $loading,AuthUser, $state) {
        //定义数据集合
        $scope.dataList = []; //列表数据
        $scope.selectparams = {
            'pageindex': 1,
            'pagesize': 10,
            selectdzzdm:AuthUser.getUser().DPCode,
            selectdzzmc: '',
            parentcode: AuthUser.getUser().ParentDpCode,
            dzzmc:'',
            dzzdm: '',
            zzlb: '711',//党小组
            isContainParent: -1,
            userid:AuthUser.getUser().Id,
            zzfbType: null
        };
        $scope.pageInfo = {ptotal: 0};
        //监视页数变化
        $scope.$watch("selectparams.pageindex", function (newVal, oldVal) {
            if ($scope.pageInfo.ptotal > 0) {
                $scope.loadData();
            }
        });

        $scope.$watch("selectparams.selectdzzdm", function (newVal, oldVal) {
            if (newVal != '' && newVal != null) {
                $scope.selectparams.parentcode = $scope.selectparams.selectdzzdm;
                $scope.loadData();
            }
        });

        $scope.$watch("selectparams.zzfbType", function (newVal, oldVal) {
            if (newVal != oldVal) {
                $scope.loadData();
            }
        });

        //查询
        $scope.search = function () {
            $scope.loadData();
        };
        //导出
        $scope.export = function () {
            var params = "?1=1";
            for (var p in $scope.selectparams) {
                if ($scope.selectparams[p] !== '' && $scope.selectparams[p] !== null)
                    params += ("&" + p + "=" + encodeURI($scope.selectparams[p]));
            }
            window.open('../../api/party/exportPartyDXZ' + params);
        };

        //加载列表数据
        $scope.loadData = function () {
            $http
            ({
                method: 'get', url: '../../api/party/getPartyList', params: $scope.selectparams
            }).then(function (result) {
                $scope.dataList = result.data.item.list;
                $scope.pageInfo.ptotal = result.data.item.total;
            });
        };

        var editPartyCtrl = function ($scope, $http) {
            $scope.params = partyModal.params;
            $scope.partyvm = partyModal.partyvm;
            $scope.parentParty = partyModal.parentParty;
            $scope.userList = [];
            $scope.dzzdm_short = "";
            if ($scope.partyvm.dzzdm != null && $scope.partyvm.dzzdm != "") {
                $scope.dzzdm_short = $scope.partyvm.dzzdm.replace($scope.parentParty.dzzdm, '');
            }

            $scope.submitDZX = function (isflag) {
                if (isflag) {
                    $loading.show();
                    $scope.partyvm.dzzdm = $scope.parentParty.dzzdm + $scope.dzzdm_short;
                    var userList = [];
                    angular.forEach($scope.userList, function (val, key) {
                        userList.push({ryjbxxbs: val.RYJBXXBS, rybm: val.RYBM});
                    });
                    $http({
                        method: "post",
                        url: "../../api/party/savePartyDXZ",
                        data: {
                            party: $scope.partyvm,
                            userList: JSON.stringify(userList)
                        }
                    }).then(function (result) {
                        $loading.hide();
                        $scope.showMsg('成功', result.data.msg);
                        //重新刷新列表
                        $scope.loadData();
                        $scope.$hide();

                    }), function (resp) {
                        $scope.showMsg('错误', '服务器错误');
                    }
                }
            };
            $scope.selectUserlist = {
                url: '../../api/partyUser/getPartyUserList',
                title: '人员选择',
                isMulti: true,
                selectData: {xm: '姓名', szdzb: '所在组织架构'},
                columns: {XM: '姓名', XBMC: '性别', JG: '籍贯', DZZMC: '所在组织架构'},
                selectLabelKey: 'XM',
                selectValuekey: 'RYJBXXBS',
                selectedValueData: '',
                selectedLabeData: '',
                selectedJData: [],
                selectParams: {
                    dzzdm: $scope.parentParty.dzzdm,
                    removeUsers: ''
                }
            };
            $scope.$watch('selectUserlist.selectedValueData', function (newVal) {
                if (newVal != '' && newVal != undefined) {
                    $http({
                        method: 'get',
                        url: '../../api/partyUser/getPartyUserList',
                        params: {
                            userIds: newVal,
                            pageindex: 1,
                            pagesize: 1000
                        }
                    }).then(function (result) {
                        $loading.hide();
                        $scope.userList = $scope.userList.concat(result.data.item.list);
                        //$scope.setRemoveUser();
                        $scope.selectUserlist.selectedValueData = "";
                        $scope.selectUserlist.selectedLabeData = "";
                    }, function (resp) {
                        $loading.hide();
                        $scope.showMsg('错误', '服务器错误');
                    });
                }
            });
            $scope.$watch('userList', function (newVal) {
                $scope.setRemoveUser();
            }, true);
            $scope.deleteUser = function (index) {
                $scope.userList.splice(index, 1);
                //$scope.setRemoveUser();
            };
            $scope.selectUser = function () {
                /*var selectedValueData = "";
                var selectedLabeData = "";
                angular.forEach($scope.userList, function (val, key) {
                    selectedValueData += (key == 0 ? '' : ',') + val.RYJBXXBS;
                    selectedLabeData += (key == 0 ? '' : ',') + val.XM;
                });
                $scope.selectUserlist.selectedValueData = selectedValueData;
                $scope.selectUserlist.selectedLabeData = selectedLabeData;*/
            };

            $scope.getUserList = function () {
                if ($scope.partyvm.dzzdm != "" && $scope.partyvm.dzzdm != null) {
                    $http
                    ({
                        method: 'get',
                        url: '../../api/partyUser/getDxzUserList',
                        params: {pageindex: 1, pagesize: 10000, dzzdm: $scope.partyvm.dzzdm}
                    }).then(function (result) {
                        $scope.userList = result.data.item.list;
                        //$scope.setRemoveUser();
                    });
                }
            };

            $scope.setRemoveUser = function () {
                $scope.selectUserlist.selectParams.removeUsers = "";
                angular.forEach($scope.userList, function (val, index) {
                    $scope.selectUserlist.selectParams.removeUsers += val.RYJBXXBS + ','
                });
            };

            $scope.getUserList();

        };
        editPartyCtrl.$inject = ['$scope', '$http'];
        //定义模态框
        var partyModal = $modal({
            resolve: {
                load: ['$ocLazyLoad', function ($ocLazyLoad) {
                }]
            },
            scope: $scope,
            controller: editPartyCtrl,
            templateUrl: '../main/party/partyGroup/edit.html',
            show: false,
            animation: 'am-fade-and-slide-top'
        });
        //新增编辑党组织
        $scope.addDXZ = function () {
            $scope.edit("", "新增党组织信息");
        };
        $scope.editDXZ = function (id) {
            $scope.edit(id, "编辑党组织信息")
        }
        $scope.edit = function (id, title) {
            partyModal.params = {
                title: title
            };
            $loading.show();
            $http.get("../../api/party/getPartyById", {
                params: {
                    'id': id,
                    'parent_dzzdm': $scope.selectparams.parentcode
                }
            }).then(function (result) {
                $loading.hide();
                partyModal.partyvm = result.data.item;
                partyModal.parentParty = result.data.extdata.parentParty;
                partyModal.$promise.then(partyModal.show);
            }, function () {
                $scope.showMsg('错误', '服务器错误');
            });
        };

        $scope.delete = function (it) {
            if (it.DXZCYSL > 0) {
                $scope.showMsg("消息", "请先删除党小组成员");
                return false;
            }
            if (confirm("是否确定删除？")) {
                $http({
                    url: "../../api/party/deletePartyById",
                    method: 'GET',
                    params: {id: it.ZZQKXXBS}
                }).then(function (result) {
                    $scope.showMsg("消息", result.data.msg);
                    if (result.data.success) {
                        $scope.loadData();
                    }
                });
            }
        };

        $scope.showMsg = function (title, content) {
            $alert({
                title: title + '：',
                content: content,
                placement: 'top',
                type: 'info',
                show: true,
                duration: 3
            });

        };

    });
})(angular);