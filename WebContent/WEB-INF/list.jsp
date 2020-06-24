<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="java.util.List" %>
<%@ page import="com.javaex.vo.PersonVo" %>
    
<%
	List<PersonVo> pList = (List<PersonVo>)request.getAttribute("personList"); //request.getAttribute를 형변환
%>
    

    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>

	<body>
		<h1>전화번호 리스트</h1>
		<p>입력한 정보 내역 입니다.</p>
		<br>
		<% for(PersonVo vo : pList) {%>
		
		<table border="1">
			<colgroup>
				<col style ="width:30px;">
				<col style ="width:90px;">
				<col style ="width:80px;">
				<col style ="width:80px;">
			</colgroup>	
			<tbody>
				<tr>
				<td colspan="2"></td>		
				<td><a href="/pb2/pbc?action=updateForm">수정</a></td>
				<td><a href="/pb2/pbc?action=delete&pId=<%=vo.getPersonId() %>">삭제</a></td>
				</tr>
				<tr>
			 	<td colspan="2">이름(name)</td>
			 	<td colspan="2"><%= vo.getName() %></td>
			 	</tr>
			 	<tr>
			 	<td colspan="2">핸드폰(hp)</td>
			 	<td colspan="2"><%= vo.getHp() %></td>
			 	</tr>
			 	<tr>
			 	<td colspan="2">회사(company)</td>
			 	<td colspan="2"><%= vo.getCompany() %></td>
			 	</tr>		 	
			 </tbody>
		</table>
		<br>
		<% } %>
		<p>
			<a href="/pb2/pbc?action=wForm">추가번호 등록</a>
		</p>
		

</body>
</html>