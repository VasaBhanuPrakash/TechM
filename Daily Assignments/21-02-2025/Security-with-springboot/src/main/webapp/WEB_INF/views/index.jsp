<!Doctype html>
<html>
<head>
<title>Home</title>
</head>
<body>
	<h2>Hello ${pageContext.request.userPrincipal.name},</h2>
	<h3>Welcome to Security in Spring Boot!</h3>
	<a href="<c:url value='/logout'/>">Click here to log out</a>
</body>
</html>