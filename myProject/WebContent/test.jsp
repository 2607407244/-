<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="./css/bootstrap.min.css">
<link rel="stylesheet" href="./css/home.css">
<script type="text/javascript" charset="utf-8"
	src="./editor/ueditor.config.js"></script>
<script type="text/javascript" charset="utf-8"
	src="./editor/ueditor.all.min.js">
	
</script>
<!--建议手动加在语言，避免在ie下有时因为加载语言失败导致编辑器加载失败-->
<!--这里加载的语言文件会覆盖你在配置项目里添加的语言类型，比如你在配置项目里配置的是英文，这里加载的中文，那最后就是中文-->
<script type="text/javascript" charset="utf-8"
	src="./editor/lang/zh-cn/zh-cn.js"></script>
<title>编辑博文</title>
</head>
<body>
	<div class="container">

		<div class="col-md-3 function aside-style">
			<a class="link" href="home.jsp">主&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;页</a>
			<a class="link" href="refer.jsp">推荐博文</a> <a class="link"
				href="food.jsp">美食天地</a> <a class="link" href="internet.jsp">网络技术</a>
			<a class="link" href="focus.jsp">关注博文</a> <a class="link"
				href="editor.jsp">编写博客</a> <a class="link" href="self-Text">个人博文</a>
			<a class="link" href="#">个人信息</a> <a class="link" href="login.jsp">退&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;出</a>
		</div>

		<div class="col-md-8 funtion">
			<form action="UeditorServlet" method="post">
				<div style="height: 50px; padding-top: 20px;">
					<span>请输入博文标题:</span> <input type="text" name="title">
				</div>
				<div>
					<span>博文类型：</span> <input type="radio" value="optionl" name="sex">美食推荐
					<input type="radio" value="optionl" name="sex">网络技术
				</div>
				<div>
					<script id="editor" type="text/plain"
						style="width:1024px;height:500px;"></script>
					<button type="submit">提交博文</button>
				</div>
			</form>
		</div>


	</div>
	<script type="text/javascript">
		//实例化编辑器
		//建议使用工厂方法getEditor创建和引用编辑器实例，如果在某个闭包下引用该编辑器，直接调用UE.getEditor('editor')就能拿到相关的实例
		var ue = UE.getEditor('editor');
	</script>
</body>
</html>