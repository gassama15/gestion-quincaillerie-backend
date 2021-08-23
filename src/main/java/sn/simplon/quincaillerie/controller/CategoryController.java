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

import sn.simplon.quincaillerie.entity.Category;
import sn.simplon.quincaillerie.service.CategoryService;

@RestController
@RequestMapping("/category")
public class CategoryController {
	
	private final CategoryService categoryService;

	@Autowired
	public CategoryController(CategoryService categoryService) {
		this.categoryService = categoryService;
	}
	
	@GetMapping
	public ResponseEntity<List<Category>> getAllCategories(){
		List<Category> categories = this.categoryService.getAllCategories();
		
		return new ResponseEntity<>(categories, HttpStatus.OK);
	}
	
	
	@GetMapping("/show/{idCategorie}")
	public ResponseEntity<Category> getCategoryById(@PathVariable("idCategorie") 
	Long idCategorie) {
		Category categorie = this.categoryService.findCategoryById(idCategorie);
		
		return new ResponseEntity<>(categorie, HttpStatus.OK);
	}
	
	
	@PostMapping("/new")
	public ResponseEntity<Category> addCategory(@RequestBody Category category){
		Category newCategory = this.categoryService.addCategory(category);
		
		return new ResponseEntity<>(newCategory, HttpStatus.CREATED);
	}
	
	
	@PutMapping("/update")
	public ResponseEntity<Category> updateCategory(@RequestBody Category category){
		Category updatedCategory = this.categoryService.updateCategory(category);
		
		return new ResponseEntity<>(updatedCategory, HttpStatus.OK);
	}
	
	
	@DeleteMapping("/delete/{idCategorie}")
	public ResponseEntity<?> deleteCategory(@PathVariable("idCategorie") 
	Long idCategorie){
		this.categoryService.deleteCategory(idCategorie);
		
		return new ResponseEntity<>(HttpStatus.OK);
	}
	

}
