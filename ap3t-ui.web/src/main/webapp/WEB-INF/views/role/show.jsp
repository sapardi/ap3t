<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<div class="content">
    <form action="">
        <div class="blocksection">
            <div class="blockcontent">
                <h3>Detail role</h3>
                <table cellpadding="0" cellspacing="0" border="0" width="928px" id="table_view">
                    <tbody>
                    <tr>
                        <td width="25%">Authority :</td>
                        <td width="75%">${data.authority}</td>
                    </tr>

                    </tbody>
                </table>
                <div class="form-agree buttonWrapper">
                    <a href="<c:url value='/role' />" class="back">Back
                    </a>
                    <a href="<c:url value='/role/${data.authority}/edit' />" class="edit">Edit</a>
                </div>
            </div>
        </div>
    </form>
</div>
