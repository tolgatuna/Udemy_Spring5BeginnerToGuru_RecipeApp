package com.tt.spring5recipeapp.services;

import com.tt.spring5recipeapp.domain.Recipe;
import com.tt.spring5recipeapp.repositories.RecipeRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.*;

public class RecipeServiceImplTest {


    RecipeService recipeService;

    @Mock
    RecipeRepository recipeRepository;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        recipeService = new RecipeServiceImpl(recipeRepository, null, null);
    }

    @Test
    public void getRecipeByIdTest() throws Exception {
        Recipe recipe = new Recipe();
        recipe.setId(1L);
        Optional<Recipe> optionalRecipe = Optional.of(recipe);

        when(recipeRepository.findById(anyLong())).thenReturn(optionalRecipe);

        Recipe returnedRecipe = recipeRepository.findById(1L).get();
        assertNotNull("Null Recipe Returned", returnedRecipe);
        verify(recipeRepository, times(1)).findById(anyLong());
        verify(recipeRepository, never()).findAll();
    }

    @Test
    public void getRecipesTest() {
        Recipe recipe1 = new Recipe();
        recipe1.setId(1L);
        Recipe recipe2 = new Recipe();
        recipe2.setId(2L);
        HashSet recipesData = new HashSet();
        recipesData.add(recipe1);
        recipesData.add(recipe2);

        // We are telling mockito when getRecipes called then return our created recipesData
        when(recipeService.getRecipes()).thenReturn(recipesData);

        Set<Recipe> recipes = recipeService.getRecipes();
        assertEquals(recipes.size(), 2);

        // We verify that recipeRepository.findAll method called only 1 time!
        verify(recipeRepository, times(1)).findAll();
        verify(recipeRepository, never()).findById(anyLong());
    }

    @Test
    public void testDeleteById() throws Exception{
        Long idToDelete = Long.valueOf(2L);
        recipeService.deleteById(idToDelete);

        // no 'when', since method has void return type
        verify(recipeRepository, times(1)).deleteById(anyLong());
    }
}