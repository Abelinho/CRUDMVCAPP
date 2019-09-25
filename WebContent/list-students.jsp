<%@ taglib uri= "http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>

<head>
 <title>Student Tracker App by Abel</title>
 
 <link type="text/css" rel="stylesheet" href="css/style.css">
</head>



<body>

 <div id="wrapper">
    <div id="header">
     <h2>Abel University</h2>
    </div>
 </div>
 
 <div id="container">
  <div id="content" >
    <!--Put new buton: Add student  -->
    
    <input type="button" value="Add Student" 
           onclick="window.location.href='add-student-form.jsp'; return false;" 
           class="add-student-button"
           > <!-- redirects form to add-student-form.jsp on clicking add student -->  
    <table>
     <tr>
      <th>First Name</th>
      <th>Last Name</th>
      <th>Email</th>
     </tr>
     
    <c:forEach var="tempStudent" items="${STUDENT_LIST}">
    
      <tr>
       <td>${tempStudent.firstName}</td>
       <td>${tempStudent.lastName}</td>
       <td>${tempStudent.email}</td>
      </tr>
     
     </c:forEach>
     
    </table>
  
  </div>
 
 </div>


</body>

</html>