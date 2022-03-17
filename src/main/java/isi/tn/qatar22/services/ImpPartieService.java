package isi.tn.qatar22.services;

import org.springframework.beans.factory.annotation.Autowired;

import isi.tn.qatar22.entities.Partie;
import isi.tn.qatar22.repositories.partieRepository;

public class ImpPartieService implements IPartieService{
	@Autowired
	partieRepository prepos;
	
	@Override
	public Partie savePartie(Partie partie) {
		// TODO Auto-generated method stub
		return prepos.save(partie);
	}

}
