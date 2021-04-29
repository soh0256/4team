<%@page contentType="text/html; charset=EUC-KR"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>공지사항 목록</title>
</head>
<body>
	
		<input type="button" value="Log-out" onclick="location.href='logout.do'" />
		<input type="button" value="회원 정보 수정" onclick="location.href='modify.do'" />
		<input type="button" value="게시글 목록" onclick="location.href='getBoardList.do'" />
	
	<center>
		<hr/>
		<h1>공지사항</h1>
			
		<!-- 검색 시작 -->
		<form action="getNoticeList.do" method="post">
			<table border="1" cellpadding="0" cellspacing="0" width="700">
				<tr>
					<td align="right">
					<select name="searchCondition">
						<c:forEach items="${conditionMap }" var="option">
							<option value="${option.value }">${option.key }
						</c:forEach>							
					</select> 
					<input name="searchKeyword" type="text" /> 
					<input type="submit" value="검색"/>
					</td>
				</tr>
			</table>
		</form>
		<!-- 검색 종료 -->
		<table border="1" cellpadding="0" cellspacing="0" width="700">
			<tr>
				<th bgcolor="orange" width="100">
				<spring:message	code="message.board.list.table.head.seq" /></th>
				<th bgcolor="orange" width="200">
				<spring:message code="message.board.list.table.head.title" /></th>
				<th bgcolor="orange" width="150">
				<spring:message code="message.board.list.table.head.writer" /></th>
				<th bgcolor="orange" width="150">
				<spring:message code="message.board.list.table.head.regDate" /></th>
				<th bgcolor="orange" width="100">
				<spring:message code="message.board.list.table.head.cnt" /></th>
			</tr>
			<c:forEach items="${noticeList }" var="notice">
				<tr>
					<td>${notice.notice_no }</td>
					<td align="left"><a href="getNotice.do?notice_no=${notice.notice_no }">
							${notice.notice_title }</a></td>
					<td>관리자</td>
					<td><fmt:formatDate value="${notice.notice_date }" pattern="yyyy-MM-dd"/></td>
					<td>${notice.notice_hits }</td>
				</tr>
			</c:forEach>
		</table>
		<!-- LoginController.java에서 사용자 권한을 저장한 "userGrad"값을 Grad에 저장 -->
		<c:set var="Grad" value="${userGrad }"/> 
		<!-- 로그인한 사용자의 권한이 Admin(관리자)일때, 공지사항 등록 버튼이 보여짐 -->
		<c:if test="${ Grad eq 'Admin'}">
		<br> <a href="insertNotice.jsp">공시사항 등록</a>
		</c:if>
	</center>
</body>
</html>