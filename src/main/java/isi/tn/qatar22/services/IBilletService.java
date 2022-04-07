package isi.tn.qatar22.services;

import java.util.List;
import java.util.Optional;

import isi.tn.qatar22.models.Billet;
import isi.tn.qatar22.reponses.MessageResponse;

public interface IBilletService {

	Optional<Billet> findById(Long id);

	MessageResponse saveBillet(Billet billet);

	List<Billet> findAllBillets();

	MessageResponse delete(Long id);

}
