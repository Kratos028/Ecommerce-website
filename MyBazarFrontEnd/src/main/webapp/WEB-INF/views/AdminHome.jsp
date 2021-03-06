<%@ include file="Header.jsp" %>

<link href="//netdna.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
 <link href="<c:url value="/resources/bootstrap/style.css"/>" rel="stylesheet">
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<script src="//netdna.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>


<div id="carouselExampleIndicators" class="carousel slide" data-ride="carousel">
  <ol class="carousel-indicators">
    <li data-target="#carouselExampleIndicators" data-slide-to="0" class="active"></li>
    <li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
    <li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
  </ol>
  <div class="carousel-inner">
    <div class="carousel-item active">
      <img class="d-block w-100" src="<c:url value="/resources/images/harkum_2018-04-26T13-00_9647b9_1112610_1024x300._CB496450020_.jpg"/>" alt="First slide" style=" width:1345px height:592px;">
    </div>
    <div class="carousel-item">
      <img class="d-block w-100" src="<c:url value="/resources/images/Apple_TV_4k.png"/>" alt="Second slide">
    </div>
    <div class="carousel-item">
      <img class="d-block w-100" src="<c:url value="/resources/images/24-05-2018-1.jpg"/>" alt="Third slide">
    </div>
  </div>
  <a class="carousel-control-prev" href="#carouselExampleIndicators" role="button" data-slide="prev">
    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
    <span class="sr-only">Previous</span>
  </a>
  <a class="carousel-control-next" href="#carouselExampleIndicators" role="button" data-slide="next">
    <span class="carousel-control-next-icon" aria-hidden="true"></span>
    <span class="sr-only">Next</span>
  </a>
</div>