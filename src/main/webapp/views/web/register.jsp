<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page language="java" pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp" %>

<div class="form_register_container">
    <form class="wrap-register" name="register-form" onsubmit="return validatePassWordConfirm()" method="post">
        <span >Register</span>
        <p><i>Many thanks for your registration!</i></p>

        <div class="wrap_name_email flex_row_around w100 m-t-8px">
            <div class="form_control wrap_name flex_column_start w48">
                <label class="m-b-4px">Name</label>
                <input maxlength="50" id="nameInput"
                       name="name"
                       class="m-b-4px w100 p-lr-4px w100" placeholder="Enter your name..."
                       required
                />
            </div>
            <div class="form_control wrap_email flex_column_start w48">
                <label class="m-b-4px">Email</label>
                <input maxlength="50" id="emailInput"
                       name="email"
                       class="m-b-4px w100 p-lr-4px w100" type="email" placeholder="Enter your email address..."
                       required
                />
            </div>
        </div>
        <div class="form_control wrap_address flex_column_start w100">
            <label class="m-b-4px">Address</label>
            <input maxlength="100"  id="addressInput"
                   name="address"
                   class="w100 m-b-4px p-lr-4px" type="text" placeholder="Enter your password..."
            />
        </div>
        <div class="form_control wrap_address flex_column_start w100">
            <label class="m-b-4px">Phone number</label>
            <input maxlength="10" id="phoneNumber"
                   name="phone"
                   pattern="[0-9]{10}"
                   type="tel"
                   class="w100 m-b-4px p-lr-4px"placeholder="Enter your phone number..."
            />
        </div>
        <div class="form_control wrap_password flex_column_start w100">
            <label class="m-b-4px">Username</label>
            <input maxlength="50" id="usernameInput"
                   name="username"
                   class="w100 m-b-4px p-lr-4px" type="text" placeholder="Enter your username..."
                   required
            />
        </div>
        <div class="form_control wrap_password flex_column_start w100">
            <label class="m-b-4px">Password</label>
            <input id="passwordInput"
                   name="password"
                   class="w100 m-b-4px p-lr-4px" type="password" placeholder="Enter your password..."
                   required
            />
        </div>
        <div class="form_control wrap_conf_password flex_column_start w100">
            <label class="m-b-4px">Confirm Password</label>
            <input id="confPasswordInput" class="w100 m-b-4px p-lr-4px"
                   name="confPassword"
                   type="password" placeholder="Confirm password..."
                   required
            />
        </div>
        <c:if test="${not empty messageResponse}">
            <i class="red_16px_bold">${messageResponse}</i>
        </c:if>
        <i id="mess_error_register" class="red_16px_bold"></i>
        <button class="register-btn" type="submit">Register</button>
    </form>
</div>