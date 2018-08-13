package com.tt.spring5recipeapp.controllers;

import com.tt.spring5recipeapp.domain.Category;
import com.tt.spring5recipeapp.domain.UnitOfMeasure;
import com.tt.spring5recipeapp.repositories.CategoryRepository;
import com.tt.spring5recipeapp.repositories.UnitOfMeasureRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
public class IndexController {

    private CategoryRepository categoryRepository;
    private UnitOfMeasureRepository unitOfMeasureRepository;

    public IndexController(CategoryRepository categoryRepository, UnitOfMeasureRepository unitOfMeasureRepository) {
        this.categoryRepository = categoryRepository;
        this.unitOfMeasureRepository = unitOfMeasureRepository;
    }

    @RequestMapping({"", "/", "/index", "/index.html"})
    public String getIndexPage() {
        Optional<Category> category = categoryRepository.findByDescription("American");
        Optional<UnitOfMeasure> unitOfMeasure = unitOfMeasureRepository.findByDescription("Teaspoon");

        System.out.println(category.get().getId() + " : " + category.get().getDescription());
        System.out.println(unitOfMeasure.get().getId() + " : " + unitOfMeasure.get().getDescription());

        return "index";
    }
}
