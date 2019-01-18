<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="<spring:url value="/resources/css/main.css"/>">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<title>Admin Panel</title>
</head>
<body>
<jsp:include page="/WEB-INF/views/admin/admin_header.jsp"></jsp:include>
<c:forEach items="${PostList}" var="post">
<p>${post.title}</p>
</c:forEach>
<script type="text/javascript" src="<spring:url value="/resources/js/main.js"/>"></script>
</body>
</html>