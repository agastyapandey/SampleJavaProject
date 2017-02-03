<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
 <link href="<c:url value="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css" />" rel="stylesheet">
 <style>
 ul{
 	list-style: none;
 	padding: 0px;
 }
 .error {
        color: red;
    }
 </style>
</head>

<body>
<jsp:include page="style.jsp"></jsp:include>
<div class="container">
 <div class="header clearfix">
        <nav>
          <ul class="nav nav-pills pull-right">
            <li role="presentation"><a href="/ProjectManagementSystem/">Home</a></li>
			 <li role="presentation" class="dropdown active">
	        		<a class="dropdown-toggle" data-toggle="dropdown" href="#" role="button" aria-haspopup="true" aria-expanded="false">
	         			Employees <span class="caret"></span>
	        		</a>
	        		<ul class="dropdown-menu">
	          			<li><a href="insert_or_update">Add Employee</a></li>
	          			<li><a href="listemployee">View Employee</a></li>
	       		 	</ul>
	     	 </li>
			
			<li role="presentation" class="dropdown">
	        		<a class="dropdown-toggle" data-toggle="dropdown" href="#" role="button" aria-haspopup="true" aria-expanded="false">
	         			Projects <span class="caret"></span>
	        		</a>
	        		<ul class="dropdown-menu">
	        			<li><a href="insertproject">Add Project</a></li>
	        			<li><a href="listproject">View Projects</a></li>
	        			<li><a href="addtask">Add Task</a></li>
	       		 	</ul>
	     	 </li>
	     	 <li role="presentation" class="dropdown">
	        		<a class="dropdown-toggle" data-toggle="dropdown" href="#" role="button" aria-haspopup="true" aria-expanded="false">
	         			Roles <span class="caret"></span>
	        		</a>
	        		<ul class="dropdown-menu">
	          			<li><a href="insertrole">Add role</a></li>
	          			<li><a href="listrole">View Role</a></li>
	       		 	</ul>
	     	 </li>
			
          </ul>
        </nav>
        <h3 class="text-muted">Project Management System</h3>
      </div>
 </div>
<div class="container">
<div class="jumbotron">
<div class="panel panel-info">
<div class="panel-heading">
<h3>Sub Task Details</h3>
</div>
</div>
<c:if test="${not empty subTask}">

<div style="margin-left:20px;">
<div style="width:120px;float:left;"><b>Project Name </b></div>: &nbsp;&nbsp;&nbsp;<b>${subTask.getTask().getProject().getProject_name()}</b><br/><br/>
<div style="width:120px;float:left;"><b>Task Name </b></div>: &nbsp;&nbsp;&nbsp;${subTask.getTask().getTaskName()}<br/><br/>
<div style="width:120px;float:left;"><b>Sub Task Name </b></div>: &nbsp;&nbsp;&nbsp;${subTask.getTaskName()}<br/><br/>
<div style="width:150px;float:left;"><b>Sub Task Description</b> </div>: &nbsp;&nbsp; ${subTask.getTaskDescription()} <br/><br/>
<div style="width:150px;float:left;"><b>Sub Task Complexity</b></div>: &nbsp;&nbsp; ${subTask.getTaskComplexity()} <br/><br/>
<div style="width:120px;float:left;"><b>Sub Task Priority</b></div>: &nbsp;&nbsp;&nbsp;${subTask.getTaskPriority()} <br/><br/>
<div style="width:120px;float:left;"><b>Sub Task Status</b></div>: &nbsp;&nbsp;${subTask.getTaskStatus()}<br/><br/>
</div>
</c:if>
<br>
<br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input style="background-color:#ADEBFF" onClick="window.location.href='taskdetail?task_id=${subTask.getTask().getTaskId()}'" type="button" Value="Back">

</div>
</div>
 <script src="<c:url value="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js" />"></script>
 <script src="<c:url value="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js" />"></script>
</body>
</html>