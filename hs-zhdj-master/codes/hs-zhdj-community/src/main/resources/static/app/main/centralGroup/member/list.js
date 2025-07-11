(function ($app) {
    $app.module('gtPartyApp').controller('memberListCtrl', function ($scope, $http, $modal, $ocLazyLoad, $alert, $loading, $state, $stateParams, AuthUser,$bsRouterState) {

        $stateParams=$bsRouterState.$params($scope);
        //定义数据集合
        $scope.dataList = []; //列表数据
        $scope.changevm={};
        $scope.selectparams = {
            isunfold: false,//组织结构树展开收缩
            'pageindex': 1,
            'pagesize': 10,
            dzzdm:'',
            dzzmc:'学院党委',
            name: '',
            onlyshow_dw: $stateParams.type,
            zzfbType : null,
        };
        $scope.pageInfo = {ptotal: 0};
        $scope.selectUserMod = 0;
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

        $scope.$on('tabChildReloadData',function (event,data) {
            if(data.name=='memberListCtrl'){
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
                method: 'get', url: '../../api/zxzxx/zxz/list', params: $scope.selectparams
            }).then(function (result) {
                $scope.dataList = result.data.item.list;
                $scope.pageInfo.ptotal = result.data.item.total;
            });
        };

        //新增编辑
        var editMemberChangeCtrl = function ($scope, $http) {
            $scope.params = memberChangeModal.params;
            $scope.receivePcomm = memberChangeModal.receivePcomm;
            $scope.changevm.dwId = $scope.selectparams.dzzdm;
            $scope.changevm.dwName = $scope.selectparams.dzzmc;

            $scope.submitDZX = function (isflag) {
                if ($scope.changevm.userName == "" || $scope.changevm.userName == null) {
                    $scope.showMsg('错误', '请选择人员');
                    return false;
                }
                if ($scope.changevm.servingDate == "" || $scope.changevm.servingDate == null) {
                    $scope.showMsg('错误', '请填写任职时间');
                    return false;
                }
                if (isflag) {
                    $loading.show();
                    var mydata = {
                        zcy:{
                            id: $scope.changevm.id,
                            userId: $scope.changevm.userId,
                            dwId: $scope.changevm.dwId,
                            servingDate: $scope.changevm.servingDate
                        }
                    };
                    $http({
                        method: "post",
                        url: "../../api/zxzxx/zxz/edit",
                        data: mydata
                    }).then(function (result) {
                        $loading.hide();
                        $scope.showMsg('成功', result.data.msg);
                        //重新刷新列表
                        $scope.loadData();
                        $scope.$hide();
                    }), function (resp) {
                        $scope.showMsg('错误', '服务器错误');
                    }
                }
            };
        };
        editMemberChangeCtrl.$inject = ['$scope', '$http'];
            //定义模态框
        var memberChangeModal = $modal({
            resolve: {
                load: ['$ocLazyLoad', function ($ocLazyLoad) {
                }]
            },
            scope: $scope,
            controller: editMemberChangeCtrl,
            templateUrl: '../main/centralGroup/member/edit.html',
            show: false,
            animation: 'am-fade-and-slide-top'
        });
        $scope.addData = function () {
            $scope.changevm={};
            $scope.edit("新增中心组成员");
            $scope.selectUserMod = 1;
        };
        $scope.editData = function (id) {
            $http({
                method: "get",
                url: "../../api/zxzxx/zxz/get?id="+id
            }).then(function (result) {
                $scope.changevm = result.data.item;
                $scope.changevm.servingDate = $scope.changevm.servingDate.substring(0,10);
            }), function (resp) {
                $scope.showMsg('错误', '服务器错误');
            };
            $scope.edit("编辑党组织信息");
            $scope.selectUserMod = 0;
        };
        $scope.edit = function (title) {
            memberChangeModal.params = {
                title: title
            };
            memberChangeModal.$promise.then(memberChangeModal.show);
        };
        var editUserChangeCtrl = function ($scope, $http) {
            $scope.params = userChangeModal.params;
            $scope.receivePcomm = userChangeModal.receivePcomm;
        };
        editUserChangeCtrl.$inject = ['$scope', '$http'];
            //定义模态框
        var userChangeModal = $modal({
            resolve: {
                load: ['$ocLazyLoad', function ($ocLazyLoad) {
                }]
            },
            scope: $scope,
            controller: editUserChangeCtrl,
            templateUrl: '../main/centralGroup/member/userList.html',
            show: false,
            animation: 'am-fade-and-slide-top'
        });
        $scope.selectUser = function () {
            $scope.user("选择人员");
        };
        $scope.user = function (title) {
            userChangeModal.params = {
                title: title
            };
            userChangeModal.xm = '';
            userChangeModal.receivePcomm = {};
            $scope.SelectUserList();
        };

        $scope.SelectUserList = function (){
            $loading.show();
            $http.get("../../api/partyUser/getPartyUserList", {
                params: {
                    pageindex:1,
                    pagesize:1000,
                    dzzdm:$scope.changevm.dwId,
                    xm:$scope.changevm.xm,
                }
            }).then(function (result) {
                $loading.hide();
                var resultDataItemList = result.data.item.list;
                //console.log($scope.changevm.userId)
                for(var i=0;i<resultDataItemList.length;i++){
                    if($scope.changevm.userId!=undefined){
                        if($scope.changevm.userId == resultDataItemList[i].RYBM){
                            resultDataItemList[i].checked = true;
                            userChangeModal.receivePcomm = resultDataItemList[i];
                        }else{
                            resultDataItemList[i].checked = false;
                        }
                    }else{
                        resultDataItemList[i].checked = false;
                    }
                }
                $scope.receivePcommList = resultDataItemList;
                userChangeModal.$promise.then(userChangeModal.show);
            }, function () {
                $scope.showMsg('错误', '服务器错误');
            });
        };

        $scope.selectUserListSelect = function(){
            $scope.xm = userChangeModal.xm;
            $scope.SelectUserList();
        };
        $scope.chkchildren = function (item) {
            userChangeModal.receivePcomm = item;
        };
        $scope.quedingxuyao = function(){
            $scope.changevm.userId = userChangeModal.receivePcomm.RYBM;
            $scope.changevm.userName = userChangeModal.receivePcomm.XM;
            userChangeModal.$promise.then(userChangeModal.hide);
        };
        //删除
        $scope.deleteData = function (id) {
            if (confirm("是否确定删除？")) {
                $http({
                    url: "../../api/zxzxx/zxz/delete",
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
        $scope.setisunfold = function () {
            $scope.selectparams.isunfold = !$scope.selectparams.isunfold;
            $scope.$emit('menudatas.toggle', !$scope.selectparams.isunfold);
        };

        //$scope.loadData();
    });
})(angular);
