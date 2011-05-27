<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<div class="content">
    <form action="">
        <div class="blocksection">
            <div class="blockcontent">
                <h3>Detail Pratesis</h3>
                <table cellpadding="0" cellspacing="0" border="0" width="928px" id="table_view">
                    <tbody>
                    <tr>
                        <td width="25%">Topik :</td>
                        <td width="75%">${data.topik!=null?data.topik.judul : ""} </td>

                    </tr>
                    <tr>
                        <td width="25%">Dokumen :</td>
                        <td width="75%">${data.dokumen} </td>
                    </tr>
                    <tr>
                        <td width="25%">Disetujui :</td>
                        <td width="75%">${data.disetujui?"Yes":"No"}</td>
                    </tr>
                    <tr>
                        <td width="25%">Status :</td>
                        <td width="75%">${data.nilai != null? data.nilai.value:""}</td>
                    </tr>
                    <tr>
                        <td width="25%">Revisi Disetujui :</td>
                        <td width="75%">${data.revisiDisetujui?"Yes":"No"}</td>
                    </tr>
                    <tr>
                        <td width="25%">Jadwal Ujian :</td>
                        <td width="75%"><fmt:formatDate value="${data.jadwalUjian}"
                                                        pattern="dd-MMMM-yyyy HH:mm"/></td>
                    </tr>

                    </tbody>
                </table>
                <div class="form-agree buttonWrapper">
                    <a href="<c:url value='/pratesis' />" class="back">Back
                    </a>
                    <a href="<c:url value='/pratesis/${data.id}/edit' />" class="edit">Edit</a>
                </div>
            </div>
        </div>
    </form>
</div>
