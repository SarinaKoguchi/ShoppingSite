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
	<h3>ご注文商品</h3>

	<table align="center">
		<tr>
			<th>商品情報</th>
			<th>数量</th>
			<th>本体価格</th>
			<th>税込価格</th>
			<th>小計</th>
		</tr>
	</table>

	<form method="POST" action="/ShoppingSite/buyItems">
		<c:forEach var="data" items="${cartItems}">
			<table align="center">
				<tr>
					<td><img
						src="${pageContext.request.contextPath}/img/${data.item_img}">
						<c:out value="${data.item_name}" /></td>
					<td><c:out value="${data.quantity}" />個</td>
					<td><c:out value="${data.item_price}" />円</td>
					<td><c:out value="${data.item_tax_price}" />円(税込)</td>
					<td><c:out value="${data.subtotal}" />円</td>
				</tr>
			</table>

		</c:forEach>
		<table align="right">
			<tr class="cart-total">
				<td>消費税合計：</td>
				<td><c:out value="${cartBean.tax_total}" />円</td>
			</tr>

			<tr class="cart-total">
				<td>合計金額：</td>
				<td><c:out value="${cartBean.total}" />円(税込)</td>
			</tr>

		</table>

		<br>
		<div>
			<h3>送付先</h3>
			<p>名前：</p>
			<p>住所：</p>

			<h3>お支払方法</h3>
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
		<input class="button" type="submit" value="注文を確定する" name="submit">

	</form>
</body>
</html>