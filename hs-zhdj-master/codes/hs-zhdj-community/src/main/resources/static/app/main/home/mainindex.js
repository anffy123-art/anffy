(function ($app) {
    'use strict';
    $app.module('gtPartyApp').controller('mainindexCtrl', function ($scope, $state, $filter, $alert, AuthUser, flowaudit, $q, $http, $ocLazyLoad, $loading, $window, $modal, $bsRouterState, $timeout, $payService, $interval) {

console.log(AuthUser.getUser(),'AuthUser')
        $bsRouterState.$params($scope);

        $scope.dataScope = 999;
        $scope.dataDzzdm = AuthUser.getUser().DataDzzdm;
        $scope.isShowMore = false;//AuthUser.getUser().curRoleId != '0b45886a-a8db-4f85-af76-61a8ea7c1dab' && AuthUser.getUser().curRoleId != 'dba21ae3-a495-4610-819b-60ccd0694cd9';
        $scope.selectmsTab = 2;

        $scope.cdData = [];//待办数据
        $scope.meetingList = [];//会议信息
        $scope.searchInfo = {  //搜索信息
            partyUserName: '',
            fileName: '',
        };
        $scope.fileList = [];

        $scope.fristName =    AuthUser.getUser().Name


        //组织成员搜索
        $scope.searchPartyUser = function (e) {
            var keycode = e == null ? 13 : (window.event ? e.keyCode : e.which);//获取按键编码
            if (keycode == 13) {
                if ($scope.searchInfo.partyUserName.length > 0) {
                    $bsRouterState.go("home.partyUserList", {xm: $scope.searchInfo.partyUserName});
                } else {
                    $alert({title: '提示：', content: '请输入关键字！', placement: 'top', type: 'info', show: true, duration: 2});
                }
            }
        };

        $scope.alertIsBuilding = function () {
            $alert({title: '提示：', content: '建设中', placement: 'top', type: 'info', show: true, duration: 2});
        };


        //制度文件搜索
        {
            //制度文件搜索
            $scope.FindWord = function (e) {
                var keycode = e == null ? 13 : (window.event ? e.keyCode : e.which);//获取按键编码
                if (keycode == 13) {
                    if ($scope.searchInfo.fileName.length > 0) {
                        //$window.open('http://10.160.8.64:8080/es/search.do?keyWords=' + decodeURI($scope.searchInfo.fileName));
                        //$bsRouterState.go('home.fileFrame', {keyWords: $scope.searchInfo.fileName});
                        $bsRouterState.go('home.fileTabList', {fileName: $scope.searchInfo.fileName});
                    } else {
                        $alert({
                            title: '提示：',
                            content: '请输入关键字！',
                            placement: 'top',
                            type: 'info',
                            container: 'oamodal',
                            show: true,
                            duration: 2
                        });
                    }
                }
            };

            var fileViewModal = $modal({
                scope: $scope,
                title: '文件展现',
                templateUrl: 'filemanage/doc-show.html?' + window.sysVersion,
                controller: 'fileViewCtrl',
                show: false,
                animation: 'am-fade-and-slide-top'
            });

            $scope.viewFile = function (fileid, filename) {
                //fileViewModal.fileId=fileid;
                $scope.viewFileId = fileid;
                $scope.viewFileName = filename;
                $scope.isrc = '/api/filemgr/showDoc/' + $scope.viewFileId;
                window.open($scope.isrc, "_blank");
                //fileViewModal.$promise.then(fileViewModal.show);
            };

            $scope.downloadFile = function (fileid) {
                $window.open('/api/filemgr/downDoc/' + fileid);
            };

            $scope.moreFIle = function () {
                $bsRouterState.go("home.fileTabList");
            };

            $scope.loadFIle = function () {
                $loading.show();
                $http({
                    method: 'get',
                    url: '../../api/filemgr/selectAllFile',
                }).then(function (req) {
                    $loading.hide();
                    $scope.fileList = req.data.item;
                }, function (resp) {
                    $loading.hide();
                });
            };
            $scope.loadFIle();
        }

        //任务
        {
            //加载任务信息
            $scope.loadMsgData = function (day, state) {
                /* $scope.cdData = [];
                 $http
                 ({
                     method: 'get',
                     url: '../../api/message/getNewMessage',
                     params: {userId: AuthUser.getUser().Id, day: day, state: state}
                 }).then(function (result) {
                     $scope.cdData = result.data.item;

                     if (day == null) {
                         var cdData = [];
                         angular.forEach($scope.cdData, function (val, index) {
                             cdData.push({
                                 date: $filter('date')(val.sendtime, 'yyyy-MM-dd'),
                                 value: val.msgtitle,
                                 id: val.messageid
                             });
                         });

                         $scope.cdOption.data = cdData;
                     }
                 });*/
            };
            //选择tab页
            $scope.ms_selectTab = function (setTab) {
                $scope.ms_activeTab = setTab;
                $scope.selectmsTab = setTab;
                // $scope.loadData($scope.ms_activeTab);
            };
            $scope.showMytask = function () {
                $bsRouterState.$closeTabName("home.mytask");
                $timeout(function () {
                    $bsRouterState.go('home.mytask', {});
                }, 100);
            };
            $scope.cdOption = {
                width: 200,
                height: 200,
                data: [],
                onSelected: function (view, date, data) {
                    $scope.loadMsgData($filter('date')(date, 'yyyy-MM-dd'), null);
                    $scope.loadTaskData($filter('date')(date, 'yyyy-MM-dd'));
                    $scope.loadShykData($filter('date')(date, 'yyyy-MM-dd'));
                }
            };

            //会议临时加入确认
            var tempUserController = function ($scope1) {
                $scope1.msgItem = m_tempUser.tempUserMsgItem;
                $scope1.msgAgree = function (optiontype) {
                    $http({
                        method: 'get',
                        url: '../../api/shyk/confirmTempUser',
                        params: {
                            id: $scope1.msgItem.businessid,
                            etype: optiontype
                        }
                    }).then(function (result) {
                        if (result.data.success) {
                            $scope.clearMessage($scope1.msgItem.messageid);
                            $scope1.$hide();
                        } else {
                            $alert({
                                title: '提示：',
                                content: result.data.msg,
                                placement: 'top',
                                type: 'info',
                                show: true,
                                duration: 3
                            });
                        }
                    });
                }
            };

            tempUserController.$inject = ['$scope'];

            var m_tempUser = new $modal({
                scope: $scope,
                controller: tempUserController,
                templateUrl: 'home/shyk_tempUserConfirm.html',
                show: false,
                animation: 'am-fade-and-slide-top'
            });

            //通知详情
            $scope.messageDetail = function (item) {
                switch (item.messagetype) {
                    case 1: //会议签收
                        $bsRouterState.go("home.shykMeetingSignin", {id: item.businessid, op: 0});
                        break;
                    case 2: //补学补课
                        $bsRouterState.go("home.shykMeetingStudy", {id: item.businessid, op: 0});
                        break;
                    case 3://会议取消通知
                        $scope.showMsg('通知', item.msgtitle);

                        $scope.clearMessage(item.messageid);
                        break;
                    case 4://学习计划通知
                        $bsRouterState.go("home.learningPlanReceiveDetails", {id: item.businessid});
                        break;
                    case 5: //会议临时加入通知
                        m_tempUser.tempUserMsgItem = item;
                        m_tempUser.$promise.then(m_tempUser.show);
                        break;
                    case 6://政工约稿
                        $bsRouterState.go("home.ygqkreply", {businessid: item.businessid, messageid: item.messageid});
                        break;
                    case 7://发起投稿审核
                        $bsRouterState.go("home." + item.url, {businessid: item.businessid, messageid: item.messageid});
                        break;
                }
            };


            //清理通知
            $scope.clearMessage = function (messageid) {
                $http({
                    method: 'get',
                    url: '../../api/message/clearMessageById',
                    params: {
                        messageId: messageid
                    }
                }).then(function (result) {
                    $scope.loadMsgData($filter('date')(new Date(), 'yyyy-MM-dd'));
                }, function (resp) {

                });
            };
        }

        //工作提醒信息
        {
            $scope.year = $filter('date')(new Date(), 'yyyy');

            //领导人员落实组织生活“5+3”制度情况
            $scope.userLeaderTotalList = [];
            var month = new Date().getMonth() + 1;
            $scope.quarter = Math.floor((month % 3 == 0) ? (month / 3) : (month / 3 + 1));
            $scope.getUserLeaderTotalList = function () {
                $http.get("../../api/bigdata/getUserLeaderTotalListNew", {
                    params: {
                        rybm: AuthUser.getUser().Id,
                        year: $scope.year,
                        quarter: $scope.quarter
                    }
                }).then(function (result) {
                    $scope.userLeaderTotalList = result.data;

                }, function () {
                    $scope.showMsg('错误', '服务器错误');
                });
            };


            $scope.getUserLeaderTotal = function (type, qt) {
                //qt区分是按季度还是年度
                var result = 0;
                angular.forEach($scope.userLeaderTotalList, function (val) {
                    if (val.LEADERTYPE == type) {
                        if (qt == "q") {//季度
                            if (val.QUARTER == $scope.quarter)
                                result += val.COUNT;
                        } else {//年份
                            result += val.COUNT;
                        }
                    }
                });
                return result;
            };

            $scope.showFSDetail = function (item) {
                var startDate = null, endDate = null, nowDate = new Date(), quarter = moment(nowDate).quarter();
                if (item.leaderType != 5) {
                    switch (item.totalType) {
                        case 1://每季度一次
                            startDate = moment(nowDate).startOf("year").quarter(quarter);
                            endDate = moment(startDate).add(2, 'month').endOf("month");
                            break;
                        case 2://每年一次
                            startDate = moment(nowDate).startOf("year");
                            endDate = moment(nowDate).endOf("year");
                            break;
                        case 3://每年2次
                            startDate = moment(nowDate).startOf("year");
                            endDate = moment(nowDate).endOf("year");
                            break;
                        case 4://每年4次
                            startDate = moment(nowDate).startOf("year");
                            endDate = moment(nowDate).endOf("year");
                            break;
                    }
                } else {
                    startDate = moment(nowDate).startOf("year");
                    endDate = moment(nowDate).endOf("year");
                }

                $bsRouterState.$closeTabName("home.userLeaderList");
                $timeout(function () {
                    $bsRouterState.go('home.userLeaderList', {
                        leaderType: item.leaderType,
                        xm: AuthUser.getUser().Name,
                        beginTime: startDate.format("YYYY-MM-DD"),
                        endTime: endDate.format("YYYY-MM-DD")
                    });
                }, 100);
            };

            $scope.getLeaderData = function (type) {
                if (type == 1) {
                    return $scope.userLeaderTotalList.filter(function (it) {
                        return it.leaderType <= 5
                    });
                } else {
                    return $scope.userLeaderTotalList.filter(function (it) {
                        return it.leaderType > 5
                    });
                }
            }


            // //中心组学习情况
            // $scope.zxzxxqkList = [];
            // $scope.getZxzxxqkTotalList = function () {
            //     $http.get("../../api/bigdata/getUserZXZXXTotalList", {
            //         params: {
            //             userCode: AuthUser.getUser().Id
            //         }
            //     }).then(function (result) {
            //         $scope.zxzxxqkList = result.data;

            //     }, function () {
            //         $scope.showMsg('错误', '服务器错误');
            //     });
            // };

            $scope.getZxzxxqkTotal = function (type) {
                var result = 0;
                angular.forEach($scope.zxzxxqkList, function (val) {
                    if (val.LEADERTYPE == type) {
                        result = val.COUNT;
                    }
                });
                return result;
            };

            $scope.getZdfyNum = function (type) {
                var result = 0;
                angular.forEach($scope.zxzxxqkList, function (val) {
                    if (val.LEADERTYPE == type) {
                        result += val.SPEAKNUMBER;
                    }
                });
                return result;
            };

            $scope.showZxzxxqkDetail = function (type) {
                $bsRouterState.$closeTabName("home.LearningSituation");
                $timeout(function () {
                    $bsRouterState.go('home.LearningSituation', {
                        studType: type
                    });
                }, 100);
            };


            //发展党员情况
            $scope.partyUserExpendTotal = [];
            $scope.getPartyUserExpendTotal = function () {
                $http.get("../../api/bigdata/getPartyUserExpendTotalList", {
                    params: {
                        dzzdm: AuthUser.getUser().DataDzzdm
                    }
                }).then(function (result) {
                    //$scope.partyUserExpendTotal = result.data;

                    angular.forEach(result.data, function (item, index) {
                        if (item.NUM > 0) {
                            var pedata = {num: item.NUM, msg: '', pflowid: '', beginSort: null, endSort: null};
                            switch (index) {
                                case 0:
                                    pedata.msg = "有" + pedata.num + "名党员待谈话！";
                                    pedata.pflowid = "F75088870EE64F06ABA7C2DE164CA024";
                                    pedata.beginSort = 1;
                                    pedata.endSort = 1;
                                    break;
                                case 1:
                                    pedata.msg = "有" + pedata.num + "名入党积极分子待考察！";
                                    pedata.pflowid = "4EE371E71B704DE1BCF4AB3863F759E1";
                                    pedata.beginSort = 3;
                                    pedata.endSort = 5;
                                    break;
                                case 2:
                                    pedata.msg = "有" + pedata.num + "名预备党员待转正！";
                                    pedata.pflowid = "CA68082965F442F28AA7C18E37B14106";
                                    pedata.beginSort = 22;
                                    pedata.endSort = 22;
                                    break;
                                default:
                                    break;
                            }

                            $scope.partyUserExpendTotal.push(pedata);
                        }
                    });

                }, function () {
                    $scope.showMsg('错误', '服务器错误');
                });
            };

            $scope.showPartyExpend = function (pflowid, beginSort, endSort) {
                $bsRouterState.$closeTabName("home.pe_UserList");
                $timeout(function () {
                    $bsRouterState.go('home.pe_UserList', {pflowid: pflowid, beginSort: beginSort, endSort: endSort});
                }, 100);
            };

            // //主题党日，换届选举信息
            // $scope.PartyTotalInfo = {};
            // $scope.worktag = 1;
            // $scope.getPartyTotalInfo = function () {
            //     $http.get("../../api/partyTowExt/getPartyTotalInfo", {
            //         params: {
            //             dzzdm: AuthUser.getUser().DataDzzdm,
            //             year: $scope.year,
            //             yearMonth: $filter('date')(new Date(), 'yyyyMM')
            //         }
            //     }).then(function (result) {
            //         $scope.PartyTotalInfo = result.data.item;

            //     }, function () {
            //         $scope.showMsg('错误', '服务器错误');
            //     });
            // };
            $scope.showZtdrExpend = function () {
                $bsRouterState.$closeTabName("home.ztdrxx");
                $timeout(function () {
                    $bsRouterState.go('home.ztdrxx', {});
                }, 100);
            };

            // $scope.shykTotalWarn = false;
            // $http
            // ({
            //     method: 'get', url: '../../api/shyk/getMeetingTotalListNew', params: {
            //         pageindex: 1,
            //         pagesize: 1,
            //         ssdzzdm: AuthUser.getUser().DataDzzdm,
            //         year: new Date().getFullYear(),
            //         quarter: parseInt(new Date().getMonth() / 3) + 1
            //     }
            // }).then(function (result) {
            //     $scope.shykTotalWarn = result.data.item.list.filter(function (it) {
            //         return it.totalWarn == 1
            //     }).length > 0;

            // }, function (resp) {
            //     $scope.showMsg('错误', '服务器错误');
            // });


            $scope.showShykTotal = function () {
                $bsRouterState.$closeTabName("home.shykTotal");
                $timeout(function () {
                    $bsRouterState.go('home.shykTotal', {});
                }, 100);
            };
        }

        //会议信息
        {
            $scope.loadMeetingData = function () {
                $http
                ({
                    method: 'get', url: '../../api/shyk/getMyMeetingList', params: {
                        pageindex: 1,
                        pagesize: 5,
                        userId: AuthUser.getUser().Id
                    }
                }).then(function (result) {
                    $scope.meetingList = result.data.item.list;
                });
            };

            $scope.showMeeting = function (id, shykType) {
                $bsRouterState.go('home.shykShow', {id: id, shykType: shykType});
            };
        }

        //我的组织信息
        {
            $scope.partyUserInfo = {};
            $scope.partyInfo_Ext = {};
            $scope.dzb_partyTotalList = [];
            $scope.dw_partyInfo_Ext = {};
            $scope.dw_partyTotalList = [];
            $scope.inPartyDate = null;
            $scope.getPartyUserInfo = function () {
                $http.get("../../api/partyUser/getPartyUserInfo", {
                    params: {
                        'rybm': AuthUser.getUser().Id,
                        'roleId': AuthUser.getUser().curRoleId,
                        'dataScope': AuthUser.getUser().dataScope,
                        'dataDzzdm': AuthUser.getUser().DataDzzdm
                    }
                }).then(function (result) {
                    $scope.partyUserInfo = result.data.item;
                    if ($scope.partyUserInfo.dzz_gjjmrq) {
                        $scope.partyUserInfo.isGroupReplace = $scope.partyUserInfo.dzz_gjjmrq.substring(0, 4) == new Date().getFullYear().toString();
                        $scope.partyUserInfo.dzz_gjjmrq = moment($scope.partyUserInfo.dzz_gjjmrq, "YYYYMMDD").format("YYYY年MM月DD日");
                    }
                    if (result.data.item.djxxModel && result.data.item.djxxModel.jrzgzzrq) {
                        $scope.inPartyDate = moment(result.data.item.djxxModel.jrzgzzrq, "YYYYMMDD");
                    }

                    $scope.getMyPartyDuesList();

                    //党总支/党支部数据
                    if (($scope.dataScope == 3 || $scope.dataScope == 4 || $scope.dataScope == 8) && $scope.partyUserInfo.dzz_partyInfo != undefined && $scope.partyUserInfo.dzz_partyInfo != null) {
                        $scope.loadUserTotal(1, $scope.partyUserInfo.dzz_partyInfo.dzzdm);
                        $scope.loadPartyTotal(1, $scope.partyUserInfo.dzz_partyInfo.dzzdm);
                        $scope.getDjkpList(1, $scope.partyUserInfo.dzz_partyInfo.dzzdm);
                    }

                    //党委数据
                    if (($scope.dataScope == 1 || $scope.dataScope == 2 || $scope.dataScope == 7) && $scope.partyUserInfo.dw_partyInfo != undefined && $scope.partyUserInfo.dw_partyInfo != null) {
                        $scope.loadUserTotal(2, $scope.partyUserInfo.dw_partyInfo.dzzdm);
                        $scope.loadPartyTotal(2, $scope.partyUserInfo.dw_partyInfo.dzzdm);
                        $scope.getDjkpList(2, $scope.partyUserInfo.dw_partyInfo.dzzdm);
                    }

                    if ((!AuthUser.getUser().oaUserId || AuthUser.getUser().oaUserId == "undefined" || AuthUser.getUser().oaUserId == 'null') && (!AuthUser.getUser().oaIdCard || AuthUser.getUser().oaIdCard == "undefined" || AuthUser.getUser().oaIdCard == 'null')) {
                        oaUserModal.$promise.then(oaUserModal.show);
                    }

                }, function () {
                    $scope.showMsg('错误', '服务器错误');
                });
            };

            //人员统计
            $scope.loadUserTotal = function (type, dzzdm) {
                $http
                ({
                    method: 'get', url: '../../api/partyExpand/getJoinUserTotalList', params: {
                        pageindex: 1,
                        pagesize: 10,
                        ssdzzdm: dzzdm,//党组织代码
                    }
                }).then(function (result) {
                    if (result.data.item.list.length > 0) {
                        var data = result.data.item.list[0];
                        if (type == 1) {
                            $scope.partyInfo_Ext.ybdys = data.YBDY;
                            $scope.partyInfo_Ext.rdjjfzs = data.JJFZ;
                            $scope.partyInfo_Ext.sqrds = data.SQRD;
                            $scope.partyInfo_Ext.fzdx = data.FZDX;
                        } else {
                            $scope.dw_partyInfo_Ext.sqrds = data.SQRD;
                            $scope.dw_partyInfo_Ext.rdjjfzs = data.JJFZ;
                            $scope.dw_partyInfo_Ext.fzdx = data.FZDX;
                            $scope.dw_partyInfo_Ext.ybdys = data.YBDY;
                        }
                    }

                });

                //在岗职工数
                $http
                ({
                    method: 'get', url: '../../api/bigdata/getPartyUserTotalList', params: {
                        dzzdm: dzzdm,//党组织代码
                    }
                }).then(function (res) {
                    if (res.data != null) {
                        if (type == 1) {
                            $scope.partyInfo_Ext.dys = res.data.TOTAL;
                            $scope.partyInfo_Ext.zgcount = res.data.ZGCOUNT;
                            $scope.partyInfo_Ext.zgrs = res.data.ZGRS;
                            $scope.partyInfo_Ext.ltxcount = res.data.LTXCOUNT;
                        } else {
                            $scope.dw_partyInfo_Ext.dys = res.data.TOTAL;
                            $scope.dw_partyInfo_Ext.zgcount = res.data.ZGCOUNT;
                            $scope.dw_partyInfo_Ext.zgrs = res.data.ZGRS;
                            $scope.dw_partyInfo_Ext.ltxcount = res.data.LTXCOUNT;
                        }
                    }

                });

                //委员数
                $http
                ({
                    method: 'get', url: '../../api/grade/getMaxGradeUserList', params: {
                        'pageindex': 1,
                        'pagesize': 5,
                        ssdzzdm: dzzdm
                    }
                }).then(function (result) {
                    if (type == 1) {
                        $scope.partyInfo_Ext.wys = result.data.item.total;
                    } else {
                        $scope.dw_partyInfo_Ext.wys = result.data.item.total;
                    }
                });
            };

            //组织统计
            $scope.loadPartyTotal = function (type, dzzdm) {
                $http.get("../../api/bigdata/getPartyCountList", {
                    params: {
                        dzzdm: dzzdm,//党组织代码
                    }
                }).then(function (result) {
                    if (type == 1) {
                        $scope.dzb_partyTotalList = result.data;
                    } else {
                        $scope.dw_partyTotalList = result.data;
                    }

                }, function () {

                });
            };

            $scope.getDjkpList = function (type, dzzdm) {
                $http
                ({
                    method: 'get', url: '../../api/partyTowExt/getDjkpxxList', params: {
                        'pageindex': 1,
                        'pagesize': 1,
                        dzzdm: dzzdm,
                        ssdzzdm: dzzdm
                    }
                }).then(function (result) {
                    var kpjg = result.data.item.list.length > 0 ? result.data.item.list[0].JUDGELEVELNAME : '';
                    if (type == 1) {
                        $scope.partyInfo_Ext.kpjg = kpjg;
                    } else {
                        $scope.dw_partyInfo_Ext.kpjg = kpjg;
                    }
                });
            };

            $scope.showMyPartyUserInfo = function () {
                $bsRouterState.$closeTabName("home.partyUserShow");
                $timeout(function () {
                    $bsRouterState.go('home.partyUserShow', {
                        rybm: AuthUser.getUser().Id,
                        userType: parseInt(AuthUser.getUser().userType)
                    });
                }, 100);
            };

            $scope.toReport = function (url) {
                $bsRouterState.$closeTabName("home.partyUserShow");
                $timeout(function () {
                    $bsRouterState.go(url);
                }, 100);
            };

        }

        //集团情况一览
        {
            $scope.partyTotal_User = {};
            $scope.partyTotalList = [];
            $scope.partyTotal = 0;
            $scope.getPartyTotal = function () {
                $http.get("../../api/bigdata/getPartyCountList", {
                    params: {
                        dzzdm: AuthUser.getUser().gddwdm,//党组织代码
                    }
                }).then(function (result) {
                    $scope.partyTotalList = result.data;
                    angular.forEach($scope.partyTotalList, function (val) {
                        $scope.partyTotal += val.NUM;
                    });

                }, function () {

                });
            };

            //人员统计
            $scope.getUserTotalParty = function () {
                $http
                ({
                    method: 'get', url: '../../api/partyExpand/getJoinUserTotalList', params: {
                        pageindex: 1,
                        pagesize: 10,
                        ssdzzdm: AuthUser.getUser().gddwdm,//党组织代码
                    }
                }).then(function (result) {
                    if (result.data.item.list.length > 0) {
                        var data = result.data.item.list[0];
                        $scope.partyTotal_User.ybdys = data.YBDY;
                        $scope.partyTotal_User.fzdys = data.FZDX;
                    }
                }, function (resp) {
                });

                $http
                ({
                    method: 'get', url: '../../api/bigdata/getPartyUserTotalList', params: {
                        dzzdm: AuthUser.getUser().gddwdm,//党组织代码
                    }
                }).then(function (result) {
                    if (result.data != null) {
                        $scope.partyTotal_User.dys = result.data.TOTAL;
                        $scope.partyTotal_User.zgcount = result.data.ZGCOUNT;
                        $scope.partyTotal_User.zgrs = result.data.ZGRS;
                        $scope.partyTotal_User.ltxcount = result.data.LTXCOUNT;
                    }
                }, function (resp) {
                });
            };

            //集团党内品牌数
            $scope.dnppCount = 0;
            $scope.getDnppCount = function () {

                $http
                ({
                    method: 'get', url: '../../api/partyTowExt/getBrandCount', params: {
                        creatType: 2,
                        partyCode: AuthUser.getUser().gddwdm
                    }
                }).then(function (result) {
                    $scope.dnppCount = result.data;
                });
            };

        }

        //我的党费
        {
            $scope.selectDuesYear = new Date().getFullYear();
            $scope.myPartyDuesList = [];
            $scope.myPartyDuesInfo = {};
            // $scope.getMyPartyDuesList = function () {
            //     $http.get("../../api/publicity/getPartyDuesUserInfoById", {
            //         params: {
            //             'usercode': AuthUser.getUser().Id,
            //             'year': $scope.selectDuesYear,
            //             'username': AuthUser.getUser().Name
            //         }
            //     }).then(function (result) {
            //         $scope.myPartyDuesInfo = result.data.item;
            //         $scope.myPartyDuesList = result.data.extdata.userMonthList;
            //         /*$scope.myPartyDuesList.forEach(function (item, index) {
            //             var payMonth = moment($scope.selectDuesYear.toString() + item.MONTH.toString().padStart(2, '0') + '01', 'YYYYMMDD');
            //             var inPartyDate = $scope.inPartyDate != null ? moment($scope.inPartyDate).startOf('month') : null;
            //             var startPayDate = $scope.myPartyDuesInfo.partycode.indexOf("001091209017002") >= 0 ? moment("2024-04-01") : moment("2024-07-01");

            //             item.isPay = item.MONEY > 0 && item.MONTH <= (moment().month() + 1) && item.payState != 1 && $scope.inPartyDate != null
            //                 && payMonth >= inPartyDate && payMonth >= startPayDate;
            //         });*/
            //     }, function () {

            //     });
            // };

            $scope.searchDues = function (addYears) {
                $scope.selectDuesYear += addYears;
                $scope.getMyPartyDuesList();
            };

            var editPayCtrl = function ($scope, $http, $alert, $loading, $payService) {
                $scope.editPayParams = editPayModal.params;
                $scope.minAmount = $scope.editPayParams.amount;
                $scope.payTitle = $scope.editPayParams.username + $scope.editPayParams.month + '月份党费';

                $scope.wxPay = function (isflag) {
                    if (isflag) {
                        $scope.updatePartyduesPayState($scope.editPayParams.payRelId,$scope.editPayParams.amount);//初始化缴费状态
                        $payService.payShow({
                            title: $scope.payTitle,
                            payRelId: $scope.editPayParams.payRelId,
                            amount: $scope.editPayParams.amount
                        }).then(function (result) {
                            if (result == true) {
                                $scope.myPartyDuesList.filter(it => it.DETAILID == $scope.editPayParams.payRelId).forEach(function (item, index) {
                                    item.isPay = false;
                                    item.payState = 1;
                                });

                                $scope.updatePartyduesPayState($scope.editPayParams.payRelId,null);//同步微信缴费状态

                                $timeout(function () {
                                    $scope.$hide();
                                }, 100);
                            }
                        });


                    }
                };

                $scope.updatePartyduesPayState = function (detailId,amount) {
                    $http.post("../../api/publicity/updatePartyduesPayState", {
                        'detailId': detailId,
                        amount:amount
                    }).then(function (result) {
                    }, function () {
                    });
                };
            };

            var editPayModal = $modal({
                resolve: {
                    load: ['$ocLazyLoad', function ($ocLazyLoad) {
                    }]
                },
                scope: $scope,
                controller: editPayCtrl,
                templateUrl: '../main/home/editPay.html',
                show: false,
                animation: 'am-fade-and-slide-top'
            });

            $scope.payDues = function (month, username, payRelId, amount) {
                editPayModal.params = {
                    month: month,
                    username: username,
                    payRelId: payRelId,
                    amount: amount
                };
                editPayModal.$promise.then(editPayModal.show);
            };
        }


        // //加载任务数据
        // $scope.taskdataList = [];
        // $scope.loadTaskData = function (day) {
        //     $http
        //     ({
        //         method: 'get', url: '../../api/partyTowExt/getTaskList', params: {
        //             taskUser: AuthUser.getUser().Id,
        //             'pageindex': 1,
        //             'pagesize': 500,
        //             day: day,
        //             beginTime: new Date()
        //         }
        //     }).then(function (result) {
        //         $scope.taskdataList = result.data.item.list;
        //         $scope.mspageList[0].number = $scope.taskdataList.length;

        //         if (day == null) {
        //             var cdData = [];
        //             angular.forEach($scope.taskdataList, function (val, index) {
        //                 cdData.push({
        //                     date: $filter('date')(val.ENDTIME, 'yyyy-MM-dd'),
        //                     value: val.TASKNAME,
        //                     id: val.ID
        //                 });
        //             });
        //             $scope.cdOption.data = $scope.cdOption.data.concat(cdData);
        //         }
        //     });
        // };
        //查看任务
        $scope.showTaskData = function (id, tasktype) {
            var taskurl = "home.systaskedti";
            //收集任务
            if (tasktype == 2) {
                taskurl = "home.taskreply";
            }
            $bsRouterState.$closeTabName(taskurl);
            $timeout(function () {
                $bsRouterState.go(taskurl, {
                    id: id,
                    isDetail: false
                });
            }, 100);
        };
        // //加载三会一课信息
        // $scope.myshykdataList = []
        // $scope.loadShykData = function (day) {
        //     $scope.cdData = [];
        //     $http
        //     ({
        //         method: 'get',
        //         url: '../../api/shyk/getMyMeetingList',
        //         params: {
        //             userId: AuthUser.getUser().Id,
        //             'pageindex': 1,
        //             'pagesize': 500,
        //             day: day,
        //             beginTime: new Date()
        //         }
        //     }).then(function (result) {
        //         $scope.getAttendLearningmeetingList(day).then(function (list) {
        //             var learningmeetingList = [];
        //             angular.forEach(list, function (item) {
        //                 learningmeetingList.push({
        //                     MEETINGID: item.meetingId,
        //                     BEGINTIME: item.meetingDate,
        //                     MEETINGNAME: "【中心组学习】" + item.meetingName,
        //                     meetingType: "中心组学习"
        //                 });
        //             })
        //             $scope.myshykdataList = learningmeetingList.concat(result.data.item.list);
        //             $scope.mspageList[1].number = $scope.myshykdataList.length;
        //             if (day == null) {
        //                 var cdData = [];
        //                 angular.forEach($scope.myshykdataList, function (val, index) {
        //                     cdData.push({
        //                         date: $filter('date')(val.BEGINTIME, 'yyyy-MM-dd'),
        //                         value: val.MEETINGNAME,
        //                         id: val.MEETINGID
        //                     });
        //                 });

        //                 $scope.cdOption.data = $scope.cdOption.data.concat(cdData);
        //             }
        //         })
        //     }, function (msg) {

        //     });
        // }
        $scope.getAttendLearningmeetingList = function (day) {
            var deferred = $q.defer();
            $http
            ({
                method: 'get',
                url: '../../api/learningMeeting/getAttendLearningmeetingList',
                params: {
                    attendUserid: AuthUser.getUser().Id,
                    day: day,
                    beginTime: new Date()
                }
            }).then(function (result) {
                deferred.resolve(result.data.item);
            }, function (error) {
                deferred.reject(error);
            });
            return deferred.promise;
        }
        //查看三会一课
        $scope.showShykData = function (id, meetingType) {
            var url = meetingType == "中心组学习" ? "home.learningMeetingView" : "home.shykShow";
            $bsRouterState.$closeTabName(url);
            $timeout(function () {
                $bsRouterState.go(url, {id: id, isDetail: true});
            }, 100);
        };
        $scope.mspageList = [
            {id: 2, title: '任务待办', url: '../main/home/tabpage/mytask.html', number: 0}
            // {id: 1, title: '会议', url: '../main/home/tabpage/meetingmsg.html', number: $scope.taskdataList.length}
        ];

        //数据初始化
        AuthUser.dofunAfterLogin().then(function (user) {
            if (AuthUser.getUser().Id != '' && AuthUser.getUser().Id != null) {
                $scope.dataScope = parseInt(AuthUser.getUser().dataScope);//角色数据范围

                $scope.loadMsgData(null, 1);

                switch ($scope.dataScope) {
                    case 1://集团
                        $scope.getUserTotalParty();
                        $scope.getUserLeaderTotalList();
                        $scope.getZxzxxqkTotalList();
                        $scope.getPartyUserExpendTotal();
                        $scope.getPartyTotal();
                        $scope.getDnppCount();
                        break;
                    case 2://党委
                        break;
                    case 7://党委
                        $scope.getUserLeaderTotalList();
                        $scope.getZxzxxqkTotalList();
                        $scope.getPartyUserExpendTotal();
                        break;
                    case 3://党总支
                        break;
                    case 8://二级党总支
                        $scope.getPartyUserExpendTotal();
                        break;
                    case 4://党支部
                        $scope.getPartyUserExpendTotal();
                        break;
                    case 5://普通党员
                        $scope.loadMeetingData();
                        break;
                    case 6:
                        $scope.loadMeetingData();
                        break;
                    default:
                        $scope.loadMeetingData();
                        break;
                }

                $scope.getPartyUserInfo();
                //$scope.getMyPartyDuesList();

                $scope.getPartyTotalInfo();
                $scope.loadTaskData(null);
                $scope.loadShykData(null);
            }
        });

    }).controller('fileViewCtrl', function ($scope, $http) {
        $scope.title = $scope.$parent.$parent.viewFileName;
        $scope.fileId = $scope.$parent.$parent.viewFileId;
        $scope.isrc = '/api/filemgr/showDoc/' + $scope.fileId;
    });
})(angular);
