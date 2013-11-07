package my.pack.controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "filterBean")
@SessionScoped
public class FilterBean {

	private String firstNameFilter;
	private String lastNameFilter;

	public String getFirstNameFilter() {
		return firstNameFilter;
	}

	public void setFirstNameFilter(String firstNameFilter) {
		this.firstNameFilter = firstNameFilter;
	}

	public String getLastNameFilter() {
		return lastNameFilter;
	}

	public void setLastNameFilter(String lastNameFilter) {
		this.lastNameFilter = lastNameFilter;
	}
}
