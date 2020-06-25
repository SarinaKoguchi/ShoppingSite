<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>注文完了</title>
<link href="<c:url value="/css/style.css" />" rel="stylesheet">
<link href="<c:url value="/css/cart.css" />" rel="stylesheet">
</head>
<body>
	<!-- 現在位置 -->
	<ul>
		<li>カートの商品</li>
		<li>ご注文内容の確認</li>
		<li>ご注文完了</li>
	</ul>
	<br>

	<p>ご注文ありがとうございました。</p>

	<form method="POST" action="/ShoppingSite/item">
		<input class="button" type="submit" value="商品一覧に戻る" name="submit">
	</form>

</body>
</html>