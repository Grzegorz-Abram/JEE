package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the ADDRESSES database table.
 * 
 */
@Entity
@Table(name="ADDRESSES")
@NamedQuery(name="Address.findAll", query="SELECT a FROM Address a")
public class Address implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idaddress;

	private String line1;

	private String line2;

	//bi-directional many-to-one association to Item
	@ManyToOne
	@JoinColumn(name="IDITEM")
	private Item item;

	public Address() {
	}

	public int getIdaddress() {
		return this.idaddress;
	}

	public void setIdaddress(int idaddress) {
		this.idaddress = idaddress;
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

	public Item getItem() {
		return this.item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

}