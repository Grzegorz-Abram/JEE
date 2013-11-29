package model;

import java.io.Serializable;

import javax.persistence.*;

import java.util.List;

/**
 * The persistent class for the ITEMS database table.
 * 
 */
@Entity
@Table(name = "ITEMS", schema = "ADDRESSBOOK")
@NamedQuery(name = "Item.findAll", query = "SELECT i FROM Item i")
public class Item implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int iditem;

	private String firstname;

	private String lastname;

	// bi-directional many-to-one association to Address
	@OneToMany(mappedBy = "item")
	private List<Address> addresses;

	// bi-directional many-to-one association to Phone
	@OneToMany(mappedBy = "item")
	private List<Phone> phones;

	public Item() {
	}

	public int getIditem() {
		return this.iditem;
	}

	public void setIditem(int iditem) {
		this.iditem = iditem;
	}

	public String getFirstname() {
		return this.firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return this.lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public List<Address> getAddresses() {
		return this.addresses;
	}

	public void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
	}

	public Address addAddress(Address address) {
		getAddresses().add(address);
		address.setItem(this);

		return address;
	}

	public Address removeAddress(Address address) {
		getAddresses().remove(address);
		address.setItem(null);

		return address;
	}

	public List<Phone> getPhones() {
		return this.phones;
	}

	public void setPhones(List<Phone> phones) {
		this.phones = phones;
	}

	public Phone addPhone(Phone phone) {
		getPhones().add(phone);
		phone.setItem(this);

		return phone;
	}

	public Phone removePhone(Phone phone) {
		getPhones().remove(phone);
		phone.setItem(null);

		return phone;
	}

	@Override
	public String toString() {
		return iditem + " - " + firstname + " " + lastname;
	}

}