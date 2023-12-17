<!DOCTYPE html>
<html>
<head>
<title>Add Student</title>
<link type="text/css" rel="stylesheet" href="CSS/style.css">
<link type="text/css" rel="stylesheet" href="CSS/add-student-style.css">
</head>
<body>
<div id="wrapper">
<div id="header">
<h2>Oasis Academy</h2>

</div>

</div>

<div id="container">
<h3>Add Student</h3>
<form action="StudContrlServ" method="get">
<input type="hidden" name="command" value="Add"/>
<tbody>
<tr>
<td><label> Student ID :</label></td>
<td><input type="text" name="sID"/></td>
</tr>
<tr>
<td><label> Name : </label></td>
<td><input type="text" name="name"/></td>
</tr>
<tr>
<td><label> Father's Name : </label></td>
<td><input type="text" name="fName"/></td>
</tr>


<tr>
<td><label> Mobile : </label></td>
<td><input type="text" name="mobile"/></td>
</tr>



<tr>
<td><label> Address : </label></td>
<td><input type="text" name="addr"/></td>
</tr>

<tr>
<td><label> </label></td>
<td><input type="submit" value="Save" class="save"/></td>
</tr>

</tbody>
</form>

<div style="clear:both;"></div>
<p>
<a href="StudContrlServ">Back to list</a>
</p>



</div>
</body>
</html>