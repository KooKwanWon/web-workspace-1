<%@ page import="servlet.model.MemberVO" %>
<%@ page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- % % :: Script Element -->
<%
	String name = request.getParameter("name");
	List<MemberVO> list = (List) request.getAttribute("list");
	MemberVO vo = (MemberVO) application.getAttribute("vo");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- %= % :: Expression Element -->
	<table border="1px">
		<% if(name!=null) {%>
			<h4>방금 전 회원님이 가입하셨습니다..</h4>
		<% } %>
		<tr>
			<td>번호</td>
			<td>이름</td>
			<td>나이</td>
			<td>주소</td>
		</tr>
		<%
		if(list!=null){
		for(int i=0; i<list.size(); i++) { %>
			<tr>
				<td> <%= i+1 %> 번째 회원 </td>		
				<td> <%= list.get(i).getName() %> </td>
				<td> <%= list.get(i).getAge() %> </td>
				<td> <%= list.get(i).getAddr() %> </td>
			</tr>
		<% } }%>
			
	</table>

</body>
</html>