(function ($app) {
    $app.module('gtPartyApp').controller('learningPlanListCtrl', function ($scope, $http, $modal, $ocLazyLoad, $alert, $loading, $state, $stateParams, AuthUser,$bsRouterState) {
        //定义数据集合
        $scope.dataList = []; //列表数据
        $scope.isShow = false;
        $scope.moreTxt = "更多";



        $scope.selectparams = {
            isunfold: false,//组织结构树展开收缩
            shykType: $stateParams.type,
            'pageindex': 1,
            'pagesize': 10,
            name: '',
            endTimeStart: '',
            endTimeEnd: '',
            userId:AuthUser.getUser().Id,
            roleId:AuthUser.getUser().curRoleId
        };
        $scope.resetparams = {
            isunfold: false,//组织结构树展开收缩
            shykType: $stateParams.type,
            'pageindex': 1,
            'pagesize': 10,
            name: '',
            endTimeStart: '',
            endTimeEnd: ''
        };
        $scope.pageInfo = {ptotal: 0};
        //监视页数变化
        $scope.$watch("selectparams.pageindex", function (newVal, oldVal) {
            if ($scope.pageInfo.ptotal > 0) {
                $scope.loadData();
            }
        });

        $scope.$on('tabChildReloadData',function (event,data) {
            if(data.name=='learningPlanListCtrl'){
                $scope.loadData();
            }
        });
        $scope.dzzdmuser={
            dzzdm:""
        };

        $scope.dzzdmByUser = function () {
            $http({
                url: "../../api/zxzxx/xxfa/getdzzdzByUserId",
                method: 'GET',
                params: {Id:AuthUser.getUser().Id }
            }).then(function (result) {
                $scope.dzzdmuser.dzzdm=result.data.msg
            });
        };
        $scope.dzzdmByUser();

        //查询
        $scope.search = function () {
            $scope.loadData();
        };
        //加载列表数据
        $scope.loadData = function () {
            $http
            ({
                method: 'get', url: '../../api/zxzxx/xxjh/list', params: $scope.selectparams
            }).then(function (result) {
                $scope.dataList = result.data.item.list;
                $scope.pageInfo.ptotal = result.data.item.total;
            });
        };


        //新增
        $scope.addData = function () {
            $bsRouterState.go('home.learningPlanAdd', {
                dzzdm: $scope.dzzdmuser.dzzdm,
                id:""
            });
        };
        //修改
        $scope.editData = function (id,state) {
            $bsRouterState.go('home.learningPlanEdit', {
                id: id,
                state: state
            });
        };
        //查看
        $scope.detailsData = function (id,d) {
            $bsRouterState.go('home.learningPlanDetails', {
                id: id,
                d:d
            });
        };
        //发布
        $scope.sendOutData = function (id) {
            if (confirm("是否确定发布？")) {
                $http({
                    url: "../../api/zxzxx/xxjh/send",
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
        //删除
        $scope.deleteData = function (id) {
            if (confirm("是否确定删除？")) {
                $http({
                    url: "../../api/zxzxx/xxjh/delete",
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

        $scope.loadData();

        //已阅党委数量
        var readedChangeCtrl = function ($scope, $http) {
            $scope.params = readedChangeModal.params;
            $scope.selectReadedList = readedChangeModal.selectReadedList;
        };
        readedChangeCtrl.$inject = ['$scope', '$http'];
            //定义模态框
        var readedChangeModal = $modal({
            resolve: {
                load: ['$ocLazyLoad', function ($ocLazyLoad) {
                }]
            },
            scope: $scope,
            controller: readedChangeCtrl,
            templateUrl: '../main/centralGroup/learningPlan/readedList.html',
            show: false,
            animation: 'am-fade-and-slide-top'
        });

        $scope.readedTotalList = function(id){
            $scope.readedId = id;
            $scope.readed("计划接收详情");
        };

        $scope.readed = function (title) {
            readedChangeModal.params = {
                title: title
            };
            readedChangeModal.selectReadedList = {
                dwName:'',
                state:null
            };
            readedChangeModal.$promise.then(readedChangeModal.show);
            $scope.ajaxReaded();
        };

        $scope.ajaxReaded = function(){
            $http.get("../../api/zxzxx/xxjh/qryReceiveList", {
                params: {
                    id:$scope.readedId,
                    pageindex:1,
                    pagesize:99999,
                    dwName:readedChangeModal.selectReadedList.dwName,
                    state:readedChangeModal.selectReadedList.state
                }
            }).then(function (result) {
                $scope.receivePcommListReaded = result.data.item.list;
            }, function () {
                $scope.showMsg('错误', '服务器错误');
            });
        };

        $scope.selectReadedListSelect = function(){
            $scope.ajaxReaded(); 
        };

        //已出方案党委数量
        var readyOutChangeCtrl = function ($scope, $http) {
            $scope.params = readyOutChangeModal.params;
            $scope.selectReadyOutList = readyOutChangeModal.selectReadyOutList;
        };
        readyOutChangeCtrl.$inject = ['$scope', '$http'];
            //定义模态框
        var readyOutChangeModal = $modal({
            resolve: {
                load: ['$ocLazyLoad', function ($ocLazyLoad) {
                }]
            },
            scope: $scope,
            controller: readyOutChangeCtrl,
            templateUrl: '../main/centralGroup/learningPlan/readyOutList.html',
            show: false,
            animation: 'am-fade-and-slide-top'
        });

        $scope.readyOutTotalList = function(id){
            $scope.readyOutId = id;
            $scope.readyOut("计划方案制定情况");
        };

        $scope.readyOut = function (title) {
            readyOutChangeModal.params = {
                title: title
            };
            readyOutChangeModal.selectReadyOutList = {
                dwName:'',
                state:null
            };
            readyOutChangeModal.$promise.then(readyOutChangeModal.show);
            $scope.ajaxReadyOut();
        };

        $scope.ajaxReadyOut = function(){
            $http.get("../../api/zxzxx/xxjh/qryReadyOutList", {
                params: {
                    id:$scope.readyOutId,
                    pageindex:1,
                    pagesize:99999,
                    dwName:readyOutChangeModal.selectReadyOutList.dwName,
                    state:readyOutChangeModal.selectReadyOutList.state
                }
            }).then(function (result) {
                $scope.receivePcommListReadyOut = result.data.item.list;
            }, function () {
                $scope.showMsg('错误', '服务器错误');
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

        $scope.selectReadyOutListSelect = function(){
            $scope.ajaxReadyOut(); 
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
            $scope.selectparams.name = $scope.resetparams.name;
            //$scope.selectparams.dzzdm = $scope.resetparams.dzzdm;
            $scope.selectparams.endTimeStart = $scope.resetparams.endTimeStart;
            $scope.selectparams.endTimeEnd = $scope.resetparams.endTimeEnd;
            // $scope.selectparams.jldzzrq_begin = $scope.resetparams.jldzzrq_begin;
            // $scope.selectparams.jldzzrq_end = $scope.resetparams.jldzzrq_end;
            // $scope.selectparams.isContainParent = $scope.resetparams.isContainParent;
            // $scope.selectparams.zzfbType = $scope.resetparams.zzfbType;
            //$scope.selectparams.selectdzzmc = $scope.selectparams.dzzmc = $scope.selectparams.zzlb = $scope.selectparams.jczzfl = '';
        }
    });
})(angular);