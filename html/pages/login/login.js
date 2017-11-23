$(function () {
    $('#loginBtn').on('click', function () {
        var username = $('#username').val().trim();
        var password = $('#password').val().trim();
        if (!username) {
            utils.msg.toast('请输入用户名!');
            return;
        }
        if (!password) {
            utils.msg.toast('请输入密码!');
            return;
        }
        bbs.mainApi.ajax({
            url: 'login',
            data: {
                username: username,
                password: password
            },
        }).done(function (r) {
            localStorage.setItem('userMenu', JSON.stringify({'user': r.user, 'syncMills': new Date().getTime()}));
            bbs.mainApi.loadLayout().done(function() {
                window.parent ? window.parent.location.reload(true) : window.location.reload(true);
                closeWindow();
            }).fail(function() {
                alert('login fail');
            })
        }).fail(function (r) {
            utils.msg.toast(r.message || '用户名或密码错误');
        })
    })

    $('#username,#password').on("keyup", function (e) {
        if (e.which == 13) {
            $('#loginBtn').click();
        }
    });

    $('.login-close').on('click', function() {
        closeWindow();
    })
})