
(function() {
    'use strict';
    window.bbs = {
        res: {
            postEdit: 'postEdit',
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

(function($) {
    'use strict';
    let MainPage = function() {

    }

    let isMobile = MainPage.isMobile = $(window).width() < 768;
    
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
            self.dropDownHover();
        }).fail(function() {
            alert('init fail');
        })
    }

    window.bbs.MainPage = MainPage;
    
})(jQuery);
