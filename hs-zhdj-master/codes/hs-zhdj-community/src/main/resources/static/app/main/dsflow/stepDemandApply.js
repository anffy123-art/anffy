(function ($app) {
    'use strict';
    var app = $app.module('dsfapp').controller('stepdemandApplyCtrl', function ($scope, $http, $loading) {
        //$scope.item = null;
        $scope.datafiles = {
            reqFileModel: {
                selectdata: {FileRefID: '', pageindex: 1, pagesize: 10, ptotal: 0},
                filetype: 1,
                items: [],
                readonly: true//除了需求人发起环节，之后都不对需求文档进行编辑
            }
        };

        $scope.loadItem = function (id) {
            $http({
                url: "../../api/DemandFlow/getDemandApply",
                method: 'GET',
                params: {id: '', fid: id, userid: ''}
            }).then(function (rq) {
                $scope.item = rq.data.items;
                $scope.iteminfo = rq.data.extdata;
                $scope.datafiles.reqFileModel.selectdata.FileRefID = $scope.item.DemandApplyID;
                $loading.hide();
            });
        };
        $scope.$on("d_applyinit", function (event, tar) {
            if (angular.isUndefined($scope.item)) {
                $scope.loadItem(tar.fid);
            }

        });
    });

    return app;
})(angular);