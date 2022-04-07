package isi.tn.qatar22.repositories;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import isi.tn.qatar22.models.User;
@Repository 
public interface userRepository extends JpaRepository<User,Long> {
	boolean existsByEmail(String email);
	Optional<User> findByUsername(String username);

	Boolean existsByUsername(String username);
	
	



}
