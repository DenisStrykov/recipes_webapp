package ru.denis_strykov.recipes.web.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import ru.denis_strykov.recipes.web.dto.RecipeDto;
import ru.denis_strykov.recipes.web.models.Recipe;
import ru.denis_strykov.recipes.web.service.RecipeService;

import java.util.List;

@Controller
public class RecipeController {

    private RecipeService recipeService;

    @Autowired
    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @GetMapping("/recipes")
    public String listRecipes(Model model) {
        List<RecipeDto> recipes = recipeService.findAllRecipe();
        model.addAttribute("recipes", recipes);
        return "recipes-list";
    }

    @GetMapping("/recipes/new")
    public String createRecipe(Model model) {
        Recipe recipe = new Recipe();
        model.addAttribute("recipe", recipe);
        return "recipes-create";
    }

    @PostMapping("/recipes/new")
    public String saveRecipe(@ModelAttribute("recipe") Recipe recipe) {
        recipeService.saveRecipe(recipe);
        return "redirect:/recipes";
    }

    @GetMapping("/recipes/{recipeId}/edit")
    public String editRecipeForm(@PathVariable("recipeId") Long recipeId, Model model) {
        RecipeDto recipe = recipeService.findRecipeById(recipeId);
        model.addAttribute("recipe", recipe);
        return "recipes-edit";
    }

    @PostMapping("/recipes/{recipeId}/edit")
    public String updateRecipe(@PathVariable("recipeId") Long recipeId, @ModelAttribute("recipe") RecipeDto recipe) {
        recipe.setId(recipeId);
        recipeService.updateRecipe(recipe);
        return "redirect:/recipes";
    }

}
