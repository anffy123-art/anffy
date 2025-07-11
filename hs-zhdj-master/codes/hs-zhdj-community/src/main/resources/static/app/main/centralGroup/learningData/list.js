(function ($app) {
    $app.module('gtPartyApp').controller('learningDataListCtrl', function ($scope, $http, $modal, $ocLazyLoad, $alert, $loading,$window, $state, $stateParams,$bsfiles, AuthUser) {
        //定义数据集合
        $scope.dataList = []; //列表数据
        $scope.changevm={};
        $scope.isShow = false;
        $scope.moreTxt = "更多";


        $scope.selectparams = {
            isunfold: false,//组织结构树展开收缩
            'pageindex': 1,
            'pagesize': 10,
            dzzdm:'',
            fileName: '',
            up_begin: '',
            up_end: '',
            onlyshow_dw: 2,
            zzfbType : null,
            roleid:AuthUser.getUser().curRoleId,
            userId:AuthUser.getUser().Id
        };
        $scope.resetparams = {
            isunfold: false,//组织结构树展开收缩
            'pageindex': 1,
            'pagesize': 10,
            dzzdm:'',
            fileName: '',
            up_begin: '',
            up_end: '',
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
                //$scope.selectparams.parentcode = $scope.selectparams.dzzdm;
                $scope.loadData();
            }
        });

        $scope.$watch("selectparams.zzfbType", function (newVal, oldVal) {
            if (newVal != oldVal) {
                $scope.loadData();
            }
        });

        var fileViewModal = $modal({
            scope: $scope,
            title: '文件展现',
            templateUrl: 'filemanage/doc-show.html?' + window.sysVersion,
            controller: 'fileViewCtrl',
            show: false,
            animation: 'am-fade-and-slide-top'
        });

        $scope.viewFile = function (fileid, filename) {
            //fileViewModal.fileId=fileid;
            $scope.viewFileId = fileid;
            $scope.viewFileName = filename;
            fileViewModal.$promise.then(fileViewModal.show);
        };

        $scope.downloadFile = function (fileid) {
            //console.log($bsfiles.configdata.downFileUrl);
            //console.log($bsfiles.configdata.downFileUrl)
            $window.open($bsfiles.configdata.downFileUrl + "/" + fileid);
        };

        //查询
        $scope.search = function () {
            $scope.loadData();
        };

        //加载列表数据
        $scope.loadData = function () {
            $http
            ({
                method: 'get', url: '../../api/zxzxx/xxzl/selectXxzl', params: $scope.selectparams
            }).then(function (result) {
                $scope.dataList = result.data.item.list;
                $scope.pageInfo.ptotal = result.data.item.total;
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
            $scope.selectparams.fileName = $scope.resetparams.fileName;
            //$scope.selectparams.dzzdm = $scope.resetparams.dzzdm;
            $scope.selectparams.doctype = $scope.resetparams.doctype;
            $scope.selectparams.up_begin = $scope.resetparams.up_begin;
            $scope.selectparams.up_end = $scope.resetparams.up_end;
            // $scope.selectparams.jldzzrq_end = $scope.resetparams.jldzzrq_end;
            // $scope.selectparams.isContainParent = $scope.resetparams.isContainParent;
            // $scope.selectparams.zzfbType = $scope.resetparams.zzfbType;
            //$scope.selectparams.selectdzzmc = $scope.selectparams.dzzmc = $scope.selectparams.zzlb = $scope.selectparams.jczzfl = '';
        };

        //$scope.loadData();
    }).controller('fileViewCtrl', function ($scope, $http) {
        $scope.title = $scope.$parent.$parent.viewFileName;
        $scope.fileId = $scope.$parent.$parent.viewFileId;
        $scope.isrc = '/api/filemgr/showDoc/' + $scope.fileId;
    });

})(angular);