<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<div class="content">
    <form action="">
        <div class="blocksection">
            <div class="blockcontent">
                <h3>Detail User</h3>
                <table cellpadding="0" cellspacing="0" border="0" width="928px" id="table_view">
                    <tbody>
                    <tr>
                        <td width="25%">Id :</td>
                        <td width="75%">${data.id}</td>
                    </tr>
                    <tr>
                        <td width="25%">Username :</td>
                        <td width="75%">${data.username}</td>
                    </tr>
                    <tr>
                        <td width="25%">Password :</td>
                        <td width="75%">${data.password}</td>
                    </tr>
                    <tr>
                        <td width="25%">Enabled :</td>
                        <td width="75%">${data.enabled}</td>
                    </tr>
                    <tr>
                        <td width="25%">Salt :</td>
                        <td width="75%">${data.salt}</td>
                    </tr>

                    <tr>
                        <td width="25%">Group :</td>
                        <td width="75%">${data.group !=null ? data.group.name : ""}</td>
                    </tr>
                    <tr>
                        <td width="25%">Type :</td>
                        <td width="75%">${data.type.value}</td>
                    </tr>

                    </tbody>
                </table>
                <div class="form-agree buttonWrapper">
                    <a href="<c:url value='/user' />" class="back">Back
                    </a>
                    <a href="<c:url value='/user/${data.id}/edit' />" class="edit">Edit</a>
                </div>
            </div>
        </div>
    </form>
</div>
