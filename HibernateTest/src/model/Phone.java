package model;

public class Phone {
	private int idPhone;
	private int idItem;
	private String phone;
	private String comment;
	private String restricted;

	public Phone() {
	}

	public Phone(int idItem, String phone, String comment, String restricted) {
		this.idItem = idItem;
		this.phone = phone;
		this.comment = comment;
		this.restricted = restricted;
	}

	public int getIdPhone() {
		return this.idPhone;
	}

	public void setIdPhone(int idPhone) {
		this.idPhone = idPhone;
	}

	public int getIdItem() {
		return this.idItem;
	}

	public void setIdItem(int idItem) {
		this.idItem = idItem;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getComment() {
		return this.comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getRestricted() {
		return this.restricted;
	}

	public void setRestricted(String restricted) {
		this.restricted = restricted;
	}

}
