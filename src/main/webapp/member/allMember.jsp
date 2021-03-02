<%@page import="kr.or.ddit.user.model.MemberVo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<link href="${cp }/css/bootstrap.min.css"
	rel="stylesheet">
<script src="/js/jquery/jquery-1.12.4.js"></script><link href="bootstrap.css" rel="stylesheet"><!-- Bootstrap core CSS -->
<script src="${cp }/js/bootstrap.js"></script><!-- Custom styles for this template -->
<link href="${cp }/css/dashboard.css" rel="stylesheet">
<link href="${cp }/css/blog.css" rel="stylesheet">
<%List<MemberVo> memList = (List<MemberVo>)request.getAttribute("memList"); %>
<body>

	
<nav class="navbar navbar-inverse navbar-fixed-top">
	<div class="container-fluid">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false"
				aria-controls="navbar">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="#">JSP/SPRING</a>
		</div>
		<div id="navbar" class="navbar-collapse collapse">
			<ul class="nav navbar-nav navbar-right">
				<li><a href="#">Dashboard</a></li>
				<li><a href="#">Settings</a></li>
				<li><a href="#">Profile</a></li>
				<li><a href="#">Help</a></li>
			</ul>
			<form class="navbar-form navbar-right">
				<input type="text" class="form-control" placeholder="Search...">
			</form>
		</div>
	</div>
</nav><div class="container-fluid">
		<div class="row">
			
<div class="col-sm-3 col-md-2 sidebar">
	<ul class="nav nav-sidebar">
		<li class="active"><a href="#">Main <span class="sr-only">(current)</span></a></li>
		<li class="active"><a href="#">전체 사용자</a></li>
		<li class="active"><a href="#">직원</a></li>
	</ul>
</div><div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
				

<div class="row">
	<div class="col-sm-8 blog-main">
		<h2 class="sub-header">직원</h2>
		<div class="table-responsive">
			<table class="table table-striped">
				<tr>
					<th>사번</th>
					<th>직원 이름</th>
					<th>담당직무</th>
					<th>입사일시</th>
				</tr>
				<%
					for(int i = 0; i < memList.size(); i++){
						MemberVo vo = memList.get(i);
						out.write("<tr>");
						out.write(    "<td>" + vo.getEmpno() + "</td>");
						out.write(    "<td>" + vo.getEname() + "</td>");
						out.write(    "<td>" + vo.getJob() + "</td>");
						out.write(    "<td>" + vo.getHiredate_fmt() + "</td>");
						out.write("<tr>");
					}
				%>
			</table>
		</div>

		<a class="btn btn-default pull-right"> 등록</a>

		<div class="text-center">
			<ul class="pagination">
				<li><a href="#">1</a></li>
				<li><a href="#">2</a></li>
				<li><a href="#">3</a></li>
				<li><a href="#">4</a></li>
				<li><a href="#">5</a></li>
			</ul>
		</div>
	</div>
</div>
	</div>
		</div>
	</div>
</body>
</html>