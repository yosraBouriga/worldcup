package isi.tn.qatar22.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import isi.tn.qatar22.entities.User;
import isi.tn.qatar22.repositories.userRepository;


@Service
public class ImpUserService implements IUserService {
	@Autowired
	userRepository urepos;

	@Override
	public User saveUser(User user) {
		// TODO Auto-generated method stub
		return urepos.save(user);
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

	@Override
	public void delete(User user) {
		// TODO Auto-generated method stub
		urepos.delete(user);
	}





	
}
