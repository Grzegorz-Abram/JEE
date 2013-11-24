package model;

public class Address {
	private int idAddress;
	private int idItem;
	private String line1;
	private String line2;

	public Address() {
	}

	public Address(int idItem, String line1, String line2) {
		this.idItem = idItem;
		this.line1 = line1;
		this.line2 = line2;
	}

	public int getIdAddress() {
		return this.idAddress;
	}

	public void setIdAddress(int idAddress) {
		this.idAddress = idAddress;
	}

	public int getIdItem() {
		return this.idItem;
	}

	public void setIdItem(int idItem) {
		this.idItem = idItem;
	}

	public String getLine1() {
		return this.line1;
	}

	public void setLine1(String line1) {
		this.line1 = line1;
	}

	public String getLine2() {
		return this.line2;
	}

	public void setLine2(String line2) {
		this.line2 = line2;
	}
}
