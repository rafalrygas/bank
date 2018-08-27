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

    <a href="${pageContext.request.contextPath}/secure/admin/users/add">Add User</a>

    <h1>All Users</h1>

    <table class="table table-striped">
        <thead>
        <tr>
            <th>Username</th>
            <th>Name</th>
            <th>Surname</th>
            <th>Action</th>
        </tr>
        </thead>

        <c:forEach var="user" items="${users}">
            <tr>
                <td>
                        ${user.username}
                </td>
                <td>${user.name}</td>
                <td>${user.surname}</td>
                <td>
                    <spring:url value="/secure/admin/users/${user.username}" var="userUrl" />
                    <spring:url value="/secure/admin/users/${user.username}/delete" var="deleteUrl" />
                    <spring:url value="/secure/admin/users/${user.username}/update" var="updateUrl" />

                    <button class="btn btn-info"
                            onclick="location.href='${userUrl}'">Query</button>
                    <button class="btn btn-primary"
                            onclick="location.href='${updateUrl}'">Update</button>
                    <button class="btn btn-danger"
                            onclick="location.href='${deleteUrl}'">Delete</button>
                </td>
            </tr>
        </c:forEach>
    </table>

</div>

</body>
</html>
