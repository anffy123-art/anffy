(function ($app) {
    $app.module('gtPartyApp').controller('myMeetingCtrl', function ($scope, $http, $modal, $ocLazyLoad, $alert, $loading, $state, $bsRouterState, AuthUser, $timeout) {
        $state.params = $bsRouterState.$params($scope);

        $scope.isShow = false;
        $scope.moreTxt = "更多";
        //定义数据集合
        $scope.loginUserId = AuthUser.getUser().Id;
        $scope.dataList = []; //列表数据
        $scope.boolList = [{dickey: 1, dicvalue: '是'}, {dickey: 0, dicvalue: '否'}];

        //组织树参数
        $scope.treeparams = {
            isunfold: false,//组织结构树展开收缩
            selectdzzdm: "",
            selectdzzmc: "",
            defaultselected: $state.params.dzzdm
        };

        $scope.selectparams = {
            pageindex: 1,
            pagesize: 10,
            partyCode: '',//党组织代码
            meetingName: '',
            meetingAddress: '',
            beginTime: $state.params.begintime,
            endTime: $state.params.endtime,
            userId: AuthUser.getUser().Id,
            shykType: 4
        };
        $scope.resetparams = {};
        angular.extend($scope.resetparams, $scope.selectparams);

        $scope.pageInfo = {ptotal: 0};
        //监视页数变化
        $scope.$watch("selectparams.pageindex", function (newVal, oldVal) {
            if ($scope.pageInfo.ptotal > 0) {
                $scope.loadData();
            }
        });

        $scope.$watch("treeparams.selectdzzdm", function (newVal, oldVal) {
            if (newVal != "") {

                if ($scope.selectparams.defaultselected != "" && $scope.selectparams.defaultselected != null &&
                    $scope.selectparams.defaultselected != $scope.selectparams.selectdzzdm)
                    return;

                $scope.selectparams.partyCode = $scope.treeparams.selectdzzdm;
                $scope.resetparams.partyCode = $scope.treeparams.selectdzzdm;

                $scope.selectparams.defaultselected = "";

                $scope.loadData();
            }
        });


        $scope.$on('tabChildReloadData', function (event, data) {
            if (data.name == 'myMeetingCtrl') {
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
                method: 'get', url: '../../api/shyk/getMyMeetingList', params: $scope.selectparams
            }).then(function (result) {
                $scope.dataList = result.data.item.list;
                $scope.pageInfo.ptotal = result.data.item.total;
            }, function (res) {
                $scope.showMsg('错误', '服务器错误');
            });
        };

        //修改
        $scope.edit = function (id,meetinguserId) {
            $bsRouterState.$closeTabName("home.shykEvaluateEdit");
            $timeout(function () {
                $bsRouterState.go('home.shykEvaluateEdit', {
                    meetingId: id,
                    meetinguserId: meetinguserId
                });
            }, 100);
        };

        //查看
        $scope.showData = function (id) {
            $bsRouterState.$closeTabName("home.shykShow");
            $timeout(function () {
                $bsRouterState.go('home.shykShow', {id: id});
            }, 100);
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
        $scope.isShowClick = function () {
            $scope.isShow = !$scope.isShow;
            if ($scope.moreTxt == "更多") {
                $scope.moreTxt = "收起";
            } else if ($scope.moreTxt == "收起") {
                $scope.moreTxt = "更多";
            }
        };
        $scope.setisunfold = function () {
            $scope.treeparams.isunfold = !$scope.treeparams.isunfold;
            $scope.$emit('menudatas.toggle', !$scope.treeparams.isunfold);
        };
        $scope.reset = function () {
            $scope.selectparams = {};

            angular.extend($scope.selectparams, $scope.resetparams);
            $scope.loadData();
        };

    });
})(angular);