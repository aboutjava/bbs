$(function() {
	let postId = utils.getUrlParams()['postId']; // 帖子id
	let sectionId = utils.getUrlParams()['section']; // 版块

	let page = new bbs.MainPage();
	page.initPageQuery = function() {
		bbs.mainApi.ajax({
			url: bbs.res.postDetail + '/search',
			data: {
				postId: postId,
			}
		}).done(function(r) {
			
		})
	}
	page.init();

})