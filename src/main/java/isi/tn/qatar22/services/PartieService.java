package isi.tn.qatar22.services;

import java.util.List;
import java.util.Optional;

import isi.tn.qatar22.entities.Partie;


public interface PartieService {

	Partie savePartie(Partie partie);
	
	Optional<Partie> findById(Long id);


	List<Partie> findAllParties();

	void delete(Partie partie);

}
