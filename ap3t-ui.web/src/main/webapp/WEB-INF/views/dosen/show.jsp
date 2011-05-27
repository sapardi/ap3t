<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<div class="content">
    <form action="">
        <div class="blocksection">
            <div class="blockcontent">
                <h3>Detail Dosen</h3>
                <table cellpadding="0" cellspacing="0" border="0" width="928px" id="table_view">
                    <tbody>
                    <tr>
                        <td width="25%">NIP :</td>
                        <td width="75%">${data.nip}</td>
                    </tr>
                    <tr>
                        <td width="25%">Nama :</td>
                        <td width="75%">${data.nama}</td>
                    </tr>
                    <tr>
                        <td width="25%">Minat :</td>
                        <td width="75%">${data.minat.value}</td>
                    </tr>

                    </tbody>
                </table>
                <div class="form-agree buttonWrapper">
                    <a href="<c:url value='/dosen' />" class="back">Back
                    </a>
                    <a href="<c:url value='/dosen/${data.id}/edit' />" class="edit">Edit</a>
                </div>
            </div>
        </div>
    </form>
</div>
