package isi.tn.qatar22.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import isi.tn.qatar22.models.Billet;
import isi.tn.qatar22.reponses.MessageResponse;
import isi.tn.qatar22.repositories.BilletRepository;


@Service
public class ImpBilletService implements IBilletService {
	@Autowired
	BilletRepository brepos;
	
	@Transactional
	@Override
	public MessageResponse saveBillet(Billet billet) {
		// TODO Auto-generated method stub
		brepos.save(billet);
		return new MessageResponse(true, "Succès", "Opération réalisée avec succès.");
	}
	
	@Transactional
	@Override
	public MessageResponse delete(Long id) {
		try {
		Billet billet = findById(id).get();
		
		
			brepos.deleteById(id);
			return new MessageResponse(true, "Succès", "L'enregistrement à été supprimé avec succès.");
		}
		catch(Exception e ) {
			return new MessageResponse(false, "Echec", "Cet enregistrement n'existe pas !");

		}
		
	}

	@Override
	public Optional<Billet> findById(Long id) {
		// TODO Auto-generated method stub
		return brepos.findById(id);
	}

	@Override
	public List<Billet> findAllBillets() {
		// TODO Auto-generated method stub
		return (List<Billet>) brepos.findAll();
	}

	/*@Override
	public void delete(Long idBillet) {
		// TODO Auto-generated method stub
		brepos.delete(idBillet);
	}*/
}
