<!-- 買い物かご -->

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	int total = (int) session.getAttribute("total");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>現在のかごの中</title>
<link href="<c:url value="/css/cart.css" />" rel="stylesheet">
<link href="<c:url value="/css/itemList.css" />" rel="stylesheet">
<script src="http://code.jquery.com/jquery-3.2.1.min.js"></script>
</head>
<body>

	<!-- ヘッダー -->
	<jsp:include page="/viewsBeforeLogin/header.jsp" />

	<h2>ショッピングカート</h2>

	<!-- 現在位置 -->
	<ul class="location">
		<li class="current">カートの商品</li>
		<li>ご注文内容の確認</li>
		<li>ご注文完了</li>
	</ul>

	<br>

	<!-- 買い物かごの中身 -->
	<table align="center">
		<tr>
			<th>商品情報</th>
			<th>数量</th>
			<th>本体価格</th>
			<th>小計</th>
			<th colspan="2"></th>
		</tr>
	</table>

	<p>
		<c:out value="${cartBean.msg}" />
	</p>

	<c:forEach var="data" items="${cartItems}">
		<form method="POST" action="/ShoppingSite/updateCart">
			<input type="hidden" name="item_id" value="${data.item_id}">
			<table align="center">
				<tr>
					<td><img
						src="${pageContext.request.contextPath}/img/${data.item_img}" class="itemImg"><br>
						<c:out value="${data.item_name}" /></td>
					<td><input type="text" name="quantity" size="2"
						value="${data.quantity}" />個</td>
					<td><c:out value="${data.item_tax_price}" />円(税込)</td>
					<td><c:out value="${data.subtotal}" />円(税込)</td>
					<td><input class="button" type="submit" value="変更"
						name="submit"></td>
					<td><input class="button" type="submit" value="削除"
						name="submit"></td>
				</tr>
			</table>
		</form>
	</c:forEach>

	<c:if test="${!empty cartItems}">
		<table align="right" class="total">
			<tr class="cart-total">
				<td colspan="4">合計金額：</td>
				<td><%=total%>円(税込)</td>
			</tr>
		</table>
	</c:if>

	<br>
	<ul>
		<li><form method="POST" action="/ShoppingSite/item">
				<input class="button" type="submit" value="買い物を続ける" name="submit">
			</form></li>

		<!-- カートの中身があるとき、ボタンを表示 -->
		<c:if test="${!empty cartItems}">
			<li><form method="POST" action="/ShoppingSite/updateCart">
					<input class="button" type="submit" value="カートの中身を空にする"
						name="submit">
				</form></li>
			<li><button class="button"
					onclick="location.href='http://localhost:8090/ShoppingSite/views/orderConfirm.jsp'"
					type="button">レジに進む</button></li>
		</c:if>
	</ul>


</body>
</html>