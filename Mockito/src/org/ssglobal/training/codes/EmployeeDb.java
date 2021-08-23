package org.ssglobal.training.codes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDb {

	private Connection conn;
	
	public void openConnect(String username, String password, String url) {
		try {
			this.conn = DriverManager.getConnection(username, password, url);
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void closeConnect() {
		try {
			this.conn.close();
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public List<Employee> selectAllEmployees(){
		List<Employee> emps = new ArrayList<>();
		try (Statement stmt = conn.createStatement();){
			ResultSet dataset = stmt.executeQuery("select * from employee");
			while(dataset.next()) {
				Employee rec = new Employee();
				rec.setFirstname(dataset.getString(0));
				rec.setLastname(dataset.getString(1));
				rec.setSalary(dataset.getDouble(2));
				emps.add(rec);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return emps;
	}
}

class Employee{
	
	private String firstname;
	private String lastname;
	private Double salary;
	
	public Employee() {	}
	
	public Employee(String firstname, String lastname, Double salary) {
		this.firstname = firstname;
		this.lastname = lastname;
		this.salary = salary;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public Double getSalary() {
		return salary;
	}
	public void setSalary(Double salary) {
		this.salary = salary;
	}
	
	
}