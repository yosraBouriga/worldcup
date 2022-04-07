package isi.tn.qatar22.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import isi.tn.qatar22.models.User;
import isi.tn.qatar22.repositories.*;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	@Autowired
	userRepository userRepository;

	@Override
	@Transactional
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		isi.tn.qatar22.models.User user = userRepository.findByUsername(username)
				.orElseThrow(() -> new UsernameNotFoundException("User Not Found with username: " + username));

		return UserDetailsImpl.build(user);
	}

}
