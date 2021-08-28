package com.store.grocery.services;

import java.util.List;

public interface CrudService<T,R>{
	
	public R create(List<T> item);
	
	public R readAll();
	
	public R update(List<T> item);
	
	public R delete(Integer id);
}
