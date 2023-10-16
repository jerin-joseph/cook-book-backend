package com.rsoclabs.cookbook.controller;

import com.rsoclabs.cookbook.entity.Recipe;
import com.rsoclabs.cookbook.service.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;
import java.util.Optional;

@RestController
public class RecipeController {

    @Autowired
    RecipeService recipeService;
    @PostMapping("/recipe")
    public String createRecipe(@RequestBody Recipe recipe){
        Recipe savedRecipe = recipeService.save(recipe);
        return savedRecipe.toString();
    }

    @GetMapping("/recipe")
    public ResponseEntity<Recipe> getRecipe(@RequestParam Long id){
        Optional<Recipe> foundRecipe = recipeService.findRecipeById(id);
        if(foundRecipe.isPresent()){
            return new ResponseEntity<>(foundRecipe.get(),HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/recipe")
    public ResponseEntity<Object> updateRecipe(@RequestBody Recipe recipe){
        Optional<Recipe> foundRecipe = recipeService.findRecipeById(recipe.getId());
        if(foundRecipe.isPresent()){
            Recipe updatedRecipe = recipeService.update(recipe);
            return new ResponseEntity<>(updatedRecipe,HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>("Recipe not found!",HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/recipe")
    public ResponseEntity<String> deleteRecipe(@RequestParam Long id){
        Optional<Recipe> foundRecipe = recipeService.findRecipeById(id);
        if(foundRecipe.isPresent()){
            recipeService.deleteRecipe(id);
            return new ResponseEntity<>("Deleted recipe with id: "+id,HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>("Could not find recipe with id: "+id,HttpStatus.NOT_FOUND);
        }
    }
}
