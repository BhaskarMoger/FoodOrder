package net.java.springboot.model;

public class Login {
	
	private Long userId;
	private String userName;
	private String password;
	
	
	public Login() {
		super();
	}
	public Login(String userName, String password) {
		super();
		this.userName = userName;
		this.password = password;
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
	@Override
	public String toString() {
		return "Login [userName=" + userName + ", password=" + password + "]";
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}


	

}
