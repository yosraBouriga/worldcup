package isi.tn.qatar22.repositories;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import isi.tn.qatar22.entities.User;
@Repository 
public interface userRepository extends JpaRepository<User,Long> {
	boolean existsByEmail(String email);

//	void delete(Optional<User> user);

}
