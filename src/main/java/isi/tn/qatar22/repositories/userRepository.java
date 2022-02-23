package isi.tn.qatar22.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import isi.tn.qatar22.entities.User;
@Repository 
public interface userRepository extends CrudRepository<User,Long> {

}
