package my.pack.controller;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.hibernate.Query;
import org.hibernate.Session;

import my.pack.model.Phone;
import my.pack.util.HibernateUtil;

@ManagedBean(name = "phoneBean")
@SessionScoped
public class PhoneBean {

	private Phone phone = new Phone();

	public Phone getPhone() {
		return phone;
	}

	public void setPhone(Phone phone) {
		this.phone = phone;
	}

	public List<Phone> getAllPhones() {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();

		session.beginTransaction();

		Query q = session.createQuery("from Phone");

		return q.list();
	}

}
