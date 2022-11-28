<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="net.testbean.*"%>
<jsp:useBean id="comp" class="net.testbean.Compute" scope="page"></jsp:useBean>



<%-- 
	● [액션태그]●
	<jsp:useBean id=""></jsp:useBean>		객체생성 (Object)
	<jsp:forward page=""></jsp:forward>		페이지 이동
	<jsp:include page=""></jsp:include>		공통 페이지 가져오기
	
	● [Java Bean 객체생성]
	<jsp:useBean id="객체명" 
				 class="팩키지명.클래스명" 
				 scope="page"></jsp:useBean>
				 
	● [Scope 유효범위]
	- scope="page"			현재 페이지에서만 유효, 생략시 기본값.
	- scope="request"		다른 페이지에서 공유
	- scope="session"		다른 페이지에서 공유
	- scope="application"	다른 페이지에서 공유


 --%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>computeok3.jsp</title>
</head>
<body>
	<h3>↪  계 산 결 과  ↩</h3>
	<h4>3) Java Bean을 이용해서 객체 생성후 메소드 호출</h4>
<%
	int num1=Integer.parseInt(request.getParameter("num1").trim());
	int num2=Integer.parseInt(request.getParameter("num2").trim());		
	
	
	out.print(num1 + "+" + num2 + "=" + comp.add(num1,num2));
	out.print("<hr>");
	out.print(num1 + "-" + num2 + "=" + comp.sub(num1,num2));
	out.print("<hr>");
	out.print(num1 + "*" + num2 + "=" + comp.mul(num1,num2));
	out.print("<hr>");
	out.print(num1 + "/" + num2 + "=" + comp.div(num1,num2));
	out.print("<hr>");
	out.print(num1 + "%" + num2 + "=" + comp.mod(num1,num2));	
	out.print("<hr>");
			
%>	
</body>
</html>