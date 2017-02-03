<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
 <link href="<c:url value="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css" />" rel="stylesheet">
<title>Insert title here</title>
<style>
 ul{
 	list-style: none;
 	padding: 0px;
 }
 </style>
</head>
<body>
<div class="container">
 <div class="header clearfix">
        <nav>
          <ul class="nav nav-pills pull-right">
            <li role="presentation"><a href="/ProjectManagementSystem/">Home</a></li>
			 <li role="presentation" class="dropdown  active">
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

      
<div class="container">
<div class="jumbotron">
<div class="panel panel-info">
  <!-- Default panel contents -->
  <div class="panel-heading"><h3>List of All Employees</h3></div>
  
  <!-- Table -->
 <table class="table">
		<tr>

			<td><b>Employee Id.</b></td>
			<td><b>First Name</b></td>
			<td><b>Last Name</b></td>
			<td><b>Date Of Joining</b></td>
			<td><b>Status</b></td>
			<td><b>Access Card No.</b></td>
			<td><b>Action</b></td>
		</tr>
 	<c:if test="${not empty employees}">
			<c:forEach var="listValue" items="${employees}">
			<tr>
				<td>${listValue.getEmp_id()}</td>
				<td>${listValue.getEmp_fname()}</td>
				<td>${listValue.getEmp_lname()}</td>
				<td>${listValue.getEmp_doj()}</td>
				<td>${listValue.getEmp_status()}</td>
				<td>${listValue.getEmp_acn()}</td>
				<td>
				<ul><li role="presentation" class="dropdown">
        <a class="dropdown-toggle" data-toggle="dropdown" href="#" role="button" aria-haspopup="true" aria-expanded="false">
          Action <span class="caret"></span>
        </a>
        <ul class="dropdown-menu">
         <li><a href="assignprojecttoemp?eid=${listValue.getEmp_id()}">Assign Project</a></li>
        <li><a href="view?eid=${listValue.getEmp_id()}">View Details</a></li>
          <li><a href="insert_or_update?id=${listValue.getEmp_id()}">Edit</a></li>
          <li><a href="delete?id=${listValue.getEmp_id()}">Delete</a></li>
           <li><a href="assigntasktoemp?eid=${listValue.getEmp_id()}&pid=">Assign Task</a></li>
        </ul>
      </li></ul>
				</td>
			</tr>
			</c:forEach>
	</c:if>
	</table>
</div>
</div>
</div>
 <script src="<c:url value="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js" />"></script>
 <script src="<c:url value="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js" />"></script>
</body>
</html>