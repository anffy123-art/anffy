(function ($app) {
    $app.module('gtPartyApp').controller('cgjqScoreEditCtrl', function ($scope, $http, $modal, $ocLazyLoad, $alert, $loading, $state, $partySelect, $stateParams, AuthUser,
                                                                        $filter, $bsRouterState) {

        $stateParams = $bsRouterState.$params($scope);

        //定义数据集合
        $scope.loginUserId = AuthUser.getUser().Id;
        $scope.dataModel = {
            postareascoreid: $stateParams.id == undefined ? "" : $stateParams.id,
            cgjqtype: $stateParams.cgjqType
        };
        $scope.isDetail = $stateParams.isDetail == 1 ? true : false;
        $scope.yearList = [];
        $scope.quarterList = [];
        $scope.cgjqScoreChecktypeList = [];
        $scope.scoreDataList = [];
        $scope.scoreLevelList=[];

        //定义岗区选择控件
        $scope.selectPostArea = {
            url: '../../api/cgjq/getSettingPostareaOfScoreList',
            title: '',
            isMulti: false,
            selectData: {name: '名称'},
            columns: {},
            selectLabelKey: 'NAME',
            selectValuekey: 'SEETINGPOSTAREAID',
            selectedValueData: '',
            selectedLabeData: '',
            selectedJData: [],
            selectParams: {
                cgjqType: $scope.dataModel.cgjqtype,
                partyCode: AuthUser.getUser().DataDzzdm,
                year: 0,
                quarter: 0
            }
        };
        if ($scope.dataModel.cgjqtype == 1) {
            $scope.selectPostArea.title = "选择责任岗";
            $scope.selectPostArea.columns = {NAME: '岗位名称', HEADUSERNAME: '岗位人员', PARTYNAME: '所在党支部'};
            $scope.selectPostArea.selectData = {name: '岗位名称',headUserName:'人员名称'};
        } else {
            $scope.selectPostArea.title = "选择责任区";
            $scope.selectPostArea.columns = {NAME: '责任区名称', HEADUSERNAME: '负责人', PARTYNAME: '所在党支部'};
            $scope.selectPostArea.selectData = {name: '责任区名称',headUserName:'负责人'};
        }
        $scope.$watch('selectPostArea.selectedValueData', function (newVal) {
            if (newVal != '' && newVal != undefined) {
                $http.get("../../api/cgjq/getPostareaById", {
                    params: {
                        'id': newVal
                    }
                }).then(function (result) {
                    if (result.data.success) {
                        $scope.dataModel.name = result.data.item.name;
                        $scope.dataModel.seetingpostareaid = result.data.item.seetingpostareaid;
                        $scope.dataModel.partycode = result.data.item.partycode;
                        $scope.dataModel.partyname = result.data.item.partyname;
                        $scope.dataModel.headuserid = result.data.item.headuserid;
                        $scope.dataModel.headusername = result.data.item.headusername;
                        $scope.dataModel.postareatime = result.data.item.createtime;

                        $scope.scoreDataList.length = 0;

                        //$scope.getPostareaSettingScoreList($scope.dataModel.partycode);
                    } else {
                        $scope.showMsg('错误', result.data.msg);
                    }
                }, function () {
                    $scope.showMsg('错误', '服务器错误');
                });
            }
        });
        $scope.$watchGroup(['dataModel.year', 'dataModel.quarter'], function (newVal) {
            $scope.selectPostArea.selectParams.year = $scope.dataModel.year;
            $scope.selectPostArea.selectParams.quarter = $scope.dataModel.quarter;
        });
        $scope.clickSelectPostArea = function () {
            if ($scope.dataModel.year == null || $scope.dataModel.quarter == null) {
                $scope.showMsg('错误', '请先选择年度和季度');
                return false;
            }
        };

        //获取数据
        $scope.loadData = function () {
            $http.get("../../api/cgjq/getPostareaScoreById", {
                params: {
                    'id': $scope.dataModel.postareascoreid,
                    cgjqType: $scope.dataModel.cgjqtype
                }
            }).then(function (result) {
                if (!result.data.success) {
                    $scope.showMsg('错误', result.data.extdata.message);
                    return false;
                }

                $scope.dataModel = result.data.item;

                //$scope.getPostareaScoreList();
            }, function () {
                $scope.showMsg('错误', '服务器错误');
            });

        };

        //保存
        $scope.submitData = function (isflag) {

            if (isflag) {
                /*if ($scope.scoreDataList.length <= 0) {
                    $scope.showMsg('错误', '请填写考核评分');
                    return false;
                }
                if ($scope.dataModel.score > 110) {
                    $scope.showMsg('错误', '总分不能超过110');
                    return false;
                }*/
                //数据处理
                var projectList = [];
                angular.forEach($scope.scoreDataList, function (val, key) {
                    projectList.push({
                        scoreprojectid: val.SCOREPROJECTID,
                        seetingprojectid: val.SEETINGPROJECTID,
                        projectname: val.PROJECTNAME,
                        content: val.CONTENT,
                        scorerefer: val.SCOREREFER,
                        sort: val.SORT,
                        reason: val.REASON,
                        initialscore: val.INITIALSCORE,
                        cgjqscorechecktype: val.CGJQSCORECHECKTYPE,
                        score: val.SCORE,
                        gqtype:val.GQTYPE
                    });
                });

                if (confirm("确认提交？")) {
                    $loading.show();
                    $http({
                        method: "post",
                        url: "../../api/cgjq/savePostareaScore",
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

                            $scope.$emit("tabReloadData", {name: 'cgjqScoreListCtrl', data: 1});
                        } else {
                            $scope.showMsg('失败', result.data.msg);
                        }
                    }, function (resp) {
                        $loading.hide();
                        $scope.showMsg('错误', '服务器错误,' + resp.data.message);
                    });
                }

            }
        };

        //评分联动
        $scope.addScoreWatch = function () {
            $.each($scope.scoreDataList, function (index, item) {
                $scope.$watch('scoreDataList[' + index + '].SCORE', function (newVal) {
                    $scope.totalScore();
                });
            });
        };

        $scope.totalScore = function () {
            var total = 0;
            $.each($scope.scoreDataList, function (index, item) {
                if (item.SCORE != null && item.SCORE != undefined) {
                    total += item.SCORE;
                }
            });

            $scope.dataModel.score = 100 + total;
        };

        //获取岗区评分数据
        $scope.getPostareaScoreList = function () {
            $http
            ({
                method: 'get', url: '../../api/cgjq/getPostareaScoreProjectList', params: {
                    postAreaScoreId: $scope.dataModel.postareascoreid
                }
            }).then(function (result) {
                $scope.scoreDataList = result.data;
                $scope.addScoreWatch();
            });
        };

        //获取岗区评分模板数据
        $scope.getPostareaSettingScoreList = function (dzzdm) {
            $http
            ({
                method: 'get', url: '../../api/cgjq/getSettingScoreProjectListOfScore', params: {
                    partyCode: dzzdm,
                    cgjqType: $scope.dataModel.cgjqtype
                }
            }).then(function (result) {
                angular.forEach(result.data, function (val) {
                    $scope.scoreDataList.push({
                        PROJECTNAME: val.PROJECTNAME,
                        CONTENT: val.CONTENT,
                        SCOREREFER: val.SCOREREFER,
                        INITIALSCORE: 0,
                        SCORE: 0,
                        SEETINGPROJECTID: val.SEETINGPROJECTID,
                        SORT: val.SORT,
                        CGJQSCORECHECKTYPE:1,
                        GQTYPE: (val.GQTYPE == null || val.GQTYPE == undefined ? "0" : val.GQTYPE.toString())
                    });
                });

                if ($scope.scoreDataList.length == 0) {
                    $scope.getPostareaSettingScoreList(AuthUser.getUser().gddwdm);
                }

                $scope.addScoreWatch();
            });
        };

        //列表数据必填
        $scope.invalidFee = function (index, form1, name) {
            name = name + "_" + index;
            eval('var i=form1.' + name + '.$invalid');
            return i;
        };

        $scope.getYearsList = function () {
            $http({
                method: 'get',
                url: '../../api/dictionary/getDictionaryListByDicTypeKey',
                params: {dicTypeKey: 'years'}
            }).then(function (result) {
                $scope.yearList = result.data;
            }, function (resp) {

            });
        };
        $scope.getQuartersList = function () {
            $http({
                method: 'get',
                url: '../../api/dictionary/getQuartersList',
                params: {}
            }).then(function (result) {
                $scope.quarterList = result.data;
            }, function (resp) {

            });
        };
        $scope.getCgjqScoreChecktypeList = function () {
            $http({
                method: 'get',
                url: '../../api/dictionary/getDictionaryListByDicTypeKey',
                params: {
                    dicTypeKey: 'cgjqScoreCheckType'
                }
            }).then(function (result) {
                $scope.cgjqScoreChecktypeList = result.data;
            }, function (resp) {

            });
        };

        $scope.getScoreLevelList = function () {
            $http({
                method: 'get',
                url: '../../api/dictionary/getDictionaryListByDicTypeKey',
                params: {
                    dicTypeKey: 'scoreLevel'
                }
            }).then(function (result) {
                $scope.scoreLevelList = result.data;
            }, function (resp) {

            });
        };

        //初始化数据
        $scope.getYearsList();
        $scope.getQuartersList();
        $scope.getCgjqScoreChecktypeList();
        $scope.getScoreLevelList();
        $scope.loadData();

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