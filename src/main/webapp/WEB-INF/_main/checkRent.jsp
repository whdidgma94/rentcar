<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../../header.jsp" %>
<body>
	<h1>예약확인</h1>
	<table class="table table-bordered">
	<tr><td>사진</td><td>차종</td><td>수량</td><td>대여일</td><td>대여기간</td><td>보험</td><td>wifi</td><td>네비게이션</td><td>베이비시트</td><td>삭제</td></tr>
	<c:forEach var="r" items="${idsList}">
	<tr>
	<td><img src="${ctx}/img/${r.carNo}.jpg" height="100px" width="100px"></td>
	<td>차종 </td>
	<td>${r.qty}</td>
	<td>${r.rday}</td>
	<td>${r.dday} 일</td>
	<td>${r.usein}</td>
	<td>${r.usewifi}</td>
	<td>${r.usenavi}</td>
	<td>${r.useseat}</td>
	<td> <button>삭제</button> </td>
	
	</tr>
	</c:forEach>
	</table>
</body>
</html>