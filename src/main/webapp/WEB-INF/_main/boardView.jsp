<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../../header.jsp" %>
<body>
<h1>게시글</h1>
	<table class="table table-bordered">
		<tr> <td>제목</td> <td colspan="3">${board.title}</td> </tr>
		<tr> <td>작성자</td> <td>${board.writer}</td><td>작성일</td> <td>${board.day}</td> </tr>
		<tr> <td colspan="4">${board.content}</td> </tr>
	</table>
	<button onclick="location.href='${ctx}/boardList.do'">목록으로</button>
	<c:if test="${board.writerId==log}"><button onclick="location.href='${ctx}/boardDelete.do'">게시글 삭제</button> </c:if>
</body>
</html>