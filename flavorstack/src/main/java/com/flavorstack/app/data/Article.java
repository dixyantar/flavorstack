package com.flavorstack.app.data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Entity
@Builder
@AllArgsConstructor
public class Article {

	@Id
	@GeneratedValue
	private Long id;
	
	@Lob
	private String content;
	
	private String author;
	private String type;
	private int value;
	private int weight;
	
}
