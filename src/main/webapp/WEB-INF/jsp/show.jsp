<%@ page session="false" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html lang="en">

<jsp:include page="./fragments/header.jsp"/>

<c:if test="${not empty msg}">
    <div class="alert alert-${css} alert-dismissible" role="alert">
        <button type="button" class="close" data-dismiss="alert" aria-label="Close">
            <span aria-hidden="true">&times;</span>
        </button>
        <strong>${msg}</strong>
    </div>
</c:if>

<div class="container">
    <h1>Visit Detail</h1>
    <br/>

    <div class="row">
        <label class="col-sm-2">Id</label>
        <div class="col-sm-10">${visit.id}</div>
    </div>

    <div class="row">
        <label class="col-sm-2">Isim</label>
        <div class="col-sm-10">${visit.firstname}</div>
    </div>

    <div class="row">
        <label class="col-sm-2">Soyisim</label>
        <div class="col-sm-10">${visit.lastname}</div>
    </div>

    <div class="row">
        <label class="col-sm-2">Kan Grubu</label>
        <div class="col-sm-10">${visit.bloodGroup}</div>
    </div>

    <div class="row">
        <label class="col-sm-2">Cep Telefon</label>
        <div class="col-sm-10">${visit.mobile}</div>
    </div>

    <div class="row">
        <label class="col-sm-2">Adres</label>
        <div class="col-sm-10">${visit.address}</div>
    </div>
    <div class="row">
        <label class="col-sm-2">Sehir</label>
        <div class="col-sm-10">${visit.city}</div>
    </div>


</div>

<jsp:include page="./fragments/footer.jsp"/>

</body>
</html>