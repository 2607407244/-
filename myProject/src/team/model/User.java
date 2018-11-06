package team.model;

import java.io.Serializable;

public class User implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;//不太懂？？？
	private int id;
	private String username;
	private String password;
	private String email;
	private String phone;
	private String qq;
	private String info;
	
	public User() {
		
	}
public User(int id,String username,String password,String email) {
		this.id = id;
		this.username = username;
		this.password = password;
		this.email = email;
	}
	public void setId(int _id) {
		this.id = _id;
	}
	public int getId() {
		return id;
	}
	public void setUsername(String _username) {
		this.username = _username;
	}
	public String getUsername() {
		return username;
	}
	public void setPassword(String _password) {
		this.password = _password;
	}
	public String getPassword() {
		return password;
	}
	public void setEmail(String _email) {
		this.email = _email;
	}
	public String getEmail() {
		return email;
	}
	public void setPhone(String _phone) {
		this.phone = _phone;
	}
	public String getPhone() {
		return phone;
	}
	public void setQq(String _qq) {
		this.qq = _qq;
	}
	public String getQq() {
		return qq;
	}
	public void setInfo(String _info) {
		this.info = _info;
	}
	public String getInfo() {
		return info;
	}
}
