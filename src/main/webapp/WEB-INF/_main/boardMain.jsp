<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../../header.jsp" %>
<body>
	<h1>게시판</h1>
	<table class="table table-bordered">
	<tr><td>번호</td>  <td>제목</td> <td>작성자</td> <td>작성일</td> </tr>
	<c:forEach var="b" items="${list}">
	<tr>
		<td>${b.num}</td>  <td> <a href='${ctx}/boardView.do?num=${b.num}'>${b.title}</a>   </td> <td>${b.writer}</td> <td>${b.day}</td>
	</tr>
	</c:forEach>
	</table>
	<c:if test="${log != null}">
		<button onclick="location.href='${ctx}/boardAdd.do'">작성하기</button>
	</c:if>
	
</body>
</html>