package teamid9527.moviebooking.entities;

import org.hibernate.validator.constraints.Email;

public class Customer {
	
	private Integer c_id;
	
	private String name;
	
	private String password;
	
	@Email
	private String email;

	public Integer getC_id() {
		return c_id;
	}

	public void setC_id(Integer c_id) {
		this.c_id = c_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Customer [c_id=" + c_id + ", name=" + name + ", password="
				+ password + ", eamil=" + email + "]";
	}

	
	
	
	
}
