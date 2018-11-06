<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="./css/bootstrap.min.css">
<link rel="stylesheet" href="./css/register.css">
<title></title>
</head>
<body>
	<div class="container">
		<div class="row">
		<div class="col-md-6 col-md-offset-4 form-style">
			<div class="form-top">
				<div class="form-top-center">
					<h2 style="text-align: center;">用户注册</h2>
				</div>
				<div class="form-top-right">
					<i class="fa fa-lock"></i>
				</div>
			</div>
			<div class="form-bottom">
				<form role="form" action="doRegister" method="post"
					class="form-horizontal">
					<div class="form-group form-group-style">
						<label class="control-label label-style col-md-3">用户名：</label>
						<div class="col-md-8">
							<input type="text" name="username" placeholder="用户名..."
								class="form-control" id="form-username">
						</div>
					</div>
					<div class="form-group form-group-style">
						<label class="control-label label-style col-md-3" id="pwd">密码：</label>
						<div class="col-md-8">
							<input type="text" name="password" placeholder="密码..."
								class="form-control" id="form-password">
						</div>
					</div>
					
					<div class="form-group form-group-style">
						<label class="control-label label-style col-md-3">邮箱：</label>
						<div class="col-md-8">
							<input type="text" name="email" placeholder="邮箱..."
								class="form-control" id="form-email">
						</div>
					</div>
					<div class="form-group form-group-style">
						<label class="control-label label-style col-md-3">电话：</label>
						<div class="col-md-8">
							<input type="text" name="tel" placeholder="电话号码..."
								class="form-control" id="form-tel">
						</div>
					</div>
					<div class="form-group form-group-style">
						<label class="control-label label-style col-md-3">QQ：</label>
						<div class="col-md-8">
							<input type="text" name="qq" placeholder="QQ..."
								class="form-control" id="form-qq">
						</div>
					</div>
					<div class="form-group form-group-style">
						<label class="control-label label-style col-md-3">个人签名：</label>
						<div class="col-md-8">
							<input type="text" name="info" placeholder="个人签名..."
								class="form-control" id="form-info">
						</div>
					</div>
					<button type="submit" class="btn">注册</button>
				</form>
			</div>
		</div>
		</div>
	</div>
</body>
</html>