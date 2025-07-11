(function () {
    'use strict';
    angular.module('gtPartyApp').controller("homeTabsCtrl", function ($scope, $state, $http, AuthUser, $bsRouterState, $timeout, $window) {

        $scope.tabClear = function ($pane) {
            $bsRouterState.$closeTab($pane);
            $timeout($scope.scrollBthHasShow, 200);
        }
        $scope.tabs = $bsRouterState.tabs;

        $scope.sysName=window.sysCompanyName;

        //监视页数变化
        $scope.$watch("tabs.activeTab", function (newVal, oldVal) {
            if ($scope.tabs.activeTab != "") {
                $timeout(function () {
                    var $tabPanel = $('div.nav-btn-panel');
                    var $tab_ul = $tabPanel.find('.nav-btn-inline');
                    var active = $tabPanel.find('.active')[0];
                    if (active != undefined)
                        $tab_ul.scrollLeft((active.offsetLeft > $tab_ul[0].offsetWidth ? active.offsetLeft : 0));
                }, 100);

            }
        });

        $scope.scrollLeft = function () {

            $timeout(function () {
                var $tabPanel = $('div.nav-btn-panel');
                var $tab_ul = $tabPanel.find('.nav-btn-inline');
                var left = $tab_ul.scrollLeft();
                left -= 100;
                $tab_ul.scrollLeft(left);
            }, 200);


        };

        $scope.scrollRight = function () {

            $timeout(function () {
                var $tabPanel = $('div.nav-btn-panel');
                var $tab_ul = $tabPanel.find('.nav-btn-inline');
                var left = $tab_ul.scrollLeft();
                $tab_ul.scrollLeft(left + 100);
            }, 200);


        };

        $scope.scrollBthHasShow = function () {
            var $tabPanel = $('div.nav-btn-panel');
            var $tab_btns = $tabPanel.find('.nav-btn');
            if ($tabPanel.find('.nav-btn-inline')[0].scrollWidth > $tabPanel.find('.nav-tabs-body').width()) {
                $tab_btns.show();
            } else {
                $tab_btns.hide();
            }

        };

        $window.addEventListener('message', function (e) {
            //console.log('message:'+e.data);
            if (e.data.method == 'go') {
                $scope.$apply(function () {
                    $bsRouterState.go(e.data.name, e.data.urlData, true);
                });
            }

        }, false);

        /**
         * childData:{name:'xxxx',...}
         */
        $scope.$on("tabReloadData", function (event, data) {
            event.stopPropagation();
            $scope.$broadcast('tabChildReloadData', data);
        });


    }).directive('bsPaneUrl', function ($window, $animate, $sce, $bsCompiler, $alert) {
        return {
            require: ['^?ngModel', '^bsTabs'],
            scope: {panedata: '='},
            link: function postLink(scope, element, attrs, controllers) {

                //var ngModelCtrl = controllers[0];
                var bsTabsCtrl = controllers[1];
                //var bsTabsPanelScope=scope.$new();
                var $pane = {};

                var paneOptions = {};

                scope.showMsg = function (title, content) {
                    $alert({
                        title: title + '：',
                        content: content,
                        placement: 'top',
                        type: 'info',
                        show: true,
                        duration: 3
                    });

                };

                angular.extend(paneOptions, scope["panedata"]);

                var promise = $bsCompiler.compile(paneOptions);

                promise.then(function (data) {
                    //scope.$tabScope=scope.$new();
                    var paneEl = data.link(scope);
                    paneEl.appendTo(element);
                    paneEl.css("min-height", $(window).height() - element.offset().top - 50);
                });

                // Add base class
                element.addClass('tab-pane');


                // Observe title attribute for change
                attrs.$observe('title', function (newValue, oldValue) {

                    scope.title = $sce.trustAsHtml(newValue);

                });

                // Save tab name into scope
                scope.name = attrs.name;

                // Add animation class
                if (bsTabsCtrl.$options.animation) {

                    element.addClass(bsTabsCtrl.$options.animation);

                }


                attrs.$observe('disabled', function (newValue, oldValue) {

                    scope.disabled = scope.$eval(newValue);

                });


                // Push pane to parent bsTabs controller
                bsTabsCtrl.$push(scope);

                // remove pane from tab controller when pane is destroyed
                scope.$on('$destroy', function () {

                    bsTabsCtrl.$remove(scope);
                });


                function render() {
                    var index = bsTabsCtrl.$panes.indexOf(scope);
                    if (index >= 0) {
                        $animate[bsTabsCtrl.$isActive(scope, index) ? 'addClass' : 'removeClass'](element, bsTabsCtrl.$options.activeClass);
                    }
                    if (bsTabsCtrl.$panes.$active == scope.name) {
                        if (scope.reloadData != undefined) {
                            scope.reloadData();
                        }
                    }
                }

                bsTabsCtrl.$activePaneChangeListeners.push(function () {

                    render();

                });

                render();

            }
        };
    }).directive('bsTabPaneHeigth', ['$timeout', function ($timeout) {
        return {
            restrict: 'EAC',
            link: function postLink(scope, element, attrs, controllers) {

                if (scope.$last === true) {
                    $timeout(function () {

                        scope.scrollBthHasShow();
                        /*
                        var menuHeight = $(window).height()-155;
                        var tabContentHeight = $(window).height()-105;

                        angular.element('.main-tab-content').height(tabContentHeight);
                        angular.element(".mainmenu").height(menuHeight);*/

                    }, 200);
                }
            }
        }
    }]);

})();
