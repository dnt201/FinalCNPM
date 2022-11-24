<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/common/taglib.jsp" %>

<div class="breadcrumb" id="breadcrumbs">
    <script type="text/javascript">
        try {
            ace.settings.check('breadcrumbs', 'fixed')
        } catch (e) {
        }
    </script>
    <ul class="breadcrumb">
        <li>
            <a href="<c:url value='/admin'/>">
                <i class="ace-icon fa fa-home home-icon"></i>
            </a>
        </li>
        <li style="margin-left: 12px">
            <i class="fas fa-angle-right"></i>
            <a href="<c:url value='/admin/discount'/>">
                List Discount
            </a>
        </li>
        <li style="margin-left: 12px">
            <i class="fas fa-angle-right"></i>
            <c:if test="${empty discountModel}">
                Insert Discount
            </c:if>
            <c:if test="${not empty discountModel}">
                Edit Discount
            </c:if>
        </li>
    </ul>
</div>
<div class="wrap">
    <div class="wrap-form-center">
        <form id="form" action="<c:url value='/admin/discount'/>" class="formCenter shadow p-3 mb-5 bg-body rounded">
            <div class="form-header">
                <h1>Discount Insert or Update</h1>
                <ul class="list-inline text-sm">
                    <li class="list-inline-item"><button class=" btn btn-outline-warning"><i class="fas fa-copy me-2">
                    </i>Copy</button></li>
                    <li class="list-inline-item"><button class=" btn btn-outline-info"><i class="fas fa-download me-2">
                    </i>Import</button></li>
                </ul>
                <h6><i class="text-danger">${messageResponse}</i></h6>
            </div>
            <section>
                <div>
                    <div class="">
                        <div class="">
                            <div class="card-header">
                                <div class="card-heading">
                                    <h5>Form discount</h5>
                                </div>
                            </div>
                            <div class="card-body">
                                <div class="row gy-3">
                                    <div class="col-12">
                                        <h6 class="form-label fw-bold">Discount name <i
                                                class="fa fa-file-signature"></i></h6>
                                        <input maxlength="30" required name="discountName" class="form-control"
                                        <c:if test="${empty discountModel && param.discountName!=null && success == false}">
                                         value="<%= request.getParameter("discountName") %>";
                                        </c:if>
                                        <c:if test="${not empty discountModel}">
                                               value="${discountModel.discountName}"
                                        </c:if>
                                               placeholder="Enter your discount name..."
                                        >
                                    </div>
                                </div>
                                <div class="row gy-3">
                                    <div class="col-12">
                                        <h6 class="form-label fw-bold">Description  <i
                                                class="fa fa-cloud"></i></h6>
                                        <input required name="description" class="form-control"
                                        <c:if test="${empty discountModel && param.description!=null  && success == false}">
                                               value="<%= request.getParameter("description") %>";
                                        </c:if>
                                        <c:if test="${not empty discountModel}">
                                               value="${discountModel.description}"
                                        </c:if>
                                               placeholder="Enter your description..."
                                        >
                                    </div>
                                </div>
                                <div class="row gy-3">
                                    <div class="col-12">
                                        <h6 class="form-label fw-bold">Discount percent <i
                                                class="fa fa-tags"></i></h6>
                                        <input  required name="discountPercent" class="form-control"
                                        <c:if test="${empty discountModel && param.discountPercent!=null  && success == false}">
                                                value="<%= request.getParameter("discountPercent") %>";
                                        </c:if>
                                        <c:if test="${not empty discountModel}">
                                                value="${discountModel.discountPercent}"
                                        </c:if>
                                               placeholder="Enter your discountPercent..."
                                        >
                                    </div>
                                </div>
                                <div style="margin-top: 12px" class="form-text" id="notification"></div>
                                <c:if test="${empty discountModel}">
                                    <input type="hidden" name="action" value="add"/>
                                    <button  style="margin-top: 12px"
                                            class="btn btn-outline-primary mb-4" type="submit">Add product</button>
                                </c:if>
                                <c:if test="${not empty discountModel}">
                                    <input type="hidden" value=${discountModel.discount_id} id="discount_id" name="discount_id"/>
                                    <input type="hidden" name="action" value="update"/>
                                    <button  style="margin-top: 12px"
                                             class="btn btn-outline-danger mb-4" type="submit">Update</button>
                                </c:if>

                            </div>
                        </div>
                    </div>

                </div>
            </section>
        </form>
    </div>
</div>