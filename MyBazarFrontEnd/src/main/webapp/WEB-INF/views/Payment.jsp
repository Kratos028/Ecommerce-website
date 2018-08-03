<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@include file="Header.jsp"%>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css"
	integrity="sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB"
	crossorigin="anonymous">

<div class="container">
<form action="<c:url value="/paymentprocess"/>" method="post">
<table>
<tr>
			<td colspan="4">Total Amount</td>
			<td colspan="2">${total}</td>
			</tr>


</table>
	<table class="table">
		<tr>

			<td colspan="2">Payment option</td>
		</tr>

		<tr>
			<td colspan="2">
				<input type="radio" name="payment" value="CC"/>Credit Card
				<input type="radio" name="payment" value="COD"/>Cash on Delivery
			<tr>
				<td>Card no: </td>
				<td><input type="text" name="cardnumber" required/></td>
				</tr>
				<tr>
				<td>CVV </td>
				<td><input type="text" name="cvv" required/></td>
				</tr>
				<tr>
				<td>Valid Upto </td>
				<td><input type="text" name="vu" required/></td>
				</tr>
				<tr>
				<td colspan="2">
					<input type="submit" value="Payment">
				
				</tr>
		
		
		
		
		
		
		</table>
	
	
	
	
	
	
	
	
	</form>
	</div>