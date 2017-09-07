$(".answerSection").click(function() {
	var target_selector = $(this).attr('data-target');
	var $target = $(target_selector);
	if($target.is(':hidden')){
		$(this).text("Hide Answer");
		$target.show();
	} else {
		$(this).text("Show Answer");
		$target.hide();
	}
});
