<%@include file="/common/taglib.jsp" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Brand list</title>
</head>
<body>
<div class="main-content">
    <div class="main-content-inner">
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
                    List Brand
                </li>
            </ul>
        </div>
        <h2 class="t-a-center"> List Brand </h2>
        <h6 class="t-a-center red_16px_bold">${messageResponse}</h6>
        <span class="me-2" id="categoryBulkAction">
            <label>Sort by:</label>
            <select id="sort" onchange="Sort(this)" class="form-select form-select-sm d-inline w-auto" name="categoryBulkAction">
                <option value="" disabled selected>Choose your option</option>
                <option value="1">A-Z</option>
                <option value="-1"> Z-A </option>
                <option></option>
            </select>
        </span>
        <form id="formsubmit" action="<c:url value='/admin/brand'/>" method="get">
            <div class="card card-table">
                <div class="preload-wrapper">
                    <table class="table table-hover table-borderless align-middle mb-0" id="userDatatable">
                        <thead>
                        <tr>
                            <th style="padding-left: 10px"></th>

                            <th>Brand Name</th>
                            <th>Action</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach var="item" items="${model.listResult}">
                            <tr>
                                <td style="padding-left: 10px"></td>
                                <td>${item.brand_name}</td>
                                <td>
                                    <a class="me-3 text-lg text-success"
                                       href="<c:url value='/admin/brand?action=edit&brand_id=${item.brand_id}'/>"
                                    >
                                        <i class="far fa-edit"></i>
                                    </a>
                                    <a class="text-lg text-danger"
                                       href="<c:url value='/admin/brand?action=delete&brand_id=${item.brand_id}'/>"
                                    >
                                        <i class="far fa-trash-alt"></i>
                                    </a>
                                </td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                    <ul class="pagination" id="pagination" style="margin-left: 20px;border-radius: 30px;"></ul>


                </div>
            </div>
        </form>

    </div>
</div>
<script>
    function Sort(param) {
        let message = document.getElementById('sort');
        let value = param.value;
        if (value === "1" || value === "-1") {
            let table, rows, switching, i, x, y, shouldSwitch;
            table = document.getElementById("userDatatable");
            switching = true;
            while (switching) {
                switching = false;
                rows = table.rows;
                for (i = 1; i < (rows.length - 1); i++) {
                    shouldSwitch = false;
                    x = rows[i].getElementsByTagName("TD")[1];
                    y = rows[i + 1].getElementsByTagName("TD")[1];
                    if ((value === "1" && x.innerHTML.toLowerCase() > y.innerHTML.toLowerCase()) ||
                        ((value === "-1" && x.innerHTML.toLowerCase() < y.innerHTML.toLowerCase()))) {
                        shouldSwitch = true;
                        break;
                    }
                }
                if (shouldSwitch) {
                    rows[i].parentNode.insertBefore(rows[i + 1], rows[i]);
                    switching = true;
                }
            }
        }
    }
</script>
</body>
</html>
