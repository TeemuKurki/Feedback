<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><c:out value="${enquiry.name}"/></title>
</head>
<body>
<h1><c:out value="${enquiry.name}"/></h1>
<form method="post">
	<c:forEach items="${queries}" var="q">
	<p><c:out value="${q.id}"></c:out></p>
	<p><c:out value="${q.query}"></c:out></p>
	<p><c:out value="${q.answer}"></c:out></p>
	</c:forEach>
</form>
</body>
</html>