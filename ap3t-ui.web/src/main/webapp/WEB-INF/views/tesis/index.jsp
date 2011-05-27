<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<script src="<c:url value='/resources/js/jquery.dataTables.js'/>" type="text/javascript"></script>
<link rel="stylesheet" href="<c:url value="/resources/css/table.css"/>" type="text/css"/>
<c:url value="/tesis" var="tesis_url"/>
<script type="text/javascript">
    $(document).ready(function() {
        var oTable = $('#datatables').dataTable({
                    "sPaginationType": "full_numbers"
                });
    });

</script>

<div class="content">
    <div class="blocksection">
        <h2>List All Tesis</h2>
        <table cellpadding="0" cellspacing="0" border="0" class="display" id="datatables" width="100%">
            <thead>
            <tr>
                <th>Topik</th>
                <th>Dokumen</th>
                <th>Disetujui</th>
                <th>Nilai</th>
                <th>Status</th>
                <th>Revisi Disetujui</th>
                <th>Jadwal Ujian</th>
                <th style="width:150px;">Action</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${data}" var="tesis">
                <tr>
                    <c:if test="${tesis.topik !=null}">
                        <td>${tesis.topik.id} </td>
                    </c:if>
                    <td>${tesis.dokumen}</td>
                    <td>${tesis.disetujui?"Yes":"No"}</td>
                    <td>${tesis.nilai != null? tesis.nilai.value:""}</td>
                    <td>${tesis.status != null? tesis.status.value:""}</td>
                    <td>${tesis.revisiDisetujui?"Yes":"No"}</td>
                    <td><fmt:formatDate value="${tesis.jadwalUjian}" pattern="dd-MMMM-yyyy : HH:mm"/></td>
                    <td>
                        <div class="buttonWrapper">
                            <a href="<c:url value='/tesis/${tesis.id}' />" class="view">View
                            </a>
                            <a href="<c:url value='/tesis/${tesis.id}/edit' />" class="edit">Edit</a>
                            <a onclick="return confirm('Apakah anda Yakin ?')"
                               href="<c:url value='/tesis/${tesis.id}/delete' />"
                               class="delete">Delete</a>
                        </div>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
            <tfoot>
            <tr>
                <td colspan="7">
                    <div class="buttonWrapper">
                        <a href="<c:url value='/tesis/new' />" class="view">Create</a>
                    </div>
                </td>
            </tr>
            </tfoot>
        </table>
    </div>
</div>
