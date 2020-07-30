package com.epam.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * SubCategory.java - The below code contain SubCategory Model.
 * @author  Krishna Kumar Singh
 * @role Junior Software Engineer
 * @contact krishna_singh1@epam.com
 */
@Entity(name = "SubCategory")
public class SubCategory {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "SubCategory_Id", updatable = false, nullable = false)
	private Integer subCategoryId;
	
	@Column(name = "Category_Id", updatable = false, nullable = false)
	//@OneToMany(mappedBy = "Category_Id")
	private Integer categoryId;
	
	@Column(name = "SubCategory_Name", updatable = false, nullable = false)
	private String name;
	
	public SubCategory () {       
	}
	
	public SubCategory (Integer subCategoryId, Integer categoryId, String name) {
	    this.subCategoryId = subCategoryId;
	    this.categoryId = categoryId;
	    this.name = name;
	}

	public String getName() {
	    return name;
	}
	
	public void setName(String name) {
	    this.name = name;
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
