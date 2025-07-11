(function ($app) {
    $app.module('gtPartyApp').controller('cgjqSetting_PostareaListCtrl', function ($scope, $http, $modal, $ocLazyLoad, $alert, $loading, $state, $stateParams, AuthUser, $bsRouterState, $timeout) {
        $state.params = $bsRouterState.$params($scope);
        //定义数据集合
        $scope.pageList = [
            {id: 1, title: '责任岗', url: '../main/cgjq/setting/postarea/post.html'},
            {id: 2, title: '责任区', url: '../main/cgjq/setting/postarea/area.html'}];
        $scope.activeTab = 1;
        $scope.loginUserId = AuthUser.getUser().Id;
        $scope.selectparams = {
            isunfold: false,//组织结构树展开收缩
            selectdzzdm: '',
            selectdzzmc: '',
            zzfbType: null
        };
        //责任岗
        $scope.post_dataList = []; //列表数据
        $scope.post_selectparams = {
            pageindex: 1,
            pagesize: 10,
            cgjqType: 1,
            partyCode: '',//党组织代码
            userId: AuthUser.getUser().Id,
            name: '',
            headUserName: '',
            zzfbType: null
        };
        $scope.post_resetparams = {
            pageindex: 1,
            pagesize: 10,
            cgjqType: 1,
            partyCode: '',//党组织代码
            userId: AuthUser.getUser().Id,
            name: '',
            headUserName: '',
            zzfbType: null
        };
        $scope.post_pageInfo = {ptotal: 0};
        //责任区
        $scope.area_dataList = []; //列表数据
        $scope.area_selectparams = {
            pageindex: 1,
            pagesize: 10,
            cgjqType: 2,
            partyCode: '',//党组织代码
            userId: AuthUser.getUser().Id,
            name: '',
            headUserName: '',
            zzfbType: null
        };
        $scope.area_resetparams = {
            pageindex: 1,
            pagesize: 10,
            cgjqType: 2,
            partyCode: '',//党组织代码
            userId: AuthUser.getUser().Id,
            name: '',
            headUserName: '',
            zzfbType: null
        };
        $scope.area_pageInfo = {ptotal: 0};
        $scope.isShow = false;
        $scope.moreTxt = "更多";


        //选择tab页
        $scope.selectTab = function (setTab) {
            $scope.activeTab = setTab;
            $scope.loadData($scope.activeTab);
        };
        //判断选中项
        $scope.isSelected = function (checkedTab) {
            return $scope.activeTab === checkedTab;

        };
        //监视页数变化
        $scope.$watch("post_selectparams.pageindex", function (newVal, oldVal) {
            if ($scope.post_pageInfo.ptotal > 0) {
                $scope.loadData(1);
            }
        });
        $scope.$watch("area_selectparams.pageindex", function (newVal, oldVal) {
            if ($scope.post_pageInfo.ptotal > 0) {
                $scope.loadData(2);
            }
        });
        $scope.$watch("selectparams.selectdzzdm", function (newVal, oldVal) {
            if (newVal != "") {
                $scope.post_selectparams.partyCode = $scope.selectparams.selectdzzdm;
                $scope.area_selectparams.partyCode = $scope.selectparams.selectdzzdm;
                $scope.loadData(1);
                $scope.loadData(2);
            }
        });

        $scope.$watch("selectparams.zzfbType", function (newVal, oldVal) {
            if (newVal != oldVal) {
                $scope.post_selectparams.zzfbType = $scope.selectparams.zzfbType;
                $scope.area_selectparams.zzfbType = $scope.selectparams.zzfbType;
                $scope.loadData(1);
                $scope.loadData(2);
            }
        });

        //查询
        $scope.search = function (cgjqType) {
            $scope.loadData(cgjqType);
        };

        //加载列表数据
        $scope.loadData = function (cgjqType) {
            var params = [];
            if (cgjqType == 1) {
                params = $scope.post_selectparams;
            } else {
                params = $scope.area_selectparams;
            }
            $http
            ({
                method: 'get', url: '../../api/cgjq/getSettingPostareaList', params: params
            }).then(function (result) {
                if (cgjqType == 1) {
                    $scope.post_dataList = result.data.item.list;
                    $scope.post_pageInfo.ptotal = result.data.item.total;
                } else {
                    $scope.area_dataList = result.data.item.list;
                    $scope.area_pageInfo.ptotal = result.data.item.total;
                }

            });
        };

        //新增
        $scope.addData = function (cgjqType) {
            //判断当前选择的组织是否为支部
            $scope.edit("", cgjqType, cgjqType == 1 ? "新增责任岗" : "新增责任区");
        };
        //修改
        $scope.editData = function (id, cgjqType) {
            $scope.edit(id, cgjqType, cgjqType == 1 ? "修改责任岗" : "修改责任区",true);
        };
        //删除
        $scope.deleteData = function (id, cgjqType) {
            if (confirm("是否确定删除？")) {
                $http({
                    url: "../../api/cgjq/deletePostareaById",
                    method: 'GET',
                    params: {id: id}
                }).then(function (result) {
                    $scope.showMsg("消息", result.data.msg);
                    if (result.data.success) {
                        $scope.loadData(cgjqType);
                    }
                });
            }
        };

        //编辑模块
        var editCtrl = function ($scope, $http) {
            $scope.params = postAreaModal.params;
            $scope.dataModel = postAreaModal.dataModel;
            $scope.userList = [];
            $scope.selectusertype = 1;
            $scope.removeUsers = "";

            //保存
            $scope.submitData = function (isflag) {
                if (isflag) {
                    var userList = [];
                    angular.forEach($scope.userList, function (val, key) {
                        userList.push({
                            xm: val.XM,
                            rybm: val.RYBM,
                            xb: val.XB,
                            mobile: val.MOBILE,
                            dutyusertype: (val.RYBM != "" && val.RYBM != null) ? 1 : 2,
                            post: val.POST
                        });
                    });
                    $loading.show();
                    $http({
                        method: "post",
                        url: "../../api/cgjq/savePostarea",
                        data: {
                            dataModel: $scope.dataModel,
                            userList: JSON.stringify(userList)
                        }
                    }).then(function (result) {
                        $loading.hide();
                        if (result.data.success) {
                            $scope.showMsg('成功', result.data.msg);
                            //重新刷新列表
                            $scope.loadData($scope.dataModel.cgjqtype);
                            $scope.$hide();
                        } else {
                            $scope.showMsg('失败', result.data.msg);
                        }

                    }, function (resp) {
                        $loading.hide();
                        $scope.showMsg('错误', '服务器错误');
                    })
                }
            };
            $scope.selectUser = function (type) {
                $scope.selectusertype = type;
                $scope.selectUserlist.isMulti = type == 1 ? false : true;
                $scope.selectUserlist.selectParams.removeUsers = type == 1 ? "" : $scope.removeUsers;
            };
            $scope.deleteUser = function (index) {
                $scope.userList.splice(index, 1);
            };
            $scope.addUser = function () {
                $scope.userList.push({XM: "", RYBM: "", XB: "", MOBILE: ""});
            };

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
                    ryzt: '2,3',
                    dzzdm: $scope.selectparams.selectdzzdm
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
                        if (result.data.item.list.length > 0) {
                            if ($scope.selectusertype == 1) {
                                var user = result.data.item.list[0];
                                $scope.dataModel.headuserid = user.RYBM;
                                $scope.dataModel.headusername = user.XM;
                            } else {
                                $scope.userList = $scope.userList.concat(result.data.item.list);
                            }
                            $scope.selectUserlist.selectedValueData = "";
                            $scope.selectUserlist.selectedLabeData = "";
                        }
                    }, function (resp) {
                        $scope.showMsg('错误', '服务器错误');
                    });
                }
            });
            $scope.$watch('userList', function (newVal) {
                $scope.setRemoveUser();
            }, true);
            $scope.setRemoveUser = function () {
                $scope.removeUsers = "";
                angular.forEach($scope.userList, function (val, index) {
                    if (val.RYJBXXBS != "" && val.RYJBXXBS != null) {
                        $scope.removeUsers += val.RYJBXXBS + ',';
                    }
                });
            };

            $scope.getUserList = function () {
                $http
                ({
                    method: 'get',
                    url: '../../api/cgjq/getSettingPostareaUserList',
                    params: {pageindex: 1, pagesize: 10000, seetingPostareaId: $scope.dataModel.seetingpostareaid}
                }).then(function (result) {
                    $scope.userList = result.data.item.list;
                });
            };
            $scope.getUserList();

            //列表数据必填
            $scope.invalidFee = function (index, form1, name) {
                name = name + "_" + index;
                eval('var i=form1.' + name + '.$invalid');
                return i;
            };

        };
        editCtrl.$inject = ['$scope', '$http'];
        //定义模态框
        var postAreaModal = $modal({
            resolve: {
                load: ['$ocLazyLoad', function ($ocLazyLoad) {
                }]
            },
            scope: $scope,
            controller: editCtrl,
            templateUrl: '../main/cgjq/setting/postarea/edit.html',
            show: false,
            animation: 'am-fade-and-slide-top'
        });
        //编辑岗区信息
        $scope.edit = function (id, cgjqType, title,isUpdate) {
            postAreaModal.params = {
                title: title,
                isUpdate:isUpdate
            };
            $loading.show();
            $http.get("../../api/cgjq/getPostareaById", {
                params: {
                    'id': id,
                    cgjqType: cgjqType,
                    dzzdm: $scope.selectparams.selectdzzdm
                }
            }).then(function (result) {
                $loading.hide();
                if (result.data.success) {
                    postAreaModal.dataModel = result.data.item;
                    postAreaModal.$promise.then(postAreaModal.show);
                } else {
                    $scope.showMsg('错误', result.data.msg);
                }
            }, function () {
                $loading.hide();
                $scope.showMsg('错误', '服务器错误');
            });
        };


        //新增责任岗
        {
            //编辑模块
            var addPostCtrl = function ($scope, $http) {
                $scope.params = addPostModal.params;
                $scope.dataModel = addPostModal.dataModel;
                $scope.userList = [];

                //保存
                $scope.submitData = function (isflag) {
                    if (isflag) {
                        var userList = [];
                        angular.forEach($scope.userList, function (val, key) {
                            userList.push({
                                xm: val.XM,
                                rybm: val.RYBM
                            });
                        });
                        $loading.show();
                        $http({
                            method: "post",
                            url: "../../api/cgjq/addPost",
                            data: {
                                dataModel: $scope.dataModel,
                                userList: JSON.stringify(userList)
                            }
                        }).then(function (result) {
                            $loading.hide();
                            if (result.data.success) {
                                $scope.showMsg('成功', result.data.msg);
                                //重新刷新列表
                                $scope.loadData($scope.dataModel.cgjqtype);
                                $scope.$hide();
                            } else {
                                $scope.showMsg('失败', result.data.msg);
                            }

                        }, function (resp) {
                            $loading.hide();
                            $scope.showMsg('错误', '服务器错误');
                        })
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
                        ryzt: '2,3',
                        dzzdm: $scope.selectparams.selectdzzdm
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
                            if (result.data.item.list.length > 0) {
                                $scope.userList = result.data.item.list;
                            } else {
                                $scope.selectUserlist.selectedValueData = "";
                                $scope.selectUserlist.selectedLabeData = "";
                            }
                        }, function (resp) {
                            $scope.showMsg('错误', '服务器错误');
                        });
                    }
                });

            };
            addPostCtrl.$inject = ['$scope', '$http'];
            //定义模态框
            var addPostModal = $modal({
                resolve: {
                    load: ['$ocLazyLoad', function ($ocLazyLoad) {
                    }]
                },
                scope: $scope,
                controller: addPostCtrl,
                templateUrl: '../main/cgjq/setting/postarea/addPost.html',
                show: false,
                animation: 'am-fade-and-slide-top'
            });

            $scope.addPost = function () {
                addPostModal.params = {
                    title: "新增责任岗"
                };
                $loading.show();
                $http.get("../../api/cgjq/getPostareaById", {
                    params: {
                        'id': "",
                        cgjqType: 1,
                        dzzdm: $scope.selectparams.selectdzzdm
                    }
                }).then(function (result) {
                    $loading.hide();
                    if (result.data.success) {
                        addPostModal.dataModel = result.data.item;
                        addPostModal.$promise.then(addPostModal.show);
                    } else {
                        $scope.showMsg('错误', result.data.msg);
                    }
                }, function () {
                    $loading.hide();
                    $scope.showMsg('错误', '服务器错误');
                });
            };
        }

        $scope.cgjqSettingProject = function (cgjqType) {
            $bsRouterState.$closeTabName("home.cgjqSetting_ProjectList2");
            $timeout(function () {
                $bsRouterState.go('home.cgjqSetting_ProjectList2', {type: 2, cgjqType: cgjqType});
            }, 100);
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

        $scope.isShowClick = function () {
            $scope.isShow = !$scope.isShow;
            if ($scope.moreTxt == "更多") {
                $scope.moreTxt = "收起";
            } else if ($scope.moreTxt == "收起") {
                $scope.moreTxt = "更多";
            }
        };
        $scope.setisunfold = function () {
            $scope.selectparams.isunfold = !$scope.selectparams.isunfold;
            $scope.$emit('menudatas.toggle', !$scope.selectparams.isunfold);
        };
        $scope.reset = function () {
            // var $form = $scope.myform;
            // var $names = $form.$$controls;
            // angular.forEach($names, function (val) {
            //     val
            // });
            // $scope.myform.$setPristine();
            // $scope.myform.$setUntouched();
            //$scope.selectparams.selectdzzdm = $scope.resetparams.selectdzzdm;
            //$scope.selectparams.selectdzzmc = $scope.resetparams.selectdzzmc;
            //$scope.selectparams.defaultselected = $scope.resetparams.defaultselected;
            //$scope.selectparams.parentname = $scope.resetparams.parentname;
            //$scope.selectparams.szdzzdm = $scope.resetparams.szdzzdm;
            //$scope.selectparams.szdzzmc = $scope.resetparams.szdzzmc;
            $scope.area_selectparams.name = $scope.area_resetparams.name;
            $scope.area_selectparams.headUserName = $scope.area_resetparams.headUserName;
            $scope.post_selectparams.name = $scope.post_resetparams.name;
            $scope.post_selectparams.headUserName = $scope.post_resetparams.headUserName;
            // $scope.selectparams.jldzzrq_begin = $scope.resetparams.jldzzrq_begin;
            // $scope.selectparams.jldzzrq_end = $scope.resetparams.jldzzrq_end;
            // $scope.selectparams.isContainParent = $scope.resetparams.isContainParent;
            // $scope.selectparams.zzfbType = $scope.resetparams.zzfbType;
            //$scope.selectparams.selectdzzmc = $scope.selectparams.dzzmc = $scope.selectparams.zzlb = $scope.selectparams.jczzfl = '';
        }

    });
})(angular);