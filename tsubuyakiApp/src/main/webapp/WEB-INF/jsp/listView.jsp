<%@page import="model.AccountModel"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>
<!DOCTYPE html>
<html>
<%
	AccountModel user = (AccountModel)session.getAttribute("user");
	String listType = (String)request.getAttribute("listType");
	pageContext.setAttribute("title", user.getName() + "さんの" + listType, PageContext.PAGE_SCOPE);
%>
<%@ include file="/WEB-INF/jsp/include/head.jsp" %>
<body>
	<%@ include file="/WEB-INF/jsp/include/navbar.jsp" %>
	<div class="container-md">
		<div class="card">
			<h4 class="card-header"><c:out value="${title}"/></h4>
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