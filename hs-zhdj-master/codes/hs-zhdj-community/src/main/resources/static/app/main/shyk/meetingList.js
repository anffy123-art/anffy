(function ($app) {
    $app.module('gtPartyApp').controller('shykMeetingListCtrl', function ($scope, $http, $modal, $ocLazyLoad, $alert, $loading, $state, $stateParams, AuthUser, $bsRouterState) {
        $state.params = $bsRouterState.$params($scope);
        $scope.pageId = "shykMeetingList" + new Date().getTime();
        $scope.isShow = false;
        $scope.moreTxt = "更多";


        //定义数据集合
        $scope.loginUserId = AuthUser.getUser().Id;
        $scope.dataList = []; //列表数据
        $scope.shyklxList = [];//三会一课类型
        $scope.shykStatusList = [];//会议状态
        $scope.selectparams = {
            isunfold: false,//组织结构树展开收缩
            shykType: null,
            'pageindex': 1,
            'pagesize': 10,
            isshowxz: 1,
            selectdzzdm: '',
            selectdzzmc: '',
            parentcode: AuthUser.getUser().ParentDpCode,
            parentname: AuthUser.getUser().ParentDpName,
            szdzzdm: AuthUser.getUser().DPCode,
            szdzzmc: AuthUser.getUser().DPName,
            partyCode: '',//党组织代码
            meetingName: '',
            meetingAddress: '',
            shykStatus: 5,
            beginTime: '',
            endTime: '',
            userid: AuthUser.getUser().Id,
            zzfbType: null
        };
        $scope.resetparams = {
            isunfold: false,//组织结构树展开收缩
            shykType: null,
            'pageindex': 1,
            'pagesize': 10,
            isshowxz: 1,
            selectdzzdm: '',
            selectdzzmc: '',
            parentcode: AuthUser.getUser().ParentDpCode,
            parentname: AuthUser.getUser().ParentDpName,
            szdzzdm: AuthUser.getUser().DPCode,
            szdzzmc: AuthUser.getUser().DPName,
            partyCode: '',//党组织代码
            meetingName: '',
            meetingAddress: '',
            shykStatus: 5,
            beginTime: '',
            endTime: '',
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

        $scope.$watch("selectparams.selectdzzdm", function (newVal, oldVal) {
            if (newVal != "") {
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
            if(data.name=='shykMeetingListCtrl'){
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
                method: 'get', url: '../../api/shyk/getMeetingList', params: $scope.selectparams
            }).then(function (result) {
                $scope.dataList = result.data.item.list;
                $scope.pageInfo.ptotal = result.data.item.total;
            });
        };

        //查看
        $scope.showData = function (id, shykType) {
            $bsRouterState.go('home.shykShow', {id: id, shykType: shykType});
        };

        //审核会议决议
        $scope.auditDecision = function (meetingid) {
            $bsRouterState.go("home.shykMeetingAuditDecision", {id: meetingid});
        };

        $scope.getShyklxList = function () {
            $http({
                method: 'get',
                url: '../../api/dictionary/getDictionaryListByDicTypeKey',
                params: {
                    dicTypeKey: 'shykType'
                }
            }).then(function (result) {
                $scope.shyklxList = result.data;
            }, function (resp) {

            });
        };

        $scope.getShykStatusList = function () {
            $http({
                method: 'get',
                url: '../../api/dictionary/getDictionaryListByDicTypeKey',
                params: {
                    dicTypeKey: 'shykStatus'
                }
            }).then(function (result) {
                $scope.shykStatusList = result.data;
            }, function (resp) {

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
            $scope.selectparams.meetingName = $scope.resetparams.meetingName;
            //$scope.selectparams.dzzdm = $scope.resetparams.dzzdm;
            $scope.selectparams.beginTime = $scope.resetparams.beginTime;
            $scope.selectparams.endTime = $scope.resetparams.endTime;
            $scope.selectparams.meetingAddress = $scope.resetparams.meetingAddress;
            $scope.selectparams.shykType = $scope.resetparams.shykType;
            // $scope.selectparams.isContainParent = $scope.resetparams.isContainParent;
            // $scope.selectparams.zzfbType = $scope.resetparams.zzfbType;
            //$scope.selectparams.selectdzzmc = $scope.selectparams.dzzmc = $scope.selectparams.zzlb = $scope.selectparams.jczzfl = '';
        };

        $scope.getShyklxList();
        $scope.getShykStatusList();
    });
})(angular);