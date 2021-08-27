package root.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import root.entity.Product;
import root.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	public ProductRepository productRepository;
	
	
	@Override
	public Product save(Product sProd) {

		return productRepository.save(sProd);
	}

	@Override
	public Product update(Product sProd) {
	
		return productRepository.save(sProd);
	}

	@Override
	public void deleteById(int sId) {

		productRepository.deleteById(sId);
	}


	@Override
	public Optional<Product> findById(int sId) {

		return productRepository.findById(sId);
	}

	@Override
	public List<Product> findAll() {

		  return productRepository.findAll();
	}

	

	

}
