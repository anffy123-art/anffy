(function () {
    "use strict";
    angular.module('gtPartyApp', ['ui.router', 'oc.lazyLoad', 'ngSanitize', 'ngAnimate', 'mgcrea.ngStrap', 'ngFileUpload', 'devself.common', 'angularAwesomeSlider']).config(function ($stateProvider, $urlRouterProvider, $modalProvider, $tooltipProvider, $asideProvider, $alertProvider, $qProvider, $bsRouterStateProvider) {

        angular.extend($modalProvider.defaults, {
            animation: 'am-flip-x',
            backdrop: 'static'
        });

        angular.extend($tooltipProvider.defaults, {
            html: true
        });

        angular.extend($asideProvider.defaults, {
            container: 'body',
            html: true
        });

        $qProvider.errorOnUnhandledRejections(false);

        //angular.extend($alertProvider.defaults, {
        //    duration:3
        //});

        $urlRouterProvider.otherwise("/login");

        /*
        添加CSS和JS示例
        resolve: {
            deps:['$ocLazyLoad',function($ocLazyLoad) {
                $ocLazyLoad.load('../modules/index/index.css');//CSS不能包在返回里面
                return [
                    $ocLazyLoad.load('../modules/index/index.js'),
                    $ocLazyLoad.load('../modules/index/others.js')
                ];
            }],
        }
        */

        //设置路由
        $stateProvider.state("login", {
            url: "/login",
            /*templateUrl: "login.html?" + window.sysVersion,
            controller: "loginCtrl",
            resolve: {
                load: ['$ocLazyLoad', function ($ocLazyLoad) {
                    $ocLazyLoad.load('css/login.css?' + window.sysVersion);
                    return $ocLazyLoad.load('login.js?' + window.sysVersion);
                }]
            }*/
            templateUrl: "login.html?" + window.sysVersion,
            controller: "loginECtrl",
            resolve: {
                load: ['$ocLazyLoad', function ($ocLazyLoad) {
                    $ocLazyLoad.load('css/login.css?' + window.sysVersion);
                    return $ocLazyLoad.load('login.js?' + window.sysVersion);
                }]
            }
        }).state("localLogin", {
            url: "/login1",
            templateUrl: "login.html?" + window.sysVersion,
            controller: "loginECtrl",
            resolve: {
                load: ['$ocLazyLoad', function ($ocLazyLoad) {
                    $ocLazyLoad.load('css/login.css?' + window.sysVersion);
                    return $ocLazyLoad.load('login.js?' + window.sysVersion);
                }]
            }
        }).state("homeTabs", {
            url: "/tabindex",
            templateUrl: "home-tabs.html?" + window.sysVersion,
            controller: "homeCtrl",
            resolve: {
                load: ['$ocLazyLoad', function ($ocLazyLoad) {
                    $ocLazyLoad.load(['css/theme1.css?' + window.sysVersion, 'home-tabs.css?' + window.sysVersion, 'css/gt_style.css?' + window.sysVersion]);
                    return $ocLazyLoad.load(['controllers.js?' + window.sysVersion, 'home-tabs.js?' + window.sysVersion]);
                }]
            }
        }).state("home", {
            url: "/?uid",
            templateUrl: "home.html?" + window.sysVersion,
            controller: "homeCtrl",
            resolve: {
                load: ['$ocLazyLoad', function ($ocLazyLoad) {
                    $ocLazyLoad.load(['css/theme1.css?' + window.sysVersion, 'css/gt_style.css?' + window.sysVersion]);
                    return $ocLazyLoad.load('controllers.js?' + window.sysVersion);
                }]
            }

        }).state("home.index", {
            url: "hindex",
            templateUrl: "home/tab_index.html?" + window.sysVersion,
            controller: "tabsIndexCtrl",
            resolve: {
                load: ['$ocLazyLoad', function ($ocLazyLoad) {
                    //return $ocLazyLoad.load('task/index.js?' + window.sysVersion);
                    return $ocLazyLoad.load('home/tab_index.js?' + window.sysVersion);
                }]
            }

        }).state("home.todolist", {
            url: "todolist",
            templateUrl: "home/messagelist.html?" + window.sysVersion,
            controller: "messageCtrl",
            resolve: {
                load: ['$ocLazyLoad', function ($ocLazyLoad) {

                    return $ocLazyLoad.load('home/messagelist.js?' + window.sysVersion);
                }]
            }
        }).state("home.donelist", {
            url: "donelist",
            templateUrl: "task/donelist.html?" + window.sysVersion,
            controller: "donelistCtrl",
            resolve: {
                load: ['$ocLazyLoad', function ($ocLazyLoad) {

                    return $ocLazyLoad.load('task/donelist.js?' + window.sysVersion);
                }]
            }
        }).state("home.demandup", {
            url: "demandup/:pid/:fid/:st?id",
            templateUrl: "dsflow/demandup.html?" + window.sysVersion,
            controller: "demandupCtrl",
            resolve: {
                load: ['$ocLazyLoad', function ($ocLazyLoad) {

                    return $ocLazyLoad.load(['dsflow/demandup.js?' + window.sysVersion]);
                }]
            }
        }).state("home.dictionarylist", {
            url: "dictionarylist/:appid",
            params: {appid: 'f0c4fa7f9f3c4fb6bd56aac608b7ad3f'},
            templateUrl: "../js/setting/DictionaryManage/dictionarylist.html?" + window.sysVersion,
            controller: "dictionarylistCtrl",
            resolve: {
                load: ['$ocLazyLoad', function ($ocLazyLoad) {
                    return $ocLazyLoad.load('../js/setting/DictionaryManage/dictionarylist.js?' + window.sysVersion);
                }]
            }
        }).state("home.syslist", {
            url: "syslist",
            templateUrl: "setting/syslist.html?" + window.sysVersion,
            controller: "syslistController",
            resolve: {
                load: ['$ocLazyLoad', function ($ocLazyLoad) {

                    return $ocLazyLoad.load('setting/syslist.js?' + window.sysVersion);
                }]
            }
        }).state("home.sysDutyList", {
            url: "sysDutyList",
            templateUrl: "setting/sysDuty/sysDutyList.html?" + window.sysVersion,
            controller: "sysDutyListCtrl",
            resolve: {
                load: ['$ocLazyLoad', function ($ocLazyLoad) {

                    return $ocLazyLoad.load(['setting/sysDuty/sysDutyList.js?' + window.sysVersion]);
                }]
            }
        }).state("home.roleList", {
            url: "roleList/:appid",
            params: {appid: 'f0c4fa7f9f3c4fb6bd56aac608b7ad3f'},
            templateUrl: "../js/setting/userRole/roleList.html?" + window.sysVersion,
            controller: "roleListController",
            resolve: {
                load: ['$ocLazyLoad', function ($ocLazyLoad) {
                    return $ocLazyLoad.load('../js/setting/userRole/roleList.js?' + window.sysVersion);
                }]
            }
        }).state("home.booklist", {
            url: "booklist",
            templateUrl: "../main/meetingbook/booklist.html?" + window.sysVersion,
            controller: "booklistController",
            resolve: {
                load: ['$ocLazyLoad', function ($ocLazyLoad) {
                    return $ocLazyLoad.load('../main/meetingbook/booklist.js?' + window.sysVersion);
                }]
            }
        }).state("home.UserManageList", {
            url: "UserManageList",
            templateUrl: "../js/setting/userRole/UserManageList.html?" + window.sysVersion,
            controller: "UserManageListController",
            resolve: {
                load: ['$ocLazyLoad', function ($ocLazyLoad) {

                    return $ocLazyLoad.load('../js/setting/userRole/UserManageList.js?' + window.sysVersion);
                }]
            }

        }).state("home.menumanage", {
            url: "menumanage/:appid",
            params: {appid: 'f0c4fa7f9f3c4fb6bd56aac608b7ad3f'},
            templateUrl: "../js/setting/MenuManage/menuManage.html?" + window.sysVersion,
            controller: "MenuManageCtrl",
            resolve: {
                load: ['$ocLazyLoad', function ($ocLazyLoad) {
                    return $ocLazyLoad.load('../js/setting/MenuManage/menuManage.js?' + window.sysVersion);
                }]
            }
        }).state('home.sysDutyList1', {
            url: "sysDutyList1",
            templateUrl: "../js/setting/sysduty/sdutyplate.html?" + window.sysVersion,
            controller: "sysDutyListCtrl1",
            resolve: {
                load: ['$ocLazyLoad', function ($ocLazyLoad) {

                    return $ocLazyLoad.load(['../js/setting/sysduty/sdutyplate.js?' + window.sysVersion]);
                }]
            }
        }).state("home.wxApiTest", {
            url: "wxapitest",
            templateUrl: "task/wxApiTest.html?" + window.sysVersion,
            controller: "wxApiTestCtrl",
            resolve: {
                load: ['$ocLazyLoad', function ($ocLazyLoad) {
                    return $ocLazyLoad.load(['task/wxApiTest.js?' + window.sysVersion]);
                }]
            }
        }).state("home.mainindex", {
            url: "mainindex",
            templateUrl: "home/mainindex.html?" + window.sysVersion,
            controller: "mainindexCtrl",
            resolve: {
                load: ['$ocLazyLoad', function ($ocLazyLoad) {
                    $ocLazyLoad.load(['../main/css/redmenu.css?' + window.sysVersion]);
                    $ocLazyLoad.load(['../js/setting/payment/payment.css', '../js/setting/payment/payment.js']);
                    return $ocLazyLoad.load('home/mainindex.js?' + window.sysVersion);
                }]
            }

        }).state("home.partyList", {
            url: "partyList?dzzdm",
            templateUrl: "party/list.html?" + window.sysVersion,
            controller: "partyListCtrl",
            resolve: {
                load: ['$ocLazyLoad', function ($ocLazyLoad) {
                    return $ocLazyLoad.load('party/list.js?' + window.sysVersion);
                }]
            }

        }).state("home.editParty", {
            url: "editParty",
            templateUrl: "party/editParty.html?" + window.sysVersion,
            controller: "editPartyCtrl",
            resolve: {
                load: ['$ocLazyLoad', function ($ocLazyLoad) {
                    return $ocLazyLoad.load('party/editParty.js?' + window.sysVersion);
                }]
            }

        }).state("home.partyUserList", {
            url: "partyUserList?xm=?&dzzdm",
            templateUrl: "partyUser/list.html?" + window.sysVersion,
            controller: "partyUserListCtrl",
            resolve: {
                load: ['$ocLazyLoad', function ($ocLazyLoad) {
                    return $ocLazyLoad.load('partyUser/list.js?' + window.sysVersion);
                }]
            }

        }).state("home.dyfzztqk", {
            url: "dyfzztqk?xm=?&dzzdm",
            templateUrl: "partyUser/dyfzztqk/index.html?" + window.sysVersion,
            controller: "dyfzztqkCtrl",
            resolve: {
                load: ['$ocLazyLoad', function ($ocLazyLoad) {
                    return $ocLazyLoad.load('partyUser/dyfzztqk/index.js?' + window.sysVersion);
                }]
            }

        }).state("home.userList", {
            url: "userList",
            templateUrl: "../main/user/userList.html?" + window.sysVersion,
            controller: "userListCtrl",
            resolve: {
                load: ['$ocLazyLoad', function ($ocLazyLoad) {

                    return $ocLazyLoad.load(['../main/user/userList.js?' + window.sysVersion]);
                }]
            }
        }).state("home.educationList", {
            url: "educationList",
            templateUrl: "../main/education/list.html?" + window.sysVersion,
            controller: "educationListCtrl",
            resolve: {
                load: ['$ocLazyLoad', function ($ocLazyLoad) {

                    return $ocLazyLoad.load(['../main/education/list.js?' + window.sysVersion]);
                }]
            }
        }).state("home.publicityList", {
            url: "publicityList",
            templateUrl: "../main/publicity/list.html?" + window.sysVersion,
            controller: "publicityListCtrl",
            resolve: {
                load: ['$ocLazyLoad', function ($ocLazyLoad) {

                    return $ocLazyLoad.load(['../main/publicity/list.js?' + window.sysVersion]);
                }]
            }
        }).state("home.integrityList", {
            url: "integrityList",
            templateUrl: "../main/integrity/list.html?" + window.sysVersion,
            controller: "integrityListCtrl",
            resolve: {
                load: ['$ocLazyLoad', function ($ocLazyLoad) {

                    return $ocLazyLoad.load(['../main/integrity/list.js?' + window.sysVersion]);
                }]
            }
        }).state("home.leagueList", {
            url: "leagueList",
            templateUrl: "../main/league/list.html?" + window.sysVersion,
            controller: "leagueListCtrl",
            resolve: {
                load: ['$ocLazyLoad', function ($ocLazyLoad) {

                    return $ocLazyLoad.load(['../main/league/list.js?' + window.sysVersion]);
                }]
            }
        }).state("home.partyGroupList", {
            url: "partyGroupList",
            templateUrl: "../main/party/partyGroup/list.html?" + window.sysVersion,
            controller: "partyGroupListCtrl",
            resolve: {
                load: ['$ocLazyLoad', function ($ocLazyLoad) {

                    return $ocLazyLoad.load(['../main/party/partyGroup/list.js?' + window.sysVersion]);
                }]
            }
        }).state("home.dyUserAdd", {
            url: "dyUserAdd?userId",
            templateUrl: "partyUser/edit.html?" + window.sysVersion,
            controller: "partyUserEditCtrl",
            resolve: {
                load: ['$ocLazyLoad', function ($ocLazyLoad) {

                    return $ocLazyLoad.load(['partyUser/edit.js?' + window.sysVersion]);
                }]
            }
        }).state("home.dyUserEdit", {
            url: "dyUserEdit?userId&userType&isDetail",
            templateUrl: "partyUser/edit.html?" + window.sysVersion,
            controller: "partyUserEditCtrl",
            resolve: {
                load: ['$ocLazyLoad', function ($ocLazyLoad) {

                    return $ocLazyLoad.load(['partyUser/edit.js?' + window.sysVersion]);
                }]
            }
        }).state("home.shykAdd", {
            url: "shykAdd?id&shykType&dzzdm",
            templateUrl: "shyk/edit.html?" + window.sysVersion,
            controller: "shykEditCtrl",
            resolve: {
                load: ['$ocLazyLoad', function ($ocLazyLoad) {

                    return $ocLazyLoad.load(['shyk/edit.js?' + window.sysVersion]);
                }]
            }
        }).state("home.shykEdit", {
            url: "shykEdit?id&shykType&dzzdm",
            templateUrl: "shyk/edit.html?" + window.sysVersion,
            controller: "shykEditCtrl",
            resolve: {
                load: ['$ocLazyLoad', function ($ocLazyLoad) {

                    return $ocLazyLoad.load(['shyk/edit.js?' + window.sysVersion]);
                }]
            }
        }).state("home.shykAudit", {
            url: "shykAudit?id&shykType",
            templateUrl: "shyk/audit.html?" + window.sysVersion,
            controller: "shykMeetingAuditCtrl",
            resolve: {
                load: ['$ocLazyLoad', function ($ocLazyLoad) {

                    return $ocLazyLoad.load(['shyk/audit.js?' + window.sysVersion]);
                }]
            }
        }).state("home.shykShow", {
            url: "shykShow?id&shykType",
            templateUrl: "shyk/show.html?" + window.sysVersion,
            controller: "shykShowCtrl",
            resolve: {
                load: ['$ocLazyLoad', function ($ocLazyLoad) {

                    return $ocLazyLoad.load(['shyk/show.js?' + window.sysVersion]);
                }]
            }
        }).state("home.shykDecisionEdit", {
            url: "shykDecisionEdit?id&shykType",
            templateUrl: "shyk/decisionEdit.html?" + window.sysVersion,
            controller: "shykDecisionEditCtrl",
            resolve: {
                load: ['$ocLazyLoad', function ($ocLazyLoad) {

                    return $ocLazyLoad.load(['shyk/decisionEdit.js?' + window.sysVersion]);
                }]
            }
        }).state("home.shykDecisionAudit", {
            url: "shykDecisionAudit?id&shykType",
            templateUrl: "shyk/decisionAudit.html?" + window.sysVersion,
            controller: "shykDecisionAuditCtrl",
            resolve: {
                load: ['$ocLazyLoad', function ($ocLazyLoad) {

                    return $ocLazyLoad.load(['shyk/decisionAudit.js?' + window.sysVersion]);
                }]
            }
        }).state("home.shykMeetingRecordEdit", {
            url: "shykMeetingRecordEdit?id&shykType",
            templateUrl: "shyk/recordEdit.html?" + window.sysVersion,
            controller: "shykMeetingRecordEditCtrl",
            resolve: {
                load: ['$ocLazyLoad', function ($ocLazyLoad) {

                    return $ocLazyLoad.load(['shyk/recordEdit.js?' + window.sysVersion]);
                }]
            }
        }).state("home.shykMeetingSignin", {
            url: "shykMeetingSignin?id&shykType&op",
            templateUrl: "shyk/signin.html?" + window.sysVersion,
            controller: "shykMeetingSigninCtrl",
            resolve: {
                load: ['$ocLazyLoad', function ($ocLazyLoad) {

                    return $ocLazyLoad.load(['shyk/signin.js?' + window.sysVersion]);
                }]
            }
        }).state("home.shykMeetingStudy", {
            url: "shykMeetingStudy?id&shykType&op",
            templateUrl: "shyk/study.html?" + window.sysVersion,
            controller: "shykMeetingStudyCtrl",
            resolve: {
                load: ['$ocLazyLoad', function ($ocLazyLoad) {

                    return $ocLazyLoad.load(['shyk/study.js?' + window.sysVersion]);
                }]
            }
        }).state("home.shykMeetingAuditDecision", {
            url: "shykMeetingAuditDecision?id&shykType&meetingdecisionid",
            templateUrl: "shyk/decisionAudit.html?" + window.sysVersion,
            controller: "shykMeetingAuditDecisionCtrl",
            resolve: {
                load: ['$ocLazyLoad', function ($ocLazyLoad) {

                    return $ocLazyLoad.load(['shyk/decisionAudit.js?' + window.sysVersion]);
                }]
            }
        }).state("home.shykMeetingList", {
            url: "shykMeetingList",
            params: {},
            templateUrl: "shyk/meetingList.html?" + window.sysVersion,
            controller: "shykMeetingListCtrl",
            resolve: {
                load: ['$ocLazyLoad', function ($ocLazyLoad) {

                    return $ocLazyLoad.load(['shyk/meetingList.js?' + window.sysVersion]);
                }]
            }
        }).state("home.learningPlan", {
            url: "learningPlan",
            params: {},
            templateUrl: "centralGroup/learningPlan/list.html?" + window.sysVersion,
            controller: "learningPlanListCtrl",
            resolve: {
                load: ['$ocLazyLoad', function ($ocLazyLoad) {

                    return $ocLazyLoad.load(['centralGroup/learningPlan/list.js?' + window.sysVersion]);
                }]
            }
        }).state("home.learningPlanAdd", {
            url: "learningPlanAdd",
            templateUrl: "centralGroup/learningPlan/edit.html?" + window.sysVersion,
            controller: "learningPlanEditCtrl",
            resolve: {
                load: ['$ocLazyLoad', function ($ocLazyLoad) {

                    return $ocLazyLoad.load(['centralGroup/learningPlan/edit.js?' + window.sysVersion]);
                }]
            }
        }).state("home.learningPlanEdit", {
            url: "learningPlanEdit?id&state",
            templateUrl: "centralGroup/learningPlan/edit.html?" + window.sysVersion,
            controller: "learningPlanEditCtrl",
            resolve: {
                load: ['$ocLazyLoad', function ($ocLazyLoad) {

                    return $ocLazyLoad.load(['centralGroup/learningPlan/edit.js?' + window.sysVersion]);
                }]
            }
        }).state("home.learningPlanDetails", {
            url: "learningPlanDetails?id&d",
            templateUrl: "centralGroup/learningPlan/details.html?" + window.sysVersion,
            controller: "learningPlanDetailsCtrl",
            resolve: {
                load: ['$ocLazyLoad', function ($ocLazyLoad) {

                    return $ocLazyLoad.load(['centralGroup/learningPlan/details.js?' + window.sysVersion]);
                }]
            }
        }).state("home.learningPlanReceive", {
            url: "learningPlanReceive",
            params: {},
            templateUrl: "centralGroup/learningPlanReceive/list.html?" + window.sysVersion,
            controller: "learningPlanReceiveListCtrl",
            resolve: {
                load: ['$ocLazyLoad', function ($ocLazyLoad) {

                    return $ocLazyLoad.load(['centralGroup/learningPlanReceive/list.js?' + window.sysVersion]);
                }]
            }
        }).state("home.learningPlanReceiveDetails", {
            url: "learningPlanReceiveDetails?id",
            templateUrl: "centralGroup/learningPlanReceive/details.html?" + window.sysVersion,
            controller: "learningPlanReceiveDetailsCtrl",
            resolve: {
                load: ['$ocLazyLoad', function ($ocLazyLoad) {

                    return $ocLazyLoad.load(['centralGroup/learningPlanReceive/details.js?' + window.sysVersion]);
                }]
            }
        }).state("home.programme", {
            url: "programme?dzzdm",
            params: {"type": 2},
            templateUrl: "centralGroup/programme/list.html?" + window.sysVersion,
            controller: "programmeListCtrl",
            resolve: {
                load: ['$ocLazyLoad', function ($ocLazyLoad) {

                    return $ocLazyLoad.load(['centralGroup/programme/list.js?' + window.sysVersion]);
                }]
            }
        }).state("home.programmeAdd", {
            url: "programmeAdd?id&dzzdm&dzzmc",
            templateUrl: "centralGroup/programme/edit.html?" + window.sysVersion,
            controller: "programmeEditCtrl",
            resolve: {
                load: ['$ocLazyLoad', function ($ocLazyLoad) {

                    return $ocLazyLoad.load(['centralGroup/programme/edit.js?' + window.sysVersion]);
                }]
            }
        }).state("home.programmeEdit", {
            url: "programmeEdit?id",
            templateUrl: "centralGroup/programme/edit.html?" + window.sysVersion,
            controller: "programmeEditCtrl",
            resolve: {
                load: ['$ocLazyLoad', function ($ocLazyLoad) {

                    return $ocLazyLoad.load(['centralGroup/programme/edit.js?' + window.sysVersion]);
                }]
            }
        }).state("home.programmeDetails", {
            url: "programmeDetails?id",
            templateUrl: "centralGroup/programme/details.html?" + window.sysVersion,
            controller: "programmeDetailsCtrl",
            resolve: {
                load: ['$ocLazyLoad', function ($ocLazyLoad) {

                    return $ocLazyLoad.load(['centralGroup/programme/details.js?' + window.sysVersion]);
                }]
            }
        }).state("home.LearningSituation", {
            url: "LearningSituation?studType",
            params: {"type": 2},
            templateUrl: "centralGroup/LearningSituation/list.html?" + window.sysVersion,
            controller: "LearningSituationListCtrl",
            resolve: {
                load: ['$ocLazyLoad', function ($ocLazyLoad) {

                    return $ocLazyLoad.load(['centralGroup/LearningSituation/list.js?' + window.sysVersion]);
                }]
            }
        }).state("home.LearningSituationDetails", {
            url: "LearningSituationDetails?id",
            params: {},
            templateUrl: "centralGroup/LearningSituation/details.html?" + window.sysVersion,
            controller: "LearningSituationDetailsCtrl",
            resolve: {
                load: ['$ocLazyLoad', function ($ocLazyLoad) {

                    return $ocLazyLoad.load(['centralGroup/LearningSituation/details.js?' + window.sysVersion]);
                }]
            }
        }).state("home.member", {
            url: "membhome.djPartyActivityRoomEditer",
            params: {"type": 2},
            templateUrl: "centralGroup/member/list.html?" + window.sysVersion,
            controller: "memberListCtrl",
            resolve: {
                load: ['$ocLazyLoad', function ($ocLazyLoad) {

                    return $ocLazyLoad.load(['centralGroup/member/list.js?' + window.sysVersion]);
                }]
            }
        }).state("home.memberAdd", {
            url: "memberAdd?dzzdm&dzzmc",
            templateUrl: "centralGroup/member/edit.html?" + window.sysVersion,
            controller: "memberEditCtrl",
            resolve: {
                load: ['$ocLazyLoad', function ($ocLazyLoad) {

                    return $ocLazyLoad.load(['centralGroup/member/edit.js?' + window.sysVersion]);
                }]
            }
        }).state("home.learningData", {
            url: "learningData",
            params: {"type": 2},
            templateUrl: "centralGroup/learningData/list.html?" + window.sysVersion,
            controller: "learningDataListCtrl",
            resolve: {
                load: ['$ocLazyLoad', function ($ocLazyLoad) {

                    return $ocLazyLoad.load(['centralGroup/learningData/list.js?' + window.sysVersion]);
                }]
            }
        }).state("home.learningSecretary", {
            url: "learningSecretary",
            params: {},
            templateUrl: "centralGroup/learningSecretary/list.html?" + window.sysVersion,
            controller: "learningSecretaryListCtrl",
            resolve: {
                load: ['$ocLazyLoad', function ($ocLazyLoad) {

                    return $ocLazyLoad.load(['centralGroup/learningSecretary/list.js?' + window.sysVersion]);
                }]
            }
        }).state("home.learningSecretaryAdd", {
            url: "learningSecretaryAdd?id&dzzdm&dwName&rydm&msName",
            templateUrl: "centralGroup/learningSecretary/edit.html?" + window.sysVersion,
            controller: "learningSecretaryEditCtrl",
            resolve: {
                load: ['$ocLazyLoad', function ($ocLazyLoad) {

                    return $ocLazyLoad.load(['centralGroup/learningSecretary/edit.js?' + window.sysVersion]);
                }]
            }
        }).state("home.ysjyb", {
            url: "ysjyb",
            templateUrl: "dwb/ysjyblist.html?" + window.sysVersion,
            controller: "ysjyblistCtrl",
            resolve: {
                load: ['$ocLazyLoad', function ($ocLazyLoad) {

                    return $ocLazyLoad.load(['dwb/ysjyblist.js?' + window.sysVersion]);
                }]
            }
        }).state("home.ysjybedit", {
            url: "ysjybedit?nd",
            templateUrl: "dwb/ysjybedit.html?" + window.sysVersion,
            controller: "ysjybeditCtrl",
            resolve: {
                load: ['$ocLazyLoad', function ($ocLazyLoad) {

                    return $ocLazyLoad.load(['dwb/ysjybedit.js?' + window.sysVersion]);
                }]
            }
        }).state("home.hdbz", {
            url: "hdbz",
            templateUrl: "dwb/hdbzlist.html?" + window.sysVersion,
            controller: "hdbzlistCtrl",
            resolve: {
                load: ['$ocLazyLoad', function ($ocLazyLoad) {

                    return $ocLazyLoad.load(['dwb/hdbzlist.js?' + window.sysVersion]);
                }]
            }
        }).state("home.cgjqSetting_PostareaList", {
            url: "cgjqSetting_PostareaList",
            templateUrl: "cgjq/setting/postarea/list.html?" + window.sysVersion,
            controller: "cgjqSetting_PostareaListCtrl",
            resolve: {
                load: ['$ocLazyLoad', function ($ocLazyLoad) {

                    return $ocLazyLoad.load(['cgjq/setting/postarea/list.js?' + window.sysVersion]);
                }]
            }
        }).state("home.cgjqSetting_ProjectList1", {
            url: "cgjqSetting_ProjectList1",
            params: {"type": 1},
            templateUrl: "cgjq/setting/scoreproject/list-jt.html?" + window.sysVersion,
            controller: "cgjqSetting_ProjectListCtrl",
            resolve: {
                load: ['$ocLazyLoad', function ($ocLazyLoad) {

                    return $ocLazyLoad.load(['cgjq/setting/scoreproject/list.js?' + window.sysVersion]);
                }]
            }
        }).state("home.cgjqSetting_ProjectList2", {
            url: "cgjqSetting_ProjectList2?cgjqType",
            params: {"type": 2},
            templateUrl: "cgjq/setting/scoreproject/list-dzb.html?" + window.sysVersion,
            controller: "cgjqSetting_ProjectListCtrl",
            resolve: {
                load: ['$ocLazyLoad', function ($ocLazyLoad) {

                    return $ocLazyLoad.load(['cgjq/setting/scoreproject/list.js?' + window.sysVersion]);
                }]
            }
        }).state("home.cgjqScoreList", {
            url: "cgjqScoreList",
            templateUrl: "cgjq/score/scoreedit/list.html?" + window.sysVersion,
            controller: "cgjqScoreListCtrl",
            resolve: {
                load: ['$ocLazyLoad', function ($ocLazyLoad) {

                    return $ocLazyLoad.load(['cgjq/score/scoreedit/list.js?' + window.sysVersion]);
                }]
            }
        }).state("home.cgjqScoreEdit", {
            url: "cgjqScoreEdit?id&cgjqType&dzzdm&isDetail",
            templateUrl: "cgjq/score/scoreedit/edit.html?" + window.sysVersion,
            controller: "cgjqScoreEditCtrl",
            resolve: {
                load: ['$ocLazyLoad', function ($ocLazyLoad) {

                    return $ocLazyLoad.load(['cgjq/score/scoreedit/edit.js?' + window.sysVersion]);
                }]
            }
        }).state("home.cgjqScoreSort", {
            url: "cgjqScoreSort",
            templateUrl: "cgjq/score/scoresort/list.html?" + window.sysVersion,
            controller: "cgjqScoreSortCtrl",
            resolve: {
                load: ['$ocLazyLoad', function ($ocLazyLoad) {

                    return $ocLazyLoad.load(['cgjq/score/scoresort/list.js?' + window.sysVersion]);
                }]
            }
        }).state("home.cgjqScoreShow", {
            url: "cgjqScoreShow?id&cgjqType&dzzdm",
            templateUrl: "cgjq/score/scoreedit/show.html?" + window.sysVersion,
            controller: "cgjqScoreShowCtrl",
            resolve: {
                load: ['$ocLazyLoad', function ($ocLazyLoad) {

                    return $ocLazyLoad.load(['cgjq/score/scoreedit/show.js?' + window.sysVersion]);
                }]
            }
        }).state("home.dzzgly", {
            url: "dzzgly",
            templateUrl: "dwb/dzzry/list.html?" + window.sysVersion,
            controller: "dzzglyListCtrl",
            resolve: {
                load: ['$ocLazyLoad', function ($ocLazyLoad) {

                    return $ocLazyLoad.load(['dwb/dzzry/list.js?' + window.sysVersion]);
                }]
            }
        }).state("home.dzzglyedit", {
            url: "dzzglyedit?dzzdm&dwName&leader&leaderName",
            templateUrl: "dwb/dzzry/edit.html?" + window.sysVersion,
            controller: "dzzglyEditCtrl",
            resolve: {
                load: ['$ocLazyLoad', function ($ocLazyLoad) {

                    return $ocLazyLoad.load(['dwb/dzzry/edit.js?' + window.sysVersion]);
                }]
            }
        }).state("home.zgyg", {
            url: "zgyg",
            templateUrl: "dwb/zgyg/list.html?" + window.sysVersion,
            controller: "zgygListCtrl",
            resolve: {
                load: ['$ocLazyLoad', function ($ocLazyLoad) {

                    return $ocLazyLoad.load(['dwb/zgyg/list.js?' + window.sysVersion]);
                }]
            }
        }).state("home.zgygedit", {
            url: "zgygedit?zgtgid",
            templateUrl: "dwb/zgyg/edit.html?" + window.sysVersion,
            controller: "zgygEditCtrl",
            resolve: {
                load: ['$ocLazyLoad', function ($ocLazyLoad) {

                    return $ocLazyLoad.load(['dwb/zgyg/edit.js?' + window.sysVersion]);
                }]
            }
        }).state("home.zgygview", {
            url: "zgygview?businessid",
            templateUrl: "dwb/zgyg/view.html?" + window.sysVersion,
            controller: "zgygEditCtrl",
            resolve: {
                load: ['$ocLazyLoad', function ($ocLazyLoad) {

                    return $ocLazyLoad.load(['dwb/zgyg/edit.js?' + window.sysVersion]);
                }]
            }
        }).state("home.ygqkreply", {
            url: "ygqkreply?businessid&messageid" + window.sysVersion,
            templateUrl: "dwb/zgyg/ygqkreply.html?" + window.sysVersion,
            controller: "ygqkreplyCtrl",
            resolve: {
                load: ['$ocLazyLoad', function ($ocLazyLoad) {

                    return $ocLazyLoad.load(['dwb/zgyg/ygqkreply.js?' + window.sysVersion]);
                }]
            }
        }).state("home.ygqk", {
            url: "ygqk",
            templateUrl: "dwb/ygqk/list.html?" + window.sysVersion,
            controller: "ygqkListCtrl",
            resolve: {
                load: ['$ocLazyLoad', function ($ocLazyLoad) {

                    return $ocLazyLoad.load(['dwb/ygqk/list.js?' + window.sysVersion]);
                }]
            }
        }).state("home.fqtg", {
            url: "fqtg?vs",
            params: {"type": 2},
            templateUrl: "dwb/fqtg/list.html?" + window.sysVersion,
            controller: "fqtgListCtrl",
            resolve: {
                load: ['$ocLazyLoad', function ($ocLazyLoad) {

                    return $ocLazyLoad.load(['dwb/fqtg/list.js?' + window.sysVersion]);
                }]
            }
        }).state("home.fqtgedit", {
            url: "fqtgedit?fqtgid&ygqkid&ygmc&businessid",
            templateUrl: "dwb/fqtg/edit.html?" + window.sysVersion,
            controller: "fqtgEditCtrl",
            resolve: {
                load: ['$ocLazyLoad', function ($ocLazyLoad) {

                    return $ocLazyLoad.load(['dwb/fqtg/edit.js?' + window.sysVersion]);
                }]
            }
        }).state("home.fqtgapprove", {
            url: "fqtgapprove?fqtgid&businessid&messageid",
            templateUrl: "dwb/fqtg/approve.html?" + window.sysVersion,
            controller: "fqtgEditCtrl",
            resolve: {
                load: ['$ocLazyLoad', function ($ocLazyLoad) {

                    return $ocLazyLoad.load(['dwb/fqtg/edit.js?' + window.sysVersion]);
                }]
            }
        }).state("home.fqtgsummary", {
            url: "fqtgsummary",
            templateUrl: "dwb/fqtg/summary.html?" + window.sysVersion,
            controller: "fqtgsummaryCtrl",
            resolve: {
                load: ['$ocLazyLoad', function ($ocLazyLoad) {

                    return $ocLazyLoad.load(['dwb/fqtg/summary.js?' + window.sysVersion]);
                }]
            }
        }).state("home.logList", {
            url: "logList",
            templateUrl: "../main/systemManage/logManage/list.html?" + window.sysVersion,
            controller: "logListCtrl",
            resolve: {
                load: ['$ocLazyLoad', function ($ocLazyLoad) {

                    return $ocLazyLoad.load(['../main/systemManage/logManage/list.js?' + window.sysVersion]);
                }]
            }
        }).state("home.pe_UserTotal", {
            url: "pe_UserTotal",
            templateUrl: "../main/partyExpand/total/total.html?" + window.sysVersion,
            controller: "peJoinUserTotalCtrl",
            resolve: {
                load: ['$ocLazyLoad', function ($ocLazyLoad) {

                    return $ocLazyLoad.load(['../main/partyExpand/total/total.js?' + window.sysVersion]);
                }]
            }
        }).state("home.DjResultMgList", {
            url: "resultmgList",
            templateUrl: "partyTwoExt/resultMg/list.html?" + window.sysVersion,
            controller: "djResultmgListCtrl",
            resolve: {
                load: ['$ocLazyLoad', function ($ocLazyLoad) {

                    return $ocLazyLoad.load(['partyTwoExt/resultMg/list.js?' + window.sysVersion]);
                }]
            }
        }).state("home.djResultmgEdit", {
            url: "resultmgEdit?id&pc",
            templateUrl: "partyTwoExt/resultMg/edit.html?" + window.sysVersion,
            controller: "djResultmgEditCtrl",
            resolve: {
                load: ['$ocLazyLoad', function ($ocLazyLoad) {

                    return $ocLazyLoad.load(['partyTwoExt/resultMg/edit.js?' + window.sysVersion]);
                }]
            }
        }).state("home.mzpyxx", {
            url: "mzpyxx",
            templateUrl: "../main/partyTwoExt/mzpyxx/list.html?" + window.sysVersion,
            controller: "mzpyxxCtrl",
            resolve: {
                load: ['$ocLazyLoad', function ($ocLazyLoad) {
                    $ocLazyLoad.load(['../main/partyTwoExt/mzpyxx/edit.js?' + window.sysVersion]);
                    return $ocLazyLoad.load(['../main/partyTwoExt/mzpyxx/list.js?' + window.sysVersion]);
                }]
            }
        }).state("home.zzsr", {
            url: "zzsr",
            templateUrl: "../main/partyTwoExt/zzsr/list.html?" + window.sysVersion,
            controller: "zzsrCtrl",
            resolve: {
                load: ['$ocLazyLoad', function ($ocLazyLoad) {

                    return $ocLazyLoad.load(['../main/partyTwoExt/zzsr/list.js?' + window.sysVersion]);
                }]
            }
        }).state("home.zzsredit", {
            url: "zzsredit?id&dzzdm&dzzmc&isDetail",
            templateUrl: "../main/partyTwoExt/zzsr/edit.html?" + window.sysVersion,
            controller: "zzsreditCtrl",
            resolve: {
                load: ['$ocLazyLoad', function ($ocLazyLoad) {

                    return $ocLazyLoad.load(['../main/partyTwoExt/zzsr/edit.js?' + window.sysVersion]);
                }]
            }
        }).state("home.zzsrview", {
            url: "zzsrview?id&dzzdm&dzzmc&isDetail",
            templateUrl: "../main/partyTwoExt/zzsr/view.html?" + window.sysVersion,
            controller: "zzsreditCtrl",
            resolve: {
                load: ['$ocLazyLoad', function ($ocLazyLoad) {

                    return $ocLazyLoad.load(['../main/partyTwoExt/zzsr/edit.js?' + window.sysVersion]);
                }]
            }
        }).state("home.gdwydqk", {
            url: "gdwydqk",
            templateUrl: "../main/partyTwoExt/gdwydqk/list.html?" + window.sysVersion,
            controller: "gdwydqkCtrl",
            resolve: {
                load: ['$ocLazyLoad', function ($ocLazyLoad) {

                    return $ocLazyLoad.load(['../main/partyTwoExt/gdwydqk/list.js?' + window.sysVersion]);
                }]
            }
        }).state("home.djkpxx", {
            url: "djkpxx",
            templateUrl: "../main/partyTwoExt/djkpxx/list.html?" + window.sysVersion,
            controller: "djkpxxCtrl",
            params: {'type': 1},
            resolve: {
                load: ['$ocLazyLoad', function ($ocLazyLoad) {

                    return $ocLazyLoad.load(['../main/partyTwoExt/djkpxx/list.js?' + window.sysVersion]);
                }]
            }
        }).state("home.djkpxxedit", {
            url: "djkpxxedit?id&dzzdm&dzzmc&isDetail&type",
            templateUrl: "../main/partyTwoExt/djkpxx/edit.html?" + window.sysVersion,
            controller: "djkpxxeditCtrl",
            resolve: {
                load: ['$ocLazyLoad', function ($ocLazyLoad) {

                    return $ocLazyLoad.load(['../main/partyTwoExt/djkpxx/edit.js?' + window.sysVersion]);
                }]
            }
        }).state("home.djkpxxview", {
            url: "djkpxxview?id&dzzdm&dzzmc&isDetail&type",
            templateUrl: "../main/partyTwoExt/djkpxx/view.html?" + window.sysVersion,
            controller: "djkpxxeditCtrl",
            resolve: {
                load: ['$ocLazyLoad', function ($ocLazyLoad) {

                    return $ocLazyLoad.load(['../main/partyTwoExt/djkpxx/edit.js?' + window.sysVersion]);
                }]
            }
        }).state("home.djkpxxDZB", {
            url: "djkpxxDZB",
            templateUrl: "../main/partyTwoExt/djkpxx/list.html?" + window.sysVersion,
            controller: "djkpxxCtrl",
            params: {'type': 2},
            resolve: {
                load: ['$ocLazyLoad', function ($ocLazyLoad) {

                    return $ocLazyLoad.load(['../main/partyTwoExt/djkpxx/list.js?' + window.sysVersion]);
                }]
            }
        }).state("home.djkpxxeditDZB", {
            url: "djkpxxeditDZB?id&dzzdm&dzzmc&isDetail&type",
            templateUrl: "../main/partyTwoExt/djkpxx/edit.html?" + window.sysVersion,
            controller: "djkpxxeditCtrl",
            resolve: {
                load: ['$ocLazyLoad', function ($ocLazyLoad) {

                    return $ocLazyLoad.load(['../main/partyTwoExt/djkpxx/edit.js?' + window.sysVersion]);
                }]
            }
        }).state("home.djkpBatch", {
            url: "djkpBatch",
            templateUrl: "../main/partyTwoExt/djkpxx/batch.html?" + window.sysVersion,
            controller: "djkpBatchCtrl",
            resolve: {
                load: ['$ocLazyLoad', function ($ocLazyLoad) {

                    return $ocLazyLoad.load(['../main/partyTwoExt/djkpxx/batch.js?' + window.sysVersion]);
                }]
            }
        }).state("home.userThoughtList", {
            url: "userThoughtList?bt&dzzdm",
            templateUrl: "../main/publicity/userThought/list.html?" + window.sysVersion,
            controller: "userThoughtListCtrl",
            resolve: {
                load: ['$ocLazyLoad', function ($ocLazyLoad) {

                    return $ocLazyLoad.load(['../main/publicity/userThought/list.js?' + window.sysVersion]);
                }]
            }
        }).state("home.userThoughtAdd", {
            url: "userThoughtAdd?id&dzzdm",
            templateUrl: "../main/publicity/userThought/edit.html?" + window.sysVersion,
            controller: "userThoughtEditCtrl",
            resolve: {
                load: ['$ocLazyLoad', function ($ocLazyLoad) {

                    return $ocLazyLoad.load(['../main/publicity/userThought/edit.js?' + window.sysVersion]);
                }]
            }
        }).state("home.userThoughtEdit", {
            url: "userThoughtEdit?id&dzzdm",
            templateUrl: "../main/publicity/userThought/edit.html?" + window.sysVersion,
            controller: "userThoughtEditCtrl",
            resolve: {
                load: ['$ocLazyLoad', function ($ocLazyLoad) {

                    return $ocLazyLoad.load(['../main/publicity/userThought/edit.js?' + window.sysVersion]);
                }]
            }
        }).state("home.userThoughtShow", {
            url: "userThoughtShow?id&dzzdm&op",
            templateUrl: "../main/publicity/userThought/edit.html?" + window.sysVersion,
            controller: "userThoughtEditCtrl",
            resolve: {
                load: ['$ocLazyLoad', function ($ocLazyLoad) {

                    return $ocLazyLoad.load(['../main/publicity/userThought/edit.js?' + window.sysVersion]);
                }]
            }
        }).state("home.userThoughtTotalList", {
            url: "userThoughtTotalList",
            templateUrl: "../main/publicity/userThought/totalList.html?" + window.sysVersion,
            controller: "userThoughtTotalListCtrl",
            resolve: {
                load: ['$ocLazyLoad', function ($ocLazyLoad) {

                    return $ocLazyLoad.load(['../main/publicity/userThought/totalList.js?' + window.sysVersion]);
                }]
            }
        }).state("home.userThoughtSummary", {
            url: "userThoughtSummary",
            templateUrl: "../main/publicity/userThought/summary.html?" + window.sysVersion,
            controller: "summaryCtrl",
            resolve: {
                load: ['$ocLazyLoad', function ($ocLazyLoad) {

                    return $ocLazyLoad.load(['../main/publicity/userThought/summary.js?' + window.sysVersion]);
                }]
            }
        }).state("home.userThoughtTotalAdd", {
            url: "userThoughtTotalAdd?id&dzzdm",
            templateUrl: "../main/publicity/userThought/totalEdit.html?" + window.sysVersion,
            controller: "userThoughtTotalEditCtrl",
            resolve: {
                load: ['$ocLazyLoad', function ($ocLazyLoad) {

                    return $ocLazyLoad.load(['../main/publicity/userThought/totalEdit.js?' + window.sysVersion]);
                }]
            }
        }).state("home.userThoughtTotalEdit", {
            url: "userThoughtTotalEdit?id&dzzdm",
            templateUrl: "../main/publicity/userThought/totalEdit.html?" + window.sysVersion,
            controller: "userThoughtTotalEditCtrl",
            resolve: {
                load: ['$ocLazyLoad', function ($ocLazyLoad) {

                    return $ocLazyLoad.load(['../main/publicity/userThought/totalEdit.js?' + window.sysVersion]);
                }]
            }
        }).state("home.userThoughtTotalShow", {
            url: "userThoughtTotalShow?id&dzzdm&op",
            templateUrl: "../main/publicity/userThought/totalEdit.html?" + window.sysVersion,
            controller: "userThoughtTotalEditCtrl",
            resolve: {
                load: ['$ocLazyLoad', function ($ocLazyLoad) {

                    return $ocLazyLoad.load(['../main/publicity/userThought/totalEdit.js?' + window.sysVersion]);
                }]
            }
        }).state("home.userLeaderList", {
            url: "userLeaderList?leaderType&xm&rybm",
            templateUrl: "../main/publicity/userLeader/list.html?" + window.sysVersion,
            controller: "userLeaderListCtrl",
            resolve: {
                load: ['$ocLazyLoad', function ($ocLazyLoad) {

                    return $ocLazyLoad.load(['../main/publicity/userLeader/list.js?' + window.sysVersion]);
                }]
            }
        }).state("home.userLeaderAdd", {
            url: "userLeaderAdd?id&dzzdm",
            templateUrl: "../main/publicity/userLeader/edit.html?" + window.sysVersion,
            controller: "userLeaderEditCtrl",
            resolve: {
                load: ['$ocLazyLoad', function ($ocLazyLoad) {

                    return $ocLazyLoad.load(['../main/publicity/userLeader/edit.js?' + window.sysVersion]);
                }]
            }
        }).state("home.userLeaderEdit", {
            url: "userLeaderEdit?id&dzzdm",
            templateUrl: "../main/publicity/userLeader/edit.html?" + window.sysVersion,
            controller: "userLeaderEditCtrl",
            resolve: {
                load: ['$ocLazyLoad', function ($ocLazyLoad) {

                    return $ocLazyLoad.load(['../main/publicity/userLeader/edit.js?' + window.sysVersion]);
                }]
            }
        }).state("home.userLeaderShow", {
            url: "userLeaderShow?id&dzzdm&op",
            templateUrl: "../main/publicity/userLeader/edit.html?" + window.sysVersion,
            controller: "userLeaderEditCtrl",
            resolve: {
                load: ['$ocLazyLoad', function ($ocLazyLoad) {

                    return $ocLazyLoad.load(['../main/publicity/userLeader/edit.js?' + window.sysVersion]);
                }]
            }
        }).state("home.partyOutlayList", {
            url: "partyOutlayList",
            templateUrl: "../main/publicity/partyOutlay/list.html?" + window.sysVersion,
            controller: "partyOutlayListCtrl",
            resolve: {
                load: ['$ocLazyLoad', function ($ocLazyLoad) {

                    return $ocLazyLoad.load(['../main/publicity/partyOutlay/list.js?' + window.sysVersion]);
                }]
            }
        }).state("home.partyOutlayAdd", {
            url: "partyOutlayAdd?id&dzzdm",
            templateUrl: "../main/publicity/partyOutlay/edit.html?" + window.sysVersion,
            controller: "partyOutlayEditCtrl",
            resolve: {
                load: ['$ocLazyLoad', function ($ocLazyLoad) {

                    return $ocLazyLoad.load(['../main/publicity/partyOutlay/edit.js?' + window.sysVersion]);
                }]
            }
        }).state("home.partyOutlayEdit", {
            url: "partyOutlayEdit?id&dzzdm",
            templateUrl: "../main/publicity/partyOutlay/edit.html?" + window.sysVersion,
            controller: "partyOutlayEditCtrl",
            resolve: {
                load: ['$ocLazyLoad', function ($ocLazyLoad) {

                    return $ocLazyLoad.load(['../main/publicity/partyOutlay/edit.js?' + window.sysVersion]);
                }]
            }
        }).state("home.partyOutlayShow", {
            url: "partyOutlayShow?id&dzzdm&op",
            templateUrl: "../main/publicity/partyOutlay/edit.html?" + window.sysVersion,
            controller: "partyOutlayEditCtrl",
            resolve: {
                load: ['$ocLazyLoad', function ($ocLazyLoad) {

                    return $ocLazyLoad.load(['../main/publicity/partyOutlay/edit.js?' + window.sysVersion]);
                }]
            }
        }).state("home.fundsIncome", {
            url: "fundsIncome",
            templateUrl: "../main/publicity/fundsIncome/list.html?" + window.sysVersion,
            controller: "fundsIncomeCtrl",
            resolve: {
                load: ['$ocLazyLoad', function ($ocLazyLoad) {

                    return $ocLazyLoad.load(['../main/publicity/fundsIncome/list.js?' + window.sysVersion]);
                }]
            }
        }).state("home.fundsIncomeEdit", {
            url: "fundsIncomeEdit?id&dzzdm&dzzmc&year",
            templateUrl: "../main/publicity/fundsIncome/edit.html?" + window.sysVersion,
            controller: "fundsIncomedtiCtrl",
            resolve: {
                load: ['$ocLazyLoad', function ($ocLazyLoad) {

                    return $ocLazyLoad.load(['../main/publicity/fundsIncome/edit.js?' + window.sysVersion]);
                }]
            }
        }).state("home.partyOrg", {
            url: "partyOrg?id&dzzdm&op",
            templateUrl: "../main/party/partyOrg/manage.html?" + window.sysVersion,
            controller: "partyOrgCtrl",
            resolve: {
                load: ['$ocLazyLoad', function ($ocLazyLoad) {
                    $ocLazyLoad.load(['../js/template/modal_partyTree.css?' + window.sysVersion]);
                    return $ocLazyLoad.load(['../main/party/partyOrg/manage.js?' + window.sysVersion]);
                }]
            }
        }).state("home.dyxxgl", {
            url: "dyxxgl",
            templateUrl: "partyExpand/summary/dyxxgl.html?" + window.sysVersion,
            controller: "dyxxglCtrl",
            resolve: {
                load: ['$ocLazyLoad', function ($ocLazyLoad) {

                    return $ocLazyLoad.load(['partyExpand/summary/dyxxgl.js?' + window.sysVersion]);
                }]
            }
        }).state("home.partyAdd", {
            url: "partyAdd?id&parentcode&op",
            templateUrl: "../main/party/edit.html?" + window.sysVersion,
            controller: "partyEditCtrl",
            resolve: {
                load: ['$ocLazyLoad', function ($ocLazyLoad) {

                    return $ocLazyLoad.load(['../main/party/edit.js?' + window.sysVersion]);
                }]
            }
        }).state("home.partyEdit", {
            url: "partyEdit?id&parentcode&op",
            templateUrl: "../main/party/edit.html?" + window.sysVersion,
            controller: "partyEditCtrl",
            resolve: {
                load: ['$ocLazyLoad', function ($ocLazyLoad) {

                    return $ocLazyLoad.load(['../main/party/edit.js?' + window.sysVersion]);
                }]
            }
        }).state("home.partyShow", {
            url: "partyShow?id&parentcode&op",
            templateUrl: "../main/party/show.html?" + window.sysVersion,
            controller: "partyShowCtrl",
            resolve: {
                load: ['$ocLazyLoad', function ($ocLazyLoad) {
                    $ocLazyLoad.load(['../main/css/redmenu.css?' + window.sysVersion]);
                    return $ocLazyLoad.load(['../main/party/show.js?' + window.sysVersion]);
                }]
            }
        }).state("home.partyShow_Dzb", {
            url: "partyShow_Dzb?id&parentcode&op",
            templateUrl: "../main/party/show_dzb.html?" + window.sysVersion,
            controller: "partyShowCtrl",
            resolve: {
                load: ['$ocLazyLoad', function ($ocLazyLoad) {
                    $ocLazyLoad.load(['../main/css/redmenu.css?' + window.sysVersion]);
                    return $ocLazyLoad.load(['../main/party/show.js?' + window.sysVersion]);
                }]
            }
        }).state("home.partyUserShow", {
            url: "partyUserShow?userId&userType&isDetail&rybm",
            templateUrl: "partyUser/show.html?" + window.sysVersion,
            controller: "partyUserShowCtrl",
            resolve: {
                load: ['$ocLazyLoad', function ($ocLazyLoad) {

                    return $ocLazyLoad.load(['partyUser/show.js?' + window.sysVersion]);
                }]
            }
        }).state("home.zxzxxqk_partyViewCS", {
            url: "zxzxxqk_partyViewCS",
            data: {viewlet: 'lc%252Fgt-zxzxxqk'},
            templateUrl: "partyTwoExt/partyView/view-url.html?" + window.sysVersion,
            controller: "partyViewUrlCtrl",
            resolve: {
                load: ['$ocLazyLoad', function ($ocLazyLoad) {
                    $ocLazyLoad.load(['partyTwoExt/partyView/view-url.css?' + window.sysVersion])
                    return $ocLazyLoad.load(['partyTwoExt/partyView/view-url.js?' + window.sysVersion]);
                }]
            }
        }).state("home.djjq_partyViewCS", {
            url: "djjq_partyViewCS",
            data: {viewlet: 'lc%252Fgt-djjq'},
            templateUrl: "partyTwoExt/partyView/view-url.html?" + window.sysVersion,
            controller: "partyViewUrlCtrl",
            resolve: {
                load: ['$ocLazyLoad', function ($ocLazyLoad) {
                    $ocLazyLoad.load(['partyTwoExt/partyView/view-url.css?' + window.sysVersion])
                    return $ocLazyLoad.load(['partyTwoExt/partyView/view-url.js?' + window.sysVersion]);
                }]
            }
        }).state("home.dzzztqk_partyViewCS", {
            url: "dzzztqk_partyViewCS",
            data: {viewlet: 'lc%252Fgt-dzzztqk'},
            templateUrl: "partyTwoExt/partyView/view-url.html?" + window.sysVersion,
            controller: "partyViewUrlCtrl",
            resolve: {
                load: ['$ocLazyLoad', function ($ocLazyLoad) {
                    $ocLazyLoad.load(['partyTwoExt/partyView/view-url.css?' + window.sysVersion])
                    return $ocLazyLoad.load(['partyTwoExt/partyView/view-url.js?' + window.sysVersion]);
                }]
            }
        }).state("home.dzzhjqk_partyViewCS", {
            url: "dzzhjqk_partyViewCS",
            data: {viewlet: 'lc%252Fgt-dzzhjqk'},
            templateUrl: "partyTwoExt/partyView/view-url.html?" + window.sysVersion,
            controller: "partyViewUrlCtrl",
            resolve: {
                load: ['$ocLazyLoad', function ($ocLazyLoad) {
                    $ocLazyLoad.load(['partyTwoExt/partyView/view-url.css?' + window.sysVersion])
                    return $ocLazyLoad.load(['partyTwoExt/partyView/view-url.js?' + window.sysVersion]);
                }]
            }
        }).state("home.dyxxqk_partyViewCS", {
            url: "dyxxqk_partyViewCS",
            data: {viewlet: 'lc%252Fgt-dyxxqk'},
            templateUrl: "partyTwoExt/partyView/view-url.html?" + window.sysVersion,
            controller: "partyViewUrlCtrl",
            resolve: {
                load: ['$ocLazyLoad', function ($ocLazyLoad) {
                    $ocLazyLoad.load(['partyTwoExt/partyView/view-url.css?' + window.sysVersion])
                    return $ocLazyLoad.load(['partyTwoExt/partyView/view-url.js?' + window.sysVersion]);
                }]
            }
        }).state("home.dnshztqk_partyViewCS", {
            url: "dnshztqk_partyViewCS",
            data: {viewlet: 'lc%252Fgt-dnshztqk'},
            templateUrl: "partyTwoExt/partyView/view-url.html?" + window.sysVersion,
            controller: "partyViewUrlCtrl",
            resolve: {
                load: ['$ocLazyLoad', function ($ocLazyLoad) {
                    $ocLazyLoad.load(['partyTwoExt/partyView/view-url.css?' + window.sysVersion])
                    return $ocLazyLoad.load(['partyTwoExt/partyView/view-url.js?' + window.sysVersion]);
                }]
            }
        }).state("home.dnhdztqk_partyViewCS", {
            url: "dnhdztqk_partyViewCS",
            data: {viewlet: 'lc%252Fgt-dnhdztqk'},
            templateUrl: "partyTwoExt/partyView/view-url.html?" + window.sysVersion,
            controller: "partyViewUrlCtrl",
            resolve: {
                load: ['$ocLazyLoad', function ($ocLazyLoad) {
                    $ocLazyLoad.load(['partyTwoExt/partyView/view-url.css?' + window.sysVersion])
                    return $ocLazyLoad.load(['partyTwoExt/partyView/view-url.js?' + window.sysVersion]);
                }]
            }
        }).state("home.djkpqk_partyViewCS", {
            url: "djkpqk_partyViewCS",
            data: {viewlet: 'lc%252Fgt-djkpqk'},
            templateUrl: "partyTwoExt/partyView/view-url.html?" + window.sysVersion,
            controller: "partyViewUrlCtrl",
            resolve: {
                load: ['$ocLazyLoad', function ($ocLazyLoad) {
                    $ocLazyLoad.load(['partyTwoExt/partyView/view-url.css?' + window.sysVersion])
                    return $ocLazyLoad.load(['partyTwoExt/partyView/view-url.js?' + window.sysVersion]);
                }]
            }
        }).state("home.xczdztqk_partyViewCS", {
            url: "xczdztqk_partyViewCS",
            data: {viewlet: 'lc%252Fgt-xczdztqk'},
            templateUrl: "partyTwoExt/partyView/view-url.html?" + window.sysVersion,
            controller: "partyViewUrlCtrl",
            resolve: {
                load: ['$ocLazyLoad', function ($ocLazyLoad) {
                    $ocLazyLoad.load(['partyTwoExt/partyView/view-url.css?' + window.sysVersion])
                    return $ocLazyLoad.load(['partyTwoExt/partyView/view-url.js?' + window.sysVersion]);
                }]
            }
        }).state("home.zgsxdtqk_partyViewCS", {
            url: "zgsxdtqk_partyViewCS",
            data: {viewlet: 'lc%252Fgt-zgsxdtqk'},
            templateUrl: "partyTwoExt/partyView/view-url.html?" + window.sysVersion,
            controller: "partyViewUrlCtrl",
            resolve: {
                load: ['$ocLazyLoad', function ($ocLazyLoad) {
                    $ocLazyLoad.load(['partyTwoExt/partyView/view-url.css?' + window.sysVersion])
                    return $ocLazyLoad.load(['partyTwoExt/partyView/view-url.js?' + window.sysVersion]);
                }]
            }
        }).state("home.hlwgzqqk_partyViewCS", {
            url: "hlwgzqqk_partyViewCS",
            data: {viewlet: 'lc%252Fgt-hlwgzqqk'},
            templateUrl: "partyTwoExt/partyView/view-url.html?" + window.sysVersion,
            controller: "partyViewUrlCtrl",
            resolve: {
                load: ['$ocLazyLoad', function ($ocLazyLoad) {
                    $ocLazyLoad.load(['partyTwoExt/partyView/view-url.css?' + window.sysVersion])
                    return $ocLazyLoad.load(['partyTwoExt/partyView/view-url.js?' + window.sysVersion]);
                }]
            }
        }).state("home.myBaseInfo", {
            url: "myBaseInfo",
            params: {"op": 0, "ow": 1},
            templateUrl: "partyUser/show.html?" + window.sysVersion,
            controller: "partyUserShowCtrl",
            resolve: {
                load: ['$ocLazyLoad', function ($ocLazyLoad) {

                    return $ocLazyLoad.load(['partyUser/show.js?' + window.sysVersion]);
                }]
            }
        }).state("home.userLeaderTotalList", {
            url: "userLeaderTotalList",
            templateUrl: "../main/publicity/userLeader/total.html?" + window.sysVersion,
            controller: "userLeaderTotalListCtrl",
            resolve: {
                load: ['$ocLazyLoad', function ($ocLazyLoad) {

                    return $ocLazyLoad.load(['../main/publicity/userLeader/total.js?' + window.sysVersion]);
                }]
            }
        }).state("home.partyTotalList", {
            url: "partyTotalList?dzzdm",
            templateUrl: "../main/report/partytotal/list.html?" + window.sysVersion,
            controller: "partyTotalListCtrl",
            resolve: {
                load: ['$ocLazyLoad', function ($ocLazyLoad) {

                    return $ocLazyLoad.load(['../main/report/partytotal/list.js?' + window.sysVersion]);
                }]
            }
        }).state("home.partyDetailTotalList", {
            url: "partyDetailTotalList?dzzdm",
            templateUrl: "../main/report/partydetail/list.html?" + window.sysVersion,
            controller: "partyDetailTotalListCtrl",
            resolve: {
                load: ['$ocLazyLoad', function ($ocLazyLoad) {

                    return $ocLazyLoad.load(['../main/report/partydetail/list.js?' + window.sysVersion]);
                }]
            }
        }).state("home.partyUserTotalList", {
            url: "partyUserTotalList?dzzdm",
            templateUrl: "../main/report/usertotal/list.html?" + window.sysVersion,
            controller: "userTotalListCtrl",
            resolve: {
                load: ['$ocLazyLoad', function ($ocLazyLoad) {

                    return $ocLazyLoad.load(['../main/report/usertotal/list.js?' + window.sysVersion]);
                }]
            }
        }).state("home.centerstudyTotal", {
            url: "centerstudyTotal?dzzdm",
            templateUrl: "../main/report/centerstudy/list.html?" + window.sysVersion,
            controller: "centerstudyTotalCtrl",
            resolve: {
                load: ['$ocLazyLoad', function ($ocLazyLoad) {

                    return $ocLazyLoad.load(['../main/report/centerstudy/list.js?' + window.sysVersion]);
                }]
            }
        }).state("home.myMeeting", {
            url: "myMeeting",
            templateUrl: "shyk/myMeeting.html?" + window.sysVersion,
            controller: "myMeetingCtrl",
            resolve: {
                load: ['$ocLazyLoad', function ($ocLazyLoad) {

                    return $ocLazyLoad.load(['shyk/myMeeting.js?' + window.sysVersion]);
                }]
            }
        }).state("home.shykEvaluateEdit", {
            url: "shykEvaluateEdit?meetingId&meetinguserId&op",
            templateUrl: "shyk/evaluate.html?" + window.sysVersion,
            controller: "shykEvaluateCtrl",
            resolve: {
                load: ['$ocLazyLoad', function ($ocLazyLoad) {

                    return $ocLazyLoad.load(['shyk/evaluate.js?' + window.sysVersion]);
                }]
            }
        }).state("home.shykEvaluateShow", {
            url: "shykEvaluateShow?meetingId&meetinguserId&op",
            templateUrl: "shyk/evaluate.html?" + window.sysVersion,
            controller: "shykEvaluateCtrl",
            resolve: {
                load: ['$ocLazyLoad', function ($ocLazyLoad) {

                    return $ocLazyLoad.load(['shyk/evaluate.js?' + window.sysVersion]);
                }]
            }
        }).state("home.assetList", {
            url: "assetList",
            templateUrl: "../main/asset/list.html?" + window.sysVersion,
            controller: "assetListCtrl",
            resolve: {
                load: ['$ocLazyLoad', function ($ocLazyLoad) {
                    return $ocLazyLoad.load('../main/asset/list.js?' + window.sysVersion);
                }]
            }
        }).state("home.assetAdd", {
            url: "assetAdd",
            templateUrl: "../main/asset/edit.html?" + window.sysVersion,
            controller: "assetEditCtrl",
            resolve: {
                load: ['$ocLazyLoad', function ($ocLazyLoad) {
                    return $ocLazyLoad.load('../main/asset/edit.js?' + window.sysVersion);
                }]
            }
        }).state("home.assetEdit", {
            url: "assetEdit",
            templateUrl: "../main/asset/edit.html?" + window.sysVersion,
            controller: "assetEditCtrl",
            resolve: {
                load: ['$ocLazyLoad', function ($ocLazyLoad) {
                    return $ocLazyLoad.load('../main/asset/edit.js?' + window.sysVersion);
                }]
            }
        }).state("home.assetShow", {
            url: "assetShow",
            params: {op: 0},
            templateUrl: "../main/asset/show.html?" + window.sysVersion,
            controller: "assetShowCtrl",
            resolve: {
                load: ['$ocLazyLoad', function ($ocLazyLoad) {
                    return $ocLazyLoad.load('../main/asset/show.js?' + window.sysVersion);
                }]
            }
        }).state("home.assetUpdateuser", {
            url: "assetUpdateuser",
            templateUrl: "../main/asset/updateuser.html?" + window.sysVersion,
            controller: "assetUpdateuserCtrl",
            resolve: {
                load: ['$ocLazyLoad', function ($ocLazyLoad) {
                    $ocLazyLoad.load('../main/asset/show.js?' + window.sysVersion);
                    return $ocLazyLoad.load('../main/asset/updateuser.js?' + window.sysVersion);
                }]
            }
        }).state("home.assetAllocateList", {
            url: "assetAllocateList",
            templateUrl: "../main/asset/allocate/list.html?" + window.sysVersion,
            controller: "assetAllocateListCtrl",
            resolve: {
                load: ['$ocLazyLoad', function ($ocLazyLoad) {
                    return $ocLazyLoad.load('../main/asset/allocate/list.js?' + window.sysVersion);
                }]
            }
        }).state("home.assetAllocateEdit", {
            url: "assetAllocateEdit",
            templateUrl: "../main/asset/allocate/edit.html?" + window.sysVersion,
            controller: "assetAllocateEditCtrl",
            resolve: {
                load: ['$ocLazyLoad', function ($ocLazyLoad) {
                    return $ocLazyLoad.load('../main/asset/allocate/edit.js?' + window.sysVersion);
                }]
            }
        }).state("home.assetAllocateShow", {
            url: "assetAllocateShow",
            templateUrl: "../main/asset/allocate/show.html?" + window.sysVersion,
            controller: "assetAllocateShowCtrl",
            resolve: {
                load: ['$ocLazyLoad', function ($ocLazyLoad) {
                    $ocLazyLoad.load('../main/asset/show.js?' + window.sysVersion);
                    return $ocLazyLoad.load('../main/asset/allocate/show.js?' + window.sysVersion);
                }]
            }
        }).state("home.assetMaintainList", {
            url: "assetMaintainList",
            templateUrl: "../main/asset/maintain/list.html?" + window.sysVersion,
            controller: "assetMaintainListCtrl",
            resolve: {
                load: ['$ocLazyLoad', function ($ocLazyLoad) {
                    return $ocLazyLoad.load('../main/asset/maintain/list.js?' + window.sysVersion);
                }]
            }
        }).state("home.assetMaintainAdd", {
            url: "assetMaintainAdd",
            templateUrl: "../main/asset/maintain/edit.html?" + window.sysVersion,
            controller: "assetMaintainEditCtrl",
            resolve: {
                load: ['$ocLazyLoad', function ($ocLazyLoad) {
                    return $ocLazyLoad.load('../main/asset/maintain/edit.js?' + window.sysVersion);
                }]
            }
        }).state("home.assetMaintainEdit", {
            url: "assetMaintainEdit",
            templateUrl: "../main/asset/maintain/edit.html?" + window.sysVersion,
            controller: "assetMaintainEditCtrl",
            resolve: {
                load: ['$ocLazyLoad', function ($ocLazyLoad) {
                    return $ocLazyLoad.load('../main/asset/maintain/edit.js?' + window.sysVersion);
                }]
            }
        }).state("home.assetMaintainShow", {
            url: "assetMaintainShow",
            templateUrl: "../main/asset/maintain/show.html?" + window.sysVersion,
            controller: "assetMaintainShowCtrl",
            resolve: {
                load: ['$ocLazyLoad', function ($ocLazyLoad) {
                    $ocLazyLoad.load('../main/asset/show.js?' + window.sysVersion);
                    return $ocLazyLoad.load('../main/asset/maintain/show.js?' + window.sysVersion);
                }]
            }
        }).state("home.assetDisposalList", {
            url: "assetDisposalList",
            templateUrl: "../main/asset/disposal/list.html?" + window.sysVersion,
            controller: "assetDisposalListCtrl",
            resolve: {
                load: ['$ocLazyLoad', function ($ocLazyLoad) {
                    return $ocLazyLoad.load('../main/asset/disposal/list.js?' + window.sysVersion);
                }]
            }
        }).state("home.assetDisposalAdd", {
            url: "assetDisposalAdd",
            templateUrl: "../main/asset/disposal/edit.html?" + window.sysVersion,
            controller: "assetDisposalEditCtrl",
            resolve: {
                load: ['$ocLazyLoad', function ($ocLazyLoad) {
                    return $ocLazyLoad.load('../main/asset/disposal/edit.js?' + window.sysVersion);
                }]
            }
        }).state("home.assetDisposalEdit", {
            url: "assetDisposalEdit",
            templateUrl: "../main/asset/disposal/edit.html?" + window.sysVersion,
            controller: "assetDisposalEditCtrl",
            resolve: {
                load: ['$ocLazyLoad', function ($ocLazyLoad) {
                    return $ocLazyLoad.load('../main/asset/disposal/edit.js?' + window.sysVersion);
                }]
            }
        }).state("home.assetDisposalShow", {
            url: "assetDisposalShow",
            templateUrl: "../main/asset/disposal/show.html?" + window.sysVersion,
            controller: "assetDisposalShowCtrl",
            resolve: {
                load: ['$ocLazyLoad', function ($ocLazyLoad) {
                    $ocLazyLoad.load('../main/asset/show.js?' + window.sysVersion);
                    return $ocLazyLoad.load('../main/asset/disposal/show.js?' + window.sysVersion);
                }]
            }
        }).state("home.systemuseTotalList", {
            url: "systemuseTotalList",
            templateUrl: "../main/report/systemusetotal/list.html?" + window.sysVersion,
            controller: "systemUseTotalListCtrl",
            resolve: {
                load: ['$ocLazyLoad', function ($ocLazyLoad) {

                    return $ocLazyLoad.load(['../main/report/systemusetotal/list.js?' + window.sysVersion]);
                }]
            }
        }).state("home.adPartyGroupList", {
            url: "adPartyGroupList",
            templateUrl: "../main/systemManage/adPartyGroup/list.html?" + window.sysVersion,
            controller: "adPartyGroupListCtrl",
            resolve: {
                load: ['$ocLazyLoad', function ($ocLazyLoad) {
                    return $ocLazyLoad.load('../main/systemManage/adPartyGroup/list.js?' + window.sysVersion);
                }]
            }
        }).state("home.learningQuarterTotal", {
            url: "learningQuarterTotal",
            templateUrl: "../main/centralGroup/quarterTotal/list.html?" + window.sysVersion,
            controller: "learningQuarterTotalCtrl",
            resolve: {
                load: ['$ocLazyLoad', function ($ocLazyLoad) {
                    return $ocLazyLoad.load('../main/centralGroup/quarterTotal/list.js?' + window.sysVersion);
                }]
            }
        }).state("home.pu_admitList", {
            url: "pu_admitList",
            templateUrl: "../main/partyUser/admit/list.html?" + window.sysVersion,
            controller: "admitListCtrl",
            resolve: {
                load: ['$ocLazyLoad', function ($ocLazyLoad) {
                    $ocLazyLoad.load('../main/partyUser/admit/edit.js?' + window.sysVersion);
                    $ocLazyLoad.load('../main/partyUser/admit/detail.js?' + window.sysVersion);
                    $ocLazyLoad.load('../main/partyUser/admit/exportParty.js?' + window.sysVersion);
                    $ocLazyLoad.load('../main/partyUser/admit/archiveEdit.js?' + window.sysVersion);
                    return $ocLazyLoad.load('../main/partyUser/admit/list.js?' + window.sysVersion);
                }]
            }
        }).state("home.pu_admitApply", {
            url: "pu_admitApply",
            templateUrl: "../main/partyUser/admit/applyList.html?" + window.sysVersion,
            controller: "admitApplyCtrl",
            resolve: {
                load: ['$ocLazyLoad', function ($ocLazyLoad) {
                    $ocLazyLoad.load('../main/partyUser/admit/edit.js?' + window.sysVersion);
                    $ocLazyLoad.load('../main/partyUser/admit/detail.js?' + window.sysVersion);
                    $ocLazyLoad.load('../main/partyUser/admit/archiveEdit.js?' + window.sysVersion);
                    return $ocLazyLoad.load('../main/partyUser/admit/applyList.js?' + window.sysVersion);
                }]
            }
        }).state("home.pu_admitActive", {
            url: "pu_admitActive",
            templateUrl: "../main/partyUser/admit/activeList.html?" + window.sysVersion,
            controller: "admitActiveCtrl",
            resolve: {
                load: ['$ocLazyLoad', function ($ocLazyLoad) {
                    $ocLazyLoad.load('../main/partyUser/admit/edit.js?' + window.sysVersion);
                    $ocLazyLoad.load('../main/partyUser/admit/detail.js?' + window.sysVersion);
                    $ocLazyLoad.load('../main/partyUser/admit/archiveEdit.js?' + window.sysVersion);
                    return $ocLazyLoad.load('../main/partyUser/admit/activeList.js?' + window.sysVersion);
                }]
            }
        }).state("home.pu_admitPass", {
            url: "pu_admitPass",
            templateUrl: "../main/partyUser/admit/passList.html?" + window.sysVersion,
            controller: "admitPassCtrl",
            resolve: {
                load: ['$ocLazyLoad', function ($ocLazyLoad) {
                    $ocLazyLoad.load('../main/partyUser/admit/edit.js?' + window.sysVersion);
                    $ocLazyLoad.load('../main/partyUser/admit/detail.js?' + window.sysVersion);
                    $ocLazyLoad.load('../main/partyUser/admit/archiveEdit.js?' + window.sysVersion);
                    return $ocLazyLoad.load('../main/partyUser/admit/passList.js?' + window.sysVersion);
                }]
            }
        }).state("home.pu_admitPrepare", {
            url: "pu_admitPrepare",
            templateUrl: "../main/partyUser/admit/prepareList.html?" + window.sysVersion,
            controller: "admitPrepareCtrl",
            resolve: {
                load: ['$ocLazyLoad', function ($ocLazyLoad) {
                    $ocLazyLoad.load('../main/partyUser/admit/edit.js?' + window.sysVersion);
                    $ocLazyLoad.load('../main/partyUser/admit/detail.js?' + window.sysVersion);
                    $ocLazyLoad.load('../main/partyUser/admit/archiveEdit.js?' + window.sysVersion);
                    return $ocLazyLoad.load('../main/partyUser/admit/prepareList.js?' + window.sysVersion);
                }]
            }
        }).state("register", {
            url: "/register",
            templateUrl: "../main/partyUser/admit/register/edit.html?" + window.sysVersion,
            controller: "registerCtrl",
            resolve: {
                load: ['$ocLazyLoad', function ($ocLazyLoad) {
                    $ocLazyLoad.load('../main/partyUser/admit/register/success.js?' + window.sysVersion);
                    return $ocLazyLoad.load('../main/partyUser/admit/register/edit.js?' + window.sysVersion);
                }]
            }
        }).state("home.pu_admitRegisterList", {
            url: "pu_admitRegisterList",
            templateUrl: "../main/partyUser/admit/register/list.html?" + window.sysVersion,
            controller: "admitRegisterListCtrl",
            resolve: {
                load: ['$ocLazyLoad', function ($ocLazyLoad) {
                    $ocLazyLoad.load('../main/partyUser/admit/register/detail.js?' + window.sysVersion);
                    return $ocLazyLoad.load('../main/partyUser/admit/register/list.js?' + window.sysVersion);
                }]
            }
        }).state("home.myApplyInfo", {
            url: "myApplyInfo",
            templateUrl: "../main/partyUser/admit/myApplyDetail.html?" + window.sysVersion,
            controller: "myApplyInfoCtrl",
            resolve: {
                load: ['$ocLazyLoad', function ($ocLazyLoad) {
                    return $ocLazyLoad.load('../main/partyUser/admit/myApplyDetail.js?' + window.sysVersion);
                }]
            }
        }).state("home.pu_ArchiveList", {
            url: "pu_ArchiveList",
            templateUrl: "../main/partyUser/archiveList.html?" + window.sysVersion,
            controller: "pu_ArchiveListCtrl",
            resolve: {
                load: ['$ocLazyLoad', function ($ocLazyLoad) {
                    return $ocLazyLoad.load('../main/partyUser/archiveList.js?' + window.sysVersion);
                }]
            }
        });

        $bsRouterStateProvider.copyUrlState($stateProvider.getStates());

    }).run(['$rootScope', '$log', function ($rootScope, $log) {
        $rootScope.$on('$stateChangeSuccess', function (event, toState, toParams, fromState, fromParams) {
            //$rootScope.title = toState.title;//在相关的路由中添加title
            if (toState.name == 'homeTabs') {
                angular.element('.theme-red').css('overflow-y', 'hidden');
            } else {
                angular.element('.theme-red').css('overflow-y', 'auto');
            }
        });

        $rootScope.menuToggle = true;
    }]);

})
();
