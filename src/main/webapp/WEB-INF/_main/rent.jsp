<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../../header.jsp" %>
<body>
	<h1>예약하기</h1>
	<table class="table table-bordered">
	<tr> <td>사진</td> <td>차종</td>  <td>번호</td> <td>가격</td> <td>제조사</td> <td>설명</td> <td>예약</td>   </tr>
	<c:forEach var="c" items="${carList}">
	<tr>
		<td> <img alt="${c.name}" src="${ctx}/img/${c.img}" height="100px" width="100px"> </td>
		<td>${c.name}</td>
		<td>${c.no}</td>
		<td>${c.price}</td>
		<td>${c.company}</td>
		<td>${c.info}</td>
		<td> <button onclick="location.href='${ctx}/reserve.do?name=${c.name}'">예약하기</button> </td>
	</tr>
	</c:forEach>
	</table>
</body>
</html>