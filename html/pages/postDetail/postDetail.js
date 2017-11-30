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

})