package controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import model.Employee;

@ManagedBean(name = "editedEmployeeBean")
@SessionScoped
public class EditedEmployeeBean {
	private Employee employee = new Employee();

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public List<Employee> getEmployeeAsList() {
		List<Employee> employees = new ArrayList<Employee>();
		employees.add(employee);
		return employees;
	}

	public String startEdit(Employee employee) {
		this.employee = employee;

		return "edit";
	}

	public String save() {
		updateEmployee();

		this.employee = new Employee();

		return "index";
	}

	public String cancel() {
		this.employee = new Employee();

		return "index";
	}

	public void updateEmployee() {
		EmployeeBean employeeBean = new EmployeeBean();
		SessionFactory factory = employeeBean.getFactory();

		Session session = factory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.update(employee);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
	}
}
