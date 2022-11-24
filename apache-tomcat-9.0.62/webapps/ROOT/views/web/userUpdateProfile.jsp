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
                    Update Profile
                </li>
            </ul>
        </div>
        <div class="col-md-3 border-right">
            <div class="d-flex flex-column align-items-center text-center p-3 py-5">
                <img class="rounded-circle"
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
                <form action="<c:url value='/me'/>">
                    <div class="row mt-3">
                        <div class="col-md-12">
                            <label class="labels">Full Name: </label>
                            <input type="text" class="form-control" placeholder="Enter your name..."
                                   value="${model.name}"
                                   name="name">
                        </div>
                        <div class="col-md-12">
                            <label class="labels">Email: </label>
                            <input type="email" class="form-control" placeholder="Enter your email..."
                                   value="${model.email}"
                                   name="email">
                        </div>
                        <div class="col-md-12">
                            <label class="labels">Address: </label>
                            <input type="text" class="form-control" placeholder="Enter your address..."
                                   value="${model.address}"
                                   name="address">
                        </div>
                        <div class="col-md-12">
                            <label class="labels">Phone number: </label>
                            <input class="form-control" placeholder="Enter your phone number..."
                                   name="phone"
                                   pattern="[0-9]{10}"
                                   type="tel"
                                   value="${model.phone}">
                        </div>
                    </div>
                    <div class="mt-5 text-center d-flex flex-column justify-content-center">
                        <c:if test="${not empty messageResponse}">
                            <i class="red_16px_bold"><b>${messageResponse}</b></i>
                        </c:if>
                        <input type="hidden" name="action" value="update">
                        <input type="hidden" name="user_id" value="${model.user_id}">
                        <button class="btn btn-primary profile-button" type="submit">Save Profile</button>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
