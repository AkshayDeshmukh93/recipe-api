package com.tcs.abn.recipeapi.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tcs.abn.recipeapi.dao.RecipeDaoInterface;
import com.tcs.abn.recipeapi.dto.RecipeDTO;
import com.tcs.abn.recipeapi.entity.Recipe;

@Service
public class RecipeServiceImpl implements RecipeServiceInterface {

	@Autowired
	private RecipeDaoInterface recDao;
	
	Logger log= LoggerFactory.getLogger(RecipeServiceImpl.class);

	@Override
	public List<RecipeDTO> getAllRecipe() {
		log.info("Invoked getAllRecipe service");		
		List<Recipe> recList= recDao.getAllRecipe();
		List <RecipeDTO> newRecpList=recList.stream()
		.map(recipe -> {
			List<String> ingList= new ArrayList<>();
			RecipeDTO tempRec= new RecipeDTO();
			tempRec.setId(recipe.getId());
			tempRec.setRecName(recipe.getRecName());
			tempRec.setRecDate(recipe.getRecDate());
			tempRec.setRecType(recipe.isRecType());
			tempRec.setRecCount(recipe.getRecCount());
			tempRec.setRecInstruction(recipe.getRecInstruction());
			ingList= Stream.of(recipe.getRecIngredients().split(",", -1)).collect(Collectors.toList());
			tempRec.setRecIngredients(ingList);
			return tempRec;
				
			}).collect(Collectors.toList());
		

		return newRecpList;
	}
	
	@Override
	public RecipeDTO getRecipe(Long id) {
		log.info("Invoked getRecipe service");	
		Recipe recipe = recDao.getRecipe(id);
		RecipeDTO recResponse= new RecipeDTO();
		if(recipe!=null) {
			recResponse.setId(recipe.getId());
			recResponse.setRecName(recipe.getRecName());
			recResponse.setRecDate(recipe.getRecDate());
			recResponse.setRecType(recipe.isRecType());
			recResponse.setRecCount(recipe.getRecCount());
			recResponse.setRecInstruction(recipe.getRecInstruction());
			List<String> ingList = Stream.of(recipe.getRecIngredients().split(",", -1)).collect(Collectors.toList());
			recResponse.setRecIngredients(ingList);
					
			return recResponse;
		}else {
			recResponse=null;
					return recResponse;
		}
		
	}


	@Override
	public void addRecipe(Recipe recipe) {
		log.info("Invoked addRecipe service");
		 recDao.addRecipe(recipe);
		
	}

	@Override
	public void updateRecipe(Recipe recipe) {
		log.info("Invoked updateRecipe service");
		recDao.updateRecipe(recipe);

	}

	@Override
	public void deleteRecipe(Long id) {
		log.info("Invoked deleteRecipe service");
		recDao.deleteRecipe(id);

	}

	
}
