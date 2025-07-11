(function ($app) {
    $app.module('gtPartyApp').controller('partyOrgCtrl', function ($scope, $http, $modal, $ocLazyLoad, $alert, $loading, $state, AuthUser, $bsRouterState) {

        $scope.selectparams = {jgfzid: '', fjgfzid: ''}
        $scope.treeData = [];
        $scope.pagetreeData = [];
        $scope.selectNode = null;
        $scope.loadData = function () {
            $loading.show();
            $http({
                url: "../../api/partyOrg/getPartyOrgTree",
                method: 'GET',
                params: $scope.selectparams
            }).then(function (rq) {
                $scope.pagetreeData = $scope.treeData = rq.data.item;
                //如果已经选择显示的分组，则直接显示原来选择的
                if ($scope.selectparams.jgfzid != "" && $scope.selectparams.jgfzid != null) {
                    $scope.pagetreeData = $scope.treeData.filter(function (item) {
                        return item.jgfzid == $scope.selectparams.jgfzid;
                    });
                }
                //默认选中第一个
                if ($scope.pagetreeData.length > 0) {
                    $scope.selectparams.fjgfzid = $scope.pagetreeData[0].jgfzid;
                    scope.GetSelectDzzdmList();
                }
                $loading.hide();
            });
        }

        //监视页数变化
        $scope.$watch("selectparams.jgfzid", function (newVal, oldVal) {
            $scope.selectNode = null;
            $scope.selectparams.fjgfzid = $scope.selectparams.jgfzid;

            if (newVal == "" || newVal == null) {
                $scope.pagetreeData = $scope.treeData;
                scope.selectPartys = [];
                scope.reviewTree(scope.treeList);
                return;
            }
            scope.GetSelectDzzdmList();
            $scope.pagetreeData = $scope.treeData.filter(function (item) {
                return item.jgfzid == newVal;
            });
            //选中的组
            $scope.selectNode = $scope.pagetreeData[0];
        });
        var editCtrl = function ($scope, $http, AuthUser) {

            $scope.submitForm = function (isflag) {
                if (isflag) {
                    $http({
                        method: "post",
                        url: "../../api/partyOrg/saveDjzzrsJgfz",
                        data: $scope.modalData
                    }).then(function (result) {
                        $loading.hide();
                        $scope.showMsg('成功', result.data.msg);
                        if (result.data.success) {
                            if ($scope.isUpdate)//修改处理
                                $scope.$parent.$parent.selectNode.fzmc = $scope.modalData.fzmc;
                            else
                                $scope.loadData();
                            $scope.$hide();
                        }

                    }, function (resp) {
                        $scope.showMsg('错误', '服务器错误');
                    })
                }
            }
        };
        editCtrl.$inject = ['$scope', '$http'];
        var cdModal = $modal({
            scope: $scope,
            title: '分组信息',
            templateUrl: 'party/partyOrg/edit.html',
            controller: editCtrl,
            show: false,
            animation: 'am-fade-and-slide-top'
        });
        $scope.modalData = {};
        $scope.isUpdate = false;
        $scope.EditModal = function () {
            $scope.modalData = angular.copy($scope.selectNode);
            $scope.isUpdate = true;
            cdModal.$promise.then(cdModal.show);
        };
        $scope.AddModal = function () {
            $scope.isUpdate = false;
            $scope.modalData = {
                createPerson: AuthUser.getUser().Id,
                updatePerson: AuthUser.getUser().Id,
                fjgfzid: $scope.selectparams.fjgfzid
            };
            cdModal.$promise.then(cdModal.show);
        };
        $scope.deleteNode = function () {
            if (confirm("是否确定删除,如确定將删除关联组织及子分组数据？")) {
                $loading.show();
                $http({
                    url: "../../api/partyOrg/delete",
                    method: 'GET',
                    params: {jgfzid: $scope.selectparams.fjgfzid}
                }).then(function (result) {
                    $scope.showMsg("消息", result.data.msg);
                    if (result.data.success) {
                        $scope.loadData();
                        $scope.selectparams.jgfzid = null;
                    }
                    $loading.show();
                }, function () {
                    $loading.hide();
                });
            }
        }
        $scope.nodeClick = function (party) {
            $scope.selectNode = party;
            $scope.selectparams.fjgfzid = party.jgfzid;
            party.expand = !(party.expand == true);
            scope.GetSelectDzzdmList();
        }
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
        $scope.loadData();


        //定义组织树数据
        var scope = $scope;
        scope.treeList = [];//组织树数据
        scope.zzfbTypeList = [];//组织分类
        scope.gddwdm = AuthUser.getUser().gddwdm;//广东党委代码
        scope.isShowZZFBType = scope.gddwdm == AuthUser.getUser().DataDzzdm && !scope.csssrc;//是否需要显示分类下拉框
        //数据联动-添加分类下拉监视
        scope.$watch("zzfbtype", function (newVal, oldVal) {
            if (newVal != oldVal) {
                scope.treeList.length = 0;
                scope.defaultselected = "";
                scope.loadParentParty();
            }
        });


        //查询父级架构
        scope.loadParentParty = function () {
            var dataDzzdm = AuthUser.getUser().DataDzzdm;//数据权限
            scope.selectdzzdm = dataDzzdm;
            if (dataDzzdm == scope.gddwdm) {//有查看全集团数据的权限
                scope.parentcode = dataDzzdm;
                scope.dzzdm = "";
                scope.selectdzzmc = "全校党组织";
            } else {
                scope.parentcode = dataDzzdm.substring(0, dataDzzdm.length - 3);
                scope.dzzdm = dataDzzdm;
            }

            $http
            ({
                method: 'get', url: '../../api/party/getPartyTreeList', params:
                    {
                        parentCode: scope.parentcode,
                        isshowxz: 1,
                        dzzdm: scope.dzzdm,
                        onlyshow_dw: scope.onlyshowdw,
                        zzfbType: scope.zzfbtype
                    }
            }).then(function (result) {
                var list = [];
                angular.forEach(result.data.item, function (node, index) {
                    node.P_Code = scope.parentcode;
                    node.isChecked = scope.isChecked(node.DZZDM);
                    list.push(node);
                });

                scope.treeList = list;

                if (scope.treeList.length == 1 || (scope.treeList.length > 0 && scope.treeList[0].DZZDM == scope.selectdzzdm)) {
                    scope.loadChildParty(scope.treeList[0]);
                }

                //默认选中党委
                if (scope.defaultselected != "" && scope.defaultselected != null && scope.defaultselected != undefined) {
                    //var defaultItem = list.filter(it => it.DZZDM == scope.defaultselected);
                    var defaultItem = $filter("filter")(list, {DZZDM: scope.defaultselected.substring(0, 12)});
                    if (defaultItem.length > 0) {
                        scope.loadChildParty(defaultItem[0]);
                    }

                }

            });
        };
        //查询子级架构
        scope.loadChildParty = function (item) {
            var CHILDSHOW = item.CHILDSHOW > 0 ? 0 : 1;
            scope.resetActive(item);
            item.CHILDSHOW = CHILDSHOW;
            scope.selectdzzdm = item.DZZDM;
            scope.selectdzzmc = item.DZZMC;
            //onlyshowdw==2 只显示一级党委 不加载下一级
            if (scope.onlyshowdw != 2 && item.CHILDSHOW > 0 && item.CHILDCOUNT > 0) {
                $http
                ({
                    method: 'get', url: '../../api/party/getPartyTreeList', params:
                        {
                            parentCode: item.DZZDM,
                            isshowxz: 1,
                            onlyshow_dw: scope.onlyshowdw
                        }
                }).then(function (result) {
                    var list = [];
                    angular.forEach(result.data.item, function (node, index) {
                        node.P_Code = item.P_Code + '.' + item.DZZDM;
                        node.isChecked = scope.isChecked(node.DZZDM);
                        list.push(node);
                    });
                    item.CHILDPARTYS = list;

                    //默认选中
                    if (item.DZZDM != scope.defaultselected && scope.defaultselected != "" && scope.defaultselected != null && scope.defaultselected != undefined) {
                        var defaultItem = $filter("filter")(list, {DZZDM: scope.defaultselected.substring(0, item.DZZDM.length + 3)});
                        if (defaultItem.length > 0) {
                            scope.loadChildParty(defaultItem[0]);
                        }

                    }

                });
            }
        };

        //重置选中项
        scope.resetActive = function (model) {
            var codes = model.P_Code.split('.');
            codes.push(model.DZZDM);
            angular.forEach(scope.treeList, function (node, index) {
                var index = $.inArray(node.DZZDM, codes);
                node.CHILDSHOW = index >= 0 ? 1 : 0;
                if (node.CHILDPARTYS != null && node.CHILDPARTYS.length > 0) {
                    scope.resetActive_child(node.CHILDPARTYS, codes);
                }
            });
        };
        scope.resetActive_child = function (list, codes) {
            angular.forEach(list, function (node, index) {
                var index = $.inArray(node.DZZDM, codes);
                node.CHILDSHOW = index >= 0 ? 1 : 0;
                if (node.CHILDPARTYS != null && node.CHILDPARTYS.length > 0) {
                    scope.resetActive_child(node.CHILDPARTYS, codes);
                }
            });
        };

        //获取组织分类数据
        scope.loadZzfbTypeList = function () {
            $http({
                method: 'get',
                url: '../../api/dictionary/getDictionaryListByDicTypeKey',
                params: {
                    dicTypeKey: 'zzfb'
                }
            }).then(function (result) {
                scope.zzfbTypeList = result.data;
            }, function (resp) {

            });
        };

        //选中
        scope.selectPartys = [];

        scope.isChecked = function (dzzdm) {
            var nodes = scope.selectPartys.filter(function (item) {
                return item.indexOf(dzzdm) > -1 || dzzdm==item;
            });
            return nodes.length > 0;
        }
        scope.chkchildren = function (party) {
            scope.arrayChange(party.DZZDM, party.isChecked);
            scope.checkedChildren(party.CHILDPARTYS, party.isChecked);
        }
        scope.checkedChildren = function (list, checked) {
            angular.forEach(list, function (node, index) {
                node.isChecked = checked;
                scope.arrayChange(node.DZZDM, checked);
                if (node.CHILDPARTYS != null && node.CHILDPARTYS.length > 0) {
                    scope.checkedChildren(node.CHILDPARTYS, checked);
                }
            });
        };
        scope.arrayChange = function (dzzdm, isChecked) {
            if (isChecked) {
                scope.selectPartys.push(dzzdm);
            } else {
                var index = scope.selectPartys.indexOf(dzzdm);   //找到要删除的元素对应的下标,从0开始
                scope.selectPartys.splice(index, 1);
            }
        }
        scope.Save = function () {
            if ($scope.selectparams.fjgfzid == null || $scope.selectparams.fjgfzid == "") {
                $scope.showMsg('错误', '请先选择分组！');
                return false;
            }
            $loading.show();
            $http({
                method: "post",
                url: "../../api/partyOrg/saveFzjggl",
                data: {jgfzid: $scope.selectparams.fjgfzid, dzzdmArray: scope.selectPartys}
            }).then(function (result) {
                $loading.hide();
                $scope.showMsg('成功', result.data.msg);

            }, function (resp) {
                $loading.hide();
                $scope.showMsg('错误', '服务器错误');
            })
        }
        scope.GetSelectDzzdmList = function () {
            $loading.show();
            $http({
                url: "../../api/partyOrg/getSelectDzzdmList",
                method: 'GET',
                params: {jgfzid: $scope.selectparams.fjgfzid}
            }).then(function (rq) {
                scope.selectPartys = rq.data.item;
                $loading.hide();
                scope.reviewTree(scope.treeList);
            });
        }
        scope.reviewTree = function (list) {
            angular.forEach(list, function (node, index) {
                node.isChecked = scope.isChecked(node.DZZDM);
                if (node.CHILDPARTYS != null && node.CHILDPARTYS.length > 0) {
                    scope.reviewTree(node.CHILDPARTYS);
                }
            });
        }
        //初始化数据
        scope.loadParentParty();
        scope.loadZzfbTypeList();
    });
})(angular);