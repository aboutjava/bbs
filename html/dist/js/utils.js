// ================layer自定义==============
(function() {
    'use strict';

    window.closeWindow = function() {
        if (window.parent && parent.layer) {
            let index = parent.layer.getFrameIndex(window.name);            
            parent.layer.close(index);            
        } else {
            window.close();
        }
    }

    if (window.layer) {
        layer.iframe = function(options) {
            options = $.extend({
                type: 2,
                shadeClose: false,
                shade: 0.8,
                area: ['100%', '100%'],
            }, options);
            let index = layer.open(options);
            return index;
        }
    }
})();

// =================工具==================
(function() {
	'user strict';
	
	let utils = window.utils = window.utils || {};

    let isMobile = utils.isMobile = window.matchMedia('(max-width: 767px)').matches;

	utils.getUrlParams = function(url) {
		url = url || window.location.search;
		if (url.indexOf('?')) {
			url = url.substring(url.indexOf('?'));
		}
		url = url.split("+").join(" ");
        let params = {}, tokens, name, value,
	        re = /[?&]?([^=]+)=([^&]*)/g;
        while (tokens = re.exec(url)) {
            name = decodeURIComponent(tokens[1]);
            value = decodeURIComponent(tokens[2]);
            if (params[name] !== undefined) {
                if (!$.isArray(params[name])) {
                    params[name] = [params[name]];
                }
                params[name].push(value);
            } else {
                params[name] = value;
            }
        }
        return params;
	}
})();

// =================消息弹出框====================
(function() {
    'use strict';

    utils.msg = {};

    function showMsgBox(msg, options, callback) {
        if (typeof (msg) == 'object') {
            options = $.extend(options, msg)
        }
        layer.alert(options.content || msg, options, callback);
    }

    utils.msg.showWaitMsg = function() {
        layer.load();
    }

    utils.msg.closeWaitMsg = function() {
        layer.closeAll('loading');
    }

    utils.msg.toast = function (msg) {
        layer.msg(msg);
    }

    utils.msg.info = function (msg, callback) {
        showMsgBox(msg, {
            skin: 'layui-ext-info',
            title: '信息',
            closeBtn: 0
        }, callback);
    }

    utils.msg.warn = function (msg, callback) {
        showMsgBox(msg, {
            skin: 'layui-ext-warn',
            title: '警告',
            closeBtn: 0
        }, callback);
    }

    utils.msg.error = function (msg, callback) {
        showMsgBox(msg, {
            skin: 'layui-ext-error',
            title: '出错啦！',
            closeBtn: 0
        }, callback);
    }

    utils.msg.confirm = function (options, okCallback, cancelCallback) {
        layer.confirm(options.content, {
            btn: [options.okText || '确定', '取消'],
            title: options.title || '确认' ,
            closeBtn: 0,
            skin: 'layui-ext-confirm' + (options.theme ? '-' + options.theme : '')
        }, function (index) {
            layer.close(index);
            if (okCallback) {
                okCallback();
            }
        }, function () {
            if (cancelCallback) {
                cancelCallback();
            }
        });
    }
})();