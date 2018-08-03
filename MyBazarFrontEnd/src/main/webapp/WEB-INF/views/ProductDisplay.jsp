<%@include file="Header.jsp"%>
		<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
        

    
       <div class="row">
       <c:forEach items="${produclist}" var="product">
<div class="col-md-3">
	<figure class="card card-product">
		<div class="img-wrap"> 
			<img src="<c:url value="/resources/images/${product.code}.jpg"/>" style="width:200px; ">
			<a class="btn-overlay" href="<c:url value="/totalproductinfo/${product.product_id}"/>"><i class="fa fa-search-plus"></i> Quick view</a>
		</div>
		<figcaption class="info-wrap">
			<h6 class="title text-dots">${product.product_name}</h6>
			<div class="action-wrap">
				<!-- <a href="login" class="btn btn-primary btn-sm float-right"> Order </a> -->
				<div class="price-wrap h5">Price
					<span class="price-new">${product.price}/-</span>
					
				</div> <!-- price-wrap.// -->
			</div> <!-- action-wrap -->
		</figcaption>
	</figure> <!-- card // -->
</div> 
</c:forEach>
</div>
        
        