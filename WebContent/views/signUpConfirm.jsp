<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>新規登録</title>
<link href="<c:url value="/css/style.css" />" rel="stylesheet">
</head>
<body>
	<p>下記のユーザーを登録します</p>
	<p>
		Name：
		<c:out value="${signUpBean.name}" />
	</p>
	<p>
		Mail：
		<c:out value="${signUpBean.mail}" />
	</p>
	<p>
		Password:
		<c:out value="${signUpBean.password}" />
	</p>
	<p>
		Age：
		<c:out value="${signUpBean.age}" />
	</p>
	<p>
		Address：
		<c:out value="${signUpBean.address}" />
	</p>
	<p>
		Birthday：
		<c:out value="${signUpBean.birth_year}" />
		年
		<c:out value="${signUpBean.birth_month}" />
		月
		<c:out value="${signUpBean.birth_day}" />
		日
	</p>

	<button
		onclick="location.href='http://localhost:8090/ShoppingSite/views/signUp.jsp'"
		type="button">入力フォームへ戻る</button>
	<a href="">登録</a>

</body>
</html>