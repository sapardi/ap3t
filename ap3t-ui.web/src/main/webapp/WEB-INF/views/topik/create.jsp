<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<div class="content">
    <c:url value="/topik" var="topik_url"/>

    <form:form action="${topik_url}" method="POST" modelAttribute="topik" id="topikForm">
        <div class="blocksection">
            <div class="blockcontent">
                <h3>Insert New Topik </h3>
                <dl class="form-select">
                    <dt>
                        <label for="mahasiswa">Mahasiswa :</label>
                    </dt>
                    <dd>

                        <form:select path="mahasiswa" items="${listMahasiswa}" itemValue="id" itemLabel="nama"
                                     id="mahasiswa"/>

                        <form:errors delimiter="&lt;p/&gt;" cssClass="boxinfo error"
                                     path="mahasiswa"/>
                        <p class="description">Required.</p>
                    </dd>
                </dl>
                <dl class="form-select">
                    <dt>
                        <label for="dosen">Dosen :</label>
                    </dt>
                    <dd>

                        <form:select path="dosen" items="${listDosen}" itemValue="id" itemLabel="nama" id="dosen"/>

                        <form:errors delimiter="&lt;p/&gt;" cssClass="boxinfo error"
                                     path="dosen"/>
                        <p class="description">Required.</p>
                    </dd>
                </dl>
                <dl class="form-textarea">
                    <dt>
                        <label for="judul">Judul :</label>
                    </dt>
                    <dd>

                        <form:textarea path="judul" id="judul"/>

                        <form:errors delimiter="&lt;p/&gt;" cssClass="boxinfo error"
                                     path="judul"/>
                        <p class="description">Required.</p>
                    </dd>
                </dl>
                <dl class="form-check">
                    <dt>
                        <label for="aktif">Status :</label>
                    </dt>
                    <dd>

                        <form:checkbox path="aktif" id="aktif" label="Aktif"/>

                        <form:errors delimiter="&lt;p/&gt;" cssClass="boxinfo error"
                                     path="aktif"/>
                        <p class="description">Required.</p>
                    </dd>
                </dl>
            </div>
        </div>
        <div class="form-button">
            <div class="buttonWrapper">
                <a href="<c:url value='/topik'/>" class="back">Back</a>
            </div>
            <input type="submit" value="Save" name="submit_1" id="submit_1"/>
            <input class="grey" type="reset" value="Clear" name="reset_1" id="reset_1"/>
        </div>
    </form:form>
</div>