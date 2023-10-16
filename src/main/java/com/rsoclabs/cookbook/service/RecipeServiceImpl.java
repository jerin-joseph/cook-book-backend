package com.rsoclabs.cookbook.service;

import com.rsoclabs.cookbook.entity.Recipe;
import com.rsoclabs.cookbook.repository.RecipeRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RecipeServiceImpl implements RecipeService{

    @Autowired
    RecipeRepository recipeRepository;
    @Override
    public Recipe save(Recipe recipe) {
        Recipe savedRecipe = recipeRepository.save(recipe);
        System.out.println(savedRecipe);
        return savedRecipe;
    }

    @Override
    @Transactional
    public Optional<Recipe> findRecipeById(Long id) {
        System.out.println(id);
        Optional<Recipe> foundRecipe = recipeRepository.findById(id);
        System.out.println(foundRecipe);
        return foundRecipe;
    }

    @Override
    public Recipe update(Recipe recipe) {
        Recipe updatedRecipe = recipeRepository.save(recipe);
        System.out.println(updatedRecipe);
        return updatedRecipe;
    }

    @Override
    public void deleteRecipe(Long id) {
        recipeRepository.deleteById(id);
    }
}
