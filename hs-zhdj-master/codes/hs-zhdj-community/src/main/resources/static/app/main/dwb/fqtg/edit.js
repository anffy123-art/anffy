(function ($ang) {
    'use strict';
    $ang.module('gtPartyApp').controller('fqtgEditCtrl', function ($scope, $filter, $http, $alert, $modal, AuthUser, $bsfiles, $state, $loading, $window, $timeout,$stateParams,$bsRouterState) {

        $stateParams=$bsRouterState.$params($scope);

        $scope.dataModel = {
            createuserid: AuthUser.getUser().Id,
            createusername: AuthUser.getUser().Name,
            photoname: null,
            photoid: null,
            newsname: null,
            newsid: null,
            ygmc: $stateParams.ygmc,
            ygqkid: $stateParams.ygqkid,
            status: 0,
            fqtgid: $stateParams.businessid != null ? $stateParams.businessid : $stateParams.fqtgid
        };
        $scope.isshow= $stateParams.readonly!=null;
        $scope.isEdit = $stateParams.fqtgid == null;
        $scope.isReply = $stateParams.ygqkid == null;//如果是接收投稿点回复，则不能选择其他约稿
        $scope.reqFileModel = {
            selectdata: {FileRefID: $scope.dataModel.photoid, pageindex: 1, pagesize: 10, ptotal: 0},
            filetype: 1,
            items: [],
            readonly: false,
            typeparams: {
                types: ['jpg', 'bmp', 'png', 'gif', 'jpe', 'jpeg'],
                errormsg: '图片格式必须为*.jpg,*.gif,*.png,*.bmp,*.jpe,*.jpeg等格式'
            }
        };
        $scope.wordFileModel = {
            selectdata: {FileRefID: $scope.dataModel.newsid, pageindex: 1, pagesize: 10, ptotal: 0},
            filetype: 1,
            items: [],
            readonly: false,
            typeparams: {
                types: ['doc', 'docx', 'pdf'],
                errormsg: '图片格式必须为*.doc,*.docx,*.pdf格式'
            }
        };
        $scope.ygqkOptions = {
            url: '../../api/Fqtg/getDwYgqkList',
            title: '选择约稿',
            isMulti: false,
            selectData: {title: '标题'},
            columns: {
                title: '标题',
                'begindate|date': '开始月份',
                'enddate|date': '结束月份'
            },
            selectLabelKey: 'title',
            selectValuekey: 'ygqkid',
            selectedValueData: '',
            selectedLabeData: '',
            selectedJData: [],
            selectParams: {leader: AuthUser.getUser().Id}
        };
        $scope.$watch('ygqkOptions.selectedValueData', function (newVal) {
            $scope.dataModel.ygqkid = $scope.ygqkOptions.selectedValueData;
            $scope.dataModel.ygmc = $scope.ygqkOptions.selectedLabeData;
        })
        $scope.uploadword = function () {
            $bsfiles.addFile($scope.wordFileModel).then(function (fid) {
                $http({
                    method: 'get',
                    url: '../..//api/home/getFileByRefID',
                    params: {fileId: fid}
                }).then(function (result) {
                    $scope.dataModel.newsname = result.data.item.filename;
                    $scope.dataModel.newsid = fid;
                }, function (resp) {
                });
            });
        }
        $scope.uploadpicture = function () {
            $bsfiles.addFile($scope.reqFileModel).then(function (fid) {
                $http({
                    method: 'get',
                    url: '../..//api/home/getFileByRefID',
                    params: {fileId: fid}
                }).then(function (result) {
                    $scope.dataModel.photoname = result.data.item.filename;
                    $scope.dataModel.photoid = fid;
                }, function (resp) {
                });
            });
        }
        $scope.loadData = function () {
            $loading.show();

            $http({
                url: "../../api/Fqtg/getFormModel",
                method: 'post',
                data: $scope.dataModel
            }).then(function (rq) {
                $scope.dataModel = rq.data.item;
                //$scope.dataModel.topicvalue = $scope.dataModel.topicvalue + '';
                $scope.reqFileModel.selectdata.FileRefID = $scope.dataModel.photoid;
                $scope.wordFileModel.selectdata.FileRefID = $scope.dataModel.newsid;
                $loading.hide();
            });
        }
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
        $scope.cancel = function () {
            history.go(-1);
        }
        //表单提交
        $scope.submitData = function (isvalid) {
            if (isvalid == false || $scope.dataModel.newsname == null) return;
            $http({
                method: "post",
                url: "../../api/Fqtg/save",
                data: $scope.dataModel
            }).then(function (result) {
                $scope.showMsg('成功', result.data.msg);
                $scope.pagechange();
            }), function (resp) {
                $scope.showMsg('错误', '服务器错误');
            }
        }
        $scope.approve = function (status) {
            $http({
                method: 'get',
                url: '../../api/Fqtg/approve',
                params: {fqtgid: $scope.dataModel.fqtgid,topicvalue:$scope.dataModel.topicvalue, formUser: AuthUser.getUser().Id, status: status}
            }).then(function (result) {
                $scope.showMsg('成功', result.data.msg);
                $bsRouterState.go('home.fqtgsummary', {});
            }, function (resp) {
            });
        }
        $scope.getTopicList();
        $scope.loadData();

        $scope.parentUrl = "home.fqtg";//父级地址
        $scope.pagechange = function () {
            if($bsRouterState.$getRouteType()=='tab'){
                $bsRouterState.$closeTab($scope);
            } else {
                $bsRouterState.go($scope.parentUrl);
            }
        };

    })
})(angular);
