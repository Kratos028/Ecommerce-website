<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@include file="Header.jsp" %>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css"
	integrity="sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB"
	crossorigin="anonymous">

<div class="container">
	<table class="table">

		<tr>

			<td>Product Name</td>
			<td>Quantity</td>
			<td>Price</td>
			<td>Total Price</td>
			<td>Operation</td>
		</tr>

		<c:forEach items="${cartitems}" var="cart">
		<form action="<c:url value="/updateCartItem/${cart.cartItemid}"/>" method="post">
			<tr>
				<td>${cart.productName}</td>
				<td><input type="text"  name="quantity" value="${cart.quantity}"  /></td>
				<td>${cart.price}</td>
				<td>${cart.quantity*cart.price}</td>
				<td><input type="submit" value="Update" class="btn btn-info" />
					<a href="<c:url value="/deleteCartItem/${cart.cartItemid}"/>"
					class="btn btn-danger">Delete</a></td>
					</tr>
					</form>	
					
		</c:forEach>
		<tr>
			<td colspan="4">Total Amount</td>
			<td colspan="4">${total}</td>
			</tr>
			<tr>
         	<td><a href="<c:url value="/continueShopping"/>"  class="btn btn-warning"><i class="fa fa-angle-left"></i> Continue Shopping</a></td>
                        <td>
                        <td><a href="<c:url value="/checkout"/>"  class="btn btn-success btn-block"><i class="fa fa-angle-right"></i> Checkout</a></td>
                    </tr>
	</table>
</div>
