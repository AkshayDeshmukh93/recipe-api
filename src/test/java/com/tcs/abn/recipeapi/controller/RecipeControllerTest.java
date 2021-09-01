package com.tcs.abn.recipeapi.controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.hamcrest.Matchers;
import org.json.JSONObject;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tcs.abn.recipeapi.dto.RecipeDTO;
import com.tcs.abn.recipeapi.entity.Recipe;
import com.tcs.abn.recipeapi.service.RecipeServiceImpl;
@ExtendWith(SpringExtension.class)
@WebMvcTest(RecipeController.class)
class RecipeControllerTest {
	
	
	@MockBean
	RecipeServiceImpl recServTest;
	
	@Autowired
	MockMvc mockMvc;
	
	@Autowired
    ObjectMapper mapper;
	

	@Test
	@DisplayName("Test GetAllRecipe GET service ")
	void testGetAllRecipe() throws Exception {

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy' 'HH:mm");
		LocalDateTime tempDate = LocalDateTime.parse("26-08-2021 10:14", formatter);

		List<String> IngrListTest=new ArrayList<>();
		IngrListTest.add("ingr1");
		IngrListTest.add("ingr1");
		IngrListTest.add("ingr3");
		IngrListTest.add("ing4");
		IngrListTest.add("ingr5");

		List<RecipeDTO> testOutput= new ArrayList<>();
		  RecipeDTO recTestResponse= new RecipeDTO(); 
		  
		  recTestResponse.setId(1L);
		  recTestResponse.setRecName("Test");
		  recTestResponse.setRecDate(tempDate);
		  recTestResponse.setRecType(true);
		  recTestResponse.setRecCount(2);
		  recTestResponse.setRecIngredients(IngrListTest);
		  recTestResponse.setRecInstruction("test"); 
		  testOutput.add(recTestResponse);
		  
		 // when(recServiceTest.getAllRecipe()).thenReturn(testOutput);
		  when(recServTest.getAllRecipe()).thenReturn(testOutput);
		  mockMvc.perform(get("/rest/recipe"))
		  .andExpect(status().isOk())
		  .andExpect(jsonPath("$", Matchers.hasSize(1)))
		  .andExpect(jsonPath("$[0].id", Matchers.is(recTestResponse.getId().intValue())));
		
	}

	 @Test 
	 @DisplayName("Test GetRecipe GET service ")
	 void testGetRecipe() throws Exception { 
		 Long id=1L;
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy' 'HH:mm");
			LocalDateTime tempDate = LocalDateTime.parse("26-08-2021 10:14", formatter);
			
			List<String> IngrListTest=new ArrayList<>();
			IngrListTest.add("ingr1");
			IngrListTest.add("ingr1");
			IngrListTest.add("ingr3");
			IngrListTest.add("ing4");
			IngrListTest.add("ingr5");
			
			RecipeDTO recTestResponse= new RecipeDTO(); 
			  recTestResponse.setId(1L);
			  recTestResponse.setRecName("Test");
			  recTestResponse.setRecDate(tempDate);
			  recTestResponse.setRecType(true);
			  recTestResponse.setRecCount(2);
			  recTestResponse.setRecIngredients(IngrListTest);
			  recTestResponse.setRecInstruction("test");
			  
			  when(recServTest.getRecipe(id)).thenReturn(recTestResponse);
			
			  mockMvc.perform(get("/rest/recipe/1"))
			  .andExpect(status().isOk())
			  .andExpect(jsonPath("id", Matchers.is(recTestResponse.getId().intValue())));
			  
	 }
	 
	 @Test
	 @DisplayName("Test AddRecipe POST service ")
	 void testAddRecipe() throws Exception {
		 DateTimeFormatter formatter =
				 DateTimeFormatter.ofPattern("dd-MM-yyyy' 'HH:mm"); LocalDateTime tempDate =
				 LocalDateTime.parse("26-08-2021 10:14", formatter);
				  
				 Recipe addRecipe = new Recipe();
				 
				 addRecipe.setRecName("Test"); 
				 addRecipe.setRecDate(tempDate);
				 addRecipe.setRecType(true); 
				 addRecipe.setRecCount(2);
				 addRecipe.setRecIngredients("ingr1,ingr2,ingr3,ing4,ingr5");
				 addRecipe.setRecInstruction("test");
		 
				 
				 RequestBuilder req= MockMvcRequestBuilders
						 .post("/rest/addrecipe").contentType(MediaType.APPLICATION_JSON)
				            .accept(MediaType.APPLICATION_JSON)
				            .content(this.mapper.writeValueAsString(addRecipe));
				 
				 mockMvc.perform(req).andExpect(status().isCreated());
	 }
		/*
		 * @Test void testAddRecipe() throws Exception {
		 * 
		 * DateTimeFormatter formatter =
		 * DateTimeFormatter.ofPattern("dd-MM-yyyy' 'HH:mm"); LocalDateTime tempDate =
		 * LocalDateTime.parse("26-08-2021 10:14", formatter);
		 * 
		 * Recipe recipeOutput = new Recipe();
		 * 
		 * recipeOutput.setRecName("Test"); recipeOutput.setRecDate(tempDate);
		 * recipeOutput.setRecType(true); recipeOutput.setRecCount(2);
		 * recipeOutput.setRecIngredients("ingr1,ingr2,ingr3,ing4,ingr5");
		 * recipeOutput.setRecInstruction("test");
		 * 
		 * //RequestBuilder req=
		 * MockMvcRequestBuilders.post("/rest/addrecipe").accept(MediaType.
		 * APPLICATION_JSON).content(recipeOutput)
		 * 
		 * //s JSONObject postInput= new JSONObject(recipeOutput.toString());
		 * 
		 * mockMvc.perform(post("/rest/addrecipe")
		 * .contentType(MediaType.APPLICATION_JSON) .content(recipeOutput.toString()))
		 * .andExpect(status().isOk()); }
		 */
	 @Test
	 @DisplayName("Test DeleteRecipe DELETE service ")
	 void testDeleteRecipe() throws Exception { 
		mockMvc.perform(delete("/rest/deleteRecipe/2")).andExpect(status().isOk());
		 
		 
	 }
	  @Test 
	  @DisplayName("Test UpdteRecipe PUT service")
	  void testUpdateRecipe() throws Exception { 
		  DateTimeFormatter formatter =
					 DateTimeFormatter.ofPattern("dd-MM-yyyy' 'HH:mm"); LocalDateTime tempDate =
					 LocalDateTime.parse("26-08-2021 10:14", formatter);
					  
					 Recipe addRecipe = new Recipe();
					 addRecipe.setId(1L);
					 addRecipe.setRecName("TestUpdate"); 
					 addRecipe.setRecDate(tempDate);
					 addRecipe.setRecType(true); 
					 addRecipe.setRecCount(2);
					 addRecipe.setRecIngredients("ingr1,ingr2,ingr3,ing4,ingr5");
					 addRecipe.setRecInstruction("test");
			 
					 
					 RequestBuilder req= MockMvcRequestBuilders
							 .put("/rest/updaterecipe").contentType(MediaType.APPLICATION_JSON)
					            .accept(MediaType.APPLICATION_JSON)
					            .content(this.mapper.writeValueAsString(addRecipe));
					 
					 mockMvc.perform(req).andExpect(status().isOk());
	  }
	  
	  @Test 
	  @DisplayName("Test GetALLRecipe with Exception -GET service ")
	  void getAllRecipeNotFoundTest() throws Exception{
			
			  List<RecipeDTO> testOutput= new ArrayList<>();
			  when(recServTest.getAllRecipe()).thenReturn(testOutput);
			  mockMvc.perform(get("/rest/recipe")) .andExpect(status().isNotFound());
			 
	  }	 	 
	  
	  @Test 
	  @DisplayName("Test GetRecipe with Exception GET service ")
	  void testGetRecipeNotFound() throws Exception {
			  mockMvc.perform(get("/rest/recipe/6")) 
			  .andExpect(status().isBadRequest());
	  }
			  
	  
	  @Test 
	  @DisplayName("Test UpdateRecipe with Exception PUT service ")
	  void testUpdateRecipeNotFound() throws Exception { 
		  DateTimeFormatter formatter =
					 DateTimeFormatter.ofPattern("dd-MM-yyyy' 'HH:mm"); 
		  LocalDateTime tempDate = LocalDateTime.parse("26-08-2021 10:14", formatter);
					  
					 Recipe addRecipe = new Recipe();
					 addRecipe.setId(null);
					 addRecipe.setRecName("TestUpdate"); 
					 addRecipe.setRecDate(tempDate);
					 addRecipe.setRecType(true); 
					 addRecipe.setRecCount(2);
					 addRecipe.setRecIngredients("ingr1,ingr2,ingr3,ing4,ingr5");
					 addRecipe.setRecInstruction("test");
			 
					 
					 RequestBuilder req= MockMvcRequestBuilders
							 .put("/rest/updaterecipe").contentType(MediaType.APPLICATION_JSON)
					            .accept(MediaType.APPLICATION_JSON)
					            .content(this.mapper.writeValueAsString(addRecipe));
					 
					 mockMvc.perform(req).andExpect(status().isNotFound());
	  }
	  
	 
			  
}
