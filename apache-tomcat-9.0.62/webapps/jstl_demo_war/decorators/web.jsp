<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="/common/taglib.jsp" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <!--Bootstrap-->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
    <!-- My javascript -->
    <!-- Font awesome -->
    <link rel="stylesheet" href="https://kit-pro.fontawesome.com/releases/v5.12.1/css/pro.min.css" />
    <script src="https://use.fontawesome.com/releases/v5.15.3/js/all.js" crossorigin="anonymous"></script>
    <!-- My Css -->
<%--    <link href="" rel="stylesheet">--%>
<%--    <link href="/css/header.css" rel="stylesheet">--%>
<%--    <link href="/css/web.css" rel="stylesheet">--%>
<%--    <link href="/css/coreTags.css" rel="stylesheet">--%>
    <link rel="stylesheet" type="text/css"
          href="<c:url value='/css/footer.css'/> ">
    <link rel="stylesheet" type="text/css"
          href="<c:url value='/css/header.css'/> ">
    <link rel="stylesheet" type="text/css"
          href="<c:url value='/css/web.css'/> ">
    <link rel="stylesheet" type="text/css"
          href="<c:url value='/css/coreTags.css'/> ">
    <!-- Font family -->
    <link href="https://fonts.googleapis.com/css2?family=Poppins:ital,wght@0,100;0,200;0,300;0,400;0,500;0,600;0,700;0,800;0,900;1,100;1,200;1,300;1,400;1,500;1,600;1,700;1,800;1,900&display=swap" rel="stylesheet">
</head>
<body>

<%@ include file="/common/web/header.jsp" %>
<div class="min-h-100">
    <dec:body />
</div>

<%@ include file="/common/web/footer.jsp" %>
<%--<button onclick="topFunction()" id="myBtn-scroll-top" title="Go to top"><i class="fa fa-angle-double-up"></i></button>--%>

<script src="https://www.gstatic.com/firebasejs/8.2.8/firebase-app.js"></script>
<script src="https://www.gstatic.com/firebasejs/8.2.8/firebase-storage.js"></script>
<%--<script type="module">--%>
<%--    const firebaseConfig = {--%>
<%--        apiKey: "AIzaSyDYgZ1VgYlLnC_y0mhHKHuMAhFq0i8g-ho",--%>
<%--        authDomain: "doancongnghethongtin-2df4c.firebaseapp.com",--%>
<%--        projectId: "doancongnghethongtin-2df4c",--%>
<%--        storageBucket: "doancongnghethongtin-2df4c.appspot.com",--%>
<%--        messagingSenderId: "311479252720",--%>
<%--        appId: "1:311479252720:web:c6494cc2ac545d8cb3b435",--%>
<%--        measurementId: "G-EKDXYS51BE"--%>
<%--    };--%>
<%--    firebase.initializeApp(firebaseConfig);--%>
<%--</script>--%>

</body>

</html>
