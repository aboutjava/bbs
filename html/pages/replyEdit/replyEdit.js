$(function() {
	let postId = utils.getUrlParams()['postId']; // 帖子id
	let replyId = utils.getUrlParams()['replyId']; // 回复id
	let section = utils.getUrlParams()['section']; // 版块
	let editor;

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

	let baseUrl;
	switch (section) {
		case 'javaBase': baseUrl = bbs.res.javaBase;
			break;
		case 'javaThread': baseUrl = bbs.res.javaThread;
			break;
		case 'spring': baseUrl = bbs.res.spring;
			break;
		case 'mybatis': baseUrl = bbs.res.mybatis;
			break;
		case 'hibernate': baseUrl = bbs.res.hibernate;
			break;
		case 'struts': baseUrl = bbs.res.struts;
			break;
		case 'otherFramework': baseUrl = bbs.res.otherFramework;
			break;
		case 'oracle': baseUrl = bbs.res.oracle;
			break;
		case 'mysql': baseUrl = bbs.res.mysql;
			break;
		case 'otherDb': baseUrl = bbs.res.otherDb;
			break;
		default:
			utils.msg.error('此版块不存在');
	}
	
	bbs.mainApi.ajax({
		url: baseUrl + '/replyEditInit',
		data: {
			replyId: replyId,
		}
	}).done(function(r) {
		if (r.reply) {
			editor.txt.html(r.reply.replyContent);
		}
	})

	$('#save').on('click', function() {
		bbs.mainApi.ajax({
			url: baseUrl + '/replySave',
			data: {
				replyContent: editor.txt.html(),
				id: replyId,
			}
		}).done(function(r) {
			window.parent.location.reload();
			closeWindow();
		}).fail(function(r) {
			utils.msg.error(r.message);
		})
	})
	
})