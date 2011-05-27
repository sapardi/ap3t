<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:if test="${mainNav == 'master'}">
    <div class="content-tab">
        <ul>
            <li class="${tab == 'tesis' ? 'active' : ''}"><a href="<c:url value='/tesis'/>">Tesis</a></li>
            <li class="${tab == 'pratesis' ? 'active' : ''}"><a href="<c:url value='/pratesis'/>">Pratesis</a></li>
            <li class="${tab == 'proposal' ? 'active' : ''}"><a href="<c:url value='/proposal'/>">Proposal</a></li>
            <li class="${tab == 'topik' ? 'active' : ''}"><a href="<c:url value='/topik'/>">Topik</a></li>
            <li class="${tab == 'mahasiswa' ? 'active' : ''}"><a href="<c:url value='/mahasiswa'/>">Mahasiswa</a></li>
            <li class="${tab == 'dosen' ? 'active' : ''}"><a href="<c:url value='/dosen'/>">Dosen</a></li>
            <li class="${tab == 'user' ? 'active' : ''}"><a href="<c:url value='/user'/>">User</a></li>
            <li class="${tab == 'group' ? 'active' : ''}"><a href="<c:url value='/group'/>">Group</a></li>
            <li class="${tab == 'role' ? 'active' : ''}"><a href="<c:url value='/role'/>">Role</a></li>
        </ul>
    </div>
</c:if>
<%--


  <li class="${mainNav == 'master' ? 'active' : 'none'}">
            <a href="<c:url value='/berita'/>" class="parent">Master Data</a>
            <ul class="zero pop-nav">
                <li><a href="<c:url value='/berita'/>">Berita</a>
                <li><a href="<c:url value='/staff'/>">Staff</a></li>
                <li><a href="<c:url value='/user'/>#">Member</a></li>
                <li><a href="<c:url value='/paket'/>#">Paket</a></li>
                <li><a href="<c:url value='/role'/>#">Role</a></li>
                <li><a href="<c:url value='/bank'/>#">Bank</a></li>
            </ul>
        </li>
        <li class="${mainNav == 'laporan' ? 'active' : 'none'}">
            <a href="#" class="parent">Laporan</a>
            <ul>
                <li><a href="<c:url value='/profit'/>">Profit Perbulan</a></li>
                <li><a href="<c:url value='/profit/laporan'/>">Cetak Profit Perbulan</a></li>
                <li><a href="<c:url value='/berita'/>">Bonus Sponsor</a></li>
                <li><a href="<c:url value='/berita'/>">Cetak Bonus Sponsor</a></li>
            </ul>
        </li>
--%>
