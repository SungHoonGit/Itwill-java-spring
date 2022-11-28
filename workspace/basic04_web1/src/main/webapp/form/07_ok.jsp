<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>07_ok.jsp</title>
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css" rel="stylesheet">
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
	<h3>출력결과</h3>
<%
	// 한글 인코딩
	request.setCharacterEncoding("UTF-8");

	// 사용자가 입력 요청한 정보 가져오기
	// 예) <inpupt type="number" name="num1">
	int num1=Integer.parseInt(request.getParameter("num1").trim());
	int num2=Integer.parseInt(request.getParameter("num2").trim());
	String op=request.getParameter("op").trim();
	
	int res1=0;			// 정수형 계산 결과
	double res2=0.0;	// 실수형 계산 결과
	
	if(op.equals("+")) {
		res1=num1+num2;
	}else if(op.equals("-")) {
		res1=num1-num2;
	}else if(op.equals("*")) {
		res1=num1*num2;
	}else if(op.equals("/")) {
		res1=num1/num2;
	}else if(op.equals("%")) {
		res1=num1%num2;
	}// if end	
%>	

	<!-- 출력 -->
	<div class="container">
		<table class="table">
		<tr>
			<td><%=num1%></td>
			<td><%=op%></td>
			<td><%=num2%></td>
			<td>=</td>
			<td>
<%
				if(op.equals("/")) {
					out.print(String.format("%.1f", res2)); // 소수점1자리수로 문자열 출력 "0.6"
				}else{
					out.print(res1);
				}//if end
%>
		    </td>
		   </tr>
		</table>
	</div>	
	
<%-- 
	
<%
	int num1= Integer.parseInt(request.getParameter("num1"));
	String operator=request.getParameter("op");
	int num2= Integer.parseInt(request.getParameter("num2"));	
%>

<h2><%if(operator.equals("+")){ %>
	<%=num1%>+<%=num2%> = <%=num1+num2 %>
	<%} else if (operator.equals("-")){ %>
	<%=num1%>-<%=num2%> = <%=num1-num2%>
	<%} else if (operator.equals("*")){ %>
	<%=num1%>*<%=num2%> = <%=num1*num2%>
	<%} else if (operator.equals("/")){ %>
	<%=num1%>/<%=num2%> = <%=num1/num2%>
	<%}%></h2> 
	
	
--%>

</body>
</html>