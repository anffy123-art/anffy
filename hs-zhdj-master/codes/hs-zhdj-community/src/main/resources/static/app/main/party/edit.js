(function ($app) {
    $app.module('gtPartyApp').controller('partyEditCtrl', function ($scope, $http, $modal, $ocLazyLoad, $alert, $loading, $state, $partySelect, $stateParams, $bsRouterState, $partySelect, $timeout, AuthUser) {

        $stateParams = $bsRouterState.$params($scope);

        $scope.op = $stateParams.op;

        $scope.isAdd = !$stateParams.id;

        /*$scope.pageList = [
            {id: 1, title: '党组织基础信息', url: '../main/party/edit_PartyInfo.html'},
            {id: 2, title: '党组织换届信息', url: '../main/party/edit_GradeList.html'},
            {id: 3, title: '领导班子信息', url: '../main/party/edit_GradeUserList.html'}
        ];*/
        $scope.activeTab = 1;

        $scope.isSave = ($stateParams.id == undefined || $stateParams.id == "" || $stateParams.id == null) ? false : true;

        $scope.partyModel = {
            zzqkxxbs: $stateParams.id == undefined ? "" : $stateParams.id,
            dzzdm: $stateParams.dzzdm == undefined ? "" : $stateParams.dzzdm
        };

        $scope.partyExt = {
            dzzdm_short: ''
        };

        $scope.parentParty = {};

        $scope.partyFBModel = {
            zzlb: null,
            jczzfl: null,
            zgrs: null
        };
        $scope.zzlbdmList = [];//组织类别
        $scope.zzlbmc = "";
        $scope.jczzflList = [];//基层组织分类

        $scope.jcDataList = [];
        $scope.selectGradeParams = {
            'pageindex': 1,
            'pagesize': 100,
            ssdzzdm: $scope.partyModel.dzzdm,
            ldjtjc: '',
            xjfs: null
        };

        $scope.selectUserParams = {
            isunfold: false,//组织结构树展开收缩
            'pageindex': 1,
            'pagesize': 10,
            ssdzzdm: $scope.partyModel.dzzdm,
            ldjtjc: '',
            xm: '',
            zwmc: null,
            rzfs: null
        };

        //选择tab页
        $scope.selectTab = function (setTab) {
            $scope.activeTab = setTab;
        };
        //判断选中项
        $scope.isSelected = function (checkedTab) {
            return $scope.activeTab === checkedTab;

        };
        //必填验证
        $scope.invalidValue = function (index, form1, name) {
            name = name + "_" + index;
            eval('var i=form1.' + name + '.$invalid');
            return i;
        };

        $scope.$watch('partyFBModel.zzlb', function (newVal) {
            if (newVal == "500" || newVal == '' || newVal == undefined) {
                $scope.pageList = [
                    {id: 1, title: '党组织基础信息', url: '../main/party/edit_PartyInfo.html'}
                ];
            } else {
                $scope.pageList = [
                    {id: 1, title: '党组织基础信息', url: '../main/party/edit_PartyInfo.html'},
                    {id: 2, title: '党组织换届信息', url: '../main/party/edit_GradeList.html'},
                    {id: 3, title: '领导班子信息', url: '../main/party/edit_GradeUserList.html'}
                ];
            }

            if (newVal != '' && newVal != undefined) {
                angular.forEach($scope.zzlbdmList, function (val) {
                    if (newVal == val.bm) {
                        $scope.zzlbmc = val.hzmc;
                    }
                });

                if (newVal == "100" || newVal == "200") {
                    $scope.pageList[2].title = "领导班子信息";
                } else {
                    $scope.pageList[2].title = "支委委员信息";
                }
            } else {
                $scope.zzlbmc = "";
            }

        });

        //tab1党组织信息
        {
            $scope.selectUser_zz = {
                url: '../../api/partyUser/getPartyUserList',
                title: '人员选择',
                isMulti: true,
                selectData: {xm: '姓名', szdzb: '所在组织架构'},
                columns: {XM: '姓名', XBMC: '性别', JG: '籍贯', DZZMC: '所在组织架构'},
                selectLabelKey: 'XM',
                selectValuekey: 'RYBM',
                selectedValueData: '',
                selectedLabeData: '',
                selectedJData: [],
                selectParams: {
                    ryzt: '2,3',
                    dzzdm: AuthUser.getUser().DataDzzdm
                }
            };

            $scope.selectUser_xc = {
                url: '../../api/partyUser/getPartyUserList',
                title: '人员选择',
                isMulti: true,
                selectData: {xm: '姓名', szdzb: '所在组织架构'},
                columns: {XM: '姓名', XBMC: '性别', JG: '籍贯', DZZMC: '所在组织架构'},
                selectLabelKey: 'XM',
                selectValuekey: 'RYBM',
                selectedValueData: '',
                selectedLabeData: '',
                selectedJData: [],
                selectParams: {
                    ryzt: '2,3',
                    dzzdm: AuthUser.getUser().DataDzzdm
                }
            };

            $scope.selectUser_jj = {
                url: '../../api/partyUser/getPartyUserList',
                title: '人员选择',
                isMulti: true,
                selectData: {xm: '姓名', szdzb: '所在组织架构'},
                columns: {XM: '姓名', XBMC: '性别', JG: '籍贯', DZZMC: '所在组织架构'},
                selectLabelKey: 'XM',
                selectValuekey: 'RYBM',
                selectedValueData: '',
                selectedLabeData: '',
                selectedJData: [],
                selectParams: {
                    ryzt: '2,3',
                    dzzdm: AuthUser.getUser().DataDzzdm
                }
            };

            //选择党小组组长
            $scope.selectUser_dxzzz = {
                url: '../../api/partyUser/getPartyUserList',
                title: '人员选择',
                isMulti: false,
                selectData: {xm: '姓名', szdzb: '所在组织架构'},
                columns: {XM: '姓名', XBMC: '性别', JG: '籍贯', DZZMC: '所在组织架构'},
                selectLabelKey: 'XM',
                selectValuekey: 'RYBM',
                selectedValueData: '',
                selectedLabeData: '',
                selectedJData: [],
                selectParams: {
                    ryzt: '2,3',
                    dzzdm: AuthUser.getUser().DataDzzdm
                }
            };

            //党群办主任
            $scope.selectUser_dqbzr = {
                url: '../../api/partyUser/getPartyUserList',
                title: '人员选择',
                isMulti: true,
                selectData: {xm: '姓名', szdzb: '所在组织架构'},
                columns: {XM: '姓名', XBMC: '性别', JG: '籍贯', DZZMC: '所在组织架构'},
                selectLabelKey: 'XM',
                selectValuekey: 'RYBM',
                selectedValueData: '',
                selectedLabeData: '',
                selectedJData: [],
                selectParams: {
                    ryzt: '2,3',
                    dzzdm: AuthUser.getUser().DataDzzdm
                }
            };

            //综合部（党群工作部）部长
            $scope.selectUser_zhbbz = {
                url: '../../api/partyUser/getPartyUserList',
                title: '人员选择',
                isMulti: true,
                selectData: {xm: '姓名', szdzb: '所在组织架构'},
                columns: {XM: '姓名', XBMC: '性别', JG: '籍贯', DZZMC: '所在组织架构'},
                selectLabelKey: 'XM',
                selectValuekey: 'RYBM',
                selectedValueData: '',
                selectedLabeData: '',
                selectedJData: [],
                selectParams: {
                    ryzt: '2,3',
                    dzzdm: AuthUser.getUser().DataDzzdm
                }
            };


            $scope.loadPartyInfo = function () {
                $http.get("../../api/party/getPartyById", {
                    params: {
                        'id': $scope.partyModel.zzqkxxbs,
                        'parent_dzzdm': $stateParams.parentcode
                    }
                }).then(function (result) {
                    $loading.hide();
                    $scope.partyModel = result.data.item;
                    $scope.parentParty = result.data.extdata.parentParty;
                    if ($scope.partyModel.dzzdm != null && $scope.partyModel.dzzdm != "") {
                        $scope.partyExt.dzzdm_short = $scope.partyModel.dzzdm.substring($scope.parentParty.dzzdm.length);
                    }

                    $scope.partyFBModel = result.data.extdata.partyFBModel;

                    if ($scope.partyFBModel.dxzzzbm != null && $scope.partyFBModel.dxzzzbm != '') {
                        $scope.selectUser_dxzzz.selectedValueData = $scope.partyFBModel.dxzzzbm;
                        $scope.selectUser_dxzzz.selectedLabeData = $scope.partyFBModel.dxzzzmc;
                    }

                    $scope.selectGradeParams.ssdzzdm = $scope.partyModel.dzzdm;
                    $scope.selectUserParams.ssdzzdm = $scope.partyModel.dzzdm;

                    $scope.getPartyZLYList();
                    $scope.getZzlbdmList();
                    $scope.getJczzflList();

                    $scope.loadGradeList();

                    $scope.loadGradeUserList();

                    $scope.getBzjcList($scope.partyModel.dzzdm);

                }, function () {
                    $scope.showMsg('错误', '服务器错误');
                });
            };

            $scope.saveParty = function (isflag) {
                if (isflag) {

                    var zlyUserList = [];
                    angular.forEach($scope.selectUser_zz.selectedValueData.split(','), function (val) {
                        if (val != '') {
                            zlyUserList.push({
                                rybm: val,
                                zlytype: 1
                            });
                        }
                    });
                    angular.forEach($scope.selectUser_xc.selectedValueData.split(','), function (val) {
                        if (val != '') {
                            zlyUserList.push({
                                rybm: val,
                                zlytype: 2
                            });
                        }
                    });
                    angular.forEach($scope.selectUser_jj.selectedValueData.split(','), function (val) {
                        if (val != '') {
                            zlyUserList.push({
                                rybm: val,
                                zlytype: 3
                            });
                        }
                    });

                    angular.forEach($scope.selectUser_dqbzr.selectedValueData.split(','), function (val) {
                        if (val != '') {
                            zlyUserList.push({
                                rybm: val,
                                zlytype: 4
                            });
                        }
                    });

                    angular.forEach($scope.selectUser_zhbbz.selectedValueData.split(','), function (val) {
                        if (val != '') {
                            zlyUserList.push({
                                rybm: val,
                                zlytype: 5
                            });
                        }
                    });

                    $scope.partyFBModel.dxzzzbm = $scope.selectUser_dxzzz.selectedValueData;
                    $scope.partyFBModel.dxzzzmc = $scope.selectUser_dxzzz.selectedLabeData;

                    $loading.show();
                    $http({
                        method: "post",
                        url: "../../api/party/saveParty",
                        data: {
                            parentDzzdm: $scope.parentParty.dzzdm,
                            dzzdm_short: $scope.partyExt.dzzdm_short,
                            partyModel: $scope.partyModel,
                            partyFBModel: $scope.partyFBModel,
                            zlyUserList: JSON.stringify(zlyUserList)
                        }
                    }).then(function (result) {
                        $loading.hide();
                        if (result.data.success) {
                            $scope.showMsg('成功', result.data.msg);
                            $scope.isSave = true;

                            $scope.loadPartyInfo();

                            $scope.$emit("tabReloadData", {name: 'partyListCtrl', data: 1});

                        } else {
                            $scope.showMsg('失败', result.data.msg);
                        }
                    }, function (resp) {
                        $scope.showMsg('错误', '服务器错误');
                    });
                }
            };

            //组织类别
            $scope.getZzlbdmList = function () {
                $http({
                    method: 'get',
                    url: '../../api/partyDic/getZzlbdmList',
                    params: {}
                }).then(function (result) {
                    $scope.zzlbdmList = result.data;
                    /*angular.forEach($scope.zzlbdmList, function (val) {
                        if ($scope.partyFBModel.zzlb == val.bm) {
                            $scope.zzlbmc = val.hzmc;
                        }
                    });

                    if (!$scope.isSave) {
                        var lbList = [];
                        angular.forEach($scope.zzlbdmList, function (val) {
                            if (val.hzmc == "党小组") {
                                lbList.push(val);

                                $scope.partyFBModel.zzlb = val.bm;
                            }
                        });

                        $scope.zzlbdmList = lbList;
                    }*/

                }, function (resp) {
                });
            };
            //基层组织分类
            $scope.getJczzflList = function () {
                $http({
                    method: 'get',
                    url: '../../api/partyDic/getJczzflList',
                    params: {}
                }).then(function (result) {
                    $scope.jczzflList = result.data;
                }, function (resp) {
                });
            };

            $scope.getPartyZLYList = function () {
                if ($scope.partyModel.dzzdm != '' && $scope.partyModel.dzzdm != null) {
                    $http
                    ({
                        method: 'get', url: '../../api/party/getPartyZLYList', params: {
                            'pageindex': 1,
                            'pagesize': 100,
                            dzzdm: $scope.partyModel.dzzdm
                        }
                    }).then(function (result) {
                        var data = result.data.item.list;
                        $scope.selectUser_zz.selectedValueData = "";
                        $scope.selectUser_zz.selectedLabeData = "";

                        $scope.selectUser_xc.selectedValueData = "";
                        $scope.selectUser_xc.selectedLabeData = "";

                        $scope.selectUser_jj.selectedValueData = "";
                        $scope.selectUser_jj.selectedLabeData = "";

                        $scope.selectUser_dqbzr.selectedValueData = "";
                        $scope.selectUser_dqbzr.selectedLabeData = "";

                        $scope.selectUser_zhbbz.selectedValueData = "";
                        $scope.selectUser_zhbbz.selectedLabeData = "";

                        angular.forEach(data, function (item, index) {
                            switch (item.ZLYTYPE) {
                                case 1:
                                    $scope.selectUser_zz.selectedValueData += item.RYBM + ",";
                                    $scope.selectUser_zz.selectedLabeData += item.XM + ",";
                                    break;
                                case 2:
                                    $scope.selectUser_xc.selectedValueData += item.RYBM + ",";
                                    $scope.selectUser_xc.selectedLabeData += item.XM + ",";
                                    break;
                                case 3:
                                    $scope.selectUser_jj.selectedValueData += item.RYBM + ",";
                                    $scope.selectUser_jj.selectedLabeData += item.XM + ",";
                                    break;
                                case 4:
                                    $scope.selectUser_dqbzr.selectedValueData += item.RYBM + ",";
                                    $scope.selectUser_dqbzr.selectedLabeData += item.XM + ",";
                                    break;
                                case 5:
                                    $scope.selectUser_zhbbz.selectedValueData += item.RYBM + ",";
                                    $scope.selectUser_zhbbz.selectedLabeData += item.XM + ",";
                                    break;
                            }
                        });

                        $scope.selectUser_zz.selectedValueData = $scope.substringLast($scope.selectUser_zz.selectedValueData);
                        $scope.selectUser_zz.selectedLabeData = $scope.substringLast($scope.selectUser_zz.selectedLabeData);

                        $scope.selectUser_xc.selectedValueData = $scope.substringLast($scope.selectUser_xc.selectedValueData);
                        $scope.selectUser_xc.selectedLabeData = $scope.substringLast($scope.selectUser_xc.selectedLabeData);

                        $scope.selectUser_jj.selectedValueData = $scope.substringLast($scope.selectUser_jj.selectedValueData);
                        $scope.selectUser_jj.selectedLabeData = $scope.substringLast($scope.selectUser_jj.selectedLabeData);

                        $scope.selectUser_dqbzr.selectedValueData = $scope.substringLast($scope.selectUser_dqbzr.selectedValueData);
                        $scope.selectUser_dqbzr.selectedLabeData = $scope.substringLast($scope.selectUser_dqbzr.selectedLabeData);

                        $scope.selectUser_zhbbz.selectedValueData = $scope.substringLast($scope.selectUser_zhbbz.selectedValueData);
                        $scope.selectUser_zhbbz.selectedLabeData = $scope.substringLast($scope.selectUser_zhbbz.selectedLabeData);

                    });
                }
            };
        }

        $scope.substringLast = function (val) {
            return val.substring(0, val.length - 1);
        };

        //tab2届次信息
        {
            $scope.loadGradeList = function () {
                if ($scope.selectGradeParams.ssdzzdm != "" && $scope.selectGradeParams.ssdzzdm != null) {
                    $http
                    ({
                        method: 'get', url: '../../api/grade/getGradeList', params: $scope.selectGradeParams
                    }).then(function (result) {
                        $scope.jcDataList = result.data.item.list;
                    });
                }
            };

            $scope.searchGrade = function () {
                $scope.loadGradeList();
            }

            var editGradeCtrl = function ($scope, $http) {
                $scope.params = gradeModal.params;
                $scope.gradevm = gradeModal.gradevm;
                $scope.gradevmFb = gradeModal.gradevmFb;
                if ($scope.gradevm.ldjtjc != "" && $scope.gradevm.ldjtjc != null) {
                    $scope.gradevm.ldjtjc = Number($scope.gradevm.ldjtjc);
                }
                $scope.party = gradeModal.party;
                $scope.submitGrade = function (isflag) {
                    if (isflag) {
                        $loading.show();
                        $http({
                            method: "post",
                            url: "../../api/grade/saveGrade",
                            data: {
                                gradeModel: $scope.gradevm,
                                gradeFbModel: $scope.gradevmFb
                            }
                        }).then(function (result) {
                            $loading.hide();
                            if (result.data.success) {
                                $scope.showMsg('成功', result.data.msg);
                                //重新刷新列表
                                $scope.loadGradeList();
                                $scope.$hide();
                            } else {
                                $scope.showMsg('失败', result.data.msg);
                            }

                        }, function (resp) {
                            $loading.hide();
                            $scope.showMsg('错误', '服务器错误');
                        })
                    }
                }
            };
            editGradeCtrl.$inject = ['$scope', '$http'];
            //定义模态框
            var gradeModal = $modal({
                resolve: {
                    load: ['$ocLazyLoad', function ($ocLazyLoad) {
                    }]
                },
                scope: $scope,
                controller: editGradeCtrl,
                templateUrl: '../main/party/edit_GradeInfo.html',
                show: false,
                animation: 'am-fade-and-slide-top'
            });
            //新增编辑届次
            $scope.addGrade = function () {
                if (!$scope.isSave) {
                    $scope.showMsg('失败', "请先保存党组织信息");
                    return false;
                }
                $scope.isDetail = true;
                $scope.showEditModal("", "新增换届信息");
            };
            $scope.editGrade = function (id) {
                $scope.isDetail = true;
                $scope.showEditModal(id, "编辑换届信息")
            }
            $scope.detailGrade = function (id) {
                $scope.isDetail = false;
                $scope.showEditModal(id, "换届信息详情");
            }
            $scope.showEditModal = function (id, title) {
                gradeModal.params = {
                    title: title
                };
                $loading.show();
                $http.get("../../api/grade/getGradeById", {
                    params: {
                        'id': id,
                        'dzzdm': $scope.partyModel.dzzdm
                    }
                }).then(function (result) {
                    $loading.hide();
                    gradeModal.gradevm = result.data.item;
                    gradeModal.party = result.data.extdata.party;
                    gradeModal.gradevmFb = result.data.extdata.gradeFbModel;

                    gradeModal.$promise.then(gradeModal.show);
                }, function () {
                    $scope.showMsg('错误', '服务器错误');
                });
            };

            $scope.deleteGrade = function (id) {
                if (confirm("是否确定删除？")) {
                    $http({
                        url: "../../api/grade/deleteGradeById",
                        method: 'GET',
                        params: {id: id}
                    }).then(function (result) {
                        $scope.showMsg("消息", result.data.msg);
                        if (result.data.success) {
                            $scope.loadGradeList();
                        }
                    });
                }
            };

            //选举方式
            $scope.getXjfslList = function () {
                $http({
                    method: 'get',
                    url: '../../api/partyDic/getXjfslList',
                    params: {}
                }).then(function (result) {
                    $scope.xjfsdmList = result.data;
                }, function (resp) {
                });
            };

            //数据初始化
            $scope.getXjfslList();
        }

        //tab3领导班子信息
        {
            //定义数据集合
            $scope.gradeUserList = []; //列表数据
            $scope.rzfsList = [];//任职方式
            $scope.zwmcList = [];//职务名称
            $scope.zwjbList = [];//职务级别
            $scope.bzjcList = [];//班子届次
            $scope.zzjzqkList = [];
            $scope.isDetail = true;

            $scope.pageInfo = {ptotal: 0};
            //监视页数变化
            $scope.$watch("selectUserParams.pageindex", function (newVal, oldVal) {
                if ($scope.pageInfo.ptotal > 0) {
                    $scope.loadGradeUserList();
                }
            });

            //查询
            $scope.searchGradeUser = function () {
                $scope.loadGradeUserList();
            };

            //加载列表数据
            $scope.loadGradeUserList = function () {
                $http
                ({
                    method: 'get', url: '../../api/grade/getGradeUserList', params: $scope.selectUserParams
                }).then(function (result) {
                    $scope.gradeUserList = result.data.item.list;
                    $scope.pageInfo.ptotal = result.data.item.total;
                });
            };

            var editGradeUserCtrl = function ($scope, $http) {
                $scope.params = gradeUserModal.params;
                $scope.uservm = gradeUserModal.uservm;
                $scope.party = gradeUserModal.party;

                $scope.selectUserlist = {
                    url: '../../api/partyUser/getPartyUserList',
                    title: '人员选择',
                    isMulti: false,
                    selectData: {xm: '姓名', szdzb: '所在组织架构'},
                    columns: {XM: '姓名', XBMC: '性别', JG: '籍贯', DZZMC: '所在组织架构'},
                    selectLabelKey: 'XM',
                    selectValuekey: 'RYJBXXBS',
                    selectedValueData: '',
                    selectedLabeData: '',
                    selectedJData: [],
                    selectParams: {
                        dzzdm: $scope.party.dzzdm
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
                            $scope.uservm.xm = result.data.item.list[0].XM;
                            $scope.uservm.rybm = result.data.item.list[0].RYBM;
                        }, function (resp) {
                            $loading.hide();
                            $scope.showMsg('错误', '服务器错误');
                        });
                    }
                });

                $scope.submitGradeUser = function (isflag) {
                    if (isflag) {
                        $loading.show();
                        $http({
                            method: "post",
                            url: "../../api/grade/saveGradeUser",
                            data: $scope.uservm
                        }).then(function (result) {
                            $loading.hide();
                            $scope.showMsg('成功', result.data.msg);
                            //重新刷新列表
                            $scope.loadGradeUserList();
                            $scope.$hide();

                        }), function (resp) {
                            $scope.showMsg('错误', '服务器错误');
                        }
                    }
                };

                $scope.getBzjcList($scope.partyModel.dzzdm);
            };
            editGradeUserCtrl.$inject = ['$scope', '$http'];
            //定义模态框
            var gradeUserModal = $modal({
                resolve: {
                    load: ['$ocLazyLoad', function ($ocLazyLoad) {
                        //return [$ocLazyLoad.load('../main/gradeUser/edit.css')];
                    }]
                },
                scope: $scope,
                controller: editGradeUserCtrl,
                templateUrl: '../main/party/edit_GradeUserInfo.html',
                show: false,
                animation: 'am-fade-and-slide-top'
            });
            //新增编辑班子届次成员信息
            $scope.addGradeUser = function () {
                if (!$scope.isSave) {
                    $scope.showMsg('失败', "请先保存党组织信息");
                    return false;
                }

                $scope.isDetail = true;
                var title = "";
                if ($scope.partyFBModel.zzlb == "100" || $scope.partyFBModel.zzlb == "200") {
                    title = "新增领导班子";
                } else {
                    title = "新增支委班子";
                }
                $scope.showGradeUserModal("", title);
            };
            $scope.editGradeUser = function (id) {
                $scope.isDetail = true;
                var title = "";
                if ($scope.partyFBModel.zzlb == "100" || $scope.partyFBModel.zzlb == "200") {
                    title = "编辑领导班子";
                } else {
                    title = "编辑支委班子";
                }
                $scope.showGradeUserModal(id, title)
            }
            $scope.detailGradeUser = function (id) {
                $scope.isDetail = false;
                var title = "";
                if ($scope.partyFBModel.zzlb == "100" || $scope.partyFBModel.zzlb == "200") {
                    title = "领导班子详情";
                } else {
                    title = "支委班子详情";
                }
                $scope.showGradeUserModal(id, title);
            }
            $scope.showGradeUserModal = function (id, title) {
                gradeUserModal.params = {
                    title: title,
                    op: id == "" ? 1 : 2
                };
                $loading.show();
                $http.get("../../api/grade/getGradeUserByID", {
                    params: {
                        'id': id,
                        'dzzdm': $scope.selectUserParams.ssdzzdm
                    }
                }).then(function (result) {
                    $loading.hide();
                    gradeUserModal.uservm = result.data.item;
                    gradeUserModal.party = result.data.extdata.party;
                    gradeUserModal.$promise.then(gradeUserModal.show);
                }, function () {
                    $scope.showMsg('错误', '服务器错误');
                });
            };

            $scope.deleteGradeUser = function (id) {
                if (confirm("是否确定删除？")) {
                    $http({
                        url: "../../api/grade/deleteGradeUserById",
                        method: 'GET',
                        params: {id: id}
                    }).then(function (result) {
                        $scope.showMsg("消息", result.data.msg);
                        if (result.data.success) {
                            $scope.loadGradeUserList();
                        }
                    });
                }
            };

            //任职方式
            $scope.getRzfsList = function () {
                $http({
                    method: 'get',
                    url: '../../api/partyDic/getRzfsList',
                    params: {}
                }).then(function (result) {
                    $scope.rzfsList = result.data;
                }, function (resp) {
                });
            };
            //党内职务
            $scope.getZwmcList = function () {
                $http({
                    method: 'get',
                    url: '../../api/partyDic/getZwmcList',
                    params: {}
                }).then(function (result) {
                    $scope.zwmcList = result.data;
                }, function (resp) {
                });
            };
            //职务级别
            $scope.getZwjbList = function () {
                $http({
                    method: 'get',
                    url: '../../api/partyDic/getdzzwjbmList',
                    params: {}
                }).then(function (result) {
                    $scope.zwjbList = result.data;
                }, function (resp) {
                });
            };
            //班子届次
            $scope.getBzjcList = function (dzzdm) {
                if (dzzdm != '' && dzzdm != null) {
                    $http({
                        method: 'get',
                        url: '../../api/grade/getGradeListByDzzdm',
                        params: {
                            dzzdm: dzzdm
                        }
                    }).then(function (result) {
                        $scope.bzjcList = result.data;
                    }, function (resp) {
                    });
                }
            };

            //专职兼职情况
            $scope.getZzjzqkList = function () {
                $http({
                    method: 'get',
                    url: '../../api/partyDic/getZzjzqkList',
                    params: {}
                }).then(function (result) {
                    $scope.zzjzqkList = result.data;
                }, function (resp) {
                });
            };

            //数据初始化
            $scope.getRzfsList();
            $scope.getZwmcList();
            $scope.getZwjbList();
            $scope.getZzjzqkList();
        }

        //数据初始化
        $scope.loadPartyInfo();

        $scope.pagechange = function () {
            var inTab = $bsRouterState.$getRouteType() == 'tab';
            if (inTab) {
                $bsRouterState.$closeTab($scope);
            } else {
                window.history.back();
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