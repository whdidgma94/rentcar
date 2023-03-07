<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../../header.jsp" %>
<body>
	<h1>회원가입</h1>
	<form action="${ctx}/memberJoin.do" method="post">
	<table class="table table-bordered">
	<tr><td>아이디</td><td><input type="text" name="id"></td></tr>
	<tr><td>비밀번호</td><td><input type="password" name="pw"></td></tr>
	<tr><td>이름</td><td><input type="text" name="name"></td></tr>
	<tr><td>나이</td><td><input type="number" name="age"></td></tr>
	<tr><td>이메일</td><td><input type="email" name="email"></td></tr>
	<tr><td>전화번호</td><td><input type="text" name="phone"></td></tr>
	<tr><td>성별</td><td><input type="radio" name="gender" value="남자">남자 &emsp;<input type="radio" name="gender" value="여자">여자
	</td></tr>
	<tr><td colspan="2"><input type="submit" value="회원가입"></td></tr>
	</table>
	</form>
</body>
</html>