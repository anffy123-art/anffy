(function ($app) {
    $app.module('gtPartyApp').controller('cgjqSetting_ProjectListCtrl', function ($scope, $http, $modal, $ocLazyLoad, $alert, $loading, $state, $stateParams, AuthUser,$bsRouterState) {
        $state.params = $bsRouterState.$params($scope);

        //定义数据集合
        $scope.type = $state.params.type;
        $scope.pageList = [
            {id: 1, title: '责任岗', url: '../main/cgjq/setting/scoreproject/post.html'},
            {id: 2, title: '责任区', url: '../main/cgjq/setting/scoreproject/area.html'}];
        $scope.activeTab = $state.params.cgjqType == undefined ? 1 : $state.params.cgjqType;
        $scope.loginUserId = AuthUser.getUser().Id;
        $scope.selectparams = {
            isunfold: false,//组织结构树展开收缩
            selectdzzdm: '',
            selectdzzmc: '',
            zzfbType: null
        };
        $scope.isPartyZB = 0;//所选组织是否党支部
        //责任岗
        $scope.post_dataList = []; //列表数据
        $scope.post_selectparams = {
            cgjqType: 1,
            partyCode: '',//党组织代码
            zzfbType: null
        };
        //责任区
        $scope.area_dataList = []; //列表数据
        $scope.area_selectparams = {
            cgjqType: 2,
            partyCode: '',//党组织代码
            zzfbType: null
        };

        //选择tab页
        $scope.selectTab = function (setTab) {
            $scope.activeTab = setTab;
            $scope.loadData($scope.activeTab);
        };
        //判断选中项
        $scope.isSelected = function (checkedTab) {
            return $scope.activeTab === checkedTab;

        };

        $scope.$watch("selectparams.selectdzzdm", function (newVal, oldVal) {
            if (newVal != "") {
                $scope.post_selectparams.partyCode = $scope.selectparams.selectdzzdm;
                $scope.area_selectparams.partyCode = $scope.selectparams.selectdzzdm;
                $scope.post_dataList.length = 0;
                $scope.area_dataList.length = 0;
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

        //加载列表数据
        $scope.loadData = function (cgjqType) {
            $http({
                method: 'get',
                url: '../../api/party/isPartyZB',
                params: {dzzdm: $scope.selectparams.selectdzzdm}
            }).then(function (result) {
                $scope.isPartyZB = result.data;
                if ($scope.type == 2 && result.data == 0) {
                    return;
                }
                //加载数据
                var params = [];
                if (cgjqType == 1) {
                    params = $scope.post_selectparams;
                } else {
                    params = $scope.area_selectparams;
                }
                $http
                ({
                    method: 'get', url: '../../api/cgjq/getSettingScoreProjectList', params: params
                }).then(function (result) {
                    if (cgjqType == 1) {
                        $scope.post_dataList = result.data;
                    } else {
                        $scope.area_dataList = result.data;
                    }
                });
            });
        };

        $scope.saveData = function (isflag, cgjqType) {
            if (isflag) {
                var dataList = cgjqType == 1 ? $scope.post_dataList : $scope.area_dataList;
                var projectList = [];

                if ($scope.selectparams.selectdzzdm == "" || $scope.selectparams.selectdzzdm == null) {
                    $scope.showMsg('失败', "请选择党支部");
                    return false;
                }

                angular.forEach(dataList, function (val, key) {
                    projectList.push({
                        seetingprojectid: val.SEETINGPROJECTID,
                        projectname: val.PROJECTNAME,
                        content: val.CONTENT,
                        scorerefer: val.SCOREREFER,
                        sort: val.SORT
                    });
                });

                $loading.show();
                $http({
                    method: "post",
                    url: "../../api/cgjq/saveScoreProject",
                    data: {
                        cgjqType: cgjqType,
                        projectList: JSON.stringify(projectList),
                        dzzdm: $scope.selectparams.selectdzzdm
                    }
                }).then(function (result) {
                    $loading.hide();
                    if (result.data.success) {
                        $scope.showMsg('成功', result.data.msg);
                        //重新刷新列表
                        $scope.loadData($scope.dataModel.cgjqtype);
                        $scope.$hide();
                    } else {
                        $scope.showMsg('失败', result.data.msg);
                    }

                }, function (resp) {
                    $loading.hide();
                    $scope.showMsg('错误', '服务器错误');
                });
            }
        };
        //使用学校考核标准
        $scope.getJTData = function (cgjqType) {
            $http
            ({
                method: 'get',
                url: '../../api/cgjq/getSettingScoreProjectList',
                params: {cgjqType: cgjqType, partyCode: AuthUser.getUser().gddwdm}
            }).then(function (result) {
                if (cgjqType == 1) {
                    angular.forEach($scope.post_dataList, function (val) {
                        angular.forEach(result.data, function (jt) {
                            if (val.PROJECTNAME == jt.PROJECTNAME) {
                                val.CONTENT = jt.CONTENT;
                                val.SCOREREFER = jt.SCOREREFER;
                            }
                        });
                    });

                } else {
                    angular.forEach($scope.area_dataList, function (val) {
                        angular.forEach(result.data, function (jt) {
                            if (val.PROJECTNAME == jt.PROJECTNAME) {
                                val.CONTENT = jt.CONTENT;
                                val.SCOREREFER = jt.SCOREREFER;
                            }
                        });
                    });
                }
            });
        };

        //列表数据必填
        $scope.invalidFee = function (index, form1, name) {
            name = name + "_" + index;
            eval('var i=form1.' + name + '.$invalid');
            return i;
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
        $scope.setisunfold = function () {
            $scope.selectparams.isunfold = !$scope.selectparams.isunfold;
            $scope.$emit('menudatas.toggle', !$scope.selectparams.isunfold);
        };
        $scope.selectparams.selectdzzdm = $scope.type == 1 ? AuthUser.getUser().gddwdm : "";

    });
})(angular);