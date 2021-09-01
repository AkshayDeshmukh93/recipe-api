package com.tcs.abn.recipeapi.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tcs.abn.recipeapi.entity.Recipe;

@Repository
public interface RecRepository extends JpaRepository<Recipe, Long>{

}
