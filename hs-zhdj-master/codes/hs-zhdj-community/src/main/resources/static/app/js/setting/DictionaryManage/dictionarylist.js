(function () {
    angular.module('devself.common').controller('dictionarylistCtrl', function ($scope, $http, $modal, $ocLazyLoad, $alert, $loading, $state,$bsRouterState) {
        $scope.title = "字典列表";
        $scope.searchTypeKey = "";
        $scope.dicvalue = "";
        $scope.diclist = [];
        $scope.viewport = {
            selector: "div[name='dictionarybody']",
            padding: 0
        };

        $state.params=$bsRouterState.$params($scope);

        //初始分页参数
        $scope.finddata = {
            pageindex: 1,//页数
            pagesize: 10,//每页展示记录条数
            ptotal: 0//总记录数
        };

        //监视页数变化
        $scope.$watch("finddata.pageindex", function (newVal, oldVal) {
            if ($scope.finddata.ptotal > 0) {
                $scope.getList();
            }
        });

        //查询
        $scope.search = function () {
            $scope.finddata.pageindex = 1;
            $scope.finddata.ptotal = 0;
            $scope.getList();
        };

        //查询
        $scope.getList = function () {
            $loading.show();
            $http({
                method: "get",
                url: "../../api/dictionary/dictionaryList",
                params: {
                    'dicTypeKey': $scope.searchTypeKey,
                    'pageIndex': $scope.finddata.pageindex,
                    'pageSize': $scope.finddata.pagesize,
                    'appId': $state.params.appid,
                    'dicvalue' : $scope.dicvalue,
                }
            }).then(function (result) {
                $loading.hide();
                $scope.diclist = result.data.item.list;
                $scope.finddata.ptotal = result.data.item.total;
                if (result.data.item.total == 0) {
                    //$alert({ title: '消息：', content: '没有查询到字典记录', placement: 'top', type: 'info', show: true, duration: 3 });
                }
            }, function (resp) {
                $loading.hide();
                $alert({title: '错误：', content: '服务器错误', placement: 'top', type: 'info', show: true, duration: 3});
            });
        };
        //删除字典
        $scope.deletedic = function (id) {
            if (!confirm("确认删除？")) {
                return;
            }
            $http.get("../../api/dictionary/delDictionary", {params: {'dictionaryid': id}}).then(function (result) {
                $alert({
                    title: '成功：',
                    content: result.data.msg,
                    placement: 'top',
                    type: 'info',
                    show: true,
                    duration: 3
                });
                $scope.getList();
            }, function (req) {
                $alert({title: '错误：', content: '服务器错误', placement: 'top', type: 'info', show: true, duration: 3});
            });
        };


        var savemodalCtrl = function ($scope, $http) {
            $scope.params = myModal.params;
            $scope.content = myModal.params.content;

            $scope.dicTypeList = [{dictype: "系统", id: 1}, {dictype: "普通", id: 2}];

            $scope.submit = function (isflag) {
                if (isflag) {
                    $loading.show();
                    $http({
                        method: "post",
                        url: "../../api/dictionary/dictionarySave",
                        data: {
                            "dictionaryid": $scope.content.dictionaryid,
                            "dictypekey": $scope.content.dictypekey,
                            "dicvalue": $scope.content.dicvalue,
                            "dictype": $scope.content.dictype,
                            "dicnote": $scope.content.dicnote,
                            "dickey": $scope.content.dickey,
                            "applicationid": $state.params.appid
                        }
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
                        $scope.getList();
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
        savemodalCtrl.$inject = ['$scope', '$http'];

        //新增或编辑字典 模态框
        var myModal = $modal({
            resolve: {
                load: ['$ocLazyLoad', function ($ocLazyLoad) {
                    return [$ocLazyLoad.load('../js/setting/DictionaryManage/savedicmodal.css')];
                }]
            },
            scope: $scope,
            controller: savemodalCtrl,
            templateUrl: '../js/setting/DictionaryManage/savedicmodal.html',
            show: false,
            animation: 'am-fade-and-slide-top'
        });

        //打开字典新增模态框
        $scope.savemodal = function () {
            myModal.content = {};
            myModal.params = {
                title: "字典新增",
                dicTypeKeyDisabled: false,
                dicTypeDisabled: true,
                content: {dictype: 2}
            };
            myModal.$promise.then(myModal.show);
        };

        //打开字典编辑模态框
        $scope.editmodal = function (id) {
            myModal.params = {
                title: "字典编辑",
                dicTypeKeyDisabled: true,
                dicTypeDisabled: false,
                content: {}
            };
            $loading.show();
            $http.get("../../api/dictionary/getDictionaryByID", {params: {'id': id}}).then(function (result) {
                console.log(result);
                $loading.hide();
                myModal.params.content = result.data.item;
                myModal.$promise.then(myModal.show);
            }, function () {
                $alert({title: '错误：', content: '服务器错误', placement: 'top', type: 'info', show: true, duration: 3});
            });
        };
        $scope.getList();//初始化列表
        $scope.reset  = function () {
            $scope.searchTypeKey = "";
            $scope.dicvalue = "";
            //$scope.selectparams.selectdzzmc = $scope.selectparams.dzzmc = $scope.selectparams.zzlb = $scope.selectparams.jczzfl = '';
        }
    });
})();