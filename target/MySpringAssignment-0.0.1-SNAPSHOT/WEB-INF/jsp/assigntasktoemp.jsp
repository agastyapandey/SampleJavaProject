<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link
	href="<c:url value="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css" />"
	rel="stylesheet">
<style>
.error {
	color: red;
}
</style>
<script>
	function displayTasksProject(str) {
		var xmlhttp;
		if (str == "") {
			document.getElementById("txtHint").innerHTML = "";
			return;
		}
		if (window.XMLHttpRequest) {
			xmlhttp = new XMLHttpRequest();

		} else {
			xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
		}
		xmlhttp.onreadystatechange = function() {
			if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
				var text = xmlhttp.responseText;
				var obj = JSON.parse(text);
				var resText =null;
				if(obj.length==0){
					 resText = "No Task added in this project.<a href='addtasktoproject?pid="+str+"'>add task</a>";
					document.getElementById("taskOption").innerHTML = resText;
					} else{
						 resText = '<select name="tid" id="optionDisplay"  value=""><option value="">Select Tasks</option>"';
						 for (var i = 0; i < obj.length; i++) {
								str2 = "<option value="+obj[i].taskId+">" + " "
										+ obj[i].taskName + "</option>";
								resText = resText.concat(str2);
							}
							resText = resText.concat("</select>");
					}
				document.getElementById("taskOption").innerHTML = resText;
				document.getElementById("task-label").style.display="inline-block";
				document.getElementById("taskOption").style.display="inline-block";
			}
		}
		xmlhttp.open("GET", "gettasksofproject?pid=" + str, true);
		xmlhttp.setRequestHeader("Accept", "application/json");
		xmlhttp.send();
	}
</script>
</head>
<body>
	<div class="container">
		<div class="header clearfix">
			<nav>
			<ul class="nav nav-pills pull-right">
				<li role="presentation"><a href="/ProjectManagementSystem/">Home</a></li>
				<li role="presentation" class="dropdown active"><a
					class="dropdown-toggle" data-toggle="dropdown" href="#"
					role="button" aria-haspopup="true" aria-expanded="false">
						Employees <span class="caret"></span>
				</a>
					<ul class="dropdown-menu">
						<li><a href="insert_or_update">Add Employee</a></li>
						<li><a href="listemployee">View Employee</a></li>
					</ul></li>

				<li role="presentation" class="dropdown"><a
					class="dropdown-toggle" data-toggle="dropdown" href="#"
					role="button" aria-haspopup="true" aria-expanded="false">
						Projects <span class="caret"></span>
				</a>
					<ul class="dropdown-menu">
						<li><a href="insertproject">Add Project</a></li>
						<li><a href="listproject">View Projects</a></li>
						<li><a href="addtask">Add Task</a></li>
					</ul></li>
				<li role="presentation" class="dropdown"><a
					class="dropdown-toggle" data-toggle="dropdown" href="#"
					role="button" aria-haspopup="true" aria-expanded="false"> Roles
						<span class="caret"></span>
				</a>
					<ul class="dropdown-menu">
						<li><a href="insertrole">Add role</a></li>
						<li><a href="listrole">View Role</a></li>
					</ul></li>

			</ul>
			</nav>
			<h3 class="text-muted">Project Management System</h3>
		</div>
	</div>

<form action="saveemptask" method="post">
	<div class="container">
		<div class="jumbotron">
			<div class="panel panel-info">
				<div class="panel-heading">
					<h3>
						<b>Assign Task</b>
					</h3>
				</div>
					<br>
					<br> <b>&nbsp;&nbsp;Employee :</b> &nbsp;&nbsp;
					${employee.getEmp_fname()} &nbsp; ${employee.getEmp_lname()}
					<input name="eid" type="hidden" value="${employee.getEmp_id()}">
					
					<c:choose>
						<c:when test="${not empty ePR}">
							&nbsp;&nbsp;&nbsp;&nbsp;
							<b>&nbsp;&nbsp;Project :&nbsp;&nbsp;&nbsp;&nbsp;</b>
							<select name="pid" onchange="displayTasksProject(this.value)">
								<option value="0">Select Project</option>
								<c:forEach var="listValue" items="${ePR}">
									<option
										value="${listValue.getProjectRole().getProject().getProject_id()}">${listValue.getProjectRole().getProject().getProject_name()}</option>
								</c:forEach>
							</select>
							&nbsp;&nbsp;&nbsp;&nbsp;
							
							<b  id="task-label" style="display:none">&nbsp;&nbsp;Tasks :&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</b>
							<div id="taskOption"></div>
							<br>
							<br>
&nbsp;&nbsp;<input style="background-color: #ADEBFF" type="submit"
								style="background-color:#ADEBFF" value="Assign Task">
							<br>
							<br>
							<br>
				</c:when>
				<c:when test="${not empty project}">
				<input type="hidden" name="pid" value="${project.getProject_id()}">
							&nbsp;&nbsp;&nbsp;&nbsp;
							<b>&nbsp;&nbsp;Project :&nbsp;&nbsp;&nbsp;&nbsp;</b>${project.getProject_name()}
							
								&nbsp;&nbsp;&nbsp;&nbsp;
								<b>&nbsp;&nbsp;Tasks :&nbsp;&nbsp;&nbsp;&nbsp;</b>
								<select name="tid">
									<option value="">Select Task</option>
									<c:forEach var="listValue" items="${tasks}">
									<option
										value="${listValue.getTaskId()}">${listValue.getTaskName()}</option>
									</c:forEach>
								</select>

							<br>
							<br>
&nbsp;&nbsp;<input style="background-color: #ADEBFF" type="submit"
								style="background-color:#ADEBFF" value="Assign Task">
							<br>
							<br>
							<br>
				</c:when>
				<c:otherwise>
					<p style="color: red;" align="center">${errMsg}</p>
					<p align="center">
						<a href="assignprojecttoemp?eid=${employee.getEmp_id()}">Assign
							Project</a>
					</p>
				</c:otherwise>
				</c:choose>
			</div>
		</div>
	</div>
	</form>
	<script
		src="<c:url value="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js" />"></script>
	<script
		src="<c:url value="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js" />"></script>
</body>
</html>