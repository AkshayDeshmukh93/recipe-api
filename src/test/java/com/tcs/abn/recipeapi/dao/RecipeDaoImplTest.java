package com.tcs.abn.recipeapi.dao;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.tcs.abn.recipeapi.dto.RecipeDTO;
import com.tcs.abn.recipeapi.entity.Recipe;
import com.tcs.abn.recipeapi.service.RecipeServiceImpl;

@ExtendWith(MockitoExtension.class)
@DataJpaTest
//@AutoConfigureTestDatabase(replace = Replace.AUTO_CONFIGURED.NONE)
class RecipeDaoImplTest {

	@InjectMocks
	RecipeDaoImpl recDaoTest;

	@Mock
	RecRepository recRepository;

	@Test
	@Order(6)
	@DisplayName("Test GetAllRecipe DAO ")
	void testGetAllRecipe() {

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy' 'HH:mm");
		LocalDateTime tempDate = LocalDateTime.parse("26-08-2021 10:14", formatter);

		List<String> IngrListTest = new ArrayList<>();
		IngrListTest.add("ingr1");
		IngrListTest.add("ingr1");
		IngrListTest.add("ingr3");
		IngrListTest.add("ing4");
		IngrListTest.add("ingr5");

		List<RecipeDTO> testOutput = new ArrayList<>();
		RecipeDTO recTestResponse = new RecipeDTO();

		recTestResponse.setId(1L);
		recTestResponse.setRecName("Test");
		recTestResponse.setRecDate(tempDate);
		recTestResponse.setRecType(true);
		recTestResponse.setRecCount(2);
		recTestResponse.setRecIngredients(IngrListTest);
		recTestResponse.setRecInstruction("test");
		testOutput.add(recTestResponse);

		List<Recipe> recipeOutList = new ArrayList<Recipe>();
		Recipe recipeOutput = new Recipe();
		recipeOutput.setId(1L);
		recipeOutput.setRecName("Test");
		recipeOutput.setRecDate(tempDate);
		recipeOutput.setRecType(true);
		recipeOutput.setRecCount(2);
		recipeOutput.setRecIngredients("ingr1,ingr2,ingr3,ing4,ingr5");
		recipeOutput.setRecInstruction("test");
		recipeOutList.add(recipeOutput);

		when(recRepository.findAll()).thenReturn(recipeOutList);

		// assertEquals(testOutput, recServTest.getAllRecipe());
		assertEquals(1, recDaoTest.getAllRecipe().size());

	}

	
	  @Test 
	  @Order(7)
	  @DisplayName("Test GetRecipe DAO ")
	  void testGetRecipe() { 
		  
	  Long id=1L; 
	  DateTimeFormatter formatter =	DateTimeFormatter.ofPattern("dd-MM-yyyy' 'HH:mm"); 
	  LocalDateTime tempDate = LocalDateTime.parse("26-08-2021 10:14", formatter);
	  
			/*
			 * List<String> IngrListTest=new ArrayList<>(); IngrListTest.add("ingr1");
			 * IngrListTest.add("ingr1"); IngrListTest.add("ingr3");
			 * IngrListTest.add("ing4"); IngrListTest.add("ingr5");
			 */
	 
	   Recipe recipeOutput= new Recipe();
	  recipeOutput.setId(1L); 
	  recipeOutput.setRecName("Test");
	  recipeOutput.setRecDate(tempDate); 
	  recipeOutput.setRecType(true);
	  recipeOutput.setRecCount(2);
	  recipeOutput.setRecIngredients("ingr1,ingr2,ingr3,ing4,ingr5");
	  recipeOutput.setRecInstruction("test");
	  
		/*
		 * RecipeDTO recTestResponse= new RecipeDTO(); recTestResponse.setId(1);
		 * recTestResponse.setRecName("Test"); recTestResponse.setRecDate(tempDate);
		 * recTestResponse.setRecType(true); recTestResponse.setRecCount(2);
		 * recTestResponse.setRecIngredients(IngrListTest);
		 * recTestResponse.setRecInstruction("test");
		 */
	  
	  ModelMapper modelMapper= new ModelMapper();
	  
	  when(recRepository.findById(id)).thenReturn(Optional.of(modelMapper.map(recipeOutput, Recipe.class))); 
	  Recipe actualOut= recDaoTest.getRecipe(id);
	  
	  
	  assertEquals(recipeOutput.getId(),actualOut.getId());
	  assertEquals(recipeOutput.getRecName(), actualOut.getRecName());
	  assertEquals(recipeOutput.getRecDate(), actualOut.getRecDate());
	  assertEquals(recipeOutput.getRecCount(), actualOut.getRecCount());
	  assertEquals(recipeOutput.isRecType(), actualOut.isRecType());
	  assertEquals(recipeOutput.getRecIngredients(),actualOut.getRecIngredients());
	  assertEquals(recipeOutput.getRecInstruction(),
	  actualOut.getRecInstruction());
	  
	  
	  }
	 

	
	  @Test
	  @Order(8) 
	  @DisplayName("Test addRecipe DAO ")
	  void testAddRecipe() { DateTimeFormatter formatter =
	  DateTimeFormatter.ofPattern("dd-MM-yyyy' 'HH:mm"); 
	  LocalDateTime tempDate =  LocalDateTime.parse("26-08-2021 10:14", formatter); 
	  
	  Recipe rec = new  Recipe();
	  
	  rec.setRecName("Test3"); 
	  rec.setRecDate(tempDate); 
	  rec.setRecType(true);
	  rec.setRecCount(2); 
	  rec.setRecIngredients("ingr1,ingr2,ingr3,ing4,ingr5");
	  rec.setRecInstruction("test");
	  
	  recDaoTest.addRecipe(rec); 
	  verify(recRepository, times(1)).save(rec);; }
	  
	  @Test
	  
	  @Order(9) 
	  @DisplayName("Test updateRecipe DAO ")
	  void testUpdateRecipe() { 
		  DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy' 'HH:mm"); LocalDateTime tempDate =
	  LocalDateTime.parse("26-08-2021 10:14", formatter); 
		  Recipe recUpdate = new  Recipe();
		  recUpdate.setId(1L); 
		  recUpdate.setRecName("Testupdate");
	  recUpdate.setRecDate(tempDate); 
	  recUpdate.setRecType(false);
	  recUpdate.setRecCount(2);
	  recUpdate.setRecIngredients("ingr1,ingr2,ingr3,ing4,ingr5");
	  recUpdate.setRecInstruction("test");
	  
	  recDaoTest.updateRecipe(recUpdate); 
	  verify(recRepository,	  times(1)).save(recUpdate); }
	  
	  @Test
	  @Order(10)
	  @DisplayName("Test deleteRecipe DAO ")
	  void testDeleteRecipe() {
	  
	  recDaoTest.deleteRecipe(1L); 
	  verify(recRepository,times(1)).deleteById(1L);
	  }
	 
	 


	 

}
