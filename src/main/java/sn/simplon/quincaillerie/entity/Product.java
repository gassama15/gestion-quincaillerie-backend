package sn.simplon.quincaillerie.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name = "produit")
public class Product implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idProduit;
	private String nomProduit;
	private String description;
	private String photo;
	private Long prix;
	private Long qte;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "category_id")
	private Category category;
	
	
	public Product(String nomProduit, String description, String photo, Long prix, Long qte, Category category) {
		this.nomProduit = nomProduit;
		this.description = description;
		this.photo = photo;
		this.prix = prix;
		this.qte = qte;
		this.category = category;
	}


	public Product(Long idProduit, String nomProduit, String description, String photo, Long prix, Long qte,
			Category category) {
		this.idProduit = idProduit;
		this.nomProduit = nomProduit;
		this.description = description;
		this.photo = photo;
		this.prix = prix;
		this.qte = qte;
		this.category = category;
	}


	public Product() {
	}


	public String getNomProduit() {
		return nomProduit;
	}


	public void setNomProduit(String nomProduit) {
		this.nomProduit = nomProduit;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public String getPhoto() {
		return photo;
	}


	public void setPhoto(String photo) {
		this.photo = photo;
	}


	public Long getPrix() {
		return prix;
	}


	public void setPrix(Long prix) {
		this.prix = prix;
	}


	public Long getQte() {
		return qte;
	}


	public void setQte(Long qte) {
		this.qte = qte;
	}


	public Category getCategory() {
		return category;
	}


	public void setCategory(Category category) {
		this.category = category;
	}


	public Long getIdProduit() {
		return idProduit;
	}


	public void setIdProduit(Long idProduit) {
		this.idProduit = idProduit;
	}
	
	
	
	
	
	
	
	
}
