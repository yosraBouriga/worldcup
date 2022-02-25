package isi.tn.qatar22.services;

import java.util.List;
import java.util.Optional;

import isi.tn.qatar22.entities.User;

public interface IUserService {
	User saveUser(User user);

	Optional<User> findById(Long id);


	List<User> findAllUsers();

	void delete(User user);


}
