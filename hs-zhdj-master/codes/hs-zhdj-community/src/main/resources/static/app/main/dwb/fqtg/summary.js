(function ($app) {
    $app.module('gtPartyApp').controller('fqtgsummaryCtrl', function ($scope, $http, $modal, $ocLazyLoad, $alert, $loading, $state, $stateParams, AuthUser,$bsRouterState) {
        //定义数据集合
        $scope.dataList = []; //列表数据
        $scope.statusList = [];
        $scope.ndList = [];
        $scope.isShow = false;
        $scope.moreTxt = "更多";


        $scope.selectparams = {
            isunfold: false,//组织结构树展开收缩
            'pageindex': 1,
            'pagesize': 10,
            dzzdm: '',
            dzzmc: '',
            author: '',
            title: null,
            onlyshow_dw: 2,
            zzfbType : null,
        };
        $scope.resetparams = {
            isunfold: false,//组织结构树展开收缩
            'pageindex': 1,
            'pagesize': 10,
            dzzdm: '',
            dzzmc: '',
            author: '',
            title: null,
            onlyshow_dw: 2,
            zzfbType : null,
        };
        $scope.pageInfo = {ptotal: 0};
        //监视页数变化
        $scope.$watch("selectparams.pageindex", function (newVal, oldVal) {
            if ($scope.pageInfo.ptotal > 0) {
                $scope.loadData();
            }
        });

        $scope.$watch("selectparams.dzzdm", function (newVal, oldVal) {
            if (newVal != '' && newVal != null) {
                $scope.loadData();
            }
        });

        $scope.$watch("selectparams.zzfbType", function (newVal, oldVal) {
            if (newVal != oldVal) {
                $scope.loadData();
            }
        });

        //获取栏目
        $scope.getTopicList = function () {
            $http({
                method: 'get',
                url: '../../api/dictionary/GetDictionaryList',
                params: {dicTypeKey: 'topic'}
            }).then(function (result) {
                $scope.ndList = result.data.item.list;
            }, function (resp) {
            });
        };
        $scope.getDictionaryList = function () {
            $http({
                method: 'get',
                url: '../../api/dictionary/GetDictionaryList',
                params: {dicTypeKey: 'fqtgStatus'}
            }).then(function (result) {
                $scope.statusList = result.data.item.list;
            }, function (resp) {
            });
        };
        //查询
        $scope.search = function () {
            $scope.loadData();
        };
        //加载列表数据
        $scope.loadData = function () {
            $loading.show();
            $http({
                url: "../../api/Fqtg/gettgList",
                method: 'GET',
                params: $scope.selectparams
            }).then(function (rq) {
                $scope.dataList = rq.data.item.list;
                $scope.pageInfo.ptotal = rq.data.item.total;
                $loading.hide();
            });
        };
        $scope.viewItem = function (fqtgid) {
            $bsRouterState.go('home.fqtgedit', {fqtgid: fqtgid,readonly:true});
        };
        $scope.approve = function (fqtgid) {
            $bsRouterState.go('home.fqtgapprove', {fqtgid: fqtgid});
        };

        var editCtrl = function ($scope, $http, AuthUser) {
            $scope.modalData = $scope.$parent.$parent.modalData;
            // $scope.modalData.nd = $scope.modalData.nd.toString();
            $scope.ndList = [];
            $scope.numList = [];
            //获取年度
            $scope.getNdList = function () {
                $http({
                    method: 'get',
                    url: '../../api/dictionary/GetDictionaryList',
                    params: {dicTypeKey: 'years'}
                }).then(function (result) {
                    $scope.ndList = result.data.item.list;
                }, function (resp) {
                });
            };
            $scope.getNumList = function () {
                $http({
                    method: 'get',
                    url: '../../api/dictionary/GetDictionaryList',
                    params: {dicTypeKey: 'zgygNumber'}
                }).then(function (result) {
                    $scope.numList = result.data.item.list;
                }, function (resp) {
                });
            };
            $scope.submitForm = function (isflag) {
                if (isflag) {
                    $scope.modalData.status = 5;//状态改成已使用
                    $http({
                        method: "post",
                        url: "../../api/Fqtg/save",
                        data: $scope.modalData
                    }).then(function (result) {
                        $loading.hide();
                        $scope.showMsg('成功', result.data.msg);
                        if (result.data.success) {
                            //重新刷新列表
                            $scope.loadData();
                            $scope.$hide();
                        }

                    }), function (resp) {
                        $scope.showMsg('错误', '服务器错误');
                    }
                }
            };
            $scope.getNumList();
            $scope.getNdList();
        };
        editCtrl.$inject = ['$scope', '$http'];
        var cdModal = $modal({
            scope: $scope,
            title: '设为已用',
            templateUrl: 'dwb/fqtg/usableedit.html',
            controller: editCtrl,
            show: false,
            animation: 'am-fade-and-slide-top'
        });
        $scope.modalData = {};
        $scope.usable = function (it) {
            $scope.modalData = it;
            cdModal.$promise.then(cdModal.show);
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
        $scope.getTopicList();
        $scope.getDictionaryList();
        $scope.loadData();

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
            $scope.selectparams.title = $scope.resetparams.title;
            //$scope.selectparams.dzzdm = $scope.resetparams.dzzdm;
            $scope.selectparams.author = $scope.resetparams.author;
            $scope.selectparams.topicValue = $scope.resetparams.topicValue;
            $scope.selectparams.status = $scope.resetparams.status;
            // $scope.selectparams.jldzzrq_end = $scope.resetparams.jldzzrq_end;
            // $scope.selectparams.isContainParent = $scope.resetparams.isContainParent;
            // $scope.selectparams.zzfbType = $scope.resetparams.zzfbType;
            //$scope.selectparams.selectdzzmc = $scope.selectparams.dzzmc = $scope.selectparams.zzlb = $scope.selectparams.jczzfl = '';
        }
    });
})(angular);
