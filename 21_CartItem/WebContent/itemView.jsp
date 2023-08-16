<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	#index{text-align : center}

	
</style>

</head>
<body>
	<div>조회수 : </div>
	<table>
	<tr>
	<td>
	<h1 id="index">${list[val].itemName}의 정보</h1>
	<img src="${list[val].pictureUrl}" width="500px" height="300px">
	</td>
	<td>
		<br>
		종류 : ${list[val].itemName}<br><br>
		가격 : ${list[val].price}<br><br>
		설명 : ${list[val].description}
	</td>
	</tr>
	</table>
</body>
</html>