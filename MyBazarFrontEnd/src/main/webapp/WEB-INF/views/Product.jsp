<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<%@include file="Header.jsp"%>

<c:if test="${flag}">
<form action="<c:url value="/updateProduct"/>" method="post">
	<table>
	<tr>
		<td>Product Id</td>
		<td><input type="text" name="product_id" value="${productCateogry.product_id}"></td>
	</tr>
		<tr>
			<td>Product Name</td>
			<td><input type="text" name="productname" value="${productCateogry.product_name}"></td>
		</tr>
		<tr>
			<td>Product Description</td>
			<td><input type="text" name="productDesc" value="${productCateogry.description}"></td>
		</tr>
		<tr>
			<td>Product Price</td>
			<td><input type="text" name="productprice" value="${productCateogry.price}"></td>
		</tr>
		<tr>
			<td>Product Stock</td>
			<td><input type="text" name="productstock" value="${productCateogry.stock}"></td>
		</tr>
		<tr>
			<td>Product Category</td>
			<td><input type="text" name="productcategory" value="${productCateogry.product_category}"></td>
		</tr>
		<tr>
			<td>Product Supplier</td>
			<td><input type="text" name="productsupplier" value="${productCateogry.supplierId}"></td>
		</tr>
		<tr>
			<td>Category ID</td>
			<td><input type="text" name="productcatid" value="${productCateogry.categoryId}"></td>
		</tr>
		<tr>
			<td colspan="2"><input type="submit" value="Save" /></td>
		</tr>



	</table>
	</form>













</c:if>
<c:if test="${!flag}">
<form action="<c:url value="/insertProdcuts"/>"  method="post" enctype="multipart/form-data">
	<table>
		<tr>
			<td>Product Name</td>
			<td><input type="text" name="productname"></td>
		</tr>
		<tr>
			<td>Product Description</td>
			<td><input type="text" name="productDesc"></td>
		</tr>
		<tr>
			<td>Product Price</td>
			<td><input type="text" name="productprice"></td>
		</tr>
		<tr>
			<td>Product Stock</td>
			<td><input type="text" name="productstock"></td>
		</tr>
		<tr>
			<td>Product Category</td>
			<td><input type="text" name="productcategory"></td>
		</tr>
		<tr>
			<td>Product Supplier</td>
			<td><input type="text" name="productsupplier"></td>
		</tr>
		<tr>
			<td>Category ID</td>
			<td><input type="text" name="productcatid"></td>
		</tr>
		<tr>
			<td>Product Image</td>
			<td><input type="file" name="file"></td>
		</tr>
		<tr>
			<td colspan="2"><input type="submit" value="Save" /></td>
		</tr>



	</table>
	</form>
	
	<table class="table">
		<tr>
			<td>Product Id</td>
			<td>Product Name</td>
			<td>Product Description</td>
			<td>Product Price</td>
			<td>Product Stock</td>
			<td>Product Category</td>
			<td>Product Supplier</td>
			<td>Category ID</td>
			</tr>
			<c:forEach items="${productCategory}" var="product">
				<tr>
				<td>${product.product_id}</td>
				<td>${product.product_name}</td>
				<td>${product.description}</td>
				<td>${product.price}</td>
				<td>${product.stock}</td>
				<td>${product.product_category}</td>
				<td>${product.supplierId}</td>
				<td>${product.categoryId}</td>
				
				<td>
			<a href="${pageContext.request.contextPath}/deleteProducts/${product.product_id}">Delete</a>
			<a href="<c:url value='/editProducts/${product.product_id}'/>" >Edit</a>
			</td>
				</tr>
				
			
			
			
			
			</c:forEach>
	
	</table>



</c:if>


</body>
</html>
