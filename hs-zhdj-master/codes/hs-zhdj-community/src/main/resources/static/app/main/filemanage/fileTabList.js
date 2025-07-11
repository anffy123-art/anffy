(function ($ang) {
    'use strict';
    $ang.module('gtPartyApp').controller('fileTabListCtrl', function ($scope, $http, $alert, $modal, AuthUser, $state, $loading, $window,$stateParams, $timeout,$bsRouterState) {
        $scope.navList = [];
        $scope.selectTabId = '';
        $scope.fileList = [];
        $scope.treeList = [];

        $stateParams = $bsRouterState.$params($scope);

        $scope.selectData = {
            fileName : '',
            filetypeid: '',
            pageindex: 1,
            pagesize: 10,
            ptotal: 0
        };

        $scope.selectData.fileName = $stateParams.fileName;

        $scope.GetNavData = function () {
            $http({
                method: 'get',
                url: '../../api/filemgr/GetFileTypeRoot'
            }).then(function (result) {
                $scope.navList = result.data.item;
                $ang.forEach($scope.navList,function (value) {
                    //默认显示下拉按钮，等点击事件后再给真实数字
                    //value.childCount=1;
                    value.expand=false;
                    value.name=value.filetypename;
                    value.id=value.filetypeid;

                });
                //添加
                if ($scope.selectData.fileName != null){
                    $scope.FindWord();
                }else{
                    $scope.clickTreeChild($scope.navList[0]);
                }
                $scope.selectTabId = $scope.navList[0].filetypeid;

                //$scope.GetTreeData($scope.navList[0].filetypeid);
            }, function (resp) {

            });
        };

        $scope.loadTreeChild=function (item) {
            $http({
                method: 'get',
                url: '../../api/filemgr/GetFileTypesByParent',
                params: {
                    parentid: item.id
                }
            }).then(function (result) {
                item.children=result.data.item;
                //item.childCount=item.children?item.children.length:0;

                $ang.forEach(item.children,function (value) {
                    //value.childCount=0;
                    value.expand=false;
                    value.name=value.filetypename;
                    value.id=value.filetypeid;
                });
                //如果有子节点有下一层，把类型选择默认选下一层第一个节点。
                /*
                if(item.childCount>0){
                    $scope.selectData.filetypeid=item.children[0].id;
                    $scope.loadData();
                }*/

            });
        };

        $scope.clickTreeChild=function(item){

            $scope.selectData.pageindex = 1;
            $scope.selectData.filetypeid=item.id;
            $scope.selectData.filetypename=item.name;

            $scope.selectData.fileName = '';

            if(!item.children){
                $scope.loadTreeChild(item);
            }
            if(item.childcount>0){
                item.expand=!item.expand;
            }
            $scope.loadData();
        };

        $scope.searchFile = function (){
            $scope.selectData.pageindex = 1;
            $scope.FindWord();
        }

        $scope.FindWord = function () {

            if ($scope.selectData.fileName.length > 0) {
                //$window.open('http://10.160.8.64:8080/es/search.do?keyWords=' + decodeURI($scope.selectKey));
                //$bsRouterState.go('home.fileFrame', {keyWords: $scope.selectKey});
                $http({
                    method: 'get',
                    url: '../../api/filemgr/GetFilesByKey',
                    params: $scope.selectData
                }).then(function (req) {
                    //$loading.hide();
                    $scope.fileList = req.data.item.list;
                    $scope.selectData.ptotal = req.data.item.total;
                    $scope.selectData.filetypeid = '';
                }, function (resp) {
                    //$loading.hide();
                });
            } else {
                $alert({title: '提示：', content: '请输入关键字！', placement: 'top', type: 'info', show: true, duration: 3});
            }

        }


        $scope.GetTreeData = function (id) {
            $scope.treeList.splice(0, $scope.treeList.length);

            $http({
                method: 'get',
                url: '../../api/filemgr/GetFileTypesByParent',
                params: {
                    parentid: id
                }
            }).then(function (result) {

                /*
                $timeout(function () {
                    $ang.forEach(result.data.item, function (it) {
                    $scope.treeList.push(it);
                });
                }, 1000);*/
                $scope.selectData.filetypeid = result.data.item[0].filetypeid;
                $scope.selectData.pageindex = 1;
                $scope.loadData();

            }, function (resp) {

            });

        }

        $scope.loadData = function () {
            if (!$scope.selectData.filetypeid) {
                return;
            }
            //$loading.show();
            $http({
                method: 'get',
                url: '../../api/filemgr/GetFilesByType',
                params: $scope.selectData
            }).then(function (req) {
                //$loading.hide();
                $scope.fileList = req.data.item.list;
                $scope.selectData.ptotal = req.data.item.total;
            }, function (resp) {
                //$loading.hide();
            });
        };

        //监视页数变化
        $scope.$watch("selectData.pageindex", function (newVal, oldVal) {
            if ($scope.selectData.ptotal > 0) {
                if ($scope.selectData.fileName != null && $scope.selectData.fileName != ''){
                    $scope.FindWord();
                }else {
                    $scope.loadData();
                }
            }
        });


        $scope.GetNavData();

        $scope.selectTab = function (id) {
            $scope.selectTabId = id;
            $scope.GetTreeData(id);
        };

        $scope.selectTree = function (id) {

            $scope.selectData.filetypeid = id;
            $scope.selectData.pageindex = 1;
            $scope.loadData();
        };

        $scope.isSelected = function (id) {
            return $scope.selectTabId == id;
        };

        $scope.isTreeSelect = function (id) {
            return $scope.selectData.filetypeid == id;
        };
        


        var fileViewModal = $modal({
            scope: $scope,
            title: '文件展现',
            templateUrl: 'filemanage/doc-show.html?' + window.sysVersion,
            controller: 'fileViewCtrl',
            show: false,
            animation: 'am-fade-and-slide-top'
        });


        $scope.viewFile = function (fileid, filename) {
            //window.open('../../api/home/downloadFile/' + fileid,"_blank");
            $scope.viewFileId = fileid;
            $scope.viewFileName = filename;
            //$scope.isrc = '/api/filemgr/showDoc/' + $scope.viewFileId;
            fileViewModal.$promise.then(fileViewModal.show);
        };

        $scope.downloadFile = function (fileid) {
            $window.open('../../api/filemgr/downDoc/' + fileid);
        };
        $scope.delete = function (id) {
            if (confirm("是否确定删除？")) {
                $http({
                    url: "../../api/filemgr/deleteFile",
                    method: 'GET',
                    params: {fileId: id}
                }).then(function (result) {
                    $scope.showMsg("消息", result.data.msg);
                    if (result.data.success) {
                        $scope.loadData();
                    }
                });
            }
        };
        var savemodalCtrl = function ($scope, $http,Upload,$alert) {
            $scope.params = myModal.params;
            $scope.content = myModal.params.content;
            $scope.isDetail=true;
            $scope.fid=null;
            $scope.updata={
                isuping:false,
                progressPer:0,
                updated:false
            };

            $scope.valiFileType=function(){

                if($scope.content.file!= null){
                    var filename=$scope.content.file.name;
                    var loc = filename.lastIndexOf('.');
                    var filetype = filename.substring(loc + 1, filename.length).toLowerCase();
                    if(filetype!='pdf'){
                        $alert({
                            title: '消息',
                            content: "只允许上传pdf",
                            placement: 'top',
                            type: 'info',
                            show: true,
                            duration: 3,
                            container: '#dicmodal'
                        });

                        $scope.content.file=null;
                    }
                } else{
                    $scope.updata.updated=false;
                }

            };

            $scope.upfile=function(){
                $scope.updata.isuping=true;
                Upload.upload({
                    url: '../../api/filemgr/postFile',
                    data: {file: $scope.content.file, 'fileId': $scope.content.fileid}
                }).then(function (resp) {
                    if (resp.data.success) {
                        $alert({
                            title: '消息',
                            content: resp.data.msg,
                            placement: 'top',
                            type: 'info',
                            show: true,
                            duration: 3
                        });
                        //fileObject.loadItems(fileObject.fileoption);
                        //$scope.updata.progressPer=100;
                        $scope.updata.isuping=false;
                        $scope.updata.updated=true;

                    } else {
                        $scope.updata.progressPer=0;
                        $alert({
                            title: '消息',
                            content: resp.data.msg,
                            placement: 'top',
                            type: 'info',
                            show: true,
                            duration: 3
                        });

                    }
                    //console.log('Success ' + resp.config.data.file.name + 'uploaded. Response: ' + resp.data);
                }, function (resp) {
                    $scope.updata.updated=false;
                    $alert({title: '错误', content: "上传服务器错误！", placement: 'center', type: 'info', show: true, duration: 3});
                    //$scope.updata.progressPer=0;

                }, function (evt) {
                    $scope.updata.progressPer = parseInt(100.0 * evt.loaded / evt.total);
                    //console.log('progress: ' + progressPercentage + '% ' + evt.config.data.file.name);
                });
            };

            $scope.submit = function (isflag) {
                if (isflag) {
                    if(!$scope.updata.updated){
                        $alert({
                            title: '提示：',
                            content: '请上传文件',
                            placement: 'top',
                            type: 'info',
                            show: true,
                            duration: 3
                        });
                        return;
                    }
                    $loading.show();
                    $http({
                        method: "post",
                        url: "../../api/filemgr/saveFile",
                        data: $scope.content
                    }).then(function (result) {
                        $loading.hide();
                        $alert({
                            title: '成功：',
                            content: result.data.msg,
                            placement: 'top',
                            type: 'info',
                            show: true,
                            duration: 3
                        });
                        //重新刷新列表
                        $scope.loadData();
                        $scope.$hide();

                    }), function (resp) {
                        $alert({
                            title: '错误：',
                            content: '服务器错误',
                            placement: 'top',
                            type: 'info',
                            show: true,
                            duration: 3
                        });
                    }
                }
            }
        };
        savemodalCtrl.$inject = ['$scope', '$http','Upload','$alert'];

        //新增或编辑字典 模态框
        var myModal = $modal({
            resolve: {
                load: ['$ocLazyLoad', function ($ocLazyLoad) {
                    return [$ocLazyLoad.load('../main/filemanage/fileEdit.css')];
                }]
            },
            scope: $scope,
            controller: savemodalCtrl,
            templateUrl: '../main/filemanage/fileEdit.html',
            show: false,
            animation: 'am-fade-and-slide-top'
        });

        $scope.addFile = function () {
            myModal.content = {};
            myModal.params = {
                title: "新增制度文件",
                dicTypeKeyDisabled: false,
                dicTypeDisabled: true,
                content: {dictype: 2,filetypeid:$scope.selectData.filetypeid}
            };
            $http.get("../../api/filemgr/getFile", {params: {'id': null}}).then(function (result) {
                console.log(result);
                $loading.hide();
                myModal.params.content = result.data.item;
                myModal.params.content.filetypeid=$scope.selectData.filetypeid;
                myModal.params.content.filetypename=$scope.selectData.filetypename;
                myModal.$promise.then(myModal.show);
            }, function () {
                $alert({title: '错误：', content: '服务器错误', placement: 'top', type: 'info', show: true, duration: 3});
            });
        };

        //打开字典编辑模态框
        $scope.editmodal = function (id) {
            myModal.params = {
                title: "制度文件编辑",
                dicTypeKeyDisabled: true,
                dicTypeDisabled: false,
                content: {}
            };
            $loading.show();
        };

    }).controller('fileViewCtrl', function ($scope, $http) {
        $scope.title = $scope.$parent.$parent.viewFileName;
        $scope.fileId = $scope.$parent.$parent.viewFileId;
        $scope.isrc = '/api/filemgr/showDoc/' + $scope.fileId;
    });
})(angular);
