package isi.tn.qatar22.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
@Entity
public class Billet implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)   
	@Column(name="idBillet")  
	private Long idBillet;
	private String date;
	private String place;
	private String prix;
	@ManyToOne
    @JoinColumn(name = "idUser")
    private User user;
	@ManyToOne
	    @JoinColumn(name = "idPartie")
	    private Partie partie;
	public Billet(Long id, String date, String place, String prix) {
		super();
		this.idBillet = id;
		this.date = date;
		this.place = place;
		this.prix = prix;
		
	}
	
	public Long getIdBillet() {
		return idBillet;
	}

	public void setIdBillet(Long idBillet) {
		this.idBillet = idBillet;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Partie getPartie() {
		return partie;
	}

	public void setPartie(Partie partie) {
		this.partie = partie;
	}

	public Billet() {
		super();
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getPlace() {
		return place;
	}
	public void setPlace(String place) {
		this.place = place;
	}
	public String getPrix() {
		return prix;
	}
	public void setPrix(String prix) {
		this.prix = prix;
	}

	
}

