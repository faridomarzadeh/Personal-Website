<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="<spring:url value="/resources/css/main.css"/>">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<title>Admin Panel</title>
</head>
<body>
<jsp:include page="/WEB-INF/views/admin/admin_header.jsp"></jsp:include>

<script type="text/javascript" src="<spring:url value="/resources/js/main.js"/>"></script>
</body>
</html>