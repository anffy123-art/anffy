(function ($app) {
    $app.module('gtPartyApp').controller('partyUserListCtrl', function ($scope, $http, $modal, $ocLazyLoad, $alert, $loading, $state, $partySelect, $stateParams, AuthUser, $bsRouterState, $excel, $timeout) {
        $state.params = $bsRouterState.$params($scope);

        //定义数据集合
        $scope.treeList = []; //组织架构
        $scope.dataList = []; //列表数据
        $scope.zzlbdmList = [];//组织类别
        $scope.zwjbList = [];//职务级别
        $scope.ryztList = [];//人员状态
        $scope.xlList = [];//学历
        $scope.dnzwList = [];//党内职务
        $scope.mzList = [];//民族
        $scope.isShow = false;
        $scope.moreTxt = "更多";
        $scope.boolList = [{dickey: 1, dicvalue: '是'}, {dickey: 0, dicvalue: '否'}];
        $scope.xbList = [{BM: '1', HZMC: '男'}, {BM: '2', HZMC: '女'}];

        //初始化查询参数
        $scope.selectparams = {
            isunfold: false,//组织结构树展开收缩
            'pageindex': 1,
            'pagesize': 10,
            'selectdzzdm': '',
            selectdzzmc: '',
            defaultselected: $state.params.dzzdm,
            parentcode: AuthUser.getUser().ParentDpCode,
            parentname: AuthUser.getUser().ParentDpName,
            szdzzdm: AuthUser.getUser().DPCode,
            szdzzmc: AuthUser.getUser().DPName,
            dzzdm: AuthUser.getUser().DPCode,
            rybm: '',
            xm: $state.params.xm == undefined ? "" : $state.params.xm,
            zzlb: null,
            zwjb: null,
            sqrdrq_begin: '',
            sqrdrq_end: '',
            szdzb: '',
            szdxz: '',
            userid: AuthUser.getUser().Id,
            zzfbType: null,
            mz: null,
            dnzw: null,
            xl: null,
            ryzt: null,
            age_begin: null,
            age_end: null,
            zwmc: '',
            sfzg: $state.params.sfzg == undefined ? null : $state.params.sfzg,
            jczzfl: $state.params.jczzfl == undefined ? null : $state.params.jczzfl,
            leadId: AuthUser.getUser().Id
        };
        $scope.resetparams = {
            isunfold: false,//组织结构树展开收缩
            'pageindex': 1,
            'pagesize': 10,
            'selectdzzdm': '',
            selectdzzmc: '',
            defaultselected: $state.params.dzzdm,
            parentcode: AuthUser.getUser().ParentDpCode,
            parentname: AuthUser.getUser().ParentDpName,
            szdzzdm: AuthUser.getUser().DPCode,
            szdzzmc: AuthUser.getUser().DPName,
            dzzdm: AuthUser.getUser().DPCode,
            rybm: '',
            xm: $state.params.xm == undefined ? "" : $state.params.xm,
            zzlb: null,
            zwjb: null,
            sqrdrq_begin: '',
            sqrdrq_end: '',
            szdzb: '',
            szdxz: '',
            userid: AuthUser.getUser().Id,
            zzfbType: null,
            mz: null,
            dnzw: null,
            xl: null,
            ryzt: null,
            age_begin: null,
            age_end: null,
            zwmc: ''
        };
        $scope.pageInfo = {ptotal: 0};
        //监视页数变化
        $scope.$watch("selectparams.pageindex", function (newVal, oldVal) {
            if ($scope.pageInfo.ptotal > 0) {
                $scope.loadData();
            }
        });

        $scope.$watch("selectparams.selectdzzdm", function (newVal, oldVal) {
            if (newVal != '' && newVal != null) {
                if ($scope.selectparams.defaultselected != "" && $scope.selectparams.defaultselected != null &&
                    $scope.selectparams.defaultselected != $scope.selectparams.selectdzzdm)
                    return;

                $scope.selectparams.defaultselected = "";

                $scope.selectparams.dzzdm = $scope.selectparams.selectdzzdm;
                $scope.loadData();
            }
        });

        $scope.$watch("selectparams.zzfbType", function (newVal, oldVal) {
            if (newVal != oldVal) {
                $scope.loadData();
            }
        });

        //查询
        $scope.search = function () {
            $scope.loadData();
        };
        //导出
        $scope.export = function () {
            if (AuthUser.getUser().Id) {
                var params = "?1=1";
                for (var p in $scope.selectparams) {
                    if ($scope.selectparams[p] !== '' && $scope.selectparams[p] !== null)
                        params += ("&" + p + "=" + encodeURI($scope.selectparams[p]));
                }
                window.open('../../api/partyUser/exportPartyUser' + params);
            }
        };

        $scope.$on('tabChildReloadData', function (event, data) {
            if (data.name == 'partyUserListCtrl') {
                $scope.loadData();
            }
        });
        //加载列表数据
        $scope.loadData = function () {
            if (AuthUser.getUser().Id) {
                $http
                ({
                    method: 'get', url: '../../api/partyUser/getPartyUserList', params: $scope.selectparams
                }).then(function (result) {
                    $scope.dataList = result.data.item.list;
                    $scope.pageInfo.ptotal = result.data.item.total;
                    //$scope.selectparams.jczzfl = null;
                });
            }
        };


        //新增编辑党员信息
        $scope.addDyUser = function () {
            $bsRouterState.$closeTabName("home.dyUserAdd");
            $timeout(function () {
                $bsRouterState.go('home.dyUserAdd', {userId: "", userType: 1, isDetail: 1});
            }, 100);
        };
        $scope.editDyUser = function (rybm, userType) {
            $bsRouterState.$closeTabName("home.dyUserEdit");
            $timeout(function () {
                $bsRouterState.go('home.dyUserEdit', {rybm: rybm, userType: userType, isDetail: 1});
            }, 100);

        };
        $scope.detailDyUser = function (rybm, userType) {
            $bsRouterState.$closeTabName("home.partyUserShow");
            $timeout(function () {
                $bsRouterState.go('home.partyUserShow', {rybm: rybm, userType: userType, isDetail: 0});
            }, 100);

        };

        $scope.delete = function (rybm) {
            if (confirm("是否确定删除？")) {
                $http({
                    url: "../../api/partyUser/deletePartyById_ZN",
                    method: 'GET',
                    params: {rybm: rybm}
                }).then(function (result) {
                    $scope.showMsg("消息", result.data.msg);
                    if (result.data.success) {
                        $scope.loadData();
                    }
                });
            }
        };

        //导入登录账号
        $scope.excelUserInfoConfig = {
            filetype: 1,
            columns: {
                '姓名': 'userName',
                '党员编码': 'userCode',
                '学号/工号': 'mobile',
                '政治面貌': 'politicalStatus',
                '所属党支部名称': 'partyName',
                '入党日期': 'inPartyDate',
                '性别': 'sex',
                '民族': 'national',
                '出生日期': 'birthDate',
                '籍贯': 'nativePlace',
                '身份证号': 'idCard',
                '年级': 'gradeName',
                '班级': 'className',
                '学历': 'education',
                '最高学历入学日期': 'enrollmentDate',
                '最高学历毕业日期': 'graduateDate',
                '工作时间': 'workDate',
                '联系电话': 'contactMobile',
                '技术职务': 'technologyPosition',
                '是否学生身份':'isStudent'
            },
            errorcolumns: {
                'userName': '姓名',
                'userCode': '党员编码',
                'mobile': '学号/工号',
                'partyName': '所属党支部名称',
                'birthDate': '出生日期',
                'politicalStatus': '政治面貌',
                'inPartyDate': '入党日期',
                'errorInfo': '错误信息'
            },
            readonly: false,
            templateUrl: '/doc/template/党员信息导入模版.xlsx'
        };

        $scope.import = function () {
            $excel.addFile($scope.excelUserInfoConfig).then(function (items) {
                $loading.show();
                $http({
                    method: "post",
                    url: "../../api/partyUser/importUserInfo",
                    data: {
                        userList: JSON.stringify(items)
                    }
                }).then(function (result) {
                    $loading.hide();
                    if (result.data.success) {
                        $scope.loadData();
                        $scope.showMsg('成功', result.data.msg, 3);
                    } else {
                        if (result.data.item.length > 0) {
                            $scope.showMsg('错误', '导入失败，存在错误数据，请修改后重新导入！', 20);
                            $excel.showErrorInfo(result.data.item);
                        } else {
                            $scope.showMsg(result.data.msg);
                        }
                    }

                }, function (resp) {
                    $loading.hide();
                    $scope.showMsg('错误', '服务器错误');
                })
            });
        };

        //导入登录账号
        $scope.excelUserMobileConfig = {
            filetype: 1,
            columns: {
                '人员编码': 'userCode',
                '登录账号': 'mobile'
            },
            errorcolumns: {
                'userCode': '人员编码',
                'mobile': '登录账号'
            },
            readonly: false,
            templateUrl: ''
        };
        $scope.importMobile = function () {
            $excel.addFile($scope.excelUserMobileConfig).then(function (items) {
                $loading.show();
                $http({
                    method: "post",
                    url: "../../api/partyUser/importUserMobile",
                    data: {
                        userList: JSON.stringify(items)
                    }
                }).then(function (result) {
                    $loading.hide();
                    if (result.data.success) {
                        $scope.showMsg('成功', result.data.msg, 3);
                    } else {
                        $scope.showMsg('失败', result.data.msg, 30);
                    }

                }, function (resp) {
                    $loading.hide();
                    $scope.showMsg('错误', '服务器错误');
                })
            });
        };

        //人员状态
        $scope.getRyztList = function () {
            $http({
                method: 'get',
                url: '../../api/partyDic/getRyztList',
                params: {}
            }).then(function (result) {
                angular.forEach(result.data, function (val) {
                    if (val.bm == "2" || val.bm == "3") {
                        $scope.ryztList.push(val);
                    }
                });
            }, function (resp) {
            });
        };

        //学历
        $scope.getEducationList = function () {
            $http({
                method: 'get',
                url: '../../api/partyDic/getEducationList'
            }).then(function (result) {
                $scope.xlList = result.data;
            }, function (resp) {

            });
        };

        //党内职务
        $scope.getZwmcList = function () {
            $http({
                method: 'get',
                url: '../../api/partyDic/getZwmcList',
                params: {}
            }).then(function (result) {
                $scope.dnzwList = result.data;
            }, function (resp) {
            });
        };

        //民族
        $scope.getMZList = function () {
            $http({
                method: 'get',
                url: '../../api/partyDic/getNationList'
            }).then(function (result) {
                $scope.mzList = result.data;
            }, function (resp) {

            });
        };


        //数据初始化
        $scope.getRyztList();
        $scope.getEducationList();
        $scope.getZwmcList();
        $scope.getMZList();

        $scope.showMsg = function (title, content, duration) {
            $alert({
                title: title + '：',
                content: content,
                placement: 'top',
                type: 'info',
                show: true,
                duration: duration
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
            $scope.selectparams.isunfold = !$scope.selectparams.isunfold;
            $scope.$emit('menudatas.toggle', !$scope.selectparams.isunfold);
        };
        $scope.reset = function () {
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
            $scope.selectparams.xm = $scope.resetparams.xm;
            $scope.selectparams.mz = $scope.resetparams.mz;
            $scope.selectparams.dnzw = $scope.resetparams.dnzw;
            $scope.selectparams.xl = $scope.resetparams.xl;
            $scope.selectparams.ryzt = $scope.resetparams.ryzt;
            $scope.selectparams.age_begin = $scope.resetparams.age_begin;
            $scope.selectparams.age_end = $scope.resetparams.age_end;
            $scope.selectparams.zwmc = $scope.resetparams.zwmc;
            //$scope.selectparams.selectdzzmc = $scope.selectparams.dzzmc = $scope.selectparams.zzlb = $scope.selectparams.jczzfl = '';
        }

    });
})(angular);
