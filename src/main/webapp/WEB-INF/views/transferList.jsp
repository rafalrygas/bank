<%@ page session="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html lang="en">

<body>

<div class="container">

    <h1><spring:message code="transferList.Transfers"></spring:message></h1>

    <table class="table table-striped">
        <thead>
        <tr>
            <th><spring:message code="transferList.id"></spring:message></th>
            <th><spring:message code="transferList.title"></spring:message></th>
            <th><spring:message code="transferList.amount"></spring:message></th>
            <th><spring:message code="transferList.accountSender"></spring:message></th>
            <th><spring:message code="transferList.accountRecipient"></spring:message></th>
            <th><spring:message code="transferList.nameOfRecipient"></spring:message></th>
            <th><spring:message code="transferList.addressOfRecipient"></spring:message></th>
            <th><spring:message code="transferList.dateOfSent"></spring:message></th>
            <th><spring:message code="transferList.dateOfReceipt"></spring:message></th>
            <th><spring:message code="transferList.statusOfTransfer"></spring:message></th>
        </tr>
        </thead>

        <c:forEach var="transfer" items="${transfers}">
            <tr>
                <td>${transfer.id}</td>
                <td>${transfer.title}</td>
                <td>${transfer.amount}</td>
                <td>${transfer.accountSender.accountNumber}</td>
                <td>${transfer.accountRecipient.accountNumber}</td>
                <td>${transfer.nameOfRecipient}</td>
                <td>${transfer.addressRecipient}</td>
                <td>${transfer.dateOfSent}</td>
                <td>${transfer.dateOfReceipt}</td>
                <td>${transfer.statusOfTransfer}</td>
                <td>
                    <spring:url value="/secure/confirmtransfer/${transfer.id}" var="updateUrl" />

                    <c:if test="${transfer.statusOfTransfer!='Confirmed' && transfer.statusOfTransfer!='Finished'}">
                        <button class="btn btn-danger"
                                onclick="location.href='${updateUrl}'"><spring:message code="transferList.confirm"></spring:message></button>
                    </c:if>
                </td>
            </tr>
        </c:forEach>
    </table>

</div>

</body>
</html>
