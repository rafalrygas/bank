<div style="border: 1px solid #ccc;padding:5px;margin-bottom:20px;">

    <a href="${pageContext.request.contextPath}/secure/admin/home">Home</a>

    | &nbsp;

    <a href="${pageContext.request.contextPath}/secure/admin/userInfo">User Info</a>

    | &nbsp;

    <a href="${pageContext.request.contextPath}/secure/admin/users">Users</a>

    <c:if test="${pageContext.request.userPrincipal.name != null}">

        | &nbsp;
        <a href="${pageContext.request.contextPath}/logout">Logout</a>

    </c:if>

</div>