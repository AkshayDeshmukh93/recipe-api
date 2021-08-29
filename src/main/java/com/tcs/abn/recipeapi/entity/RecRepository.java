package com.tcs.abn.recipeapi.entity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecRepository extends JpaRepository<Recipe, Integer>{

}
