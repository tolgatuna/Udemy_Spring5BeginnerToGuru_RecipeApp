package com.tt.spring5recipeapp.controllers;

import com.tt.spring5recipeapp.commands.RecipeCommand;
import com.tt.spring5recipeapp.domain.Recipe;
import com.tt.spring5recipeapp.services.RecipeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class RecipeController {
    RecipeService recipeService;

    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @RequestMapping("/recipe/{id}/show")
    public String showById(@PathVariable("id") String id, Model model) {
        model.addAttribute("recipe", recipeService.findById(new Long(id)));
        return "recipe/show";
    }

    @RequestMapping("recipe/new")
    public String newRecipe(Model model) {
        model.addAttribute("recipe", new Recipe());
        return "recipe/recipeForm";
    }

    @RequestMapping("recipe/{id}/update")
    public String updateRecipe(@PathVariable("id") String id, Model model) {
        RecipeCommand recipe = recipeService.findCommandById(new Long(id));
        model.addAttribute("recipe", recipe);
        return "recipe/recipeForm";
    }

    @PostMapping
    @RequestMapping("recipe")
    public String saveOrUpdate(@ModelAttribute RecipeCommand command) {
        RecipeCommand savedCommand = recipeService.saveRecipeCommand(command);
        return "redirect:/recipe/" + savedCommand.getId() + "/show";
    }
}
