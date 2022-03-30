package isi.tn.qatar22.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import isi.tn.qatar22.entities.Billet;
import isi.tn.qatar22.entities.Partie;
@Repository 
public interface BilletRepository extends CrudRepository<Billet, Long>{

	
}
