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
<h3>Employee Details</h3>
</div>
</div>
<c:if test="${not empty employee}">

<div style="margin-left:20px;">
<b><div style="width:120px;float:left;">Emp Id </div>: &nbsp;&nbsp; ${employee.getEmp_id()}</b><br>
<div style="width:120px;float:left;"><b>Employee Name </div>: &nbsp;&nbsp;&nbsp;</b>${employee.getEmp_fname()}&nbsp;&nbsp;${employee.getEmp_lname()}<br/>
<div style="width:120px;float:left;"><b>Project Name</div>: &nbsp;&nbsp;</b> ${project.getProject_name()}<br/>
</div>
</c:if>
</div>
<%-- <p align="right"><a href="assignprojecttoemp?eid=${emp.getEmp_id()}"><b>Assign Project</b></a></p> --%>
<c:choose>
    <c:when test="${not empty empTask}">
<h3>&nbsp;List of Tasks :</h3>
<table class="table">
		<tr>
			<td><b>Task Name</b></td>
			<td><b>Task Complexity</b></td>
			<td><b>Task Priority</b></td>
			<td><b>Task Status</b></td>
			<td><b>Action</b></td>
		</tr>
			<c:forEach var="listValue" items="${empTask}">
			<tr>
				<td>${listValue.getTask().getTaskName()}</td>
				<td>&nbsp;${listValue.getTask().getTaskComplexity()}</td>
				<td>&nbsp;${listValue.getTask().getTaskPriority()}</td>
				<td>&nbsp;${listValue.getTask().getTaskStatus()}</td>
				<td>
				<ul><li role="presentation" class="dropdown">
        <a class="dropdown-toggle" data-toggle="dropdown" href="#" role="button" aria-haspopup="true" aria-expanded="false">
          Action <span class="caret"></span>
        </a>
        <ul class="dropdown-menu">
          <li><a href="addtasktoproject?pid=${project.getProject_id()}&task_id=${listValue.getTask().getTaskId()}">Edit</a></li>
          <li><a href="taskdetail?task_id=${listValue.getTask().getTaskId()}">View SubTask</a></li>
           <li><a href="unassigntask?eTId=${listValue.getEmployeeTaskId()}">Remove Task</a></li>
        </ul>
      </li></ul>
				</td>
			</tr>
			</c:forEach>
	</table>
 </c:when>    
    <c:otherwise>
       <p class="error" align="center">${employee.getEmp_fname()}&nbsp;${employee.getEmp_lname()} has not any task on ${project.getProject_name()} </p>
    </c:otherwise>
</c:choose>
</div>
 <script src="<c:url value="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js" />"></script>
 <script src="<c:url value="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js" />"></script>
</body>
</html>