package sn.simplon.quincaillerie.controller;

import java.util.List;

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

import sn.simplon.quincaillerie.entity.Product;
import sn.simplon.quincaillerie.service.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController {
	
	private final ProductService productService;

	@Autowired
	public ProductController(ProductService productService) {
		this.productService = productService;
	}
	
	@GetMapping
	public ResponseEntity<List<Product>> getAllProducts(){
		List<Product> products = this.productService.getAllProducts();
		
		return new ResponseEntity<>(products, HttpStatus.OK);
	}
	
	@GetMapping("/show/{id}")
	public ResponseEntity<Product> getProductById(@PathVariable("id") Long id){
		Product product = this.productService.findProductById(id);
		
		return new ResponseEntity<>(product, HttpStatus.OK);
	}
	
	@PostMapping("/new")
	public ResponseEntity<Product> addProduct(@RequestBody Product product){
		Product newProduct = this.productService.addProduct(product);
		
		return new ResponseEntity<>(newProduct, HttpStatus.CREATED);
	}
	
	@PutMapping("/update")
	public ResponseEntity<Product> updateProduct(@RequestBody Product product){
		Product updatedProduct = this.productService.updateProduct(product);
		
		return new ResponseEntity<>(updatedProduct, HttpStatus.OK);
	}
	
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteProduct(@PathVariable("id") Long id){
		this.productService.deleteProduct(id);
		
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	

}
