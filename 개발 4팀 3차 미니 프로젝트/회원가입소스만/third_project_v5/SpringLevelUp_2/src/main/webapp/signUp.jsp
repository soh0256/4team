<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var ="context"><%=request.getContextPath()%></c:set>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>회원가입</title>
	<link href="css/bootstrap.min.css" rel="stylesheet">
	<link href="css/bootstrap-theme.css" rel="stylesheet">
	<link href="css/plugins/metisMenu/metisMenu.min.css" rel="stylesheet">
	<link href="css/plugins/social-buttons.css" rel="stylesheet">
	<link href="css/plugins/dataTables.bootstrap.css" rel="stylesheet">
    <link href="css/process.css" rel="stylesheet">
	
	<script src="js/plugins/dataTables/dataTables.bootstrap.js"></script>
	<script src="js/plugins/dataTables/jquery.dataTables.js"></script>
	<script src="js/jquery-1.9.1.js"></script>
	
<script type="text/javascript">
$(document).ready(function(){
	fn_init();


	$( "#birth" ).datepicker({
    	dateFormat: 'yy-mm-dd',
    	changeMonth: true,
        changeYear: true,
        yearRange: "1980:2016"
    });

});

<%-- 주소검색 팝업 호출 --%>
function fn_openAddressPopup(){
	var url = "./addressAPIPopup.jsp";
	var name = "AddressPopup";
	var option = "width=650, height=500, top=100, left=200, location=no, scrollbars = yes"
	window.open(url, name, option);
}


<%-- 주소검색 팝업 호출 CallBack --%>
function callback_openAddressPopup(aParam){
	document.getElementById("post_num").value = aParam["roadAddr"];
}

function fn_save(){
	if(!fn_validation()) return;

	$("#phone_num").val($("#phone0").val() + "-" + $("#phone1").val() + "-" + $("#phone2").val());

	$("#joinFrm").submit();
}
</script>
</head>
<body>
	<center>
		<h1 id="title">회원가입</h1>
	</center>
		<hr>
		<!-- encytype 사진업로드 -->
		<form id="joinFrm" action="signUp.do" method="post" class="form-horizontal" enctype="multipart/form-data">
		
  			<div class="form-group">
    			<label for="inputEmail" class="col-sm-2 control-label">사진</label>
    			<div class="col-sm-5">
      			<input type="file" class="form-control" id="user_image" name="user_image" placeholder="사진을 첨부해주세요" value="${param.user_image}">
    			</div>
  			</div>
  			
  			<div class="form-group">
    			<label for="inputId" class="col-sm-2 control-label">아이디</label>
    			<div class="col-sm-5">
      			<input type="text" class="form-control" id="id" name="id" value="${param.id}" placeholder="ID" autofocus>
    			</div>
  			</div>
  			<div class="form-group">
    			<label for="inputPassword" class="col-sm-2 control-label">비밀번호</label>
    			<div class="col-sm-5">
      			<input type="password" class="form-control" id="pw" name="pw" placeholder="Password" value="${param.pw}">
    			</div>
  			</div>
  			
  			<div class="form-group">
    			<label for="inputEmail" class="col-sm-2 control-label">이메일</label>
    			<div class="col-sm-5">
      			<input type="text" class="form-control" id="email" name="email" placeholder="Email" value="${param.email}">
    			</div>
  			</div>
  			
  			<div class="form-group">
    			<label for="inputName" class="col-sm-2 control-label">이름</label>
    			<div class="col-sm-5">
      			<input type="text" class="form-control" id="name" name="name" placeholder="Name" value="${param.name}">
    			</div>
  			</div>
  			
  			<div class="form-group">
    			<label for="birth" class="control-label col-md-2"><b>생년월일</b></label>
    			<div class="col-sm-5">
      			<input type="text" class="form-control" id="birth" name="birth" required="required" maxlength="10" value="${param.birth}">
    			</div>
  			</div>
  			
  			
  			<div class="form-group">
				<label for="inputPhone" class="control-label col-md-2"><b>연락처</b></label>
				<div class="col-md-2">
		        	<select class="form-control" id="phone0" name="phoneCd" required="required">
							<option value="1">010</option>
							<option value="4">070</option>
							<option value="2">02</option>
							<option value="5">032</option>
							<option value="6">031</option>
		     		</select>
	     		</div>
				<div class="col-md-2">
					<input class="form-control" type="text" id="phone1" maxlength="4" required="required" onkeydown="return fn_showKeyCode(event)"/>
				</div>
				<div class="col-md-2">
					<input class="form-control" type="text" id="phone2" maxlength="4" required="required" onkeydown="return fn_showKeyCode(event)"/>
				</div>
				<input type="hidden" id="phone_num" name="phone_num">
			</div>
  			
  			
  			<div class="form-group">
    			<label for="inputAddress" class="col-sm-2 control-label">기본주소</label>
    			<div class="col-sm-5">
      			<input type="text" class="form-control" id="post_num" name="post_num" value="${param.post_num}" placeholder="검색을 이용해주세요" onclick = "fn_openAddressPopup()">
    			</div>
  			</div>
  			
  			<div class="form-group">
    			<label for="inputAddress" class="col-sm-2 control-label">상세주소</label>
    			<div class="col-sm-5">
      			<input type="text" class="form-control" id="address" name="address" value="${param.address}" placeholder="Address">
    			</div>
  			</div>
  			
  			<div class="form-group">
    			<label for="inputAddress" class="col-sm-2 control-label">권한</label>
    			<div class="col-sm-5">
      			<select name="grade">
  							<option   value="User">사용자</option>
 							<option  value="Admin">관리자</option>
				</select>
    			</div>
  			</div>

				
  			<div class="form-group">
    			<div class="col-sm-offset-2 col-sm-10">
    			</div>
  			</div>
  			<div class="form-group">
    			<div class="col-sm-offset-2 col-sm-10">
      			<button type="submit" class="btn btn-primary">회원가입</button>
      			<input type="button" class="btn btn-primary" value="취소" onclick="location.href='login.do'" />
    			</div>
  			</div>
			</form>
		<hr>
	
</body>
</html>