
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	<%@include file="Header.jsp"%>


 

<c:if test="${flag}">
<form action="<c:url value="/category/updateCategory"/>" method="post">

	<table>
	<tr>
		<td>Category Id</td>
		<td><input type="text" name="categoryId" value="${categoryData.categoryId}" readonly="readonly"/>
		<td>Category Name</td>
		<td><input type="text" name="categoryName" value="${categoryData.categoryName}"/>
		<td>Category Description</td>
		<td><input type="text" name="categoryDesc" value="${categoryData.categoryDesc}"/>
		
			<td colspan="2"><input type="submit" value="Update" /></td>
		</tr>
	</table>




</form>

</c:if>
<c:if test="${!flag}">
<form action="<c:url value="/category/InsertCategory"/>" method="post">

	<table>
		<tr>
			<td>Category Name</td>
			<td><input type="text" name="categoryName" /></td>
		</tr>
		<tr>
			<td>Category Description</td>
			<td><input type="text" name="categoryDesc" /></td>
		</tr>

		<tr>
			<td colspan="2"><input type="submit" value="Submit" /></td>
		</tr>
	</table>




</form>
<table>
	<tr>
	<td>Category ID</td>
	<td>Category Name</td>
	<td>Category Description</td>
	<td>Operation</td>
	</tr>
	<c:forEach items="${categorylist}" var="category">
	<tr>
		<td>${category.categoryId}</td>
		<td>${category.categoryName}</td>
		<td>${category.categoryDesc}</td>
		<td>
		
			<a href="<c:url value='/category/deleteCategory/${category.categoryId}'/>" >Delete</a>
			<a href="<c:url value='/category/editCategory/${category.categoryId}'/>" >Edit</a>
			</td>
		</tr>
</c:forEach>


</table>
</c:if>
</body>
</html>