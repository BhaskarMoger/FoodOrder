package net.java.springboot.model;



import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.JoinColumn;

@Entity
@Table (name="Place_Order")
public class Order {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column(name="First Name")
	private String firstName;
	@Column(name="Last Name")
	private String lastname;
	@Column(name="Mobile Number", length = 10)
	private Long mobileNo;
	@Column(name= "Address")
	private String address;
	@Column(name= "Payment")
	private String payment;
	@Column(name= "Amout")
	private Double amount;
	@Column(name= "Quantity")
	private Long quantity;
    @Column(name= "User")
    private Long userId;
	@Column(name= "Order Date")
	private LocalDate date;
	 @ManyToOne
	@JoinColumn(name = "user_id")
	private User user; 
	 


	
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
	public Long getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(Long mobileNo) {
		this.mobileNo = mobileNo;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}

	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	public Long getQuantity() {
		return quantity;
	}
	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}

	

	public Order(String firstName, String lastname, Long mobileNo, String address, String payment, Double amount,
			Long quantity, Long userId, LocalDate date, User user) {
		super();
		this.firstName = firstName;
		this.lastname = lastname;
		this.mobileNo = mobileNo;
		this.address = address;
		this.payment = payment;
		this.amount = amount;
		this.quantity = quantity;
		this.userId = userId;
		this.date = date;
		this.user = user;
	}
	public Order() {
		super();
	}

	public String getPayment() {
		return payment;
	}
	public void setPayment(String payment) {
		this.payment = payment;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}

	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	
	



	
	

}
