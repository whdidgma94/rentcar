<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../../header.jsp" %>
<body>
	<h1>관리자 회원관리</h1>
	<table class="table table-bordered">	
		<tr> <td>아이디</td> <td>비밀번호</td> <td>이름</td> <td>나이</td> <td>이메일</td> <td>전화번호</td> <td>성별</td> <td>삭제</td> </tr>
		<c:forEach var="m" items="${memberList}">
			<c:if test="${m.id != 'admin'}">
				<tr>
					<td>${m.id}</td>
					<td>${m.pw}</td>
					<td>${m.name}</td>
					<td>${m.age}</td>
					<td>${m.email}</td>
					<td>${m.phone}</td>
					<td>${m.gender}</td>
					<td><input type="button" value="삭제" id="delBtn" onclick="test('${m.id}')"/></td>
				</tr>
			</c:if>
		</c:forEach>
	</table>
	<script>		
		function test(id){
			console.log(id);
			$.ajax({
				type : "post",
				url : "adminMemberDelete.do",
				data : {id : id},
				success : function(data) {
					history.go(0);
				}
			})	
			
		}
	</script>
</body>
</html>