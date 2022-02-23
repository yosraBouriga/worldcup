package isi.tn.qatar22.services;

import java.util.List;

import isi.tn.qatar22.entities.User;

public interface IUserService {
	User saveUser(User user);

	List<User> findAllUsers();
}
