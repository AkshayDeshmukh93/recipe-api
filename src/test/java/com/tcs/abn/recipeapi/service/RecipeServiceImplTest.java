package com.tcs.abn.recipeapi.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.tcs.abn.recipeapi.dao.RecipeDaoImpl;
import com.tcs.abn.recipeapi.dto.RecipeDTO;
import com.tcs.abn.recipeapi.entity.Recipe;

@ExtendWith(MockitoExtension.class)
class RecipeServiceImplTest {

	@InjectMocks
	RecipeServiceImpl recServTest;
	
	@Mock
	RecipeDaoImpl recDaoTest;
	
	@Test
	@Order(1)
	@DisplayName("Test GetAllRecipe service ")
	void testGetAllRecipe() {

		
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

    List<Recipe> recipeOutList= new ArrayList<Recipe>();
	Recipe recipeOutput = new Recipe();
	recipeOutput.setId(1L);
	recipeOutput.setRecName("Test");
	recipeOutput.setRecDate(tempDate);
	recipeOutput.setRecType(true);
	recipeOutput.setRecCount(2);
	recipeOutput.setRecIngredients("ingr1,ingr2,ingr3,ing4,ingr5");
	recipeOutput.setRecInstruction("test"); 
	recipeOutList.add(recipeOutput);
	
	when(recDaoTest.getAllRecipe()).thenReturn(recipeOutList);
	
	//assertEquals(testOutput, recServTest.getAllRecipe());
	assertEquals(1,recServTest.getAllRecipe().size());

	}

	
	@Test
	@Order(2)
	@DisplayName("Test GetRecipe service ")
	void testGetRecipe() {
		Long id=1L;
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy' 'HH:mm");
		LocalDateTime tempDate = LocalDateTime.parse("26-08-2021 10:14", formatter);
		
		List<String> IngrListTest=new ArrayList<>();
		IngrListTest.add("ingr1");
		IngrListTest.add("ingr1");
		IngrListTest.add("ingr3");
		IngrListTest.add("ing4");
		IngrListTest.add("ingr5");
		
		   Recipe recipeOutput = new Recipe();
					recipeOutput.setId(1L);
				    recipeOutput.setRecName("Test");
					recipeOutput.setRecDate(tempDate);
					recipeOutput.setRecType(true);
					recipeOutput.setRecCount(2);
					recipeOutput.setRecIngredients("ingr1,ingr2,ingr3,ing4,ingr5");
					recipeOutput.setRecInstruction("test"); 			
		
		RecipeDTO recTestResponse= new RecipeDTO(); 
		  recTestResponse.setId(1L);
		  recTestResponse.setRecName("Test");
		  recTestResponse.setRecDate(tempDate);
		  recTestResponse.setRecType(true);
		  recTestResponse.setRecCount(2);
		  recTestResponse.setRecIngredients(IngrListTest);
		  recTestResponse.setRecInstruction("test"); 
		  
	 
			when(recDaoTest.getRecipe(id)).thenReturn(recipeOutput);
		RecipeDTO actualOut= recServTest.getRecipe(id);
			
			assertEquals(recTestResponse.getId(),actualOut.getId());
			assertEquals(recTestResponse.getRecName(), actualOut.getRecName());
			assertEquals(recTestResponse.getRecDate(), actualOut.getRecDate());
			assertEquals(recTestResponse.getRecCount(), actualOut.getRecCount());
			assertEquals(recTestResponse.isRecType(), actualOut.isRecType());
			assertEquals(recTestResponse.getRecIngredients().size(), actualOut.getRecIngredients().size());
			assertEquals(recTestResponse.getRecInstruction(), actualOut.getRecInstruction());
	}

	@Test
	@Order(3)
	@DisplayName("Test addRecipe service ")
	void testAddRecipe() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy' 'HH:mm");
		LocalDateTime tempDate = LocalDateTime.parse("26-08-2021 10:14", formatter);
		Recipe rec = new Recipe();
		
		rec.setRecName("Test3");
		rec.setRecDate(tempDate);
		rec.setRecType(true);
		rec.setRecCount(2);
		rec.setRecIngredients("ingr1,ingr2,ingr3,ing4,ingr5");
		rec.setRecInstruction("test");
		
		recServTest.addRecipe(rec);
		verify(recDaoTest, times(1)).addRecipe(rec);
		
	}
	
	@Test
	@Order(4)
	@DisplayName("Test UpdateRecipe service ")
	void testUpdateRecipe() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy' 'HH:mm");
		LocalDateTime tempDate = LocalDateTime.parse("26-08-2021 10:14", formatter);
		Recipe recUpdate = new Recipe();
		recUpdate.setId(1L);
		recUpdate.setRecName("Testupdate");
		recUpdate.setRecDate(tempDate);
		recUpdate.setRecType(false);
		recUpdate.setRecCount(2);
		recUpdate.setRecIngredients("ingr1,ingr2,ingr3,ing4,ingr5");
		recUpdate.setRecInstruction("test");
		
		recServTest.updateRecipe(recUpdate);
		verify(recDaoTest, times(1)).updateRecipe(recUpdate);
		
	}
	
	@Test
	@Order(5)
	@DisplayName("Test deleteRecipe service ")
	void testDeleteRecipe() {
		recServTest.deleteRecipe(2L);
		verify(recDaoTest,times(1)).deleteRecipe(2L);
	
	}
	
	@Test
	@DisplayName("Test GetRecipe response null service ")
	void testGetRecipeNull() {
		Long id=5L;
		   
			when(recDaoTest.getRecipe(id)).thenReturn(null);
			assertEquals(null,recServTest.getRecipe(id));
	}


}
