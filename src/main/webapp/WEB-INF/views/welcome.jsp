<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Feedback Starting page</title>
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
			<a href="./" class="btn btn-warning btn-lg active">Front Pageee</a>
  			<a href="addEnquiry" class="btn btn-warning btn-lg">Create Form</a>
  			<a href="enquiries/" class="btn btn-warning btn-lg">Enquiries</a>
		</div>
	</div>
	
	<div class="container">
		<div class="row">
			<div class="col-sm-3"></div>
			<div class="col-sm-6">
				<h1><a href="http://i2.cdn.turner.com/cnnnext/dam/assets/150807073434-donald-trump-gop-debate-thumbs-up-august-6-full-169.jpg" style="color:black; text-decoration:none">Toimii</a></h1>
		
				<p>
					<a href="enquiries">Enquiries.json</a>
				</p>
				<select name="Enquiry select" onchange="location = this.value;">
					<option value="">Select Enquiry id</option>
					<option value="1">1</option>
					<option value="2">2</option>
				</select>			
			</div>
			<div class="col-sm-3"></div>
		</div>
		
	</div>	
</body>
</html>