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
		<form action="signUp.do" method="post" class="form-horizontal">
  			<div class="form-group">
    			<label for="inputId" class="col-sm-2 control-label">���̵�</label>
    			<div class="col-sm-5">
      			<input type="text" class="form-control" id="inputId" name="id" placeholder="ID" autofocus>
    			</div>
  			</div>
  			<div class="form-group">
    			<label for="inputPassword" class="col-sm-2 control-label">��й�ȣ</label>
    			<div class="col-sm-5">
      			<input type="password" class="form-control" id="inputPassword" name="pw" placeholder="Password">
    			</div>
  			</div>
  			<div class="form-group">
    			<label for="inputEmail" class="col-sm-2 control-label">�̸���</label>
    			<div class="col-sm-5">
      			<input type="text" class="form-control" id="inputEmail" name="email" placeholder="Email">
    			</div>
  			</div>
  			<div class="form-group">
    			<label for="inputName" class="col-sm-2 control-label">�̸�</label>
    			<div class="col-sm-5">
      			<input type="text" class="form-control" id="inputName" name="name" placeholder="Name">
    			</div>
  			</div>
  			<div class="form-group">
    			<label for="birth" class="col-sm-2 control-label">�������</label>
    			<div class="col-sm-5">
      			<input type="text" class="form-control" id="birth" name="birth" required="required" maxlength="10">
    			</div>
  			</div>
  			<div class="form-group">
    			<label for="inputPhone" class="col-sm-2 control-label">�ڵ�����ȣ</label>
    			<div class="col-sm-5">
      			<input type="text" class="form-control" id="inputPhone" name="phone_num" placeholder="Phone">
    			</div>
  			</div>
  			<div class="form-group">
    			<label for="inputAddress" class="col-sm-2 control-label">�ּ�</label>
    			<div class="col-sm-5">
      			<input type="text" class="form-control" id="inputAddress" name="address" placeholder="Address">
    			</div>
  			</div>
  			<div class="form-group">
    			<label for="inputAddress" class="col-sm-2 control-label">����</label>
    			<div class="col-sm-5">
      			<select name="grade">
  							<option value="User">�����</option>
 							<option value="Admin">������</option>
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