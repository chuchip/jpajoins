package com.profesorp.jpajoins.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import com.profesorp.jpajoins.dtos.DtoRequest;
import com.profesorp.jpajoins.dtos.DtoResponse;
import com.profesorp.jpajoins.entities.Invoiceheader;
import com.profesorp.jpajoins.repository.invoiceHeaderRepository;
import com.profesorp.jpajoins.services.ICacheData;

@Component
public class CacheDataImpl implements ICacheData{
	@Autowired
	invoiceHeaderRepository invoiceHeaderRepository;
	
	@Override	
    @Cacheable(cacheNames="headers", condition="#id > 1")
	public DtoResponse getDataCache(int id) {	
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		DtoResponse requestResponse=new DtoResponse();		
		Optional<Invoiceheader> invoice=invoiceHeaderRepository.findById(id);
		
		 if (invoice.isPresent())
		 {
			 requestResponse.setInvoiceHeader(invoice.get());
			 requestResponse.setHttpStatus(HttpStatus.OK);
			 return requestResponse;
		 }
		 requestResponse.setHttpStatus(HttpStatus.NOT_FOUND);
		 return requestResponse;		
	}

	@Override
	@CacheEvict(cacheNames="headers", allEntries=true)
	public void flushCache() {		
	}
	
	@CachePut(cacheNames="headers", key="#dtoRequest.id")
	public  DtoResponse update(DtoRequest dtoRequest)
	{
		DtoResponse requestResponse=new DtoResponse();			
		Optional<Invoiceheader> invoiceOptional=invoiceHeaderRepository.findById(dtoRequest.getId());
		 if (! invoiceOptional.isPresent())
		 {
			 requestResponse.setHttpStatus(HttpStatus.BAD_REQUEST);
			 return requestResponse;
		 }
		Invoiceheader invoice= invoiceOptional.get();
		invoice.setActivo(dtoRequest.getActive());
		invoiceHeaderRepository.save(invoice);

		requestResponse.setInvoiceHeader(invoice);
		requestResponse.setHttpStatus(HttpStatus.OK);
		return requestResponse;
	}

}
