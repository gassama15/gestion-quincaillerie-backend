package sn.simplon.quincaillerie.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import sn.simplon.quincaillerie.dao.CategoryRepository;
import sn.simplon.quincaillerie.entity.Category;
import sn.simplon.quincaillerie.exception.CategoryNotFoundException;

@Service
public class CategoryService {
	
	private final CategoryRepository categoryRepository;

	@Autowired
	public CategoryService(CategoryRepository categoryRepository) {
		this.categoryRepository = categoryRepository;
	}
	
	public Category addCategory(Category category) {
		return this.categoryRepository.save(category);
	}
	
	public List<Category> getAllCategories() {
		return this.categoryRepository.findAll(Sort.by(Sort.Direction.DESC, "idCategorie"));
	}
	
	public Category updateCategory(Category category) {
		return this.categoryRepository.save(category);
	}
	
	public Category findCategoryById(Long id) {
		return this.categoryRepository.findCategoryByIdCategorie(id)
				.orElseThrow(() -> new CategoryNotFoundException("Catégorie avec id "+id+" n'existe pas"));
	}
	
	public void deleteCategory(Long id) {
		this.categoryRepository.deleteById(id);
	}
	
	
	

}
