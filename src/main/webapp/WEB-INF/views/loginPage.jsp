<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<html>
<head>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <link href="<c:url value="/resources/css/login.css" />" rel="stylesheet">
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/jquery-validation@1.17.0/dist/jquery.validate.js"></script>
    <script type="text/javascript">
        $(document).ready(function () {
            $('#form1').validate({
                rules: {
                    username: {
                        required: true
                    }
                }
            });
        });
    </script>
</head>

<body>
<div class="login-page">

    <div class="form">
        <img src="<c:url value="/resources/images/Amber.jpg"/>" class="img-thumbnail" style="width:50%">
        <form class="login-form" name='form1' action="${pageContext.request.contextPath}/j_spring_security_check"
              method='POST' id="form1">
            <div class="form-group">
                <label for="username"><spring:message code="loginPage.username"></spring:message></label>
                <input type='text' name='username' id="username" value=''/>
            </div>
            <div class="form-group">
                <label for="password"><spring:message code="loginPage.password"></spring:message></label>
                <input type='password' name='password' id="password"/>
            </div>
            <button type="submit">
                <spring:message code="loginPage.submit"></spring:message>
            </button>
        </form>
        <c:if test="${param.error == 'true'}">
            <div class="alert alert-danger">
                    ${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message}
            </div>
        </c:if>
    </div>
</div>
</body>
</html>
