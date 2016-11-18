<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form"  prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><c:out value="${enquiry.name}"/></title>
</head>
<body>
<h1><c:out value="${enquiry.name}"/></h1>
<c:forEach items="${queries}" var="q">
<p><c:out value="${q.id}"></c:out></p>
<p><c:out value="${q.query}"></c:out></p>
<p><c:out value="${q.answer}"></c:out></p>
<form:form modelAttribute="delete_query" method="delete">
			<button type="submit">Delete</button>
</form:form>
</c:forEach>
<br><br>

<form:form modelAttribute="query" method="post">
	<fieldset>		
		<legend>Lisää uusi kysymys</legend>
		<p>
			<form:label	path="query">Uusi kysymys</form:label><br/>
			<form:input path="query" />		
		</p>
		<p>	
			<button type="submit">Lisää</button>
		</p>
	</fieldset>
</form:form>
</body>
</html>