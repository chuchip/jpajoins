package com.profesorp.jpajoins.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Transient;

import org.hibernate.annotations.JoinColumnOrFormula;
import org.hibernate.annotations.JoinColumnsOrFormulas;
import org.hibernate.annotations.JoinFormula;

import lombok.Data;

@Entity
@Data
public class Invoiceheader  implements Serializable{
	
	private static final long serialVersionUID = 1L;

	
	@Id
	int id;

	@Column(name="active")
	String activo;	

	@Column(name="fiscalyear")
	int yearFiscal;
	@Column(name="numberinvoice")
	int numberInvoice;

	@Column(name="customerid",insertable=false, updatable=false)
	int customerId;

	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumnsOrFormulas({
		 @JoinColumnOrFormula(column=@JoinColumn(name="customerid", referencedColumnName ="id") ),
		 @JoinColumnOrFormula(formula = @JoinFormula(value="1",referencedColumnName = "active"))
	})	
	Customer customer;

	@OneToMany(fetch=FetchType.EAGER)
	@JoinColumns(
			{
				@JoinColumn(name="fiscalyear",referencedColumnName="fiscalyear"),	
				@JoinColumn(name="numberinvoice",referencedColumnName="numberinvoice")				
			}			
			)
	@OrderBy("linea desc")
	List<Invoicedetails> details;
	
	
}
