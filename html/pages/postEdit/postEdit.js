$(function() {
	let postId = utils.getUrlParams()['postId']; // 帖子id
	let section = utils.getUrlParams()['section']; // 版块

	CKEDITOR.replace('editor');

	// bbs.mainApi.ajax({
	// 	url: bbs.res.postEdit,
	// 	data: 
	// })
})