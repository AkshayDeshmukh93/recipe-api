package com.tcs.abn.recipeapi;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.SpringBootTest;

import com.tcs.abn.recipeapi.controller.RecipeController;

@SpringBootTest
class RecipeApiApplicationTests {
	@Autowired
	RecipeController recController;

	@Test
	void contextLoads() {
		 assertThat(recController).isNotNull(); 	
		 }
	

}
