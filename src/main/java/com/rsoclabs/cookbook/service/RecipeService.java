package com.rsoclabs.cookbook.service;

import com.rsoclabs.cookbook.entity.Recipe;

import java.util.Optional;

public interface RecipeService {
    Recipe create(Recipe recipe);

    Optional<Recipe> findRecipeById(Long id);
}
