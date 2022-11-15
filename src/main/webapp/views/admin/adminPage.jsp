<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/common/taglib.jsp" %>

<title>Admin Dashboard</title>

<div class="home-content">
    <div class="overview-boxes">
        <div class="box">
            <div class="right-side">
                <div class="box-topic">Số sản phẩm</div>
                <div class="number">${requestScope.productQty}</div>
                <div class="indicator">
                    <i class='fa fa-arrow-alt-circle-up'></i>
                    <span class="text">Cập nhật trong tháng</span>
                </div>
            </div>
            <i class=' fa fa-shopping-basket cart'></i>
        </div>
        <div class="box">
            <div class="right-side">
                <div class="box-topic">Tổng tiền</div>
                <div class="number">
                    <fmt:formatNumber type = "number" value = "${requestScope.totalMoney}" /> đ</div>
                <div class="indicator">
                    <i class='fa fa-arrow-alt-circle-down'></i>
                    <span class="text">Cập nhật trong tháng</span>
                </div>
            </div>
            <i class='fa fa-dollar-sign cart two' ></i>
        </div>
        <div class="box">
            <div class="right-side">
                <div class="box-topic">Số đơn hàng</div>
                <div class="number">${requestScope.orderQty}</div>
                <div class="indicator">
                    <i class='fa fa-arrow-alt-circle-up'></i>
                    <span class="text">Cập nhật trong tháng</span>
                </div>
            </div>
            <i class=' fa fa-receipt cart three' ></i>
        </div>
        <div class="box">
            <div class="right-side">
                <div class="box-topic">User</div>
                <div class="number">${requestScope.userQty}</div>
                <div class="indicator">
                    <i class='fa fa-arrow-alt-circle-up'></i>
                    <span class="text">Cập nhật trong tháng</span>
                </div>
            </div>
            <i class='fa fa-user-shield cart four' ></i>
        </div>
    </div>
    <div class="wrap-themdzochodzuiiiii">
        <img class="themdzochodzuiiiii" src="<c:url value='/assets/web/images/ajoKz.png'/>"/>
        <img class="themdzochodzuiiiii" src="<c:url value='/assets/web/images/free-bar-.png'/>"/>
    </div>
</div>