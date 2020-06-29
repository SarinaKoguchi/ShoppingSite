<!-- 登録確認画面 -->

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:useBean id="itemBean" class="jp.co.aforce.beans.ItemBean"
	scope="request" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>管理者/商品登録確認</title>
<link href="<c:url value="/css/style.css" />" rel="stylesheet">
</head>
<body>

	<h1>商品情報の登録</h1>

	<p>下記の商品情報を登録します。</p>
	<p>
		<c:out value="${itemBean.msg }" />
	</p>
	<form method="POST" action="/ShoppingSite/stockRegister">
		<table align="center">
			<tr>
				<td>商品ID：</td>
				<td><input type="text" name="item_id" size="25"
					value="${stockItem.item_id}" readonly /></td>
			</tr>
			<tr>
				<td>商品画像パス：</td>
				<td><input type="text" name="item_img" size="25"
					value="${stockItem.item_img}" readonly /></td>
			</tr>
			<tr>
				<td>商品名：</td>
				<td><input type="text" name="item_name" size="25"
					value="${stockItem.item_name}" readonly /></td>
			</tr>
			<tr>
				<td>本体価格：</td>
				<td><input type="text" name="item_price" size="25"
					value="${stockItem.item_price_string}" readonly /></td>
			</tr>
			<tr>
				<td>在庫：</td>
				<td><input type="text" name="item_stock" size="25"
					value="${stockItem.item_stock_string}" readonly /></td>
			</tr>
		</table>
		<p>
			<input class="button" type="submit" value="戻る" name="submit">
			<input class="button" type="submit" value="登録" name="submit">
		</p>
	</form>

</body>
</html>