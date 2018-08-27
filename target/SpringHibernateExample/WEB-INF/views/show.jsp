<%@ page session="false" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html lang="en">

<div class="container">

    <c:if test="${not empty msg}">
        <div class="alert alert-${css} alert-dismissible" role="alert">
            <strong>${msg}</strong>
        </div>
    </c:if>

    <h1>User Detail</h1>
    <br/>

    <div class="row">
        <label class="col-sm-2">username</label>
        <div class="col-sm-10">${user.username}</div>
    </div>

    <div class="row">
        <label class="col-sm-2">name</label>
        <div class="col-sm-10">${user.name}</div>
    </div>

    <div class="row">
        <label class="col-sm-2">surname</label>
        <div class="col-sm-10">${user.surname}</div>
    </div>

    <div class="row">
        <label class="col-sm-2">pesel</label>
        <div class="col-sm-10">${user.pesel}</div>
    </div>

    <div class="row">
        <label class="col-sm-2">phoneNumber</label>
        <div class="col-sm-10">${user.phoneNumber}</div>
    </div>

    <div class="row">
        <label class="col-sm-2">additionalPhoneNumber</label>
        <div class="col-sm-10">${user.additionalPhoneNumber}</div>
    </div>

    <div class="row">
        <label class="col-sm-2">email</label>
        <div class="col-sm-10">${user.email}</div>
    </div>

    <div class="row">
        <label class="col-sm-2">street</label>
        <div class="col-sm-10">${user.street}</div>
    </div>

    <div class="row">
        <label class="col-sm-2">houseNumber</label>
        <div class="col-sm-10">${user.houseNumber}</div>
    </div>

    <div class="row">
        <label class="col-sm-2">flatNumber</label>
        <div class="col-sm-10">${user.flatNumber}</div>
    </div>

    <div class="row">
        <label class="col-sm-2">zipCode</label>
        <div class="col-sm-10">${user.zipCode}</div>
    </div>

    <div class="row">
        <label class="col-sm-2">city</label>
        <div class="col-sm-10">${user.city}</div>
    </div>

    <div class="row">
        <label class="col-sm-2">country</label>
        <div class="col-sm-10">${user.country}</div>
    </div>

    <div class="row">
        <label class="col-sm-2">enabled</label>
        <div class="col-sm-10">${user.enabled}</div>
    </div>

    <c:forEach var="userRole" items="${user.userRole}">
        <tr>
            <td>
                    ${userRole.role}
            </td>
        </tr>
    </c:forEach>

    <a href="${pageContext.request.contextPath}/secure/admin/users/${user.username}/roles">Edit roles</a>

</div>

</body>
</html>