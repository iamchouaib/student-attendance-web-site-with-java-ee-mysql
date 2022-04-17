package control;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import model.Absense;
import model.AbsenseDbUtil;
import model.Student;
import model.StudentDbUtil;
import model.Teacher;
import model.TeacherDbUtil;

@WebServlet("/TeacherServlet")
public class TeacherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// declaration states

	private TeacherDbUtil teacherDbUtil;
	private StudentDbUtil studentDbUtil;
	private AbsenseDbUtil absentDbUtil;

	// resource jdbc

	@Resource(name = "jdbc/presense")

	private DataSource dataSource;

	@Override
	public void init() throws ServletException {
		super.init();
		try {

			teacherDbUtil = new TeacherDbUtil(dataSource);
			studentDbUtil = new StudentDbUtil(dataSource);
			absentDbUtil = new AbsenseDbUtil(dataSource);

		} catch (Exception e) {
			throw new ServletException();

		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String command = request.getParameter("command");

		try {
			if (command == null) {
				goToView(request, response);

			}

			switch (command) {
			case "LOAD":
				loadTeacher(request, response);
				break;
			case "UPDATE":
				updateTeacher(request, response);
				break;

			case "APPALE":
				listStudents(request, response);
				break;

			case "ABSENSE":
				addAbsense(request, response);
				break;

			case "SHOWABSENSE":
				showAbsense(request, response);
				break;

			default:
				break;
			}
		} catch (Exception e) {

		}

	}

	private void showAbsense(HttpServletRequest request, HttpServletResponse response)throws Exception {
		String date = request.getParameter("date");
		String id = request.getParameter("idTeacher");
		String absense;
//		absense =  absentDbUtil.showAbsense(date , Integer.parseInt(id));	
		
		
		
		Student student =  studentDbUtil.getStudent("1");

		request.setAttribute("STUDNTS", student);

		RequestDispatcher dispatcher = request.getRequestDispatcher("afficherAbsense.jsp");
		dispatcher.forward(request, response);
	
	
		
	}

	private void addAbsense(HttpServletRequest request, HttpServletResponse response) throws Exception {

		String group = request.getParameter("group");
		String date = request.getParameter("date");
		String TeacherId = request.getParameter("idTeacher");
		RequestDispatcher dispatcher;

//		if (absentDbUtil.checkSeance(date, TeacherId)) {
//
//System.out.println("there are this seance");
//			
//
//		} else {
		String absent = request.getParameter("absent");

		int gp = Integer.parseInt(group);
		Absense a = new Absense(date, gp, absent, TeacherId);

		absentDbUtil.addSeance(a);

		goToView(request, response);
	}

//	}

	private void listStudents(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String group = request.getParameter("group");

		List<Student> students = studentDbUtil.getStudentsByGroup(group);

		request.setAttribute("STUDNTS", students);

		RequestDispatcher dispatcher = request.getRequestDispatcher("/list-students.jsp");
		dispatcher.forward(request, response);

	}

	private void goToView(HttpServletRequest request, HttpServletResponse response) throws Exception {
		RequestDispatcher d;
		d = request.getRequestDispatcher("/Teacher-view.jsp");
		d.forward(request, response);

	}

	private void updateTeacher(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int id = Integer.parseInt(request.getParameter("teacherID"));
		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		String groups = request.getParameter("groups");
		String moduel = request.getParameter("module");
		String email = request.getParameter("email");

		Teacher t = new Teacher(id, nom, prenom, email, groups, null, moduel, null, null);

		teacherDbUtil.updateTeacher(t);

		goToView(request, response);
		PrintWriter out = response.getWriter();
		out.print("udpdate secuss");

	}

	private void loadTeacher(HttpServletRequest request, HttpServletResponse response) throws Exception {

		String id = (String) request.getParameter("MYID");

		Teacher t = teacherDbUtil.getTeacher(id);

		request.setAttribute("The_Teacher", t);

		RequestDispatcher dispatcher = request.getRequestDispatcher("/update-profile.jsp");
		dispatcher.forward(request, response);

	}

}
