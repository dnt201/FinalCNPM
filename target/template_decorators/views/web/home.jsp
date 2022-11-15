<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/common/taglib.jsp" %>

<html>
<body>
<div id="carouselExampleIndicators" class="carousel slide" data-bs-ride="carousel">
    <div class="carousel-indicators">
        <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="0" class="active" aria-current="true" aria-label="Slide 1"></button>
        <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="1" aria-label="Slide 2"></button>
        <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="2" aria-label="Slide 3"></button>
    </div>
    <div class="carousel-inner " style="height:70vh !important;">
        <div class="carousel-item active">
            <img src="<c:url value='/assets/web/images/caus1.jpg'/>" class="d-block w-100" alt="...">
        </div>
        <div class="carousel-item">
            <img src="<c:url value='/assets/web/images/caus2.jpg'/>" class="d-block w-100" alt="...">
        </div>
        <div class="carousel-item">
            <img src="<c:url value='/assets/web/images/caus3.jpg'/>" class="d-block w-100" alt="...">
        </div>
    </div>
    <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide="prev">
        <span class="carousel-control-prev-icon" aria-hidden="true"></span>
        <span class="visually-hidden">Previous</span>
    </button>
    <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide="next">
        <span class="carousel-control-next-icon" aria-hidden="true"></span>
        <span class="visually-hidden">Next</span>
    </button>
</div>

    <div class="flex_column_center w-100">
        <h1 class="button mt_16px mb_16px ">Products</h1>
        <a href="<c:url value='/products'/>" class="pd_1628 mb_16px bg_gray cl_white btnHomePage">
        Details</a>
        <video class="w100 mt_16px" style="height:100vh !important;" autoPlay="autoPlay" loop="loop" muted="muted"
               src="<c:url value='/assets/web/images/backGround.mp4'/>">
        </video>
    </div>
</body>
</html>
