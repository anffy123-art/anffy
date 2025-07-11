﻿(function ($ang) {
    'use strict';
    $ang.module('zcapp').controller('demandupCtrl', function ($scope, $http, $state, $alert, $q, AuthUser, flowaudit, $loading) {

        $scope.viewdata = {
            tiltle: "需求提交",
            FlowStage: 1,
            reqFileModel: {
                selectdata: {FileRefID: '', pageindex: 1, pagesize: 10, ptotal: 0},
                filetype: 1,
                items: [],
                readonly: false,
                //canupfile: function (resultfun) {
                //    if ($scope.item.DemandApplyID == GuidEmpty) {
                //        //$scope.save(function () {
                //        //    $scope.viewdata.reqFileModel.selectdata.FileRefID = $scope.item.DemandApplyID;
                //        //    resultfun($scope.viewdata.reqFileModel);
                //        //});
                //        $scope.asyncSave().then(function (srq) {
                //            $scope.viewdata.reqFileModel.selectdata.FileRefID = $scope.item.DemandApplyID;
                //            resultfun($scope.viewdata.reqFileModel);
                //        });
                //    } else {
                //        $scope.viewdata.reqFileModel.selectdata.FileRefID = $scope.item.DemandApplyID;
                //        resultfun($scope.viewdata.reqFileModel);
                //    }
                //},
                canupfileAsync: function () {
                    var deferred = $q.defer();

                    if ($scope.item.DemandApplyID == GuidEmpty) {
                        //if ($scope.item.PlanFinishTime != null) {
                        $scope.asyncSave().then(function (srq) {
                            deferred.resolve($scope.item.DemandApplyID);
                        }, function (flasesrq) {
                            deferred.reject(flasesrq);
                        });
                        //}
                    } else {
                        deferred.resolve($scope.item.DemandApplyID);
                    }

                    return deferred.promise;
                }
            },
            params: $state.params,
            readonly: $state.params.st == 2,
            selectTest: {
                url: '../../api/home/selectlist',
                title: '测试选择',
                isMulti: false,
                selectData: {dictypekey: '字典关系字', dicvalue: '字典值'},
                columns: {dickey: '字典数', dicvalue: '字典值', dictypekey: '字典关健类型', dictype: '字典类型'},
                selectLabelKey: 'dicvalue',
                selectValuekey: 'dictionaryid',
                selectedValueData: 'id1,id2',
                selectedLabeData: 'name1,name2',
                selectedJData: []

            }
        };


        var explorer = navigator.userAgent;
        $scope.item = {};
        $scope.iteminfo = {};

        var GuidEmpty = "00000000-0000-0000-0000-000000000000";
        //监视选择的系统
        $scope.iteminfo.SystemName = "";
        $scope.$watch("iteminfo.SystemName", function (newVal, oldVal) {
            if ($scope.iteminfo.SystemName != "" && ($scope.item.DemandApplyID == GuidEmpty || ($scope.item.DemandApplyID != GuidEmpty && oldVal != ""))) {
                $scope.item.DemandTitle = "关于" + $scope.iteminfo.SystemName + "-XXXX的需求";
            }
            var t = $scope.iteminfo.SystemName.split("");
            var team = "";
            angular.forEach(t, function (value, key) {
                team += $scope.isChinese(value);
            });
            $scope.pattern = "^" + $scope.toUnicode('关于') + team + $scope.toUnicode('-') + "[\\d\\D]*" + $scope.toUnicode('的需求') + "$";

        });
        //是否为汉字
        $scope.isChinese = function (name) {
            var strExp = new RegExp(/^[\u4E00-\u9FA5]+$/);
            if (strExp.test(name)) {
                return $scope.toUnicode(name)
            } else {
                return name;
            }
        }

        //中文转Unicode
        $scope.toUnicode = function (e) {
            return escape(e).replace(/%/g, "\\").toLowerCase();
        };


        //获取紧急程度下拉框数据
        $scope.getUrgentStatuslist = function () {
            $http({
                url: "../../api/Comm/GetDictionaryListByDicType",
                method: 'GET',
                params: {DicTypeKey: "DemandUp_UrgentStatus"}
            }).then(function (rq) {
                $scope.UrgentStatuslist = rq.data;
            });
        };
        var parserDate = function (date) {
            var t = Date.parse(date);
            if (!isNaN(t)) {
                return new Date(Date.parse(date.replace(/-/g, "/")));
            } else {
                return new Date();
            }
        }
        $scope.asyncSave = function () {
            var deferred = $q.defer();

            // } else {
            if (IEVersion() != -1) {
                if (typeof $scope.item.PlanFinishTime == "string") {

                    $scope.item.PlanFinishTime = parserDate($scope.item.PlanFinishTime)
                }
                ;
            } else {
                if ($scope.item.PlanFinishTime == null) {
                    $alert({
                        title: '消息',
                        content: "请先完成需求的填写，再上传附件",
                        placement: 'center',
                        type: 'info',
                        show: true,
                        duration: 3
                    });

                } else {
                    $scope.item.PlanFinishTime = parserDate($scope.item.PlanFinishTime.toString())
                }
            }
            if (this.demandupForm.$valid) {
                $http({
                    url: "../../api/DemandFlow/saveDemandApply",
                    method: 'POST',
                    data: JSON.stringify($scope.item),
                    contentType: 'application/json'
                }).then(function (rq) {
                    if (rq.data.success) {
                        $scope.item.DemandApplyID = rq.data.extdata.DemandApplyID;
                        deferred.resolve(rq);
                    } else {
                        $alert({
                            title: '消息',
                            content: rq.data.msg,
                            placement: 'center',
                            type: 'info',
                            show: true,
                            duration: 3
                        });
                        deferred.reject(rq);
                    }

                });
            } else {
                this.demandupForm.$submitted = true;
                deferred.reject();
            }

            return deferred.promise;
            //  }

        }


        $scope.save = function (aftersuccessfun) {
            $scope.asyncSave().then(function (rq) {
                $alert({title: '消息', content: rq.data.msg, placement: 'center', type: 'info', show: true, duration: 3});
            }, function (rq) {
                if (rq) {
                    $alert({
                        title: '消息',
                        content: rq.data.msg,
                        placement: 'center',
                        type: 'info',
                        show: true,
                        duration: 3
                    });
                }
            });
            //if (this.demandupForm.$valid) {
            //    $http({ url: "../../api/DemandFlow/saveDemandApply", method: 'POST', data: $scope.item }).then(function (rq) {
            //        $scope.item.DemandApplyID = rq.data.extdata.DemandApplyID;
            //        if (rq.data.success) {
            //            if (angular.isFunction(aftersuccessfun)) {
            //                aftersuccessfun();
            //            } else {
            //                $alert({ title: '消息', content: rq.data.msg, placement: 'center', type: 'info', show: true, duration: 3 });
            //            }
            //        }
            //    });
            //} else {
            //    this.demandupForm.$submitted = true;
            //}
        };

        function IEVersion() {
            var userAgent = navigator.userAgent; //取得浏览器的userAgent字符串  
            var isIE = userAgent.indexOf("compatible") > -1 && userAgent.indexOf("MSIE") > -1; //判断是否IE<11浏览器  
            var isEdge = userAgent.indexOf("Edge") > -1 && !isIE; //判断是否IE的Edge浏览器  
            var isIE11 = userAgent.indexOf('Trident') > -1 && userAgent.indexOf("rv:11.0") > -1;
            if (isIE) {
                var reIE = new RegExp("MSIE (\\d+\\.\\d+);");
                reIE.test(userAgent);
                var fIEVersion = parseFloat(RegExp["$1"]);
                if (fIEVersion == 7) {
                    return 7;
                } else if (fIEVersion == 8) {
                    return 8;
                } else if (fIEVersion == 9) {
                    return 9;
                } else if (fIEVersion == 10) {
                    return 10;
                } else {
                    return 6;//IE版本<=7
                }
            } else if (isEdge) {
                return 'edge';//edge
            } else if (isIE11) {
                return 11; //IE11  
            } else {
                return -1;//不是ie浏览器
            }
        };


        $scope.loadItem = function () {
            $loading.show();
            $http({
                url: "../../api/DemandFlow/getDemandApply",
                method: 'GET',
                params: {
                    id: $state.params.id ? $state.params.id : '',
                    fid: $state.params.fid ? $state.params.fid : '',
                    userid: AuthUser.getUser().DGUserID
                }
            }).then(function (rq) {
                if (IEVersion() != -1) {
                    rq.data.items.PlanFinishTime = rq.data.items.PlanFinishTime == null ? null : rq.data.items.PlanFinishTime.substring(0, 10);
                }
                $scope.item = rq.data.items;
                //$scope.item.PlanFinishTime = rq.data.items.PlanFinishTime.substring(0, 10);
                $scope.iteminfo = rq.data.extdata;
                $scope.viewdata.reqFileModel.selectdata.FileRefID = $scope.item.DemandApplyID;
                $scope.viewdata.reqFileModel.readonly = $scope.viewdata.FlowStage != 1 || $scope.viewdata.params.st == 2 || (angular.isDefined($state.params.id) && $scope.item.FlowStep > 0);
                $loading.hide();
            }, function (reason) {
                $loading.hide();
            });
        };

        //修改后使用异步方法
        $scope.UpflowdoAsync = function () {

            if ($scope.viewdata.reqFileModel.items.length == 0) {
                $alert({
                    title: '消息',
                    content: '需求说明书不能为空！',
                    placement: 'center',
                    type: 'info',
                    show: true,
                    duration: 3
                });

                return false;
            }

            if ($scope.item.DemandTitle.indexOf('-XXXX的需求') > -1) {
                $alert({
                    title: '消息',
                    content: '[需求名称]必需修改具体的项目！',
                    placement: 'center',
                    type: 'info',
                    show: true,
                    duration: 3
                });
                return false;
            }

            if ($scope.item.FlowID) {
                $scope.asyncSave().then(function (rq) {
                    if (rq.data.success) {
                        flowaudit.showaudit({
                            pid: $scope.item.FlowStep == 0 ? $scope.item.FlowPid : $scope.viewdata.params.pid,
                            fid: $scope.item.FlowID,
                            onsuccess: $scope.pagechange
                        });
                    }
                }, function (rq) {
                    if (rq) {
                        $alert({
                            title: '消息',
                            content: rq.data.msg,
                            placement: 'center',
                            type: 'info',
                            show: true,
                            duration: 3
                        });
                    }
                });
            } else {
                var option = {
                    appid: $scope.iteminfo.appid, uid: AuthUser.getUser().DGUserID, flowname: $scope.item.DemandTitle
                };

                flowaudit.startflowAsync(option).then(function (sfRq) {
                    $scope.item.FlowID = sfRq.data.FlowID;
                    $scope.item.FlowPid = sfRq.data.ProcessID;
                    $scope.asyncSave().then(function (saverq) {

                        flowaudit.showaudit({
                            pid: $scope.item.FlowPid,
                            fid: $scope.item.FlowID,
                            onsuccess: $scope.pagechange
                        });

                    }, function (rq) {
                        if (rq) {
                            $alert({
                                title: '消息',
                                content: rq.data.msg,
                                placement: 'center',
                                type: 'info',
                                show: true,
                                duration: 3
                            });
                        }
                    });
                });
            }

            return true;

        };

        //同步方法不再使用
        $scope.upflow = function () {

            if ($scope.viewdata.reqFileModel.items.length == 0) {
                $alert({
                    title: '消息',
                    content: '需求说明书不能为空！',
                    placement: 'center',
                    type: 'info',
                    show: true,
                    duration: 3
                });
                return false;
            }


            if ($scope.item.FlowID) {
                $scope.save(function () {
                    flowaudit.showaudit({
                        pid: $scope.item.FlowStep == 0 ? $scope.item.FlowPid : $scope.viewdata.params.pid,
                        fid: $scope.item.FlowID,
                        onsuccess: $scope.pagechange
                    });
                });
            } else {
                var option = {
                    appid: $scope.iteminfo.appid,
                    uid: AuthUser.getUser().DGUserID,
                    flowname: $scope.item.DemandTitle,
                    onstartSuccess: function (rq) {

                        if (rq.data.success) {

                            $scope.item.FlowID = rq.data.FlowID;
                            $scope.item.FlowPid = rq.data.ProcessID;

                            $scope.save(function () {
                                flowaudit.showaudit({
                                    pid: $scope.item.FlowPid, fid: $scope.item.FlowID, onsuccess: $scope.pagechange
                                });
                            });
                        }
                    }
                };
                flowaudit.startflow(option)
            }
        };

        $scope.pagechange = function () {
            $state.go("home.dmuplist");
        };
        $scope.getUrgentStatuslist();
        $scope.loadItem();

    });
})(angular);