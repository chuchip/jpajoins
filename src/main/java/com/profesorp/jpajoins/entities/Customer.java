package com.profesorp.jpajoins.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data

public class Customer implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	int id;
	
	@Column
	String name;
	
	@Column
	String address;
	
	@Column
	int active;
	
//	@OneToMany(fetch=FetchType.LAZY)
//	@Where(clause = "active = 1")
//	@JoinTable(name = "Customer",
//    	joinColumns = { @JoinColumn(name = "id") },
//    	inverseJoinColumns = { @JoinColumn(name = "customerid") }
//	)
//	List<InvoiceDetails> invoiceDetails;
}
