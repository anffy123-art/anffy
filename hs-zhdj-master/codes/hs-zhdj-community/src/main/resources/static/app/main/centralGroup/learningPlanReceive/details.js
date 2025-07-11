(function ($app) {
    $app.module('gtPartyApp').controller('learningPlanReceiveDetailsCtrl', function ($scope, $http, $modal, $ocLazyLoad, $alert, $loading, $state, $partySelect, $stateParams, AuthUser, $filter,$bsRouterState) {

        $stateParams=$bsRouterState.$params($scope);

        $scope.changevm = {};
        $scope.receiveDWs = [];
        $scope.reqFileModel = {
            selectdata: {FileRefID: '', pageindex: 1, pagesize: 10, ptotal: 0},//查询参数：FileRefID为文件关联ID
            filetype: 3,//文件类型
            items: [],//列表数据地址
            readonly: false,//是否只能查看
            title: '学习资料',
            addFileButton: '上传',
            type: 'details'
        };
        $scope.state = ''; //列表数据
        $scope.selectparams = {
            shykType: $stateParams.type,
            'pageindex': 1,
            'pagesize': 10,
            id: '',
            name: '',
            endTimeStart: '',
            endTimeEnd: '',
            userId:AuthUser.getUser().Id,
            roleId:AuthUser.getUser().curRoleId
        };

        //接收
        $scope.receiveData = function (id) {
            $http.get("../../api/zxzxx/xxjh/markReceived", {
                params: {
                    'id': id,
                    'userId':AuthUser.getUser().Id,
                    'roleId':AuthUser.getUser().curRoleId
                }
            }).then(function (result) {
                $scope.showMsg("消息", result.data.msg);
                if (result.data.success) {
                    $scope.loadData();

                    $scope.$emit("tabReloadData",{name:'learningPlanReceiveListCtrl',data:1});
                }
            }, function () {
                $scope.showMsg('错误', '服务器错误');
            });
        };

        //清除消息
        $scope.clearMessage = function (businessId, userId) {
            $http({
                method: 'get',
                url: '../../api/message/clearMessageByBusinessId',
                params: {
                    businessId: businessId,
                    userId: userId,
                    messageType: 4
                }
            }).then(function (result) {

            }, function (resp) {

            });
        };

        //加载列表数据
        $scope.loadStateData = function (id) {
            $scope.selectparams.id = id;
            $http
            ({
                method: 'get', url: '../../api/zxzxx/xxjh/list4zd', params: $scope.selectparams
            }).then(function (result) {
                if (result.data.item.list.length > 0) {
                    $scope.state = result.data.item.list[0].state;
                    if ($scope.state != 1) {
                        $scope.receiveData(id);
                    }
                }
            });
        };

        //加载数据
        $scope.loadData = function () {
            $http.get("../../api/zxzxx/xxjh/get", {
                params: {
                    'id': $stateParams.id
                }
            }).then(function (result) {
                $scope.reqFileModel.selectdata.FileRefID = $stateParams.id;
                $scope.changevm = result.data.item;
                //清除通知
                $scope.clearMessage($stateParams.id, AuthUser.getUser().Id);
                $scope.loadStateData($stateParams.id);
                //console.log(result.data.item);
                $http.get("../../api/dictionary/GetDictionaryList", {
                    params: {
                        'dicTypeKey': 'zxzxxjhlx'
                    }
                }).then(function (result) {
                    $scope.roleConfigList = result.data.item.list;
                    $scope.changevmTypeCode = $scope.roleConfigList[$scope.changevm.typeCode - 1];
                }, function () {
                    $scope.showMsg('错误', '服务器错误');
                });
            }, function () {
                $scope.showMsg('错误', '服务器错误');
            });
        };
        //保存
        //isflag：表单验证结果，shykStatus：下一环节状态
        $scope.submitData = function (isflag, shykStatus, isnotify) {
            if (isflag) {
                $scope.changevm.typeCode = $scope.changevmTypeCode.val;
                var receiveDWs = [];
                for (var i = 0; i < $scope.receiveDWs.length; i++) {
                    receiveDWs.push({});
                    receiveDWs[i].dwId = $scope.receiveDWs[i].dwId;
                    receiveDWs[i].receiveUserId = $scope.receiveDWs[i].secretaryIds;
                }
                var mydata = {
                    xxjh: $scope.changevm,
                    receiveDWs: receiveDWs
                }
                $loading.show();
                $http({
                    method: "post",
                    url: "../../api/zxzxx/xxjh/edit",
                    data: mydata
                }).then(function (result) {
                    $loading.hide();
                    $scope.showMsg('成功', result.data.msg);
                    $scope.pagechange();
                }), function (resp) {
                    $scope.showMsg('错误', '服务器错误');
                }
            }
        };

        $scope.loadData();


        $scope.parentUrl = "home.learningPlanReceive";//父级地址
        $scope.pagechange = function () {
            if($bsRouterState.$getRouteType()=='tab'){
                $bsRouterState.$closeTab($scope);
            } else {
                $bsRouterState.go($scope.parentUrl);
            }
        };

    });
})(angular);