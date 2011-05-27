<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<div id="secnav">
    <ul>
        <security:authorize access="fullyAuthenticated">
            <li><a href="<c:url value="/logout"/>">Logout</a></li>

            <li class="subnav">
                <a >Options</a>
                <ul>
                    <li><a href="<c:url value='/admin/password'/> ">Change Password</a></li>
                </ul>
            </li>
        </security:authorize>
    </ul>
</div>
