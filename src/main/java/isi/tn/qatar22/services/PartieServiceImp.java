package isi.tn.qatar22.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import isi.tn.qatar22.models.Billet;
import isi.tn.qatar22.models.Partie;
import isi.tn.qatar22.reponses.MessageResponse;
import isi.tn.qatar22.repositories.PartieRepository;

@Service
public class PartieServiceImp implements PartieService {
	@Autowired
	PartieRepository prepos;

	@Override
	public MessageResponse savePartie(Partie partie) {
		// TODO Auto-generated method stub
		prepos.save(partie);
		return new MessageResponse(true, "Succès", "Opération réalisée avec succès.");
	}

	@Override
	public Optional<Partie> findById(Long id) {
		// TODO Auto-generated method stub
		return this.prepos.findById(id);
	}

	@Override
	public List<Partie> findAllParties() {
		// TODO Auto-generated method stub
		return (List<Partie>) this.prepos.findAll();
	}

	@Transactional
	@Override
	public MessageResponse delete(Long id) {
		try {
			Partie partie = findById(id).get();

			prepos.deleteById(id);
			return new MessageResponse(true, "Succès", "L'enregistrement à été supprimé avec succès.");
		} catch (Exception e) {
			return new MessageResponse(false, "Echec", "Cet enregistrement n'existe pas !");

		}

		/*
		 * @Override public void delete(Partie partie) { // TODO Auto-generated method
		 * stub this.prepos.delete(partie);
		 * 
		 * 
		 * }
		 */

	}
}
