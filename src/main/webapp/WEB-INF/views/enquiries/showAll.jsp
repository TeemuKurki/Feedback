<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Show All Enquiries</title>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>

	<div class="jumbotron" id="headerjumbotron">
		<h1 class="text-center">Tervetuloa testisivulle</h1>
	</div>
	<div class="nav">
		<div class="btn-group btn-group-justified">
			<a href="/Feedback/" class="btn btn-warning btn-lg">Front Pageee</a>
  			<a href="/Feedback/addEnquiry/" class="btn btn-warning btn-lg">Create Form</a>
			<a href="/Feedback/enquiries/" class="btn btn-warning btn-lg active">Enquiries</a>
		</div>
	</div>
	
	<div class="container">
		<div class="row">
			<div class="col-sm-3"></div>
			<div class="col-sm-6">
				<div class="list-group">
					<c:forEach items="${enquiries}" var="e">
						<h1><a class="list-group-item" href="${e.id}/edit"><c:out value="${e.id}"/>. <c:out value="${e.name}"/></a></h1>
						<!--<p><c:forEach items="${e.queries}" var="q">
						<p><c:out value="${q.id}"/>. <c:out value="${q.query}"/></p>
						</c:forEach> </p>-->
					</c:forEach>
				</div>
	
	</div>
	<div class="col-sm-3"></div>
</body>
</html>