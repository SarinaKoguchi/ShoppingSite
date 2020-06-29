<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:useBean id="itemBean" class="jp.co.aforce.beans.ItemBean"
	scope="request" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>検索結果</title>
<link href="<c:url value="/css/itemList.css" />" rel="stylesheet">
</head>
<body>

	<!-- ヘッダー -->
	<jsp:include page="/viewsBeforeLogin/header.jsp" />

	<h1>検索結果</h1>
	<p>
		【
		<c:out value="${itemBean.search}" />
		】の検索結果
	</p>

	<form method="POST" action="/ShoppingSite/item">
		<input class="button" type="submit" value="全商品を表示する" name="submit">
	</form>

	<!-- ソート機能 -->
	<!-- 	<form method="GET" action="/ShoppingSite/search"> -->
	<!-- 		<input type="radio" name="sort" value="1" -->
	<%-- 			<c:if test="${sort == '1'}"> checked="checked"</c:if> />価格が高い順 <input --%>
	<!-- 			type="radio" name="sort" value="2" -->
	<%-- 			<c:if test="${sort == '2'}"> checked="checked"</c:if> />価格が低い順 <input --%>
	<!-- 			type="radio" name="sort" value="3" -->
	<%-- 			<c:if test="${sort == '3'}"> checked="checked"</c:if> />名前(昇順) <input --%>
	<!-- 			type="radio" name="sort" value="4" -->
	<%-- 			<c:if test="${sort == '4'}"> checked="checked"</c:if> />名前(降順) <input --%>
	<!-- 			class="button" type="submit" value="実行"> -->
	<!-- 	</form> -->

	<c:forEach var="data" items="${searchItems}">
		<ul id="itemList">
			<li>
				<form method="POST" action="/ShoppingSite/item">
					<p>
						<img src="${pageContext.request.contextPath}/img/${data.item_img}">
					</p>
					<p>
						<c:out value="${data.item_name}" />
					</p>
					<p>
						<c:out value="${data.item_price}" />
						円
					</p>
					<p>
						<c:out value="${data.item_id}" />
					</p>
					<p>
						数量:<select name="quantity">
							<option value="1">1</option>
							<option value="2">2</option>
							<option value="3">3</option>
						</select> <input class="button" type="submit" name="submit" value="カートに入れる">
					</p>
				</form>
			</li>
		</ul>
	</c:forEach>


</body>
</html>