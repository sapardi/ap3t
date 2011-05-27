<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<div class="content">
    <c:url value="/group" var="group_url"/>

    <form:form action="${group_url}" method="POST" modelAttribute="group" id="groupForm">
        <div class="blocksection">
            <div class="blockcontent">
                <h3>Insert New Group </h3>

                <dl class="form-text">
                    <dt>
                        <label for="name">Nama :</label>
                    </dt>
                    <dd>

                        <form:input path="name" id="name"/>

                        <form:errors delimiter="&lt;p/&gt;" cssClass="boxinfo error"
                                     path="name"/>
                        <p class="description">Required.</p>
                    </dd>
                </dl>
                <dl class="form-check">
                    <dt>
                        <label for="roles">Roles :</label>
                    </dt>
                    <dd>
                        <c:forEach var="role" items="${roles}">
                            <form:checkbox  path="roles" value="${role.authority}"
                                           label="${role.authority}"/>
                        </c:forEach>

                        <p class="description">Required. </p>
                    </dd>
                </dl>
            </div>
        </div>
        <div class="form-button">
            <div class="buttonWrapper">
                <a href="<c:url value='/group'/>" class="back">Back</a>
            </div>
            <input type="submit" value="Save" name="submit_1" id="submit_1"/>
            <input class="grey" type="reset" value="Clear" name="reset_1" id="reset_1"/>
        </div>
    </form:form>
</div>