<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>

<title>Student Tracker App</title>
</head>
<!-- <link type="text/css" rel="stylesheet" href="CSS/style.css">-->

<body>
<div id="wrapper">
<div id="header">
<h2>Oasis Academy</h2>
</div>
</div>

<div id="container">
<div id="content">
<INPUT TYPE="BUTTON" value="Add Student"
onclick="window.location.href='add-stud-form.jsp';return false;"
class="add-student-button"/>
<table>
<tr>
<th>Stud ID</th>
<th>Name</th>
<th>fName</th>
<th>Mobile</th>
<th>Address</th>
</tr>
<c:forEach var="tStud" items="${STUDENT_LIST}">
		
		<!-- set up a link for each student -->
			<c:url var="tempLink" value="StudContrlServ">
				<c:param name="command" value="LOAD" />
				<c:param name="studId" value="${tStud.studID}" />
			</c:url>
	
			<!--  set up a link to delete a student -->
			<c:url var="deleteLink" value="StudContrlServ">
				<c:param name="command" value="DELETE" />
				<c:param name="studId" value="${tStud.studID}" />
			</c:url>
			
		 	<tr>
		    	<td> ${tStud.studID}</td>
		    	<td> ${tStud.sName}</td>
		    	<td> ${tStud.fName}</td>
		    	<td> ${tStud.sMobile}</td>
		    	<td> ${tStud.sAddress}</td>
		    	<td> 
					<a href="${tempLink}">Update</a> 
					 | 
					<a href="${deleteLink}"
					onclick="if (!(confirm('Are you sure you want to delete this+ ${tStud.studID} + student?'))) return false">
					Delete</a>	
				</td>
		    	
		 	</tr> 
		</c:forEach>

</table>



</div>
</div>



</body>
</html>





































<%-- <c:forEach var="tStud" items="${STUDENT_LIST}">
<tr>
<td> ${tStud.studID}</td>
<td> ${tStud.sName}</td>
<td> ${tStud.fName}</td>
<td> ${tStud.sMobile}</td>
<td> ${tStud.sAddress}</td>
</tr>
</c:forEach>




</table>



</div>
</div>



</body>
</html> --%>