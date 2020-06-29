<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="<c:url value="/css/style.css" />" rel="stylesheet">
<link href="<c:url value="/css/header.css" />" rel="stylesheet">
</head>
<body>
	<header>
		<hr class="upper">
		<p>
			<img src="${pageContext.request.contextPath}/img/kuma.png"
				class="icon"> 自分ツッコミくま オンラインショップ <img
				src="${pageContext.request.contextPath}/img/kuma.png" class="icon">
		<p>
			<c:if test="${!empty loginUser}">
				<form method="POST" action="/ShoppingSite/logout" class="user">
					ようこそ <a href="/.jsp"> <c:out value="${loginUser.name}" />
					</a> さん <input class="button" type="submit" value="ログアウト">
				</form>

				<!-- 検索機能 -->
				<form method="GET" action="/ShoppingSite/search" class="search">
					<input type="text" size="40" name="search"
						placeholder="商品IDまたは商品名を入力してください"> <input class="button"
						type="submit" value="検索">
					<c:out value="${itemBean.msg}" />
				</form>

				<form method="POST" action="/ShoppingSite/displayCart" class="cart">
					<button type="submit" class="cartImg">
						<img src="${pageContext.request.contextPath}/img/cart.png"
							alt="カート" />
					</button>
				</form>
			</c:if>
		<hr>
	</header>
</body>
</html>