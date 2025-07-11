(function ($app) {
    'use strict';
    $app.module('gtPartyApp').controller('messageCtrl', function ($scope, $state, $alert, AuthUser, flowaudit, $http, $ocLazyLoad, $loading,$bsRouterState) {

        $scope.pageList = [
            {id: 1, title: '待办消息', url: '../main/home/todolist.html'},
            {id: 2, title: '已办消息', url: '../main/home/alreadylist.html'}];
        $scope.activeTab = 1;

        //选择tab页
        $scope.selectTab = function (setTab) {
            $scope.activeTab = setTab;
        };
        //判断选中项
        $scope.isSelected = function (checkedTab) {
            return $scope.activeTab === checkedTab;
        };

        //待办消息
        $scope.todomessageList = [];
        $scope.loadTodoMessage = function () {
            $http
            ({
                method: 'get',
                url: '../../api/message/getMessageList',
                params: $scope.tododata
            }).then(function (result) {
                $scope.todomessageList = result.data.item.list;
                $scope.tododata.ptotal = result.data.item.total;
            });
        };
        $scope.alreadymessageList = [];
        $scope.loadaLreadyMessage = function () {
            $http
            ({
                method: 'get',
                url: '../../api/message/getMessageList',
                params:  $scope.alreadydata
            }).then(function (result) {
                $scope.alreadymessageList = result.data.item.list;
                $scope.alreadydata.ptotal = result.data.item.total;
            });
        };
        //初始化查询参数
        $scope.tododata = {
            'pageindex': 1,
            'pagesize': 10,
            'ptotal': 0,
            'userId': AuthUser.getUser().Id,
            'state': 1,
        };
        //监视页数变化
        $scope.$watch("tododata.pageindex", function (newVal, oldVal) {
            if ($scope.tododata.ptotal > 0) {
                $scope.loadTodoMessage();
            }
        });

        //初始化查询参数
        $scope.alreadydata = {
            'pageindex': 1,
            'pagesize': 10,
            'ptotal': 0,
            'userId': AuthUser.getUser().Id,
            'state': 0,
        };
        //监视页数变化
        $scope.$watch("alreadydata.pageindex", function (newVal, oldVal) {
            if ($scope.alreadydata.ptotal > 0) {
                $scope.loadaLreadyMessage();
            }
        });
        $scope.loadTodoMessage();
        $scope.loadaLreadyMessage();

        $scope.messageDetail = function (item,op) {
            switch (item.MESSAGETYPE) {
                case 1: //会议签收
                    $bsRouterState.go("home.shykMeetingSignin", {id: item.BUSINESSID,op:op});
                    $scope.clearMessage(item.MESSAGEID);
                    break;
                case 2: //补学补课
                    $bsRouterState.go("home.shykMeetingStudy", {id: item.BUSINESSID,op:op});
                    break;
                case 3://会议取消通知
                    $scope.showMsg('通知', item.MSGTITLE);

                    $scope.clearMessage(item.MESSAGEID);
                    break;
                case 4://学习计划通知
                    $bsRouterState.go("home.learningPlanReceiveDetails", {id: item.BUSINESSID});
                    break;
            }
        }

        //清理通知
        $scope.clearMessage = function (messageid) {
            $http({
                method: 'get',
                url: '../../api/message/clearMessageById',
                params: {
                    messageId: messageid
                }
            }).then(function (result) {
                $scope.loadTodoMessage();
            }, function (resp) {

            });
        };
    });
})(angular);