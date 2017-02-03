<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Project</title>
<link href="<c:url value="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css" />" rel="stylesheet">
<style>
    .error {
        color: red;
    }
</style>
</head>

<body>
<div class="container">
 <div class="header clearfix">
        <nav>
          <ul class="nav nav-pills pull-right">
            <li role="presentation"><a href="/ProjectManagementSystem/">Home</a></li>
			 <li role="presentation" class="dropdown">
	        		<a class="dropdown-toggle" data-toggle="dropdown" href="#" role="button" aria-haspopup="true" aria-expanded="false">
	         			Employees <span class="caret"></span>
	        		</a>
	        		<ul class="dropdown-menu">
	          			<li><a href="insert_or_update">Add Employee</a></li>
	          			<li><a href="listemployee">View Employee</a></li>
	       		 	</ul>
	     	 </li>
			
			<li role="presentation" class="dropdown active">
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
      
<form:form method="POST" action="saveproject" commandName="project1">    
 <div class="container">
<div class="jumbotron">
<div class="panel panel-info">
<div class="panel-heading">
 
<c:choose>
<c:when test="${not empty project}">
<h3><b>Edit Project</b></h3>
<input type="hidden" name="project_id" value="${project.getProject_id()}">
</div>
</div>
</c:when>
<c:otherwise>
<h3><b>Add Project</b></h3>
</div>
</div>
</c:otherwise>
</c:choose>
<br>
<b>&nbsp;&nbsp;Project Name:</b>
<br>
&nbsp;&nbsp;<input type="text" id="project_name" name="project_name"  value="${project.getProject_name()}" placeholder="Project Name"> <form:errors path="project_name" cssClass="error" />
<br>
<br>
<b>&nbsp;&nbsp;Start Date:</b>
<br>
&nbsp;&nbsp;<input type="date"  id="start_date" name="start_date" value="${project.getStart_date()}" placeholder="MM/DD/YYYY"><form:errors path="start_date" cssClass="error" />
<br>
<br>
<b>&nbsp;&nbsp;End Date:</b>
<br>
&nbsp;&nbsp;<input type="date"  id="end_date" name="end_date" value="${project.getEnd_date()}" placeholder="MM/DD/YYYY"><form:errors path="end_date" cssClass="error" />
<br>
<br>
<br>
&nbsp;&nbsp;<input style="background-color:#ADEBFF"  type="submit" style="background-color:#ADEBFF"  value="Save">
<input style="background-color:#ADEBFF" onClick="window.location.href='listproject'" type="button" Value="Back">
<br>

</div>
</div>
</form:form>
 <script src="<c:url value="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js" />"></script>
 <script src="<c:url value="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js" />"></script>
</body>
</html>