<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<div class="content">
    <c:url value="/tesis" var="tesis_url"/>

    <form:form action="${tesis_url}" method="PUT" modelAttribute="tesis" id="tesisForm">
        <form:hidden path="id" id="id"/>
        <div class="blocksection">
            <div class="blockcontent">
                <h3>Insert New Tesis </h3>
                <dl class="form-select">
                    <dt>
                        <label for="topik">Topik :</label>
                    </dt>
                    <dd>

                        <form:select path="topik" items="${listTopik}" itemValue="id" itemLabel="judul"
                                     id="topik"/>

                        <form:errors delimiter="&lt;p/&gt;" cssClass="boxinfo error"
                                     path="topik"/>
                        <p class="description">Required.</p>
                    </dd>
                </dl>
                <dl class="form-text">
                    <dt>
                        <label for="dokumen">Dokumen :</label>
                    </dt>
                    <dd>

                        <form:input path="dokumen" id="dokumen"/>
                        <form:errors delimiter="&lt;p/&gt;" cssClass="boxinfo error"
                                     path="dokumen"/>
                        <p class="description">Required.</p>
                    </dd>
                </dl>
                <dl class="form-check">
                    <dt>
                        <label for="disetujui">Disetujui :</label>
                    </dt>
                    <dd>

                        <form:checkbox path="disetujui" id="disetujui" label="Disetujui"/>

                        <form:errors delimiter="&lt;p/&gt;" cssClass="boxinfo error"
                                     path="disetujui"/>
                        <p class="description">Required.</p>
                    </dd>
                </dl>


                <dl class="form-select">
                    <dt>
                        <label for="nilai">Nilai :</label>
                    </dt>
                    <dd>
                        <form:select path="nilai" items="${nilaiData}" id="nilai"/>

                        <form:errors delimiter="&lt;p/&gt;" cssClass="boxinfo error"
                                     path="nilai"/>
                        <p class="description">Required.</p>
                    </dd>
                </dl>
                <dl class="form-select">
                    <dt>
                        <label for="status">Status :</label>
                    </dt>
                    <dd>
                        <form:select path="status" items="${statusData}" id="status"/>

                        <form:errors delimiter="&lt;p/&gt;" cssClass="boxinfo error"
                                     path="status"/>
                        <p class="description">Required.</p>
                    </dd>
                </dl>
                <dl class="form-check">
                    <dt>
                        <label for="revisiDisetujui">Revisi Disetujui :</label>
                    </dt>
                    <dd>

                        <form:checkbox path="revisiDisetujui" id="revisiDisetujui" label="Revisi Disetujui"/>

                        <form:errors delimiter="&lt;p/&gt;" cssClass="boxinfo error"
                                     path="revisiDisetujui"/>
                        <p class="description">Required.</p>
                    </dd>
                </dl>
                <dl class="form-text">
                    <dt>
                        <label for="jadwalUjian">Jadwal Ujian :</label>
                    </dt>
                    <dd>

                        <form:input path="jadwalUjian" id="jadwalUjian"/>
                        <form:errors delimiter="&lt;p/&gt;" cssClass="boxinfo error"
                                     path="jadwalUjian"/>
                        <p class="description">Required.</p>
                    </dd>
                </dl>

            </div>
        </div>
        <div class="form-button">
            <div class="buttonWrapper">
                <a href="<c:url value='/tesis'/>" class="back">Back</a>
            </div>
            <input type="submit" value="Save" name="submit_1" id="submit_1"/>
            <input class="grey" type="reset" value="Clear" name="reset_1" id="reset_1"/>
        </div>
    </form:form>
</div>