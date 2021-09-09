<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Product registration</title>
</head>
<body>
 <div align="center">
  <h1>Product Register Form</h1>
  <form action="<%= request.getContextPath() %>/register" method="post">
   <table style="with: 80%">
    <tr>
     <td>Name</td>
     <td><input type="text" name="name" /></td>
    </tr>
    <tr>
     <td>Colour</td>
     <td><input type="text" name="colour" /></td>
    </tr>
    <tr>
     <td>Description</td>
     <td><input type="text" name="description" /></td>
    </tr>
    <tr>
     <td>Barcode</td>
     <td><input type="password" name="barcode" /></td>
    </tr>
   </table>
   <input type="submit" value="Submit" />
  </form>
  <form action="<%= request.getContextPath() %>/read" method="get">
  	<input type="submit" value="Read" />
  </form>
  <form action="<%= request.getContextPath() %>/search" method="post">
  	<table style="with: 80%">
    <tr>
     <td>Barcode</td>
     <td><input type="password" name="barcode" /></td>
    </tr>
   </table>
  	<input type="submit" value="Search" />
  </form>
 </div>
</body>
</html>