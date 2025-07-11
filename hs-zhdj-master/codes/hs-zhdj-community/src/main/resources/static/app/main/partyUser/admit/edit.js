var partyAdmitUser_editCtrl = function ($scope, $http, $alert, $loading, $partySelect) {
    $scope.parentLoad = partyAdmitUser_editModal.parentLoad;
    $scope.editParams = partyAdmitUser_editModal.params;
    $scope.isNew = !$scope.editParams.userCode;
    $scope.userStatus = $scope.editParams.userStatus;
    $scope.upUserStatus = $scope.editParams.upUserStatus;
    $scope.dataModel = {};
    $scope.xbList = [];
    //选择党支部
    $scope.partyTreeConfig = {
        scope: $scope,
        selectedKey: '',
        selectedText: '',
        selectedData: [],
        isMulti: false,
        isshowxz: 0
    };
    $partySelect.initServer($scope.partyTreeConfig);
    $scope.selectParty = function () {
        $partySelect.showModal();
    };
    $scope.$watch("partyTreeConfig.selectedKey", function (newVal, oldVal) {
        if (newVal) {
            $scope.dataModel.partyCode = $scope.partyTreeConfig.selectedKey;
            $scope.dataModel.partyName = $scope.partyTreeConfig.selectedText;
        }
    }, true);

    $scope.selectUserlist = {
        url: '../../api/partyUserAdmit/getList',
        title: '人员选择',
        isMulti: false,
        selectData: {userName: '姓名'},
        columns: {userName: '姓名', userCode: '学号/工号', partyName: '所属党组织', userStatusName: '人员类别'},
        selectLabelKey: 'userCode',
        selectValuekey: 'userCode',
        selectedValueData: '',
        selectedLabeData: '',
        selectedJData: [],
        selectParams: {
            userStatus: $scope.upUserStatus,
            isArchive: 0
        },
        onSelect: function (value, item) {
            if (value) {
                $scope.xbList = [];
                $scope.mzList = [];
                $scope.xlList = [];
                $scope.boolList = [];
                $scope.getData(value);
            }
        }
    };

    $scope.save = function (isflag) {
        if (isflag) {
            $loading.show();
            $http({
                method: "post",
                url: "../../api/partyUserAdmit/saveUser",
                data: $scope.dataModel
            }).then(function (result) {
                $loading.hide();
                if (result.data.success) {
                    $scope.showMsg('成功', "操作成功");
                    //重新刷新列表
                    $scope.parentLoad();
                    $scope.$hide();
                } else {
                    $scope.showMsg('失败', result.data.msg);
                }

            }, function (resp) {
                $loading.hide();
                $scope.showMsg('错误', '服务器错误：' + resp.data);
            });
        }
    };
    $scope.getData = function (userCode) {
        $http
        ({
            method: 'get', url: "../../api/partyUserAdmit/getPartyUserByCode",
            params: {
                'userCode': userCode
            }
        }).then(function (result) {
            $scope.dataModel = result.data.item;
            if ($scope.isNew) {
                $scope.dataModel.userStatus = $scope.userStatus;
                $scope.dataModel.applyApproveStatus = 2;
            }
            $scope.xbList = [{BM: '1', HZMC: '男'}, {BM: '2', HZMC: '女'}];
            $scope.boolList = [{dickey: true, dicvalue: '是'}, {dickey: false, dicvalue: '否'}];
            $scope.getMZList();
            $scope.getEducationList();
        }, function (resp) {
            $scope.showMsg('错误', '服务器错误：' + resp.data);
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
    $scope.getEducationList = function () {
        $http({
            method: 'get',
            url: '../../api/partyDic/getEducationList'
        }).then(function (result) {
            $scope.xlList = result.data;
        }, function (resp) {

        });
    };

    $scope.getData($scope.editParams.userCode);

};

//定义模态框
var partyAdmitUser_editModal;