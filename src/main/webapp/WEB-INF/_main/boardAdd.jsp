<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../../header.jsp" %>
<body>
	<h1>게시글 작성</h1>
	<form action="${ctx}/boardAdd.do" method="post">
	<table class="table table-bordered">
	<tr><td>제목</td> <td> <input type="text" name="title"> </td> </tr>
	<tr><td colspan="2">내용</td></tr>
	<tr><td colspan="2"> <textarea rows="30" cols="120" name="content" spellcheck="false"></textarea> </td> </tr>
	<tr> <td colspan="2"> <button>작성하기</button> </td> </tr>
	</table>
	</form>
</body>
</html>