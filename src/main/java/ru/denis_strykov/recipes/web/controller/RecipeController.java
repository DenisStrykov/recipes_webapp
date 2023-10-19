package ru.denis_strykov.recipes.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.denis_strykov.recipes.web.dto.RecipeDto;
import ru.denis_strykov.recipes.web.models.Recipe;
import ru.denis_strykov.recipes.web.models.UserEntity;
import ru.denis_strykov.recipes.web.security.SecurityUtil;
import ru.denis_strykov.recipes.web.service.RecipeService;
import ru.denis_strykov.recipes.web.service.UserService;

import javax.validation.Valid;
import java.util.List;

@Controller
public class RecipeController {

    private RecipeService recipeService;
    private UserService userService;

    @Autowired
    public RecipeController(RecipeService recipeService, UserService userService) {
        this.recipeService = recipeService;
        this.userService = userService;
    }

    @GetMapping("/recipes")
    public String listRecipes(Model model) {
        UserEntity user = new UserEntity();
        List<RecipeDto> recipes = recipeService.findAllRecipe();
        String username = SecurityUtil.getSessionUser();
        if (username != null) {
            user = userService.findByUsername(username);
            model.addAttribute("user", user);
        }
        model.addAttribute("user", user);
        model.addAttribute("recipes", recipes);
        return "recipes-list";
    }

    @GetMapping("/recipes/{recipesId}")
    public String recipeDetail(@PathVariable("recipesId") Long recipeId, Model model) {
        UserEntity user = new UserEntity();
        RecipeDto recipeDto = recipeService.findRecipeById(recipeId);
        String username = SecurityUtil.getSessionUser();
        if (username != null) {
            user = userService.findByUsername(username);
            model.addAttribute("user", user);
        }
        model.addAttribute("user", user);
        model.addAttribute("recipe", recipeDto);
        return "recipes-detail";
    }

    @GetMapping("/recipes/new")
    public String createRecipe(Model model) {
        Recipe recipe = new Recipe();
        model.addAttribute("recipe", recipe);
        return "recipes-create";
    }

    @GetMapping("/recipes/{recipeId}/delete")
    public String deleteRecipe(@PathVariable("recipeId") Long recipeId) {
        recipeService.delete(recipeId);
        return "redirect:/recipes";
    }

    @GetMapping("/recipes/search")
    public String searchRecipe(@RequestParam(value = "query") String query, Model model) {
        List<RecipeDto> recipes = recipeService.searchRecipes(query);
        model.addAttribute("recipes", recipes);
        return "recipes-list";
    }

    @PostMapping("/recipes/new")
    public String saveRecipe(@Valid @ModelAttribute("recipe") RecipeDto recipeDto, BindingResult result, Model model) {
//        if (result.hasErrors()) {
//            model.addAttribute("recipe", recipeDto);
//            return "recipes-create";
//        }
        recipeService.saveRecipe(recipeDto);
        return "redirect:/recipes";
    }

    @GetMapping("/recipes/{recipeId}/edit")
    public String editRecipeForm(@PathVariable("recipeId") Long recipeId, Model model) {
        RecipeDto recipe = recipeService.findRecipeById(recipeId);
        model.addAttribute("recipe", recipe);
        return "recipes-edit";
    }

    @PostMapping("/recipes/{recipeId}/edit")
    public String updateRecipe(@PathVariable("recipeId") Long recipeId
            , @Valid @ModelAttribute("recipe") RecipeDto recipe
            , BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("recipe", recipe);
            return "recipes-edit";
        }
        recipe.setId(recipeId);
        recipeService.updateRecipe(recipe);
        return "redirect:/recipes";
    }

}