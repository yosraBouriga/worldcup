package isi.tn.qatar22.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import isi.tn.qatar22.entities.Partie;
import isi.tn.qatar22.services.IPartieService;

@RestController
@CrossOrigin(origins = "http://localhost:4200") // api sera consommée par Angular
@RequestMapping("/api")
public class PartieController {

	@Autowired(required=true)
	IPartieService pserv;
	
	@PostMapping("/addmatch")
	public Partie createPartie(@Validated @RequestBody Partie partie) {
		return pserv.savePartie(partie);
	}

}
