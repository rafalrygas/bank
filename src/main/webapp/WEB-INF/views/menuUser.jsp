<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<head>
    <link href="<c:url value="/resources/css/menuUser.css" />" rel="stylesheet">
</head>

<body>

    <a class="dropbtn" href="${pageContext.request.contextPath}/secure/home"><spring:message code="menuUser.home"></spring:message></a>


    <a class="dropbtn" href="${pageContext.request.contextPath}/secure/userinfo"><spring:message code="menuUser.userInfo"></spring:message></a>


    <div class="dropdown">
        <button class="dropbtn"><spring:message code="menuUser.transfers"></spring:message></button>
        <div class="dropdown-content">
            <a href="${pageContext.request.contextPath}/secure/maketransfer"><spring:message code="menuUser.makeTransfer"></spring:message></a>
            <a href="${pageContext.request.contextPath}/secure/transferlist"><spring:message code="menuUser.listOftransfers"></spring:message></a>
        </div>
    </div>

    <c:if test="${pageContext.request.userPrincipal.name != null}">

        <a class="dropbtn" href="${pageContext.request.contextPath}/logout"><spring:message code="menuUser.logout"></spring:message></a>

    </c:if>

    <div class="container">

        <c:if test="${not empty msg}">
            <div class="alert alert-${css} alert-dismissible" role="alert">
                <strong>${msg}</strong>
            </div>
        </c:if>

        <h1><spring:message code="menuUser.accounts"></spring:message></h1>

        <table class="table table-striped">
            <thead>
            <tr>
                <th><spring:message code="menuUser.account"></spring:message></th>
                <th><spring:message code="menuUser.state"></spring:message></th>
            </tr>
            </thead>

            <c:forEach var="account" items="${accounts}">
                <tr>
                    <td>
                        <a href="${pageContext.request.contextPath}/secure/account/${account.accountNumber}">${account.accountNumber}</a>
                    </td>
                    <td>
                        ${account.state}
                    </td>
                </tr>
            </c:forEach>
        </table>

    </div>


</div>
</body>