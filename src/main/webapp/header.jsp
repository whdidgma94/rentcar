<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>렌트카</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<link href="${ctx}/css/style.css" rel="stylesheet" type="text/css">
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
</head>
<body>
<header>
<div class="nav justify-content-between"> 
<div> <img alt="로고" src="${ctx}/img/rent_logo.jpg" width="200" height="200"> </div>
<div>
<c:if test="${log == null}">Guest</c:if><c:if test="${log != null}">${log}</c:if> 님 
							<c:if test="${log == null}"><button onclick="location.href='${ctx}/memberLogin.do'">로그인</button><button onclick="location.href='${ctx}/memberJoin.do'">회원가입</button></c:if>
							<c:if test="${log != null}"><button onclick="location.href='${ctx}/memberLogout.do'">로그아웃</button></c:if>										 
</div>
</div>
<div class="nav justify-content-around contentsbar">
	<div class="col-2 py-3" onclick="location.href='${ctx}/rent.do'"> 예약하기 </div>
	<div class="col-2 py-3" onclick="location.href='${ctx}/checkRent.do'"> 예약확인 </div>	
	<div class="col-2 py-3" onclick="location.href='${ctx}/boardList.do'"> 게시판 </div>
	<c:if test="${log == 'admin'}"><div class="col-2 py-3" onclick="location.href='${ctx}/adminMember.do'"> 회원관리 </div>
								   <div class="col-2 py-3" onclick="location.href='${ctx}/adminAddCar.do'"> 차량추가 </div></c:if>
	<c:if test="${log != 'admin' && log != null}"><div class="col-2 py-3" onclick="location.href='${ctx}/memberProfile.do'"> 마이페이지 </div></c:if>
</div>
</header>
