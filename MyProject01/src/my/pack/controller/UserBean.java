package my.pack.controller;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.hibernate.Query;
import org.hibernate.Session;

import my.pack.model.User;
import my.pack.util.HibernateUtil;

@ManagedBean(name = "userBean")
@SessionScoped
public class UserBean {

	private User user = new User();

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<User> getAllUsers() {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();

		session.beginTransaction();

		Query q = session.createQuery("from User");

		return q.list();
	}

}
