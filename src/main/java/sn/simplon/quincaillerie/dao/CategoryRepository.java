package sn.simplon.quincaillerie.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import sn.simplon.quincaillerie.entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {

	Optional<Category> findCategoryByIdCategorie(Long id);

}
