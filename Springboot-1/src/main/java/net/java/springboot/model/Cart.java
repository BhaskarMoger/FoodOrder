package net.java.springboot.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table (name="Cart")
public class Cart {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn
    private User user;

    @ManyToOne
    @JoinColumn
    private Item item;
    @Column(name= "User")
    private Long userId;
    @Column(name= "Item")
    private Long itemId;
    @Column(name= "Item Name")
    private String itemName;
    @Column(name= "Descrption")
    private String description;
    @Column(name= "Image")
    private String imageUrl;
    @Column(name= "Price")
    private Double price;
    
    @Column(name= "Quantity")
    private int quantity;
    
    
    
	public Cart() {
		super();
	}
	



	public Cart(User user, Item item, Long userId, Long itemId, String itemName, String description, String imageUrl,
			Double price, int quantity) {
		super();
		this.user = user;
		this.item = item;
		this.userId = userId;
		this.itemId = itemId;
		this.itemName = itemName;
		this.description = description;
		this.imageUrl = imageUrl;
		this.price = price;
		this.quantity = quantity;
	}




	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Item getItem() {
		return item;
	}
	public void setItem(Item item) {
		this.item = item;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}








	public Long getUserId() {
		return userId;
	}








	public void setUserId(Long userId) {
		this.userId = userId;
	}








	public Long getItemId() {
		return itemId;
	}








	public void setItemId(Long itemId) {
		this.itemId = itemId;
	}


    
    

}
