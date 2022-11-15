<%@include file="/common/taglib.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<c:if test="${model.getRoleModel().getRoleName() !='admin'}">
    <div class="user-detail-container">
        <div class="column">
            <div class="wrap-center">
                <div class="w-360px border-bottom">
                    <div class="d-flex flex-column align-items-center text-center p-3 py-5">
                        <img class="rounded-circle mt-5" width="150px"
                             src="https://st3.depositphotos.com/15648834/17930/v/600/depositphotos_179308454-stock-illustration-unknown-person-silhouette-glasses-profile.jpg"/>
                        <h3 class="font-weight-bold">${model.name}</h3>
                        <p class="text-black-50 f-s-20px t-a-left w-100p"><i class="fa fa-user"></i>
                                ${model.username}</p>
                        <p class="text-black-50 f-s-20px t-a-left w-100p"><i class="fa fa-envelope"></i>
                                ${model.email}</p>
                        <p class="text-black-50 f-s-20px t-a-left w-100p"><i class="fa fa-phone"></i>
                                ${model.phone}</p>
                        <p class="text-black-50 f-s-20px t-a-left w-100p"><i class="fa fa-map-marker-alt"></i>
                                ${model.address}</p>
                        <div class="mt-5 text-center">
                            <a class="btn btn-primary profile-button"
                               href="<c:url value='/me?action=update-profile'/>"> <i class="fas fa-id-card"></i> Update
                                profile </a>
                            <a class="btn btn-success profile-button"
                               href="<c:url value='/me?action=change-password'/>"> <i class="fas fa-lock"></i> Update
                                password </a>
                        </div>
                    </div>
                </div>
            </div>

            <div class="user-detail__list-order">
                <div class="col-md-12">
                    <h2 class="t-a-center m-b-12px bg-white mb-2 pd-b-12px pd-t-12px">List order<i
                            class="f-s-16px">(${orders.size()})</i></h2>
                </div>
                <!-- Render list -->
                <c:forEach var="item" items="${orders}">
                    <div class="list-order column rounded mt-2 mb-2">
                        <div class="list-order-header border-bottom">
                            <span><i class="fas fa-receipt f-s-16px"></i> ID Order: ${item.order_id}</span>
                            <span class="cl-success"><i class="fa fa-truck"></i> Giao hàng thành công</span>
                        </div>
                        <!-- Line item -->
                        <c:forEach var="lineItem" items="${item.getOrderItemsList()}">
                            <div class="flex line-order pd-t-12px pd-b-12px border-bottom">
                                <a href="<c:url value='/product/detail?product_id=${lineItem.productModel.product_id}'/>">
                                    <img class="line-order__img-span"
                                         src="${lineItem.productModel.image}"/>
                                </a>
                                <div class="line-order__infor-wrap">
                                    <div class="line-order__infor-left">
                                        <h5>${lineItem.productModel.productName}</h5>
                                        <h6><i>Phân loại hàng: Laptop</i></h6>
                                        <span>x${lineItem.quantity}</span>
                                    </div>
                                    <div>
                                        <div>
                                            <c:if test="${lineItem.productModel.discount.discountPercent > 0}">
                                                <span class="price-old"><fmt:formatNumber type="number"
                                                                                          value="${lineItem.productModel.price}"/> đ</span>
                                                <span class="price-new"><fmt:formatNumber type="number"
                                                                                          value="${lineItem.productModel.price-lineItem.productModel.price*lineItem.productModel.discount.discountPercent/100}"/> đ</span>
                                            </c:if>

                                            <c:if test="${lineItem.productModel.discount.discountPercent <= 0}">
                                                <span class="price-new"><fmt:formatNumber type="number"
                                                                                          value="${lineItem.productModel.price}"/> đ </span>
                                            </c:if>
                                        </div>
                                        <span>Tổng:
                                        <span class="cl-red">
                                            <fmt:formatNumber type="number"
                                                              value="${(lineItem.productModel.price-(lineItem.productModel.price*lineItem.productModel.discount.discountPercent/100))*lineItem.quantity}"/> đ
                                        </span>
                                    </span>
                                    </div>
                                </div>
                            </div>
                        </c:forEach>
                        <!-- Line item -->
                        <div class="list-order-footer pd-b-12px pd-t-12px b">
                            <i class="col-md-4">Ngày tạo: <fmt:formatDate value="${item.createAt}"
                                                                          pattern="MM/dd/yyyy"/></i>
                            <div class="mr-3">
                                <form action="<c:url value='/order/detail?'/>">
                                    <input type="hidden" name="order_id" value="${item.order_id}"/>
                                    <button class="btn btn-outline-info mr-3"><i class="fa fa-info"></i> Details
                                    </button>
                                    <i class="fa fa-shield-alt cl-red"></i> Tổng tiền:
                                    <span class="summary"><fmt:formatNumber type="number"
                                                                            value="${item.total}"/> đ</span>
                                </form>
                            </div>
                        </div>
                    </div>
                </c:forEach>
                <!-- End render list -->
            </div>
        </div>
    </div>
</c:if>

<c:if test="${model.getRoleModel().getRoleName() =='admin'}">
    <div class="container rounded bg-white mt-2 mb-1">
        <div class="col">
            <h1 class="t">Hello admin!</h1>
            <div class="d-flex flex-column align-items-center text-center p-3 py-5">
                <img class="rounded-circle"
                     width="150px"
                     src="https://st3.depositphotos.com/15648834/17930/v/600/depositphotos_179308454-stock-illustration-unknown-person-silhouette-glasses-profile.jpg"
                />
                <h3 class="font-weight-bold">${model.name}</h3>
                <span class="text-black-50 f-s-20px"><i class="fa fa-user"></i> ${model.username}</span>
                <span class="text-black-50 f-s-20px"><i class="fa fa-envelope"></i> ${model.email}</span>
                <span class="text-black-50 f-s-20px"><i class="fa fa-phone"></i> ${model.phone}</span>
                <span class="text-black-50 f-s-20px"><i class="fa fa-address-book"></i> ${model.address}</span>
                <div class="mt-5 text-center">
                    <a class="btn btn-primary profile-button"
                       href="<c:url value='/me?action=update-profile'/>"> <i class="fas fa-id-card"></i> Update
                        profile </a>
                    <a class="btn btn-success profile-button"
                       href="<c:url value='/me?action=change-password'/>"> <i class="fas fa-lock"></i> Update
                        password </a>
                </div>
            </div>
        </div>
    </div>
</c:if>
