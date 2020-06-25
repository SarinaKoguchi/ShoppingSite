<!-- 注文確認画面 -->

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:useBean id="loginBean" class="jp.co.aforce.beans.LoginBean"
	scope="request" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>注文確認</title>
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

	<p>買い物かごには、以下の商品が入っています。</p>
	<table align="center">
		<tr>
			<th>商品情報</th>
			<th>数量</th>
			<th>小計(税込)</th>
		</tr>
	</table>

	<c:forEach var="data" items="${cartItems}">
		<form method="POST" action="/ShoppingSite/buyItems">
			<table>
				<tr>
					<td><img
						src="${pageContext.request.contextPath}/img/${data.item_img}">
						<c:out value="${data.item_name}" /></td>
					<td><input type="text" name="quantity" size="2"
						value="${data.quantity}" />個</td>
					<td><c:out value="${data.item_price}" />円</td>
					<%-- 				<td><c:out value="${data.item_tax_price}" />円(税込)</td> --%>
					<td><c:out value="${data.subtotal}" />円</td>
					<td><input class="button" type="submit" value="変更"
						name="submit"></td>
					<td><input class="button" type="submit" value="削除"
						name="submit"></td>
				</tr>
			</table>
		</form>
	</c:forEach>
	<table>
	 <tr>
			<td colspan="3">消費税： ○○円</td>
		</tr>
		<tr>
			<td colspan="3">商品合計(税込)： ○○円</td>
		</tr>
	</table>

	<div>
		<p>送付先</p>

		<p>お支払方法</p>
		<select name="payment">
			<option value=""></option>
			<option value="現金">現金</option>
			<option value="クレジットカード">クレジットカード</option>
		</select>
	</div>

	<br>
	<button class="button"
		onclick="location.href='http://localhost:8090/ShoppingSite/views/cart.jsp'"
		type="button">カートに戻る</button>
	<button class="button"
		onclick="location.href='http://localhost:8090/ShoppingSite/views/orderDone.jsp'"
		type="button">注文を確定する</button>
</body>
</html>