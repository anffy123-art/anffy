(function ($app) {
    'use strict';
    $app.module('dsfapp').controller('formBugInfoCtrl', function ($scope, $http, $modal, $bsfiles, $alert, $window, AuthUser, $loading) {
        //http链接参数
        $scope.urls = {
            getProblemInfodUrl: "../../api/DevTest/getProblemInfo",
            findFileListUrl: '../../api/FileUpload/FindFileList',
            getSysDutyListUrl: "../../api/SysDuty/GetSysDuty",
            getDicListUrl: "../../api/Comm/GetDictionaryListByDicType",
        }
        //下拉列表数据
        $scope.selectdatas = [];
        //截图集合
        $scope.files = [];
        var DevTestDataID = '';
        $scope.filedata = {
            selectdata: {pageindex: 1, pagesize: 999999, ptotal: 0},
            filetype: 1,
            readonly: false,
            items: $scope.files,
            typeparams: {types: ['jpg', 'bmp', 'jpe', 'jpeg'], errormsg: '图片格式必须为*.jpg,*.bmp,*.jpe,*.jpeg等格式'}
        }
        //加载问题明细
        $scope.loadItem = function () {
            $http({
                url: $scope.urls.getProblemInfodUrl, method: 'GET',
                params: {
                    DTID: '',
                    fid: $scope.flowdata.params.fid,
                    uid: AuthUser.getUser().DGUserID,
                    testplanid: ''
                }
            }).then(function (rq) {
                    $loading.hide();
                    $scope.content = rq.data.item;
                    $scope.DutyUserName = rq.data.DutyUserName;
                    $scope.$emit('bugitem', rq.data);
                    angular.extend($scope.filedata.selectdata, {FileRefID: rq.data.item.DevTestDataID});
                    //加载问题截图列表
                    $bsfiles.loadItems($scope.filedata);
                }, function (ex) {
                    $loading.hide();
                    $alert({
                        title: '错误：',
                        content: '加载测试问题明细失败，服务器错误。',
                        placement: 'top',
                        type: 'info',
                        show: true,
                        duration: 3
                    });
                }
            );

        };
        $scope.loadItem();
        //获取功能点列表
        $scope.getSysDutyList = function () {
            $http.get($scope.urls.getSysDutyListUrl, {
                params: {
                    sysName: "",
                    SysDutyName: "",
                    DutyLv: 0
                }
            }).then(function (result) {
                $scope.selectdatas.sysDutyList = result.data;
            })
        }
        //获取问题类型列表
        $scope.getProblemTypeList = function () {
            $http.get($scope.urls.getDicListUrl, {params: {DicTypeKey: "DevTestData_ProblemType"}}).then(function (result) {
                $scope.selectdatas.problemTypeList = result.data;
            })
        }
        //获取严重程度列表
        $scope.getSeriousLvList = function () {
            $http.get($scope.urls.getDicListUrl, {params: {DicTypeKey: "DevTestData_SeriousLv"}}).then(function (result) {
                $scope.selectdatas.seriousLvList = result.data;
            })
        }
        //初始化下拉列表方法
        $scope.initSelect = function () {
            $scope.getSysDutyList();
            $scope.getProblemTypeList();
            $scope.getSeriousLvList();
        }
        //初始化下拉框
        $scope.initSelect();
        var imgModal = $modal({
            scope: $scope,
            title: '问题截图',
            templateUrl: '../js/template/showimg.html',
            show: false,
            animation: 'am-fade-and-slide-top'
        });
        //缩略图放大
        $scope.zoomImg = function (imgurl) {
            $scope.zoomUrl = imgurl;

            imgModal.$promise.then(imgModal.show);
        }


    }).filter('getDicValue', function () {
        return function (list, id) {
            var dicvalue = '';
            angular.forEach(list, function (item) {
                if (item.DicKey == id) dicvalue = item.DicValue;
            })
            return dicvalue;
        };
    }).filter('getSysDuty', function () {
        return function (list, param) {
            var sysdutyName = '';
            angular.forEach(list, function (item) {
                if (item.SysDutyID == param) sysdutyName = item.SysDutyName;
            })
            return sysdutyName;
        };
    });
})(angular);