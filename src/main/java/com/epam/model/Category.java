package com.epam.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Category.java - The below code contain Category Model.
 * @author  Krishna Kumar Singh
 * @role Junior Software Engineer
 * @contact krishna_singh1@epam.com
 */
@Entity(name = "Category")
public class Category {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "Category_Id", updatable = false, nullable = false)
	private Integer categoryId;
	
	@Column(name = "Category_Name", updatable = false, nullable = false)
	private String name;
	
	public Category () {       
	}
	
	public Category (Integer categoryId, String name) {
	    this.categoryId = categoryId;
	    this.name = name;
	}

	public String getName() {
	    return name;
	}
	
	public void setName(String name) {
	    this.name = name;
	}  
	
	public Integer getCategoryId() {
	    return categoryId;
	}
	
	public void setCategoryid(Integer categoryId) {
	    this.categoryId = categoryId;
	}
}
