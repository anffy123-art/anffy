(function () {
    'use strict';

    var app = angular.module('dsfapp');

    app.directive('onFinishRenderFilters', function ($timeout) {
        return {
            restrict: 'A',
            link: function (scope, element, attr) {
                if (scope.$last === true) {
                    $timeout(function () {
                        scope.$emit('ngRepeatFinished', scope);
                    });
                }
            }
        };
    }).directive('bsLvtree1', function ($filter, $timeout, $ocLazyLoad, $compile) {
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
        }

        //树形结构加入dom
        var htmltreebind = function (vtrees, $treepanel) {

            angular.forEach(vtrees, function (vtval) {
                var htmln = '<div class="tree_node" data-id="' + vtval.id + '" data-xid="' + vtval.xid + '">\r';
                htmln += '<div class="tree_head">\r';
                htmln += '\t<div data-id="' + vtval.id + '" ng-mouseover="overItem(this)" ng-mouseleave="leaveItem(this)" class="item_panel">\r';
                //第一排
                htmln += '<div class="item_col1">';
                htmln += '\t\t<a ng-click="btnclick(\'' + vtval.id + '\',1)" title="新增同级"><span class="glyphicon glyphicon-plus-sign"></span></a>';
                htmln += '</div >'
                //第二排
                htmln += '<div class="item_col2">';

                if (vtval.islast) {
                    htmln += '\t\t<div class="item_chk"><input type="checkbox" name="chk" value="' + vtval.id + '" /></div>'
                }

                if (!vtval.islast) {
                    htmln += '\t\t<a title="新增子级" ng-click="btnclick(\'' + vtval.id + '\',2)" class="item_col2_addchild"><span class="glyphicon glyphicon-chevron-right"></span></a>'
                }
                htmln += '\t\t<a ng-click="btnclick(\'' + vtval.id + '\',4)" title="' + vtval.name + '" class="item_div btn btn-success">' + vtval.name + '</a>\r';
                htmln += '</div >';
                //第三排
                htmln += '<div class="item_col3">';
                htmln += '\t\t<a ng-click="btnclick(\'' + vtval.id + '\',3)" title="删除节点"><span class="glyphicon glyphicon-minus-sign"></span></a>';
                htmln += '</div >';

                htmln += '\t\t</div>\r';
                htmln += '\t</div>\r';
                htmln += '</div>\r';

                var $tnode = $(htmln), $tpanel;
                $treepanel.append($tnode);
                if (vtval.children && vtval.children.length > 0) {
                    $tpanel = $('<div class="tree_body"></div>');
                    $tnode.append($tpanel);
                    htmltreebind(vtval.children, $tpanel);
                }


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

                    ctx.moveTo($it.position().left + $it.width() - 15, $it.position().top + $('.x_axis_div').height() + $it.height() / 2 - 9);
                    ctx.lineTo($cit.position().left, $cit.position().top + $('.x_axis_div').height() + $cit.height() / 2 - 9);
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

                //第一层节点
                $scope.ngModel.treeNodes = $filter('filter')($scope.ngModel.data, function (val) {
                    return val.xid == $scope.ngModel.xAxis[0].id;
                });

                $scope.ngModel.treelength = 0;
                $scope.ngModel.treeloadlength = 0;

                bindtree($scope.ngModel.treeNodes, $scope.ngModel);

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

                $scope.$watch('ngModel.treeloadlength', function () {

                    if ($scope.ngModel.treelength == $scope.ngModel.treeloadlength) {
                        $timeout(function () {
                            //开始画图
                            var cvs = $elem.find('.dutypanel>canvas')[0];
                            cvs.width = $elem.find('.dutypanel').width();
                            cvs.height = $elem.find('.dutypanel').height();
                            var ctx = cvs.getContext('2d');
                            drawxAxisLine(ctx, $scope.ngModel.xAxis, cvs.height);
                            ctx.beginPath();
                            angular.forEach($scope.ngModel.treeNodes, function (tn, tk) {
                                drawRectToRectLine(ctx, tn);
                            });
                            ctx.closePath();
                            ctx.save();
                        }, 50);
                    }
                });


            }
        }
    }).controller("sysDutyListCtrl1", function ($scope) {
        $scope.option = {
            xAxis: [{id: 0, name: '系统'}, {id: 1, name: '模块'}, {id: 2, name: '应用'}, {id: 3, name: '功能点'}],
            data: [{id: 'xx01', xid: 0, pid: null, name: '协同办公平台'}, {
                id: 'xx11',
                xid: 1,
                pid: 'xx01',
                name: '业务支持中心'
            }, {id: 'xx12', xid: 1, pid: 'xx01', name: '开发易'}, {
                id: 'xx111',
                xid: 2,
                pid: 'xx11',
                name: '数据修改'
            }, {id: 'xx112', xid: 2, pid: 'xx11', name: '数据查询'},
                {id: 'xx1111', xid: 3, pid: 'xx111', name: '工作台'}, {
                    id: 'xx1112',
                    xid: 3,
                    pid: 'xx111',
                    name: '修改申请'
                }, {id: 'xx1113', xid: 3, pid: 'xx111', name: '查询修改'}
            ],
            canEdit: false,
            canChecked: false
        };
    });

    //$(function () {
    //var ctx = $('#myCanvas')[0].getContext("2d");
    //ctx.strokeStyle = "#0000ff";
    //ctx.lineWidth = 1;
    //ctx.strokeRect(5, 5, 80, 60);
    //ctx.fillText("Hello World!",10,10);
    //ctx.save();  


    //lvTree(option);

    //});

    //function lvTree(option) {
    //    if (!option) {
    //        return;
    //    }

    //    if (option.xAxis) {
    //        var html_lv = '', html_sys = '', html_duty = '';
    //        //添加标题头
    //        $.each(option.xAxis, function (i, n) {
    //            html_lv += '<div>'+ n.name+'</div>';
    //        });
    //        $('.x_axis_div').append(html_lv);

    //        //添加系统
    //        html_sys += '<div data-id="xx01" class="sys_div">';
    //        $.each(option.xAxis, function (i, n) {
    //            html_sys += '<div data-xid="'+ n.id +'"></div>';
    //        });
    //        html_sys += '</div>';

    //        $('.x_axis_div').after(html_sys);

    //        TreeItemAppend($('.dutypanel'), 0, option.data);

    //    }
    //}

    //function TreeItemAppend($ParentTreeNode,xid,data) {
    //    var htmlTree = '';

    //    $.each(data, function (i, n) {
    //        if (n.xid == xid) {
    //            htmlTree += '<div class="tree_div tree_node" data-id="' + n.id + '" data-xid="' + n.xid + '">';
    //            //treehead
    //            htmlTree += '<div class="tree_head tree_div"><div class="item_div" data-id="' + n.id + '">' + n.name + '</div></div>';
    //            htmlTree += '</div>';
    //            $ParentTreeNode.append(htmlTree);

    //            $.each(data, function (ci, cn) {
    //                if (cn.pid == n.id) {

    //                }
    //            });
    //        }
    //    });

    //}
})();