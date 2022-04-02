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

import isi.tn.qatar22.entities.Billet;
import isi.tn.qatar22.services.IBilletService;
import isi.tn.qatar22.services.ImpBilletService;

@RestController
@CrossOrigin(origins = "*") // api sera consommée par Angular
@RequestMapping("/api")
public class BilletController {

	@Autowired
	ImpBilletService pserv;
	
	@PostMapping("/addbillet")
	public Billet createBillet(@Validated @RequestBody Billet billet) {
		return pserv.saveBillet(billet);
		
																	  }
				
	@GetMapping("/billet/{id}")
	public Optional<Billet> getBilletById(@PathVariable(value = "id") Long Id) {
			return pserv.findById(Id);
			// .orElseThrow(() -> new ResourceNotFoundException("partie", "id", Id));
		}

		@GetMapping("/billet")
		public List<Billet> getAllBillets() {
			List<Billet> pro = pserv.findAllBillets();
			return pro;

		}

		@DeleteMapping("/billet/{id}")
		public ResponseEntity<?> deleteBillet(@PathVariable(value = "id") Long billetId) {
			Billet billet = pserv.findById(billetId).orElseThrow(null);
			// .orElseThrow(() -> new ResourceNotFoundException("partie", "id", partieId));

			// partieRepository.deleteById(partieId);
			pserv.delete(billet);

			return ResponseEntity.ok().build();
		}
		
		@PutMapping("/billet/{id}")
		public Billet updateBillet(@PathVariable(value = "id") Long Id,
		                                        @Validated @RequestBody Billet billetDetails) {

			Billet billet = this.pserv.findById(Id).orElseThrow(null);
		    
		   
			billet.setDate(billetDetails.getDate());
			billet.setPlace(billetDetails.getPlace());
			billet.setPrix(billetDetails.getPrix());
		 
		   

		    Billet updatedBillet = pserv.saveBillet(billet);
		    return updatedBillet;
		
																							}

}
