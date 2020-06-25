<!-- 買い物かご -->

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:useBean id="cartBean" class="jp.co.aforce.beans.CartBean"
	scope="session" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>現在のかごの中</title>
<link href="<c:url value="/css/style.css" />" rel="stylesheet">
<link href="<c:url value="/css/cart.css" />" rel="stylesheet">
<script src="http://code.jquery.com/jquery-3.2.1.min.js"></script>
</head>
<body>
	<h1>ショッピングカート</h1>

	<!-- 現在位置 -->
	<ul>
		<li>カートの商品</li>
		<li>ご注文内容の確認</li>
		<li>ご注文完了</li>
	</ul>

	<!-- 買い物かごの中身 -->
	<table align="center">
		<tr>
			<th>商品情報</th>
			<th>数量</th>
			<th>本体価格</th>
			<th>税込価格</th>
			<th>小計</th>
		</tr>
	</table>

	<p>
		<c:out value="${cartBean.msg}" />
	</p>

	<c:forEach var="data" items="${cartItems}">
		<form method="POST" action="/ShoppingSite/deleteCart">
			<table align="center">
				<tr>
					<td><img
						src="${pageContext.request.contextPath}/img/${data.item_img}">
						<c:out value="${data.item_name}" /></td>
					<td><input type="text" name="quantity" size="2"
						value="${data.quantity}" />個</td>
					<td><c:out value="${data.item_price}" />円</td>
					<td><c:out value="${data.item_tax_price}" />円(税込)</td>
<%-- 					<td><c:out value="${data.subtotal}" />円</td> --%>
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
			<%-- 			<td colspan="4" class="cart-total">合計金額：<c:out value="${cartBean.total}" />円(税込)</td> --%>
		</tr>

	</table>

	<ul>
		<li><form method="POST" action="/ShoppingSite/item">
				<input class="button" type="submit" value="買い物を続ける" name="submit">
			</form></li>
		<li><button class="button"
				onclick="location.href='http://localhost:8090/ShoppingSite/views/orderConfirm.jsp'"
				type="button">レジに進む</button></li>
	</ul>


</body>
</html>