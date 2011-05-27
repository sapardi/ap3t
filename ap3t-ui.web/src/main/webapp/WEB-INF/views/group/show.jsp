<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<div class="content">
    <form action="">
        <div class="blocksection">
            <div class="blockcontent">
                <h3>Detail Group</h3>
                <table cellpadding="0" cellspacing="0" border="0" width="928px" id="table_view">
                    <tbody>
                    <tr>
                        <td width="25%">Nama :</td>
                        <td width="75%">${data.name}</td>
                    </tr>
                    <tr>
                        <td width="25%">Hak Akses :</td>
                        <td width="75%">
                            <c:forEach var="role" items="${data.roles}">
                                ${role.authority}&nbsp;&nbsp;
                            </c:forEach>
                        </td>
                    </tr>

                    </tbody>
                </table>
                <div class="form-agree buttonWrapper">
                    <a href="<c:url value='/group' />" class="back">Back
                    </a>
                    <a href="<c:url value='/group/${data.id}/edit' />" class="edit">Edit</a>
                </div>
            </div>
        </div>
    </form>
</div>
