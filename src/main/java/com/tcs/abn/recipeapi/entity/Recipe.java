package com.tcs.abn.recipeapi.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

@Entity
@Table
public class Recipe {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column
	@Size(min=2,message = "Name must contain atleast 2 character")
	@NotBlank
	private String recName;
	
	@Past
	private LocalDateTime recDate;
	
	@Column
	@NotNull
	private boolean recType;
	
	@Column
	@Min(value = 1, message = "Must have atleast 1 quantity")
	private int recCount;
	
	@Column
	@NotBlank(message = "Must mention all the ingredients")
	private String recIngredients;
	
	
	@Column
	@NotNull
	private String recInstruction;
	
	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getRecName() {
		return recName;
	}


	public void setRecName(String recName) {
		this.recName = recName;
	}


	public LocalDateTime getRecDate() {
		return recDate;
	}


	public void setRecDate(LocalDateTime recDate) {
		this.recDate = recDate;
	}


	public boolean isRecType() {
		return recType;
	}


	public void setRecType(boolean recType) {
		this.recType = recType;
	}


	public int getRecCount() {
		return recCount;
	}


	public void setRecCount(int recCount) {
		this.recCount = recCount;
	}


	public String getRecIngredients() {
		return recIngredients;
	}


	public void setRecIngredients(String recIngredients) {
		this.recIngredients = recIngredients;
	}


	public String getRecInstruction() {
		return recInstruction;
	}


	public void setRecInstruction(String recInstruction) {
		this.recInstruction = recInstruction;
	}

	public Recipe() {
		
	}
		
}
