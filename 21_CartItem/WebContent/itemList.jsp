<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	body{
	display : flex;
	align-items: center;
	flex-direction: column;
	}
	#index{text-align : center}

	
</style>
</head>
<body>
	<h1 id="index">Fruit Total List</h1>
	<br>
	<table id="tb1" width="800px">
		<tr id="picture">
			<td><a href="itemView.do?val=0"><img src="${list[0].pictureUrl}" width="150px" height="120px"></a></td>
			<td><a href="itemView.do?val=1"><img src="${list[1].pictureUrl}" width="150px" height="120px"></a></td>
			<td><a href="itemView.do?val=2"><img src="${list[2].pictureUrl}" width="150px" height="120px"></a></td>
			<td><a href="itemView.do?val=3"><img src="${list[3].pictureUrl}" width="150px" height="120px"></a></td>
			<td><a href="itemView.do?val=4"><img src="${list[4].pictureUrl}" width="150px" height="120px"></a></td>
		</tr>
		<tr>
		<c:forEach items="${list}" var = "item">
			<td>상품명 : ${item.itemName}</td>
		</c:forEach>
		</tr>
		<tr>
		<c:forEach items="${list}" var = "item">
			<td>가격 : ${item.price}원</td>
		</c:forEach>
		</tr>
	</table>
	<br><br>
	<hr width="90%" align="center">
	<h2 id="index">오늘 본 상품들</h2>
	<table width="300px">
	<tr>
	<c:forEach items="${list2}" var = "item2">
			<td><img src="${item2.pictureUrl}" width="120px" height="96px"></td>
	</c:forEach>
	</tr>
	</table>
</body>
<script>

</script>
</html>