(function ($saga_docUpload) {
    'use strict';
    $saga_docUpload.module('dsfapp').controller('formDocUploadCtrl', function ($scope, $http, $modal, $alert) {
        //接收广播信息
        $scope.$on("toDevDocUpload", function (event, tar) {
            if (angular.isUndefined($scope.item)) {
                $scope.fid = tar.fid;

                //$scope.loadItems(tar.fid);
            }
        });
        $scope.init = function () {
            //模拟数据
            $scope.items = [{SysDutyName: 1}, {SysDutyName: 2}, {SysDutyName: 3}, {SysDutyName: 4}];
            $scope.itemSon1 = [{key: 11, value: "A1", checked: false}, {key: 12, value: "B1", checked: false}, {
                key: 13,
                value: "C1",
                checked: false
            }, {key: 14, value: "D1", checked: false}];
            $scope.itemSon2 = [{key: 21, value: "A2", checked: false}, {key: 22, value: "B2", checked: false}, {
                key: 23,
                value: "C2",
                checked: false
            }, {key: 24, value: "D2", checked: false}];
            $scope.itemSon3 = [{key: 31, value: "A3", checked: false}, {key: 32, value: "B3", checked: false}, {
                key: 33,
                value: "C3",
                checked: false
            }, {key: 34, value: "D3", checked: false}];
            $scope.itemSon4 = [{key: 41, value: "A4", checked: false}, {key: 42, value: "B4", checked: false}, {
                key: 43,
                value: "C4",
                checked: false
            }, {key: 44, value: "D4", checked: false}];
            $scope.itemAll = [$scope.itemSon1, $scope.itemSon2, $scope.itemSon3, $scope.itemSon4];
        };

        $scope.selected = [];
        $scope.selectedTags = [];
        //全选·取消全选
        $scope.selectAll = function (e) {
            var dataAll = $scope.itemSon1.concat($scope.itemSon2).concat($scope.itemSon3).concat($scope.itemSon4);
            for (var i = 0; i < dataAll.length; i++) {
                //全选
                if (e) {
                    dataAll[i].checked = true;
                    $scope.selected.push(dataAll[i].key);
                    $scope.selectedTags.push(dataAll[i].value);
                } else {
                    //全不选
                    dataAll[i].checked = false;
                    var idx = $scope.selected.indexOf(dataAll[i].key);
                    $scope.selected.splice(idx, 1);
                    $scope.selectedTags.splice(idx, 1);
                }
            }

        };
        //局部全选·取消局部全选
        $scope.partAll = function (e, d) {
            $scope.getdata(d);
            if (e) {
                //全选

                for (var i = 0; i < $scope.itemSon.length; i++) {
                    $scope.itemSon[i].checked = true;
                    if (!$scope.selected.in_array($scope.itemSon[i].key)) {
                        $scope.selected.push($scope.itemSon[i].key);
                        $scope.selectedTags.push($scope.itemSon[i].value);
                    }

                }

            } else {
                //全不选
                for (var i = 0; i < $scope.itemSon.length; i++) {
                    $scope.itemSon[i].checked = false;
                    var idx = $scope.selected.indexOf($scope.itemSon[i].key);
                    $scope.selected.splice(idx, 1);
                    $scope.selectedTags.splice(idx, 1);
                }
            }
        };


        var updateSelected = function (action, id, name) {
            if (action == 'add' && $scope.selected.indexOf(id) == -1) {
                $scope.selected.push(id);
                $scope.selectedTags.push(name);
            }
            if (action == 'remove' && $scope.selected.indexOf(id) != -1) {
                var idx = $scope.selected.indexOf(id);
                $scope.selected.splice(idx, 1);
                $scope.selectedTags.splice(idx, 1);
            }
        }

        $scope.updateSelection = function ($event, id) {
            var checkbox = $event.target;
            var action = (checkbox.checked ? 'add' : 'remove');
            updateSelected(action, id, checkbox.name);
        };
        $scope.getdata = function (d) {
            switch (d) {
                case 1:
                    $scope.itemSon = $scope.itemSon2;
                    break;
                case 2:
                    $scope.itemSon = $scope.itemSon3;
                    break;
                case 3:
                    $scope.itemSon = $scope.itemSon4;
                    break;
                case 0:
                    $scope.itemSon = $scope.itemSon1;
                    break;

            }

        }

        $scope.getSon = function (e, d) {
            $scope.flag = e.SysDutyName;
            //$scope.getdata(d);
        };


        $scope.init();


    });

})(angular);

