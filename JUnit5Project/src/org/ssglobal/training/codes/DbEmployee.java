package org.ssglobal.training.codes;

import java.util.ArrayList;
import java.util.List;

public class DbEmployee {
	
	private List<Employee> empTbl;
	
	public DbEmployee() {
		this.empTbl = new ArrayList<>();
	}

	public List<Employee> addEmployee(String fname, String lname, Integer age, Float salary){
		this.empTbl.add(new Employee(fname, lname, age, salary));
		return this.empTbl;
	}
}
