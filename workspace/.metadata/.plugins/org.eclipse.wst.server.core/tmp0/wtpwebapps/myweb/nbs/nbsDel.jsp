<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="ssi.jsp" %>       
<%@include file="../header.jsp" %>
    	<!-- 본문시작 bbsDel.jsp -->
    	<!-- 글번호(bbsno)와 비밀번호(passwd)가 일치하면 글삭제 -->
<h3>* 글삭제 *</h3>
<p><a href="nbsList.jsp">[글목록]</a></p>
<%
	int nbsno=Integer.parseInt(request.getParameter("nbsno"));
%>
<div class="container">
	<form method='post' action="nbsDelProc.jsp" onsubmit="return pwcheck()"><!-- myscript.js -->
		<input type="hidden" name="nbsno" value="<%=nbsno%>">
		<table class="table">
		<tr>
			<td colspan="2">
				<input type="submit" value="삭제" class="btn btn-danger">
			</td>
		</tr>		
		</table>
	</form>
</div>


    	<!-- 본문 끝 -->
<%@ include file="../footer.jsp"%>