package isi.tn.qatar22.repositories;



import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import isi.tn.qatar22.entities.Billet;
@Repository 
public interface BilletRepository extends CrudRepository<Billet, Long>{

	
}
