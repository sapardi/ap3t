<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<script src="<c:url value='/resources/js/jquery.dataTables.js'/>" type="text/javascript"></script>
<link rel="stylesheet" href="<c:url value="/resources/css/table.css"/>" type="text/css"/>
<c:url value="/topik" var="topik_url"/>
<script type="text/javascript">
    $(document).ready(function() {
        var oTable = $('#datatables').dataTable({
                    "sPaginationType": "full_numbers"
                });
    });

</script>

<div class="content">
    <div class="blocksection">
        <h2>List All Topik</h2>
        <table cellpadding="0" cellspacing="0" border="0" class="display" id="datatables" width="100%">
            <thead>
            <tr>
                <th>Mahasiswa</th>
                <th>Dosen</th>
                <th>Judul</th>
                <th>Status</th>
                <th style="width:150px;">Action</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${data}" var="topik">
                <tr>
                    <c:if test="${topik.mahasiswa !=null}">
                        <td>${topik.mahasiswa.nim}&nbsp;-&nbsp;${topik.mahasiswa.nama} </td>
                    </c:if>
                    <c:if test="${topik.mahasiswa ==null}">
                        <td> &nbsp;</td>
                    </c:if>
                    <c:if test="${topik.dosen !=null}">
                        <td>${topik.dosen.nip}&nbsp;-&nbsp;${topik.dosen.nama} </td>
                    </c:if>
                    <c:if test="${topik.dosen ==null}">
                        <td> &nbsp;</td>
                    </c:if>
                    <td><p>${topik.judul}</p></td>
                    <td>${topik.aktif?"Active":"In Active"}</td>
                    <td>
                        <div class="buttonWrapper">
                            <a href="<c:url value='/topik/${topik.id}' />" class="view">View
                            </a>
                            <a href="<c:url value='/topik/${topik.id}/edit' />" class="edit">Edit</a>
                            <a onclick="return confirm('Apakah anda Yakin ?')"
                               href="<c:url value='/topik/${topik.id}/delete' />"
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
                        <a href="<c:url value='/topik/new' />" class="view">Create</a>
                    </div>
                </td>
            </tr>
            </tfoot>
        </table>
    </div>
</div>
