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
<div class="panel-heading">
<form:form method="POST" action="save_or_update?id=${emp.getEmp_id()}" commandName="employee1">
<c:choose>
<c:when test="${not empty emp.getEmp_id()}">
<h3><b>Edit Employee details</b></h3>

</div>
</div>
<input type="hidden" id="Emp_id" name="Emp_id"  value="${emp.getEmp_id()}">
<br>
<b>Employee Id: ${emp.getEmp_id()}</b>
<br>
</c:when>
<c:otherwise>
<h3><b>Add Employee</b></h3>
</div>
</div>
</c:otherwise>
</c:choose>
<br>

<div style="margin-left:20px;">
<b>First name:</b><br>
<input type="text" id="Emp_fname" name="Emp_fname"  value="${emp.getEmp_fname()}" placeholder="First Name"><form:errors path="Emp_fname" cssClass="error" />
<br>
<br>
<b>Last name:</b><br>
<input type="text" id="Emp_lname" name="Emp_lname" onkeyup="validateLname()" value="${emp.getEmp_lname()}" placeholder="First Name">
<br>
<br>
<b>Joining Date:</b><br>
<input type="date"  id="Emp_doj" name="Emp_doj" value="${emp.getEmp_doj()}" placeholder="MM/DD/YYYY"><form:errors path="Emp_doj" cssClass="error" />
<br>
<br>
<b>Status:</b>
<select name="Emp_status">
  <option value="Active">Active</option>
  <option value="Inactive">Inactive</option>
</select><form:errors path="Emp_status" />
<br>
<br>
<b>Access Card No:</b><br>
<input type="text" id="Emp_acn" name="Emp_acn" onkeyup="validateAcn()" value="${emp.getEmp_acn()}" placeholder="Access Card No."><form:errors path="Emp_acn" cssClass="error" />
<br>
<br>
<br>

<input style="background-color:#ADEBFF"  type="submit" style="background-color:#ADEBFF"  value="Save">
<input style="background-color:#ADEBFF" onClick="window.location.href='listemployee'" type="button" Value="Back">
<br>

</div>

</div>
</div>
</form:form>
 <script src="<c:url value="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js" />"></script>
 <script src="<c:url value="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js" />"></script>
</body>
</html>