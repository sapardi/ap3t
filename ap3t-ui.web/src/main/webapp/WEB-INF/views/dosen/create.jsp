<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<div class="content">
    <c:url value="/dosen" var="dosen_url"/>

    <form:form action="${dosen_url}" method="POST" modelAttribute="dosen" id="dosenForm">
    <div class="blocksection">
        <div class="blockcontent">
            <h3>Insert New Dosen </h3>
            <dl class="form-text">
                <dt>
                    <label for="nip">NIP :</label>
                </dt>
                <dd>

                    <form:input path="nip" id="nip"/>

                    <form:errors delimiter="&lt;p/&gt;" cssClass="boxinfo error"
                                 path="nip"/>
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
            <a href="<c:url value='/dosen'/>" class="back">Back</a>
        </div>
        <input type="submit" value="Save" name="submit_1" id="submit_1"/>
        <input class="grey" type="reset" value="Clear" name="reset_1" id="reset_1"/>
    </div>
    </form:form>
</div>