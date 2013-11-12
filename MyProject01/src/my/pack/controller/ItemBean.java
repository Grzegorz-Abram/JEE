package my.pack.controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

import my.pack.model.Item;
import my.pack.util.HibernateHelper;

@ManagedBean(name = "itemBean")
@SessionScoped
public class ItemBean {
	private HibernateHelper helper;
	private DataModel<Item> items;
	private Item selectedItem;
	private int selectedItemIndex;
	private String firstName;
	private String lastName;
	private String address;
	private String phone;
	private String orderColumn;

	public ItemBean() {
		helper = new HibernateHelper();
		this.firstName = "";
		this.lastName = "";
		this.address = "";
		this.phone = "";
		this.orderColumn = "i.lastName desc";
	}

	public ItemBean(String firstName, String lastName, String address,
			String phone, String orderColumn) {
		helper = new HibernateHelper();
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.phone = phone;
		this.orderColumn = orderColumn;
	}

	public Item getSelectedItem() {
		if (selectedItem == null) {
			selectedItem = new Item();
			selectedItemIndex = -1;
		}
		return selectedItem;
	}

	public DataModel<Item> getItemsWithFilter(String firstName,
			String lastName, String address, String phone, String orderColumn) {
		// if (items == null) {
		items = new ListDataModel<Item>(helper.getItemsWithFilter(firstName,
				lastName, address, phone, orderColumn));
		// }
		return items;
	}

	public String edit() {
		selectedItem = (Item) items.getRowData();
		return "edit";
	}
}
