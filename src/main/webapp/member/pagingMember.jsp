<%@page import="kr.or.ddit.common.model.PageVo"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="kr.or.ddit.user.model.MemberVo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<meta name="description" content="">
<meta name="author" content="">
<link rel="icon" href="${cp }/../favicon.ico">

<title>user</title>
<link href="${cp }/css/bootstrap.min.css"
   rel="stylesheet">
<!-- Bootstrap core CSS -->
<link href="${cp }/css/dashboard.css"
   rel="stylesheet">
<link href="${cp }/css/blog.css"
   rel="stylesheet">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<%
List<MemberVo> userList = (List<MemberVo>) request.getAttribute("memList");
%>
<script>
	$(function(){
		$(".member").on("click", function(){
			//this : 클릭 이벤트가 발생한 element
			//data-속성명 data-userid, 속성명은 대소문자 무시하고 소문자로 인식
			//data-userId ==> data-userid
			var empno = $(this).data("empno");
			$("#empno").val(empno);
			$("#frm").submit();
		});
	});
</script>
</head>
<body>
	<form id="frm" action="${cp }/user" >
		<input type="hidden" id="userid" name="userid" value=""/>
	</form>
   <%@ include file="/common/header.jsp"%>
   <div class="container-fluid">
      <div class="col-sm-3 col-md-2 sidebar">
         <%@ include file="/common/left.jsp"%>
      </div>
      <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">

         <div class="row">
            <div class="col-sm-8 blog-main">
               <h2 class="sub-header">사용자</h2>
               <div class="table-responsive">
                  <table class="table table-striped">
                     <tr>
                        <th>직원번호</th>
                        <th>직원이름</th>
                        <th>직원업무</th>
                        <th>입사일시</th>
                     </tr>
                     <%
                     
                     for (MemberVo member : (List<MemberVo>)request.getAttribute("memList")) { %>
                        <tr class="member" data-empno="<%=member.getEmpno() %>">
                     		<td><%=member.getEmpno() %></td>
                     		<td><%=member.getEname() %></td>
                     		<td><%=member.getJob() %></td>
                     		<td><%=member.getHiredate_fmt() %></td>
                     	</tr>	
                     <%} %>
                  </table>
               </div>
               
               <a class="btn btn-default pull-right">사용자 등록</a>
                  <div class="text-center">
							<% PageVo pageVo  = (PageVo)request.getAttribute("pageVo");
							   int pagination =	(int)request.getAttribute("pagination");%>
							<ul class="pagination">
								
								<%-- pagination 값이 4이므로 1부터 4까지 4번 반복된다
								     전체 사용자수 : 16명
								     페이지 사이즈 : 5
								     전체 페이지 수 : 4페이지
								 --%> 
								 <li class="prev">
									<a href="${cp }/pagingMember?page=1&pageSize=<%=pageVo.getPageSize()%>">«</a>
								</li>
								<%for(int i = 1; i <= pagination; i++){
									
									if(pageVo.getPage() == i){%>
										<li class="active"><span><%=i %></span></li>
									<%}
									else {%>
										<li><a href="${cp }/pagingMember?page=<%=i %>&pageSize=<%=pageVo.getPageSize()%>"><%=i %></a></li>
									<%} %>
								<%} %>
								<li class="next">
									<a href="${cp }/pagingMember?page=<%=pagination %>&pageSize=<%=pageVo.getPageSize()%>">»</a>
								</li>
							</ul>
						</div>  
               
            </div>
         </div>
      </div>
   </div>
</body>
</html>