/**
 ---------------------------------------
 方法：bsselectdata //列表选择
 引用：
 <span class="input-group-addon" data-url="../../api/DemandDev/FindSysdata" data-datatext="item.SystemName" data-dataval="item.SystemID" bsselectdata><i class="glyphicon glyphicon-zoom-in"></i></span>
 参数说明
 data-url：数据源的url地址
 data-datatext：数据选择文字双向绑字段
 data-dataval：数据选择ID双向绑字段
 data-aid:扩展传参数（可空）
 ---------------------------------------
 方法：flowaudit //流程提交服务
 引用：
 controller('demandupCtrl', function (flowaudit) {
    flowaudit.startflow({appid: "",uid: "",flowname:"",onstartSuccess:function(rq){}})
    flowaudit.showaudit({pid: "", fid: "", onsuccess: function(){}});
}）
 1.startflow开启流程实例
 参数说明：
 appid:流程id
 uid:用户id
 flowname:流程名称用于待办
 onstartSuccess：返回function(rq){}
 rq: data {
FlowID:流程实例ID，
ProcessID：流程步骤ID，
success：提升是否成功
}
 2.showaudit提交
 参数说明：
 pid:环节id
 fid:流程实例id
 onsuccess:成功调用函数
 ---------------------------------------
 方法：pagination //分页
 引用：
 <pagination  data-pageindex="finddata.pageindex" data-pagesize="finddata.pagesize" data-ptotal="finddata.ptotal"></pagination>
 参数说明:
 data-pageindex：选择页面
 data-pagesize：页面展示数据条数
 data-ptotal：数据总数
 ---------------------------------------
 方法：AuthUser //当前人员方法
 引用：controller('demandlistCtrl', function (AuthUser){
    AuthUser.getUser();
}）
 getUser：获取当前登陆人员信息
 返回：{人员信息}
 字段
 DGUserID：用户ID
 Name：用户名
 Mobile：用户手机
 DPID：用户机构ID
 DPName：用户机构名
 DPCode：用户机构代号
 ---------------------------------------
 方法：userselect //人员选择框
 引用：
 多选
 <span data-textids="test1" data-textnames="test2" data-datausers="test3" data-testguids="test4" userselect><i class="glyphicon glyphicon-zoom-in"></i></span>
 单选
 <span data-textids="test1" data-textnames="test2" data-datausers="test3" data-testguids="test4" data-selecttype="single" userselect><i class="glyphicon glyphicon-zoom-in"></i></span>
 参数说明
 data-textnames：所选人员的名字拼接字符串双向绑定   例如："xxx,xxx,xxx"
 data-textids：所选人员的DGUserID拼接字符串双向绑定  例如"xxxxxxx,xxxxxx,xxxxxxx"
 data-textguids：所选人员的UserID拼接字符串双向绑定   例如"xxxxxxxxxx,xxxxxxxxxx,xxxxxxxxxx"
 data-datausers：所选人员的对象双向绑定，若没有使用到该数据，可以在引用的时候设置为  data-datausers="[]"
 data-selecttype：人员选择模式，默认为多选  可选值:single/multi
 data-isNotRelated:是否关联用一个父元素的input标签(点击input标签时也可以触发该控件)，默认为false  可选值:true/fasle(不关联)
 ---------------------------------------
 指令：bsfiles
 必要参数：ngModel
 示例：<bsfiles ng-model="viewdata.reqFileModel" />
 参数格式：
 {
                 selectdata: { FileRefID: '', pageindex: 1, pagesize: 10, ptotal: 0 },//查询参数：FileRefID为文件关联ID
                 filetype:1,//文件类型
                 items: [],//列表数据地址
                 readonly:false,//是否只能查看
                 canupfileAsync: function () {
                     var deferred = $q.defer();

                     if ($scope.item.DemandApplyID == GuidEmpty) {
                         $scope.asyncSave().then(function (srq) {
                             deferred.resolve($scope.item.DemandApplyID);
                         }, function (flasesrq) {
                             deferred.reject(flasesrq);
                         });
                     } else {
                         deferred.resolve($scope.item.DemandApplyID);
                     }

                     return deferred.promise;
                 }
             }
 ---------------------------------------
 指令：bsLvtree
 引用：<bs_lvtree ng-model="option"></bs_lvtree>
 $scope.option = {
            xAxis: [{ id: 0, name: '系统' }, { id: 1, name: '模块' }, { id: 2, name: '应用' }, { id: 3, name: '功能点' }],
            data: [{ id: 'xx01', xid: 0, pid: null, name: '协同办公平台' }, { id: 'xx11', xid: 1, pid: 'xx01', name: '业务支持中心' }, { id: 'xx12', xid: 1, pid: 'xx01', name: '开发易' }, { id: 'xx111', xid: 2, pid: 'xx11', name: '数据修改' }, { id: 'xx112', xid: 2, pid: 'xx11', name: '数据查询' },
            { id: 'xx1111', xid: 3, pid: 'xx111', name: '工作台' }, { id: 'xx1112', xid: 3, pid: 'xx111', name: '修改申请' }, { id: 'xx1113', xid: 3, pid: 'xx111', name: '查询修改' }
            ],
            canEdit: false,--是否显示编辑按钮
            canChecked: false ---是否显示选择最后一级按钮
            btnclick:function(item,type),type-1:新增同级,2:新增子级,3:删除节点,4:主窗口
        };
 ---------------------------------------
 指令：sysselect 功能选择控件
 必要参数：
 textids:选择完成后，返回的ID,格式如"xxx,xxx,xxx"
 texttext:选择完成后，返回对应的名称，格式如"xxx,xxx,xxx"
 selecteditems:选择完成后，返回选择的集合
 可选参数：
 title：弹出模态框的标题
 selecttype：选择类型，若不填则默认为选择系统。0-选择系统;1-选择模块;2-选择菜单;3-选择功能点
 singlemode:选择模式，若不填则默认为多选模式。 true-单选模式,false-多选模式
 notrelated:是否取消关联用一个父元素的input标签(点击input标签时也可以触发该控件)，默认为false  可选值:true(关联)/fasle(不关联)
 示例：
 1：
 <button sysselect data-title="菜单选择" data-notrelated="true" data-textids="selectids" data-textnames="selectnames" data-selecteditems="selecteditems"  data-selecttype="3">测试</button>
 2：
 <label class="input-group">
 <input ng-model="sysselect.names" disabled/>
 <button sysselect data-title="菜单选择" data-textids="selectids" data-textnames="selectnames" data-selecteditems="selecteditems" data-singlemode="true" data-selecttype="0">测试按钮</button>
 </label>
 -------------------------------------------------------------------------
 指令：bsselectdataPro
 引用：<button dataoptions='param'>
 参数格式：{
                url:'../../api/home/selectlist',
                title:'测试选择',
                isMulti:false,
                selectData:{dictypekey:'字典关系字',dicvalue:'字典值'},
                columns:{dickey:'字典数',dicvalue:'字典值',dictypekey:'字典关健类型',dictype:'字典类型'},
                selectLabelKey:'dicvalue',
                selectValuekey:'dictionaryid',
                selectedValueData:'id1,id2',
                selectedLabeData:'name1,name2',
                selectParams:{}
            }

 ---------------------------------------------------------------
 服务$payService支付服务调用
 方法 1.payShow(model)开始支付。model：{}，字段查看yy_payOrder
 例如：{amt:221.00,payRelID:'xxxxx1',companyID:'8c7d150b-9be7-4a06-a7cb-552a4ddc0ce9',creatorID:$scope.User.Id,commodityName:'测试商品'}
 */
(function ($ang) {
    'use strict';

    $ang.module('devself.common', []).factory("AuthUser", function ($window, $timeout, $q) {
        var lstorage = $window.localStorage;
        //lstorage["islogin"] = "0";
        var authUser = {
            islogin: function () {
                return lstorage["islogin"] == "1";
            },
            setlogin: function () {
                lstorage["islogin"] = "1";
            }, loginout: function () {
                lstorage["islogin"] = "0";
            }
        };

        authUser.getUser = function () {
            var d_user = {
                Id: lstorage['Id'],
                IsEnt: lstorage['extData'] != "null",
                DGUserID: lstorage['DGUserID'],
                Name: lstorage['Name'],
                Mobile: lstorage['Mobile'],
                DPID: lstorage['DPID'],
                DPName: lstorage['DPName'],
                DPCode: lstorage['DPCode'],
                DPFullName: lstorage['DPFullName'],
                SexID: lstorage['SexID'],
                ParentDpCode: lstorage['ParentDpCode'],
                ParentDpName: lstorage['ParentDpName'],
                DataDzzdm: lstorage['DataDzzdm'],
                gddwdm: lstorage['gddwdm'],
                userType: lstorage['userType'],  //1站内，2路外
                dataScope: lstorage['dataScope'],
                curRoleId: lstorage['curRoleId'],
                dwId: lstorage['dwId'],
                dwName: lstorage['dwName'],
                oaUserId: lstorage['oaUserId'],
                oaIdCard: lstorage['oaIdCard'],
                generalPartyCode: lstorage['generalPartyCode']
            };

            return d_user;
        };

        authUser.getExtData = function () {
            return angular.fromJson(lstorage['extData'] == "null" ? "{}" : lstorage['extData']);
        };

        authUser.setExtData = function (a_data) {
            lstorage['extData'] = angular.toJson(a_data);
        };

        authUser.clearExtData = function () {
            lstorage['extData'] = null;
        };

        authUser.setUser = function (d_user) {

            if (d_user) {
                lstorage['Id'] = d_user.id;
                lstorage['DGUserID'] = d_user.dguserid;
                lstorage['Name'] = d_user.name;
                lstorage['Mobile'] = d_user.mobile;
                lstorage['DPID'] = d_user.pdid;
                lstorage['DPName'] = d_user.dpname;
                lstorage['DPCode'] = d_user.dpcode;
                lstorage['DPFullName'] = d_user.dpfullname;
                lstorage['SexID'] = d_user.sexid;
                lstorage['ParentDpCode'] = d_user.parentdpid;
                lstorage['ParentDpName'] = d_user.dpfullname;
                lstorage['DataDzzdm'] = d_user.dataDzzdm;
                lstorage['gddwdm'] = d_user.gddwdm;
                lstorage['userType'] = d_user.userType;
                lstorage['dataScope'] = d_user.dataScope;
                lstorage['curRoleId'] = d_user.curRoleId;
                lstorage['dwId'] = d_user.dwId;
                lstorage['dwName'] = d_user.dwName;
                lstorage['oaUserId'] = d_user.oaUserId;
                lstorage['oaIdCard'] = d_user.oaIdCard;
                lstorage['generalPartyCode'] = d_user.generalPartyCode;

                if (d_user.id) {
                    authUser.setlogin();
                }

            } else {
                authUser.loginout();
            }

        };

        authUser.clearUser = function () {
            lstorage['Id'] = null;
            lstorage['DGUserID'] = null;
            lstorage['Name'] = null;
            lstorage['Mobile'] = null;
            lstorage['DPID'] = null;
            lstorage['DPName'] = null;
            lstorage['DPCode'] = null;
            lstorage['DPFullName'] = null;
            lstorage['SexID'] = null;
            lstorage['ParentDpCode'] = null;
            lstorage['ParentDpName'] = null;
            lstorage['DataDzzdm'] = null;
            lstorage['gddwdm'] = null;
            lstorage['userType'] = null;
            lstorage['dataScope'] = null;
            lstorage['curRoleId'] = null;
            lstorage['dwId'] = null;
            lstorage['dwName'] = null;
            lstorage['oaUserId'] = null;
            lstorage['oaIdCard'] = null;
            lstorage['generalPartyCode'] = null;
            authUser.loginout();
            authUser.clearExtData();
        };


        authUser.dofunAfterLogin = function () {
            var defer = $q.defer();

            $timeout(function () {
                if (authUser.islogin()) {
                    defer.resolve(authUser.getUser());
                }
            }, 1000);

            return defer.promise;
        };

        return authUser;
    }).directive('bsselectdata', function ($http, $modal) {
        var directiveObject = {
            restrict: 'EAC',
            scope: {
                dataval: '=',
                datatext: '=',
                title: '@'
            },
            link: function (scope, element, attr, controller) {
                if (angular.isDefined(attr['url']) && angular.isDefined(attr['dataval']) && angular.isDefined(attr['datatext'])) {

                    var sdModalController = function ($scope) {
                        //选择模式，默认单选；单选-single/多选-multi
                        //判断是否为多选模式
                        $scope.isMulti = attr['selecttype'] == "multi" ? true : false;
                        //扩展Array类，通过员工号判断数组中是否存在某元素
                        Array.prototype.contains = function (obj) {
                            var i = this.length;
                            while (i--) {
                                if (this[i].val === obj.val) {
                                    return i;
                                }
                            }
                            return -1;
                        };

                        $scope.finddata = {
                            aid: angular.isDefined(attr['aid']) ? attr['aid'] : '', pageindex: 1, pagesize: 5, ptotal: 0
                        };
                        //监视页面的变化
                        $scope.$watch("finddata.pageindex", function (newVal, oldVal) {
                            if ($scope.finddata.ptotal > 0) {
                                $scope.loadData();
                            }
                        });

                        attr.$observe('aid', function (newValue, oldValue) {
                            if (newValue) $scope.finddata.aid = newValue;
                        });

                        //多选缓存
                        $scope.selecttemp = [];
                        //多选模式中单击方法
                        $scope.selectOne = function (item) {
                            if (item.checked && $scope.selecttemp.indexOf(item) < 0) {
                                $scope.selecttemp.push(item)
                            }
                            if (!item.checked) {
                                var index = $scope.selecttemp.indexOf(item);
                                if (index > -1) {
                                    $scope.selecttemp.splice(index, 1)
                                }
                            }
                        };

                        $scope.data = {
                            findkey: '', items: [], radioit: null
                        };
                        $scope.title = scope.title;
                        $scope.selectedData = function () {
                            if ($scope.data.radioit) {
                                scope.dataval = $scope.data.radioit.val;
                                scope.datatext = $scope.data.radioit.label;
                            }
                            if ($scope.isMulti) {
                                var valarr = [];
                                var namearr = [];
                                angular.forEach($scope.selecttemp, function (item) {
                                    valarr.push(item.val);
                                    namearr.push(item.label);
                                });
                                scope.dataval = valarr.join(",");
                                scope.datatext = namearr.join(",");
                            }
                            $scope.$hide();
                        };

                        $scope.findData = function () {
                            $scope.loadData();
                        };

                        $scope.loadData = function () {
                            $http({
                                method: 'GET',
                                url: attr['url'],
                                params: angular.extend($scope.finddata, {findkey: $scope.data.findkey})
                            }).then(function (req) {
                                $scope.data.items = req.data.item.list;
                                $scope.finddata.ptotal = req.data.item.total;
                                //判断是否为多选，若是，则初始化checkbox选择状态
                                if ($scope.isMulti) {
                                    $scope.multiselectFilter($scope.data.items)
                                }
                            });

                        };
                        //初始化checkbox选择状态，主要用于分页后记录已选择的人员
                        $scope.multiselectFilter = function (list) {
                            angular.forEach(list, function (user) {
                                if ($scope.selecttemp.contains(user) >= 0) {
                                    user.checked = true;
                                }
                            })
                        };

                        $scope.loadData();
                    };

                    sdModalController.$inject = ['$scope'];

                    var sdModal = $modal({
                        scope: scope,
                        controller: sdModalController,
                        templateUrl: '../js/template/modal_selectdata.html',
                        show: false
                    });

                    //data-isNotRelated:是否关联用一个父元素的input标签(点击input标签时也可以触发该控件)，默认为false  可选值:true/fasle(不关联)
                    if (attr['isNotRelated']) {
                        element.on("click", function () {
                            sdModal.$promise.then(sdModal.show);
                        });
                        element.css({cursor: 'pointer'});
                    } else {
                        element.parent().on("click", function () {
                            sdModal.$promise.then(sdModal.show);
                        });
                        element.css({cursor: 'pointer'});
                        element.parent().children("input").css({cursor: 'pointer', "background-color": "#FFFFFF"});
                    }

                }
            }
        };

        return directiveObject;

    }).provider("flowaudit", function () {
        //流程提交参数修改成可以在引用配置下面操作地址，用来解决不同应用调用问题
        var defaults = this.defaults = {
            appid: '', fid: '', pid: '', uid: '',
            flowurl: '../../api/flow/getflownextinfo',
            userurl: '../../api/flow/getflownextusers',
            putnexturl: '../../api/flow/putnextsteps',
            startflowurl: '../../api/flow/startflow'
        };

        this.$get = function ($http, $modal, $alert, $q) {

            var faudit = {
                onnextsuccess: false,
                afuns: ''
            };

            angular.extend(faudit, defaults);

            faudit.startflow = function (sparams, option) {
                angular.extend(faudit, option);
                faudit.appid = sparams.appid;
                faudit.uid = sparams.uid;
                $http({
                    url: faudit.startflowurl,
                    method: 'GET',
                    params: {appId: faudit.appid, flowName: sparams.flowname, workBy: faudit.uid}
                }).then(sparams.onstartSuccess);
            };

            faudit.startflowAsync = function (sparams, option) {
                angular.extend(faudit, option);
                faudit.appid = sparams.appid;
                faudit.uid = sparams.uid;
                var deferred = $q.defer();

                $http({
                    url: faudit.startflowurl,
                    method: 'GET',
                    params: {appId: faudit.appid, flowName: sparams.flowname, workBy: faudit.uid}
                }).then(
                    function (TureRq) {
                        if (TureRq.data.success) {
                            deferred.resolve(TureRq);
                        } else {
                            deferred.reject(TureRq);
                        }
                    }, function (FalseRq) {
                        deferred.reject(TureRq);
                    }
                );

                return deferred.promise;
            };

            var faModalController = function ($scope, $filter, AuthUser) {

                $scope.title = '流程处理';
                $scope.flowdata = {selectedaction: false, flowInfo: {}, flowUsers: [], comment: ""};
                $scope.fauditInfo = faudit;
                $scope.loadflow = function () {
                    $http({
                        method: 'GET',
                        url: $scope.fauditInfo.flowurl,
                        params: {processId: $scope.fauditInfo.pid, afuns: $scope.fauditInfo.afuns}
                    }).then(function (rq) {
                        if (rq.data.success) {
                            $scope.flowdata.flowInfo = rq.data.item;
                            if ($scope.flowdata.flowInfo.flowtp == 0) {
                                $scope.flowdata.comment = "同意";
                            }
                            $scope.flowdata.selectedaction = $scope.flowdata.flowInfo.nextactions[0];
                        } else {
                            $alert({
                                title: '消息',
                                content: rq.data.msg,
                                placement: 'centre',
                                type: 'info',
                                show: true,
                                duration: 3
                            });
                        }
                    });
                };

                $scope.$watch("flowdata.selectedaction", function (newVal, oldVal) {

                    if (!$scope.flowdata.selectedaction) {
                        return false;
                    }

                    $scope.flowdata.flowUsers.length = 0;
                    $http({
                        method: 'GET',
                        url: $scope.fauditInfo.userurl,
                        params: {processId: $scope.fauditInfo.pid, actionId: $scope.flowdata.selectedaction.actionid}
                    }).then(function (rq) {
                        //赋值时判断当前选中的步骤ID是否为改变值中的步骤ID，防止网络差时错误显示用户列表-hyl
                        if (rq.data.success && $scope.flowdata.selectedaction.actionid == newVal.actionid) {
                            $scope.flowdata.flowUsers = rq.data.item;
                        } else {
                            $alert({
                                title: '消息',
                                content: rq.data.msg,
                                placement: 'top',
                                type: 'error',
                                show: true,
                                duration: 3
                            });
                        }
                    });
                });

                $scope.filterUserchecked = function (val) {
                    return val.checked;
                };

                //全选，反选功能
                $scope.isAll = false;
                $scope.temparr = [];
                $scope.selectAll = function () {
                    //判断单选或多选:1为单选，2和其它为多选
                    if ($scope.flowdata.selectedaction.userchosemode == 1 && $scope.isAll) {
                        $scope.isAll = false;
                        $alert({
                            title: '提示',
                            content: '该环节用户为单选模式！',
                            placement: 'top',
                            type: 'warning',
                            show: true,
                            duration: 3
                        });
                    }

                    angular.forEach($scope.flowdata.flowUsers, function (user) {
                        user.checked = $scope.isAll;
                    });
                };
                $scope.selectOne = function (it) {
                    var count = 0;
                    angular.forEach($scope.flowdata.flowUsers, function (user) {
                        //判断单选或多选:1为单选，2和其它为多选
                        if ($scope.flowdata.selectedaction.userchosemode == 1) {
                            count = 1;
                            if (it != user) user.checked = false;
                        } else {
                            if (user.checked) count++;
                        }

                    });

                    if (count == 0) $scope.isAll = false;
                    if (count == $scope.flowdata.flowUsers.length) $scope.isAll = true;
                };
                //全选，反选功能结束

                $scope.tonextstep = function () {

                    var arruser = [];

                    if ($scope.flowdata.comment.length == 0) {
                        if (!($scope.flowdata.flowInfo.flowtp == 0 || $scope.flowdata.selectedaction.flowtp == 2)) {
                            $alert({
                                title: '提示',
                                content: '环节意见不能为空！',
                                placement: 'top',
                                type: 'warning',
                                show: true,
                                duration: 3
                            });

                            return;
                        }
                    }


                    angular.forEach($scope.flowdata.flowUsers, function (u) {
                        if (u.checked) {
                            this.push(u.fuserid);
                        }

                    }, arruser);

                    if (arruser.length == 0 && (!$scope.flowdata.selectedaction.flowtp == 2)) {
                        $alert({
                            title: '提示',
                            content: '请选择下一步处理人！',
                            placement: 'top',
                            type: 'warning',
                            show: true,
                            duration: 3
                        });

                        return;
                    }


                    $http({
                        method: 'GET', url: $scope.fauditInfo.putnexturl,
                        params: {
                            processId: $scope.fauditInfo.pid, ationId: $scope.flowdata.selectedaction.actionid,
                            users: arruser.join(','), comment: $scope.flowdata.comment, workBy: AuthUser.getUser().Id
                        }
                    }).then(function (rq) {
                        $alert({
                            title: '消息',
                            content: rq.data.msg,
                            placement: 'top',
                            type: 'success',
                            show: true,
                            duration: 3
                        });
                        $scope.$hide();
                        if (rq.data.success) {

                            if (angular.isFunction($scope.fauditInfo.onsuccess)) {
                                $scope.fauditInfo.onsuccess();
                            }
                        }

                    });
                };

                $scope.loadflow();
            };

            faModalController.$inject = ['$scope', '$filter', 'AuthUser'];

            var faModal = $modal({
                controller: faModalController, resolve: {
                    load: ['$ocLazyLoad', function ($ocLazyLoad) {
                        $ocLazyLoad.load('../js/template/modal_flowaudit.css');
                        return true;
                    }]
                }, templateUrl: '../js/template/modal_flowaudit.html', show: false
            });

            faudit.showaudit = function (option) {
                angular.extend(faudit, option);
                faModal.$promise.then(faModal.show);
            };

            return faudit;
        };

    }).directive('pagination', function () {

        return {
            restrict: 'EA',
            //作用域
            scope: {
                pageindex: '=',  //等号是双向绑定 选中页面
                pagesize: '=',//最大页面
                ptotal: '=',  //数据长度
                mergetotal: '=?' //合并行后显示的总数
            },
            //html
            templateUrl: '../js/template/pagination.html',
            //替换
            replace: true,
            //link函数
            link: function ($scope) {

                $scope.initpage = function () {
                    //分页总数
                    $scope.pages = Math.ceil($scope.ptotal / $scope.pagesize); //分页数
                    $scope.newPages = $scope.pages > 5 ? 5 : $scope.pages;
                    $scope.pageList = [];
                    //$scope.pageindex = 1;

                    //分页要repeat的数组
                    for (var i = 0; i < $scope.newPages; i++) {
                        $scope.pageList.push(i + 1);
                    }
                };
                //监测total数据数量的变化
                $scope.$watch("ptotal", function (newVal, oldVal) {
                    $scope.initpage();
                    if ($scope.pageindex > $scope.pages) {
                        $scope.selectPage($scope.pages);
                    }
                });

                //打印当前选中页索引
                $scope.selectPage = function (page) {

                    //不能小于1大于最大
                    if (page < 1 || page > $scope.pages) return;
                    //最多显示分页数5
                    if (page > 2) {
                        //因为只显示5个页数，大于2页开始分页转换
                        var newpageList = [];
                        for (var i = (page - 3); i < ((page + 2) > $scope.pages ? $scope.pages : (page + 2)); i++) {
                            newpageList.push(i + 1);
                        }
                        $scope.pageList = newpageList;
                    }
                    if (page >= 1 && page <= 2) {
                        var newpageList = [];
                        for (var i = 1; i <= ($scope.pages > 5 ? 5 : $scope.pages); i++) {
                            newpageList.push(i);
                        }
                        $scope.pageList = newpageList;
                    }

                    $scope.pageindex = page;
                    //$scope.isActivePage();
                    //console.log("选择的页：" + page);
                };

                //设置当前选中页样式
                $scope.isActivePage = function (page) {

                    return $scope.pageindex == page;
                };
                //第一页
                $scope.PreviousFirst = function () {
                    if ($scope.pageindex == 1) {
                        return false;
                    } else {
                        $scope.selectPage(1);
                    }
                };
                //上一页
                $scope.Previous = function () {
                    $scope.selectPage($scope.pageindex - 1);
                };
                //下一页
                $scope.Next = function () {
                    $scope.selectPage($scope.pageindex + 1);
                };
                //最后一页
                $scope.NextLast = function () {
                    $scope.selectPage($scope.pages);
                };
                //跳转
                $scope.skipPage = function (skipPageNumber) {

                    var reg = /^[0-9]+$/;
                    var r = reg.test(skipPageNumber);
                    if (!isNaN(skipPageNumber) && r) {
                        if (skipPageNumber <= $scope.pages) {
                            $scope.skipError = true;
                            $scope.selectPage(skipPageNumber);
                        } else {
                            $scope.skipError = false;
                            alert("填入页数不能大于" + $scope.pages);
                        }
                    } else {
                        $scope.skipError = true;
                        alert("输入非法，请输入正确的页数");
                    }

                }

            }
        }
    }).directive('titlemenu', function ($state, $http, $bsRouterState) {

        return {
            restrict: 'EA',
            //作用域
            scope: {
                parentno: '=' //父级no
            },
            //html
            templateUrl: '../js/template/title-menu.html',
            //替换
            replace: true,
            transclude: true,
            //link函数
            link: function (scope, element, attrs, controllers) {

                var inTab = $bsRouterState.$getRouteType() == 'tab';

                var menuno = inTab ? scope.$parent.name : $state.current.name;

                $http.post('../../api/menumanage/FindMenus', {
                    menuno: menuno,
                    parentNo: scope.parentno == undefined ? "" : scope.parentno
                }).then(function (rq) {
                    scope.items = [];
                    for (var i = rq.data.item.length - 1; i >= 0; i--) {
                        scope.items.push(rq.data.item[i]);
                    }
                });
                scope.back = function () {
                    if (!inTab) {
                        history.go(-1);
                    }

                };
                scope.goto = function (menuno) {
                    if (!inTab) {
                        if (menuno.indexOf("home") > -1 || menuno.indexOf("homeE") > -1)
                            $state.go(menuno);
                    }
                }
            }
        }
    }).directive("bsflowstep", function ($http) {
        return {
            restrict: 'EA',
            //作用域
            scope: {
                fid: '='//数据长度
            },
            //html
            templateUrl: '../js/template/t_flowstep.html',
            //替换
            replace: true,
            //link函数
            link: function (scope, element, attr, controller) {

                if (angular.isDefined(scope.fid)) {

                    var url = attr['url'] || '../../api/flow/getflowsteps';

                    $http({url: url, method: 'GET', params: {flowId: scope.fid}}).then(function (rq) {
                        if (rq.data.success) {
                            scope.items = rq.data.item;
                        }
                    });
                }
            }
        }
    }).directive('userselect', function ($http, $modal, $alert, AuthUser) {
        var directiveObject = {
            restrict: 'EAC',
            scope: {
                textids: '=',//已选择的人员ID
                textnames: '=',//已选择的人员
                textguids: '=',//已选择的人员guid
                datausers: '=',//已选人员对象
            },
            link: function (scope, element, attr, controller) {
                //判断绑定的变量是否已定义
                if (angular.isDefined(attr['textids']) && angular.isDefined(attr['textnames'])) {
                    var usModalController = function ($scope) {
                        //将参数传递的方式改成form
                        $scope.postCfg = {
                            headers: {'Content-Type': 'application/x-www-form-urlencoded'},
                            transformRequest: function (data) {
                                return $.param(data);
                            }
                        };
                        $scope.title = '人员选择';
                        $scope.rootDPID = "";

                        $scope.selectdzzdm = AuthUser.getUser().gddwdm;//当前选中的组织机构
                        $scope.$watch("selectdzzdm", function (newVal, oldVal) {
                            $scope.clickDep();
                        });
                        //人员列表
                        $scope.userSelectList = [];
                        //部门列表
                        $scope.depList = [];
                        //选择模式，默认多选；单选/多选
                        $scope.selecttype = attr['selecttype'] == "single" ? attr['selecttype'] : "multi";

                        //如果datausers没有定义，赋值个空数组
                        if (angular.isUndefined(scope.datausers)) {
                            scope.datausers = [];
                        }
                        //待添加人员列表
                        $scope.tempAdd = [];
                        //拷贝对象，单次赋值给右边已选列表
                        $scope.rightusers = angular.copy(scope.datausers);

                        //确定选择按钮，统计所选择的人员，按照"xxxx,xxxx,xxxx"模板拼接
                        $scope.selectedData = function () {
                            var isFirst = true;
                            scope.textnames = "";
                            scope.textguids = "";
                            scope.textids = "";
                            angular.forEach($scope.rightusers, function (item) {
                                if (isFirst) {
                                    scope.textnames = item.name;
                                    scope.textids = item.dguserid;
                                    scope.textguids = item.id;
                                    isFirst = false;
                                } else {
                                    scope.textnames += ',' + item.name;
                                    scope.textids += ',' + item.dguserid;
                                    scope.textguids += ',' + item.id;
                                }
                            });
                            scope.datausers = $scope.rightusers;
                            $scope.$hide();
                        };
                        //添加已选择的人员
                        $scope.addUser = function () {
                            var isSingle = $scope.selecttype == "single";//判断是否为单选模式
                            var isFlag = $scope.tempAdd.length <= 1 && $scope.rightusers.length == 0;//判断已选人数是否小于等于1
                            if ((isSingle && isFlag) || !isSingle) {
                                angular.forEach($scope.tempAdd, function (item) {
                                    //准备添加的人员是否在右边列表存在,如果存在，为false,不添加到右侧
                                    var isAdd = true;
                                    angular.forEach($scope.rightusers, function (user) {
                                        if (item.id == user.id) {
                                            isAdd = false;
                                        }
                                    });
                                    if (isAdd) {
                                        $scope.rightusers.push(item);
                                    }
                                })
                            } else {
                                $alert({
                                    title: '错误：',
                                    content: '只可选择一名人员！',
                                    placement: 'center',
                                    type: 'info',
                                    container: '#userselect1',
                                    show: true,
                                    duration: 3
                                });
                            }
                        };

                        //删除已选择的人员
                        $scope.deleteUser = function () {
                            angular.forEach($scope.tempSelected, function (item) {
                                var index = $scope.rightusers.indexOf(item);
                                $scope.rightusers.splice(index, 1);
                            })
                        };

                        //人员查询
                        $scope.searchUser = function () {
                            if (angular.isDefined($scope.searchParam) && $scope.searchParam != "" && $scope.searchParam != null) {
                                $scope.loadUser();
                            } else {
                                $alert({
                                    title: '消息：',
                                    content: '请输入要查询的人员名',
                                    placement: 'center',
                                    type: 'info',
                                    container: '#userselect1',
                                    show: true,
                                    duration: 3
                                });
                                return false;
                            }
                        };

                        //点击部门,通过部门ID获取人员列表
                        $scope.clickDep = function () {
                            $scope.searchParam = "";//查询条件清空
                            $scope.loadUser();
                        };

                        $scope.loadUser = function () {
                            $scope.isloading = true;
                            $scope.userSelectList = [];
                            $http.get("../../api/user/GetUserListByDpID", {
                                params: {
                                    'userName': $scope.searchParam,
                                    'dpId': $scope.selectdzzdm
                                }
                            }).then(function (result) {
                                $scope.userSelectList = result.data.item;//返回的人员列表赋值给变量userSelectList
                                $scope.isloading = false;
                            }, function () {
                                $alert({
                                    title: '错误：',
                                    content: '查询人员列表失败，服务器错误',
                                    placement: 'center',
                                    type: 'info',
                                    container: '#userselect1',
                                    show: true,
                                    duration: 3
                                });
                            });
                        };
                    };

                    usModalController.$inject = ['$scope'];
                    var usModal = $modal({
                        scope: scope,
                        controller: usModalController,
                        resolve: {
                            load: ['$ocLazyLoad', function ($ocLazyLoad) {
                                $ocLazyLoad.load('../js/template/modal_userselect.css');
                                return true;
                            }]
                        },
                        templateUrl: '../js/template/modal_userselect.html',
                        show: false,
                        animation: 'am-fade-and-slide-top'
                    });
                    //data-isNotRelated:是否关联用一个父元素的input标签(点击input标签时也可以触发该控件)，默认为false  可选值:true/fasle(不关联)
                    if (attr['isNotRelated']) {
                        element.on("click", function () {
                            usModal.$promise.then(usModal.show);
                        });
                        element.css({cursor: 'pointer'});
                    } else {
                        element.parent().on("click", function () {
                            usModal.$promise.then(usModal.show);
                        });
                        element.css({cursor: 'pointer'});
                        element.parent().children("input").css({cursor: 'pointer', "background-color": "#FFFFFF"});
                    }
                }
            }
        };

        return directiveObject;
    }).directive('dpselect', function ($http, $modal, $alert) {
        var directiveObject = {
            restrict: 'EAC',
            scope: {
                dpid: '=',//已选择的部门ID
                dpname: '=',//已选择的部门名称
                dpitem: '=',//已选择的部门对象
            },
            link: function (scope, element, attr, controller) {
                //判断绑定的变量是否已定义
                if (angular.isDefined(attr['dpid']) && angular.isDefined(attr['dpname'])) {
                    var dpModalController = function ($scope) {
                        //将参数传递的方式改成form
                        $scope.postCfg = {
                            headers: {'Content-Type': 'application/x-www-form-urlencoded'},
                            transformRequest: function (data) {
                                return $.param(data);
                            }
                        };
                        $scope.title = '部门选择';
                        $scope.rootDPID = "";
                        //当前展开的部门
                        $scope.curdepid = "";

                        //部门列表
                        $scope.depList = [];
                        $scope.dpitem = {
                            selectDp: ""
                        };
                        $scope.dpresultlist = [];


                        //如果datausers没有定义，赋值个空数组
                        if (angular.isUndefined(scope.dpitem)) {
                            scope.dpitem = null;
                        }


                        //初始化树列表，获取根节点
                        $scope.initTree = function () {
                            $http.post("../../api/dsUser/GetDPbyParentDPID", {'DPID': $scope.rootDPID}, $scope.postCfg).then(function (result) {
                                $scope.depList = result.data;
                            }, function () {
                                $alert({
                                    title: '错误：',
                                    content: '获取根节点失败，服务器错误',
                                    placement: 'center',
                                    type: 'info',
                                    container: '#userselect1',
                                    show: true,
                                    duration: 3
                                });
                            });
                        };

                        //加载子部门节点
                        $scope.loadChildDep = function (item) {
                            $scope.searchParam = "";//查询条件清空
                            if (!item.isExpand)//如果该节点未展开
                            {
                                item.isExpand = true;
                                $scope.getDPByParentID(item);
                            } else {
                                item.isExpand = false;
                            }


                        };


                        //根据父部门获取子部门列表
                        $scope.getDPByParentID = function (item) {
                            $http.post("../../api/user/GetDpListByParentID", {'parentDPID': item.dpid}).then(function (result) {
                                item.childDepList = result.data.item;
                            }, function () {
                                $alert({
                                    title: '错误：',
                                    content: '查询子部门列表失败，服务器错误',
                                    placement: 'center',
                                    type: 'info',
                                    container: '#userselect1',
                                    show: true,
                                    duration: 3
                                });
                            });
                        };

                        $scope.initTree();

                        //点击部门
                        $scope.clickDep = function (item, $event) {
                            if ($scope.curdepid != item.DPID) {
                                $scope.searchParam = "";//查询条件清空
                                $scope.dpresultlist = [];
                                $scope.dpresultlist.push(item);
                                $scope.curdepid = item.DPID;
                                $scope.selectDP = item;


                            }
                        };

                        //点击选择部门
                        $scope.selectedDp = function () {
                            if ($scope.selectDP != null) {
                                scope.dpid = $scope.selectDP.DPID;
                                scope.dpname = $scope.selectDP.DPName;
                                scope.dpitem = $scope.selectDP;
                                dpModal.$promise.then(dpModal.hide);
                            }
                        };

                        //根据输入字段查询部门
                        $scope.searchDP = function () {
                            if (angular.isDefined($scope.searchParam) && $scope.searchParam != "" && $scope.searchParam != null) {//查询条件不为空时进行查询
                                $scope.isloading = true;
                                $scope.dpresultlist = [];
                                $http.get("../../api/SysManage/findTargetDPlists", {params: {'searchParam': $scope.searchParam}}).then(function (result) {
                                    $scope.dpresultlist = result.data.list;
                                    $scope.isloading = false;
                                }, function () {
                                    $alert({
                                        title: '错误：',
                                        content: '查询部门失败，服务器错误',
                                        placement: 'center',
                                        type: 'info',
                                        show: true,
                                        duration: 3
                                    });
                                });
                            }
                        };
                    };


                    dpModalController.$inject = ['$scope'];
                    var dpModal = $modal({
                        scope: scope,
                        controller: dpModalController,
                        resolve: {
                            load: ['$ocLazyLoad', function ($ocLazyLoad) {
                                $ocLazyLoad.load('../js/template/modal_userselect.css');
                                return true;
                            }]
                        },
                        templateUrl: '../js/template/modal_dpselect.html',
                        show: false,
                        animation: 'am-fade-and-slide-top'
                    });
                    //data-isNotRelated:是否关联用一个父元素的input标签(点击input标签时也可以触发该控件)，默认为false  可选值:true/fasle(不关联)
                    if (attr['isNotRelated']) {
                        element.on("click", function () {
                            dpModal.$promise.then(dpModal.show);
                        });
                        element.css({cursor: 'pointer'});
                    } else {
                        element.parent().on("click", function () {
                            dpModal.$promise.then(dpModal.show);
                        });
                        element.parent().children("input").css({cursor: 'pointer', "background-color": "#FFFFFF"});
                        element.css({cursor: 'pointer'});
                    }

                }
            }
        };

        return directiveObject;
    }).factory("$excel", function ($modal, $http, $window, $alert, $q) {
        var fileObject = {
            configdata: {
                uploadurl: '../../api/home/importExcel',
                typeparams: false,//为false则可选择所有文件，限制格式:{types:['jpg','bmp','jpe','jpeg'],errormsg:'图片格式必须为*.jpg,*.bmp,*.jpe,*.jpeg等格式'}
            },
            fModal: {},
            addDefer: {}
        };

        fileObject.init = function (config) {
            //fileObject.configdata
            angular.extend(fileObject.configdata, config);
        };

        fileObject.addFile = function (fileoption) {
            fileObject.addDefer = $q.defer();
            //这里才传值到弹出页面
            if (angular.isDefined(fileoption)) {
                fileObject.fileoption = fileoption;
            }
            fileObject.fModal.$promise.then(fileObject.fModal.show);

            return fileObject.addDefer.promise;
        };


        fileObject.uploadMethod = function (file, scope, Upload, AuthUser) {
            fileObject.fileoption.columns.file = file;
            //alert(scope);
            Upload.upload({
                url: fileObject.configdata.uploadurl,
                data: fileObject.fileoption.columns
            }).then(function (resp) {
                if (resp.data.success) {
                    /*$alert({
                        title: '消息',
                        content: resp.data.msg,
                        placement: 'top',
                        type: 'info',
                        show: true,
                        duration: 3
                    });*/
                    //fileObject.loadItems(fileObject.fileoption);
                    fileObject.addDefer.resolve(resp.data.item);
                    scope.$hide();
                } else {
                    fileObject.addDefer.reject(false);
                    $alert({
                        title: '消息',
                        content: resp.data.msg,
                        placement: 'top',
                        type: 'info',
                        show: true,
                        duration: 3
                    });
                    scope.$hide();
                }
                //console.log('Success ' + resp.config.data.file.name + 'uploaded. Response: ' + resp.data);
            }, function (resp) {
                fileObject.addDefer.reject(false);
                $alert({title: '错误', content: "上传服务器错误！", placement: 'center', type: 'info', show: true, duration: 3});
                console.log('Error status: ' + resp.status);
                scope.$hide();
            }, function (evt) {
                scope.updata.progressPer = parseInt(100.0 * evt.loaded / evt.total);
                //console.log('progress: ' + progressPercentage + '% ' + evt.config.data.file.name);
            });

        };
        fileObject.initupload = function (upload) {
            //fileObject.configdata
            angular.extend(fileObject, upload);
        };
        fileObject.fileModalController = function ($scope, Upload, AuthUser) {

            $scope.filetype = fileObject.fileoption.filetype;
            $scope.updata = {isuping: false, progressPer: 0};
            $scope.SettingID = "";
            $scope.templateUrl = fileObject.fileoption.templateUrl;
            var types = angular.isDefined(fileObject.fileoption.typeparams) ? fileObject.fileoption.typeparams.types : false;
            $scope.acceptType = types ? ('.'+types.join(',.')) : '*';


            $scope.submit = function () {
                if ($scope.fileform.file.$valid && $scope.file && $scope.valiFileType()) {
                    $scope.updata.isuping = true;
                    $scope.upload($scope.file);
                }
                //if ($scope.fileform.file.$error.minHeight) {
                //    $alert({ title: '消息', content: "图片高度小于100px", placement: 'center', type: 'info', show: true, duration: 3, container: '#fileaddmodal' });
                //}
                if ($scope.fileform.file.$error.maxSize) {
                    $alert({
                        title: '消息',
                        content: "文件不得大于20MB",
                        placement: 'center',
                        type: 'info',
                        show: true,
                        duration: 3,
                        container: '#fileaddmodal'
                    });
                }
            };

            //验证文件格式，返回布尔类型
            $scope.valiFileType = function () {
                //验证结果标识
                var isFlag = false;
                //如果没定义
                var types = angular.isDefined(fileObject.fileoption.typeparams) ? fileObject.fileoption.typeparams.types : false;
                if ($scope.file != null) {
                    var filename = $scope.file.name;
                    var loc = filename.lastIndexOf('.');
                    var filetype = filename.substring(loc + 1, filename.length).toLowerCase();
                    //如果限制了上传文件格式，则进入判断
                    if (types) {
                        angular.forEach(types, function (item) {
                            if (item == filetype) {
                                isFlag = true;
                            }
                        })
                    } else {
                        isFlag = true;
                    }
                }
                //若文件格式非法，并且文件不为空，则弹出错误信息，并且清空文件
                if (!isFlag && $scope.file != null) {
                    $scope.file = "";
                    $alert({
                        title: '消息',
                        content: fileObject.fileoption.typeparams.errormsg,
                        placement: 'top',
                        type: 'info',
                        show: true,
                        duration: 3,
                        container: '#fileaddmodal'
                    });
                }
                return isFlag;
            };

            $scope.upload = function () {
                fileObject.uploadMethod($scope.file, $scope, Upload, AuthUser);
            }

        };

        fileObject.fileModalController.$inject = ['$scope', 'Upload', 'AuthUser'];

        fileObject.fModal = $modal({
            controller: fileObject.fileModalController,
            templateUrl: '../js/template/modal_fileadd.html', show: false,
            placement: 'center', animation: 'am-fade-and-slide-top'
        });
        fileObject.showErrorInfo = function (errorList) {
            fileObject.errorList = errorList;

            fileObject.eModal.$promise.then(fileObject.eModal.show);
        };
        fileObject.excelModalController = function ($scope) {
            $scope.fdata = {title: '导入失败列表'};
            $scope.fdata.items = fileObject.errorList;
            $scope.fdata.columns = fileObject.fileoption.errorcolumns;

            $scope.excel = function () {
                var text = JSON.stringify(fileObject.errorList);
                var columns = JSON.stringify(fileObject.fileoption.errorcolumns);
                var url = "../../api/home/exportErrorExcel";
                var xhr = new XMLHttpRequest();
                xhr.open('POST', url, true);
                // 返回类型blob
                xhr.responseType = "blob";
                xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded;");
                xhr.onload = function () {
                    if (this.status === 200) {
                        var blob = this.response;
                        var reader = new FileReader();
                        reader.readAsDataURL(blob);
                        reader.onload = function (e) {
                            var a = document.createElement('a');
                            a.download = '导出错误信息.xlsx';
                            a.href = e.target.result;
                            $("body").append(a);
                            a.click();
                            $(a).remove();
                        }
                    }
                };
                // 发送ajax请求
                var content = "text=" + text + "&columns=" + columns;
                xhr.send(content);
            };
        };
        fileObject.excelModalController.$inject = ['$scope'];

        fileObject.eModal = $modal({
            controller: fileObject.excelModalController,
            templateUrl: '../js/template/modal_excelerrorinfo.html', show: false,
            placement: 'center', animation: 'am-fade-and-slide-top'
        });
        //fileObject.fileModalController.$scope.upload();
        return fileObject;
    }).factory("$bsfiles", function ($modal, $http, $window, $alert, $q, $filter) {
        var fileObject = {
            configdata: {
                itemsurl: '../../api/home/findFileList', uploadurl: '../../api/home/postFile',
                delfileurl: '../../api/home/delfile',
                delfileByRefurl: '../../api/home/delfileByRefID',
                downFileUrl: '../../api/home/downloadFile',
                zipdownFileUrl: '../../api/home/zipdownloadFile',
                showImgUrl: '../../api/home/showImg',
                typeparams: false,//为false则可选择所有文件，限制格式:{types:['jpg','bmp','jpe','jpeg'],errormsg:'图片格式必须为*.jpg,*.bmp,*.jpe,*.jpeg等格式'}
            },
            fModal: {},
            addDefer: {}
        };

        var limitTypes = ['jpg', 'png', 'jpeg', 'pdf', 'doc', 'docx', 'xls', 'xlsx', 'ppt', 'pptx', 'txt', 'rar', 'zip', '7z','mp4','avi'];

        fileObject.init = function (config) {
            //fileObject.configdata
            angular.extend(fileObject.configdata, config);
        };

        fileObject.loadItems = function (fileoption) {

            if (!angular.isDefined(fileoption)) {
                return false;
            }

            if (angular.isUndefined(fileoption.selectdata.FileRefID) || fileoption.selectdata.FileRefID.length == 0) {
                return false;
            }

            //if (angular.isDefined(fileoption)) {
            //    fileObject.fileoption = fileoption;
            //}

            var deferred = $q.defer();

            $http({
                url: fileObject.configdata.itemsurl,
                method: 'GET',
                params: fileoption.selectdata
            }).then(function (rq) {
                fileoption.items.splice(0, fileoption.items.length);
                angular.forEach(rq.data.item.list, function (val, key) {
                    this.push(val);
                }, fileoption.items);
                fileoption.selectdata.ptotal = rq.data.item.total;
                deferred.resolve(fileoption.selectdata.ptotal > 0);
            }, function () {
                deferred.resolve(false);
            });

            return deferred.promise;
        };

        fileObject.loadLearningMaterialType = function (scope) {
            if (fileObject.fileoption.selectdata.filetypecode) {
                $http({
                    method: 'get',
                    url: '../../api/dictionary/getDictionaryListByDicTypeKey',
                    params: {
                        dicTypeKey: fileObject.fileoption.selectdata.filetypecode
                    }
                }).then(function (result) {
                    scope.fileTypeList = result.data;

                }, function (resp) {

                });
            }
        };

        fileObject.addFile = function (fileoption) {
            fileObject.addDefer = $q.defer();
            //这里才传值到弹出页面
            if (angular.isDefined(fileoption)) {
                fileObject.fileoption = fileoption;
            }
            fileObject.fModal.$promise.then(fileObject.fModal.show);

            return fileObject.addDefer.promise;
        };


        fileObject.delfile = function (fileid, fileoption) {
            if ($window.confirm("是否删除？")) {
                var deferred = $q.defer();
                $http({
                    url: fileObject.configdata.delfileurl,
                    method: 'GET',
                    params: {fileId: fileid}
                }).then(function (rq) {
                    if (rq.data.success) {
                        fileObject.loadItems(fileoption).then(function (isupload) {
                            deferred.resolve(isupload);
                        });
                    }
                    $alert({
                        title: '消息',
                        content: rq.data.msg,
                        placement: 'top',
                        type: 'info',
                        show: true,
                        duration: 3
                    });
                });

                return deferred.promise;
            }
        };

        fileObject.delfileByRefID = function (fileid, filerefid, fileoption) {
            $http({
                url: fileObject.configdata.delfileByRefurl,
                method: 'GET',
                params: {fileId: fileid, fileRefId: filerefid}
            }).then(function (rq) {
                if (rq.data.success) {
                    fileObject.loadItems(fileoption);
                }
            });
        };
        fileObject.uploadMethod = function (file, scope, Upload, AuthUser, filetype) {
            Upload.upload({
                url: fileObject.configdata.uploadurl,
                data: {file: file, 'fileRefID': scope.refid, uid: AuthUser.getUser().Id, filetype: filetype}
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
                    fileObject.addDefer.resolve(resp.data.item);
                    scope.$hide();
                } else {
                    fileObject.addDefer.reject(false);
                    $alert({
                        title: '消息',
                        content: resp.data.msg,
                        placement: 'top',
                        type: 'info',
                        show: true,
                        duration: 3
                    });
                    fileObject.loadItems(fileObject.fileoption);
                    scope.$hide();
                }
                //console.log('Success ' + resp.config.data.file.name + 'uploaded. Response: ' + resp.data);
            }, function (resp) {
                fileObject.addDefer.reject(false);
                $alert({title: '错误', content: "上传服务器错误！", placement: 'center', type: 'info', show: true, duration: 3});
                console.log('Error status: ' + resp.status);
                scope.$hide();
            }, function (evt) {
                scope.updata.progressPer = parseInt(100.0 * evt.loaded / evt.total);
                //console.log('progress: ' + progressPercentage + '% ' + evt.config.data.file.name);
            });

        };
        fileObject.initupload = function (upload) {
            //fileObject.configdata
            angular.extend(fileObject, upload);
        };
        fileObject.fileModalController = function ($scope, Upload, AuthUser) {

            $scope.refid = fileObject.fileoption.selectdata.FileRefID;
            $scope.filetype = fileObject.fileoption.filetype;
            $scope.updata = {isuping: false, progressPer: 0};
            $scope.SettingID = "";
            $scope.fileTypeList = [];

            if (angular.isDefined(fileObject.fileoption.selectdata.SettingID)) {
                //$scope.SettingID = fileObject.fileoption.selectdata.FileRefID.SettingID;
                $scope.SettingID = fileObject.fileoption.selectdata.SettingID;
            }


            $scope.submit = function () {
                if ($scope.fileform.file.$valid && $scope.file && $scope.valiFileType()) {
                    $scope.updata.isuping = true;
                    $scope.upload($scope.file);
                }
                //if ($scope.fileform.file.$error.minHeight) {
                //    $alert({ title: '消息', content: "图片高度小于100px", placement: 'center', type: 'info', show: true, duration: 3, container: '#fileaddmodal' });
                //}
                if ($scope.fileform.file.$error.maxSize) {
                    $alert({
                        title: '消息',
                        content: "文件不得大于20MB",
                        placement: 'center',
                        type: 'info',
                        show: true,
                        duration: 3,
                        container: '#fileaddmodal'
                    });
                }
            };

            //验证文件格式，返回布尔类型
            $scope.valiFileType = function () {
                //验证结果标识
                var isFlag = false;
                //如果没定义
                var types = angular.isDefined(fileObject.fileoption.typeparams) ? fileObject.fileoption.typeparams.types : false;
                if ($scope.file != null) {
                    var filename = $scope.file.name;
                    var loc = filename.lastIndexOf('.');
                    var filetype = filename.substring(loc + 1, filename.length).toLowerCase();
                    //如果限制了上传文件格式，则进入判断
                    if (types) {
                        angular.forEach(types, function (item) {
                            if (item == filetype) {
                                isFlag = true;
                            }
                        })
                    } else {
                        var existType = $filter('filter')(limitTypes, filetype);
                        isFlag = existType.length > 0;
                        fileObject.fileoption.typeparams = {errormsg: '不支持上传类型'};
                    }
                }
                //若文件格式非法，并且文件不为空，则弹出错误信息，并且清空文件
                if (!isFlag && $scope.file != null) {
                    $scope.file = "";
                    $alert({
                        title: '消息',
                        content: fileObject.fileoption.typeparams.errormsg,
                        placement: 'top',
                        type: 'info',
                        show: true,
                        duration: 3,
                        container: '#fileaddmodal'
                    });
                }
                return isFlag;
            };

            $scope.upload = function () {
                if ($scope.fileform.filetype) {
                    $scope.filetype = $scope.fileform.filetype.$modelValue;
                }
                fileObject.uploadMethod($scope.file, $scope, Upload, AuthUser, $scope.filetype);
            }

            fileObject.loadLearningMaterialType($scope);

        };

        fileObject.fileModalController.$inject = ['$scope', 'Upload', 'AuthUser'];

        fileObject.fModal = $modal({
            controller: fileObject.fileModalController,
            templateUrl: '../js/template/modal_fileadd.html', show: false,
            placement: 'center', animation: 'am-fade-and-slide-top'
        });
        //fileObject.fileModalController.$scope.upload();
        return fileObject;
    }).directive('bsfiles', function ($bsfiles, $window) {
        var directiveObject = {
            restrict: 'EA',
            template: '<ng-include src="ngModel.templateUrl"/>',
            replace: true,
            require: 'ngModel',
            scope: {ngModel: '=', isupload: '=?'},
            link: function (scope, element, attr, ngmodel) {
                scope.styleConfig = {
                    mainStyle: {"padding-top": "10px"},
                    mainClass: "list-table-panel",
                    titleClass: "list-table-title"
                };
                //添加自定义模板参数
                if (angular.isUndefined(scope.ngModel.templateUrl)) {
                    scope.ngModel.templateUrl = '../js/template/filelist.html';
                }

                if (angular.isUndefined(scope.ngModel.downFun)) {
                    scope.ngModel.downFun = function (id) {
                        $window.open($bsfiles.configdata.downFileUrl + "/" + id);
                    }
                    scope.ngModel.zipdownFun = function (id) {
                        $window.open($bsfiles.configdata.zipdownFileUrl + "/" + id + "/" + scope.ngModel.title);
                    }
                }

                //读取自定义样式配置
                if (scope.ngModel.styles) {
                    if (scope.ngModel.styles.padding != null) {
                        scope.styleConfig.mainStyle = {
                            "padding-top": scope.ngModel.styles.padding.toString() + "px"
                        }
                    }
                    if (scope.ngModel.styles.customerClass) {
                        if (scope.ngModel.styles.customerClass.mainClass) {
                            scope.styleConfig.mainClass = scope.ngModel.styles.customerClass.mainClass;
                        }
                        if (scope.ngModel.styles.customerClass.titleClass) {
                            scope.styleConfig.titleClass = scope.ngModel.styles.customerClass.titleClass;
                        }
                    }
                }

                scope.$watch('ngModel.selectdata.FileRefID', function (newval, oldval) {
                    if(newval){
                        $bsfiles.loadItems(scope.ngModel).then(function (isupload) {
                            scope.isupload = isupload;
                        });
                    }
                });

                //监视页数变化
                scope.$watch("ngModel.selectdata.pageindex", function (newVal, oldVal) {
                    if (scope.ngModel.selectdata.ptotal > 0) {
                        $bsfiles.loadItems(scope.ngModel).then(function (isupload) {
                            scope.isupload = isupload;
                        });
                    }
                });

                scope.downfile = function (id) {
                    //console.log($bsfiles.configdata.downFileUrl);
                    //console.log($bsfiles.configdata.downFileUrl)
                    scope.ngModel.downFun(id);
                };
                scope.zipdown = function () {
                    scope.ngModel.zipdownFun(scope.ngModel.selectdata.FileRefID);
                }

                scope.addFile = function () {
                    //判断是否有同步方法
                    if (angular.isFunction(scope.ngModel.canupfile)) {
                        scope.ngModel.canupfile($bsfiles.addFile);
                    } else if (angular.isFunction(scope.ngModel.canupfileAsync)) {
                        scope.ngModel.canupfileAsync().then(function (id) {
                            scope.ngModel.selectdata.FileRefID = id;
                            $bsfiles.addFile(scope.ngModel).then(function (fid) {
                                $bsfiles.loadItems(scope.ngModel).then(function (isupload) {
                                    scope.isupload = isupload;
                                });
                            });
                        });
                    } else {
                        $bsfiles.addFile(scope.ngModel).then(function (fid) {
                            $bsfiles.loadItems(scope.ngModel).then(function (isupload) {
                                scope.isupload = isupload;
                            });
                        });
                    }

                };

                scope.delfile = function (fid) {
                    $bsfiles.delfile(fid, scope.ngModel).then(function (isupload) {
                        scope.isupload = isupload;
                    });
                };


            }
        };
        return directiveObject;
    }).directive('singlefile', function ($state, $http, $bsfiles, $window) {

        return {
            restrict: 'EA',
            require: '?ngModel',
            //作用域
            scope: {
                id: '=', //父级no
                typeparams: '=?',
                readonly: '=?',
                fileid: '='
            },
            //html
            templateUrl: '../js/template/single-file.html',
            //替换
            replace: true,
            transclude: true,
            //link函数
            link: function (scope, element, attrs, controllers) {

                scope.ngModel = {
                    selectdata: {FileRefID: scope.id, pageindex: 1, pagesize: 10, ptotal: 0},//查询参数：FileRefID为文件关联ID
                    filetype: 3,//文件类型
                    items: [],//列表数据地址
                    readonly: scope.readonly,//是否只能查看
                    addFileButton: '上传'
                };
                if (scope.typeparams != undefined) {
                    scope.ngModel.typeparams = scope.typeparams;
                }
                $bsfiles.loadItems(scope.ngModel);
                scope.item = {};
                scope.upload = function () {
                    scope.ngModel.selectdata.FileRefID = scope.id;
                    $bsfiles.addFile(scope.ngModel).then(function (fid) {
                        scope.fileid = fid;
                        $bsfiles.delfileByRefID(fid, scope.id, scope.ngModel);
                        $bsfiles.loadItems(scope.ngModel);
                    });
                }
                scope.downFun = function (id) {
                    $window.open($bsfiles.configdata.downFileUrl + "/" + id);
                }
                scope.delfile = function (id) {
                    $bsfiles.delfile(id, scope.ngModel);
                }
            }
        }
    }).directive('upfile', function ($bsfiles, $window, $alert, Upload, AuthUser, $http, $modal) {
        var upfileObject = {
            restrict: 'EA',
            templateUrl: '../js/template/upfile.html',
            replace: true,
            require: 'ngModel',
            scope: {ngModel: '='},
            link: function (scope, element, attr, ngmodel) {
                var fileObject = {
                    configdata: {
                        itemsurl: '../../api/ICTFileUpLoad/FindFile', uploadurl: '../../api/ICTFileUpLoad/PostFile',
                        delfileurl: '../../api/FileUpload/delfile',
                        typeparams: false,//为false则可选择所有文件，限制格式:{types:['jpg','bmp','jpe','jpeg'],errormsg:'图片格式必须为*.jpg,*.bmp,*.jpe,*.jpeg等格式'}
                    },
                    fileoption: scope.ngModel
                };
                scope.$watch('scope.ngModel.selectdata.FileRefID', function (newval, oldval) {

                    scope.loadItem(scope.ngModel);

                });
                scope.title = scope.ngModel.title;
                scope.refid = fileObject.fileoption.selectdata.FileRefID;
                scope.filetype = fileObject.fileoption.filetype;
                //文件步骤
                scope.FlowStep = fileObject.fileoption.selectdata.FlowStep;
                //文件的配置ID
                scope.SettingID = fileObject.fileoption.selectdata.SettingID;

                //验证文件格式，返回布尔类型
                //scope.valiFileType = function () {
                //    //验证结果标识
                //    var isFlag = false;
                //    //如果没定义
                //    var types = angular.isDefined(fileObject.fileoption.typeparams) ? fileObject.fileoption.typeparams.types : false;
                //    if (scope.upfile != null) {
                //        var filename = scope.upfile.name;
                //        var loc = filename.lastIndexOf('.');
                //        var filetype = filename.substring(loc + 1, filename.length).toLowerCase();
                //        //如果限制了上传文件格式，则进入判断
                //        if (types&&types.length>0) {
                //            angular.forEach(types, function (item) {
                //                if (item == filetype) {
                //                    isFlag = true;
                //                }
                //            })
                //        } else {
                //            isFlag = true;
                //        }
                //    }
                //    //若文件格式非法，并且文件不为空，则弹出错误信息，并且清空文件
                //    if (!isFlag && scope.upfile != null) {
                //        scope.upfile = "";
                //        $alert({ title: '消息', content: fileObject.fileoption.typeparams.errormsg, placement: 'top', type: 'info', show: true, duration: 3});
                //    }
                //    return isFlag;
                //}
                //加载文件
                scope.loadItem = function (fileoption) {

                    if (!angular.isDefined(fileoption)) {
                        return false;
                    }

                    if (!angular.isDefined(fileoption.selectdata.FileRefID)) {
                        return false;
                    }

                    fileoption.items.splice(0, fileoption.items.length);
                    $http({
                        url: fileObject.configdata.itemsurl,
                        method: 'GET',
                        params: {
                            FileRefID: fileoption.selectdata.FileRefID,
                            SettingID: fileoption.selectdata.SettingID,
                            uid: fileObject.fileoption.selectdata.userID
                        }
                    }).then(function (rq) {

                        if (rq.data.total > 0) {
                            $("#" + fileoption.selectdata.SettingID).val(rq.data.items.FileName);
                            fileObject.fileoption.isUpload = true;
                        }
                        fileoption.selectdata.ptotal = rq.data.total;
                    });
                };
                //上传文件
                //scope.upfilemethod = function (file) {
                //    //判断是否有同步方法
                //    if (angular.isFunction(scope.ngModel.canupfileAsync)) {
                //        scope.ngModel.canupfileAsync().then(function (id) {
                //            scope.ngModel.selectdata.FileRefID = id;
                //            Upload.upload({
                //                url: fileObject.configdata.uploadurl,
                //                data: { file: file, 'FileRefID': scope.ngModel.selectdata.FileRefID, uid: AuthUser.getUser().DGUserID, filetype: scope.filetype, SettingID: scope.SettingID }
                //            }).then(function (resp) {
                //                if (resp.data.success) {
                //                    $alert({ title: '消息', content: resp.data.msg, placement: 'top', type: 'info', show: true, duration: 3 });
                //                    fileObject.fileoption.isUpload = true;
                //                    fileObject.fileoption.updateFlag = !fileObject.fileoption.updateFlag;
                //                    fileObject.loadItems(fileObject.fileoption);


                //                } else {
                //                    $alert({ title: '消息', content: resp.data.msg, placement: 'top', type: 'info', show: true, duration: 3 });

                //                }
                //                //console.log('Success ' + resp.config.data.file.name + 'uploaded. Response: ' + resp.data);
                //            }, function (resp) {
                //                $alert({ title: '错误', content: "上传服务器错误！", placement: 'center', type: 'info', show: true, duration: 3 });
                //                console.log('Error status: ' + resp.status);

                //            });
                //        }, function () {
                //            $alert({ title: '消息', content: "请填写完成表格后再上传", placement: 'top', type: 'info', show: true, duration: 3 });
                //        });
                //    } else {
                //        $alert({ title: '消息', content: "无法上传", placement: 'top', type: 'info', show: true, duration: 3 });
                //    }
                //};
                //文件上传方法
                scope.uploadMethod = function (file, scopes, Upload, AuthUser) {
                    Upload.upload({
                        url: fileObject.configdata.uploadurl,
                        data: {
                            file: file,
                            'FileRefID': fileObject.fileoption.selectdata.FileRefID,
                            uid: AuthUser.getUser().DGUserID,
                            filetype: fileObject.fileoption.filetype,
                            SettingID: fileObject.fileoption.selectdata.SettingID
                        }
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
                            fileObject.fileoption.isUpload = true;
                            fileObject.fileoption.updateFlag = !fileObject.fileoption.updateFlag;
                            scope.loadItem(fileObject.fileoption);
                            scopes.$parent.$hide();

                        } else {
                            $alert({
                                title: '消息',
                                content: resp.data.msg,
                                placement: 'top',
                                type: 'info',
                                show: true,
                                duration: 3
                            });
                            scopes.$parent.$hide();
                        }
                    }, function (resp) {
                        $alert({
                            title: '错误',
                            content: "上传服务器错误！",
                            placement: 'center',
                            type: 'info',
                            show: true,
                            duration: 3
                        });
                        console.log('Error status: ' + resp.status);
                        scopes.$parent.$hide();
                    }, function (evt) {
                        scopes.updata.progressPer = parseInt(100.0 * evt.loaded / evt.total);
                    });

                };
                //$bsfiles.initupload(scope.upload);
                scope.addFile = function () {
                    //判断是否有同步方法
                    if (angular.isFunction(scope.ngModel.canupfileAsync)) {
                        scope.ngModel.canupfileAsync().then(function (id) {
                            scope.ngModel.selectdata.FileRefID = id;
                            scope.fModal.$promise.then(scope.fModal.show);
                        });
                    } else {
                        scope.fModal.$promise.then(scope.fModal.show);
                    }
                };
                //模态框
                scope.fileModalController = function ($scope, Upload, AuthUser) {

                    $scope.refid = fileObject.fileoption.selectdata.FileRefID;
                    $scope.filetype = fileObject.fileoption.filetype;
                    $scope.updata = {isuping: false, progressPer: 0};
                    $scope.SettingID = "";
                    if (angular.isDefined(fileObject.fileoption.selectdata.FileRefID.SettingID)) {
                        $scope.SettingID = fileObject.fileoption.selectdata.FileRefID.SettingID;
                    }


                    $scope.submit = function () {
                        if ($scope.fileform.file.$valid && $scope.file && $scope.valiFileType()) {
                            $scope.updata.isuping = true;
                            $scope.upload($scope.file);
                        }
                        if ($scope.fileform.file.$error.minHeight) {
                            $alert({
                                title: '消息',
                                content: "图片高度小于100px",
                                placement: 'center',
                                type: 'info',
                                show: true,
                                duration: 3,
                                container: '#fileaddmodal'
                            });
                        }
                        if ($scope.fileform.file.$error.maxSize) {
                            $alert({
                                title: '消息',
                                content: "文件不得大于20MB",
                                placement: 'center',
                                type: 'info',
                                show: true,
                                duration: 3,
                                container: '#fileaddmodal'
                            });
                        }
                    };

                    //验证文件格式，返回布尔类型
                    $scope.valiFileType = function () {
                        //验证结果标识
                        var isFlag = false;
                        //如果没定义
                        var types = angular.isDefined(fileObject.fileoption.typeparams) ? fileObject.fileoption.typeparams.types : false;
                        if ($scope.file != null) {
                            var filename = $scope.file.name;
                            var loc = filename.lastIndexOf('.');
                            var filetype = filename.substring(loc + 1, filename.length).toLowerCase();
                            //如果限制了上传文件格式，则进入判断
                            if (types) {
                                angular.forEach(types, function (item) {
                                    if (item == filetype) {
                                        isFlag = true;
                                    }
                                })
                            } else {
                                isFlag = true;
                            }
                        }
                        //若文件格式非法，并且文件不为空，则弹出错误信息，并且清空文件
                        if (!isFlag && $scope.file != null) {
                            $scope.file = "";
                            $alert({
                                title: '消息',
                                content: fileObject.fileoption.typeparams.errormsg,
                                placement: 'top',
                                type: 'info',
                                show: true,
                                duration: 3,
                                container: '#fileaddmodal'
                            });
                        }
                        return isFlag;
                    };

                    $scope.upload = function () {

                        scope.uploadMethod($scope.file, $scope, Upload, AuthUser);
                    }

                };

                scope.fileModalController.$inject = ['$scope', 'Upload', 'AuthUser'];

                scope.fModal = $modal({
                    controller: scope.fileModalController,
                    templateUrl: '../js/template/modal_fileadd.html', show: false,
                    placement: 'center', animation: 'am-fade-and-slide-top'
                });

            }
        };
        return upfileObject;
    }).directive('uiKindeditor', function ($ocLazyLoad) {
        return {
            restrict: 'EA',
            require: '?ngModel',
            link: function (scope, element, attrs, ctrl) {
                $ocLazyLoad.load('../../scripts/kindeditor/kindeditor-all-min.js').then(function () {
                    var _initContent, editor;
                    var fexUE = {
                        initEditor: function () {
                            editor = KindEditor.create(element[0], {
                                width: '90%',
                                height: '400px',
                                resizeType: 1,
                                langType: 'zh-CN',
                                uploadJson: '',
                                formatUploadUrl: false,
                                allowImageUpload: false,
                                allowFileManager: false,
                                items: ['source', '|', 'undo', 'redo', '|', 'preview', 'print', 'template', 'code', 'cut', 'copy', 'paste',
                                    'plainpaste', 'wordpaste', '|', 'justifyleft', 'justifycenter', 'justifyright',
                                    'justifyfull', 'insertorderedlist', 'insertunorderedlist', 'indent', 'outdent', 'subscript',
                                    'superscript', 'clearhtml', 'quickformat', 'selectall', '|', 'fullscreen', '/',
                                    'formatblock', 'fontname', 'fontsize', '|', 'forecolor', 'hilitecolor', 'bold',
                                    'italic', 'underline', 'strikethrough', 'lineheight', 'removeformat', '|', 'image', 'table', 'hr', 'emoticons', 'baidumap', 'pagebreak',
                                    'anchor', 'link', 'unlink', '|', 'about'],
                                afterChange: function () {
                                    ctrl.$setViewValue(this.html());
                                }
                            });
                        },
                        setContent: function (content) {
                            if (editor) {
                                editor.html(content);
                            }
                        }
                    };

                    if (!ctrl) {
                        return;
                    }
                    _initContent = ctrl.$viewValue;
                    ctrl.$render = function () {
                        _initContent = ctrl.$isEmpty(ctrl.$viewValue) ? '' : ctrl.$viewValue;
                        fexUE.setContent(_initContent);
                    };
                    fexUE.initEditor();
                });
            }
        }
    }).provider('$ueditor', function () {
        var defaults = this.defaults = {
            UEDITOR_HOME_URL: '../../scripts/ueditor/',
            //initialContent: _initContent,
            initialFrameHeight: 400,
            autoHeightEnabled: false,
            autoFloatEnabled: false,
            serverUrl: '',
            wordCount: false,
            maximumWords: 10000000,
            elementPathEnabled: false,
            enableAutoSave: false,
            zIndex: 0,
            toolbars: [[
                'fullscreen', 'source', '|', 'undo', 'redo', '|',
                'bold', 'italic', 'underline', 'fontborder', 'strikethrough', 'superscript', 'subscript', 'removeformat', 'formatmatch', 'autotypeset', 'blockquote', 'pasteplain', '|', 'forecolor', 'backcolor', 'insertorderedlist', 'insertunorderedlist', 'selectall', 'cleardoc', '|',
                'rowspacingtop', 'rowspacingbottom', 'lineheight', '|',
                'customstyle', 'paragraph', 'fontfamily', 'fontsize', '|',
                'directionalityltr', 'directionalityrtl', 'indent', '|',
                'justifyleft', 'justifycenter', 'justifyright', 'justifyjustify', '|', 'touppercase', 'tolowercase', '|',
                'link', 'unlink', 'anchor', '|', 'imagenone', 'imageleft', 'imageright', 'imagecenter', '|',
                'simpleupload', 'insertimage', 'emotion', 'scrawl', 'attachment', '|',
                'horizontal', 'date', 'time', 'spechars', 'snapscreen', 'wordimage', '|',
                'inserttable', 'deletetable', 'insertparagraphbeforetable', 'insertrow', 'deleterow', 'insertcol', 'deletecol', 'mergecells', 'mergeright', 'mergedown', 'splittocells', 'splittorows', 'splittocols', 'charts'
            ]]
        };
        //var editor=null;
        this.$get = function () {
            var editor = new UE.ui.Editor(defaults);
            return {ue: editor, options: defaults};
        }
    }).directive('uiUeditor', ["$ocLazyLoad", "$compile", "$ueditor", function ($ocLazyLoad, $compile, $ueditor) {
        /* return {
             restrict: 'EA',
             require: '?ngModel',
             link: function (scope, element, attrs, ctrl) {
                 //Ueditor富文本框先存代码，以后可能使用
                 //$ocLazyLoad.load(['../../scripts/ueditor/ueditor.config.js',
                 //    '../../scripts/ueditor/ueditor.all.js']).then(function () {
                 var _self = this,
                     _initContent,
                     editor,
                     editorReady = false;

                 var fexUE = {
                     initEditor: function () {
                         _self = this;
                         if (typeof UE != 'undefined') {
                             editor = new UE.ui.Editor($ueditor.options);
                             //editor=UE.getEditor(attrs['id'],$ueditor.options);
                             editor.render(element[0]);

                             editor.ready(function () {
                                 editorReady = true;
                                 _self.setContent(_initContent);

                                 editor.addListener('contentChange', function () {
                                     scope.$apply(function () {
                                         ctrl.$setViewValue(editor.getContent());
                                     });
                                 });
                             });
                         }
                     },
                     setContent: function (content) {
                         if (editor && editorReady) {
                             editor.setContent(content);
                         }
                     },
                     destroy:function () {
                         //element.prev('.edui-default').remove();
                         editor.destroy();
                         $("[class*='edui-']").remove();

                     }
                 };
                 if (!ctrl) {
                     return;
                 }
                 _initContent = ctrl.$viewValue;
                 ctrl.$render = function () {
                     _initContent = ctrl.$isEmpty(ctrl.$viewValue) ? '' : ctrl.$viewValue;
                     fexUE.setContent(_initContent);
                 };

                 scope.$on('$destroy',function(){
                     fexUE.destroy();
                 });

                 fexUE.initEditor();
                 //});
             }
         };*/
        return {
            restrict: 'EA',
            require: '?ngModel',
            link: function (scope, element, attrs, ctrl) {
                $ocLazyLoad.load('../../scripts/kindeditor/kindeditor-all-min.js').then(function () {
                    var _initContent, editor;
                    var fexUE = {
                        initEditor: function () {
                            editor = KindEditor.create(element[0], {
                                width: '90%',
                                height: '400px',
                                resizeType: 1,
                                langType: 'zh-CN',
                                uploadJson: '',
                                formatUploadUrl: false,
                                allowImageUpload: false,
                                allowFileManager: false,
                                items: ['source', '|', 'undo', 'redo', '|', 'preview', 'print', 'template', 'code', 'cut', 'copy', 'paste',
                                    'plainpaste', 'wordpaste', '|', 'justifyleft', 'justifycenter', 'justifyright',
                                    'justifyfull', 'insertorderedlist', 'insertunorderedlist', 'indent', 'outdent', 'subscript',
                                    'superscript', 'clearhtml', 'quickformat', 'selectall', '|', 'fullscreen', '/',
                                    'formatblock', 'fontname', 'fontsize', '|', 'forecolor', 'hilitecolor', 'bold',
                                    'italic', 'underline', 'strikethrough', 'lineheight', 'removeformat', '|', 'image', 'table', 'hr', 'emoticons', 'baidumap', 'pagebreak',
                                    'anchor', 'link', 'unlink', '|', 'about'],
                                afterChange: function () {
                                    ctrl.$setViewValue(this.html());
                                }
                            });
                        },
                        setContent: function (content) {
                            if (editor) {
                                editor.html(content);
                            }
                        }
                    };

                    if (!ctrl) {
                        return;
                    }
                    _initContent = ctrl.$viewValue;
                    ctrl.$render = function () {
                        _initContent = ctrl.$isEmpty(ctrl.$viewValue) ? '' : ctrl.$viewValue;
                        fexUE.setContent(_initContent);
                    };
                    fexUE.initEditor();
                });
            }
        }
    }]).filter('showhtmlfilter', function ($sce) {
        return function (html) {
            return $sce.trustAsHtml(html);
        };
    }).filter('dicShowValFilter', function ($filter) {

        return function (key, diclist) {
            var result = '';
            if (key != null && diclist != null && diclist.length > 0) {
                var vals = $filter('filter')(diclist, {dickey: key});
                if (vals.length > 0) {
                    result = vals[0].dicvalue;
                }
            }
            return result;
        };
    }).directive('ngIndeterminate', function () {
        return {
            restrict: 'A',
            link: function (scope, element, attr) {
                attr.$observe('ngIndeterminate', function (value) {
                    element.prop('indeterminate', value == "true");
                });
            }
        };

        //模态框方式载入loading
    }).factory("$loading", function ($modal) {
        var loadingObject = {};

        loadingObject.loadingModal = $modal({
            templateUrl: '../js/template/modal_loading.html', show: false,
            placement: 'center', animation: '.modal-backdrop.am-fade', backdrop: false
        });
        loadingObject.show = function () {

            loadingObject.loadingModal.$promise.then(loadingObject.loadingModal.show);

        };
        loadingObject.hide = function () {
            loadingObject.loadingModal.$promise.then(loadingObject.loadingModal.hide);

        };
        return loadingObject;

    }).directive('menupanel', function ($http, AuthUser, $state) {
        return {
            restrict: 'EA',
            templateUrl: '../js/template/t_menupanel.html',
            scope: true,
            link: function (scope, element, attr) {
                var menuobject = {
                    param: {
                        uid: AuthUser.getUser().DGUserID,
                        appkey: attr['appkey'],
                        defrolekey: attr['defrolekey']
                    },
                    getMenuUrl: '../../api/user/getmenubyuid'
                };
                scope.panels = [];
                scope.getMenuList = function () {
                    $http({
                        method: 'post', url: menuobject.getMenuUrl, data: menuobject.param
                    }).then(function (result) {
                        if (result.data.success) {
                            scope.menuList = result.data.item;
                            //$state.get('home');若路由不存在，返回null
                            //$state.is('home');若路由不存在，返回undifined;
                            if (scope.menuList.length > 0) {
                                angular.forEach(scope.menuList, function (menu) {
                                    //如果为父节点
                                    if (menu.ParentMenuId == null || menu.ParentMenuId == "") {
                                        var pmenu = {title: menu.MenuName, cNodes: []};
                                        //遍历插入子节点
                                        angular.forEach(scope.menuList, function (cli) {
                                            //截取路由
                                            var realstate = scope.sliceStateName(cli.MenuNo);
                                            //路由是否存在,若存在则为原路由，若不存在，为空
                                            var isExisted = angular.isDefined($state.is(realstate)) ? cli.MenuNo : '';
                                            if (cli.ParentMenuId == menu.MenuId) pmenu.cNodes.push({
                                                title: cli.MenuName,
                                                name: isExisted
                                            });
                                        });
                                        scope.panels.push(pmenu);
                                    }
                                })
                            }
                            scope.initActive();
                        } else {
                            $alert({
                                title: '错误：',
                                content: result.data.msg,
                                placement: 'centre',
                                type: 'info',
                                show: true,
                                duration: 3
                            });
                        }

                    });
                };
                //用于截取路由name,
                //如:home.roleList({appid:"CBFAF886-D757-46B5-A856-763AEEF6D3D3"})---返回home.roleList
                scope.sliceStateName = function (statename) {
                    var index = statename.indexOf('(');
                    if (index >= 0) {
                        return statename.slice(0, index);
                    }
                    return statename;
                };


                //刷新页面时默认打开一级菜单
                scope.initActive = function () {
                    //当前路由name
                    var statename = $state.current.name;
                    angular.forEach(scope.panels, function (value, index) {
                        angular.forEach(value.cNodes, function (item) {
                            //去掉参数的路由，如home.roleList({appid:"CBFAF886-D757-46B5-A856-763AEEF6D3D3"})，去参数路由：home.roleList
                            var realState = scope.sliceStateName(item.name);
                            if (realState == statename) {
                                scope.panels.activePanel = index;
                            }
                        })
                    });
                };
                if (angular.isDefined(attr['appkey']) && angular.isDefined(attr['defrolekey'])) {
                    scope.getMenuList();
                }

            }
        };
    }).directive('bsLvtree', function ($filter, $timeout, $ocLazyLoad, $compile) {
        //生成树型结构
        var bindtree = function (vtree, model) {
            angular.forEach(vtree, function (val, key) {
                val.children = $filter('filter')(model.data, function (fdata) {
                    return fdata.pid == val.id;
                });
                model.treelength++;

                //默认不显示按钮
                val.showbtn = false;
                //查看最后一级
                if (model.xAxis[model.xAxis.length - 1].id == val.xid) {
                    val.islast = true;
                } else {
                    val.islast = false;
                }

                bindtree(val.children, model);
            });
        };

        var htmlXaxisbind = function (xaxis, $xAxispanel) {
            angular.forEach(xaxis, function (xval) {
                $xAxispanel.append('<div data-id="' + xval.id + '">' + xval.name + '</div>');
            });
        };


        //画中间线
        var drawxAxisLine = function (ctx, xAxis, pheigth) {
            ctx.beginPath();
            ctx.lineWidth = 1;
            ctx.shadowBlur = 0;
            //ctx.setLineDash = [15,5];
            ctx.strokeStyle = '#000000';

            for (var i = 1; i < xAxis.length; i++) {

                ctx.moveTo(250 * i, 0);
                ctx.lineTo(250 * i, pheigth);
                ctx.stroke();
            }
            ctx.closePath();

        };

        //画对象之间的联线
        var drawRectToRectLine = function (ctx, vtreeit) {
            var $it, $cit;

            ctx.lineWidth = 1;
            ctx.shadowBlur = 0;
            ctx.strokeStyle = 'green';

            if (vtreeit.children && vtreeit.children.length > 0) {

                $it = $('.item_panel[data-id="' + vtreeit.id + '"]');

                angular.forEach(vtreeit.children, function (cv, ck) {
                    $cit = $('.item_panel[data-id="' + cv.id + '"]');

                    ctx.moveTo($it.position().left + $it.width() - 12, $it.position().top + 5);
                    ctx.lineTo($cit.position().left + 10, $cit.position().top + 5);
                    ctx.stroke();

                    drawRectToRectLine(ctx, cv);
                });
            }

        };

        return {
            restrict: 'EA',
            require: '?ngModel',
            templateUrl: '../js/setting/sysduty/lv_tree.html',
            scope: {ngModel: '='},
            controller: function ($scope) {
                $ocLazyLoad.load('../js/setting/sysduty/sdutyplate.css');

                $scope.ngModel.xAxis = $filter('orderBy')($scope.ngModel.xAxis, '+id') || [{id: 0, name: '根节点'}];
                $scope.ngModel.treelength = 0;
                $scope.ngModel.treeloadlength = 0;

                //btntype：{1：'新增同级',2:'新增子级',3:'删除节点',4:'查看节点'}
                $scope.btnclick = function (titem, btntype) {
                    if ($scope.ngModel.btnclick) {
                        $scope.ngModel.btnclick(titem, btntype);
                    }
                };

                $scope.loadIncrease = function () {
                    $scope.ngModel.treeloadlength++;
                };


            },
            link: function ($scope, $elem, $attrs) {

                //htmlXaxisbind($scope.ngModel.showxAxis, $elem.find('.x_axis_div'));
                //开始添加节点
                //htmltreebind($scope.ngModel.treeNodes, $elem.find('.tree_div'));
                //$compile($elem.find('.tree_div'))($scope);

                $scope.$watch('ngModel.data', function () {
                    //第一层节点
                    $scope.ngModel.treeNodes = $filter('filter')($scope.ngModel.data, function (val) {
                        return val.xid == $scope.ngModel.xAxis[0].id;
                    });
                    $scope.ngModel.treelength = 0;
                    $scope.ngModel.treeloadlength = 0;
                    bindtree($scope.ngModel.treeNodes, $scope.ngModel);

                });

                $scope.$watch('ngModel.treeloadlength', function () {

                    if ($scope.ngModel.treelength == $scope.ngModel.treeloadlength && $scope.ngModel.treeloadlength > 0) {
                        $timeout(function () {
                            //开始画图
                            var cvs = $elem.find('.dutypanel>canvas')[0];
                            cvs.width = $elem.find('.dutypanel').width();
                            cvs.height = $elem.find('.dutypanel').height();
                            var ctx = cvs.getContext('2d');
                            //drawxAxisLine(ctx, $scope.ngModel.xAxis, cvs.height);
                            ctx.beginPath();
                            angular.forEach($scope.ngModel.treeNodes, function (tn, tk) {
                                drawRectToRectLine(ctx, tn);
                            });
                            ctx.closePath();
                            ctx.save();
                        }, 200);
                    }
                });


            }
        }
    }).directive('sysselect', function ($http, AuthUser, $state, $modal) {
        var directiveObject = {
            restrict: 'EAC',
            scope: {
                textids: '=',//已选择的人员ID
                textnames: '=',//已选择的人员
                selecteditems: '=',//已选对象
            },
            link: function (scope, element, attr, controller) {

                //通过item的id判断该元素是否在arr里
                scope.contains = function (arr, item) {
                    var i = arr.length;
                    //如果选择系统，通过SystemID去判断
                    //如果选择模块，菜单，功能点，通过SysDutyID去判断
                    if (attr['selecttype'] == 0) {
                        while (i--) {
                            if (arr[i].SystemID === item.SystemID) {
                                return true;
                            }
                        }
                    } else {
                        while (i--) {
                            if (arr[i].SysDutyID === item.SysDutyID) {
                                return true;
                            }
                        }
                    }

                    return false;
                };
                var sysModalController = function ($scope) {
                    $scope.title = angular.isDefined(attr['title']) ? attr['title'] : "功能点选择";//模态框标题
                    $scope.sysList = [];//系统列表
                    $scope.curList = [];//当前选择列表，保存该控件打开时最右边div的那个集合，如selectType=0，则是系统，1则是模块
                    $scope.selectedItems = angular.isDefined(scope.selecteditems) ? angular.copy(scope.selecteditems) : [];//已选择对象
                    $scope.selectType = angular.isDefined(attr['selecttype']) && attr['selecttype'] > -1 && attr['selecttype'] < 4 ? attr['selecttype'] : 0;//选择类型 0-选择系统;1-选择模块;2-选择菜单;3-选择功能点;
                    $scope.singleMode = attr['singlemode'] == "true" ? true : false;//选择模式   true-单选模式,false-多选模式
                    //所有请求url
                    var urls = {
                        GetSysLisUrl: '../../api/SysManage/GetAllSysList',
                        GetChildSysDutyListUrl: '../../api/SysDuty/GetChildSysDutyList'
                    };
                    //系统列表初始化
                    $scope.SysListInit = function () {
                        $http.post(urls.GetSysLisUrl).then(function (result) {
                            $scope.sysList = result.data.list;
                            if ($scope.selectType == 0) {
                                $scope.curList = angular.copy(result.data.list);//当前需要添加的集合
                            }
                        }, function () {
                            $alert({
                                title: '错误：',
                                content: '获取系统列表失败，服务器错误',
                                placement: 'center',
                                type: 'info',
                                container: '#sysselect',
                                show: true,
                                duration: 3
                            });
                        });
                    };
                    //模态框样式初始化
                    $scope.InitClass = function () {
                        $scope.isZero = $scope.selectType == 0 ? true : false;
                        $scope.isOne = $scope.selectType == 1 ? true : false;
                        $scope.isTwo = $scope.selectType == 2 ? true : false;
                        $scope.isThree = $scope.selectType == 3 ? true : false;
                    };
                    //执行初始化
                    $scope.InitClass();
                    $scope.SysListInit();
                    //移除元素
                    $scope.Remove = function (index, arr) {
                        arr.splice(index, 1);
                    };
                    //确认选择
                    $scope.Confirm = function () {
                        scope.selecteditems = angular.copy($scope.selectedItems);
                        scope.textids = "";
                        scope.textnames = "";
                        $scope.GenerateValue();
                        $scope.$hide();
                    };
                    $scope.GenerateValue = function () {
                        var isFirst = true;
                        if ($scope.selectType == 0) {
                            angular.forEach(scope.selecteditems, function (item) {
                                if (isFirst) {
                                    scope.textnames = item.SystemName;
                                    scope.textids = item.SystemID;
                                    isFirst = false;
                                } else {
                                    scope.textnames += "," + item.SystemName;
                                    scope.textids += "," + item.SystemID;
                                }
                            });
                        } else {
                            angular.forEach(scope.selecteditems, function (item) {
                                if (isFirst) {
                                    scope.textnames = item.SysDutyName;
                                    scope.textids = item.SysDutyID;
                                    isFirst = false;
                                } else {
                                    scope.textnames += "," + item.SysDutyName;
                                    scope.textids += "," + item.SysDutyID;
                                }
                            });
                        }
                    };
                    //changeType为对应改变的下拉类型，0-系统,1-模块,2-菜单
                    //arr  选中的值
                    //list 当前列表
                    $scope.SelectChange = function (changeType, arr, list) {
                        //单选模式
                        if ($scope.singleMode) {
                            if ($scope.selectType == changeType && arr.length > 0) {
                                arr.length = 1;
                                $scope.selectedItems[0] = arr[0];
                            } else if (arr.length > 0) {
                                $scope.getSelectList(changeType, arr, list);
                            }
                        } else {
                            //多选模式
                            if ($scope.selectType == changeType) {
                                $scope.tempSelected = angular.copy(arr);
                            } else if (arr.length > 0) {
                                $scope.getSelectList(changeType, arr, list);
                            }
                        }
                    };
                    //获得系统、模块、菜单、功能集合
                    $scope.getSelectList = function (changeType, arr, list) {
                        var SystemID = '';
                        var PdutyID = '';
                        var DutyLv = changeType + 1;
                        if (changeType == 0) {
                            SystemID = arr[0].SystemID;
                        } else {
                            PdutyID = arr[0].SysDutyID;
                        }
                        list.child = [];
                        list.child.isloading = true;
                        $http.post(urls.GetChildSysDutyListUrl, {
                            SystemID: SystemID,
                            PdutyID: PdutyID,
                            DutyLv: DutyLv
                        }).then(function (result) {
                            list.child.isloading = false;
                            arr.length = 1;
                            //如果当前获取的列表为该选择模式需要的列表，则将次返回数据复制给curList
                            if (DutyLv == $scope.selectType) {
                                $scope.curList = angular.copy(result.data.list);//当前需要添加的集合
                            } else {
                                $scope.curList.length = 0;
                            }
                            list.child = result.data.list;
                        }, function (result) {
                            list.child.isloading = false;
                            $alert({
                                title: '错误：',
                                content: '获列表失败，服务器错误',
                                placement: 'center',
                                type: 'info',
                                container: '#sysselect',
                                show: true,
                                duration: 3
                            });
                        })
                    };
                    //添加到已选
                    $scope.Add = function (type) {
                        if (type == 0) {
                            angular.forEach($scope.tempSelected, function (item) {
                                if (scope.contains($scope.selectedItems, item) == false) {
                                    this.push(item);
                                }
                            }, $scope.selectedItems)
                        } else {
                            angular.forEach($scope.curList, function (item) {
                                if (scope.contains($scope.selectedItems, item) == false) {
                                    this.push(item);
                                }
                            }, $scope.selectedItems)
                        }
                    };
                    $scope.Delete = function () {
                        $scope.selectedItems.length = [];
                    }
                };
                sysModalController.$inject = ['$scope'];
                //模态框实例
                var sysModal = $modal({
                    scope: scope,
                    controller: sysModalController,
                    resolve: {
                        load: ['$ocLazyLoad', function ($ocLazyLoad) {
                            $ocLazyLoad.load('../js/template/modal_sysselect.css');
                            return true;
                        }]
                    },
                    templateUrl: '../js/template/modal_sysselect.html',
                    show: false,
                    animation: 'am-fade-and-slide-top'
                });
                //data-notrelated:是否取消关联用一个父元素的input标签(点击input标签时也可以触发该控件)，默认为false  可选值:true(关联)/fasle(不关联)
                if (attr['notrelated']) {
                    element.on("click", function () {
                        sysModal.$promise.then(sysModal.show);
                    });
                    element.css({cursor: 'pointer'});
                } else {
                    element.parent().on("click", function () {
                        sysModal.$promise.then(sysModal.show);
                    });
                    element.css({cursor: 'pointer'});
                    element.parent().children("input").css({cursor: 'pointer', "background-color": "#FFFFFF"});
                }

            }
        };
        return directiveObject;
    }).directive('bsselectdataPro', function ($http, $modal, $filter) {
        var directiveObject = {
            restrict: 'EAC',
            scope: {
                dataoptions: '='
            },
            link: function (scope, element, attr, controller) {
                var sdModal = {}, selectHtml = '';
                /*
                angular.extend(scope.dataoptions,{
                    isMulti:true,
                    selectedLabeData:'',
                    selectedValueData:'',
                    selectedJData:[]
                });*/

                if (!scope.dataoptions.selectedJData) {
                    scope.dataoptions.selectedJData = [];
                }

                scope.init = function () {

                    scope.dataoptions.selectedJData = [];
                    if (!scope.dataoptions.selectParams) {
                        scope.dataoptions.selectParams = {};
                    }
                    if (scope.dataoptions.selectedValueData && scope.dataoptions.selectedValueData.length > 0) {
                        var valueArray = scope.dataoptions.selectedValueData.split(',');
                        var labelArray = scope.dataoptions.selectedLabeData.split(',');

                        angular.forEach(valueArray, function (val, key) {
                            var it = {};
                            it[scope.dataoptions.selectValuekey] = val;
                            it[scope.dataoptions.selectLabelKey] = labelArray[key];
                            scope.dataoptions.selectedJData.push(it);
                        });
                    }
                };

                var sdModalController = function ($scope) {


                    $scope.fdata = {
                        selectParams: scope.dataoptions.selectParams,
                        selectCols: [],
                        columns: scope.dataoptions.columns,
                        items: [],
                        ptotal: 0,
                        title: scope.dataoptions.title,
                        selectedJData: scope.dataoptions.selectedJData,
                        selectValuekey: scope.dataoptions.selectValuekey,
                        selectLabelKey: scope.dataoptions.selectLabelKey,
                        selectTemp: [],
                        isMulti: scope.dataoptions.isMulti
                    };

                    //转成查询条件
                    angular.extend($scope.fdata.selectParams, {
                        pageindex: 1,
                        pagesize: 10
                    });
                    angular.forEach(scope.dataoptions.selectData, function (value, key) {
                        $scope.fdata.selectParams[key] = '';
                        $scope.fdata.selectCols.push({text: value, val: key});
                    });

                    $scope.loadData = function () {
                        $http.get(scope.dataoptions.url, {params: $scope.fdata.selectParams}).then(function (value) {
                            $scope.fdata.items = value.data.item.list;
                            $scope.fdata.ptotal = value.data.item.total;
                        });
                    };

                    $scope.findSData = function () {
                        $scope.fdata.selectParams.pageindex = 1;
                        $scope.loadData();
                    };

                    $scope.addItem = function () {
                        var tableCheckedArray = $filter('filter')($scope.fdata.items, function (tIt) {
                            return tIt.checked;
                        });
                        angular.forEach(tableCheckedArray, function (value, key) {
                            var itemData = $filter('filter')($scope.fdata.selectedJData, function (it) {
                                return it[$scope.fdata.selectValuekey] == value[$scope.fdata.selectValuekey];
                            });
                            if (itemData.length == 0) {
                                $scope.fdata.selectedJData.push(value);
                            }
                        });

                    };

                    $scope.deleteItem = function (it) {
                        var i = -1;
                        if (it) {
                            i = $scope.fdata.selectedJData.indexOf(it);
                            $scope.fdata.selectedJData.splice(i, 1);
                        } else {
                            angular.forEach($scope.fdata.selectTemp, function (value, key) {
                                i = $scope.fdata.selectedJData.indexOf(value);
                                $scope.fdata.selectedJData.splice(i, 1);
                            });
                        }

                    };

                    $scope.$watch("fdata.selectParams.pageindex", function (newVal) {
                        if ($scope.fdata.ptotal > 0) {
                            $scope.loadData();
                        }
                    });

                    $scope.selectedData = function () {
                        scope.dataoptions.selectedLabeData = '';
                        scope.dataoptions.selectedValueData = '';
                        var selectItem = null;
                        if ($scope.fdata.isMulti) {
                            selectItem = [];
                            angular.forEach($scope.fdata.selectedJData, function (value, key) {
                                if (key > 0) {
                                    scope.dataoptions.selectedLabeData += ',';
                                    scope.dataoptions.selectedValueData += ','
                                }

                                scope.dataoptions.selectedLabeData += value[$scope.fdata.selectLabelKey];
                                scope.dataoptions.selectedValueData += value[$scope.fdata.selectValuekey];
                                if (scope.ngModel != undefined) {
                                    scope.ngModel.selectedLabeData = scope.dataoptions.selectedLabeData;
                                    scope.ngModel.selectedValueData = scope.dataoptions.selectedValueData;
                                }

                                selectItem.push(value);
                            });
                        } else {
                            selectItem = {};
                            angular.forEach($scope.fdata.items, function (value, key) {
                                if (value.checked == true) {
                                    scope.dataoptions.selectedLabeData = value[$scope.fdata.selectLabelKey];
                                    scope.dataoptions.selectedValueData = value[$scope.fdata.selectValuekey];
                                    selectItem = value;
                                }
                            });
                        }
                        if (scope.dataoptions.onSelect != undefined) {
                            scope.dataoptions.onSelect(scope.dataoptions.selectedValueData, selectItem);
                        }
                        $scope.$hide();
                    };

                    $scope.loadData();

                };
                sdModalController.$inject = ['$scope'];

                //动态生成html
                angular.forEach(scope.dataoptions.selectData, function (value, key, index) {
                    if (key / 2 == 0) {
                        selectHtml += '<div class="row clearfix">';
                    }

                    selectHtml += '<div class="col-lg-3 col-md-3 col-sm-4 col-xs-5 form-control-label">';
                    selectHtml += '<label for="' + key + '">' + value + '</label>';
                    selectHtml += '</div>';
                    selectHtml += '<div class="col-lg-3 col-md-3 col-sm-4 col-xs-5"><div class="form-group"><div class="form-line">';
                    selectHtml += '<input type="text" class="form-control" ng-model="fdata.selectParams.' + key + '" ng-keypress="($event.which === 13)?loadData():0">';
                    selectHtml += '</div></div></div>';
                    if (key / 2 == 0) {
                        selectHtml += '</div>';
                    }
                });
                //
                angular.forEach(scope.dataoptions.comboxData, function (value, key, item) {
                    selectHtml += '<div class="col-lg-3 col-md-3 col-sm-4 col-xs-5 form-control-label">';
                    selectHtml += '<label for="' + key + '">' + value.text + '</label>';
                    selectHtml += '</div>';
                    selectHtml += '<div class="col-lg-3 col-md-3 col-sm-4 col-xs-5"><div class="form-group"><div class="form-line">';
                    selectHtml += '  <select class="form-control show-tick" ng-model="fdata.selectParams.' + key + '"';
                    selectHtml += ' class="form-control" name="honourlevel" ng-required="true"> <option value="" selected>--请选择--</option> ';
                    angular.forEach(value.data, function (dic, dicvalue) {
                        selectHtml += '<option value="' + dic.dicvalue + '">' + dic.dickey + '</option> ';
                    });
                    selectHtml += '</select>';
                    selectHtml += '</div></div></div>';
                });
                $http.get("../js/template/modal_selectdatapro.html").then(function (value) {
                    var showTemplate = value.data.replace(/\$\$selectdate\$\$/, selectHtml);
                    showTemplate = showTemplate.replace(/\$\$itemlabel\$\$/, scope.dataoptions.selectLabelKey);
                    sdModal = $modal({
                        scope: scope, controller: sdModalController, template: showTemplate, show: false
                    });
                });


                element.on('click', function () {
                    scope.init();
                    sdModal.$promise.then(sdModal.show);
                });
            }
        };
        return directiveObject;
    }).directive('bsDtable', function ($compile) {
        var directiveObject = {
            restrict: 'EAC',
            template: function (tElement, tAttrs) {

                var html = '<table class="table table-bordered tlist">\n';
                html += '<thead>\n';
                html += '<tr>\n';
                html += '     <th ng-if="showcheckbox!=false" class="th-checkbox"><input id="checkAll" class="pull-left filled-in chk-col-cyan" type="checkbox" ng-click="checkAll()" /><label for="checkAll">全选</label></th><th ng-repeat="cp in dtData.columns">{{cp.text}}</th>\n';
                html += '</tr>\n';
                html += '</thead>\n';
                html += '<tbody data-id="drow">\n';
                html += '</tbody>\n';
                html += '</table>';

                return html;
            },
            scope: {
                datarows: '=',
                datacols: '=',
                ismulti: '=',
                showcheckbox: '='
            },
            link: function (scope, element, attr, controller) {

                scope.dtData = {
                    columns: [],
                    trHtml: '',
                    showcheckbox: attr.showcheckbox == false ? false : true
                };
                scope.allchecked = false;

                scope.checkAll = function () {
                    if (scope.allchecked == false) {
                        scope.allchecked = true;
                    } else {
                        scope.allchecked = false;
                    }
                    angular.forEach(scope.datarows, function (value, key) {
                        value.checked = scope.allchecked;
                    });
                };

                scope.checkItem = function (it) {
                    //单选
                    if (!scope.ismulti) {
                        angular.forEach(scope.datarows, function (value, key) {
                            value.checked = false;
                            if (it.checked == false && it == value) {
                                value.checked = true;
                            }
                        });
                    }
                };

                scope.dtData.trHtml += '<tr ng-repeat="it in datarows">' +
                    '<td ng-if="showcheckbox!=false"><input type="checkbox" id="{{$index}}" class="filled-in chk-col-cyan" ng-model="it.checked" ng-click="checkItem(it)" /><label for="{{$index}}"></label></td>';

                angular.forEach(scope.datacols, function (value, key) {
                    scope.dtData.trHtml += '<td ng-bind="it.' + key + '"></td>>';
                    this.push({text: value, val: key});
                }, scope.dtData.columns);

                scope.dtData.trHtml += '</tr>';

                element.find('tbody[data-id="drow"]').append(scope.dtData.trHtml);
                $compile(element.find('tbody[data-id="drow"]'))(scope);

            }
        };

        return directiveObject;
    }).directive('autoHeight', function ($window, $timeout) {
        return {
            restrict: 'A',
            link: function (scope, element, attrs) {
                $timeout(function () {
                    var winowHeight = $window.innerHeight; //获取窗口高度
                    var headerHeight = element.offset().top;
                    var footerHeight = 10;

                    $("body").css("oveflow-y", "hidden");
                    element.addClass('outoflow')
                        .css('max-height',
                            (winowHeight - headerHeight - footerHeight) + 'px');
                }, 1000);
            }
        };
    }).directive('autoHeightFixed', function ($window, $timeout) {
        return {
            restrict: 'A',
            link: function (scope, element, attrs) {
                $timeout(function () {
                    /* var winowHeight = $window.innerHeight; //获取窗口高度
                     var headerHeight = element.offset().top;
                     var footerHeight = 10;*/

                    $("body").css("oveflow-y", "hidden");
                    element.addClass('outoflow')
                        .css('max-height', '600px');
                }, 1000);
            }
        };
    })
    /* .directive("fixHeaderTableRows", function ($window,$timeout) {
     return {
         restrict : 'A',
         link : function(scope, element, attrs) {
             var mybody = element.closest('table');
             var header = mybody.prev();
             header.css("position", "relative").css("background-color", "white").css("max-width", "none").css("margin-bottom", "0px");
             mybody.css("max-width", "none").css("width", "auto").css("margin-top", "0px");
             mybody.parent().scroll(function() {
                 var scrollTop = $(this).scrollTop();
                 header.css("top", scrollTop.toString() + "px");
                 header.scrollLeft($(this).scrollLeft());
             });
             if (scope.$last === true) {
                 $timeout(function (){
                     var firstRow = mybody.children("tbody").children("tr");
                     if (firstRow.length > 0) { //一行都没有一般就不会错位
                         // header.width(mybody.width());
                         var headerList = header.find("tr>th");
                         // for (var i = headerList.length - 1; i >= 0; i --) {
                         //     var width = $($(firstRow[0]).children("td")[i]).width();
                         //
                         //     $(headerList[i]).width(width);
                         // }
                         var bodyWidth = mybody.width();
                         var totalWidth = 0;
                         var headerColumnList = header.find("tr>th");
                         var widthList = [headerColumnList.length];
                         header.width(bodyWidth);
                         headerColumnList.each(function(i, v) {
                             var bodyColumn = $($(firstRow[firstRow.length - 1]).children("td")[i]);
                             var width = bodyColumn.outerWidth();
                             var borderWidth = parseInt(bodyColumn.css("border-width"));

                             $(v).css("width", (width - borderWidth).toString() + "px");
                             var nowWidth = $(v).outerWidth();
                             if (nowWidth > width) {
                                 widthList[i] = nowWidth;
                                 totalWidth += nowWidth;
                             } else {
                                 widthList[i] = width;
                                 totalWidth += width;
                             }
                         });
                         var headerBorderWidth = parseInt(header.css("border-left-width"));
                         header.width(totalWidth);
                         mybody.width(totalWidth);
                         headerColumnList.each(function(i, v) {
                             var borderWidth = parseInt($(v).css("border-left-width"));
                             $(v).css("width", (widthList[i] - borderWidth).toString() + "px");
                             $($(firstRow[0]).children("td")[i]).css("width", (widthList[i] - borderWidth).toString() + "px");
                         });
                     }
                 }, 1000);
             }

             // if (scope.$last === true) {
             //     $timeout(function (){
             //         var firstRow = mybody.children("tbody").children("tr");
             //         if (firstRow.length > 0) { //一行都没有一般就不会错位
             //             header.width(mybody.width());
             //             var headerList = header.find("tr>th");
             //             // for (var i = headerList.length - 1; i >= 0; i --) {
             //             //     var width = $($(firstRow[0]).children("td")[i]).width();
             //             //
             //             //     $(headerList[i]).width(width);
             //             // }
             //             header.find("tr>th").each(function (i, v) {
             //                 var width = $($(firstRow[0]).children("td")[i]).width();
             //
             //                 $(v).css("width", Math.floor(width).toString() + "px");
             //             });
             //         }
             //     }, 1000);
             // };
         }
     };
 })*/
        .factory('$payService', ['$q', '$rootScope', '$aside', '$alert', '$http', '$modal', '$loading', function ($q, $rootScope, $aside, $alert, $http, $modal, $loading) {
            var paySModel = {};

            paySModel.weChatPay = $modal({
                scope: $rootScope,
                resolve: {
                    load: ['$ocLazyLoad', function ($ocLazyLoad) {
                        return $ocLazyLoad.load(['../js/setting/payment/payment.css', '../js/setting/payment/payment.js']);
                    }]
                },
                controller: 'wxNativeCtrl',
                templateUrl: '../js/setting/payment/wx-modal.html',
                show: false
            });

            paySModel.payShow = function (model) {
                var $defer = $q.defer();

                if (!angular.isNumber(model.amount)) {
                    $alert({
                        title: '参数错误',
                        content: '支付金额必需为数字',
                        placement: 'top',
                        type: 'info',
                        show: true,
                        duration: 3
                    });
                    return;
                }
                if (angular.isUndefined(model.payRelId)) {
                    $alert({
                        title: '参数错误',
                        content: 'payRelId:关系ID必填！',
                        placement: 'top',
                        type: 'info',
                        show: true,
                        duration: 3
                    });
                    return;
                }
                if (angular.isUndefined(model.title)) {
                    $alert({
                        title: '参数错误',
                        content: 'title:支付标题必填！',
                        placement: 'top',
                        type: 'info',
                        show: true,
                        duration: 3
                    });
                    return;
                }

                $rootScope.wxNativeData = {};

                $loading.show();

                $http.post('../../wxapi/pay/order/create', {
                    "payRelId": model.payRelId,
                    "title": model.title,
                    "payAmount": model.amount,
                    "tradeType": 'NATIVE'
                }).then(function (res) {
                    $loading.hide();
                    if (res.data.returnCode == "SUCCESS") {
                        $rootScope.wxNativeData.imgdata = res.data.codeURL;
                        $rootScope.wxNativeData.outTradeNo = res.data.outTradeNo;
                        $rootScope.payModel = model;
                        $rootScope.paydefer$ = $defer;
                        paySModel.weChatPay.$promise.then(paySModel.weChatPay.show);
                    } else {
                        $alert({
                            title: '失败',
                            content: '创建微信支付订单失败：' + res,
                            placement: 'top',
                            type: 'info',
                            show: true,
                            duration: 10
                        });
                    }
                }, function (res) {
                    $loading.hide();
                    $alert({
                        title: '错误',
                        content: '服务器错误：' + res.data.message,
                        placement: 'top',
                        type: 'info',
                        show: true,
                        duration: 10
                    });
                });

                /*$rootScope.payModel = model;
                $rootScope.paydefer$ = $defer;
                paySModel.weChatPay.$promise.then(paySModel.weChatPay.show);*/

                return $defer.promise;
            };

            paySModel.backShow = function (payRelID) {
                /*var $defer = $q.defer();
                $rootScope.payModel = {payRelID: payRelID};
                paySModel.backAside.$promise.then(paySModel.backAside.show);
                $rootScope.backpaydefer$ = $defer;

                return $defer.promise;*/
            };
            return paySModel;
        }]).directive("zeroTableTh", ['$timeout', function ($timeout) {

        var f_time = function (element) {
            var $table = element.parents('table');
            var $thead = $table.find('thead');
            var $preTitleTable = $table.prev('table.zero-theader');
            var td_width = [], t_width = 0;

            if ($preTitleTable.length == 0) {
                var $title_table = $('<div class="zero-thead-div"><table class="table table-bordered zero-theader"></table></div>');
                var $divBody = $('<div class="zero-body-div"></div>');
                $table.before($title_table);
                $table.before($divBody);
                $.each($thead.find('th'), function (i, th) {
                    td_width.push(th.offsetWidth);
                    t_width += th.offsetWidth;
                });

                $thead.appendTo($title_table.find('table'));
                $table.appendTo($divBody);
                $table.addClass('zero-body');

                $.each($thead.find("th"), function (i, th) {
                    th.style.width = td_width[i] + "px";
                });

                $.each($table.find('tr:eq(0)>td'), function (i, td) {
                    td.style.width = td_width[i] + "px";
                });

                $divBody.height($(window).height() - $table.offset().top);

                $divBody.scroll(function () {
                    $title_table.scrollLeft($(this).scrollLeft());
                });
            } else {

                $thead = $table.parent().parent().find('.zero-theader>thead');

                $.each($thead.find('th'), function (i, th) {
                    td_width.push(th.offsetWidth);
                });

                $.each($table.find('tr:eq(0)>td'), function (i, td) {
                    td.style.width = td_width[i] + "px";
                });
            }
        };

        var directiveObject = {
            restrict: 'AC',
            link: function (scope, element, attr, controller) {
                if (scope.$last === true) {
                    $timeout(function () {
                        f_time(element);
                    }, 100);
                }
            }
        };
        return directiveObject;
    }]).directive("eChart", function ($http, $window, $ocLazyLoad) {
        return {
            restrict: 'EA',
            require: '?ngModel',
            link: function (scope, element, attrs, ctrl) {
                $ocLazyLoad.load('../../scripts/echarts.min.js').then(function () {
                    //初始化图表
                    var myChart = echarts.init(element[0]);
                    //监控option数据变化
                    scope.$watch(
                        attrs["ecData"],
                        function () {
                            var option = scope.$eval(attrs.ecData);
                            if (angular.isObject(option)) {
                                //绘制图表
                                myChart.setOption(option);
                            }
                        },
                        true
                    );
                    scope.getDom = function () {
                        return {
                            height: element[0].offsetHeight,
                            width: element[0].offsetWidth
                        };
                    };
                    //监控图表宽高变化，响应式
                    scope.$watch(
                        scope.getDom,
                        function () {
                            // resize echarts图表
                            myChart.resize();
                        },
                        true
                    );
                });
            }
        }
    }).directive("partyTree", function ($http, $ocLazyLoad, AuthUser, $filter, $timeout, $rootScope) {
        return {
            restrict: 'EA',
            require: '?ngModel',
            //作用域
            scope: {
                selectdzzdm: '=',  //等号是双向绑定，选中的党组织代码
                selectdzzmc: '=',  //等号是双向绑定，选中的党组织名称
                parentcode: '=?', //父级
                parentname: '=?',
                dzzdm: '=?', //当前党组织
                dzzmc: '=?',
                height: '=',
                csssrc: '=?',
                showtogglebtn: '=?',
                defaultselected: '=?',//默认选中的党委代码
                isunfold: '=?',//是否展开
                isshowxz: '=?',//是否加载小组，0不加载，1加载
                showlevel: '=?',
                datadzzdm: '=?',//数据权限
            },
            templateUrl: '../js/template/modal_partyTreeNew.html',
            link: function (scope, elemnet) {
                //组织树样式
                if (scope.csssrc) {
                    $ocLazyLoad.load(scope.csssrc);
                } else {
                    $ocLazyLoad.load('../js/template/modal_partyTree.css');
                }

                scope.isunfold = scope.isunfold == undefined ? true : scope.isunfold;
                //pt-sidebar-collapsed-back 时sidebar_width的宽度
                scope.sidebar_width = 260;
                scope.sidebar_has_resize = false;
                scope.menu_width = 292;

                //sidebar初始化
                var $sidebar = null;
                $sidebar = elemnet.parents('.dj-list-body').first();
                if (scope.isunfold) {
                    $sidebar.addClass('pt-sidebar-collapsed-back');
                } else {
                    $sidebar.addClass('pt-sidebar-collapsed');
                }
                var sidebarDivs = $sidebar.parent().find('.dj-list-body>div');
                sidebarDivs.eq(0).addClass('sidebar1');
                sidebarDivs.eq(1).addClass('content1');

                scope.sidebrResize = function (sideWidth) {
                    if (sideWidth < 500 && sideWidth >= 260) {

                        scope.sidebar_width = sideWidth;

                        sidebarDivs.eq(0).width(scope.sidebar_width);
                        sidebarDivs.eq(1).width($(window).width() - scope.menu_width - scope.sidebar_width - 23);
                        //sidebarDivs.eq(1).width($sidebar.width() - scope.sidebar_width - 10);
                    }

                };
                sidebarDivs.eq(0).mousedown(function (e) {
                    scope.sidebar_has_resize = true;
                });
                sidebarDivs.mousemove(function (e) {
                    if (scope.sidebar_has_resize) {
                        scope.sidebrResize(e.clientX - scope.menu_width + 20);
                    }
                });
                $(window).mouseup(function (e) {
                    scope.sidebar_has_resize = false;
                });
                sidebarDivs.eq(0).children().mousedown(function (e) {
                    e.stopPropagation();
                });

                $rootScope.$watch("menuToggle", function (newVal, oldVal) {
                    scope.menu_width = newVal ? 292 : 76;
                    scope.sidebrResize(scope.sidebar_width);
                });
                scope.$watch("isunfold", function (newVal, oldVal) {
                    scope.isshowtogglebtn = newVal;
                    if ($sidebar) {
                        if (newVal) {
                            $sidebar.removeClass('pt-sidebar-collapsed');
                            $sidebar.addClass('pt-sidebar-collapsed-back');//展开
                            /*$timeout(function () {
                                scope.sidebrResize(260);
                            }, 200);*/

                        } else {
                            $sidebar.removeClass('pt-sidebar-collapsed-back');
                            $sidebar.addClass('pt-sidebar-collapsed');//收缩
                            sidebarDivs.removeAttr("style");
                        }
                    }
                });

                //定义组织树数据
                scope.treeList = [];//组织树数据
                scope.gddwdm = AuthUser.getUser().gddwdm;//广东党委代码

                //查询父级架构
                scope.loadParentParty = function () {
                    var dataDzzdm =scope.datadzzdm || AuthUser.getUser().DataDzzdm;//数据权限
                    scope.selectdzzdm = dataDzzdm;
                    if (dataDzzdm == scope.gddwdm) {//有查看全集团数据的权限
                        scope.parentcode = dataDzzdm;
                        scope.dzzdm = "";
                        scope.selectdzzmc = "全校党组织";
                    } else {
                        scope.parentcode = dataDzzdm.substring(0, dataDzzdm.length - 3);
                        scope.dzzdm = dataDzzdm;
                    }

                    $http
                    ({
                        method: 'get', url: '../../api/party/getPartyTreeList', params:
                            {
                                parentCode: scope.parentcode,
                                dzzdm: scope.dzzdm,
                                showlevel: scope.showlevel
                            }
                    }).then(function (result) {
                        var list = [];
                        angular.forEach(result.data.item, function (node, index) {
                            node.P_Code = scope.parentcode;
                            list.push(node);
                        });

                        scope.treeList = list;

                        if (scope.treeList.length == 1 || (scope.treeList.length > 0 && scope.treeList[0].DZZDM == scope.selectdzzdm)) {
                            scope.loadChildParty(scope.treeList[0]);
                        }

                        //默认选中党委
                        if (scope.defaultselected != "" && scope.defaultselected != null && scope.defaultselected != undefined) {
                            //var defaultItem = list.filter(it => it.DZZDM == scope.defaultselected);
                            var defaultItem = $filter("filter")(list, {DZZDM: scope.defaultselected.substring(0, 12)});
                            if (defaultItem.length > 0) {
                                scope.loadChildParty(defaultItem[0]);
                            }

                        }

                    });
                };
                //查询子级架构
                scope.loadChildParty = function (item) {
                    var CHILDSHOW = item.CHILDSHOW > 0 ? 0 : 1;
                    scope.resetActive(item);
                    item.CHILDSHOW = CHILDSHOW;
                    scope.selectdzzdm = item.DZZDM;
                    scope.selectdzzmc = item.DZZMC;
                    if (item.CHILDSHOW > 0 && item.CHILDCOUNT > 0) {
                        $http
                        ({
                            method: 'get', url: '../../api/party/getPartyTreeList', params:
                                {
                                    parentCode: item.DZZDM,
                                    showlevel: scope.showlevel
                                }
                        }).then(function (result) {
                            var list = [];
                            angular.forEach(result.data.item, function (node, index) {
                                node.P_Code = item.P_Code + '.' + item.DZZDM;
                                list.push(node);
                            });
                            item.CHILDPARTYS = list;

                            //默认选中
                            if (item.DZZDM != scope.defaultselected && scope.defaultselected != "" && scope.defaultselected != null && scope.defaultselected != undefined) {
                                var defaultItem = $filter("filter")(list, {DZZDM: scope.defaultselected.substring(0, item.DZZDM.length + 3)});
                                if (defaultItem.length > 0) {
                                    scope.loadChildParty(defaultItem[0]);
                                }

                            }

                        });
                    }
                };

                //重置选中项
                scope.resetActive = function (model) {
                    var codes = model.P_Code.split('.');
                    codes.push(model.DZZDM);
                    angular.forEach(scope.treeList, function (node, index) {
                        var index = $.inArray(node.DZZDM, codes);
                        node.CHILDSHOW = index >= 0 ? 1 : 0;
                        if (node.CHILDPARTYS != null && node.CHILDPARTYS.length > 0) {
                            scope.resetActive_child(node.CHILDPARTYS, codes);
                        }
                    });
                };
                scope.resetActive_child = function (list, codes) {
                    angular.forEach(list, function (node, index) {
                        var index = $.inArray(node.DZZDM, codes);
                        node.CHILDSHOW = index >= 0 ? 1 : 0;
                        if (node.CHILDPARTYS != null && node.CHILDPARTYS.length > 0) {
                            scope.resetActive_child(node.CHILDPARTYS, codes);
                        }
                    });
                };
                //初始化数据
                scope.loadParentParty();
            }
        }
    }).directive("gtCalendar", function ($http, $window, $ocLazyLoad, $timeout) {
        return {
            restrict: 'EA',
            require: '?ngModel',
            link: function (scope, element, attrs, ctrl) {
                $ocLazyLoad.load(['../../scripts/calendar.css', '../../scripts/calendar.js']).then(function () {
                    /*$timeout(function () {
                        var option = scope.$eval(attrs.cdOption);
                        option.height = element[0].offsetWidth - 10;
                        option.width = element[0].offsetWidth;
                        var myCalendar = $(element[0]).calendar(option);
                        //监控option数据变化
                        scope.$watch(
                            attrs["cdOption"],
                            function () {
                                var option = scope.$eval(attrs.cdOption);
                                if (angular.isObject(option)) {
                                    //绘制图表
                                    myCalendar.calendar(option)
                                }
                            },
                            true
                        );
                    }, 100);

                    scope.getDom = function () {
                        return {
                            height: element[0].parentElement.offsetHeight,
                            width: element[0].parentElement.offsetWidth
                        };
                    };
                    //监控图表宽高变化，响应式
                    scope.$watch(
                        scope.getDom,
                        function () {
                            var option = scope.$eval(attrs.cdOption);
                            option.height = element[0].parentElement.offsetWidth - 10;
                            option.width = element[0].parentElement.offsetWidth;
                            var myCalendar = $(element[0]).calendar(option);
                        },
                        true
                    );*/

                    var option = scope.$eval(attrs.cdOption);
                    option.height = option.height || (element[0].offsetWidth - 10);
                    option.width = option.width || element[0].offsetWidth;
                    var myCalendar = $(element[0]).calendar(option);
                    //监控option数据变化
                    scope.$watch(
                        attrs["cdOption"],
                        function () {
                            var option = scope.$eval(attrs.cdOption);
                            if (angular.isObject(option)) {
                                //更新数据
                                myCalendar.calendar("setData", option.data)
                            }
                        },
                        true
                    );

                });
            }
        }
    }).directive('rolePermissionCode', function ($http, AuthUser) {
        var sUrl = '../../api/user/UserPermissionStatus';
        return {
            restrict: 'A',
            link: function (scope, element, attrs, ctrl) {
                //attrs['rolePermissionCode']
                element.hide();

                if (scope.PermissionCodeData == null) {
                    scope.PermissionCodeData = {};
                }

                if (scope.PermissionCodeData[attrs['rolePermissionCode']] == null) {

                    scope.PermissionCodeData[attrs['rolePermissionCode']] = {eles: [element], val: null};

                    $http.get(sUrl, {
                        params: {
                            code: attrs['rolePermissionCode'],
                            roleId: AuthUser.getUser().curRoleId,
                            userDwid: AuthUser.getUser().dwId,
                        }
                    }).then(
                        function (res) {
                            scope.PermissionCodeData[attrs['rolePermissionCode']].val = res.data.success;
                            if (res.data.success) {
                                //一起处理显示状态
                                $ang.forEach(scope.PermissionCodeData[attrs['rolePermissionCode']].eles, function (el) {
                                    el.show();
                                });

                            }
                        }, function (rs) {

                        }
                    );
                } else {
                    //网络返回速度慢过js执行数时，保存在列表上，等返回再一起处理显示状态。
                    scope.PermissionCodeData[attrs['rolePermissionCode']].eles.push(element);
                    if (scope.PermissionCodeData[attrs['rolePermissionCode']].val != null) {
                        if (scope.PermissionCodeData[attrs['rolePermissionCode']].val) {
                            element.show();
                        }
                    }
                }
            }
        };
    }).factory('$desData', ['$filter', function ($filter) {

        var dk = 'MMmmHHss';
        var result = {};
        result.GetToken = function (val) {
            var data = {token: '', tm: new Date()};
            var tms = $filter('date')(data.tm, dk);
            var wkey = CryptoJS.enc.Utf8.parse(tms);
            var encrypted = window.CryptoJS.DES.encrypt(val, wkey, {
                mode: CryptoJS.mode.ECB,
                padding: CryptoJS.pad.Pkcs7
            }).toString();
            data.token = encrypted.toString();
            return data;
        };
        return result;
    }]).directive("bsDatetimepicker", ['$timeout', function ($timeout) {
        return {
            require: '?ngModel',
            restrict: 'AE',
            scope: {
                ngModel: '=',
                beginDate: '@',
                endDate: '@',
                minView: '@',// 最精确的时间  0-4越小越精确  0-分钟; 1-小时; 2-天; 3-月 ; 4-年
                maxView: '@',//最高能展示的时间，默认为年
                startView: '@', //— 选完时间首先显示的视图 0:分钟；1：小时；2：天：3：月；4：年
                format: '@',//默认显示月视图，不显示时分秒
                todayBtn: '@',//今天按钮是否显示， 默认显示
                todayHighlight: '@',//当天显示是否高亮，默认显示
                showMeridian: '@',//是否显示上下午，默认不显示
                weekStart: '@',// 一周从哪一天开始显示,默认为7，表示从周日开始显示
                daysOfWeekDisabled: '@', //一周的周几不能选择[0,4,6]
                forceParse: '@',//强制解析,输入的可能不正规，但是它胡强制尽量解析成你规定的格式（format） 默认解析
                autoclose: '@'//选完时间后是否自动关闭 ,默认true，表示关闭
            },
            link: function (scope, element, attr, ngModel) {
                $timeout(function () {
                    element.datetimepicker({
                        showMeridian: scope.showMeridian ? scope.showMeridian : false,
                        todayBtn: scope.todayBtn ? scope.todayBtn : true,
                        todayHighlight: scope.todayHighlight ? scope.todayHighlight : true,
                        weekStart: scope.weekStart ? scope.weekStart : 0,
                        daysOfWeekDisabled: scope.daysOfWeekDisabled ? scope.daysOfWeekDisabled : [],
                        forceParse: scope.forceParse ? scope.forceParse : true,
                        autoclose: scope.autoclose ? scope.autoclose : true, //
                        minView: scope.minView ? scope.minView : 2,
                        maxView: scope.maxView ? scope.maxView : 4,
                        startView: scope.startView ? scope.startView : 2,
                        format: scope.format ? scope.format : 'yyyy-mm-dd',

                        inline: true,
                        language: 'cn',
                        keyboardNavigation: true,//方向键改变日期
                        /*onSelect: function(dateText) {
                            console.log(dateText)
                            var modelPath = $(this).attr('ng-model');
                            putObject(modelPath, scope, dateText);
                            scope.$apply();
                        },*/
                    });
                    element.on('click', function (e) {//设置最大最小时间限制
                        e.currentTarget.blur();
                        if (attr.hasOwnProperty('beginDate')) {
                            element.datetimepicker('setStartDate', attr.beginDate);
                        }
                        if (attr.hasOwnProperty('endDate')) {
                            element.datetimepicker('setEndDate', attr.endDate);
                        }
                    });
                }, 0)
            }
        }
    }]).directive('selectFilter', function ($ocLazyLoad, $parse) {
        return {
            restrict: 'EA',
            require: '?ngModel',
            link: function (scope, element, attrs, ctrl) {
                $ocLazyLoad.load('../../scripts/jqueryPlugins/selectFilter.js').then(function () {

                    element.selectFilter({
                        callBack: function (val) {
                            //返回选择的值
                            console.log(val + '-是返回的值');
                            if (!ctrl) {
                                return;
                            }
                            //ctrl.$modelValue = val;

                            element[0].value = val;
                            //更新模型
                            $parse(attrs['ngModel']).assign(scope, element[0].value);
                            scope.$apply();

                        }
                    });

                });
            }
        }
    }).provider('$bsRouterState', function () {

        var defaults = this.defaults = {
            routeTypes: ['url', 'tab'],
            activeRouteType: 'tab',
            activeTabUrl: 'tabsIndex',
            activeRouteName: 'homeTabs',
            urlToTabRex: 'home.',
            initTabName: 'home.mainindex'
        };

        var routes = [], tabs = [], iniComplete = false;
        tabs.activeTab = '';

        this.copyUrlState = function (urlStates) {
            angular.forEach(urlStates, function (val, key) {
                if (key.indexOf(defaults.urlToTabRex) >= 0) {
                    this.push(val.self);
                }
            }, routes);
        };

        this.$get = function ($state, $filter, $http, $timeout) {

            var $link = {};

            var showTab = function (name, params, reload) {

                //当没有加载完就显示首页时等齐
                /*
                var addTitles=$filter('filter')(routes, function (route) {
                    return route.title!=null;
                });*/
                if (!iniComplete) {
                    $timeout(function () {
                        showTab(name, params, reload);
                    }, 100);
                    return false;
                }

                var existTabs = $filter('filter')(tabs, function (t) {
                    return t.name == name;
                });

                if (reload) {
                    var indexTab = tabs.indexOf(existTabs[0]);

                    if (indexTab >= 0) {
                        tabs.splice(indexTab, 1);
                        //existTabs.length=0;
                        $timeout(function () {
                            showTab(name, params);
                        }, 100);
                        return false;
                    }
                }

                if (existTabs.length <= 0) {
                    var curRoute = $filter('filter')(routes, function (route) {
                        return route.name == name && route.title
                    });

                    if (curRoute.length > 0) {
                        var newTabs = angular.copy(curRoute[0]);
                        if (!newTabs.params) {
                            newTabs.params = {};
                        }
                        angular.extend(newTabs.params, params);
                        tabs.push(newTabs);
                        //$link.params=params;
                        tabs.activeTab = name;
                    }
                } else {
                    tabs.activeTab = name;
                }

                return true;
            };
            var closeTab = function (tab) {
                var indexTab = tabs.indexOf(tab.panedata);

                if (indexTab >= 0) {
                    tabs.splice(indexTab, 1);
                }
            };

            var closeTabName = function (tabName) {
                var existTabs = $filter('filter')(tabs, function (t) {
                    return t.name == tabName;
                });
                angular.forEach(existTabs, function (eTab) {
                    var tabScope = {panedata: eTab};
                    closeTab(tabScope);
                });
            };

            var buildTabRoute = function (menuList) {
                angular.forEach(routes, function (route) {
                    route.canClose = true;
                    var menus = $filter('filter')(menuList, function (menu) {
                        return menu.menuno == route.name;
                    });
                    if (menus.length > 0) {
                        route.title = menus[0].menuname;
                    } else {
                        route.title = null;
                    }
                });
                setCloseState(defaults.initTabName, false);
                iniComplete = true;
                /*
                var initTabs = $filter('filter')(routes, {name: defaults.initTabName});
                angular.forEach(initTabs, function (it) {
                    it.canClose = false;
                });
                showTab(defaults.initTabName, {});
                */

            };

            var setCloseState = function (tabName, canClose) {
                var initTabs = $filter('filter')(routes, function (t) {
                    return t.name == tabName;
                });
                angular.forEach(initTabs, function (it) {
                    it.canClose = canClose;
                });
            };

            //var setPath

            var loadTabMenu = function () {
                iniComplete = false;
                $http.get('../../api/menumanage/tabMenuList').then(function (req) {
                    if (req.data.success) {
                        buildTabRoute(req.data.item);
                    }

                });

            };


            $link.defaults = defaults;
            $link.go = function (name, urlData, reload) {
                if (this.$getRouteType() == 'tab') {
                    //$link.params=urlData;
                    showTab(name, urlData, reload);
                } else {
                    $state.go(name, urlData);
                }
            };
            $link.$getRouteType = function () {
                return $state.is(defaults.activeRouteName) ? defaults.routeTypes[1] : defaults.routeTypes[0];
            };

            $link.buildTabRoute = buildTabRoute;

            $link.loadTabMenu = loadTabMenu;

            $link.tabs = tabs;

            $link.$setCloseState = setCloseState;
            $link.$showTab = showTab;
            $link.$closeTab = closeTab;
            $link.$closeTabName = closeTabName;
            $link.$params = function (scope) {

                if ($link.$getRouteType() == 'tab') {
                    return scope.panedata.params;
                } else {
                    return $state.params;
                }

            };

            return $link;
        }
    }).directive('bsUiSref', function ($bsRouterState) {
        var directiveObject = {
            scope: true,
            link: function postLink(scope, element, attrs, controllers) {

                element.bind('click', function () {
                    scope.$apply(function () {

                        var uiSref = attrs['bsUiSref'];
                        var dataJson = uiSref.match(/\((.+?)\)/);
                        if (dataJson) {
                            var nameJson = uiSref.match(/(.+?)\(/);
                            $bsRouterState.go(nameJson[1], eval(dataJson[0]));
                        } else {
                            $bsRouterState.go(uiSref, {});
                        }

                    });

                });
            }
        };

        return directiveObject;
    }).directive('activePartytree', ['$timeout', function ($timeout) {

        var activateFun = function (scope, $element) {
            var scrollTop = 0;
            var el = $element.find("div");
            angular.forEach(el, function (item) {
                if (item.className == "party_active") {
                    scrollTop = item.offsetTop;
                }
            });
            $element[0].scrollTop = scrollTop;
        };

        var directiveObject = {
            restrict: 'AC',
            link: function (scope, element, attr, controller) {
                $timeout(function () {
                    activateFun(scope, element);
                }, 200)

            }

        };
        return directiveObject;
    }]).directive('selectedPartyname', function ($compile) {
        var directiveObject = {
            restrict: 'EAC',
            template: function (tElement, tAttrs) {
                var html = '<div class="select-party">当前选中组织：{{selectdzzmc}}<span ng-if="ptotal!=null">，共有{{ptotal}}{{unit}}。</span></div>';
                return html;
            },
            scope: {
                selectdzzmc: '=?',
                ptotal: '=?',
                unit: '=?'
            },
            link: function (scope, element, attr, controller) {

            }
        };

        return directiveObject;
    }).factory('$uuid', ['$filter', function ($filter) {
        var result = {};
        result.getUUID = function () {
            var d = new Date().getTime();
            var uuid = 'xxxxxxxx-xxxx-4xxx-yxxx-xxxxxxxxxxxx'.replace(/[xy]/g, function (c) {
                var r = (d + Math.random() * 16) % 16 | 0;
                d = Math.floor(d / 16);
                return (c == 'x' ? r : (r & 0x7 | 0x8)).toString(16);
            });
            return uuid;
        };
        return result;
    }]).directive("zeroTableHeight", ['$timeout', function ($timeout) {

        var f_time = function (element) {

            var $tarTable = element.parents('table');
            var $sourceTable = element.parents('.zero-list-table-panel').find(".zero-source-table-div table");

            var $tarTr = $tarTable.find('tr');
            var $sourceTr = $sourceTable.find('tr');

            for (var i = 0; i < $tarTr.length; i++) {
                var $sourceTd = $sourceTr.eq(i).find('td:first');
                var $tarTd = $tarTr.eq(i).find('td:first');
                if ($sourceTd.height() >= $tarTd.height()) {
                    $tarTd.height($sourceTd.height());
                } else {
                    $sourceTd.height($tarTd.height());
                }
            }

            /*
            var $table=element.parents('table');
            var $thead=$table.find('thead');
            var t_width=0;

            if($table.parent('.zero-source-table-div').has()){
                var $divSourceDiv=$('<div class="zero-source-table-div"></div>');
                var $divTargetTable=$('<table class="zero-target-table"><thead></thead><tbody></tbody></table>');
                $table.before($divSourceDiv);
                $table.before($divTargetTable);
                $table.appendTo($divSourceDiv);

                $.each($thead.find('th[zero-table-th]').toArray().reverse(),function (i,th){
                    t_width+=th.offsetWidth;
                    var thIndex=th.index();
                    var $tTh=$divTargetTable.find("thead tr").has()?$('<tr></tr>').appendTo($divTargetTable.find("thead")):$divTargetTable.find("thead tr").first();

                    $tTh.append(th);

                    $.each($table.find("tbody tr"),function (i,tr) {
                        var $tTr=$divTargetTable.find("tbody tr").eq(i).has()?$('<tr></tr>').appendTo($divTargetTable.find("thead")):$divTargetTable.find("tbody tr").eq(i);
                        tr.find('td').eq(thIndex).appendTo($tTr);
                    });

                });

                $divTargetTable.width(t_width);


            }*/
        };

        var directiveObject = {
            restrict: 'AC',
            link: function (scope, element, attr, controller) {
                if (scope.$last === true) {
                    $timeout(function () {
                        f_time(element);
                    }, 600);
                }
            }
        };
        return directiveObject;
    }]).filter('trustAsHtml',
        [
            '$sce', function ($sce) {
            return function (text) {
                return $sce.trustAsHtml(text);
            }
        }]).directive('panelTitle', function ($compile) {
        var directiveObject = {
            restrict: 'EAC',
            template: function (tElement, tAttrs) {
                var html = '<div class="dj-paneltitle" ><div class="title-line"></div><span class="title-text">{{title}}</span><div class="title-tool" ng-transclude></div></div>';
                return html;
            },
            scope: {
                title: '=?'
            },
            transclude: true,
            link: function (scope, element, attr, controller) {

            }
        };

        return directiveObject;
    }).directive('foldPartytree', function ($compile, $rootScope) {
        var directiveObject = {
            restrict: 'EA',
            require: '?ngModel',
            templateUrl: '../js/template/modal_foldPartytree.html',
            scope: {
                isunfold: '=?',
            },
            link: function (scope, element, attr, controller) {
                scope.isunfoldfun = function () {
                    scope.isunfold = !scope.isunfold;
                    //scope.$emit('menudatas.toggle', !scope.isunfold);
                    $rootScope.menuToggle = !scope.isunfold;
                }

                scope.$watch("isunfold", function () {
                    $rootScope.menuToggle = !scope.isunfold;
                });
            }
        };

        return directiveObject;
    }).directive("linkCondition", function ($http, $ocLazyLoad, AuthUser, $filter) {
        return {
            restrict: 'EA',
            require: 'ngModel',
            replace: true,
            //作用域
            scope: {
                ngModel: '=',
                sourceList: '=',
                valueField: '@',
                textField: '@',
                defaultCount: '@',
                alwaysSelectAll: '=',
                singleMode: '@'
            },
            templateUrl: '../js/template/linkcondition.html',
            link: function (scope, elemnet, attr, controller) {
                scope.isShowAll = true;
                scope.showText = "展开";
                scope.selected = [];
                scope.limit = parseInt(scope.defaultCount);

                if (scope.limit != null) {
                    scope.isShowAll = false;
                }

                scope.$watch('isShowAll', function (newVal, oldVal) {
                    if (newVal) {
                        scope.showText = "收起";
                    } else {
                        scope.showText = "展开";
                    }
                });

                scope.isExists = function (val) {
                    if (scope.selected.filter(function (x) {
                        return x == val;
                    }).length > 0) {
                        return true;
                    } else {
                        return false;
                    }
                };
                scope.onClick = function (val) {
                    if (scope.alwaysSelectAll) {
                        scope.selected = [];
                    } else {
                        if (scope.isExists(val)) {
                            scope.selected = scope.selected.filter(function (x) {
                                return x != val;
                            });
                        } else {
                            if (scope.singleMode == "1") {//单选
                                scope.selected = new Array([val]);
                                scope.ngModel = val;
                            } else {
                                scope.selected.push(val);
                            }
                        }
                    }
                };
                scope.$watch('selected.length', function (newVal, oldVal) {
                    if (newVal != null && newVal != 0) {
                        if (angular.isArray(scope.ngModel)) {
                            scope.ngModel = scope.selected;
                        } else {
                            scope.ngModel = scope.selected.join(',');
                        }
                    } else {
                        if (angular.isArray(scope.ngModel)) {
                            scope.ngModel = [];
                        } else {
                            scope.ngModel = null;
                        }
                    }
                    //$scope.loadData();
                });
                scope.$watch('ngModel', function (newVal, oldVal) {
                    if (angular.isArray(newVal)) {
                        scope.selected = newVal;
                    } else if (newVal != null) {
                        scope.selected = newVal.split(",");
                    } else {
                        scope.selected = [];
                    }
                });
            }
        }
    }).directive("workTabs", function ($http, $ocLazyLoad, AuthUser, $filter, $bsRouterState, $timeout) {
        return {
            restrict: 'EA',
            require: '?ngModel',
            //作用域
            scope: {
                worktype: '=',//1党支部，2党委
                dzzdm: '=',//党组织编码
                defaulttab: '=',//默认加载tab数据
                removetab: '='//排除tab，多个用逗号分隔，如：'1,2'
            },
            templateUrl: '../js/template/modal_worktabs.html',
            link: function (scope, elemnet) {
                scope.pageList = [];
                scope.activeTab = scope.defaulttab || 1;

                let pageList = [];
                if (scope.worktype == 1) {
                    pageList = [
                        // {id: 1, title: '创岗建区情况', url: '../main/home/tabpage/cgjq.html'},
                        {id: 1, title: '三会一课情况', url: '../main/home/tabpage/shykqk.html'},
                        {id: 3, title: '党费收缴情况', url: '../main/home/tabpage/dfsj.html'},
                        {id: 4, title: '发展党员情况', url: '../main/home/tabpage/dyfz.html'},
                        {id: 5, title: '主题党日情况', url: '../main/home/tabpage/ztdr.html'},
                        // {id: 6, title: '党建工作成果情况', url: '../main/home/tabpage/djcg.html'},
                        // {id: 7, title: '党建考评情况', url: '../main/home/tabpage/djkp_dzb.html'},
                        // {id: 8, title: '职工思想动态情况', url: '../main/home/tabpage/zgsxdt.html'},
                        // {id: 9, title: '党内评先情况', url: '../main/home/tabpage/dnpx.html'},
                        {id: 10, title: '党纪处分情况', url: '../main/home/tabpage/djcf.html'}];
                } else {
                    pageList = [
                        {id: 1, title: '党委委员情况', url: '../main/home/tabpage/dwqk.html'},
                        {id: 2, title: '三会一课情况', url: '../main/home/tabpage/shykqk.html'},
                        // {id: 3, title: '中心组学习', url: '../main/home/tabpage/zxzxx.html'},
                        // {id: 4, title: '领导人员5+3', url: '../main/home/tabpage/ldry.html'},
                        // {id: 5, title: '创岗建区', url: '../main/home/tabpage/cgjq.html'},
                        {id: 6, title: '党费收缴', url: '../main/home/tabpage/dfsj.html'},
                        // {id: 7, title: '发展党员', url: '../main/home/tabpage/dyfz.html'},
                        {id: 8, title: '主题党日', url: '../main/home/tabpage/ztdr.html'},
                        // {id: 9, title: '党内品牌', url: '../main/home/tabpage/dnpp.html'},
                        // {id: 10, title: '党建工作成果情况', url: '../main/home/tabpage/djcg.html'},
                        // {id: 11, title: '党建考评情况', url: '../main/home/tabpage/djkp.html'},
                        // {id: 12, title: '职工思想动态情况', url: '../main/home/tabpage/zgsxdt.html'},
                        // {id: 13, title: '党内评先情况', url: '../main/home/tabpage/dnpx.html'},
                        {id: 14, title: '党纪处分情况', url: '../main/home/tabpage/djcf.html'}];
                }

                if (scope.removetab != null && scope.removetab != undefined) {
                    scope.pageList = pageList.filter(function (item) {
                        if (scope.removetab.split(',').indexOf(item.id.toString()) < 0) {
                            return item;
                        }
                    });
                } else {
                    scope.pageList = pageList;
                }

                scope.isSelected = function (checkedTab) {
                    return scope.activeTab === checkedTab;
                };
                scope.selectTab = function (setTab) {
                    scope.activeTab = setTab;
                    if (scope.dzzdm != '' && scope.dzzdm != null && scope.dzzdm != undefined) {
                        if (scope.worktype == 1) {
                            switch (setTab) {
                                case 1:
                                    scope.loadCgjqTotalList();
                                    break;
                                case 2:
                                    scope.loadShykTotal();
                                    break;
                                case 3:
                                    scope.loadPartyDuesList(1);
                                    break;
                                case 4:
                                    scope.loadJoinPartyUserList();
                                    break;
                                case 5:
                                    scope.loadZtdrList();
                                    break;
                                case 6:
                                    scope.loadDjcgList();
                                    break;
                                case 7:
                                    scope.loadDjkpList_dzb();
                                    break;
                                case 8:
                                    scope.loadThoughtTotal();
                                    break;
                                case 9:
                                    scope.loadDnpxList();
                                    break;
                                case 10:
                                    scope.loadDjcfList();
                                    break;
                            }
                        } else {
                            switch (setTab) {
                                case 1:
                                    scope.loadGradeUserList();
                                    break;
                                case 2:
                                    scope.loadShykTotal();
                                    break;
                                case 3:
                                    scope.loadZxzxxTotalList();
                                    break;
                                case 4:
                                    scope.loadUserLeaderList();
                                    break;
                                case 5:
                                    scope.loadCgjqTotalList();
                                    break;
                                case 6:
                                    scope.loadPartyDuesList(2);
                                    break;
                                case 7:
                                    scope.loadJoinPartyUserList();
                                    break;
                                case 8:
                                    scope.loadZtdrList();
                                    break;
                                case 9:
                                    scope.loadDnppList();
                                    break;
                                case 10:
                                    scope.loadDjcgList();
                                    break;
                                case 11:
                                    scope.loadDjkpList();
                                    break;
                                case 12:
                                    scope.loadThoughtTotal();
                                    break;
                                case 13:
                                    scope.loadDnpxList();
                                    break;
                                case 14:
                                    scope.loadDjcfList();
                                    break;
                            }
                        }
                    }
                };

                scope.toRight = function ($event) {
                    var redmenu = $($event.target).closest('.menubody').find('.redmenu');
                    var left = redmenu.scrollLeft();
                    redmenu.scrollLeft(left + 200);
                };
                scope.toLeft = function ($event) {
                    var redmenu = $($event.target).closest('.menubody').find('.redmenu');
                    var left = redmenu.scrollLeft();
                    redmenu.scrollLeft(left - 200);
                };

                //tabs
                {
                    scope.shykTotalList = [];
                    //会议统计
                    scope.loadShykTotal = function () {
                        $http
                        ({
                            method: 'get', url: '../../api/shyk/getMeetingTotalList', params: {
                                pageindex: 1,
                                pagesize: 20,
                                ssdzzdm: scope.dzzdm,//党组织代码
                                year: new Date().getFullYear(),
                                quarter: parseInt(new Date().getMonth() / 3) + 1
                            }
                        }).then(function (result) {
                            scope.shykTotalList = result.data.item.list;
                        }, function (resp) {
                        });
                    };

                    //领导班子成员
                    scope.gradeUserList = [];
                    scope.loadGradeUserList = function () {
                        $http
                        ({
                            method: 'get', url: '../../api/grade/getMaxGradeUserList', params: {
                                'pageindex': 1,
                                'pagesize': 50,
                                ssdzzdm: scope.dzzdm
                            }
                        }).then(function (result) {
                            scope.gradeUserList = result.data.item.list;
                        });
                    };

                    //创岗建区
                    scope.cgjqTotalList = [];
                    scope.cgjqTotalData = {
                        YEAR: new Date().getFullYear(),
                        POSTCOUNT: 0,
                        AREACOUNT: 0
                    };
                    scope.loadCgjqTotalList = function () {
                        $http
                        ({
                            method: 'get', url: '../../api/bigdata/getCGJQTotal', params: {
                                dzzdm: scope.dzzdm,//党组织代码
                                year: scope.cgjqTotalData.YEAR
                            }
                        }).then(function (res) {
                            scope.cgjqTotalData.POSTCOUNT = res.data.POSTCOUNT;
                            scope.cgjqTotalData.AREACOUNT = res.data.AREACOUNT;

                        }, function (resp) {

                        });

                        $http
                        ({
                            method: 'get', url: '../../api/bigdata/getCGJQTotalList', params: {
                                dzzdm: scope.dzzdm,//党组织代码
                                year: scope.cgjqTotalData.YEAR
                            }
                        }).then(function (res) {
                            scope.cgjqTotalList = res.data;

                        }, function (resp) {

                        });
                    };

                    //党费收缴情况
                    scope.partyDuesTotal = {
                        YEAR: new Date().getFullYear(),
                        MONTH: new Date().getMonth() + 1,
                        PAYINCOUNT: 0,
                        PAYABLEMONEY: 0,
                        PAYINMONEY: 0,
                        DYZS: 0
                    };
                    scope.loadPartyDuesList = function (type) {
                        $http.get("../../api/publicity/getDuesPayTotal", {
                            params: {
                                'pageindex': 1,
                                'pagesize': 1,
                                'year': scope.partyDuesTotal.YEAR,
                                'dzzdm': scope.dzzdm,
                                'month': scope.partyDuesTotal.MONTH
                            }
                        }).then(function (result) {
                            if (result.data.item.list.length > 0) {
                                scope.partyDuesTotal = result.data.item.list[0];
                                scope.partyDuesTotal.MONTH = new Date().getMonth() + 1;
                            }

                        }, function () {

                        });
                    };

                    //发展党员情况
                    scope.joinPartyUserList = [];
                    scope.tab_dyfzData = {dys: 0, sqrds: 0, rdjjfzs: 0, fzdx: 0, ybdys: 0};
                    scope.loadJoinPartyUserList = function () {
                        $http
                        ({
                            method: 'get', url: '../../api/partyExpand/getJoinUserList', params: {
                                'pageindex': 1,
                                'pagesize': 5,
                                partyCode: scope.dzzdm
                            }
                        }).then(function (result) {
                            scope.joinPartyUserList = result.data.item.list;
                        });

                        $http
                        ({
                            method: 'get', url: '../../api/partyExpand/getJoinUserTotalList', params: {
                                pageindex: 1,
                                pagesize: 10,
                                ssdzzdm: scope.dzzdm,//党组织代码
                            }
                        }).then(function (result) {
                            if (result.data.item.list.length > 0) {
                                var data = result.data.item.list[0];
                                scope.tab_dyfzData.dys = data.TOTALCOUNT;
                                scope.tab_dyfzData.ybdys = data.YBDY;
                                scope.tab_dyfzData.rdjjfzs = data.JJFZ;
                                scope.tab_dyfzData.sqrds = data.SQRD;
                                scope.tab_dyfzData.fzdx = data.FZDX;
                            }

                        }, function (resp) {

                        });
                    };

                    //职工思想动态
                    scope.thoughtTotal = {
                        YEAR: new Date().getFullYear(),
                        MONTH: new Date().getMonth() + 1,
                        NUM_THOUGHTTYPE1: 0,
                        NUM_THOUGHTTYPE2: 0,
                        NUM_THOUGHTTYPE3: 0,
                        NUM_THOUGHTTYPE4: 0,
                        NUM_THOUGHTTYPE5: 0,
                        NUM_THOUGHTTYPE6: 0,
                        NUM_THOUGHTTYPE7: 0,
                        NUM_THOUGHTTYPE8: 0
                    };
                    scope.loadThoughtTotal = function () {
                        $http
                        ({
                            method: 'get', url: '../../api/publicity/getThoughtTotal', params: {
                                'pageindex': 1,
                                'pagesize': 10,
                                partyCode: scope.dzzdm,
                                year: new Date().getFullYear(),
                                month: new Date().getMonth() + 1
                            }
                        }).then(function (result) {
                            if (result.data.item.list.length > 0) {
                                scope.thoughtTotal = result.data.item.list[0];
                            }
                        });
                    };

                    //领导人员5+3情况
                    scope.userLeaderList = {};
                    scope.loadUserLeaderList = function () {
                        $http
                        ({
                            method: 'get', url: '../../api/publicity/getUserLeaderTotalList', params: {
                                'pageindex': 1,
                                'pagesize': 5,
                                partyCode: scope.dzzdm,
                                beginTime: new Date().getFullYear() + "-01-01",
                                endTime: new Date().getFullYear() + "-12-31"
                            }
                        }).then(function (result) {
                            scope.userLeaderList = result.data.item.list;
                        });
                    };

                    //主题党日
                    scope.ztdrList = {};
                    scope.loadZtdrList = function () {
                        $http
                        ({
                            method: 'get', url: '../../api/partyTowExt/getZtdrxxList', params: {
                                'pageindex': 1,
                                'pagesize': 5, dzzdm: scope.dzzdm
                            }
                        }).then(function (result) {
                            scope.ztdrList = result.data.item.list;
                        });
                    };

                    //党内品牌
                    scope.dnppList = {};
                    scope.loadDnppList = function () {
                        $http
                        ({
                            method: 'get', url: '../../api/partyTowExt/getBrandList', params: {
                                'pageindex': 1,
                                'pagesize': 5, partyCode: scope.dzzdm
                            }
                        }).then(function (result) {
                            scope.dnppList = result.data.item.list;
                        });
                    };

                    //党建工作成果
                    scope.djcgList = {};
                    scope.loadDjcgList = function () {
                        $http
                        ({
                            method: 'get', url: '../../api/partyTowExt/getResultmgList', params: {
                                'pageindex': 1,
                                'pagesize': 5, partyCode: scope.dzzdm
                            }
                        }).then(function (result) {
                            scope.djcgList = result.data.item.list;
                        });
                    };

                    //党建考评
                    scope.djkpList = {};
                    scope.loadDjkpList = function () {
                        $http
                        ({
                            method: 'get', url: '../../api/partyTowExt/getDjkpxxList', params: {
                                'pageindex': 1,
                                'pagesize': 5,
                                ssdzzdm: scope.dzzdm
                            }
                        }).then(function (result) {
                            scope.djkpList = result.data.item.list;
                        });
                    };
                    //党建考评-党支部
                    scope.djkpData = {YEAR: new Date().getFullYear()};
                    scope.loadDjkpList_dzb = function () {
                        $http
                        ({
                            method: 'get', url: '../../api/partyTowExt/getDjkpxxList', params: {
                                'pageindex': 1,
                                'pagesize': 5,
                                ssdzzdm: scope.dzzdm,
                                year: new Date().getFullYear()
                            }
                        }).then(function (result) {
                            if (result.data.item.list.length > 0) {
                                scope.djkpData = result.data.item.list[0];
                            }
                        });
                    };

                    //党内评先
                    scope.dnpxList = {};
                    scope.loadDnpxList = function () {
                        $http
                        ({
                            method: 'get', url: '../../api/partyTowExt/getDnpxxxList', params: {
                                'pageindex': 1,
                                'pagesize': 5,
                                pxlx: 2,
                                ssdzzdm: scope.dzzdm
                            }
                        }).then(function (result) {
                            scope.dnpxList = result.data.item.list;
                        });
                    };

                    //党纪处分
                    scope.djcfList = {};
                    scope.loadDjcfList = function () {
                        $http
                        ({
                            method: 'get', url: '../../api/partyTowExt/getJlcfxxList', params: {
                                'pageindex': 1,
                                'pagesize': 5,
                                dzzdm: scope.dzzdm
                            }
                        }).then(function (result) {
                            scope.djcfList = result.data.item.list;
                        });
                    };


                    //创岗建区
                    scope.zxzxxTotalList = [];

                    scope.loadZxzxxTotalList = function () {
                        $http
                        ({
                            method: 'get', url: '../../api/bigdata/getZXZXXTotal', params: {
                                ssdzzdm: scope.dzzdm,//党组织代码
                                year: new Date().getFullYear()
                            }
                        }).then(function (result) {
                            scope.zxzxxTotalList = result.data;

                        }, function (resp) {

                        });
                    };

                }

                //更多链接
                {
                    //三会一课
                    scope.showMeeting = function (item, type, isQuarter) {
                        var url = "home.shykList";
                        var beginMonth = item.QUARTER * 3 - 2 + type;
                        var beginTime = item.YY + "-" + (beginMonth < 10 ? ("0" + beginMonth) : beginMonth) + "-01";
                        var endTime = "";

                        endTime = moment(new Date(beginTime)).add(isQuarter ? 2 : 0, 'month').endOf('month').format("YYYY-MM-DD");

                        $bsRouterState.$closeTabName(url);
                        $timeout(function () {
                            $bsRouterState.go(url, {
                                begintime: beginTime,
                                endtime: endTime,
                                dzzdm: item.DZZDM,
                                dzzmc: item.DZZMC,
                                shykType: item.SHYKTYPE
                            });
                        }, 100);
                    };

                    //领导人员5+3
                    scope.showLeader = function (xm, type) {
                        $bsRouterState.$closeTabName("home.userLeaderList");
                        $timeout(function () {
                            $bsRouterState.go('home.userLeaderList', {
                                leaderType: type,
                                xm: xm,
                                beginTime: new Date().getFullYear() + '-01-01',
                                endTime: new Date().getFullYear() + '-12-31',
                                dzzdm: scope.dzzdm
                            });
                        }, 100);
                    };

                    //创岗建区
                    scope.showPostArea = function (cgjqType) {
                        $bsRouterState.$closeTabName("home.cgjqScoreList");
                        $timeout(function () {
                            $bsRouterState.go('home.cgjqScoreList', {
                                gqtype: 1,
                                cgjqType: cgjqType,
                                year: new Date().getFullYear(),
                                dzzdm: scope.dzzdm
                            });
                        }, 100);
                    };

                    //思想动态
                    scope.showThought = function (qtype, destroyType, handleState) {
                        $bsRouterState.$closeTabName("home.userThoughtList");
                        $timeout(function () {
                            $bsRouterState.go('home.userThoughtList', {
                                qtype: qtype,
                                destroyType: destroyType,
                                handleState: handleState,
                                bt: moment(new Date()).startOf("month").format("YYYY-MM-DD"),
                                et: moment(new Date()).endOf("month").format("YYYY-MM-DD"),
                                dzzdm: scope.dzzdm
                            });
                        }, 100);
                    };

                    scope.showDues = function () {
                        $bsRouterState.$closeTabName("home.partyDuesList");
                        $timeout(function () {
                            $bsRouterState.go('home.partyDuesList', {
                                dzzdm: scope.dzzdm
                            });
                        }, 100);
                    };

                    scope.showUserExpand = function (pflowid) {
                        $bsRouterState.$closeTabName("home.pe_UserList");
                        $timeout(function () {
                            $bsRouterState.go('home.pe_UserList', {
                                pflowid: pflowid,
                                dzzdm: scope.dzzdm
                            });
                        }, 100);
                    };

                    scope.showUser = function () {
                        $bsRouterState.$closeTabName("home.partyUserList");
                        $timeout(function () {
                            $bsRouterState.go('home.partyUserList', {
                                dzzdm: scope.dzzdm
                            });
                        }, 100);
                    };

                    scope.showDjkp = function () {
                        $bsRouterState.$closeTabName("home.djkpxxDZB");
                        $timeout(function () {
                            $bsRouterState.go('home.djkpxxDZB', {
                                year: new Date().getFullYear(),
                                dzzdm: scope.dzzdm
                            });
                        }, 100);
                    };


                    scope.showMore_dwqk = function () {
                        $bsRouterState.$closeTabName("home.gradeUserList");
                        $timeout(function () {
                            $bsRouterState.go('home.gradeUserList', {
                                dzzdm: scope.dzzdm
                            });
                        }, 100);
                    };

                    scope.showMore_djcf = function () {
                        $bsRouterState.$closeTabName("home.jlcfxx");
                        $timeout(function () {
                            $bsRouterState.go('home.jlcfxx', {
                                dzzdm: scope.dzzdm
                            });
                        }, 100);
                    };

                    scope.showMore_djcg = function () {
                        $bsRouterState.$closeTabName("home.DjResultMgList");
                        $timeout(function () {
                            $bsRouterState.go('home.DjResultMgList', {
                                dzzdm: scope.dzzdm
                            });
                        }, 100);
                    };

                    scope.showMore_djkp = function () {
                        $bsRouterState.$closeTabName("home.djkpxx");
                        $timeout(function () {
                            $bsRouterState.go('home.djkpxx', {
                                dzzdm: scope.dzzdm
                            });
                        }, 100);
                    };

                    scope.showMore_dnpp = function () {
                        $bsRouterState.$closeTabName("home.brandMgList");
                        $timeout(function () {
                            $bsRouterState.go('home.brandMgList', {
                                dzzdm: scope.dzzdm
                            });
                        }, 100);
                    };

                    scope.showMore_dnpx = function () {
                        $bsRouterState.$closeTabName("home.dnpxxx");
                        $timeout(function () {
                            $bsRouterState.go('home.dnpxxx', {
                                dzzdm: scope.dzzdm
                            });
                        }, 100);
                    };

                    scope.showMore_ztdr = function () {
                        $bsRouterState.$closeTabName("home.ztdrxx");
                        $timeout(function () {
                            $bsRouterState.go('home.ztdrxx', {
                                dzzdm: scope.dzzdm
                            });
                        }, 100);
                    };


                    scope.showMore_zxzxx = function (xm) {
                        $bsRouterState.$closeTabName("home.LearningSituation");
                        $timeout(function () {
                            $bsRouterState.go('home.LearningSituation', {
                                dzzdm: scope.dzzdm,
                                xm: xm,
                                beginTime: new Date().getFullYear() + '-01-01',
                                endTime: new Date().getFullYear() + '-12-31'
                            });
                        }, 100);
                    };

                }

                scope.selectTab(scope.activeTab);
            }
        }
    }).directive('linkTag', function () {
        return {
            restrict: 'EA',
            template: function (tElement, tAttrs) {
                var _html = '';
                _html += '<a>' + tAttrs.title + '</a>';
                return _html;
            },
            replace: false,
            controller: function ($scope, $element, $attrs, $bsRouterState, $timeout) {

                $element.on("click", function () {
                    $bsRouterState.$closeTabName("home." + $attrs.url);
                    $timeout(function () {
                        $bsRouterState.go('home.' + $attrs.url, angular.fromJson($attrs.params));
                    }, 100);
                })
            }
        };
    }).directive('imgComponent', function ($state, $http, $bsRouterState, $uuid, $bsfiles) {
        return {
            restrict: 'EA',
            require: '?ngModel',
            //作用域
            scope: {
                filerefid: '=',
                filetypeid: '=',
                readonly: '=',
                ismulti: "=?",
                height: '=?',
                imgList: '=?',
                width: '=?'
            },
            //html
            templateUrl: '../js/template/modal-showimg.html',
            //link函数
            link: function (scope) {
                scope.modalId = $uuid.getUUID();
                scope.img = {rotate: 0, scale: 1};
                scope.imgList = [];
                scope.showIndex = 0;
                scope.height = scope.height || 150;
                scope.widthStr = scope.width ? (scope.width.toString() + "px") : "100%";
                //图片附件
                scope.reqFileModel = {
                    selectdata: {FileRefID: '', pageindex: 1, pagesize: 10, ptotal: 0},
                    filetype: 1,
                    items: [],
                    readonly: false,
                    typeparams: {
                        types: ['jpg', 'bmp', 'png', 'gif', 'jpe', 'jpeg'],
                        errormsg: '图片格式必须为*.jpg,*.gif,*.png,*.bmp,*.jpe,*.jpeg等格式'
                    }
                };

                scope.$watch('filerefid', function (newVal, oldVal) {
                    if (newVal != null) {
                        scope.img = {rotate: 0, scale: 1};
                        scope.getImgList();
                    }
                });
                scope.getImgList = function () {
                    $http
                    ({
                        method: 'get',
                        url: '../../api/filemgr/getFileList',
                        params: {
                            filerefid: scope.filerefid,
                            fileTypeId: scope.filetypeid,
                            pageindex: 1,
                            pagesize: 1000
                        }
                    }).then(function (result) {
                        scope.imgList = result.data.item.list;
                    });
                };
                scope.showImg = function (index) {
                    scope.img.rotate = 0;
                    scope.showIndex = index;
                };
                scope.uploadImg = function () {
                    scope.reqFileModel.selectdata.FileRefID = scope.filerefid;
                    scope.reqFileModel.filetype = scope.filetypeid;
                    $bsfiles.addFile(scope.reqFileModel).then(function (fid) {
                        scope.getImgList();
                    });
                };
                scope.deleteImg = function (fid) {
                    if (confirm("是否删除？")) {
                        $http({
                            url: '../../api/home/delfile',
                            method: 'GET',
                            params: {fileId: fid}
                        }).then(function (rq) {
                            if (rq.data.success) {
                                scope.getImgList();
                            }
                            $alert({
                                title: '消息',
                                content: rq.data.msg,
                                placement: 'top',
                                type: 'info',
                                show: true,
                                duration: 3
                            });
                        });
                    }
                };
                scope.up = function () {
                    scope.showIndex -= 1;
                    scope.img = {rotate: 0, scale: 1};
                };
                scope.next = function () {
                    scope.showIndex += 1;
                    scope.img = {rotate: 0, scale: 1};
                };
                scope.zoomIn = function () {
                    scope.img.scale += 0.1;
                };
                scope.zoomOut = function () {
                    scope.img.scale -= 0.1;
                };
            }
        }
    }).directive("treeSelect", function ($http, $ocLazyLoad, AuthUser, $filter) {
        //<tree-select data-url="treeConfig.url" data-value="treeConfig.value" data-ismulti="treeConfig.ismulti"></tree-select>
        return {
            restrict: 'EA',
            require: '?ngModel',
            //作用域
            scope: {
                url: '=',//api
                params: '=?',//api参数,类型：对象 {}
                value: '=?',//选择id集合,类型：数组 [id1,id2]
                ismulti: "=?",//单选or多选,类型：boolean
                readonly: "=?", //是否只读
                placeholder: "=?"
            },
            templateUrl: '../js/template/modal_treeselect.html',
            link: function (scope, elemnet) {
                scope.ismulti = !scope.ismulti ? false : scope.ismulti;
                scope.value = !scope.value ? (scope.ismulti ? [] : '') : scope.value;

                scope.dataList = [];
                scope.selectList = [];
                scope.containerShow = 0;
                scope.isGetList = false;
                scope.isDefaultVal = false;

                scope.getList = function () {
                    $http
                    ({
                        method: 'get', url: scope.url, params: scope.params | {}
                    }).then(function (result) {
                        scope.dataList = result.data.item;

                        if (scope.dataList.length > 0) {
                            if (scope.value.length > 0) {
                                scope.defaultVal(scope.dataList);
                            }

                            //scope.dataList[0].chlidShow = 1;
                        }
                    });
                };

                scope.$watch("value", function (newVal) {
                    if (scope.dataList.length <= 0) {
                        if (!scope.isGetList) {
                            scope.isGetList = true;
                            scope.getList();
                        }
                    } else if (scope.value.length > 0 && !scope.isDefaultVal) {
                        scope.defaultVal(scope.dataList);
                    }
                }, true);

                scope.defaultVal = function (list) {
                    scope.isDefaultVal = true;
                    var chlidShow = 0;
                    $.each(list, function (index, item) {
                        if ($.inArray(item.id, scope.value) >= 0 || item.id == scope.value) {
                            item.checked = 1;
                            chlidShow = 1;
                            //scope.select(item);

                            if (scope.selectList.filter(val => val.id == item.id).length <= 0) {
                                scope.selectList.push({name: item.name, id: item.id});
                            }
                        }

                        if (item.childList.length > 0) {
                            item.chlidShow = scope.defaultVal(item.childList);
                        }
                    });

                    return chlidShow;
                };

                scope.showContainer = function () {
                    scope.containerShow = Math.abs((scope.containerShow | 0) - 1);
                };
                $(document).on('click', function (e) {
                    if (typeof (e.target.className) == "string" && e.target.className.indexOf("vue-treeselect") < 0) {
                        scope.$apply(function () {
                            scope.containerShow = 0;

                        })
                    }

                })

                scope.showChildren = function (node) {
                    node.chlidShow = Math.abs((node.chlidShow | 0) - 1);
                };

                //选择节点
                scope.check = function (node) {
                    if (scope.ismulti == true) {
                        //多选
                        node.checked = Math.abs((node.checked | 0) - 1);
                        scope.select(node);
                        if (node.checked == 1 && node.childList.length > 0) {
                            scope.checkChildren(node);
                        }
                    } else {
                        //单选
                        scope.selectList = [{name: node.name, id: node.id}];
                        scope.value = node.id;//[node.id];
                        scope.showContainer();
                    }
                };

                scope.checkChildren = function (node) {
                    $.each(node.childList, function (index, item) {
                        item.checked = 1;

                        scope.select(item);

                        if (item.childList.length > 0) {
                            scope.checkChildren(item);
                        }
                    });
                };

                scope.select = function (node) {
                    if (node.checked == 1) {
                        if (scope.selectList.filter(val => val.id == node.id).length <= 0) {
                            scope.selectList.push({name: node.name, id: node.id});
                        }
                    } else {
                        scope.selectList = scope.selectList.filter(val => val.id != node.id);
                    }
                    scope.setValue();
                };

                scope.remove = function (node) {
                    scope.selectList = scope.selectList.filter(val => val.id != node.id);
                    scope.setValue();
                    scope.uncheck(scope.dataList, node.id);
                };
                scope.uncheck = function (list, uncheckId) {
                    $.each(list, function (index, item) {
                        if (uncheckId) {
                            if (item.id === uncheckId) {
                                item.checked = 0;
                                return;
                            }
                        } else {
                            item.checked = 0;
                        }

                        if (item.childList.length > 0) {
                            scope.uncheck(item.childList, uncheckId);
                        }
                    });
                };
                scope.clear = function () {
                    scope.selectList = [];
                    scope.value = scope.ismulti ? [] : '';
                    scope.uncheck(scope.dataList, "");
                };

                scope.setValue = function () {
                    scope.value = scope.ismulti ? scope.selectList.map(it => {
                        return it.id
                    }) : (scope.selectList.length > 0 ? scope.selectList[0].id : '');
                };

                //scope.getList();

            }
        }
    }).directive("treeComponent", function ($http, $ocLazyLoad, AuthUser, $filter, $timeout, $rootScope) {
        return {
            restrict: 'EA',
            require: '?ngModel',
            //作用域
            scope: {
                url: '=',
                params: '=?',
                value: '=?',
                name: '=?',
                height: '=?',
                reload: '=?',
                isunfold: '=?'
            },
            templateUrl: '../js/template/modal_tree.html',
            link: function (scope, elemnet) {
                if (scope.isunfold != undefined) {
                    //组织树样式
                    if (scope.csssrc) {
                        $ocLazyLoad.load(scope.csssrc);
                    } else {
                        $ocLazyLoad.load('../js/template/modal_partyTree.css');
                    }
                    scope.isunfold = scope.isunfold == undefined ? true : scope.isunfold;
                    //pt-sidebar-collapsed-back 时sidebar_width的宽度
                    scope.sidebar_width = 260;
                    scope.sidebar_has_resize = false;
                    scope.menu_width = 292;
                    //sidebar初始化
                    var $sidebar = null;
                    $sidebar = elemnet.parents('.dj-list-body').first();
                    if (scope.isunfold) {
                        $sidebar.addClass('pt-sidebar-collapsed-back');
                    } else {
                        $sidebar.addClass('pt-sidebar-collapsed');
                    }
                    var sidebarDivs = $sidebar.parent().find('.dj-list-body>div');
                    sidebarDivs.eq(0).addClass('sidebar1');
                    sidebarDivs.eq(1).addClass('content1');
                    scope.sidebrResize = function (sideWidth) {
                        if (sideWidth < 500 && sideWidth >= 260) {
                            scope.sidebar_width = sideWidth;
                            sidebarDivs.eq(0).width(scope.sidebar_width);
                            sidebarDivs.eq(1).width($(window).width() - scope.menu_width - scope.sidebar_width - 23);
                            //sidebarDivs.eq(1).width($sidebar.width() - scope.sidebar_width - 10);
                        }
                    };

                    sidebarDivs.eq(0).mousedown(function (e) {
                        scope.sidebar_has_resize = true;
                    });

                    sidebarDivs.mousemove(function (e) {
                        if (scope.sidebar_has_resize) {
                            scope.sidebrResize(e.clientX - scope.menu_width + 20);
                        }
                    });

                    $(window).mouseup(function (e) {
                        scope.sidebar_has_resize = false;
                    });

                    sidebarDivs.eq(0).children().mousedown(function (e) {
                        e.stopPropagation();
                    });

                    $rootScope.$watch("menuToggle", function (newVal, oldVal) {
                        scope.menu_width = newVal ? 292 : 76;
                        scope.sidebrResize(scope.sidebar_width);
                    });

                    scope.$watch("isunfold", function (newVal, oldVal) {
                        scope.isshowtogglebtn = newVal;
                        if ($sidebar) {
                            if (newVal) {
                                $sidebar.removeClass('pt-sidebar-collapsed');
                                $sidebar.addClass('pt-sidebar-collapsed-back');//展开
                                /*$timeout(function () {
                                    scope.sidebrResize(260);
                                }, 200);*/

                            } else {
                                $sidebar.removeClass('pt-sidebar-collapsed-back');
                                $sidebar.addClass('pt-sidebar-collapsed');//收缩
                                sidebarDivs.removeAttr("style");
                            }
                        }
                    });
                }

                scope.enable = scope.enable == undefined ? true : scope.enable;
                scope.dataList = [];
                scope.activeIds = "";
                scope.value = scope.value || "";
                scope.name = scope.name || "全校党组织";
                scope.getList = function () {
                    $http
                    ({
                        method: 'get', url: scope.url, params: scope.params | {}
                    }).then(function (result) {
                        scope.dataList = result.data.item;
                    });
                };

                scope.clickNode = function (node) {
                    node.show = Math.abs((node.show | 0) - 1);
                    scope.value = node.id;
                    scope.name = node.name;
                    scope.activeIds = node.fullids.split('.');
                };

                scope.isActive = function (node) {
                    return $.inArray(node.id, scope.activeIds) >= 0 ? 'party_active' : '';
                }

                scope.$watch("reload", function (newVal) {
                    if (scope.reload == true) {
                        scope.getList();
                        scope.reload = false;
                    }
                });

                scope.reset = function () {
                    scope.value = "";
                    scope.name = "全校党组织";
                    scope.activeIds = "";
                };

                scope.getList();

            }
        }
    }).directive('thSelectAll', function () {
        var directiveObject = {
            restrict: 'A',
            template: '<input type="checkbox" class="filled-in chk-col-red" ng-click="checkAll()" id="allcheck_{{checkboxid}}"/>  <label class="checkbox_lable" for="allcheck_{{checkboxid}}"></label>',
            scope: {
                datalist: '='
            },
            link: function (scope, element, attr, controller) {
                scope.checkboxid = Math.random();
                /* scope.allchecked = false;*/
                var selectAllbox = element.find('input[type="checkbox"]');
                scope.checkAll = function () {
                    /*if (scope.allchecked == false) {
                        scope.allchecked = true;
                    } else {
                        scope.allchecked = false;
                    }*/
                    if (scope.datalist) {
                        angular.forEach(scope.datalist, function (val) {
                            val.rowChecked = selectAllbox.prop("checked");
                        });
                    }
                };
            }
        };

        return directiveObject;
    }).directive('tdRownum', function () {
        var directiveObject = {
            restrict: 'A',
            template: function (tElement, tAttrs) {
                var html = '<span>{{pagesize*(pageindex-1)+index+1}}</span>';
                return html;
            },
            scope: {
                index: '=',
                pageindex: '=',
                pagesize: '=',
            },
            link: function (scope, element, attr, controller) {
                element.parent().on('click', function () {
                    var tar1 = event.target;
                    if (tar1.nodeName == "TD") {
                        var ngStr = $(this).find("[type='checkbox']").attr('ng-model');

                        var funText = "scope.$parent." + ngStr + "=!scope.$parent." + ngStr + ";";

                        scope.$apply(function () {
                            eval(funText);
                        });
                    }
                    //event.stopPropagation();

                });
            }
        };

        return directiveObject;
    }).directive('userselectPro', function ($http, $modal, $alert, AuthUser) {
        var directiveObject = {
            restrict: 'EAC',
            scope: {
                values: '=',//已选择的人员ID
                texts: '=',//已选择的人员
                datausers: '=',//已选人员对象
                onselect: '=?',
                selectdzzdm: '='
            },
            link: function (scope, element, attr, controller) {
                //选择模式，默认多选；单选/多选
                scope.selecttype = attr['selecttype'] == "single" ? attr['selecttype'] : "multi";
                scope.isSingle = scope.selecttype == "single";//判断是否为单选模式
                scope.isShowchildren = attr['isshowchildren'] == "true" ? 1 : 0;

                //判断绑定的变量是否已定义
                if (angular.isDefined(attr['values']) && angular.isDefined(attr['texts'])) {
                    var usModalController = function ($scope) {
                        //将参数传递的方式改成form
                        $scope.postCfg = {
                            headers: {'Content-Type': 'application/x-www-form-urlencoded'},
                            transformRequest: function (data) {
                                return $.param(data);
                            }
                        };
                        $scope.title = '人员选择';
                        $scope.roleid = null;
                        $scope.selectdzzdm = scope.selectdzzdm != null ? scope.selectdzzdm : AuthUser.getUser().gddwdm;//当前选中的组织机构
                        $scope.$watch("selectdzzdm", function (newVal, oldVal) {
                            if (newVal) {
                                $scope.searchParam = "";//查询条件清空
                                $scope.loadUser();
                            }
                        });
                        $scope.roleLists = [];
                        $scope.getRoleList = function () {
                            $http({
                                url: "../../api/userrole/GetAllRoleList",
                                method: 'GET',
                                params: {
                                    appid: 'f0c4fa7f9f3c4fb6bd56aac608b7ad3f',
                                    pageindex: 1,
                                    pagesize: 999
                                }
                            }).then(function (rq) {
                                $scope.roleLists = rq.data.item.list;
                            });
                        }
                        $scope.getRoleList();
                        //人员列表
                        $scope.userSelectList = [];


                        //如果datausers没有定义，赋值个空数组
                        if (angular.isUndefined(scope.datausers)) {
                            scope.datausers = [];
                        }
                        //待添加人员列表
                        $scope.tempAdd = [];
                        //拷贝对象，单次赋值给右边已选列表
                        $scope.rightusers = angular.copy(scope.datausers);

                        //确定选择按钮，统计所选择的人员，按照"xxxx,xxxx,xxxx"模板拼接
                        $scope.selectedData = function () {
                            if ($scope.rightusers.length <= 0) {
                                $alert({
                                    title: '消息：',
                                    content: '请添加人员',
                                    placement: 'top',
                                    type: 'info',
                                    container: '#userselectpro',
                                    show: true,
                                    duration: 3
                                });

                                return false;
                            }
                            var isFirst = true;
                            scope.texts = "";
                            scope.values = "";
                            angular.forEach($scope.rightusers, function (item) {
                                if (isFirst) {
                                    scope.texts = item.XM;
                                    scope.values = item.RYBM;
                                    isFirst = false;
                                } else {
                                    scope.texts += ',' + item.XM;
                                    scope.values += ',' + item.RYBM;
                                }
                            });
                            scope.datausers = $scope.rightusers;
                            if (scope.onselect) {
                                scope.onselect($scope.rightusers);
                            }
                            $scope.$hide();
                        };
                        //添加已选择的人员
                        $scope.addUser = function () {
                            var isFlag = $scope.tempAdd.length <= 1 && $scope.rightusers.length == 0;//判断已选人数是否小于等于1
                            if ((scope.isSingle && isFlag) || !scope.isSingle) {
                                angular.forEach($scope.tempAdd, function (item) {
                                    //准备添加的人员是否在右边列表存在,如果存在，为false,不添加到右侧
                                    var isAdd = true;
                                    angular.forEach($scope.rightusers, function (user) {
                                        if (item.RYBM == user.RYBM) {
                                            isAdd = false;
                                        }
                                    });
                                    if (isAdd) {
                                        $scope.rightusers.push(item);
                                    }

                                    $scope.userSelectList = $scope.userSelectList.filter(it => it.RYBM != item.RYBM);

                                })
                            } else {
                                $alert({
                                    title: '错误：',
                                    content: '只可选择一名人员！',
                                    placement: 'top',
                                    type: 'info',
                                    container: '#userselectpro',
                                    show: true,
                                    duration: 3
                                });
                            }
                        };
                        $scope.addAllUser = function () {
                            if (!scope.isSingle) {
                                $scope.userSelectList.forEach(item => {
                                    if ($scope.rightusers.filter(user => user.RYBM == item.RYBM).length <= 0) {
                                        $scope.rightusers.push(item);
                                    }
                                });

                                $scope.userSelectList = [];
                            }
                        };

                        //删除已选择的人员
                        $scope.deleteUser = function () {
                            angular.forEach($scope.tempSelected, function (item) {
                                var index = $scope.rightusers.indexOf(item);
                                $scope.rightusers.splice(index, 1);

                                if (item.SZDZBDM == $scope.selectdzzdm && $scope.userSelectList.filter(user => user.RYBM == item.RYBM).length <= 0) {
                                    $scope.userSelectList.push(item);
                                }

                            })
                        };

                        $scope.deleteAllUser = function () {
                            $scope.rightusers.forEach(item => {
                                if (item.SZDZBDM == $scope.selectdzzdm && $scope.userSelectList.filter(user => user.RYBM == item.RYBM).length <= 0) {
                                    $scope.userSelectList.push(item);
                                }
                            });
                            $scope.rightusers = [];
                        };

                        //人员查询
                        $scope.searchUser = function () {
                            if ((angular.isDefined($scope.searchParam) && $scope.searchParam != "" && $scope.searchParam != null) || $scope.roleid != null) {
                                $scope.selectdzzdm = "";
                                $scope.loadUser();
                            } else {
                                $alert({
                                    title: '消息：',
                                    content: '请输入要查询的人员名',
                                    placement: 'top',
                                    type: 'info',
                                    container: '#userselectpro',
                                    show: true,
                                    duration: 3
                                });
                                return false;
                            }
                        };

                        $scope.loadUser = function () {
                            $scope.isloading = true;
                            $scope.userSelectList = [];
                            $http.get("../../api/partyUser/getPartyUserList", {
                                params: {
                                    roleid: $scope.roleid,
                                    isShowchildren: scope.isShowchildren,
                                    'xm': $scope.searchParam,
                                    'szdzbdm': $scope.selectdzzdm,
                                    'pageindex': 1,
                                    'pagesize': 1000,
                                    'dzzdm': AuthUser.getUser().gddwdm
                                }
                            }).then(function (result) {
                                $scope.userSelectList = result.data.item.list;//返回的人员列表赋值给变量userSelectList
                                $scope.isloading = false;
                            }, function () {
                                $alert({
                                    title: '错误：',
                                    content: '查询人员列表失败，服务器错误',
                                    placement: 'top',
                                    type: 'info',
                                    container: '#userselectpro',
                                    show: true,
                                    duration: 3
                                });
                            });
                        };
                    };

                    usModalController.$inject = ['$scope'];
                    var usModal = $modal({
                        scope: scope,
                        controller: usModalController,
                        resolve: {
                            load: ['$ocLazyLoad', function ($ocLazyLoad) {
                                $ocLazyLoad.load('../js/template/modal_userselectpro.css');
                                return true;
                            }]
                        },
                        templateUrl: '../js/template/modal_userselectpro.html',
                        show: false,
                        animation: 'am-fade-and-slide-top'
                    });
                    //data-isNotRelated:是否关联用一个父元素的input标签(点击input标签时也可以触发该控件)，默认为false  可选值:true/fasle(不关联)
                    if (attr['isNotRelated']) {
                        element.on("click", function () {
                            usModal.$promise.then(usModal.show);
                        });
                        element.css({cursor: 'pointer'});
                    } else {
                        element.parent().on("click", function () {
                            usModal.$promise.then(usModal.show);
                        });
                        element.css({cursor: 'pointer'});
                        element.parent().children("input").css({cursor: 'pointer', "background-color": "#FFFFFF"});
                    }
                }
            }
        };

        return directiveObject;
    }).directive("insertSelect", [function () {
        return {
            restrict: 'AE',
            templateUrl: '../js/template/insertSelect.html',
            scope: {
                modelData: '=modelData',
                optionList: '=optionList',
                placeholder: '=placeholder',    //placeholder 可由引入页面传入
                valuefield: '=valuefield',
                textfield: '=textfield',
            },
            link: function ($scope, $elem) {
                //
            },
            controller: ["$scope", function ($scope) {

            }]
        }
    }]).directive('fixedTableHeader', function ($timeout, $compile, $loading, $interval) {
        return {
            restrict: 'A',
            scope: {
                fiexdFooter: '=?',//是否固定表格tfoot
                /*fixedColumns:'=?',*/
                maxHeight: '=?', //最大高度，默认自适应表格到底部的高度
                fixedEndColumns: '=?',
                isload: '=?'
            },
            link: function (scope, element, attr) {
                /*scope.isload = scope.isload || true;
                scope.$watch("isload", function (newVal) {
                    if (newVal) {
                        scope.load();
                        scope.isload = false;
                    }
                });*/

                scope.defualtWidth = 0;

                var $table = $(element).parent().parent();
                var $parent = $table.parent();


                var reloadTable = function () {

                    $table.fixedHeaderTable('destroy');

                    $timeout(function () {
                        $parent = $table.parent();

                        var parentHeight = 0;
                        var diffHeight = (scope.fixedEndColumns > 0 ? 15 : 0);//误差偏移量
                        var maxHeight = scope.maxHeight || ($(window).actual('height') - $table.offset().top - ($parent.parent().find(".grid-page").height() || 0) - 20);

                        if ($table.actual('height') < maxHeight) { //不需要出滚动条
                            parentHeight = $table.actual('height') + 3;
                        } else {
                            parentHeight = maxHeight;
                        }

                        $parent.height(parentHeight + diffHeight);

                        if ($table.height() >= $table.parent().height() || scope.fixedEndColumns > 0) {
                            $table.fixedHeaderTable({
                                footer: scope.fiexdFooter || false,
                                fixedEndColumns: scope.fixedEndColumns || 0
                            });

                            //全选
                            var $tableWrapper = $table.parent().parent();
                            $tableWrapper.find(".fht-thead").find('input[type="checkbox"]').on('click', function () {
                                var allChecked = this.checked;

                                var allCheckedInput = $tableWrapper.find(".fht-tbody").find("thead").find('input[type="checkbox"]');

                                var allCheckScope = allCheckedInput.scope();

                                allCheckedInput.prop("checked", allChecked);

                                allCheckScope.$apply(function () {

                                    allCheckScope.checkAll();
                                });

                            });


                            //固定列
                            if (scope.fixedEndColumns > 0) {
                                try {
                                    var $fixedColumn = $table.parent().parent().parent().find(".fht-fixed-column");
                                    $compile($fixedColumn.contents())($table.scope());

                                    $tableWrapper.find(".fht-tbody").height($tableWrapper.find(".fht-tbody").height() - 2);
                                    $fixedColumn.find(".fht-tbody").height($fixedColumn.find(".fht-tbody").height() + 5);

                                    $table.find('tr > *:nth-child(n+' + ($table.find('th').length - scope.fixedEndColumns + 1) + ')').find("*").attr("disabled", true);
                                } catch (exception) {
                                }
                            }

                        }

                        //$loading.hide("fixedTableHeader");
                    });
                }

                if (scope.$parent.$last === true) {
                    //$loading.show("fixedTableHeader");
                    scope.defualtWidth = $parent.width();
                    reloadTable();

                    /*var timer = $interval(function () {
                        if (scope.defualtWidth > 0 && Math.abs(scope.defualtWidth - $parent.width()) > 30) {
                            scope.defualtWidth = $parent.width();
                            reloadTable();
                        }
                    }, 200);*/
                }

            }
        };
    });
    ;
})(angular);
