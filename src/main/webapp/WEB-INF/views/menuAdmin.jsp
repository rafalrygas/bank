<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<div style="border: 1px solid #ccc;padding:5px;margin-bottom:20px;">

    <a href="${pageContext.request.contextPath}/secure/admin/home"><spring:message code="menuAdmin.home"></spring:message></a>

    | &nbsp;

    <a href="${pageContext.request.contextPath}/secure/admin/userInfo"><spring:message code="menuAdmin.userInfo"></spring:message></a>

    | &nbsp;

    <a href="${pageContext.request.contextPath}/secure/admin/users"><spring:message code="menuAdmin.users"></spring:message></a>

    <c:if test="${pageContext.request.userPrincipal.name != null}">

        | &nbsp;
        <a href="${pageContext.request.contextPath}/logout"><spring:message code="menuAdmin.logout"></spring:message></a>

    </c:if>

    <div class="pull-right" style="padding-right: 50px">
        <a href="?language=pl">Polski</a>|<a href="?language=en">English</a>
    </div>
</div>