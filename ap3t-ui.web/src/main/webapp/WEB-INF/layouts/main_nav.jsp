<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div id="mainnav">
    <ul>
        <li class="${mainNav == 'home' ? 'active' : 'none'}">
            <a href="<c:url value='/dashboard'/>">Home</a>
            <%--<ul class="icon">
                <li class="gears"><a href="#">Ext JS</a></li>
                <li class="gears"><a href="#">Ext JS 4</a></li>
                <li class="geartool"><a href="#">Ext GWT</a></li>
                <li class="desktop"><a href="#">Ext Designer</a></li>
                <li class="gear-small"><a href="#">Ext Core</a></li>
                <li class="touch"><a href="#">Sencha Touch</a></li>
                <li class="motion"><a href="#">Sencha Animator</a></li>
            </ul>--%>
        </li>
        <li class="${mainNav == 'master' ? 'active' : 'none'}">
            <a class="parent">Master</a>
            <ul class="zero pop-nav">
                <li><a href="<c:url value='/tesis'/>">Tesis</a></li>
                <li><a href="<c:url value='/pratesis'/>">Pratesis</a></li>
                <li><a href="<c:url value='/proposal'/>">Proposal</a></li>
                <li><a href="<c:url value='/topik'/>">Topik</a></li>
                <li><a href="<c:url value='/mahasiswa'/>">Mahasiswa</a></li>
                <li><a href="<c:url value='/dosen'/>">Dosen</a></li>
                <li><a href="<c:url value='/user'/>">User</a></li>
                <li><a href="<c:url value='/group'/>">Group</a></li>
                <li><a href="<c:url value='/role'/>">Role</a></li>
            </ul>
        </li>
        <%--  <li class="${mainNav == 'profit' ? 'active' : 'none'}">
            <a href="#" class="parent">Profit</a>
            <ul>
                <li><a href="<c:url value='/profit/mandiri'/>">Mandiri</a></li>
                <li><a href="<c:url value='/profit/bca'/>">BCA</a></li>
                <li><a href="<c:url value='/profit/bni'/>">BNI</a></li>
            </ul>
        </li>
        <li class="${mainNav == 'bonus' ? 'active' : 'none'}">
            <a href="#" class="parent">Bonus</a>
            <ul>
                <li><a href="<c:url value='/bonus/mandiri'/>">Mandiri</a></li>
                <li><a href="<c:url value='/bonus/bca'/>">BCA</a></li>
                <li><a href="<c:url value='/bonus/bni'/>">BNI</a></li>
            </ul>
        </li>
         <li class="${mainNav == 'laporan' ? 'active' : 'none'}">
            <a href="#" class="parent">Laporan</a>
            <ul>
                <li><a href="<c:url value='/bonus/mandiri'/>">Profit</a></li>
                <li><a href="<c:url value='/bonus/bca'/>">Profit By Rekening</a></li>
                <li><a href="<c:url value='/bonus/bni'/>">Bonus</a></li>
                <li><a href="<c:url value='/bonus/bni'/>">Bonus By Rekening</a></li>
            </ul>
        </li>--%>
        <%-- <li>
            <a href="#" class="parent">Blog</a>
        </li>
        <li>
            <a href="#" class="parent">Store</a>
            <ul>
                <li><a href="#">Sencha Complete</a></li>
                <li><a href="#">Ext JS 4 Pre-Sale</a></li>
                <li><a href="#">Ext JS</a></li>
                <li><a href="#">Ext GWT</a></li>
                <li><a href="#">Ext Designer</a></li>
                <li><a href="#">Sencha Touch</a></li>
                <li><a href="#">Ordering Information</a></li>
            </ul>
        </li>--%>
    </ul>
</div>