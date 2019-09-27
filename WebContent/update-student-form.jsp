<!DOCTYPE html>
<html>
 <head>
 <title>Update Student form by Abel</title>
 
 <link type="text/css" rel="stylesheet" href="css/style.css">
 <link type="text/css" rel="stylesheet" href="css/add-student-style.css">
</head>

 <body>
  <div id="wrapper">
    <div id="header">
     <h2>Abel University</h2>
    </div>
 </div>
 
 <div id="container">
   <h3>Update Student</h3>
 
 <form action="StudentControllerServlet" method="GET">
   <input type="hidden" name="command" value="UPDATE" >
   <input type="hidden" name="studentId" value="${THE_STUDENT.id}" >
 
   <table>
    <tbody>
     <tr>
      <td><label>First name:</label></td>
      <td><input type= "text" name="firstName" 
      value="${THE_STUDENT.firstName}"></td>
     </tr>
     
     <tr>
      <td><label>Last name:</label></td>
      <td><input type= "text" name="lastName"
      value="${THE_STUDENT.lastName}"></td>
     </tr>
     
     <tr>
      <td><label>Email:</label></td>
      <td><input type= "text" name="email"
      value="${THE_STUDENT.email}"></td>
     </tr>
     
     <tr>
      <td><label></label></td>
      <td><input type="submit" value="Save" class="save"></td>
     </tr>
     
    </tbody>
   </table>
 
 </form>
 
 <div style="clear: both;"></div> <!-- this is for a line break. find out more -->
 
 <p>
   <a href="StudentControllerServlet">Back to List</a> <!-- This line calls the servlet which in turn redirects u to the liststudent.jsp -->
 </p>
 </div>

 
 
 </body>

</html>