package isi.tn.qatar22.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;


@Entity
public class User implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id // clé primaire
	@GeneratedValue(strategy = GenerationType.IDENTITY) // ça sera généré automatiquement
	@Column(name = "idUser") // esm lcolonne userid
	private Long idUser;
	private String email;
	private String pwd;
	private String fname;
	private String lname;
	@OneToMany (mappedBy="user")
	private List<Billet> billets;
	

	public Long getIdUser() {
		return idUser;
	}
	public void setIdUser(Long idUser) {
		this.idUser = idUser;
	}
	public List<Billet> getBillets() {
		return billets;
	}
	public void setBillets(List<Billet> billets) {
		this.billets = billets;
	}
	public User() {
		super();
	}
	public User(Long id, String email, String pwd, String fname, String lname) {
		super();
		this.idUser = id;
		this.email = email;
		this.pwd = pwd;
		this.fname = fname;
		this.lname = lname;
	}

	public Long getId() {
		return idUser;
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
