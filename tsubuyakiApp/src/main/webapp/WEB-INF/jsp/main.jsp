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
				<c:if test="${errors != null}">
					<c:choose>
						<c:when test="${errors.post != null}"><div class="alert alert-danger">${errors.post}</div></c:when>
						<c:when test="${errors.dbError != null}"><div class="alert alert-danger">${errors.dbError}</div></c:when>
					</c:choose>
				</c:if>
				<form action="Main" method="post">
					<input type="hidden" name="accountId" value="${user.id}">
					<div class="mb-3">
						<label for="post" class="form-label">投稿したい内容</label>
						<textarea class="form-control" id="post" name="post" rows="3">${post}</textarea>
					</div>
					<button type="submit" class="btn btn-outline-success">投稿</button>
				</form>
			</div>
		</div>
		<div class="card">
			<ul class="list-group list-group-flush">
				<c:forEach var="post" items="${postList}">
					<a href="/tsubuyakiApp/Individual?id=<c:out value="${post.id}"/>" class="list-group-item">
						<div class="card-body">
							<h5 class="card-title"><c:out value="${post.postUserName}"/></h5>
							<c:if test="${not empty post.toId}">
								<p class="card-text text-secondary">返信</p>
							</c:if>
							<p class="card-text" style="white-space: pre-wrap;"><c:out value="${post.item}"/></p>
						</div>
					</a>
				</c:forEach>
			</ul>
		</div>
	</div>
	
	<%@ include file="/WEB-INF/jsp/include/js.jsp" %>
</body>
</html>