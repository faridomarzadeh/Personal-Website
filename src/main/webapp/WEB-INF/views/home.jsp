<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ page session="false" %>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="<spring:url value="/resources/css/main.css"/>">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<title>Farid's Website</title>
</head>
<body>
<jsp:include page="/WEB-INF/views/fragments/header.jsp"/>
<div class="wrapper">
<div class="description">
<h2>About Me</h2>
</div>
<c:forEach items="${PostList}" var="post">
<p>${post.title}</p>
</c:forEach>
</div>
<script type="text/javascript" src="<spring:url value="/resources/js/main.js"/>"></script>
</body>
</html>
