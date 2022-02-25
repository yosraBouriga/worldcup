package isi.tn.qatar22.controllers;

import java.util.List;
import java.util.Optional;


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
@CrossOrigin(origins = "http://localhost:4200") // api sera consommée par Angular
@RequestMapping("/api")
public class UserController {
	@Autowired
	IUserService userv;

	@PostMapping("/addusert")
	public User createUser(@Validated @RequestBody User user) {
		return userv.saveUser(user);
	}

	@GetMapping("/user/{id}")
	public Optional<User> getUserById(@PathVariable(value = "id") Long Id) {
		return userv.findById(Id);
		// .orElseThrow(() -> new ResourceNotFoundException("User", "id", Id));
	}

	@GetMapping("/users")
	public List<User> getAllUsers() {
		List<User> pro = userv.findAllUsers();
		return pro;

	}

	@DeleteMapping("/user/{id}")
	public ResponseEntity<?> deleteUser(@PathVariable(value = "id") Long userId) {
		User user = userv.findById(userId).orElseThrow(null);
		// .orElseThrow(() -> new ResourceNotFoundException("User", "id", userId));

		// userRepository.deleteById(userId);
		userv.delete(user);

		return ResponseEntity.ok().build();
	}
	@PutMapping("/user/{id}")
	public User updateUser(@PathVariable(value = "id") Long Id,
	                                        @Validated @RequestBody User userDetails) {

	    User user = userv.findById(Id).orElseThrow(null);
	    
	   
	    user.setEmail(userDetails.getEmail());
	    user.setPwd(userDetails.getPwd());
	    user.setFname(userDetails.getFname());
	    user.setLname(userDetails.getLname());

	    User updatedUser = userv.saveUser(user);
	    return updatedUser;
	}
}
