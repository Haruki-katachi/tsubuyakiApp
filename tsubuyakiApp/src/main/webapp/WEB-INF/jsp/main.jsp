<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>
<!DOCTYPE html>
<html>
<%
	pageContext.setAttribute("title", "つぶやきアプリ", PageContext.PAGE_SCOPE);
%>
<%@ include file="/WEB-INF/jsp/include/head.jsp" %>

<body>
	<%@ include file="/WEB-INF/jsp/include/navbar.jsp" %>
	<div class="container-md">
		<div class="card">
			<div class="mb-3">
				<c:if test="${error != null}">
					<div class="alert alert-danger">${error}</div>
				</c:if>
				<form action="Main" method="post">
					<label for="post" class="form-label">投稿したい内容</label>
					<textarea class="form-control mb-1" id="post" name="post" rows="3"></textarea>
					<button type="submit" class="btn btn-outline-success">投稿</button>
				</form>
			</div>
		</div>
		<div class="card">
			<ul>
				<c:forEach var="post" items="posts">
					<a class="card-body" href="#">
						<h5 class="card-title">${post.name}</h5>
						<p class="card-text">${post.item}</p>
					</a>
				</c:forEach>
			</ul>
		</div>
	</div>
	
	<%@ include file="/WEB-INF/jsp/include/js.jsp" %>
</body>
</html>