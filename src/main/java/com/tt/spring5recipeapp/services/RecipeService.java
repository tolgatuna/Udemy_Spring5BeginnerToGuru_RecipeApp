package com.tt.spring5recipeapp.services;

import com.tt.spring5recipeapp.commands.RecipeCommand;
import com.tt.spring5recipeapp.domain.Recipe;

import java.util.Set;

public interface RecipeService {
    Set<Recipe> getRecipes();

    Recipe findById(Long id);

    RecipeCommand findCommandById(Long id);

    RecipeCommand saveRecipeCommand(RecipeCommand command);
}
