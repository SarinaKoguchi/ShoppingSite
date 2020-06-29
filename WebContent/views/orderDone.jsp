<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>注文完了</title>
<link href="<c:url value="/css/itemList.css" />" rel="stylesheet">
<link href="<c:url value="/css/cart.css" />" rel="stylesheet">
</head>
<body>

	<!-- ヘッダー -->
	<jsp:include page="/viewsBeforeLogin/header.jsp" />

	<!-- 現在位置 -->
	<ul class="location">
		<li>カートの商品</li>
		<li>ご注文内容の確認</li>
		<li class="current">ご注文完了</li>
	</ul>
	<br>

	<p>ご注文ありがとうございました。</p>
	<img src="${pageContext.request.contextPath}/img/kuma_ThankYou.png" class="picture">

	<form method="POST" action="/ShoppingSite/item">
		<input class="button" type="submit" value="商品一覧に戻る" name="submit">
	</form>

</body>
</html>