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

<!-- CSS -->
<link href="<c:url value="/css/itemList.css" />" rel="stylesheet">

<!-- JavaScript -->
<script type="text/javascript"
	src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script type="text/javascript" src="js/script.js"></script>

<!-- 画像ポップアップ -->
<link rel="stylesheet" href="css/lightbox.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/2.0.0/jquery.min.js"></script>
<script src="js/lightbox.min.js"></script>

</head>
<body>
	<!-- ヘッダー -->
	<jsp:include page="/viewsBeforeLogin/header.jsp" />

	<!-- 商品一覧 -->
	<h1>商品一覧</h1>

	<!-- ソート機能 -->
	<form method="POST" action="/ShoppingSite/item">
		<input type="radio" name="sort" value="1"
			<c:if test="${sort == '1'}"> checked="checked"</c:if> />商品ID(昇順) <input
			type="radio" name="sort" value="2"
			<c:if test="${sort == '2'}"> checked="checked"</c:if> />商品ID(降順) <input
			type="radio" name="sort" value="3"
			<c:if test="${sort == '3'}"> checked="checked"</c:if> />価格が高い順 <input
			type="radio" name="sort" value="4"
			<c:if test="${sort == '4'}"> checked="checked"</c:if> />価格が低い順 <input
			type="radio" name="sort" value="5"
			<c:if test="${sort == '5'}"> checked="checked"</c:if> />名前(昇順) <input
			type="radio" name="sort" value="6"
			<c:if test="${sort == '6'}"> checked="checked"</c:if> />名前(降順) <input
			class="button" type="submit" value="ならびかえ">
	</form>

	<p>
		カテゴリ <a href="">ぬいぐるみ</a> <a href="">雑貨</a> <a href="">ファッション</a>
	</p>

	<br>

	<p>
		<c:out value="${cartBean.msg}" />
	</p>


	<ul id="itemList">
		<c:forEach var="data" items="${items}">
			<li>
				<form method="POST" action="/ShoppingSite/addCart">
					<input type="hidden" name="item_id" value="${data.item_id}">
					<p>
						<a href="${pageContext.request.contextPath}/img/${data.item_img}"
							data-lightbox="demo"> <img
							src="${pageContext.request.contextPath}/img/${data.item_img}"></a>
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

	<!-- ページトップへ戻るボタン -->
	<div class="pagetop">▲</div>

	<script type="text/javascript" src="/js/sort.js"></script>
	<script src="js/lightbox.min.js"></script>
</body>
</html>