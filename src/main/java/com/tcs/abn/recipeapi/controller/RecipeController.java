package com.tcs.abn.recipeapi.controller;

import java.util.List;
import java.util.NoSuchElementException;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tcs.abn.recipeapi.dto.RecipeDTO;
import com.tcs.abn.recipeapi.dto.RecipeEntityDTO;
import com.tcs.abn.recipeapi.entity.Recipe;
import com.tcs.abn.recipeapi.exception.ResourceNoFoundException;
import com.tcs.abn.recipeapi.service.RecipeServiceInterface;

@RestController
public class RecipeController {

	
	@Autowired
	private RecipeServiceInterface recService;
	
	Logger log= LoggerFactory.getLogger(RecipeController.class);
	
	@GetMapping("/rest/recipe")
	public ResponseEntity<List<RecipeDTO>> getAllRecipe(){
		log.info("Invoked getAllRecipe Controller | Get Rest Call");
		List<RecipeDTO> recList=recService.getAllRecipe();
		
		  if(!(recList.isEmpty() ||recList==null)) {
			  return new ResponseEntity<>(recList,HttpStatus.OK);
		  }else {
			  throw new	  ResourceNoFoundException("Recipe Not Exists");
			  
		  }
			  
			
		 
		
		
		
	}
	
	
	@GetMapping("/rest/recipe/{id}")
	public ResponseEntity<RecipeDTO> getRecipe(@PathVariable Long id){
		log.info("Invoked getRecipe Controller | Get Rest Call");	
		RecipeDTO recipe= recService.getRecipe(id);
		if(recipe!=null) {
			return new ResponseEntity<>(recipe,HttpStatus.OK); 
		}else {
			throw new NoSuchElementException(" Not found");
		}
			
			
		
		
			
	}
	
	@PostMapping("/rest/addrecipe")
	public ResponseEntity<String> addRecipe (@Valid @RequestBody RecipeEntityDTO recipe){
		log.info("Invoked addRecipe Controller | Post Rest Call");	
		 
		 ModelMapper modelMapper=new ModelMapper();
		 
		recService.addRecipe(modelMapper.map(recipe, Recipe.class));
		 	 
		return new ResponseEntity<String>(HttpStatus.CREATED);
		
	}
	
	@DeleteMapping("/rest/deleteRecipe/{id}")
	public ResponseEntity<String>  deleteRecipe(@PathVariable Long id) {
		
		log.info("Invoked deleteRecipe Controller | delete Rest Call");
		
			
				recService.deleteRecipe(id);
				return new ResponseEntity<> (HttpStatus.OK);
			}
			
		
	
	
	@PutMapping("/rest/updaterecipe")
	public ResponseEntity<String> updateRecipe(@RequestBody RecipeEntityDTO recipe) {
		log.info("Invoked updateRecipe Controller | Put Rest Call");
		
		if(recipe.getId()==null) {
			throw new ResourceNoFoundException("Ricipe id should not be null ");
		}else {
			ModelMapper modelMapper= new ModelMapper();
			recService.updateRecipe(modelMapper.map(recipe, Recipe.class));
			return new ResponseEntity<> (HttpStatus.OK);
		}
		
				
			
			
	}
		
		
	}
