package indi.sql.connection;

import java.io.IOException;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class employee_servlet
 */
@WebServlet(urlPatterns="/server.do")
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

		request.setCharacterEncoding("utf-8");
		String name=request.getParameter("name");  //获取输入姓名
		String birthday=request.getParameter("birthday");  //获取输入的出生日期
		String dept=request.getParameter("dept");  //获取选择的部门
		
		try {
			date =fmt.parse(birthday);		
			jsd=new java.sql.Date(date.getTime());	//类型转换 String->date
			request.setAttribute("name",name);
			request.setAttribute("birthday",birthday);
			request.setAttribute("dept",dept);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		switch(dept) {
			case "信息工程学院":
				dept_int=1;
				break;
			case "外国语学院":
				dept_int=2;
				break;
			case "体育学院":
				dept_int=3;
				break;
			case "音乐学院":
				dept_int=4;
				break;
		}
		
		emp=new Employee(dept_int,name,jsd);  //把输入在前端的用户信息放在一个员工对象中
		IOUS insert=new IOUS();		//实例化一个插入对象
		insert.in_emp(emp);			//调用插入方法
		request.getRequestDispatcher("myemp.jsp").forward(request, response);
//		response.sendRedirect("myemp.jsp");
	}

	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
