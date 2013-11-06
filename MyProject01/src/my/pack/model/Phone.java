package my.pack.model;

// Generated 2013-11-04 21:27:42 by Hibernate Tools 4.0.0

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Phone generated by hbm2java
 */
@Entity
@Table(name = "PHONE", schema = "PUBLIC", catalog = "PHONEBOOK")
public class Phone implements java.io.Serializable {

	private Integer idPhone;
	private Item item;
	private String phone;
	private String comment;
	private String restricted;

	public Phone() {
	}

	public Phone(Item item, String phone, String comment, String restricted) {
		this.item = item;
		this.phone = phone;
		this.comment = comment;
		this.restricted = restricted;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id_phone", unique = true, nullable = false)
	public Integer getIdPhone() {
		return this.idPhone;
	}

	public void setIdPhone(Integer idPhone) {
		this.idPhone = idPhone;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_item")
	public Item getItem() {
		return this.item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	@Column(name = "phone", length = 45)
	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Column(name = "comment", length = 45)
	public String getComment() {
		return this.comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	@Column(name = "restricted", length = 45)
	public String getRestricted() {
		return this.restricted;
	}

	public void setRestricted(String restricted) {
		this.restricted = restricted;
	}

}
