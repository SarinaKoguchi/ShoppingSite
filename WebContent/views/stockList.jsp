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
<link href="<c:url value="/css/itemList.css" />" rel="stylesheet">
</head>
<body>

	<h1>商品管理</h1>

	<p>
		現在のユーザ名： <a href="/.jsp"> <c:out value="${loginUser.name}" /></a>
	</p>

	<form method="POST" action="/ShoppingSite/logout">
		<input class="button" type="submit" value="ログアウト">
	</form>

	<h2>商品一覧</h2>

	<a href="#register">新規登録</a>


	<table border="1" align="center">
		<tr>
			<th class="id">商品ID</th>
			<th class="img">商品画像(パス)</th>
			<th class="name">商品名</th>
			<th>在庫</th>
			<th>本体価格</th>
			<th class="btn">変更</th>
			<th class="btn">削除</th>
		</tr>
	</table>

	<c:forEach var="data" items="${items}">
		<form method="POST" action="/ShoppingSite/stock">
			<table border="1" align="center">
				<tr>
					<td class="id"><c:out value="${data.item_id}" /> <input
						type="hidden" name="item_id" value="${data.item_id}"></td>
					<td class="img"><img
						src="${pageContext.request.contextPath}/img/${data.item_img}"><br>
						<input type="text" name="item_img" size="30"
						value="${data.item_img}" /></td>
					<td class="name"><input type="text" name="item_name" size="30"
						value="${data.item_name}" /></td>
					<td><input type="text" name="item_stock" size="1"
						value="${data.item_stock}" />個</td>
					<td><input type="text" name="item_price" size="3"
						value="${data.item_price}" />円</td>
					<td class="btn"><input class="button" type="submit" value="変更"
						name="submit"></td>
					<td class="btn"><input class="button" type="submit" value="削除"
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
		<table align="center" class="register">
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