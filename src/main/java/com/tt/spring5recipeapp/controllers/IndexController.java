package com.tt.spring5recipeapp.controllers;

import com.tt.spring5recipeapp.services.RecipeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
public class IndexController {

    public final RecipeService recipeService;

    public IndexController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @RequestMapping({"", "/", "/index", "/index.html"})
    public String getRecipePage(Model model) {
        log.debug("Index Page Called");
        model.addAttribute("recipes", recipeService.getRecipes());
        return "index";
    }
}
