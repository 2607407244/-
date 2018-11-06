<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="./css/bootstrap.min.css">
<link rel="stylesheet" href="./css/home.css">
<title>博客系统主页</title>
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
				<div class="row head-pic"></div>
				<div class="row self-info">
					<div class="row header">
						<h1>欢迎来到识广博文</h1>
					</div>
					<div class="row text-style">
						<p class="p-style">本系统主要由用户信息管理，博文管理模块，评论管理模块，前台门户模块四个部分组成。每个模块又由几个小模块构成，其中，
							用户信息管理模块由用户信息维护、注册、登录、找回密码构成；博文管理模块由发布博文、查看博文、修改博文和删除维护构成；
							评论管理模块由查看评论、回复评论、发表评论、删除评论构成；前台门户模块由自博文列表、博文搜索、博文查看构成。</p>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>