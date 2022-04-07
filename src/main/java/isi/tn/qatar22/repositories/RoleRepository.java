package isi.tn.qatar22.repositories;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import isi.tn.qatar22.models.*;
@Repository
public interface RoleRepository extends JpaRepository<Role,Long> {
	Optional<Role> findByName(ERole name);
}
