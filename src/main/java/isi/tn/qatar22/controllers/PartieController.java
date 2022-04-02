package isi.tn.qatar22.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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

import isi.tn.qatar22.entities.Partie;
import isi.tn.qatar22.services.PartieService;
import isi.tn.qatar22.services.PartieServiceImp;

@RestController
@CrossOrigin(origins = "*") // api sera consommée par Angular
@RequestMapping("/api")
public class PartieController {

	@Autowired
	PartieServiceImp pserv;
	
	@PostMapping("/addmatch")
	public Partie createPartie(@Validated @RequestBody Partie partie) {
		return pserv.savePartie(partie);
		
																	  }
				
	@GetMapping("/partie/{id}")
	public Optional<Partie> getPartieById(@PathVariable(value = "id") Long Id) {
			return pserv.findById(Id);
			// .orElseThrow(() -> new ResourceNotFoundException("partie", "id", Id));
		}

		@GetMapping("/parties")
		public List<Partie> getAllparties() {
			List<Partie> pro = pserv.findAllParties();
			return pro;

		}

		@DeleteMapping("/partie/{id}")
		public ResponseEntity<?> deletePartie(@PathVariable(value = "id") Long partieId) {
			Partie partie = pserv.findById(partieId).orElseThrow(null);
			// .orElseThrow(() -> new ResourceNotFoundException("partie", "id", partieId));

			// partieRepository.deleteById(partieId);
			pserv.delete(partie);

			return ResponseEntity.ok().build();
		}
		
		@PutMapping("/partie/{id}")
		public Partie updatePartie(@PathVariable(value = "id") Long Id,
		                                        @Validated @RequestBody Partie partieDetails) {

		    Partie partie = this.pserv.findById(Id).orElseThrow(null);
		    
		   
		    partie.setDate(partieDetails.getDate());
		    partie.setEquipe1(partieDetails.getEquipe1());
		    partie.setEquipe2(partieDetails.getEquipe2());
		    partie.setNomStade(partieDetails.getNomStade());
		   

		    Partie updatedPartie = pserv.savePartie(partie);
		    return updatedPartie;
		
																							}

}
