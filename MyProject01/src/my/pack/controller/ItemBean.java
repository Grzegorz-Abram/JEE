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

	public List<Item> getItemsByFirstName(String firstName) {

		Transaction transaction = session.beginTransaction();

		Query q = session.createQuery("from Item i where i.firstName like '"
				+ firstName + "%'");

		transaction.commit();

		return q.list();
	}

	public List<Item> getItemsWithFilter(String firstName, String lastName,
			String address, String phone, String orderColumn) {

		Transaction transaction = session.beginTransaction();

		if (orderColumn == null || orderColumn.isEmpty()) {
			orderColumn = "i.lastName";
		}

		// select distinct i.firstName, i.lastName, a.line1, a.line2, p.phone,
		// p.comment
		Query q = session.createQuery(" select distinct i from Item i "
				+ " left outer join i.addresses a "
				+ " left outer join i.phones p where i.firstName like '"
				+ firstName + "%' and i.lastName like '" + lastName
				+ "%' and (coalesce(a.line1, '') like '" + address
				+ "%' or coalesce(a.line2, '') like '" + address + "%') "
				+ " and (coalesce(p.phone, '') like '" + phone + "%' "
				+ " or coalesce(p.comment, '') like '" + phone
				+ "%') order by " + orderColumn);

		transaction.commit();

		return q.list();
	}
}
