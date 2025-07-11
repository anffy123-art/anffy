(function ($app) {
    'use strict';
    $app.module('dsfapp').controller('formDevProblemkCtrl', function ($scope, $http, $modal, $state, $bsfiles, $alert, $window, AuthUser, $loading) {
        $scope.typedatas = {}
        //接受广播信息
        $scope.$on("toDevTestProblem", function (event, tar) {
            $loading.hide();
            $scope.formdata = tar;
            $scope.typedatas = {
                InternalTest: {
                    type: 1,
                    title: '内部测试',
                    showBtnExec: tar.showBtnExec,
                    readonly: tar.readonly_InternalTest,
                    showAllForm: tar.showAllForm
                },
                FucnTest: {
                    type: 2,
                    title: '功能测试',
                    showBtnExec: false,
                    readonly: tar.readonly_FuncTest,
                    showAllForm: tar.showAllForm
                },
            }
        });

    }).directive('devtestproblem', function ($http, $modal, $bsfiles, $alert, $window, AuthUser, $loading, $state) {
        var directiveObject = {
            restrict: 'EA',
            templateUrl: 'templateDevTestProblem.html',
            replace: true,
            scope: {
                typedatas: '=',
                formparams: '='
            },
            link: function ($scope, element, attr) {
                //分页参数
                $scope.page = {
                    pageIndex: 1,
                    pageSize: 5,
                    totalCount: 0
                }
                $scope.searchparam = [];

                $scope.alertfuc = function (title, content) {
                    $alert({
                        title: title,
                        content: content,
                        placement: 'center',
                        type: 'info',
                        show: true,
                        duration: 3
                    });
                }
                //http链接参数
                $scope.urls = {
                    getProblemListByFidUrl: "../../api/DevTest/getProblemByFid",
                    findFileListUrl: '../../api/FileUpload/FindFileList',
                    deleteProblemUrl: '../../api/DevTest/deleteProbleByDTID',
                    deleteFileUrl: '../../api/FileUpload/delfile',
                    getProblemTypeListUrl: '../../api/Comm/GetDictionaryListByDicType'
                }

                $scope.getProblemTypeList = function () {
                    $http.get($scope.urls.getProblemTypeListUrl, {params: {DicTypeKey: "DevTestData_ProblemType"}}).then(function (result) {
                        $scope.problemTypeList = result.data;
                    })
                }
                $scope.getProblemTypeList();
                //监视页数变化
                $scope.$watch("page.pageIndex", function (newVal, oldVal) {
                    if ($scope.page.totalCount > 0) {
                        $scope.loadItem();
                    }
                });
                //刷新数据
                $scope.refreshdata = function () {
                    $scope.loadItem();
                    $scope.loadProblemCountItem();
                }

                //加载问题明细列表
                $scope.loadItem = function () {
                    $loading.show();
                    $http({
                        url: $scope.urls.getProblemListByFidUrl, method: 'GET',
                        params: {
                            fid: $scope.formparams.fid,
                            testtype: $scope.typedatas.type,
                            FlowStage: $scope.formparams.FlowStage || '',
                            problemName: $scope.searchparam.problemName == null ? '' : $scope.searchparam.problemName,
                            problemType: $scope.searchparam.problemType == null ? '' : $scope.searchparam.problemType,
                            pageIndex: $scope.page.pageIndex,
                            pageSize: $scope.page.pageSize
                        }
                    }).then(function (rq) {
                        $loading.hide();
                        $scope.items = rq.data.items;
                        $scope.page.totalCount = rq.data.total;
                    });
                };

                //测试问题删除
                $scope.deleteProblem = function (dtid) {
                    if ($window.confirm("是否删除？")) {
                        $scope.tempfiles = [];
                        //获得对应问题的截图列表
                        $http({
                            url: $scope.urls.findFileListUrl,
                            method: 'GET',
                            params: {FileRefID: dtid, pageindex: 1, pagesize: 99999, ptotal: 0}
                        }).then(function (rq) {
                            $scope.tempfiles = rq.data.items;
                        });
                        $http.get($scope.urls.deleteProblemUrl, {params: {'DTID': dtid}}).then(function (result) {
                            if (result.data.success) {
                                angular.forEach($scope.tempfiles, function (file) {
                                    $http({
                                        url: $scope.urls.deleteFileUrl,
                                        method: 'GET',
                                        params: {FileId: file.FileId}
                                    }).then(function (rq) {
                                        console.log("删除图片");
                                    });
                                });
                                $scope.refreshdata();
                                $scope.alertfuc('成功：', result.data.msg);
                            } else {
                                $scope.alertfuc('失败：', result.data.msg);
                            }
                        })
                    }
                }

                //控制器参数
                var testproblemCtrl = function ($scope, $http) {
                    $scope.params = problemModal.params;
                    //http的url参数
                    $scope.configdata = {
                        getProblemInfoUrl: "../../api/DevTest/getProblemInfo",
                        getSysDutyListUrl: "../../api/SysDuty/GetSysDuty",
                        getDicListUrl: "../../api/Comm/GetDictionaryListByDicType",
                        saveProblemUrl: "../../api/DevTest/saveProblem",
                    };
                    //下拉列表数据
                    $scope.selectdatas = [];
                    $scope.content = [];//清空数据
                    //截图集合
                    $scope.files = [];
                    //截图上传参数
                    $scope.filedata = {
                        selectdata: {FileRefID: $scope.params.DevTestDataID, pageindex: 1, pagesize: 999999, ptotal: 0},
                        filetype: 4,
                        readonly: false,
                        items: $scope.files,
                        typeparams: {
                            types: ['jpg', 'bmp', 'jpe', 'jpeg', 'png'],
                            errormsg: '图片格式必须为*.jpg,*.bmp,*.jpe,*.jpeg,*.png等格式'
                        }
                    }

                    $scope.getProblemInfo = function () {
                        var getinfoparams = {
                            DTID: $scope.params.DevTestDataID ? $scope.params.DevTestDataID : '',
                            fid: '',
                            uid: AuthUser.getUser().DGUserID,
                            testplanid: ''
                        }
                        if (angular.isDefined($scope.params.SysDutyParam)) {
                            angular.extend(getinfoparams, {testplanid: $scope.params.SysDutyParam.DevTestPlanID});
                        }
                        //显示loading遮罩
                        $loading.show();
                        $http.get($scope.configdata.getProblemInfoUrl, {params: getinfoparams}).then(function (result) {
                            $loading.hide();
                            $scope.content = result.data.item;
                            $scope.content.SysDutyName = result.data.sysDutyName;
                            //设置传入的功能点参数
                            if (result.data.SysDutyName == null) {
                                $scope.content.SysDutyName = problemModal.params.SysDutyParam.SysDutyName;
                                $scope.content.SysDutyID = problemModal.params.SysDutyParam.SysDutyID;
                            }
                        }, function (ex) {
                            $loading.hide();
                        });
                    }

                    //获取功能点列表
                    $scope.getSysDutyList = function () {
                        $http.get($scope.configdata.getSysDutyListUrl, {
                            params: {
                                sysName: "",
                                SysDutyName: "",
                                DutyLv: 0
                            }
                        }).then(function (result) {
                            $scope.selectdatas.sysDutyList = result.data;
                        })
                    }
                    //获取问题类型列表
                    $scope.getProblemTypeList = function () {
                        $http.get($scope.configdata.getDicListUrl, {params: {DicTypeKey: "DevTestData_ProblemType"}}).then(function (result) {
                            $scope.selectdatas.problemTypeList = result.data;
                        })
                    }
                    //获取严重程度列表
                    $scope.getSeriousLvList = function () {
                        $http.get($scope.configdata.getDicListUrl, {params: {DicTypeKey: "DevTestData_SeriousLv"}}).then(function (result) {
                            $scope.selectdatas.seriousLvList = result.data;
                        })
                    }
                    //初始化问题明细表单
                    $scope.initSelect = function () {
                        $scope.getProblemInfo();
                        $scope.getSysDutyList();
                        $scope.getProblemTypeList();
                        $scope.getSeriousLvList();
                    }
                    //初始化下拉框
                    $scope.initSelect();

                    // 保存测试问题
                    $scope.saveProblem = function (isflag) {
                        if (isflag) {
                            if ($scope.files.length > 0) {
                                $http({
                                    method: "post",
                                    url: $scope.configdata.saveProblemUrl,
                                    data: $scope.content
                                }).then(function (result) {
                                    if (result.data.success) {
                                        $scope.alertfuc('成功：', result.data.msg);
                                    } else {
                                        $scope.alertfuc('错误：', rq.data.msg);
                                    }
                                    $scope.$hide();

                                }), function (resp) {
                                    $scope.alertfuc('错误：', '服务器错误');
                                }
                            } else {
                                $scope.alertfuc('提示：', '请上传至少一张问题截图');
                            }
                        }
                    }
                    //上传截图
                    $scope.addFile = function (isflag) {
                        $scope.issubmitted = true;
                        //设置上传格式
                        var typeparams = {
                            types: ['jpg', 'bmp', 'jpe', 'jpeg', 'png'],
                            errormsg: '图片必须为*.jpg,*.bmp,*.jpe,*.jpeg,*.png格式'
                        }
                        //判断是否为问题录入，若是，则先判断表单是否严重通过再新增一条记录；若否，则直接打开附件添加
                        if (!$scope.params.isShow && angular.isUndefined($scope.params.DevTestDataID)) {
                            if (isflag) {
                                $http({
                                    method: "post",
                                    url: $scope.configdata.saveProblemUrl,
                                    data: $scope.content
                                }).then(function (result) {
                                    if (result.data.success) {
                                        $scope.params.DevTestDataID = result.data.extdata.DevTestDataID;
                                        $scope.content.DevTestDataID = result.data.extdata.DevTestDataID;
                                        var param = $scope.filedata;
                                        param.selectdata.FileRefID = result.data.extdata.DevTestDataID;
                                        $bsfiles.addFile(param);
                                    } else {
                                        $scope.alertfuc('错误：', result.data.msg);
                                    }

                                })
                            }
                        } else {
                            $bsfiles.addFile($scope.filedata);
                        }
                    }

                    //缩略图放大
                    $scope.zoomImg = function (imgurl) {
                        $scope.zoomUrl = imgurl;
                        var imgModal = $modal({
                            scope: $scope,
                            title: '测试问题',
                            templateUrl: '../js/template/showimg.html',
                            show: false,
                            placement: 'center',
                            animation: 'am-fade-and-slide-top'
                        });
                        imgModal.$promise.then(imgModal.show);
                    }
                    //删除截图附件
                    $scope.delfile = function (fileid) {
                        $bsfiles.delfile(fileid, $scope.filedata);
                    }
                    //当为问题明细展示时进行截图列表初始化
                    if (angular.isDefined($scope.params.DevTestDataID)) {
                        $bsfiles.loadItems($scope.filedata);
                    }
                };

                testproblemCtrl.$inject = ['$scope', '$http'];

                var problemModal = $modal({
                    resolve: {
                        load: ['$ocLazyLoad', function ($ocLazyLoad) {
                            return [$ocLazyLoad.load('dsflow/editTestProblemModal.css')];
                        }]
                    },
                    scope: $scope,
                    title: '测试问题',
                    templateUrl: 'dsflow/editTestProblemModal.html',
                    controller: testproblemCtrl,
                    show: false,
                    animation: 'am-fade-and-slide-top'
                });
                //隐藏后执行loadItem
                problemModal.$options.onHide = function () {
                    $scope.refreshdata();
                };
                //测试问题录入模态框打开
                $scope.addProblem = function (item) {
                    problemModal.params = {
                        title: "问题录入",
                        readonly: false,//如果为录入，为false
                        SysDutyParam: item
                    }
                    problemModal.$promise.then(problemModal.show);
                }

                $scope.openBugFixTask = function (fdatas) {
                    $state.go("home.bugfix", {fid: fdatas.FlowID, pid: fdatas.FlowPid, st: 2, ft: 3});
                }

                //测试问题编辑模态框打开
                $scope.editProblem = function (item) {
                    problemModal.params = {
                        title: item.ProblemState > 0 ? "问题明细" : "问题编辑",
                        readonly: $scope.typedatas.readonly || item.ProblemState > 0,//只读
                        DevTestDataID: item.DevTestDataID,

                    }
                    problemModal.$promise.then(problemModal.show);
                }

                var assignProblemCtrl = function ($scope, $http) {
                    $scope.Quantity_flag = true;
                    $scope.bugitem = assignProblemModal.bugitem;
                    $scope.title = assignProblemModal.title;
                    $scope.ids = [];
                    angular.forEach($scope.bugitem, function (value, key) {
                        if (value.ProblemState == 0) {
                            this.push(value.DevTestDataID);
                        }
                    }, $scope.ids);
                    $scope.sendTask = function (ExpectFinishDate, ExpectQuantity) {
                        //查看表单验证是否通过
                        if ($scope.Dateform.$valid) {
                            $loading.show();
                            $http.post("../../api/Task/sendBugFixTask", {
                                'DevTestDataIDs': $scope.ids,
                                'CreateID': AuthUser.getUser().DGUserID,
                                'ExpectFinishDate': ExpectFinishDate,
                                'ExpectQuantity': ExpectQuantity
                            }).then(function (rq) {
                                $scope.alertfuc('提示：', rq.data.msg);
                                $loading.hide();
                                $scope.$hide();
                            });
                        }
                    }
                }
                assignProblemCtrl.$inject = ['$scope', '$http'];
                //派发模态框
                var assignProblemOptions = {
                    animation: "am-fade-and-slide-top",
                    scope: $scope,
                    controller: assignProblemCtrl,
                    templateUrl: '../js/template/modal_inputExpectFinishDate.html',
                    show: false
                };
                var assignProblemModal = $modal(assignProblemOptions);
                assignProblemModal.$options.onHide = function () {
                    $scope.refreshdata();
                }
                $scope.assignOneProblem = function (item) {
                    assignProblemModal.bugitem = [item];
                    assignProblemModal.title = '派发信息'
                    assignProblemModal.$promise.then(assignProblemModal.show);
                };
                $scope.assignAllProblem = function (items) {
                    assignProblemModal.bugitem = items;
                    if (items.length <= 0) {
                        $scope.alertfuc('提示：', '请先添加需要派发的问题！');
                        return false;
                    }
                    assignProblemModal.title = '一键派发信息'
                    assignProblemModal.$promise.then(assignProblemModal.show);
                };
                //分页参数
                $scope.ProblemCountPage = {
                    pageIndex: 1,
                    pageSize: 5,
                    totalCount: 0
                }
                //监视页数变化
                $scope.$watch("ProblemCountPage.pageIndex", function (newVal, oldVal) {
                    if ($scope.ProblemCountPage.totalCount > 0) {
                        $scope.loadProblemCountItem();
                    }
                });

                //加载列表
                $scope.loadProblemCountItem = function () {
                    $loading.show();
                    $http({
                        url: "../../api/DevTest/getProblemCountByDID", method: 'GET',
                        params: {
                            fid: $scope.formparams.fid,
                            FlowStage: $scope.formparams.FlowStage || '',
                            testtype: $scope.typedatas.type,
                            pageindex: $scope.ProblemCountPage.pageIndex,
                            pagesize: $scope.ProblemCountPage.pageSize
                        }
                    }).then(function (rq) {
                        $loading.hide();
                        $scope.ProblemCountItems = rq.data.items;
                        $scope.ProblemCountPage.totalCount = rq.data.total;
                    });
                };
                //通过测试计划
                $scope.passPlan = function (item) {
                    //通过状态值
                    var planstate = 2;
                    if (!confirm("是否通过“" + item.SysDutyName + "”功能点测试？")) {
                        return;
                    }
                    $http.post('../../api/DevTest/saveDevTestPlan', {
                        'list': [item],
                        'opr': 'updateState',
                        'param': planstate
                    }).then(
                        function successCallback(rq) {
                            if (rq.data.success) {
                                item.PlanState = planstate;
                            } else {
                                $alert({
                                    title: '错误：',
                                    content: '无法通过“' + item.SysDutyName + '”功能点测试：' + rq.data.msg,
                                    placement: 'center',
                                    type: 'info',
                                    show: true,
                                    duration: 3
                                });
                            }
                        }, function errorCallback(ex) {
                            $alert({
                                title: '错误：',
                                content: '服务器错误',
                                placement: 'center',
                                type: 'info',
                                show: true,
                                duration: 3
                            });
                        });
                }
                //选项卡数据
                $scope.tabs = [
                    {title: '问题统计', content: "problemcount.html"},
                    {title: '问题明细', content: "probleminfolist.html"}]

                //点击数字弹出的模态框
                var problemListCtrl = function ($scope, $http) {
                    //测试问题编辑模态框打开
                    $scope.editProblem = function (item) {
                        $scope.$hide();
                        problemModal.params = {
                            title: "问题编辑",
                            readonly: true,//只读
                            DevTestDataID: item.DevTestDataID,

                        }
                        problemModal.$promise.then(problemModal.show);
                    }
                    $scope.params = problemListModal.params;
                    //list清空
                    $scope.items = [];
                    //分页参数
                    $scope.page = {
                        pageIndex: 1,
                        pageSize: 5,
                        totalCount: 0
                    }
                    //监视页数变化
                    $scope.$watch("page.pageIndex", function (newVal, oldVal) {
                        if ($scope.page.totalCount > 0) {
                            $scope.loadProblemCountItem();
                        }
                    });
                    $scope.loadProblemCountItem = function () {
                        $http({
                            url: "../../api/DevTest/getProblemListByState", method: 'GET',
                            params: {
                                planid: $scope.params.planid,
                                state: $scope.params.state == null ? '' : $scope.params.state,
                                sysDutyID: $scope.params.sysDutyID,
                                pageindex: $scope.page.pageIndex,
                                pagesize: $scope.page.pageSize
                            }
                        }).then(function (rq) {
                            $scope.items = rq.data.items;
                            $scope.page.totalCount = rq.data.total;
                        });
                    }
                    $scope.loadProblemCountItem();
                }
                problemListCtrl.$inject = ['$scope', '$http'];
                var problemListModal = $modal({
                    title: '测试问题明细',
                    templateUrl: 'problemlist.html',
                    controller: problemListCtrl,
                    show: false,
                    animation: 'am-fade-and-slide-top'
                });

                //点击数字显示问题明细
                $scope.showlist = function (item, state) {
                    problemListModal.params = {
                        title: "测试问题明细",
                        sysDutyID: item.SysDutyID,
                        state: state,
                        planid: item.DevTestPlanID
                    }
                    problemListModal.$promise.then(problemListModal.show);
                }

                //输入测试计划预计完成时间弹窗
                var ExecPlanTimeCtrl = function ($scope, $http) {
                    $scope.title = "执行测试计划:";
                    $scope.Quantity_flag = true;
                    $scope.sendTask = function (ExpectFinishDate, ExpectQuantity) {

                        if ($scope.Dateform.$valid) {
                            $loading.show();
                            $http.get("../../api/Task/sendExecTestTask", {
                                params: {
                                    fid: $scope.formparams.fid,
                                    CreateID: AuthUser.getUser().DGUserID,
                                    ExpectFinishDate: ExpectFinishDate,
                                    ExpectQuantity: ExpectQuantity

                                }
                            }).then(function (rq) {
                                $loading.hide();
                                $scope.$hide();
                                if (rq.data.success) {
                                    $alert({
                                        title: '成功：',
                                        content: rq.data.msg,
                                        placement: 'center',
                                        type: 'info',
                                        show: true,
                                        duration: 3
                                    });
                                } else {
                                    $alert({
                                        title: '失败：',
                                        content: rq.data.msg,
                                        placement: 'center',
                                        type: 'info',
                                        show: true,
                                        duration: 3
                                    });
                                }
                            });
                        }
                    }
                }
                ExecPlanTimeCtrl.$inject = ['$scope', '$http'];
                var ExecPlanTimeModal = $modal({
                    animation: "am-fade-and-slide-top",
                    scope: $scope,
                    controller: ExecPlanTimeCtrl,
                    templateUrl: '../js/template/modal_inputExpectFinishDate.html',
                    show: false,
                    backdrop: false
                });
                ExecPlanTimeModal.$options.onHide = function () {
                    $scope.loadItem();
                    $scope.loadProblemCountItem();
                }

                $scope.execTestPlan = function (ele) {
                    ExecPlanTimeModal.$promise.then(ExecPlanTimeModal.show);
                };

                $scope.refreshdata();
            }
        }
        return directiveObject;
    }).filter('isZero', function () {
        //0过滤
        return function (item) {
            return item == 0 ? "" : item;
        };
    }).filter('isProblemState', function () {
        //问题状态过滤展示
        return function (item) {
            switch (item) {
                case 0:
                    return "待处理";
                case 1:
                    return "处理中";
                case 2:
                    return "已处理";
                default:
                    return "待处理";
            }
        };
    }).filter('isPlanState', function () {
        //计划状态过滤展示
        return function (item) {
            switch (item) {
                case 0:
                    return "未测试";
                case 1:
                    return "测试中";
                case 2:
                    return "已测试";
                default:
                    return "未测试";
            }
        };
    });
})(angular);