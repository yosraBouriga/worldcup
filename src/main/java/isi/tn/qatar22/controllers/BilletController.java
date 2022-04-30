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

import isi.tn.qatar22.models.Billet;
import isi.tn.qatar22.reponses.MessageResponse;
import isi.tn.qatar22.services.ImpBilletService;

@RestController
@CrossOrigin(origins = "*") // api sera consommée par Angular
@RequestMapping("/api")
public class BilletController {

	@Autowired
	ImpBilletService bserv;
	
	@PostMapping("/addbillet")
	@PreAuthorize("hasRole('ADMIN')")
	public MessageResponse createBillet(@Validated @RequestBody Billet billet) {
		return bserv.saveBillet(billet);
		
																	  }
				
	@GetMapping("/billet/{id}")
	@PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
	public Optional<Billet> getBilletById(@PathVariable(value = "id") Long Id) {
			return bserv.findById(Id);
			// .orElseThrow(() -> new ResourceNotFoundException("partie", "id", Id));
		}

	@GetMapping("/billet")
	@PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
	public List<Billet> getAllBillets() {
		List<Billet> pro = bserv.findAllBillets();
			return pro;

		}

		/*@DeleteMapping("/billet/{id}")
		public ResponseEntity<?> deleteBillet(@PathVariable(value = "id") Long billetId) {
			Billet billet = pserv.findById(billetId).orElseThrow(null);
			// .orElseThrow(() -> new ResourceNotFoundException("partie", "id", partieId));

			// partieRepository.deleteById(partieId);
			pserv.delete(billet);

			return ResponseEntity.ok().build();
		}*/
		@DeleteMapping("/billet/{id}")
		@PreAuthorize("hasRole('ADMIN')")
		public MessageResponse deleteBillet(@PathVariable(value = "id") Long idBillet) {

			return bserv.delete(idBillet);

		}
		
		@PutMapping("/billet/{id}")
		@PreAuthorize("hasRole('ADMIN')")
		public MessageResponse updateBillet(@PathVariable(value = "id") Long Id,
		                                        @Validated @RequestBody Billet billetDetails) {

			Billet billet = this.bserv.findById(Id).orElseThrow(null);
		    
		   
			billet.setDate(billetDetails.getDate());
			billet.setPlace(billetDetails.getPlace());
			billet.setPrix(billetDetails.getPrix());
		 
		   

		    MessageResponse updatedBillet = bserv.saveBillet(billet);
		    return updatedBillet;
		
																							}

}
