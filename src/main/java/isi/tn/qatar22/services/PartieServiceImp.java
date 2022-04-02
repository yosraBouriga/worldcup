package isi.tn.qatar22.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import isi.tn.qatar22.entities.Partie;
import isi.tn.qatar22.entities.User;
import isi.tn.qatar22.repositories.PartieRepository;

@Service
public class PartieServiceImp implements PartieService{
	@Autowired
	PartieRepository prepos;
	
	@Override
	public Partie savePartie(Partie partie) {
		// TODO Auto-generated method stub
		return prepos.save(partie);
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

	@Override
	public void delete(Partie partie) {
		// TODO Auto-generated method stub
		this.prepos.delete(partie);

		
	}

	

}
