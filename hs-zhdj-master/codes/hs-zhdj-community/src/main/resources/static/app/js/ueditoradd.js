(function ($ang) {
    'use strict';
    $ang.module('devself.common').directive('uiKindeditor', function ($ocLazyLoad) {
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
                                allowFileManager: true,
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
                    }

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
    }).directive('uiUeditor', ["$ocLazyLoad", "$compile", function ($ocLazyLoad, $compile) {
        return {
            restrict: 'EA',
            require: '?ngModel',
            link: function (scope, element, attrs, ctrl) {
                //Ueditor富文本框先存代码，以后可能使用
                //$ocLazyLoad.load(['../Areas/AdminManage/Content/Vendor/jquery/ueditor/ueditor.config.js',
                //'../Areas/AdminManage/Content/Vendor/jquery/ueditor/ueditor.all.js']).then(function () {
                //    var _self = this,
                //    _initContent,
                //    editor,
                //    editorReady = false
                //    var fexUE = {
                //        initEditor: function () {
                //            var _self = this;
                //            if (typeof UE != 'undefined') {
                //                editor = new UE.ui.Editor({
                //                    initialContent: _initContent,
                //                    autoHeightEnabled: false,
                //                    autoFloatEnabled: false
                //                });


                //                editor.render(element[0]);
                //                editor.ready(function () {
                //                    editorReady = true;
                //                    _self.setContent(_initContent);

                //                    editor.addListener('contentChange', function () {
                //                        scope.$apply(function () {
                //                            ctrl.$setViewValue(editor.getContent());
                //                        });
                //                    });
                //                });
                //            }
                //        },
                //        setContent: function (content) {
                //            if (editor && editorReady) {
                //                editor.setContent(content);
                //            }
                //        }
                //    };
                //    if (!ctrl) {
                //        return;
                //    }
                //    _initContent = ctrl.$viewValue;
                //    ctrl.$render = function () {
                //        _initContent = ctrl.$isEmpty(ctrl.$viewValue) ? '' : ctrl.$viewValue;
                //        fexUE.setContent(_initContent);
                //    };

                //    fexUE.initEditor();
                //});
            }
        };
    }]);

})(angular);