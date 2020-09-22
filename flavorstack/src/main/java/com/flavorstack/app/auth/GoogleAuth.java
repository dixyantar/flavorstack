package com.flavorstack.app.auth;

import java.util.Collections;

import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken.Payload;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdTokenVerifier;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.gson.GsonFactory;

public class GoogleAuth {

	private GoogleIdTokenVerifier verifier;
	private static final String CLIENT_ID = "70335511196-acnuatmjb07pbcftigiqfh2th7rk4o2c.apps.googleusercontent.com";

	public GoogleAuth() throws Exception {
		HttpTransport transport = GoogleNetHttpTransport.newTrustedTransport();
		JsonFactory jsonFactory = GsonFactory.getDefaultInstance();
		this.verifier = new GoogleIdTokenVerifier.Builder(transport, jsonFactory)
				.setAudience(Collections.singletonList(CLIENT_ID)).build();
	}
	
	public boolean isVerified(String idTokenString) throws Exception {
		boolean isVerified = false;
		GoogleIdToken idToken = verifier.verify(idTokenString);
		if (idToken != null) {
		  Payload payload = idToken.getPayload();

		  // Print user identifier
		  String userId = payload.getSubject();
		  System.out.println(payload.toPrettyString() );

		  // Get profile information from payload
		  String email = payload.getEmail();
		  boolean emailVerified = Boolean.valueOf(payload.getEmailVerified());
		  String name = (String) payload.get("name");
		  String pictureUrl = (String) payload.get("picture");
		  String locale = (String) payload.get("locale");
		  String familyName = (String) payload.get("family_name");
		  String givenName = (String) payload.get("given_name");

		  
		  isVerified = true;

		} 
		return isVerified;
	}

}
