package com.profesorp.jpajoins.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.annotations.FilterDef;

import lombok.Data;

@Entity
@Data
@FilterDef(name="onlyActive", defaultCondition="active = 1")
public class Customer implements Serializable {
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
