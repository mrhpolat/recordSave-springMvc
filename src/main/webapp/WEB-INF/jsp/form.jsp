<%@ page session="false" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html lang="tr">

<jsp:include page="./fragments/header.jsp"/>

<div class="container">

    <c:choose>
        <c:when test="${visit.id == null}">
            <h1>Add User</h1>
        </c:when>
        <c:otherwise>
            <h1>Update User</h1>
        </c:otherwise>
    </c:choose>
    <br/>

    <spring:url value="/visit/ins" var="visitActionUrl"/>

    <form:form class="form-horizontal" method="POST" modelAttribute="visit" action="${visitActionUrl}">

        <form:hidden path="id"/>

        <spring:bind path="firstname">
            <label class="col-sm-2 control-label">Isim</label>
            <div class="col-sm-10">
                <form:input path="firstname" type="text" class="form-control"
                            id="isim" placeholder="isim"/>
            </div>
        </spring:bind>
        <spring:bind path="lastname">
            <label class="col-sm-2 control-label">Soyisim</label>
            <div class="col-sm-10">
                <form:input path="lastname" type="text" class="form-control"
                            id="lastname" placeholder="Soyisim"/>
            </div>
        </spring:bind>
        <spring:bind path="mobile">
            <label class="col-sm-2 control-label">Cep Telefonu</label>
            <div class="col-sm-10">
                <form:input path="mobile" type="number" class="form-control"
                            id="mobile" placeholder="0090-5xx-xxx-xxxx"
                            size="20" maxlength="17" minlength="10"/>
            </div>
        </spring:bind>

        <spring:bind path="bloodGroup">
            <label class="col-sm-2 control-label">Kan Grubu</label>
            <div class="col-sm-5">
                <form:select path="bloodGroup" class="form-control">
                    <form:option value="NONE" label="--- Select ---"/>
                    <form:options items="${bloods}"/>
                </form:select>
                <form:errors path="bloodGroup" class="control-label"/>
            </div>
            <div class="col-sm-5"></div>
        </spring:bind>

        <spring:bind path="address">
            <label class="col-sm-2 control-label">Adres</label>
            <div class="col-sm-10">
                <form:textarea path="address" rows="5" class="form-control"
                               id="adres" placeholder="address"/>
                <form:errors path="address" class="control-label"/>
            </div>
        </spring:bind>

        <spring:bind path="city">
            <label class="col-sm-2 control-label">City</label>
            <div class="col-sm-5">
                <form:select path="city" class="form-control">
                    <form:option value="NONE" label="--- Select ---"/>
                    <form:options items="${cities}"/>
                </form:select>
                <form:errors path="city" class="control-label"/>
            </div>
            <div class="col-sm-5"></div>
        </spring:bind>

        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <c:choose>
                    <c:when test="${visit.id==null}">
                        <button type="submit" class="btn-lg btn-primary pull-right">Kaydet</button>
                    </c:when>
                    <c:otherwise>
                        <button type="submit" class="btn-lg btn-primary pull-right">Guncelle</button>
                    </c:otherwise>
                </c:choose>
            </div>
        </div>
    </form:form>
</div>

<jsp:include page="./fragments/footer.jsp"/>

</html>