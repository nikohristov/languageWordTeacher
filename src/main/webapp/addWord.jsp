<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<!DOCTYPE html>
<html>

<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script>
$(function() {
	$('#addMeaningButton').click(function() {
		addFields();
	});
});

function addFields() {
	var html = "<input name='meaningList' type='text'><br>";
	$('#wordFields').append(html);
}
</script>
</head>

<body>
	<form action="${pageContext.request.contextPath}/AddWordServlet"
		method="post">
		<div id="wordFields">
			<input name="title" type="text" placeholder="Title"><br>
			<input name="meaningList" type="text"><br>
		</div>
		<button type="button" id="addMeaningButton">Add more meanings</button>
		<br> <input type="submit">
	</form>
</body>
</html>
