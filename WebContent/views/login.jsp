<!-- ログイン画面 -->

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:useBean id="loginBean" class="jp.co.aforce.beans.LoginBean"
	scope="request" />

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="<c:url value="/css/style.css" />" rel="stylesheet">
<link href="<c:url value="/css/login.css" />" rel="stylesheet">
<title>ログイン画面</title>
</head>
<body>
	<div class="form">
		<h1>LOGIN FORM</h1>

		<p>メールアドレスとパスワードを入力してください。</p>

		<!-- エラーメッセージ -->
		<div class="emsg">
			<c:out value="${loginBean.emsg}" />
		</div>

		<!-- 入力フォーム -->
		<form method="POST" action="/ShoppingSite/login">
			<table align="center">
				<tr>
					<td class="text">Mail :</td>
					<td><input type="email" name="mail"></td>
				</tr>
				<tr>
					<td class="text">Password :</td>
					<td><input type="password" name="password"></td>
				</tr>
				<tr>
					<td><button class="button"
							onclick="location.href='http://localhost:8090/ShoppingSite/views/index.html'"
							type="button">戻る</button></td>
					<td><input class="button" type="submit" value="ログイン" ></td>
				</tr>
			</table>
		</form>

		<p>
			<a href="">forget password?</a>
		</p>
		<p>
			<a href="signUp.jsp">create an account</a>
		</p>
	</div>

</body>
</html>