<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<html>
<head>
    <title><spring:message code="logoutSuccessfulPage.Logout"></spring:message></title>
</head>
<body>

<h1><spring:message code="logoutSuccessfulPage.logoutSuccessful"></spring:message></h1>
<a href="${pageContext.request.contextPath}/login"><spring:message code="logoutSuccessfulPage.loginAgain"></spring:message></a>
</body>
</html>
