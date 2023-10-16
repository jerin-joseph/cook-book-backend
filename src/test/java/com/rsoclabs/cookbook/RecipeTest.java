package com.rsoclabs.cookbook;

import com.rsoclabs.cookbook.entity.Ingredient;
import com.rsoclabs.cookbook.entity.Recipe;
import com.rsoclabs.cookbook.service.RecipeService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class RecipeTest {

    @Autowired
    RecipeService recipeService;
    @Test
    public void getRecipebyId(){
        Recipe recipe = Recipe.builder()
                .name("Omlette")
                .date(new Date())
                .authorId(1L)
                .description("simple recipe")
                .ingredients(List.of(Ingredient.builder().ingName("Egg").ingQty("1").build(),
                            Ingredient.builder().ingName("onion").ingQty("2").build()))
                .build();
        Recipe savedRecipe = recipeService.save(recipe);
        System.out.println(savedRecipe);
        Optional<Recipe> foundRecipe = recipeService.findRecipeById(savedRecipe.getId());
        System.out.println(foundRecipe);
        assertEquals(savedRecipe,foundRecipe.get());


    }
}
