package net.java.springboot.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table (name="Item")
public class Item {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name="Food Name")
	private String name;
	@Column(name="Description")
	private String description;
	@Column(name="Price")
	private long price;
	@Column(name = "Image")
    private String imageUrl;
	
	
	
	public Item() {
		super();
	}

	public Item(String name, String description, long price, String imageUrl) {
		super();
		this.name = name;
		this.description = description;
		this.price = price;
		this.imageUrl = imageUrl;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public long getPrice() {
		return price;
	}
	public void setPrice(long price) {
		this.price = price;
	}
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Item orElseThrow() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
	

	
	
	

}
