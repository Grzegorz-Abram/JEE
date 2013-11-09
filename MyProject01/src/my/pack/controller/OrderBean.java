package my.pack.controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "orderBean")
@SessionScoped
public class OrderBean {

	private String orderColumn;
	private String order = "asc";

	public String getOrderColumn() {
		return orderColumn;
	}

	public void setOrderColumn(String orderColumn) {

		if (order.equals("asc")) {
			order = "desc";
		} else {
			order = "asc";
		}

		this.orderColumn = orderColumn + " " + order;
	}
}
