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
					<div class="alert alert-danger">${errors}</div>
				</c:if>
				<form action="Main" method="post">
					<input type="hidden" name="accountId" value="${user.id}">
					<label for="post" class="form-label">投稿したい内容</label>
					<textarea class="form-control mb-1" id="item" name="post" rows="3"></textarea>
					<button type="submit" class="btn btn-outline-success">投稿</button>
				</form>
			</div>
		</div>
		<div class="card">
			<ul>
				<c:forEach var="post" items="${postList}">
						<div class="card-body">
							<h5 class="card-title"><c:out value="${post.postUserName}"/></h5>
							<c:if test="${not empty toId}">
							<p class="card-text"><a href="#">この</a>投稿への返信<p>
							</c:if>
							<p class="card-text"><c:out value="${post.item}"/></p>
							<a href="/Individual&id=<c:out value="${post.id}"/>">詳細表示</a>
						</div>
				</c:forEach>
			</ul>
		</div>
	</div>
	
	<%@ include file="/WEB-INF/jsp/include/js.jsp" %>
</body>
</html>