<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div align="center">
		<h3>회원 상세보기</h3>
		<hr />
		<form action="updateMember" method="post">
			<input type="hidden" name="member_id" value="${ member.getMember_id() }" />
			<table border="1">
				<tr>
					<td bgcolor="aqua">이름</td>
					<td align="left"><input type="text" name="name" value="${ member.getName() }"/></td>
				</tr>
				<tr>
					<td bgcolor="aqua">비밀번호</td>
					<td align="left"><input type="text" name="password" value="${ member.getPassword() }"/></td>
				</tr>
				<tr>
					<td bgcolor="aqua">직책</td>
					<td align="left"><input type="text" name="role" value="${ member.getRole() }"/></td>
				</tr>
				<tr>
					<td colspan="2" align="center">
						<input type="submit" value="회원정보 수정하기" />
					</td>
				</tr>
			</table>
		</form>
		<hr />
		<a href="insertMember">회원 등록</a>&nbsp;&nbsp;&nbsp;
		<a href="deleteMember?member_id=${ member.member_id }">회원 삭제</a>&nbsp;&nbsp;&nbsp;
		<a href="getMemberList">회원 목록</a>
	</div>
</body>
</html>