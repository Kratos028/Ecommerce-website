<%@include file="Header.jsp"%>
		<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
        
        
        

<div class="card">
	<div class="row">
		<aside class="col-sm-5 border-right">
<article class="gallery-wrap"> 

<div class="img-small-wrap">
  <div class="item-gallery"> <img src="<c:url value="/resources/images/${product.code}.jpg"/>" style="width:550px; height:600px;"> </div>
 <%--  <div class="item-gallery"> <img src="<c:url value="/resources/images/${product.code}.jpg"/>" style="width:100px;"> </div> --%>
  
</div> 
</article> 
		</aside>
		<aside class="col-sm-7">
<article class="card-body p-5">
	<h3 class="title mb-3">${product.product_name}</h3>

<p class="price-detail-wrap"> 
	<span class="price h3 text-warning"> 
		<span class="num">${product.price}/-</span>
	</span> 
	
</p> <!-- price-detail-wrap .// -->
<dl class="item-property">
  <dt>Description</dt>
  <dd><p>${product.description}</p></dd>
</dl>
<dl class="param param-feature">
  <dt>Product No.</dt>
  <dd>${product.product_id}</dd>
</dl> 
<dl class="param param-feature">
  <dt>Stock</dt>
  <dd>${product.stock}</dd>
</dl> 

<hr>
<form action="<c:url value="/addToCart/${product.product_id}"/>" method="get">
	<div class="row">
		<div class="col-sm-5">
			<dl class="param param-inline">
			
			  <dt>Quantity</dt>
			  <dd>
			  	<select name="quantity" class="form-control form-control-sm" style="width:70px;">
			  		<option> 1 </option>
			  		<option> 2 </option>
			  		<option> 3 </option>
			  	</select>
			  </dd>
			</dl> 
		 
	<hr>
	<!-- <a href="#" class="btn btn-lg btn-primary text-uppercase"> Buy now </a> -->
	<input type="submit" value="Add To Cart" class="btn btn-info btn-block"/>
	
	
	</div> 
		
	</div>
		</form>
</article> 
		</aside> 
	</div> 
</div>

        