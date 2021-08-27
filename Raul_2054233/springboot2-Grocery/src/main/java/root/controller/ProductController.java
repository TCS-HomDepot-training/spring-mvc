package root.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import root.entity.Product;
import root.exception.ResourceNotFoundException;
import root.service.ProductService;

@RestController
@RequestMapping("/gorcery")
public class ProductController {

	@Autowired
	public ProductService productService;

	@PostMapping("/add")
	public ResponseEntity<?> create(@RequestBody Product prodRequest) {

		return ResponseEntity.status(HttpStatus.CREATED).body(productService.save(prodRequest));
	}

	@GetMapping("/getById/{id}")
	public ResponseEntity<?> findById(@PathVariable int id) {
		Optional<Product> oProduct = productService.findById(id);

		if (!oProduct.isPresent()) {
			return ResponseEntity.notFound().build();
		}

		return ResponseEntity.ok(oProduct);
	}

	@DeleteMapping("/del/{id}")
	public ResponseEntity<?> delete(@PathVariable(value = "id") int prodId) {
		Product existingPdt = this.productService.findById(prodId)
				.orElseThrow(() -> new ResourceNotFoundException("Product not found with id :" + prodId));
		this.productService.deleteById(prodId);
		return ResponseEntity.ok().build();
	}

	@GetMapping("/getName/{name}")
	public List<Product> findByName(@PathVariable String name) {

		List<Product> Products = StreamSupport.stream(productService.findAll().spliterator(), false)
				.filter(x -> x.getName().equals(name)).collect(Collectors.toList());

		return Products;
	}

	// update user
	@PutMapping("/update/{id}")
	public Product updateUser(@RequestBody Product pdt, @PathVariable("id") int pdtId) {
		Product existingPdt = this.productService.findById(pdtId)
				.orElseThrow(() -> new ResourceNotFoundException("Product not found with id :" + pdtId));
		existingPdt.setName(pdt.getName());
		existingPdt.setUnitPrice(pdt.getUnitPrice());
		existingPdt.setDiscount(pdt.getDiscount());
		existingPdt.setLastUpdateTime(pdt.getLastUpdateTime());
		return this.productService.save(existingPdt);
	}
	
	@GetMapping("/all")
	public List<Product> getProduct() {
		return  this.productService.findAll();
	}

}
