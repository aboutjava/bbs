$(function() {
	let postId = utils.getUrlParams()['postId']; // 帖子id
	let section = utils.getUrlParams()['section']; // 版块

	let page = new bbs.MainPage();
	page.initPageQuery = function() {
		bbs.mainApi.ajax({
			url: bbs.res.postDetail + '/search',
			data: {
				postId: postId,
			}
		}).done(function(r) {
			let post = r.post;
			if (bbs.user.userId == post.authorId) {
				post.edit = {};
				post.section = section;
				post.postId = postId;
			}
			
			let replies = r.replies;
			$.each(replies, function(i,item) {
				if (item.replierId == bbs.user.userId) {
					item.edit = {};
					item.edit.id = item.id;
					item.edit.section = section;
				}
			})
			let res = {};
			res.rows = replies;
			$('.box-header').html(Mustache.render($('#resultTmpl').html(), post));
			$('.box-body').html(Mustache.render($('#replyTmpl').html(), res));
		})
	}
	page.init();

	initEditor(); // 编辑器初始化
	

	function initEditor() {
		let E = window.wangEditor;
		editor = new E('#editor');
		editor.customConfig.uploadImgShowBase64 = true   // 使用 base64 保存图片
    	// editor.customConfig.uploadImgServer = '/upload'  // 上传图片到服务器
    	if (utils.isMobile) {
    		// 自定义菜单配置
		    editor.customConfig.menus = [
		        'emoticon',  // 表情
    			'image',  // 插入图片
		    ]
    	}
		editor.create();
	}

	$('#save').on('click', function() {
		bbs.mainApi.ajax({
			url: bbs.res.javaBase + '/replySave',
			data: {
				replyContent: editor.txt.html(),
				postId: postId,
			}
		}).done(function(r) {
			window.parent.location.reload();
			closeWindow();
		}).fail(function(r) {
			utils.msg.error(r.message);
		})
	})

})