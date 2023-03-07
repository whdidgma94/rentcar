<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../../header.jsp" %>
<body>
	<h1>로그인</h1>
	<form action="${ctx}/memberLogin.do" method="post">
	<table class="table table-bordered">
	<tr><td>아이디</td><td><input type="text" name="id"></td></tr>
	<tr><td>비밀번호</td><td><input type="password" name="pw"></td></tr>
	<tr><td colspan="2"><input type="submit" value="로그인"></td></tr>
	</table>
	</form>
</body>
</html>