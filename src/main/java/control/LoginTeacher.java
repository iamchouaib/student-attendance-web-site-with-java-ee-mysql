package control;

import java.io.IOException;
import java.io.PrintWriter;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

import model.Teacher;
import model.TeacherDbUtil;

@WebServlet("/LoginTeacher")
public class LoginTeacher extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private TeacherDbUtil teacherDbUtil;
	
	@Resource(name = "jdbc/presense")

	private DataSource dataSource;
       

	@Override
	public void init() throws ServletException {
		teacherDbUtil = new TeacherDbUtil(dataSource);
		super.init();
	}



	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (request.getSession().getAttribute("teacher") != null) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("Teacher-view.jsp");
			dispatcher.include(request, response);
		} else {
//doPost(request, response);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/login-teacher.jsp");
			dispatcher.include(request, response);
		}
		
	}

	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RequestDispatcher dispatcher;

		String username = request.getParameter("username");
		String password = request.getParameter("password");

		
		try {
			Teacher t = teacherDbUtil.checkLogin(username, password);
			if ( t != null) {

				HttpSession session = request.getSession();
				session.setAttribute("teacher", t);

				dispatcher = request.getRequestDispatcher("/Teacher-view.jsp");
				dispatcher.forward(request, response);

			} else {

				PrintWriter out = response.getWriter();

				dispatcher = request.getRequestDispatcher("/login-teacher.jsp");
				dispatcher.include(request, response);

				out.print("<h2> Incorect user or password !!<h2>");
			}
		} catch (Exception e) {

		}
	}

}
