(function ($app) {
    $app.module('gtPartyApp').controller('shykShowCtrl', function ($scope, $http, $modal, $ocLazyLoad, $alert, $loading, $state, $partySelect, $stateParams, AuthUser, $timeout, $location, $bsRouterState, $filter) {
        $stateParams = $bsRouterState.$params($scope);

        $scope.dataScope = parseInt(AuthUser.getUser().dataScope);//角色数据范围;

        $scope.qrcodeUrl = "http://" + window.location.host + "/api/home/ShowQRCode?code=" + $stateParams.id;
        $scope.democracyReviewType = 7;//民主评议党员
        //定义数据集合
        $scope.loginUserId = AuthUser.getUser().Id;
        $scope.shyklxList = [];//三会一课类型
        $scope.topicList = [];//议题
        $scope.userList = [];//会议成员
        $scope.dataModel = {
            meetingid: $stateParams.id == undefined ? "" : $stateParams.id,
            shyktype: $stateParams.shykType == undefined ? "" : $stateParams.shykType,
        };
        $scope.extdata = {shykTypeName: ''};
        $scope.jlModel = {
            mbid: null
        };//会议记录信息
        $scope.jlmbList = [];//记录模板
        $scope.decisionList = [];
        $scope.difftime = 0;//会议时间差
        $scope.isEnd = false;//会议是否结束
        $scope.meetingUserModel = {};
        $scope.imgConfig1 = {
            filerefid: $scope.dataModel.meetingid,
            filetypeid: 1,
            readonly: true,
            ismulti: true,
            height: 150,
            width: 180,
            imgList: []
        };
        $scope.imgConfig2 = {
            filerefid: $scope.dataModel.meetingid,
            filetypeid: 2,
            readonly: true,
            ismulti: true,
            height: 150,
            width: 180,
            imgList: []
        };
        $scope.democracyReviewList = [];
        $scope.meetingTypeList = [];

        //分页
        $scope.selectparams = {
            'pageindex': 1,
            'pagesize': 1000000,
            meetingId: $stateParams.id
        }
        $scope.pageInfo = {ptotal: 0};

        $scope.img = {rotate: 0};

        $scope.reqFileModel = {
            selectdata: {FileRefID: '', pageindex: 1, pagesize: 10, ptotal: 0, fileType: 13},//查询参数：FileRefID为文件关联ID
            filetype: 13,//文件类型
            items: [],//列表数据地址
            readonly: true,//是否只能查看
            title: '会议记录附件',
            addFileButton: '上传'
        };

        //监视页数变化
        $scope.$watch("selectparams.pageindex", function (newVal, oldVal) {
            if ($scope.pageInfo.ptotal > 0) {
                $scope.getUserList();
            }
        });

        $scope.$watch("jlModel.mbid", function (newVal, oldVal) {
            if (newVal != null) {
                $http.get("../../api/shykSetting/getHyjlById", {
                    params: {
                        'id': newVal
                    }
                }).then(function (result) {
                    $scope.dataModel.meetingbriefcontent = result.data.item.mbnr;
                }, function () {
                    $scope.showMsg('错误', '服务器错误');
                });
            }
        });

        //加载数据
        $scope.loadData = function () {
            $http.get("../../api/shyk/getMeetingById", {
                params: {
                    'id': $scope.dataModel.meetingid,
                    'dzzdm': $scope.dataModel.partycode,
                    'shyktype': $scope.dataModel.shyktype
                }
            }).then(function (result) {
                $scope.dataModel = result.data.item;
                $scope.reqFileModel.selectdata.FileRefID = $scope.dataModel.meetingid;
                $scope.getUserList();
                $scope.getJlmbList();
                $scope.getMeetingDecisionList();
                $scope.getMeetingDemocracyReviewList();
                $scope.getMeetingTypeList();

                $scope.difftime = result.data.extdata.difftime;
                $scope.isEnd = new Date() > new Date($scope.dataModel.endtime);
                if (result.data.extdata.meetingUser != null) {
                    $scope.meetingUserModel = result.data.extdata.meetingUser;
                }

                $scope.extdata = result.data.extdata;
            }, function () {
                $scope.showMsg('错误', '服务器错误');
            });
        };

        $scope.editNoSigninModal = {
            userRemark: "",//未参加原因
            MEETINGID: '',
            USERCODE: ''
        };
        $scope.resetRemark = function (meetingId, userCode) {
            $scope.editNoSigninModal = {
                userRemark: "",//未参加原因
                MEETINGID: meetingId,
                USERCODE: userCode
            };
        };

        //签收
        $scope.signin = function (meetingId, userCode, isSignin) {
            if (isSignin) {
                $scope.editNoSigninModal.userRemark = "";
            }
            if (!isSignin && $scope.editNoSigninModal.userRemark == "") {
                $scope.showMsg('错误', '请填写未参加原因');
                return false;
            }
            $http({
                method: 'post',
                url: '../../api/shyk/signinMeeting',
                data: {
                    meetingId: meetingId,
                    userCode: userCode,
                    isSignin: isSignin,
                    userRemark: $scope.editNoSigninModal.userRemark
                }
            }).then(function (result) {
                $scope.showMsg('成功', result.data.msg);
                $('#editNoSignin').modal('hide');
                $scope.getUserList();
            }, function () {
                $scope.showMsg('错误', '服务器错误');
            });
        };

        //签到
        $scope.checkin = function (meetingId, userCode) {
            $http({
                method: 'post',
                url: '../../api/shyk/checkinMeeting',
                data: {
                    meetingId: meetingId,
                    userCode: userCode
                }
            }).then(function (result) {
                $scope.showMsg('成功', result.data.msg);
                $scope.getUserList();
            }, function () {
                $scope.showMsg('错误', '服务器错误');
            });
        };

        //召开
        $scope.meetingConvene = function (isConvene) {
            if (isConvene && $scope.userList.filter(function (val) {
                return val.SIGNINSTATUS == 1;
            }).length > 0) {
                $scope.showMsg('错误', '还有成员未签收！');
                return;
            }
            if (confirm(isConvene ? "确定召开会议？" : "确定取消会议？")) {
                $http({
                    method: 'post',
                    url: '../../api/shyk/conveneMeeting',
                    data: {
                        meetingId: $scope.dataModel.meetingid,
                        isConvene: isConvene
                    }
                }).then(function (result) {
                    $scope.showMsg('成功', result.data.msg);
                    $scope.pagechange();
                }, function () {
                    $scope.showMsg('错误', '服务器错误');
                });
            }
        };

        //保存会议记录
        $scope.saveMeetingRecord = function () {
            if ($scope.dataModel.meetingbriefcontent == "") {
                $scope.showMsg('错误', '请填写会议记录');
                return false;
            }
            $http({
                method: 'post',
                url: '../../api/shyk/saveMeetingBriefContent',
                data: {
                    meetingId: $scope.dataModel.meetingid,
                    meetingBriefContent: $scope.dataModel.meetingbriefcontent
                }
            }).then(function (result) {
                $scope.showMsg('成功', result.data.msg);
                $scope.pagechange();
            }, function () {
                $scope.showMsg('错误', '服务器错误');
            });
        };

        $scope.auditDecision = function () {
            $bsRouterState.go("home.shykMeetingAuditDecision", {id: $scope.dataModel.meetingid});
        };

        $scope.printQrcode = function () {
            window.document.body.innerHTML = "<img src='" + $scope.qrcodeUrl + "'/>";
            window.print();

            window.location.reload();
        };


        //取消签收
        $scope.cancelSignin = function (meetingId, userCode) {
            $http({
                method: 'post',
                url: '../../api/shyk/cancelUserSignin',
                data: {
                    meetingId: meetingId,
                    userCode: userCode
                }
            }).then(function (result) {
                $scope.showMsg('成功', result.data.msg);
                $scope.getUserList();
            }, function () {
                $scope.showMsg('错误', '服务器错误');
            });
        };

        //取消签到
        $scope.cancelCheckin = function (meetingId, userCode) {
            $http({
                method: 'post',
                url: '../../api/shyk/cancelUserCheckin',
                data: {
                    meetingId: meetingId,
                    userCode: userCode
                }
            }).then(function (result) {
                $scope.showMsg('成功', result.data.msg);
                $scope.getUserList();
            }, function () {
                $scope.showMsg('错误', '服务器错误');
            });
        };

        //党课评价情况
        $scope.showEvaluate = function (id, meetinguserId) {
            $bsRouterState.$closeTabName("home.shykEvaluateShow");
            $timeout(function () {
                $bsRouterState.go('home.shykEvaluateShow', {
                    meetingId: id,
                    meetinguserId: meetinguserId,
                    op: 0
                });
            }, 100);
        };

        $scope.getUserList = function () {
            $http
            ({
                method: 'get',
                url: '../../api/shyk/getMeetingUserList',
                params: $scope.selectparams
            }).then(function (result) {
                $scope.userList = result.data.item.list;
                $scope.pageInfo.ptotal = result.data.item.total;
            });
        };
        $scope.getShyklxList = function () {
            $http({
                method: 'get',
                url: '../../api/dictionary/getDictionaryListByDicTypeKey',
                params: {
                    dicTypeKey: 'shykType'
                }
            }).then(function (result) {
                $scope.shyklxList = result.data;
            }, function (resp) {

            });
        };
        $scope.getMeetingTopicList = function () {
            $http({
                method: 'get',
                url: '../../api/shyk/getMeetingTopicList',
                params: {
                    meetingId: $scope.dataModel.meetingid
                }
            }).then(function (result) {
                $scope.topicList = result.data;
            }, function (resp) {

            });
        };
        $scope.getJlmbList = function () {

            $http({
                method: 'get',
                url: '../../api/shykSetting/getHyjlList',
                params: {
                    pageindex: 1, pagesize: 10000, lx: $scope.dataModel.shyktype
                }
            }).then(function (result) {
                $scope.jlmbList = result.data.item.list;
            }, function (resp) {

            });
        };
        $scope.getMeetingDecisionList = function () {
            $http
            ({
                method: 'get',
                url: '../../api/shyk/getMeetingDecisionList',
                params: $scope.selectparams
            }).then(function (result) {
                $scope.decisionList = result.data.item.list;
            });
        };

        $scope.getMeetingDemocracyReviewList = function () {
            $http({
                method: 'get',
                url: '../../api/shyk/getMeetingDemocracyReviewList',
                params: {
                    meetingId: $scope.dataModel.meetingid
                }
            }).then(function (result) {
                $scope.democracyReviewList = result.data.item;
            }, function (resp) {
            });
        };
        $scope.getMeetingTypeList = function () {
            $http({
                method: 'get',
                url: '../../api/shyk/getMeetingTypeList',
                params: {
                    meetingId: $scope.dataModel.meetingid
                }
            }).then(function (result) {
                $scope.meetingTypeList = result.data.item;

                $scope.getShyklxList();
            }, function (resp) {
            });
        };

        $scope.isShowDemocracyReview = function () {
            return $scope.meetingTypeList.filter(e => e.shyktype === $scope.democracyReviewType).length > 0;
        };

        $scope.loadData();
        $scope.getShyklxList();

        //$scope.parentUrl = "home.shykIndex" + $scope.dataModel.shyktype.toString();//父级地址
        $scope.pagechange = function () {
            //$state.go($scope.parentUrl);

            var inTab = $bsRouterState.$getRouteType() == 'tab';
            if (inTab) {
                $bsRouterState.$closeTab($scope);
            } else {
                window.history.go(-1);
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