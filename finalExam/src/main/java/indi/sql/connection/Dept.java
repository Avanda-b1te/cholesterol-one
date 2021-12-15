package indi.sql.connection;


//部门类 部门信息初始化，获取部门信息
public class Dept {
int id;
String name;

public void set_id(int id) {
	this.id=id;
}
public void set_name(String name) {
	this.name=name;
}
public int get_id() {
	return id;
}
public String get_name() {
	return name;
}

}
