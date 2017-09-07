$('#editorDiv').trumbowyg();

$("#addNewAnswer").click(function(){
	var answerRows = $('#answerTable > tbody > tr').length;
	var newRow = "<tr><td><input type=\"text\" name=\"answers["+answerRows+"].content\" class=\"form-control\" required=\"required\"></input></td><td><input type=\"checkbox\" name=\"answers["+answerRows+"].correctOption\" class=\"form-control\"></input></td></tr>";
	$("#answerTable").append(newRow);
});