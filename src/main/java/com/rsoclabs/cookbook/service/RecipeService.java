package com.rsoclabs.cookbook.service;

import com.rsoclabs.cookbook.entity.Recipe;

import java.util.List;
import java.util.Optional;

public interface RecipeService {
    Recipe save(Recipe recipe);

    Optional<Recipe> findRecipeById(Long id);

    Recipe update(Recipe recipe);

    void deleteRecipe(Long id);

    List<Recipe> findAllRecipe();
}
