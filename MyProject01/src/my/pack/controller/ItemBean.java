package my.pack.controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
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
		items = new ListDataModel<Item>(helper.getItemsWithFilter(
				filterBean.getFirstName(), filterBean.getLastName(),
				filterBean.getAddress(), filterBean.getPhone(),
				orderBean.getOrderColumn()));
		// }

		return items;
	}

	public String edit() {
		selectedItem = (Item) items.getRowData();
		return "edit";
	}
}
