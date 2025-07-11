(function ($app) {
    $app.module('gtPartyApp').controller('djkpBatchCtrl', function ($scope, $http, $modal, $ocLazyLoad, $timeout, $alert, $partySelect, $loading, $state, AuthUser, $stateParams, $bsRouterState) {
        $state.params = $bsRouterState.$params($scope);

        $scope.type = $state.params.type; //单位党组织工作考核=1， 党支部工作考核=2
        //定义数据集合
        $scope.dataList = []; //列表数据
        $scope.isDetail = true;
        //初始化查询参数
        $scope.selectparams = {
            isunfold: false,//组织结构树展开收缩
            'pageindex': 1,
            'pagesize': 999,
            'selectdzzdm': '',
            selectdzzmc: '',
            defaultselected: $state.params.dzzdm,
            parentcode: AuthUser.getUser().ParentDpCode,
            parentname: AuthUser.getUser().ParentDpName,
            dzzmc: $state.params.dzzmc == undefined ? AuthUser.getUser().DPName : $state.params.dzzmc,
            dzzdm: $state.params.dzzdm == undefined ? AuthUser.getUser().DPCode : $state.params.dzzdm,
            showdw: $state.params.type == 1 ? 1 : 0,
            showdzb: $state.params.type == 2 ? 1 : 0,
            showdxz: null,
            year: $state.params.year == undefined ? new Date().getFullYear() : $state.params.year,
            selectdzzdm: null
        };
        $scope.$watch("selectparams.year", function (newVal) {
            if (newVal) {
                $scope.selectparams.selectdzzdm = "";
                $scope.dataList = [];
            }
        }, true);
        //选择党支部
        $scope.partyTreeConfig = {
            scope: $scope,
            selectedKey: '',
            selectedText: '',
            selectedData: [],
            isMulti: false,
            isshowxz: 0
        };
        $partySelect.initServer($scope.partyTreeConfig);
        $scope.selectParty = function () {
            $partySelect.showModal();
        };
        $scope.$watch("partyTreeConfig.selectedKey", function (newVal, oldVal) {
            if (newVal) {
                $scope.selectparams.dzzdm = $scope.partyTreeConfig.selectedKey;
                $scope.selectparams.dzzmc = $scope.partyTreeConfig.selectedText;
                $scope.dzzdmOptions.selectParams.dzzdm = $scope.partyTreeConfig.selectedKey;
                $scope.dataList = [];
            }
        }, true);


        $scope.dzzdmOptions = {
            url: '../../api/partyTowExt/getParyDjkpList',
            title: '选择党组织',
            isMulti: true,
            selectData: {selectdzzmc: '组织名称'},
            columns: {
                DZZMC: '组织名称'
            },
            selectLabelKey: 'DZZMC',
            selectValuekey: 'DZZDM',
            selectedValueData: '',
            selectedLabeData: '',
            selectedJData: [],
            selectParams: {
                dzzdm: $scope.selectparams.dzzdm,
                year: $scope.selectparams.year,
                showdw: $scope.selectparams.showdw,
                showdzb: $scope.selectparams.showdzb
            }
        };
        $scope.$watch('dzzdmOptions.selectedValueData', function (newVal) {
            if (newVal != "") {
                $scope.selectparams.selectdzzdm = $scope.dzzdmOptions.selectedValueData;
                $scope.loadData();
            }
        })
        //加载列表数据
        $scope.loadData = function () {

            $http
            ({
                method: 'get', url: '../../api/partyTowExt/getParyDjkpList', params: $scope.selectparams
            }).then(function (result) {
                $scope.dataList = result.data.item.list;
                $scope.pageInfo.ptotal = result.data.item.total;
            });
        };

        $scope.getYearList = function () {
            $http({
                method: 'get',
                url: '../../api/dictionary/getDictionaryListByDicTypeKey',
                params: {
                    dicTypeKey: 'years'
                }
            }).then(function (result) {
                $scope.yearList = result.data;
            }, function (resp) {

            });
        };


        $scope.delete = function (index) {
            if (confirm("是否确定删除？")) {
                $scope.dataList.splice(index, 1);
            }
        };
        $scope.getJudgeLevelList = function () {
            $http({
                method: 'get',
                url: '../../api/dictionary/getDictionaryListByDicTypeKey',
                params: {
                    dicTypeKey: 'judgeLevel'
                }
            }).then(function (result) {
                $scope.judgeLevelList = result.data.filter(function (item) {
                    return item.dicnote == $scope.type.toString();
                });
            }, function (resp) {

            });
        };
        $scope.invalidFee = function (index, form1, name) {
            name = name + "_" + index;
            eval('var i=form1.' + name + '.$invalid');
            return i;
        };
        //数据初始化
        $scope.getJudgeLevelList();
        $scope.getYearList();

        $scope.all = function () {
            if ($scope.selectparams.dzzdm.length < 12 && $scope.type == 2) {
                $scope.showMsg('提示', "请选择党组织");
                return;
            }
            $scope.selectparams.pagesize = 999;
            $scope.selectparams.selectdzzdm = "";
            $scope.loadData();
        }
        //提交
        $scope.submitData = function (isflag) {
            if (isflag) {
                $loading.show();
                //数据处理
                var resultList = [];
                angular.forEach($scope.dataList, function (val, key) {
                    resultList.push({
                        quarter1: val.QUARTER1,
                        quarter2: val.QUARTER2,
                        quarter3: val.QUARTER3,
                        quarter4: val.QUARTER4,
                        judgelevel: val.JUDGELEVEL,
                        dzzdm: val.DZZDM,
                        year: $scope.selectparams.year,
                        id: val.ID,
                        dzzmc: val.DZZMC
                    });
                });
                $http({
                    method: "post",
                    url: "../../api/partyTowExt/saveDjkpxxByList",
                    data: {
                        dataList: JSON.stringify(resultList)
                    }
                }).then(function (result) {
                    $loading.hide();
                    $scope.showMsg('提示', result.data.msg);

                    if (result.data.success) {
                        $scope.$emit("tabReloadData", {name: 'djkpxxCtrl', data: 1});
                        //重新刷新列表
                        $scope.pagechange();
                        $scope.$hide();
                    }
                }, function (resp) {
                    $scope.showMsg('错误', '服务器错误');
                })
            }
        };
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