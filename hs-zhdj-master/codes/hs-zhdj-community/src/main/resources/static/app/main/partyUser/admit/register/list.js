(function ($app) {
    $app.module('gtPartyApp').controller('admitRegisterListCtrl', function ($scope, $http, $modal, $ocLazyLoad, $alert, $loading, $state, $bsRouterState, AuthUser, $timeout, $excel, $partySelect, $filter) {
        $state.params = $bsRouterState.$params($scope);
        $scope.loginUserId = AuthUser.getUser().Id;
        $scope.pageId = "admitRegisterList";
        $scope.userStatus = 1;

        //定义数据集合
        $scope.dataList = []; //列表数据
        $scope.xbList = [{BM: '1', HZMC: '男'}, {BM: '2', HZMC: '女'}];
        $scope.boolList = [{dickey: 1, dicvalue: '是'}, {dickey: 0, dicvalue: '否'}];
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
            userName: '',
            applyStartDate: null,
            applyEndDate: null,
            userStatus: $scope.userStatus,
            applyApproveStatus: 1,
            userCode: '',
            gradeName: '',
            className: '',
            sexId: null,
            isStudent: null,
            educationalId: null,
            isArchive: 0
        };
        $scope.pageInfo = {ptotal: 0};
        $scope.applyApproveStatusList = [];

        detailCtrl.$inject = ['$scope', '$http', '$alert', '$loading'];
        detailModal = $modal({
            resolve: {
                load: ['$ocLazyLoad', function ($ocLazyLoad) {
                }]
            },
            scope: $scope,
            controller: detailCtrl,
            templateUrl: '../main/partyUser/admit/register/detail.html',
            show: false,
            animation: 'am-fade-and-slide-top'
        });

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

        $scope.export = function () {
            var params = "?1=1&getType=" + 1;
            for (var p in $scope.selectparams) {
                if ($scope.selectparams[p] !== '' && $scope.selectparams[p] !== null)
                    params += ("&" + p + "=" + encodeURI($scope.selectparams[p]));
            }
            window.open('../../api/partyUserAdmit/exportPartyUserAdmit' + params);
        };

        $scope.detail = function (userCode) {
            detailModal.params = {
                userCode: userCode,
                title: "查看入党申请人信息"
            };
            detailModal.$promise.then(detailModal.show);
        };

        $scope.audit = function (status) {
            var ids = $.map($filter('filter')($scope.dataList, {rowChecked: true}), function (x) {
                return x.userCode;
            });

            if (ids.length <= 0) {
                $scope.showMsg('提示', "请选择需要审核的数据");
                return false;
            }

            if ($scope.dataList.filter(it => it.applyApproveStatus != 1 && it.rowChecked == true).length > 0) {
                $scope.showMsg('提示', "请选择待审核的数据");
                return false;
            }

            if (confirm(status == 2 ? "确认审核通过？" : "确认审核不通过？")) {
                $loading.show();
                $http({
                    method: "post",
                    url: "../../api/partyUserAdmit/audit",
                    data: {
                        userCodes: JSON.stringify(ids),
                        applyApproveStatus: status
                    }
                }).then(function (result) {
                    $loading.hide();
                    if (result.data.success) {
                        $scope.showMsg('成功', "审核成功");
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

        //获取字典数据
        $scope.getApplyApproveStatusList = function () {
            $http({
                method: 'get',
                url: '../../api/dictionary/getDictionaryListByDicTypeKey',
                params: {
                    dicTypeKey: 'ApplyApproveStatus'
                }
            }).then(function (result) {
                $scope.applyApproveStatusList = result.data;
            }, function (resp) {

            });
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

        $scope.getEducationList = function () {
            $http({
                method: 'get',
                url: '../../api/partyDic/getEducationList'
            }).then(function (result) {
                $scope.xlList = result.data;
            }, function (resp) {

            });
        };

        $scope.getEducationList();

        $scope.getApplyApproveStatusList();

    });
})(angular);