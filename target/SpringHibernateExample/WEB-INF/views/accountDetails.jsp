<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html lang="en">

<body>

<div class="container">

    <table class="table table-striped">
        <thead>
        <tr>
            <th><spring:message code="accountDetails.number"></spring:message></th>
            <th><spring:message code="accountDetails.state"></spring:message></th>
            <th><spring:message code="accountDetails.owners"></spring:message></th>
        </tr>
        </thead>


            <tr>
                <td>${account.accountNumber}</td>
                <td>${account.state}</td>
                <td>
                    <c:forEach var="user" items="${account.users}">
                        ${user.name} ${user.surname} |
                    </c:forEach>
                </td>
            </tr>

    </table>

</div>

</body>
</html>
