(function () {
    var app = angular.module('dsfapp');

    app.controller("saveSysDutyCtrl", function ($scope, $alert) {

        $scope.hasPermission = {
            hide: '取消',
            editTitle: true,
            showSave: true
        }

        $scope.addOrUp = {
            selectSystemID: "",
            DutyName: "",
            DutyLv: "",
            PDutyID: "",
            SysDutyNote: "",
            DutyCreatorName: "",
            DutyLastDoneTime: ""

        };
        $scope.addOrUp.DutyCreatorName = $scope.user.Name;

        $scope.Dlevel = [
            {DutyLv: "", LvName: '-------请先选择系统层级-------'},
            {DutyLv: 1, LvName: '模块'},
            {DutyLv: 2, LvName: '菜单'},
            {DutyLv: 3, LvName: '功能点'}
        ];

        //更新父级节点的options
        $scope.updatePDuty = function () {
            $scope.PDuty = [];

            $scope.PDuty.push({
                SysDutyID: "",
                SysDutyName: "-------请先选择模块层级-------"
            });

            if ($scope.addOrUp.DutyLv == 1) {
                $scope.PDuty.push({
                    SysDutyID: "100",
                    SysDutyName: "系统"
                });
            } else if ($scope.addOrUp.DutyLv == 2) {
                angular.forEach($scope.PSysDuty, function (data) {
                    if (data.myDuty != undefined && data.myDuty.SystemID == $scope.addOrUp.selectSystemID)
                        if ($scope.sysDuty == null || ($scope.sysDuty.SysDutyID != data.myDuty.SysDutyID)) $scope.PDuty.push(data.myDuty);
                });
            } else if ($scope.addOrUp.DutyLv == 3) {
                angular.forEach($scope.PSysDuty, function (data) {
                    if (data.childDuty != undefined && data.myDuty.SystemID == $scope.addOrUp.selectSystemID) {
                        angular.forEach(data.childDuty, function (childData) {
                            //不显示当前编辑的节点
                            if ($scope.sysDuty == null || ($scope.sysDuty.SysDutyID != childData.myDuty.SysDutyID && $scope.sysDuty != null)) $scope.PDuty.push(childData.myDuty);
                        });
                    }
                });
            }
            $scope.addOrUp.PDutyID = "";
        }

        $scope.updatePDuty();
        //前台显示赋值
        $scope.addOrUp.DutyLastDoneTime = new Date().toLocaleString();
        if ($scope.sysDuty != null) {
            $scope.addOrUp.selectSystemID = $scope.sysDuty.SystemID;
            $scope.addOrUp.DutyLv = $scope.sysDuty.DutyLv;
            //模块赋值后先更新一遍
            $scope.updatePDuty();
            $scope.addOrUp.PDutyID = $scope.sysDuty.PDutyID == null ? "100" : $scope.sysDuty.PDutyID;
            $scope.addOrUp.DutyName = $scope.sysDuty.SysDutyName;
            $scope.addOrUp.SysDutyNote = $scope.sysDuty.SysDutyNote;
            $scope.hasPermission.editTitle = false;
        }


        //根据选择的DutyLv来显示对应的父级节点
        $scope.$watch('addOrUp.DutyLv', function (value) {
            $scope.updatePDuty();
            if ($scope.sysDuty != null && $scope.sysDuty.DutyLv == $scope.addOrUp.DutyLv) {
                $scope.addOrUp.PDutyID = $scope.sysDuty.PDutyID == null ? "100" : $scope.sysDuty.PDutyID;
            }
        }, true);

        //同时系统也要watch
        $scope.$watch('addOrUp.selectSystemID', function (value) {
            $scope.updatePDuty();
            if ($scope.sysDuty != null && $scope.addOrUp.selectSystemID == $scope.sysDuty.SystemID) {
                $scope.addOrUp.PDutyID = $scope.sysDuty.PDutyID == null ? "100" : $scope.sysDuty.PDutyID;
            }
        }, true);

        $scope.save = function () {
            $scope.tempSysDuty = {
                SysDutyID: ($scope.sysDuty != null) ? $scope.sysDuty.SysDutyID : null,
                PDutyID: $scope.addOrUp.PDutyID != "100" ? $scope.addOrUp.PDutyID : null,
                SystemID: $scope.addOrUp.selectSystemID,
                DutyLv: $scope.addOrUp.DutyLv,
                SysDutyName: $scope.addOrUp.DutyName,
                SysDutyNote: $scope.addOrUp.SysDutyNote,
                CreatorID: $scope.user.DGUserID,
                LastDoneTime: $scope.addOrUp.DutyLastDoneTime
            };
            //新增或者修改
            $.ajax({
                type: "post",
                url: "../../api/SysDuty/ChangeSysDuty",
                contentType: 'application/json',
                data: JSON.stringify($scope.tempSysDuty),
                success: function (data, status) {
                    $alert({content: data, type: 'info', placement: 'top', show: true, duration: 3});
                    //执行完后重新刷新数据
                    $scope.getSysDuty();
                },
                error: function (data, status) {
                    $alert({content: data, type: 'info', placement: 'top', show: true, duration: 3});
                }
            });

        };
    });
})();