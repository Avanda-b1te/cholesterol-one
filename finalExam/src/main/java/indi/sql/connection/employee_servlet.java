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
		String name=request.getParameter("name");  //��ȡ��������
		String birthday=request.getParameter("birthday");  //��ȡ����ĳ�������
		String dept=request.getParameter("dept");  //��ȡѡ��Ĳ���
		
		try {
			date =fmt.parse(birthday);		
			jsd=new java.sql.Date(date.getTime());	//����ת�� String->date
			request.setAttribute("name",name);
			request.setAttribute("birthday",birthday);
			request.setAttribute("dept",dept);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		switch(dept) {
			case "��Ϣ����ѧԺ":
				dept_int=1;
				break;
			case "�����ѧԺ":
				dept_int=2;
				break;
			case "����ѧԺ":
				dept_int=3;
				break;
			case "����ѧԺ":
				dept_int=4;
				break;
		}
		
		emp=new Employee(dept_int,name,jsd);  //��������ǰ�˵��û���Ϣ����һ��Ա��������
		IOUS insert=new IOUS();		//ʵ����һ���������
		insert.in_emp(emp);			//���ò��뷽��
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
