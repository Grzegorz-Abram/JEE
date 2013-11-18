package my.pack.controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

import my.pack.model.Item;
import my.pack.model.Phone;
import my.pack.util.HibernateHelper;

@ManagedBean(name = "itemBean")
@SessionScoped
public class ItemBean {
	private HibernateHelper helper;
	private DataModel<Item> items;
	private Item selectedItem;

	@ManagedProperty(value = "#{filterBean}")
	private FilterBean filterBean;

	public void setFilterBean(FilterBean filterBean) {
		this.filterBean = filterBean;
	}

	@ManagedProperty(value = "#{orderBean}")
	private OrderBean orderBean;

	public void setOrderBean(OrderBean orderBean) {
		this.orderBean = orderBean;
	}

	public ItemBean() {
		helper = new HibernateHelper();
	}

	public Item getSelectedItem() {
		return this.selectedItem;
	}

	public DataModel<Item> getItems() {
		// if (items == null) {
		items = new ListDataModel<Item>(helper.getItems(
				filterBean.getFirstName(), filterBean.getLastName(),
				filterBean.getAddress(), filterBean.getPhone(),
				orderBean.getOrderColumn()));
		// }

		return items;
	}

	public String add() {
		selectedItem = new Item();
		return "edit";
	}

	public String edit() {
		selectedItem = (Item) items.getRowData();
		return "edit";
	}

	public String save() {
		helper.saveItem(selectedItem);
		return "index";
	}

	public String delete() {
		selectedItem = (Item) items.getRowData();
		helper.deleteItem(selectedItem);
		return null;
	}

	public String addPhone() {
		Phone phone = new Phone();
		phone.setItem(selectedItem);
		selectedItem.getPhones().add(phone);
		helper.savePhone(phone);
		return null;
	}

	public String deletePhone(int idPhone) {
		Phone phone = new Phone();
		for (Phone phoneTemp : selectedItem.getPhones()) {
			if (phoneTemp.getIdPhone() == idPhone) {
				phone = phoneTemp;
				break;
			}
		}
		selectedItem.getPhones().remove(phone);
		helper.deletePhone(phone);
		return null;
	}
}
