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
<h3>Project Details</h3>
</div>
</div>
<c:if test="${not empty project}">
<div style="margin-left:20px;">
<div style="width:120px;float:left;"><b>Project name </div>: &nbsp;&nbsp;&nbsp;</b>${project.getProject_name()}<br/>
<div style="width:120px;float:left;"><b>Start Date</div>: &nbsp;&nbsp;</b> ${project.getStart_date()}<br/>
<div style="width:120px;float:left;"><b>End Date</div>: &nbsp;&nbsp;</b> ${project.getEnd_date()}<br/>
</div>
</c:if>
</div>

<p align="right"><a href="addemptoproject?pid=${project.getProject_id()}"><b>Add Employee</b></a></p>

<c:choose>
    <c:when test="${not empty ePR}">
       
       <h3>&nbsp;List of Employees :</h3>
<table class="table">
		<tr>
			<td><b>Employee</b></td>
			<td><b>Role</b></td>
			<td><b>Assign Date</b></td>
			<td><b>Release Date</b></td>
			<td><b>Action</b></td>
		</tr>
			<c:forEach var="listValue" items="${ePR}">
			<tr>
				<td>${listValue.getEmployee().getEmp_fname()}&nbsp;${listValue.getEmployee().getEmp_lname()}</td>
				<td>${listValue.getProjectRole().getRole().getRole_name()}</td>
				<td>${listValue.getAssignDate()}</td>
				<td>${listValue.getReleaseDate()}</td>
				<td>
				<ul><li role="presentation" class="dropdown">
        <a class="dropdown-toggle" data-toggle="dropdown" href="#" role="button" aria-haspopup="true" aria-expanded="false">
          Action <span class="caret"></span>
        </a>
        <ul class="dropdown-menu">
          <li><a href="assignprojecttoemp?eid=${listValue.getEmployee().getEmp_id()}&ePRID=${listValue.getEmployeeProjectRoleId()}">Edit</a></li>
          <li><a href="unassignproject?ePRID=${listValue.getEmployeeProjectRoleId()}&pagename=viewempofproject">Unassign Project</a></li>
          <li><a href="viewemptaskonproject?eid=${listValue.getEmployee().getEmp_id()}&pid=${project.getProject_id()}">View Task</a></li>
           <li><a href="assigntasktoemp?eid=${listValue.getEmployee().getEmp_id()}&pid=${project.getProject_id()}">Assign Task</a></li>
        </ul>
      </li></ul>
				</td>
			</tr>
			</c:forEach>
	</table>
           
    </c:when>    
    <c:otherwise>
       <p class="error" align="center">No employee on this project</p>
    </c:otherwise>
</c:choose>

</div>
 <script src="<c:url value="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js" />"></script>
 <script src="<c:url value="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js" />"></script>
</body>
</html>