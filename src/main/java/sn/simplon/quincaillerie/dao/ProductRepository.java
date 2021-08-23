package sn.simplon.quincaillerie.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import sn.simplon.quincaillerie.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

	Optional<Product> findProductByIdProduit(Long id);

}
