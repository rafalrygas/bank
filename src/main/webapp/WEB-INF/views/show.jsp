<%@ page session="false" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>

<div class="container">

    <c:if test="${not empty msg}">
        <div class="alert alert-${css} alert-dismissible" role="alert">
            <strong>${msg}</strong>
        </div>
    </c:if>

    <h1><spring:message code="show.userDetails"></spring:message></h1>
    <br/>

    <div class="row">
        <label class="col-sm-2">
            <spring:message code="show.username"></spring:message>
        </label>
        <div class="col-sm-10">${user.username}</div>
    </div>

    <div class="row">
        <label class="col-sm-2"><spring:message code="show.name"></spring:message></label>
        <div class="col-sm-10">${user.name}</div>
    </div>

    <div class="row">
        <label class="col-sm-2"><spring:message code="show.surname"></spring:message></label>
        <div class="col-sm-10">${user.surname}</div>
    </div>

    <div class="row">
        <label class="col-sm-2"><spring:message code="show.pesel"></spring:message></label>
        <div class="col-sm-10">${user.pesel}</div>
    </div>

    <div class="row">
        <label class="col-sm-2"><spring:message code="show.phoneNumber"></spring:message></label>
        <div class="col-sm-10">${user.phoneNumber}</div>
    </div>

    <div class="row">
        <label class="col-sm-2"><spring:message code="show.additionalPhoneNumber"></spring:message></label>
        <div class="col-sm-10">${user.additionalPhoneNumber}</div>
    </div>

    <div class="row">
        <label class="col-sm-2"><spring:message code="show.email"></spring:message></label>
        <div class="col-sm-10">${user.email}</div>
    </div>

    <div class="row">
        <label class="col-sm-2"><spring:message code="show.street"></spring:message></label>
        <div class="col-sm-10">${user.street}</div>
    </div>

    <div class="row">
        <label class="col-sm-2"><spring:message code="show.houseNumber"></spring:message></label>
        <div class="col-sm-10">${user.houseNumber}</div>
    </div>

    <div class="row">
        <label class="col-sm-2"><spring:message code="show.flatNumber"></spring:message></label>
        <div class="col-sm-10">${user.flatNumber}</div>
    </div>

    <div class="row">
        <label class="col-sm-2"><spring:message code="show.zipCode"></spring:message></label>
        <div class="col-sm-10">${user.zipCode}</div>
    </div>

    <div class="row">
        <label class="col-sm-2"><spring:message code="show.city"></spring:message></label>
        <div class="col-sm-10">${user.city}</div>
    </div>

    <div class="row">
        <label class="col-sm-2"><spring:message code="show.country"></spring:message></label>
        <div class="col-sm-10">${user.country}</div>
    </div>

    <div class="row">
        <label class="col-sm-2"><spring:message code="show.enabled"></spring:message></label>
        <div class="col-sm-10">${user.enabled}</div>
    </div>

    <c:forEach var="userRole" items="${user.userRole}">
        <tr>
            <td>
                    ${userRole.role}
            </td>
        </tr>
    </c:forEach>

    <a href="${pageContext.request.contextPath}/secure/admin/users/${user.username}/roles"><spring:message code="show.editRoles"></spring:message></a>

</div>

</body>
</html>