 <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>
<!-- 본문시작 mailForm.jsp -->
<h3> 메일 보내기 </h3><br>
<div class="container">
<form method="post" action="mailProc.jsp" onsubmit="return mailCheck()">
	<table class="table">
	<tr>
	    <th class="success">받는사람</th>
		<td><input type="email" id="to" name="to"></td>
	</tr>
	<tr>
	    <th class="success">보내는사람</th>
		<td><input type="email" id="from" name="from"></td>
	</tr>
	 <tr>
	   <th class="success">제목</th>
	   <td><input type="text" id="subject" name="subject"></td>
	 </tr>
	 <tr>
	   <th class="success">내용</th>
	   <td><textarea rows="5" cols="30" name="content"></textarea></td>
	 </tr>
	 <tr>
	   <td colspan="2">
	     <input type="submit" value="메일보내기" class="btn btn-primary">
	     <input type="reset"  value="취소"      class="btn btn-primary">
	   </td>
	 </tr> 
	</table>		
</form>
</div>
<!-- 본문끝 -->
<%@ include file="../footer.jsp" %>
