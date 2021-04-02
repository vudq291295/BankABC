package org.IntegrateService.PurchasePrepaidDataSIM.Presentation.Controller;

import java.util.Objects;

import org.IntegrateService.PurchasePrepaidDataSIM.Authentication.JwtTokenUtil;
import org.IntegrateService.PurchasePrepaidDataSIM.Model.LoginRequest;
import org.IntegrateService.PurchasePrepaidDataSIM.Model.LoginResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class JwtAuthenticationController {

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JwtTokenUtil jwtTokenUtil;

	@Autowired
	private UserDetailsService jwtInMemoryUserDetailsService;

	@RequestMapping(value = "/authenticate", method = RequestMethod.POST)
	public ResponseEntity<?> createAuthenticationToken(@RequestBody LoginRequest authenticationRequest)
			throws Exception {
		System.out.println("authenticationRequest.getPhonenumber() "+authenticationRequest.getPhonenumber());
		System.out.println("authenticationRequest.getPassword() "+authenticationRequest.getPassword());

		authenticate(authenticationRequest.getPhonenumber(),authenticationRequest.getPassword());

		final UserDetails userDetails = jwtInMemoryUserDetailsService
				.loadUserByUsername(authenticationRequest.getPhonenumber());
		System.out.println("userDetails.getUsername() "+userDetails.getUsername());

		
		final String token = jwtTokenUtil.generateToken(userDetails);

		return ResponseEntity.ok(new LoginResponse(token));
	}

	private void authenticate(String phoneNumber,String password) throws Exception {
		Objects.requireNonNull(phoneNumber);

		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(phoneNumber, password));
		} catch (DisabledException e) {
			System.out.println("DisabledException: "+e);
			throw new Exception("USER_DISABLED", e);
		} catch (BadCredentialsException e) {
			System.out.println("BadCredentialsException: "+e);

			throw new Exception("INVALID_CREDENTIALS", e);
		}
	}
}
