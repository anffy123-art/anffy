(function ($app) {
    $app.module('gtPartyApp').controller('pu_ArchiveListCtrl', function ($scope, $http, $modal, $ocLazyLoad, $alert, $loading, $state, $bsRouterState, AuthUser, $timeout, $excel, $partySelect, $filter) {
        $state.params = $bsRouterState.$params($scope);
        $scope.loginUserId = AuthUser.getUser().Id;
        $scope.isShow = false;
        $scope.moreTxt = "更多";
        $scope.boolList = [{dickey: 1, dicvalue: '是'}, {dickey: 0, dicvalue: '否'}];
        $scope.pageId = "pu_ArchiveList";

        //定义数据集合
        $scope.dataList = []; //列表数据
        $scope.xbList = [{BM: '1', HZMC: '男'}, {BM: '2', HZMC: '女'}];
        $scope.xlList = [];
        $scope.isShow = false;
        $scope.moreTxt = "更多";
        //组织树参数
        $scope.treeparams = {
            isunfold: false,//组织结构树展开收缩
            selectdzzdm: "",
            selectdzzmc: "",
            defaultselected: $state.params.dzzdm
        };
        //查询条件
        $scope.selectparams = {
            pageindex: 1,
            pagesize: 10,
            dzzdm: '',
            inPatyStartDate: null,
            inPatyEndDate: null,
            userCode: '',
            gradeName: '',
            className: '',
            sexId: null,
            isStudent: null,
            educationalId: null,
            isArchive: 1,
            userStatus: null,
            userNo:''
        };
        $scope.pageInfo = {ptotal: 0};
        //加载列表数据
        $scope.getList = function () {
            $http
            ({
                method: 'get', url: '../../api/partyUserAdmit/getList', params: $scope.selectparams
            }).then(function (result) {
                $scope.dataList = result.data.item.list;
                $scope.pageInfo.ptotal = result.data.item.total;
            }, function (res) {
                $scope.showMsg('错误', '服务器错误');
            });
        };

        $scope.search = function () {
            $scope.getList();
        };

        $scope.unArchive = function () {
            var ids = $.map($filter('filter')($scope.dataList, {rowChecked: true}), function (x) {
                return x.userCode;
            });

            if (ids.length <= 0) {
                $scope.showMsg('提示', "请选择需要还原的数据");
                return false;
            }

            if (confirm("确认还原？")) {
                $loading.show();
                $http({
                    method: "post",
                    url: "../../api/partyUserAdmit/unArchive",
                    data: {
                        userCodes: JSON.stringify(ids)
                    }
                }).then(function (result) {
                    $loading.hide();
                    if (result.data.success) {
                        $scope.showMsg('成功', "操作成功");
                        $scope.getList();
                    } else {
                        $scope.showMsg('失败', result.data.msg);
                    }
                }, function (resp) {
                    $loading.hide();
                    $scope.showMsg('错误', '服务器错误：' + resp.data);
                });
            }
        };

        $scope.$watch("selectparams.pageindex", function (newVal, oldVal) {
            if ($scope.pageInfo.ptotal > 0) {
                $scope.getList();
            }
        });
        $scope.$watch("treeparams.selectdzzdm", function (newVal, oldVal) {
            if (newVal != "") {
                if ($scope.treeparams.defaultselected != "" && $scope.treeparams.defaultselected != null &&
                    $scope.treeparams.defaultselected != $scope.treeparams.selectdzzdm)
                    return;

                $scope.selectparams.dzzdm = $scope.treeparams.selectdzzdm;

                $scope.getList();
            }
        });
        $scope.setisunfold = function () {
            $scope.treeparams.isunfold = !$scope.treeparams.isunfold;
            $scope.$emit('menudatas.toggle', !$scope.treeparams.isunfold);
        };
        $scope.isShowClick = function () {
            $scope.isShow = !$scope.isShow;
            if ($scope.moreTxt == "更多") {
                $scope.moreTxt = "收起";
            } else if ($scope.moreTxt == "收起") {
                $scope.moreTxt = "更多";
            }
        };

        //人员状态
        $scope.getRyztList = function () {
            $http({
                method: 'get',
                url: '../../api/partyDic/getRyztList',
                params: {}
            }).then(function (result) {
                $scope.ryztList = result.data.filter(it => it.bm != '9');
            }, function (resp) {
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
        $scope.getEducationList = function () {
            $http({
                method: 'get',
                url: '../../api/partyDic/getEducationList'
            }).then(function (result) {
                $scope.xlList = result.data;
            }, function (resp) {

            });
        };

        $scope.getRyztList();
        $scope.getEducationList();

    });
})(angular);