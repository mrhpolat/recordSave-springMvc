<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>Kayıt Defteri</title>
	<link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" />
</head>

<spring:url value="/visit/" var="urlHome" />
<spring:url value="/visit/list" var="urlAllVisit" />
<spring:url value="/visit/data" var="urlAddVisit" />

<body>
<nav class="navbar navbar-expand-md navbar-light bg-light sticky-top">
	<div class="container-fluid">
		<a class="navbar-brand" href="${urlHome}">Home</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarResponsive">
			<ul class="navbar-nav ml-auto">
				<li class="nav-link">
					<a class="nav-link" href="${urlAllVisit}">All Visits</a>
				</li>
				<li class="nav-link">
					<a class="nav-link" href="${urlAddVisit}">Add Visit</a>
				</li>
			</ul>
		</div>
	</div>
</nav>
