<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:useBean id="itemBean" class="jp.co.aforce.beans.ItemBean"
	scope="session" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>商品一覧</title>
<link href="<c:url value="/css/style.css" />" rel="stylesheet">
<link href="<c:url value="/css/itemList.css" />" rel="stylesheet">
</head>
<body>
	<!-- スクロールナビ -->
	<a href="/.jsp"> ようこそ <c:out value="${loginUser.name}" /> さん
	</a>
	<form method="POST" action="/ShoppingSite/logout">
		<input class="button" type="submit" value="ログアウト">
	</form>

	<!-- 検索機能 -->
	<form method="GET" action="/ShoppingSite/search">
		<input type="text" size="40" name="search"
			placeholder="商品IDまたは商品名を入力してください"> <input class="button"
			type="submit" value="検索">
		<p>
			<c:out value="${itemBean.msg}" />
		</p>
	</form>

	<form method="POST" action="/ShoppingSite/displayCart">
		<input type="hidden" name="member_name" value="${loginUser.name}">
		<button type="submit" class="cart"><img src="${pageContext.request.contextPath}/img/cart.png" alt="カート" /></button>
	</form>

	<a href="">カテゴリ</a>
	<a href="">ぬいぐるみ</a>
	<a href="">雑貨</a>
	<a href=""></a>
	<a href=""></a>

	<hr>

	<!-- 商品一覧 -->
	<h1>商品一覧</h1>

	<!-- ソート機能 -->
	<ul class="sort">
		<li><button class="sort_btn_expensive">価格が高い順</button></li>
		<li>価格が低い順</li>
		<li>名前(昇順)</li>
		<li>名前(降順)</li>
	</ul>

	<p>
		<c:out value="${cartBean.msg}" />
	</p>
	<ul id="itemList">
		<c:forEach var="data" items="${items}">
			<li class="item">
				<form method="POST" action="/ShoppingSite/addCart">
					<input type="hidden" name="item_id" value="${data.item_id}">
					<p>
						<img src="${pageContext.request.contextPath}/img/${data.item_img}">
					</p>
					<p>
						<c:out value="${data.item_name}" />
					</p>
					<p>
						<c:out value="${data.item_price}" />
						円
					</p>
					<p>
						<c:out value="${data.item_id}" />
					</p>
					<p>
						数量:<select name="quantity">
							<option value="1">1</option>
							<option value="2">2</option>
							<option value="3">3</option>
						</select> <input class="button" type="submit" value="カートに入れる">
					</p>
				</form>
			</li>
		</c:forEach>
	</ul>

	<script type="text/javascript" src="/js/sort.js"></script>
</body>
</html>