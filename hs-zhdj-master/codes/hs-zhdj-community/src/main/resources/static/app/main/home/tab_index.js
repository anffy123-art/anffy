(function ($app) {
    'use strict';
    $app.module('gtPartyApp').controller('tabsIndexCtrl', function ($scope, $state, $filter, $alert, AuthUser, $http, $ocLazyLoad, $bsRouterState) {

        $scope.tabs=[{
            "title": "首页",
            name:"mainindex",
            templateUrl:"home/mainindex.html",
            controller: "mainindexCtrl",
            resolve: {
                load: ['$ocLazyLoad', function ($ocLazyLoad) {
                    return $ocLazyLoad.load('home/mainindex.js?' + window.sysVersion);
                }]
            }
            },
            {
                "title": "党建",
                name:"partyList",
                templateUrl:"party/list.html",
                controller: "partyListCtrl",
                resolve: {
                    load: ['$ocLazyLoad', function ($ocLazyLoad) {
                        return $ocLazyLoad.load('party/list.js?' + window.sysVersion);
                    }]
                }
            }
        ];

        $scope.tabs.activeTab = "mainindex";

        $bsRouterState.getTest();

        $scope.tabClear=function(tabPane) {
            //var i=$scope.tabs.indexOf(tabPane.panedata);
            var i=$scope.tabs.indexOf(tabPane.panedata);
            //$scope.tabs.splice(i,1);

        };

        $scope.tabClear1=function(tabPane) {
            //var i=$scope.tabs.indexOf(tabPane.panedata);
            $scope.tabs.splice(1,1);

        };

        $scope.addTab=function () {
            $scope.tabs.push({
                name: "home.cgjqSetting_PostareaList",
                "title": "岗区配置",
                templateUrl: "cgjq/setting/postarea/list.html?" + window.sysVersion,
                controller: "cgjqSetting_PostareaListCtrl",
                resolve: {
                    load: ['$ocLazyLoad', function ($ocLazyLoad) {

                        return $ocLazyLoad.load(['cgjq/setting/postarea/list.js?' + window.sysVersion]);
                    }]
                }});
            $scope.tabs.activeTab=$scope.tabs[$scope.tabs.length-1].name;
        };



    }).directive('bsPaneUrl', function ($window, $animate, $sce,$bsCompiler) {
        return {
            require: ['^?ngModel', '^bsTabs'],
            scope: {panedata:'='},
            link: function postLink (scope, element, attrs, controllers) {

                //var ngModelCtrl = controllers[0];
                var bsTabsCtrl = controllers[1];
                //var bsTabsPanelScope=scope.$new();
                var $pane={};

                var paneOptions={};

                angular.extend(paneOptions,scope["panedata"]);

                var promise= $bsCompiler.compile(paneOptions);

                promise.then(function (data) {
                    scope.$tabScope=scope.$new();
                    var paneEl=data.link(scope.$tabScope);
                    paneEl.appendTo(element);
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


                function render () {
                    var index = bsTabsCtrl.$panes.indexOf(scope);
                    if(index>=0){
                        $animate[bsTabsCtrl.$isActive(scope, index) ? 'addClass' : 'removeClass'](element, bsTabsCtrl.$options.activeClass);
                    }

                }

                bsTabsCtrl.$activePaneChangeListeners.push(function () {

                    render();

                });

                render();

            }};
    });
})(angular);