<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

</head>
<body>
<table>
    <tr>
 <th>Id</th>
<th>Name</th>
<th>Department</th>
<th>Designation</th>
    </tr>        
        <tr>
            <td>${Employee.id}</td>
            <td>${Employee.name}</td>
            <td>${Employee.dept}</td>
            <td>${Employee.designation}</td>
        </tr>
    
    
</table>
</body>
</html>