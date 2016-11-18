<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Show All Enquiries</title>
</head>
<body>
	<c:forEach items="${enquiries}" var="e">
	<h1><a href="${e.id}/edit"><c:out value="${e.id}"/>. <c:out value="${e.name}"/></a></h1>
	<!--<p><c:forEach items="${e.queries}" var="q">
		<p><c:out value="${q.id}"/>. <c:out value="${q.query}"/></p>
		</c:forEach> </p>-->
	</c:forEach>
</body>
</html>