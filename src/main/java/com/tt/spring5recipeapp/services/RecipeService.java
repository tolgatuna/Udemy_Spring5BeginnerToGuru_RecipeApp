package com.tt.spring5recipeapp.services;

import com.tt.spring5recipeapp.domain.Recipe;

import java.util.Set;

public interface RecipeService {
    Set<Recipe> getRecipes();

}
