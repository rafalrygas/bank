<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title><spring:message code="moneyTransferForm.moneyTransfer"></spring:message></title>
</head>
<body>
    <c:if test="${not empty msg}">
        <div class="alert alert-${css} alert-dismissible" role="alert">
            <strong>${msg}</strong>
        </div>
    </c:if>

    <spring:url value="/secure/confirmtransfer/${transferId}" var="userActionUrl"/>

    <form action="${userActionUrl}" method="post" name="myform">
        <table border="0">
            <tr>
                <td><spring:message code="moneyTransferAcceptForm.insertCode"></spring:message>:</td>
                <td><input type= 'text' name="checkCode" id="checkCode"/></td>
            </tr>
            <tr>
                <td colspan="2" align="center"><input type="submit" value=<spring:message code="moneyTransferAcceptForm.submit"></spring:message> /></td>
            </tr>
        </table>
    </form>
</body>
</html>
