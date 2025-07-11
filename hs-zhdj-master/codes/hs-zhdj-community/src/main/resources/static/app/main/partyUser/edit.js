(function ($app) {
    $app.module('gtPartyApp').controller('partyUserEditCtrl', function ($scope, $http, $modal, $ocLazyLoad, $alert, $loading, $state, $partySelect, $stateParams, $bsRouterState) {
        $stateParams = $bsRouterState.$params($scope);

        //定义数据集合
        $scope.ryztList = [];//人员状态
        $scope.boolList = [];
        $scope.djztList = [];//党籍状态
        $scope.mzList = [];
        $scope.xbList = [];
        $scope.xlList = [];

        $scope.dyvm = {
            rybm: $stateParams.rybm == undefined ? "" : $stateParams.rybm,
            userType: $stateParams.rybm == undefined ? "" : $stateParams.userType //1 站内，2路外
        };
        $scope.fbModel = {ldrylxdbm: '', ldrylxdmc: ''};//副表信息
        $scope.djxxModel = {};//党籍信息

        $scope.isDetail = $stateParams.isDetail == 1 ? true : false;
        $scope.uservm = {};
        $scope.szdzbmc = "";
        $scope.mobile = "";

        $scope.selectPartylist = {
            url: '../../api/party/getPartyList',
            title: '选择党组织',
            isMulti: true,
            selectData: {dzzmc: '党组织名称'},
            columns: {DZZMC: '党组织名称', ZZLBMC: '组织类别', JCZZFLMC: '基层分类'},
            selectLabelKey: 'DZZMC',
            selectValuekey: 'DZZDM',
            selectedValueData: '',
            selectedLabeData: '',
            selectedJData: [],
            selectParams: {}
        };

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
                $scope.dyvm.szdzbdm = $scope.partyTreeConfig.selectedKey;
                $scope.szdzbmc = $scope.partyTreeConfig.selectedText;
            }
        }, true);

        //保存
        $scope.submitDyUser = function (isflag) {
            if (isflag) {
                if (confirm("确认提交？")) {
                    $loading.show();
                    $http({
                        method: "post",
                        url: "../../api/partyUser/savePartyUser",
                        data: {
                            ggZgjbxx: $scope.uservm,
                            dyModel: $scope.dyvm,
                            rybm: $scope.dyvm.rybm,
                            mobile: $scope.mobile,
                            fbModel: $scope.fbModel,
                            djxxModel: $scope.djxxModel
                        }
                    }).then(function (result) {
                        $loading.hide();
                        if (result.data.success) {
                            $scope.showMsg('成功', result.data.msg);
                            //重新刷新列表
                            $scope.$emit("tabReloadData", {name: 'partyUserListCtrl', data: 1});
                            $scope.pagechange();
                        } else {
                            $scope.showMsg('失败', result.data.msg);
                        }

                    }, function (resp) {
                        $scope.showMsg('错误', '服务器错误');
                    });
                }
            }
        };

        $scope.loadUser = function () {
            $http.get("../../api/partyUser/getPartyUserById_ZN", {
                params: {
                    'rybm': $scope.dyvm.rybm
                }
            }).then(function (result) {
                if (result.data.success) {
                    $scope.dyvm = result.data.item;
                    $scope.uservm = result.data.extdata.user_rs;

                    $scope.mobile = result.data.extdata.mobile;
                    $scope.extdata = result.data.extdata;
                    $scope.fbModel = result.data.extdata.fbModel;
                    $scope.djxxModel = result.data.extdata.djxxModel;
                    $scope.szdzbmc = result.data.extdata.zzZzqkxx.dzzmc;

                    $scope.boolList = [{dickey: true, dicvalue: '是'}, {dickey: false, dicvalue: '否'}];
                    $scope.xbList = [{BM: '1', HZMC: '男'}, {BM: '2', HZMC: '女'}];

                    $scope.getMZList();
                    $scope.getEducationList();
                    $scope.getRyztList();
                } else {
                    $scope.showMsg('获取人员数据失败', result.data.msg, 30);
                }
            }, function () {
                $scope.showMsg('错误', '服务器错误');
            });
        };

        //人员状态
        $scope.getRyztList = function () {
            $http({
                method: 'get',
                url: '../../api/partyDic/getRyztList',
                params: {}
            }).then(function (result) {
                $scope.ryztList = result.data.filter(it => (it.bm == '2' || it.bm == '3'));

            }, function (resp) {
            });
        };
        //民族
        $scope.getMZList = function () {
            $http({
                method: 'get',
                url: '../../api/partyDic/getNationList'
            }).then(function (result) {
                $scope.mzList = result.data;
            }, function (resp) {

            });
        };
        //学历
        $scope.getEducationList = function () {
            $http({
                method: 'get',
                url: '../../api/partyDic/getEducationList'
            }).then(function (result) {
                $scope.xlList = result.data;
            }, function (resp) {

            });
        };

        //数据初始化
        $scope.loadUser();

        $scope.pagechange = function () {
            var inTab = $bsRouterState.$getRouteType() == 'tab';
            if (inTab) {
                $bsRouterState.$closeTab($scope);
            } else {
                window.history.back();
            }
        };

    });
})(angular);