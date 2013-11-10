package my.pack.controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import my.pack.model.Phone;

@ManagedBean(name = "phoneBean")
@SessionScoped
public class PhoneBean {

	private Phone phone = new Phone();

	public Phone getPhone() {
		return phone;
	}

	public void setPhone(Phone phone) {
		this.phone = phone;
	}
}
