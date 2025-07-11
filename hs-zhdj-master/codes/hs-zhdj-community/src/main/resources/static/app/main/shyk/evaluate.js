(function ($app) {
    $app.module('gtPartyApp').controller('shykEvaluateCtrl', function ($scope, $http, $modal, $ocLazyLoad, $alert, $loading, $state, $partySelect, $stateParams, $bsRouterState, $partySelect) {
        $stateParams = $bsRouterState.$params($scope);

        $scope.op = $stateParams.op;
        //定义数据集合
        $scope.dataModel = {
            meetinguserid: $stateParams.meetinguserId == undefined ? "" : $stateParams.meetinguserId,
            meetingid: $stateParams.meetingId == undefined ? "" : $stateParams.meetingId
        };
        $scope.meetingModel = {};

        $scope.projectList = [];

        $scope.resultTypeList = [];

        $scope.extdata = {};

        $scope.userList = [];


        $scope.loadData = function () {
            $http.get("../../api/shyk/getUserevaluateByUserId", {
                params: {
                    'meetingUserId': $scope.dataModel.meetinguserid,
                    'meetingId': $scope.dataModel.meetingid,
                }
            }).then(function (result) {
                if (result.data.success) {
                    $scope.dataModel = result.data.item;
                    $scope.projectList = result.data.extdata.projectList;
                    $scope.meetingModel = result.data.extdata.meetingModel;
                    $scope.extdata = result.data.extdata;

                    $scope.getResultTypeList();

                } else {
                    $scope.showMsg('错误', result.data.msg);
                }
            }, function () {
                $scope.showMsg('错误', '服务器错误');
            });
        };
        //保存
        $scope.submitData = function (isflag) {
            if (!isflag) {
                $scope.showMsg('提示', '请填写相关信息');
                return false;
            }

            var projectList = [];

            angular.forEach($scope.projectList, function (val, key) {
                projectList.push({
                    projectid: val.PROJECTID,
                    userevaluateid: val.USEREVALUATEID,
                    projectname: val.PROJECTNAME,
                    shykevaluatetype: val.SHYKEVALUATETYPE,
                    shykevaluateresulttype: val.SHYKEVALUATERESULTTYPE,
                    recommend: val.RECOMMEND
                });
            });

            if (isflag) {
                if (confirm("确认提交？")) {
                    $loading.show();
                    $http({
                        method: "post",
                        url: "../../api/shyk/saveUserevaluate",
                        data: {
                            dataModel: $scope.dataModel,
                            projectList: JSON.stringify(projectList)
                        }
                    }).then(function (result) {
                        $loading.hide();
                        if (result.data.success) {
                            $scope.showMsg('成功', result.data.msg);
                            //重新刷新列表
                            $scope.pagechange();

                            $scope.$emit("tabReloadData", {name: 'myMeetingCtrl', data: 1});
                        } else {
                            $scope.showMsg('失败', result.data.msg);
                        }

                    }, function (resp) {
                        $loading.hide();
                        $scope.showMsg('错误', '服务器错误,' + resp.data.message);
                    })
                }
            }
        };

        $scope.invalidFee = function (index, form1, name) {
            name = name + "_" + index;
            eval('var i=form1.' + name + '.$invalid');
            return i;
        };

        $scope.getResultTypeList = function () {
            $http({
                method: 'get',
                url: '../../api/dictionary/getDictionaryListByDicTypeKey',
                params: {
                    dicTypeKey: 'shykEvaluateResultType'
                }
            }).then(function (result) {

                $scope.resultTypeList = result.data;

            }, function (resp) {

            });
        };

        $scope.getUserList = function () {
            $http
            ({
                method: 'get',
                url: '../../api/shyk/getMeetingUserList',
                params: {
                    'pageindex': 1,
                    'pagesize': 10000,
                    meetingId: $stateParams.meetingId
                }
            }).then(function (result) {
                $scope.userList = result.data.item.list;
            });
        };

        $scope.userClick = function (id) {
            $scope.dataModel = [];
            //$scope.projectList = [];
            //$scope.extdata = {};
            $scope.dataModel.meetinguserid = id;
            $scope.dataModel.meetingid = $scope.meetingModel.meetingid;
            $scope.loadData();
        };

        //加载数据
        $scope.loadData();

        if ($scope.op == 0) {
            $scope.getUserList();
        }

        $scope.pagechange = function () {
            var inTab = $bsRouterState.$getRouteType() == 'tab';
            if (inTab) {
                $bsRouterState.$closeTab($scope);
            } else {
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