<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="net.sungjuk.*" %>    
<%@ page import="java.util.ArrayList"%>
    
<jsp:useBean id="dao" class="net.sungjuk.SungjukDAO" scope="page"></jsp:useBean>
<jsp:useBean id="dto" class="net.sungjuk.SungjukDTO" scope="page"></jsp:useBean>
    
    
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>sungjukList.jsp</title>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>
	<h3>↪ 성적 목록 ↩</h3>
	<p><a href="sungjukForm.jsp">[성적쓰기]</a></p>
	
	<table class="table table-striped">
	<tr>
		<th class="info">이름</th>
		<th class="info">국어</th>
		<th class="info">영어</th>
		<th class="info">수학</th>
		<th class="info">등록일</th>
	</tr>
<%
	ArrayList<SungjukDTO> list= dao.list();
	if(list==null) {
		out.println("<tr>");
		out.println(" <td clospan='5'>글없음!!</td>");
		out.println("</tr>");
	}else{
		for(int i=0; i<list.size(); i++) {
			dto=list.get(i);
%>
			<tr>
				<td><a href="sungjukRead.jsp?sno=<%=dto.getSno()%>"><%=dto.getUname()%></a></td>
				<td><%=dto.getKor()%></td>
				<td><%=dto.getEng()%></td>
				<td><%=dto.getMat()%></td>
				<td><%=dto.getWdate().substring(0, 10)%></td>
			</tr>
<%
		}//for end
	}//if end
%>		

	</table>

</body>
</html>