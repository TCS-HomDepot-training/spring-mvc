package root.service;

import java.util.List;
import java.util.Optional;

import root.entity.Product;

public interface ProductService {

	public Product save(Product sProd);

	public Product update(Product sProd);

	public void deleteById(int sId);

	public Optional<Product> findById(int sId);

	public List<Product> findAll();

}
