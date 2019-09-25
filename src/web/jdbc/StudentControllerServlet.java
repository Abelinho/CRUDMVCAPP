package web.jdbc;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

/**
 * Servlet implementation class StudentControllerServlet
 */
@WebServlet("/StudentControllerServlet")
public class StudentControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private StudentDbUtil studentDbUtil;
	
	@Resource(name="jdbc/web_student_tracker")/**use JavaEE resource injection to inject data source,
	                                            the tomcat server injects the connection pool object 
	                                            and  assigns it to the datasSource variable  
	                                          **/
	private DataSource dataSource;
	
  /**init() method is called by the app server(tomcat) 
    when this servlet is initialized.
    this init()method functions like a constructor in servlet classes**/
	@Override
	public void init() throws ServletException {
		super.init();
		
		//create an instance of studentDbUtil and pass in the conn pool dataSource
		
		try {
			studentDbUtil = new StudentDbUtil(dataSource);
		}
		catch(Exception exc) {
			throw new ServletException(exc);
		}
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//list the students..in MVC fashion
		try {
		listStudents(request, response);
		}
		catch(Exception exc) {
		   throw new ServletException(exc);
		}
	}

	private void listStudents(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
	  //get students form db util
	  List<Student> students = studentDbUtil.getStudents();
	  
	  //add students to the request
		request.setAttribute("STUDENT_LIST", students);
	  
	  //send to JSP page(view)
	  RequestDispatcher dispatcher = request.getRequestDispatcher("/list-students.jsp");
      	dispatcher.forward(request, response);
	
	}	
}
