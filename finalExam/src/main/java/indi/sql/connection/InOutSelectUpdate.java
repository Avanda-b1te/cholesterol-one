package indi.sql.connection;

import java.sql.*;
import java.util.List;

//��ɾ�Ĳ�ӿ�
public interface InOutSelectUpdate {
	public void in_emp(Employee e);
	public List<Employee> select_emp();
//	public void in_dept();
	public List<Dept> select_dept();

}
