<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="team.dao.ArticleDAO"%>
<%@ page import="team.model.ArticleInfo" import="team.model.User"%>
<%@ page import="team.model.ArticleType"%>
<%@ page import="java.util.List"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="./css/bootstrap.min.css">
<link rel="stylesheet" href="./css/refer.css">
<link rel="stylesheet" href="./css/style4.css">
<title>个人博文</title>
</head>
<body>
	<%
		ArticleDAO articleDao = new ArticleDAO();
		List<ArticleInfo> list1 = null;
		User user = new User();
		user = (User) session.getAttribute("user");
		list1 = articleDao.findAll(user.getUsername());
		session.setAttribute("list", list1);
	%>

	<div class="container">
		<div class="row">
			<div class="col-md-3 function aside-style">
				<a class="link" href="home.jsp">主&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;页</a>
				<a class="link" href="refer.jsp">推荐博文</a> <a class="link"
					href="food.jsp">美食天地</a> <a class="link" href="internet.jsp">网络技术</a>
				<a class="link" href="focus.jsp">关注博文</a> <a class="link"
					href="editor.jsp">编写博客</a> <a class="link" href="self-Text.jsp">个人博文</a>
				<a class="link" href="#">个人信息</a> <a class="link" href="login.jsp">退&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;出</a>
			</div>
			<div class="col-md-8 function">
				<div class="aa">
					<form>
						<span>请输入搜索关键字:</span> <input type="text" name="info"><input
							type="submit" value="搜索">
					</form>
				</div>
				<%
					String info = request.getParameter("info");
					ArticleDAO indexDao = new ArticleDAO();
					List<ArticleInfo> list2 = null;
					if (info != null && info != "") {
						list2 = indexDao.fuzzyFind(user.getUsername(), info);
						session.setAttribute("list", list2);
					}
				%>
				<div id="main">
					<c:forEach var="art" items="${sessionScope.list}">
						<div class="entry">
							<div class="entry-header">

								<h3 class="title">
									<a href="single-post.html">${art.title}</a>
								</h3>
								<button class="self-button">
									<a href="/myProject/DeletArticle?id=${art.id}">删除</a>
								</button>
								<button class="self-button">
									<a href="Mod.jsp?id=${art.id}">修改</a>
								</button>
								<p class="meta">
									发布于 <a href="#">${art.pub_date}</a> 作者：<a href="#">${art.username}
									</a>
								</p>
								<a href="Text-show.jsp?id=${art.id}" class="button">Read More...</a>
							</div>
							<!-- end .entry-header -->
							<div class="entry-content">
								<a href="single-post.html"><img src="img/32.jpg" width="240"
									height="140" alt="" class="entry-image" /></a>
								<p>${art.content}</p>
								<hr />
								<ul class="entry-links">
									<li><a href="#">博文类型 ：${art.type}</a> <span
										class="separator">|</span></li>
									<li><a href="#">41 Comments</a> <span class="separator">|</span></li>
									<li><a href="#">0 Tweets</a></li>
								</ul>
							</div>
							<!-- end .entry-content -->
						</div>
					</c:forEach>
				</div>

			</div>
		</div>
	</div>
</body>
</html>