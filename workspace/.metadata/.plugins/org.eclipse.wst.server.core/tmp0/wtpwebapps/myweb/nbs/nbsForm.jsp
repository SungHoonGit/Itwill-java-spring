<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>    
<%@ include file="ssi.jsp"%>
<%@include file="../header.jsp" %>
    <!-- 본문시작 bbsForm.jsp -->
	<h3> 공지사항 작성 </h3>
	<p><a href="nbsList.jsp">[공지사항]</a></p>
	
	<div class="container">
		<form name="nbsfrm" id="nbsfrm" method="post" action="nbsIns.jsp" onsubmit="return nbsCheck()"> <!--  myscript.js에 함수 작성함  -->
		<table class="table">
		<tr>
		   <th class="success">제목</th>
		   <td><input type="text" name="subject" id="subject" class="form-control" maxlength="100" required></td>
		</tr>
		<tr>
		   <th class="success">내용</th>
		   <td><textarea rows="5" class="form-control" name="content" id="content"></textarea></td>
		</tr>
		<tr>
		    <td colspan="2" align="center">
		       <input type="submit" value="쓰기" class="btn btn-success">
		       <input type="reset"  value="취소" class="btn btn-danger">
		    </td>
		</tr>    
		</table>	
		</form>
	</div>
		
    <!-- 본문 끝 -->
<%@ include file="../footer.jsp"%>