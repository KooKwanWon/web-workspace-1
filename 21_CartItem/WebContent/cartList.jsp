<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.7.0.min.js"></script>
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
	<table border="1">
	<thead>
	<tr>
	<th>번호</th>
	<th>상품이미지</th>
	<th>상품명</th>
	<th>상품가격</th>
	<th>수량</th>
	<th><button onclick="deleteStorage()">삭제</button></th>
	</tr>
	</thead>
	<tbody>
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
	</tbody>
	<tfoot>
	<tr>
	<td colspan="6">총 결제금액 : <span id="resultTotal"></span></td>
	</tr>
	</tfoot>
	</table>
	</div>
	
	<script>
	function refreshPage(){
		for(let key in localStorage) {
			console.log(key);
		}
	}
	</script>
</body>
</html>