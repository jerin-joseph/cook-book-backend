package com.rsoclabs.cookbook;

import com.rsoclabs.cookbook.entity.Recipe;
import com.rsoclabs.cookbook.service.RecipeService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class RecipeTest {

    @Autowired
    RecipeService recipeService;
    @Test
    public void getRecipebyId(){
        Recipe recipe = new Recipe(null,1L,"bullseye","a simple recipe",
                "egg,oil",
                new Date());
        Recipe savedRecipe = recipeService.create(recipe);
        System.out.println(savedRecipe);
        Optional<Recipe> foundRecipe = recipeService.findRecipeById(savedRecipe.getId());
        System.out.println(foundRecipe);
        assertEquals(savedRecipe,foundRecipe.get());


    }
}
