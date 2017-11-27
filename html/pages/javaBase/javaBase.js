$(function() {
	let page = new bbs.MainPage();
	page.initPageQuery = function() {
		bbs.mainApi.ajax({
			url: bbs.res.javaBase + '/search',
		}).done(function(r) {
			let res = {};
			res.rows = r.list;
			$('.resultList').html(Mustache.render($('#resultTmpl').html(), res));
		})
	}
	page.init();

})