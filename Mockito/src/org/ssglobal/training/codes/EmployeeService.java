package org.ssglobal.training.codes;

import java.util.List;
import java.util.stream.Collectors;

public class EmployeeService {

	private EmployeeDb empDb;

	public EmployeeService(EmployeeDb empDb) {
		this.empDb = empDb;
	}
	
	public List<String> getAllFirstNames(){
		return empDb.selectAllEmployees().stream().map((rec)->{
			return rec.getFirstname();
		}).collect(Collectors.toList());
	}
	
}
