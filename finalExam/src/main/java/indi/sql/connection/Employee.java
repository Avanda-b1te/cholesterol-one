package indi.sql.connection;

import java.util.Date;
//Ա���� ����Ա����Ϣ�ĳ�ʼ���ͻ�ȡԱ����Ϣ
public class Employee {
//int id;
int dept_id;
String name;
Date date;

public Employee(int dept_id,String name,Date date) {
//	this.id=id;
	this.dept_id=dept_id;
	this.name=name;
	this.date=date;
}
public Employee() {
	
}
//public void set_id(int id) {
//	this.id=id;
//}

public void set_dept_id(int dept_id) {
	this.dept_id=dept_id;
}

public void set_name(String name) {
	this.name=name;
}

public void set_date(Date date) {
	this.date=date;
}

//public int get_id() {
//	return id;
//}

public int get_dept_id() {
	return dept_id;
}

public String get_name() {
	return name;
}

public Date get_date() {
	return date;
}
}
