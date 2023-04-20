<%@ taglib uri="http://struts.apache.org/tags-html" prefix="h"%>
<%@ taglib prefix="logic" uri="http://struts.apache.org/tags-logic"%>
<%@ taglib prefix="bean" uri="http://struts.apache.org/tags-bean"%>
<%@ page import="com.assignment.UserForm" %>
<html>
<head>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"
	type="text/javascript"></script>
	<link rel="stylesheet" href="reg.css?v=7.4"/>
<script
	src="https://cdn.jsdelivr.net/jquery.validation/1.16.0/jquery.validate.min.js"
	type="text/javascript"></script>
<script type="text/javascript" src="jscript.js?v=8.2">
</script>
<link rel="stylesheet" href="https://cdn.datatables.net/1.13.4/css/jquery.dataTables.css" />
<script src="https://cdn.datatables.net/1.13.4/js/jquery.dataTables.js"></script>
<script src="https://code.jquery.com/ui/1.13.0/jquery-ui.min.js"></script>
<link rel="stylesheet" href="https://code.jquery.com/ui/1.13.0/themes/base/jquery-ui.css">
</head>
<body>




<script>
  $(document).ready(function() {
    $('.datepicker').datepicker({
      dateFormat: 'yy-mm-dd',
      maxDate: new Date(),
      changeMonth: true,
      numberOfMonths: 1,
      changeYear: true,
      yearRange: "1900:+0"  
    });
  });
</script>
<%

String myAttribute = (String) session.getAttribute("edit");
String state = (String) request.getAttribute("state");
String city = (String) request.getAttribute("city");
%>


	<div class="container" id="formcontainer">
	<%
	String insert = (String) request.getAttribute("insert");
	String update = (String) request.getAttribute("update");
	boolean val = Boolean.parseBoolean( (String) session.getAttribute("view"));
	%>
	<%if(insert!=null){
		%><p class="insertmsg"><%=insert %></p><% 
	}%>
	<%if(update!=null){
		%><p class="insertmsg"><%=update %></p><% 
	}%>
	
	
		<div class="box">
		
			<form id="myForm" class="addform" action="<%=request.getContextPath()%>/adduser.do?insert=true"
				method="post">
				<h:form action="adduser.do?insert=true"	method="post">
				<%if(session.getAttribute("edit")=="true" && session.getAttribute("view")!="true"){
					%>
					<h1>Edit User </h1>
					<% 
				} %>
				<%if(session.getAttribute("view")=="true" ){
					%>
					<h1>View User </h1>
					<% 
				} %>
				<%if(session.getAttribute("add")=="true" ){
					%>
					<h1>Add User </h1>
					<% 
				} %>
				
				<span class="label"> Enter User ID*</span> <br />
				<h:text name="UserForm" property="uid"  readonly="true" />
				<br />
				
				<span class="label"> Enter First Name*</span> <br />
				<h:text name="UserForm" property="fname" readonly="<%= val %>" />
				<br /> <span class="label"> Enter Last Name*</span> <br />
				<h:text name="UserForm" property="lname" readonly="<%= val %>" />
				<br /> <span class="label">Choose Gender</span> <br />
				<h:radio name="UserForm" property="gender" value="Male" disabled="<%= val %>"    /> <span>Male</span>
				<h:radio name="UserForm" property="gender" value="Female"  disabled="<%= val %>"/> <span>Female</span>
				<br /> <span class="label"> Enter DOB</span> <br />
				<h:text name="UserForm" property="dob" styleClass="datepicker" readonly="<%= val %>"/>
				<br /> <span class="label"> Enter Email*</span> <br />
				<h:text name="UserForm" property="email" readonly="<%= val %>"  />
				<br /> <span class="label"> Email Notification</span>
				<h:checkbox name="UserForm" property="emailnot" />
				<br /> <span class="label"> Enter Address1</span> <br />
				<h:text name="UserForm" property="adress1" readonly="<%= val %>"/>
				
				<br /> <span class="label"> Enter Address2</span> <br />
				<h:text name="UserForm" property="adress2" readonly="<%= val %>" />

				
			<%if(session.getAttribute("view")=="true"){
				%>
				<br /> <span class="label">State</span> <select id="state"
					 name="state" disabled />">
					 	<%if(session.getAttribute("edit")=="true" || session.getAttribute("view")=="true"){
					%>
					<option value="TX" selected><%= state %></option>
					<% 
				}%>
					<option value="">--Select State--</option>
					<option value="CA">California</option>
					<option value="NY">New York</option>
					<option value="TX">Texas</option>
				</select> <br /> <br />
				<% 
				
			}else{
				%>
				<br /> <span class="label">State</span> <select id="state"
					 name="state" />">
					 	<%if(session.getAttribute("edit")=="true" || session.getAttribute("view")=="true"){
					%>
					<option value="TX" selected><%= state %></option>
					<% 
				}%>
					<option value="">--Select State--</option>
					<option value="CA">California</option>
					<option value="NY">New York</option>
					<option value="TX">Texas</option>
				</select> <br /> <br />
				<%
			}%>
			
				
				
				 <span class="label"> City</span> <select id="city"
					name="city" >
						<%if(session.getAttribute("edit")=="true" || session.getAttribute("view")=="true"){
					%>
					<option value="mumbai" selected><%= city %></option>
					<% 
				}%>
					<option value="">--Select City--</option>
				</select> <br /> <span class="label"> Enter Pincode</span> <br />
				<h:text name="UserForm" property="pincode" readonly="<%= val %>" />
				<br />
				<hr>
				<% if(session.getAttribute("view")!="true"){
					
					%>
					<input type="submit" value="submit" id="addbtn"/>
					<%} %>
					<%if(session.getAttribute("view")=="true" ){
					%>
					<a class="backlink" href="adduser.do">Go back</a>
					<% 
				} %>
				
				</h:form>
			</form>
		</div>
	</div>

	<div id="dropbox" class="dropbox">
		<div class="modal">
			<h2 class="sd">Are you sure want to delete?</h2>
			<div class="btns">

				<input class="del" type="button" value="Delete" /> <input
					class="cancel" type="button" value="cancel" />
			</div>

		</div>

	</div>


	<%
		if (request.getAttribute("data") != null) {
	%>

	<div class="tc">
	<table id="myTable" class="display">
	
	 <thead>
        <tr>
            <th>User Id</th>
            <th>First Name</th>
            <th>Last Name</th>
            <th>Gender</th>
            <th>Email</th>
            <th>Dob</th>
            <th>Notification</th>
            <th>Address1</th>
            <th>State</th>
            <th>City</th>
            <th>Address2</th>
            <th>Pincode</th>
            <th>Actions</th>
            
        </tr>
    </thead>


		<logic:iterate name="data" id="UserForm">
			
			
		<tbody>
					<tr>
					
						<td><bean:write name="UserForm" property="uid" /></td>
					
						<td><bean:write name="UserForm" property="fname" /></td>
					
						<td><bean:write name="UserForm" property="lname" /></td>
				
						<td><bean:write name="UserForm" property="gender" /></td>
					
						<td><bean:write name="UserForm" property="email" /></td>
					
						<td><bean:write name="UserForm" property="dob" /></td>
					
						<td><bean:write name="UserForm" property="emailnot" /></td>
					
						<td><bean:write name="UserForm" property="adress1" /></td>
					
						<td><bean:write name="UserForm" property="state" /></td>
				
						<td><bean:write name="UserForm" property="city" /></td>
					
						<td><bean:write name="UserForm" property="adress2" /></td>
					
						<td><bean:write name="UserForm" property="pincode" /></td>
						
						<td><div class="buttons">
							<a id="editbtn" href="adduser.do?id=<bean:write name="UserForm" property="uid" />"><button id="<bean:write name="UserForm" property="uid" />" class="view" >view</button></a>	
			<a id="editbtn" href="adduser.do?editid=<bean:write name="UserForm" property="uid" />"><button id="<bean:write name="UserForm" property="uid" />" class="edit" >edit</button></a>		
					<button id="<bean:write name="UserForm" property="uid" />" class="delete">delete</button>
				
			</div></td>
					</tr>
				</tbody>
				
		</logic:iterate>
		</table>
		
		</div>
		



	
	
	
	
	<%
		}
	
	
	%>
	
</body>
</html>