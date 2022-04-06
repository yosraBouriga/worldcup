package isi.tn.qatar22.services;

import java.util.List;
import java.util.Optional;

import isi.tn.qatar22.entities.User;
import isi.tn.qatar22.reponses.MessageResponse;

public interface IUserService {
	MessageResponse saveUser(User user);

	Optional<User> findById(Long id);


	List<User> findAllUsers();

//	void delete(Optional<User> user);


	MessageResponse delete(Long id);



}
