package com.flavorstack.app;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BaseRestController {

	
	@GetMapping("/get")
	public ResponseEntity<String> get(){
		String resp = "No, never";
		return new ResponseEntity<>(resp,HttpStatus.OK);
	}
}