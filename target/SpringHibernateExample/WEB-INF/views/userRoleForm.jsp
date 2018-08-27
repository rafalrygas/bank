<%@ page session="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html lang="en">

<body>

<div class="container">

    <c:if test="${not empty msg}">
        <div class="alert alert-${css} alert-dismissible" role="alert">
            <button type="button" class="close" data-dismiss="alert"
                    aria-label="Close">
                <span aria-hidden="true">×</span>
            </button>
            <strong>${msg}</strong>
        </div>
    </c:if>

    <h1>Roles</h1>

    <table class="table table-striped">
        <thead>
        <tr>
            <th>Role</th>
            <th>Action</th>
        </tr>
        </thead>

        <c:forEach var="userRole" items="${userRoles}">
            <tr>
                <td>${userRole.role}</td>
                <td>
                    <spring:url value="/secure/admin/users/${userRole.user.username}/roles/${userRole.userRoleId}/delete" var="deleteUrl" />

                    <button class="btn btn-danger"
                            onclick="location.href='${deleteUrl}'">Delete</button>
                </td>
            </tr>
        </c:forEach>
    </table>

    <a href="${pageContext.request.contextPath}/secure/admin/users/${user}/roles/add">Add roles</a>

</div>

</body>
</html>

