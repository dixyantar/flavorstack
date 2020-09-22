package com.flavorstack.app.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.flavorstack.app.auth.GoogleAuth;

@RestController
public class AuthController {

	private GoogleAuth gAuth;

	public AuthController() throws Exception {
		gAuth = new GoogleAuth();
	}

	@GetMapping("/get")
	public ResponseEntity<String> get() {
		String resp = "Auto Build Success";
		return new ResponseEntity<>(resp, HttpStatus.OK);
	}

	@PostMapping("/authSuccess")
	public ResponseEntity<String> authSucess(@RequestParam String idtoken) throws Exception {
		
		if(gAuth.isVerified(idtoken)) {
			return new ResponseEntity<>("Work done on auth Success", HttpStatus.OK);
		}else {
			return new ResponseEntity<>("Auth Unsuccessfull", HttpStatus.UNAUTHORIZED);
		}
	}
}
