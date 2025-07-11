(function ($app) {
    $app.module('gtPartyApp').controller('shykDecisionEditCtrl', function ($scope, $http, $modal, $ocLazyLoad, $alert, $loading, $state, $partySelect, $stateParams, AuthUser, $timeout,$bsRouterState) {
        $stateParams = $bsRouterState.$params($scope);

        //定义数据集合
        $scope.shyklxList = [];//三会一课类型
        $scope.topicList = [];//议题
        $scope.dataModel = {
            meetingid: $stateParams.id == undefined ? "" : $stateParams.id,
            shyktype: $stateParams.shykType == undefined ? "" : $stateParams.shykType,
        };
        $scope.jymbList = [];//决议模板
        $scope.jyDataList = [{meetingdecisionid: 1, content: '', jymbid: null}];
        $scope.extdata = {shykTypeName: ''};

        //分页
        $scope.selectparams = {
            'pageindex': 1,
            'pagesize': 1000000,
            meetingId: $stateParams.id
        }

        $scope.$watch("jyDataList", function () {
            $scope.mbidWatch();
        }, true);

        //加载数据
        $scope.loadData = function () {
            $http.get("../../api/shyk/getMeetingById", {
                params: {
                    'id': $scope.dataModel.meetingid
                }
            }).then(function (result) {
                $scope.dataModel = result.data.item;
                $scope.getJymbList();

                $scope.extdata = result.data.extdata;
            }, function () {
                $scope.showMsg('错误', '服务器错误');
            });
        };

        //保存
        $scope.saveData = function (state) {
            if ($scope.dataModel.decisiontype == null) {
                $scope.showMsg('错误', '请选择决议类型');
                return false;
            }
            var decisionList = [];
            angular.forEach($scope.jyDataList, function (val, key) {
                if (val.content != "") {
                    decisionList.push({content: val.content, jymbid: val.jymbid});
                }
            });

            if (decisionList.length <= 0) {
                $scope.showMsg('错误', '请填写决议内容');
                return false;
            }

            if (confirm(state == 0 ? "确认保存？" : "确认提交？")) {
                $loading.show();
                $http({
                    method: "post",
                    url: "../../api/shyk/saveMeetingDecision",
                    data: {
                        meetingId: $scope.dataModel.meetingid,
                        decisiontype: $scope.dataModel.decisiontype,
                        decisionList: JSON.stringify(decisionList),
                        state: state
                    }
                }).then(function (result) {
                    $loading.hide();
                    if (result.data.success) {
                        $scope.showMsg('成功', result.data.msg);
                        //重新刷新列表
                        $scope.pagechange();

                        $scope.$emit("tabReloadData",{name:'shykIndexCtrl',data:1});
                    } else {
                        $scope.showMsg('失败', result.data.msg);
                    }
                }, function (resp) {
                    $loading.hide();
                    $scope.showMsg('错误', '服务器错误');
                });
            }
        };

        $scope.addDecision = function () {
            $scope.jyDataList.push({meetingdecisionid: $scope.jyDataList.length + 1, content: '', jymbid: null});
        };

        $scope.deleteDecision = function (id,index) {
            //$scope.jyDataList = $scope.jyDataList.filter(it => it.meetingdecisionid != id);
            $scope.jyDataList.splice(index, 1);
        };

        $scope.mbidWatch = function () {
            $.each($scope.jyDataList, function (index, item) {
                $scope.$watch('jyDataList[' + index + '].jymbid', function (newVal, oldVal) {
                    if (newVal != null && newVal != oldVal) {
                        $http.get("../../api/shykSetting/getHyjyById", {
                            params: {
                                'id': newVal
                            }
                        }).then(function (result) {
                            $scope.jyDataList[index].content = result.data.item.mbnr;
                        }, function () {
                        });
                    }
                });
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
        $scope.getJymbList = function () {

            $http({
                method: 'get',
                url: '../../api/shykSetting/getHyjyList',
                params: {
                    pageindex: 1, pagesize: 10000, lx: $scope.dataModel.shyktype
                }
            }).then(function (result) {
                $scope.jymbList = result.data.item.list;
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
                $scope.jyDataList = result.data.item.list;
                if ($scope.jyDataList.length <= 0) {
                    $scope.addDecision();
                }
            });
        };

        $scope.loadData();
        $scope.getShyklxList();
        $scope.getMeetingTopicList();
        $scope.mbidWatch();
        $scope.getMeetingDecisionList();

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