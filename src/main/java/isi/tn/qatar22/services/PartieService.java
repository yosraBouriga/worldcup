package isi.tn.qatar22.services;

import java.util.List;
import java.util.Optional;

import isi.tn.qatar22.models.Partie;
import isi.tn.qatar22.reponses.MessageResponse;



public interface PartieService {

	MessageResponse savePartie(Partie partie);
	
	Optional<Partie> findById(Long id);


	List<Partie> findAllParties();

	MessageResponse delete(Long id);

}
