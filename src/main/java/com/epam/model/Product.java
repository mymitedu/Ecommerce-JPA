package com.epam.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Product.java - The below code contain product Model.
 * @author  Krishna Kumar Singh
 * @role Junior Software Engineer
 * @contact krishna_singh1@epam.com
 */
@Entity(name = "Product")
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "Product_Id", updatable = false, nullable = false)
	private Integer productId;
	
	@Column(name = "Category_Id", updatable = false, nullable = false)
	// @OneToMany(mappedBy = "Category_Id")
	private Integer categoryId;
	
	@Column(name = "SubCategory_Id", updatable = false, nullable = false)
	//@OneToMany(mappedBy = "SubCategory_Id")
	private Integer subCategoryId;
	
	@Column(name = "Product_Name", updatable = false, nullable = false)
	private String name;
	
	@Column(name = "Product_Price", updatable = false, nullable = false)
	private Double price;
	
	@Column(name = "Product_Stock", updatable = false, nullable = false)
	private Integer stock;
	
	public Product () {       
	}
	
	public Product (Integer productId, Integer categoryId, Integer subCategoryId, String name, Double price, Integer stock) {
	    this.productId = productId;
	    this.categoryId = categoryId;
	    this.subCategoryId = subCategoryId;
	    this.name = name;
	    this.price = price;
	    this.stock = stock;
	}

	public String getName() {
	    return name;
	}
	
	public void setName(String name) {
	    this.name = name;
	}
	
	public Double getPrice() {
	    return price;
	}
	
	public void setPrice(Double price) {
	    this.price = price;
	}
	
	public Integer getStock() {
	    return stock;
	}
	
	public void setStock(Integer stock) {
	    this.stock = stock;
	}
	
	public Integer getProductId() {
	    return productId;
	}
	
	public void setProductId(Integer productId) {
	    this.productId = productId;
	}   
	
	public Integer getSubCategoryId() {
	    return subCategoryId;
	}
	
	public void setSubCategoryId(Integer subCategoryId) {
	    this.subCategoryId = subCategoryId;
	}
	
	public Integer getCategoryId() {
	    return categoryId;
	}
	
	public void setCategoryId(Integer categoryId) {
	    this.categoryId = categoryId;
	}	
}
