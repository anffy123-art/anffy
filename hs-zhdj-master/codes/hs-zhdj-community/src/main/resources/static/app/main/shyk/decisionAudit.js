(function ($app) {
    $app.module('gtPartyApp').controller('shykMeetingAuditDecisionCtrl', function ($scope, $http, $modal, $ocLazyLoad, $alert, $loading, $state, $partySelect, $stateParams, AuthUser, $timeout,$bsRouterState) {
        $stateParams = $bsRouterState.$params($scope);

        //定义数据集合
        $scope.shyklxList = [];//三会一课类型
        $scope.topicList = [];//议题
        $scope.userList = [];//会议成员
        $scope.dataModel = {
            meetingid: $stateParams.id == undefined ? "" : $stateParams.id,
            shyktype: $stateParams.shykType == undefined ? "" : $stateParams.shykType,
        };
        $scope.decisionList = [];
        $scope.extdata = {shykTypeName: ''};

        //分页
        $scope.selectparams = {
            'pageindex': 1,
            'pagesize': 1000000,
            meetingId: $stateParams.id
        }
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
                $scope.getMeetingDecisionList();

                $scope.extdata = result.data.extdata;
            }, function () {
                $scope.showMsg('错误', '服务器错误');
            });
        };

        //提交
        $scope.saveData = function () {
            if ($scope.dataModel.decisionapprovecontent == "" || $scope.dataModel.decisionapprovecontent == null) {
                $scope.showMsg('错误', '请填审核信息！');
                return false;
            }
            if (confirm("确认提交？")) {
                $http({
                    method: 'post',
                    url: '../../api/shyk/saveDecisionAudit',
                    data: {
                        meetingId: $scope.dataModel.meetingid,
                        approvecontent: $scope.dataModel.decisionapprovecontent
                    }
                }).then(function (result) {
                    if (result.data.success) {
                        $scope.showMsg('成功', result.data.msg);
                        //重新刷新列表
                        $scope.pagechange();

                        $scope.$emit("tabReloadData",{name:'shykMeetingListCtrl',data:1});
                    } else {
                        $scope.showMsg('失败', result.data.msg);
                    }
                }, function () {
                    $scope.showMsg('错误', '服务器错误');
                });
            }
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

        $scope.loadData();
        $scope.getShyklxList();

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