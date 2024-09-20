package net.java.springboot.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table (name="Seller")
public class Seller {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column(name="First Name")
	private String firstName;
	@Column(name="Last Name")
	private String lastname;
	@Column(name="Email ID")
	private String emailId;
	@Column(name="Mobile Number", length = 10)
	private Long mobileNo;
	@Column(name= "Seller Name")
	private String userName;
	@Column(name= "Password")
	private String password;
	@Column(name= "Address")
	private String address;
	
	
	public Seller() {
		
	}
	
	public Seller(String firstName, String lastname, String emailId, Long mobileNo, String userName, String password,
			String address) {
		super();
		this.firstName = firstName;
		this.lastname = lastname;
		this.emailId = emailId;
		this.mobileNo = mobileNo;
		this.userName = userName;
		this.password = password;
		this.address = address;
	}

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public Long getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(Long mobileNo) {
		this.mobileNo = mobileNo;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
}
