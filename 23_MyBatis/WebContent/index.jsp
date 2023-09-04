<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.7.0.min.js"></script>
</head>
<body>
	
	<form action="find.do" method="post">
		<input type="text" name="word" id="word" /> 
		<input type="submit" value="검색" id="submit">
	</form>
	
	
	<p id="allprint"></p>
	
	
	
	
	
	<!-- href="allprint.do?value=allprint" -->
	<script>
		$(document).ready(function(){
			$.ajax({
				type: 'post',
				url: 'JustPrint',
				data: 'word=',
				dataType: 'json',
								
				success: function(data){
					console.log(data);
					$.each(data, function(index, item) {
						
						$("#allprint").append(JSON.parse(item) + " ");
						$("#allprint").append(item.StudentVO + " ");
						$("#allprint").append(item.student_Address + " ");
						$("#allprint").append(item.department + "<br>");
					});
				}
				
				
			})
		});
	</script>
	
	
</body>
</html>