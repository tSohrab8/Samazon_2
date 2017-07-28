package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the user database table.
 * 
 */
@Entity
@Table(name="user")
@NamedQuery(name="User.findAll", query="SELECT u FROM User u")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int userid;

	private int currentorderid;

	private String email;

	private String pw;

	private String role;

	private String username;

	//bi-directional many-to-one association to Userorder
	@OneToMany(mappedBy="user")
	private List<Userorder> userorders;

	public User() {
	}

	public int getUserid() {
		return this.userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public int getCurrentorderid() {
		return this.currentorderid;
	}

	public void setCurrentorderid(int currentorderid) {
		this.currentorderid = currentorderid;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPw() {
		return this.pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getRole() {
		return this.role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public List<Userorder> getUserorders() {
		return this.userorders;
	}

	public void setUserorders(List<Userorder> userorders) {
		this.userorders = userorders;
	}

	public Userorder addUserorder(Userorder userorder) {
		getUserorders().add(userorder);
		userorder.setUser(this);

		return userorder;
	}

	public Userorder removeUserorder(Userorder userorder) {
		getUserorders().remove(userorder);
		userorder.setUser(null);

		return userorder;
	}

}