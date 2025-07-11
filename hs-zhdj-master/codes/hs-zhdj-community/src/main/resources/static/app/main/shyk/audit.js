(function ($app) {
    $app.module('gtPartyApp').controller('shykMeetingAuditCtrl', function ($scope, $http, $modal, $ocLazyLoad, $alert, $loading, $state, $partySelect, $stateParams, AuthUser, $timeout, $bsRouterState) {
        $stateParams = $bsRouterState.$params($scope);

        //定义数据集合
        $scope.shyklxList = [];//三会一课类型
        $scope.topicList = [];//议题
        $scope.userList = [];//会议成员
        $scope.dataModel = {
            meetingid: $stateParams.id == undefined ? "" : $stateParams.id,
            shyktype: $stateParams.shykType == undefined ? "" : $stateParams.shykType,
        };
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

                $scope.extdata = result.data.extdata;

            }, function () {
                $scope.showMsg('错误', '服务器错误');
            });
        };

        //保存会议记录
        $scope.saveMeetingApprove = function () {
            if ($scope.dataModel.meetingapprovestatus == null) {
                $scope.showMsg('错误', '请选择审核意见');
                return false;
            }
            $http({
                method: 'post',
                url: '../../api/shyk/saveMeetingAudit',
                data: {
                    meetingId: $scope.dataModel.meetingid,
                    meetingapprovestatus: $scope.dataModel.meetingapprovestatus,
                    meetingapproveopinion: $scope.dataModel.meetingapproveopinion
                }
            }).then(function (result) {
                $scope.showMsg('成功', result.data.msg);
                $scope.pagechange();

                $scope.$emit("tabReloadData",{name:'shykIndexCtrl',data:1});
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

        $scope.loadData();
        $scope.getShyklxList();
        $scope.getMeetingTopicList();

        //$scope.parentUrl = "home.shykIndex" + $scope.dataModel.shyktype.toString();//父级地址
        $scope.pagechange = function () {

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