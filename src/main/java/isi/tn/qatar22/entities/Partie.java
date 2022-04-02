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
public class Partie implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id // clé primaire
	@GeneratedValue(strategy = GenerationType.IDENTITY) // ça sera généré automatiquement
	@Column(name = "idPartie") // esm lcolonne idPartie
	private Long idPartie;
	private String equipe1;
	private String equipe2;
	private String date;
	private String nomStade;
	@OneToMany (mappedBy="partie")
	private List<Billet> billets;
	
	public String getEquipe1() {
		return equipe1;
	}
	public void setEquipe1(String equipe1) {
		this.equipe1 = equipe1;
	}
	public String getEquipe2() {
		return equipe2;
	}
	public void setNomStade(String nomStade) {
		this.nomStade = nomStade;
	}
	public String getNomStade() {
		return nomStade;
	}
	public void setEquipe2(String equipe2) {
		this.equipe2 = equipe2;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	
	
	public Partie() {
		super();
	}
	public Partie(Long id, String equipe1, String equipe2, String date, String nomStade) {
		super();
		this.idPartie = id;
		this.equipe1 = equipe1;
		this.equipe2 = equipe2;
		this.date = date;
		this.nomStade = nomStade;
	}
	
	

}
