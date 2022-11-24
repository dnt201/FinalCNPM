<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="/common/taglib.jsp" %>

<nav class="header">
    <button class="left-items">
        <img src="<c:url value='/images/Mercedes-Benz.png'/> " alt="logo"/>
        <p>Logo</p>
    </button>
    <div class="center-items">
        <a class="vertical-center" href="<c:url value='/core-tags'/>">Core Tags</a>
        <a class="vertical-center"  href="<c:url value='/formatting-tags'/>">Formatting tags</a>
        <a class="vertical-center" href="<c:url value='/functions'/>">JSTL Functions</a>
    </div>
</nav>
