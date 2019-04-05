package com.profesorp.jpajoins.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Article {
	@Id
	int id;
	
	@Column
	String description;
	@Column
	double price;
}
