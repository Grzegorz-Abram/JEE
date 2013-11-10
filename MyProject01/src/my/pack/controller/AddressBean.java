package my.pack.controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import my.pack.model.Address;

@ManagedBean(name = "addressBean")
@SessionScoped
public class AddressBean {

	private Address address = new Address();

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}
}
