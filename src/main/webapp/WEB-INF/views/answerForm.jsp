<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://www.springframework.org/tags/form"  prefix="form"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Insert title here</title>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>

	<div class="jumbotron" id="headerjumbotron">
		<h1 class="text-center">Tervetuloa testisivulle</h1>
	</div>
	<div class="page-header">
		<div class="btn-group btn-group-justified">
			<a href="welcome.jsp" class="btn btn-warning btn-lg">Front Pageee</a>
  			<a href="createForm.jsp" class="btn btn-warning btn-lg">Create Form</a>
  			<a href="createQuery.jsp" class="btn btn-warning btn-lg">Create Query</a>
		</div>
	</div>
	
			<form:form modelAttribute="answer" method="post">
		  	<fieldset>		
				<legend>Lisää uusi Vastaus</legend>
				<p>
					<form:label	path="answer">Uusi vastaus</form:label><br/>
					<form:input path="answer" />		
				</p>
				<p>	
					<button type="submit">Lisää</button>
				</p>
			</fieldset>
		</form:form>

</body>
</html>