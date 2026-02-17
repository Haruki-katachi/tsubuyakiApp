<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>
<!DOCTYPE html>
<html>

<%
	pageContext.setAttribute("title", "ログイン", PageContext.PAGE_SCOPE);
%>

<%@ include file="/WEB-INF/jsp/include/head.jsp" %>

<body>
	<nav class="navbar navbar-light bg-light">
		<div class="container-fluid">
			<span class="navbar-brand h1">つぶやきアプリ</span>
		</div>
	</nav>
	<div class="container-md">
		<div class="row">
			<div class="col-md-3"></div>
			<div class="col-md-6">
				<div class="card my-3">
					<div class="card-header">${title}</div>
					<div class="card-body">
						<c:if test="${error != null}">
							<div class="alert alert-danger" role="alert">${error}</div>
						</c:if>
						<c:if test="${success != null}">
							<div class="alert alert-success" role="alert">${success}</div>
						</c:if>
						<form action="Login" method="post">
							<div class="mb-3">
								<label for="email" class="form-label">E-mailアドレス</label>
								<input type="text"
									name="email" id="email" class="form-control"
									value='<c:out value="${user.email}"/>'>
							</div>
							<div class="mb-3">
								<label for="password" class="form-label">パスワード</label>
								<input type="password"
									name="password" id="password" class="form-control"
									value='<c:out value="${user.password}"/>'>
							</div>
							<button type="submit" class="btn btn-outline-success">ログイン</button>
						</form>
					</div>
				</div>
				<a href="AccountRegister">会員登録へ</a>
			</div>
			<div class="col-md-6"></div>
		</div>
	</div>
	
	<%@ include file="/WEB-INF/jsp/include/js.jsp" %>
	
</body>
</html>