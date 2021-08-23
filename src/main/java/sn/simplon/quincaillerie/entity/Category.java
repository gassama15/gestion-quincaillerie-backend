package sn.simplon.quincaillerie.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity(name = "categorie")
public class Category implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idCategorie;
	private String libelle;
	@OneToMany(fetch = FetchType.LAZY )
	@JoinColumn(name = "category_id")
	private List<Product> products;
	
	public Category(Long idCategorie, String libelle) {
		this.idCategorie = idCategorie;
		this.libelle = libelle;
	}

	public Category(String libelle) {
		this.libelle = libelle;
	}

	public Category() {
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public Long getIdCategorie() {
		return idCategorie;
	}

	public List<Product> getProducts() {
		return products;
	}
	
	
	
	
	
	
}
