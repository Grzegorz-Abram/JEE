package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the PHONES database table.
 * 
 */
@Entity
@Table(name="PHONES")
@NamedQuery(name="Phone.findAll", query="SELECT p FROM Phone p")
public class Phone implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idphone;

	private String comment;

	private String phone;

	private String restricted;

	//bi-directional many-to-one association to Item
	@ManyToOne
	@JoinColumn(name="IDITEM")
	private Item item;

	public Phone() {
	}

	public int getIdphone() {
		return this.idphone;
	}

	public void setIdphone(int idphone) {
		this.idphone = idphone;
	}

	public String getComment() {
		return this.comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getRestricted() {
		return this.restricted;
	}

	public void setRestricted(String restricted) {
		this.restricted = restricted;
	}

	public Item getItem() {
		return this.item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

}