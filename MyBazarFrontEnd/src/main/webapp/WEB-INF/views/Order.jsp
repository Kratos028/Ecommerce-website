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
			
		</tr>

		<c:forEach items="${cartitem}" var="cart">
		
			<tr>
				<td>${cart.productName}</td>
				<td><input type="text"  name="quantity" value="${cart.quantity}"  /></td>
				<td>${cart.price}</td>
				<td>${cart.quantity*cart.price}</td>
				
					</tr>
					
					
		</c:forEach>
		<tr>
			<td colspan="4">Total Amount</td>
			<td colspan="4">${total}/-</td>
			</tr>
			<tr>
         	<td><a href="<c:url value="/continueShopping"/>"  class="btn btn-warning"><i class="fa fa-angle-left"></i> Continue Shopping</a></td>
                        <td><a href="<c:url value="/payment"/>"  class="btn btn-success btn-lg btn-block"> Payment</a></td>
                    </tr>
	</table>
</div>
