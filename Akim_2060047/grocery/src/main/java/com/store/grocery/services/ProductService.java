package com.store.grocery.services;

import com.store.grocery.dto.ProductDTO;
import com.store.grocery.dto.ResponseProduct;

public interface ProductService extends CrudService<ProductDTO,ResponseProduct>{	
	
	public ResponseProduct getById(Integer id);
	
	public ResponseProduct getByName(String name);

}
