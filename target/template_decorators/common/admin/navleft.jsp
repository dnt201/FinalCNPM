<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="/common/taglib.jsp" %>

<c:if test="${empty User}">
  <c:redirect url ="/home-page"/>
</c:if>
<c:if test="${User.getRoleModel().getRoleName() !='admin'}">
  <c:redirect url ="/home-page"/>
</c:if>
<ul class="navbar-nav bg-gradient-dark sidebar sidebar-dark accordion" id="accordionSidebar">
  <!-- Sidebar - Brand -->
  <a class="sidebar-brand d-flex align-items-center justify-content-center" href="<c:url value='/admin'/>">
    <div class="sidebar-brand-icon rotate-n-15">
      <i class="fas fa-laugh-wink"></i>
    </div>
    <div class="sidebar-brand-text mx-3">Admin<sup>2</sup></div>
  </a>

  <!-- Divider -->
  <hr class="sidebar-divider my-0">

  <!-- Nav Item - Dashboard -->
  <li class="nav-item active">
    <a class="nav-link" href="<c:url value='/admin'/>">
      <i class="fas fa-fw fa-tachometer-alt"></i>
      <span>Dashboard</span></a>
  </li>
  <!-- Divider -->
  <hr class="sidebar-divider">

  <!-- Heading -->
  <div class="sidebar-heading">
    Admin Management
  </div>

  <!-- Nav Item - Pages Collapse Menu -->
  <li class="nav-item">
    <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapseTwo"
       aria-expanded="true" aria-controls="collapseTwo">
      <i class="fas fa-fw fa-cog"></i>
      <span>Elements</span>
    </a>
    <div id="collapseTwo" class="collapse" aria-labelledby="headingTwo" data-parent="#accordionSidebar">
      <div class="bg-white py-2 collapse-inner rounded">
        <h5 class="collapse-header">List Elements:</h5>
        <a class="collapse-item" href="<c:url value='/admin/user'/>">Users</a>
        <a class="collapse-item" href="<c:url value='/admin/product'/>">Products</a>
        <a class="collapse-item" href="<c:url value='/admin/brand'/>">Brand</a>
        <a class="collapse-item" href="<c:url value='/admin/discount'/>">Discount</a>
        <a class="collapse-item" href="<c:url value='/admin/order'/>">Order</a>

      </div>
    </div>
  </li>

  <!-- Nav Item - Utilities Collapse Menu -->
  <li class="nav-item">
    <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapseUtilities"
       aria-expanded="true" aria-controls="collapseUtilities">
      <i class="fas fa-fw fa-wrench"></i>
      <span>Insert</span>
    </a>
    <div id="collapseUtilities" class="collapse" aria-labelledby="headingUtilities"
         data-parent="#accordionSidebar">
      <div class="bg-white py-2 collapse-inner rounded">
        <h6 class="collapse-header">Insert:</h6>
        <a class="collapse-item" href="<c:url value='/admin/product?action=insert'/>">Product</a>
        <a class="collapse-item" href="<c:url value='/admin/brand?action=insert'/>">Brand</a>
        <a class="collapse-item" href="<c:url value='/admin/discount?action=insert'/>">Discount</a>
      </div>
    </div>
  </li>

  <!-- Divider -->
  <hr class="sidebar-divider d-none d-md-block">
</ul>
