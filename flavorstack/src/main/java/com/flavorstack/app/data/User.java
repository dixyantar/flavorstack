package com.flavorstack.app.data;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Entity
@Data
@AllArgsConstructor
@Builder
public class User {
	
	private @Id Long id;
	private String firstName;
	private String lastName;
	private String emailId;
	private Date createdOn;
	private Date lastLogin;
	

}
