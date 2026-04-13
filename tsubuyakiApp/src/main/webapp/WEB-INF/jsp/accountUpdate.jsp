<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<%
	pageContext.setAttribute("title", "アカウント情報修正", PageContext.PAGE_SCOPE);
%>
<%@ include file="/WEB-INF/jsp/include/head.jsp" %>
<body>
	<%@ include file="/WEB-INF/jsp/include/navbar.jsp" %>
	<div class="container-md">
		<div class="row">
			<div class="col-md-3"></div>
			<div class="col-md-6" >
				<div class="card my-3">
					<div class="card-header"><c:out value="${title}"/></div>
					<div class="card-body">
						<c:if test="${db_error != null}">
							<div class="alert alert-danger"><c:out value="${db_error}"/></div>
						</c:if>
						<form action="AccountUpdate" method="post">
							<div class="mb-3">
								<label for="email" class="form-label">E-mailアドレス</label>
								<input type="text"
									name="email" id="email"
									class="form-control<c:if test="${errors.email!=null}"> is-invalid</c:if>"
									value="<c:out value="${user.email}"/>">
								<div class="invalid-feedback"><c:out value="${errors.email}"/></div>
							</div>
							<div class="mb-3">
								<label for="password" class="form-label">パスワード</label>
								<input type="password"
									name="password" id="password"
									class="form-control<c:if test="${errors.password!=null}"> is-invalid</c:if>"
									value="<c:out value="${user.password}"/>">
								<div class="invalid-feedback"><c:out value="${errors.password}"/></div>
							</div>
							<div class="mb-3">
								<label for="name" class="form-label">ニックネーム</label>
								<input type="text"
									name="name" id="name"
									class="form-control<c:if test="${errors.name!=null}"> is-invalid</c:if>"
									value="<c:out value="${user.name}"/>">
								<div class="invalid-feedback"><c:out value="${errors.name}"/></div>
							</div>
							<button type="submit" class="btn btn-outline-success">更新</button>
						</form>
					</div>
				</div>
			</div>
			<div class="col-md-3"></div>
		</div>
	</div>
	<%@ include file="/WEB-INF/jsp/include/js.jsp" %>
</body>
</html>