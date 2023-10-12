package ru.denis_strykov.recipes.web.service;

import org.springframework.stereotype.Service;
import ru.denis_strykov.recipes.web.dto.RecipeDto;
import ru.denis_strykov.recipes.web.models.Recipe;

import java.util.List;

public interface RecipeService {

    List<RecipeDto> findAllRecipe();
    Recipe saveRecipe(RecipeDto recipeDto);
    RecipeDto findRecipeById(Long recipeId);
    void updateRecipe(RecipeDto recipe);
    void delete(Long recipeId);
}
