<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title><spring:message code="moneyTransferForm.moneyTransfer"></spring:message></title>
</head>

<body>
<div align="center">

    <spring:url value="/secure/maketransfer" var="userActionUrl"/>

    <form:form action="${userActionUrl}" method="post" commandName="moneyTransferForm" id="moneyTransferForm">
        <table border="0">
            <tr>
                <td><spring:message code="moneyTransferForm.title"></spring:message>:</td>
                <td><form:input path="title"/></td>
            </tr>
            <tr>
                <td><spring:message code="moneyTransferForm.amount"></spring:message>:</td>
                <td><form:input path="amount"/></td>
            </tr>
            <tr>
                <td><spring:message code="moneyTransferForm.accountSender"></spring:message>:</td>
                <td><form:select path="accountSender" items="${accounts}" multiple="false"/></td>
            </tr>
            <tr>
                <td><spring:message code="moneyTransferForm.accountRecipient"></spring:message>:</td>
                <td><form:input path="accountRecipient"/></td>
            </tr>
            <tr>
                <td><spring:message code="moneyTransferForm.nameOfRecipient"></spring:message>:</td>
                <td><form:input path="nameOfRecipient"/></td>
            </tr>
            <tr>
                <td><spring:message code="moneyTransferForm.addressRecipient"></spring:message>:</td>
                <td><form:input path="addressRecipient"/></td>
            </tr>
            <tr>
                <td colspan="2" align="center"><input type="submit" value=<spring:message code="moneyTransferForm.makeTransfer"></spring:message> /></td>
            </tr>
        </table>
    </form:form>
</div>
</body>
</html>
