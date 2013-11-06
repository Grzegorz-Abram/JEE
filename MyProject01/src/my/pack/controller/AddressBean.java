package my.pack.controller;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.hibernate.Query;
import org.hibernate.Session;

import my.pack.model.Address;
import my.pack.util.HibernateUtil;

@ManagedBean(name = "addressBean")
@SessionScoped
public class AddressBean {

	private Address address = new Address();

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public List<Address> getAllAddresses() {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();

		session.beginTransaction();

		Query q = session.createQuery("from Address");

		return q.list();
	}

}
