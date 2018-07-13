$(function() {
	$('#addMeaningButton').click(function() {
		addFields();
	});
});

function addFields() {
	var html = "<input name='meaning[]' type='text'><br>";
	$('#wordFields').append(html);
}