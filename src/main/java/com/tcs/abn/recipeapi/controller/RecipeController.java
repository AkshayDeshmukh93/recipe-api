package com.tcs.abn.recipeapi.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.tcs.abn.recipeapi.dto.RecipeDTO;
import com.tcs.abn.recipeapi.entity.Recipe;
import com.tcs.abn.recipeapi.service.RecipeServiceInterface;

@RestController
public class RecipeController {

	
	@Autowired
	private RecipeServiceInterface recService;
	
	Logger log= LoggerFactory.getLogger(RecipeController.class);
	
	@GetMapping("/rest/recipe")
	public List<RecipeDTO> getAllRecipe(){
		log.info("Invoked getAllRecipe Controller | Get Rest Call");
		return recService.getAllRecipe();
	}
	
	
	@GetMapping("/rest/recipe/{id}")
	public RecipeDTO getRecipe(@PathVariable int id){
		log.info("Invoked getRecipe Controller | Get Rest Call");		
		return recService.getRecipe(id); 
			
	}
	
	@PostMapping("/rest/addrecipe")
	public void addRecipe (@Valid @RequestBody Recipe recipe){
		log.info("Invoked addRecipe Controller | Post Rest Call");	
		 recService.addRecipe(recipe);
		
	}
	
	@DeleteMapping("/rest/deleteRecipe/{id}")
	public void deleteRecipe(@PathVariable int id) {
		log.info("Invoked deleteRecipe Controller | delete Rest Call");
		recService.deleteRecipe(id);
	}
	
	@PutMapping("/rest/updaterecipe")
	public void updateRecipe(@RequestBody Recipe recipe) {
		log.info("Invoked updateRecipe Controller | Put Rest Call");
		recService.updateRecipe(recipe);
		
	}
}
