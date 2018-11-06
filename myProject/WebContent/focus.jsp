<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="./css/bootstrap.min.css">
<link rel="stylesheet" href="./css/refer.css">
<title>推荐博文</title>
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-md-3 function aside-style">
				<a class="link" href="home.jsp">主&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;页</a>
				<a class="link" href="refer.jsp">推荐博文</a> <a class="link" href="food.jsp">美食天地</a>
				<a class="link" href="internet.jsp">网络技术</a> <a class="link" href="focus.jsp">关注博文</a>
				<a class="link" href="editor.jsp">编写博客</a> <a class="link" href="self-Text.jsp">个人博文</a>
				<a class="link" href="#">个人信息</a> <a class="link" href="login.jsp">退&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;出</a>
			</div>
			<div class="col-md-8 function">
			<div class="aa">
					<form>
						<span>请输入搜索关键字:</span> <input type="text" name="info"><input
							type="submit" value="搜索">
					</form>
				</div>
			<div class="show-text"></div>
			<div class="show-text"></div>
			<div class="show-text"></div>
			</div>
		</div>
	</div>
</body>
</html>