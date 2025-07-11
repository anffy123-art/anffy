(function ($app) {
    $app.module('gtPartyApp').controller('shykMeetingStudyCtrl', function ($scope, $http, $modal, $ocLazyLoad, $alert, $loading, $state, $partySelect, $stateParams, AuthUser, $timeout, $bsRouterState) {
        $stateParams = $bsRouterState.$params($scope);

        //定义数据集合
        $scope.shyklxList = [];//三会一课类型
        $scope.topicList = [];//议题
        $scope.userList = [];//会议成员
        $scope.dataModel = {
            meetingid: $stateParams.id == undefined ? "" : $stateParams.id,
            shyktype: $stateParams.shykType == undefined ? "" : $stateParams.shykType,
        };
        $scope.op = $stateParams.op;

        $scope.meetingUserModel = {};
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
                }

                $scope.extdata = result.data.extdata;

            }, function () {
                $scope.showMsg('错误', '服务器错误');
            });
        };

        //提交
        $scope.saveData = function (isflag) {
            if (isflag) {
                if ($scope.meetingUserModel.makeuupstudy == "") {
                    $scope.showMsg('错误', '请填写补学补课情况！');
                    return false;
                }
                if (confirm("确认提交？")) {
                    $http({
                        method: 'post',
                        url: '../../api/shyk/saveUserStudy',
                        data: {
                            meetingId: $scope.dataModel.meetingid,
                            userCode: AuthUser.getUser().Id,
                            makeuupstudy: $scope.meetingUserModel.makeuupstudy
                        }
                    }).then(function (result) {
                        if (result.data.success) {
                            $scope.showMsg('成功', result.data.msg);
                            //重新刷新列表
                            $scope.clearMessage($scope.meetingUserModel.usercode);
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
                    messageType: 2
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