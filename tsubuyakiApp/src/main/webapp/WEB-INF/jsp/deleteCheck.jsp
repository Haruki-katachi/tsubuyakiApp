<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>
<!DOCTYPE html>
<html>
<%
	pageContext.setAttribute("title", "削除確認");
%>
<%@ include file="/WEB-INF/jsp/include/head.jsp" %>
<body>
	<%@ include file="/WEB-INF/jsp/include/navbar.jsp" %>
	<div class="container-md">
		<div class="row">
			<div class="col-md-3"></div>
			<div class="col-md-6">
				<div class="card text-center">
					<h5 class="card-header">${title}</h5>
					<div class="card-body">
						<p class="card-text">削除しますか？</p>
						<form action="PostDelete" method="post">
							<input type="hidden" name="postId" value="<c:out value="${post.id}"/>">
							<button type="submit" class="btn btn-outline-danger mb-3">削除</button>
						</form>
						<a href="/tsubuyakiApp/Individual?id=<c:out value="${post.id}"/>">戻る</a>
					</div>
				</div>
			</div>
			<div class="col-md-3"></div>
		</div>
	</div>
	<%@ include file="/WEB-INF/jsp/include/js.jsp" %>
</body>
</html>