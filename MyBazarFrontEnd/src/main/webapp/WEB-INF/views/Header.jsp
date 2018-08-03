<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 <%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html>
<head>

 <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" integrity="sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB" crossorigin="anonymous">
	  <link href="<c:url value="/resources/bootstrap/style.css"/>" rel="stylesheet">
	   <link href="<c:url value="/resources/bootstrap/javascr.js"/>" rel="stylesheet">
	    <link href="css/font-awesome.css" rel="stylesheet">
	     <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/animate.css/3.5.2/animate.min.css">
	   

</head>
<body>

    <nav class="Hifishope-navbar navbar navbar-expand-lg navbar-light bg-light">
		<div class="container">
  <a class="navbar-brand" href="${pageContext.request.contextPath}/">HifiShope</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>


  <div class="collapse navbar-collapse" id="navbarSupportedContent">
    <ul class="navbar-nav mr-auto ">
    
      <li class="nav-item">
        <a class="nav-link" href="aboutus">About Us</a>
      </li>
    <c:if test="${user.role=='USER_ADMIN '}">
      <li class="nav-item ">
       <a class="nav-link" href="manageproducts">Products</a>
        
      </li>
        <li class="nav-item ">
       <a class="nav-link" href="suppliermanage">Supplier</a>
        
      </li>
     
     <li class="nav-item">
      <a class="nav-link disabled" href="category">Category</a></li>
      </c:if>
      <li class="nav-item">
        <a class="nav-link disabled" href="contactus">Contact Us</a>
      </li>
      <c:if test="${loggedin!=true}">
      <li class="nav-item">
      <a class="nav-link disabled" href="login">Login</a>
      </li>
      <li class="nav-item">
      <a class="nav-link disabled" href="register">Register</a>
      </li>
      </c:if>
      <li class="nav-item">
      <a class="nav-link disabled" href="productDisplay">Display Products</a>
      </li>
      
    </ul>
    <%-- <form action="${pageContext.request.contextPath}/search" class="form-inline my-2 my-lg-0">
      <input class="form-control mr-sm-2" name="keyword" type="search" placeholder="Search" aria-label="Search">
      <button type="submit" class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button> --%>
		
		
		<div class ="nav navbar-nav navbar-right">
		<font color="black" face="calibri" size="3">Welcome :${user.name}</font>
		<c:if test="${loggedin==true}">
		 <a class="btn btn-primary btn-md" data-submit="parent" href="${pageContext.request.contextPath}/logout" rel="nofollow">
               <i class="icon-off"></i> Logout
            </a></c:if>
		
		</div>
    </form>
	  
  </div>
		</div>
</nav>





</body>
</html>
