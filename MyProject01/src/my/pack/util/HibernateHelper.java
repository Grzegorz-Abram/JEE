package my.pack.util;

import java.util.List;

import my.pack.model.Item;
import my.pack.model.Phone;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class HibernateHelper {
	Session session = null;

	public HibernateHelper() {
		// this.session = HibernateUtil.getSessionFactory().getCurrentSession();
		this.session = HibernateUtil.getSessionFactory().openSession();
	}

	public List<Item> getItems(String firstName, String lastName,
			String address, String phone, String orderColumn) {
		List<Item> itemList = null;

		try {
			Transaction transaction = session.beginTransaction();

			if (orderColumn == null || orderColumn.isEmpty()) {
				orderColumn = "i.lastName";
			}

			Query query = session.createQuery(" select distinct i from Item i "
					+ " left outer join i.addresses a "
					+ " left outer join i.phones p where i.firstName like '"
					+ firstName + "%' and i.lastName like '" + lastName
					+ "%' and (coalesce(a.line1, '') like '" + address
					+ "%' or coalesce(a.line2, '') like '" + address + "%') "
					+ " and (coalesce(p.phone, '') like '" + phone + "%' "
					+ " or coalesce(p.comment, '') like '" + phone
					+ "%') order by " + orderColumn);
			itemList = (List<Item>) query.list();

			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return itemList;
	}

	public void deleteItem(Item item) {
		Transaction tx = null;

		try {
			tx = session.beginTransaction();

			session.delete(item);

			tx.commit();
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}
	}

	public void saveItem(Item item) {
		Transaction tx = null;

		try {
			tx = session.beginTransaction();

			session.save(item);

			tx.commit();
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}
	}

	public void savePhone(Phone phone) {
		Transaction tx = null;

		try {
			tx = session.beginTransaction();

			session.save(phone);

			tx.commit();
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}
	}

	public void deletePhone(Phone phone) {
		Transaction tx = null;

		try {
			tx = session.beginTransaction();

			session.delete(phone);

			tx.commit();
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}
	}
}