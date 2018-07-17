/** kit_admin-v1.0.4 MIT License By http://kit/zhengjinfan.cn */
 ;/**
 * Name:app.js
 * LICENSE:MIT
 */
var tab;
layui.define(['element', 'nprogress', 'form', 'table', 'loader', 'tab', 'navbar', 'onelevel'], function(exports) {
    var $ = layui.jquery,
        element = layui.element,
        layer = layui.layer,
        _win = $(window),
        _doc = $(document),
        _body = $('.kit-body'),
        form = layui.form,
        table = layui.table,
        loader = layui.loader,
        navbar = layui.navbar,
        _componentPath = 'components/';
    tab = layui.tab
    var app = {
        hello: function(str) {
            layer.alert('Hello ' + (str || 'test'));
        },
        config: {
            type: 'iframe'
        },
        set: function(options) {
            var that = this;
            $.extend(true, that.config, options);
            return that;
        },
        init: function() {
            var that = this,
                _config = that.config;
            if (_config.type === 'page') {
                $('a[kit-loader]').on('click', function() {
                    var url = $(this).data('url'),
                        name = $(this).data('name'),
                        id = $(this).data('id');
                    loader.load({
                        url: url,
                        name: name,
                        id: id === undefined ? new Date().getTime() : id,
                        onSuccess: success
                    });

                    function success(data) {
                        switch (data.name) {
                            case 'table':
                                loader.getScript(_componentPath + 'table/table.js', function() {
                                    var tableIns = table.render(moduleTable.config);
                                    moduleTable.extend({
                                        currTable: tableIns,
                                        table: table,
                                        layer: layer,
                                        form: form,
                                        jquery: $
                                    });
                                });
                                break;
                            case 'form':
                                form.render();
                                break;
                            default:
                                break;
                        }
                    };
                });
            }
            if (_config.type === 'iframe') {
                tab.set({
                    elem: '#container',
                    onSwitch: function(data) { //选项卡切换时触发
                    	
                    },
                    closeBefore: function(data) { //关闭选项卡之前触发
                        return true; //返回true则关闭
                    }
                }).render();
                //navbar加载方式一，直接绑定已有的dom元素事件                
                navbar.bind(function(data) {
                    tab.tabAdd(data);
                });
                //navbar加载方式二，设置远程地址加载
                // navbar.set({
                //     remote: {
                //         url: '/datas/navbar1.json'
                //     }
                // }).render(function(data) {
                //     tab.tabAdd(data);
                // });
                //navbar加载方式三，设置data本地数据
                // navbar.set({
                //     data: [{
                //         id: "1",
                //         title: "基本元素",
                //         icon: "fa-cubes",
                //         spread: true,
                //         children: [{
                //             id: "7",
                //             title: "表格",
                //             icon: "&#xe6c6;",
                //             url: "test.html"
                //         }, {
                //             id: "8",
                //             title: "表单",
                //             icon: "&#xe63c;",
                //             url: "form.html"
                //         }]
                //     }, {
                //         id: "5",
                //         title: "这是一级导航",
                //         icon: "fa-stop-circle",
                //         url: "https://www.baidu.com",
                //         spread: false
                //     }]
                // }).render(function(data) {
                //     tab.tabAdd(data);
                // });

                //处理顶部一级菜单
                var onelevel = layui.onelevel;
                if (onelevel.hasElem()) {
                    onelevel.set({
                        remote: {
                            url: '/datas/onelevel1.json' //远程地址
                        },
                        onClicked: function(id) {
                            switch (id) {
                                case 1:
                                    navbar.set({
                                        remote: {
                                            url: '/datas/navbar1.json'
                                        }
                                    }).render(function(data) {
                                        tab.tabAdd(data);
                                    });
                                    break;
                                case 2:
                                    navbar.set({
                                        remote: {
                                            url: '/datas/navbar2.json'
                                        }
                                    }).render(function(data) {
                                        tab.tabAdd(data);
                                    });
                                    break;
                                default:
                                    navbar.set({
                                        data: [{
                                            id: "1",
                                            title: "基本元素",
                                            icon: "fa-cubes",
                                            spread: true,
                                            children: [{
                                                id: "7",
                                                title: "表格",
                                                icon: "&#xe6c6;",
                                                url: "test.html"
                                            }, {
                                                id: "8",
                                                title: "表单",
                                                icon: "&#xe63c;",
                                                url: "form.html"
                                            }]
                                        }, {
                                            id: "5",
                                            title: "这是一级导航",
                                            icon: "fa-stop-circle",
                                            url: "https://www.baidu.com",
                                            spread: false
                                        }]
                                    }).render(function(data) {
                                        tab.tabAdd(data);
                                    });
                                    break;
                            }
                        }
                    }).render();
                }
            }
            return that;
        }
    };

    //输出test接口
    exports('app', app);
});