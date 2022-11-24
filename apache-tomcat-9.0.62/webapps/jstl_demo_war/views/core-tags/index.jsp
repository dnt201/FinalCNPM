<%@ include file="../../common/taglib.jsp"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="coreTags">
    <h1 class="title">List core tags</h1>

    <c:choose>
        <%-- In --%>
        <c:when test="${requestScope.randNum==1}">
            <table>
                <tr>
                    <th style="font-weight: bold">Thẻ</th>
                    <th style="font-weight: bold">Mô tả</th>
                </tr>
                <c:forEach items="${requestScope.coreTags}" var="item">
                    <tr>
                        <td><c:out value = "${item.name}" /></td>
                        <td>${item.description}</td>
                    </tr>
                </c:forEach>
            </table>
        </c:when>

        <%-- Không in --%>
        <c:when test="${requestScope.randNum==2}">
          <h1 style="width: 100%; text-align: center">No contents, f5 to load contents.</h1>
        </c:when>

        <%-- Các trường hợp khác --%>
        <c:otherwise>
            <b>Other color</b>
        </c:otherwise>
    </c:choose>

    <p>Ví dụ: <c:out value="${'<c:set>'}"/> <a href="${pageContext.request.contextPath}/core-tags/cset">Click to view</a></p>
</div>