package isi.tn.qatar22.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import isi.tn.qatar22.entities.User;
import isi.tn.qatar22.repositories.userRepository;
import isi.tn.qatar22.services.IUserService;

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
	public List<User> findAllUsers() {
		// TODO Auto-generated method stub
		return (List<User>) urepos.findAll();
	}
}
