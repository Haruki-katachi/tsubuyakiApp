<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>
<!DOCTYPE html>
<html>
<%
	pageContext.setAttribute("title", "アカウント登録", PageContext.PAGE_SCOPE);
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
						<c:if test="${db_error != null}">
							<div class="alert alert-danger">${db_error}</div>
						</c:if>
						<form action="AccountRegister" method="post">
							<div class="mb-3">
								<label for="email" class="form-label">E-mailアドレス</label>
								<input type="text"
									name="email" id="email"
									class='form-control<c:if test="${errors.email != null}"> is-invalid</c:if>'
									value="${user.email}">
								<div id="email" class="invalid-feedback">${errors.email}</div>
							</div>
							<div class="mb-3">
								<label for="password" class="form-label">パスワード</label>
								<input type="password"
									name="password" id="password"
									class="form-control<c:if test='${errors.password != null}'> is-invalid</c:if>"
									value="${user.password}">
								<div id="password" class="invalid-feedback">${errors.password}</div>
							</div>
							<div class="mb-3">
								<label for="name" class="form-label">ニックネーム</label>
								<input type="text"
									name="name" id="name"
									class="form-control<c:if test='${errors.name != null}'> is-invalid</c:if>"
									value="${user.name}">
								<div id="name" class="invalid-feedback">${errors.name}</div>
							</div>
							<button type="submit" class="btn btn-outline-success">登録</button>
						</form>
					</div>
				</div>
				<a href="Login">ログインページへ</a>
			</div>
		</div>
	</div>
</body>
</html>