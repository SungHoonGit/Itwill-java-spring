<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="ssi.jsp" %>    
<%@ include file="../header.jsp"%>
    	<!-- 본문시작 nbsUpdateProc.jsp -->
    	<!-- 수정 요청한 정보를 가져와서, DB에 가서 행 수정하기 -->
<h3>* 글 업데이트 *</h3>
<p>
	<a href="nbsForm.jsp">[글쓰기]</a>
	&nbsp;&nbsp;
	<a href="nbsList.jsp">[글목록]</a>
</p>
<div class="container">
<%
	
	//사용자가 입력 요청한 정보를 가져요기
	int nbsno=Integer.parseInt(request.getParameter("nbsno"));
	String subject	= request.getParameter("subject").trim();
	String content	= request.getParameter("content").trim();
	
	//dto객체에 담기
	dto.setNbsno(nbsno);
	dto.setSubject(subject);
	dto.setContent(content);
	

	
	int cnt=dao.updateproc(dto);
    if(cnt==0) {
         out.println("<p>수정할 수 없습니다</p>");
         out.println("<p><a href='javascript:history.back()'>[다시시도]</a></p>");
      }else {
         out.println("<script>");
         out.println("   alert('게시글이 수정되었습니다');");
         out.println("   location.href='nbsList.jsp';");   // 목록페이지 이동
         out.println("</script>");
      }// if end
%>    		
</div>
    	<!-- 본문 끝 -->
<%@ include file="../footer.jsp"%>