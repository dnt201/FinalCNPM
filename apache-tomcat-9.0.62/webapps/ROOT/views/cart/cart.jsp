<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/common/taglib.jsp" %>

<div class="CartPage">
    <%--    {showDetailOder && orderCreate.order && <ThankForBuy handleClose={() => setShowDetailOrder(!showDetailOder)} id={orderCreate?.order?._id} user={orderCreate?.order?.user} thanks={true} />}--%>

    <div class="cart-information">
        <h1 class="w-100p center">Thông tin</h1>
        <c:if test="${not empty User}">
            <div class="m-l-8px">
                <h4>Họ tên: ${User.username}</h4>
                <h4>Gmail: ${User.email}</h4>
                <h4>Số điện thoại: ${User.phone}</h4>
                <h4>Địa chỉ: ${User.address}</h4>
            </div>
        </c:if>
        <c:if test="${empty User}">
            <div class="t-a-center">
                Bạn chưa đăng nhập, hãy <a class="lazy-css" href="<c:url value='/login?action=login'/>">đăng nhập</a> để
                hoàn tất đơn hàng! &#10084;
            </div>
        </c:if>
        <div class="container-cart-page">
            <div class="cart-page-left flex-4">
                <div class="left-header">
                    <h1> Shopping Cart</h1>
                    <c:if test="${empty order || order.orderItemsList.size() <= 0}">
                        <span>Số item: 0 </span>
                    </c:if>
                    <c:if test="${order.orderItemsList.size() > 0}">
                        <span>Số item: ${order.orderItemsList.size()} </span>
                    </c:if>
                </div>
                <div class="left-list-item">

                    <table class="w-100p">
                        <colgroup>
                            <col span="1" style="width:30%"/>
                            <col span="1" style="width:30%"/>
                            <col span="1" style="width:10%"/>
                            <col span="1" style="width:10%"/>
                            <col span="1" style="width:20%"/>
                        </colgroup>
                        <thead>
                        <tr>
                            <th class="t-a-center">Item</th>
                            <th class="t-a-center">Image</th>
                            <th class="t-a-center">Price</th>
                            <th class="t-a-center">Quantity</th>
                            <th class="t-a-center">Total</th>
                        </tr>
                        </thead>
                        <tbody>
                        <%-- map cart item--%>
                        <c:forEach var="item" items="${order.orderItemsList}">
                                <tr class="item vtc-al-baseline ta-center  row-item-lazzy-quatroidat">
                                    <td class="flex al-it-center jfct-center item-infor">
                                        <div>
                                            <span class="cart-item-price">${item.productModel.productName} ${item.id} ${item.id.order_id}${item.id.product_id} </span>
                                            <br/>
                                            <form action="<c:url value ='/cart' />">
                                                <input type="hidden" name="product_id" value="${item.productModel.product_id}"/>
                                                <input type="hidden" name="action" value="remove"/>
                                            <button class="remove-cart-item-btn">Remove <i
                                                    class="fa fa-times remove-cart-item"></i></button>
                                            </form>
                                        </div>
                                    </td>
                                    <td>
                                        <img class="cart-item-img"
                                             src=<c:url value='${item.productModel.image}'/>alt="image"/>
                                    </td>
                                    <td>
                                        <c:if test="${item.productModel.discount.discountPercent <= 0}">
                                            <span class="cart-item-price">
                                                    <fmt:formatNumber type="number"
                                                                      value="${item.productModel.price}"/> đ </span>
                                        </c:if>

                                        <c:if test="${item.productModel.discount.discountPercent > 0}">
                                        <span class="cart-item-price-x">
                                            <fmt:formatNumber type="number" value="${item.productModel.price}"/> đ
                                        </span>
                                            <br/>
                                            <span class="cart-item-price sale">
                                        <fmt:formatNumber type="number"
                                                          value="${item.productModel.price - item.productModel.price*item.productModel.discount.discountPercent/100}"/> đ
                                        </span>
                                        </c:if>

                                    </td>
                                    <td>
                                        <form class="flex" action="<c:url value ='/cart' />">
                                            <input type="hidden" name="product_id" value="${item.productModel.product_id}"/>
                                            <input type="hidden" name="action" value="update"/>
                                        <input class="w-80p" type="number" id="quantity" name="quantity"
                                               value="${item.quantity}" />
                                        <button class="reload-item-quantity"><i
                                                class="fa fa-sync-alt  cl-success"></i></button>
                                        </form>
                                        <c:if test="${item.productModel.discount.discountPercent > 0}">
                                            <span class="alert-danger">
                                            Sale ${item.productModel.discount.discountPercent}%
                                        </span>
                                        </c:if>
                                    </td>
                                    <td>
                                <span>
                                    <fmt:formatNumber type="number" value="${(item.productModel.price - item.productModel.price*item.productModel.discount.discountPercent/100)*item.quantity}"/> đ
                                </span>
                                    </td>
                                </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                    <c:if test="${empty order}">
                        <h3 class="ta-center w-100p"><i>Bạn chưa có sản phẩm nào trong giỏ</i></h3>
                    </c:if>
                </div>
                <div class="footer">
                    <button>Back to shop</button>
                </div>
            </div>

            <div class="cart-page-right ">
                <div class="right-header">
                    <h1 class="ta-center"> ShopND</h1>

                </div>
                <div class="right-container flex-8">
                    <c:if test="${empty order}">
                        <h3 class="t-a-center"> Opps! Bạn chưa mua gì cả ❤</h3>
                    </c:if>
                    <c:if test="${not empty order}">
                        <h2>Summary</h2>
                        <div class="m-bt-16px summary-lazy-css">
                            <span>Tổng số lượng hàng: </span>
                            <c:set var="total" value="${0}"/>
                            <c:forEach var="item123" items="${order.orderItemsList}">
                                <c:set var="total" value="${total + item123.quantity}"/>
                            </c:forEach>
                            <span class="ta-right f-b">${total}</span>
                        </div>

                        <div class="m-bt-16px summary-lazy-css">
                            <span>Phí ship: </span>
                            <span class="ta-right f-b">0 đ</span>
                        </div>
                        <div class="m-bt-px summary-lazy-css">
                            <span>Tổng tiền: </span>

                            <span class="ta-right f-b cl-red"><fmt:formatNumber type="number"
                                                                                value="${order.total}"/> đ</span>
                        </div>
                    </c:if>

                </div>
                <div class="footer">
                    <c:if test="${empty User || empty order || order.orderItemsList.size() <= 0}">
                        <button class="checkout-footer" disabled>CHECKOUT</button>
                    </c:if>
                    <c:if test="${not empty User && not empty order && order.orderItemsList.size() > 0}">
                        <form action="<c:url value="/cart"/>">
                            <input type="hidden" name="action" value="checkout"/>
                            <button class="checkout-footer">CHECKOUT</button>
                        </form>
                    </c:if>
                </div>
            </div>
        </div>
    </div>
