package web.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

public class StudentDbUtil {

	private DataSource dataSource; //reference to a data source i.e webstudent tracker in the mysql db
	
	public StudentDbUtil(DataSource theDatasource) {
		dataSource=theDatasource;
		}
	
	public List<Student> getStudents() throws Exception {
		
	   List<Student> students = new ArrayList<>();
	   
	   Connection myConn = null;
	   Statement myStmt = null;
	   ResultSet myRs = null;
	   
	   try {
	   //get a connection
	    myConn = dataSource.getConnection(); //establishes connection to db
	   //create a sql statement
	   String sql = "select * from student order by last_name";
	   
	   myStmt = myConn.createStatement(); //Creates a Statement object for sending SQL statements to the database
	   
	   //execute query
	   myRs = myStmt.executeQuery(sql); //Executes the given SQL statement, which returns a single ResultSet object
	   
	   //process result set
	   while(myRs.next()) {
		   //retrieve data from result set row
		    int id = myRs.getInt("id");
		    String firstName = myRs.getString("first_name");
		    String lastName = myRs.getString("last_name");
		    String email = myRs.getString("email");
		    
		   //create new student object
		    Student tempStudent = new Student(id, firstName, lastName, email); 
		   //add it to the list of students
		   students.add(tempStudent);
		   
	   }
	   
		   
		   return students; 
	   }
	   finally {
		 //close JDBC objects
		   close(myConn, myStmt, myRs);
	   }
	   
	}

	private void close(Connection myConn, Statement myStmt, ResultSet myRs) {
		
		try {
			if(myRs !=null) {
				myRs.close();
			}
			
			if(myStmt !=null) {
				myStmt.close();
			}
			
			if(myConn !=null) {
				myConn.close();//doesnt really close it...just puts back in connection pool
			}
			
		}
		
		catch(Exception exc){
			exc.printStackTrace();
		}
		
	}
	
}
