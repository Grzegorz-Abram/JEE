package my.pack.controller;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import my.pack.model.Item;
import my.pack.util.HibernateUtil;

@ManagedBean(name = "itemBean")
@SessionScoped
public class ItemBean {

	private Session session = null;
	private Item item = new Item();

	public ItemBean() {
		session = HibernateUtil.getSessionFactory().openSession();
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public List<Item> getAllItems() {

		Transaction transaction = session.beginTransaction();

		Query q = session.createQuery("from Item");

		transaction.commit();

		return q.list();
	}
}
