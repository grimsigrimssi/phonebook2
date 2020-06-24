<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="com.javaex.dao.PhoneDao" %>    

<%@ page import="com.javaex.vo.PersonVo" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<p>
		전화번호를 수정하려면<br>
		수정하고 "수정" 버튼을 클릭하세요.
	</p>
	 	<form action="/pb2/pbc?action=update" method="get">
		이름(name): <input type="text" name="name" value=""> <br>
		핸드폰(hp): <input type="text" name="hp" value=""> <br>
		회사(company): <input type="text" name="company" value=""> <br>
		<input type="hidden" name="action" value="update">	
		
		<button type="submit">수정</button>
		</form>
</body>
</html>