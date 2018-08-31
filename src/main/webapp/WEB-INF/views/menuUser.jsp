<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<div style="border: 1px solid #ccc;padding:5px;margin-bottom:20px;">

    <a href="${pageContext.request.contextPath}/secure/home"><spring:message code="menuUser.home"></spring:message></a>

    | &nbsp;

    <a href="${pageContext.request.contextPath}/secure/userinfo"><spring:message code="menuUser.userInfo"></spring:message></a>

    <c:if test="${pageContext.request.userPrincipal.name != null}">

        | &nbsp;
        <a href="${pageContext.request.contextPath}/logout"><spring:message code="menuUser.logout"></spring:message></a>

    </c:if>

</div>