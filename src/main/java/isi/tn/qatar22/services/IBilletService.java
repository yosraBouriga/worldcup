package isi.tn.qatar22.services;

import java.util.List;
import java.util.Optional;

import isi.tn.qatar22.entities.Billet;
import isi.tn.qatar22.entities.User;

public interface IBilletService {

	Optional<Billet> findById(Long id);

	Billet saveBillet(Billet billet);

	List<Billet> findAllBillets();

	void delete(Billet billet);
	





}
