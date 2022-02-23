package isi.tn.qatar22.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id // clé primaire
	@GeneratedValue(strategy = GenerationType.IDENTITY) // ça sera généré automatiquement
	@Column(name = "userid") // esm lcolonne userid
	private Long id;
	private String email;
	private String pwd;
	private String fname;
	private String lname;

	public User(Long id, String email, String pwd, String fname, String lname) {
		super();
		this.id = id;
		this.email = email;
		this.pwd = pwd;
		this.fname = fname;
		this.lname = lname;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}
}
