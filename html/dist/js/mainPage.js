
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
    }

    BbsUser.prototype.isUserLogin = function() {
        return !!data;
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
    let MainPage = function() {

    }

    let isMobile = MainPage.isMobile = window.matchMedia('(max-width: 767px)').matches;
    
    MainPage.prototype.dropDownHover = function() {
        if (isMobile) {
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

    MainPage.prototype.loadLayout = function() {
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

    MainPage.prototype.postEdit = function() { // 发新帖或修改帖子按钮
        $('.post-edit').on('click', function() {
            if (bbs.user.isUserLogin) {
                let section = $(this).attr('data-section');
                let postId = $(this).attr('data-postId');

                if(bbs.user.canEdit(section)) {
                    layer.iframe({
                        title: postId ? '修改' : '发新帖',
                        content: 'postEdit.html?section=' + section + '&postId=' + postId,
                    });
                } else {
                    utils.msg.error('小黑屋住户不能进行此操作！');
                }
            } else {
                utils.msg.confirm({
                    theme: 'warn',
                    content: '你需要登录后才能继续操作',
                }, function() {
                    layer.iframe({
                        title: '用户登录',
                        content: 'login.html',
                    });
                })
            }
        })
        
    }

    MainPage.prototype.init = function() {
        let self = this;
        this.loadLayout().done(function() {
            let layout = JSON.parse(localStorage.getItem('commonLayout'));
            $('#mainHeader').html(layout.header);
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
        }).fail(function() {
            alert('init fail');
        })
    }

    window.bbs.MainPage = MainPage;
    
})(jQuery);
