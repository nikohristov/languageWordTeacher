<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<body>
	<div>
		<table>
			<tr>
				<td>
					<form action="${pageContext.request.contextPath}/AddWordServlet" method="get">
						<input type="submit" value="Add new word">
					</form>

				</td>
			</tr>
			<tr>
				<td><button type="submit" formaction="/addWord">Start
						an exam</button></td>
			</tr>
		</table>
	</div>
</body>
</html>
