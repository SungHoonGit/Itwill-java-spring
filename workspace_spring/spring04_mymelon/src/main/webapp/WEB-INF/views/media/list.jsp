<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
   <meta charset="UTF-8">
   <title>list.jsp</title>
   <style>
      *{font-family: gulim; font-size: 24px; }
   </style>
   <link href="../css/style.css" rel="stylesheet" type="text/css">
</head>
<body>
   <div class="title">미디어 그룹 목록</div>
   <div class="content">
      <input type="button" value="그룹등록" onclick="location.href='create.do'">
   </div>
   
   <c:if test="${requestScope.count == 0}">
      <table><tr><td>게시판에 글 없음!</td></tr></table>
   </c:if>
   
   <c:if test="${requestScope.count > 0}">   <!-- requestScope. 생략 가능 -->
      <table>
      <tr>
         <th>그룹번호</th>
         <th>그룹제목</th>
         <th>수정/삭제</th>
      </tr>
      
      <!-- MediagroupCont의 list()함수에서 mav.addObject("list")를 가리킴 -->
      <c:forEach var="dto" items="${list}">
         <tr>
            <td>${dto.mediagroupno}</td>
            <td><a href="../media/list.do?mediagroupno=${dto.mediagroupno}">${dto.title}</a></td>
            <td>
               <input type="button" value="수정" onclick="location.href='update.do?mediagroupno=${dto.mediagroupno}'">
               <input type="button" value="삭제" onclick="location.href='delete.do?mediagroupno=${dto.mediagroupno}'">
            </td>
         </tr>
      </c:forEach>
      </table>
   </c:if>
   
   <!-- paging 페이지 리스트 -->
   <c:if test="${requestScope.count > 0}">
      <c:set var="pageCount" value="${requestScope.totalPage}"/>
      <c:set var="startPage" value="${requestScope.startPage}"/>
      <c:set var="endPage"   value="${requestScope.endPage}"/>
      
      <div class="content">
         <!-- endPage는 10, 20, 30.. ex)총 페이지가 22일 때 endPage 30이 아닌 22까지 출력해야 함 -->
         <c:if test="${endPage > pageCount}">   
            <c:set var="endPage" value="${pageCount}"></c:set>
         </c:if>
         
         <!-- 이전 : startPage는 10, 20, 30.. 따라서 1보다 크면 이전 페이지 이동 가능 -->
         <c:if test="${startPage > 1}">
            <a href="./list.do?pageNum=${startPage-1}">[이전]</a> <!-- pageNum값을 Controller에 보냄? -->
         </c:if>
         
         <!-- 현재페이지 볼드체 / 현재페이지 외 링크 걸기 -->
         <c:forEach var="i" begin="${startPage}" end="${endPage}">
            <c:choose>
               <c:when test="${pageNum == i}"><span style="font-weight: bold">${i}</span></c:when>
               <c:when test="${pageNum != i}"><a href="./list.do?pageNum=${i}">[${i}]</a></c:when>
            </c:choose>
         </c:forEach>
         
         <!-- 다음 이동 -->
         <c:if test="${endPage < pageCount}">
            <a href="./list.do?pageNum=${endPage+1}">[다음]</a>
         </c:if>
      </div>
   </c:if>
   
   
   
   
</body>
</html>