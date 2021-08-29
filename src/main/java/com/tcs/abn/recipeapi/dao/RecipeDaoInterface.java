package com.tcs.abn.recipeapi.dao;


import java.util.List;

import com.tcs.abn.recipeapi.entity.Recipe;

public interface RecipeDaoInterface {
	
	public List<Recipe> getAllRecipe();
	
	public  Recipe getRecipe(int id);
	
	public void addRecipe(Recipe recipe);
	
	public void updateRecipe(Recipe recipe);
	
	public void deleteRecipe(int id);
	

}
