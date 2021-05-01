<%@page contentType="text/html; charset=EUC-KR"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">

<link href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" rel="stylesheet">
<link href="css/bootstrap.css" rel="stylesheet">
<link href="dataTables.bootstrap.css" rel="stylesheet">

<title>ȸ������</title>
</head>
<body>
	<center>
		<h1>ȸ������</h1>
	</center>
		<hr>

  		<form action="signUp.do" method="post" class="form-horizontal" >
  			<div class="form-group">
    			<label for="inputId" class="col-sm-2 control-label">�̹��� ����</label>
    			<div class="col-sm-5">
      			<input type="text" class="form-control" id="user_image" name="user_image" value="${param.user_img}" placeholder="������ �̹���" autofocus>
    			</div>
  			</div>
  		<form action="signUp.do" method="post" class="form-horizontal" >
  			<div class="form-group">
    			<label for="inputId" class="col-sm-2 control-label">���̵�</label>
    			<div class="col-sm-5">
      			<input type="text" class="form-control" id="id" name="id" value="${param.id}" placeholder="ID" autofocus>
    			</div>
  			</div>
  			<div class="form-group">
    			<label for="inputPassword" class="col-sm-2 control-label">��й�ȣ</label>
    			<div class="col-sm-5">
      			<input type="password" class="form-control" id="pw" name="pw" placeholder="Password" value="${param.pw}">
    			</div>
  			</div>
  			
  			<div class="form-group">
    			<label for="inputEmail" class="col-sm-2 control-label">�̸���</label>
    			<div class="col-sm-5">
      			<input type="text" class="form-control" id="email" name="email" placeholder="Email" value="${param.email}">
    			</div>
  			</div>
  			
  			<div class="form-group">
    			<label for="inputName" class="col-sm-2 control-label">�̸�</label>
    			<div class="col-sm-5">
      			<input type="text" class="form-control" id="name" name="name" placeholder="Name" value="${param.name}">
    			</div>
  			</div>
  			<div class="form-group">
    			<label for="birth" class="col-sm-2 control-label">�������</label>
    			<div class="col-sm-5">
      			<input type="text" class="form-control" id="birth" name="birth" required="required" maxlength="10" value="${param.birth}">
    			</div>
  			</div>
  			<div class="form-group">
    			<label for="inputPhone" class="col-sm-2 control-label">�ڵ�����ȣ</label>
    			<div class="col-sm-5">
      			<input type="text" class="form-control" id="phone_num" name="phone_num" value="${param.phone_num}" placeholder="������ ���� ���ڸ� �Է����ּ���">
    			</div>
  			</div>
  			<div class="form-group">
    			<label for="inputAddress" class="col-sm-2 control-label">�����ȣ</label>
    			<div class="col-sm-5">
      			<input type="text" class="form-control" id="post_num" name="post_num" value="${param.post_num}" placeholder="�˻��� �̿����ּ���">
    			</div>
  			</div>
  			
  			<div class="form-group">
    			<label for="inputAddress" class="col-sm-2 control-label">�ּ�</label>
    			<div class="col-sm-5">
      			<input type="text" class="form-control" id="address" name="address" value="${param.address}" placeholder="Address">
    			</div>
  			</div>
  			
  			<div class="form-group">
    			<label for="inputAddress" class="col-sm-2 control-label">����</label>
    			<div class="col-sm-5">
      			<select name="grade">
  							<option value="${param.grade}">�����</option>
 							<option value="${param.grade}">������</option>
				</select>
    			</div>
  			</div>
  			

  			<div class="form-group">
    			<div class="col-sm-offset-2 col-sm-10">
    			</div>
  			</div>
  			<div class="form-group">
    			<div class="col-sm-offset-2 col-sm-10">
      			<button type="submit" class="btn btn-primary">ȸ������</button>
      			<input type="button" class="btn btn-primary" value="���" onclick="location.href='login.do'" />
    			</div>
  			</div>
			</form>
		<hr>
	
</body>
</html>