<%@page contentType="text/html; charset=EUC-KR"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>회원탈퇴</title>
</head>
<body>
	<center>
		<h1>회원탈퇴</h1>
		<hr>
		<form action="delete.do" method="post">
			<table border="1" cellpadding="0" cellspacing="0">
				<tr>
					<td bgcolor="orange">회원탈퇴 하시겠습니까?</td>
					
				</tr>
				<tr>
					<td colspan="2" align="center">
					<input type="button" value="예" onclick="location.href='login.do'"/>
					<input type="button" value="취소" onclick="location.href='getBoardList.do'" />
				</tr>
			</table>
		</form>
		<hr>
	</center>
</body>
</html>