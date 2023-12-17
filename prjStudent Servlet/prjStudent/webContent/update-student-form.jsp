<!DOCTYPE html>
<html>
<head>
<title>Update Student</title>
<link type="text/css" rel="stylesheet" href="CSS/style.css">
<link type="text/css" rel="stylesheet" href="CSS/add-student-style.css">
</head>
<body>
<div id="wrapper">
<div id="header">
<h2>FooBar University</h2>

</div>

</div>

<div id="container">
<h3>Update Student</h3>
<form action="StudContrlServ" method="get">
<input type="hidden" name="command" value="UPDATE" />
<input type="hidden" name="sID" value="${THE_STUDENT.studID}" />

<table>
<tbody>
<tr>
<td><label> Student ID :</label></td>
<td><input type="text" name="sID"
			value="${THE_STUDENT.studID}" /></td>

</tr>

<tr>
<td><label> Name : </label></td>
<td><input type="text" name="Name"
    value="${THE_STUDENT.sName}"/></td>
</tr>




<tr>
<td><label>Father Name : </label></td>
<td><input type="text" name="fName"
    value="${THE_STUDENT.fName}"/></td>
</tr>


<tr>
<td><label> Mobile : </label></td>
<td><input type="text" name="Mobile"
    value="${THE_STUDENT.sMobile}"/></td>
</tr>



<tr>
<td><label> Address : </label></td>
<td><input type="text" name="addr"
    value="${THE_STUDENT.sAddress}"/></td>
</tr>

<tr>
<td><label></label></td>
<td><input type="submit" value="Save" class="save"/></td>
</tr>

</tbody>
</table>
</form>

<div style="clear:both;"></div>
<p>
<a href="StudContrlServ">Back to list</a>
</p>

</div>
</body>
</html>