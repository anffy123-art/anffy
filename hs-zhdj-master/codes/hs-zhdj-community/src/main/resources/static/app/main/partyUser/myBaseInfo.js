(function ($app) {
    $app.module('gtPartyApp').controller('myBaseInfoCtrl', function ($scope, $http, $modal, $ocLazyLoad, $alert, $loading, $state, $partySelect, $stateParams, $bsRouterState, AuthUser, $filter) {
        $stateParams = $bsRouterState.$params($scope);

        $scope.pictureurl = "../../api/home/showImg/" + AuthUser.getUser().Id;

        //定义数据集合
        $scope.ryztList = [];//人员状态
        $scope.cgcjlbList = [];//出国出境类别
        $scope.cgcjyyList = [];//出国出境原因
        $scope.pxqkList = [];//培训情况
        $scope.yxqkList = [];//一线情况
        $scope.zjpxjgList = [];//最近培训结果
        $scope.gzgwList = [];//工作岗位
        $scope.boolList = [{dickey: 1, dicvalue: '是'}, {dickey: 0, dicvalue: '否'}];
        $scope.djztList = [];

        $scope.dyvm = {
            rybm: AuthUser.getUser().Id == undefined ? "" : AuthUser.getUser().Id,
            ryjbxxbs: "",
            userType: AuthUser.getUser().userType == undefined ? "" : AuthUser.getUser().userType//1 站内，2路外
        };
        $scope.fbModel = {};//副表信息
        $scope.djxxModel = {};//党籍信息
        $scope.djxxFBModel = {};

        $scope.isDetail = $stateParams.isDetail == 1 ? true : false;
        $scope.uservm = {};
        $scope.szdzbmc = "";
        $scope.mobile = "";


        $scope.loadUser = function () {
            var url = $scope.dyvm.userType == 1 ? "../../api/partyUser/getPartyUserById_ZN" : "../../api/partyUser/getPartyUserById_LW";
            $http.get(url, {
                params: {
                    'id': $scope.dyvm.ryjbxxbs,
                    'rybm': $scope.dyvm.rybm
                }
            }).then(function (result) {
                $scope.dyvm = result.data.item;
                $scope.uservm = result.data.extdata.user_rs;
                $scope.mobile = result.data.extdata.mobile;
                $scope.extdata = result.data.extdata;
                $scope.fbModel = result.data.extdata.fbModel;
                $scope.djxxModel = result.data.extdata.djxxModel;
                $scope.djxxFBModel = result.data.extdata.djxxFBModel;
                $scope.szdzbmc = result.data.extdata.zzZzqkxx.dzzmc;
                $scope.mzpy_Selectparams.rybm = $scope.uservm.rybm;

                if ($scope.uservm.rybm != null && $scope.uservm.rybm != '') {
                    $scope.getRyztList();
                    $scope.getDjztList();
                    $scope.loadDnpxData($scope.uservm.rybm);
                    $scope.loadJvcfData($scope.uservm.rybm);
                    $scope.loadDnbfData($scope.uservm.rybm);
                    $scope.getUserLeaderTotalList();
                    $scope.getMZPYList();
                    $scope.loadGradeUserList($scope.extdata.dwid, $scope.uservm.rybm);
                }

            }, function () {
                $scope.showMsg('错误', '服务器错误');
            });
        };

        //领导人员落实组织生活“5+3”制度情况
        $scope.userLeaderTotalList = [];
        $scope.getUserLeaderTotalList = function () {
            $http.get("../../api/bigdata/getUserLeaderTotalList", {
                params: {
                    userCode: $scope.uservm.rybm,
                    year: $filter('date')(new Date(), 'yyyy')
                }
            }).then(function (result) {
                $scope.userLeaderTotalList = result.data;

            }, function () {
                $scope.showMsg('错误', '服务器错误');
            });
        };

        $scope.showFSDetail = function (type) {
            $bsRouterState.$closeTabName("home.userLeaderList");
            $timeout(function () {
                $bsRouterState.go('home.userLeaderList', {
                    leaderType: type
                });
            }, 100);
        };

        //领导班子成员
        $scope.gradeUserList = [];
        $scope.loadGradeUserList = function (dwid, rybm) {
            $http
            ({
                method: 'get', url: '../../api/grade/getMaxGradeUserList', params: {
                    'pageindex': 1,
                    'pagesize': 5,
                    ssdzzdm: dwid,
                    rybm: rybm
                }
            }).then(function (result) {
                $scope.gradeUserList = result.data.item.list;
            });
        };

        //人员状态
        $scope.getRyztList = function () {
            $http({
                method: 'get',
                url: '../../api/partyDic/getRyztList',
                params: {}
            }).then(function (result) {
                $scope.ryztList = result.data;
                angular.forEach(result.data, function (val) {
                    if (val.bm == $scope.dyvm.ryzt) {
                        $scope.dyvm.RYZTMC = val.hzmc;
                    }
                });
            }, function (resp) {
            });
        };
        //工作岗位
        $scope.getGzgwList = function () {
            $http({
                method: 'get',
                url: '../../api/partyDic/getGzgwList',
                params: {}
            }).then(function (result) {
                $scope.gzgwList = result.data;
            }, function (resp) {
            });
        };
        //党籍状态
        $scope.getDjztList = function () {
            $http({
                method: 'get',
                url: '../../api/dictionary/getDictionaryListByDicTypeKey',
                params: {
                    dicTypeKey: 'djzt'
                }
            }).then(function (result) {
                $scope.djztList = result.data;
                angular.forEach(result.data, function (val) {
                    if (val.dickey == $scope.djxxFBModel.djzt) {
                        $scope.djxxFBModel.djztmc = val.dicvalue;
                    }
                });

            }, function (resp) {

            });
        };
        $scope.dnpxparams = {
            'pageindex': 1,
            'pagesize': 10,
            'selectdzzdm': '',
            'rybm': null,
            'ptotal': 0,
            datalist: []
        };
        //监视页数变化
        $scope.$watch("dnpxparams.pageindex", function (newVal, oldVal) {
            if ($scope.dnpxparams.ptotal > 0) {
                $scope.loadDnpxData($scope.uservm.rybm);
            }
        });
        //加载党内评先列表数据
        $scope.loadDnpxData = function (rybm) {
            $scope.dnpxparams.rybm = rybm;
            $http
            ({
                method: 'get', url: '../../api/partyTowExt/getDnpxxxList', params: $scope.dnpxparams
            }).then(function (result) {
                $scope.dnpxparams.datalist = result.data.item.list;
                $scope.dnpxparams.ptotal = result.data.item.total;
            });
        };
        $scope.jlcfparams = {
            'pageindex': 1,
            'pagesize': 10,
            'selectdzzdm': '',
            'rybm': null,
            'ptotal': 0,
            datalist: []
        };
        //监视页数变化
        $scope.$watch("jlcfparams.pageindex", function (newVal, oldVal) {
            if ($scope.jlcfparams.ptotal > 0) {
                $scope.loadJvcfData($scope.uservm.rybm);
            }
        });
        //加载纪律处分列表数据
        $scope.loadJvcfData = function (rybm) {
            $scope.jlcfparams.rybm = rybm;
            $http
            ({
                method: 'get', url: '../../api/partyTowExt/getJlcfxxList', params: $scope.jlcfparams
            }).then(function (result) {
                $scope.jlcfparams.datalist = result.data.item.list;
                $scope.jlcfparams.ptotal = result.data.item.total;
            });
        };

        $scope.dnbfparams = {
            'pageindex': 1,
            'pagesize': 10,
            'selectdzzdm': '',
            'rybm': null,
            'ptotal': 0,
            datalist: []
        };
        //监视页数变化
        $scope.$watch("dnbfparams.pageindex", function (newVal, oldVal) {
            if ($scope.dnbfparams.ptotal > 0) {
                $scope.loadDnbfData($scope.uservm.rybm);
            }
        });
        //加载党内帮扶列表数据
        $scope.loadDnbfData = function (rybm) {
            $scope.dnbfparams.rybm = rybm;
            $http
            ({
                method: 'get', url: '../../api/partyTowExt/getDnghbfDetailsList', params: $scope.dnbfparams
            }).then(function (result) {
                $scope.dnbfparams.datalist = result.data.item.list;
                $scope.dnbfparams.ptotal = result.data.item.total;
            });
        };

        //党群管理人员情况
        {
            $scope.mzpy_DataList = [];
            $scope.mzpy_Selectparams = {
                'pageindex': 1,
                'pagesize': 5,
                rybm: ''
            };
            $scope.mzpy_PageInfo = {ptotal: 0};
            $scope.getMZPYList = function () {
                $http
                ({
                    method: 'get', url: '../../api/partyUser/getMZPYList', params: $scope.mzpy_Selectparams
                }).then(function (result) {
                    $scope.mzpy_DataList = result.data.item.list;
                    $scope.mzpy_PageInfo.ptotal = result.data.item.total;
                });
            };

            //监视页数变化
            $scope.$watch("mzpy_Selectparams.pageindex", function (newVal, oldVal) {
                if ($scope.mzpy_PageInfo.ptotal > 0) {
                    $scope.getMZPYList();
                }
            });
        }

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