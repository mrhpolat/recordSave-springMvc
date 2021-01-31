<%@ page session="false" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html lang="tr">

<jsp:include page="./fragments/header.jsp"/>

<spring:url value="/visit/list" var="urlList"/>
<spring:url value="/visit/data" var="urlAdd"/>

<div class="container">
    <div class="costume-home">
        <a href="${urlList}" class="btn btn-outline-secondary btn-lg costume-home" type="button">Visit List</a>
        <a href="${urlAdd}" class="btn btn-outline-secondary btn-lg costume-home">Visit Add</a>
    </div>
</div>

<jsp:include page="./fragments/footer.jsp"/>

</html>