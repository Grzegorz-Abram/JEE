package model;

public class Item {
	private int idItem;
	private String firstName;
	private String lastName;

	public Item() {
	}

	public Item(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public int getIdItem() {
		return this.idItem;
	}

	public void setIdItem(int idItem) {
		this.idItem = idItem;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
}
