package com.tcs.abn.recipeapi;



import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.tcs.abn.recipeapi.controller.RecipeController;

@SpringBootTest
class RecipeApiApplicationTests {
	@Autowired
	RecipeController recController;

	@Test
	void contextLoads() {
		
	}

}
