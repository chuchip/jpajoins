package com.profesorp.jpajoins.entities;

 

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

import lombok.Data;

@Entity
@Data
public class Invoicedetails {
	@Id
	int id;
	
	@Column
	int fiscalyear;
	@Column
	int numberinvoice;
	@Column
	int lineaDetails; // La 'D' esta en mayuscualas adrede para que mapee el campo linea_details
	
	@Column
	int numberarticles;
	
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumns({
		@JoinColumn(name="articleid",referencedColumnName="id")		
	})
	Article articles;	
}
