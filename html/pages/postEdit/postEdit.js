$(function() {
	let postId = utils.getUrlParams()['postId']; // 帖子id
	let section = utils.getUrlParams()['section']; // 版块

	initEditor(); // 编辑器初始化
	

	function initEditor() {
		let E = window.wangEditor;
		let editor = new E('#editor');
		editor.customConfig.uploadImgShowBase64 = true   // 使用 base64 保存图片
    	// editor.customConfig.uploadImgServer = '/upload'  // 上传图片到服务器
    	if (bbs.MainPage.isMobile) {
    		// 自定义菜单配置
		    editor.customConfig.menus = [
		        'emoticon',  // 表情
    			'image',  // 插入图片
		    ]
    	}
		editor.create();
	}

	// bbs.mainApi.ajax({
	// 	url: bbs.res.postEdit,
	// 	data: 
	// })
})