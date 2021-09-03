package com.tcs.abn.recipeapi.dao;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;


import com.tcs.abn.recipeapi.entity.Recipe;

@Component
public class DataLoader implements ApplicationRunner {

	private RecRepository recRepository;

	@Autowired
	public DataLoader(RecRepository recRepository) {
		this.recRepository = recRepository;
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy' 'HH:mm");
		LocalDateTime tempDate = LocalDateTime.parse("26-08-2021 10:14", formatter);

		Recipe rec = new Recipe();
		
		rec.setRecName("Test");
		rec.setRecDate(tempDate);
		rec.setRecType(true);
		rec.setRecCount(2);
		rec.setRecIngredients("ingr1,ingr2,ingr3,ing4,ingr5");
		rec.setRecInstruction("test");
		recRepository.save(rec);
		
		
Recipe rec2 = new Recipe();
		
		rec2.setRecName("Test2");
		rec2.setRecDate(tempDate);
		rec2.setRecType(true);
		rec2.setRecCount(2);
		rec2.setRecIngredients("ingr1,ingr2,ingr3,ing4,ingr5");
		rec2.setRecInstruction("test");
		recRepository.save(rec2);
		

	}
}