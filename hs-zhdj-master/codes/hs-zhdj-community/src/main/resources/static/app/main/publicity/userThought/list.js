(function ($app) {
    $app.module('gtPartyApp').controller('userThoughtListCtrl', function ($scope, $http, $modal, $ocLazyLoad, $alert, $loading, $state, $bsRouterState, AuthUser, $timeout) {
        $state.params = $bsRouterState.$params($scope);
        $scope.isShow = false;
        $scope.moreTxt = "更多";
        //定义数据集合
        $scope.loginUserId = AuthUser.getUser().Id;
        $scope.dataList = []; //列表数据
        $scope.thoughtTypeList = [];
        $scope.questionTypeList = [];
        $scope.handleTypeList = [];
        $scope.destroyTypeList = [];
        $scope.handleStateList = [];

        $scope.selectparams = {
            isunfold: false,//组织结构树展开收缩
            'pageindex': 1,
            'pagesize': 10,
            isshowxz: 0,
            selectdzzdm: "",
            selectdzzmc: "",
            defaultselected: $state.params.dzzdm,
            parentcode: AuthUser.getUser().ParentDpCode,
            parentname: AuthUser.getUser().ParentDpName,
            szdzzdm: AuthUser.getUser().DPCode,
            szdzzmc: AuthUser.getUser().DPName,
            zzfbType:null,
            partyCode: '',//党组织代码
            userid: AuthUser.getUser().Id,
            userName: '',
            thoughtType: null,
            questionType: $state.params.qtype == undefined?null:$state.params.qtype,
            beginTime: $state.params.bt==undefined?'':$state.params.bt,
            endTime: $state.params.et==undefined?'':$state.params.et,
            handleType: null,
            destroyType: $state.params.dtype==undefined?null:$state.params.dtype,
            handleState: $state.params.hstate==undefined?null:$state.params.hstate
        };
        $scope.resetparams = {
            isunfold: false,//组织结构树展开收缩
            'pageindex': 1,
            'pagesize': 10,
            isshowxz: 0,
            selectdzzdm: "",
            selectdzzmc: "",
            defaultselected: $state.params.dzzdm,
            parentcode: AuthUser.getUser().ParentDpCode,
            parentname: AuthUser.getUser().ParentDpName,
            szdzzdm: AuthUser.getUser().DPCode,
            szdzzmc: AuthUser.getUser().DPName,
            zzfbType:null,
            partyCode: '',//党组织代码
            userid: AuthUser.getUser().Id,
            userName: '',
            thoughtType: null,
            questionType: null,
            beginTime: '',
            endTime: '',
            handleType: null,
            destroyType: null,
            handleState: null
        };
        $scope.pageInfo = {ptotal: 0};
        //监视页数变化
        $scope.$watch("selectparams.pageindex", function (newVal, oldVal) {
            if ($scope.pageInfo.ptotal > 0) {
                $scope.loadData();
            }
        });

        $scope.$watch("selectparams.selectdzzdm", function (newVal, oldVal) {
            if (newVal != "") {

                if ($scope.selectparams.defaultselected != "" && $scope.selectparams.defaultselected != null &&
                    $scope.selectparams.defaultselected != $scope.selectparams.selectdzzdm)
                    return;

                $scope.selectparams.defaultselected='';
                $scope.selectparams.partyCode = $scope.selectparams.selectdzzdm;
                if ($scope.selectparams.selectdzzdm != AuthUser.getUser().DPCode) {
                    $scope.selectparams.userid = "";
                } else {
                    $scope.selectparams.userid = AuthUser.getUser().Id;
                }
                $scope.loadData();
            }
        });

        $scope.$watch("selectparams.zzfbType", function (newVal, oldVal) {
            if (newVal != oldVal) {
                $scope.loadData();
            }
        });

        $scope.$on('tabChildReloadData',function (event,data) {
            if(data.name=='userThoughtListCtrl'){
                $scope.loadData();
            }
        });


        //查询
        $scope.search = function () {
            $scope.loadData();
        };

        //加载列表数据
        $scope.loadData = function () {
            $http
            ({
                method: 'get', url: '../../api/publicity/getUserThoughtList', params: $scope.selectparams
            }).then(function (result) {
                $scope.dataList = result.data.item.list;
                $scope.pageInfo.ptotal = result.data.item.total;
            });
        };

        //新增
        $scope.addData = function () {
            $bsRouterState.$closeTabName("home.userThoughtAdd");
            $timeout(function () {
                $bsRouterState.go('home.userThoughtAdd', {
                    id: "",
                    dzzdm: $scope.selectparams.partyCode
                });
            }, 100);
        };
        //修改
        $scope.editData = function (id) {
            $bsRouterState.$closeTabName("home.userThoughtEdit");
            $timeout(function () {
                $bsRouterState.go('home.userThoughtEdit', {
                    id: id,
                    dzzdm: $scope.selectparams.partyCode
                });
            }, 100);
        };

        //查看
        $scope.showData = function (id) {
            $bsRouterState.$closeTabName("home.userThoughtShow");
            $timeout(function () {
                $bsRouterState.go('home.userThoughtShow', {id: id, op: 0});
            }, 100);
        };

        //删除
        $scope.deleteData = function (id) {
            if (confirm("是否确定删除？")) {
                $http({
                    url: "../../api/publicity/deleteUserthoughtById",
                    method: 'GET',
                    params: {id: id}
                }).then(function (result) {
                    $scope.showMsg("消息", result.data.msg);
                    if (result.data.success) {
                        $scope.loadData();
                    }
                });
            }
        };

        $scope.exportData = function () {
            if ($scope.selectparams.dzzdm != "" && $scope.selectparams.dzzdm != AuthUser.getUser().gddwdm) {
                var params = "?1=1";
                for (var p in $scope.selectparams) {
                    if ($scope.selectparams[p] !== '' && $scope.selectparams[p] !== null)
                        params += ("&" + p + "=" + encodeURI($scope.selectparams[p]));
                }
                window.open('../../api/publicity/exportUserthought' + params);
            }
        };

        $scope.getThoughtTypeList = function () {
            $http({
                method: 'get',
                url: '../../api/dictionary/getDictionaryListByDicTypeKey',
                params: {
                    dicTypeKey: 'thoughtType'
                }
            }).then(function (result) {
                $scope.thoughtTypeList = result.data;
            }, function (resp) {

            });
        };
        $scope.getQuestionTypeList = function () {
            $http({
                method: 'get',
                url: '../../api/dictionary/getDictionaryListByDicTypeKey',
                params: {
                    dicTypeKey: 'questionType'
                }
            }).then(function (result) {
                $scope.questionTypeList = result.data;
            }, function (resp) {

            });
        };
        $scope.getHandleTypeList = function () {
            $http({
                method: 'get',
                url: '../../api/dictionary/getDictionaryListByDicTypeKey',
                params: {
                    dicTypeKey: 'handleType'
                }
            }).then(function (result) {
                $scope.handleTypeList = result.data;
            }, function (resp) {

            });
        };
        $scope.getDestroyTypeList = function () {
            $http({
                method: 'get',
                url: '../../api/dictionary/getDictionaryListByDicTypeKey',
                params: {
                    dicTypeKey: 'destroyType'
                }
            }).then(function (result) {
                $scope.destroyTypeList = result.data;
            }, function (resp) {

            });
        };
        $scope.getHandleStateList = function () {
            $http({
                method: 'get',
                url: '../../api/dictionary/getDictionaryListByDicTypeKey',
                params: {
                    dicTypeKey: 'handleState'
                }
            }).then(function (result) {
                $scope.handleStateList = result.data;
            }, function (resp) {

            });
        };

        $scope.getThoughtTypeList();
        $scope.getQuestionTypeList();
        $scope.getHandleTypeList();
        $scope.getDestroyTypeList();
        $scope.getHandleStateList();

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
            $scope.selectparams.userName = $scope.resetparams.userName;
            $scope.selectparams.thoughtType = $scope.resetparams.thoughtType;
            $scope.selectparams.questionType = $scope.resetparams.questionType;
            $scope.selectparams.beginTime = $scope.resetparams.beginTime;
            $scope.selectparams.endTime = $scope.resetparams.endTime;
            $scope.selectparams.handleType = $scope.resetparams.handleType;
            $scope.selectparams.destroyType = $scope.resetparams.destroyType;
            $scope.selectparams.handleState = $scope.resetparams.handleState;
            //$scope.selectparams.selectdzzmc = $scope.selectparams.dzzmc = $scope.selectparams.zzlb = $scope.selectparams.jczzfl = '';
        }

    });
})(angular);
