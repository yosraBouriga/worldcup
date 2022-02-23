package isi.tn.qatar22.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.validation.annotation.Validated;




import isi.tn.qatar22.entities.User;
import isi.tn.qatar22.services.IUserService;

@RestController
@CrossOrigin(origins = "http://localhost:4200") //api sera consommée par Angular
@RequestMapping("/api")
public class UserController {
	@Autowired
	IUserService userv;
	
	@PostMapping("/addusert")
	public User createUser(@Validated @RequestBody User user) {
	    return userv.saveUser(user);
	}
	
}
