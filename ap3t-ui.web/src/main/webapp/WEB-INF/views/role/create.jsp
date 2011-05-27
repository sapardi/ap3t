<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<div class="content">
    <c:url value="/role" var="role_url"/>

    <form:form action="${role_url}" method="POST" modelAttribute="role" id="roleForm">
    <div class="blocksection">
        <div class="blockcontent">
            <h3>Insert New role </h3>
            <dl class="form-text">
                <dt>
                    <label for="authority">Authority :</label>
                </dt>
                <dd>

                    <form:input path="authority" id="authority"/>

                    <form:errors delimiter="&lt;p/&gt;" cssClass="boxinfo error"
                                 path="authority"/>
                    <p class="description">Required.</p>
                </dd>
            </dl>

        </div>
    </div>
    <div class="form-button">
        <div class="buttonWrapper">
            <a href="<c:url value='/role'/>" class="back">Back</a>
        </div>
        <input type="submit" value="Save" name="submit_1" id="submit_1"/>
        <input class="grey" type="reset" value="Clear" name="reset_1" id="reset_1"/>
    </div>
    </form:form>
</div>