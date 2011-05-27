<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<script src="<c:url value='/resources/js/jquery.dataTables.js'/>" type="text/javascript"></script>
<link rel="stylesheet" href="<c:url value="/resources/css/table.css"/>" type="text/css"/>
<c:url value="/mahasiswa" var="mahasiswa_url"/>
<script type="text/javascript">
    $(document).ready(function() {
        var oTable = $('#datatables').dataTable({
                    "sPaginationType": "full_numbers"
                });
    });

</script>

<div class="content">
    <div class="blocksection">
        <h2>List All Mahasiswa</h2>
        <table cellpadding="0" cellspacing="0" border="0" class="display" id="datatables" width="100%">
            <thead>
            <tr>
                <th>NIM</th>
                <th>Nama</th>
                <th>Minat</th>
                <th style="width:150px;">Action</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${data}" var="mahasiswa">
                <tr>
                    <td>${mahasiswa.nim}</td>
                    <td>${mahasiswa.nama}</td>
                    <td>${mahasiswa.minat.value}</td>
                    <td>
                        <div class="buttonWrapper">
                            <a href="<c:url value='/mahasiswa/${mahasiswa.id}' />" class="view">View
                            </a>
                            <a href="<c:url value='/mahasiswa/${mahasiswa.id}/edit' />" class="edit">Edit</a>
                            <a onclick="return confirm('Apakah anda Yakin ?')"
                               href="<c:url value='/mahasiswa/${mahasiswa.id}/delete' />"
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
                        <a href="<c:url value='/mahasiswa/new' />" class="view">Create</a>
                    </div>
                </td>
            </tr>
            </tfoot>
        </table>
    </div>
</div>
