package indi.sql.connection;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class Js_ds
 */
@WebServlet(urlPatterns="/dselect.do")
public class Js_ds extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public Js_ds() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		IOUS ious=new IOUS();
		List<Employee> emp=ious.select_emp();
		System.out.print(emp);
		List<String> list=new ArrayList<String>();
		for(Employee o:emp) {
			int eid=o.get_dept_id();
			String ename=o.get_name();
			Date edate=o.get_date();
			list.add("[\""+eid+"\",\""+ename+"\",\""+edate+"\"]");
		}
		System.out.print(list.toString());
		response.getWriter().write(list.toString());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
