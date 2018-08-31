<%@ page session="false" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html lang="en">

<div class="container">

    <spring:url value="/secure/admin/users" var="userActionUrl"/>

    <form:form class="form-horizontal" method="post"
               modelAttribute="userForm" action="${userActionUrl}">

        <spring:bind path="username">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <label class="col-sm-2 control-label"><spring:message code="show.username"></spring:message></label>
                <div class="col-sm-10">
                    <form:input path="username" type="text" class="form-control"
                                id="username" placeholder="Username"/>
                    <form:errors path="username" class="control-label"/>
                </div>
            </div>
        </spring:bind>

        <spring:bind path="password">
            <div class="form-group ${status.error ? 'has-error' : ''}">
            <label class="col-sm-2 control-label"><spring:message code="show.password"></spring:message></label>
                <div class="col-sm-10">
                    <form:input path="password" class="form-control"
                                id="password" placeholder="Password"/>
                    <form:errors path="password" class="control-label"/>
                </div>
            </div>
        </spring:bind>

        <spring:bind path="name">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <label class="col-sm-2 control-label"><spring:message code="show.name"></spring:message></label>
                <div class="col-sm-10">
                    <form:input path="name" class="form-control"
                                id="name" placeholder="name"/>
                    <form:errors path="name" class="control-label"/>
                </div>
            </div>
        </spring:bind>

        <spring:bind path="surname">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <label class="col-sm-2 control-label"><spring:message code="show.surname"></spring:message></label>
                <div class="col-sm-10">
                    <form:input path="surname" class="form-control"
                                id="surname" placeholder="surname"/>
                    <form:errors path="surname" class="control-label"/>
                </div>
            </div>
        </spring:bind>

        <spring:bind path="street">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <label class="col-sm-2 control-label"><spring:message code="show.street"></spring:message></label>
                <div class="col-sm-10">
                    <form:input path="street" class="form-control"
                                id="street" placeholder="street"/>
                    <form:errors path="street" class="control-label"/>
                </div>
            </div>
        </spring:bind>

        <spring:bind path="city">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <label class="col-sm-2 control-label"><spring:message code="show.city"></spring:message></label>
                <div class="col-sm-10">
                    <form:input path="city" class="form-control"
                                id="city" placeholder="city"/>
                    <form:errors path="city" class="control-label"/>
                </div>
            </div>
        </spring:bind>

        <spring:bind path="country">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <label class="col-sm-2 control-label"><spring:message code="show.country"></spring:message></label>
                <div class="col-sm-10">
                    <form:input path="country" class="form-control"
                                id="country" placeholder="country"/>
                    <form:errors path="country" class="control-label"/>
                </div>
            </div>
        </spring:bind>

        <spring:bind path="houseNumber">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <label class="col-sm-2 control-label"><spring:message code="show.houseNumber"></spring:message></label>
                <div class="col-sm-10">
                    <form:input path="houseNumber" class="form-control"
                                id="houseNumber" placeholder="houseNumber"/>
                    <form:errors path="houseNumber" class="control-label"/>
                </div>
            </div>
        </spring:bind>

        <spring:bind path="flatNumber">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <label class="col-sm-2 control-label"><spring:message code="show.flatNumber"></spring:message></label>
                <div class="col-sm-10">
                    <form:input path="flatNumber" class="form-control"
                                id="flatNumber" placeholder="flatNumber"/>
                    <form:errors path="flatNumber" class="control-label"/>
                </div>
            </div>
        </spring:bind>

        <spring:bind path="phoneNumber">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <label class="col-sm-2 control-label"><spring:message code="show.phoneNumber"></spring:message></label>
                <div class="col-sm-10">
                    <form:input path="phoneNumber" class="form-control"
                                id="phoneNumber" placeholder="phoneNumber"/>
                    <form:errors path="phoneNumber" class="control-label"/>
                </div>
            </div>
        </spring:bind>

        <spring:bind path="additionalPhoneNumber">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <label class="col-sm-2 control-label"><spring:message code="show.additionalPhoneNumber"></spring:message></label>
                <div class="col-sm-10">
                    <form:input path="additionalPhoneNumber" class="form-control"
                                id="additionalPhoneNumber" placeholder="additionalPhoneNumber"/>
                    <form:errors path="additionalPhoneNumber" class="control-label"/>
                </div>
            </div>
        </spring:bind>
        <spring:bind path="email">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <label class="col-sm-2 control-label"><spring:message code="show.email"></spring:message></label>
                <div class="col-sm-10">
                    <form:input path="email" class="form-control"
                                id="email" placeholder="email"/>
                    <form:errors path="email" class="control-label"/>
                </div>
            </div>
        </spring:bind>
        <spring:bind path="pesel">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <label class="col-sm-2 control-label"><spring:message code="show.pesel"></spring:message></label>
                <div class="col-sm-10">
                    <form:input path="pesel" class="form-control"
                                id="pesel" placeholder="pesel"/>
                    <form:errors path="pesel" class="control-label"/>
                </div>
            </div>
        </spring:bind>


        <spring:bind path="zipCode">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <label class="col-sm-2 control-label"><spring:message code="show.zipCode"></spring:message></label>
                <div class="col-sm-10">
                    <form:input path="zipCode" class="form-control"
                                id="zipCode" placeholder="zipCode"/>
                    <form:errors path="zipCode" class="control-label"/>
                </div>
            </div>
        </spring:bind>

        <spring:bind path="Enabled">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <label class="col-sm-2 control-label"><spring:message code="show.enabled"></spring:message></label>
                <div class="col-sm-10">
                    <label class="radio-inline">
                        <form:radiobutton path="enabled" value="True"/> <spring:message code="show.true"></spring:message>
                    </label>
                    <label class="radio-inline">
                        <form:radiobutton path="enabled" value="False"/> <spring:message code="show.false"></spring:message>
                    </label> <br/>
                    <form:errors path="enabled" class="control-label"/>
                </div>
            </div>
        </spring:bind>

        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <button type="submit" class="btn-lg btn-primary pull-right"><spring:message code="show.add"></spring:message>
                </button>
            </div>
        </div>
    </form:form>

</div>

</body>
</html>
