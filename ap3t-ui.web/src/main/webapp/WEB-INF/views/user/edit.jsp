<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<div class="content">
    <c:url value="/user" var="user_url"/>

    <form:form action="${user_url}" method="PUT" modelAttribute="user" id="userForm">
        <form:hidden path="id" id="id"/>
        <form:hidden path="password"/>
        <form:hidden path="salt"/>
        <div class="blocksection">
            <div class="blockcontent">
                <h3>Insert New User </h3>
                <dl class="form-text">
                    <dt>
                        <label for="username">Username :</label>
                    </dt>
                    <dd>

                        <form:input path="username" id="username"/>

                        <form:errors delimiter="&lt;p/&gt;" cssClass="boxinfo error"
                                     path="username"/>
                        <p class="description">Required.</p>
                    </dd>
                </dl>
                <dl class="form-radio">
                    <dt>
                        <label for="enabled">Status :</label>
                    </dt>
                    <dd>
                        <form:checkbox path="enabled" id="enabled"/>

                        <p class="description">Required </p>
                    </dd>
                </dl>
                <dl class="form-select">
                    <dt>
                        <label for="group">Group :</label>
                    </dt>
                    <dd>
                        <form:select path="group" items="${groups}" id="group" itemLabel="name" itemValue="id"/>

                        <form:errors delimiter="&lt;p/&gt;" cssClass="boxinfo error"
                                     path="group"/>
                        <p class="description">Required.</p>
                    </dd>
                </dl>
                <dl class="form-select">
                    <dt>
                        <label for="type">Type :</label>
                    </dt>
                    <dd>
                        <form:select path="type" items="${types}" id="type"/>

                        <form:errors delimiter="&lt;p/&gt;" cssClass="boxinfo error"
                                     path="type"/>
                        <p class="description">Required.</p>
                    </dd>
                </dl>
            </div>
        </div>
        <div class="form-button">
            <div class="buttonWrapper">
                <a href="<c:url value='/user'/>" class="back">Back</a>
            </div>
            <input type="submit" value="Save" name="submit_1" id="submit_1"/>
            <input class="grey" type="reset" value="Clear" name="reset_1" id="reset_1"/>
        </div>
    </form:form>
</div>