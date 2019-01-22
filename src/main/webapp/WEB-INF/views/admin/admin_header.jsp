<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="topnav" id="myMenu">
	<div class="topheader">
	<c:forEach items="${menuList}" var="menu">
	<c:if test="${not empty menu.isDropdown }">
	<a href="<spring:url value="/admin${menu.url}"/>">${menu.content}</a>
	</c:if>
	</c:forEach>
		<div class="dropdown">
		<c:forEach items= "${menuList}" var="menu">
		   <c:if test="${empty menu.parentId && empty menu.isDropdown}">
			<button class="dropbtn">
				${menu.content}
			</button>
			</c:if>
			<c:forEach items="${menu.subMenu}" var="submenu">
			<div class="dropdown-content">
				<a href="<spring:url value="/admin${menu.url}"/>">${submenu.content}</a>
			</div>
			</c:forEach>
		</c:forEach>
		</div>
		<a href="javascript:void(0);" class="icon" onclick="myFunction()">
		 <i class="fa fa-bars"></i>
		</a>
	</div>
</div>