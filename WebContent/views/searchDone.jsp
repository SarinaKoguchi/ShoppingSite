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
<link href="<c:url value="/css/style.css" />" rel="stylesheet">
<link href="<c:url value="/css/itemList.css" />" rel="stylesheet">
</head>
<body>
	<h1>検索結果</h1>
	<p>【<c:out value="${itemBean.search}" />】の検索結果</p>

	<p>
		<c:out value="${itemBean.msg}" />
	</p>


	<!-- ソート機能 -->
	<ul class="sort">
		<li><a href="">価格が高い順</a></li>
		<li><a href="">価格が低い順</a></li>
	</ul>

	<c:forEach var="data" items="${searchItems}">
		<ul>
			<li class="item">
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