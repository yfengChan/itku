$(".answerSection").click(function() {
	var target_selector = $(this).attr('data-target');
	var $target = $(target_selector);
	if($target.is(':hidden')){
		$(this).text("隐藏答案");
		$target.show();
	} else {
		$(this).text("显示答案");
		$target.hide();
	}
});
