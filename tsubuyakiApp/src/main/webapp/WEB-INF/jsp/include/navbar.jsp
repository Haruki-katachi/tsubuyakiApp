<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
	<div class="container-fluid">
		<a class="navbar-brand h1" href="Main">つぶやきアプリ</a>
		<button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-cotrols="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarSupportedContent">
			<ul class="navbar-nav me-auto mb-2 mb-lg-0">
				<li class="nav-item">
					<a class="nav-link" href="GoodList">いいねしたつぶやき</a>
				</li>
				<li class="nav-item">
					<a class="nav-link" href="PostList">投稿したつぶやき</a>
				</li>
			</ul>
			<span class="navbar-text">
				ようこそ、${user.name}さん
			</span>
			<a class="btn btn-outline-primary" href="Logout">ログアウト</a>
		</div>
	</div>
</nav>