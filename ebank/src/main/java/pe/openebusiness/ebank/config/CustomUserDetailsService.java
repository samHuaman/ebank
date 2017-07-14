package pe.openebusiness.ebank.config;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.openebusiness.ebank.config.service.UserService;
import pe.openebusiness.ebank.model.Authority;
import pe.openebusiness.ebank.model.Role;
import pe.openebusiness.ebank.model.User;
import pe.openebusiness.ebank.util.Helpers;

@Service("customUserDetailsService")
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	private UserService userService;

	@Override
	@Transactional(readOnly = true)
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userService.findByUsername(username);

		if (user == null) {
			throw new UsernameNotFoundException("User with username: " + username + " not found");
		}

		return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
				Helpers.intToBoolean(user.getEnabled()), accountNonExpired(user), credentialsNonExpired(user),
				accountNonLocked(user), getGrantedAuthorities(user));
	}

	private List<GrantedAuthority> getGrantedAuthorities(User user) {
		List<GrantedAuthority> grantedAuthorities = new ArrayList<GrantedAuthority>();

		for (Role role : user.getRoles()) {
			for (Authority authority : role.getAuthorities()) {
				grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_" + authority.getDescription()));
			}
		}

		return grantedAuthorities;
	}

	private boolean accountNonExpired(User user) {
		LocalDateTime ldt = LocalDateTime.now();
		Date now = Date.from(ldt.atZone(ZoneId.systemDefault()).toInstant());

		if (user.getUser_expired_date() != null) {
			int result = now.compareTo(user.getUser_expired_date());

			if (result < 0) {
				return true;
			} else {
				return false;
			}
		}

		return true;
	}

	private boolean accountNonLocked(User user) {
		LocalDateTime ldt = LocalDateTime.now();
		Date now = Date.from(ldt.atZone(ZoneId.systemDefault()).toInstant());

		if (user.getEnd_lock_date() != null) {
			int result = now.compareTo(user.getEnd_lock_date());

			if (result >= 0) {
				return true;
			} else {
				return false;
			}
		}

		return true;
	}

	private boolean credentialsNonExpired(User user) {
		LocalDateTime ldt = LocalDateTime.now();
		Date now = Date.from(ldt.atZone(ZoneId.systemDefault()).toInstant());

		if (user.getCredentials_expired_date() != null) {
			int result = now.compareTo(user.getCredentials_expired_date());

			if (result < 0) {
				return true;
			} else {
				return false;
			}
		}

		return true;
	}

}
