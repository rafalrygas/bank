<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<html>
<head><title><spring:message code="loginPage.login"></spring:message></title></head>
<body>


<h1><spring:message code="loginPage.login"></spring:message></h1>

<!-- /login?error=true -->
<c:if test="${param.error == 'true'}">
    <div style="color:red;margin:10px 0px;">

        <spring:message code="loginPage.loginFailed"></spring:message><br />
        <spring:message code="loginPage.loginFailedReason"></spring:message> :  ${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message}

    </div>
</c:if>

<h3><spring:message code="loginPage.usernameAndPassword"></spring:message></h3>

<form name='f' action="${pageContext.request.contextPath}/j_spring_security_check" method='POST'>
    <table>
        <tr>
            <td><spring:message code="loginPage.username"></spring:message></td>
            <td><input type='text' name='username' value=''></td>
        </tr>
        <tr>
            <td><spring:message code="loginPage.password"></spring:message></td>
            <td><input type='password' name='password' /></td>
        </tr>
        <tr>
            <td><input name="submit" type="submit" value="<spring:message code="loginPage.submit"></spring:message>" /></td>
        </tr>
    </table>
</form>
</body>
</html>
