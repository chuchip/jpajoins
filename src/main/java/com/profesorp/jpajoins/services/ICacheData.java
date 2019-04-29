package com.profesorp.jpajoins.services;

import com.profesorp.jpajoins.dtos.DtoRequest;
import com.profesorp.jpajoins.dtos.DtoResponse;

public interface ICacheData {
	
	public DtoResponse  getDataCache(int id);
	public  DtoResponse update(DtoRequest dtoRequest);
	public void flushCache();
}
