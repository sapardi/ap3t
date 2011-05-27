<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<div class="content">
    <c:url value="/mahasiswa" var="mahasiswa_url"/>

    <form:form action="${mahasiswa_url}" method="POST" modelAttribute="mahasiswa" id="mahasiswaForm">
    <div class="blocksection">
        <div class="blockcontent">
            <h3>Insert New Mahasiswa </h3>
            <dl class="form-text">
                <dt>
                    <label for="nim">NIM :</label>
                </dt>
                <dd>

                    <form:input path="nim" id="nim"/>

                    <form:errors delimiter="&lt;p/&gt;" cssClass="boxinfo error"
                                 path="nim"/>
                    <p class="description">Required.</p>
                </dd>
            </dl>
            <dl class="form-text">
                <dt>
                    <label for="nama">Nama :</label>
                </dt>
                <dd>

                    <form:input path="nama" id="nama"/>

                    <form:errors delimiter="&lt;p/&gt;" cssClass="boxinfo error"
                                 path="nama"/>
                    <p class="description">Required.</p>
                </dd>
            </dl>
            <dl class="form-select">
                <dt>
                    <label for="minat">Minat :</label>
                </dt>
                <dd>
                    <form:select path="minat" items="${minatData}" id="minat"/>

                    <form:errors delimiter="&lt;p/&gt;" cssClass="boxinfo error"
                                 path="minat"/>
                    <p class="description">Required.</p>
                </dd>
            </dl>
        </div>
    </div>
    <div class="form-button">
        <div class="buttonWrapper">
            <a href="<c:url value='/mahasiswa'/>" class="back">Back</a>
        </div>
        <input type="submit" value="Save" name="submit_1" id="submit_1"/>
        <input class="grey" type="reset" value="Clear" name="reset_1" id="reset_1"/>
    </div>
    </form:form>
</div>