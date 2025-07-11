(function ($app) {
    $app.module('gtPartyApp').controller('shykMeetingRecordEditCtrl', function ($scope, $http, $modal, $ocLazyLoad, $alert, $loading, $state, $partySelect, $stateParams, AuthUser, $timeout, $bsRouterState, $filter, $bsfiles) {
        $stateParams = $bsRouterState.$params($scope);

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
        $scope.difftime = 0;//会议时间差
        $scope.reqFileModel = {
            selectdata: {FileRefID: '', pageindex: 1, pagesize: 10, ptotal: 0, fileType: 13},//查询参数：FileRefID为文件关联ID
            filetype: 13,//文件类型
            items: [],//列表数据地址
            readonly: $scope.op == 0,//是否只能查看
            title: '附件上传（选填）',
            addFileButton: '上传'
        };
        $scope.imgConfig1 = {
            filerefid: $scope.dataModel.meetingid,
            filetypeid: 1,
            readonly: false,
            ismulti: true,
            height: 150,
            imgList: []
        };
        $scope.imgConfig2 = {
            filerefid: $scope.dataModel.meetingid,
            filetypeid: 2,
            readonly: false,
            ismulti: true,
            height: 150,
            imgList: []
        };

        //分页
        $scope.selectparams = {
            'pageindex': 1,
            'pagesize': 1000000,
            meetingId: $stateParams.id
        }

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
                $scope.getUserList();
                $scope.getJlmbList();
                $scope.difftime = result.data.extdata.difftime;
                $scope.reqFileModel.selectdata.FileRefID = $scope.dataModel.meetingid;

                $scope.extdata = result.data.extdata;
            }, function () {
                $scope.showMsg('错误', '服务器错误');
            });
        };

        //保存会议记录
        $scope.saveMeetingRecord = function (state) {
            /*if ($scope.dataModel.meetingbriefcontent == "" || $scope.dataModel.meetingbriefcontent == null) {
                $scope.showMsg('错误', '请填写会议记录');
                return false;
            }*/

            if (state == 1 && $filter('filter')($scope.userList, {SIGNINSTATUS: 1}).length > 0) {
                $scope.showMsg('错误', '有未参加学员，请填写未参加原因！');
                return false;
            }

            if ($scope.imgConfig2.imgList.length <= 0) {
                $scope.showMsg('错误', '请上传台账记录');
                return false;
            }
            if (confirm(state == 0 ? "确认保存？" : "确认提交？")) {
                $http({
                    method: 'post',
                    url: '../../api/shyk/saveMeetingBriefContent',
                    data: {
                        meetingId: $scope.dataModel.meetingid,
                        meetingBriefContent: $scope.dataModel.meetingbriefcontent,
                        state: state
                    }
                }).then(function (result) {
                    $loading.hide();
                    if (result.data.success) {
                        $scope.showMsg('成功', result.data.msg);
                        //重新刷新列表
                        $scope.pagechange();

                        $scope.$emit("tabReloadData", {name: 'shykIndexCtrl', data: 1});
                    } else {
                        $scope.showMsg('失败', result.data.msg);
                    }
                }, function () {
                    $loading.hide();
                    $scope.showMsg('错误', '服务器错误');
                });
            }
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

        $scope.loadData();
        $scope.getShyklxList();
        $scope.getMeetingTopicList();

        //$scope.parentUrl = "home.shykIndex" + $scope.dataModel.shyktype.toString();//父级地址
        $scope.pagechange = function () {
            //$state.go($scope.parentUrl);
            var inTab = $bsRouterState.$getRouteType() == 'tab';
            if (inTab) {
                $bsRouterState.$closeTab($scope);
            } else {
                //$bsRouterState.go($scope.parentUrl);
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