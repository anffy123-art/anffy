(function ($app) {
    $app.module('gtPartyApp').controller('cgjqScoreSortCtrl', function ($scope, $http, $modal, $ocLazyLoad, $alert, $loading, $state, $stateParams, AuthUser, $bsRouterState) {
        $state.params = $bsRouterState.$params($scope);

        //定义数据集合
        $scope.pageList = [
            {id: 1, title: '责任岗', url: '../main/cgjq/score/scoresort/post.html'},
            {id: 2, title: '责任区', url: '../main/cgjq/score/scoresort/area.html'}];
        $scope.activeTab = 1;
        $scope.loginUserId = AuthUser.getUser().Id;
        $scope.selectparams = {
            isunfold: false,//组织结构树展开收缩
            selectdzzdm: '',
            selectdzzmc: '',
            zzfbType: null
        };
        //当前年度季度
        var year = new Date().getFullYear();
        var quarter = parseInt(new Date().getMonth() / 3) + 1;
        $scope.isShow = false;
        $scope.moreTxt = "更多";


        //责任岗
        $scope.post_dataList = []; //列表数据
        $scope.post_selectparams = {
            cgjqType: 1,
            partyCode: '',//党组织代码
            userId: AuthUser.getUser().Id,
            name: '',
            year: year,
            quarter: quarter,
            zzfbType: null
        };
        $scope.post_resetparams = {
            cgjqType: 1,
            partyCode: '',//党组织代码
            userId: AuthUser.getUser().Id,
            name: '',
            year: year,
            quarter: quarter,
            zzfbType: null
        };
        //责任区
        $scope.area_dataList = []; //列表数据
        $scope.area_selectparams = {
            cgjqType: 2,
            partyCode: '',//党组织代码
            userId: AuthUser.getUser().Id,
            name: '',
            year: year,
            quarter: quarter,
            zzfbType: null
        };
        $scope.area_resetparams = {
            cgjqType: 2,
            partyCode: '',//党组织代码
            userId: AuthUser.getUser().Id,
            name: '',
            year: year,
            quarter: quarter,
            zzfbType: null
        };
        $scope.yearList = [];
        $scope.quarterList = [];
        $scope.scoreLevelList = [];


        //选择tab页
        $scope.selectTab = function (setTab) {
            $scope.activeTab = setTab;
            $scope.loadData($scope.activeTab);
        };
        //判断选中项
        $scope.isSelected = function (checkedTab) {
            return $scope.activeTab === checkedTab;

        };
        //监视页数变化
        $scope.$watch("selectparams.selectdzzdm", function (newVal, oldVal) {
            if (newVal != "") {
                $scope.post_selectparams.partyCode = $scope.selectparams.selectdzzdm;
                $scope.area_selectparams.partyCode = $scope.selectparams.selectdzzdm;
                $scope.loadData(1);
                $scope.loadData(2);
            }
        });

        $scope.$watch("selectparams.zzfbType", function (newVal, oldVal) {
            if (newVal != oldVal) {
                $scope.post_selectparams.zzfbType = $scope.selectparams.zzfbType;
                $scope.area_selectparams.zzfbType = $scope.selectparams.zzfbType;
                $scope.loadData(1);
                $scope.loadData(2);
            }
        });

        //查询
        $scope.search = function (cgjqType) {
            $scope.loadData(cgjqType);
        };

        //导出
        $scope.exportData = function (cgjqType) {
            var params = "?1=1";
            var sparams = cgjqType == 1 ? $scope.post_selectparams : $scope.area_selectparams;
            for (var p in sparams) {
                if (sparams[p] != '' && sparams[p] != null)
                    params += ("&" + p + "=" + encodeURI(sparams[p]));
            }
            window.open('../../api/cgjq/exportPostareaScoreOrder' + params);
        };

        //加载列表数据
        $scope.loadData = function (cgjqType) {
            var params = [];
            if (cgjqType == 1) {
                params = $scope.post_selectparams;
            } else {
                params = $scope.area_selectparams;
            }
            $http
            ({
                method: 'get', url: '../../api/cgjq/getPostareaScoreOrderList', params: params
            }).then(function (result) {
                if (cgjqType == 1) {
                    $scope.post_dataList = result.data;
                } else {
                    $scope.area_dataList = result.data;
                }
                $scope.addLevelWatch();
            });
        };

        $scope.addLevelWatch = function () {
            $.each($scope.post_dataList, function (index, item) {
                $scope.$watch('post_dataList[' + index + '].SCORELEVEL', function (newVal) {
                    $scope.updateScoreLevel(item.POSTAREASCOREID, newVal);
                });
            });

            $.each($scope.area_dataList, function (index, item) {
                $scope.$watch('area_dataList[' + index + '].SCORELEVEL', function (newVal) {
                    $scope.updateScoreLevel(item.POSTAREASCOREID, newVal);
                });
            });
        };
        //保存评定等级
        $scope.updateScoreLevel = function (postAreaScoreId, scoreLevel) {
            if (postAreaScoreId != "" && scoreLevel != null && scoreLevel != "") {
                $http({
                    method: 'post',
                    url: '../../api/cgjq/updateScoreLevel',
                    data: {
                        postAreaScoreId: postAreaScoreId,
                        scoreLevel: scoreLevel
                    }
                }).then(function (result) {
                    if (result.data.success) {
                        /*$scope.showMsg('成功', result.data.msg);
                        //重新刷新列表
                        $scope.pagechange();*/
                    } else {
                        $scope.showMsg('失败', result.data.msg);
                    }
                }, function () {
                    $scope.showMsg('错误', '服务器错误');
                });
            }
        };

        //编辑模块
        /*var showCtrl = function ($scope, $http) {
            $scope.params = postAreaModal.params;
            $scope.dataModel = postAreaModal.dataModel;
            $scope.scoreDataList = [];
            $scope.userList = [];

            //获取岗区评分数据
            $scope.getPostareaScoreList = function () {
                $http
                ({
                    method: 'get', url: '../../api/cgjq/getPostareaScoreProjectList', params: {
                        postAreaScoreId: $scope.dataModel.postareascoreid
                    }
                }).then(function (result) {
                    $scope.scoreDataList = result.data;
                });
            };
            $scope.getUserList = function () {
                $http
                ({
                    method: 'get',
                    url: '../../api/cgjq/getPostareaScoreUserList',
                    params: {pageindex: 1, pagesize: 10000, postAreaScoreId: $scope.dataModel.postareascoreid}
                }).then(function (result) {
                    $scope.userList = result.data.item.list;
                });
            };

            $scope.getPostareaScoreList();
            $scope.getUserList();
        };
        showCtrl.$inject = ['$scope', '$http'];
        //定义模态框
        var postAreaModal = $modal({
            resolve: {
                load: ['$ocLazyLoad', function ($ocLazyLoad) {
                }]
            },
            scope: $scope,
            controller: showCtrl,
            templateUrl: '../main/cgjq/score/scoresort/show.html',
            show: false,
            animation: 'am-fade-and-slide-top'
        });*/
        //获取数据
        $scope.showData = function (postAreaScoreId, cgjqType) {
            $bsRouterState.go('home.cgjqScoreShow', {id: postAreaScoreId, cgjqType: cgjqType});
            /*$http.get("../../api/cgjq/getPostareaScoreById", {
                params: {
                    'id': postAreaScoreId,
                    cgjqType: cgjqType
                }
            }).then(function (result) {
                $loading.hide();
                if (result.data.success) {
                    postAreaModal.dataModel = result.data.item;
                    postAreaModal.$promise.then(postAreaModal.show);
                } else {
                    $scope.showMsg('错误', result.data.msg);
                }
            }, function () {
                $loading.hide();
                $scope.showMsg('错误', '服务器错误');
            });*/

        };

        //导出申报表
        $scope.export = function (postAreaScoreId, cgjqType) {
            window.open('../../api/cgjq/createWord?id=' + postAreaScoreId);
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

        $scope.getYearsList();
        $scope.getQuartersList();
        $scope.getScoreLevelList();

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

        $scope.isShowClick = function(){
            $scope.isShow=!$scope.isShow;
            if($scope.moreTxt == "更多")
            {
                $scope.moreTxt = "收起";
            }
            else if($scope.moreTxt == "收起")
            {
                $scope.moreTxt = "更多";
            }
        };
        $scope.setisunfold = function () {
            $scope.selectparams.isunfold = !$scope.selectparams.isunfold;
            $scope.$emit('menudatas.toggle', !$scope.selectparams.isunfold);
        };
        $scope.reset  = function () {
            // var $form = $scope.myform;
            // var $names = $form.$$controls;
            // angular.forEach($names, function (val) {
            //     val
            // });
            // $scope.myform.$setPristine();
            // $scope.myform.$setUntouched();
            //$scope.selectparams.selectdzzdm = $scope.resetparams.selectdzzdm;
            //$scope.selectparams.selectdzzmc = $scope.resetparams.selectdzzmc;
            //$scope.selectparams.defaultselected = $scope.resetparams.defaultselected;
            //$scope.selectparams.parentname = $scope.resetparams.parentname;
            //$scope.selectparams.szdzzdm = $scope.resetparams.szdzzdm;
            //$scope.selectparams.szdzzmc = $scope.resetparams.szdzzmc;
            $scope.area_selectparams.year = $scope.area_resetparams.year;
            //$scope.selectparams.dzzdm = $scope.resetparams.dzzdm;
            $scope.area_selectparams.quarter = $scope.area_resetparams.quarter;
            $scope.post_selectparams.year = $scope.post_resetparams.year;
            $scope.post_selectparams.quarter = $scope.post_resetparams.quarter;
            // $scope.selectparams.jldzzrq_end = $scope.resetparams.jldzzrq_end;
            // $scope.selectparams.isContainParent = $scope.resetparams.isContainParent;
            // $scope.selectparams.zzfbType = $scope.resetparams.zzfbType;
            //$scope.selectparams.selectdzzmc = $scope.selectparams.dzzmc = $scope.selectparams.zzlb = $scope.selectparams.jczzfl = '';
        }

    });
})(angular);