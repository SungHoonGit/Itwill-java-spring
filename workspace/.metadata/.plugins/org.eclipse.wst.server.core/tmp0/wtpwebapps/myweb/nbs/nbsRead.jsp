<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="ssi.jsp" %>    
<%@ include file="../member/auth.jsp" %>
<%@ include file="../header.jsp" %>
<!-- 본문 시작 bbsRead.jsp -->
<h3>* 게시판 상세보기 *</h3>
<p>
   <a href="nbsList.jsp?col=<%=col%>&word=<%=word%>&nowPage<%=nowPage%>">[글목록]</a>
</p>

<div class="container">
<%
int nbsno=Integer.parseInt(request.getParameter("nbsno"));
   dto=dao.read(nbsno);
   if(dto==null){
      out.println("해당 글 없음!!");
   }else{
      
      dao.incrementCnt(nbsno); //조회수 증가
%>
   
    <table class="table">
      <tr>
          <th class="success">제목</th>
            <td><%=dto.getSubject()%></td>
      </tr>
      <tr>
          <th class="success">내용</th>
            <td style="text-align: left">
<%
//사용자가 입력한 엔터(\n)를 <br>테그로 바꾸기
      String content=Utility.convertChar(dto.getContent());
      out.print(content);
%>
            </td>
      </tr>
      <tr>
          <th class="success">조회수</th>
          <td><%=dto.getReadcnt() %></td>
      </tr>
      <tr>
          <th class="success">작성자</th>
          <td> 관리자 </td>
      </tr>
      <tr>
          <th class="success">작성일</th>
          <td><%=dto.getRegdt() %></td>
      </tr>
   
    </table>
    <br>
<%if(s_mlevel.equals("A1")){ %>
   <input type="button" value="수정" class="btn btn-warning" onclick="location.href='nbsUpdate.jsp?nbsno=<%=nbsno%>&col=<%=col%>&word=<%=word%>'">
   <input type="button" value="삭제" class="btn btn-danger"  onclick="location.href='nbsDel.jsp?nbsno=<%=nbsno%>'">
   
<%      }//if end
   }//if end
%>

</div>

<!-- 본문끝 -->
<%@include file="../footer.jsp" %>