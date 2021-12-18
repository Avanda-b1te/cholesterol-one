package indi.sql.connection;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

;

/**
 * Servlet implementation class Js_select
 */
@WebServlet(urlPatterns="/select.do")
public class Js_select extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public Js_select() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		IOUS Select_dept=new IOUS();
		List<Dept> list_dept=Select_dept.select_dept();

		List<String> list=new ArrayList<String>();
		for(Dept o:list_dept) {
			String dname=o.get_name();
			list.add("\""+dname+"\"");
		}
		
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
