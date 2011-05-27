<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<div class="content">
    <spring:url value='/login' var="submit_url"/>
    <form action="${submit_url}" method="POST">
        <div class="blocksection">
            <div class="blockcontent">

                <h3>Login</h3>
                <dl class="form-text">
                    <dt>
                        <label for="j_username">Username :</label>
                    </dt>
                    <dd>
                        <input type="text" id="j_username" name="j_username" value=""/>


                        <p class="description">Masukkan Username anda.</p>
                    </dd>
                    <dt>
                        <label for="j_password">Password :</label>
                    </dt>
                    <dd>
                        <input type="password" id="j_password" name="j_password" value=""/>


                        <p class="description">Masukkan Password anda.</p>
                    </dd>

                    <c:if test="${not empty param.error}">
                        <dd>
                            <div class="boxinfo error">
                                Login Gagal, Mohon Periksa Username dan Password Anda.
                            </div>
                        </dd>
                    </c:if>
                </dl>
            </div>
        </div>
        <div class="form-button">
            <input type="submit" value="Login" name="submit_1" id="submit_1"/>
            <input class="grey" type="reset" value="Hapus" name="reset_1" id="reset_1"/>
        </div>
    </form>
</div>