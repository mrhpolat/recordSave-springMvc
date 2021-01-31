<%@ page session="false" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html lang="tr">

<jsp:include page="./fragments/header.jsp"/>

<body>

<div class="container">

    <c:if test="${not empty msg}">
        <div class="alert alert-${css} alert-dismissible" role="alert">
            <button type="button" class="close" data-dismiss="alert"
                    aria-label="Close">
                <span aria-hidden="true">&times;</span>
            </button>
            <strong>${msg}</strong>
        </div>
    </c:if>

    <h1 class="costume-home">All Visits</h1>

    <table class="table table-striped">
        <thead>
        <tr>
            <th>#Id</th>
            <th>Isim</th>
            <th>Soyisim</th>
            <th>Kan Grubu</th>
            <th>Cep Telefonu</th>
            <th>Adres</th>
        </tr>
        </thead>

        <c:forEach var="visit" items="${visits}">
            <tr>
                <td>${visit.id}</td>
                <td>${visit.firstname}</td>
                <td>${visit.lastname}</td>
                <td>${visit.bloodGroup}</td>
                <td>${visit.mobile}</td>
                <td>${visit.address}</td>
                <td>
                    <spring:url value="/visit/${visit.id}" var="visitUrl"/>
                    <spring:url value="/visit/del/${visit.id}" var="deleteUrl"/>
                    <spring:url value="/visit/upd/${visit.id}" var="updateUrl"/>

                    <button class="btn btn-info" onclick="location.href='${visitUrl}'">Info</button>
                    <button class="btn btn-primary" onclick="location.href='${updateUrl}'">Update</button>
                    <button class="btn btn-danger" onclick="location.href='${deleteUrl}'">Delete</button>
                </td>
            </tr>
        </c:forEach>
    </table>

</div>

<jsp:include page="./fragments/footer.jsp"/>

</body>
</html>