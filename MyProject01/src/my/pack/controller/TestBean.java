package my.pack.controller;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import my.pack.model.Test;
import my.pack.util.HibernateUtil;

@ManagedBean(name = "testBean")
@SessionScoped
public class TestBean {

	private Session session = null;
	private Test test = new Test();

	public TestBean() {
		session = HibernateUtil.getSessionFactory().openSession();
	}

	public Test getTest() {
		return test;
	}

	public void setTest(Test test) {
		this.test = test;
	}

	public List<Test> getAllTests() {

		Transaction transaction = session.beginTransaction();

		Query q = session.createQuery("from Test");

		transaction.commit();

		return q.list();
	}
}
