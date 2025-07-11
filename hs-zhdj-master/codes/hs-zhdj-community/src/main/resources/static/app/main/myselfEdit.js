(function ($app) {

    $app.module('gtPartyApp').controller('editUserCtrl', function ($scope, $http, $bsfiles, $modal, $ocLazyLoad, AuthUser, $alert, $loading, $state) {

        $scope.reqFileModel = {
            selectdata: {FileRefID: '', pageindex: 1, pagesize: 10, ptotal: 0},
            filetype: 1,
            items: [],
            readonly: false,
            typeparams: {
                types: ['jpg', 'bmp', 'png', 'gif', 'jpe', 'jpeg'],
                errormsg: '图片格式必须为*.jpg,*.gif,*.png,*.bmp,*.jpe,*.jpeg等格式'
            }
        };
        $scope.pictureurl = "";
        $scope.pictureurl = "../../api/home/showImg/" + AuthUser.getUser().Id;
        // $http.get("../../api/activity/GetActivityByID", {params: {'id': $state.params.id}}).then(function (result) {
        //     console.log(result);
        //     $scope.parkvm = result.data.item;
        //     if ($scope.parkvm.publisherName == undefined || $scope.parkvm.publisherName == null) {
        //         $scope.parkvm.publisherName = AuthUser.getUser().Name;
        //         $scope.parkvm.publisher = AuthUser.getUser().Id;
        //     }
        //     $scope.reqFileModel.selectdata.FileRefID = result.data.item.activityID;
        //     $scope.pictureurl = "../../api/home/showImg/" + result.data.item.activityID;
        //     $scope.dataurl = "../../api/park/getParks?cityType=" + $scope.parkvm.cityids;
        // }, function () {
        //     $scope.showMsg('错误', '服务器错误');
        // });
        // $scope.changePassword = function () {
        //     alert("测试");
        // };
        // $scope.getpubTypeList = function () {
        //     $http({
        //         method: 'get',
        //         url: '../../api/dictionary/getDictionaryListByDicTypeKey',
        //         params: {
        //             dicTypeKey: 'pubTypeList'
        //         }
        //     }).then(function (result) {
        //         $scope.pubTypeList = result.data;
        //     }, function (resp) {
        //
        //     });
        // };
        // $scope.citytypechange = function (cityids) {
        //     $scope.dataurl = "../../api/park/getParks?cityType=" + cityids;
        // }
        $scope.submitPark = function (isflag) {
            if (isflag) {
                $loading.show();
                //$scope.parkvm.deadline = new Date($scope.parkvm.deadline).Format('yyyy-MM-dd');
                $scope.parkvm.validTime = new Date($scope.parkvm.validTime).Format('yyyy-MM-dd');
                $http({
                    method: "post",
                    url: "../../api/activity/saveActivity",
                    data: {model: $scope.parkvm, parkids: $scope.parkvm.parkids}
                }).then(function (result) {
                    $loading.hide();
                    $scope.showMsg('成功', result.data.msg);
                    //重新刷新列表
                    $state.go("home.activitylist");

                }, function (resp) {
                    $scope.showMsg('错误', '服务器错误');
                })
            }
        }
        $scope.cancel = function () {
            $state.go("home.activitylist");
        }
        Date.prototype.Format = function (fmt) {
            var o = {
                "M+": this.getMonth() + 1,//月份
                "d+": this.getDate(),//日
                "H+": this.getHours(),//小时
                "m+": this.getMinutes(),//分
                "s+": this.getSeconds(),//秒
                "q+": Math.floor((this.getMonth() + 3) / 3),//季度
                "S+": this.getMilliseconds()//毫毛
            };
            if (/(y+)/.test(fmt)) fmt = fmt.replace(RegExp.$1, (this.getFullYear() + "").substr(4 - RegExp.$1.length));
            for (var k in o)
                if (new RegExp("(" + k + ")").test(fmt)) fmt = fmt.replace(RegExp.$1, (RegExp.$1.length == 1) ? (o[k]) : (("00" + o[k]).substr(("" + o[k]).length)));
            return fmt;
        };
        $scope.showMsg = function (title, content) {
            $alert({
                title: title + '：',
                content: content,
                placement: 'top',
                type: 'info',
                show: true,
                duration: 3
            });

        };
        //$scope.getpubTypeList();
    })
})(angular);
