(function ($app) {
    $app.module('gtPartyApp').controller('programmeEditCtrl', function ($scope, $http, $modal, $ocLazyLoad, $alert, $loading, $state, $partySelect, $stateParams, AuthUser, $filter, $bsRouterState) {
        //console.log(AuthUser.getUser());

        $stateParams = $bsRouterState.$params($scope);
        $scope.isAdd = !$stateParams.id;

        $scope.changevm = {};
        $scope.sendDepartmentName = '';
        $scope.receiveDepartmentId = '';
        $scope.vipUserIds = '';
        $scope.vipUserNames = '';
        $scope.upstepUsers = [];
        $scope.changevm2 = {};
        $scope.changevm3 = {};
        $scope.receiveDWs3 = [];
        $scope.stepList3 = [];
        $scope.changevm4 = {};
        $scope.prog1 = true;
        $scope.prog2 = false;
        $scope.prog3 = false;
        $scope.prog4 = false;
        $scope.mod1 = 'mod';
        $scope.mod2 = '';
        $scope.mod3 = '';
        $scope.mod4 = '';
        $scope.reqFileModel = {
            selectdata: {FileRefID: '', pageindex: 1, pagesize: 10, ptotal: 0,filetypecode:'LearningMaterialType'},//查询参数：FileRefID为文件关联ID
            filetype: 1,//文件类型
            items: [],//列表数据地址
            readonly: false,//是否只能查看
            title: '学习资料上传',
            addFileButton: '上传',
            filetypecode:'LearningMaterialType'
        };

        $scope.selectparams_GradeUser = {
            'pageindex': 1,
            'pagesize': 999,
            'dzzdm': $scope.receiveDepartmentId,
            ssdzzdm: ''
        };

        $scope.selectUserlist = {
            url: "../../api/partyUser/getPartyUserList",
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
                dzzdm: $scope.changevm.dwId || '请选择',
                removeUsers: '',
                //szdzbdm: $scope.dataModel.shyktype == 2 ? $scope.dataModel.partycode : '',
                ryzt: '2,3' //预备党员，正式党员
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
                        pagesize: 10000
                    }
                }).then(function (result) {
                    $loading.hide();
                    result.data.item.list.forEach(item => {
                        if ($scope.upstepUsers.filter(it => it.RYBM == item.RYBM).length <= 0) {
                            $scope.upstepUsers.push({
                                RYBM: item.RYBM,
                                XM: item.XM,
                                ZWMCMC: item.DNZW
                            });
                        }
                    });

                    $scope.setSelectUser();

                }, function (resp) {
                    $loading.hide();
                    $scope.showMsg('错误', '服务器错误');
                });
            }
        });
        $scope.deleteUser = function (index) {
            $scope.upstepUsers.splice(index, 1);

            $scope.setSelectUser();
        };

        $scope.loadXXJH = function () {
            $http.get("../../api/dictionary/GetDictionaryList", {
                params: {
                    'dicTypeKey': 'zxzxxxxfaqxyy'
                }
            }).then(function (result2) {
                $scope.stepList3 = result2.data.item.list;
            }, function () {
                $scope.showMsg('错误', '服务器错误');
            });
            $scope.chkchildrenReceiveDWs3 = function (time, index) {
                if (time.checked) {
                    $scope.receiveDWs3[index].absent = '1';
                } else {
                    $scope.receiveDWs3[index].absent = '0';
                }
            };
            $scope.chkchildrenStepList3 = function (time, index) {
                $scope.receiveDWs3[index].absentReasonCode = time;
                for (var i = 0; i < $scope.stepList3.length; i++) {
                    if ($scope.receiveDWs3[index].absentReasonCode == $scope.stepList3[i].val) {
                        $scope.receiveDWs3[index].absentReason = $scope.stepList3[i].label;
                    }
                }
            };
            $http.get("../../api/dictionary/GetDictionaryList", {
                params: {
                    'dicTypeKey': 'zxzxxxxfaxxxs'
                }
            }).then(function (result1) {
                $scope.studyModalityList = result1.data.item.list;
                if ($stateParams.id == undefined || $stateParams.id == '') {
                    $scope.changevmStudyModalityCode = $scope.studyModalityList[0];
                }
                if ($stateParams.id == undefined || $stateParams.id == '')
                    return;
                $http.get("../../api/zxzxx/xxfa/get", {
                    params: {
                        'id': $stateParams.id
                    }
                }).then(function (result) {
                    //$scope.changevm = result.data.item;
                    $scope.yekafanwei(result.data.item.zzZxzxxFaModel.caseStep);
                    $scope.selectvipUserlist.selectParams.ssdzzdm = $scope.selectparams_GradeUser.ssdzzdm = $scope.receiveDepartmentId = result.data.item.zzZxzxxFaModel.dwId;
                    $scope.selecthostUserlist.selectParams.ssdzzdm = $scope.selectsupplementUserlist.selectParams.ssdzzdm = result.data.item.zzZxzxxFaModel.dwId;
                    $scope.sendDepartmentName = result.data.item.zzZxzxxFaModel.dwName;
                    $scope.changevm = {
                        id: $stateParams.id,
                        planId: result.data.item.zzZxzxxFaModel.planId,
                        planName: result.data.item.zzZxzxxFaModel.planName,
                        caseName: result.data.item.zzZxzxxFaModel.caseName,
                        studyStartTime: result.data.item.zzZxzxxFaModel.studyStartTime,
                        studyAddress: result.data.item.zzZxzxxFaModel.studyAddress,
                        studyModalityCode: result.data.item.zzZxzxxFaModel.studyModalityCode,
                        studyContent: result.data.item.zzZxzxxFaModel.studyContent,
                        expandScope: result.data.item.zzZxzxxFaModel.expandScope,
                        hostUserId: result.data.item.zzZxzxxFaModel.hostUserId,
                        hostUserName: result.data.item.zzZxzxxFaModel.hostUserName,
                    }
                    for (var i = 0; i < $scope.studyModalityList.length; i++) {
                        if ($scope.changevm.studyModalityCode == $scope.studyModalityList[i].val) {
                            $scope.changevmStudyModalityCode = $scope.studyModalityList[i];
                        }
                    }

                    var vipUsers = {
                        spokesmanId: [],
                        spokesmanName: []
                    };
                    console.log(result.data.item.vipUsersmodel)
                    for (var i = 0; i < result.data.item.vipUsersmodel.length; i++) {
                        if (result.data.item.vipUsersmodel[i].vip == 1) {
                            vipUsers.spokesmanId.push(result.data.item.vipUsersmodel[i].spokesmanId);
                            vipUsers.spokesmanName.push(result.data.item.vipUsersmodel[i].spokesmanName);
                        }
                    }
                    console.log("111")
                    $scope.selectvipUserlist.selectedValueData = vipUsers.spokesmanId.join(",");
                    $scope.selectvipUserlist.selectedLabeData = vipUsers.spokesmanName.join(",");
                    var supplementUsers = {
                        spokesmanId: [],
                        spokesmanName: []
                    };
                    for (var i = 0; i < result.data.item.vipUsersmodel.length; i++) {
                        if (result.data.item.vipUsersmodel[i].vip == 2) {
                            supplementUsers.spokesmanId.push(result.data.item.vipUsersmodel[i].spokesmanId);
                            supplementUsers.spokesmanName.push(result.data.item.vipUsersmodel[i].spokesmanName);
                        }
                    }
                    $scope.selectsupplementUserlist.selectedValueData = supplementUsers.spokesmanId.join(",");
                    $scope.selectsupplementUserlist.selectedLabeData = supplementUsers.spokesmanName.join(",");
                    $scope.selecthostUserlist.selectedValueData = result.data.item.zzZxzxxFaModel.hostUserId;
                    $scope.selecthostUserlist.selectedLabeData = result.data.item.zzZxzxxFaModel.hostUserName;
                    $scope.changevm2 = {
                        id: $stateParams.id,
                        examineTime: result.data.item.zzZxzxxFaModel.examineTime,
                        opinion: result.data.item.zzZxzxxFaModel.opinion
                    }
                    $scope.changevm3.id = $stateParams.id;
                    $scope.receiveDWs3 = result.data.item.upstepUsers;
                    for (var i = 0; i < $scope.receiveDWs3.length; i++) {
                        if ($scope.receiveDWs3[i].absent == 1) {
                            $scope.receiveDWs3[i].checked = true;
                        } else {
                            $scope.receiveDWs3[i].checked = false;
                        }
                    }


                    $scope.changevm4.id = $stateParams.id;
                    $scope.changevm4.summary = result.data.item.zzZxzxxFaModel.summary;
                    $scope.reqFileModel.selectdata.FileRefID = $scope.changevm4.id;
                    $scope.loadData();
                    $scope.selectUserlist.selectParams.dzzdm = $scope.changevm.dwId;
                    $scope.selecthostUserlist.selectParams.dzzdm = $scope.changevm.dwId;
                    $scope.selectvipUserlist.selectParams.dzzdm = $scope.changevm.dwId;
                    $scope.selectsupplementUserlist.selectParams.dzzdm = $scope.changevm.dwId;
                }, function () {
                    $scope.showMsg('错误', '服务器错误');
                });
            }, function () {
                $scope.showMsg('错误', '服务器错误');
            });
        }
        //加载数据
        $scope.loadData = function () {
            /*$http
            ({
                method: 'get', url: '../../api/grade/getMaxGradeUserList', params: $scope.selectparams_GradeUser
            }).then(function (result) {
                $scope.upstepUsers = result.data.item.list;

                $scope.setSelectUser();
            }, function () {
                $scope.showMsg('错误', '服务器错误');
            });*/
            if ($scope.receiveDWs3.length > 0) {
                $http
                ({
                    method: 'get',
                    url: '../../api/partyUser/getPartyUserList',
                    params: {
                        pageindex: 1,
                        pagesize: 10000,
                        rybm_list: $scope.receiveDWs3.map(it => it.leaderUserId).join(",")
                    }
                }).then(function (result) {
                    $scope.upstepUsers = result.data.item.list;

                    $scope.setSelectUser();
                }, function () {
                    $scope.showMsg('错误', '服务器错误');
                });
            }
        };
        //保存
        //isflag：表单验证结果，shykStatus：下一环节状态
        $scope.submitData = function (isflag) {
            if (isflag) {
                $scope.changevm.studyModalityCode = $scope.changevmStudyModalityCode.val;
                //日期格式化
                if (typeof $scope.changevm.studyStartTime == "object") {
                    //$scope.changevm.studyStartTime = $scope.changevm.studyStartTime.toLocaleDateString();
                    $scope.changevm.studyStartTime = $filter('date')($scope.changevm.studyStartTime, 'yyyy/MM/dd HH:mm:ss');
                }
                //console.log($scope.changevm.hostUserId + ":" + $scope.changevm.hostUserName);
                $scope.changevm.hostUserId = $scope.selecthostUserlist.selectedValueData;
                $scope.changevm.hostUserName = $scope.selecthostUserlist.selectedLabeData;

                var userList = [];
                $scope.upstepUsers.forEach(it=>{
                    userList.push({leaderUserId:it.RYBM,leaderUserName:it.XM,post:it.ZWMC});
                });

                var mydata = {
                    xxfa: $scope.changevm,
                    userList:JSON.stringify(userList),
                    vipUserIds: $scope.selectvipUserlist.selectedValueData,
                    supplementUserIds: $scope.selectsupplementUserlist.selectedValueData
                }
                $loading.show();
                $http({
                    method: "post",
                    url: "../../api/zxzxx/xxfa/edit",
                    data: mydata
                }).then(function (result) {
                    $loading.hide();
                    $scope.showMsg('成功', result.data.msg);
                    $scope.changevm.id = result.data.item;
                    $scope.changevm2.id = result.data.item;
                    $scope.changevm3.id = result.data.item;
                    $scope.changevm4.id = result.data.item;
                    $scope.yekafanwei(2);

                    $scope.$emit("tabReloadData", {name: 'programmeListCtrl', data: 1});
                }), function (resp) {
                    $scope.showMsg('错误', '服务器错误');
                }
            } else {
                $alert({title: '提示：', content: '请填写相关信息', placement: 'top', type: 'info', show: true, duration: 2});
            }
        };
        $scope.submitData2 = function (isflag) {
            if (isflag) {
                if (typeof $scope.changevm2.examineTime == "object") {
                    //$scope.changevm2.examineTime = $scope.changevm2.examineTime.toLocaleDateString();
                    $scope.changevm2.examineTime = $filter('date')($scope.changevm2.examineTime, 'yyyy/MM/dd HH:mm:ss');
                }
                var mydata = {
                    xxfa: $scope.changevm2
                }
                $loading.show();
                $http({
                    method: "post",
                    url: "../../api/zxzxx/xxfa/examine",
                    data: mydata
                }).then(function (result) {
                    $http.get("../../api/zxzxx/xxfa/get", {
                        params: {
                            'id': $scope.changevm2.id
                        }
                    }).then(function (result) {
                        $scope.receiveDWs3 = result.data.item.upstepUsers;
                        for (var i = 0; i < $scope.receiveDWs3.length; i++) {
                            if ($scope.receiveDWs3[i].absent == 1) {
                                $scope.receiveDWs3[i].checked = true;
                            } else {
                                $scope.receiveDWs3[i].checked = false;
                            }
                        }
                        $loading.hide();
                        $scope.showMsg('成功', result.data.msg);
                        $scope.yekafanwei(3);
                    }, function () {
                        $scope.showMsg('错误', '服务器错误');
                    });

                    $scope.$emit("tabReloadData", {name: 'programmeListCtrl', data: 1});
                }), function (resp) {
                    $scope.showMsg('错误', '服务器错误');
                }
            } else {
                $alert({title: '提示：', content: '请填写相关信息', placement: 'top', type: 'info', show: true, duration: 2});
            }
        };
        $scope.submitData3 = function (isflag) {
            if (isflag) {
                var mydata = {
                    xxfa: $scope.changevm3,
                    attendDetail: $scope.receiveDWs3
                }
                $loading.show();
                $http({
                    method: "post",
                    url: "../../api/zxzxx/xxfa/attend",
                    data: mydata
                }).then(function (result) {
                    $loading.hide();
                    $scope.showMsg('成功', result.data.msg);
                    $scope.yekafanwei(4);
                    $scope.reqFileModel.selectdata.FileRefID = $scope.changevm3.id;

                    $scope.$emit("tabReloadData", {name: 'programmeListCtrl', data: 1});
                }), function (resp) {
                    $scope.showMsg('错误', '服务器错误');
                }
            } else {
                $alert({title: '提示：', content: '请填写正确信息', placement: 'top', type: 'info', show: true, duration: 2});
            }
        };

        $scope.randomId = function () {
            var d = new Date().getTime();
            var uuid = 'xxxxxxxx-xxxx-4xxx-yxxx-xxxxxxxxxxxx'.replace(/[xy]/g, function (c) {
                var r = (d + Math.random() * 16) % 16 | 0;
                d = Math.floor(d / 16);
                return (c == 'x' ? r : (r & 0x7 | 0x8)).toString(16);
            });
            return uuid;
        }

        $scope.submitData4 = function (isflag) {
            if (isflag) {
                if (confirm("请确认方案是否已录入完成，提交后将无法修改！")) {
                    var mydata = $scope.changevm4;
                    $loading.show();
                    $http({
                        method: "post",
                        url: "../../api/zxzxx/xxfa/accept",
                        data: mydata
                    }).then(function (result) {
                        angular.forEach($scope.reqFileModel.items, function (file, index) {
                            $http
                            ({
                                method: 'get',
                                url: '../../api/zxzxx/xxzl/insert',
                                params: {
                                    id: $scope.randomId(),
                                    fileId: file.fileid,
                                    docType: '学习成果',
                                    dzzdm: $scope.receiveDepartmentId
                                }
                            }).then(function (result) {
                            }), function (resp) {
                                $scope.showMsg('错误', '服务器错误');
                            }
                        });
                        $loading.hide();
                        $scope.showMsg('成功', result.data.msg);
                        $scope.pagechange();

                        $scope.$emit("tabReloadData", {name: 'programmeListCtrl', data: 1});
                    }), function (resp) {
                        $scope.showMsg('错误', '服务器错误');
                    }
                }
            } else {
                $alert({title: '提示：', content: '请填写相关信息', placement: 'top', type: 'info', show: true, duration: 2});
            }
        };

        $scope.setSelectUser = function () {
            var rybmList = $scope.upstepUsers.map(it => it.RYBM).join(",");
            $scope.selecthostUserlist.selectParams.rybm_list = rybmList;
            $scope.selectvipUserlist.selectParams.rybm_list = rybmList;
            $scope.selectsupplementUserlist.selectParams.rybm_list = rybmList;
        };

        //选择计划
        var planChangeCtrl = function ($scope, $http) {
            $scope.params = planChangeModal.params;
            $scope.selectPlanList = planChangeModal.selectPlanList;
            $scope.receivePcomm = planChangeModal.receivePcomm;
        }
        planChangeCtrl.$inject = ['$scope', '$http'];
        //定义模态框
        var planChangeModal = $modal({
            resolve: {
                load: ['$ocLazyLoad', function ($ocLazyLoad) {
                }]
            },
            scope: $scope,
            controller: planChangeCtrl,
            templateUrl: '../main/centralGroup/programme/planList.html',
            show: false,
            animation: 'am-fade-and-slide-top'
        });

        $scope.xuanzePlan = function () {
            $scope.plan("选择计划");
        }

        $scope.plan = function (title) {
            planChangeModal.params = {
                title: title
            };
            planChangeModal.selectPlanList = {
                typeCode: null,
                name: '',
                publishTimeStart: '',
                publishTimeEnd: ''
            };
            $http.get("../../api/dictionary/GetDictionaryList", {
                params: {
                    'dicTypeKey': 'zxzxxjhlx'
                }
            }).then(function (result) {
                $scope.selectPlanListTypeCode = result.data.item.list;
            }, function () {
                $scope.showMsg('错误', '服务器错误');
            });
            planChangeModal.receivePcomm = [];
            planChangeModal.$promise.then(planChangeModal.show);
            $scope.ajaxChoose();
        };

        $scope.ajaxChoose = function () {
            $http.get("../../api/zxzxx/xxjh/choose", {
                params: {
                    pageindex: 1,
                    pagesize: 99999,
                    typeCode: planChangeModal.selectPlanList.typeCode,
                    name: planChangeModal.selectPlanList.name,
                    publishTimeStart: planChangeModal.selectPlanList.publishTimeStart,
                    publishTimeEnd: planChangeModal.selectPlanList.publishTimeEnd,
                    /*userId: AuthUser.getUser().Id,
                    roleId:AuthUser.getUser().curRoleId*/
                    dzzdm: AuthUser.getUser().DataDzzdm.length < AuthUser.getUser().generalPartyCode.length ? AuthUser.getUser().DataDzzdm : AuthUser.getUser().generalPartyCode
                }
            }).then(function (result) {
                var resultDataItemList = result.data.item.list;
                //console.log(resultDataItemList);
                //console.log($scope.changevm.userId)
                for (var i = 0; i < resultDataItemList.length; i++) {
                    if ($scope.changevm.planId != undefined) {
                        if ($scope.changevm.planId == resultDataItemList[i].id) {
                            resultDataItemList[i].checked = true;
                            planChangeModal.receivePcomm = resultDataItemList[i];
                        } else {
                            resultDataItemList[i].checked = false;
                        }
                    } else {
                        resultDataItemList[i].checked = false;
                    }
                }
                $scope.receivePcommListPlan = resultDataItemList;
            }, function () {
                $scope.showMsg('错误', '服务器错误');
            });
        };

        $scope.selectPlanListSelect = function () {
            $scope.ajaxChoose();
            //console.log('111');
        }

        $scope.chkchildrenPlan = function (item) {
            planChangeModal.receivePcomm = item;
        };

        $scope.quedingxuyaoPlan = function () {
            //console.log(planChangeModal.receivePcomm);
            $scope.sendDepartmentName = planChangeModal.receivePcomm.receiveDepartmentName;
            $scope.selectvipUserlist.selectParams.ssdzzdm = $scope.selectparams_GradeUser.ssdzzdm = $scope.receiveDepartmentId = planChangeModal.receivePcomm.receiveDepartmentId;
            $scope.selecthostUserlist.selectParams.ssdzzdm = $scope.selectsupplementUserlist.selectParams.ssdzzdm = planChangeModal.receivePcomm.receiveDepartmentId;
            $scope.changevm.planId = planChangeModal.receivePcomm.id;
            $scope.changevm.planName = planChangeModal.receivePcomm.name;
            planChangeModal.$promise.then(planChangeModal.hide);

            $scope.changevm.dwId = $scope.receiveDepartmentId;

            $scope.selectUserlist.selectParams.dzzdm = $scope.changevm.dwId;
            $scope.selecthostUserlist.selectParams.dzzdm = $scope.changevm.dwId;
            $scope.selectvipUserlist.selectParams.dzzdm = $scope.changevm.dwId;
            $scope.selectsupplementUserlist.selectParams.dzzdm = $scope.changevm.dwId;

            $scope.loadData();
        }

        $scope.selecthostUserlist = {
            //url: '../../api/grade/getMaxGradeUserList',
            url: "../../api/partyUser/getPartyUserList",
            title: '人员选择',
            isMulti: false,
            selectData: {xm: '姓名'},
            columns: {XM: '姓名', DZZMC: '所在党组织'},
            selectLabelKey: 'XM',
            selectValuekey: 'RYBM',
            selectedValueData: '',
            selectedLabeData: '',
            selectedJData: [],
            selectParams: {
                'pageindex': 1,
                'pagesize': 999,
                /*'dzzdm': $scope.receiveDepartmentId,
                ssdzzdm: AuthUser.getUser().DPCode*/
                dzzdm: $scope.changevm.dwId || '请选择',
                rybm_list: ''
            }
        };
        $scope.selectvipUserlist = {
            //url: '../../api/grade/getMaxGradeUserList',
            url: "../../api/partyUser/getPartyUserList",
            title: '人员选择',
            isMulti: true,
            selectData: {xm: '姓名'},
            columns: {XM: '姓名', DZZMC: '所在党组织'},
            selectLabelKey: 'XM',
            selectValuekey: 'RYBM',
            selectedValueData: '',
            selectedLabeData: '',
            selectedJData: [],
            selectParams: {
                'pageindex': 1,
                'pagesize': 999,
                /*'dzzdm': $scope.receiveDepartmentId,
                ssdzzdm: AuthUser.getUser().DPCode*/
                dzzdm: $scope.changevm.dwId || '请选择',
                rybm_list: ''
            }
        };
        $scope.selectsupplementUserlist = {
            //url: '../../api/grade/getMaxGradeUserList',
            url: "../../api/partyUser/getPartyUserList",
            title: '人员选择',
            isMulti: true,
            selectData: {xm: '姓名'},
            columns: {XM: '姓名', DZZMC: '所在党组织'},
            selectLabelKey: 'XM',
            selectValuekey: 'RYBM',
            selectedValueData: '',
            selectedLabeData: '',
            selectedJData: [],
            selectParams: {
                'pageindex': 1,
                'pagesize': 999,
                /*'dzzdm': $scope.receiveDepartmentId,
                ssdzzdm: AuthUser.getUser().DPCode*/
                dzzdm: $scope.changevm.dwId || '请选择',
                rybm_list: ''
            }
        };

        $scope.yekafanwei = function (m) {
            if (m == 2) {
                $scope.prog1 = false;
                $scope.prog2 = true;
                $scope.prog3 = false;
                $scope.prog4 = false;
                $scope.mod1 = '';
                $scope.mod2 = 'mod';
                $scope.mod3 = '';
                $scope.mod4 = '';
            } else if (m == 3) {
                $scope.prog1 = false;
                $scope.prog2 = false;
                $scope.prog3 = true;
                $scope.prog4 = false;
                $scope.mod1 = '';
                $scope.mod2 = '';
                $scope.mod3 = 'mod';
                $scope.mod4 = '';
            } else if (m == 4) {
                $scope.prog1 = false;
                $scope.prog2 = false;
                $scope.prog3 = false;
                $scope.prog4 = true;
                $scope.mod1 = '';
                $scope.mod2 = '';
                $scope.mod3 = '';
                $scope.mod4 = 'mod';
            } else {
                $scope.prog1 = true;
                $scope.prog2 = false;
                $scope.prog3 = false;
                $scope.prog4 = false;
                $scope.mod1 = 'mod';
                $scope.mod2 = '';
                $scope.mod3 = '';
                $scope.mod4 = '';
            }
        };
        $scope.yekafanwei(1)
        $scope.loadXXJH();
        $scope.parentUrl = "home.programme";//父级地址
        $scope.pagechange = function () {
            if ($bsRouterState.$getRouteType() == 'tab') {
                $bsRouterState.$closeTab($scope);
            } else {
                $bsRouterState.go($scope.parentUrl);
            }
        };

    })
})(angular);