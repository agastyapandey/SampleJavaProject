<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Employee Role</title>
 <link href="<c:url value="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css" />" rel="stylesheet">
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
	     	 <li role="presentation" class="dropdown active">
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
  <!-- Default panel contents -->
  <div class="panel-heading"><h3>List of Roles</h3></div>
  
  <!-- Table -->
 <table class="table">
		<tr>

			<td><b>Role Id.</b></td>
			<td><b>Role Name</b></td>
			<td><b>Edit</b></td>
			<td><b>Delete</b></td>
		</tr>
 	<c:if test="${not empty roles}">
			<c:forEach var="listValue" items="${roles}">
			<tr>
				<td>${listValue.getRole_id()}</td>
				<td>${listValue.getRole_name()}</td>
				<td><a href="insertrole?rid=${listValue.getRole_id()}">Edit </a></td>
				<td><a href="deleterole?rid=${listValue.getRole_id()}">Delete </a></td>
			</tr>
			</c:forEach>
	</c:if>
	</table>
	</div>
	</div>
 <script src="<c:url value="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js" />"></script>
 <script src="<c:url value="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js" />"></script>

</body>
</html>