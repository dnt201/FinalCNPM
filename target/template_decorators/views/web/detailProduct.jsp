<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/common/taglib.jsp" %>

<div class="detail-product-page-container">
    <div class="product-detail">
        <div class="product-detail-left loader_center">
            <img src="${model.image}" alt="123"/>
        </div>
        <div class="product-detail-right">
            <h1 class="name">${model.productName}</h1>
            <div class='rating'>
                <span style="color: #f8e825;}"><i class="far fa-star"></i></span>
                <span style="color: #f8e825;}"><i class="far fa-star"></i></span>
                <span style="color: #f8e825;}"><i class="far fa-star"></i></span>
                <span style="color: #f8e825;}"><i class="far fa-star"></i></span>
                <span style="color: #f8e825;}"><i class="far fa-star"></i></span>
                <span><i>0 lượt đánh giá</i></span>
            </div>
            <p class="des"> Description: ${model.description} </p>
            <form action="<c:url value='/cart'/>">
                <div class="status-quantity-price">
                    <div class="status-quantity">
                        <div class="status">
                            <span class="all-ready-span"><i class="fa fa-check"></i>Còn hàng</span>
                            <%--<span class="sold-out-span"><FontAwesomeIcon icon={faTimes} /> Hết hàng</span>--%>
                        </div>
                        <div class="quantity">
                            <span>Số lượng</span>
                            <input class="quantity-input" type="number" id="quantity-add-card" name="quantity"
                                   min="1"
                                   value="1"
                            />
                        </div>
                    </div>
                    <div class="price">
                        <c:if test="${model.discount.discountPercent > 0}">
                            <div class="new-price"><fmt:formatNumber type="number"
                                                                     value="${model.price-model.price*model.discount.discountPercent/100}"/>
                                đ
                            </div>
                            <div class="old-price"><fmt:formatNumber type="number" value="${model.price}"/> đ</div>
                        </c:if>
                        <c:if test="${model.discount.discountPercent <= 0}">
                            <div class="new-price"><fmt:formatNumber type="number" value="${model.price}"/> đ</div>
                        </c:if>
                    </div>
                </div>
                <div class="button">
                    <c:if test="${User.getRoleModel().getRoleName() !='admin'}">
                        <input type="hidden" name="action" value="add"/>
                        <input type="hidden" name="product_id" value="${model.product_id}"/>
                        <button type="submit"> Add to cart <i class="fa fa-cart-arrow-down"></i></button>
                    </c:if>
                    <c:if test="${User.getRoleModel().getRoleName() =='admin'}">
                            <a class="btn-details" href="<c:url value='/admin/product?action=edit&product_id=${model.product_id}'/>"> Details</a>
                    </c:if>
                </div>
            </form>
        </div>
    </div>
    <div class="review-wrap">
        <div class="create-review-container">
            <h1 class="t-a-center mg-32016">Đánh giá & nhận xét sản phẩm</h1>
            <div class="create-review">
                <div class="review-metqua">
                    <select class="review-select">
                        <option value='0'>Select...</option>
                        <option value='1'>1 - Poor</option>
                        <option value='2'>2 - Fair</option>
                        <option value='3'>3 - Good</option>
                        <option value='4'>4 - Very Good</option>
                        <option value='5'>5 - Excellent</option>
                    </select>
                    <button class="btn-post-review" onclick="alertFeatureUpdate()">Post</button>
                </div>
                <textarea class="review-input" id="w3review" name="w3review" rows="4"/></textarea>
            </div>
            <div class="review-container">
                <span class="review-header">Reviews</span>
                <div class='rating'>
                    <span style="color: #f8e825;}"><i class="far fa-star"></i></span>
                    <span style="color: #f8e825;}"><i class="far fa-star"></i></span>
                    <span style="color: #f8e825;}"><i class="far fa-star"></i></span>
                    <span style="color: #f8e825;}"><i class="far fa-star"></i></span>
                    <span style="color: #f8e825;}"><i class="far fa-star"></i></span>
                    <span><i>0 lượt đánh giá</i></span>
                </div>
            </div>
        </div>
    </div>
    <div class="product-detail-information">
        <div class="wrap pt-5">
            <h2>Thông số kỹ thuật</h2>
            <div class="line-item">
                <div class="flex-1">Tên sản phẩm</div>
                <div class="flex-3">${model.productName}</div>
            </div>
            <div class="line-item">
                <div class="flex-1">Thương hiệu</div>
                <div class="flex-3">${model.brandModel.brand_name}</div>
            </div>
            <div class="line-item">
                <div class="flex-1">Màu sắc</div>
                <div class="flex-3">${model.color}</div>
            </div>
            <div class="line-item-infor f-s-16px pt-1 pb-1"> Thông tin chung</div>
            <div class="line-item">
                <div class="flex-1">Thế hệ CPU</div>
                <div class="flex-3">${model.cpu}</div>
            </div>
            <div class="line-item">
                <div class="flex-1">Card đồ họa</div>
                <div class="flex-3">${model.vga}</div>
            </div>
            <div class="line-item">
                <div class="flex-1">RAM</div>
                <div class="flex-3">${model.ram}</div>
            </div>
            <div class="line-item">
                <div class="flex-1">Màn hình</div>
                <div class="flex-3">${model.monitor}</div>
            </div>
            <div class="line-item">
                <div class="flex-1">Lưu trữ</div>
                <div class="flex-3">${model.storage}</div>
            </div>
            <div class="line-item">
                <div class="flex-1">Pin</div>
                <div class="flex-3">${model.pin}</div>
            </div>
            <div class="line-item">
                <div class="flex-1">Cổng kết nối</div>
                <div class="flex-3">${model.connection}</div>
            </div>
        </div>
    </div>
</div>