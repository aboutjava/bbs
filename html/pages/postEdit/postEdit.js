$(function() {
	let postId = utils.getUrlParams()['postId']; // 帖子id
	let section = utils.getUrlParams()['section']; // 版块

	initEditor(); // 编辑器初始化
	

	function initEditor() {
		let E = window.wangEditor;
		let editor = new E('#editor');
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

	let url;
	switch (section) {
		case 'javaBase': url = bbs.res.javaBase + '/editInit';
			break;
		case 'javaThread': url = bbs.res.javaThread + '/editInit';
			break;
		case 'spring': url = bbs.res.spring + '/editInit';
			break;
		case 'mybatis': url = bbs.res.mybatis + '/editInit';
			break;
		case 'hibernate': url = bbs.res.hibernate + '/editInit';
			break;
		case 'struts': url = bbs.res.struts + '/editInit';
			break;
		case 'otherFramework': url = bbs.res.otherFramework + '/editInit';
			break;
		case 'oracle': url = bbs.res.oracle + '/editInit';
			break;
		case 'mysql': url = bbs.res.mysql + '/editInit';
			break;
		case 'otherDb': url = bbs.res.otherDb + '/editInit';
			break;
		default:
			utils.msg.error('此版块不存在');
	}
	
	bbs.mainApi.ajax({
		url: url,
		data: {
			postId: postId,
			section: section,
		}
	})

	
})