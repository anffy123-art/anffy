(function ($app) {
    $app.module('gtPartyApp').controller('shykMeetingSigninCtrl', function ($scope, $http, $modal, $ocLazyLoad, $alert, $loading, $state, $partySelect, $stateParams, AuthUser, $timeout,$bsRouterState) {
        $stateParams = $bsRouterState.$params($scope);

        //定义数据集合
        $scope.shyklxList = [];//三会一课类型
        $scope.topicList = [];//议题
        $scope.userList = [];//会议成员
        $scope.dataModel = {
            meetingid: $stateParams.id == undefined ? "" : $stateParams.id,
            shyktype: $stateParams.shykType == undefined ? "" : $stateParams.shykType,
        };
        $scope.meetingUserModel = {};
        $scope.difftime = 0;//会议时间差
        $scope.extdata = {shykTypeName: ''};

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

                if (result.data.extdata.meetingUser != null) {
                    $scope.meetingUserModel = result.data.extdata.meetingUser;
                    $scope.clearMessage($scope.meetingUserModel.usercode);
                }

                $scope.difftime = result.data.extdata.difftime;

                $scope.extdata = result.data.extdata;

            }, function () {
                $scope.showMsg('错误', '服务器错误');
            });
        };

        //提交
        $scope.saveData = function (isflag) {
            if (isflag) {
                if (new Date() > new Date($scope.dataModel.begintime)) {
                    $scope.showMsg('错误', '请在会议开始时间30分钟前请假！');
                    return false;
                }

                if ($scope.meetingUserModel.userremark == "") {
                    $scope.showMsg('错误', '请填写未参加会议原因！');
                    return false;
                }
                if (confirm("确认未参加会议？")) {
                    $http({
                        method: 'post',
                        url: '../../api/shyk/signinMeeting',
                        data: {
                            meetingId: $scope.dataModel.meetingid,
                            userCode: AuthUser.getUser().Id,
                            isSignin: false,
                            userRemark: $scope.meetingUserModel.userremark
                        }
                    }).then(function (result) {
                        if (result.data.success) {
                            $scope.showMsg('成功', result.data.msg);
                            //重新刷新列表
                            $scope.pagechange();
                        } else {
                            $scope.showMsg('失败', result.data.msg);
                        }
                    }, function () {
                        $scope.showMsg('错误', '服务器错误');
                    });
                }
            }
        };

        //清除消息
        $scope.clearMessage = function (userId) {
            $http({
                method: 'get',
                url: '../../api/message/clearMessageByBusinessId',
                params: {
                    businessId: $scope.dataModel.meetingid,
                    userId: userId,
                    messageType: 1
                }
            }).then(function (result) {

            }, function (resp) {

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

        $scope.loadData();
        $scope.getShyklxList();
        $scope.getMeetingTopicList();

        $scope.pagechange = function () {

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