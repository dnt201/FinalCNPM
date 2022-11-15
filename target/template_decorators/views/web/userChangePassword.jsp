<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 12/11/2021
  Time: 4:33 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/common/taglib.jsp" %>

<div class="container rounded bg-white mt-2 mb-1">
    <div class="row">
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
                    <a href="<c:url value='/me'/>">
                        <i class="ace-icon fa fa-id-card "></i>
                    </a>
                </li>
                <li style="margin-left: 12px">
                    <i class="fas fa-angle-right"></i>
                    Change password
                </li>
            </ul>
        </div>
        <div class="col-md-3 border-right">
            <div class="d-flex flex-column align-items-center text-center p-3 py-5">
                <img class="rounded-circle mt-5"
                     width="150px"
                     src="https://st3.depositphotos.com/15648834/17930/v/600/depositphotos_179308454-stock-illustration-unknown-person-silhouette-glasses-profile.jpg"
                >
                <h3 class="font-weight-bold">${model.name}</h3>
                <span class="text-black-50 f-s-20px t-a-left w-100p"><i
                        class="fa fa-user"></i> ${model.username}</span>
                <span class="text-black-50 f-s-20px t-a-left w-100p"><i
                        class="fa fa-envelope"></i> ${model.email}</span>
                <span class="text-black-50 f-s-20px t-a-left w-100p"><i
                        class="fa fa-phone"></i> ${model.phone}</span>
                <span class="text-black-50 f-s-20px t-a-left w-100p"><i
                        class="fa fa-address-book"></i> ${model.address}</span>
            </div>
        </div>
        <div class="col-md-9 border-right">
            <div class="p-3 py-5">
                <div class="d-flex justify-content-between align-items-center mb-3">
                    <h4 class="text-right">Profile Settings</h4>
                </div>
                <form onsubmit="return validateChange()"
                      name="change-password-form"
                      action="<c:url value='/me'/>"
                      method="post"
                >
                    <div class="row mt-3">
                        <div class="col-md-12">
                            <label class="labels">Current password: </label>
                            <input type="text" class="form-control" placeholder="Enter your current password..."
                                   name="curPassword">
                        </div>
                        <div class="col-md-12">
                            <label class="labels">New password: </label>
                            <input type="text" class="form-control" placeholder="Enter your new password..."
                                   name="password">
                        </div>

                        <div class="col-md-12">
                            <label class="labels">Confirm password: </label>
                            <input type="text" class="form-control" placeholder="Enter your confirm password..."
                                   name="confPassword">
                        </div>
                    </div>
                    <div class="mt-5 text-center d-flex flex-column justify-content-center">
                        <i class="red_16px_bold"><b id="mess_error_change_password">
                            <c:if test="${not empty messageResponse}">
                                <i class="red_16px_bold"><b class="red_16px_bold">${messageResponse}</b></i>
                            </c:if>
                        </b></i>
                        <input type="hidden" name="action" value="change">
                        <input type="hidden" name="user_id" value="${model.user_id}">
                        <button class="btn btn-primary profile-button" type="submit">Change Password</button>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>

