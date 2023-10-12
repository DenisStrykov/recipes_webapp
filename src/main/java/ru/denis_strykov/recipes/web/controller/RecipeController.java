package ru.denis_strykov.recipes.web.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.denis_strykov.recipes.web.dto.RecipeDto;
import ru.denis_strykov.recipes.web.service.RecipeService;

import java.util.List;

@Controller
public class RecipeController {

    private RecipeService recipeService;

    @Autowired
    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @GetMapping("/recipe")
    public String listRecipes(Model model) {
        List<RecipeDto> recipes = recipeService.findAllRecipe();
        model.addAttribute("recipes", recipes);
        return "recipes-list";
    }

}
