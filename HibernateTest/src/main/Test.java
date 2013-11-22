package main;

import java.util.List;

import model.Employee;
import controller.EmployeeBean;

public class Test {
	public static void main(String[] args) {
		EmployeeBean employeeBean = new EmployeeBean();
		List<Employee> employees = employeeBean.listEmployees();
		for (Employee employee : employees) {
			System.out.println(employee.getId() + " - "
					+ employee.getFirstName() + " " + employee.getLastName()
					+ " -> " + employee.getSalary());
		}
	}
}