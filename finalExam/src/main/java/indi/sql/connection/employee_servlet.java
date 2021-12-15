package indi.sql.connection;

import java.io.IOException;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class employee_servlet
 */
@WebServlet(urlPatterns="/insert.do")
public class employee_servlet extends jakarta.servlet.http.HttpServlet {
	private static final long serialVersionUID = 1L;
	DateFormat fmt=new SimpleDateFormat("yyyy-MM-dd");
    /**
     * Default constructor. 
     */
    public employee_servlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	int dept_int = 0;
	Date date = null;
	java.sql.Date jsd=null;
	Employee emp=null;
	Dept dt=null;
	IOUS ious;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		String name=request.getParameter("name");
		String birthday=request.getParameter("birthday");
		String dept=request.getParameter("dept");


		try {
			date =fmt.parse(birthday);
			jsd=new java.sql.Date(date.getTime());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(request.getParameter("name")=="1") {
			r_dept();
		}

		emp=new Employee(dept_int,name,jsd);
		IOUS insert=new IOUS();
		insert.in_emp();
		
	}

	public List<Dept> r_dept() {
		return ious.select_dept();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
