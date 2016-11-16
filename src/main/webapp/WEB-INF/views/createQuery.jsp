<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form"  prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Kysymyslomake</title>
</head>
<body>
		<form:form modelAttribute="enquiries/"+<c:out value="${queries.id}"/>+"/edit" method="post">
		  	<fieldset>		
				<legend>Lisää uusi kysymys</legend>
				<p>
					<form:label	path="name">Uusi kysymys</form:label><br/>
					<form:input path="name" />
				</p>
				<p>	
					<button type="submit">Lisää</button>
				</p>
			</fieldset>
		</form:form>
</body>
</html>