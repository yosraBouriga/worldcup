package isi.tn.qatar22.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import isi.tn.qatar22.models.Partie;
import isi.tn.qatar22.reponses.MessageResponse;
import isi.tn.qatar22.services.PartieServiceImp;

@RestController
@CrossOrigin(origins = "*") // api sera consommée par Angular
@RequestMapping("/api")
public class PartieController {

	@Autowired
	PartieServiceImp pserv;

	@PostMapping("/addmatch")
	@PreAuthorize("hasRole('ADMIN')")
	public MessageResponse createPartie(@Validated @RequestBody Partie partie) {
		return pserv.savePartie(partie);
		
	}

	@GetMapping("/partie/{id}")
	@PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
	public Optional<Partie> getPartieById(@PathVariable(value = "id") Long Id) {
		return pserv.findById(Id);
	}

	@GetMapping("/parties")
	@PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
	public List<Partie> getAllparties() {
		List<Partie> pro = pserv.findAllParties();
		return pro;

	}

	/*@DeleteMapping("/partie/{id}")
	public ResponseEntity<?> deletePartie(@PathVariable(value = "id") Long partieId) {
		Partie partie = pserv.findById(partieId).orElseThrow(null);

		pserv.delete(partie);

		return ResponseEntity.ok().build();
	}*/
	@DeleteMapping("/partie/{id}")
	@PreAuthorize("hasRole('ADMIN')")
	public MessageResponse deletePartie(@PathVariable(value = "id") Long idPartie) {

		return pserv.delete(idPartie);

	}

	@PutMapping("/partie/{id}")
	@PreAuthorize("hasRole('ADMIN')")
	public MessageResponse updatePartie(@PathVariable(value = "id") Long Id, @Validated @RequestBody Partie partieDetails) {

		Partie partie = this.pserv.findById(Id).orElseThrow(null);

		partie.setDate(partieDetails.getDate());
		partie.setEquipe1(partieDetails.getEquipe1());
		partie.setEquipe2(partieDetails.getEquipe2());
		partie.setNomStade(partieDetails.getNomStade());

		MessageResponse updatedPartie = pserv.savePartie(partie);
		return updatedPartie;

	}

}
