<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@include file="Header.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<div class="container">
<c:if test="${flag}">
<form action="<c:url value="/updateSupplier"/>"  method="post" enctype="multipart/form-data">
	<table class="table">
	
	<tr>
		<td>Supplier Id</td>
		<td><input type="text" name="sup_id" value="${supplierlist.sup_id}" readonly="readonly"/></td>
	</tr>
		<tr>
			<td>Supplier Name</td>
			<td><input type="text" name="suppliername" value="${supplierlist.dealer_Name}"></td>
		</tr>
		<tr>
			<td>Supplier Description</td>
			<td><input type="text" name="supplierDesc" value="${supplierlist.dealer_desc}"></td>
		</tr>
		<tr>
			<td>Supplier Address</td>
			<td><input type="text" name="supplieraddress" value="${supplierlist.dealer_address}"></td>
		</tr>
		
<tr>
			<td colspan="2"><input type="submit" value="Save" /></td>
		</tr>



	</table>
	</form>
	</c:if>










<c:if test="${!flag}">
<form action="<c:url value="/insertSupplier"/>"  method="post" enctype="multipart/form-data">
	<table class="table">
		<tr>
			<td>Supplier Name</td>
			<td><input type="text" name="suppliername"></td>
		</tr>
		<tr>
			<td>Supplier Description</td>
			<td><input type="text" name="supplierDesc"></td>
		</tr>
		<tr>
			<td>Supplier Address</td>
			<td><input type="text" name="supplieraddress"></td>
		</tr>
		
<tr>
			<td colspan="2"><input type="submit" value="Save" /></td>
		</tr>



	</table>
	</form>

	<table class="table">
		<tr>

			<td>Supplier Id</td>
			<td>Supplier Name</td>
			<td>Supplier Description</td>
			<td>Supplier Address</td>
		</tr>
				<c:forEach items="${supplierlist}" var="sup">
				<tr>
					<td>${sup.sup_id}</td>
					<td>${sup.dealer_Name}</td>
					<td>${sup.dealer_desc}</td>
					<td>${sup.dealer_address}</td>
					
					
				
				<td>
					<a href="<c:url value='/editSupplier/${sup.sup_id}'/>" >Edit</a>
					<a href="<c:url value='/deleteSupplier/${sup.sup_id}'/>" >Delete</a>
					
					
					</td>
				
				
				</tr>
				
				</c:forEach>


	</table>


</c:if>

</div>