<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
 <link href="<c:url value="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css" />" rel="stylesheet">
 <style>
    .error {
        color: red;
    }
</style>
</head>
<body onload="setEmpStatus()">	
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
<form action="savesubtask" id="myform" method="post">
<c:choose>
<c:when test="${not empty subTask}">
<div class="panel-heading"><h3><b>Edit SubTask</b></h3></div>
<input type="hidden" name="subTaskId" value="${subTask.getSubTaskId()}">
</c:when>
<c:otherwise>
<div class="panel-heading"><h3><b>Add SubTask</b></h3></div>
</c:otherwise>
</c:choose>
<br>
<b>&nbsp;&nbsp;Project :</b> &nbsp;&nbsp; <b> ${task.getProject().getProject_name()} </b>
<br>
<br>
<b>&nbsp;&nbsp;Task Name:</b> &nbsp;&nbsp;<b> ${task.getTaskName()}</b>
<br>
<br>

<input type="hidden" name="task_id" value="${task.getTaskId()}">
<b>&nbsp;&nbsp;Sub Task Name:</b> &nbsp;&nbsp;&nbsp; <input type="text" name="taskName" value="${subTask.getTaskName()}">
<br>
<br>
<b>&nbsp;&nbsp;Sub Task Description :</b>
<br>
&nbsp;&nbsp;<textarea name="taskDescription" rows="4" cols="50" Value="">${subTask.getTaskDescription()}</textarea>
<br>
<br>
<b>&nbsp;&nbsp;Sub Priority :</b> (lesser no. has higher priority)
            <select name="taskPriority" value="${subTask.getTaskPriority()}">
            			<option value="5">Select Priority</option>
						<option value="1">1</option>
  						<option value="2">2</option>
  						<option value="3">3</option>
  						<option value="4">4</option>
  						<option value="5">5</option>
			</select>             
<br>
<br>
<b>&nbsp;&nbsp;Sub Complexity : </b>(higher no. has more complexity)
			<select name="taskComplexity" value="${subTask.getTaskComplexity()}">
            			<option value="5">Select Complexity</option>
						<option value="1">1</option>
  						<option value="2">2</option>
  						<option value="3">3</option>
  						<option value="4">4</option>
  						<option value="5">5</option>
			</select>            
<br>
<br>
<b>&nbsp;&nbsp;Sub Status :</b>
 			<select name="taskStatus" value="${subTask.getTaskStatus()}">
  						<option value="Pending">Pending</option>
  						<option value="Done">Done</option>
			</select>           
<br>
<br>
&nbsp;&nbsp;<input style="background-color:#ADEBFF"  type="submit" style="background-color:#ADEBFF"  value="Save">
<br>
<br>
</form>

</div>
</div>
</div>
 <script src="<c:url value="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js" />"></script>
 <script src="<c:url value="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js" />"></script>
</body>
</html>