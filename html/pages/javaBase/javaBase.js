$(function() {
	let page = new bbs.MainPage();
	page.init();

	$('#postNew').on('click', function(event) {
		event.preventDefault();
		let section = $(this).attr('data-section');
		layer.iframe({
			title: '发新帖',
			content: 'postEdit.html?section=' + section,
		})
	})
})