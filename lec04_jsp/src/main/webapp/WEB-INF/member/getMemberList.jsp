<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div align="center">
		<h1>회원 목록 보기</h1>
		<table border="1">
			<thead>
				<tr>
					<th bgcolor="aqua" width="150">아이디</th>
					<th bgcolor="aqua" width="100">이름</th>
					<th bgcolor="aqua" width="100">비밀번호</th>
					<th bgcolor="aqua" width="100">직책</th>
				</tr>
			</thead>
			<tbody>
			<c:forEach var="member" items="${ members }">
				<tr>
					<td>${ member.member_id }</td>
					<td align="left"><a href="getMember?member_id=${ member.member_id }">${ member.name }</a></td>
					<td>${ member.password }</td>
					<td>${ member.role }</td>
				</tr>
			</c:forEach>
			</tbody>
		</table>
		<br />
		<a href="insertMember">새 회원 등록</a>
	</div>
</body>
</html>