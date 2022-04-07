package isi.tn.qatar22.services;

import java.util.List;
import java.util.Optional;

import isi.tn.qatar22.models.User;
import isi.tn.qatar22.reponses.MessageResponse;

public interface IUserService {
	User saveUser(User user);

	Optional<User> findById(Long id);


	List<User> findAllUsers();



	MessageResponse delete(Long id);




}
