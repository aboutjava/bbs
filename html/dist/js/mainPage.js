
(function() {
    'use strict';
    window.bbs = {
        res: {
            javaBase: 'javaBase',
            javaThread: 'javaThread',
            spring: 'spring',
            mybatis: 'mybatis',
            hibernate: 'hibernate',
            struts: 'struts',
            otherFramework: 'otherFramework',
            oracle: 'oracle',
            mysql: 'mysql',
            otherDb: 'otherDb',
            postDetail: 'postDetail',
        },
    }
})();

(function($) {
    'use strict';
    let MainApi = function() {
        let loc = window.location;
        this.apiBaseUrl = loc.protocol + '//' + loc.hostname + ((loc.port && loc.port != 80) ? ':' + loc.port : '') + '/bbs/';
    }

    MainApi.default = {
        ajaxOption: {
            method: 'POST',
            dataType: 'json',
        },
    }

    MainApi.prototype.ajax = function(options) {
        options = $.extend({}, MainApi.default.ajaxOption, options);
        options.url = this.apiBaseUrl + options.url;

        let dtd = $.Deferred();
        utils.msg.showWaitMsg();
        $.ajax(options).done(function(r) {
            utils.msg.closeWaitMsg();
            if (r.success) {
                dtd.resolve(r);
            } else {
                dtd.reject(r);
            }
        }).fail(function(jqXHR, textStatus, errorThrown) {
            utils.msg.closeWaitMsg();
            dtd.reject({
                success: false,
                status: jqXHR.status,
                message: errorThrown,
            });
        })
        return dtd.promise();
    }

    MainApi.prototype.loadLayout = function() {
        let dtd = $.Deferred();
        localStorage.removeItem('commonLayout');
        $.get('common_layout.html', function(data) {
            let $commonLayout = $(data);
            let layout = {};
            layout.header = $commonLayout.find('#mainHeader').html();
            layout.footer = $commonLayout.find('#mainFooter').html();
            if (!layout.header || !layout.footer) {
                dtd.reject('主页面布局有误');
                return;
            }
            localStorage.setItem('commonLayout', JSON.stringify(layout));
            dtd.resolve();
        });
        return dtd.promise();
    }

    window.bbs.mainApi = new MainApi();
})(jQuery);

// ==============用户信息==============
(function($) {
    'use strict';

    let BbsUser = function() {}

    BbsUser.prototype.setUser = function(data) {
        this.name = data.name;
        this.roleName = data.roleName;
        this.authorities = data.authorities;
        this.userId = data.userId;
        this.user = {name: this.name, roleName : this.roleName};
    }

    BbsUser.prototype.isUserLogin = function() {
        return !!localStorage.getItem('userMenu');
    }

    BbsUser.prototype.canEdit = function(resource) {
        let auth = resource + 'Edit';
        let ban = resource + 'Ban';
        return this.authorities.indexOf(ban) < 0 && this.authorities.indexOf(auth) >= 0;
    }

    BbsUser.prototype.canManager = function(resource) {
        let auth = resource + 'manage';
        let ban = resource + 'Ban';
        return this.authorities.indexOf(ban) < 0 && this.authorities.indexOf(auth) >= 0;
    }

    window.bbs.user = new BbsUser();
})(jQuery);

// ==========页面操作===============
(function($) {
    'use strict';
    // 用户信息
    let UserMenu = function(data) {
        if (data) {
            data = JSON.parse(data);
            bbs.user.setUser(data.user);
            this.syncMills = data.syncMills;
        } else {
            this.syncMills = 0;
        }
    }

    UserMenu.prototype.isExpired = function() {
        var deltMills = Math.abs((new Date()).getTime() - this.syncMills || 0);
        return deltMills >= 600000;
    }

    UserMenu.prototype.reload = function(callback) {
        let self = this;
        bbs.mainApi.ajax({
            url: 'userMenu',
        }).done(function(r) {
            bbs.user.setUser(r.user);
            self.syncMills = new Date().getTime();
            callback({
                user: r.user,
                syncMills: self.syncMills,
            });
        }).fail(function(r) {
            window.location.replace('/login.html');
        });
    }

    UserMenu.prototype.render = function(header) {
        let res = {};
        res.user = bbs.user.user;
        let mainHeader = Mustache.render(header, res);
        $('#mainHeader').html(mainHeader);
    }

    // 主页面
    let MainPage = function() {

    }
    
    MainPage.prototype.dropDownHover = function() {
        if (utils.isMobile) {
            $('[data-toggle="collapse"]').hover(function() {
                $(this).trigger('click');
            }, function() {

            })

            $('#navbar-collapse').hover(function() {
                // $('[data-target="#navbar-collapse"]').trigger('click');
            }, function() {
                $('[data-target="#navbar-collapse"]').trigger('click');
            })
        } else {
            $('.dropdown').hover(function() {
                $(this).addClass('open');
            }, function() {
                $(this).removeClass('open');
            });
        }

        $('.content-wrapper').on('click', function() {
            if ($('#navbar-collapse').hasClass('in')) {
                $('[data-target="#navbar-collapse"]').trigger('click');
            }
        })
    }

    MainPage.prototype.postEdit = function() { // 发新帖或修改帖子按钮
        $('.post-edit').on('click', '[data-section]', function() {
            if (bbs.user.isUserLogin()) {
                let section = $(this).attr('data-section');
                let postId = $(this).attr('data-postId');

                if(bbs.user.canEdit(section)) {
                    layer.iframe({
                        title: postId ? '修改' : '发新帖',
                        content: 'postEdit.html?section=' + section + '&postId=' + (postId ? postId : ''),
                    });
                } else {
                    utils.msg.error('小黑屋住户不能进行此操作！');
                }
            } else {
                utils.msg.confirm({
                    theme: 'warn',
                    content: '你需要登录后才能继续操作',
                }, function() {
                    window.location.replace('login.html?oldHref=' + encodeURIComponent(window.location.href));
                })
            }
        })
        
    }

    MainPage.prototype.replyEdit = function() { // 回复修改
        $('.reply-edit').on('click', '[data-replyId]', function() {
            if (bbs.user.isUserLogin()) {
                let section = $(this).attr('data-section');
                let replyId = $(this).attr('data-replyId');

                if(bbs.user.canEdit(section)) {
                    layer.iframe({
                        title: '修改',
                        content: 'replyEdit.html?section=' + section + '&replyId=' + (replyId ? replyId : ''),
                    });
                } else {
                    utils.msg.error('小黑屋住户不能进行此操作！');
                }
            } else {
                utils.msg.confirm({
                    theme: 'warn',
                    content: '你需要登录后才能继续操作',
                }, function() {
                    window.location.replace('login.html?oldHref=' + encodeURIComponent(window.location.href));
                })
            }
        })
    }

    MainPage.prototype.init = function() {
        let self = this;
        if (localStorage.getItem('commonLayout')) {
            mainPageInit(self);
        } else {
            bbs.mainApi.loadLayout().done(function() {
                mainPageInit(self);
            }).fail(function() {
                alert('init fail');
            })
        }
        
    }

    MainPage.prototype.initPageQuery = function() {

    }


    // 主页面加载
    function mainPageInit(self) {
        let layout = JSON.parse(localStorage.getItem('commonLayout'));
        // 用户信息
        self.userMenu = new UserMenu(localStorage.getItem('userMenu'));
        if (bbs.user.isUserLogin()) {
            if (self.userMenu.isExpired()) {
                self.userMenu.reload(function(data) {
                    localStorage.setItem('userMenu', JSON.stringify(data));
                    self.userMenu.render(layout.header);
                });
            } else {
                self.userMenu.render(layout.header);
            }
        } else {
            self.userMenu.render(layout.header);
        }

        $('#mainFooter').html(layout.footer);
        let currentHref = window.location.href;
        $('#navbar-collapse').find('a').each(function(i, item) {
            let href = $(this).attr('href');
            if (currentHref.indexOf(href) != -1) {
                $(this).parent().addClass('active');
            }
        })
        self.dropDownHover(); // 下拉框hover事件
        self.postEdit(); // 发新帖或修改帖子
        self.replyEdit(); // 回复修改
        self.initPageQuery();

        $(document).on('click', '[data-toggle]', function() {
            let key = $(this).attr('data-toggle');
            if (key === 'logout') {
                localStorage.removeItem('commonLayout');
                localStorage.removeItem('userMenu');
            } else if (key === 'login') {
                window.location.replace('login.html?oldHref=' + encodeURIComponent(window.location.href));
            } else if (key === 'register') {

            }
        })
    }

    window.bbs.MainPage = MainPage;
    
})(jQuery);
