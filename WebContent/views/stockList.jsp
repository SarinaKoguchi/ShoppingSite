<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:useBean id="itemBean" class="jp.co.aforce.beans.ItemBean"
	scope="session" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>管理者/商品管理</title>
<link href="<c:url value="/css/style.css" />" rel="stylesheet">
</head>
<body>
	<h1>商品管理</h1>

	<a href="/.jsp"> ようこそ <c:out value="${loginUser.name}" /> さん
	</a>

	<form method="POST" action="/ShoppingSite/logout">
		<input class="button" type="submit" value="ログアウト">
	</form>

	<h2>商品一覧</h2>

	<a href="#register">新規登録</a>


	<table border="1" align="center">
		<tr>
			<th>商品ID</th>
			<th>商品画像</th>
			<th>商品名</th>
			<th>在庫</th>
			<th>本体価格</th>
			<th></th>
			<th></th>
		</tr>
	</table>

	<c:forEach var="data" items="${items}">
		<form method="POST" action="/ShoppingSite/stock">
			<table border="1" align="center">
				<tr>
					<td><input type="text" name="item_id" size="20"
						value="${data.item_id}" readonly></td>
					<td><img
						src="${pageContext.request.contextPath}/img/${data.item_img}">
						<br> <input type="text" name="item_img" size="25"
						value="${data.item_img}" /></td>
					<td><input type="text" name="item_name" size="30"
						value="${data.item_name}" /></td>
					<td><input type="text" name="item_stock" size="3"
						value="${data.item_stock}" /></td>
					<td><input type="text" name="item_price" size="5"
						value="${data.item_price}" />円</td>
					<td><input class="button" type="submit" value="変更"
						name="submit"></td>
					<td><input class="button" type="submit" value="削除"
						name="submit"></td>
				</tr>
			</table>
		</form>
	</c:forEach>


	<h2 id="register">商品の登録</h2>

	<!-- 未入力エラーメッセージ -->
	<p>
		<c:out value="${itemBean.msg }" />
	</p>

	<form method="POST" action="/ShoppingSite/stock">
		<table align="center">
			<tr>
				<td>商品ID：</td>
				<td><input type="text" name="item_id" size="25" /></td>
			</tr>
			<tr>
				<td>商品画像パス：</td>
				<td><input type="text" name="item_img" size="25" /></td>
			</tr>
			<tr>
				<td>商品名：</td>
				<td><input type="text" name="item_name" size="25" /></td>
			</tr>
			<tr>
				<td>本体価格：</td>
				<td><input type="text" name="item_price" size="25" /></td>
			</tr>
			<tr>
				<td>在庫：</td>
				<td><input type="text" name="item_stock" size="25" /></td>
			</tr>

		</table>
		<input class="button" type="submit" value="登録" name="submit">
	</form>
</body>
</html>