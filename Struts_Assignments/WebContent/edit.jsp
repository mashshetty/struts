<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="h"%>
<%@ taglib prefix="logic" uri="http://struts.apache.org/tags-logic"%>
<%@ taglib prefix="bean" uri="http://struts.apache.org/tags-bean"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>edit user</title>
<link rel="stylesheet" href="reg.css?ver-2.6" />
<script src="https://code.jquery.com/jquery-3.6.0.min.js"
	type="text/javascript"></script>
<script
	src="https://cdn.jsdelivr.net/jquery.validation/1.16.0/jquery.validate.min.js"
	type="text/javascript"></script>
<script type="text/javascript" src="jscript.js">

</script>
</head>
<body>

<div class="container">

		<div class="box">
			<form class="myForm" id="myForm" action="adduser.do?update=true" method="post" >
				<h1 class="viewuser">Edit User</h1>
				<span class="label"> Enter User ID*</span> <br />
				<h:text name="editdata" property="uid" />
				<br />
				<span class="label"> Enter First Name*</span> <br />
				<h:text name="editdata" property="fname" />
				<br /> <span class="label"> Enter Last Name*</span> <br />
				<h:text name="editdata" property="lname" />
				<br /> <span class="label">Choose Gender</span> <br />
				<h:radio name="editdata" property="gender" value="Male" />
				<h:radio name="editdata" property="gender" value="Female" />
				<br /> <span class="label"> Enter DOB</span> <br />
				<h:text name="editdata" property="dob" />
				<br /> <span class="label"> Enter Email*</span> <br />
				<h:text name="editdata" property="email" />
				<br /> <span class="label"> Email Notification</span>

				<h:checkbox name="editdata" property="emailnot" />
				<br /> <span class="label"> EnterAddress1</span> <br />
				<h:text name="editdata" property="adress1" />
				<br /> <span class="label"> Enter Address2</span> <br />
				<h:text name="editdata" property="adress2" />
				<br /> <span class="label">State</span> <select value=<bean:write name="editdata" property="state" /> id="state"
					name="state">
					<option value="">--Select State--</option>
					<option value="CA">California</option>
					<option value="NY">New York</option>
					<option value="TX">Texas</option>
				</select> <br /> <br /> <span class="label"> City</span> <select value=<bean:write name="editdata" property="city" /> id="city"
					name="city">
					<option value="">--Select City--</option>
				</select> <br /> <span class="label"> Enter Pincode</span> <br />
				<h:text name="editdata" property="pincode" />
				<br />
				<hr>
				
				<input type="submit" value="update" class="editsub" />

				<h:errors />
			</form>
		</div>
	</div>
</body>
</html>