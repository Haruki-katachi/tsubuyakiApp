<%@page import="model.PostModel"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>
<!DOCTYPE html>
<html>
<%
	PostModel post = (PostModel)request.getAttribute("post");
	pageContext.setAttribute("title", post.getPostUserName() + "さんの投稿", PageContext.PAGE_SCOPE);
%>
<%@ include file="/WEB-INF/jsp/include/head.jsp" %>

<body>
	<%@ include file="/WEB-INF/jsp/include/navbar.jsp" %>
	<div class="container-md">
		<div class="card">
			<div class="card-body">
				<h5 class="card-title">${post.postUserName}</h5>
				<c:if test="${not empty post.toId}">
					<p class="card-text text-secondary"><a href="/tsubuyakiApp/Individual?id=<c:out value="${post.toId}"/>">この</a>投稿への返信</p>
				</c:if>
				<p class="card-text" style="white-space: pre-wrap;">${post.item}</p>
				<c:choose>
					<c:when test="${user.id == post.accountId}">
						<form action="Delete" method="get">
							<input type="hidden" name="postId" value="${post.id}">
							<button type="submit" class="btn btn-outline-danger">削除</button>
						</form>
					</c:when>
					<c:when test="${user.id != post.accountId}">
						<form action="Good" method="post">
							<input type="hidden" name="postId" value="${post.id}">
							<button type="submit" class="btn <%-- いいねしてるか否かでボタンデザインを変える --%>btn-outline-success">いいね</button>
						</form>
					</c:when>
				</c:choose>
			</div>
		</div>
		<div class="card">
			<div class="mb-3">
				<c:if test="${errors != null}">
					<c:choose>
						<c:when test="${errors.post != null}"><div class="alert alert-danger">${errors.post}</div></c:when>
						<c:when test="${errors.dbError}"><div class="alert alert-danger">${errors.dbError}</div></c:when>
					</c:choose>
				</c:if>
				<form action="Individual" method="post">
					<input type="hidden" name="accountId" value="${user.id}">
					<input type="hidden" name="toId" value="${post.id}">
					<div class="mb-3">
						<label for="reply" class="form-label">返信したい内容</label>
						<textarea rows="3" class="form-control" id="reply" name="reply">${reply}</textarea>
					</div>
					<button type="submit" class="btn btn-outline-success">返信</button>
				</form>
			</div>
		</div>
		<div class="card">
			<ul class="list-group list-group-flush">
				<c:forEach var="reply" items="${replyList}">
					<a href="/tsubuyakiApp/Individual?id=<c:out value="${reply.id}"/>" class="list-group-item">
						<div class="card-body">
							<h5 class="card-title"><c:out value="${reply.postUserName}"/></h5>
							<c:if test="${not empty reply.toId}">
								<p class="card-text text-secondary">返信</p>
							</c:if>
							<p class="card-text" style="white-space: pre-wrap;"><c:out value="${reply.item}"/></p>
						</div>
					</a>
				</c:forEach>
			</ul>
		</div>
	</div>
	
	<%@ include file="/WEB-INF/jsp/include/js.jsp" %>
	
</body>
</html>