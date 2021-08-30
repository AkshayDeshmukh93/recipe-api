package com.tcs.abn.recipeapi.service;

import java.util.List;
import com.tcs.abn.recipeapi.dto.RecipeDTO;
import com.tcs.abn.recipeapi.entity.Recipe;

public interface RecipeServiceInterface {

	public List<RecipeDTO> getAllRecipe();

	public  RecipeDTO getRecipe(Long id);
	
	public void addRecipe(Recipe recipe);
	
	public void updateRecipe(Recipe recipe);
	
	public void deleteRecipe(Long id);
}
