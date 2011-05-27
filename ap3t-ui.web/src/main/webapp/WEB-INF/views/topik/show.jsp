<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<div class="content">
    <form action="">
        <div class="blocksection">
            <div class="blockcontent">
                <h3>Detail Topik</h3>
                <table cellpadding="0" cellspacing="0" border="0" width="928px" id="table_view">
                    <tbody>
                    <tr>
                        <td width="25%">Mahasiswa :</td>
                        <c:if test="${data.mahasiswa !=null}">
                            <td width="75%">${data.mahasiswa.nim}&nbsp;-&nbsp;${data.mahasiswa.nama} </td>
                        </c:if>
                        <c:if test="${data.mahasiswa ==null}">
                            <td width="75%"> &nbsp;</td>
                        </c:if>
                    </tr>
                    <tr>
                        <td width="25%">Dosen :</td>
                         <c:if test="${data.dosen !=null}">
                            <td width="75%">${data.dosen.nip}&nbsp;-&nbsp;${data.dosen.nama} </td>
                        </c:if>
                        <c:if test="${data.dosen ==null}">
                            <td width="75%"> &nbsp;</td>
                        </c:if>
                    </tr>
                    <tr>
                        <td width="25%">Judul :</td>
                        <td width="75%"><p>${data.judul}</p></td>
                    </tr>
                    <tr>
                        <td width="25%">Status :</td>
                        <td width="75%">${data.aktif?"Active":"In Active"}</td>
                    </tr>

                    </tbody>
                </table>
                <div class="form-agree buttonWrapper">
                    <a href="<c:url value='/topik' />" class="back">Back
                    </a>
                    <a href="<c:url value='/topik/${data.id}/edit' />" class="edit">Edit</a>
                </div>
            </div>
        </div>
    </form>
</div>
