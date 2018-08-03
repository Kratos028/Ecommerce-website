<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@include file="Header.jsp"%>


<form action="<c:url value="/insertUser"/>" method="Post">
<div class="form-group">
	<label for="email" class="col-md-3 control-label">Email</label>
	<div class="col-md-9">
		<input type="text" class="form-control" name="email"
			placeholder="Email Address">
	</div>
</div>

<div class="form-group">
	<label for="firstname" class="col-md-3 control-label"> Name</label>
	<div class="col-md-9">
		<input type="text" class="form-control" name="firstname"
			placeholder="User Name">
	</div>
</div>

<div class="form-group">
	<label for="password" class="col-md-3 control-label">Password</label>
	<div class="col-md-9">
		<input type="password" class="form-control" name="passwd"
			placeholder="Password">
	</div>
</div>
<div class="form-group">
	<label for="phoneno" class="col-md-3 control-label">Phone
		Number</label>
	<div class="col-md-9">
		<input type="text" name="PhoneNumber" pattern="[7-9]{1}[0-9]{9}"
			class="form-control"  placeholder="Number">
	</div>
</div>

<div class="form-group">
	<!-- Button -->
	<div class="col-md-offset-3 col-md-9">
		<input type="submit" value="Sign Up">

	</div>
</div>





</form>





</body>
</html>