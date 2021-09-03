package com.tcs.abn.recipeapi.dto;

import java.time.LocalDateTime;


public class RecipeEntityDTO {
	
	private Long id;
	private String recName;
	private LocalDateTime recDate;
	private boolean recType;
	private int recCount;
	private String recIngredients;
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
	
	
}
