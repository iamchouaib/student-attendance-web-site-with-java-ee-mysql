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

import model.AdminDbUtil;

/**
 * Servlet implementation class LoginAdmin
 */
@WebServlet("/LoginAdmin")
public class LoginAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;
	// declaration states

	private AdminDbUtil adminDbUtil;

	// resource jdbc

	@Resource(name = "jdbc/presense")

	private DataSource dataSource;

	@Override
	public void init() throws ServletException {
		super.init();
		try {

			adminDbUtil = new AdminDbUtil(dataSource);

		} catch (Exception e) {
			throw new ServletException();

		}
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		if (request.getSession().getAttribute("user") != null) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("AdministratorServlet");
			dispatcher.include(request, response);
		} else {
doPost(request, response);
//			RequestDispatcher dispatcher = request.getRequestDispatcher("/login-admin.jsp");
//			dispatcher.include(request, response);
		}
		


	

	

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		RequestDispatcher dispatcher;

		String username = request.getParameter("username");
		String password = request.getParameter("password");

		try {
			if (adminDbUtil.checkLogin(username, password)) {

				HttpSession session = request.getSession();
				session.setAttribute("user", username);
				request.setAttribute("USER", username);

				dispatcher = request.getRequestDispatcher("AdministratorServlet");
				dispatcher.forward(request, response);

			} else {

				PrintWriter out = response.getWriter();

				dispatcher = request.getRequestDispatcher("/login-admin.jsp");
				dispatcher.include(request, response);

				out.print("<center><h2 class='wrong'> Incorect user or password !!<h2>");
			}
		} catch (Exception e) {

		}
	}
}
