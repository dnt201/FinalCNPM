<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/common/taglib.jsp" %>
<div class="detail-order-container">
    <div class="wrap">
        <div class="breadcrumb" id="breadcrumbs">
            <script type="text/javascript">
                try {
                    ace.settings.check('breadcrumbs', 'fixed')
                } catch (e) {
                }
            </script>
            <ul class="breadcrumb">
                <li>
                    <a href="<c:url value='/home-page'/>">
                        <i class="ace-icon fa fa-home home-icon"></i>
                    </a>
                </li>
                <li style="margin-left: 12px">
                    <i class="fas fa-angle-right"></i>
                    <c:if test="${User.getRoleModel().getRoleName() !='admin'}">
                    <a href="<c:url value='/me'/>">
                        <i class="ace-icon fa fa-user"></i>
                    </a>
                    </c:if>
                    <c:if test="${User.getRoleModel().getRoleName() =='admin'}">
                        <a href="<c:url value='/admin'/>">
                            <i class="ace-icon fa fa-columns"></i>
                        </a>
                    </c:if>
                </li>
                <li style="margin-left: 12px">
                    <i class="fas fa-angle-right"></i>
                    Detail Order
                </li>

            </ul>
        </div>
        <div class="flex-row jt-ct-center align-item-center">
            <h1 class="m-r-8px t-a-center">Order #${model.order_id}</h1>
        </div>
        <div class="detail-order-wrap">
            <div class="quatroiluoiluon jt-ct-sb">
                <div>
                    <div>
                        <span class="w-170px"><b>Customer: </b></span>
                        <span>${model.usersModel.username}</span>
                    </div>
                    <div>
                        <span class="w-170px"><b>Email: </b></span>
                        <span>${model.usersModel.email}</span>
                    </div>
                    <div>
                        <span class="w-170px"><b>Numbs of product: </b></span>
                        <c:set var="total" value="${0}"/>
                        <c:forEach var="item" items="${model.orderItemsList}">
                            <c:set var="total" value="${total + item.quantity}"/>
                        </c:forEach>
                        <span>${total}</span>
                    </div>
                    <div>
                        <span class="w-170px"><b>Order Date: </b></span>
                        <span>${model.createAt}</span>
                    </div>
                </div>
                <div class="quatroiluoiluon1">
                    <div>
                        <span class="w-170px"><b>Address: </b></span>
                        <span>${model.usersModel.address}</span>
                    </div>
                    <div>
                        <span><b>Phone number: </b></span>
                        <span>${model.usersModel.phone}</span>
                    </div>
                </div>
            </div>
            <div>
                <table class="w-100p m-b-8px table" style="overflow-x:auto;">
                    <colgroup>
                        <col span="1" style="width:15%"/>
                        <col span="1" style="width:30%"/>
                        <col span="1" style="width:10%"/>
                        <col span="1" style="width:10%"/>
                        <col span="1" style="width:10%"/>
                        <col span="1" style="width:10%"/>
                        <col span="1" style="width:15%"/>
                    </colgroup>
                    <thead>
                    <tr>
                        <th class="t-a-center">Product image</th>
                        <th class="t-a-center">Product name</th>
                        <th class="t-a-center">Unit price</th>
                        <th class="t-a-center">Discount</th>
                        <th class="t-a-center">Sale price</th>
                        <th class="t-a-center">Quantity</th>
                        <th class="t-a-center">Total price</th>
                    </tr>
                    </thead>

                    <%--Start-item--%>
                    <tbody>

                    <c:set var="Sum" value="${0}"/>
                    <c:forEach var="item" items="${model.orderItemsList}">
                        <tr class="t-a-center">
                            <td>
                                <img class="t-a-left p-l-4px"
                                     src=<c:url value='${item.productModel.image}'/>alt="image" style="width: 150px; height: auto"/>
                            </td>
                            <td>
                                <span>${item.productModel.productName}</span>
                            </td>
                            <td>
                                <span>${item.productModel.price}</span>
                            </td>
                            <td>
                                <span>${item.productModel.discount.discountPercent}</span>
                            </td>
                            <td>
                                <span>${item.productModel.price - item.productModel.price*item.productModel.discount.discountPercent/100}</span>
                            </td>
                            <td>
                                <span>${item.quantity}</span>
                            </td>
                            <td>
                                <span><fmt:formatNumber type = "number" value = "${(item.productModel.price - item.productModel.price*item.productModel.discount.discountPercent/100)*item.quantity}" /> đ</span>
                                <c:set var="Sum"
                                       value="${Sum + (item.productModel.price - item.productModel.price*item.productModel.discount.discountPercent/100)*item.quantity}"/>
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                    <%--End item--%>
                </table>
            </div>

            <div class="flex-column  align-item-flex-end">
                <span class="cl-red"><b>Item price: </b><fmt:formatNumber type = "number" value = "${Sum}" /> đ</span><br/>
                <span><b>Shipping price: </b>   0 đ</span><br/>
                <span class="cl-red f-s-24px"><b> <i class="fa fa-shield-alt cl-red"></i> Total: </b><fmt:formatNumber type = "number" value = "${Sum}" /> đ</span></span>
            </div>
        </div>
    </div>

</div>