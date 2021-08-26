package sn.simplon.quincaillerie.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import sn.simplon.quincaillerie.dao.ProductRepository;
import sn.simplon.quincaillerie.entity.Product;
import sn.simplon.quincaillerie.exception.ProductNotFoundException;

@Service
public class ProductService {

	private final ProductRepository productRepository;

	@Autowired
	public ProductService(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}
	
	
	public Product addProduct(Product product) {
		return this.productRepository.save(product);
	}
	
	
	public List<Product> getAllProducts() {
		return this.productRepository.findAll(Sort.by(Sort.Direction.DESC, "idProduit"));
	}
	
	
	public Product updateProduct(Product product) {
		return this.productRepository.save(product);
	}
	
	public Product findProductById(Long id) {
		return this.productRepository.findProductByIdProduit(id)
				.orElseThrow(() -> new ProductNotFoundException("Produit avec id "+id+" n'existe pas"));
	}
	
	public void deleteProduct(Long id) {
		this.productRepository.deleteById(id);
	}
	
}
