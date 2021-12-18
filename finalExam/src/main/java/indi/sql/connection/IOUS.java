package indi.sql.connection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

//增删改查实现类
public class IOUS implements InOutSelectUpdate{
	private PreparedStatement ps=null;
	private DBConnection db=new DBConnection();
	private ResultSet rs=null;
//	private Employee e=null;
	
	@Override
	public void in_emp(Employee e) {
		// TODO Auto-generated method stub
		int id=e.get_dept_id();
		String name=e.get_name();
		Date date=(Date)e.get_date();
		try {
			ps=db.DB("insert into employee(dept_id,name,birthday) values(?,?,?)");
			ps.setInt(1, id);
			ps.setString(2, name);
			ps.setDate(3, date);
			if(ps.executeUpdate()>0) {
				System.out.print("添加成功");
			}
			else {
				System.out.print("添加失败");
			}
			db.close();
		} catch (SQLException ee) {
			// TODO Auto-generated catch block
			ee.printStackTrace();
		}
	}

	@Override
	public List<Employee> select_emp() {
		// TODO Auto-generated method stub
		List<Employee> emp=new ArrayList<>();
		try {
			rs=db.DB("select * from employee").executeQuery();
			while(rs.next()) {
				int id=rs.getInt(2);
				String name=rs.getString(3);
				Date date=rs.getDate(4);
				Employee e=new Employee();
				e.set_dept_id(id);
				e.set_name(name);
				e.set_date(date);
				emp.add(e);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		db.close();
		return emp;
	}

	@Override
	public List<Dept> select_dept() {
		// TODO Auto-generated method stub
		List<Dept> list_dept=new ArrayList<>();
		
		try {
			rs=db.DB("select * from dept").executeQuery();
			while(rs.next()) {
				int id=rs.getInt(1);
				String name=rs.getString(2);
				Dept dept = new Dept();
				dept.set_id(id);
				dept.set_name(name);
				list_dept.add(dept);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		db.close();
		return list_dept;
	}
}
