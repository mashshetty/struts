<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib uri="http://struts.apache.org/tags-html" prefix="h"%>
<%@ taglib prefix="logic" uri="http://struts.apache.org/tags-logic"%>
<%@ taglib prefix="bean" uri="http://struts.apache.org/tags-bean"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="reg.css?ver-2.6" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View User</title>
</head>
<body>



<div id="viewpage" class="container">

			<div class="box">
			<h1 class="viewuser">View User</h1>
				<table>

					<tr>
						<th>User ID</th>
						<td><bean:write name="UserForm" property="uid" /></td>
					</tr>
					<tr>
						<th>First Name</th>
						<td><bean:write name="UserForm" property="fname" /></td>
					</tr>
					<tr>
						<th>Last Name</th>
						<td><bean:write name="UserForm" property="lname" /></td>
					</tr>
					<tr>
						<th>Gender</th>
						<td><bean:write name="UserForm" property="gender" /></td>
					</tr>
					<tr>
						<th>Email</th>
						<td><bean:write name="UserForm" property="email" /></td>
					</tr>
					
					<tr>
						<th>DOB</th>
						<td><bean:write name="UserForm" property="dob" /></td>
					</tr>
					<tr>
						<th>Email Notification</th>
						<td><bean:write name="UserForm" property="emailnot" /></td>
					</tr>
					<tr>
						<th>Address 1</th>
						<td><bean:write name="UserForm" property="adress1" /></td>
					</tr>
					<tr>
						<th>State</th>
						<td><bean:write name="UserForm" property="state" /></td>
					</tr>
					<tr>
						<th>City</th>
						<td><bean:write name="UserForm" property="city" /></td>
					</tr>
					<tr>
						<th>Address 2</th>
						<td><bean:write name="UserForm" property="adress2" /></td>
					</tr>
					<tr>
						<th>Pincode</th>
						<td><bean:write name="UserForm" property="pincode" /></td>
					</tr>
				</table>
				
				<button  class="viewx" id="backbtn">Go back</button>

				
			</div>
			</div>
	
</body>
</html>