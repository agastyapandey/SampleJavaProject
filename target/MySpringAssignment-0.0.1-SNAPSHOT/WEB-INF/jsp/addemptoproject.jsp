<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
			
			<li role="presentation" class="dropdown  active">
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
<div class="panel-heading">

<c:choose>
    <c:when test="${not empty ePR}">
       <h3>Edit Employee</h3> 
    </c:when>    
    <c:otherwise>
       <h3>Add Employee</h3> 
    </c:otherwise>
</c:choose>

 on &nbsp;${project.getProject_name()} </div>
<br>
<br>
<p class="error">${errMsg}</p>
<form action="confirmassignproject" id="myform" method="post">
<input type="hidden"  id="pagename" name="pagename" value="addemptoproject">
<input type="hidden"  id="pid" name="pid" value="${project.getProject_id()}">
<b>&nbsp;&nbsp;&nbsp;Project:</b> &nbsp; ${project.getProject_name()}
<br><br>
&nbsp;&nbsp;	
<b>Employee:&nbsp;</b>
            <select name="eid">
            
           						 <c:choose>
    									<c:when test="${not empty ePR}">
       										<option value="${ePR.getEmployee().getEmp_id()}">${ePR.getEmployee().getEmp_fname()}&nbsp;${ePR.getEmployee().getEmp_lname()}</option>
    									</c:when>    
   										<c:otherwise>
        									<option value="">Select Employee</option>	 
   										 </c:otherwise>
								</c:choose>
            
            		
				<c:forEach var="listValue" items="${employees}">	
  					<option value="${listValue.getEmp_id()}">${listValue.getEmp_fname()}&nbsp;${listValue.getEmp_lname()}</option>
				</c:forEach>
			</select>
&nbsp;&nbsp;<b>Role:&nbsp;</b>
            <select name="rid">
            					<c:choose>
    									<c:when test="${not empty ePR}">
       										<option value="${ePR.getProjectRole().getRole().getRole_id()}">${ePR.getProjectRole().getRole().getRole_name()}</option>
    									</c:when>    
   										<c:otherwise>
        									<option value="">Select Role</option>	 
   										 </c:otherwise>
								</c:choose>
            					<c:forEach var="listValue" items="${roles}">	
  									<option value="${listValue.getRole_id()}">${listValue.getRole_name()}</option>
								</c:forEach>
			</select>

	
&nbsp;&nbsp;&nbsp;&nbsp;
<b>Assigned Date:&nbsp;</b>
<input type="date"  id="assignDate" name="assignDate" value="${ePR.getAssignDate()}">

&nbsp;&nbsp;&nbsp;&nbsp;
<b>Release Date:&nbsp;</b>
<input type="date"  id="releaseDate" name="releaseDate" value="${ePR.getReleaseDate()}">

&nbsp;&nbsp;
<input style="background-color:#ADEBFF"  type="submit" style="background-color:#ADEBFF"  value="Save">
<br>
<br>
<p style="color:red;">&nbsp;&nbsp;${errorMsg}</p>
<br>
</form>
</div>
</div>
</div>
<script src="<c:url value="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js" />"></script>
 <script src="<c:url value="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js" />"></script>
</body>
</html>