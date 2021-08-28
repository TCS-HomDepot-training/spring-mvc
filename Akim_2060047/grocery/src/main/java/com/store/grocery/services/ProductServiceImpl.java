package com.store.grocery.services;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.store.grocery.dto.ProductDTO;
import com.store.grocery.dto.ResponseProduct;
import com.store.grocery.entities.Product;
import com.store.grocery.repositories.ProductRepository;
import com.store.grocery.utils.CodesEnum;

@Service
public class ProductServiceImpl implements ProductService{

	@Autowired
	ProductRepository productRepository;
	
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Override
	public ResponseProduct readAll() {
		ResponseProduct response = new ResponseProduct();
		List<ProductDTO> products = productRepository.findAll().stream().map(product->{
			return new ProductDTO(product.getId(),product.getName(),product.getUnitPrice(),product.getDiscount(),product.getLastUpdateTime());
		}).collect(Collectors.toList());
		response.setObject(products);
		return response;
	}

	@Override
	public ResponseProduct create(List<ProductDTO> item) {
		ResponseProduct response = new ResponseProduct();
		try {
			List<Product> products = item.stream().map(dto->{
				return new Product(null,dto.getName(),dto.getUnitPrice(),dto.getDiscount(),LocalDate.now());
			}).collect(Collectors.toList());
			products.forEach(p -> productRepository.save(p));
			response.setStatusCode(CodesEnum.CREATE.getstatusCode());
			response.setMessage(CodesEnum.CREATE.getMesage());
		}catch(Exception e) {
			logger.info("Error: "+e);
			response.setStatusCode(CodesEnum.PERSISTENCE_ERROR.getstatusCode());
			response.setMessage(CodesEnum.PERSISTENCE_ERROR.getMesage());
		}
		return response;
	}

	@Override
	public ResponseProduct update(List<ProductDTO> item) {
		ResponseProduct response = new ResponseProduct();
		try {
			List<Product> products = item.stream().map(dto->{
				return new Product(dto.getId(),dto.getName(),dto.getUnitPrice(),dto.getDiscount(),LocalDate.now());
			}).collect(Collectors.toList());
			products.forEach(p -> productRepository.save(p));
			response.setStatusCode(CodesEnum.OK.getstatusCode());
			response.setMessage(CodesEnum.OK.getMesage());
		}catch(Exception e) {
			logger.info("Error: "+e);
			response.setStatusCode(CodesEnum.PERSISTENCE_ERROR.getstatusCode());
			response.setMessage(CodesEnum.PERSISTENCE_ERROR.getMesage());
		}
		return response;
	}

	@Override
	public ResponseProduct delete(Integer id) {
		ResponseProduct response = new ResponseProduct();
		try {
			productRepository.deleteById(id);
			response.setStatusCode(CodesEnum.OK.getstatusCode());
			response.setMessage(CodesEnum.OK.getMesage());
		}catch(Exception e) {
			logger.info("Error: "+e);
			response.setStatusCode(CodesEnum.PERSISTENCE_ERROR.getstatusCode());
			response.setMessage(CodesEnum.PERSISTENCE_ERROR.getMesage());
		}
		return response;
	}

	@Override
	public ResponseProduct getById(Integer id) {
		ResponseProduct response = new ResponseProduct();
		try {
			List<ProductDTO> products = Arrays.asList(productRepository.findById(id))
					.stream()
					.filter(Optional::isPresent)
					.map(product->{
						return new ProductDTO(product.get().getId(),product.get().getName(),product.get().getUnitPrice(),product.get().getDiscount(),product.get().getLastUpdateTime());
					}).collect(Collectors.toList());
			response.setObject(products);
		}catch(Exception e) {
			logger.info("Error: "+e);
			response.setStatusCode(CodesEnum.PERSISTENCE_ERROR.getstatusCode());
			response.setMessage(CodesEnum.PERSISTENCE_ERROR.getMesage());
		}
		return response;
	}

	@Override
	public ResponseProduct getByName(String name) {
		ResponseProduct response = new ResponseProduct();
		try {
			List<ProductDTO> products = productRepository.findByName(name)
					.stream()
					.map(product->{
						return new ProductDTO(product.getId(),product.getName(),product.getUnitPrice(),product.getDiscount(),product.getLastUpdateTime());
					}).collect(Collectors.toList());
			response.setObject(products);
		}catch(Exception e) {
			logger.info("Error: "+e);
			response.setStatusCode(CodesEnum.PERSISTENCE_ERROR.getstatusCode());
			response.setMessage(CodesEnum.PERSISTENCE_ERROR.getMesage());
		}
		return response;
	}
	
}
