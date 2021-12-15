package indi.sql.connection;

import java.sql.*;
import java.util.List;

//增删改查接口
public interface InOutSelectUpdate {
	public void in_emp();
	public ResultSet select_emp();
//	public void in_dept();
	public List<Dept> select_dept();

}
