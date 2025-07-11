(function ($app) {
    $app.module('gtPartyApp').controller('partyListCtrl', function ($scope, $http, $modal, $ocLazyLoad, $alert, $loading, $state, AuthUser, $bsRouterState, $timeout) {
        $state.params = $bsRouterState.$params($scope);
        $scope.isShow = false;

        $scope.moreTxt = "更多";


        //定义数据集合
        $scope.treeList = []; //组织架构
        $scope.dataList = []; //列表数据
        $scope.zzlbdmList = [];//组织类别
        $scope.jczzflList = [];//基层组织分类
        $scope.isDetail = true;
        $scope.dwjbList = [{dickey: 1, dicvalue: '一级党委'}, {dickey: 2, dicvalue: '二级党委'}];
        //初始化查询参数
        $scope.selectparams = {
            isunfold: false,//组织结构树展开收缩
            'pageindex': 1,
            'pagesize': 10,
            selectdzzdm: '',
            selectdzzmc: '',
            defaultselected: $state.params.dzzdm,
            parentcode: AuthUser.getUser().DPCode,
            parentname: AuthUser.getUser().ParentDpName,
            szdzzdm: AuthUser.getUser().DPCode,
            szdzzmc: AuthUser.getUser().DPName,
            dzzmc: '',
            dzzdm: '',
            //zzlb: $state.params.zzlb == undefined ? null : $state.params.zzlb,
            jczzfl: $state.params.jczzfl == undefined ? null : $state.params.jczzfl,
            jldzzrq_begin: $state.params.jldzzrq_begin == undefined ? '' : $state.params.jldzzrq_begin,
            jldzzrq_end: $state.params.jldzzrq_end == undefined ? '' : $state.params.jldzzrq_end,
            isContainParent: null,
            userid: AuthUser.getUser().Id,
            zzfbType: null,
            hjYear: $state.params.hjYear == undefined ? null : $state.params.hjYear, //是否换届

            dwjb: $state.params.dwjb == undefined ? null : $state.params.dwjb,
            jmrq_begintime: $state.params.jmrq_begintime == undefined ? '' : $state.params.jmrq_begintime,
            jmrq_endtime: $state.params.jmrq_endtime == undefined ? '' : $state.params.jmrq_endtime,

            /*zzlbList: $state.params.zzlb == undefined ? null : $state.params.zzlb.split(','),
            zzlbArray: $state.params.zzlb == undefined ? ['1'] : $state.params.zzlb.split(',')*/

            zzlbList: $state.params.zzlb == undefined ? null : $state.params.zzlb,
            partyGroupId:''
        };
        $scope.resetparams = {
            isunfold: false,//组织结构树展开收缩
            'pageindex': 1,
            'pagesize': 10,
            selectdzzdm: '',
            selectdzzmc: '',
            defaultselected: $state.params.dzzdm,
            parentcode: AuthUser.getUser().DPCode,
            parentname: AuthUser.getUser().ParentDpName,
            szdzzdm: AuthUser.getUser().DPCode,
            szdzzmc: AuthUser.getUser().DPName,
            dzzmc: '',
            dzzdm: '',
            zzlb: null,
            zzlbList:null,
            jczzfl: null,
            jldzzrq_begin: '',
            jldzzrq_end: '',
            isContainParent: null,
            userid: AuthUser.getUser().Id,
            zzfbType: null
        };
        $scope.pageInfo = {ptotal: 0};
        //监视页数变化
        $scope.$watch("selectparams.pageindex", function (newVal, oldVal) {
            if ($scope.pageInfo.ptotal > 0) {
                $scope.loadData();
            }
        });

        $scope.$watch("selectparams.selectdzzdm + selectparams.partyGroupId", function (newVal, oldVal) {
            if (newVal != '' && newVal != null) {

                if ($scope.selectparams.defaultselected != "" && $scope.selectparams.defaultselected != null &&
                    $scope.selectparams.defaultselected != $scope.selectparams.selectdzzdm)
                    return;

                $scope.selectparams.defaultselected = "";

                if ($scope.selectparams.selectdzzdm == AuthUser.getUser().gddwdm) {
                    $scope.selectparams.isContainParent = -1;
                }
                $scope.selectparams.parentcode = $scope.selectparams.selectdzzdm;//.substring(0, $scope.selectparams.selectdzzdm.length - 3);
                $scope.loadData();
            }
        });

       /* $scope.$watch("selectparams.partyGroupId", function (newVal, oldVal) {
            if (newVal != '' && newVal != null) {
                $scope.loadData();
            }
        });*/

        $scope.$watch("selectparams.zzfbType", function (newVal, oldVal) {
            if (newVal != oldVal) {
                $scope.loadData();
            }
        });

        /*$scope.$watch("selectparams.zzlbArray", function (newVal, oldVal) {
            if (newVal.join(",") != oldVal.join(",")) {
                if (newVal.join(",") == "1") {
                    $scope.selectparams.zzlbList = [];
                } else {
                    $scope.selectparams.zzlbList = newVal.join(",");
                }
                $scope.loadData();
            }
        });*/

        $scope.$on('tabChildReloadData', function (event, data) {
            if (data.name == 'partyListCtrl') {
                $scope.loadData();
            }
        });

        //查询
        $scope.search = function () {
            $scope.loadData();
        };
        //导出
        $scope.export = function () {
            if (AuthUser.getUser().Id) {
                var params = "?1=1";
                for (var p in $scope.selectparams) {
                    if ($scope.selectparams[p] !== '' && $scope.selectparams[p] !== null)
                        params += ("&" + p + "=" + encodeURI($scope.selectparams[p]));
                }
                window.open('../../api/party/exportParty' + params);
            }
        };

        //加载列表数据
        $scope.loadData = function () {
            if (AuthUser.getUser().Id) {
                $http
                ({
                    method: 'get', url: '../../api/party/getPartyList', params: $scope.selectparams
                }).then(function (result) {
                    $scope.dataList = result.data.item.list;
                    $scope.pageInfo.ptotal = result.data.item.total;

                    //$scope.selectparams.sfhj = "";
                    //$scope.selectparams.zzlbList = "";

                });
            }
        };

        /* var editPartyCtrl = function ($scope, $http) {
             $scope.params = partyModal.params;
             $scope.partyvm = partyModal.partyvm;
             $scope.parentParty = partyModal.parentParty;
             if ($scope.partyvm.dzzdm != null && $scope.partyvm.dzzdm != "") {
                 $scope.dzzdm_short = $scope.partyvm.dzzdm.replace($scope.parentParty.dzzdm, '');
             }
             $scope.submitParty = function (isflag) {
                 if (isflag) {
                     $loading.show();
                     $scope.partyvm.dzzdm = $scope.parentParty.dzzdm + $scope.dzzdm_short;
                     $http({
                         method: "post",
                         url: "../../api/party/saveParty",
                         data: $scope.partyvm
                     }).then(function (result) {
                         $loading.hide();
                         $scope.showMsg('成功', result.data.msg);
                         //重新刷新列表
                         $scope.loadData();
                         $scope.$hide();
                         //$state.go('home.partyList', {cache: true}, {reload: true}); //刷新
                     }, function (resp) {
                         $scope.showMsg('错误', '服务器错误');
                     })
                 }
             }
         };
         editPartyCtrl.$inject = ['$scope', '$http'];
         //定义模态框
         var partyModal = $modal({
             resolve: {
                 load: ['$ocLazyLoad', function ($ocLazyLoad) {
                 }]
             },
             scope: $scope,
             controller: editPartyCtrl,
             templateUrl: '../main/party/editParty.html',
             show: false,
             animation: 'am-fade-and-slide-top'
         });*/
        //新增编辑党组织
        $scope.addParty = function () {
            //$scope.edit("", "新增党组织信息");
            $bsRouterState.$closeTabName("home.partyAdd");
            $timeout(function () {
                $bsRouterState.go('home.partyAdd', {
                    id: "",
                    parentcode: $scope.selectparams.parentcode
                });
            }, 100);
        };
        $scope.editParty = function (id) {
            //$scope.isDetail = true;
            //$scope.edit(id, "编辑党组织信息");
            $bsRouterState.$closeTabName("home.partyEdit");
            $timeout(function () {
                $bsRouterState.go('home.partyEdit', {
                    id: id
                });
            }, 100);

        };
        $scope.detailParty = function (id, ZZLBMC, dzzdm) {
            //$scope.isDetail = false;
            //$scope.edit(id, "党组织信息详情");
            if (ZZLBMC != undefined && ZZLBMC != null && (ZZLBMC.indexOf("党委") >= 0 || ZZLBMC.indexOf("党工委") >= 0)) {
                $bsRouterState.$closeTabName("home.partyShow");
                $timeout(function () {
                    $bsRouterState.go('home.partyShow', {
                        id: id,
                        op: 0,
                        dzzdm: dzzdm
                    });
                }, 100);
            } else {
                $bsRouterState.$closeTabName("home.partyShow_Dzb");
                $timeout(function () {
                    $bsRouterState.go('home.partyShow_Dzb', {
                        id: id,
                        op: 0,
                        dzzdm: dzzdm
                    });
                }, 100);
            }
        };
        /* $scope.edit = function (id, title) {
             partyModal.params = {
                 title: title
             };
             $loading.show();
             $http.get("../../api/party/getPartyById", {
                 params: {
                     'id': id,
                     'parent_dzzdm': $scope.selectparams.parentcode
                 }
             }).then(function (result) {
                 $loading.hide();
                 partyModal.partyvm = result.data.item;
                 partyModal.parentParty = result.data.extdata.parentParty;
                 partyModal.$promise.then(partyModal.show);
             }, function () {
                 $scope.showMsg('错误', '服务器错误');
             });
         };*/

        $scope.delete = function (id) {
            if (confirm("是否确定删除？")) {
                $http({
                    url: "../../api/party/deletePartyById",
                    method: 'GET',
                    params: {id: id}
                }).then(function (result) {
                    $scope.showMsg("消息", result.data.msg);
                    if (result.data.success) {
                        $scope.loadData();
                        //$state.go('home.partyList', {cache: true}, {reload: true}); //刷新
                    }
                });
            }
        };

        //组织类别
        $scope.getZzlbdmList = function () {
            $http({
                method: 'get',
                url: '../../api/partyDic/getZzlbdmList',
                params: {}
            }).then(function (result) {
               /* $scope.zzlbdmList.push({bm: '1', hzmc: '--全部--'});*/
                $scope.zzlbdmList = $scope.zzlbdmList.concat(result.data);
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
        $scope.getZzlbdmList();
        $scope.getJczzflList();

        //$scope.loadParentParty();

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

        $scope.setisunfold = function () {
            $scope.selectparams.isunfold = !$scope.selectparams.isunfold;
            $scope.$emit('menudatas.toggle', !$scope.selectparams.isunfold);
        };

        $scope.reset = function () {
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
            $scope.selectparams.dzzmc = $scope.resetparams.dzzmc;
            //$scope.selectparams.dzzdm = $scope.resetparams.dzzdm;
            $scope.selectparams.zzlb = $scope.resetparams.zzlb;
            $scope.selectparams.zzlbList = $scope.resetparams.zzlbList;
            $scope.selectparams.jczzfl = $scope.resetparams.jczzfl;
            $scope.selectparams.jldzzrq_begin = $scope.resetparams.jldzzrq_begin;
            $scope.selectparams.jldzzrq_end = $scope.resetparams.jldzzrq_end;
            // $scope.selectparams.isContainParent = $scope.resetparams.isContainParent;
            // $scope.selectparams.zzfbType = $scope.resetparams.zzfbType;
            //$scope.selectparams.selectdzzmc = $scope.selectparams.dzzmc = $scope.selectparams.zzlb = $scope.selectparams.jczzfl = '';
        }

    });
})(angular);