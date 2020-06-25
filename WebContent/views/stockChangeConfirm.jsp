<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:useBean id="itemBean" class="jp.co.aforce.beans.ItemBean"
	scope="request" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>管理者/在庫変更確認</title>
<link href="<c:url value="/css/style.css" />" rel="stylesheet">
</head>
<body>

	<h1>在庫変更確認画面</h1>

	<p>(登録、変更、削除)対象商品</p>

	<form method="POST" action="/ShoppingSite/item">
		<table border="1" align="center">
			<tr>
				<th>商品ID</th>
				<th>商品画像</th>
				<th>商品名</th>
				<th>在庫</th>
				<th>本体価格</th>
			</tr>

			<!-- TODO　リストだけど繰り返さない処理にする -->
			<c:forEach var="data" items="${items}">
				<tr>
					<td><c:out value="${data.item_id}" /></td>
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
				</tr>
			</c:forEach>
		</table>
	</form>

	<p>上記の商品を(登録、変更、削除)してよろしいですか？</p>
	<input class="button" type="submit" value="登録" name="add">
	<form method="POST" action="/ShoppingSite/item">
		<input class="button" type="submit" value="一覧に戻る" name="submit">
	</form>





</body>
</html>