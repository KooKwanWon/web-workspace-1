<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<Style>
h1{text-align: center}
#shop{text-align: right}

#tb1{
	display : flex;
	align-items: center;
	flex-direction: column;
	}


</Style>
<body>
	<h1>장바구니</h1>
	<div id="shop">
	<a href="itemList.do">쇼핑 계속하기</a>
	</div>
	<div id="tb1">
	<table border="1px">
	<tr>
	<td>번호</td>
	<td>상품이미지</td>
	<td>상품명</td>
	<td>상품가격</td>
	<td>수량</td>
	<td><button>삭제</button></td>
	</tr>
	<c:forEach items="${list}" var = "item">
			<tr>
			<td>${item.itemId}</td>
			<td><img src="${item.pictureUrl}" width="120px" height="96px"></td>
			<td>${item.itemName}</td>
			<td>${item.price}</td>
			<td></td>
			<td><input type ="radio" name = "fruit" value =""></td>
			</tr>
	</c:forEach>
	<tr>
	<td colspan="6">총 결제금액 : </td>
	</tr>
	</table>
	</div>
</body>
</html>