(function ($app) {
    $app.module('gtPartyApp').controller('gdwydqkCtrl', function ($scope, $filter, $http, $modal, $ocLazyLoad, $timeout, $alert, $loading, $state, AuthUser, $stateParams, $excel, $bsRouterState) {
        $state.params = $bsRouterState.$params($scope);
        $scope.isShow = false;
        $scope.moreTxt = "更多";


        $scope.treeConfig = {
            url: '../../api/adPartyGroup/getTree',
            isunfold: false,
            value: '',
            name: ''
        };

        $scope.setisunfold = function () {
            $scope.treeConfig.isunfold = !$scope.treeConfig.isunfold;
            $scope.$emit('menudatas.toggle', !$scope.treeConfig.isunfold);
        };

        $scope.$watch('treeConfig.value', function (newVal, oldVal) {
            $scope.selectparams.groupId = newVal;
            $scope.loadData();
        });

        //定义数据集合
        $scope.dataList = []; //列表数据
        $scope.isDetail = true;
        //初始化查询参数
        $scope.selectparams = {
            isunfold: false,//组织结构树展开收缩
            'pageindex': 1,
            'pagesize': 10,
            dzzmc: '',
            yearmonth: '',
            date: new Date(moment(new Date()).add(-1, 'month')),
            groupId: ''
        };
        $scope.resetparams = {
            isunfold: false,//组织结构树展开收缩
            'pageindex': 1,
            'pagesize': 10,
            dzzmc: '',
            yearmonth: '',
            date: new Date(moment(new Date()).add(-1, 'month')),
            groupId: ''
        };
        $scope.pageInfo = {ptotal: 0};
        //监视页数变化
        $scope.$watch("selectparams.pageindex", function (newVal, oldVal) {
            if ($scope.pageInfo.ptotal > 0) {
                $scope.loadData();
            }
        });
        //监视党组织选中变化
        $scope.$watch("selectparams.selectdzzdm", function (newVal, oldVal) {
            if (newVal != '' && newVal != null) {

                if ($scope.selectparams.defaultselected != "" && $scope.selectparams.defaultselected != null &&
                    $scope.selectparams.defaultselected != $scope.selectparams.selectdzzdm)
                    return;

                $scope.selectparams.defaultselected = "";

                $scope.selectparams.dzzdm = $scope.selectparams.selectdzzdm;
                $scope.loadData();
            }
        });


        $scope.$on('tabChildReloadData', function (event, data) {
            if (data.name == 'ztdrxxCtrl') {
                $scope.loadData();
            }
        });
        //查询
        $scope.search = function () {
            $scope.loadData();
        };

        //加载列表数据
        $scope.loadData = function () {
            $scope.selectparams.yearmonth = $filter('date')($scope.selectparams.date, 'yyyyMM')
            $http
            ({
                method: 'get', url: '../../api/partyTowExt/getGdwydqkList', params: $scope.selectparams
            }).then(function (result) {
                $scope.dataList = result.data.item.list;
                $scope.pageInfo.ptotal = result.data.item.total;
            });
        };

        $scope.delete = function () {
            var ids = $.map($filter('filter')($scope.dataList, {checked: 1}), function (x) {
                return x.ID;
            });
            if (confirm("确定删除？")) {
                $http({
                    method: 'post',
                    url: '../../api/partyTowExt/deleteGdwydqkList',
                    data: {
                        ids: JSON.stringify(ids)
                    }
                }).then(function (result) {
                    $scope.showMsg('成功', result.data.msg);
                    $scope.isAll = false;
                    $scope.loadData();
                }, function () {
                    $scope.showMsg('错误', '服务器错误');
                });
            }
        };

        $scope.export = function () {
            var params = "?1=1";
            for (var p in $scope.selectparams) {
                if ($scope.selectparams[p] !== '' && $scope.selectparams[p] !== null)
                    params += ("&" + p + "=" + encodeURI($scope.selectparams[p]));
            }
            window.open('../../api/partyTowExt/exportGdwydqk' + params);
        };
        $scope.isAll = false;
        $scope.selectAll = function () {
            $scope.isAll = !$scope.isAll;
            angular.forEach($scope.dataList, function (item) {
                item.checked = $scope.isAll ? 1 : 0;
            });
        };
        //导入
        $scope.excelConfig = {
            filetype: 1,
            columns: {
                '单位名称': 'dzzmc',
                '年月': 'ny',
                '单位总人数': 'dwzrs',
                '单位关注总人数': 'dwgzzrs',
                '阅读量': 'ydl',
                '点赞量': 'dzl',
                '篇均阅读量': 'pjydl',
                '篇均点赞量': 'pjdzl',
                '到达率': 'ddl',
                '阅读率': 'ydlv',
                '点赞率': 'dzlv',
                '到达率得分': 'ddldf',
                '领导班子阅读量': 'ldbzydl',
                '党支部书记阅读量': 'dzbsjydl',
                '党员阅读量': 'dyydl',
            },
            errorcolumns: {
                'dzzmc': '单位名称',
                'ny': '年月',
                'dwzrs': '单位总人数',
                'dwgzzrs': '单位关注总人数',
                'ydl': '阅读量',
                'dzl': '点赞量',
                'pjydl': '篇均阅读量',
                'pjdzl': '篇均点赞量',
                'ddl': '到达率',
                'ydlv': '阅读率',
                'dzlv': '点赞率',
                'ddldf': '到达率得分',
                'ldbzydl': '领导班子阅读量',
                'dzbsjydl': '党支部书记阅读量',
                'dyydl': '党员阅读量',
                'errorInfo': '错误',
            },
            readonly: false,
            templateUrl: '../../doc/template/各单位阅读情况导入模板.xlsx'
        };
        $scope.import = function () {
            $excel.addFile($scope.excelConfig).then(function (items) {
                $loading.show();
                $http({
                    method: "post",
                    url: "../../api/partyTowExt/importGdwydqk",
                    data: {
                        userList: JSON.stringify(items)
                    }
                }).then(function (result) {
                    $loading.hide();
                    if (result.data.success) {
                        $scope.showMsg('成功', result.data.msg, 3);
                        $scope.loadData();
                    } else {
                        if (result.data.item.length > 0) {
                            $excel.showErrorInfo(result.data.item);
                        }
                    }

                }, function (resp) {
                    $loading.hide();
                    $scope.showMsg('错误', '服务器错误');
                })
            });
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
        $scope.isShowClick = function () {
            $scope.isShow = !$scope.isShow;
            if ($scope.moreTxt == "更多") {
                $scope.moreTxt = "收起";
            } else if ($scope.moreTxt == "收起") {
                $scope.moreTxt = "更多";
            }
        };

        $scope.reset = function () {

            $scope.selectparams.dzzmc = $scope.resetparams.dzzmc;
            $scope.selectparams.yearmonth = $scope.resetparams.yearmonth;
        }
        $scope.loadData();
    });
})(angular);
