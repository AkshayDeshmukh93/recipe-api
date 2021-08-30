package com.tcs.abn.recipeapi.dao;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tcs.abn.recipeapi.entity.RecRepository;
import com.tcs.abn.recipeapi.entity.Recipe;


@Repository
public class RecipeDaoImpl implements RecipeDaoInterface {

	@Autowired 
	private RecRepository recRepository;
	
	Logger log= LoggerFactory.getLogger(RecipeDaoImpl.class);
	
	@Override
	public List<Recipe> getAllRecipe() {
		log.info("Invoked getAllRecipe RepositoryDao");
		return recRepository.findAll();
		
	
	}
	
	@Override
	public Recipe getRecipe(Long id) {
		log.info("Invoked getRecipe RepositoryDao");
		
		return recRepository.findById(id).get();
		
	}

	@Override
	public void addRecipe(Recipe recipe) {
		log.info("Invoked addRecipe RepositoryDao");
		 recRepository.save(recipe);
	}

	@Override
	public void updateRecipe(Recipe recipe) {
		log.info("Invoked updateRecipe RepositoryDao");
		 recRepository.save(recipe);
		
	}

	@Override
	public void deleteRecipe(Long id) {
		log.info("Invoked deleteRecipe RepositoryDao");
		
		recRepository.deleteById(id);
	}

	

	
	
}
