(function ($app) {
    $app.module('gtPartyApp').controller('partyShowCtrl', function ($scope, $http, $modal, $ocLazyLoad, $alert, $loading, $state, $partySelect, $stateParams, $bsRouterState, $partySelect, $timeout, AuthUser) {

        $stateParams = $bsRouterState.$params($scope);

        $scope.op = $stateParams.op;
        $scope.partyModel = {
            zzqkxxbs: $stateParams.id == undefined ? "" : $stateParams.id,
            dzzdm: $stateParams.dzzdm == undefined ? "" : $stateParams.dzzdm
        };
        $scope.partyExt = {
            dzzdm_short: ''
        };
        $scope.parentParty = {};
        $scope.partyFBModel = {
            zzlb: null,
            jczzfl: null,
            zgrs: null
        };
        $scope.jcModel = {};
        $scope.zzlbdmList = [];//组织类别
        $scope.jczzflList = [];//基层组织分类
        $scope.gradeUserList = []; //领导班子成员


        $scope.loadPartyInfo = function () {
            $http.get("../../api/party/getPartyById", {
                params: {
                    'id': $scope.partyModel.zzqkxxbs,
                    'parent_dzzdm': $stateParams.parentcode,
                    'dzzdm': $scope.partyModel.dzzdm
                }
            }).then(function (result) {
                $loading.hide();
                $scope.partyModel = result.data.item;
                $scope.parentParty = result.data.extdata.parentParty;
                if ($scope.partyModel.dzzdm != null && $scope.partyModel.dzzdm != "") {
                    $scope.partyExt.dzzdm_short = $scope.partyModel.dzzdm.substring($scope.parentParty.dzzdm.length);
                }

                $scope.partyFBModel = result.data.extdata.partyFBModel;
                $scope.selectparams_GradeUser.ssdzzdm = $scope.partyModel.dzzdm;
                $scope.dnpx_Selectparams.ssdzzdm = $scope.partyModel.dzzdm;
                $scope.djkp_Selectparams.ssdzzdm = $scope.partyModel.dzzdm;
                $scope.dqgly_Selectparams.dzzdm = $scope.partyModel.dzzdm;

                $scope.getZzlbdmList();
                $scope.getJczzflList();

                if ($scope.partyModel.dzzdm != "" && $scope.partyModel.dzzdm != null) {
                    $scope.loadGradeList();
                    $scope.loadGradeUserList();
                    $scope.loadUserTotal();
                    $scope.loadChildTotal();
                    $scope.getDnpxList();
                    $scope.getDjkpList();
                    $scope.getPartyZLYList();
                }

            }, function () {
                $scope.showMsg('错误', '服务器错误');
            });
        };

        //领导班子
        $scope.loadGradeList = function () {
            $http
            ({
                method: 'get', url: '../../api/grade/getGradeList', params: {
                    'pageindex': 1,
                    'pagesize': 100,
                    ssdzzdm: $scope.partyModel.dzzdm,
                    ldjtjc: '',
                    xjfs: null
                }
            }).then(function (result) {
                if (result.data.item.list.length > 0) {
                    $scope.jcModel = result.data.item.list[0];
                }
            });
        };

        //领导班子成员
        {
            $scope.selectparams_GradeUser = {
                'pageindex': 1,
                'pagesize': 5,
                'dzzdm': $scope.partyModel.dzzdm,
                ssdzzdm: ''
            };
            $scope.pageInfo_GradeUser = {ptotal: 0};
            $scope.loadGradeUserList = function () {
                $http
                ({
                    method: 'get', url: '../../api/grade/getMaxGradeUserList', params: $scope.selectparams_GradeUser
                }).then(function (result) {
                    $scope.gradeUserList = result.data.item.list;
                    $scope.pageInfo_GradeUser.ptotal = result.data.item.total;
                });
            };
            //监视页数变化
            $scope.$watch("selectparams_GradeUser.pageindex", function (newVal, oldVal) {
                if ($scope.pageInfo_GradeUser.ptotal > 0) {
                    $scope.loadGradeUserList();
                }
            });
        }

        //党员统计
        $scope.loadUserTotal = function () {
            $http
            ({
                method: 'get', url: '../../api/partyExpand/getJoinUserTotalList', params: {
                    pageindex: 1,
                    pagesize: 10,
                    ssdzzdm: $scope.partyModel.dzzdm,//党组织代码
                }
            }).then(function (result) {
                if (result.data.item.list.length > 0) {
                    var data = result.data.item.list[0];
                    $scope.partyModel.ybdys = data.YBDY;
                    $scope.partyModel.rdjjfzs = data.JJFZ;
                    $scope.partyModel.sqrds = data.SQRD;
                    $scope.partyModel.fzdx = data.FZDX;
                }
            }, function (resp) {
                $scope.showMsg('错误', '服务器错误');
            });

            $http
            ({
                method: 'get', url: '../../api/bigdata/getPartyUserTotalList', params: {
                    dzzdm: $scope.partyModel.dzzdm,//党组织代码
                }
            }).then(function (res) {
                if (res.data != null) {
                    $scope.partyModel.dys = res.data.TOTAL;
                    $scope.partyModel.zgcount = res.data.ZGCOUNT;
                    $scope.partyModel.ltxcount = res.data.LTXCOUNT;
                }

            }, function (resp) {
                $scope.showMsg('错误', '服务器错误');
            });
        };

        //党组织统计
        $scope.loadChildTotal = function () {
            $http
            ({
                method: 'get', url: '../../api/party/getChildPartyCount', params: {
                    dzzdm: $scope.partyModel.dzzdm,//党组织代码
                    ssdzzdm: $scope.partyModel.dzzdm,//党组织代码
                }
            }).then(function (result) {
                if (result.data.length > 0) {
                    var data = result.data[0];
                    $scope.partyModel.childCount = data.CHILDCOUNT;
                }

            }, function (resp) {
                $scope.showMsg('错误', '服务器错误');
            });
        };

        // //党内评先
        // {
        //     $scope.dnpx_DataList = [];
        //     $scope.dnpx_Selectparams = {
        //         'pageindex': 1,
        //         'pagesize': 5,
        //         dzzdm: $scope.partyModel.dzzdm,
        //         pxlx: 2,
        //         ssdzzdm: $scope.partyModel.dzzdm
        //     };
        //     $scope.dnpx_PageInfo = {ptotal: 0};
        //     $scope.getDnpxList = function () {
        //         $http
        //         ({
        //             method: 'get', url: '../../api/partyTowExt/getDnpxxxList', params: $scope.dnpx_Selectparams
        //         }).then(function (result) {
        //             $scope.dnpx_DataList = result.data.item.list;
        //             $scope.dnpx_PageInfo.ptotal = result.data.item.total;
        //         });
        //     };

        //     //监视页数变化
        //     $scope.$watch("dnpx_Selectparams.pageindex", function (newVal, oldVal) {
        //         if ($scope.dnpx_PageInfo.ptotal > 0) {
        //             $scope.getDnpxList();
        //         }
        //     });
        // }

        //党建考评
        {
            $scope.djkp_DataList = [];
            $scope.djkp_Selectparams = {
                'pageindex': 1,
                'pagesize': 5,
                dzzdm: $scope.partyModel.dzzdm,
                ssdzzdm: $scope.partyModel.dzzdm
            };
            $scope.djkp_PageInfo = {ptotal: 0};
            $scope.getDjkpList = function () {
                $http
                ({
                    method: 'get', url: '../../api/partyTowExt/getDjkpxxList', params: $scope.djkp_Selectparams
                }).then(function (result) {
                    $scope.djkp_DataList = result.data.item.list;
                    $scope.djkp_PageInfo.ptotal = result.data.item.total;
                });
            };

            //监视页数变化
            $scope.$watch("djkp_Selectparams.pageindex", function (newVal, oldVal) {
                if ($scope.djkp_PageInfo.ptotal > 0) {
                    $scope.getDjkpList();
                }
            });
        }

        // //党群管理人员情况
        // {
        //     $scope.dqgly_DataList = [];
        //     $scope.dqgly_Selectparams = {
        //         'pageindex': 1,
        //         'pagesize': 5,
        //         dzzdm: $scope.partyModel.dzzdm
        //     };
        //     $scope.dqgly_PageInfo = {ptotal: 0};
        //     $scope.getPartyZLYList = function () {
        //         $http
        //         ({
        //             method: 'get', url: '../../api/party/getPartyZLYList', params: $scope.dqgly_Selectparams
        //         }).then(function (result) {
        //             result.data.item.list.forEach(item => {
        //                 if ($scope.dqgly_DataList.filter(it => it.XM == item.XM).length <= 0) {
        //                     $scope.dqgly_DataList.push({
        //                         XM: item.XM,
        //                         ZWMC: item.ZWMC,
        //                         SZDZBMC: item.SZDZBMC,
        //                         JSZWMC: item.JSZWMC
        //                     });
        //                 }
        //             });
        //             //$scope.dqgly_DataList = result.data.item.list;
        //             $scope.dqgly_PageInfo.ptotal = $scope.dqgly_DataList.length;
        //         });
        //     };

        //     //监视页数变化
        //     $scope.$watch("dqgly_Selectparams.pageindex", function (newVal, oldVal) {
        //         if ($scope.dqgly_PageInfo.ptotal > 0) {
        //             $scope.getPartyZLYList();
        //         }
        //     });
        // }

        //组织类别
        $scope.getZzlbdmList = function () {
            $http({
                method: 'get',
                url: '../../api/partyDic/getZzlbdmList',
                params: {}
            }).then(function (result) {
                $scope.zzlbdmList = result.data;
                angular.forEach(result.data, function (val) {
                    if (val.bm == $scope.partyFBModel.zzlb) {
                        $scope.partyFBModel.zzlbmc = val.hzmc;
                    }
                });
            }, function (resp) {
            });
        };
        //基层组织分类
        $scope.getJczzflList = function () {
            $http({
                method: 'get',
                url: '../../api/partyDic/getJczzflList',
                params: {}
            }).then(function (result) {
                $scope.jczzflList = result.data;
            }, function (resp) {
            });
        };

        //数据初始化
        $scope.loadPartyInfo();


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