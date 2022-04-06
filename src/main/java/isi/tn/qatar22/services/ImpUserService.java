package isi.tn.qatar22.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import isi.tn.qatar22.entities.User;
import isi.tn.qatar22.reponses.MessageResponse;
import isi.tn.qatar22.repositories.userRepository;

@Service
public class ImpUserService implements IUserService {
	@Autowired
	userRepository urepos;

	@Transactional
	@Override
	public MessageResponse saveUser(User user) {
		boolean existe = urepos.existsByEmail(user.getEmail());
		if (existe) {
			return new MessageResponse(false, "Echec !", "Cet email existe déja !");
		}
		urepos.save(user);
		return new MessageResponse(true, "Succès", "Opération réalisée avec succès.");
	}

	/*
	 * @Override public User saveUser(User user) { // TODO Auto-generated method
	 * stub return urepos.save(user); }
	 */

	@Transactional
	@Override
	public MessageResponse delete(Long id) {
		try {
		User user = findById(id).get();
		System.out.println(user.getPwd());
		
		
			urepos.deleteById(id);
			return new MessageResponse(true, "Succès", "L'enregistrement à été supprimé avec succès.");
		}
		catch(Exception e ) {
			return new MessageResponse(false, "Echec", "Cet enregistrement n'existe pas !");

		}
		
	}

	@Override
	public Optional<User> findById(Long id) {
		// TODO Auto-generated method stub
		return urepos.findById(id);
	}

	@Override
	public List<User> findAllUsers() {
		// TODO Auto-generated method stub
		return (List<User>) urepos.findAll();
	}







}
