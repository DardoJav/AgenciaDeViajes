package com.agenciaDeViajesMVC.services;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.agenciaDeViajesMVC.daos.PassengerDao;
import com.agenciaDeViajesMVC.modelos.Passenger;
import com.agenciaDeViajesMVC.modelos.UserRole;

public class LoginUserServiceImpl implements UserDetailsService {
	
	private PassengerDao passengerDao;
	
	public UserDetails loadUserByUsername(final String username) throws UsernameNotFoundException {

		Passenger passenger = passengerDao.findPassengerByName(username);
		List<GrantedAuthority> authorities = buildUserAuthority(passenger.getUserRoles());

		return buildUserForAuthentication(passenger, authorities);


	}

	private User buildUserForAuthentication(Passenger passenger, List<GrantedAuthority> authorities) {
		return new User(passenger.getName(), passenger.getPassword(), passenger.isEnabled(), true, true, true, authorities);
	}

	private List<GrantedAuthority> buildUserAuthority(Set<UserRole> userRoles) {

		Set<GrantedAuthority> setAuths = new HashSet<GrantedAuthority>();
		
		// Build user's authorities
		for (UserRole userRole : userRoles) {
			setAuths.add(new SimpleGrantedAuthority(userRole.getRole()));
		}
		
		List<GrantedAuthority> Result = new ArrayList<GrantedAuthority>(setAuths);

		return Result;
	}

	public PassengerDao getPassengerDao() {
		return passengerDao;
	}

	public void setPassengerDao(PassengerDao passengerDao) {
		this.passengerDao = passengerDao;
	}
	
}
