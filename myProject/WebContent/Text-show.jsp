<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="team.dao.ArticleDAO" import="team.model.ArticleInfo"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="./css/bootstrap.min.css">
<title>博文信息</title>
</head>
<%
	ArticleInfo info = new ArticleInfo();
	ArticleDAO dao = new ArticleDAO();
	int id = Integer.parseInt(request.getParameter("id"));
	info = dao.findById(id);
%>
<body>
	<div class="container">
		<div class="row">
			<div class="col-md-8 col-md-push-2">
				<article> 
				<header>
				<div style="text-align: center;">
					<h3 style="display: inline;"><%=info.getTitle() %></h3>
					<span>(<%=info.getType() %>) </span>
				</div>

				</header>
				<div><%=info.getContent() %></div>
				<footer style="float:right;">
				<h5><%=info.getUsername() %></h5>
				<p>41 Comments | 0 Tweets</p>
				<p>发布日期：<%=info.getPub_date() %></p>
				</footer> </article>
			</div>
		</div>
	</div>
</body>
<style>
.container {
	height: 800px;
	margin-top: 10px;
	/* boder: 1px solid black; */
	background:url(./img/xx.jpg);
	background-size: 100%;
	background-repeat: no-repeat;
}

.row {
	height: 800px;
	/* border: 1px solid black; */
}

.col-md-8 {
	height: 800px;
	/* border: 1px solid black; */
	overflow-y:auto;
}

</style>
</html>