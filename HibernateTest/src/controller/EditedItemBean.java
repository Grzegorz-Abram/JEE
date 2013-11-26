package controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import model.Item;

@ManagedBean(name = "editedItemBean")
@SessionScoped
public class EditedItemBean {
	private Item item = new Item();

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public List<Item> getItemAsList() {
		List<Item> items = new ArrayList<Item>();
		items.add(item);
		return items;
	}

	public String addItem() {
		this.item = new Item();

		return "edit";
	}

	public String startEdit(Item item) {
		this.item = item;

		return "edit";
	}

	public String save() {
		updateItem();

		this.item = new Item();

		return "index";
	}

	public String cancel() {
		this.item = new Item();

		return "index";
	}

	public void updateItem() {
		ItemBean itemBean = new ItemBean();
		SessionFactory factory = itemBean.getFactory();

		Session session = factory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			if (item.getIdItem() > 0) {
				session.update(item);
			} else {
				session.save(item);
			}
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
